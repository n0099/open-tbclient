package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.support.v7.widget.ActivityChooserView;
import android.view.WindowManager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
final class b {
    private static final Pattern kGv = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);
    private Point kGw;
    private Point kGx;
    private Point kGy;
    private final Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    public void b(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        if (c(camera)) {
            parameters.setFocusMode("auto");
        }
        this.kGw = a.fg(this.mContext);
        Point point = new Point();
        point.x = this.kGw.x;
        point.y = this.kGw.y;
        int ff = a.ff(this.mContext);
        if (ff == 0) {
            point.x = this.kGw.y;
            point.y = this.kGw.x;
        }
        this.kGy = a(parameters, point);
        if (ff == 0) {
            this.kGx = new Point(this.kGy.y, this.kGy.x);
        } else {
            this.kGx = this.kGy;
        }
    }

    public static boolean c(Camera camera) {
        return a(camera.getParameters().getSupportedFocusModes(), "auto") != null;
    }

    public Point cTv() {
        return this.kGx;
    }

    public void d(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(this.kGy.x, this.kGy.y);
        d(parameters);
        camera.setDisplayOrientation(cTw());
        camera.setParameters(parameters);
    }

    private static String a(Collection<String> collection, String... strArr) {
        if (collection != null) {
            for (String str : strArr) {
                if (collection.contains(str)) {
                    return str;
                }
            }
        }
        return null;
    }

    public int cTw() {
        int i;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(0, cameraInfo);
        switch (((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation()) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 90;
                break;
            case 2:
                i = 180;
                break;
            case 3:
                i = 270;
                break;
            default:
                i = 0;
                break;
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((i + cameraInfo.orientation) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i) + 360) % 360;
    }

    private static Point a(Camera.Parameters parameters, Point point) {
        Point a = a(parameters.getSupportedPreviewSizes(), point);
        if (a == null) {
            return new Point((point.x >> 3) << 3, (point.y >> 3) << 3);
        }
        return a;
    }

    private static Point a(List<Camera.Size> list, Point point) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        Iterator<Camera.Size> it = list.iterator();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = i5;
            if (!it.hasNext()) {
                i = i6;
                i2 = i7;
                break;
            }
            Camera.Size next = it.next();
            i2 = next.width;
            i = next.height;
            i5 = Math.abs(i2 - point.x) + Math.abs(i - point.y);
            if (i5 == 0) {
                break;
            }
            if (i5 < i8) {
                i3 = i;
                i4 = i2;
            } else {
                i5 = i8;
                i3 = i6;
                i4 = i7;
            }
            i7 = i4;
            i6 = i3;
        }
        if (i2 > 0 && i > 0) {
            return new Point(i2, i);
        }
        return null;
    }

    private static int b(CharSequence charSequence, int i) {
        String[] split = kGv.split(charSequence);
        int length = split.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            try {
                double parseDouble = Double.parseDouble(split[i2].trim());
                int i4 = (int) (10.0d * parseDouble);
                if (Math.abs(i - parseDouble) >= Math.abs(i - i3)) {
                    i4 = i3;
                }
                i2++;
                i3 = i4;
            } catch (NumberFormatException e) {
                return i;
            }
        }
        return i3;
    }

    private void d(Camera.Parameters parameters) {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            int i = 27;
            String str2 = parameters.get("max-zoom");
            if (str2 != null) {
                try {
                    int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 <= parseDouble) {
                        parseDouble = 27;
                    }
                    i = parseDouble;
                } catch (NumberFormatException e) {
                }
            }
            String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    if (i > parseInt) {
                        i = parseInt;
                    }
                } catch (NumberFormatException e2) {
                }
            }
            String str4 = parameters.get("mot-zoom-values");
            if (str4 != null) {
                i = b(str4, i);
            }
            String str5 = parameters.get("mot-zoom-step");
            if (str5 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str5.trim()) * 10.0d);
                    if (parseDouble2 > 1) {
                        i -= i % parseDouble2;
                    }
                } catch (NumberFormatException e3) {
                }
            }
            if (str2 != null || str4 != null) {
                parameters.set("zoom", String.valueOf(i / 10.0d));
            }
            if (str3 != null) {
                parameters.set("taking-picture-zoom", i);
            }
        }
    }
}

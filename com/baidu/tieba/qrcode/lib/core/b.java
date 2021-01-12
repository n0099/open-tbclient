package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.view.WindowManager;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
final class b {
    private static final Pattern mFg = Pattern.compile(",");
    private final Context mContext;
    private Point mFh;
    private Point mFi;
    private Point mFj;

    public b(Context context) {
        this.mContext = context;
    }

    public void b(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        if (c(camera)) {
            parameters.setFocusMode("auto");
        }
        this.mFh = a.gK(this.mContext);
        Point point = new Point();
        point.x = this.mFh.x;
        point.y = this.mFh.y;
        int gJ = a.gJ(this.mContext);
        if (gJ == 0) {
            point.x = this.mFh.y;
            point.y = this.mFh.x;
        }
        this.mFj = a(parameters, point);
        if (gJ == 0) {
            this.mFi = new Point(this.mFj.y, this.mFj.x);
        } else {
            this.mFi = this.mFj;
        }
    }

    public static boolean c(Camera camera) {
        return a(camera.getParameters().getSupportedFocusModes(), "auto") != null;
    }

    public Point dAh() {
        return this.mFi;
    }

    public void d(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(this.mFj.x, this.mFj.y);
        c(parameters);
        camera.setDisplayOrientation(dAi());
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

    public int dAi() {
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
                i = SubsamplingScaleImageView.ORIENTATION_270;
                break;
            default:
                i = 0;
                break;
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((i + cameraInfo.orientation) % EncoderTextureDrawer.X264_WIDTH)) % EncoderTextureDrawer.X264_WIDTH;
        }
        return ((cameraInfo.orientation - i) + EncoderTextureDrawer.X264_WIDTH) % EncoderTextureDrawer.X264_WIDTH;
    }

    private static Point a(Camera.Parameters parameters, Point point) {
        Point a2 = a(parameters.getSupportedPreviewSizes(), point);
        if (a2 == null) {
            return new Point((point.x >> 3) << 3, (point.y >> 3) << 3);
        }
        return a2;
    }

    private static Point a(List<Camera.Size> list, Point point) {
        int i;
        int i2 = 0;
        Iterator<Camera.Size> it = list.iterator();
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        while (true) {
            int i5 = i2;
            if (!it.hasNext()) {
                i = i4;
                i2 = i5;
                break;
            }
            Camera.Size next = it.next();
            i2 = next.width;
            i = next.height;
            int abs = Math.abs(i2 - point.x) + Math.abs(i - point.y);
            if (abs == 0) {
                break;
            }
            if (abs < i3) {
                i4 = i;
            } else {
                abs = i3;
                i2 = i5;
            }
            i3 = abs;
        }
        if (i2 > 0 && i > 0) {
            return new Point(i2, i);
        }
        return null;
    }

    private static int c(CharSequence charSequence, int i) {
        String[] split = mFg.split(charSequence);
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

    private void c(Camera.Parameters parameters) {
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
                i = c(str4, i);
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

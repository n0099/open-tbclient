package com.baidu.wallet.base.iddetect.utils;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.wallet.core.utils.LogUtil;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static com.baidu.wallet.base.iddetect.a f23235a;

    public static com.baidu.wallet.base.iddetect.a a(Context context, int i2, boolean z) {
        if (f23235a == null || z) {
            f23235a = a(i2, context);
        }
        return f23235a;
    }

    public static Rect a(Context context) {
        if (Build.VERSION.SDK_INT < 14) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        Rect rect = new Rect();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRectSize(rect);
        return rect;
    }

    public static float a(int i2, int i3) {
        return a((i2 * 1.0f) / i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.wallet.base.iddetect.a a(int i2, Context context) {
        com.baidu.wallet.base.iddetect.a a2;
        Camera a3 = a(i2);
        if (a3 != null) {
            try {
                if (a3.getParameters() != null) {
                    List<com.baidu.wallet.base.iddetect.a> a4 = a(a3.getParameters().getSupportedPreviewSizes());
                    Rect a5 = a(context);
                    a2 = a(context, a5, a(a5.width(), a5.height()), a4);
                    if (a3 != null) {
                        LogUtil.errord(com.baidu.wallet.base.iddetect.a.class.getSimpleName(), "release camera");
                        a3.release();
                    }
                    return a2;
                }
            } catch (Exception e2) {
                String simpleName = com.baidu.wallet.base.iddetect.a.class.getSimpleName();
                LogUtil.errord(simpleName, "exception = " + e2.getMessage());
                throw e2;
            }
        }
        a2 = null;
        if (a3 != null) {
        }
        return a2;
    }

    public static Camera a(int i2) {
        Camera open;
        try {
            if (Build.VERSION.SDK_INT >= 9) {
                try {
                    if (i2 == 1) {
                        open = Camera.open(0);
                    } else {
                        open = Camera.open(1);
                    }
                } catch (Exception unused) {
                    open = Camera.open();
                }
                return open;
            }
            return Camera.open();
        } catch (Exception unused2) {
            return null;
        }
    }

    public static com.baidu.wallet.base.iddetect.a a(Context context, Rect rect, float f2, List<com.baidu.wallet.base.iddetect.a> list) {
        boolean z;
        int i2;
        boolean z2 = false;
        com.baidu.wallet.base.iddetect.a aVar = null;
        int i3 = 0;
        while (true) {
            if (i3 >= list.size()) {
                z = false;
                break;
            }
            aVar = list.get(i3);
            float a2 = a(aVar.f23229b, aVar.f23228a);
            list.get(i3).f23231d = Math.abs(a2 - f2);
            list.get(i3).f23232e = true;
            if (a2 == f2 && (i2 = aVar.f23229b) >= 480 && i2 <= 720) {
                aVar.f23230c = 0.6306f;
                z = true;
                break;
            }
            i3++;
        }
        if (!z) {
            Collections.sort(list);
            int i4 = 0;
            while (true) {
                if (i4 < list.size()) {
                    if (list.get(i4).f23229b >= 480 && list.get(i4).f23229b <= 720 && list.get(i4).f23231d <= 0.1f) {
                        aVar = list.get(i4);
                        aVar.f23230c = a(context, rect, aVar);
                        z2 = true;
                        break;
                    }
                    i4++;
                } else {
                    break;
                }
            }
        }
        if (!z && !z2) {
            if (aVar == null) {
                aVar = new com.baidu.wallet.base.iddetect.a(640, 480);
            } else {
                aVar.f23229b = 480;
                aVar.f23228a = 640;
            }
            aVar.f23230c = a(context, rect, aVar);
        }
        return aVar;
    }

    public static float a(Context context, Rect rect, com.baidu.wallet.base.iddetect.a aVar) {
        float width = (rect.width() * 1.0f) / aVar.f23229b;
        float height = (rect.height() * 1.0f) / aVar.f23228a;
        return width > height ? (width * 0.6306f) / height : (height * 0.6306f) / width;
    }

    public static List<com.baidu.wallet.base.iddetect.a> a(List<Camera.Size> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Camera.Size size = list.get(i2);
            arrayList.add(new com.baidu.wallet.base.iddetect.a(size.width, size.height));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static float a(float f2) {
        return Float.parseFloat(new DecimalFormat("##0.00").format(f2));
    }
}

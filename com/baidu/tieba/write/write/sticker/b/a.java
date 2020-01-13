package com.baidu.tieba.write.write.sticker.b;

import android.graphics.PointF;
import android.view.MotionEvent;
/* loaded from: classes11.dex */
public class a {
    public static PointF M(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return null;
        }
        PointF pointF = new PointF();
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
        return pointF;
    }

    public static float N(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public static float O(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        return (float) Math.toDegrees(Math.atan2(motionEvent.getY(0) - motionEvent.getY(1), motionEvent.getX(0) - motionEvent.getX(1)));
    }

    public static boolean c(float[] fArr, float f, float f2) {
        if (fArr == null || fArr.length != 8) {
            return false;
        }
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[2];
        float f6 = fArr[3];
        float f7 = fArr[4];
        float f8 = fArr[5];
        float f9 = fArr[6];
        float f10 = fArr[7];
        float j = j(f3, f4, f5, f6);
        float a = a(f3, f4, f5, f6, f, f2);
        float j2 = j(f5, f6, f9, f10);
        float a2 = a(f5, f6, f9, f10, f, f2);
        float a3 = a(f9, f10, f7, f8, f, f2);
        float a4 = a(f7, f8, f3, f4, f, f2);
        if (j > 0.0f && j2 > 0.0f && a <= j2 && a3 <= j2 && a2 <= j && a4 <= j) {
            return true;
        }
        return false;
    }

    private static float a(float f, float f2, float f3, float f4, float f5, float f6) {
        float j = j(f, f2, f3, f4);
        float j2 = j(f, f2, f5, f6);
        float j3 = j(f3, f4, f5, f6);
        if (j != 0.0f) {
            if (j2 == 0.0f || j3 == 0.0f) {
                return 0.0f;
            }
            float f7 = ((j + j2) + j3) / 2.0f;
            return (((float) Math.sqrt(((f7 - j2) * ((f7 - j) * f7)) * (f7 - j3))) * 2.0f) / j;
        }
        return j2;
    }

    private static float j(float f, float f2, float f3, float f4) {
        return (float) Math.sqrt(Math.pow(f - f3, 2.0d) + Math.pow(f2 - f4, 2.0d));
    }
}

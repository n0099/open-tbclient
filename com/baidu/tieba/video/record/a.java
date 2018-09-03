package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static boolean mX(boolean z) {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo[] cameraInfoArr = new Camera.CameraInfo[numberOfCameras];
        for (int i = 0; i < numberOfCameras; i++) {
            cameraInfoArr[i] = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfoArr[i]);
        }
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < numberOfCameras; i4++) {
            if (i3 == -1 && cameraInfoArr[i4].facing == 0) {
                i3 = i4;
            } else if (i2 == -1 && cameraInfoArr[i4].facing == 1) {
                i2 = i4;
            }
        }
        if (i2 == -1 || !z) {
            return (i3 == -1 || z) ? false : true;
        }
        return true;
    }

    public static int mY(boolean z) {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo[] cameraInfoArr = new Camera.CameraInfo[numberOfCameras];
        for (int i = 0; i < numberOfCameras; i++) {
            cameraInfoArr[i] = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfoArr[i]);
        }
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < numberOfCameras; i4++) {
            if (i3 == -1 && cameraInfoArr[i4].facing == 0) {
                i3 = i4;
            } else if (i2 == -1 && cameraInfoArr[i4].facing == 1) {
                i2 = i4;
            }
        }
        if (i2 == -1 || !z) {
            if (i3 == -1 || z) {
                if (!z || i2 != -1) {
                    if (i2 != -1) {
                        return i2;
                    }
                    if (i3 == -1) {
                        return -1;
                    }
                    return i3;
                }
                return i3;
            }
            return i3;
        }
        return i2;
    }

    public static int g(Activity activity, int i) {
        if (Build.VERSION.SDK_INT <= 8) {
            return 0;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        int I = I(activity);
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + I) % 360)) % 360;
        }
        return ((cameraInfo.orientation - I) + 360) % 360;
    }

    public static int I(Activity activity) {
        switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
            case 0:
            default:
                return 0;
            case 1:
                return 90;
            case 2:
                return SubsamplingScaleImageView.ORIENTATION_180;
            case 3:
                return SubsamplingScaleImageView.ORIENTATION_270;
        }
    }

    public static Camera.Size a(Camera camera, int i, int i2) {
        int i3;
        Camera.Size size;
        boolean z;
        List<Camera.Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
        Collections.sort(supportedPreviewSizes, new C0246a());
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() <= 0) {
            return null;
        }
        Iterator<Camera.Size> it = supportedPreviewSizes.iterator();
        int i4 = -1;
        while (true) {
            if (!it.hasNext()) {
                i3 = i4;
                size = null;
                z = false;
                break;
            }
            Camera.Size next = it.next();
            i4++;
            if (next != null && next.width >= i2 && next.height >= i) {
                z = true;
                size = next;
                i3 = i4;
                break;
            }
        }
        if (!z) {
            int size2 = supportedPreviewSizes.size() - 1;
            size = supportedPreviewSizes.get(size2);
            i3 = size2;
        }
        int i5 = 1080 * ((int) (1080 * ((i2 * 1.0f) / i)));
        while (size.width * size.height > i5 && i3 > 0) {
            int i6 = i3 - 1;
            size = supportedPreviewSizes.get(i6);
            i3 = i6;
        }
        return size;
    }

    /* renamed from: com.baidu.tieba.video.record.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0246a implements Comparator<Camera.Size> {
        private C0246a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return size.width != size2.width ? size.width - size2.width : size.height - size2.height;
        }
    }

    public static int clamp(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        return i < i2 ? i2 : i;
    }

    public static boolean b(PackageManager packageManager) {
        FeatureInfo[] systemAvailableFeatures;
        if (packageManager == null || (systemAvailableFeatures = packageManager.getSystemAvailableFeatures()) == null) {
            return false;
        }
        for (FeatureInfo featureInfo : systemAvailableFeatures) {
            if (featureInfo != null && "android.hardware.camera.flash".equals(featureInfo.name)) {
                return true;
            }
        }
        return false;
    }
}

package com.baidu.wallet.base.camera.internal;

import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.os.Build;
import android.view.SurfaceHolder;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes5.dex */
public class CameraCtrl implements Camera.ErrorCallback, NoProguard {
    public static final int STATE_RAW = 0;
    public static final int TO_STATE_DESTROIED = 8;
    public static final int TO_STATE_INIT = 1;
    public static final int TO_STATE_PAUSED = 4;
    public static final int TO_STATE_STARTED = 2;
    public static final String Tag = CameraCtrl.class.getSimpleName();
    public int _cameraCnt;
    public int _cameraId;
    public b _cameraProxy;
    public int _height;
    public final Method[] _newVersionMethods;
    public Camera.PreviewCallback _previewCb;
    public SurfaceHolder _previewView;
    public int _rotation;
    public int _state;
    public boolean _supportAutoFocus;
    public int _width;

    /* loaded from: classes5.dex */
    public enum MethodIndex {
        open,
        getNumberOfCameras,
        setDisplayOrientation
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static CameraCtrl f23246a = new CameraCtrl();
    }

    private void doDestroy() {
        if (this._cameraProxy != null) {
            LogUtil.i(Tag, "doDestroy");
            this._cameraProxy.a((Camera.PreviewCallback) null);
            this._cameraProxy.c();
            this._cameraProxy.f();
            reset();
        }
    }

    private void doStart(Camera.PreviewCallback previewCallback) {
        LogUtil.i(Tag, "doStart");
        if (this._previewCb == null) {
            int bitsPerPixel = ((this._width * this._height) * ImageFormat.getBitsPerPixel(this._cameraProxy.d().getPreviewFormat())) / 8;
            byte[][] bArr = new byte[4];
            for (int i2 = 0; i2 < 4; i2++) {
                bArr[i2] = new byte[bitsPerPixel];
                this._cameraProxy.a(bArr[i2]);
            }
        }
        this._previewCb = previewCallback;
        this._cameraProxy.a(previewCallback);
        try {
            if (this._previewView != null) {
                this._cameraProxy.a(this._previewView);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            this._cameraProxy.e();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static CameraCtrl getInstance() {
        return a.f23246a;
    }

    private Camera.Size getSimilarRatioSize(int i2, int i3, List<Camera.Size> list, int i4) {
        int i5 = i2;
        int i6 = i3;
        if (i5 >= i6) {
            i6 = i5;
            i5 = i6;
        }
        float f2 = i5 / i6;
        double d2 = Double.MAX_VALUE;
        Camera.Size size = null;
        sortSize(list);
        ListIterator<Camera.Size> listIterator = list.listIterator();
        String str = Tag;
        LogUtil.i(str, "sorted getSimilarRatioSize(" + i6 + i5 + ") ; expectRatio = " + f2);
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            Camera.Size next = listIterator.next();
            LogUtil.i(Tag, String.format("supported picture size:(%d,%d)", Integer.valueOf(next.width), Integer.valueOf(next.height)));
            if (next.width == i6 && next.height == i5) {
                size = next;
                break;
            }
            int i7 = next.width;
            double d3 = next.height / i7;
            LogUtil.i(Tag, String.format("supported picture size:(%d,%d);ratio:%f", Integer.valueOf(i7), Integer.valueOf(next.height), Double.valueOf(d3)));
            double abs = Math.abs(f2 - d3);
            if (d2 > abs && 400 < next.height) {
                size = next;
                d2 = abs;
            }
        }
        if (size == null) {
            Camera.Size size2 = list.get(list.size() - 1);
            StringBuilder sb = new StringBuilder(size2.width);
            sb.append(",");
            sb.append(size2.height);
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.SDK_SELF_DEFINE_CAMERA_GET_SIZE, Arrays.asList(String.valueOf(i4), sb.toString()));
            String valueOf = String.valueOf(i4);
            StringBuilder sb2 = new StringBuilder(size2.width);
            sb2.append(",");
            sb2.append(size2.height);
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.SDK_SELF_DEFINE_CAMERA_GET_SIZE, valueOf, sb2.toString());
            return size2;
        }
        return size;
    }

    public static boolean isSupprtFlashLight(PackageManager packageManager) {
        FeatureInfo[] systemAvailableFeatures = packageManager.getSystemAvailableFeatures();
        if (systemAvailableFeatures == null) {
            return false;
        }
        for (FeatureInfo featureInfo : systemAvailableFeatures) {
            if ("android.hardware.camera.flash".equals(featureInfo.name)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0065 A[Catch: all -> 0x0161, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x0010, B:11:0x0017, B:13:0x003b, B:15:0x004d, B:20:0x0059, B:22:0x0065, B:25:0x0092, B:27:0x00c9, B:28:0x00f2, B:30:0x00f7, B:32:0x00fb, B:33:0x00fe, B:34:0x0103, B:36:0x010f, B:40:0x0129, B:39:0x0122, B:44:0x012e, B:48:0x013a, B:12:0x0036, B:55:0x014d, B:57:0x0151, B:59:0x0155, B:61:0x0159, B:52:0x0144), top: B:70:0x0001, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0092 A[Catch: all -> 0x0161, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x0010, B:11:0x0017, B:13:0x003b, B:15:0x004d, B:20:0x0059, B:22:0x0065, B:25:0x0092, B:27:0x00c9, B:28:0x00f2, B:30:0x00f7, B:32:0x00fb, B:33:0x00fe, B:34:0x0103, B:36:0x010f, B:40:0x0129, B:39:0x0122, B:44:0x012e, B:48:0x013a, B:12:0x0036, B:55:0x014d, B:57:0x0151, B:59:0x0155, B:61:0x0159, B:52:0x0144), top: B:70:0x0001, inners: #1, #2, #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean openCamera(int i2, int i3, int i4, int i5, int i6, int i7) {
        String focusMode;
        boolean z;
        Camera.Size similarRatioSize;
        boolean z2 = true;
        if (this._cameraProxy == null) {
            try {
                this._cameraProxy = b.a();
                if (-1 != i2 && isSupportMultiCamera()) {
                    this._cameraProxy.f23253a = (Camera) this._newVersionMethods[MethodIndex.open.ordinal()].invoke(Camera.class, Integer.valueOf(i2));
                    Camera.Parameters d2 = this._cameraProxy.d();
                    focusMode = d2.getFocusMode();
                    if (!focusMode.equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO) && !focusMode.equals("macro")) {
                        z = false;
                        this._supportAutoFocus = z;
                        similarRatioSize = getSimilarRatioSize(i3, i4, d2.getSupportedPreviewSizes(), 0);
                        if (similarRatioSize != null) {
                            this._cameraProxy.f();
                            this._cameraProxy = null;
                            String str = Tag;
                            LogUtil.e(str, "fail to get a proximate preivew size(" + i3 + "," + i4 + ").", null);
                            return false;
                        }
                        String str2 = Tag;
                        LogUtil.i(str2, "set preview size to widht = " + similarRatioSize.width + " , height = " + similarRatioSize.height);
                        int i8 = similarRatioSize.width;
                        this._width = i8;
                        int i9 = similarRatioSize.height;
                        this._height = i9;
                        d2.setPreviewSize(i8, i9);
                        Camera.Size similarRatioSize2 = getSimilarRatioSize(i3, i4, d2.getSupportedPictureSizes(), 1);
                        if (similarRatioSize2 != null) {
                            d2.setPictureSize(similarRatioSize2.width, similarRatioSize2.height);
                            String str3 = Tag;
                            LogUtil.i(str3, "set picture size to width = " + similarRatioSize2.width + " , height = " + similarRatioSize2.height);
                        }
                        try {
                            d2.setPreviewFormat(i6);
                            if (9 > Build.VERSION.SDK_INT) {
                                d2.setPreviewFrameRate(i7);
                            }
                            try {
                                this._cameraProxy.a(d2);
                                Method method = this._newVersionMethods[MethodIndex.setDisplayOrientation.ordinal()];
                                if (method != null) {
                                    try {
                                        method.invoke(this._cameraProxy.f23253a, Integer.valueOf(i5));
                                        this._rotation = i5;
                                    } catch (Exception e2) {
                                        LogUtil.e(Tag, "", e2);
                                    }
                                }
                                this._cameraId = i2;
                                return true;
                            } catch (Exception e3) {
                                LogUtil.e(Tag, d2.toString(), e3);
                                return false;
                            }
                        } catch (IllegalArgumentException e4) {
                            LogUtil.e(Tag, "failed to openCamera:", e4);
                            return false;
                        }
                    }
                    z = true;
                    this._supportAutoFocus = z;
                    similarRatioSize = getSimilarRatioSize(i3, i4, d2.getSupportedPreviewSizes(), 0);
                    if (similarRatioSize != null) {
                    }
                }
                this._cameraProxy.b();
                Camera.Parameters d22 = this._cameraProxy.d();
                focusMode = d22.getFocusMode();
                if (!focusMode.equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                    z = false;
                    this._supportAutoFocus = z;
                    similarRatioSize = getSimilarRatioSize(i3, i4, d22.getSupportedPreviewSizes(), 0);
                    if (similarRatioSize != null) {
                    }
                }
                z = true;
                this._supportAutoFocus = z;
                similarRatioSize = getSimilarRatioSize(i3, i4, d22.getSupportedPreviewSizes(), 0);
                if (similarRatioSize != null) {
                }
            } catch (Exception e5) {
                LogUtil.e(Tag, "The camera is in use", e5);
                return false;
            }
        } else {
            return (i2 == this._cameraId && i3 == this._width && i5 == this._rotation && i4 == this._height) ? false : false;
        }
    }

    private boolean setState(int i2) {
        if (2 == i2) {
            if ((this._state & 7) == 0) {
                return false;
            }
        } else if (4 == i2) {
            if ((this._state & 6) == 0) {
                return false;
            }
        } else if (1 == i2) {
            int i3 = this._state;
            if (i3 != 0 && 8 != i3) {
                return false;
            }
        } else if (8 != i2) {
            return false;
        }
        this._state = i2;
        String str = Tag;
        LogUtil.i(str, "setState(" + this._state + ") succeed.");
        return true;
    }

    private void sortSize(List<Camera.Size> list) {
        Collections.sort(list, new Comparator<Camera.Size>() { // from class: com.baidu.wallet.base.camera.internal.CameraCtrl.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Camera.Size size, Camera.Size size2) {
                int i2 = size.width;
                int i3 = size2.width;
                if (i2 > i3) {
                    return 1;
                }
                if (i2 < i3) {
                    return -1;
                }
                if (i2 == i3) {
                    int i4 = size.height;
                    int i5 = size2.height;
                    if (i4 > i5) {
                        return 1;
                    }
                    return i4 < i5 ? -1 : 0;
                }
                return 0;
            }
        });
    }

    public b camera() {
        return this._cameraProxy;
    }

    public synchronized void destroy() {
        String str = Tag;
        LogUtil.i(str, "destroy:stat=" + this._state);
        if (setState(8)) {
            doDestroy();
        }
    }

    public int getCameraCount() {
        int i2 = this._cameraCnt;
        if (-1 == i2) {
            if (this._newVersionMethods[MethodIndex.getNumberOfCameras.ordinal()] == null) {
                return 1;
            }
            try {
                int intValue = ((Integer) this._newVersionMethods[MethodIndex.getNumberOfCameras.ordinal()].invoke(Camera.class, new Object[0])).intValue();
                this._cameraCnt = intValue;
                i2 = intValue;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
            if (-1 == i2) {
                return 0;
            }
            return i2;
        }
        return i2;
    }

    public int getCurrentZoom() {
        b bVar;
        if (!isSupportZoom() || (bVar = this._cameraProxy) == null) {
            return 0;
        }
        return bVar.d().getZoom();
    }

    public int getMaxZoom() {
        b bVar;
        if (!isSupportZoom() || (bVar = this._cameraProxy) == null) {
            return 0;
        }
        return bVar.d().getMaxZoom();
    }

    public synchronized int getPreviewHeight() {
        return this._height;
    }

    public synchronized int getPreviewWidht() {
        return this._width;
    }

    public synchronized boolean init(int i2, int i3, int i4, int i5, int i6, int i7) {
        String str = Tag;
        LogUtil.i(str, "init:state=" + this._state);
        if (setState(1)) {
            this._previewCb = null;
            return openCamera(i2, i3, i4, i5, i6, i7);
        }
        return false;
    }

    public boolean isFlashOn() {
        if ((this._state & 6) == 0) {
            return false;
        }
        return "torch".equals(this._cameraProxy.d().getFlashMode());
    }

    public boolean isSupportAutoFocus() {
        return this._supportAutoFocus;
    }

    public boolean isSupportMultiCamera() {
        return 9 <= Build.VERSION.SDK_INT && this._newVersionMethods[MethodIndex.getNumberOfCameras.ordinal()] != null && getCameraCount() > 1;
    }

    public boolean isSupportZoom() {
        b bVar = this._cameraProxy;
        if (bVar != null) {
            return bVar.d().isZoomSupported();
        }
        return false;
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i2, Camera camera) {
        String str = Tag;
        LogUtil.e(str, "camera error: " + i2, null);
    }

    public synchronized void pause() {
        if (setState(4)) {
            this._cameraProxy.c();
        }
    }

    public void reset() {
        this._cameraProxy = null;
        this._previewCb = null;
        this._previewView = null;
        this._rotation = -1;
        this._height = -1;
        this._width = -1;
        this._cameraId = -1;
        this._state = 0;
    }

    public boolean setFlashOn(boolean z) {
        Camera.Parameters d2;
        String flashMode;
        if ((this._state & 6) == 0 || (flashMode = (d2 = this._cameraProxy.d()).getFlashMode()) == null) {
            return false;
        }
        String str = z ? "torch" : DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        if (str.equals(flashMode)) {
            return true;
        }
        d2.setFlashMode(str);
        try {
            this._cameraProxy.a(d2);
            return true;
        } catch (Exception e2) {
            LogUtil.e(Tag, "setFlashOn()", e2);
            return false;
        }
    }

    public void setPreviewDisplay(SurfaceHolder surfaceHolder) {
        if (this._previewView != null || surfaceHolder == null) {
            return;
        }
        try {
            this._cameraProxy.a(surfaceHolder);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void setZoom(int i2) {
        b bVar = this._cameraProxy;
        if (bVar != null) {
            Camera.Parameters d2 = bVar.d();
            if (!isSupportZoom() || d2.getZoom() == i2) {
                return;
            }
            d2.setZoom(i2);
            this._cameraProxy.a(d2);
        }
    }

    public synchronized void start(Camera.PreviewCallback previewCallback, SurfaceHolder surfaceHolder) {
        String str = Tag;
        LogUtil.i(str, "start:stat=" + this._state);
        if (previewCallback == null) {
            LogUtil.w(Tag, "Can not start a camera with a null preview-callback");
        } else if (previewCallback == this._previewCb && surfaceHolder == this._previewView && 2 == this._state) {
            LogUtil.w(Tag, "The camera already started.");
        } else if (setState(2)) {
            this._previewView = surfaceHolder;
            doStart(previewCallback);
        }
    }

    public boolean trigerFlash() {
        if ((this._state & 6) == 0) {
            return false;
        }
        this._cameraProxy.c();
        Camera.Parameters d2 = this._cameraProxy.d();
        if ("torch".equals(d2.getFlashMode())) {
            d2.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        } else {
            d2.setFlashMode("torch");
        }
        try {
            this._cameraProxy.a(d2);
            this._cameraProxy.e();
            return true;
        } catch (Exception unused) {
            this._cameraProxy.e();
            return false;
        }
    }

    public CameraCtrl() {
        this._cameraProxy = null;
        this._cameraCnt = -1;
        this._supportAutoFocus = false;
        this._previewView = null;
        this._state = 0;
        reset();
        this._newVersionMethods = new Method[MethodIndex.values().length];
        int i2 = 0;
        while (true) {
            Method[] methodArr = this._newVersionMethods;
            if (i2 < methodArr.length) {
                methodArr[i2] = null;
                i2++;
            } else {
                try {
                    Class[] clsArr = {Integer.TYPE};
                    methodArr[MethodIndex.open.ordinal()] = Camera.class.getMethod("open", clsArr);
                    this._newVersionMethods[MethodIndex.setDisplayOrientation.ordinal()] = Camera.class.getMethod("setDisplayOrientation", clsArr);
                    this._newVersionMethods[MethodIndex.getNumberOfCameras.ordinal()] = Camera.class.getMethod("getNumberOfCameras", null);
                    return;
                } catch (NoSuchMethodException e2) {
                    LogUtil.e(Tag, "determine method: ", e2);
                    return;
                }
            }
        }
    }
}

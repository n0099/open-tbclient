package com.baidu.wallet.base.camera.internal;

import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.os.Build;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
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
/* loaded from: classes6.dex */
public class CameraCtrl implements Camera.ErrorCallback, NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_RAW = 0;
    public static final int TO_STATE_DESTROIED = 8;
    public static final int TO_STATE_INIT = 1;
    public static final int TO_STATE_PAUSED = 4;
    public static final int TO_STATE_STARTED = 2;
    public static final String Tag;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class MethodIndex {
        public static final /* synthetic */ MethodIndex[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MethodIndex getNumberOfCameras;
        public static final MethodIndex open;
        public static final MethodIndex setDisplayOrientation;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1736074880, "Lcom/baidu/wallet/base/camera/internal/CameraCtrl$MethodIndex;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1736074880, "Lcom/baidu/wallet/base/camera/internal/CameraCtrl$MethodIndex;");
                    return;
                }
            }
            open = new MethodIndex("open", 0);
            getNumberOfCameras = new MethodIndex("getNumberOfCameras", 1);
            MethodIndex methodIndex = new MethodIndex("setDisplayOrientation", 2);
            setDisplayOrientation = methodIndex;
            $VALUES = new MethodIndex[]{open, getNumberOfCameras, methodIndex};
        }

        public MethodIndex(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static MethodIndex valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MethodIndex) Enum.valueOf(MethodIndex.class, str) : (MethodIndex) invokeL.objValue;
        }

        public static MethodIndex[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MethodIndex[]) $VALUES.clone() : (MethodIndex[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static CameraCtrl a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1085954032, "Lcom/baidu/wallet/base/camera/internal/CameraCtrl$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1085954032, "Lcom/baidu/wallet/base/camera/internal/CameraCtrl$a;");
                    return;
                }
            }
            a = new CameraCtrl();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2018979443, "Lcom/baidu/wallet/base/camera/internal/CameraCtrl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2018979443, "Lcom/baidu/wallet/base/camera/internal/CameraCtrl;");
                return;
            }
        }
        Tag = CameraCtrl.class.getSimpleName();
    }

    private void doDestroy() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this._cameraProxy == null) {
            return;
        }
        LogUtil.i(Tag, "doDestroy");
        this._cameraProxy.a((Camera.PreviewCallback) null);
        this._cameraProxy.c();
        this._cameraProxy.f();
        reset();
    }

    private void doStart(Camera.PreviewCallback previewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, previewCallback) == null) {
            LogUtil.i(Tag, "doStart");
            if (this._previewCb == null) {
                int bitsPerPixel = ((this._width * this._height) * ImageFormat.getBitsPerPixel(this._cameraProxy.d().getPreviewFormat())) / 8;
                byte[][] bArr = new byte[4];
                int i2 = 0;
                while (i2 < 4) {
                    bArr[i2] = null;
                    try {
                        bArr[i2] = new byte[bitsPerPixel];
                    } catch (OutOfMemoryError unused) {
                        long freeMemory = Runtime.getRuntime().freeMemory();
                        LogUtil.d("freeMemory", freeMemory + "");
                        int i3 = (int) freeMemory;
                        if (i3 <= bitsPerPixel) {
                            bArr[i2] = new byte[i3];
                        } else {
                            bArr[i2] = new byte[bitsPerPixel];
                        }
                    } finally {
                        this._cameraProxy.a(bArr[i2]);
                    }
                    i2++;
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
    }

    public static CameraCtrl getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? a.a : (CameraCtrl) invokeV.objValue;
    }

    private Camera.Size getSimilarRatioSize(int i2, int i3, List<Camera.Size> list, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), list, Integer.valueOf(i4)})) == null) {
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
                DXMSdkSAUtils.onEventWithValues("sdk_self_define_camera_get_size", Arrays.asList(String.valueOf(i4), sb.toString()));
                return size2;
            }
            return size;
        }
        return (Camera.Size) invokeCommon.objValue;
    }

    public static boolean isSupprtFlashLight(PackageManager packageManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, packageManager)) == null) {
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
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0069 A[Catch: all -> 0x0165, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x0014, B:13:0x001b, B:15:0x003f, B:17:0x0051, B:22:0x005d, B:24:0x0069, B:27:0x0096, B:29:0x00cd, B:30:0x00f6, B:32:0x00fb, B:34:0x00ff, B:35:0x0102, B:36:0x0107, B:38:0x0113, B:42:0x012d, B:41:0x0126, B:46:0x0132, B:50:0x013e, B:14:0x003a, B:57:0x0151, B:59:0x0155, B:61:0x0159, B:63:0x015d, B:54:0x0148), top: B:76:0x0005, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0096 A[Catch: all -> 0x0165, TRY_ENTER, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x0014, B:13:0x001b, B:15:0x003f, B:17:0x0051, B:22:0x005d, B:24:0x0069, B:27:0x0096, B:29:0x00cd, B:30:0x00f6, B:32:0x00fb, B:34:0x00ff, B:35:0x0102, B:36:0x0107, B:38:0x0113, B:42:0x012d, B:41:0x0126, B:46:0x0132, B:50:0x013e, B:14:0x003a, B:57:0x0151, B:59:0x0155, B:61:0x0159, B:63:0x015d, B:54:0x0148), top: B:76:0x0005, inners: #1, #2, #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean openCamera(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        String focusMode;
        boolean z;
        Camera.Size similarRatioSize;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65544, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) != null) {
            return invokeCommon.booleanValue;
        }
        synchronized (this) {
            boolean z2 = true;
            if (this._cameraProxy == null) {
                try {
                    this._cameraProxy = b.a();
                    if (-1 != i2 && isSupportMultiCamera()) {
                        this._cameraProxy.a = (Camera) this._newVersionMethods[MethodIndex.open.ordinal()].invoke(Camera.class, Integer.valueOf(i2));
                        Camera.Parameters d2 = this._cameraProxy.d();
                        focusMode = d2.getFocusMode();
                        if (!focusMode.equals("auto") && !focusMode.equals("macro")) {
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
                                            method.invoke(this._cameraProxy.a, Integer.valueOf(i5));
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
                    if (!focusMode.equals("auto")) {
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
    }

    private boolean setState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i2)) == null) {
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
        return invokeI.booleanValue;
    }

    private void sortSize(List<Camera.Size> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, list) == null) {
            Collections.sort(list, new Comparator<Camera.Size>(this) { // from class: com.baidu.wallet.base.camera.internal.CameraCtrl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CameraCtrl a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(Camera.Size size, Camera.Size size2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, size, size2)) == null) {
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
                    return invokeLL.intValue;
                }
            });
        }
    }

    public b camera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this._cameraProxy : (b) invokeV.objValue;
    }

    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                String str = Tag;
                LogUtil.i(str, "destroy:stat=" + this._state);
                if (setState(8)) {
                    doDestroy();
                }
            }
        }
    }

    public int getCameraCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
        return invokeV.intValue;
    }

    public int getCurrentZoom() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!isSupportZoom() || (bVar = this._cameraProxy) == null) {
                return 0;
            }
            return bVar.d().getZoom();
        }
        return invokeV.intValue;
    }

    public int getMaxZoom() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!isSupportZoom() || (bVar = this._cameraProxy) == null) {
                return 0;
            }
            return bVar.d().getMaxZoom();
        }
        return invokeV.intValue;
    }

    public synchronized int getPreviewHeight() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                i2 = this._height;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized int getPreviewWidht() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                i2 = this._width;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized boolean init(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            synchronized (this) {
                String str = Tag;
                LogUtil.i(str, "init:state=" + this._state);
                if (setState(1)) {
                    this._previewCb = null;
                    return openCamera(i2, i3, i4, i5, i6, i7);
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public boolean isFlashOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if ((this._state & 6) == 0) {
                return false;
            }
            return "torch".equals(this._cameraProxy.d().getFlashMode());
        }
        return invokeV.booleanValue;
    }

    public boolean isSupportAutoFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this._supportAutoFocus : invokeV.booleanValue;
    }

    public boolean isSupportMultiCamera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? 9 <= Build.VERSION.SDK_INT && this._newVersionMethods[MethodIndex.getNumberOfCameras.ordinal()] != null && getCameraCount() > 1 : invokeV.booleanValue;
    }

    public boolean isSupportZoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            b bVar = this._cameraProxy;
            if (bVar != null) {
                return bVar.d().isZoomSupported();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i2, Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, camera) == null) {
            String str = Tag;
            LogUtil.e(str, "camera error: " + i2, null);
        }
    }

    public synchronized void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                if (setState(4)) {
                    this._cameraProxy.c();
                }
            }
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this._cameraProxy = null;
            this._previewCb = null;
            this._previewView = null;
            this._rotation = -1;
            this._height = -1;
            this._width = -1;
            this._cameraId = -1;
            this._state = 0;
        }
    }

    public boolean setFlashOn(boolean z) {
        InterceptResult invokeZ;
        Camera.Parameters d2;
        String flashMode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
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
        return invokeZ.booleanValue;
    }

    public void setPreviewDisplay(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, surfaceHolder) == null) && this._previewView == null && surfaceHolder != null) {
            try {
                this._cameraProxy.a(surfaceHolder);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setZoom(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (bVar = this._cameraProxy) == null) {
            return;
        }
        Camera.Parameters d2 = bVar.d();
        if (!isSupportZoom() || d2.getZoom() == i2) {
            return;
        }
        d2.setZoom(i2);
        this._cameraProxy.a(d2);
    }

    public synchronized void start(Camera.PreviewCallback previewCallback, SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, previewCallback, surfaceHolder) == null) {
            synchronized (this) {
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
        }
    }

    public boolean trigerFlash() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public CameraCtrl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this._cameraProxy = null;
        this._cameraCnt = -1;
        this._supportAutoFocus = false;
        this._previewView = null;
        this._state = 0;
        reset();
        this._newVersionMethods = new Method[MethodIndex.values().length];
        int i4 = 0;
        while (true) {
            Method[] methodArr = this._newVersionMethods;
            if (i4 < methodArr.length) {
                methodArr[i4] = null;
                i4++;
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

package com.baidu.wallet.base.iddetect.utils;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.CameraSizeInfo;
import com.baidu.wallet.core.utils.LogUtil;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes13.dex */
public class CameraUtilsForScan {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float BANK_HEIGHT_WIDTH_RADIO = 0.6306f;
    public static final int BIG_MAX_SIZE_HEIGHT = 1080;
    public static final int BIG_MAX_SIZE_WIDTH = 1920;
    public static final int CAMERA_POS_BACK = 1;
    public static final int CAMERA_POS_FRONT = 0;
    public static final int DEFAULT_SIZE_HEIGHT = 480;
    public static final int DEFAULT_SIZE_WIDTH = 640;
    public static final float MAX_RATIO_DVALUE = 0.1f;
    public static final int MAX_SIZE_HEIGHT = 720;
    public static final int MIN_SIZE_HEIGHT = 480;
    public static CameraSizeInfo mSmallSortSize;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-410854552, "Lcom/baidu/wallet/base/iddetect/utils/CameraUtilsForScan;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-410854552, "Lcom/baidu/wallet/base/iddetect/utils/CameraUtilsForScan;");
        }
    }

    public CameraUtilsForScan() {
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CameraSizeInfo getBestSurfaceSize(int i2, Context context) {
        InterceptResult invokeIL;
        CameraSizeInfo mostSimilarSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, context)) == null) {
            Camera cameraDevice = getCameraDevice(i2);
            if (cameraDevice != null) {
                try {
                    if (cameraDevice.getParameters() != null) {
                        List<CameraSizeInfo> sortOut = sortOut(cameraDevice.getParameters().getSupportedPreviewSizes());
                        Rect screenInfo = getScreenInfo(context);
                        mostSimilarSize = getMostSimilarSize(context, screenInfo, getWdivideHRatio(screenInfo.width(), screenInfo.height()), sortOut);
                        if (cameraDevice != null) {
                            LogUtil.errord(CameraSizeInfo.class.getSimpleName(), "release camera");
                            cameraDevice.release();
                        }
                        return mostSimilarSize;
                    }
                } catch (Exception e2) {
                    String simpleName = CameraSizeInfo.class.getSimpleName();
                    LogUtil.errord(simpleName, "exception = " + e2.getMessage());
                    throw e2;
                }
            }
            mostSimilarSize = null;
            if (cameraDevice != null) {
            }
            return mostSimilarSize;
        }
        return (CameraSizeInfo) invokeIL.objValue;
    }

    public static Camera getCameraDevice(int i2) {
        InterceptResult invokeI;
        Camera open;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
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
        return (Camera) invokeI.objValue;
    }

    public static float getFormatFloat(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, null, f2)) == null) ? Float.parseFloat(new DecimalFormat("##0.00").format(f2)) : invokeF.floatValue;
    }

    public static float getFrameHeightRatio(Context context, Rect rect, CameraSizeInfo cameraSizeInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, context, rect, cameraSizeInfo)) == null) {
            float width = (rect.width() * 1.0f) / cameraSizeInfo.mHeight;
            float height = (rect.height() * 1.0f) / cameraSizeInfo.mWidth;
            return width > height ? (width * 0.6306f) / height : (height * 0.6306f) / width;
        }
        return invokeLLL.floatValue;
    }

    public static CameraSizeInfo getMostSimilarSize(Context context, Rect rect, float f2, List<CameraSizeInfo> list) {
        InterceptResult invokeCommon;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, rect, Float.valueOf(f2), list})) == null) {
            boolean z2 = false;
            CameraSizeInfo cameraSizeInfo = null;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    z = false;
                    break;
                }
                cameraSizeInfo = list.get(i3);
                float wdivideHRatio = getWdivideHRatio(cameraSizeInfo.mHeight, cameraSizeInfo.mWidth);
                list.get(i3).mRatioDeta = Math.abs(wdivideHRatio - f2);
                list.get(i3).mIsCompareRatio = true;
                if (wdivideHRatio == f2 && (i2 = cameraSizeInfo.mHeight) >= 480 && i2 <= 720) {
                    cameraSizeInfo.mHeightRatio = 0.6306f;
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
                        if (list.get(i4).mHeight >= 480 && list.get(i4).mHeight <= 720 && list.get(i4).mRatioDeta <= 0.1f) {
                            cameraSizeInfo = list.get(i4);
                            cameraSizeInfo.mHeightRatio = getFrameHeightRatio(context, rect, cameraSizeInfo);
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
                if (cameraSizeInfo == null) {
                    cameraSizeInfo = new CameraSizeInfo(640, 480);
                } else {
                    cameraSizeInfo.mHeight = 480;
                    cameraSizeInfo.mWidth = 640;
                }
                cameraSizeInfo.mHeightRatio = getFrameHeightRatio(context, rect, cameraSizeInfo);
            }
            return cameraSizeInfo;
        }
        return (CameraSizeInfo) invokeCommon.objValue;
    }

    public static Rect getScreenInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (Build.VERSION.SDK_INT < 14) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            Rect rect = new Rect();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRectSize(rect);
            return rect;
        }
        return (Rect) invokeL.objValue;
    }

    public static CameraSizeInfo getSortSizeInstance(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (mSmallSortSize == null || z) {
                mSmallSortSize = getBestSurfaceSize(i2, context);
            }
            return mSmallSortSize;
        }
        return (CameraSizeInfo) invokeCommon.objValue;
    }

    public static float getWdivideHRatio(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65545, null, i2, i3)) == null) ? getFormatFloat((i2 * 1.0f) / i3) : invokeII.floatValue;
    }

    public static List<CameraSizeInfo> sortOut(List<Camera.Size> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Camera.Size size = list.get(i2);
                arrayList.add(new CameraSizeInfo(size.width, size.height));
            }
            Collections.sort(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}

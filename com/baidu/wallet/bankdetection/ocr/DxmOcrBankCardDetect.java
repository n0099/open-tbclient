package com.baidu.wallet.bankdetection.ocr;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.statistics.api.StatisticManager;
/* loaded from: classes13.dex */
public class DxmOcrBankCardDetect {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    /* loaded from: classes13.dex */
    public static class Options {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float bankCardRatio;
        public float blurThreshold;
        public int borderDistance;
        public float expandRatio;
        public int maxLength;
        public int minLength;
        public float scoreThreshold;
        public boolean useMinScore;

        public Options() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1269393288, "Lcom/baidu/wallet/bankdetection/ocr/DxmOcrBankCardDetect;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1269393288, "Lcom/baidu/wallet/bankdetection/ocr/DxmOcrBankCardDetect;");
                return;
            }
        }
        StatisticManager.onEvent(StatServiceEvent.OCR_BANKCARD_START_LOAD_SO);
        try {
            System.loadLibrary("dxmpay_bankcard_ocr");
            StatisticManager.onEvent(StatServiceEvent.OCR_BANKCARD_LOAD_SO_SUCCESS);
        } catch (Exception e2) {
            e2.printStackTrace();
            StatisticManager.onEventEndWithValue(StatServiceEvent.OCR_BANKCARD_LOAD_SO_ERROR, e2.getMessage());
        }
    }

    public DxmOcrBankCardDetect() {
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

    public static native int dynamicInitModel(String str, String str2, String str3, String str4, String str5, boolean z);

    private String getPrivateDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Context context = this.mContext;
            if (context != null) {
                if (Build.VERSION.SDK_INT < 29) {
                    return Environment.getExternalStorageDirectory().toString();
                }
                return context.getExternalFilesDir("").getAbsolutePath();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static void saveBitmap(Bitmap bitmap, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bitmap, str) == null) {
        }
    }

    public static native int staticInitModel(AssetManager assetManager, String str, String str2, String str3, String str4, String str5, boolean z);

    public native void close();

    public native int detect(byte[] bArr, int[] iArr, Object[] objArr);

    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.mContext = context;
        }
    }

    public native void setOptions(Options options);
}

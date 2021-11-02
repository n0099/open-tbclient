package com.baidu.wallet.qrcodescanner;

import com.baidu.idl.util.StuLogEx;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ScanCodeController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class DecodeTool {
        public static final /* synthetic */ DecodeTool[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DecodeTool IDL;
        public static final DecodeTool ZXING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2044259774, "Lcom/baidu/wallet/qrcodescanner/ScanCodeController$DecodeTool;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2044259774, "Lcom/baidu/wallet/qrcodescanner/ScanCodeController$DecodeTool;");
                    return;
                }
            }
            IDL = new DecodeTool(StuLogEx.TAG, 0, 1);
            DecodeTool decodeTool = new DecodeTool("ZXING", 1, 2);
            ZXING = decodeTool;
            $VALUES = new DecodeTool[]{IDL, decodeTool};
        }

        public DecodeTool(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static DecodeTool valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DecodeTool) Enum.valueOf(DecodeTool.class, str) : (DecodeTool) invokeL.objValue;
        }

        public static DecodeTool[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DecodeTool[]) $VALUES.clone() : (DecodeTool[]) invokeV.objValue;
        }
    }

    public static DecodeTool a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? DecodeTool.IDL : (DecodeTool) invokeV.objValue;
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? i2 != 2 : invokeI.booleanValue;
    }
}

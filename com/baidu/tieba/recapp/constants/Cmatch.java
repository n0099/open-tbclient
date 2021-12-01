package com.baidu.tieba.recapp.constants;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes11.dex */
public final class Cmatch {
    public static final /* synthetic */ Cmatch[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Cmatch FRS;
    public static final Cmatch HOMEPAGE;
    public static final Cmatch PB_BANNER;
    public static final Cmatch PB_COMMENT;
    public static final Cmatch PIC_PAGE;
    public static final Cmatch VIDEO_FLOW;
    public static final Cmatch VIDEO_LIST;
    public static final Cmatch VIDEO_PASTER;
    public static final Cmatch VIDEO_PB_COMMENT;
    public static final Cmatch VIDEO_PB_RECOMMEND;
    public transient /* synthetic */ FieldHolder $fh;
    public final String value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1236627753, "Lcom/baidu/tieba/recapp/constants/Cmatch;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1236627753, "Lcom/baidu/tieba/recapp/constants/Cmatch;");
                return;
            }
        }
        HOMEPAGE = new Cmatch("HOMEPAGE", 0, "547");
        FRS = new Cmatch("FRS", 1, "489");
        PB_BANNER = new Cmatch("PB_BANNER", 2, "778");
        PB_COMMENT = new Cmatch("PB_COMMENT", 3, "1502");
        PIC_PAGE = new Cmatch("PIC_PAGE", 4, "646");
        VIDEO_PB_COMMENT = new Cmatch("VIDEO_PB_COMMENT", 5, "1383");
        VIDEO_PB_RECOMMEND = new Cmatch("VIDEO_PB_RECOMMEND", 6, "1382");
        VIDEO_LIST = new Cmatch("VIDEO_LIST", 7, "714");
        VIDEO_PASTER = new Cmatch("VIDEO_PASTER", 8, "946");
        Cmatch cmatch = new Cmatch("VIDEO_FLOW", 9, "1675");
        VIDEO_FLOW = cmatch;
        $VALUES = new Cmatch[]{HOMEPAGE, FRS, PB_BANNER, PB_COMMENT, PIC_PAGE, VIDEO_PB_COMMENT, VIDEO_PB_RECOMMEND, VIDEO_LIST, VIDEO_PASTER, cmatch};
    }

    public Cmatch(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = str2;
    }

    public static Cmatch valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Cmatch) Enum.valueOf(Cmatch.class, str) : (Cmatch) invokeL.objValue;
    }

    public static Cmatch[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Cmatch[]) $VALUES.clone() : (Cmatch[]) invokeV.objValue;
    }
}

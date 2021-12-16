package com.baidu.tieba.recapp.constants;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes12.dex */
public final class PlaceId {
    public static final /* synthetic */ PlaceId[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PlaceId FRS;
    public static final PlaceId HOMEPAGE;
    public static final PlaceId PB_BANNER;
    public static final PlaceId PB_COMMENT;
    public static final PlaceId PIC_PAGE;
    public static final PlaceId PIC_PAGE_BANNER;
    public static final PlaceId PIC_PAGE_INSERT;
    public static final PlaceId VIDEO_FLOW;
    public static final PlaceId VIDEO_LIST;
    public static final PlaceId VIDEO_PASTER;
    public static final PlaceId VIDEO_PB_COMMENT;
    public static final PlaceId VIDEO_PB_RECOMMEND;
    public transient /* synthetic */ FieldHolder $fh;
    public final String value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-40719863, "Lcom/baidu/tieba/recapp/constants/PlaceId;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-40719863, "Lcom/baidu/tieba/recapp/constants/PlaceId;");
                return;
            }
        }
        HOMEPAGE = new PlaceId("HOMEPAGE", 0, "1453093728320");
        FRS = new PlaceId("FRS", 1, "0005");
        PB_BANNER = new PlaceId("PB_BANNER", 2, "1527489263072");
        PB_COMMENT = new PlaceId("PB_COMMENT", 3, "1591063400197");
        PIC_PAGE = new PlaceId("PIC_PAGE", 4, "1449746786091");
        PIC_PAGE_INSERT = new PlaceId("PIC_PAGE_INSERT", 5, "1623060974307");
        PIC_PAGE_BANNER = new PlaceId("PIC_PAGE_BANNER", 6, "1615197341657");
        VIDEO_PB_COMMENT = new PlaceId("VIDEO_PB_COMMENT", 7, "1383");
        VIDEO_PB_RECOMMEND = new PlaceId("VIDEO_PB_RECOMMEND", 8, "1578383264653");
        VIDEO_LIST = new PlaceId("VIDEO_LIST", 9, "1517888290046");
        VIDEO_PASTER = new PlaceId("VIDEO_PASTER", 10, "1546857125210");
        PlaceId placeId = new PlaceId("VIDEO_FLOW", 11, "1622184170464");
        VIDEO_FLOW = placeId;
        $VALUES = new PlaceId[]{HOMEPAGE, FRS, PB_BANNER, PB_COMMENT, PIC_PAGE, PIC_PAGE_INSERT, PIC_PAGE_BANNER, VIDEO_PB_COMMENT, VIDEO_PB_RECOMMEND, VIDEO_LIST, VIDEO_PASTER, placeId};
    }

    public PlaceId(String str, int i2, String str2) {
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

    public static PlaceId valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PlaceId) Enum.valueOf(PlaceId.class, str) : (PlaceId) invokeL.objValue;
    }

    public static PlaceId[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PlaceId[]) $VALUES.clone() : (PlaceId[]) invokeV.objValue;
    }
}

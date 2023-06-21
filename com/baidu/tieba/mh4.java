package com.baidu.tieba;

import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class mh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PoiInfo a;
    public boolean b;
    public boolean c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public mh4(PoiInfo poiInfo) {
        this(poiInfo, false, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {poiInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((PoiInfo) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static List<mh4> a(List<PoiInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList(list.size());
                for (PoiInfo poiInfo : list) {
                    if (poiInfo.location != null) {
                        arrayList.add(new mh4(poiInfo));
                    }
                }
                return arrayList;
            }
            return new ArrayList();
        }
        return (List) invokeL.objValue;
    }

    public mh4(PoiInfo poiInfo, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {poiInfo, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (poiInfo == null) {
            this.a = new PoiInfo();
        }
        this.a = poiInfo;
        this.b = z;
        this.c = z2;
    }
}

package com.baidu.tieba;

import android.util.Pair;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.gmb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.fun.ad.sdk.internal.api.utils.MD5Utils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class jmb<A extends gmb> extends AdReporter<A> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean e;
    public final String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jmb(Ssp.Pid pid) {
        super(pid.pid, pid.type, pid.ssp.type);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = pid.isBidding;
        this.f = pid.pid;
    }

    @Override // com.fun.ad.sdk.internal.api.utils.AdReporter
    public List onReport(Object obj, String str) {
        InterceptResult invokeLL;
        double a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, str)) == null) {
            gmb gmbVar = (gmb) obj;
            if (gmbVar != null && gmbVar.a != 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Pair.create("csj_rq_id", gmbVar.c()));
                if (!this.e) {
                    a = FunAdSdk.getARPU(this.f);
                } else {
                    a = gmbVar.a() / 1000.0d;
                }
                arrayList.add(Pair.create("rvn", Double.valueOf(a)));
                arrayList.add(Pair.create("rvnM", MD5Utils.getMD5String(String.valueOf((int) Math.floor(1000000.0d * a)))));
                arrayList.add(Pair.create(MapBundleKey.MapObjKey.OBJ_BID, Boolean.valueOf(this.e)));
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }
}

package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.pm4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jm4 extends bl4<pm4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.bl4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkglist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jm4(qj4 qj4Var, bn4 bn4Var) {
        super(qj4Var, bn4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qj4Var, bn4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((qj4) objArr2[0], (bn4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl4
    /* renamed from: w */
    public pm4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            return cp4.f(jSONObject);
        }
        return (pm4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl4
    /* renamed from: u */
    public boolean e(pm4 pm4Var) {
        InterceptResult invokeL;
        List<pm4.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, pm4Var)) == null) {
            if (pm4Var == null || (list = pm4Var.a) == null || list.isEmpty()) {
                return false;
            }
            for (pm4.a aVar : pm4Var.a) {
                if (TextUtils.isEmpty(aVar.b)) {
                    return false;
                }
                if (aVar.a == 0) {
                    if (aVar.d == null && aVar.g == null && aVar.e == null) {
                        return false;
                    }
                    uk4 uk4Var = aVar.d;
                    if (uk4Var != null && !uk4Var.a()) {
                        return false;
                    }
                    PMSAppInfo pMSAppInfo = aVar.g;
                    if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl4
    /* renamed from: v */
    public pk4 s(pm4 pm4Var) {
        InterceptResult invokeL;
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pm4Var)) == null) {
            this.a.E();
            dp4 dp4Var = new dp4();
            Map<String, PMSAppInfo> v = sj4.i().v();
            ArrayList arrayList = new ArrayList();
            List<wk4> list = null;
            for (pm4.a aVar : pm4Var.a) {
                if (aVar != null) {
                    int i = aVar.a;
                    if (i != 0) {
                        this.a.v().o(aVar, v.get(aVar.b), new pk4(i, aVar.b + "，Server返回错误"));
                    } else {
                        List<vk4> list2 = aVar.e;
                        if (list2 != null) {
                            for (vk4 vk4Var : list2) {
                                if (vk4Var != null) {
                                    vk4Var.o = aVar.b;
                                }
                            }
                            o(aVar.e, dp4Var);
                            arrayList.addAll(aVar.e);
                        }
                        list = f(aVar.f);
                        if (list != null) {
                            m(list, dp4Var);
                        }
                        if (aVar.d != null && (pMSAppInfo2 = aVar.g) != null) {
                            pMSAppInfo2.appId = aVar.b;
                            this.a.v().l(aVar.g);
                            n(aVar.d, dp4Var);
                        } else {
                            PMSAppInfo pMSAppInfo3 = v.get(aVar.b);
                            if (pMSAppInfo3 == null) {
                                PMSAppInfo pMSAppInfo4 = aVar.g;
                                if (pMSAppInfo4 != null) {
                                    pMSAppInfo4.appId = aVar.b;
                                    List<vk4> list3 = aVar.e;
                                    if (list3 != null && !list3.isEmpty()) {
                                        aVar.g.copySubPkgInfo(aVar.e.get(0));
                                    }
                                    this.a.v().p(aVar.g, null);
                                } else {
                                    this.a.v().o(aVar, null, new pk4(aVar.a, aVar.b + "，本地记录不存在"));
                                }
                            } else if (aVar.d == null && (pMSAppInfo = aVar.g) != null) {
                                pMSAppInfo.appId = aVar.b;
                                this.a.v().p(aVar.g, pMSAppInfo3);
                            } else {
                                uk4 uk4Var = aVar.d;
                                if (uk4Var != null && aVar.g == null) {
                                    aVar.h = true;
                                    aVar.g = pMSAppInfo3;
                                    n(uk4Var, dp4Var);
                                }
                            }
                        }
                    }
                }
            }
            if (dp4Var.n() == 0) {
                this.a.F();
            } else {
                this.a.G(dp4Var);
                gl4.a(pm4Var, arrayList, list, this.a);
            }
            return null;
        }
        return (pk4) invokeL.objValue;
    }
}

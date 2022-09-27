package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.fe4;
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
public class zd4 extends rc4<fe4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zd4(gb4 gb4Var, re4 re4Var) {
        super(gb4Var, re4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gb4Var, re4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((gb4) objArr2[0], (re4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.rc4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkglist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rc4
    /* renamed from: v */
    public boolean f(fe4 fe4Var) {
        InterceptResult invokeL;
        List<fe4.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fe4Var)) == null) {
            if (fe4Var == null || (list = fe4Var.a) == null || list.isEmpty()) {
                return false;
            }
            for (fe4.a aVar : fe4Var.a) {
                if (TextUtils.isEmpty(aVar.b)) {
                    return false;
                }
                if (aVar.a == 0) {
                    if (aVar.d == null && aVar.g == null && aVar.e == null) {
                        return false;
                    }
                    kc4 kc4Var = aVar.d;
                    if (kc4Var != null && !kc4Var.a()) {
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
    @Override // com.baidu.tieba.rc4
    /* renamed from: w */
    public fc4 t(fe4 fe4Var) {
        InterceptResult invokeL;
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fe4Var)) == null) {
            this.a.E();
            tg4 tg4Var = new tg4();
            Map<String, PMSAppInfo> v = ib4.i().v();
            ArrayList arrayList = new ArrayList();
            List<mc4> list = null;
            for (fe4.a aVar : fe4Var.a) {
                if (aVar != null) {
                    int i = aVar.a;
                    if (i != 0) {
                        this.a.v().o(aVar, v.get(aVar.b), new fc4(i, aVar.b + "，Server返回错误"));
                    } else {
                        List<lc4> list2 = aVar.e;
                        if (list2 != null) {
                            for (lc4 lc4Var : list2) {
                                if (lc4Var != null) {
                                    lc4Var.o = aVar.b;
                                }
                            }
                            p(aVar.e, tg4Var);
                            arrayList.addAll(aVar.e);
                        }
                        list = g(aVar.f);
                        if (list != null) {
                            n(list, tg4Var);
                        }
                        if (aVar.d != null && (pMSAppInfo2 = aVar.g) != null) {
                            pMSAppInfo2.appId = aVar.b;
                            this.a.v().l(aVar.g);
                            o(aVar.d, tg4Var);
                        } else {
                            PMSAppInfo pMSAppInfo3 = v.get(aVar.b);
                            if (pMSAppInfo3 == null) {
                                PMSAppInfo pMSAppInfo4 = aVar.g;
                                if (pMSAppInfo4 != null) {
                                    pMSAppInfo4.appId = aVar.b;
                                    List<lc4> list3 = aVar.e;
                                    if (list3 != null && !list3.isEmpty()) {
                                        aVar.g.copySubPkgInfo(aVar.e.get(0));
                                    }
                                    this.a.v().p(aVar.g, null);
                                } else {
                                    this.a.v().o(aVar, null, new fc4(aVar.a, aVar.b + "，本地记录不存在"));
                                }
                            } else if (aVar.d == null && (pMSAppInfo = aVar.g) != null) {
                                pMSAppInfo.appId = aVar.b;
                                this.a.v().p(aVar.g, pMSAppInfo3);
                            } else {
                                kc4 kc4Var = aVar.d;
                                if (kc4Var != null && aVar.g == null) {
                                    aVar.h = true;
                                    aVar.g = pMSAppInfo3;
                                    o(kc4Var, tg4Var);
                                }
                            }
                        }
                    }
                }
            }
            if (tg4Var.n() == 0) {
                this.a.F();
            } else {
                this.a.G(tg4Var);
                wc4.a(fe4Var, arrayList, list, this.a);
            }
            return null;
        }
        return (fc4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rc4
    /* renamed from: x */
    public fe4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? sg4.f(jSONObject) : (fe4) invokeL.objValue;
    }
}

package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.bm4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class vl4 extends nk4<bm4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.nk4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkglist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vl4(cj4 cj4Var, nm4 nm4Var) {
        super(cj4Var, nm4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cj4Var, nm4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((cj4) objArr2[0], (nm4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nk4
    /* renamed from: w */
    public bm4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            return oo4.f(jSONObject);
        }
        return (bm4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nk4
    /* renamed from: u */
    public boolean e(bm4 bm4Var) {
        InterceptResult invokeL;
        List<bm4.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bm4Var)) == null) {
            if (bm4Var == null || (list = bm4Var.a) == null || list.isEmpty()) {
                return false;
            }
            for (bm4.a aVar : bm4Var.a) {
                if (TextUtils.isEmpty(aVar.b)) {
                    return false;
                }
                if (aVar.a == 0) {
                    if (aVar.d == null && aVar.g == null && aVar.e == null) {
                        return false;
                    }
                    gk4 gk4Var = aVar.d;
                    if (gk4Var != null && !gk4Var.a()) {
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
    @Override // com.baidu.tieba.nk4
    /* renamed from: v */
    public bk4 s(bm4 bm4Var) {
        InterceptResult invokeL;
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bm4Var)) == null) {
            this.a.E();
            po4 po4Var = new po4();
            Map<String, PMSAppInfo> v = ej4.i().v();
            ArrayList arrayList = new ArrayList();
            List<ik4> list = null;
            for (bm4.a aVar : bm4Var.a) {
                if (aVar != null) {
                    int i = aVar.a;
                    if (i != 0) {
                        this.a.v().o(aVar, v.get(aVar.b), new bk4(i, aVar.b + "，Server返回错误"));
                    } else {
                        List<hk4> list2 = aVar.e;
                        if (list2 != null) {
                            for (hk4 hk4Var : list2) {
                                if (hk4Var != null) {
                                    hk4Var.o = aVar.b;
                                }
                            }
                            o(aVar.e, po4Var);
                            arrayList.addAll(aVar.e);
                        }
                        list = f(aVar.f);
                        if (list != null) {
                            m(list, po4Var);
                        }
                        if (aVar.d != null && (pMSAppInfo2 = aVar.g) != null) {
                            pMSAppInfo2.appId = aVar.b;
                            this.a.v().l(aVar.g);
                            n(aVar.d, po4Var);
                        } else {
                            PMSAppInfo pMSAppInfo3 = v.get(aVar.b);
                            if (pMSAppInfo3 == null) {
                                PMSAppInfo pMSAppInfo4 = aVar.g;
                                if (pMSAppInfo4 != null) {
                                    pMSAppInfo4.appId = aVar.b;
                                    List<hk4> list3 = aVar.e;
                                    if (list3 != null && !list3.isEmpty()) {
                                        aVar.g.copySubPkgInfo(aVar.e.get(0));
                                    }
                                    this.a.v().p(aVar.g, null);
                                } else {
                                    this.a.v().o(aVar, null, new bk4(aVar.a, aVar.b + "，本地记录不存在"));
                                }
                            } else if (aVar.d == null && (pMSAppInfo = aVar.g) != null) {
                                pMSAppInfo.appId = aVar.b;
                                this.a.v().p(aVar.g, pMSAppInfo3);
                            } else {
                                gk4 gk4Var = aVar.d;
                                if (gk4Var != null && aVar.g == null) {
                                    aVar.h = true;
                                    aVar.g = pMSAppInfo3;
                                    n(gk4Var, po4Var);
                                }
                            }
                        }
                    }
                }
            }
            if (po4Var.n() == 0) {
                this.a.F();
            } else {
                this.a.G(po4Var);
                sk4.a(bm4Var, arrayList, list, this.a);
            }
            return null;
        }
        return (bk4) invokeL.objValue;
    }
}

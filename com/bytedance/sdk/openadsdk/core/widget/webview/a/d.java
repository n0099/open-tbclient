package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.e.g;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.executor.GetExecutor;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.v;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j.i;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f30941a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f30942b;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30942b = new AtomicBoolean(false);
    }

    private JSONObject c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            GetExecutor getExecutor = com.bytedance.sdk.openadsdk.l.e.b().c().getGetExecutor();
            getExecutor.setUrl(str);
            NetResponse execute = getExecutor.execute();
            if (execute != null) {
                try {
                    if (!execute.isSuccess() || execute.getBody() == null) {
                        return null;
                    }
                    return new JSONObject(execute.getBody());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public Set<String> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return c.a().b(str);
        }
        return (Set) invokeL.objValue;
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f30941a == null) {
                synchronized (d.class) {
                    if (f30941a == null) {
                        f30941a = new d();
                    }
                }
            }
            return f30941a;
        }
        return (d) invokeV.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || o.h() == null) {
            return;
        }
        int F = o.h().F();
        if (F <= 0) {
            F = 100;
        }
        List<v> b2 = c.a().b();
        if (!b2.isEmpty() && F < b2.size()) {
            TreeMap treeMap = new TreeMap();
            for (v vVar : b2) {
                treeMap.put(vVar.g(), vVar);
            }
            HashSet hashSet = new HashSet();
            int size = (int) (b2.size() - (F * 0.75f));
            int i2 = 0;
            for (Map.Entry entry : treeMap.entrySet()) {
                if (entry != null && i2 < size) {
                    i2++;
                    ((Long) entry.getKey()).longValue();
                    v vVar2 = (v) entry.getValue();
                    if (vVar2 != null) {
                        hashSet.add(vVar2.b());
                    }
                }
            }
            a(hashSet);
            this.f30942b.set(false);
            return;
        }
        j.b("TmplDiffManager", "end doCheckAndDeleteTask maxTplCnt,local size" + F + ", 目前存储的模版的个数 " + b2.size());
    }

    public v a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return c.a().a(str);
        }
        return (v) invokeL.objValue;
    }

    public void a(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar) == null) || mVar == null || mVar.P() == null) {
            return;
        }
        String b2 = mVar.P().b();
        String d2 = mVar.P().d();
        String c2 = mVar.P().c();
        String e2 = mVar.P().e();
        String a2 = mVar.P().a();
        int d3 = com.bytedance.sdk.openadsdk.r.o.d(mVar.ao());
        i e3 = i.a().a(b2).b(c2).c(d2).d(e2).e(a2);
        j.b("TmplDiffManager", "从物料中获取模版信息进行保存 rit " + d3);
        a(e3, d3 + "");
    }

    public void b(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, mVar) == null) || mVar == null || mVar.Q() == null) {
            return;
        }
        String b2 = mVar.Q().b();
        String d2 = mVar.Q().d();
        String c2 = mVar.Q().c();
        String e2 = mVar.Q().e();
        String a2 = mVar.Q().a();
        int d3 = com.bytedance.sdk.openadsdk.r.o.d(mVar.ao());
        i e3 = i.a().a(b2).b(c2).c(d2).d(e2).e(a2);
        a(e3, d3 + "");
    }

    public void a(i iVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, iVar, str) == null) {
            if (iVar == null) {
                j.f("TmplDiffManager", "saveTemplate error: tplInfo == null");
                return;
            }
            String str2 = iVar.f30315a;
            String str3 = iVar.f30317c;
            String str4 = iVar.f30316b;
            String str5 = iVar.f30318d;
            String str6 = iVar.f30319e;
            if (TextUtils.isEmpty(str)) {
                str = h.d().h();
            }
            String str7 = str;
            if (TextUtils.isEmpty(str2)) {
                j.f("TmplDiffManager", "saveTemplate error:tmpId is empty");
            } else {
                com.bytedance.sdk.component.e.e.a(new g(this, "saveTemplate", str2, str3, str4, str5, str6, str7) { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f30943a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f30944b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ String f30945c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f30946d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ String f30947e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ String f30948f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ d f30949g;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r8, str2, str3, str4, str5, str6, str7};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((String) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f30949g = this;
                        this.f30943a = str2;
                        this.f30944b = str3;
                        this.f30945c = str4;
                        this.f30946d = str5;
                        this.f30947e = str6;
                        this.f30948f = str7;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f30949g.a(this.f30943a, this.f30944b, this.f30945c, this.f30946d, this.f30947e, this.f30948f);
                        }
                    }
                }, 10);
            }
        }
    }

    private void b(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            c.a().a(new v().a(str).b(str2).c(str3).d(str4).e(str5).f(str6).a(Long.valueOf(System.currentTimeMillis())));
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            synchronized (this) {
                if (a(str) != null) {
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                        b(str6, str, str3, str2, str4, str5);
                    }
                    return;
                } else if (TextUtils.isEmpty(str4)) {
                    a(str2, str6, str);
                } else if (TextUtils.isEmpty(str3)) {
                    a(str2, str6, str);
                } else {
                    b(str6, str, str3, str2, str4, str5);
                }
                boolean b2 = f.b(str5);
                if (!a.e() || b2) {
                    b.a().a(true);
                }
            }
        }
    }

    private void a(String str, String str2, String str3) {
        JSONObject c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, this, str, str2, str3) == null) || TextUtils.isEmpty(str) || (c2 = c(str)) == null) {
            return;
        }
        String optString = c2.optString(PackageTable.MD5);
        String optString2 = c2.optString("version");
        String optString3 = c2.optString("data");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
            return;
        }
        v a2 = new v().a(str2).b(str3).c(optString).d(str).e(optString3).f(optString2).a(Long.valueOf(System.currentTimeMillis()));
        c.a().a(a2);
        b();
        if (f.b(optString2)) {
            a2.f(optString2);
            b.a().a(true);
        }
    }

    public void a(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, set) == null) {
            try {
                c.a().a(set);
            } catch (Throwable th) {
                j.b("TmplDiffManager", th.getMessage());
            }
        }
    }
}

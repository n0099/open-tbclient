package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.core.e.l;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.j.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.q.c;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e implements com.bytedance.sdk.openadsdk.downloadnew.core.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f68001a;

    /* renamed from: b  reason: collision with root package name */
    public String f68002b;

    /* renamed from: c  reason: collision with root package name */
    public c.p.a.a.a.d.d f68003c;

    /* renamed from: d  reason: collision with root package name */
    public final m f68004d;

    /* renamed from: e  reason: collision with root package name */
    public String f68005e;

    /* renamed from: f  reason: collision with root package name */
    public c.p.a.a.a.d.b f68006f;

    /* renamed from: g  reason: collision with root package name */
    public c.p.a.a.a.d.c f68007g;

    public e(Context context, String str, m mVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, mVar, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68001a = new WeakReference<>(context);
        this.f68004d = mVar;
        this.f68005e = str2;
        this.f68002b = str;
        this.f68003c = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(str, str2, mVar, null).h();
        this.f68006f = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f68004d).d();
        this.f68007g = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f68004d, this.f68005e).d();
        a();
    }

    private Context k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            WeakReference<Context> weakReference = this.f68001a;
            return (weakReference == null || weakReference.get() == null) ? o.a() : this.f68001a.get();
        }
        return (Context) invokeV.objValue;
    }

    private synchronized void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            synchronized (this) {
                g.d().g(this.f68002b, hashCode());
            }
        }
    }

    private synchronized void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            synchronized (this) {
                if (n()) {
                    g.d().p().b(k(), this.f68003c.d(), this.f68003c.u(), null, hashCode());
                } else {
                    g.d().e(k(), hashCode(), null, this.f68003c);
                }
            }
        }
    }

    private boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            h h2 = o.h();
            if (h2 != null) {
                return h2.r();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("download_type", 3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (n()) {
                g.d().p().a(k(), null, true, this.f68003c, this.f68007g, this.f68006f, null, hashCode());
            } else {
                g.d().h(this.f68002b, this.f68003c.d(), 2, this.f68007g, this.f68006f);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(int i2, a.InterfaceC1922a interfaceC1922a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, interfaceC1922a) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tTAppDownloadListener) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, tTAppDownloadListener, z) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            l();
            WeakReference<Context> weakReference = this.f68001a;
            if (weakReference != null) {
                weakReference.clear();
                this.f68001a = null;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (a(this.f68004d)) {
                b(this.f68004d);
            } else {
                p();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            a(0L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            m();
        }
    }

    private boolean a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, mVar)) == null) {
            if (mVar == null) {
                return true;
            }
            return !(mVar.D() == 0);
        }
        return invokeL.booleanValue;
    }

    private void b(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, mVar) == null) || mVar == null) {
            return;
        }
        String U = mVar.U();
        String a2 = f.a(mVar);
        l Y = mVar.Y();
        String a3 = Y != null ? Y.a() : "";
        boolean z = mVar.X() == 4;
        com.bytedance.sdk.openadsdk.e.d.b(o.a(), mVar, this.f68005e, "pop_up", o());
        com.bytedance.sdk.openadsdk.q.c.a(k(), mVar.ak(), U, new c.a(this, mVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ m f68008a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f68009b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, mVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68009b = this;
                this.f68008a = mVar;
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f68009b.p();
                    com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f68008a, this.f68009b.f68005e, "pop_up_download", this.f68009b.o());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f68008a, this.f68009b.f68005e, "pop_up_cancel", this.f68009b.o());
                }
            }
        }, a2, a3, z);
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            g.d().j(this.f68002b, true);
        }
    }
}

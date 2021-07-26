package com.bytedance.sdk.openadsdk.core.dynamic.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidgetImp;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.openadsdk.core.e.k;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.p;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.o;
import com.bytedance.sdk.openadsdk.q.q;
import com.bytedance.sdk.openadsdk.theme.ThemeStatusBroadcastReceiver;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a implements com.bytedance.sdk.openadsdk.core.nativeexpress.a.b<DynamicRootView>, o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f30026a;

    /* renamed from: b  reason: collision with root package name */
    public String f30027b;

    /* renamed from: c  reason: collision with root package name */
    public int f30028c;

    /* renamed from: d  reason: collision with root package name */
    public String f30029d;

    /* renamed from: e  reason: collision with root package name */
    public m f30030e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f30031f;

    /* renamed from: g  reason: collision with root package name */
    public DynamicRootView f30032g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.dynamic.c.a f30033h;

    /* renamed from: i  reason: collision with root package name */
    public Context f30034i;
    public com.bytedance.sdk.openadsdk.core.nativeexpress.m j;
    public n k;

    public a(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, themeStatusBroadcastReceiver};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30034i = context;
        this.f30032g = new DynamicRootView(context, themeStatusBroadcastReceiver);
        this.f30033h = new com.bytedance.sdk.openadsdk.core.dynamic.c.a(this.f30034i);
        this.f30032g.setRenderListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f30033h.a(new com.bytedance.sdk.openadsdk.core.dynamic.d.b(this) { // from class: com.bytedance.sdk.openadsdk.core.dynamic.a.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f30036a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f30036a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.dynamic.d.b
                public void a(f fVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, fVar) == null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable(this, fVar) { // from class: com.bytedance.sdk.openadsdk.core.dynamic.a.a.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ f f30037a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f30038b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, fVar};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f30038b = this;
                                this.f30037a = fVar;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f30038b.f30036a.a(this.f30037a);
                                }
                            }
                        });
                    }
                }
            });
            this.f30033h.b(f());
        }
    }

    private String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f30031f != null) {
                    this.f30031f.put(com.alipay.sdk.sys.a.j, g());
                }
                jSONObject.put("templateInfo", this.f30031f);
                jSONObject.put("adInfo", new com.bytedance.sdk.openadsdk.core.dynamic.b.a(this.f30030e).a());
                jSONObject.put(DI.APP_INFO_NAME, new com.bytedance.sdk.openadsdk.core.dynamic.b.b().a());
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    private JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (com.bytedance.sdk.openadsdk.core.o.h() != null) {
                try {
                    int d2 = q.d(this.f30027b);
                    int g2 = com.bytedance.sdk.openadsdk.core.o.h().g(String.valueOf(d2));
                    boolean b2 = com.bytedance.sdk.openadsdk.core.o.h().b(String.valueOf(d2));
                    jSONObject.put("voice_control", com.bytedance.sdk.openadsdk.core.o.h().c(d2));
                    jSONObject.put("rv_skip_time", g2);
                    jSONObject.put("fv_skip_show", b2);
                    jSONObject.put("show_dislike", this.f30030e != null && this.f30030e.aM());
                    jSONObject.put("video_adaptation", this.f30030e != null ? this.f30030e.i() : 0);
                } catch (Exception unused) {
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    private boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            DynamicRootView dynamicRootView = this.f30032g;
            return (dynamicRootView == null || dynamicRootView.getChildCount() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public a b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f30027b = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f30029d = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public DynamicRootView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f30032g : (DynamicRootView) invokeV.objValue;
    }

    public a a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar)) == null) {
            this.f30030e = mVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f30026a = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            this.f30028c = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            this.f30031f = jSONObject;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public void a(com.bytedance.sdk.openadsdk.core.nativeexpress.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mVar) == null) {
            this.j = mVar;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                e();
            } else {
                l.d().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.dynamic.a.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f30035a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f30035a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f30035a.e();
                        }
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.b
    /* renamed from: a */
    public DynamicRootView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c() : (DynamicRootView) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, fVar) == null) {
            if (fVar == null) {
                this.f30032g.b();
                return;
            }
            try {
                DynamicBaseWidgetImp dynamicBaseWidgetImp = new DynamicBaseWidgetImp(this.f30034i, this.f30032g, fVar);
                a(fVar, dynamicBaseWidgetImp);
                this.f30032g.setDynamicBaseWidget(dynamicBaseWidgetImp);
                this.f30032g.a();
            } catch (Exception unused) {
                this.f30032g.b();
            }
        }
    }

    private void a(f fVar, DynamicBaseWidget dynamicBaseWidget) {
        List<f> f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, fVar, dynamicBaseWidget) == null) || fVar == null || dynamicBaseWidget == null || (f2 = fVar.f()) == null || f2.size() <= 0) {
            return;
        }
        for (f fVar2 : fVar.f()) {
            if (fVar2 != null) {
                DynamicBaseWidget a2 = b.a(this.f30034i, this.f30032g, fVar2);
                a(fVar2, a2);
                dynamicBaseWidget.a(a2);
            }
        }
    }

    public void a(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, nVar) == null) {
            this.k = nVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.o
    public void a(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pVar) == null) {
            if (pVar.b() && h()) {
                this.f30032g.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.j.a(d(), pVar);
                return;
            }
            this.j.a(pVar.i());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.o
    public void a(int i2, k kVar) {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048581, this, i2, kVar) == null) || (nVar = this.k) == null) {
            return;
        }
        nVar.a(i2, kVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.o
    public void a(int i2, k kVar, boolean z) {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), kVar, Boolean.valueOf(z)}) == null) || (nVar = this.k) == null) {
            return;
        }
        nVar.a(i2, kVar, z);
    }
}

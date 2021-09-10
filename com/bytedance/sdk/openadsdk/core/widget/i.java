package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.e.x;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.q.s;
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f67404a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f67405b;

    /* renamed from: c  reason: collision with root package name */
    public Context f67406c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.d f67407d;

    /* renamed from: e  reason: collision with root package name */
    public b f67408e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67409f;

    /* renamed from: g  reason: collision with root package name */
    public x f67410g;

    /* renamed from: h  reason: collision with root package name */
    public ViewStub f67411h;

    /* renamed from: i  reason: collision with root package name */
    public View f67412i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f67414a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f67415b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f67416c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ a[] f67417d;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1655137755, "Lcom/bytedance/sdk/openadsdk/core/widget/i$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1655137755, "Lcom/bytedance/sdk/openadsdk/core/widget/i$a;");
                    return;
                }
            }
            f67414a = new a("PAUSE_VIDEO", 0);
            f67415b = new a("RELEASE_VIDEO", 1);
            a aVar = new a("START_VIDEO", 2);
            f67416c = aVar;
            f67417d = new a[]{f67414a, f67415b, aVar};
        }

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f67417d.clone() : (a[]) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        boolean h();

        void j();
    }

    public i() {
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
        this.f67409f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.f67406c == null) {
            return;
        }
        d();
    }

    private void d() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (view = this.f67404a) == null) {
            return;
        }
        view.setVisibility(8);
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f67410g = null;
        }
    }

    public void a(Context context, View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, view) == null) && context != null && (view instanceof ViewGroup)) {
            this.f67412i = view;
            this.f67406c = o.a().getApplicationContext();
            this.f67411h = (ViewStub) LayoutInflater.from(context).inflate(t.f(context, "tt_video_traffic_tip"), (ViewGroup) view, true).findViewById(t.e(context, "tt_video_traffic_tip_layout_viewStub"));
        }
    }

    private void a(Context context, View view, boolean z) {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65537, this, context, view, z) == null) || context == null || view == null || (viewStub = this.f67411h) == null || viewStub.getParent() == null || this.f67404a != null) {
            return;
        }
        this.f67411h.inflate();
        this.f67404a = view.findViewById(t.e(context, "tt_video_traffic_tip_layout"));
        this.f67405b = (TextView) view.findViewById(t.e(context, "tt_video_traffic_tip_tv"));
        View findViewById = view.findViewById(t.e(context, "tt_video_traffic_continue_play_btn"));
        if (z) {
            findViewById.setClickable(true);
            findViewById.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.i.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ i f67413a;

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
                    this.f67413a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.f67413a.c();
                        if (this.f67413a.f67407d != null) {
                            this.f67413a.f67407d.a(a.f67416c, (String) null);
                        }
                    }
                }
            });
            return;
        }
        findViewById.setOnClickListener(null);
        findViewById.setClickable(false);
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.d dVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, bVar) == null) {
            this.f67408e = bVar;
            this.f67407d = dVar;
        }
    }

    public boolean a(int i2, x xVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), xVar, Boolean.valueOf(z)})) == null) {
            Context context = this.f67406c;
            if (context == null || xVar == null) {
                return true;
            }
            a(context, this.f67412i, z);
            this.f67410g = xVar;
            if (i2 == 1 || i2 == 2) {
                return a(i2);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    private boolean a(int i2) {
        InterceptResult invokeI;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) {
            if (a() || this.f67409f) {
                return true;
            }
            if (this.f67407d != null && (bVar = this.f67408e) != null) {
                if (bVar.h()) {
                    this.f67407d.e(null, null);
                }
                this.f67407d.a(a.f67414a, (String) null);
            }
            a(this.f67410g, true);
            return false;
        }
        return invokeI.booleanValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                b();
            }
            d();
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View view = this.f67404a;
            return view != null && view.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    private void a(x xVar, boolean z) {
        View view;
        String str;
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65538, this, xVar, z) == null) || xVar == null || (view = this.f67404a) == null || this.f67406c == null || view.getVisibility() == 0) {
            return;
        }
        b bVar = this.f67408e;
        if (bVar != null) {
            bVar.j();
        }
        int ceil = (int) Math.ceil((xVar.d() * 1.0d) / 1048576.0d);
        if (z) {
            str = t.a(this.f67406c, "tt_video_without_wifi_tips") + ceil + t.a(this.f67406c, "tt_video_bytesize_MB") + t.a(this.f67406c, "tt_video_bytesize");
        } else {
            str = t.a(this.f67406c, "tt_video_without_wifi_tips") + t.a(this.f67406c, "tt_video_bytesize");
        }
        s.a(this.f67404a, 0);
        s.a(this.f67405b, (CharSequence) str);
        if (!s.d(this.f67404a) || (view2 = this.f67404a) == null) {
            return;
        }
        view2.bringToFront();
    }
}

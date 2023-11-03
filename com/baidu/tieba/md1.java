package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.poly.widget.PopupWindow;
import com.baidu.poly.widget.toast.ToastLoadingView;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class md1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile md1 e;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public ToastLoadingView b;
    public PopupWindow c;
    public PopupWindow d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947968719, "Lcom/baidu/tieba/md1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947968719, "Lcom/baidu/tieba/md1;");
        }
    }

    /* loaded from: classes7.dex */
    public class a extends ob1<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ Bundle d;
        public final /* synthetic */ md1 e;

        public a(md1 md1Var, ChannelListView channelListView, boolean z, Context context, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md1Var, channelListView, Boolean.valueOf(z), context, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = md1Var;
            this.a = channelListView;
            this.b = z;
            this.c = context;
            this.d = bundle;
        }

        @Override // com.baidu.tieba.ob1
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                this.e.f("2", str);
                this.a.U(this.c.getString(R.string.obfuscated_res_0x7f0f190f), null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ob1
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                int optInt = jSONObject.optInt("payStatus", 3);
                this.e.f("1", String.valueOf(optInt));
                if (optInt == 2) {
                    this.a.d0(0, dd1.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")), "0");
                } else if (!this.b) {
                    this.e.k(this.c, this.a);
                } else {
                    this.e.j(this.c, this.d, this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;
        public final /* synthetic */ md1 b;

        public b(md1 md1Var, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md1Var, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = md1Var;
            this.a = channelListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.c.n();
                uc1 uc1Var = new uc1("103");
                uc1Var.b("1");
                xc1.e(uc1Var);
                this.a.d0(3, "pay failed , click choose window", "0");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ ChannelListView c;
        public final /* synthetic */ md1 d;

        public c(md1 md1Var, Context context, Bundle bundle, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md1Var, context, bundle, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = md1Var;
            this.a = context;
            this.b = bundle;
            this.c = channelListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.d.c.n();
                uc1 uc1Var = new uc1("103");
                uc1Var.b("2");
                xc1.e(uc1Var);
                this.d.i(this.a, this.b, this.c, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ md1 a;

        public d(md1 md1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = md1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d != null && this.a.d.r()) {
                this.a.d.n();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public e(md1 md1Var, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md1Var, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // com.baidu.poly.widget.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d0(3, "pay failed , click error window", "0");
            }
        }
    }

    public md1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static md1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (md1.class) {
                    if (e == null) {
                        e = new md1();
                    }
                }
            }
            return e;
        }
        return (md1) invokeV.objValue;
    }

    public final View g(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            if (activity != null && activity.getWindow() != null) {
                return activity.getWindow().getDecorView().findViewById(16908290);
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public final void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            de1.b(this.b);
            try {
                if (this.a == 0) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.a);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                uc1 uc1Var = new uc1("105");
                uc1Var.c(jSONObject);
                xc1.e(uc1Var);
            } catch (JSONException e2) {
                if (gd1.d) {
                    e2.printStackTrace();
                }
            } finally {
                this.a = 0L;
            }
        }
    }

    public final void k(Context context, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, channelListView) == null) {
            View inflate = View.inflate(channelListView.getContext(), R.layout.obfuscated_res_0x7f0d0250, null);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d65)).setText(R.string.obfuscated_res_0x7f0f0fa7);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d64)).setText(R.string.obfuscated_res_0x7f0f0fa8);
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
            this.d = popupWindow;
            popupWindow.v(false);
            this.d.A(false);
            this.d.u(new ColorDrawable(0));
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d5c)).setOnClickListener(new d(this));
            this.d.z(new e(this, channelListView));
            this.d.C(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        }
    }

    public void i(Context context, Bundle bundle, ChannelListView channelListView, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, bundle, channelListView, Boolean.valueOf(z)}) == null) && context != null && bundle != null && channelListView != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.b = de1.c((ViewGroup) g((Activity) context), layoutParams, null, -1L);
            this.a = System.currentTimeMillis();
            wb1.j().m(bundle, new a(this, channelListView, z, context, bundle));
        }
    }

    public final void j(Context context, Bundle bundle, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, bundle, channelListView) == null) {
            View inflate = View.inflate(channelListView.getContext(), R.layout.obfuscated_res_0x7f0d0785, null);
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
            this.c = popupWindow;
            popupWindow.v(false);
            this.c.A(false);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0904b9)).setOnClickListener(new b(this, channelListView));
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0904b8)).setOnClickListener(new c(this, context, bundle, channelListView));
            this.c.C(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
            xc1.e(new uc1(WorkPostNotifyFlutterData.FAIL_POST));
        }
    }
}

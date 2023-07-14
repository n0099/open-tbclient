package com.baidu.tieba;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.poly.widget.WechatSignAutoRenewActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class og1 implements ij1 {
    public static /* synthetic */ Interceptable $ic;
    public static og1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public boolean b;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og1 this$0;

        public b(og1 og1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = og1Var;
        }

        public /* synthetic */ b(og1 og1Var, a aVar) {
            this(og1Var);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && this.this$0.b) {
                this.this$0.b = false;
                try {
                    int intExtra = intent.getIntExtra("code", 0);
                    Intent intent2 = new Intent(PolyActivity.g, WechatSignAutoRenewActivity.class);
                    intent2.putExtra("code", intExtra);
                    PolyActivity.g.startActivity(intent2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public og1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
    }

    public static og1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (og1.class) {
                    if (c == null) {
                        c = new og1();
                    }
                }
            }
            return c;
        }
        return (og1) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new b(this, null);
            PolyActivity.g.getApplicationContext().registerReceiver(this.a, new IntentFilter("com_baidu_poly_cashier_wechat_sign_auto_renew_receiver"));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a != null) {
            try {
                PolyActivity.g.getApplicationContext().unregisterReceiver(this.a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ij1
    public void a(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, str2) == null) {
            ui1.b("WECHAT signWechatAutoRenew appId=" + str);
            vg1 a2 = lg1.a();
            if (a2 == null) {
                return;
            }
            if (!a2.b(activity)) {
                sj1.f(activity, "您没有安装微信，请选择其他支付方式");
                activity.finish();
                return;
            }
            this.b = true;
            f();
            e();
            a2.a(activity, str, str2);
            activity.finish();
        }
    }
}

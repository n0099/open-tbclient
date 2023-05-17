package com.baidu.ufosdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ui.FeedbackListActivity;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class x0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ FeedbackListActivity d;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x0 a;

        public a(x0 x0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                x0 x0Var = this.a;
                Context context = x0Var.a;
                String str = x0Var.b;
                String str2 = x0Var.c;
                String str3 = s1.j;
                HashMap hashMap = new HashMap();
                e0 a = e0.a(context);
                hashMap.put("clientid", a.a);
                if (str2 != null && str2.length() > 0) {
                    hashMap.put("appid", str2);
                } else {
                    hashMap.put("appid", a.b);
                }
                hashMap.put("devid", a.c);
                hashMap.put("uid", b.c());
                hashMap.put(DpStatConstants.KEY_USER_ID, b.c());
                hashMap.put("username", b.b());
                hashMap.put("sdkvn", "4.1.9.1");
                hashMap.put("id", str);
                String b = b.b(b.a(hashMap));
                try {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("sdk_encrypt", b);
                    String a2 = d0.a(str3, d0.a(hashMap2));
                    if (!TextUtils.isEmpty(a2) && ((Integer) new JSONObject(b.a(a2)).get("errno")).intValue() != 0) {
                        Intent intent = new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss");
                        intent.setPackage(c.a());
                        context.sendBroadcast(intent);
                        b.a("删除失败，请稍后重试。", 1);
                    }
                } catch (Exception unused) {
                    Intent intent2 = new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss");
                    intent2.setPackage(c.a());
                    context.sendBroadcast(intent2);
                    b.a("删除失败，请稍后重试。", 1);
                }
            }
        }
    }

    public x0(FeedbackListActivity feedbackListActivity, Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackListActivity, context, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = feedbackListActivity;
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            new Thread(new a(this)).start();
            if (this.d.o.isShowing()) {
                this.d.o.dismiss();
            }
        }
    }
}

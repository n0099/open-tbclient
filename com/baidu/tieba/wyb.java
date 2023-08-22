package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.state.StateManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.open.activity.AssistActivity;
import com.yy.open.activity.BridgeActivity;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class wyb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<c> a;
    public Handler b;
    public Context c;
    public String d;
    public azb e;

    public final void h(int i, Intent intent, tyb tybVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), intent, tybVar, Long.valueOf(j)}) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ tyb b;
        public final /* synthetic */ Intent c;
        public final /* synthetic */ long d;
        public final /* synthetic */ wyb e;

        public a(wyb wybVar, int i, tyb tybVar, Intent intent, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wybVar, Integer.valueOf(i), tybVar, intent, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = wybVar;
            this.a = i;
            this.b = tybVar;
            this.c = intent;
            this.d = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a == 0) {
                        this.b.onCancel();
                        return;
                    }
                    String stringExtra = this.c.getStringExtra("resjson");
                    this.e.e.a(stringExtra);
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    if (jSONObject.has("resCode") && jSONObject.has("resMsg")) {
                        String optString = jSONObject.optString("resMsg");
                        int optInt = jSONObject.optInt("resCode");
                        if (optInt != 1000006 && optInt != 1290001) {
                            optInt = this.a;
                            this.e.f(this.c, this.b, this.d, optInt, optString);
                            return;
                        }
                        Log.e("chenqiang", "resCode:" + optInt);
                        this.e.f(this.c, this.b, this.d, optInt, optString);
                        return;
                    }
                    Log.e("chenqiang", "please update yy new version！");
                    if (jSONObject.has("openid") && jSONObject.has("access_code")) {
                        i = this.a;
                        str = "success";
                    } else {
                        str = "handleAuthLoginResult--default error!";
                        i = 444222199;
                    }
                    this.e.f(this.c, this.b, this.d, i, str);
                } catch (Exception unused) {
                    this.b.onError(new uyb(444222105, zyb.h(444222105)));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tyb a;
        public final /* synthetic */ uyb b;

        public b(wyb wybVar, tyb tybVar, uyb uybVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wybVar, tybVar, uybVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tybVar;
            this.b = uybVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onError(this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public tyb a;
        public long b;

        public c(wyb wybVar, tyb tybVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wybVar, tybVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tybVar;
            this.b = System.currentTimeMillis();
        }
    }

    public wyb(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = azb.b();
        this.c = context;
        this.d = str;
        this.a = new SparseArray<>();
        this.b = new Handler(Looper.getMainLooper());
    }

    public final void c(Activity activity, String str, tyb tybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, tybVar) == null) {
            if (yyb.d(activity, BridgeActivity.class) && yyb.d(activity, AssistActivity.class)) {
                int a2 = zyb.a(activity);
                if (a2 != 0) {
                    try {
                        this.a.put(62345, new c(this, tybVar));
                        String c2 = zyb.c(this.c, this.d, str, true);
                        Intent intent = new Intent(activity, AssistActivity.class);
                        intent.putExtra("type", "type_web");
                        intent.putExtra("url", c2);
                        activity.startActivityForResult(intent, 62345);
                        return;
                    } catch (Exception unused) {
                        g(new uyb(a2), tybVar);
                        return;
                    }
                }
                Intent e = zyb.e(activity);
                this.a.put(62345, new c(this, tybVar));
                Bundle d = zyb.d(activity, this.d);
                e.putExtra("action", "action_login");
                e.putExtra(StateManager.KEY_STATE, d);
                i(activity, e, 62345);
                return;
            }
            g(new uyb(3), tybVar);
        }
    }

    public final boolean d(int i, int i2, Intent intent, tyb tybVar) {
        InterceptResult invokeCommon;
        long currentTimeMillis;
        tyb tybVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, tybVar})) == null) {
            if (i != 62345 && i != 62347) {
                return false;
            }
            c cVar = this.a.get(i);
            if (cVar != null) {
                currentTimeMillis = cVar.b;
                tybVar2 = cVar.a;
                this.a.remove(i);
            } else {
                currentTimeMillis = System.currentTimeMillis();
                tybVar2 = tybVar;
            }
            if (i == 62345) {
                e(i2, intent, tybVar2, currentTimeMillis);
                return true;
            } else if (i != 62347) {
                return false;
            } else {
                h(i2, intent, tybVar2, currentTimeMillis);
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final void e(int i, Intent intent, tyb tybVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), intent, tybVar, Long.valueOf(j)}) == null) {
            this.b.postDelayed(new a(this, i, tybVar, intent, j), 10L);
        }
    }

    public final void f(Intent intent, tyb tybVar, long j, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{intent, tybVar, Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            switch (i) {
                case 1000006:
                    tybVar.onError(new uyb(1000006, str));
                    return;
                case 1290001:
                    tybVar.onError(new uyb(1290001, str));
                    return;
                case 444111001:
                    try {
                        String stringExtra = intent.getStringExtra("resjson");
                        this.e.a(stringExtra);
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        jSONObject.optString("openid");
                        jSONObject.optString("uid");
                        jSONObject.optString("access_code");
                        tybVar.onComplete(jSONObject);
                        return;
                    } catch (Exception unused) {
                        tybVar.onError(new uyb(444222105, zyb.h(444222105)));
                        return;
                    }
                case 444111002:
                    tybVar.onCancel();
                    return;
                case 444111003:
                    try {
                        JSONObject jSONObject2 = new JSONObject(intent.getStringExtra("resjson"));
                        if ("1".equals(jSONObject2.optString("appType"))) {
                            jSONObject2.optString("uid");
                        } else {
                            jSONObject2.optString("openid");
                        }
                        tybVar.onComplete(jSONObject2);
                        return;
                    } catch (Exception unused2) {
                        tybVar.onError(new uyb(444222105, zyb.h(444222105)));
                        return;
                    }
                case 444222000:
                    tybVar.onError(new uyb(444222000, str));
                    return;
                case 444222001:
                    tybVar.onError(new uyb(444222001, str));
                    return;
                case 444222002:
                    tybVar.onError(new uyb(444222002, str));
                    return;
                case 444222003:
                    tybVar.onError(new uyb(444222003, str));
                    return;
                case 444222104:
                    tybVar.onError(new uyb(444222104, str));
                    return;
                case 444222105:
                    tybVar.onError(new uyb(444222105, str));
                    return;
                case 444222106:
                    try {
                        new JSONObject(intent.getStringExtra("resjson"));
                        tybVar.onError(new uyb(444222106, str));
                        return;
                    } catch (Exception unused3) {
                        tybVar.onError(new uyb(444222105, zyb.h(444222105)));
                        return;
                    }
                case 444222108:
                    try {
                        tybVar.onComplete(new JSONObject(intent.getStringExtra("resjson")));
                        return;
                    } catch (Exception unused4) {
                        tybVar.onError(new uyb(444222105, zyb.h(444222105)));
                        return;
                    }
                case 444222110:
                    try {
                        new JSONObject(intent.getStringExtra("resjson"));
                        tybVar.onError(new uyb(444222110, str));
                        return;
                    } catch (Exception unused5) {
                        tybVar.onError(new uyb(444222105, zyb.h(444222105)));
                        return;
                    }
                default:
                    Log.e("chenqiang", "default  error");
                    tybVar.onError(new uyb(i, zyb.h(i)));
                    return;
            }
        }
    }

    public final void g(uyb uybVar, tyb tybVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, uybVar, tybVar) == null) && tybVar != null) {
            this.b.postDelayed(new b(this, tybVar, uybVar), 50L);
        }
    }

    public final void i(Activity activity, Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, activity, intent, i) == null) {
            intent.putExtra("request_code", i);
            Intent intent2 = new Intent(activity.getApplicationContext(), BridgeActivity.class);
            intent2.putExtra("intent", intent);
            activity.startActivityForResult(intent2, i);
        }
    }
}

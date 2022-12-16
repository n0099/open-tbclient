package com.baidu.ufosdk;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e0 implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e0 i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public Context e;
    public HandlerThread f;
    public Handler g;
    public int h;

    public e0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("Thread#UFOSignatures");
        this.f = handlerThread;
        handlerThread.start();
        this.g = new Handler(this.f.getLooper(), this);
        this.a = b.b(context);
        this.b = b.a(context);
        this.c = b.c(context);
        this.d = b.d(context);
        if (!TextUtils.isEmpty(this.b)) {
            b.a(this.e, this.b);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || !TextUtils.isEmpty(this.b)) {
            return;
        }
        HandlerThread handlerThread = this.f;
        if (handlerThread != null && !handlerThread.isInterrupted()) {
            String str = "Signature client app : " + z;
            if (z) {
                this.g.removeMessages(1001);
                this.g.sendEmptyMessage(1001);
                return;
            }
            this.g.obtainMessage(1002).sendToTarget();
            return;
        }
        HandlerThread handlerThread2 = new HandlerThread("Thread#UFOSignatures");
        this.f = handlerThread2;
        handlerThread2.start();
        this.g = new Handler(this.f.getLooper(), this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        int i2;
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message)) == null) {
            int i3 = message.what;
            if (i3 == 1001) {
                String str = "current retry count: " + this.h;
                if (!a() && (i2 = this.h) < 5 && (handler = this.g) != null) {
                    handler.sendEmptyMessageDelayed(1001, i2 * 500);
                    this.h++;
                } else {
                    try {
                        if (Build.VERSION.SDK_INT >= 18) {
                            this.f.quitSafely();
                        } else {
                            this.f.quit();
                        }
                        this.f = null;
                        this.g = null;
                        this.h = 0;
                    } catch (Exception unused) {
                    }
                }
            } else if (i3 == 1002) {
                a();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static e0 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (i == null) {
                synchronized (e0.class) {
                    if (i == null) {
                        i = new e0(context);
                    }
                }
            }
            return i;
        }
        return (e0) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a() {
        InterceptResult invokeV;
        String str;
        boolean z;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Context context = this.e;
            e0 a2 = a(context);
            String str2 = s1.g;
            String str3 = "postUrl is " + str2;
            HashMap hashMap = new HashMap();
            hashMap.put("os", "android");
            hashMap.put("clientid", a2.a);
            hashMap.put("appid", a2.b);
            hashMap.put("devid", a2.c);
            b.a();
            hashMap.put("pkgname", b.d.getAppPkgName());
            hashMap.put("cuid", b.f());
            b.a();
            hashMap.put("appvn", b.d.getAppVersion());
            hashMap.put(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, "");
            hashMap.put("model", "");
            hashMap.put("osvn", "");
            hashMap.put("phonetime", String.valueOf(System.currentTimeMillis()));
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            if (i2 == 0 && i3 == 0) {
                str = null;
            } else {
                str = String.valueOf(i2) + "*" + String.valueOf(i3);
            }
            hashMap.put("screensize", str);
            hashMap.put("sdkvn", "4.1.9.1");
            String b = b.b(b.a(hashMap));
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("sdk_encrypt", b);
                a = d0.a(str2, d0.a(hashMap2));
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(a)) {
                JSONObject jSONObject = new JSONObject(b.a(a));
                String str4 = "getAPIKey response is " + jSONObject.toString();
                if (((Integer) jSONObject.get("errno")).intValue() == 0) {
                    String string = jSONObject.getString("clientid");
                    String string2 = jSONObject.getString("appid");
                    String string3 = jSONObject.getString("devid");
                    String string4 = jSONObject.getString(Constants.KEY_PRODUCT_LINE);
                    u1.a(b.i(context).edit().putString("ufo_sg_cd", string));
                    u1.a(b.i(context).edit().putString("ufo_sg_ad", string2));
                    u1.a(b.i(context).edit().putString("ufo_sg_dd", string3));
                    u1.a(b.i(context).edit().putString("ufo_sg_pd", string4));
                    z = true;
                    String str5 = "on cloud signatures: " + z;
                    if (z) {
                        this.a = b.i(this.e).getString("ufo_sg_cd", "");
                        this.b = b.i(this.e).getString("ufo_sg_ad", "");
                        this.c = b.i(this.e).getString("ufo_sg_dd", "");
                        this.d = b.i(this.e).getString("ufo_sg_pd", "");
                    }
                    Context context2 = this.e;
                    Intent intent = new Intent("com.baidu.ufosdk.ACTION_SIGN");
                    intent.setPackage(c.a());
                    intent.putExtra("extra.permission_allow", z);
                    context2.sendBroadcast(intent);
                    b.a(this.e, this.b);
                    return z;
                }
            }
            z = false;
            String str52 = "on cloud signatures: " + z;
            if (z) {
            }
            Context context22 = this.e;
            Intent intent2 = new Intent("com.baidu.ufosdk.ACTION_SIGN");
            intent2.setPackage(c.a());
            intent2.putExtra("extra.permission_allow", z);
            context22.sendBroadcast(intent2);
            b.a(this.e, this.b);
            return z;
        }
        return invokeV.booleanValue;
    }
}

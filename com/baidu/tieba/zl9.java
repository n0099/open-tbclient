package com.baidu.tieba;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.http.GetRequest;
import com.fun.ad.sdk.internal.api.http.RequestParams;
import com.fun.ad.sdk.internal.api.http.Response;
import com.fun.ad.sdk.internal.api.utils.HostAppInfo;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.comm.constants.Constants;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class zl9 {
    public static /* synthetic */ Interceptable $ic;
    public static final eg9 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x011d  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x014c  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(@NonNull Message message) {
            boolean z;
            Response perform;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, message) != null) {
                return;
            }
            int i = message.what;
            boolean z2 = false;
            if (i != 100) {
                if (i != 101) {
                    return;
                }
                eg9 eg9Var = zl9.a;
                synchronized (eg9Var) {
                    LogPrinter.d("new dey", new Object[0]);
                    double a = wg9.a();
                    wg9.b.clear().apply();
                    eg9Var.a.clear();
                    if (a > 0.0d) {
                        ug9.d(ug9.m() + a);
                    }
                }
                Calendar calendar = Calendar.getInstance();
                long timeInMillis = calendar.getTimeInMillis();
                calendar.add(6, 1);
                calendar.set(11, 0);
                calendar.set(12, 0);
                calendar.set(13, 0);
                long timeInMillis2 = calendar.getTimeInMillis() - timeInMillis;
                sendEmptyMessageDelayed(101, timeInMillis2 >= 0 ? timeInMillis2 : 0L);
                return;
            }
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject();
                HostAppInfo.fillReqParams(jSONObject);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.get(next));
                }
            } catch (JSONException unused) {
            }
            try {
                perform = new GetRequest("https://cd.xdplt.com/v2/pr", new RequestParams(hashMap)).perform();
            } catch (IOException | JSONException e) {
                LogPrinter.d("cpm exception:" + e, new Object[0]);
                LogPrinter.e(e);
            }
            if (perform != null && perform.getResponseCode() == 200) {
                JSONObject jSONObject2 = new JSONObject(perform.getContent());
                if (jSONObject2.getInt(Constants.KEYS.RET) != 200) {
                    z = false;
                    if (!z) {
                        int i2 = message.arg1;
                        LogPrinter.d("ad cpm config pull times = %1s", Integer.valueOf(i2));
                        int i3 = i2 == 0 ? 10 : i2 <= 2 ? i2 * 5 * 60 : 3600;
                        Message obtainMessage = obtainMessage(100);
                        obtainMessage.arg1 = i2 + 1;
                        sendMessageDelayed(obtainMessage, i3 * 1000);
                        return;
                    }
                    eg9 eg9Var2 = zl9.a;
                    synchronized (eg9Var2) {
                        eg9Var2.a.clear();
                        try {
                            JSONArray jSONArray = new JSONArray(wg9.a.getString("key_ad_cpmcfg", ""));
                            if (jSONArray.length() >= 1) {
                                double m = ug9.m();
                                double a2 = wg9.a();
                                HashMap hashMap2 = new HashMap();
                                boolean z3 = false;
                                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                                    JSONObject jSONObject3 = jSONArray.getJSONObject(i4);
                                    String string = jSONObject3.getString("aid");
                                    double d = jSONObject3.getDouble("cpm");
                                    LogPrinter.d("update Cpm:" + string, new Object[0]);
                                    hashMap2.put(string, Double.valueOf(d));
                                    int i5 = wg9.a.getInt(string, 0);
                                    LogPrinter.d("need adjust aid count:" + i5, new Object[0]);
                                    if (i5 != 0) {
                                        a2 -= wg9.b(string);
                                        m += i5 * d;
                                        SharedPreferences.Editor remove = wg9.b.remove(string);
                                        remove.remove(string + "_");
                                        z3 = true;
                                    }
                                }
                                eg9Var2.a.putAll(hashMap2);
                                if (z3) {
                                    LogPrinter.d("update totalPrice&totalPriceByBasePrice", new Object[0]);
                                    double d2 = a2 < 0.0d ? 0.0d : a2;
                                    SharedPreferences.Editor editor = wg9.b;
                                    editor.putLong("key_price_by_baseprice", Double.doubleToRawLongBits(d2));
                                    editor.apply();
                                    ug9.d(m);
                                }
                            }
                        } catch (JSONException unused2) {
                            eg9Var2.a.clear();
                        }
                    }
                    Calendar calendar2 = Calendar.getInstance();
                    Random random = new Random();
                    long timeInMillis3 = calendar2.getTimeInMillis();
                    int nextInt = random.nextInt(30);
                    calendar2.set(11, 1);
                    calendar2.set(12, nextInt);
                    Calendar calendar3 = Calendar.getInstance();
                    int i6 = calendar3.get(6);
                    int i7 = calendar3.get(1);
                    calendar3.setTimeInMillis(wg9.a.getLong("key_cpm_update_date", 0L));
                    int i8 = calendar3.get(6);
                    if (i7 == calendar3.get(1) && i6 == i8) {
                        z2 = true;
                    }
                    if (z2) {
                        calendar2.add(6, 1);
                    }
                    long timeInMillis4 = calendar2.getTimeInMillis() - timeInMillis3;
                    sendEmptyMessageDelayed(100, timeInMillis4 < 0 ? 0L : timeInMillis4);
                    return;
                }
                wg9.a.edit().putLong("key_cpm_update_date", Calendar.getInstance().getTimeInMillis()).putString("key_ad_cpmcfg", jSONObject2.getJSONObject("data").getJSONArray("cpm").toString()).apply();
                z = true;
                if (!z) {
                }
            }
            LogPrinter.d("cpm fail:", new Object[0]);
            z = false;
            if (!z) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948363938, "Lcom/baidu/tieba/zl9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948363938, "Lcom/baidu/tieba/zl9;");
                return;
            }
        }
        a = new eg9();
        HandlerThread handlerThread = new HandlerThread("pull_pid_cpm");
        handlerThread.start();
        new a(handlerThread.getLooper());
    }
}

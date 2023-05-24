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
public class oxa {
    public static /* synthetic */ Interceptable $ic;
    public static final tra a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948049009, "Lcom/baidu/tieba/oxa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948049009, "Lcom/baidu/tieba/oxa;");
                return;
            }
        }
        a = new tra();
        HandlerThread handlerThread = new HandlerThread("pull_pid_cpm");
        handlerThread.start();
        new a(handlerThread.getLooper());
    }

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
            long j;
            double d;
            int i;
            Response perform;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                long j2 = 0;
                boolean z2 = false;
                if (i2 != 100) {
                    if (i2 == 101) {
                        tra traVar = oxa.a;
                        synchronized (traVar) {
                            LogPrinter.d("new dey", new Object[0]);
                            double a = lsa.a();
                            lsa.b.clear().apply();
                            traVar.a.clear();
                            if (a > 0.0d) {
                                jsa.d(jsa.m() + a);
                            }
                        }
                        Calendar calendar = Calendar.getInstance();
                        long timeInMillis = calendar.getTimeInMillis();
                        calendar.add(6, 1);
                        calendar.set(11, 0);
                        calendar.set(12, 0);
                        calendar.set(13, 0);
                        long timeInMillis2 = calendar.getTimeInMillis() - timeInMillis;
                        if (timeInMillis2 >= 0) {
                            j2 = timeInMillis2;
                        }
                        sendEmptyMessageDelayed(101, j2);
                        return;
                    }
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
                    if (jSONObject2.getInt(Constants.KEYS.RET) == 200) {
                        lsa.a.edit().putLong("key_cpm_update_date", Calendar.getInstance().getTimeInMillis()).putString("key_ad_cpmcfg", jSONObject2.getJSONObject("data").getJSONArray("cpm").toString()).apply();
                        z = true;
                        if (!z) {
                        }
                    } else {
                        z = false;
                        if (!z) {
                            int i3 = message.arg1;
                            LogPrinter.d("ad cpm config pull times = %1s", Integer.valueOf(i3));
                            if (i3 == 0) {
                                i = 10;
                            } else if (i3 <= 2) {
                                i = i3 * 5 * 60;
                            } else {
                                i = 3600;
                            }
                            Message obtainMessage = obtainMessage(100);
                            obtainMessage.arg1 = i3 + 1;
                            sendMessageDelayed(obtainMessage, i * 1000);
                            return;
                        }
                        tra traVar2 = oxa.a;
                        synchronized (traVar2) {
                            traVar2.a.clear();
                            try {
                                JSONArray jSONArray = new JSONArray(lsa.a.getString("key_ad_cpmcfg", ""));
                                if (jSONArray.length() >= 1) {
                                    double m = jsa.m();
                                    double a2 = lsa.a();
                                    HashMap hashMap2 = new HashMap();
                                    boolean z3 = false;
                                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                                        JSONObject jSONObject3 = jSONArray.getJSONObject(i4);
                                        String string = jSONObject3.getString("aid");
                                        double d2 = jSONObject3.getDouble("cpm");
                                        LogPrinter.d("update Cpm:" + string, new Object[0]);
                                        hashMap2.put(string, Double.valueOf(d2));
                                        int i5 = lsa.a.getInt(string, 0);
                                        LogPrinter.d("need adjust aid count:" + i5, new Object[0]);
                                        if (i5 != 0) {
                                            a2 -= lsa.b(string);
                                            m += i5 * d2;
                                            lsa.b.remove(string).remove(string + "_");
                                            z3 = true;
                                        }
                                    }
                                    traVar2.a.putAll(hashMap2);
                                    if (z3) {
                                        LogPrinter.d("update totalPrice&totalPriceByBasePrice", new Object[0]);
                                        if (a2 < 0.0d) {
                                            d = 0.0d;
                                        } else {
                                            d = a2;
                                        }
                                        SharedPreferences.Editor editor = lsa.b;
                                        editor.putLong("key_price_by_baseprice", Double.doubleToRawLongBits(d));
                                        editor.apply();
                                        jsa.d(m);
                                    }
                                }
                            } catch (JSONException unused2) {
                                traVar2.a.clear();
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
                        calendar3.setTimeInMillis(lsa.a.getLong("key_cpm_update_date", 0L));
                        int i8 = calendar3.get(6);
                        if (i7 == calendar3.get(1) && i6 == i8) {
                            z2 = true;
                        }
                        if (z2) {
                            calendar2.add(6, 1);
                        }
                        long timeInMillis4 = calendar2.getTimeInMillis() - timeInMillis3;
                        if (timeInMillis4 < 0) {
                            j = 0;
                        } else {
                            j = timeInMillis4;
                        }
                        sendEmptyMessageDelayed(100, j);
                        return;
                    }
                }
                LogPrinter.d("cpm fail:", new Object[0]);
                z = false;
                if (!z) {
                }
            }
        }
    }
}

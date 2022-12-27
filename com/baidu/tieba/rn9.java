package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.codec.binary4util.BaseNCodec;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class rn9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String c = "UnionIDHelper";
    public static boolean d;
    public static final String e;
    public static final String f;
    public static final Object g;
    public static rn9 h;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile un9 a;
    public AtomicBoolean b;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ b b;
        public final /* synthetic */ rn9 c;

        public a(rn9 rn9Var, Context context, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn9Var, context, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rn9Var;
            this.a = context;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (rn9.d) {
                    Log.d(rn9.c, "asyncRequest, Thread runn！");
                }
                sn9 m = this.c.m(this.a);
                if (rn9.d) {
                    String str = rn9.c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("asyncRequest, cachedBean == null ？");
                    if (m == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sb.append(z);
                    Log.d(str, sb.toString());
                }
                if (m == null || this.c.q(m)) {
                    if (rn9.d) {
                        Log.d(rn9.c, "asyncRequest, requestFromManufacturer");
                    }
                    this.c.r();
                    if (rn9.d) {
                        Log.d(rn9.c, "asyncRequest, trySaveFiles！");
                    }
                    this.c.b.set(this.c.t(this.a));
                    if (rn9.d) {
                        Log.d(rn9.c, "asyncRequest, trySaveFiles done");
                    }
                }
                if (rn9.d) {
                    Log.d(rn9.c, "asyncRequest, send  innerHandler message");
                }
                this.b.obtainMessage(100, this.c.a).sendToTarget();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public tn9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, tn9 tn9Var) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper, tn9Var};
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
            this.a = tn9Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String oaid;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 100) {
                    un9 un9Var = (un9) message.obj;
                    if (rn9.d) {
                        String str = rn9.c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("handleMessage ，what：");
                        if (un9Var == null) {
                            oaid = "";
                        } else {
                            oaid = un9Var.getOAID();
                        }
                        sb.append(oaid);
                        Log.d(str, sb.toString());
                    }
                    tn9 tn9Var = this.a;
                    if (tn9Var != null) {
                        tn9Var.a(un9Var);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948127532, "Lcom/baidu/tieba/rn9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948127532, "Lcom/baidu/tieba/rn9;");
                return;
            }
        }
        d = nn9.e();
        e = j(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, BaseNCodec.PAD_DEFAULT}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, BaseNCodec.PAD_DEFAULT});
        f = j(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, BaseNCodec.PAD_DEFAULT}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, BaseNCodec.PAD_DEFAULT});
        g = new Object();
    }

    public rn9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
    }

    public static rn9 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (h == null) {
                synchronized (rn9.class) {
                    if (h == null) {
                        h = new rn9();
                    }
                }
            }
            return h;
        }
        return (rn9) invokeV.objValue;
    }

    public final long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return nn9.a(on9.a()) * 60 * 1000;
        }
        return invokeV.longValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return nn9.d(on9.a());
        }
        return invokeV.booleanValue;
    }

    public static String j(byte[]... bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte[] bArr2 : bArr) {
                sb.append(new String(bo9.a(bArr2)));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return bo9.c(zn9.b(e, f, str.getBytes()), IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException | Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public final boolean q(@NonNull sn9 sn9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sn9Var)) == null) {
            if (Math.abs(System.currentTimeMillis() - sn9Var.a) > n()) {
                if (d) {
                    Log.d(c, "isExpireTime ：超过缓存有效期");
                    return true;
                }
                return true;
            } else if (d) {
                Log.d(c, "isExpireTime ：没有超过缓存有效期");
                return false;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new String(zn9.a(e, f, bo9.a(str.getBytes())));
            } catch (Exception e2) {
                if (d) {
                    String str2 = c;
                    Log.d(str2, "getCacheObject ，decryptUnionID：" + e2.getMessage());
                    return "";
                }
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public synchronized void i(Context context, @NonNull Looper looper, @Nullable tn9 tn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, looper, tn9Var) == null) {
            synchronized (this) {
                if (looper != null) {
                    b bVar = new b(looper, tn9Var);
                    if (p()) {
                        bVar.obtainMessage(100, null).sendToTarget();
                        return;
                    }
                    if (this.a != null && this.b.get()) {
                        if (d) {
                            String str = c;
                            Log.d(str, "asyncRequest, mIUnionId.getOAID：" + this.a.getOAID());
                            String str2 = c;
                            Log.d(str2, "asyncRequest, mIUnionId.isTrackLimited：" + this.a.c());
                            String str3 = c;
                            Log.d(str3, "asyncRequest, mIUnionId.getStatusCode：" + this.a.getStatusCode());
                        }
                        bVar.obtainMessage(100, this.a).sendToTarget();
                    } else {
                        if (!this.b.get()) {
                            this.a = new pn9(context).a;
                        }
                        new Thread(new a(this, context, bVar)).start();
                    }
                    return;
                }
                throw new NullPointerException("param looper not null");
            }
        }
    }

    public final sn9 m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
            if (!file.exists()) {
                if (d) {
                    Log.d(c, "getCacheObject dir 不存在 , 首次需要创建");
                }
                return null;
            }
            File file2 = new File(file, ".bd_un_info.so");
            if (!file2.exists()) {
                if (d) {
                    Log.d(c, "getCacheObject  file 不存在, 首次需要创建");
                }
                return null;
            }
            String a2 = do9.a(file2, g);
            if (d) {
                String str = c;
                Log.d(str, "getCacheObject ，content：" + a2);
            }
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            String k = k(a2);
            if (d) {
                String str2 = c;
                Log.d(str2, "getCacheObject ，json：" + k);
            }
            try {
                JSONObject jSONObject = new JSONObject(k);
                sn9 sn9Var = new sn9();
                s(sn9Var, jSONObject);
                return sn9Var;
            } catch (Exception e2) {
                if (d) {
                    String str3 = c;
                    Log.d(str3, "getCacheObject , " + e2.getMessage());
                }
                return null;
            }
        }
        return (sn9) invokeL.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = this.a.d();
            if (d) {
                String str = c;
                Log.d(str, "asyncRequest, requestFromManufacturer done :" + this.a.getOAID());
            }
        }
    }

    public final boolean s(sn9 sn9Var, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sn9Var, jSONObject)) == null) {
            try {
                long optLong = jSONObject.optLong(new String(bo9.a("dGltZQ==".getBytes())));
                sn9Var.a = optLong;
                if (d) {
                    String str = c;
                    Log.d(str, "tryParseCacheJsonObject ，time：" + optLong);
                    String str2 = c;
                    Log.d(str2, "tryParseCacheJsonObject ，System.currentTimeMillis() - time：" + (System.currentTimeMillis() - optLong));
                }
                String str3 = new String(bo9.a("dW5pb25JRG9iag==".getBytes()));
                if (d) {
                    String str4 = c;
                    Log.d(str4, "tryParseCacheJsonObject objKey：" + str3);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(str3);
                if (d) {
                    String str5 = c;
                    Log.d(str5, "tryParseCacheJsonObject ，jsonObject：" + optJSONObject);
                }
                if (optJSONObject != null) {
                    String str6 = new String(bo9.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                    String str7 = new String(bo9.a("aXNTdXBwb3J0".getBytes()));
                    String str8 = new String(bo9.a("c3RhdHVzY29kZQ==".getBytes()));
                    String str9 = new String(bo9.a("b2FpZA==".getBytes()));
                    String str10 = new String(bo9.a("YWFpZA==".getBytes()));
                    String str11 = new String(bo9.a("dmFpZA==".getBytes()));
                    boolean optBoolean = optJSONObject.optBoolean(str6);
                    boolean optBoolean2 = optJSONObject.optBoolean(str7);
                    int optInt = optJSONObject.optInt(str8);
                    String optString = optJSONObject.optString(str9);
                    String optString2 = optJSONObject.optString(str10);
                    String optString3 = optJSONObject.optString(str11);
                    this.a.h(optBoolean);
                    this.a.e(optBoolean2);
                    this.a.a(optInt);
                    this.a.g(optString);
                    this.a.f(optString2);
                    this.a.b(optString3);
                    sn9Var.b = this.a;
                    return true;
                }
                sn9Var.b = null;
                if (d) {
                    Log.d(c, "tryParseCacheJsonObject return cause null：");
                }
                return false;
            } catch (Exception e2) {
                if (d) {
                    String str12 = c;
                    Log.d(str12, "tryParseCacheJsonObject ：" + e2.getMessage());
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            try {
                if (this.a != null && !TextUtils.isEmpty(this.a.getOAID())) {
                    File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(file, ".bd_un_info.so");
                    String str = new String(bo9.a("dGltZQ==".getBytes()));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, System.currentTimeMillis());
                    String str2 = new String(bo9.a("dW5pb25JRG9iag==".getBytes()));
                    JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                    }
                    String str3 = new String(bo9.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                    String str4 = new String(bo9.a("aXNTdXBwb3J0".getBytes()));
                    String str5 = new String(bo9.a("c3RhdHVzY29kZQ==".getBytes()));
                    String str6 = new String(bo9.a("b2FpZA==".getBytes()));
                    String str7 = new String(bo9.a("YWFpZA==".getBytes()));
                    String str8 = new String(bo9.a("dmFpZA==".getBytes()));
                    optJSONObject.put(str3, this.a.c());
                    optJSONObject.put(str4, this.a.isSupport());
                    optJSONObject.put(str5, this.a.getStatusCode());
                    optJSONObject.put(str6, this.a.getOAID());
                    optJSONObject.put(str7, this.a.getAAID());
                    optJSONObject.put(str8, this.a.getVAID());
                    jSONObject.put(str2, optJSONObject);
                    do9.b(l(jSONObject.toString()), file2, false, g);
                    if (d) {
                        String str9 = c;
                        Log.d(str9, "trySaveFiles, app: " + jSONObject.toString());
                        return true;
                    }
                    return true;
                }
                return false;
            } catch (Exception e2) {
                if (d) {
                    String str10 = c;
                    Log.d(str10, "trySaveFiles, error " + e2.getMessage());
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}

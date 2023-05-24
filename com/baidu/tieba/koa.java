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
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class koa {
    public static /* synthetic */ Interceptable $ic = null;
    public static String c = "UnionIDHelper";
    public static boolean d;
    public static final String e;
    public static final String f;
    public static final Object g;
    public static koa h;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile noa a;
    public AtomicBoolean b;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ b b;
        public final /* synthetic */ koa c;

        public a(koa koaVar, Context context, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {koaVar, context, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = koaVar;
            this.a = context;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (koa.d) {
                    Log.d(koa.c, "asyncRequest, Thread runn！");
                }
                loa m = this.c.m(this.a);
                if (koa.d) {
                    String str = koa.c;
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
                    if (koa.d) {
                        Log.d(koa.c, "asyncRequest, requestFromManufacturer");
                    }
                    this.c.r();
                    if (koa.d) {
                        Log.d(koa.c, "asyncRequest, trySaveFiles！");
                    }
                    this.c.b.set(this.c.t(this.a));
                    if (koa.d) {
                        Log.d(koa.c, "asyncRequest, trySaveFiles done");
                    }
                }
                if (koa.d) {
                    Log.d(koa.c, "asyncRequest, send  innerHandler message");
                }
                this.b.obtainMessage(100, this.c.a).sendToTarget();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public moa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, moa moaVar) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper, moaVar};
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
            this.a = moaVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String oaid;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 100) {
                    noa noaVar = (noa) message.obj;
                    if (koa.d) {
                        String str = koa.c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("handleMessage ，what：");
                        if (noaVar == null) {
                            oaid = "";
                        } else {
                            oaid = noaVar.getOAID();
                        }
                        sb.append(oaid);
                        Log.d(str, sb.toString());
                    }
                    moa moaVar = this.a;
                    if (moaVar != null) {
                        moaVar.a(noaVar);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947921196, "Lcom/baidu/tieba/koa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947921196, "Lcom/baidu/tieba/koa;");
                return;
            }
        }
        d = goa.e();
        e = j(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, 61});
        f = j(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});
        g = new Object();
    }

    public koa() {
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

    public static koa o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (h == null) {
                synchronized (koa.class) {
                    if (h == null) {
                        h = new koa();
                    }
                }
            }
            return h;
        }
        return (koa) invokeV.objValue;
    }

    public final long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return goa.a(hoa.a()) * 60 * 1000;
        }
        return invokeV.longValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return goa.d(hoa.a());
        }
        return invokeV.booleanValue;
    }

    public static String j(byte[]... bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte[] bArr2 : bArr) {
                sb.append(new String(uoa.a(bArr2)));
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
                return uoa.c(soa.b(e, f, str.getBytes()), IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException | Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public final boolean q(@NonNull loa loaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, loaVar)) == null) {
            if (Math.abs(System.currentTimeMillis() - loaVar.a) > n()) {
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
                return new String(soa.a(e, f, uoa.a(str.getBytes())));
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

    public synchronized void i(Context context, @NonNull Looper looper, @Nullable moa moaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, looper, moaVar) == null) {
            synchronized (this) {
                if (looper != null) {
                    b bVar = new b(looper, moaVar);
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
                            this.a = new ioa(context).a;
                        }
                        new Thread(new a(this, context, bVar)).start();
                    }
                    return;
                }
                throw new NullPointerException("param looper not null");
            }
        }
    }

    public final loa m(Context context) {
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
            String a2 = woa.a(file2, g);
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
                loa loaVar = new loa();
                s(loaVar, jSONObject);
                return loaVar;
            } catch (Exception e2) {
                if (d) {
                    String str3 = c;
                    Log.d(str3, "getCacheObject , " + e2.getMessage());
                }
                return null;
            }
        }
        return (loa) invokeL.objValue;
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

    public final boolean s(loa loaVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, loaVar, jSONObject)) == null) {
            try {
                long optLong = jSONObject.optLong(new String(uoa.a("dGltZQ==".getBytes())));
                loaVar.a = optLong;
                if (d) {
                    String str = c;
                    Log.d(str, "tryParseCacheJsonObject ，time：" + optLong);
                    String str2 = c;
                    Log.d(str2, "tryParseCacheJsonObject ，System.currentTimeMillis() - time：" + (System.currentTimeMillis() - optLong));
                }
                String str3 = new String(uoa.a("dW5pb25JRG9iag==".getBytes()));
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
                    String str6 = new String(uoa.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                    String str7 = new String(uoa.a("aXNTdXBwb3J0".getBytes()));
                    String str8 = new String(uoa.a("c3RhdHVzY29kZQ==".getBytes()));
                    String str9 = new String(uoa.a("b2FpZA==".getBytes()));
                    String str10 = new String(uoa.a("YWFpZA==".getBytes()));
                    String str11 = new String(uoa.a("dmFpZA==".getBytes()));
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
                    loaVar.b = this.a;
                    return true;
                }
                loaVar.b = null;
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
                    String str = new String(uoa.a("dGltZQ==".getBytes()));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, System.currentTimeMillis());
                    String str2 = new String(uoa.a("dW5pb25JRG9iag==".getBytes()));
                    JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                    }
                    String str3 = new String(uoa.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                    String str4 = new String(uoa.a("aXNTdXBwb3J0".getBytes()));
                    String str5 = new String(uoa.a("c3RhdHVzY29kZQ==".getBytes()));
                    String str6 = new String(uoa.a("b2FpZA==".getBytes()));
                    String str7 = new String(uoa.a("YWFpZA==".getBytes()));
                    String str8 = new String(uoa.a("dmFpZA==".getBytes()));
                    optJSONObject.put(str3, this.a.c());
                    optJSONObject.put(str4, this.a.isSupport());
                    optJSONObject.put(str5, this.a.getStatusCode());
                    optJSONObject.put(str6, this.a.getOAID());
                    optJSONObject.put(str7, this.a.getAAID());
                    optJSONObject.put(str8, this.a.getVAID());
                    jSONObject.put(str2, optJSONObject);
                    woa.b(l(jSONObject.toString()), file2, false, g);
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

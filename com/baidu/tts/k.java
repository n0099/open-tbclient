package com.baidu.tts;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.jni.LicenseInfo;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes9.dex */
public class k implements d1<k, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;

    /* loaded from: classes9.dex */
    public static class a implements c1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;
        public String c;
        public String d;
        public d e;
        public LicenseInfo f;
        public long g;

        public a() {
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
            this.a = -1;
        }

        public void a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                LoggerProxy.d("OfflineAuth", "this=" + this + "--error=" + dVar.getDetailMessage());
                this.e = dVar;
            }
        }

        @Override // com.baidu.tts.c1
        public boolean a() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                LoggerProxy.d("OfflineAuth", "lastCheckExpireTime " + this.g);
                if (this.g - System.currentTimeMillis() >= 0) {
                    return true;
                }
                if (w0.b(this.b) || !new File(this.b).exists()) {
                    return false;
                }
                b1 d = b1.d();
                Context b = d.b();
                String c = d.c();
                byte[] bArr = new byte[32];
                LoggerProxy.d("OfflineAuth", "verify license before " + this.b);
                String a = l2.a(b);
                String str2 = this.c;
                if (TextUtils.isEmpty(this.d)) {
                    str = "";
                } else {
                    str = this.d;
                }
                LicenseInfo bdTTSVerifyLicense = EmbeddedSynthesizerEngine.bdTTSVerifyLicense(a, 1, str2, c, str, this.b, bArr);
                this.f = bdTTSVerifyLicense;
                if (bdTTSVerifyLicense != null) {
                    this.a = bdTTSVerifyLicense.getRet();
                    try {
                        Date parse = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(this.f.getTime());
                        if (parse != null) {
                            this.g = parse.getTime();
                            LoggerProxy.d("OfflineAuth", "expireTime=" + this.g);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                LoggerProxy.d("OfflineAuth", "verify result=" + this.a + " ,  " + this.f);
                if (this.a >= 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = new a();
            aVar.b = this.d;
            aVar.c = this.a;
            aVar.d = this.c;
            boolean a2 = aVar.a();
            LoggerProxy.d("OfflineAuth", "isValidOfficial " + a2);
            if (!a2) {
                Context b = b1.d().b();
                LoggerProxy.d("OfflineAuth", "+ downloadLicense");
                int i = -1;
                String a3 = w0.a("AndroidTTS", this.b);
                if (System.currentTimeMillis() - b.getSharedPreferences(a3, 0).getLong("getLicense_time", 0L) > b.getSharedPreferences(a3, 0).getLong("getLicense_expires", 0L)) {
                    try {
                        FutureTask futureTask = new FutureTask(new j(this.a, this.b, this.c, this.d));
                        new i2(futureTask, "bds-license").start();
                        i = ((Integer) futureTask.get(2000L, TimeUnit.MILLISECONDS)).intValue();
                    } catch (InterruptedException e) {
                        e = e;
                        LoggerProxy.d("OfflineAuth", e.toString());
                    } catch (ExecutionException e2) {
                        LoggerProxy.d("OfflineAuth", "ExecutionException " + e2.getCause());
                    } catch (TimeoutException e3) {
                        e = e3;
                        LoggerProxy.d("OfflineAuth", e.toString());
                    }
                }
                LoggerProxy.d("OfflineAuth", "- downloadLicense ret = " + i);
                if (i < 0) {
                    d a4 = z0.a().a(u0.R);
                    a4.b = i;
                    a4.c = "appCode=" + this.a + "--licensePath=" + this.d;
                    a4.a = null;
                    aVar.a(a4);
                } else if (!aVar.a()) {
                    aVar.a(z0.a().a(u0.P));
                }
            }
            return aVar;
        }
        return invokeV.objValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            k kVar = (k) obj;
            String str = kVar.a;
            String str2 = kVar.d;
            boolean equals = TextUtils.equals(this.a, str);
            boolean equals2 = TextUtils.equals(this.d, str2);
            if (equals && equals2) {
                return 0;
            }
            return 1;
        }
        return invokeL.intValue;
    }
}

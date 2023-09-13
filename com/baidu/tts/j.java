package com.baidu.tts;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.h1;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Callable;
/* loaded from: classes9.dex */
public class j implements Callable<Integer> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;

    public j(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.lang.Integer] */
    @Override // java.util.concurrent.Callable
    public Integer call() throws Exception {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LoggerProxy.d("GetTtsLicenseV1Work", "begins getLicense");
            g1 g1Var = new g1();
            String a = h1.d.a.a("https://upl.baidu.com/offline/auth", true);
            String name = v0.class.getName();
            LoggerProxy.d(name, "ipUrl: " + a);
            if (a.isEmpty()) {
                a = "https://upl.baidu.com/offline/auth";
            }
            try {
                str = new URL("https://upl.baidu.com/offline/auth").getHost();
            } catch (MalformedURLException e) {
                e.printStackTrace();
                str = "";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Host", str);
            g1Var.e = hashMap;
            String str3 = this.b;
            String str4 = this.c;
            String str5 = this.d;
            i iVar = new i();
            iVar.b = str3;
            iVar.f = str4;
            iVar.d = str5;
            try {
                HashMap hashMap2 = new HashMap();
                b1 d = b1.d();
                String c = d.c();
                Context b = d.b();
                String b2 = l2.b(this.a);
                int i = b.getSharedPreferences(w0.a("AndroidTTS", this.b), 0).getInt("getLicense_err_no", -1);
                n0 n0Var = n0.q0;
                hashMap2.put("cuid", c);
                n0 n0Var2 = n0.B0;
                hashMap2.put("sign", b2);
                n0 n0Var3 = n0.l;
                hashMap2.put("id", this.a);
                n0 n0Var4 = n0.C0;
                hashMap2.put("app", l2.a(b));
                n0 n0Var5 = n0.D0;
                hashMap2.put("selfDef", "android.etts");
                n0 n0Var6 = n0.E0;
                hashMap2.put("sta", w0.a(b));
                n0 n0Var7 = n0.F0;
                hashMap2.put("errno", "" + i);
                n0 n0Var8 = n0.r0;
                hashMap2.put("sdkversion", "6.0.5.5f65dca");
                str2 = w0.a(hashMap2);
                LoggerProxy.d("GetTtsLicenseV1Work", "getLicense params: " + str2);
            } catch (Exception e2) {
                LoggerProxy.d("GetTtsLicenseV1Work", "getEntity error " + e2.getMessage());
                str2 = null;
            }
            g1Var.a(a, str2, "POST", iVar);
            return Integer.valueOf(iVar.c);
        }
        return invokeV.objValue;
    }
}

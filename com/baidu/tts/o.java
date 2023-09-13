package com.baidu.tts;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.TtsMode;
import com.baidu.tts.e2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final x1 a;
    public String b;
    public q1 c;
    public q d;
    public p e;
    public n f;
    public d g;
    public int h;
    public final String i;

    public o(String str, x1 x1Var, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, x1Var, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = str;
        String a = w0.a("MultiModeSynthesizer", str);
        this.i = a;
        this.d = new q(str, mVar);
        this.e = new p(str, mVar);
        this.f = new n(str);
        this.a = x1Var;
        q1 b = x1Var.b();
        LoggerProxy.d(a, "engineParams " + b);
        a(b);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:130:0x01c8 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:273:0x0122 */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x01c8, code lost:
        if (r0 != 0) goto L236;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x032f  */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.baidu.tts.n, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.baidu.tts.n] */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d a(w1 w1Var) throws InterruptedException {
        InterceptResult invokeL;
        boolean z;
        String str;
        e2 e2Var;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w1Var)) == null) {
            if (d0.a(this.b).a()) {
                return z0.a().a(u0.G0);
            }
            int i = e2.j;
            String str2 = e2.b.a.d;
            LoggerProxy.d(this.i, "operatorName = " + str2);
            synchronized (w1Var) {
                JSONObject jSONObject = w1Var.d;
                if (jSONObject != null) {
                    try {
                        jSONObject.put("operator", str2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            TtsMode ttsMode = w1Var.i;
            boolean z4 = false;
            if (ttsMode == TtsMode.OFFLINE) {
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                synchronized (w1Var) {
                    JSONObject jSONObject2 = w1Var.d;
                    if (jSONObject2 != null) {
                        try {
                            jSONObject2.put("syn_stime", valueOf);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                synchronized (w1Var) {
                    JSONObject jSONObject3 = w1Var.d;
                    if (jSONObject3 != null) {
                        try {
                            jSONObject3.put("use_online", (Object) 0);
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                d a = this.e.a(w1Var);
                Long valueOf2 = Long.valueOf(System.currentTimeMillis());
                synchronized (w1Var) {
                    JSONObject jSONObject4 = w1Var.d;
                    if (jSONObject4 != null) {
                        try {
                            jSONObject4.put("syn_etime", valueOf2);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
                f0.a(this.b).a(m0.c, null, a, this.c, w1Var);
                return a;
            } else if (ttsMode == TtsMode.ONLINE) {
                Long valueOf3 = Long.valueOf(System.currentTimeMillis());
                synchronized (w1Var) {
                    JSONObject jSONObject5 = w1Var.d;
                    if (jSONObject5 != null) {
                        try {
                            jSONObject5.put("syn_stime", valueOf3);
                        } catch (JSONException e5) {
                            e5.printStackTrace();
                        }
                    }
                }
                synchronized (w1Var) {
                    JSONObject jSONObject6 = w1Var.d;
                    if (jSONObject6 != null) {
                        try {
                            jSONObject6.put("use_online", (Object) 1);
                        } catch (JSONException e6) {
                            e6.printStackTrace();
                        }
                    }
                }
                d a2 = this.d.a(w1Var);
                Long valueOf4 = Long.valueOf(System.currentTimeMillis());
                synchronized (w1Var) {
                    JSONObject jSONObject7 = w1Var.d;
                    if (jSONObject7 != null) {
                        try {
                            jSONObject7.put("syn_etime", valueOf4);
                        } catch (JSONException e7) {
                            e7.printStackTrace();
                        }
                    }
                }
                f0.a(this.b).a(m0.b, a2, null, this.c, w1Var);
                return a2;
            } else {
                ?? r0 = this.f;
                r0.getClass();
                try {
                    boolean a3 = r0.a();
                    u1 u1Var = r0.a.a;
                    LoggerProxy.d(r0.c, "MixOnlineRequestTimeout: " + u1Var.o + " isModeChanged: " + a3);
                    int i2 = e2.j;
                    e2Var = e2.b.a;
                } catch (Exception e8) {
                    LoggerProxy.d(r0.c, e8.toString());
                }
                if (e2Var.a()) {
                    String str3 = r0.c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("detector.isNetworkTypeWifi(): ");
                    e2.c cVar = e2Var.b;
                    e2.c cVar2 = e2.c.i;
                    if (cVar == cVar2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    sb.append(z2);
                    sb.append(",detector.isNetworkTypeEther():");
                    e2.c cVar3 = e2Var.b;
                    e2.c cVar4 = e2.c.d;
                    if (cVar3 == cVar4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    sb.append(z3);
                    sb.append(",detector.isHighSpeedNetwork():");
                    sb.append(e2Var.b());
                    sb.append(" mOldMode: ");
                    sb.append(r0.b);
                    LoggerProxy.d(str3, sb.toString());
                    q0 q0Var = r0.b;
                    if (q0Var == q0.a) {
                        if (e2Var.b == cVar2) {
                            r0 = 1;
                        } else {
                            r0 = 0;
                        }
                        if (r0 != 0) {
                            z = true;
                            LoggerProxy.d(this.i, "isuseonline=" + z);
                            if (!z) {
                                Long valueOf5 = Long.valueOf(System.currentTimeMillis());
                                synchronized (w1Var) {
                                    JSONObject jSONObject8 = w1Var.d;
                                    if (jSONObject8 != null) {
                                        try {
                                            jSONObject8.put("syn_stime", valueOf5);
                                        } catch (JSONException e9) {
                                            e9.printStackTrace();
                                        }
                                    }
                                }
                                synchronized (w1Var) {
                                    JSONObject jSONObject9 = w1Var.d;
                                    if (jSONObject9 != null) {
                                        try {
                                            jSONObject9.put("use_online", (Object) 1);
                                        } catch (JSONException e10) {
                                            e10.printStackTrace();
                                        }
                                    }
                                }
                                d a4 = this.d.a(w1Var);
                                d dVar = null;
                                if (a4 != null) {
                                    LoggerProxy.d(this.i, "online synthesize tts error=" + a4.getDetailMessage());
                                    w1Var.a("online_ecode", Integer.valueOf(a4.getDetailCode()));
                                    w1Var.a("online_msg", a4.getDetailMessage());
                                    u0 a5 = a4.a();
                                    LoggerProxy.d(this.i, "ttserror enum=" + a5);
                                    if (a5 != u0.q && a5 != u0.h && a5 != u0.t && a5 != u0.v && a5 != u0.w && a5 != u0.u && a5 != u0.O) {
                                        LoggerProxy.e(this.i, "---> errorenum=" + a5);
                                    } else {
                                        if (w1Var.a.length() > w1Var.h) {
                                            str = w1Var.a.substring(w1Var.h);
                                        } else {
                                            str = null;
                                        }
                                        if (str != null) {
                                            LoggerProxy.d(this.i, "mix_a ---> switch to offline synth " + str + ", sn=" + w1Var.g);
                                            dVar = this.e.a(w1Var);
                                            z4 = true;
                                        } else {
                                            LoggerProxy.e(this.i, "remainText is empty , can't synthesize continue, sn=" + w1Var.g);
                                        }
                                    }
                                }
                                Long valueOf6 = Long.valueOf(System.currentTimeMillis());
                                synchronized (w1Var) {
                                    JSONObject jSONObject10 = w1Var.d;
                                    if (jSONObject10 != null) {
                                        try {
                                            jSONObject10.put("syn_etime", valueOf6);
                                        } catch (JSONException e11) {
                                            e11.printStackTrace();
                                        }
                                    }
                                }
                                f0.a(this.b).a(m0.d, a4, dVar, this.c, w1Var);
                                if (z4) {
                                    return dVar;
                                }
                                return a4;
                            }
                            Long valueOf7 = Long.valueOf(System.currentTimeMillis());
                            synchronized (w1Var) {
                                JSONObject jSONObject11 = w1Var.d;
                                if (jSONObject11 != null) {
                                    try {
                                        jSONObject11.put("syn_stime", valueOf7);
                                    } catch (JSONException e12) {
                                        e12.printStackTrace();
                                    }
                                }
                            }
                            synchronized (w1Var) {
                                JSONObject jSONObject12 = w1Var.d;
                                if (jSONObject12 != null) {
                                    try {
                                        jSONObject12.put("use_online", (Object) 0);
                                    } catch (JSONException e13) {
                                        e13.printStackTrace();
                                    }
                                }
                            }
                            LoggerProxy.d(this.i, "mix_a ---> directly to offline synth " + w1Var.a);
                            d a6 = this.e.a(w1Var);
                            Long valueOf8 = Long.valueOf(System.currentTimeMillis());
                            synchronized (w1Var) {
                                JSONObject jSONObject13 = w1Var.d;
                                if (jSONObject13 != null) {
                                    try {
                                        jSONObject13.put("syn_etime", valueOf8);
                                    } catch (JSONException e14) {
                                        e14.printStackTrace();
                                    }
                                }
                            }
                            f0.a(this.b).a(m0.d, z0.a().a(u0.T0), a6, this.c, w1Var);
                            return a6;
                        }
                    } else if (q0Var == q0.c) {
                        r0 = e2Var.b();
                        if (r0 != 0) {
                            z = true;
                            LoggerProxy.d(this.i, "isuseonline=" + z);
                            if (!z) {
                            }
                        }
                    } else if (q0Var == q0.b) {
                        if (!e2Var.b()) {
                            if (e2Var.b == cVar4) {
                                r0 = 1;
                            } else {
                                r0 = 0;
                            }
                        }
                        z = true;
                        LoggerProxy.d(this.i, "isuseonline=" + z);
                        if (!z) {
                        }
                    }
                }
                z = false;
                LoggerProxy.d(this.i, "isuseonline=" + z);
                if (!z) {
                }
            }
        } else {
            return (d) invokeL.objValue;
        }
    }

    public void a() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            q qVar = this.d;
            boolean z = true;
            byte b = (byte) (qVar.e + 1);
            qVar.e = b;
            n1 n1Var = new n1(qVar.a, qVar.c, b, qVar.d, qVar.b);
            qVar.f = n1Var;
            o1 o1Var = n1Var.c;
            synchronized (o1Var) {
                if (o1Var.d != null) {
                    z = false;
                }
            }
            if (z) {
                n1Var.c.a((k1) null);
            }
        }
    }

    public void a(q1 q1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q1Var) == null) {
            this.c = q1Var;
            this.d.d = q1Var.a;
            this.e.d = q1Var.b;
            this.f.a = q1Var;
        }
    }
}

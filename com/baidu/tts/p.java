package com.baidu.tts;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.aperf.bosuploader.FileUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SynthesizerTool;
import com.baidu.tts.g2;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;
import java.util.regex.Pattern;
import org.chromium.net.NetError;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final m c;
    public t1 d;
    public final long[] e;
    public String f;
    public final HashMap<String, a> g;
    public String h;
    public String i;
    public final EmbeddedSynthesizerEngine j;
    public int k;
    public final Semaphore l;

    /* loaded from: classes9.dex */
    public class b implements Callable<d>, EmbeddedSynthesizerEngine.OnNewDataListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public w1 a;
        public r0 b;
        public long c;
        public long d;
        public long e;
        public long f;
        public int g;
        public int h;
        public boolean i;
        public long j;
        public long k;
        public long l;
        public long m;
        public long n;
        public final /* synthetic */ p o;

        /* loaded from: classes9.dex */
        public class a implements m {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;
            public final /* synthetic */ b b;

            public a(b bVar, p pVar, m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, pVar, mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = mVar;
            }

            @Override // com.baidu.tts.m
            public void a(v1 v1Var) {
                m mVar;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, v1Var) == null) {
                    l0 l0Var = v1Var.a;
                    if (l0Var == l0.b) {
                        LoggerProxy.d(this.b.o.a, "onDataEnd");
                        this.b.o.l.release();
                    } else if (l0Var == l0.c && (mVar = this.a) != null) {
                        mVar.a(v1Var);
                    }
                }
            }
        }

        public b(p pVar, w1 w1Var, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, w1Var, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.o = pVar;
            this.b = r0.c;
            this.c = 0L;
            this.d = 0L;
            this.e = 0L;
            this.f = 0L;
            this.g = 0;
            this.h = 0;
            this.a = w1Var;
            this.g = w1Var.b();
            d0.a(pVar.b).a(new a(this, pVar, mVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't wrap try/catch for region: R(21:3|(1:5)|84|7|(17:79|80|10|(1:12)|13|14|15|16|17|18|19|20|(1:22)|23|(2:25|(2:29|(1:31)(5:33|34|35|36|(2:38|(15:40|41|42|44|45|46|47|48|49|50|51|52|53|54|(1:56)(2:57|58))(2:65|66))(2:67|68))))|72|(0)(0))|9|10|(0)|13|14|15|16|17|18|19|20|(0)|23|(0)|72|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00df, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x00e0, code lost:
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r12.y, "parseLong exception = " + r0.getMessage());
            r20 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0139, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x013a, code lost:
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r13.y, "parseLong exception = " + r0.getMessage());
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0083, code lost:
            if (android.text.TextUtils.isEmpty(r0) == false) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x01c9  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x01d5  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0233 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0234  */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public d call() throws Exception {
            InterceptResult invokeV;
            String str;
            String optString;
            r0 a2;
            d dVar;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LoggerProxy.d(this.o.a, "start offline Synthesizer " + this.a.g);
                this.j = System.currentTimeMillis();
                p pVar = this.o;
                pVar.j.bdTTSSetParamFloat(pVar.e[0], 1, pVar.d.c);
                p pVar2 = this.o;
                pVar2.j.bdTTSSetParamFloat(pVar2.e[0], 2, pVar2.d.a);
                p pVar3 = this.o;
                pVar3.j.bdTTSSetParamFloat(pVar3.e[0], 3, pVar3.d.b);
                p pVar4 = this.o;
                pVar4.j.bdTTSSetParamFloat(pVar4.e[0], 4, pVar4.d.t);
                HashMap<String, String> hashMap = this.a.m;
                t1 t1Var = this.o.d;
                if (hashMap != null) {
                    str = hashMap.get(SpeechSynthesizer.PARAM_TEXT_CTRL);
                }
                str = t1Var.g;
                String str2 = str;
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        optString = new JSONObject(str2).optString("emo", "");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = "normal";
                    }
                    String str3 = optString;
                    p pVar5 = this.o;
                    pVar5.j.bdTTSSetParamString(pVar5.e[0], "emo", str3);
                    p pVar6 = this.o;
                    int bdTTSSetParam = pVar6.j.bdTTSSetParam(pVar6.e[0], 0, 0L);
                    p pVar7 = this.o;
                    EmbeddedSynthesizerEngine embeddedSynthesizerEngine = pVar7.j;
                    long j = pVar7.e[0];
                    t1 t1Var2 = pVar7.d;
                    t1Var2.getClass();
                    long j2 = 0;
                    long j3 = Long.parseLong(t1Var2.h);
                    embeddedSynthesizerEngine.bdTTSSetParam(j, 6, j3);
                    p pVar8 = this.o;
                    long bdTTSGetParam = pVar8.j.bdTTSGetParam(pVar8.e[0], 6);
                    p pVar9 = this.o;
                    pVar9.j.bdTTSSetParam(pVar9.e[0], 5, pVar9.d.e);
                    p pVar10 = this.o;
                    EmbeddedSynthesizerEngine embeddedSynthesizerEngine2 = pVar10.j;
                    long j4 = pVar10.e[0];
                    t1 t1Var3 = pVar10.d;
                    t1Var3.getClass();
                    j2 = Long.parseLong(t1Var3.u);
                    embeddedSynthesizerEngine2.bdTTSSetParam(j4, 7, j2);
                    p pVar11 = this.o;
                    pVar11.j.bdTTSSetParam(pVar11.e[0], 20, pVar11.d.b());
                    LoggerProxy.d(this.o.a, "vocoder level = " + bdTTSGetParam + " , enableWm = " + this.o.d.b() + " , engineResult = " + bdTTSSetParam + " , textCtrl = " + str2 + " , emo = " + str3);
                    this.o.j.setOnNewDataListener(this);
                    p pVar12 = this.o;
                    int bdTTSGetParam2 = (int) pVar12.j.bdTTSGetParam(pVar12.e[0], 8);
                    a2 = r0.a(bdTTSGetParam2);
                    if (a2 != null) {
                        this.b = a2;
                    }
                    int i = this.b.a;
                    if (this.a.h > 0) {
                        r0 r0Var = this.a.l;
                        LoggerProxy.d(this.o.a, "onlineHz " + r0Var + " , offlineHz " + i);
                        if (r0Var != null && r0Var.a != i) {
                            dVar = z0.a().a(u0.v0);
                            if (dVar != null) {
                                return dVar;
                            }
                            w1 w1Var = this.a;
                            w1Var.getClass();
                            try {
                                bArr = w1Var.a.substring(w1Var.h).getBytes("gbk");
                            } catch (UnsupportedEncodingException e2) {
                                e2.printStackTrace();
                                bArr = null;
                            }
                            LoggerProxy.d(this.o.a, "before bdTTSSynthesis");
                            w1 w1Var2 = this.a;
                            this.e = System.currentTimeMillis();
                            g2 g2Var = w1Var2.k;
                            g2.a aVar = new g2.a();
                            aVar.a = System.currentTimeMillis();
                            g2Var.b = aVar;
                            p pVar13 = this.o;
                            int bdTTSSynthesis = pVar13.j.bdTTSSynthesis(pVar13.e[0], bArr, bArr.length);
                            LoggerProxy.d(this.o.a, "synthesizeResult " + bdTTSSynthesis);
                            if (!this.i) {
                                LoggerProxy.d(this.o.a, "get last empty synthesizer audio " + this.a.g + ", progress " + this.h);
                                v1 v1Var = new v1(l0.b, this.a, null);
                                v1Var.b = 1;
                                v1Var.h = i0.a;
                                if (d0.a(this.o.b).a(v1Var) == 0) {
                                    LoggerProxy.d(this.o.a, "after bdttssynthesis result = " + bdTTSSynthesis + ", sn=" + this.a.g);
                                    try {
                                        this.o.l.acquire();
                                        try {
                                            this.a.b("speaker", new JSONObject(this.o.f).optString("speaker", StringUtil.NULL_STRING));
                                            this.a.b("audio_duration", Long.valueOf(this.c));
                                            this.a.b("so_version", SynthesizerTool.getEngineVersion() + "");
                                            this.a.b("appid", this.o.d.q);
                                            this.a.b("offline_error_code", Integer.valueOf(bdTTSSynthesis));
                                            this.a.b("time_first_bag", Long.valueOf(this.d));
                                        } catch (Throwable th) {
                                            LoggerProxy.d(this.o.a, "offline mtj exception! e=" + th.getMessage());
                                            th.printStackTrace();
                                        }
                                        if (p.a(this.o, bdTTSSynthesis)) {
                                            return null;
                                        }
                                        d a3 = z0.a().a(u0.Z);
                                        a3.b = bdTTSSynthesis;
                                        a3.c = null;
                                        a3.a = null;
                                        return a3;
                                    } catch (InterruptedException e3) {
                                        LoggerProxy.d(this.o.a, "because interrupt close");
                                        e3.printStackTrace();
                                        throw e3;
                                    }
                                }
                                throw new InterruptedException("InterruptedException");
                            }
                            throw new InterruptedException("InterruptedException");
                        }
                    }
                    p pVar14 = this.o;
                    pVar14.k = (bdTTSGetParam2 * 2) / 1000;
                    LoggerProxy.d(pVar14.a, " sampleRate:" + bdTTSGetParam2 + " sampleRateHz:" + i);
                    dVar = null;
                    if (dVar != null) {
                    }
                }
                optString = null;
                if (TextUtils.isEmpty(optString)) {
                }
                String str32 = optString;
                p pVar52 = this.o;
                pVar52.j.bdTTSSetParamString(pVar52.e[0], "emo", str32);
                p pVar62 = this.o;
                int bdTTSSetParam2 = pVar62.j.bdTTSSetParam(pVar62.e[0], 0, 0L);
                p pVar72 = this.o;
                EmbeddedSynthesizerEngine embeddedSynthesizerEngine3 = pVar72.j;
                long j5 = pVar72.e[0];
                t1 t1Var22 = pVar72.d;
                t1Var22.getClass();
                long j22 = 0;
                long j32 = Long.parseLong(t1Var22.h);
                embeddedSynthesizerEngine3.bdTTSSetParam(j5, 6, j32);
                p pVar82 = this.o;
                long bdTTSGetParam3 = pVar82.j.bdTTSGetParam(pVar82.e[0], 6);
                p pVar92 = this.o;
                pVar92.j.bdTTSSetParam(pVar92.e[0], 5, pVar92.d.e);
                p pVar102 = this.o;
                EmbeddedSynthesizerEngine embeddedSynthesizerEngine22 = pVar102.j;
                long j42 = pVar102.e[0];
                t1 t1Var32 = pVar102.d;
                t1Var32.getClass();
                j22 = Long.parseLong(t1Var32.u);
                embeddedSynthesizerEngine22.bdTTSSetParam(j42, 7, j22);
                p pVar112 = this.o;
                pVar112.j.bdTTSSetParam(pVar112.e[0], 20, pVar112.d.b());
                LoggerProxy.d(this.o.a, "vocoder level = " + bdTTSGetParam3 + " , enableWm = " + this.o.d.b() + " , engineResult = " + bdTTSSetParam2 + " , textCtrl = " + str2 + " , emo = " + str32);
                this.o.j.setOnNewDataListener(this);
                p pVar122 = this.o;
                int bdTTSGetParam22 = (int) pVar122.j.bdTTSGetParam(pVar122.e[0], 8);
                a2 = r0.a(bdTTSGetParam22);
                if (a2 != null) {
                }
                int i2 = this.b.a;
                if (this.a.h > 0) {
                }
                p pVar142 = this.o;
                pVar142.k = (bdTTSGetParam22 * 2) / 1000;
                LoggerProxy.d(pVar142.a, " sampleRate:" + bdTTSGetParam22 + " sampleRateHz:" + i2);
                dVar = null;
                if (dVar != null) {
                }
            } else {
                return (d) invokeV.objValue;
            }
        }

        @Override // com.baidu.tts.jni.EmbeddedSynthesizerEngine.OnNewDataListener
        public int onNewData(byte[] bArr, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bArr, i)) == null) {
                this.h = i + this.g;
                int abs = Math.abs(this.a.j) + 1;
                if (bArr.length == 0) {
                    abs = -abs;
                }
                this.k = System.currentTimeMillis();
                if (Math.abs(abs) == 1) {
                    this.a.k.b.b = System.currentTimeMillis();
                    this.d = System.currentTimeMillis() - this.e;
                    this.l = this.k - this.j;
                    LoggerProxy.d(this.o.a, "get synthesizer audio " + this.a.g + ", progress " + this.h + " , audioData.length " + bArr.length + " , mSleepDivisor " + this.o.k);
                } else {
                    long j = this.k - this.m;
                    LoggerProxy.d(this.o.a, "get synthesizer audio " + this.a.g + ", progress " + this.h + " , audioData.length " + bArr.length + " , mSleepDivisor " + this.o.k + " , firstReceiveDataTime " + this.l + " , sdkDealCostTime " + this.n + " , engineIntervalTime " + j + " , currentIdx " + abs);
                }
                w1 w1Var = this.a;
                w1Var.j = abs;
                v1 v1Var = new v1(l0.c, w1Var, null);
                v1Var.b = 1;
                v1Var.h = i0.a;
                v1Var.g = bArr;
                v1Var.d = this.h;
                v1Var.k = this.b;
                v1Var.c = abs;
                int a2 = d0.a(this.o.b).a(v1Var);
                int i2 = -1;
                if (a2 == -2) {
                    LoggerProxy.d(this.o.a, "offline engine putdata interrupted!");
                } else {
                    this.f += bArr.length;
                    if (bArr.length == 0) {
                        System.currentTimeMillis();
                        this.c = ((this.f * 8) * 1000) / (this.b.a * 16);
                    }
                    if (Thread.currentThread().isInterrupted()) {
                        LoggerProxy.d(this.o.a, "interrupted to interrupt syn");
                    } else {
                        p pVar = this.o;
                        try {
                            Thread.sleep((bArr.length * pVar.d.z) / pVar.k);
                            long currentTimeMillis = System.currentTimeMillis();
                            this.m = currentTimeMillis;
                            this.n = currentTimeMillis - this.k;
                            i2 = 0;
                        } catch (InterruptedException e) {
                            LoggerProxy.e(this.o.a, "------->sleep interrupted!");
                            e.printStackTrace();
                        }
                    }
                }
                if (i2 != 0) {
                    this.i = true;
                }
                return i2;
            }
            return invokeLI.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;

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
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "OfflineResource{speaker='" + this.a + "', type='" + this.b + "', textFilePath='" + this.c + "', speechFilePath='" + this.d + "', subganFilePath='" + this.e + "', tacFilePath='" + this.f + "', tacSubganSpeakerAttr='" + this.g + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    public p(String str, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new long[1];
        this.f = "";
        this.g = new HashMap<>();
        this.k = 0;
        this.l = new Semaphore(0);
        this.b = str;
        this.a = w0.a("OfflineSynthesizer", str);
        this.j = new EmbeddedSynthesizerEngine(str);
        this.c = mVar;
    }

    public static boolean a(p pVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, pVar, i)) == null) {
            pVar.getClass();
            if (i != 0 && i != 530 && i != 531) {
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public int a(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        String str5;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, str3, str4)) == null) {
            boolean isEmpty = TextUtils.isEmpty(str3);
            boolean isEmpty2 = TextUtils.isEmpty(str2);
            boolean isEmpty3 = TextUtils.isEmpty(str);
            boolean isEmpty4 = TextUtils.isEmpty(str4);
            String str6 = this.d.l;
            if (isEmpty2 && isEmpty3) {
                u0 u0Var = u0.F0;
                return NetError.ERR_CACHE_RACE;
            }
            Context b2 = b1.d().b();
            byte[] d = w0.d(str);
            byte[] d2 = w0.d(str2);
            byte[] d3 = w0.d(str3);
            byte[] d4 = w0.d(str6);
            if (!w0.b(str2)) {
                str5 = a(str2);
            } else {
                str5 = "";
            }
            String str7 = str5;
            EmbeddedSynthesizerEngine embeddedSynthesizerEngine = this.j;
            String a2 = l2.a(b2);
            if (isEmpty3) {
                bArr = null;
            } else {
                bArr = d;
            }
            if (isEmpty2) {
                bArr2 = null;
            } else {
                bArr2 = d2;
            }
            if (isEmpty) {
                bArr3 = null;
            } else {
                bArr3 = d3;
            }
            int loadSuitedEngine = embeddedSynthesizerEngine.loadSuitedEngine(a2, d4, bArr, bArr2, bArr3, str7, this.e[0]);
            LoggerProxy.d(this.a, "loadSuitedModel ret=" + loadSuitedEngine);
            if (!isEmpty2 && loadSuitedEngine == 0) {
                if (!w0.b(str2) && this.d != null) {
                    long bdTTSGetParam = this.j.bdTTSGetParam(this.e[0], 6);
                    t1 t1Var = this.d;
                    String valueOf = String.valueOf(bdTTSGetParam);
                    t1Var.getClass();
                    try {
                        Long.parseLong(valueOf);
                        t1Var.h = valueOf;
                    } catch (Exception e) {
                        LoggerProxy.d(t1Var.y, e.getMessage());
                        u0 u0Var2 = u0.F0;
                    }
                }
                if (!isEmpty4) {
                    try {
                        JSONObject jSONObject = new JSONObject(str4);
                        String optString = jSONObject.optString("model_speaker_id");
                        String optString2 = jSONObject.optString("model_style_id");
                        LoggerProxy.d(this.a, "set model_speaker_id: " + optString);
                        LoggerProxy.d(this.a, "set model_style_id: " + optString2);
                        try {
                            if (!TextUtils.isEmpty(optString)) {
                                this.j.bdTTSSetParam(this.e[0], 9, Long.parseLong(optString));
                            }
                            if (!TextUtils.isEmpty(optString2)) {
                                this.j.bdTTSSetParam(this.e[0], 10, Long.parseLong(optString2));
                            }
                        } catch (Exception e2) {
                            LoggerProxy.d(this.a, "parseLong exception = " + e2.getMessage());
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
            return loadSuitedEngine;
        }
        return invokeLLLL.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:136:0x006e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0053 */
    /* JADX WARN: Can't wrap try/catch for region: R(8:5|(2:6|7)|(5:9|10|11|12|(3:13|14|(1:16)(1:17)))|18|19|20|(1:22)(3:66|(3:69|(2:71|(3:73|(2:75|(2:77|78)(2:80|81))(2:82|(2:84|(1:105)(5:88|89|90|91|(2:93|(2:95|96)(2:97|98))(2:99|100)))(2:107|108))|79)(2:109|110))(2:111|112)|67)|113)|(4:24|(1:26)(1:64)|27|(2:29|(9:33|34|(1:36)(1:51)|37|38|39|(1:41)|42|(2:44|46)(1:47))(1:31))(4:55|(1:57)(2:60|(1:62)(1:63))|58|59))(1:65)) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x021f, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0220, code lost:
        r0.printStackTrace();
        com.baidu.tts.chainofresponsibility.logger.LoggerProxy.e(r18.a, "offline resource is invalid");
        r0 = com.baidu.tts.z0.a().a(com.baidu.tts.u0.k0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0236: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:74:0x0236 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0238: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:74:0x0236 */
    /* JADX WARN: Removed duplicated region for block: B:116:0x039f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009c A[Catch: JSONException -> 0x021f, TryCatch #11 {JSONException -> 0x021f, blocks: (B:31:0x008f, B:33:0x009c, B:35:0x00b0, B:37:0x00b6, B:39:0x00ce, B:41:0x00dc, B:43:0x0103, B:45:0x010f, B:67:0x01f2, B:46:0x0125, B:47:0x0138, B:49:0x0140, B:51:0x0152, B:53:0x0158, B:58:0x016e, B:60:0x017a, B:62:0x019c, B:63:0x01b1, B:64:0x01c4, B:57:0x016b, B:65:0x01d7, B:66:0x01ea, B:68:0x01fb, B:69:0x020d, B:54:0x015d), top: B:130:0x008f, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0258  */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d a() {
        InterceptResult invokeV;
        d dVar;
        String str;
        d a2;
        JSONObject jSONObject;
        String str2;
        String str3;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        Closeable closeable;
        ?? r11;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str4 = this.d.i;
            Closeable closeable2 = null;
            if (!TextUtils.isEmpty(str4)) {
                LoggerProxy.d(FileUtil.TAG, "resourcePath = " + str4);
                StringBuilder sb = new StringBuilder();
                try {
                    try {
                        fileInputStream = new FileInputStream(new File(str4, "offline_speaker_resource.conf"));
                    } catch (Throwable th) {
                        th = th;
                        inputStreamReader = inputStreamReader2;
                        closeable2 = closeable;
                    }
                } catch (IOException e) {
                    e = e;
                    fileInputStream = null;
                    inputStreamReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    inputStreamReader = null;
                }
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                    try {
                        r11 = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String readLine = r11.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            } catch (IOException e2) {
                                e = e2;
                                e.printStackTrace();
                                w0.a(fileInputStream);
                                w0.a(inputStreamReader);
                                w0.a((Closeable) r11);
                                String sb2 = sb.toString();
                                LoggerProxy.d(FileUtil.TAG, "offline resource = " + sb2);
                                optJSONArray = new JSONObject(sb2).optJSONArray("speaker_info");
                                if (optJSONArray == null) {
                                }
                                if (dVar != null) {
                                }
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        r11 = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        w0.a(fileInputStream);
                        w0.a(inputStreamReader);
                        w0.a(closeable2);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    inputStreamReader = null;
                    r11 = inputStreamReader;
                    e.printStackTrace();
                    w0.a(fileInputStream);
                    w0.a(inputStreamReader);
                    w0.a((Closeable) r11);
                    String sb22 = sb.toString();
                    LoggerProxy.d(FileUtil.TAG, "offline resource = " + sb22);
                    optJSONArray = new JSONObject(sb22).optJSONArray("speaker_info");
                    if (optJSONArray == null) {
                    }
                    if (dVar != null) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = null;
                }
                w0.a(fileInputStream);
                w0.a(inputStreamReader);
                w0.a((Closeable) r11);
                String sb222 = sb.toString();
                LoggerProxy.d(FileUtil.TAG, "offline resource = " + sb222);
                optJSONArray = new JSONObject(sb222).optJSONArray("speaker_info");
                if (optJSONArray == null) {
                    LoggerProxy.e(this.a, "speakerInfo not right");
                    dVar = z0.a().a(u0.k0);
                } else {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i);
                        a aVar = new a();
                        String optString = jSONObject2.optString("speaker");
                        if (!TextUtils.isEmpty(optString)) {
                            aVar.a = optString;
                            String optString2 = jSONObject2.optString("text_file");
                            if (!TextUtils.isEmpty(optString2)) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(str4);
                                String str5 = File.separator;
                                sb3.append(str5);
                                sb3.append(optString2);
                                aVar.c = sb3.toString();
                                String optString3 = jSONObject2.optString("type");
                                aVar.b = optString3;
                                if (TextUtils.equals(optString3, "normal")) {
                                    String optString4 = jSONObject2.optString("speech_file");
                                    if (!TextUtils.isEmpty(optString4)) {
                                        aVar.d = str4 + str5 + optString4;
                                    } else {
                                        LoggerProxy.e(this.a, "speechFile is empty");
                                        dVar = z0.a().a(u0.k0);
                                        break;
                                    }
                                } else if (TextUtils.equals(optString3, "tacotron")) {
                                    String optString5 = jSONObject2.optString("speaker_id");
                                    String optString6 = jSONObject2.optString(MapBundleKey.MapObjKey.OBJ_STYLE_ID);
                                    if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                                        JSONObject jSONObject3 = new JSONObject();
                                        try {
                                            jSONObject3.put("model_speaker_id", optString5);
                                            jSONObject3.put("model_style_id", optString6);
                                            aVar.g = jSONObject3.toString();
                                        } catch (JSONException e5) {
                                            e5.printStackTrace();
                                        }
                                        String optString7 = jSONObject2.optString("tac_file");
                                        if (!TextUtils.isEmpty(optString7)) {
                                            StringBuilder sb4 = new StringBuilder();
                                            sb4.append(str4);
                                            String str6 = File.separator;
                                            sb4.append(str6);
                                            sb4.append(optString7);
                                            aVar.f = sb4.toString();
                                            String optString8 = jSONObject2.optString("subgan_file");
                                            if (!TextUtils.isEmpty(optString8)) {
                                                aVar.e = str4 + str6 + optString8;
                                            } else {
                                                LoggerProxy.e(this.a, "subganFile is empty");
                                                dVar = z0.a().a(u0.k0);
                                                break;
                                            }
                                        } else {
                                            LoggerProxy.e(this.a, "tacFile is empty");
                                            dVar = z0.a().a(u0.k0);
                                            break;
                                        }
                                    } else {
                                        LoggerProxy.e(this.a, "speakerId or styleId is empty");
                                        dVar = z0.a().a(u0.k0);
                                        break;
                                    }
                                } else {
                                    LoggerProxy.e(this.a, "wrong type in speakerInfo");
                                }
                                this.g.put(optString, aVar);
                            } else {
                                LoggerProxy.e(this.a, "textFile is empty");
                                dVar = z0.a().a(u0.k0);
                                break;
                            }
                        } else {
                            LoggerProxy.e(this.a, "speaker cannot be empty if offline resource exists");
                            dVar = z0.a().a(u0.k0);
                            break;
                        }
                    }
                }
                if (dVar != null) {
                    t1 t1Var = this.d;
                    String str7 = t1Var.k;
                    String str8 = t1Var.m;
                    String str9 = t1Var.n;
                    String str10 = t1Var.o;
                    String str11 = t1Var.l;
                    byte[] d = w0.d(str7);
                    byte[] d2 = w0.d(str8);
                    byte[] d3 = w0.d(str9);
                    byte[] d4 = w0.d(str11);
                    LoggerProxy.d(this.a, "convertDatPath:" + str11);
                    Context b2 = b1.d().b();
                    if (!w0.b(str8)) {
                        str = a(str8);
                    } else {
                        str = "";
                    }
                    int bdTTSEngineInit = this.j.bdTTSEngineInit(l2.a(b2), d, d2, d3, d4, str, this.e);
                    long j = this.e[0];
                    LoggerProxy.d(this.a, "engine init ret = " + bdTTSEngineInit);
                    if (bdTTSEngineInit == 0) {
                        if (TextUtils.isEmpty(str10)) {
                            return null;
                        }
                        try {
                            jSONObject = new JSONObject(str10);
                        } catch (JSONException e6) {
                            e6.printStackTrace();
                            jSONObject = null;
                        }
                        if (jSONObject != null) {
                            str3 = jSONObject.optString("model_speaker_id");
                            str2 = jSONObject.optString("model_style_id");
                        } else {
                            str2 = null;
                            str3 = null;
                        }
                        LoggerProxy.d(this.a, "set model_speaker_id initial: " + str3);
                        LoggerProxy.d(this.a, "set model_style_id initial: " + str2);
                        try {
                            if (!TextUtils.isEmpty(str3)) {
                                this.j.bdTTSSetParam(this.e[0], 9, Long.parseLong(str3));
                            }
                            if (TextUtils.isEmpty(str2)) {
                                return null;
                            }
                            this.j.bdTTSSetParam(this.e[0], 10, Long.parseLong(str2));
                            return null;
                        } catch (Exception e7) {
                            LoggerProxy.d(this.a, "parseLong exception = " + e7.getMessage());
                            return null;
                        }
                    }
                    if (bdTTSEngineInit == 12) {
                        a2 = z0.a().a(u0.h0);
                        a2.b = bdTTSEngineInit;
                        a2.c = "offline resources version error";
                        a2.a = null;
                    } else if (bdTTSEngineInit == 13) {
                        a2 = z0.a().a(u0.i0);
                        a2.b = bdTTSEngineInit;
                        a2.c = "offline resources authorize failed";
                        a2.a = null;
                    } else {
                        a2 = z0.a().a(u0.W);
                        a2.b = bdTTSEngineInit;
                        a2.c = "bdTTSEngineInit result not 0";
                        a2.a = null;
                    }
                    return a2;
                }
                return dVar;
            }
            if (b() == -1) {
                dVar = z0.a().a(u0.l0);
            } else {
                dVar = null;
            }
            if (dVar != null) {
            }
        } else {
            return (d) invokeV.objValue;
        }
    }

    public d a(w1 w1Var) throws InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w1Var)) == null) {
            String str = w1Var.a;
            if (this.d.w && Pattern.compile("<(\\S*?)(\\s.*)?>.*?</\\1>").matcher(str).find()) {
                return z0.a().a(u0.j0);
            }
            try {
                if (d0.a(this.b).a()) {
                    return z0.a().a(u0.G0);
                }
                if (b() == 1) {
                    t1 t1Var = this.d;
                    int a2 = a(t1Var.k, t1Var.m, t1Var.n, t1Var.o);
                    if (a2 != 0) {
                        d a3 = z0.a().a(u0.X);
                        a3.b = a2;
                        a3.c = null;
                        a3.a = null;
                        return a3;
                    }
                }
                b bVar = new b(this, w1Var, this.c);
                int i = w1Var.h;
                d call = bVar.call();
                w1Var.b("syn_text", str.substring(i));
                return call;
            } catch (InterruptedException e) {
                LoggerProxy.d(this.a, "offline syn call interrupted!");
                throw e;
            } catch (Exception e2) {
                String str2 = this.a;
                LoggerProxy.d(str2, "offline syn call exception! e=" + e2.getMessage());
                d a4 = z0.a().a(u0.Y);
                a4.a = e2;
                return a4;
            }
        }
        return (d) invokeL.objValue;
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f = EmbeddedSynthesizerEngine.bdTTSGetDatParam(str);
            String str2 = this.a;
            LoggerProxy.d(str2, "before bdTTSEngineInit SpeechInfo: " + this.f);
            try {
                return new JSONObject(this.f).optString("authorize");
            } catch (JSONException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            t1 t1Var = this.d;
            String str = t1Var.j;
            if (str != null) {
                String str2 = this.a;
                LoggerProxy.d(str2, "last speaker " + this.h + " ,will switch speaker " + str);
                if (!TextUtils.equals(this.h, str)) {
                    a aVar = this.g.get(str);
                    if (aVar != null) {
                        this.d.k = aVar.c;
                        String str3 = aVar.b;
                        if (TextUtils.equals(str3, "normal")) {
                            this.d.m = aVar.d;
                        } else if (TextUtils.equals(str3, "tacotron")) {
                            t1 t1Var2 = this.d;
                            t1Var2.m = aVar.f;
                            t1Var2.n = aVar.e;
                            t1Var2.o = aVar.g;
                        } else {
                            LoggerProxy.e(this.a, "speaker type not exists in offline resource");
                            return -1;
                        }
                        this.h = str;
                        this.i = null;
                        String str4 = this.a;
                        LoggerProxy.d(str4, "switch ok ! speaker " + str);
                        return 1;
                    }
                    LoggerProxy.e(this.a, "speaker not exists in offline resource");
                    return -1;
                }
            } else {
                String str5 = t1Var.x;
                if (str5 != null && !TextUtils.equals(this.i, str5)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str5);
                        String optString = jSONObject.optString(SpeechSynthesizer.PARAM_TTS_TEXT_MODEL_FILE);
                        String optString2 = jSONObject.optString(SpeechSynthesizer.PARAM_TTS_SPEECH_MODEL_FILE);
                        String optString3 = jSONObject.optString(SpeechSynthesizer.PARAM_TTS_EXT_SPEECH_MODEL_FILE);
                        String optString4 = jSONObject.optString(SpeechSynthesizer.PARAM_TTS_TAC_SUBGAN_SPEAKER_ATTR);
                        String str6 = this.a;
                        LoggerProxy.d(str6, "textModelPath = " + optString + " , speechModelPath = " + optString2 + ", speechExtFilePath = " + optString3 + ", tacSubganSpeakerAttr = " + optString4);
                        t1 t1Var3 = this.d;
                        t1Var3.k = optString;
                        t1Var3.m = optString2;
                        t1Var3.n = optString3;
                        t1Var3.o = optString4;
                        this.i = str5;
                        this.h = null;
                        String str7 = this.a;
                        LoggerProxy.d(str7, "switch ok ! model " + str5);
                        return 1;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        String str8 = this.a;
                        LoggerProxy.d(str8, "model = " + str5 + " error");
                        return -1;
                    }
                }
            }
            LoggerProxy.d(this.a, "the speakers are the same or not set speaker");
            return 0;
        }
        return invokeV.intValue;
    }
}

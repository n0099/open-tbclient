package com.baidu.tts;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioTrack;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.b2;
import com.baidu.tts.c;
import com.baidu.tts.c0;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.SynthesizerResponse;
import com.baidu.tts.client.TtsEntity;
import com.baidu.tts.client.TtsMode;
import com.baidu.tts.e2;
import com.baidu.tts.g;
import com.baidu.tts.jni.TtsLogLoad;
import com.baidu.tts.receiver.TestCommandReceiver;
import com.baidu.tts.t;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final x1 c;
    public final o d;
    public c0 e;
    public c f;
    public final b2 g;
    public final m h;

    /* loaded from: classes9.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler a;
        public h2 b;
        public final /* synthetic */ a c;

        /* renamed from: com.baidu.tts.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class HandlerC0550a extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SpeechSynthesizerListener a;
            public final /* synthetic */ c b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandlerC0550a(c cVar, Looper looper, a aVar, SpeechSynthesizerListener speechSynthesizerListener) {
                super(looper);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, looper, aVar, speechSynthesizerListener};
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
                this.b = cVar;
                this.a = speechSynthesizerListener;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    if (message.what != 1) {
                        String str = this.b.c.a;
                        LoggerProxy.d(str, "Unknown event type: " + message.what);
                        return;
                    }
                    SpeechSynthesizerListener speechSynthesizerListener = this.a;
                    if (speechSynthesizerListener != null) {
                        speechSynthesizerListener.onSynthesizeResponse((com.baidu.tts.c) message.obj);
                    }
                }
            }
        }

        public c(a aVar, SpeechSynthesizerListener speechSynthesizerListener, Handler handler) {
            Looper looper;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, speechSynthesizerListener, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = aVar;
            if (handler != null) {
                looper = handler.getLooper();
            } else {
                Integer a = k2.a();
                String str = "bds-cBack-" + aVar.b;
                if (a != null) {
                    this.b = new h2(str, a.intValue());
                } else {
                    this.b = new h2(str);
                }
                this.b.start();
                looper = this.b.getLooper();
            }
            if (looper != null) {
                this.a = new HandlerC0550a(this, looper, aVar, speechSynthesizerListener);
            } else {
                this.a = null;
            }
        }
    }

    /* renamed from: com.baidu.tts.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0549a implements m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0549a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.tts.m
        public void a(v1 v1Var) {
            String str;
            c cVar;
            Handler handler;
            com.baidu.tts.c cVar2;
            int i;
            String str2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, v1Var) == null) && v1Var != null) {
                l0 l0Var = v1Var.a;
                w1 w1Var = v1Var.i;
                String str3 = w1Var.g;
                a aVar = this.a;
                aVar.getClass();
                w1 w1Var2 = v1Var.i;
                com.baidu.tts.c cVar3 = null;
                if (w1Var2 != null) {
                    str = w1Var2.b;
                } else {
                    LoggerProxy.d(aVar.a, "getUtteranceId null");
                    str = null;
                }
                switch (l0Var.ordinal()) {
                    case 0:
                        SynthesizerResponse.SynthesizeType synthesizeType = SynthesizerResponse.SynthesizeType.SYNTHESIZE_START;
                        a aVar2 = this.a;
                        cVar3 = new com.baidu.tts.c(synthesizeType, str3, str, aVar2.b);
                        LoggerProxy.d(aVar2.a, "onSynthesizeStart sn = " + str3);
                        break;
                    case 1:
                        SynthesizerResponse.SynthesizeType synthesizeType2 = SynthesizerResponse.SynthesizeType.SYNTHESIZE_FINISH;
                        a aVar3 = this.a;
                        cVar3 = new com.baidu.tts.c(synthesizeType2, str3, str, aVar3.b);
                        if (w1Var.c == p0.b) {
                            a.a(aVar3, v1Var);
                        }
                        LoggerProxy.d(this.a.a, "onSynthesizeFinished sn = " + str3);
                        break;
                    case 2:
                        byte[] bArr = v1Var.g;
                        int i2 = v1Var.d;
                        int i3 = v1Var.b;
                        int i4 = v1Var.k.a;
                        SynthesizerResponse.SynthesizeType synthesizeType3 = SynthesizerResponse.SynthesizeType.SYNTHESIZE_DATA_ARRIVED;
                        a aVar4 = this.a;
                        cVar2 = new com.baidu.tts.c(synthesizeType3, str3, str, aVar4.b, new c.a(bArr, i2, i3, i4), null);
                        if (w1Var.c == p0.b) {
                            a.a(aVar4, v1Var);
                        }
                        cVar3 = cVar2;
                        break;
                    case 3:
                        SynthesizerResponse.SynthesizeType synthesizeType4 = SynthesizerResponse.SynthesizeType.SYNTHESIZE_STOP;
                        a aVar5 = this.a;
                        cVar3 = new com.baidu.tts.c(synthesizeType4, str3, str, aVar5.b);
                        LoggerProxy.d(aVar5.a, "onSynthesizeStop sn = " + str3);
                        break;
                    case 4:
                        com.baidu.tts.d dVar = v1Var.j;
                        if (dVar != null) {
                            i = dVar.getDetailCode();
                            str2 = dVar.getDetailMessage();
                        } else {
                            u0 u0Var = u0.U0;
                            i = -9999;
                            str2 = DownloadStatisticConstants.UBC_VALUE_UNKNOW;
                        }
                        cVar2 = new com.baidu.tts.c(SynthesizerResponse.SynthesizeType.SYNTHESIZE_ERROR, str3, str, this.a.b, null, new c.b(i, str2));
                        u0 a = v1Var.j.a();
                        LoggerProxy.d(this.a.a, "onError sn = " + str3 + " , msg = " + a.b + " , code = " + a.a);
                        cVar3 = cVar2;
                        break;
                    case 5:
                        SynthesizerResponse.SynthesizeType synthesizeType5 = SynthesizerResponse.SynthesizeType.PLAY_START;
                        a aVar6 = this.a;
                        cVar3 = new com.baidu.tts.c(synthesizeType5, str3, str, aVar6.b);
                        LoggerProxy.d(aVar6.a, "onPlayStart sn = " + str3);
                        break;
                    case 6:
                        cVar2 = new com.baidu.tts.c(SynthesizerResponse.SynthesizeType.PLAY_PROGRESS, str3, str, this.a.b, new c.a(v1Var.g, v1Var.d, v1Var.b, v1Var.k.a), null);
                        cVar3 = cVar2;
                        break;
                    case 7:
                        f0.a(this.a.b).a(v1Var.j, str3);
                        SynthesizerResponse.SynthesizeType synthesizeType6 = SynthesizerResponse.SynthesizeType.PLAY_FINISH;
                        a aVar7 = this.a;
                        cVar3 = new com.baidu.tts.c(synthesizeType6, str3, str, aVar7.b);
                        LoggerProxy.d(aVar7.a, "onPlayFinish sn = " + str3);
                        break;
                }
                if (cVar3 != null && (cVar = this.a.f) != null && (handler = cVar.a) != null) {
                    try {
                        handler.sendMessage(handler.obtainMessage(1, cVar3));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Callable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Void, java.lang.Object] */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    this.a.d.a();
                    return null;
                } catch (InterruptedException unused) {
                    LoggerProxy.d(this.a.a, "create connections interrupted!");
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Callable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final w1 a;
        public final /* synthetic */ a b;

        public d(a aVar, w1 w1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, w1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aVar;
            this.a = w1Var;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Void, java.lang.Object] */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    this.a.k.h = System.currentTimeMillis();
                    this.b.h.a(new v1(l0.a, this.a, null));
                    com.baidu.tts.d a = this.b.d.a(this.a);
                    if (a == null) {
                        LoggerProxy.d(this.b.a, "synthesize has finished successfully.");
                        this.b.h.a(new v1(l0.b, this.a, null));
                    } else {
                        this.b.h.a(new v1(l0.e, this.a, a));
                    }
                } catch (InterruptedException unused) {
                    LoggerProxy.d(this.b.a, "synthesize interrupted!");
                    this.b.h.a(new v1(l0.d, this.a, null));
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    public a(Context context, String str) {
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
        C0549a c0549a = new C0549a(this);
        this.h = c0549a;
        this.a = w0.a("SpeechSynthesizerAdapter", str);
        this.b = str;
        b1.d().a(context);
        x1 x1Var = new x1(str);
        this.c = x1Var;
        this.d = new o(str, x1Var, c0549a);
        this.g = new b2(str, x1Var.c(), c0549a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:3|6|14|15|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
        com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r6.a, r7.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:
        r7 = r0.getQueue().size();
        r0 = r6.a;
        com.baidu.tts.chainofresponsibility.logger.LoggerProxy.e(r0, " count=" + r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(a aVar, v1 v1Var) {
        c0 c0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, aVar, v1Var) == null) {
            b2 b2Var = aVar.g;
            synchronized (b2Var) {
                synchronized (b2Var) {
                    if (b2Var.d == null) {
                        String str = b2Var.b;
                        b2Var.d = new c0(Integer.MAX_VALUE, new x0(str, "bds-playPool"), new c0.a());
                    }
                    c0Var = b2Var.d;
                }
            }
            c0Var.submit(new b2.a(b2Var, v1Var));
        }
    }

    public final c0 a() {
        InterceptResult invokeV;
        c0 c0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.e == null) {
                    this.e = new c0(5, new x0(this.b, "bds-engine"), new ThreadPoolExecutor.AbortPolicy());
                }
                c0Var = this.e;
            }
            return c0Var;
        }
        return (c0) invokeV.objValue;
    }

    public com.baidu.tts.d a(TtsEntity ttsEntity, p0 p0Var) {
        InterceptResult invokeLL;
        u0 u0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ttsEntity, p0Var)) == null) {
            if (ttsEntity == null) {
                return z0.a().a(u0.w0);
            }
            g2 g2Var = new g2();
            g2Var.f = System.currentTimeMillis();
            String text = ttsEntity.getText();
            if (TextUtils.isEmpty(text)) {
                u0Var = u0.w0;
            } else {
                try {
                    if (text.getBytes("gbk").length > 1024) {
                        u0Var = u0.x0;
                    } else {
                        u0Var = null;
                    }
                } catch (UnsupportedEncodingException unused) {
                    u0Var = u0.y0;
                }
            }
            g2Var.g = System.currentTimeMillis();
            if (u0Var == null) {
                String str = this.a;
                LoggerProxy.d(str, "synthesizeOrSpeak " + ttsEntity + " , methodEnum " + p0Var);
                TtsMode ttsMode = ttsEntity.getTtsMode();
                t0 ttsEnum = ttsMode.getTtsEnum();
                h a = g.a.a.a(ttsMode.getTtsEnum(), this.c);
                if (!a.c()) {
                    return a.a();
                }
                String str2 = this.a;
                LoggerProxy.d(str2, "init ttsEnum " + ttsEnum + " " + b(ttsEnum));
                if (!b(ttsEnum)) {
                    com.baidu.tts.d a2 = a(ttsEnum);
                    if (a2 == null) {
                        LoggerProxy.d(this.a, "initTts  success ");
                        return a(ttsEntity, p0Var, g2Var);
                    } else if (a2.a() == u0.r0) {
                        LoggerProxy.d(this.a, "initTts offline failed but online success");
                        return a(ttsEntity, p0Var, g2Var);
                    } else {
                        String str3 = this.a;
                        LoggerProxy.d(str3, "initTts  error = " + a2.getDetailCode());
                        return a2;
                    }
                }
                return a(ttsEntity, p0Var, g2Var);
            }
            return z0.a().a(u0Var);
        }
        return (com.baidu.tts.d) invokeLL.objValue;
    }

    public final com.baidu.tts.d a(TtsEntity ttsEntity, p0 p0Var, g2 g2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, ttsEntity, p0Var, g2Var)) == null) {
            w1 w1Var = new w1(ttsEntity);
            w1Var.c = p0Var;
            g2Var.e = w1Var.a;
            g2Var.c = w1Var.g;
            g2Var.d = this.b;
            w1Var.k = g2Var;
            if (p0Var == p0.b) {
                a2 a2Var = this.g.c;
                if (!a2Var.r) {
                    a2Var.a();
                }
                a2 a2Var2 = this.g.c;
                LoggerProxy.d(a2Var2.b, "audioTrack play before");
                try {
                    AudioTrack audioTrack = a2Var2.d;
                    if (audioTrack != null) {
                        audioTrack.play();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                LoggerProxy.d(a2Var2.b, "audioTrack play end");
            }
            synchronized (this) {
                c0 a = a();
                try {
                    a.submit(new d(this, w1Var));
                } catch (RejectedExecutionException unused) {
                    int size = a.getQueue().size();
                    String str = this.a;
                    LoggerProxy.e(str, " count=" + size);
                    return z0.a().a(u0.B0);
                } catch (Exception e2) {
                    LoggerProxy.d(this.a, e2.toString());
                    return z0.a().a(u0.B0);
                }
            }
            return null;
        }
        return (com.baidu.tts.d) invokeLLL.objValue;
    }

    public com.baidu.tts.d a(t0 t0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t0Var)) == null) {
            o oVar = this.d;
            q1 q1Var = oVar.c;
            String str = q1Var.b.q;
            String str2 = q1Var.a.h;
            int i = e2.j;
            e2 e2Var = e2.b.a;
            x1 x1Var = oVar.a;
            synchronized (e2Var) {
                LoggerProxy.d("NetworkCallback", "registerNetworkCallback hasRegister = " + e2Var.c);
                if (!e2Var.c) {
                    e2Var.i = x1Var;
                    boolean z = x1Var.b.d;
                    LoggerProxy.d("NetworkCallback", "registerNetworkCallback verify network " + z);
                    e2Var.f = z;
                    ConnectivityManager connectivityManager = (ConnectivityManager) b1.d().b().getSystemService("connectivity");
                    e2Var.a = connectivityManager;
                    if (connectivityManager != null) {
                        NetworkRequest.Builder builder = new NetworkRequest.Builder();
                        if (z && Build.VERSION.SDK_INT >= 23) {
                            builder.addCapability(16);
                        }
                        try {
                            e2Var.a.registerNetworkCallback(builder.addCapability(12).build(), e2Var);
                            e2Var.c = true;
                        } catch (Exception unused) {
                            LoggerProxy.w("NetworkCallback", "registerNetworkCallback exception.");
                        }
                    } else {
                        LoggerProxy.e("NetworkCallback", "fatal error, ConnectivityManager fetch failed.");
                    }
                    if (!e2Var.c) {
                        try {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
                            e2Var.h = new e2.a(e2Var);
                            b1.d().b().registerReceiver(e2Var.h, intentFilter);
                            e2Var.c = true;
                        } catch (Exception unused2) {
                            LoggerProxy.w("NetworkCallback", "NetworkChangeReceiver register exception.");
                        }
                    }
                    t tVar = t.a.a;
                    String str3 = e2Var.i.b.a.q;
                    synchronized (tVar) {
                        if (!TextUtils.isEmpty(str3)) {
                            tVar.c = str3;
                        }
                        if (tVar.e == null) {
                            Integer num = k2.b;
                            if (num != null) {
                                tVar.e = new h2("bds-dns", num.intValue());
                            } else {
                                tVar.e = new h2("bds-dns");
                            }
                            tVar.e.start();
                            tVar.a = new Handler(tVar.e.getLooper());
                            tVar.d = false;
                            tVar.b = new s(tVar);
                        }
                    }
                }
            }
            int i2 = TestCommandReceiver.b;
            TestCommandReceiver testCommandReceiver = TestCommandReceiver.b.a;
            synchronized (testCommandReceiver) {
                IntentFilter intentFilter2 = new IntentFilter("baidu.tts.action.log");
                intentFilter2.addAction("baidu.tts.action.log.SAVE_OFFLINE");
                intentFilter2.addAction("baidu.tts.action.log.SAVE_AUDIO");
                intentFilter2.addAction("baidu.tts.action.log.SAVE_SDK");
                intentFilter2.addAction("baidu.tts.action.test.PACKAGE_NAME");
                b1.d().b().registerReceiver(testCommandReceiver, intentFilter2);
            }
            f0 a = f0.a(oVar.b);
            q1 q1Var2 = oVar.c;
            boolean z2 = q1Var2.e;
            String str4 = q1Var2.f;
            a.i = z2;
            a.h = str;
            a.g = str2;
            TtsLogLoad.getInstance().init(str4, str2);
            d0 a2 = d0.a(oVar.b);
            if (!a2.n) {
                a2.m.start();
                a2.n = true;
            }
            LoggerProxy.d(oVar.i, "initial  " + t0Var);
            if (t0Var == t0.d) {
                if ((oVar.h & 1) == 0) {
                    com.baidu.tts.d a3 = oVar.e.a();
                    oVar.g = a3;
                    if (a3 == null) {
                        oVar.h |= 1;
                    } else {
                        return a3;
                    }
                } else {
                    LoggerProxy.d(oVar.i, "OfflineSynthesizer already init ");
                }
            } else if (t0Var == t0.c) {
                if (((oVar.h >> 1) & 1) == 0) {
                    oVar.d.getClass();
                    oVar.h |= 2;
                } else {
                    LoggerProxy.d(oVar.i, "OnlineSynthesizer already init ");
                }
            } else if (t0Var == t0.e) {
                if ((oVar.h & 1) == 0) {
                    com.baidu.tts.d a4 = oVar.e.a();
                    oVar.g = a4;
                    if (a4 == null) {
                        oVar.h |= 1;
                    }
                } else {
                    LoggerProxy.d(oVar.i, "OfflineSynthesizer already init ");
                }
                if (((oVar.h >> 1) & 1) == 0) {
                    oVar.d.getClass();
                    oVar.h |= 2;
                } else {
                    LoggerProxy.d(oVar.i, "OnlineSynthesizer already init ");
                }
                if (oVar.g != null) {
                    return z0.a().a(u0.r0);
                }
            }
            return null;
        }
        return (com.baidu.tts.d) invokeL.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                c0 c0Var = this.e;
                if (c0Var != null) {
                    if (!c0Var.isShutdown()) {
                        this.e.shutdownNow();
                    }
                    try {
                        LoggerProxy.d(this.a, "before awaitTermination");
                        boolean awaitTermination = this.e.awaitTermination(10000L, TimeUnit.MILLISECONDS);
                        String str = this.a;
                        LoggerProxy.d(str, "after awaitTermination isTermination=" + awaitTermination);
                        d0.a(this.b).b();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.e = null;
            }
            b2 b2Var = this.g;
            b2Var.c.d();
            synchronized (b2Var) {
                c0 c0Var2 = b2Var.d;
                if (c0Var2 != null) {
                    if (!c0Var2.isShutdown()) {
                        b2Var.d.shutdownNow();
                    }
                    try {
                        LoggerProxy.d(b2Var.a, "before awaitTermination");
                        boolean awaitTermination2 = b2Var.d.awaitTermination(LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION, TimeUnit.MILLISECONDS);
                        String str2 = b2Var.a;
                        LoggerProxy.d(str2, "after awaitTermination isTermination=" + awaitTermination2);
                        d0.a(b2Var.b).b();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                b2Var.d = null;
            }
            b2Var.c.d();
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean b(t0 t0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t0Var)) == null) {
            o oVar = this.d;
            oVar.getClass();
            if (t0Var == t0.d) {
                if ((oVar.h & 1) == 1) {
                    return true;
                }
            } else if (t0Var == t0.c) {
                if (((oVar.h >> 1) & 1) == 1) {
                    return true;
                }
            } else if (t0Var == t0.e && (oVar.h & 3) == 3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}

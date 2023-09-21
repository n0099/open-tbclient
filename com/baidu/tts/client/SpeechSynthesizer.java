package com.baidu.tts.client;

import android.content.Context;
import android.media.AudioTrack;
import android.net.ConnectivityManager;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.a;
import com.baidu.tts.a2;
import com.baidu.tts.b;
import com.baidu.tts.b1;
import com.baidu.tts.c0;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.d;
import com.baidu.tts.d0;
import com.baidu.tts.e2;
import com.baidu.tts.f0;
import com.baidu.tts.g;
import com.baidu.tts.h;
import com.baidu.tts.h2;
import com.baidu.tts.k2;
import com.baidu.tts.n0;
import com.baidu.tts.n1;
import com.baidu.tts.o;
import com.baidu.tts.o1;
import com.baidu.tts.p;
import com.baidu.tts.p0;
import com.baidu.tts.q;
import com.baidu.tts.q0;
import com.baidu.tts.receiver.TestCommandReceiver;
import com.baidu.tts.s0;
import com.baidu.tts.t0;
import com.baidu.tts.t1;
import com.baidu.tts.u0;
import com.baidu.tts.w0;
import com.baidu.tts.x1;
import com.baidu.tts.z0;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.concurrent.RejectedExecutionException;
import okhttp3.WebSocket;
import org.chromium.net.NetError;
/* loaded from: classes9.dex */
public class SpeechSynthesizer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUDIO_BITRATE_OPUS_128K;
    public static final String AUDIO_BITRATE_OPUS_16K;
    public static final String AUDIO_BITRATE_OPUS_32K;
    public static final String AUDIO_BITRATE_OPUS_64K;
    public static final String AUDIO_BITRATE_PCM;
    public static final String AUDIO_ENCODE_OPUS;
    public static final String AUDIO_ENCODE_PCM;
    public static final int AUDIO_SAMPLERATE_16K;
    public static final int AUDIO_SAMPLERATE_24K;
    public static final int AUDIO_SAMPLERATE_8K;
    public static final int ERROR_APP_ID_IS_INVALID;
    public static final int ERROR_LIST_IS_TOO_LONG;
    public static final int ERROR_QUEUE_IS_FULL;
    public static final int ERROR_TEXT_ENCODE_IS_WRONG;
    public static final int ERROR_TEXT_IS_EMPTY;
    public static final int ERROR_TEXT_IS_TOO_LONG;
    public static final String LANGUAGE_EN;
    public static final String LANGUAGE_ZH;
    public static final int MAX_ONLINE_REQUEST_TIMEOUT = 6000;
    public static final int MAX_QUEUE_SIZE = 5;
    public static final int MIN_ONLINE_REQUEST_TIMEOUT = 200;
    public static final String MIX_MODE_DEFAULT;
    public static final String MIX_MODE_HIGH_SPEED_NETWORK;
    public static final String MIX_MODE_HIGH_SPEED_NETWORK_WITHOUT_ETHER;
    public static final String PARAM_APP_ID;
    public static final String PARAM_AUDIO_CTRL;
    public static final String PARAM_AUDIO_ENCODE;
    public static final String PARAM_AUDIO_RATE;
    public static final String PARAM_AUTH_SN;
    public static final String PARAM_BILINGUAL_MODE;
    public static final String PARAM_BIND_CORE;
    public static final String PARAM_CITYID;
    public static final String PARAM_ENABLE_UPLOAD_LOG;
    public static final String PARAM_ENABLE_WM;
    public static final String PARAM_INTERCEPT_SSML;
    public static final String PARAM_KEY;
    public static final String PARAM_LANGUAGE;
    public static final String PARAM_LIP_CTRL;
    public static final String PARAM_LIP_ENABLE;
    public static final String PARAM_MIX_MODE;
    public static final String PARAM_MIX_TIMEOUT_FOUR_SECOND;
    public static final String PARAM_MIX_TIMEOUT_ONE_SECOND;
    public static final String PARAM_MIX_TIMEOUT_THREE_SECOND;
    public static final String PARAM_MIX_TIMEOUT_TWO_SECOND;
    public static final String PARAM_OFFLINE_MODEL;
    public static final String PARAM_OFFLINE_SPEAKER;
    public static final String PARAM_OFFLINE_SPEED;
    public static final String PARAM_OFFLINE_SYNTHESIZE_SLEEP_DIVISOR;
    public static final String PARAM_ONLINE_SPEAKER;
    public static final String PARAM_ONLINE_SPEED;
    public static final String PARAM_ONLINE_TIMEOUT;
    public static final String PARAM_OPEN_XML;
    public static final String PARAM_PITCH;
    public static final String PARAM_PLAYER_CONTENT_TYPE;
    public static final String PARAM_PLAYER_POLICY;
    public static final String PARAM_PLAYER_USAGE;
    public static final String PARAM_PLAYER_VOLUME;
    public static final String PARAM_PRE_CREATE_CONNECTIONS;
    public static final String PARAM_PRODUCT_ID;
    public static final String PARAM_REC_PER = "rec_per";
    public static final String PARAM_REQUEST_ENABLE_DNS;
    public static final String PARAM_SPEC;
    public static final String PARAM_SPEED;
    public static final String PARAM_STAT_PARAM;
    public static final String PARAM_TEXT_CTRL;
    public static final String PARAM_TEXT_POS;
    public static final String PARAM_THREAD_PRIORITY;
    public static final String PARAM_TTS_CONVERT_MODEL_FILE;
    public static final String PARAM_TTS_EXT_SPEECH_MODEL_FILE;
    public static final String PARAM_TTS_LICENCE_FILE;
    public static final String PARAM_TTS_OFFLINE_RESOURCE;
    public static final String PARAM_TTS_SPEECH_MODEL_FILE;
    public static final String PARAM_TTS_TAC_SUBGAN_SPEAKER_ATTR;
    public static final String PARAM_TTS_TEXT_MODEL_FILE;
    public static final String PARAM_UPLOAD_LOG_URL;
    public static final String PARAM_URL;
    public static final String PARAM_USERID;
    public static final String PARAM_VOCODER_OPTIM_LEVEL;
    public static final String PARAM_VOLUME;
    public static final String PLAYER_STREAM_TYPE;
    public static final String REQUEST_DNS_OFF = "0";
    public static final String REQUEST_DNS_ON = "1";
    public static final String REQUEST_HTTP_DNS_ON = "2";
    public static final String REQUEST_PROTOCOL_HTTP = "http";
    public static final String REQUEST_PROTOCOL_HTTPS = "https";
    public static final String REQUEST_PROTOCOL_WS = "ws";
    public static final String REQUEST_PROTOCOL_WSS = "wss";
    public static final String TEXT_ENCODE_BIG5;
    public static final String TEXT_ENCODE_GBK;
    public static final String TEXT_ENCODE_UTF8;
    public static final String VERIFY_NETWORK_VALID;
    public transient /* synthetic */ FieldHolder $fh;
    public final a a;
    public final String b;
    public final String c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(505485615, "Lcom/baidu/tts/client/SpeechSynthesizer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(505485615, "Lcom/baidu/tts/client/SpeechSynthesizer;");
                return;
            }
        }
        u0 u0Var = u0.B0;
        ERROR_QUEUE_IS_FULL = -402;
        u0 u0Var2 = u0.C0;
        ERROR_LIST_IS_TOO_LONG = -403;
        u0 u0Var3 = u0.w0;
        ERROR_TEXT_IS_EMPTY = NetError.ERR_INVALID_URL;
        u0 u0Var4 = u0.x0;
        ERROR_TEXT_IS_TOO_LONG = -301;
        u0 u0Var5 = u0.y0;
        ERROR_TEXT_ENCODE_IS_WRONG = -302;
        u0 u0Var6 = u0.E0;
        ERROR_APP_ID_IS_INVALID = -405;
        PARAM_REQUEST_ENABLE_DNS = n0.a(n0.A0);
        PARAM_URL = n0.a(n0.h);
        PARAM_AUDIO_CTRL = n0.a(n0.K0);
        PARAM_TEXT_CTRL = n0.a(n0.M0);
        PARAM_LIP_CTRL = n0.a(n0.N0);
        PARAM_LIP_ENABLE = n0.a(n0.O0);
        PARAM_STAT_PARAM = n0.a(n0.Q0);
        PARAM_TEXT_POS = n0.a(n0.S0);
        PARAM_SPEED = n0.a(n0.M);
        PARAM_OFFLINE_SPEED = n0.a(n0.O);
        PARAM_ONLINE_SPEED = n0.a(n0.N);
        PARAM_PITCH = n0.a(n0.R);
        PARAM_VOLUME = n0.a(n0.Q);
        PARAM_SPEC = n0.a(n0.y0);
        PARAM_TTS_OFFLINE_RESOURCE = n0.a(n0.b0);
        PARAM_OFFLINE_SPEAKER = n0.a(n0.c0);
        PARAM_OFFLINE_MODEL = n0.a(n0.d0);
        PARAM_TTS_TEXT_MODEL_FILE = n0.a(n0.e0);
        PARAM_TTS_SPEECH_MODEL_FILE = n0.a(n0.f0);
        PARAM_TTS_CONVERT_MODEL_FILE = n0.a(n0.g0);
        PARAM_TTS_EXT_SPEECH_MODEL_FILE = n0.a(n0.h0);
        PARAM_TTS_TAC_SUBGAN_SPEAKER_ATTR = n0.a(n0.y);
        PARAM_TTS_LICENCE_FILE = n0.a(n0.i0);
        PARAM_VOCODER_OPTIM_LEVEL = n0.a(n0.l0);
        PARAM_INTERCEPT_SSML = n0.a(n0.P);
        PARAM_OPEN_XML = n0.a(n0.k0);
        PARAM_BILINGUAL_MODE = n0.a(n0.G0);
        PARAM_PRODUCT_ID = n0.a(n0.Z);
        PARAM_APP_ID = n0.a(n0.I);
        PARAM_KEY = n0.a(n0.z0);
        PARAM_AUTH_SN = n0.a(n0.J);
        PARAM_LANGUAGE = n0.a(n0.S);
        PARAM_AUDIO_ENCODE = n0.a(n0.f1185T);
        PARAM_AUDIO_RATE = n0.a(n0.U);
        PARAM_PLAYER_VOLUME = n0.a(n0.V);
        PLAYER_STREAM_TYPE = n0.a(n0.W);
        PARAM_PLAYER_USAGE = n0.a(n0.X);
        PARAM_PLAYER_CONTENT_TYPE = n0.a(n0.Y);
        PARAM_ONLINE_SPEAKER = n0.a(n0.a0);
        PARAM_MIX_MODE = n0.a(n0.D);
        MIX_MODE_DEFAULT = q0.a.name();
        MIX_MODE_HIGH_SPEED_NETWORK = q0.b.name();
        MIX_MODE_HIGH_SPEED_NETWORK_WITHOUT_ETHER = q0.c.name();
        VERIFY_NETWORK_VALID = n0.a(n0.E);
        PARAM_PLAYER_POLICY = n0.a(n0.F);
        PARAM_ONLINE_TIMEOUT = n0.a(n0.H0);
        PARAM_THREAD_PRIORITY = n0.a(n0.Z0);
        PARAM_BIND_CORE = n0.a(n0.a1);
        PARAM_OFFLINE_SYNTHESIZE_SLEEP_DIVISOR = n0.a(n0.b1);
        PARAM_PRE_CREATE_CONNECTIONS = n0.a(n0.c1);
        PARAM_MIX_TIMEOUT_ONE_SECOND = s0.f.name();
        PARAM_MIX_TIMEOUT_TWO_SECOND = s0.c.name();
        PARAM_MIX_TIMEOUT_THREE_SECOND = s0.d.name();
        PARAM_MIX_TIMEOUT_FOUR_SECOND = s0.e.name();
        LANGUAGE_ZH = "ZH";
        LANGUAGE_EN = "EN";
        TEXT_ENCODE_GBK = "0";
        TEXT_ENCODE_BIG5 = "1";
        TEXT_ENCODE_UTF8 = "2";
        AUDIO_ENCODE_OPUS = "2";
        AUDIO_ENCODE_PCM = "4";
        AUDIO_SAMPLERATE_8K = 8000;
        AUDIO_SAMPLERATE_16K = 16000;
        AUDIO_SAMPLERATE_24K = 24000;
        AUDIO_BITRATE_OPUS_16K = "16";
        AUDIO_BITRATE_OPUS_32K = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
        AUDIO_BITRATE_OPUS_64K = "64";
        AUDIO_BITRATE_OPUS_128K = "128";
        AUDIO_BITRATE_PCM = "0";
        PARAM_CITYID = n0.a(n0.T0);
        PARAM_USERID = n0.a(n0.U0);
        PARAM_ENABLE_UPLOAD_LOG = n0.a(n0.V0);
        PARAM_UPLOAD_LOG_URL = n0.a(n0.W0);
        PARAM_ENABLE_WM = n0.a(n0.X0);
    }

    public synchronized int release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                LoggerProxy.d(this.b, "release");
                a aVar = this.a;
                aVar.b();
                o oVar = aVar.d;
                q qVar = oVar.d;
                n1 n1Var = qVar.f;
                if (n1Var != null) {
                    o1 o1Var = n1Var.c;
                    synchronized (o1Var) {
                        LoggerProxy.d(o1Var.a, "start cancel.");
                        WebSocket webSocket = o1Var.d;
                        if (webSocket != null) {
                            webSocket.cancel();
                        }
                        o1.m.remove(o1Var.b);
                    }
                }
                qVar.b.shutdownNow();
                p pVar = oVar.e;
                pVar.j.bdTTSEngineUninit(pVar.e[0]);
                oVar.f.a = null;
                f0 a = f0.a(aVar.b);
                f0.s.remove(a.b);
                a.c.shutdownNow();
                d0 a2 = d0.a(aVar.b);
                if (a2.n && !a2.k) {
                    a2.k = true;
                    a2.e.clear();
                    a2.m.interrupt();
                    try {
                        LoggerProxy.d(a2.b, "wait thread exit+++.");
                        a2.l.acquire();
                        LoggerProxy.d(a2.b, "wait thread exit---");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    d0.r.remove(a2.a);
                    a2.c.release(a2.a);
                }
                aVar.g.c.b();
                a.c cVar = aVar.f;
                if (cVar != null) {
                    Handler handler = cVar.a;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                    h2 h2Var = cVar.b;
                    if (h2Var != null) {
                        h2Var.quit();
                    }
                }
                b bVar = b.a.a;
                String str = this.c;
                if (bVar.a.containsKey(str)) {
                    bVar.a.remove(str);
                    LoggerProxy.d("SynthesizerStats", "unregisterSynthesizer " + str + " ,  count " + bVar.a.size());
                    if (bVar.a.size() == 0) {
                        k2.b = k2.a;
                        g gVar = g.a.a;
                        gVar.a.a.clear();
                        gVar.b.a.clear();
                        int i = TestCommandReceiver.b;
                        TestCommandReceiver testCommandReceiver = TestCommandReceiver.b.a;
                        synchronized (testCommandReceiver) {
                            testCommandReceiver.a = false;
                            Context b = b1.d().b();
                            if (b != null) {
                                try {
                                    b.unregisterReceiver(testCommandReceiver);
                                } catch (Exception e2) {
                                    LoggerProxy.e("TestCommandReceiver", e2.getMessage());
                                }
                            }
                        }
                        int i2 = e2.j;
                        e2 e2Var = e2.b.a;
                        synchronized (e2Var) {
                            LoggerProxy.d("NetworkCallback", "unRegisterReceiver");
                            try {
                                if (e2Var.h != null) {
                                    b1.d().b().unregisterReceiver(e2Var.h);
                                    e2Var.h = null;
                                }
                            } catch (Exception unused) {
                                LoggerProxy.w("NetworkCallback", "unregisterReceiver exception.");
                            }
                            try {
                                ConnectivityManager connectivityManager = e2Var.a;
                                if (connectivityManager != null) {
                                    connectivityManager.unregisterNetworkCallback(e2Var);
                                }
                            } catch (IllegalArgumentException unused2) {
                            } catch (Exception unused3) {
                                LoggerProxy.w("NetworkCallback", "unregisterNetworkCallback exception.");
                                e2Var.e.clear();
                                e2Var.c = false;
                                e2Var.d = "";
                                e2Var.g = false;
                            }
                            e2Var.e.clear();
                            e2Var.c = false;
                            e2Var.d = "";
                            e2Var.g = false;
                            e2Var.b = e2.c.c;
                            e2Var.d();
                        }
                        b1 d = b1.d();
                        d.a.clear();
                        d.b = null;
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public SpeechSynthesizer(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        String a = b.a().a(this);
        this.c = a;
        String a2 = w0.a("SpeechSynthesizer", a);
        this.b = a2;
        LoggerProxy.d(a2, "VersionName: 6.0.5.5f65dca VersionName_CODE: 28");
        this.a = new a(context, a);
    }

    public synchronized ITtsError speak(TtsEntity ttsEntity) {
        InterceptResult invokeL;
        d a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, ttsEntity)) == null) {
            synchronized (this) {
                LoggerProxy.d(this.b, "speak");
                a = this.a.a(ttsEntity, p0.b);
                if (a == null) {
                    a = new d();
                }
                String str = this.b;
                LoggerProxy.d(str, "speak result = " + a.getDetailCode() + " , message = " + a.getDetailMessage());
            }
            return a;
        }
        return (ITtsError) invokeL.objValue;
    }

    public synchronized ITtsError synthesize(TtsEntity ttsEntity) {
        InterceptResult invokeL;
        d a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, ttsEntity)) == null) {
            synchronized (this) {
                LoggerProxy.d(this.b, "synthesize");
                a = this.a.a(ttsEntity, p0.a);
                if (a == null) {
                    a = new d();
                }
                String str = this.b;
                LoggerProxy.d(str, "synthesize result = " + a.getDetailCode() + " , message = " + a.getDetailMessage());
            }
            return a;
        }
        return (ITtsError) invokeL.objValue;
    }

    public synchronized int freeCustomResource() {
        InterceptResult invokeV;
        int bdTTSDomainDataUninit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                LoggerProxy.d(this.b, "freeCustomResource: ");
                p pVar = this.a.d.e;
                bdTTSDomainDataUninit = pVar.j.bdTTSDomainDataUninit(pVar.e[0]);
            }
            return bdTTSDomainDataUninit;
        }
        return invokeV.intValue;
    }

    public synchronized String getInstanceId() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                str = this.c;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public synchronized int stop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                LoggerProxy.d(this.b, "stop");
                this.a.b();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public synchronized int loadCustomResource(String str) {
        InterceptResult invokeL;
        int bdTTSDomainDataInit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                String str2 = this.b;
                LoggerProxy.d(str2, "loadCustomResource: " + str);
                p pVar = this.a.d.e;
                pVar.getClass();
                bdTTSDomainDataInit = pVar.j.bdTTSDomainDataInit(w0.d(str), pVar.e[0]);
            }
            return bdTTSDomainDataInit;
        }
        return invokeL.intValue;
    }

    public synchronized ITtsError loadOfflineTts() {
        InterceptResult invokeV;
        d dVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                a aVar = this.a;
                aVar.getClass();
                g gVar = g.a.a;
                t0 t0Var = t0.d;
                h a = gVar.a(t0Var, aVar.c);
                dVar = null;
                if (!a.c()) {
                    dVar = a.a();
                } else {
                    LoggerProxy.d(aVar.a, "init ttsEnum OFFLINE " + aVar.b(t0Var));
                    if (!aVar.b(t0Var)) {
                        dVar = aVar.a(t0Var);
                    } else {
                        p pVar = aVar.d.e;
                        int b = pVar.b();
                        if (b == -1) {
                            dVar = z0.a().a(u0.l0);
                        } else if (b == 1) {
                            t1 t1Var = pVar.d;
                            int a2 = pVar.a(t1Var.k, t1Var.m, t1Var.n, t1Var.o);
                            if (a2 != 0) {
                                d a3 = z0.a().a(u0.X);
                                a3.b = a2;
                                a3.c = null;
                                a3.a = null;
                                dVar = a3;
                            }
                        }
                    }
                }
                String str2 = aVar.a;
                if (dVar == null) {
                    str = "loadOfflineTts success ";
                } else {
                    str = "loadOfflineTts error code = " + dVar.getDetailCode() + " , message = " + dVar.getDetailMessage();
                }
                LoggerProxy.d(str2, str);
                if (dVar == null) {
                    dVar = new d();
                }
                LoggerProxy.d(this.b, "load offline result = " + dVar.getDetailCode() + " , message = " + dVar.getDetailMessage());
            }
            return dVar;
        }
        return (ITtsError) invokeV.objValue;
    }

    public synchronized ITtsError loadOnlineTts() {
        InterceptResult invokeV;
        d dVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                a aVar = this.a;
                aVar.getClass();
                g gVar = g.a.a;
                t0 t0Var = t0.c;
                h a = gVar.a(t0Var, aVar.c);
                d dVar2 = null;
                if (!a.c()) {
                    dVar = a.a();
                } else {
                    LoggerProxy.d(aVar.a, "init ttsEnum ONLINE " + aVar.b(t0Var));
                    if (!aVar.b(t0Var)) {
                        dVar2 = aVar.a(t0Var);
                    }
                    if (dVar2 == null && aVar.c.b.a.w) {
                        synchronized (aVar) {
                            c0 a2 = aVar.a();
                            try {
                                a2.submit(new a.b(aVar));
                            } catch (RejectedExecutionException unused) {
                                int size = a2.getQueue().size();
                                LoggerProxy.e(aVar.a, " count=" + size);
                            } catch (Exception e) {
                                LoggerProxy.d(aVar.a, e.toString());
                            }
                        }
                    }
                    dVar = dVar2;
                }
                String str2 = aVar.a;
                if (dVar == null) {
                    str = "loadOnlineTts success ";
                } else {
                    str = "loadOnlineTts error code = " + dVar.getDetailCode() + " , message = " + dVar.getDetailMessage();
                }
                LoggerProxy.d(str2, str);
                if (dVar == null) {
                    dVar = new d();
                }
                LoggerProxy.d(this.b, "load online result = " + dVar.getDetailCode() + " , message = " + dVar.getDetailMessage());
            }
            return dVar;
        }
        return (ITtsError) invokeV.objValue;
    }

    public synchronized int pause() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                LoggerProxy.d(this.b, DownloadStatisticConstants.UBC_TYPE_PAUSE);
                a2 a2Var = this.a.g.c;
                if (!a2Var.r) {
                    i = -1;
                } else {
                    LoggerProxy.d(a2Var.b, DownloadStatisticConstants.UBC_TYPE_PAUSE);
                    try {
                        a2Var.i = true;
                        AudioTrack audioTrack = a2Var.d;
                        if (audioTrack != null) {
                            audioTrack.pause();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    i = 0;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int resume() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                LoggerProxy.d(this.b, DownloadStatisticConstants.UBC_TYPE_RESUME);
                a2 a2Var = this.a.g.c;
                i = 0;
                if (!a2Var.r) {
                    i = -1;
                } else {
                    LoggerProxy.d(a2Var.b, DownloadStatisticConstants.UBC_TYPE_RESUME);
                    try {
                        a2Var.i = false;
                        AudioTrack audioTrack = a2Var.d;
                        if (audioTrack != null) {
                            audioTrack.play();
                        }
                        a2Var.c();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int setParam(String str, String str2) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            synchronized (this) {
                String str3 = this.b;
                LoggerProxy.d(str3, "setParam key: " + str + " value:" + str2);
                a aVar = this.a;
                aVar.getClass();
                try {
                    n0 valueOf = n0.valueOf(str);
                    x1 x1Var = aVar.c;
                    if (x1Var != null) {
                        i = x1Var.a(valueOf, str2);
                    } else {
                        i = 0;
                    }
                } catch (Exception unused) {
                    u0 u0Var = u0.F0;
                    i = NetError.ERR_CACHE_RACE;
                }
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public synchronized void setSpeechSynthesizerListener(SpeechSynthesizerListener speechSynthesizerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, speechSynthesizerListener) == null) {
            synchronized (this) {
                LoggerProxy.d(this.b, "setSpeechSynthesizerListener");
                a aVar = this.a;
                if (speechSynthesizerListener != null && aVar.f == null) {
                    aVar.f = new a.c(aVar, speechSynthesizerListener, null);
                } else {
                    aVar.f = null;
                }
            }
        }
    }
}

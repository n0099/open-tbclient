package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tieba.j4c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import com.yy.gslbsdk.db.DelayTB;
import com.yy.render.RenderEngine;
import com.yy.render.view.RenderSurfaceView;
import com.yy.render.view.RenderTextureView;
import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.NetRequestStatusInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import com.yy.transvod.player.log.TLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class n5c extends l5c implements k2c, j7c {
    public static /* synthetic */ Interceptable $ic;
    public static int V;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Executor> A;
    public WeakReference<j4c.d> B;
    public WeakReference<d4c> C;
    public WeakReference<x3c> D;
    public WeakReference<a4c> E;
    public WeakReference<r3c> F;
    public WeakReference<w3c> G;
    public WeakReference<z3c> H;
    public WeakReference<v3c> I;
    public WeakReference<t3c> J;
    public WeakReference<c4c> K;
    public WeakReference<Executor> L;
    public WeakReference<q3c> M;
    public WeakReference<j4c.c> N;
    public WeakReference<y3c> O;
    public WeakReference<b4c> P;
    public WeakReference<g4c> Q;
    public WeakReference<s3c> R;
    public WeakReference<u3c> S;

    /* renamed from: T  reason: collision with root package name */
    public WeakReference<f4c> f1137T;
    public WeakReference<p3c> U;
    public final ExecutorService c;
    public RenderSurfaceView d;
    public RenderTextureView e;
    public Gson f;
    public i4c g;
    public boolean h;
    public Handler i;
    public String j;
    public int k;
    public int l;
    public String m;
    public final AtomicInteger n;
    public final AtomicInteger o;
    public final AtomicInteger p;
    public final AtomicInteger q;
    public AtomicBoolean r;
    public int s;
    public boolean t;
    public int u;
    public int v;
    public boolean w;
    public int x;
    public int y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947954893, "Lcom/baidu/tieba/n5c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947954893, "Lcom/baidu/tieba/n5c;");
        }
    }

    @Override // com.baidu.tieba.k2c
    public void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ q3c b;
        public final /* synthetic */ n5c c;

        /* renamed from: com.baidu.tieba.n5c$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0408a extends TypeToken<byte[]> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0408a(a aVar) {
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
                    }
                }
            }
        }

        public a(n5c n5cVar, JSONObject jSONObject, q3c q3cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n5cVar, jSONObject, q3cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n5cVar;
            this.a = jSONObject;
            this.b = q3cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Gson gson = new Gson();
                    String optString = this.a.optString("sei");
                    int optInt = this.a.optInt("type");
                    this.b.onSEIVideoOriginalData(this.c.a, (byte[]) gson.fromJson(optString, new C0408a(this).getType()), optInt);
                } catch (Exception e) {
                    TLog.d("[VodPlayerClient]", this.c.M0() + "(VodPlayerClient.onSEIVideoOriginalData) ex: " + e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n5c a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                m mVar = (m) message.obj;
                JSONObject jSONObject = mVar.c;
                String str = mVar.a;
                char c = 65535;
                switch (str.hashCode()) {
                    case -1893106721:
                        if (str.equals("onPlayerDecodeBitrate")) {
                            c = 17;
                            break;
                        }
                        break;
                    case -1122266638:
                        if (str.equals("onPlayerExtraInfoListener")) {
                            c = 11;
                            break;
                        }
                        break;
                    case -1105747594:
                        if (str.equals("onPlayerCacheWriteToDiskCompleted")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -726502775:
                        if (str.equals("onPlayerAudioStalls")) {
                            c = 21;
                            break;
                        }
                        break;
                    case -513983265:
                        if (str.equals("onPlayerFirstVideoFrameShow")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case -125887634:
                        if (str.equals("onPlayerVideoStalls")) {
                            c = 20;
                            break;
                        }
                        break;
                    case -48461180:
                        if (str.equals("onPlayerNetRequestStatus")) {
                            c = 14;
                            break;
                        }
                        break;
                    case 54802172:
                        if (str.equals("onPlayerDecodeOuputSize")) {
                            c = 18;
                            break;
                        }
                        break;
                    case 76638970:
                        if (str.equals("onPlayerStateUpdate")) {
                            c = '\r';
                            break;
                        }
                        break;
                    case 269354233:
                        if (str.equals("onSubProcessCrash")) {
                            c = 24;
                            break;
                        }
                        break;
                    case 303848884:
                        if (str.equals("onPlayerCachePositionUpdate")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 554677256:
                        if (str.equals("onPlayerDecodeType")) {
                            c = 19;
                            break;
                        }
                        break;
                    case 598376093:
                        if (str.equals("onPlayerVideoPlayPaused")) {
                            c = 22;
                            break;
                        }
                        break;
                    case 822132006:
                        if (str.equals("onPlayerUpdatePcdnUrlResult")) {
                            c = 23;
                            break;
                        }
                        break;
                    case 853792181:
                        if (str.equals("onAudioFocusListener")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case 1012167752:
                        if (str.equals("onPlayerError")) {
                            c = '\f';
                            break;
                        }
                        break;
                    case 1055756567:
                        if (str.equals("onPlayerRenderFramerate")) {
                            c = 16;
                            break;
                        }
                        break;
                    case 1141144174:
                        if (str.equals("onPlayerInfo")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 1147162650:
                        if (str.equals("onPlayerPlayCompletionOneLoop")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case 1343087941:
                        if (str.equals("onPlayerVideoSizeUpdate")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 1385041286:
                        if (str.equals("onLoadingUpdate")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 1468645360:
                        if (str.equals("onPlayerPlayCompletion")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 1482173798:
                        if (str.equals("onPlayerPlayPositionUpdate")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1668839139:
                        if (str.equals("onPlayerStatistics")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1955119023:
                        if (str.equals("onPlayerReceiveToRenderDelay")) {
                            c = 15;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        if (jSONObject != null) {
                            int optInt = jSONObject.optInt("i");
                            TLog.b("[VodPlayerClient]", this.a.M0() + "onLoadingUpdate:" + optInt);
                            x3c x3cVar = (x3c) this.a.D.get();
                            if (x3cVar != null) {
                                x3cVar.a(this.a.a, optInt);
                                return;
                            }
                            return;
                        }
                        return;
                    case 1:
                        d4c d4cVar = (d4c) this.a.C.get();
                        if (d4cVar == null || jSONObject == null) {
                            return;
                        }
                        d4cVar.onPlayerStatistics(this.a.a, jSONObject.optInt("i"), jSONObject.optString("s"));
                        return;
                    case 2:
                        if (jSONObject != null) {
                            long optLong = jSONObject.optLong("l");
                            this.a.q.set((int) optLong);
                            a4c a4cVar = (a4c) this.a.E.get();
                            if (a4cVar != null) {
                                a4cVar.a(this.a.a, optLong);
                                return;
                            }
                            return;
                        }
                        return;
                    case 3:
                        r3c r3cVar = (r3c) this.a.F.get();
                        if (r3cVar == null || jSONObject == null) {
                            return;
                        }
                        r3cVar.onPlayerCachePositionUpdate(this.a.a, jSONObject.optLong("l"));
                        return;
                    case 4:
                        r3c r3cVar2 = (r3c) this.a.F.get();
                        if (r3cVar2 == null || jSONObject == null) {
                            return;
                        }
                        r3cVar2.onPlayerCacheWriteToDiskCompleted(this.a.a, jSONObject.optString("s"));
                        return;
                    case 5:
                        if (jSONObject != null) {
                            int optInt2 = jSONObject.optInt("i");
                            long optLong2 = jSONObject.optLong("l");
                            TLog.h("[VodPlayerClient]", this.a.M0() + "onPlayerInfo,what:" + optInt2 + ",extra:" + optLong2);
                            w3c w3cVar = (w3c) this.a.G.get();
                            if (w3cVar != null) {
                                w3cVar.onPlayerInfo(this.a.a, optInt2, optLong2);
                                return;
                            }
                            return;
                        }
                        return;
                    case 6:
                        if (jSONObject != null) {
                            int optInt3 = jSONObject.optInt("i");
                            int optInt4 = jSONObject.optInt("i1");
                            TLog.h("[VodPlayerClient]", this.a.M0() + "onPlayerVideoSizeUpdate,width:" + optInt3 + ",height:" + optInt4);
                            w3c w3cVar2 = (w3c) this.a.G.get();
                            if (w3cVar2 != null) {
                                w3cVar2.onPlayerVideoSizeUpdate(this.a.a, optInt3, optInt4);
                                return;
                            }
                            return;
                        }
                        return;
                    case 7:
                        TLog.h("[VodPlayerClient]", this.a.M0() + "onPlayerPlayCompletion");
                        z3c z3cVar = (z3c) this.a.H.get();
                        if (z3cVar != null) {
                            z3cVar.onPlayerPlayCompletion(this.a.a);
                            return;
                        }
                        return;
                    case '\b':
                        TLog.h("[VodPlayerClient]", this.a.M0() + "onPlayerPlayCompletionOneLoop");
                        z3c z3cVar2 = (z3c) this.a.H.get();
                        if (z3cVar2 != null) {
                            z3cVar2.onPlayerPlayCompletionOneLoop(this.a.a);
                            return;
                        }
                        return;
                    case '\t':
                        if (jSONObject != null) {
                            int optInt5 = jSONObject.optInt("i");
                            int optInt6 = jSONObject.optInt("i1");
                            int optInt7 = jSONObject.optInt("i2");
                            TLog.h("[VodPlayerClient]", this.a.M0() + "onPlayerFirstVideoFrameShow,width:" + optInt5 + ",height:" + optInt6 + ",costMs:" + optInt7);
                            v3c v3cVar = (v3c) this.a.I.get();
                            if (v3cVar != null) {
                                v3cVar.onPlayerFirstVideoFrameShow(this.a.a, optInt5, optInt6, optInt7);
                                return;
                            }
                            return;
                        }
                        return;
                    case '\n':
                        if (jSONObject != null) {
                            int optInt8 = jSONObject.optInt("i");
                            TLog.h("[VodPlayerClient]", this.a.M0() + " onAudioFocusListener,focus status:" + optInt8);
                            p3c p3cVar = (p3c) this.a.U.get();
                            if (p3cVar != null) {
                                p3cVar.onAudioFocusChange(optInt8);
                                return;
                            }
                            return;
                        }
                        return;
                    case 11:
                        if (jSONObject != null) {
                            int optInt9 = jSONObject.optInt("i");
                            long optLong3 = jSONObject.optLong("l1");
                            long optLong4 = jSONObject.optLong("l2");
                            long optLong5 = jSONObject.optLong("l3");
                            String optString = jSONObject.optString("s");
                            JSONObject optJSONObject = jSONObject.optJSONObject("o");
                            TLog.h("[VodPlayerClient]", this.a.M0() + " OnPlayerExtraInfoListener,type:" + optInt9);
                            u3c u3cVar = (u3c) this.a.S.get();
                            if (u3cVar != null) {
                                u3cVar.a(optInt9, optLong3, optLong4, optLong5, optString, optJSONObject);
                                return;
                            }
                            return;
                        }
                        return;
                    case '\f':
                        if (jSONObject != null) {
                            int optInt10 = jSONObject.optInt("i");
                            int optInt11 = jSONObject.optInt("i1");
                            String optString2 = jSONObject.optString("s");
                            TLog.h("[VodPlayerClient]", this.a.M0() + "onPlayerError,url:" + optString2 + ",what:" + optInt10 + ",extra:" + optInt11);
                            t3c t3cVar = (t3c) this.a.J.get();
                            if (t3cVar != null) {
                                t3cVar.onPlayerError(this.a.a, optString2, optInt10, optInt11);
                                return;
                            }
                            return;
                        }
                        return;
                    case '\r':
                        if (jSONObject != null) {
                            int optInt12 = jSONObject.optInt("i");
                            int optInt13 = jSONObject.optInt("i1");
                            TLog.h("[VodPlayerClient]", this.a.M0() + "onPlayerStateUpdate,newState:" + optInt12 + ",reason:" + optInt13);
                            c4c c4cVar = (c4c) this.a.K.get();
                            if (c4cVar != null) {
                                this.a.b = optInt12 == 6;
                                TLog.h("[VodPlayerClient]", this.a.M0() + "onPlayerStateUpdate,mPlayerState:" + this.a.b);
                                if (optInt12 == 6) {
                                    this.a.Q0();
                                }
                                c4cVar.onPlayerStateUpdate(this.a.a, optInt12, optInt13);
                                return;
                            }
                            return;
                        }
                        return;
                    case 14:
                        y3c y3cVar = (y3c) this.a.O.get();
                        if (y3cVar == null || jSONObject == null) {
                            return;
                        }
                        y3cVar.a(this.a.a, jSONObject.optInt("status"), (NetRequestStatusInfo) new Gson().fromJson(jSONObject.optString("info"), new a(this).getType()));
                        return;
                    case 15:
                        b4c b4cVar = (b4c) this.a.P.get();
                        if (b4cVar == null || jSONObject == null) {
                            return;
                        }
                        b4cVar.onPlayerReceiveToRenderDelay(this.a.a, jSONObject.optInt(DelayTB.DELAY));
                        return;
                    case 16:
                        if (jSONObject != null) {
                            int optInt14 = jSONObject.optInt("framerate");
                            TLog.h("[VodPlayerClient]", this.a.M0() + "onPlayerRenderFramerate:" + optInt14);
                            b4c b4cVar2 = (b4c) this.a.P.get();
                            if (b4cVar2 != null) {
                                b4cVar2.onPlayerRenderFramerate(this.a.a, optInt14);
                                return;
                            }
                            return;
                        }
                        return;
                    case 17:
                        if (jSONObject != null) {
                            int optInt15 = jSONObject.optInt("videoBitrate");
                            int optInt16 = jSONObject.optInt("audioBitrate");
                            TLog.b("[VodPlayerClient]", this.a.M0() + "onPlayerDecodeBitrate,videoBitrate:" + optInt15 + ",audioBitrate:" + optInt16);
                            b4c b4cVar3 = (b4c) this.a.P.get();
                            if (b4cVar3 != null) {
                                b4cVar3.onPlayerDecodeBitrate(this.a.a, optInt15, optInt16);
                                return;
                            }
                            return;
                        }
                        return;
                    case 18:
                        if (jSONObject != null) {
                            int optInt17 = jSONObject.optInt("width");
                            int optInt18 = jSONObject.optInt("height");
                            TLog.h("[VodPlayerClient]", this.a.M0() + "onPlayerDecodeOuputSize,width:" + optInt17 + ",height:" + optInt18);
                            b4c b4cVar4 = (b4c) this.a.P.get();
                            if (b4cVar4 != null) {
                                b4cVar4.onPlayerDecodeOuputSize(this.a.a, optInt17, optInt18);
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        if (jSONObject != null) {
                            int optInt19 = jSONObject.optInt("decodType");
                            TLog.h("[VodPlayerClient]", this.a.M0() + "onPlayerDecodeType:" + optInt19);
                            b4c b4cVar5 = (b4c) this.a.P.get();
                            if (b4cVar5 != null) {
                                b4cVar5.onPlayerDecodeType(this.a.a, optInt19);
                                return;
                            }
                            return;
                        }
                        return;
                    case 20:
                        b4c b4cVar6 = (b4c) this.a.P.get();
                        if (b4cVar6 == null || jSONObject == null) {
                            return;
                        }
                        b4cVar6.onPlayerVideoStalls(this.a.a, jSONObject.optBoolean("videoStalls"), jSONObject.optInt("type"));
                        return;
                    case 21:
                        b4c b4cVar7 = (b4c) this.a.P.get();
                        if (b4cVar7 == null || jSONObject == null) {
                            return;
                        }
                        b4cVar7.onPlayerAudioStalls(this.a.a, jSONObject.optBoolean("audioStalls"), jSONObject.optInt("type"));
                        return;
                    case 22:
                        if (jSONObject != null) {
                            boolean optBoolean = jSONObject.optBoolean("isPaused");
                            TLog.h("[VodPlayerClient]", this.a.M0() + "onPlayerVideoPlayPaused:" + optBoolean);
                            g4c g4cVar = (g4c) this.a.Q.get();
                            if (g4cVar != null) {
                                g4cVar.a(optBoolean);
                                return;
                            }
                            return;
                        }
                        return;
                    case 23:
                        if (jSONObject != null) {
                            int optInt20 = jSONObject.optInt("taskId");
                            int optInt21 = jSONObject.optInt("result");
                            String optString3 = jSONObject.optString("url");
                            TLog.h("[VodPlayerClient]", this.a.M0() + "onPlayerUpdatePcdnUrlResult:" + optString3 + " " + optInt20 + "-->" + optInt21);
                            f4c f4cVar = (f4c) this.a.f1137T.get();
                            if (f4cVar != null) {
                                f4cVar.a(this.a.a, optInt20, optString3, optInt21);
                                return;
                            }
                            return;
                        }
                        return;
                    case 24:
                        TLog.h("[VodPlayerClient]", this.a.M0() + "onSubProcessCrash, failOver2MainProcess:" + mVar.d);
                        this.a.i.removeCallbacksAndMessages(null);
                        s3c s3cVar = (s3c) this.a.R.get();
                        if (s3cVar != null) {
                            s3cVar.a(mVar.b, mVar.d, new HashMap<>());
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* loaded from: classes7.dex */
        public class a extends TypeToken<NetRequestStatusInfo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(n5c n5cVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n5cVar, looper};
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
            this.a = n5cVar;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ q3c b;
        public final /* synthetic */ n5c c;

        /* loaded from: classes7.dex */
        public class a extends TypeToken<ArrayList<VideoExtraInfo>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public f(n5c n5cVar, JSONObject jSONObject, q3c q3cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n5cVar, jSONObject, q3cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n5cVar;
            this.a = jSONObject;
            this.b = q3cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Gson gson = new Gson();
                    this.b.onSEIVideoExtraInfo(this.c.a, this.a.optInt("type"), (ArrayList) gson.fromJson(this.a.optString("videoExtraInfo"), new a(this).getType()));
                } catch (Exception e) {
                    TLog.d("[VodPlayerClient]", this.c.M0() + "(VodPlayerClient.onSEIVideoExtraInfo) ex: " + e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ q3c b;
        public final /* synthetic */ n5c c;

        /* loaded from: classes7.dex */
        public class a extends TypeToken<ArrayList<MixVideoExtraInfo>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public g(n5c n5cVar, JSONObject jSONObject, q3c q3cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n5cVar, jSONObject, q3cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n5cVar;
            this.a = jSONObject;
            this.b = q3cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Gson gson = new Gson();
                    this.b.onSEIMixVideoExtraInfo(this.c.a, this.a.optInt("type"), (ArrayList) gson.fromJson(this.a.optString("mixVideoExtraInfo"), new a(this).getType()));
                } catch (Exception e) {
                    TLog.d("[VodPlayerClient]", this.c.M0() + "(VodPlayerClient.onSEIMixVideoExtraInfo) ex: " + e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ q3c b;
        public final /* synthetic */ n5c c;

        /* loaded from: classes7.dex */
        public class a extends TypeToken<ArrayList<AlphaChannelData>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public h(n5c n5cVar, JSONObject jSONObject, q3c q3cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n5cVar, jSONObject, q3cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n5cVar;
            this.a = jSONObject;
            this.b = q3cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Gson gson = new Gson();
                    this.b.onSEIAlphaChannelInfo(this.c.a, this.a.optInt("type"), (ArrayList) gson.fromJson(this.a.optString("alphaChannelInfo"), new a(this).getType()));
                } catch (Exception e) {
                    TLog.d("[VodPlayerClient]", this.c.M0() + "(VodPlayerClient.onSEIAlphaChannelInfo) ex: " + e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ q3c b;
        public final /* synthetic */ n5c c;

        /* loaded from: classes7.dex */
        public class a extends TypeToken<ArrayList<MixAudioExtraInfo>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public i(n5c n5cVar, JSONObject jSONObject, q3c q3cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n5cVar, jSONObject, q3cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n5cVar;
            this.a = jSONObject;
            this.b = q3cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.b.onDSEMixAudioExtraInfoV1(this.c.a, (ArrayList) new Gson().fromJson(this.a.optString("mixAudioExtraInfo"), new a(this).getType()));
                } catch (Exception e) {
                    TLog.d("[VodPlayerClient]", this.c.M0() + "(VodPlayerClient.onDSEMixAudioExtraInfoV1) ex: " + e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ j4c.c b;
        public final /* synthetic */ n5c c;

        /* loaded from: classes7.dex */
        public class a extends TypeToken<ArrayList<MixAudioExtraInfo>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public j(n5c n5cVar, JSONObject jSONObject, j4c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n5cVar, jSONObject, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n5cVar;
            this.a = jSONObject;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.b.a(this.c.a, (ArrayList) new Gson().fromJson(this.a.optString("mixAudioExtraInfo"), new a(this).getType()));
                } catch (Exception e) {
                    TLog.d("[VodPlayerClient]", this.c.M0() + "(VodPlayerClient.onDSEMixAudioExtraInfo) ex: " + e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ q3c b;
        public final /* synthetic */ n5c c;

        /* loaded from: classes7.dex */
        public class a extends TypeToken<ArrayList<Long>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public k(n5c n5cVar, JSONObject jSONObject, q3c q3cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n5cVar, jSONObject, q3cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n5cVar;
            this.a = jSONObject;
            this.b = q3cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.b.onSEIAudioExtraInfoV0(this.c.a, (ArrayList) new Gson().fromJson(this.a.optString("uids"), new a(this).getType()));
                } catch (Exception e) {
                    TLog.d("[VodPlayerClient]", this.c.M0() + "(VodPlayerClient.onSEIAudioExtraInfoV0) ex: " + e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ q3c b;
        public final /* synthetic */ n5c c;

        /* loaded from: classes7.dex */
        public class a extends TypeToken<byte[]> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public l(n5c n5cVar, JSONObject jSONObject, q3c q3cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n5cVar, jSONObject, q3cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n5cVar;
            this.a = jSONObject;
            this.b = q3cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Gson gson = new Gson();
                    String optString = this.a.optString("sei");
                    int optInt = this.a.optInt("type");
                    this.b.onSEIAudioOriginalData(this.c.a, (byte[]) gson.fromJson(optString, new a(this).getType()), optInt);
                } catch (Exception e) {
                    TLog.d("[VodPlayerClient]", this.c.M0() + "(VodPlayerClient.onSEIAudioOriginalData) ex: " + e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ n5c b;

        public b(n5c n5cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n5cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n5cVar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.h && this.b.d != null) {
                    TLog.h("[VodPlayerClient]", this.b.M0() + "send data to sub process: " + this.a);
                    this.b.d.q(this.a);
                } else if (this.b.e != null) {
                    TLog.h("[VodPlayerClient]", this.b.M0() + "send data to sub process: " + this.a);
                    this.b.e.r(this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j4c.d a;
        public final /* synthetic */ Bitmap b;

        public c(n5c n5cVar, j4c.d dVar, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n5cVar, dVar, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.b = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(n5c n5cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n5cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                return new Thread(runnable, "C-vodplayer-" + n5c.H());
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public JSONObject c;
        public boolean d;

        public m(n5c n5cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n5cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = null;
            this.d = false;
        }
    }

    public n5c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = Executors.newSingleThreadExecutor(new e(this));
        this.d = null;
        this.e = null;
        this.g = null;
        this.h = true;
        this.i = null;
        this.k = -1;
        this.l = -1;
        this.m = null;
        this.n = new AtomicInteger(0);
        this.o = new AtomicInteger(0);
        this.p = new AtomicInteger(0);
        this.q = new AtomicInteger(0);
        this.r = new AtomicBoolean(true);
        this.s = -1;
        this.t = false;
        this.u = -1;
        this.v = -1;
        this.w = false;
        this.x = -1;
        this.y = -1;
        this.z = true;
        this.A = new WeakReference<>(null);
        this.B = new WeakReference<>(null);
        this.C = new WeakReference<>(null);
        this.D = new WeakReference<>(null);
        this.E = new WeakReference<>(null);
        this.F = new WeakReference<>(null);
        this.G = new WeakReference<>(null);
        this.H = new WeakReference<>(null);
        this.I = new WeakReference<>(null);
        this.J = new WeakReference<>(null);
        this.K = new WeakReference<>(null);
        this.L = new WeakReference<>(null);
        this.M = new WeakReference<>(null);
        this.N = new WeakReference<>(null);
        this.O = new WeakReference<>(null);
        this.P = new WeakReference<>(null);
        this.Q = new WeakReference<>(null);
        this.R = new WeakReference<>(null);
        this.S = new WeakReference<>(null);
        this.f1137T = new WeakReference<>(null);
        this.U = new WeakReference<>(null);
    }

    public n5c(Context context, i4c i4cVar, j4c j4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, i4cVar, j4cVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.c = Executors.newSingleThreadExecutor(new e(this));
        this.d = null;
        this.e = null;
        this.g = null;
        this.h = true;
        this.i = null;
        this.k = -1;
        this.l = -1;
        this.m = null;
        this.n = new AtomicInteger(0);
        this.o = new AtomicInteger(0);
        this.p = new AtomicInteger(0);
        this.q = new AtomicInteger(0);
        this.r = new AtomicBoolean(true);
        this.s = -1;
        this.t = false;
        this.u = -1;
        this.v = -1;
        this.w = false;
        this.x = -1;
        this.y = -1;
        this.z = true;
        this.A = new WeakReference<>(null);
        this.B = new WeakReference<>(null);
        this.C = new WeakReference<>(null);
        this.D = new WeakReference<>(null);
        this.E = new WeakReference<>(null);
        this.F = new WeakReference<>(null);
        this.G = new WeakReference<>(null);
        this.H = new WeakReference<>(null);
        this.I = new WeakReference<>(null);
        this.J = new WeakReference<>(null);
        this.K = new WeakReference<>(null);
        this.L = new WeakReference<>(null);
        this.M = new WeakReference<>(null);
        this.N = new WeakReference<>(null);
        this.O = new WeakReference<>(null);
        this.P = new WeakReference<>(null);
        this.Q = new WeakReference<>(null);
        this.R = new WeakReference<>(null);
        this.S = new WeakReference<>(null);
        this.f1137T = new WeakReference<>(null);
        this.U = new WeakReference<>(null);
        q7c.c().e(this);
        this.a = j4cVar;
        this.g = i4cVar;
        this.h = i4cVar.g;
        L0(context);
        TLog.h("[VodPlayerClient]", M0() + "create vodplayer client");
    }

    @Override // com.baidu.tieba.l5c
    public void A(w3c w3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, w3cVar) == null) {
            this.G = new WeakReference<>(w3cVar);
        }
    }

    @Override // com.baidu.tieba.l5c
    public void B(b4c b4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b4cVar) == null) {
            this.P = new WeakReference<>(b4cVar);
        }
    }

    @Override // com.baidu.tieba.l5c
    public void C(c4c c4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c4cVar) == null) {
            this.K = new WeakReference<>(c4cVar);
        }
    }

    @Override // com.baidu.tieba.l5c
    public void D(d4c d4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d4cVar) == null) {
            this.C = new WeakReference<>(d4cVar);
        }
    }

    @Override // com.baidu.tieba.l5c
    public void x(r3c r3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, r3cVar) == null) {
            this.F = new WeakReference<>(r3cVar);
        }
    }

    @Override // com.baidu.tieba.l5c
    public void y(t3c t3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, t3cVar) == null) {
            this.J = new WeakReference<>(t3cVar);
        }
    }

    @Override // com.baidu.tieba.l5c
    public void z(v3c v3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, v3cVar) == null) {
            this.I = new WeakReference<>(v3cVar);
        }
    }

    public static /* synthetic */ int H() {
        return N0();
    }

    public static synchronized int N0() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            synchronized (n5c.class) {
                i2 = V;
                V = i2 + 1;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.i = new d(this, Looper.getMainLooper());
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.q.set(0);
            this.n.set(0);
            this.o.set(0);
            this.p.set(0);
            this.k = 0;
        }
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            i3c i3cVar = new i3c();
            i3cVar.a = "sendRedirectUrlData";
            P0(this.f.toJson(i3cVar));
        }
    }

    @Override // com.baidu.tieba.l5c
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (this.h) {
                return this.d;
            }
            return this.e;
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.tieba.l5c
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.p.get();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.l5c
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.o.get();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.l5c
    public void w(Executor executor, q3c q3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, executor, q3cVar) == null) {
            this.L = new WeakReference<>(executor);
            this.M = new WeakReference<>(q3cVar);
        }
    }

    @Override // com.baidu.tieba.l5c
    public void E(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.x = i2;
            TLog.h("[VodPlayerClient]", M0() + "setRotateMode:" + this.x);
            Y0();
        }
    }

    public void S0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.r.set(z);
            TLog.h("[VodPlayerClient]", M0() + "setAudioFocusEnable:" + this.r.get());
            T0();
        }
    }

    @Override // com.baidu.tieba.l5c
    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.v = i2;
            TLog.h("[VodPlayerClient]", M0() + "setDisplayMode:" + this.v);
            U0();
        }
    }

    @Override // com.baidu.tieba.l5c
    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            this.s = i2;
            TLog.h("[VodPlayerClient]", M0() + "setNumberOfLoops:" + this.s);
            W0();
        }
    }

    @Override // com.baidu.tieba.l5c
    public void F(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            this.l = i2;
            TLog.h("[VodPlayerClient]", M0() + "start, taskId:" + i2);
            q7c.c().g(this, i2, this.z);
            synchronized (this) {
                i3c i3cVar = new i3c();
                i3cVar.a = "startPlay";
                i3cVar.b.put("taskId", Integer.valueOf(i2));
                i3cVar.b.put("apiStartTimeMs", Long.valueOf(j2));
                P0(this.f.toJson(i3cVar));
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TLog.h("[VodPlayerClient]", M0() + "stop");
            q7c.c().h(this);
            synchronized (this) {
                this.n.set(0);
                this.q.set(0);
                this.o.set(0);
                this.p.set(0);
                i3c i3cVar = new i3c();
                i3cVar.a = "stopPlay";
                P0(this.f.toJson(i3cVar));
                this.l = -1;
            }
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                String b2 = i4c.b(this.g);
                if (b2 != null && !b2.isEmpty()) {
                    i3c i3cVar = new i3c();
                    i3cVar.a = "initPlay";
                    i3cVar.b.put("opt", b2);
                    P0(this.f.toJson(i3cVar));
                    return;
                }
                TLog.d("[VodPlayerClient]", M0() + "createServerVodplayer, mPlayerOptions is empty");
            }
        }
    }

    public final String M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(PreferencesUtil.LEFT_MOUNT);
            sb.append("channel:");
            sb.append(this.j);
            if (this.k != -1) {
                sb.append(",context:");
                sb.append(this.k);
            }
            if (this.l != -1) {
                sb.append(",task:");
                sb.append(this.l);
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void L0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            if (this.h) {
                RenderSurfaceView renderSurfaceView = new RenderSurfaceView(context);
                this.d = renderSurfaceView;
                renderSurfaceView.setKeepScreenOn(true);
                this.d.o(false);
                this.d.p(false);
                if (Build.MODEL.equals("OPPO A33t")) {
                    this.d.setLayerType(1, null);
                }
                this.j = this.d.getChannelId();
                TLog.h("[VodPlayerClient]", M0() + "create RenderSurfaceView");
            } else {
                RenderTextureView renderTextureView = new RenderTextureView(context);
                this.e = renderTextureView;
                renderTextureView.setKeepScreenOn(true);
                this.e.p(false);
                this.e.q(false);
                this.e.setOpaque(false);
                if (Build.VERSION.SDK_INT < 24) {
                    this.e.setBackgroundColor(0);
                }
                if (Build.MODEL.equals("OPPO A33t")) {
                    this.e.setLayerType(1, null);
                }
                this.j = this.e.getChannelId();
                TLog.h("[VodPlayerClient]", M0() + "create RenderTextureView");
            }
            J0();
            if (this.h) {
                RenderEngine.r.a().A(this.d, o5c.class, this);
            } else {
                RenderEngine.r.a().B(this.e, o5c.class, this);
            }
            p7c.n().j(this, true);
            this.f = new GsonBuilder().excludeFieldsWithModifiers(128, 8).serializeNulls().create();
            K0();
        }
    }

    public final void P0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && !TextUtils.isEmpty(str)) {
            if (this.d != null || this.e != null) {
                try {
                    this.c.execute(new b(this, str));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    TLog.d("[VodPlayerClient]", M0() + "(sendDataToSubProcess) ex: " + e2.getMessage());
                }
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void r(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048616, this, j2) == null) {
            TLog.h("[VodPlayerClient]", M0() + "seekTo:" + j2);
            synchronized (this) {
                i3c i3cVar = new i3c();
                i3cVar.a = "seekTo";
                i3cVar.b.put("p", Long.valueOf(j2));
                P0(this.f.toJson(i3cVar));
            }
        }
    }

    public final void R0(Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, obj, z) == null) && this.i != null) {
            synchronized (this) {
                if (this.i != null) {
                    if (z) {
                        this.i.sendMessageAtFrontOfQueue(Message.obtain(this.i, 1, obj));
                    } else {
                        this.i.sendMessage(Message.obtain(this.i, 1, obj));
                    }
                }
            }
        }
    }

    public final void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                i3c i3cVar = new i3c();
                i3cVar.a = "setAudioFocusEnable";
                i3cVar.b.put("af", Boolean.valueOf(this.r.get()));
                P0(this.f.toJson(i3cVar));
            }
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.v >= 0) {
            synchronized (this) {
                i3c i3cVar = new i3c();
                i3cVar.a = "setDisplayMode";
                i3cVar.b.put(com.kuaishou.weapon.p0.u.A, Integer.valueOf(this.v));
                P0(this.f.toJson(i3cVar));
            }
        }
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            synchronized (this) {
                i3c i3cVar = new i3c();
                i3cVar.a = "setIsSpecialMp4WithAlpha";
                i3cVar.b.put("al", Boolean.valueOf(this.w));
                P0(this.f.toJson(i3cVar));
            }
        }
    }

    public final void W0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.s >= 0) {
            synchronized (this) {
                i3c i3cVar = new i3c();
                i3cVar.a = "setNumberOfLoops";
                i3cVar.b.put("p", Integer.valueOf(this.s));
                P0(this.f.toJson(i3cVar));
            }
        }
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.y >= 0) {
            synchronized (this) {
                i3c i3cVar = new i3c();
                i3cVar.a = "setOrientateMode";
                i3cVar.b.put("ot", Integer.valueOf(this.y));
                P0(this.f.toJson(i3cVar));
            }
        }
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.x >= 0) {
            synchronized (this) {
                i3c i3cVar = new i3c();
                i3cVar.a = "setRotateMode";
                i3cVar.b.put("rt", Integer.valueOf(this.x));
                P0(this.f.toJson(i3cVar));
            }
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            synchronized (this) {
                i3c i3cVar = new i3c();
                i3cVar.a = "setVideoExtrasInfoEnable";
                i3cVar.b.put("b", Boolean.valueOf(this.t));
                P0(this.f.toJson(i3cVar));
            }
        }
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.u >= 0) {
            synchronized (this) {
                i3c i3cVar = new i3c();
                i3cVar.a = "setVolume";
                i3cVar.b.put("v", Integer.valueOf(this.u));
                P0(this.f.toJson(i3cVar));
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            TLog.h("[VodPlayerClient]", M0() + "appInBackground");
            synchronized (this) {
                i3c i3cVar = new i3c();
                i3cVar.a = "appInBackground";
                P0(this.f.toJson(i3cVar));
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            TLog.h("[VodPlayerClient]", M0() + "appInFrontground");
            synchronized (this) {
                i3c i3cVar = new i3c();
                i3cVar.a = "appInFrontground";
                P0(this.f.toJson(i3cVar));
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            TLog.h("[VodPlayerClient]", M0() + "getCurrentPosition:" + this.q.get());
            return this.q.get();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.l5c
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            TLog.h("[VodPlayerClient]", M0() + "getDuration:" + this.n.get());
            return this.n.get();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.l5c
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            TLog.h("[VodPlayerClient]", M0() + DownloadStatisticConstants.UBC_TYPE_PAUSE);
            synchronized (this) {
                i3c i3cVar = new i3c();
                i3cVar.a = "pausePlay";
                P0(this.f.toJson(i3cVar));
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            TLog.h("[VodPlayerClient]", M0() + "pausePlayWithAudio");
            synchronized (this) {
                i3c i3cVar = new i3c();
                i3cVar.a = "pausePlayWithAudio";
                P0(this.f.toJson(i3cVar));
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            TLog.h("[VodPlayerClient]", M0() + DownloadStatisticConstants.UBC_TYPE_RESUME);
            synchronized (this) {
                i3c i3cVar = new i3c();
                i3cVar.a = "resumePlay";
                P0(this.f.toJson(i3cVar));
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            TLog.h("[VodPlayerClient]", M0() + "resumePlayWithAudio");
            synchronized (this) {
                i3c i3cVar = new i3c();
                i3cVar.a = "resumePlayWithAudio";
                P0(this.f.toJson(i3cVar));
            }
        }
    }

    @Override // com.baidu.tieba.j7c
    public void a(String str, boolean z, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{str, Boolean.valueOf(z), hashMap}) == null) {
            TLog.g(this, "VodPlayerClient onCrash, recover server, failOver2MainProcess:" + z);
            if (!z) {
                O0();
                K0();
                W0();
                Z0();
                a1();
                U0();
                V0();
                Y0();
                X0();
            }
            m mVar = new m(this);
            mVar.a = "onSubProcessCrash";
            mVar.b = str;
            mVar.d = z;
            R0(mVar, true);
        }
    }

    @Override // com.baidu.tieba.k2c
    public void c(Bitmap bitmap) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bitmap) == null) {
            TLog.h("[VodPlayerClient]", M0() + "recv bitmap from sub process");
            synchronized (this) {
                Executor executor = this.A.get();
                j4c.d dVar = this.B.get();
                if (executor != null && dVar != null) {
                    executor.execute(new c(this, dVar, bitmap));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(M0());
                    sb.append(" onScreenShot failed executor is null?");
                    if (executor == null) {
                        str = "yes";
                    } else {
                        str = "no";
                    }
                    sb.append(str);
                    sb.append(" VodPlayerScreenShotCallback is null?");
                    if (dVar == null) {
                        str2 = "yes";
                    } else {
                        str2 = "no";
                    }
                    sb.append(str2);
                    TLog.d("[VodPlayerClient]", sb.toString());
                }
                this.A.clear();
                this.B.clear();
            }
        }
    }

    @Override // com.baidu.tieba.k2c
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("cmd");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                char c2 = 65535;
                switch (optString.hashCode()) {
                    case -1893106721:
                        if (optString.equals("onPlayerDecodeBitrate")) {
                            c2 = 19;
                            break;
                        }
                        break;
                    case -1751664499:
                        if (optString.equals("onDSEMixAudioExtraInfo")) {
                            c2 = DecodedBitStreamParser.RS;
                            break;
                        }
                        break;
                    case -1741719303:
                        if (optString.equals("onSEIAudioOriginalData")) {
                            c2 = WebvttCueParser.CHAR_SPACE;
                            break;
                        }
                        break;
                    case -1122266638:
                        if (optString.equals("onPlayerExtraInfoListener")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case -1105747594:
                        if (optString.equals("onPlayerCacheWriteToDiskCompleted")) {
                            c2 = 11;
                            break;
                        }
                        break;
                    case -726502775:
                        if (optString.equals("onPlayerAudioStalls")) {
                            c2 = 23;
                            break;
                        }
                        break;
                    case -513983265:
                        if (optString.equals("onPlayerFirstVideoFrameShow")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -441667023:
                        if (optString.equals("setRedirectUrl")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -356191701:
                        if (optString.equals("onSEIAlphaChannelInfo")) {
                            c2 = DecodedBitStreamParser.FS;
                            break;
                        }
                        break;
                    case -332667027:
                        if (optString.equals("setPlayerUID")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -125887634:
                        if (optString.equals("onPlayerVideoStalls")) {
                            c2 = 22;
                            break;
                        }
                        break;
                    case -48461180:
                        if (optString.equals("onPlayerNetRequestStatus")) {
                            c2 = 16;
                            break;
                        }
                        break;
                    case -24168773:
                        if (optString.equals("onSEIVideoExtraInfo")) {
                            c2 = 26;
                            break;
                        }
                        break;
                    case 42199303:
                        if (optString.equals("onSEIMixVideoExtraInfo")) {
                            c2 = 27;
                            break;
                        }
                        break;
                    case 54802172:
                        if (optString.equals("onPlayerDecodeOuputSize")) {
                            c2 = 20;
                            break;
                        }
                        break;
                    case 76638970:
                        if (optString.equals("onPlayerStateUpdate")) {
                            c2 = 15;
                            break;
                        }
                        break;
                    case 117071962:
                        if (optString.equals("onSEIAudioExtraInfoV0")) {
                            c2 = 31;
                            break;
                        }
                        break;
                    case 277599208:
                        if (optString.equals("onDSEMixAudioExtraInfoV1")) {
                            c2 = DecodedBitStreamParser.GS;
                            break;
                        }
                        break;
                    case 303848884:
                        if (optString.equals("onPlayerCachePositionUpdate")) {
                            c2 = '\n';
                            break;
                        }
                        break;
                    case 466690590:
                        if (optString.equals("onSEIVideoOriginalData")) {
                            c2 = '!';
                            break;
                        }
                        break;
                    case 554677256:
                        if (optString.equals("onPlayerDecodeType")) {
                            c2 = 21;
                            break;
                        }
                        break;
                    case 598376093:
                        if (optString.equals("onPlayerVideoPlayPaused")) {
                            c2 = 25;
                            break;
                        }
                        break;
                    case 822132006:
                        if (optString.equals("onPlayerUpdatePcdnUrlResult")) {
                            c2 = 24;
                            break;
                        }
                        break;
                    case 853792181:
                        if (optString.equals("onAudioFocusListener")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 1012167752:
                        if (optString.equals("onPlayerError")) {
                            c2 = 14;
                            break;
                        }
                        break;
                    case 1055756567:
                        if (optString.equals("onPlayerRenderFramerate")) {
                            c2 = 18;
                            break;
                        }
                        break;
                    case 1141144174:
                        if (optString.equals("onPlayerInfo")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1147162650:
                        if (optString.equals("onPlayerPlayCompletionOneLoop")) {
                            c2 = '\r';
                            break;
                        }
                        break;
                    case 1343087941:
                        if (optString.equals("onPlayerVideoSizeUpdate")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1385041286:
                        if (optString.equals("onLoadingUpdate")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 1468645360:
                        if (optString.equals("onPlayerPlayCompletion")) {
                            c2 = '\f';
                            break;
                        }
                        break;
                    case 1482173798:
                        if (optString.equals("onPlayerPlayPositionUpdate")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case 1668839139:
                        if (optString.equals("onPlayerStatistics")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case 1955119023:
                        if (optString.equals("onPlayerReceiveToRenderDelay")) {
                            c2 = 17;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        this.k = jSONObject2.optInt("playerUID");
                        TLog.h("[VodPlayerClient]", M0() + "setPlayerUID:" + this.k);
                        return;
                    case 1:
                        this.m = jSONObject2.optString("redirectUrl");
                        TLog.h("[VodPlayerClient]", M0() + "setRedirectUrl:" + this.m);
                        return;
                    case 2:
                        if (jSONObject2.optInt("i") == 3) {
                            this.n.set((int) jSONObject2.optLong("l"));
                        }
                        m mVar = new m(this);
                        mVar.a = optString;
                        mVar.c = jSONObject2;
                        R0(mVar, false);
                        return;
                    case 3:
                        int optInt = jSONObject2.optInt("i");
                        int optInt2 = jSONObject2.optInt("i1");
                        this.o.set(optInt);
                        this.p.set(optInt2);
                        m mVar2 = new m(this);
                        mVar2.a = optString;
                        mVar2.c = jSONObject2;
                        R0(mVar2, false);
                        return;
                    case 4:
                        m mVar3 = new m(this);
                        mVar3.a = optString;
                        mVar3.c = jSONObject2;
                        R0(mVar3, true);
                        return;
                    case 5:
                        if (jSONObject2 != null) {
                            int optInt3 = jSONObject2.optInt("i");
                            TLog.h("[VodPlayerClient]", M0() + " onAudioFocusListener,focus status:" + optInt3);
                            p3c p3cVar = this.U.get();
                            if (p3cVar != null) {
                                p3cVar.onAudioFocusChange(optInt3);
                                return;
                            }
                            return;
                        }
                        return;
                    case 6:
                        if (jSONObject2 != null) {
                            int optInt4 = jSONObject2.optInt("i");
                            long optLong = jSONObject2.optLong("l1");
                            long optLong2 = jSONObject2.optLong("l2");
                            long optLong3 = jSONObject2.optLong("l3");
                            String optString2 = jSONObject2.optString("s");
                            JSONObject optJSONObject = jSONObject2.optJSONObject("o");
                            TLog.h("[VodPlayerClient]", M0() + " OnPlayerExtraInfoListener,type:" + optInt4);
                            u3c u3cVar = this.S.get();
                            if (u3cVar != null) {
                                u3cVar.a(optInt4, optLong, optLong2, optLong3, optString2, optJSONObject);
                                return;
                            }
                            return;
                        }
                        return;
                    case 7:
                    case '\b':
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                        m mVar4 = new m(this);
                        mVar4.a = optString;
                        mVar4.c = jSONObject2;
                        R0(mVar4, false);
                        return;
                    case 26:
                        q3c q3cVar = this.M.get();
                        Executor executor = this.L.get();
                        if (q3cVar != null && executor != null) {
                            executor.execute(new f(this, jSONObject2, q3cVar));
                            return;
                        }
                        return;
                    case 27:
                        q3c q3cVar2 = this.M.get();
                        Executor executor2 = this.L.get();
                        if (q3cVar2 != null && executor2 != null) {
                            executor2.execute(new g(this, jSONObject2, q3cVar2));
                            return;
                        }
                        return;
                    case 28:
                        q3c q3cVar3 = this.M.get();
                        Executor executor3 = this.L.get();
                        if (q3cVar3 != null && executor3 != null) {
                            executor3.execute(new h(this, jSONObject2, q3cVar3));
                            return;
                        }
                        return;
                    case 29:
                        q3c q3cVar4 = this.M.get();
                        Executor executor4 = this.L.get();
                        if (q3cVar4 != null && executor4 != null) {
                            executor4.execute(new i(this, jSONObject2, q3cVar4));
                            return;
                        }
                        return;
                    case 30:
                        j4c.c cVar = this.N.get();
                        Executor executor5 = this.L.get();
                        if (cVar != null && executor5 != null) {
                            executor5.execute(new j(this, jSONObject2, cVar));
                            return;
                        }
                        return;
                    case 31:
                        q3c q3cVar5 = this.M.get();
                        Executor executor6 = this.L.get();
                        if (q3cVar5 != null && executor6 != null) {
                            executor6.execute(new k(this, jSONObject2, q3cVar5));
                            return;
                        }
                        return;
                    case ' ':
                        q3c q3cVar6 = this.M.get();
                        Executor executor7 = this.L.get();
                        if (q3cVar6 != null && executor7 != null) {
                            executor7.execute(new l(this, jSONObject2, q3cVar6));
                            return;
                        }
                        return;
                    case '!':
                        q3c q3cVar7 = this.M.get();
                        Executor executor8 = this.L.get();
                        if (q3cVar7 != null && executor8 != null) {
                            executor8.execute(new a(this, jSONObject2, q3cVar7));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Exception e2) {
                TLog.d("[VodPlayerClient]", M0() + "(onData) ex: " + e2.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void q(Executor executor, j4c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, executor, dVar) == null) {
            TLog.h("[VodPlayerClient]", M0() + "screenShot");
            synchronized (this) {
                this.A = new WeakReference<>(executor);
                this.B = new WeakReference<>(dVar);
                i3c i3cVar = new i3c();
                i3cVar.a = "screenShot";
                P0(this.f.toJson(i3cVar));
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void s(o3c o3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, o3cVar) == null) {
            if (o3cVar != null) {
                this.l = (int) o3cVar.j();
                TLog.h("[VodPlayerClient]", M0() + "setDataSource:" + o3cVar.k());
                synchronized (this) {
                    String r = o3c.r(o3cVar);
                    if (r != null && !r.isEmpty()) {
                        this.z = o3cVar.d();
                        i3c i3cVar = new i3c();
                        i3cVar.a = "setDataSource";
                        i3cVar.b.put("source", r);
                        P0(this.f.toJson(i3cVar));
                        return;
                    }
                    TLog.d("[VodPlayerClient]", M0() + "setDataSource#dataSource is empty");
                    return;
                }
            }
            TLog.d("[VodPlayerClient]", M0() + "setDataSource#source is null");
        }
    }

    @Override // com.baidu.tieba.l5c
    public void t(o3c o3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, o3cVar) == null) {
            if (o3cVar != null) {
                this.l = (int) o3cVar.j();
                TLog.h("[VodPlayerClient]", M0() + "setDataSourceAndPrepare:" + o3cVar.k());
                synchronized (this) {
                    String r = o3c.r(o3cVar);
                    if (r != null && !r.isEmpty()) {
                        this.z = o3cVar.d();
                        i3c i3cVar = new i3c();
                        i3cVar.a = "setDataSourceAndPrepare";
                        i3cVar.b.put("source", r);
                        P0(this.f.toJson(i3cVar));
                        return;
                    }
                    TLog.d("[VodPlayerClient]", M0() + "setDataSourceAndPrepare#dataSource is empty");
                    return;
                }
            }
            TLog.d("[VodPlayerClient]", M0() + "setDataSourceAndPrepare#source is null");
        }
    }
}

package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tieba.b5c;
import com.baidu.tieba.j4c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.NetRequestStatusInfo;
import com.yy.transvod.player.log.TLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class m5c extends l5c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicInteger A;
    public AtomicInteger B;
    public AtomicInteger C;
    public Object D;
    public i4c E;
    public Executor F;
    public boolean G;
    public b5c.e H;
    public int c;
    public String d;
    public Handler e;
    public b5c f;
    public WeakReference<w3c> g;
    public WeakReference<t3c> h;
    public WeakReference<d4c> i;
    public WeakReference<c4c> j;
    public WeakReference<z3c> k;
    public WeakReference<x3c> l;
    public WeakReference<a4c> m;
    public WeakReference<v3c> n;
    public WeakReference<r3c> o;
    public WeakReference<q3c> p;
    public WeakReference<j4c.c> q;
    public WeakReference<y3c> r;
    public WeakReference<b4c> s;
    public WeakReference<g4c> t;
    public WeakReference<u3c> u;
    public WeakReference<f4c> v;
    public AtomicInteger w;
    public AtomicInteger x;
    public AtomicInteger y;
    public AtomicInteger z;

    /* loaded from: classes7.dex */
    public class b implements b5c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m5c a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Message a;
            public final /* synthetic */ b b;

            public a(b bVar, Message message) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, message};
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
                this.a = message;
            }

            @Override // java.lang.Runnable
            public void run() {
                q3c q3cVar;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (q3cVar = (q3c) this.b.a.p.get()) == null) {
                    return;
                }
                Message message = this.a;
                if (message.what == 69) {
                    q3cVar.onSEIAudioOriginalData(this.b.a.a, (byte[]) message.obj, message.arg1);
                }
                Message message2 = this.a;
                if (message2.what == 68) {
                    q3cVar.onSEIVideoOriginalData(this.b.a.a, (byte[]) message2.obj, message2.arg1);
                }
                Message message3 = this.a;
                if (message3.what == 67) {
                    q3cVar.onSEIAudioExtraInfoV0(this.b.a.a, (ArrayList) message3.obj);
                }
                Message message4 = this.a;
                if (message4.what == 63) {
                    q3cVar.onSEIVideoExtraInfo(this.b.a.a, message4.arg1, (ArrayList) message4.obj);
                }
                Message message5 = this.a;
                if (message5.what == 64) {
                    q3cVar.onSEIMixVideoExtraInfo(this.b.a.a, message5.arg1, (ArrayList) message5.obj);
                }
                Message message6 = this.a;
                if (message6.what == 66) {
                    q3cVar.onSEIAlphaChannelInfo(this.b.a.a, message6.arg1, (ArrayList) message6.obj);
                }
                Message message7 = this.a;
                if (message7.what == 65) {
                    q3cVar.onDSEMixAudioExtraInfoV1(this.b.a.a, (ArrayList) message7.obj);
                }
            }
        }

        public b(m5c m5cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m5cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m5cVar;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:107:0x02b6 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x027d A[ADDED_TO_REGION] */
        @Override // com.baidu.tieba.b5c.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(Message message) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                c cVar = new c(this.a);
                Object obj = message.obj;
                if (obj instanceof String) {
                    cVar.d = (String) obj;
                }
                int i = message.what;
                cVar.a = i;
                int i2 = 0;
                if (i != 5009) {
                    if (i != 5010) {
                        if (i != 5017) {
                            if (i != 5019) {
                                if (i != 5030) {
                                    if (i != 5040) {
                                        if (i != 5102) {
                                            if (i != 7000) {
                                                switch (i) {
                                                    case 63:
                                                    case 64:
                                                    case 65:
                                                    case 66:
                                                    case 67:
                                                    case 68:
                                                    case 69:
                                                        j4c.c cVar2 = (j4c.c) this.a.q.get();
                                                        if (cVar2 != null) {
                                                            if (message.what == 67) {
                                                                ArrayList arrayList = (ArrayList) message.obj;
                                                                ArrayList<MixAudioExtraInfo> arrayList2 = new ArrayList<>();
                                                                while (i2 < arrayList.size()) {
                                                                    arrayList2.add(new MixAudioExtraInfo(((Long) arrayList.get(i2)).toString(), -1));
                                                                    i2++;
                                                                }
                                                                cVar2.a(this.a.a, arrayList2);
                                                            }
                                                            if (message.what == 65) {
                                                                cVar2.a(this.a.a, (ArrayList) message.obj);
                                                            }
                                                        }
                                                        if (this.a.F == null) {
                                                            return;
                                                        }
                                                        try {
                                                            this.a.F.execute(new a(this, message));
                                                            return;
                                                        } catch (Exception e) {
                                                            e.printStackTrace();
                                                            return;
                                                        }
                                                    default:
                                                        switch (i) {
                                                            case 5000:
                                                                cVar.c = message.arg2;
                                                                this.a.q0(message.arg1, cVar);
                                                                break;
                                                            case 5001:
                                                                cVar.b = message.arg1;
                                                                break;
                                                            case 5002:
                                                                cVar.b = message.arg1;
                                                                this.a.w.set(message.arg1);
                                                                break;
                                                            case 5003:
                                                                if (this.a.w.get() > 0) {
                                                                    this.a.B.set(message.arg1);
                                                                    cVar.b = message.arg1;
                                                                    break;
                                                                }
                                                                break;
                                                            case 5004:
                                                                if (this.a.w.get() > 0) {
                                                                    this.a.x.set(message.arg1);
                                                                    cVar.b = message.arg1;
                                                                    break;
                                                                }
                                                                break;
                                                            case 5005:
                                                                cVar.b = message.arg1;
                                                                this.a.y.set(message.arg1);
                                                                break;
                                                            default:
                                                                switch (i) {
                                                                    case 5013:
                                                                        cVar.b = message.arg1;
                                                                        cVar.c = message.arg2;
                                                                        cVar.f = message.obj;
                                                                        break;
                                                                    case 5014:
                                                                        cVar.f = message.obj;
                                                                        break;
                                                                    case SpeedStatsStampTable.HOME_VIEW_ON_LAYOUT_END_STAMP_KEY /* 5015 */:
                                                                        if (this.a.z.get() == message.arg1 && this.a.A.get() == message.arg2) {
                                                                            z = false;
                                                                            break;
                                                                        } else {
                                                                            cVar.b = message.arg1;
                                                                            cVar.c = message.arg2;
                                                                            this.a.z.set(message.arg1);
                                                                            this.a.A.set(message.arg2);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    default:
                                                                        switch (i) {
                                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_END_STAMP_KEY /* 5203 */:
                                                                                break;
                                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONRESUME_STAMP_KEY /* 5204 */:
                                                                                cVar.b = message.arg1;
                                                                                cVar.c = message.arg2;
                                                                                cVar.e = System.currentTimeMillis();
                                                                                break;
                                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DATABACK_STAMP_KEY /* 5205 */:
                                                                                cVar.b = message.arg1;
                                                                                cVar.c = message.arg2;
                                                                                cVar.f = message.obj;
                                                                                cVar.e = System.currentTimeMillis();
                                                                                TLog.g(this, "first frame again show, going to transmit to mainloop");
                                                                                break;
                                                                            default:
                                                                                switch (i) {
                                                                                    case 6000:
                                                                                    case 6001:
                                                                                    case 6002:
                                                                                    case AuthCode.StatusCode.PERMISSION_NOT_EXIST /* 6004 */:
                                                                                        cVar.b = message.arg1;
                                                                                        cVar.c = message.arg2;
                                                                                        break;
                                                                                    case AuthCode.StatusCode.CERT_FINGERPRINT_ERROR /* 6003 */:
                                                                                        cVar.b = message.arg1;
                                                                                        cVar.c = message.arg2;
                                                                                        break;
                                                                                }
                                                                                i2 = 1;
                                                                                break;
                                                                        }
                                                                }
                                                        }
                                                        if (this.a.e != null && i2 != 0) {
                                                            synchronized (this) {
                                                                if (this.a.e != null) {
                                                                    if (z) {
                                                                        this.a.e.sendMessageAtFrontOfQueue(Message.obtain(this.a.e, 1, cVar));
                                                                    } else {
                                                                        this.a.e.sendMessage(Message.obtain(this.a.e, 1, cVar));
                                                                    }
                                                                }
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                }
                                            }
                                            cVar.b = System.currentTimeMillis();
                                        } else {
                                            cVar.b = message.arg1;
                                            cVar.c = message.arg2;
                                            cVar.f = message.obj;
                                            cVar.e = System.currentTimeMillis();
                                            TLog.g(this, "first frame show, going to transmit to mainloop");
                                        }
                                        z = true;
                                        i2 = 1;
                                        if (this.a.e != null) {
                                            return;
                                        }
                                        return;
                                    }
                                    cVar.b = message.arg1;
                                } else {
                                    cVar.b = message.arg1;
                                    cVar.c = message.arg2;
                                    cVar.d = (String) message.obj;
                                }
                            } else {
                                cVar.b = message.arg1;
                                cVar.f = message.obj;
                            }
                        } else {
                            synchronized (this) {
                                if (this.a.f != null) {
                                    this.a.f.O0();
                                }
                            }
                            cVar.b = this.a.B.get();
                            cVar.c = this.a.w.get();
                            this.a.B.set(0);
                            this.a.x.set(0);
                        }
                    } else {
                        cVar.b = message.arg1;
                        cVar.c = message.arg2;
                        cVar.f = message.obj;
                    }
                } else {
                    Object obj2 = message.obj;
                    if (obj2 instanceof String) {
                        cVar.b = message.arg1;
                        cVar.d = (String) obj2;
                    }
                }
                z = false;
                i2 = 1;
                if (this.a.e != null) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m5c a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                if (message.what == 1) {
                    c cVar = (c) message.obj;
                    int i = cVar.a;
                    if (i == 1) {
                        TLog.g(this, String.format(Locale.getDefault(), "player state stopped(%d)", Integer.valueOf(this.a.c)));
                        this.a.C.set(1);
                        c4c c4cVar = (c4c) this.a.j.get();
                        if (c4cVar != null) {
                            c4cVar.onPlayerStateUpdate(this.a.a, 1, 0);
                        }
                    } else if (i == 5030) {
                        f4c f4cVar = (f4c) this.a.v.get();
                        if (f4cVar != null) {
                            f4cVar.a(this.a.a, (int) cVar.b, cVar.d, (int) cVar.c);
                        } else {
                            TLog.c(this, "OnPlayerUpdatePcdnUrlResultListener is null");
                        }
                    } else if (i == 5040) {
                        TLog.g(this, String.format(Locale.getDefault(), "player play duration:%d  (%d)", Long.valueOf(cVar.b), Integer.valueOf(this.a.c)));
                        w3c w3cVar = (w3c) this.a.g.get();
                        if (w3cVar != null) {
                            w3cVar.onPlayerInfo(this.a.a, 4, cVar.b);
                        }
                    } else if (i == 5102) {
                        TLog.l(this, String.format(Locale.getDefault(), "player first frame show(%d)", Integer.valueOf(((Long) cVar.f).intValue())));
                        v3c v3cVar = (v3c) this.a.n.get();
                        if (v3cVar != null) {
                            v3cVar.onPlayerFirstVideoFrameShow(this.a.a, (int) cVar.b, (int) cVar.c, ((Long) cVar.f).intValue());
                        } else {
                            TLog.c(this, String.format(Locale.getDefault(), "player first frame show : listener is null ", new Object[0]));
                        }
                        u3c u3cVar = (u3c) this.a.u.get();
                        if (u3cVar != null) {
                            u3cVar.a(103, cVar.e, 0L, 0L, null, null);
                        }
                    } else if (i == 7000) {
                        u3c u3cVar2 = (u3c) this.a.u.get();
                        TLog.g(this, "on demuxer read header end");
                        if (u3cVar2 != null) {
                            u3cVar2.a(102, cVar.b, 0L, 0L, null, null);
                        }
                    } else if (i == 5009) {
                        d4c d4cVar = (d4c) this.a.i.get();
                        if (d4cVar != null) {
                            d4cVar.onPlayerStatistics(this.a.a, (int) cVar.b, cVar.d);
                        }
                    } else if (i != 5010) {
                        switch (i) {
                            case 4:
                                TLog.g(this, String.format(Locale.getDefault(), "player state ready(%d)", Integer.valueOf(this.a.c)));
                                this.a.C.set(4);
                                c4c c4cVar2 = (c4c) this.a.j.get();
                                if (c4cVar2 != null) {
                                    c4cVar2.onPlayerStateUpdate(this.a.a, 4, 0);
                                    break;
                                }
                                break;
                            case 5:
                                TLog.g(this, String.format(Locale.getDefault(), "player state loading(%d)", Integer.valueOf(this.a.c)));
                                this.a.C.set(5);
                                c4c c4cVar3 = (c4c) this.a.j.get();
                                if (c4cVar3 != null) {
                                    c4cVar3.onPlayerStateUpdate(this.a.a, 5, (int) cVar.c);
                                    break;
                                }
                                break;
                            case 6:
                                TLog.g(this, String.format(Locale.getDefault(), "player state playing(%d)", Integer.valueOf(this.a.c)));
                                this.a.C.set(6);
                                c4c c4cVar4 = (c4c) this.a.j.get();
                                if (c4cVar4 != null) {
                                    c4cVar4.onPlayerStateUpdate(this.a.a, 6, 0);
                                    break;
                                }
                                break;
                            case 7:
                                TLog.g(this, String.format(Locale.getDefault(), "player state paused(%d)", Integer.valueOf(this.a.c)));
                                this.a.C.set(7);
                                c4c c4cVar5 = (c4c) this.a.j.get();
                                if (c4cVar5 != null) {
                                    c4cVar5.onPlayerStateUpdate(this.a.a, 7, 0);
                                    break;
                                }
                                break;
                            case 8:
                                TLog.g(this, String.format(Locale.getDefault(), "player play end(%d)", Integer.valueOf(this.a.c)));
                                z3c z3cVar = (z3c) this.a.k.get();
                                if (z3cVar != null) {
                                    z3cVar.onPlayerPlayCompletion(this.a.a);
                                }
                                this.a.C.set(8);
                                c4c c4cVar6 = (c4c) this.a.j.get();
                                if (c4cVar6 != null) {
                                    c4cVar6.onPlayerStateUpdate(this.a.a, 8, 0);
                                    break;
                                }
                                break;
                            case 9:
                                TLog.g(this, String.format(Locale.getDefault(), "player state invalid(%d)", Integer.valueOf(this.a.c)));
                                c4c c4cVar7 = (c4c) this.a.j.get();
                                if (c4cVar7 != null) {
                                    c4cVar7.onPlayerStateUpdate(this.a.a, 9, 0);
                                    break;
                                }
                                break;
                            default:
                                switch (i) {
                                    case 5001:
                                        TLog.a(this, String.format(Locale.getDefault(), "player loading (%d)", Long.valueOf(cVar.b)));
                                        x3c x3cVar = (x3c) this.a.l.get();
                                        if (x3cVar != null) {
                                            x3cVar.a(this.a.a, (int) cVar.b);
                                            break;
                                        }
                                        break;
                                    case 5002:
                                        TLog.g(this, String.format(Locale.getDefault(), "player resource duration:%d  (%d)", Long.valueOf(cVar.b), Integer.valueOf(this.a.c)));
                                        w3c w3cVar2 = (w3c) this.a.g.get();
                                        if (w3cVar2 != null) {
                                            w3cVar2.onPlayerInfo(this.a.a, 3, cVar.b);
                                            break;
                                        }
                                        break;
                                    case 5003:
                                        a4c a4cVar = (a4c) this.a.m.get();
                                        if (a4cVar != null) {
                                            a4cVar.a(this.a.a, cVar.b);
                                            break;
                                        }
                                        break;
                                    case 5004:
                                        TLog.g(this, String.format(Locale.getDefault(), "player cache (%d)", Long.valueOf(cVar.b)));
                                        r3c r3cVar = (r3c) this.a.o.get();
                                        if (r3cVar != null) {
                                            r3cVar.onPlayerCachePositionUpdate(this.a.a, cVar.b);
                                            break;
                                        }
                                        break;
                                    case 5005:
                                        TLog.g(this, String.format(Locale.getDefault(), "player resource total size: (%d)", Long.valueOf(cVar.b), Integer.valueOf(this.a.c)));
                                        w3c w3cVar3 = (w3c) this.a.g.get();
                                        if (w3cVar3 != null) {
                                            w3cVar3.onPlayerInfo(this.a.a, 2, cVar.b);
                                            break;
                                        }
                                        break;
                                    default:
                                        switch (i) {
                                            case 5013:
                                                TLog.g(this, String.format(Locale.getDefault(), "player download speed(%d)", Long.valueOf(cVar.b)));
                                                w3c w3cVar4 = (w3c) this.a.g.get();
                                                if (w3cVar4 != null) {
                                                    w3cVar4.onPlayerInfo(this.a.a, 0, cVar.b);
                                                    break;
                                                }
                                                break;
                                            case 5014:
                                                TLog.g(this, String.format(Locale.getDefault(), "player caton times: %d  (%d)", Long.valueOf(cVar.b), Integer.valueOf(this.a.c)));
                                                w3c w3cVar5 = (w3c) this.a.g.get();
                                                if (w3cVar5 != null) {
                                                    w3cVar5.onPlayerInfo(this.a.a, 1, cVar.b);
                                                    break;
                                                }
                                                break;
                                            case SpeedStatsStampTable.HOME_VIEW_ON_LAYOUT_END_STAMP_KEY /* 5015 */:
                                                TLog.g(this, String.format(Locale.getDefault(), "player resolution  w: %d  h: %d (%d)", Long.valueOf(cVar.b), Long.valueOf(cVar.c), Integer.valueOf(this.a.c)));
                                                w3c w3cVar6 = (w3c) this.a.g.get();
                                                if (w3cVar6 != null) {
                                                    w3cVar6.onPlayerVideoSizeUpdate(this.a.a, (int) cVar.b, (int) cVar.c);
                                                    break;
                                                }
                                                break;
                                            default:
                                                switch (i) {
                                                    case SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_END_STAMP_KEY /* 5017 */:
                                                        TLog.g(this, String.format(Locale.getDefault(), "player one loop end(%d)", Integer.valueOf(this.a.c)));
                                                        z3c z3cVar2 = (z3c) this.a.k.get();
                                                        if (z3cVar2 != null) {
                                                            z3cVar2.onPlayerPlayCompletionOneLoop(this.a.a);
                                                            break;
                                                        }
                                                        break;
                                                    case 5018:
                                                        r3c r3cVar2 = (r3c) this.a.o.get();
                                                        if (r3cVar2 != null) {
                                                            r3cVar2.onPlayerCacheWriteToDiskCompleted(this.a.a, cVar.d);
                                                            break;
                                                        }
                                                        break;
                                                    case 5019:
                                                        y3c y3cVar = (y3c) this.a.r.get();
                                                        if (y3cVar != null) {
                                                            NetRequestStatusInfo netRequestStatusInfo = (NetRequestStatusInfo) cVar.f;
                                                            y3cVar.a(this.a.a, (int) cVar.b, netRequestStatusInfo);
                                                            TLog.g(this, String.format(Locale.getDefault(), "player serverIp : %s", netRequestStatusInfo.b));
                                                            break;
                                                        } else {
                                                            TLog.c(this, "OnPlayerNetRequestStatusListener is null");
                                                            break;
                                                        }
                                                    default:
                                                        switch (i) {
                                                            case SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_START_STAMP_KEY /* 5200 */:
                                                                Log.i("transvod", "play egl setup fail");
                                                                TLog.c(this, String.format(Locale.getDefault(), "egl setup failed", new Object[0]));
                                                                t3c t3cVar = (t3c) this.a.h.get();
                                                                if (t3cVar != null) {
                                                                    m5c m5cVar = this.a;
                                                                    t3cVar.onPlayerError(m5cVar.a, m5cVar.d, SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_START_STAMP_KEY, 0);
                                                                    break;
                                                                }
                                                                break;
                                                            case SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_END_STAMP_KEY /* 5201 */:
                                                                g4c g4cVar = (g4c) this.a.t.get();
                                                                if (g4cVar != null) {
                                                                    g4cVar.a(true);
                                                                    break;
                                                                }
                                                                break;
                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_START_STAMP_KEY /* 5202 */:
                                                                g4c g4cVar2 = (g4c) this.a.t.get();
                                                                if (g4cVar2 != null) {
                                                                    g4cVar2.a(false);
                                                                    break;
                                                                }
                                                                break;
                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_END_STAMP_KEY /* 5203 */:
                                                                u3c u3cVar3 = (u3c) this.a.u.get();
                                                                TLog.g(this, "onSurfaceStatus create");
                                                                if (u3cVar3 != null) {
                                                                    u3cVar3.a(100, cVar.b, 0L, 0L, null, null);
                                                                    break;
                                                                }
                                                                break;
                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONRESUME_STAMP_KEY /* 5204 */:
                                                                u3c u3cVar4 = (u3c) this.a.u.get();
                                                                TLog.g(this, "onSurfaceStatus changed");
                                                                if (u3cVar4 != null) {
                                                                    u3cVar4.a(101, cVar.b, cVar.c, cVar.e, null, null);
                                                                    break;
                                                                }
                                                                break;
                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DATABACK_STAMP_KEY /* 5205 */:
                                                                TLog.l(this, String.format(Locale.getDefault(), "player first frame again show(%d)", Integer.valueOf(((Long) cVar.f).intValue())));
                                                                u3c u3cVar5 = (u3c) this.a.u.get();
                                                                if (u3cVar5 != null) {
                                                                    TLog.g(this, String.format(Locale.getDefault(), "OnPlayerExtraInfoListener:(%d)", 104));
                                                                    u3cVar5.a(104, cVar.b, cVar.c, cVar.e, null, null);
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                switch (i) {
                                                                    case 6000:
                                                                        b4c b4cVar = (b4c) this.a.s.get();
                                                                        if (b4cVar != null) {
                                                                            b4cVar.onPlayerReceiveToRenderDelay(this.a.a, (int) cVar.b);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 6001:
                                                                        Log.i("hello", "rendering frameRate " + ((int) cVar.b));
                                                                        b4c b4cVar2 = (b4c) this.a.s.get();
                                                                        if (b4cVar2 != null) {
                                                                            b4cVar2.onPlayerRenderFramerate(this.a.a, (int) cVar.b);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 6002:
                                                                        b4c b4cVar3 = (b4c) this.a.s.get();
                                                                        if (b4cVar3 != null) {
                                                                            b4cVar3.onPlayerDecodeType(this.a.a, (int) cVar.b);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case AuthCode.StatusCode.CERT_FINGERPRINT_ERROR /* 6003 */:
                                                                        b4c b4cVar4 = (b4c) this.a.s.get();
                                                                        if (b4cVar4 != null) {
                                                                            TLog.g(this, String.format(Locale.getDefault(), "decoder output size %d * %d", Integer.valueOf((int) cVar.b), Integer.valueOf((int) cVar.c)));
                                                                            b4cVar4.onPlayerDecodeOuputSize(this.a.a, (int) cVar.b, (int) cVar.c);
                                                                            break;
                                                                        } else {
                                                                            TLog.g(this, "OnPlayerQualityMonitorListener is null");
                                                                            break;
                                                                        }
                                                                    case AuthCode.StatusCode.PERMISSION_NOT_EXIST /* 6004 */:
                                                                        b4c b4cVar5 = (b4c) this.a.s.get();
                                                                        if (b4cVar5 != null) {
                                                                            b4cVar5.onPlayerDecodeBitrate(this.a.a, (int) cVar.b, (int) cVar.c);
                                                                            Log.i("hello", "videoBitrate " + ((int) cVar.b) + " audioBitrate " + ((int) cVar.c));
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED /* 6005 */:
                                                                        b4c b4cVar6 = (b4c) this.a.s.get();
                                                                        if (b4cVar6 != null) {
                                                                            b4cVar6.onPlayerVideoStalls(this.a.a, ((int) cVar.b) == 1, (int) cVar.c);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case AuthCode.StatusCode.PERMISSION_EXPIRED /* 6006 */:
                                                                        b4c b4cVar7 = (b4c) this.a.s.get();
                                                                        if (b4cVar7 != null) {
                                                                            b4cVar7.onPlayerAudioStalls(this.a.a, ((int) cVar.b) == 1, (int) cVar.c);
                                                                            break;
                                                                        }
                                                                        break;
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                    } else {
                        Log.i("transvod", "player error code " + cVar.b);
                        TLog.c(this, String.format(Locale.getDefault(), "player error code : %d", Long.valueOf(cVar.b)));
                        if (this.a.G) {
                            TLog.c(this, "stop by self");
                            this.a.G();
                        }
                        t3c t3cVar2 = (t3c) this.a.h.get();
                        if (t3cVar2 != null) {
                            t3cVar2.onPlayerError(this.a.a, (String) cVar.f, (int) cVar.b, (int) cVar.c);
                        }
                    }
                    m5c m5cVar2 = this.a;
                    m5cVar2.b = m5cVar2.C.get() == 6;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m5c m5cVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m5cVar, looper};
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
            this.a = m5cVar;
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public long c;
        public String d;
        public long e;
        public Object f;
        public final /* synthetic */ m5c g;

        public c(m5c m5cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m5cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = m5cVar;
            this.a = 0;
            this.b = 0L;
            this.c = 0L;
            this.d = null;
            this.e = 0L;
            this.f = null;
        }
    }

    public m5c(Context context, i4c i4cVar, j4c j4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, i4cVar, j4cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = new WeakReference<>(null);
        this.h = new WeakReference<>(null);
        this.i = new WeakReference<>(null);
        this.j = new WeakReference<>(null);
        this.k = new WeakReference<>(null);
        this.l = new WeakReference<>(null);
        this.m = new WeakReference<>(null);
        this.n = new WeakReference<>(null);
        this.o = new WeakReference<>(null);
        this.p = new WeakReference<>(null);
        this.q = new WeakReference<>(null);
        this.r = new WeakReference<>(null);
        this.s = new WeakReference<>(null);
        this.t = new WeakReference<>(null);
        this.u = new WeakReference<>(null);
        this.v = new WeakReference<>(null);
        this.w = new AtomicInteger(0);
        this.x = new AtomicInteger(0);
        this.y = new AtomicInteger(0);
        this.z = new AtomicInteger(0);
        this.A = new AtomicInteger(0);
        this.B = new AtomicInteger(0);
        this.C = new AtomicInteger(0);
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = false;
        this.H = new b(this);
        long currentTimeMillis = System.currentTimeMillis();
        this.a = j4cVar;
        this.E = i4cVar;
        m0(context.getApplicationContext(), i4cVar);
        TLog.l(this, "[transvod] create VodPlayer cost: " + (System.currentTimeMillis() - currentTimeMillis) + " sdkversion: " + j() + " isSubProcess:" + i4cVar.m);
    }

    @Override // com.baidu.tieba.l5c
    public void A(w3c w3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, w3cVar) == null) {
            this.g = new WeakReference<>(w3cVar);
        }
    }

    public void A0(x3c x3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x3cVar) == null) {
            this.l = new WeakReference<>(x3cVar);
        }
    }

    @Override // com.baidu.tieba.l5c
    public void B(b4c b4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b4cVar) == null) {
            this.s = new WeakReference<>(b4cVar);
        }
    }

    public void B0(y3c y3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, y3cVar) == null) {
            this.r = new WeakReference<>(y3cVar);
        }
    }

    @Override // com.baidu.tieba.l5c
    public void C(c4c c4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, c4cVar) == null) {
            this.j = new WeakReference<>(c4cVar);
        }
    }

    public void C0(z3c z3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, z3cVar) == null) {
            this.k = new WeakReference<>(z3cVar);
        }
    }

    @Override // com.baidu.tieba.l5c
    public void D(d4c d4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, d4cVar) == null) {
            this.i = new WeakReference<>(d4cVar);
        }
    }

    public void D0(a4c a4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, a4cVar) == null) {
            this.m = new WeakReference<>(a4cVar);
        }
    }

    public void E0(f4c f4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, f4cVar) == null) {
            this.v = new WeakReference<>(f4cVar);
        }
    }

    public void F0(g4c g4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, g4cVar) == null) {
            this.t = new WeakReference<>(g4cVar);
        }
    }

    public void H0(j4c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.q = new WeakReference<>(cVar);
        }
    }

    public void I0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            synchronized (this) {
                if (this.f != null) {
                    this.f.f1(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void s(o3c o3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, o3cVar) == null) {
            synchronized (this) {
                if (this.f != null) {
                    this.d = o3cVar.k();
                    this.G = o3cVar.d();
                    this.f.U0(o3cVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void t(o3c o3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, o3cVar) == null) {
            synchronized (this) {
                if (this.f != null) {
                    this.d = o3cVar.k();
                    this.G = o3cVar.d();
                    this.f.V0(o3cVar);
                }
            }
        }
    }

    public void v0(boolean z) {
        b5c b5cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048622, this, z) == null) && (b5cVar = this.f) != null) {
            b5cVar.Y0(z);
        }
    }

    public void w0(boolean z) {
        b5c b5cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && (b5cVar = this.f) != null) {
            b5cVar.Z0(z);
        }
    }

    @Override // com.baidu.tieba.l5c
    public void x(r3c r3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, r3cVar) == null) {
            this.o = new WeakReference<>(r3cVar);
        }
    }

    @Override // com.baidu.tieba.l5c
    public void y(t3c t3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, t3cVar) == null) {
            this.h = new WeakReference<>(t3cVar);
        }
    }

    public void y0(p3c p3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, p3cVar) == null) {
            y4c.m(p3cVar);
        }
    }

    @Override // com.baidu.tieba.l5c
    public void z(v3c v3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, v3cVar) == null) {
            this.n = new WeakReference<>(v3cVar);
        }
    }

    public void z0(u3c u3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, u3cVar) == null) {
            this.u = new WeakReference<>(u3cVar);
        }
    }

    @Override // com.baidu.tieba.l5c
    public void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            TLog.g(this, this.c + "rotateMode: " + i + " enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.e1(i);
                }
            }
        }
    }

    public void G0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            TLog.g(this, this.c + "orientateMode: " + i + " enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.d1(i);
                }
            }
        }
    }

    public void J0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            TLog.g(this, this.c + "volume:" + i + " enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.g1(i);
                }
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            TLog.g(this, this.c + "displayMode: " + i + " enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.W0(i);
                }
            }
        }
    }

    public void u0(x4c x4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, x4cVar) == null) {
            TLog.g(this, this.c + " setEffectResources " + x4c.d(x4cVar));
            synchronized (this) {
                if (this.f == null) {
                    return;
                }
                this.f.X0(x4cVar);
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            TLog.g(this, this.c + "VodPlay enter.  setNumberOfLoops: " + i);
            synchronized (this) {
                if (this.f != null) {
                    this.f.b1(i);
                }
            }
        }
    }

    public void x0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            TLog.g(this, this.c + "isSpecialMp4WithAlpha: " + z + " enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.a1(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void F(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            TLog.l(this, this.c + "VodPlay.start enter, isSubProcess:" + this.E.m);
            StringBuilder sb = new StringBuilder();
            sb.append(this.c);
            sb.append(" VodPlay.start enter. ");
            Log.i("transvod", sb.toString());
            synchronized (this) {
                if (this.f != null) {
                    this.f.i1(i, j);
                }
            }
        }
    }

    public final void m0(Context context, i4c i4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, i4cVar) == null) {
            TLog.k(4);
            k5c.a(context);
            h3c.c(context);
            m6c m6cVar = i4cVar.j;
            if (m6cVar != null) {
                this.D = m6cVar;
            } else {
                l6c l6cVar = i4cVar.k;
                if (l6cVar != null) {
                    this.D = l6cVar;
                } else if (i4cVar.g) {
                    this.D = new SurfaceView(context);
                } else {
                    this.D = new TextureView(context);
                }
            }
            b5c b5cVar = new b5c(i4cVar);
            this.f = b5cVar;
            b5cVar.c1(this.H);
            this.f.h1(context, this.D);
            this.c = this.f.m0();
            TLog.l(this, String.format(Locale.getDefault(), "VodPlayer create(%d)", Integer.valueOf(this.c)));
            this.e = new a(this, Looper.getMainLooper());
        }
    }

    public final void q0(int i, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048612, this, i, cVar) == null) {
            TLog.g(this, String.format("mPlayerContextId = %d, MET_CALLBACK_PLAYER_STATE_CHANGE state = %d", Integer.valueOf(this.c), Integer.valueOf(i)));
            if (i != 1) {
                switch (i) {
                    case 4:
                        cVar.a = 4;
                        return;
                    case 5:
                        cVar.a = 5;
                        return;
                    case 6:
                        cVar.a = 6;
                        return;
                    case 7:
                        cVar.a = 7;
                        return;
                    case 8:
                        cVar.a = 8;
                        cVar.b = this.B.get();
                        cVar.c = this.w.get();
                        this.B.set(0);
                        this.x.set(0);
                        return;
                    default:
                        return;
                }
            }
            cVar.a = 1;
        }
    }

    @Override // com.baidu.tieba.l5c
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            Log.i("transvod", this.c + " VodPlay stop.");
            TLog.l(this, this.c + " VodPlay.stop enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.j1();
                }
                this.y.set(0);
                this.x.set(0);
                this.w.set(0);
                this.B.set(0);
                this.z.set(0);
                this.A.set(0);
            }
        }
    }

    public int K0(int i, o3c o3cVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i, o3cVar)) == null) {
            synchronized (this) {
                if (this.f != null) {
                    this.f.k1(i, o3cVar);
                    return 0;
                }
                return -1;
            }
        }
        return invokeIL.intValue;
    }

    @Override // com.baidu.tieba.l5c
    public void q(Executor executor, j4c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, executor, dVar) == null) {
            synchronized (this) {
                if (this.f != null) {
                    this.f.S0(executor, dVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void w(Executor executor, q3c q3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048623, this, executor, q3cVar) == null) {
            this.p = new WeakReference<>(q3cVar);
            this.F = executor;
        }
    }

    @Override // com.baidu.tieba.l5c
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TLog.g(this, this.c + "appInBackground");
            synchronized (this) {
                if (this.f != null) {
                    this.f.H0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            TLog.g(this, this.c + "appInFrontground");
            synchronized (this) {
                if (this.f != null) {
                    this.f.I0();
                }
            }
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            TLog.g(this, this.c + " disableJoyPkPipMode.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.j0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            TLog.g(this, this.c + "VodPlay.pausePlayWithAudio enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.L0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            TLog.g(this, this.c + "VodPlay.resumePlayWithAudio enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.Q0();
                }
            }
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            TLog.g(this, this.c + "VodPlay.pausePlayWithVideo enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.M0();
                }
            }
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            TLog.g(this, this.c + "VodPlay.resumePlayWithVideo enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.R0();
                }
            }
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.finalize();
        }
    }

    @Override // com.baidu.tieba.l5c
    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.B.get();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.l5c
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.w.get();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.l5c
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            TLog.g(this, this.c + "VodPlay.getPlayerView enter.");
            return this.D;
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.tieba.l5c
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.A.get();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.l5c
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.z.get();
        }
        return invokeV.intValue;
    }

    public int o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            TLog.g(this, this.c + "VodPlay.getPlayerUID enter.");
            return this.c;
        }
        return invokeV.intValue;
    }

    public String p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            b5c b5cVar = this.f;
            if (b5cVar != null) {
                return b5cVar.l0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l5c
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            Log.i("transvod", this.c + " VodPlay.pause. ");
            TLog.l(this, this.c + " VodPlay.pause enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.K0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            Log.i("transvod", this.c + " VodPlay.resume. ");
            TLog.l(this, this.c + " VodPlay.resumeenter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.P0();
                }
            }
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            Log.i("transvod", this.c + "VodPlay release.");
            TLog.l(this, this.c + "VodPlay release enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.N0();
                    this.f = null;
                }
                if (this.e != null) {
                    this.e.removeCallbacksAndMessages(null);
                    this.e = null;
                }
            }
        }
    }

    public void n0(n4c n4cVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, n4cVar) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.c);
            sb.append(" enableJoyPkPipMode:");
            if (n4cVar != null) {
                str = "(" + n4cVar.b + "," + n4cVar.c + "), (" + n4cVar.d + StringUtil.ARRAY_ELEMENT_SEPARATOR + n4cVar.e + "), force: " + n4cVar.a;
            } else {
                str = StringUtil.NULL_STRING;
            }
            sb.append(str);
            TLog.g(this, sb.toString());
            synchronized (this) {
                if (this.f != null) {
                    this.f.k0(n4cVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.l5c
    public void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048613, this, j) == null) {
            TLog.l(this, this.c + " VodPlay.seekTo enter.  seekToTime: " + j);
            synchronized (this) {
                if (j > this.w.get()) {
                    j = this.w.get();
                }
                if (j < 0) {
                    j = 0;
                }
                if (this.f != null) {
                    this.f.T0(j);
                }
            }
        }
    }
}

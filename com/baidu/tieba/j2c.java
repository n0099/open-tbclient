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
import com.baidu.tieba.g1c;
import com.baidu.tieba.y1c;
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
/* loaded from: classes6.dex */
public class j2c extends i2c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicInteger A;
    public AtomicInteger B;
    public AtomicInteger C;
    public Object D;
    public f1c E;
    public Executor F;
    public boolean G;
    public y1c.e H;
    public int c;
    public String d;
    public Handler e;
    public y1c f;
    public WeakReference<t0c> g;
    public WeakReference<q0c> h;
    public WeakReference<a1c> i;
    public WeakReference<z0c> j;
    public WeakReference<w0c> k;
    public WeakReference<u0c> l;
    public WeakReference<x0c> m;
    public WeakReference<s0c> n;
    public WeakReference<o0c> o;
    public WeakReference<n0c> p;
    public WeakReference<g1c.c> q;
    public WeakReference<v0c> r;
    public WeakReference<y0c> s;
    public WeakReference<d1c> t;
    public WeakReference<r0c> u;
    public WeakReference<c1c> v;
    public AtomicInteger w;
    public AtomicInteger x;
    public AtomicInteger y;
    public AtomicInteger z;

    /* loaded from: classes6.dex */
    public class b implements y1c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j2c a;

        /* loaded from: classes6.dex */
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
                n0c n0cVar;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (n0cVar = (n0c) this.b.a.p.get()) == null) {
                    return;
                }
                Message message = this.a;
                if (message.what == 69) {
                    n0cVar.onSEIAudioOriginalData(this.b.a.a, (byte[]) message.obj, message.arg1);
                }
                Message message2 = this.a;
                if (message2.what == 68) {
                    n0cVar.onSEIVideoOriginalData(this.b.a.a, (byte[]) message2.obj, message2.arg1);
                }
                Message message3 = this.a;
                if (message3.what == 67) {
                    n0cVar.onSEIAudioExtraInfoV0(this.b.a.a, (ArrayList) message3.obj);
                }
                Message message4 = this.a;
                if (message4.what == 63) {
                    n0cVar.onSEIVideoExtraInfo(this.b.a.a, message4.arg1, (ArrayList) message4.obj);
                }
                Message message5 = this.a;
                if (message5.what == 64) {
                    n0cVar.onSEIMixVideoExtraInfo(this.b.a.a, message5.arg1, (ArrayList) message5.obj);
                }
                Message message6 = this.a;
                if (message6.what == 66) {
                    n0cVar.onSEIAlphaChannelInfo(this.b.a.a, message6.arg1, (ArrayList) message6.obj);
                }
                Message message7 = this.a;
                if (message7.what == 65) {
                    n0cVar.onDSEMixAudioExtraInfoV1(this.b.a.a, (ArrayList) message7.obj);
                }
            }
        }

        public b(j2c j2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j2cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j2cVar;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:107:0x02b6 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x027d A[ADDED_TO_REGION] */
        @Override // com.baidu.tieba.y1c.e
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
                                                        g1c.c cVar2 = (g1c.c) this.a.q.get();
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

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j2c a;

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
                        z0c z0cVar = (z0c) this.a.j.get();
                        if (z0cVar != null) {
                            z0cVar.onPlayerStateUpdate(this.a.a, 1, 0);
                        }
                    } else if (i == 5030) {
                        c1c c1cVar = (c1c) this.a.v.get();
                        if (c1cVar != null) {
                            c1cVar.a(this.a.a, (int) cVar.b, cVar.d, (int) cVar.c);
                        } else {
                            TLog.c(this, "OnPlayerUpdatePcdnUrlResultListener is null");
                        }
                    } else if (i == 5040) {
                        TLog.g(this, String.format(Locale.getDefault(), "player play duration:%d  (%d)", Long.valueOf(cVar.b), Integer.valueOf(this.a.c)));
                        t0c t0cVar = (t0c) this.a.g.get();
                        if (t0cVar != null) {
                            t0cVar.onPlayerInfo(this.a.a, 4, cVar.b);
                        }
                    } else if (i == 5102) {
                        TLog.l(this, String.format(Locale.getDefault(), "player first frame show(%d)", Integer.valueOf(((Long) cVar.f).intValue())));
                        s0c s0cVar = (s0c) this.a.n.get();
                        if (s0cVar != null) {
                            s0cVar.onPlayerFirstVideoFrameShow(this.a.a, (int) cVar.b, (int) cVar.c, ((Long) cVar.f).intValue());
                        } else {
                            TLog.c(this, String.format(Locale.getDefault(), "player first frame show : listener is null ", new Object[0]));
                        }
                        r0c r0cVar = (r0c) this.a.u.get();
                        if (r0cVar != null) {
                            r0cVar.a(103, cVar.e, 0L, 0L, null, null);
                        }
                    } else if (i == 7000) {
                        r0c r0cVar2 = (r0c) this.a.u.get();
                        TLog.g(this, "on demuxer read header end");
                        if (r0cVar2 != null) {
                            r0cVar2.a(102, cVar.b, 0L, 0L, null, null);
                        }
                    } else if (i == 5009) {
                        a1c a1cVar = (a1c) this.a.i.get();
                        if (a1cVar != null) {
                            a1cVar.onPlayerStatistics(this.a.a, (int) cVar.b, cVar.d);
                        }
                    } else if (i != 5010) {
                        switch (i) {
                            case 4:
                                TLog.g(this, String.format(Locale.getDefault(), "player state ready(%d)", Integer.valueOf(this.a.c)));
                                this.a.C.set(4);
                                z0c z0cVar2 = (z0c) this.a.j.get();
                                if (z0cVar2 != null) {
                                    z0cVar2.onPlayerStateUpdate(this.a.a, 4, 0);
                                    break;
                                }
                                break;
                            case 5:
                                TLog.g(this, String.format(Locale.getDefault(), "player state loading(%d)", Integer.valueOf(this.a.c)));
                                this.a.C.set(5);
                                z0c z0cVar3 = (z0c) this.a.j.get();
                                if (z0cVar3 != null) {
                                    z0cVar3.onPlayerStateUpdate(this.a.a, 5, (int) cVar.c);
                                    break;
                                }
                                break;
                            case 6:
                                TLog.g(this, String.format(Locale.getDefault(), "player state playing(%d)", Integer.valueOf(this.a.c)));
                                this.a.C.set(6);
                                z0c z0cVar4 = (z0c) this.a.j.get();
                                if (z0cVar4 != null) {
                                    z0cVar4.onPlayerStateUpdate(this.a.a, 6, 0);
                                    break;
                                }
                                break;
                            case 7:
                                TLog.g(this, String.format(Locale.getDefault(), "player state paused(%d)", Integer.valueOf(this.a.c)));
                                this.a.C.set(7);
                                z0c z0cVar5 = (z0c) this.a.j.get();
                                if (z0cVar5 != null) {
                                    z0cVar5.onPlayerStateUpdate(this.a.a, 7, 0);
                                    break;
                                }
                                break;
                            case 8:
                                TLog.g(this, String.format(Locale.getDefault(), "player play end(%d)", Integer.valueOf(this.a.c)));
                                w0c w0cVar = (w0c) this.a.k.get();
                                if (w0cVar != null) {
                                    w0cVar.onPlayerPlayCompletion(this.a.a);
                                }
                                this.a.C.set(8);
                                z0c z0cVar6 = (z0c) this.a.j.get();
                                if (z0cVar6 != null) {
                                    z0cVar6.onPlayerStateUpdate(this.a.a, 8, 0);
                                    break;
                                }
                                break;
                            case 9:
                                TLog.g(this, String.format(Locale.getDefault(), "player state invalid(%d)", Integer.valueOf(this.a.c)));
                                z0c z0cVar7 = (z0c) this.a.j.get();
                                if (z0cVar7 != null) {
                                    z0cVar7.onPlayerStateUpdate(this.a.a, 9, 0);
                                    break;
                                }
                                break;
                            default:
                                switch (i) {
                                    case 5001:
                                        TLog.a(this, String.format(Locale.getDefault(), "player loading (%d)", Long.valueOf(cVar.b)));
                                        u0c u0cVar = (u0c) this.a.l.get();
                                        if (u0cVar != null) {
                                            u0cVar.a(this.a.a, (int) cVar.b);
                                            break;
                                        }
                                        break;
                                    case 5002:
                                        TLog.g(this, String.format(Locale.getDefault(), "player resource duration:%d  (%d)", Long.valueOf(cVar.b), Integer.valueOf(this.a.c)));
                                        t0c t0cVar2 = (t0c) this.a.g.get();
                                        if (t0cVar2 != null) {
                                            t0cVar2.onPlayerInfo(this.a.a, 3, cVar.b);
                                            break;
                                        }
                                        break;
                                    case 5003:
                                        x0c x0cVar = (x0c) this.a.m.get();
                                        if (x0cVar != null) {
                                            x0cVar.a(this.a.a, cVar.b);
                                            break;
                                        }
                                        break;
                                    case 5004:
                                        TLog.g(this, String.format(Locale.getDefault(), "player cache (%d)", Long.valueOf(cVar.b)));
                                        o0c o0cVar = (o0c) this.a.o.get();
                                        if (o0cVar != null) {
                                            o0cVar.onPlayerCachePositionUpdate(this.a.a, cVar.b);
                                            break;
                                        }
                                        break;
                                    case 5005:
                                        TLog.g(this, String.format(Locale.getDefault(), "player resource total size: (%d)", Long.valueOf(cVar.b), Integer.valueOf(this.a.c)));
                                        t0c t0cVar3 = (t0c) this.a.g.get();
                                        if (t0cVar3 != null) {
                                            t0cVar3.onPlayerInfo(this.a.a, 2, cVar.b);
                                            break;
                                        }
                                        break;
                                    default:
                                        switch (i) {
                                            case 5013:
                                                TLog.g(this, String.format(Locale.getDefault(), "player download speed(%d)", Long.valueOf(cVar.b)));
                                                t0c t0cVar4 = (t0c) this.a.g.get();
                                                if (t0cVar4 != null) {
                                                    t0cVar4.onPlayerInfo(this.a.a, 0, cVar.b);
                                                    break;
                                                }
                                                break;
                                            case 5014:
                                                TLog.g(this, String.format(Locale.getDefault(), "player caton times: %d  (%d)", Long.valueOf(cVar.b), Integer.valueOf(this.a.c)));
                                                t0c t0cVar5 = (t0c) this.a.g.get();
                                                if (t0cVar5 != null) {
                                                    t0cVar5.onPlayerInfo(this.a.a, 1, cVar.b);
                                                    break;
                                                }
                                                break;
                                            case SpeedStatsStampTable.HOME_VIEW_ON_LAYOUT_END_STAMP_KEY /* 5015 */:
                                                TLog.g(this, String.format(Locale.getDefault(), "player resolution  w: %d  h: %d (%d)", Long.valueOf(cVar.b), Long.valueOf(cVar.c), Integer.valueOf(this.a.c)));
                                                t0c t0cVar6 = (t0c) this.a.g.get();
                                                if (t0cVar6 != null) {
                                                    t0cVar6.onPlayerVideoSizeUpdate(this.a.a, (int) cVar.b, (int) cVar.c);
                                                    break;
                                                }
                                                break;
                                            default:
                                                switch (i) {
                                                    case SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_END_STAMP_KEY /* 5017 */:
                                                        TLog.g(this, String.format(Locale.getDefault(), "player one loop end(%d)", Integer.valueOf(this.a.c)));
                                                        w0c w0cVar2 = (w0c) this.a.k.get();
                                                        if (w0cVar2 != null) {
                                                            w0cVar2.onPlayerPlayCompletionOneLoop(this.a.a);
                                                            break;
                                                        }
                                                        break;
                                                    case 5018:
                                                        o0c o0cVar2 = (o0c) this.a.o.get();
                                                        if (o0cVar2 != null) {
                                                            o0cVar2.onPlayerCacheWriteToDiskCompleted(this.a.a, cVar.d);
                                                            break;
                                                        }
                                                        break;
                                                    case 5019:
                                                        v0c v0cVar = (v0c) this.a.r.get();
                                                        if (v0cVar != null) {
                                                            NetRequestStatusInfo netRequestStatusInfo = (NetRequestStatusInfo) cVar.f;
                                                            v0cVar.a(this.a.a, (int) cVar.b, netRequestStatusInfo);
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
                                                                q0c q0cVar = (q0c) this.a.h.get();
                                                                if (q0cVar != null) {
                                                                    j2c j2cVar = this.a;
                                                                    q0cVar.onPlayerError(j2cVar.a, j2cVar.d, SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_START_STAMP_KEY, 0);
                                                                    break;
                                                                }
                                                                break;
                                                            case SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_END_STAMP_KEY /* 5201 */:
                                                                d1c d1cVar = (d1c) this.a.t.get();
                                                                if (d1cVar != null) {
                                                                    d1cVar.a(true);
                                                                    break;
                                                                }
                                                                break;
                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_START_STAMP_KEY /* 5202 */:
                                                                d1c d1cVar2 = (d1c) this.a.t.get();
                                                                if (d1cVar2 != null) {
                                                                    d1cVar2.a(false);
                                                                    break;
                                                                }
                                                                break;
                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_END_STAMP_KEY /* 5203 */:
                                                                r0c r0cVar3 = (r0c) this.a.u.get();
                                                                TLog.g(this, "onSurfaceStatus create");
                                                                if (r0cVar3 != null) {
                                                                    r0cVar3.a(100, cVar.b, 0L, 0L, null, null);
                                                                    break;
                                                                }
                                                                break;
                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONRESUME_STAMP_KEY /* 5204 */:
                                                                r0c r0cVar4 = (r0c) this.a.u.get();
                                                                TLog.g(this, "onSurfaceStatus changed");
                                                                if (r0cVar4 != null) {
                                                                    r0cVar4.a(101, cVar.b, cVar.c, cVar.e, null, null);
                                                                    break;
                                                                }
                                                                break;
                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DATABACK_STAMP_KEY /* 5205 */:
                                                                TLog.l(this, String.format(Locale.getDefault(), "player first frame again show(%d)", Integer.valueOf(((Long) cVar.f).intValue())));
                                                                r0c r0cVar5 = (r0c) this.a.u.get();
                                                                if (r0cVar5 != null) {
                                                                    TLog.g(this, String.format(Locale.getDefault(), "OnPlayerExtraInfoListener:(%d)", 104));
                                                                    r0cVar5.a(104, cVar.b, cVar.c, cVar.e, null, null);
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                switch (i) {
                                                                    case 6000:
                                                                        y0c y0cVar = (y0c) this.a.s.get();
                                                                        if (y0cVar != null) {
                                                                            y0cVar.onPlayerReceiveToRenderDelay(this.a.a, (int) cVar.b);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 6001:
                                                                        Log.i("hello", "rendering frameRate " + ((int) cVar.b));
                                                                        y0c y0cVar2 = (y0c) this.a.s.get();
                                                                        if (y0cVar2 != null) {
                                                                            y0cVar2.onPlayerRenderFramerate(this.a.a, (int) cVar.b);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 6002:
                                                                        y0c y0cVar3 = (y0c) this.a.s.get();
                                                                        if (y0cVar3 != null) {
                                                                            y0cVar3.onPlayerDecodeType(this.a.a, (int) cVar.b);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case AuthCode.StatusCode.CERT_FINGERPRINT_ERROR /* 6003 */:
                                                                        y0c y0cVar4 = (y0c) this.a.s.get();
                                                                        if (y0cVar4 != null) {
                                                                            TLog.g(this, String.format(Locale.getDefault(), "decoder output size %d * %d", Integer.valueOf((int) cVar.b), Integer.valueOf((int) cVar.c)));
                                                                            y0cVar4.onPlayerDecodeOuputSize(this.a.a, (int) cVar.b, (int) cVar.c);
                                                                            break;
                                                                        } else {
                                                                            TLog.g(this, "OnPlayerQualityMonitorListener is null");
                                                                            break;
                                                                        }
                                                                    case AuthCode.StatusCode.PERMISSION_NOT_EXIST /* 6004 */:
                                                                        y0c y0cVar5 = (y0c) this.a.s.get();
                                                                        if (y0cVar5 != null) {
                                                                            y0cVar5.onPlayerDecodeBitrate(this.a.a, (int) cVar.b, (int) cVar.c);
                                                                            Log.i("hello", "videoBitrate " + ((int) cVar.b) + " audioBitrate " + ((int) cVar.c));
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED /* 6005 */:
                                                                        y0c y0cVar6 = (y0c) this.a.s.get();
                                                                        if (y0cVar6 != null) {
                                                                            y0cVar6.onPlayerVideoStalls(this.a.a, ((int) cVar.b) == 1, (int) cVar.c);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case AuthCode.StatusCode.PERMISSION_EXPIRED /* 6006 */:
                                                                        y0c y0cVar7 = (y0c) this.a.s.get();
                                                                        if (y0cVar7 != null) {
                                                                            y0cVar7.onPlayerAudioStalls(this.a.a, ((int) cVar.b) == 1, (int) cVar.c);
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
                        q0c q0cVar2 = (q0c) this.a.h.get();
                        if (q0cVar2 != null) {
                            q0cVar2.onPlayerError(this.a.a, (String) cVar.f, (int) cVar.b, (int) cVar.c);
                        }
                    }
                    j2c j2cVar2 = this.a;
                    j2cVar2.b = j2cVar2.C.get() == 6;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j2c j2cVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j2cVar, looper};
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
            this.a = j2cVar;
        }
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public long c;
        public String d;
        public long e;
        public Object f;
        public final /* synthetic */ j2c g;

        public c(j2c j2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j2cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = j2cVar;
            this.a = 0;
            this.b = 0L;
            this.c = 0L;
            this.d = null;
            this.e = 0L;
            this.f = null;
        }
    }

    public j2c(Context context, f1c f1cVar, g1c g1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, f1cVar, g1cVar};
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
        this.a = g1cVar;
        this.E = f1cVar;
        m0(context.getApplicationContext(), f1cVar);
        TLog.l(this, "[transvod] create VodPlayer cost: " + (System.currentTimeMillis() - currentTimeMillis) + " sdkversion: " + j() + " isSubProcess:" + f1cVar.m);
    }

    @Override // com.baidu.tieba.i2c
    public void A(t0c t0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t0cVar) == null) {
            this.g = new WeakReference<>(t0cVar);
        }
    }

    public void A0(u0c u0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u0cVar) == null) {
            this.l = new WeakReference<>(u0cVar);
        }
    }

    @Override // com.baidu.tieba.i2c
    public void B(y0c y0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y0cVar) == null) {
            this.s = new WeakReference<>(y0cVar);
        }
    }

    public void B0(v0c v0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, v0cVar) == null) {
            this.r = new WeakReference<>(v0cVar);
        }
    }

    @Override // com.baidu.tieba.i2c
    public void C(z0c z0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, z0cVar) == null) {
            this.j = new WeakReference<>(z0cVar);
        }
    }

    public void C0(w0c w0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, w0cVar) == null) {
            this.k = new WeakReference<>(w0cVar);
        }
    }

    @Override // com.baidu.tieba.i2c
    public void D(a1c a1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, a1cVar) == null) {
            this.i = new WeakReference<>(a1cVar);
        }
    }

    public void D0(x0c x0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, x0cVar) == null) {
            this.m = new WeakReference<>(x0cVar);
        }
    }

    public void E0(c1c c1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, c1cVar) == null) {
            this.v = new WeakReference<>(c1cVar);
        }
    }

    public void F0(d1c d1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, d1cVar) == null) {
            this.t = new WeakReference<>(d1cVar);
        }
    }

    public void H0(g1c.c cVar) {
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

    @Override // com.baidu.tieba.i2c
    public void s(l0c l0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, l0cVar) == null) {
            synchronized (this) {
                if (this.f != null) {
                    this.d = l0cVar.k();
                    this.G = l0cVar.d();
                    this.f.U0(l0cVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.i2c
    public void t(l0c l0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, l0cVar) == null) {
            synchronized (this) {
                if (this.f != null) {
                    this.d = l0cVar.k();
                    this.G = l0cVar.d();
                    this.f.V0(l0cVar);
                }
            }
        }
    }

    public void v0(boolean z) {
        y1c y1cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048622, this, z) == null) && (y1cVar = this.f) != null) {
            y1cVar.Y0(z);
        }
    }

    public void w0(boolean z) {
        y1c y1cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && (y1cVar = this.f) != null) {
            y1cVar.Z0(z);
        }
    }

    @Override // com.baidu.tieba.i2c
    public void x(o0c o0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, o0cVar) == null) {
            this.o = new WeakReference<>(o0cVar);
        }
    }

    @Override // com.baidu.tieba.i2c
    public void y(q0c q0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, q0cVar) == null) {
            this.h = new WeakReference<>(q0cVar);
        }
    }

    public void y0(m0c m0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, m0cVar) == null) {
            v1c.m(m0cVar);
        }
    }

    @Override // com.baidu.tieba.i2c
    public void z(s0c s0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, s0cVar) == null) {
            this.n = new WeakReference<>(s0cVar);
        }
    }

    public void z0(r0c r0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, r0cVar) == null) {
            this.u = new WeakReference<>(r0cVar);
        }
    }

    @Override // com.baidu.tieba.i2c
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

    @Override // com.baidu.tieba.i2c
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

    public void u0(u1c u1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, u1cVar) == null) {
            TLog.g(this, this.c + " setEffectResources " + u1c.d(u1cVar));
            synchronized (this) {
                if (this.f == null) {
                    return;
                }
                this.f.X0(u1cVar);
            }
        }
    }

    @Override // com.baidu.tieba.i2c
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

    @Override // com.baidu.tieba.i2c
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

    public final void m0(Context context, f1c f1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, f1cVar) == null) {
            TLog.k(4);
            h2c.a(context);
            e0c.c(context);
            j3c j3cVar = f1cVar.j;
            if (j3cVar != null) {
                this.D = j3cVar;
            } else {
                i3c i3cVar = f1cVar.k;
                if (i3cVar != null) {
                    this.D = i3cVar;
                } else if (f1cVar.g) {
                    this.D = new SurfaceView(context);
                } else {
                    this.D = new TextureView(context);
                }
            }
            y1c y1cVar = new y1c(f1cVar);
            this.f = y1cVar;
            y1cVar.c1(this.H);
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

    @Override // com.baidu.tieba.i2c
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

    public int K0(int i, l0c l0cVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i, l0cVar)) == null) {
            synchronized (this) {
                if (this.f != null) {
                    this.f.k1(i, l0cVar);
                    return 0;
                }
                return -1;
            }
        }
        return invokeIL.intValue;
    }

    @Override // com.baidu.tieba.i2c
    public void q(Executor executor, g1c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, executor, dVar) == null) {
            synchronized (this) {
                if (this.f != null) {
                    this.f.S0(executor, dVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.i2c
    public void w(Executor executor, n0c n0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048623, this, executor, n0cVar) == null) {
            this.p = new WeakReference<>(n0cVar);
            this.F = executor;
        }
    }

    @Override // com.baidu.tieba.i2c
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

    @Override // com.baidu.tieba.i2c
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

    @Override // com.baidu.tieba.i2c
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

    @Override // com.baidu.tieba.i2c
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

    @Override // com.baidu.tieba.i2c
    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.B.get();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.i2c
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.w.get();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.i2c
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            TLog.g(this, this.c + "VodPlay.getPlayerView enter.");
            return this.D;
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.tieba.i2c
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.A.get();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.i2c
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
            y1c y1cVar = this.f;
            if (y1cVar != null) {
                return y1cVar.l0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i2c
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

    @Override // com.baidu.tieba.i2c
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

    public void n0(k1c k1cVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, k1cVar) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.c);
            sb.append(" enableJoyPkPipMode:");
            if (k1cVar != null) {
                str = "(" + k1cVar.b + "," + k1cVar.c + "), (" + k1cVar.d + StringUtil.ARRAY_ELEMENT_SEPARATOR + k1cVar.e + "), force: " + k1cVar.a;
            } else {
                str = StringUtil.NULL_STRING;
            }
            sb.append(str);
            TLog.g(this, sb.toString());
            synchronized (this) {
                if (this.f != null) {
                    this.f.k0(k1cVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.i2c
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

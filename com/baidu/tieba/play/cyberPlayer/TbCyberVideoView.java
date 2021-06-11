package com.baidu.tieba.play.cyberPlayer;

import android.content.Context;
import android.net.Uri;
import android.os.PowerManager;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.MediaController;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVideoView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import d.a.m0.r.q.a2;
import d.a.m0.z0.m0;
import d.a.n0.k2.n;
import d.a.n0.k2.o;
import d.a.n0.u1.h;
import d.a.n0.u1.k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TbCyberVideoView extends CyberVideoView implements MediaController.MediaPlayerControl {
    public static k q0;
    public boolean J;
    public String K;
    public String L;
    public boolean M;
    public d.a.n0.k2.p.b N;
    public h O;
    public String P;
    public String Q;
    public PowerManager.WakeLock R;
    public WeakReference<Context> S;
    public boolean T;
    public boolean U;
    public int V;
    public boolean W;
    public boolean a0;
    public int b0;
    public d.a.n0.k2.f c0;
    public boolean d0;
    public CyberPlayerManager.OnPreparedListener e0;
    public CyberPlayerManager.OnCompletionListener f0;
    public CyberPlayerManager.OnSeekCompleteListener g0;
    public CyberPlayerManager.OnErrorListener h0;
    public CyberPlayerManager.OnInfoListener i0;
    public g j0;
    public CyberPlayerManager.OnPreparedListener k0;
    public CyberPlayerManager.OnCompletionListener l0;
    public CyberPlayerManager.OnErrorListener m0;
    public CyberPlayerManager.OnSeekCompleteListener n0;
    public CyberPlayerManager.OnInfoListener o0;
    public final CustomMessageListener p0;

    /* loaded from: classes5.dex */
    public class a implements CyberPlayerManager.OnPreparedListener {
        public a() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            int c2;
            if (TbCyberVideoView.this.N != null) {
                TbCyberVideoView.this.N.d(TbCyberVideoView.this.getDuration());
            }
            if (TbCyberVideoView.this.getVideoMonitor() != null) {
                TbCyberVideoView.this.getVideoMonitor().l(ErrorCode.ARGS_ERROR);
            }
            if (!TbCyberVideoView.this.d0) {
                if (!ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    return;
                }
                TbVideoViewSet d2 = TbVideoViewSet.d();
                TbCyberVideoView tbCyberVideoView = TbCyberVideoView.this;
                d2.g(tbCyberVideoView, tbCyberVideoView.L);
            }
            if (TbCyberVideoView.this.e0 != null) {
                TbCyberVideoView.this.e0.onPrepared();
            }
            if (TbCyberVideoView.this.J && (c2 = n.d().c(TbCyberVideoView.this.L)) > 0) {
                TbCyberVideoView.this.seekTo(c2);
            }
            if (TbCyberVideoView.this.M) {
                TbCyberVideoView.this.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CyberPlayerManager.OnCompletionListener {
        public b() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (TbCyberVideoView.this.O != null) {
                TbCyberVideoView.this.O.e(TbCyberVideoView.this.P, TbCyberVideoView.this.Q);
                TbCyberVideoView.this.O = null;
            }
            n.d().e(TbCyberVideoView.this.L);
            if (TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                return;
            }
            if (TbCyberVideoView.this.N != null) {
                TbCyberVideoView.this.N.a();
            }
            TbCyberVideoView.this.M = false;
            if (TbCyberVideoView.this.f0 != null) {
                TbCyberVideoView.this.f0.onCompletion();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public c() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.L()) {
                n.d().f(TbCyberVideoView.this.L, TbCyberVideoView.this.getCurrentPosition());
            }
            TbVideoViewSet.d().f(TbCyberVideoView.this.L);
            if (TbCyberVideoView.this.h0 != null) {
                TbCyberVideoView.this.h0.onError(i2, i3, obj);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements CyberPlayerManager.OnSeekCompleteListener {
        public d() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (TbCyberVideoView.this.g0 != null) {
                TbCyberVideoView.this.g0.onSeekComplete();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements CyberPlayerManager.OnInfoListener {
        public e() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (TbCyberVideoView.this.i0 != null) {
                TbCyberVideoView.this.i0.onInfo(i2, i3, obj);
            }
            if (TbCyberVideoView.this.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                try {
                    JSONObject jSONObject = new JSONObject((String) obj);
                    TbCyberVideoView.this.getVideoMonitor().g(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                } catch (JSONException unused) {
                }
            }
            if (i2 != 904 || TbCyberVideoView.this.N == null) {
                return true;
            }
            TbCyberVideoView.this.N.c(TbCyberVideoView.this);
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                TbCyberVideoView.this.S();
                if (TbCyberVideoView.this.O != null) {
                    TbCyberVideoView.this.O.k(TbCyberVideoView.this.P, TbCyberVideoView.this.Q);
                    TbCyberVideoView.this.O = null;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        if (runTask != null) {
            q0 = (k) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.S = null;
        this.T = false;
        this.U = false;
        this.d0 = false;
        this.k0 = new a();
        this.l0 = new b();
        this.m0 = new c();
        this.n0 = new d();
        this.o0 = new e();
        this.p0 = new f(2001011);
        I(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h getVideoMonitor() {
        k kVar;
        h hVar = this.O;
        if (hVar != null) {
            return hVar;
        }
        if (!StringUtils.isNull(this.L) && (kVar = q0) != null) {
            this.O = kVar.a(this.K, this.L, null);
        }
        return this.O;
    }

    public final String A(String str) {
        if (!d.a.c.e.p.k.isEmpty(str) && d.a.n0.r3.f.d().e()) {
            if (str.contains("http://tb-video.bdstatic.com")) {
                return str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
            }
            return str.contains(UrlSchemaHelper.SCHEMA_TYPE_HTTP) ? str.replace(UrlSchemaHelper.SCHEMA_TYPE_HTTP, UrlSchemaHelper.SCHEMA_TYPE_HTTPS) : str;
        }
        return str;
    }

    public final boolean B() {
        return this == TbVideoViewSet.d().e(this.L);
    }

    public final boolean F() {
        return getParent() != null;
    }

    public void G() {
        H();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    public final void H() {
        this.j0 = null;
        this.f0 = null;
        this.h0 = null;
        this.i0 = null;
        this.e0 = null;
        this.g0 = null;
        this.c0.j(null);
        this.c0.i(null);
        this.c0.k(null);
    }

    public final void I(Context context) {
        try {
            PowerManager powerManager = (PowerManager) TbadkCoreApplication.getInst().getContext().getSystemService("power");
            if (powerManager != null) {
                PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                this.R = newWakeLock;
                newWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.S = new WeakReference<>(TbadkCoreApplication.getInst());
        super.setOnPreparedListener(this.k0);
        super.setOnCompletionListener(this.l0);
        super.setOnErrorListener(this.m0);
        super.setOnSeekCompleteListener(this.n0);
        super.setOnInfoListener(this.o0);
        this.N = new d.a.n0.k2.p.b();
        this.c0 = new d.a.n0.k2.f();
        SkinManager.setBackgroundResource(this, R.color.black_alpha100);
    }

    public final void J(Uri uri) {
        d.a.n0.k2.p.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.c()) {
            if (!pcdnConfigData.a(uri)) {
                this.b0 = 2;
                return;
            } else if (d.a.n0.k2.p.c.e() <= 0) {
                this.b0 = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.b() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(d.a.n0.k2.p.c.e()));
                this.W = true;
                this.a0 = pcdnConfigData.b();
                this.b0 = 1;
                return;
            }
        }
        this.b0 = 0;
    }

    public boolean K() {
        return this.M;
    }

    public final boolean L() {
        return getCyberPlayer() != null && getCyberPlayer().getDuration() >= getCyberPlayer().getCurrentPosition();
    }

    @Deprecated
    public void M() {
        d.a.n0.k2.p.b bVar = this.N;
        if (bVar != null) {
            bVar.e();
            this.N.d(getDuration());
            this.N.c(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().a(CyberPlayerManager.hasCacheFile(this.L));
            getVideoMonitor().i(ErrorCode.ARGS_ERROR);
        }
    }

    @Deprecated
    public void N() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().a(CyberPlayerManager.hasCacheFile(this.L));
            getVideoMonitor().j();
            getVideoMonitor().l(ErrorCode.ARGS_ERROR);
        }
    }

    public void O(long j, long j2, long j3) {
        h hVar = this.O;
        if (hVar != null) {
            hVar.c(j, j2, j3);
        }
    }

    public void P(TbVideoViewSet.b bVar) {
        if (!isPlaying() && !this.M) {
            this.M = true;
            if (bVar != null) {
                this.U = true;
                if (!F()) {
                    bVar.b();
                }
            } else {
                this.U = false;
            }
            setVideoPath(this.L, this.K);
            return;
        }
        R(bVar);
    }

    public final void Q() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20513");
        hashMap.put("click_time", "" + System.currentTimeMillis());
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void R(TbVideoViewSet.b bVar) {
        if (bVar != null) {
            this.U = true;
            if (!F()) {
                bVar.b();
            }
            if (!B()) {
                bVar.a();
                this.M = true;
                setVideoPath(this.L, this.K);
                return;
            }
        } else {
            this.U = false;
        }
        start();
    }

    public void S() {
        if (!this.U) {
            stopPlayback();
            return;
        }
        if (this.L != null && isPlaying()) {
            m0.e(this.S, false);
        }
        this.M = false;
        if (isPlaying() && L()) {
            n.d().f(this.L, getCurrentPositionSync());
        }
        try {
            if (this.R != null && this.R.isHeld()) {
                this.R.release();
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        super.pause();
        d.a.n0.k2.p.b bVar = this.N;
        if (bVar != null) {
            bVar.g();
        }
        this.c0.n();
        h hVar = this.O;
        if (hVar == null || !hVar.d(this.P, this.Q)) {
            return;
        }
        this.O = null;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public int getCurrentPositionSync() {
        if (getCyberPlayer() == null) {
            return 0;
        }
        return getCyberPlayer().getCurrentPositionSync();
    }

    public d.a.n0.k2.f getMediaProgressObserver() {
        return this.c0;
    }

    public String getOriginUrl() {
        return this.L;
    }

    public int getPcdnState() {
        return this.b0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.p0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.j0;
        if (gVar != null) {
            gVar.onSurfaceDestroyed();
        }
        try {
            if (this.R != null && this.R.isHeld()) {
                this.R.release();
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        MessageManager.getInstance().unRegisterListener(this.p0);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        m0.e(this.S, false);
        if (isPlaying() && L()) {
            n.d().f(this.L, getCurrentPositionSync());
        }
        super.pause();
        d.a.n0.k2.p.b bVar = this.N;
        if (bVar != null) {
            bVar.b();
        }
        try {
            if (this.R != null && this.R.isHeld()) {
                this.R.release();
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        h hVar = this.O;
        if (hVar != null) {
            hVar.f();
        }
    }

    public void setContinuePlayEnable(boolean z) {
        this.J = z;
    }

    public void setIsUseInflutter(boolean z) {
        this.d0 = z;
    }

    public void setIsVolume0(boolean z) {
        this.T = z;
    }

    public void setLocateSource(String str) {
        this.P = str;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.T = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        m0.e(this.S, !z);
    }

    public void setNoBussinessStats() {
        this.N = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.f0 = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.h0 = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.i0 = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.e0 = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.g0 = onSeekCompleteListener;
    }

    public void setOnSurfaceDestroyedListener(g gVar) {
        this.j0 = gVar;
    }

    public void setPlayMode(String str) {
        d.a.n0.k2.p.b bVar = this.N;
        if (bVar != null) {
            bVar.i(str);
        }
    }

    public void setStageType(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            str = "-1";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20484");
        hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, str);
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
        this.Q = str;
    }

    public void setThreadDataForStatistic(a2 a2Var) {
        if (this.N == null) {
            this.N = new d.a.n0.k2.p.b();
        }
        this.N.j(a2Var);
    }

    public void setTryUseViewInSet(boolean z) {
        this.U = z;
    }

    public void setVideoDuration(int i2) {
        this.V = i2;
    }

    public void setVideoPath(String str, String str2) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        this.K = str2;
        setVideoPath(str);
    }

    public void setVideoStatData(o oVar) {
        if (this.N == null) {
            this.N = new d.a.n0.k2.p.b();
        }
        this.N.k(oVar);
        if (oVar != null) {
            this.P = oVar.f60587a;
        }
    }

    public void setVolume(float f2, float f3) {
        if (getCyberPlayer() != null) {
            this.T = f2 == 0.0f && f3 == 0.0f;
            getCyberPlayer().setVolume(f2, f3);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.T) {
            m0.e(this.S, true);
            setVolume(1.0f, 1.0f);
        }
        this.M = true;
        super.start();
        d.a.n0.k2.p.b bVar = this.N;
        if (bVar != null) {
            bVar.f();
        }
        this.c0.m();
        try {
            if (this.R != null && !this.R.isHeld()) {
                this.R.acquire();
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().h(ErrorCode.ARGS_ERROR);
            getVideoMonitor().b(this.W, this.a0);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.L != null && isPlaying()) {
            m0.e(this.S, false);
        }
        this.M = false;
        if (isPlaying() && L()) {
            n.d().f(this.L, getCurrentPositionSync());
        }
        try {
            if (this.R != null && this.R.isHeld()) {
                this.R.release();
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        super.stopPlayback();
        TbVideoViewSet.d().f(this.L);
        d.a.n0.k2.p.b bVar = this.N;
        if (bVar != null) {
            bVar.g();
        }
        this.c0.n();
        h hVar = this.O;
        if (hVar == null || !hVar.d(this.P, this.Q)) {
            return;
        }
        this.O = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        Q();
        this.L = str;
        String A = A(str);
        k kVar = q0;
        if (kVar != null) {
            h a2 = kVar.a(this.K, this.L, null);
            this.O = a2;
            if (a2 != null) {
                a2.a(CyberPlayerManager.hasCacheFile(A));
            }
        }
        this.c0.l(this);
        d.a.n0.k2.p.b bVar = this.N;
        if (bVar != null) {
            bVar.e();
        }
        J(Uri.parse(A));
        h hVar = this.O;
        if (hVar != null) {
            hVar.j();
        }
        String host = Uri.parse(this.L).getHost();
        setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.V < 900)) ? "1" : "0");
        super.setVideoPath(A);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.S = null;
        this.T = false;
        this.U = false;
        this.d0 = false;
        this.k0 = new a();
        this.l0 = new b();
        this.m0 = new c();
        this.n0 = new d();
        this.o0 = new e();
        this.p0 = new f(2001011);
        I(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.S = null;
        this.T = false;
        this.U = false;
        this.d0 = false;
        this.k0 = new a();
        this.l0 = new b();
        this.m0 = new c();
        this.n0 = new d();
        this.o0 = new e();
        this.p0 = new f(2001011);
        I(context);
    }
}

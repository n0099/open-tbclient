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
import d.b.h0.r.q.a2;
import d.b.h0.z0.m0;
import d.b.i0.i2.n;
import d.b.i0.i2.o;
import d.b.i0.s1.h;
import d.b.i0.s1.k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TbCyberVideoView extends CyberVideoView implements MediaController.MediaPlayerControl {
    public static k o0;
    public boolean H;
    public String I;
    public String J;
    public boolean K;
    public d.b.i0.i2.p.b L;
    public h M;
    public String N;
    public String O;
    public PowerManager.WakeLock P;
    public WeakReference<Context> Q;
    public boolean R;
    public boolean S;
    public int T;
    public boolean U;
    public boolean V;
    public int W;
    public d.b.i0.i2.f a0;
    public boolean b0;
    public CyberPlayerManager.OnPreparedListener c0;
    public CyberPlayerManager.OnCompletionListener d0;
    public CyberPlayerManager.OnSeekCompleteListener e0;
    public CyberPlayerManager.OnErrorListener f0;
    public CyberPlayerManager.OnInfoListener g0;
    public g h0;
    public CyberPlayerManager.OnPreparedListener i0;
    public CyberPlayerManager.OnCompletionListener j0;
    public CyberPlayerManager.OnErrorListener k0;
    public CyberPlayerManager.OnSeekCompleteListener l0;
    public CyberPlayerManager.OnInfoListener m0;
    public final CustomMessageListener n0;

    /* loaded from: classes5.dex */
    public class a implements CyberPlayerManager.OnPreparedListener {
        public a() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            int c2;
            if (TbCyberVideoView.this.L != null) {
                TbCyberVideoView.this.L.d(TbCyberVideoView.this.getDuration());
            }
            if (TbCyberVideoView.this.getVideoMonitor() != null) {
                TbCyberVideoView.this.getVideoMonitor().l(-400);
            }
            if (!TbCyberVideoView.this.b0) {
                if (!ViewCompat.isAttachedToWindow(TbCyberVideoView.this.getView())) {
                    return;
                }
                TbVideoViewSet d2 = TbVideoViewSet.d();
                TbCyberVideoView tbCyberVideoView = TbCyberVideoView.this;
                d2.g(tbCyberVideoView, tbCyberVideoView.J);
            }
            if (TbCyberVideoView.this.c0 != null) {
                TbCyberVideoView.this.c0.onPrepared();
            }
            if (TbCyberVideoView.this.H && (c2 = n.d().c(TbCyberVideoView.this.J)) > 0) {
                TbCyberVideoView.this.seekTo(c2);
            }
            if (TbCyberVideoView.this.K) {
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
            if (TbCyberVideoView.this.M != null) {
                TbCyberVideoView.this.M.h(TbCyberVideoView.this.N, TbCyberVideoView.this.O);
                TbCyberVideoView.this.M = null;
            }
            n.d().e(TbCyberVideoView.this.J);
            if (TbCyberVideoView.this.getCyberPlayer().isLooping()) {
                return;
            }
            if (TbCyberVideoView.this.L != null) {
                TbCyberVideoView.this.L.a();
            }
            TbCyberVideoView.this.K = false;
            if (TbCyberVideoView.this.d0 != null) {
                TbCyberVideoView.this.d0.onCompletion();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public c() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            if (TbCyberVideoView.this.getCurrentPosition() > 0 && TbCyberVideoView.this.M()) {
                n.d().f(TbCyberVideoView.this.J, TbCyberVideoView.this.getCurrentPosition());
            }
            TbVideoViewSet.d().f(TbCyberVideoView.this.J);
            if (TbCyberVideoView.this.f0 != null) {
                TbCyberVideoView.this.f0.onError(i, i2, obj);
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
            if (TbCyberVideoView.this.e0 != null) {
                TbCyberVideoView.this.e0.onSeekComplete();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements CyberPlayerManager.OnInfoListener {
        public e() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (TbCyberVideoView.this.g0 != null) {
                TbCyberVideoView.this.g0.onInfo(i, i2, obj);
            }
            if (TbCyberVideoView.this.getVideoMonitor() != null && i == 10009 && (obj instanceof String)) {
                try {
                    JSONObject jSONObject = new JSONObject((String) obj);
                    TbCyberVideoView.this.getVideoMonitor().c(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                } catch (JSONException unused) {
                }
            }
            if (i != 904 || TbCyberVideoView.this.L == null) {
                return true;
            }
            TbCyberVideoView.this.L.c(TbCyberVideoView.this);
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                TbCyberVideoView.this.U();
                if (TbCyberVideoView.this.M != null) {
                    TbCyberVideoView.this.M.k(TbCyberVideoView.this.N, TbCyberVideoView.this.O);
                    TbCyberVideoView.this.M = null;
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
            o0 = (k) runTask.getData();
        }
    }

    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Q = null;
        this.R = false;
        this.S = false;
        this.b0 = false;
        this.i0 = new a();
        this.j0 = new b();
        this.k0 = new c();
        this.l0 = new d();
        this.m0 = new e();
        this.n0 = new f(2001011);
        J(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h getVideoMonitor() {
        k kVar;
        h hVar = this.M;
        if (hVar != null) {
            return hVar;
        }
        if (!StringUtils.isNull(this.J) && (kVar = o0) != null) {
            this.M = kVar.a(this.I, this.J, null);
        }
        return this.M;
    }

    public final String B(String str) {
        if (!d.b.b.e.p.k.isEmpty(str) && d.b.i0.p3.f.d().e()) {
            if (str.contains("http://tb-video.bdstatic.com")) {
                return str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
            }
            return str.contains(UrlSchemaHelper.SCHEMA_TYPE_HTTP) ? str.replace(UrlSchemaHelper.SCHEMA_TYPE_HTTP, UrlSchemaHelper.SCHEMA_TYPE_HTTPS) : str;
        }
        return str;
    }

    public final boolean E() {
        return this == TbVideoViewSet.d().e(this.J);
    }

    public final boolean F() {
        return getParent() != null;
    }

    public void G() {
        I();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    public final void I() {
        this.h0 = null;
        this.d0 = null;
        this.f0 = null;
        this.g0 = null;
        this.c0 = null;
        this.e0 = null;
        this.a0.j(null);
        this.a0.i(null);
        this.a0.k(null);
    }

    public final void J(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                this.P = newWakeLock;
                newWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.Q = new WeakReference<>(TbadkCoreApplication.getInst());
        super.setOnPreparedListener(this.i0);
        super.setOnCompletionListener(this.j0);
        super.setOnErrorListener(this.k0);
        super.setOnSeekCompleteListener(this.l0);
        super.setOnInfoListener(this.m0);
        this.L = new d.b.i0.i2.p.b();
        this.a0 = new d.b.i0.i2.f();
        SkinManager.setBackgroundResource(this, R.color.black_alpha100);
    }

    public final void K(Uri uri) {
        d.b.i0.i2.p.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
        if (pcdnConfigData != null && pcdnConfigData.c()) {
            if (!pcdnConfigData.a(uri)) {
                this.W = 2;
                return;
            } else if (d.b.i0.i2.p.c.e() <= 0) {
                this.W = 3;
                return;
            } else {
                setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.b() ? "1" : "0");
                setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(d.b.i0.i2.p.c.e()));
                this.U = true;
                this.V = pcdnConfigData.b();
                this.W = 1;
                return;
            }
        }
        this.W = 0;
    }

    public boolean L() {
        return this.K;
    }

    public final boolean M() {
        return getCyberPlayer() != null && getCyberPlayer().getDuration() >= getCyberPlayer().getCurrentPosition();
    }

    @Deprecated
    public void O() {
        d.b.i0.i2.p.b bVar = this.L;
        if (bVar != null) {
            bVar.e();
            this.L.d(getDuration());
            this.L.c(this);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().b(CyberPlayerManager.hasCacheFile(this.J));
            getVideoMonitor().i(-400);
        }
    }

    @Deprecated
    public void P() {
        if (getVideoMonitor() != null) {
            getVideoMonitor().b(CyberPlayerManager.hasCacheFile(this.J));
            getVideoMonitor().j();
            getVideoMonitor().l(-400);
        }
    }

    public void Q(long j, long j2, long j3) {
        h hVar = this.M;
        if (hVar != null) {
            hVar.f(j, j2, j3);
        }
    }

    public void R(TbVideoViewSet.b bVar) {
        if (!isPlaying() && !this.K) {
            this.K = true;
            if (bVar != null) {
                this.S = true;
                if (!F()) {
                    bVar.a();
                }
            } else {
                this.S = false;
            }
            setVideoPath(this.J, this.I);
            return;
        }
        T(bVar);
    }

    public final void S() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20513");
        hashMap.put("click_time", "" + System.currentTimeMillis());
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
    }

    public void T(TbVideoViewSet.b bVar) {
        if (bVar != null) {
            this.S = true;
            if (!F()) {
                bVar.a();
            }
            if (!E()) {
                bVar.b();
                this.K = true;
                setVideoPath(this.J, this.I);
                return;
            }
        } else {
            this.S = false;
        }
        start();
    }

    public void U() {
        if (!this.S) {
            stopPlayback();
            return;
        }
        if (this.J != null && isPlaying()) {
            m0.e(this.Q, false);
        }
        this.K = false;
        if (isPlaying() && M()) {
            n.d().f(this.J, getCurrentPositionSync());
        }
        try {
            if (this.P != null && this.P.isHeld()) {
                this.P.release();
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        super.pause();
        d.b.i0.i2.p.b bVar = this.L;
        if (bVar != null) {
            bVar.g();
        }
        this.a0.n();
        h hVar = this.M;
        if (hVar == null || !hVar.g(this.N, this.O)) {
            return;
        }
        this.M = null;
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

    public d.b.i0.i2.f getMediaProgressObserver() {
        return this.a0;
    }

    public String getOriginUrl() {
        return this.J;
    }

    public int getPcdnState() {
        return this.W;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.n0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.h0;
        if (gVar != null) {
            gVar.onSurfaceDestroyed();
        }
        try {
            if (this.P != null && this.P.isHeld()) {
                this.P.release();
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        MessageManager.getInstance().unRegisterListener(this.n0);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        m0.e(this.Q, false);
        if (isPlaying() && M()) {
            n.d().f(this.J, getCurrentPositionSync());
        }
        super.pause();
        d.b.i0.i2.p.b bVar = this.L;
        if (bVar != null) {
            bVar.b();
        }
        try {
            if (this.P != null && this.P.isHeld()) {
                this.P.release();
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        h hVar = this.M;
        if (hVar != null) {
            hVar.a();
        }
    }

    public void setContinuePlayEnable(boolean z) {
        this.H = z;
    }

    public void setIsUseInflutter(boolean z) {
        this.b0 = z;
    }

    public void setLocateSource(String str) {
        this.N = str;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setMute(boolean z) {
        this.R = z;
        getCyberPlayer().muteOrUnmuteAudio(z);
        m0.e(this.Q, !z);
    }

    public void setNoBussinessStats() {
        this.L = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.d0 = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.f0 = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.g0 = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.c0 = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.e0 = onSeekCompleteListener;
    }

    public void setOnSurfaceDestroyedListener(g gVar) {
        this.h0 = gVar;
    }

    public void setPlayMode(String str) {
        d.b.i0.i2.p.b bVar = this.L;
        if (bVar != null) {
            bVar.i(str);
        }
    }

    public void setStageType(String str) {
        if (d.b.b.e.p.k.isEmpty(str)) {
            str = "-1";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", "20484");
        hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, str);
        setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
        this.O = str;
    }

    public void setThreadDataForStatistic(a2 a2Var) {
        if (this.L == null) {
            this.L = new d.b.i0.i2.p.b();
        }
        this.L.j(a2Var);
    }

    public void setTryUseViewInSet(boolean z) {
        this.S = z;
    }

    public void setVideoDuration(int i) {
        this.T = i;
    }

    public void setVideoPath(String str, String str2) {
        if (d.b.b.e.p.k.isEmpty(str)) {
            return;
        }
        this.I = str2;
        setVideoPath(str);
    }

    public void setVideoStatData(o oVar) {
        if (this.L == null) {
            this.L = new d.b.i0.i2.p.b();
        }
        this.L.k(oVar);
        if (oVar != null) {
            this.N = oVar.f56164a;
        }
    }

    public void setVolume(float f2, float f3) {
        if (getCyberPlayer() != null) {
            this.R = f2 == 0.0f && f3 == 0.0f;
            getCyberPlayer().setVolume(f2, f3);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        if (!this.R) {
            m0.e(this.Q, true);
            setVolume(1.0f, 1.0f);
        }
        this.K = true;
        super.start();
        d.b.i0.i2.p.b bVar = this.L;
        if (bVar != null) {
            bVar.f();
        }
        this.a0.m();
        try {
            if (this.P != null && !this.P.isHeld()) {
                this.P.acquire();
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        if (getVideoMonitor() != null) {
            getVideoMonitor().e(-400);
            getVideoMonitor().d(this.U, this.V);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (this.J != null && isPlaying()) {
            m0.e(this.Q, false);
        }
        this.K = false;
        if (isPlaying() && M()) {
            n.d().f(this.J, getCurrentPositionSync());
        }
        try {
            if (this.P != null && this.P.isHeld()) {
                this.P.release();
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        super.stopPlayback();
        TbVideoViewSet.d().f(this.J);
        d.b.i0.i2.p.b bVar = this.L;
        if (bVar != null) {
            bVar.g();
        }
        this.a0.n();
        h hVar = this.M;
        if (hVar == null || !hVar.g(this.N, this.O)) {
            return;
        }
        this.M = null;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        if (d.b.b.e.p.k.isEmpty(str)) {
            return;
        }
        S();
        this.J = str;
        String B = B(str);
        k kVar = o0;
        if (kVar != null) {
            h a2 = kVar.a(this.I, this.J, null);
            this.M = a2;
            if (a2 != null) {
                a2.b(CyberPlayerManager.hasCacheFile(B));
            }
        }
        this.a0.l(this);
        d.b.i0.i2.p.b bVar = this.L;
        if (bVar != null) {
            bVar.e();
        }
        K(Uri.parse(B));
        h hVar = this.M;
        if (hVar != null) {
            hVar.j();
        }
        String host = Uri.parse(this.J).getHost();
        setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.T < 900)) ? "1" : "0");
        super.setVideoPath(B);
    }

    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
        this.Q = null;
        this.R = false;
        this.S = false;
        this.b0 = false;
        this.i0 = new a();
        this.j0 = new b();
        this.k0 = new c();
        this.l0 = new d();
        this.m0 = new e();
        this.n0 = new f(2001011);
        J(context);
    }

    public TbCyberVideoView(Context context) {
        super(context, 1);
        this.Q = null;
        this.R = false;
        this.S = false;
        this.b0 = false;
        this.i0 = new a();
        this.j0 = new b();
        this.k0 = new c();
        this.l0 = new d();
        this.m0 = new e();
        this.n0 = new f(2001011);
        J(context);
    }
}

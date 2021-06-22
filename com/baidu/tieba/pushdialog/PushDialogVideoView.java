package com.baidu.tieba.pushdialog;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.a.o0.k2.n;
import d.a.o0.k2.o;
/* loaded from: classes5.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public d.a.n0.b1.m.i G;
    public CyberPlayerManager.OnPreparedListener H;
    public VideoLoadingProgressView.c I;
    public Runnable J;
    public CyberPlayerManager.OnCompletionListener K;
    public CyberPlayerManager.OnErrorListener L;
    public Runnable M;
    public CyberPlayerManager.OnSeekCompleteListener N;
    public Runnable O;
    public TbCyberVideoView.g P;
    public CustomMessageListener Q;
    public Handler R;
    public VideoControllerView.d S;

    /* renamed from: e  reason: collision with root package name */
    public int f20229e;

    /* renamed from: f  reason: collision with root package name */
    public int f20230f;

    /* renamed from: g  reason: collision with root package name */
    public int f20231g;

    /* renamed from: h  reason: collision with root package name */
    public int f20232h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f20233i;
    public TbCyberVideoView j;
    public d.a.o0.k2.m k;
    public ProgressBar l;
    public View m;
    public View n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public String r;
    public String s;
    public TbImageView t;
    public PbVideoWifiTipLayout u;
    public boolean v;
    public int w;
    public CallStateReceiver x;
    public boolean y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                PushDialogVideoView.this.G();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1 && PushDialogVideoView.this.j != null && PushDialogVideoView.this.j.isPlaying()) {
                int currentPosition = PushDialogVideoView.this.j.getCurrentPosition();
                int duration = PushDialogVideoView.this.j.getDuration();
                if (currentPosition > duration) {
                    currentPosition = duration;
                }
                if (PushDialogVideoView.this.S != null) {
                    PushDialogVideoView.this.S.a(currentPosition);
                }
                sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.f20229e - (currentPosition % PushDialogVideoView.this.f20229e));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements VideoControllerView.d {
        public c() {
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i2) {
            int duration;
            if (PushDialogVideoView.this.j == null || (duration = PushDialogVideoView.this.j.getDuration()) <= 0 || PushDialogVideoView.this.l == null) {
                return;
            }
            PushDialogVideoView.this.l.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
        }
    }

    /* loaded from: classes5.dex */
    public class d implements CyberPlayerManager.OnPreparedListener {
        public d() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            PushDialogVideoView.this.k.e();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements VideoLoadingProgressView.c {
        public e() {
        }

        @Override // com.baidu.tieba.play.VideoLoadingProgressView.c
        public void onAnimationEnd() {
            PushDialogVideoView.this.T();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PushDialogVideoView.this.j.getCurrentPosition() > 100) {
                PushDialogVideoView.this.v = true;
                PushDialogVideoView.this.m.setVisibility(8);
                PushDialogVideoView.this.n.setVisibility(8);
                PushDialogVideoView.this.k.c();
                PushDialogVideoView.this.t.setVisibility(8);
                PushDialogVideoView.this.N();
                return;
            }
            d.a.c.e.m.e.a().postDelayed(PushDialogVideoView.this.J, 20L);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements CyberPlayerManager.OnCompletionListener {
        public g() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            PushDialogVideoView.this.v = false;
            PushDialogVideoView.this.D = false;
            PushDialogVideoView.this.w = 0;
            PushDialogVideoView.this.m.setVisibility(0);
            PushDialogVideoView.this.l.setVisibility(8);
            PushDialogVideoView.this.l.setProgress(PushDialogVideoView.this.l.getMax());
            if (PushDialogVideoView.this.j == null || PushDialogVideoView.this.j.getDuration() > 150000) {
                PushDialogVideoView.this.I(false);
            } else {
                PushDialogVideoView.this.p.setVisibility(0);
            }
            n.d().e(PushDialogVideoView.this.r);
            if (PushDialogVideoView.this.j == null || PushDialogVideoView.this.j.getDuration() > 150000) {
                return;
            }
            PushDialogVideoView pushDialogVideoView = PushDialogVideoView.this;
            pushDialogVideoView.O(pushDialogVideoView.r, PushDialogVideoView.this.s);
        }
    }

    /* loaded from: classes5.dex */
    public class h implements CyberPlayerManager.OnErrorListener {
        public h() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            PushDialogVideoView.this.n.setVisibility(0);
            PushDialogVideoView.this.k.b();
            if (!d.a.c.e.p.j.z()) {
                PushDialogVideoView.this.B = true;
            }
            PushDialogVideoView.this.D = false;
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PushDialogVideoView.this.n.setVisibility(0);
            PushDialogVideoView.this.k.b();
        }
    }

    /* loaded from: classes5.dex */
    public class j implements CyberPlayerManager.OnSeekCompleteListener {
        public j() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (PushDialogVideoView.this.z) {
                d.a.c.e.m.e.a().postDelayed(PushDialogVideoView.this.O, 200L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PushDialogVideoView.this.j == null || !PushDialogVideoView.this.z) {
                d.a.c.e.m.e.a().postDelayed(PushDialogVideoView.this.J, 200L);
                PushDialogVideoView.this.z = false;
            } else if (PushDialogVideoView.this.w != PushDialogVideoView.this.j.getCurrentPosition()) {
                PushDialogVideoView.this.z = false;
                d.a.c.e.m.e.a().postDelayed(PushDialogVideoView.this.J, 20L);
            } else {
                d.a.c.e.m.e.a().postDelayed(PushDialogVideoView.this.O, 200L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements TbCyberVideoView.g {
        public l() {
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
        public void onSurfaceDestroyed() {
            PushDialogVideoView.this.v = false;
            PushDialogVideoView.this.D = false;
            d.a.c.e.m.e.a().removeCallbacks(PushDialogVideoView.this.J);
            d.a.c.e.m.e.a().removeCallbacks(PushDialogVideoView.this.M);
        }
    }

    /* loaded from: classes5.dex */
    public interface m {
        void a(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.f20229e = 50;
        this.f20230f = 3;
        this.v = false;
        this.w = 0;
        this.y = true;
        this.z = false;
        this.A = false;
        this.E = false;
        this.H = new d();
        this.I = new e();
        this.J = new f();
        this.K = new g();
        this.L = new h();
        this.M = new i();
        this.N = new j();
        this.O = new k();
        this.P = new l();
        this.Q = new a(2016503);
        this.R = new b(Looper.getMainLooper());
        this.S = new c();
        x(context);
    }

    public void A() {
        stopPlay();
        d.a.c.e.m.e.a().removeCallbacks(this.J);
        d.a.c.e.m.e.a().removeCallbacks(this.M);
        d.a.c.e.m.e.a().removeCallbacks(this.O);
        this.R.removeMessages(1);
        this.x.unregister(getContext());
    }

    public void B() {
        if (y()) {
            this.E = true;
            G();
            return;
        }
        this.E = false;
        G();
    }

    public void F() {
        if (this.E) {
            K();
        }
    }

    public void G() {
        if (this.j.isPlaying() && this.y) {
            L();
        }
        this.j.pause();
        setPauseState();
    }

    public void H() {
        I(true);
    }

    public final void I(boolean z) {
        this.m.setVisibility(0);
        this.o.setVisibility(0);
        this.p.setVisibility(8);
        this.k.b();
        this.l.setVisibility(8);
        this.n.setVisibility(8);
        this.R.removeMessages(1);
        this.t.setVisibility(z ? 0 : 8);
    }

    public void J() {
        if (!d.a.c.e.p.j.z()) {
            d.a.c.e.p.l.J(getContext(), getContext().getString(R.string.neterror));
        } else if (this.j.isPlaying()) {
            G();
        } else if (this.v) {
            K();
        } else {
            R();
        }
    }

    public void K() {
        this.j.start();
        this.t.setVisibility(8);
        this.m.setVisibility(8);
        this.k.b();
        N();
        this.o.setVisibility(8);
        this.p.setVisibility(8);
    }

    public void L() {
        n.d().f(this.r, this.j.getCurrentPositionSync());
    }

    public final void M() {
        if (d.a.c.e.p.j.x()) {
            d.a.o0.r3.f.d().g(getContext());
        }
    }

    public void N() {
        if (this.j == null) {
            return;
        }
        this.l.setVisibility(0);
        int duration = ((this.j.getDuration() / 200) / 50) * 50;
        this.f20229e = duration;
        if (duration < 50) {
            this.f20229e = 50;
        } else if (duration > 500) {
            this.f20229e = 500;
        }
        this.R.removeMessages(1);
        Handler handler = this.R;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f20229e - (this.j.getCurrentPosition() % this.f20229e));
    }

    public void O(String str, String str2) {
        M();
        this.D = true;
        setVideoUrl(str, str2);
        this.j.setVideoPath(str, str2);
        this.k.g();
        this.t.setVisibility(0);
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.n.setVisibility(8);
        d.a.c.e.m.e.a().removeCallbacks(this.M);
        d.a.c.e.m.e.a().postDelayed(this.M, 60000L);
    }

    public final void P(m mVar, boolean z, String str, String str2) {
        if (this.A) {
            Q(str, str2);
        } else {
            O(str, str2);
        }
        if (mVar != null) {
            mVar.a(z);
        }
    }

    public void Q(String str, String str2) {
        M();
        this.D = true;
        this.k.g();
        this.t.setVisibility(0);
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.n.setVisibility(8);
        d.a.c.e.m.e.a().removeCallbacks(this.M);
        d.a.c.e.m.e.a().postDelayed(this.M, 60000L);
    }

    public final void R() {
        S(this.r, this.s, null, new Object[0]);
    }

    public void S(String str, String str2, m mVar, Object... objArr) {
        M();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.A = ((Boolean) objArr[0]).booleanValue();
        }
        if (d.a.c.e.p.j.x() && !this.F && !d.a.o0.r3.f.d().e()) {
            this.u.setVisibility(0);
            this.u.setData(this.G.b(), this.G.c());
            return;
        }
        P(mVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    public final void T() {
        TbCyberVideoView tbCyberVideoView = this.j;
        if (tbCyberVideoView == null) {
            return;
        }
        if (this.D) {
            tbCyberVideoView.start();
            this.D = false;
        }
        d.a.c.e.m.e.a().removeCallbacks(this.J);
        d.a.c.e.m.e.a().postDelayed(this.J, 20L);
        d.a.c.e.m.e.a().removeCallbacks(this.M);
        int c2 = n.d().c(this.r);
        this.w = c2;
        if (c2 != 0) {
            this.j.seekTo(c2);
            if (!this.C) {
                N();
                d.a.c.e.m.e.a().removeCallbacks(this.J);
            }
            this.z = true;
        }
    }

    public int getCurrentPosition() {
        TbCyberVideoView tbCyberVideoView = this.j;
        if (tbCyberVideoView == null) {
            return 0;
        }
        return tbCyberVideoView.getCurrentPosition();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext<?> tbPageContext;
        if (view == this.n) {
            R();
        } else if (view == this) {
            TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 2).param("tid", this.s));
            J();
        } else if (view == this.p) {
            O(this.r, this.s);
        } else if (view == this.u.getTvPlay()) {
            this.F = true;
            this.u.setVisibility(8);
            O(this.r, this.s);
        } else if (view != this.u.getTvOpenFreeData() || (tbPageContext = this.f20233i) == null) {
        } else {
            tbPageContext.getPageActivity().finish();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(this.f20231g, this.f20232h);
    }

    public void setNetworkChange() {
        if (!d.a.c.e.p.j.z() || !this.B || StringUtils.isNull(this.r) || StringUtils.isNull(this.s)) {
            return;
        }
        this.B = false;
        this.C = true;
        O(this.r, this.s);
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.f20233i = tbPageContext;
        tbPageContext.registerListener(this.Q);
    }

    public void setPauseState() {
        this.k.b();
        this.o.setVisibility(0);
        this.p.setVisibility(8);
    }

    public void setTbRichTextVideoInfo(d.a.n0.b1.m.i iVar) {
        this.G = iVar;
        this.q.setText(StringHelper.stringForVideoTime(iVar.b() * 1000));
    }

    public void setThumbnail(String str) {
        this.t.U(str, 17, false);
    }

    public void setVideoUrl(String str, String str2) {
        this.r = str;
        this.s = str2;
    }

    public void setVideoViewBusiness(o oVar) {
        this.j.setVideoStatData(oVar);
    }

    public void stopPlay() {
        if (this.j.isPlaying() && this.y) {
            L();
        }
        d.a.c.e.m.e.a().removeCallbacks(this.J);
        d.a.c.e.m.e.a().removeCallbacks(this.M);
        this.j.stopPlayback();
        this.v = false;
        this.D = false;
        this.w = 0;
        H();
    }

    public final void x(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        int k2 = d.a.c.e.p.l.k(context) - d.a.c.e.p.l.g(context, R.dimen.tbds132);
        this.f20231g = k2;
        this.f20232h = (int) (k2 * 0.5625f);
        TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) findViewById(R.id.videoView);
        this.j = tbCyberVideoView;
        tbCyberVideoView.setPlayMode("2");
        this.j.setStageType(null);
        d.a.o0.k2.m mVar = new d.a.o0.k2.m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.k = mVar;
        mVar.f(this.I);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.l = progressBar;
        progressBar.setMax(this.f20231g);
        this.l.setProgress(0);
        this.m = findViewById(R.id.black_mask);
        this.n = findViewById(R.id.layout_error);
        this.o = (ImageView) findViewById(R.id.img_play);
        this.p = (TextView) findViewById(R.id.txt_replay);
        this.q = (TextView) findViewById(R.id.push_dialog_video_time);
        this.t = (TbImageView) findViewById(R.id.video_thumbnail);
        this.u = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.t.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        CallStateReceiver callStateReceiver = new CallStateReceiver();
        this.x = callStateReceiver;
        callStateReceiver.register(context);
        this.n.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.u.setOnPlayClickListener(this);
        this.u.setFreeClickListener(this);
        setOnClickListener(this);
        this.j.setOnPreparedListener(this.H);
        this.j.setOnCompletionListener(this.K);
        this.j.setOnErrorListener(this.L);
        this.j.setOnSeekCompleteListener(this.N);
        this.j.setOnSurfaceDestroyedListener(this.P);
        z();
    }

    public boolean y() {
        TbCyberVideoView tbCyberVideoView = this.j;
        if (tbCyberVideoView == null) {
            return false;
        }
        return tbCyberVideoView.isPlaying();
    }

    public void z() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f20230f) {
            return;
        }
        this.f20230f = skinType;
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20229e = 50;
        this.f20230f = 3;
        this.v = false;
        this.w = 0;
        this.y = true;
        this.z = false;
        this.A = false;
        this.E = false;
        this.H = new d();
        this.I = new e();
        this.J = new f();
        this.K = new g();
        this.L = new h();
        this.M = new i();
        this.N = new j();
        this.O = new k();
        this.P = new l();
        this.Q = new a(2016503);
        this.R = new b(Looper.getMainLooper());
        this.S = new c();
        x(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20229e = 50;
        this.f20230f = 3;
        this.v = false;
        this.w = 0;
        this.y = true;
        this.z = false;
        this.A = false;
        this.E = false;
        this.H = new d();
        this.I = new e();
        this.J = new f();
        this.K = new g();
        this.L = new h();
        this.M = new i();
        this.N = new j();
        this.O = new k();
        this.P = new l();
        this.Q = new a(2016503);
        this.R = new b(Looper.getMainLooper());
        this.S = new c();
        x(context);
    }
}

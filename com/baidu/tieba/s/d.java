package com.baidu.tieba.s;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    private TextView bDN;
    private TextView etH;
    private View gKQ;
    private ScaleVideoView gVt;
    private LogoActivity gXu;
    private a gXv;
    private int gXy;
    private View mRootView;
    private boolean gXz = true;
    private Runnable gXA = new Runnable() { // from class: com.baidu.tieba.s.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.gXv != null) {
                d.this.gXv.onError();
            }
        }
    };
    private com.baidu.tieba.s.a gXw = new com.baidu.tieba.s.a();
    private c gXx = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Lr();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.gXy = 0;
        this.gXu = logoActivity;
        this.gXy = 0;
    }

    public boolean bzQ() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.gXw == null || this.gXx == null) {
            return false;
        }
        return this.gXw.bzQ() && this.gXx.bzT();
    }

    public void bzV() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.gXx != null) {
                this.gXx.bzU();
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", 0L);
        }
    }

    public View p(double d) {
        if (this.mRootView == null) {
            this.mRootView = q(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new al("c12944"));
        e.fw().postDelayed(this.gXA, 1000L);
        load();
    }

    private void load() {
        if (this.gXx != null && !an.isEmpty(this.gXx.getVideoPath())) {
            this.gVt.setVideoPath(this.gXx.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.gXw != null) {
            this.gXw.cZ(System.currentTimeMillis());
        }
        if (this.gXy >= 0) {
            this.gVt.seekTo(this.gXy);
        }
        this.gVt.start();
    }

    private View q(double d) {
        View inflate = LayoutInflater.from(this.gXu).inflate(d.i.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.ah(this.gXu) * d)));
        this.gVt = (ScaleVideoView) inflate.findViewById(d.g.video);
        this.gVt.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.s.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.fw().removeCallbacks(d.this.gXA);
                if (d.this.gXv != null) {
                    d.this.gXz = false;
                    d.this.gXv.onError();
                    return true;
                }
                return true;
            }
        });
        this.gVt.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.s.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.fw().removeCallbacks(d.this.gXA);
                if (d.this.gXv != null) {
                    d.this.gXz = false;
                    d.this.gXv.Lr();
                }
            }
        });
        this.gVt.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.s.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.fw().removeCallbacks(d.this.gXA);
                d.this.gVt.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.s.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.bzW();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.etH = (TextView) inflate.findViewById(d.g.skip);
        this.etH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.s.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.fw().removeCallbacks(d.this.gXA);
                if (d.this.gXv != null) {
                    d.this.gXz = false;
                    d.this.gXv.Lr();
                }
                TiebaStatic.log(new al("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        u uVar = new u();
        uVar.parseJson(string);
        final String yQ = uVar.yQ();
        this.gKQ = inflate.findViewById(d.g.tip_container);
        this.gKQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.s.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new al("c12945"));
                if (!an.isEmpty(yQ)) {
                    d.this.gXz = false;
                    d.this.gXv.Lr();
                    ax.wf().c(d.this.gXu.getPageContext(), new String[]{yQ});
                }
            }
        });
        this.bDN = (TextView) inflate.findViewById(d.g.tip_text);
        String yR = uVar.yR();
        if (an.isEmpty(yR)) {
            yR = this.gXu.getString(d.k.video_splash_tip_default);
        }
        this.bDN.setText(yR);
        bzX();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzW() {
        if (this.gVt != null) {
            this.gVt.setBackgroundResource(0);
        }
    }

    private void bzX() {
        if (this.gXx != null && this.gXx.bzT()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.gXx.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.gVt != null) {
                    this.gVt.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gVt != null) {
                    this.gVt.setBackgroundColor(this.gXu.getResources().getColor(d.C0126d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.gXz = true;
        if (this.gVt != null) {
            this.gVt.resume();
        }
    }

    public void onPause() {
        if (this.gVt != null) {
            this.gXy = this.gVt.getCurrentPosition();
            this.gVt.stopPlayback();
            if (this.gXz) {
                bzX();
            }
        }
    }

    public void onDestroy() {
        e.fw().removeCallbacks(this.gXA);
    }

    public void a(a aVar) {
        this.gXv = aVar;
    }
}

package com.baidu.tieba.v;

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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    private TextView bNY;
    private TextView eIN;
    private View hax;
    private ScaleVideoView hlb;
    private LogoActivity hnb;
    private a hnc;
    private int hnf;
    private View mRootView;
    private boolean hng = true;
    private Runnable hnh = new Runnable() { // from class: com.baidu.tieba.v.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hnc != null) {
                d.this.hnc.onError();
            }
        }
    };
    private com.baidu.tieba.v.a hnd = new com.baidu.tieba.v.a();
    private c hne = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Pj();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.hnf = 0;
        this.hnb = logoActivity;
        this.hnf = 0;
    }

    public boolean bFv() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.hnd == null || this.hne == null) {
            return false;
        }
        return this.hnd.bFv() && this.hne.bFy();
    }

    public void bFA() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.hne != null) {
                this.hne.bFz();
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
        TiebaStatic.log(new an("c12944"));
        e.im().postDelayed(this.hnh, 1000L);
        load();
    }

    private void load() {
        if (this.hne != null && !ap.isEmpty(this.hne.getVideoPath())) {
            this.hlb.setVideoPath(this.hne.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.hnd != null) {
            this.hnd.de(System.currentTimeMillis());
        }
        if (this.hnf >= 0) {
            this.hlb.seekTo(this.hnf);
        }
        this.hlb.start();
    }

    private View q(double d) {
        View inflate = LayoutInflater.from(this.hnb).inflate(d.i.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aj(this.hnb) * d)));
        this.hlb = (ScaleVideoView) inflate.findViewById(d.g.video);
        this.hlb.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.v.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.im().removeCallbacks(d.this.hnh);
                if (d.this.hnc != null) {
                    d.this.hng = false;
                    d.this.hnc.onError();
                    return true;
                }
                return true;
            }
        });
        this.hlb.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.v.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.im().removeCallbacks(d.this.hnh);
                if (d.this.hnc != null) {
                    d.this.hng = false;
                    d.this.hnc.Pj();
                }
            }
        });
        this.hlb.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.v.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.im().removeCallbacks(d.this.hnh);
                d.this.hlb.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.v.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.bFB();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.eIN = (TextView) inflate.findViewById(d.g.skip);
        this.eIN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.im().removeCallbacks(d.this.hnh);
                if (d.this.hnc != null) {
                    d.this.hng = false;
                    d.this.hnc.Pj();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        u uVar = new u();
        uVar.parseJson(string);
        final String CI = uVar.CI();
        this.hax = inflate.findViewById(d.g.tip_container);
        this.hax.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!ap.isEmpty(CI)) {
                    d.this.hng = false;
                    d.this.hnc.Pj();
                    az.zV().c(d.this.hnb.getPageContext(), new String[]{CI});
                }
            }
        });
        this.bNY = (TextView) inflate.findViewById(d.g.tip_text);
        String CJ = uVar.CJ();
        if (ap.isEmpty(CJ)) {
            CJ = this.hnb.getString(d.k.video_splash_tip_default);
        }
        this.bNY.setText(CJ);
        bFC();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFB() {
        if (this.hlb != null) {
            this.hlb.setBackgroundResource(0);
        }
    }

    private void bFC() {
        if (this.hne != null && this.hne.bFy()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.hne.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.hlb != null) {
                    this.hlb.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hlb != null) {
                    this.hlb.setBackgroundColor(this.hnb.getResources().getColor(d.C0142d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.hng = true;
        if (this.hlb != null) {
            this.hlb.resume();
        }
    }

    public void onPause() {
        if (this.hlb != null) {
            this.hnf = this.hlb.getCurrentPosition();
            this.hlb.stopPlayback();
            if (this.hng) {
                bFC();
            }
        }
    }

    public void onDestroy() {
        e.im().removeCallbacks(this.hnh);
    }

    public void a(a aVar) {
        this.hnc = aVar;
    }
}

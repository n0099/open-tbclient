package com.baidu.tieba.u;

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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class d {
    private TextView cdw;
    private TextView fda;
    private ScaleVideoView hDc;
    private LogoActivity hEZ;
    private a hFa;
    private int hFd;
    private View hsD;
    private View mRootView;
    private boolean hFe = true;
    private Runnable hFf = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hFa != null) {
                d.this.hFa.onError();
            }
        }
    };
    private com.baidu.tieba.u.a hFb = new com.baidu.tieba.u.a();
    private c hFc = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Tn();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.hFd = 0;
        this.hEZ = logoActivity;
        this.hFd = 0;
    }

    public boolean bJK() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.hFb == null || this.hFc == null) {
            return false;
        }
        return this.hFb.bJK() && this.hFc.bJN();
    }

    public void bJP() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.hFc != null) {
                this.hFc.bJO();
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", 0L);
        }
    }

    public View n(double d) {
        if (this.mRootView == null) {
            this.mRootView = o(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new am("c12944"));
        e.jG().postDelayed(this.hFf, 1000L);
        load();
    }

    private void load() {
        if (this.hFc != null && !ao.isEmpty(this.hFc.getVideoPath())) {
            this.hDc.setVideoPath(this.hFc.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.hFb != null) {
            this.hFb.df(System.currentTimeMillis());
        }
        if (this.hFd >= 0) {
            this.hDc.seekTo(this.hFd);
        }
        this.hDc.start();
    }

    private View o(double d) {
        View inflate = LayoutInflater.from(this.hEZ).inflate(e.h.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aQ(this.hEZ) * d)));
        this.hDc = (ScaleVideoView) inflate.findViewById(e.g.video);
        this.hDc.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hFf);
                if (d.this.hFa != null) {
                    d.this.hFe = false;
                    d.this.hFa.onError();
                    return true;
                }
                return true;
            }
        });
        this.hDc.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hFf);
                if (d.this.hFa != null) {
                    d.this.hFe = false;
                    d.this.hFa.Tn();
                }
            }
        });
        this.hDc.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hFf);
                d.this.hDc.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.u.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.bJQ();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.fda = (TextView) inflate.findViewById(e.g.skip);
        this.fda.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hFf);
                if (d.this.hFa != null) {
                    d.this.hFe = false;
                    d.this.hFa.Tn();
                }
                TiebaStatic.log(new am("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        x xVar = new x();
        xVar.parseJson(string);
        final String FY = xVar.FY();
        this.hsD = inflate.findViewById(e.g.tip_container);
        this.hsD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12945"));
                if (!ao.isEmpty(FY)) {
                    d.this.hFe = false;
                    d.this.hFa.Tn();
                    ay.Db().c(d.this.hEZ.getPageContext(), new String[]{FY});
                }
            }
        });
        this.cdw = (TextView) inflate.findViewById(e.g.tip_text);
        String FZ = xVar.FZ();
        if (ao.isEmpty(FZ)) {
            FZ = this.hEZ.getString(e.j.video_splash_tip_default);
        }
        this.cdw.setText(FZ);
        bJR();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJQ() {
        if (this.hDc != null) {
            this.hDc.setBackgroundResource(0);
        }
    }

    private void bJR() {
        if (this.hFc != null && this.hFc.bJN()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.hFc.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.hDc != null) {
                    this.hDc.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hDc != null) {
                    this.hDc.setBackgroundColor(this.hEZ.getResources().getColor(e.d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.hFe = true;
        if (this.hDc != null) {
            this.hDc.resume();
        }
    }

    public void onPause() {
        if (this.hDc != null) {
            this.hFd = this.hDc.getCurrentPosition();
            this.hDc.stopPlayback();
            if (this.hFe) {
                bJR();
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hFf);
    }

    public void a(a aVar) {
        this.hFa = aVar;
    }
}

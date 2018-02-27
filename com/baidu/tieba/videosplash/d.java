package com.baidu.tieba.videosplash;

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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    private TextView eXG;
    private View hnK;
    private ScaleVideoView hzA;
    private a hzB;
    private int hzE;
    private LogoActivity hzy;
    private TextView hzz;
    private View mRootView;
    private boolean hzF = true;
    private Runnable hzG = new Runnable() { // from class: com.baidu.tieba.videosplash.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hzB != null) {
                d.this.hzB.onError();
            }
        }
    };
    private com.baidu.tieba.videosplash.a hzC = new com.baidu.tieba.videosplash.a();
    private c hzD = new c();

    /* loaded from: classes.dex */
    public interface a {
        void SU();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.hzE = 0;
        this.hzy = logoActivity;
        this.hzE = 0;
    }

    public boolean bEA() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.hzC == null || this.hzD == null) {
            return false;
        }
        return this.hzC.bEA() && this.hzD.bED();
    }

    public void bEF() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.hzD != null) {
                this.hzD.bEE();
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", 0L);
        }
    }

    public View o(double d) {
        if (this.mRootView == null) {
            this.mRootView = p(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new ak("c12944"));
        e.ns().postDelayed(this.hzG, 1000L);
        load();
    }

    private void load() {
        if (this.hzD != null && !am.isEmpty(this.hzD.getVideoPath())) {
            this.hzA.setVideoPath(this.hzD.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.hzC != null) {
            this.hzC.cV(System.currentTimeMillis());
        }
        if (this.hzE >= 0) {
            this.hzA.seekTo(this.hzE);
        }
        this.hzA.start();
    }

    private View p(double d) {
        View inflate = LayoutInflater.from(this.hzy).inflate(d.h.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aq(this.hzy) * d)));
        this.hzA = (ScaleVideoView) inflate.findViewById(d.g.video);
        this.hzA.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videosplash.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.ns().removeCallbacks(d.this.hzG);
                if (d.this.hzB != null) {
                    d.this.hzF = false;
                    d.this.hzB.onError();
                    return true;
                }
                return true;
            }
        });
        this.hzA.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videosplash.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.ns().removeCallbacks(d.this.hzG);
                if (d.this.hzB != null) {
                    d.this.hzF = false;
                    d.this.hzB.SU();
                }
            }
        });
        this.hzA.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videosplash.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.ns().removeCallbacks(d.this.hzG);
                d.this.hzA.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videosplash.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.bEG();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.eXG = (TextView) inflate.findViewById(d.g.skip);
        this.eXG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videosplash.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.ns().removeCallbacks(d.this.hzG);
                if (d.this.hzB != null) {
                    d.this.hzF = false;
                    d.this.hzB.SU();
                }
                TiebaStatic.log(new ak("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        u uVar = new u();
        uVar.parseJson(string);
        final String Gd = uVar.Gd();
        this.hnK = inflate.findViewById(d.g.tip_container);
        this.hnK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videosplash.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12945"));
                if (!am.isEmpty(Gd)) {
                    d.this.hzF = false;
                    d.this.hzB.SU();
                    aw.Dt().c(d.this.hzy.getPageContext(), new String[]{Gd});
                }
            }
        });
        this.hzz = (TextView) inflate.findViewById(d.g.tip_text);
        String Ge = uVar.Ge();
        if (am.isEmpty(Ge)) {
            Ge = this.hzy.getString(d.j.video_splash_tip_default);
        }
        this.hzz.setText(Ge);
        bEH();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEG() {
        if (this.hzA != null) {
            this.hzA.setBackgroundResource(0);
        }
    }

    private void bEH() {
        if (this.hzD != null && this.hzD.bED()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.hzD.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.hzA != null) {
                    this.hzA.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hzA != null) {
                    this.hzA.setBackgroundColor(this.hzy.getResources().getColor(d.C0141d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.hzF = true;
        if (this.hzA != null) {
            this.hzA.resume();
        }
    }

    public void onPause() {
        if (this.hzA != null) {
            this.hzE = this.hzA.getCurrentPosition();
            this.hzA.stopPlayback();
            if (this.hzF) {
                bEH();
            }
        }
    }

    public void onDestroy() {
        e.ns().removeCallbacks(this.hzG);
    }

    public void a(a aVar) {
        this.hzB = aVar;
    }
}

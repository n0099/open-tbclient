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
    private TextView eXU;
    private int hAc;
    private View hoi;
    private LogoActivity hzW;
    private TextView hzX;
    private ScaleVideoView hzY;
    private a hzZ;
    private View mRootView;
    private boolean hAd = true;
    private Runnable hAe = new Runnable() { // from class: com.baidu.tieba.videosplash.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hzZ != null) {
                d.this.hzZ.onError();
            }
        }
    };
    private com.baidu.tieba.videosplash.a hAa = new com.baidu.tieba.videosplash.a();
    private c hAb = new c();

    /* loaded from: classes.dex */
    public interface a {
        void SV();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.hAc = 0;
        this.hzW = logoActivity;
        this.hAc = 0;
    }

    public boolean bEF() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.hAa == null || this.hAb == null) {
            return false;
        }
        return this.hAa.bEF() && this.hAb.bEI();
    }

    public void bEK() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.hAb != null) {
                this.hAb.bEJ();
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
        e.ns().postDelayed(this.hAe, 1000L);
        load();
    }

    private void load() {
        if (this.hAb != null && !am.isEmpty(this.hAb.getVideoPath())) {
            this.hzY.setVideoPath(this.hAb.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.hAa != null) {
            this.hAa.cV(System.currentTimeMillis());
        }
        if (this.hAc >= 0) {
            this.hzY.seekTo(this.hAc);
        }
        this.hzY.start();
    }

    private View p(double d) {
        View inflate = LayoutInflater.from(this.hzW).inflate(d.h.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aq(this.hzW) * d)));
        this.hzY = (ScaleVideoView) inflate.findViewById(d.g.video);
        this.hzY.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videosplash.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.ns().removeCallbacks(d.this.hAe);
                if (d.this.hzZ != null) {
                    d.this.hAd = false;
                    d.this.hzZ.onError();
                    return true;
                }
                return true;
            }
        });
        this.hzY.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videosplash.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.ns().removeCallbacks(d.this.hAe);
                if (d.this.hzZ != null) {
                    d.this.hAd = false;
                    d.this.hzZ.SV();
                }
            }
        });
        this.hzY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videosplash.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.ns().removeCallbacks(d.this.hAe);
                d.this.hzY.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videosplash.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.bEL();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.eXU = (TextView) inflate.findViewById(d.g.skip);
        this.eXU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videosplash.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.ns().removeCallbacks(d.this.hAe);
                if (d.this.hzZ != null) {
                    d.this.hAd = false;
                    d.this.hzZ.SV();
                }
                TiebaStatic.log(new ak("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        u uVar = new u();
        uVar.parseJson(string);
        final String Ge = uVar.Ge();
        this.hoi = inflate.findViewById(d.g.tip_container);
        this.hoi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videosplash.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12945"));
                if (!am.isEmpty(Ge)) {
                    d.this.hAd = false;
                    d.this.hzZ.SV();
                    aw.Du().c(d.this.hzW.getPageContext(), new String[]{Ge});
                }
            }
        });
        this.hzX = (TextView) inflate.findViewById(d.g.tip_text);
        String Gf = uVar.Gf();
        if (am.isEmpty(Gf)) {
            Gf = this.hzW.getString(d.j.video_splash_tip_default);
        }
        this.hzX.setText(Gf);
        bEM();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEL() {
        if (this.hzY != null) {
            this.hzY.setBackgroundResource(0);
        }
    }

    private void bEM() {
        if (this.hAb != null && this.hAb.bEI()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.hAb.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.hzY != null) {
                    this.hzY.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hzY != null) {
                    this.hzY.setBackgroundColor(this.hzW.getResources().getColor(d.C0141d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.hAd = true;
        if (this.hzY != null) {
            this.hzY.resume();
        }
    }

    public void onPause() {
        if (this.hzY != null) {
            this.hAc = this.hzY.getCurrentPosition();
            this.hzY.stopPlayback();
            if (this.hAd) {
                bEM();
            }
        }
    }

    public void onDestroy() {
        e.ns().removeCallbacks(this.hAe);
    }

    public void a(a aVar) {
        this.hzZ = aVar;
    }
}

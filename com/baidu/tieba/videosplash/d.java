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
    private TextView eXS;
    private View hnX;
    private LogoActivity hzL;
    private TextView hzM;
    private ScaleVideoView hzN;
    private a hzO;
    private int hzR;
    private View mRootView;
    private boolean hzS = true;
    private Runnable hzT = new Runnable() { // from class: com.baidu.tieba.videosplash.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hzO != null) {
                d.this.hzO.onError();
            }
        }
    };
    private com.baidu.tieba.videosplash.a hzP = new com.baidu.tieba.videosplash.a();
    private c hzQ = new c();

    /* loaded from: classes.dex */
    public interface a {
        void SV();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.hzR = 0;
        this.hzL = logoActivity;
        this.hzR = 0;
    }

    public boolean bEB() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.hzP == null || this.hzQ == null) {
            return false;
        }
        return this.hzP.bEB() && this.hzQ.bEE();
    }

    public void bEG() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.hzQ != null) {
                this.hzQ.bEF();
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
        e.ns().postDelayed(this.hzT, 1000L);
        load();
    }

    private void load() {
        if (this.hzQ != null && !am.isEmpty(this.hzQ.getVideoPath())) {
            this.hzN.setVideoPath(this.hzQ.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.hzP != null) {
            this.hzP.cV(System.currentTimeMillis());
        }
        if (this.hzR >= 0) {
            this.hzN.seekTo(this.hzR);
        }
        this.hzN.start();
    }

    private View p(double d) {
        View inflate = LayoutInflater.from(this.hzL).inflate(d.h.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aq(this.hzL) * d)));
        this.hzN = (ScaleVideoView) inflate.findViewById(d.g.video);
        this.hzN.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.videosplash.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.ns().removeCallbacks(d.this.hzT);
                if (d.this.hzO != null) {
                    d.this.hzS = false;
                    d.this.hzO.onError();
                    return true;
                }
                return true;
            }
        });
        this.hzN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.videosplash.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.ns().removeCallbacks(d.this.hzT);
                if (d.this.hzO != null) {
                    d.this.hzS = false;
                    d.this.hzO.SV();
                }
            }
        });
        this.hzN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.videosplash.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.ns().removeCallbacks(d.this.hzT);
                d.this.hzN.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.videosplash.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.bEH();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.eXS = (TextView) inflate.findViewById(d.g.skip);
        this.eXS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videosplash.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.ns().removeCallbacks(d.this.hzT);
                if (d.this.hzO != null) {
                    d.this.hzS = false;
                    d.this.hzO.SV();
                }
                TiebaStatic.log(new ak("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        u uVar = new u();
        uVar.parseJson(string);
        final String Ge = uVar.Ge();
        this.hnX = inflate.findViewById(d.g.tip_container);
        this.hnX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videosplash.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12945"));
                if (!am.isEmpty(Ge)) {
                    d.this.hzS = false;
                    d.this.hzO.SV();
                    aw.Du().c(d.this.hzL.getPageContext(), new String[]{Ge});
                }
            }
        });
        this.hzM = (TextView) inflate.findViewById(d.g.tip_text);
        String Gf = uVar.Gf();
        if (am.isEmpty(Gf)) {
            Gf = this.hzL.getString(d.j.video_splash_tip_default);
        }
        this.hzM.setText(Gf);
        bEI();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEH() {
        if (this.hzN != null) {
            this.hzN.setBackgroundResource(0);
        }
    }

    private void bEI() {
        if (this.hzQ != null && this.hzQ.bEE()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.hzQ.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.hzN != null) {
                    this.hzN.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hzN != null) {
                    this.hzN.setBackgroundColor(this.hzL.getResources().getColor(d.C0140d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.hzS = true;
        if (this.hzN != null) {
            this.hzN.resume();
        }
    }

    public void onPause() {
        if (this.hzN != null) {
            this.hzR = this.hzN.getCurrentPosition();
            this.hzN.stopPlayback();
            if (this.hzS) {
                bEI();
            }
        }
    }

    public void onDestroy() {
        e.ns().removeCallbacks(this.hzT);
    }

    public void a(a aVar) {
        this.hzO = aVar;
    }
}

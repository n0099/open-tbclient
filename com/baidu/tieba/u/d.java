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
    private TextView chn;
    private TextView fjS;
    private ScaleVideoView hKo;
    private LogoActivity hMk;
    private a hMl;
    private int hMo;
    private View hzP;
    private View mRootView;
    private boolean hMp = true;
    private Runnable hMq = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hMl != null) {
                d.this.hMl.onError();
            }
        }
    };
    private com.baidu.tieba.u.a hMm = new com.baidu.tieba.u.a();
    private c hMn = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Ut();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.hMo = 0;
        this.hMk = logoActivity;
        this.hMo = 0;
    }

    public boolean bLP() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.hMm == null || this.hMn == null) {
            return false;
        }
        return this.hMm.bLP() && this.hMn.bLS();
    }

    public void bLU() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.hMn != null) {
                this.hMn.bLT();
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
        e.jG().postDelayed(this.hMq, 1000L);
        load();
    }

    private void load() {
        if (this.hMn != null && !ao.isEmpty(this.hMn.getVideoPath())) {
            this.hKo.setVideoPath(this.hMn.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.hMm != null) {
            this.hMm.dm(System.currentTimeMillis());
        }
        if (this.hMo >= 0) {
            this.hKo.seekTo(this.hMo);
        }
        this.hKo.start();
    }

    private View o(double d) {
        View inflate = LayoutInflater.from(this.hMk).inflate(e.h.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aQ(this.hMk) * d)));
        this.hKo = (ScaleVideoView) inflate.findViewById(e.g.video);
        this.hKo.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hMq);
                if (d.this.hMl != null) {
                    d.this.hMp = false;
                    d.this.hMl.onError();
                    return true;
                }
                return true;
            }
        });
        this.hKo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hMq);
                if (d.this.hMl != null) {
                    d.this.hMp = false;
                    d.this.hMl.Ut();
                }
            }
        });
        this.hKo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hMq);
                d.this.hKo.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.u.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.bLV();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.fjS = (TextView) inflate.findViewById(e.g.skip);
        this.fjS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hMq);
                if (d.this.hMl != null) {
                    d.this.hMp = false;
                    d.this.hMl.Ut();
                }
                TiebaStatic.log(new am("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        x xVar = new x();
        xVar.parseJson(string);
        final String Hc = xVar.Hc();
        this.hzP = inflate.findViewById(e.g.tip_container);
        this.hzP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12945"));
                if (!ao.isEmpty(Hc)) {
                    d.this.hMp = false;
                    d.this.hMl.Ut();
                    ay.Ef().c(d.this.hMk.getPageContext(), new String[]{Hc});
                }
            }
        });
        this.chn = (TextView) inflate.findViewById(e.g.tip_text);
        String Hd = xVar.Hd();
        if (ao.isEmpty(Hd)) {
            Hd = this.hMk.getString(e.j.video_splash_tip_default);
        }
        this.chn.setText(Hd);
        bLW();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLV() {
        if (this.hKo != null) {
            this.hKo.setBackgroundResource(0);
        }
    }

    private void bLW() {
        if (this.hMn != null && this.hMn.bLS()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.hMn.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.hKo != null) {
                    this.hKo.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hKo != null) {
                    this.hKo.setBackgroundColor(this.hMk.getResources().getColor(e.d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.hMp = true;
        if (this.hKo != null) {
            this.hKo.resume();
        }
    }

    public void onPause() {
        if (this.hKo != null) {
            this.hMo = this.hKo.getCurrentPosition();
            this.hKo.stopPlayback();
            if (this.hMp) {
                bLW();
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hMq);
    }

    public void a(a aVar) {
        this.hMl = aVar;
    }
}

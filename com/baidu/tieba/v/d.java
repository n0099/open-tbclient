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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class d {
    private TextView cig;
    private TextView fnD;
    private View hEh;
    private ScaleVideoView hOG;
    private LogoActivity hQC;
    private a hQD;
    private int hQG;
    private View mRootView;
    private boolean hQH = true;
    private Runnable hQI = new Runnable() { // from class: com.baidu.tieba.v.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hQD != null) {
                d.this.hQD.onError();
            }
        }
    };
    private com.baidu.tieba.v.a hQE = new com.baidu.tieba.v.a();
    private c hQF = new c();

    /* loaded from: classes.dex */
    public interface a {
        void UR();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.hQG = 0;
        this.hQC = logoActivity;
        this.hQG = 0;
    }

    public boolean bNm() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.hQE == null || this.hQF == null) {
            return false;
        }
        return this.hQE.bNm() && this.hQF.bNp();
    }

    public void bNr() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.hQF != null) {
                this.hQF.bNq();
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
        e.jG().postDelayed(this.hQI, 1000L);
        load();
    }

    private void load() {
        if (this.hQF != null && !ao.isEmpty(this.hQF.getVideoPath())) {
            this.hOG.setVideoPath(this.hQF.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.hQE != null) {
            this.hQE.dr(System.currentTimeMillis());
        }
        if (this.hQG >= 0) {
            this.hOG.seekTo(this.hQG);
        }
        this.hOG.start();
    }

    private View o(double d) {
        View inflate = LayoutInflater.from(this.hQC).inflate(e.h.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aQ(this.hQC) * d)));
        this.hOG = (ScaleVideoView) inflate.findViewById(e.g.video);
        this.hOG.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.v.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hQI);
                if (d.this.hQD != null) {
                    d.this.hQH = false;
                    d.this.hQD.onError();
                    return true;
                }
                return true;
            }
        });
        this.hOG.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.v.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hQI);
                if (d.this.hQD != null) {
                    d.this.hQH = false;
                    d.this.hQD.UR();
                }
            }
        });
        this.hOG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.v.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hQI);
                d.this.hOG.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.v.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.bNs();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.fnD = (TextView) inflate.findViewById(e.g.skip);
        this.fnD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hQI);
                if (d.this.hQD != null) {
                    d.this.hQH = false;
                    d.this.hQD.UR();
                }
                TiebaStatic.log(new am("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        y yVar = new y();
        yVar.parseJson(string);
        final String Hr = yVar.Hr();
        this.hEh = inflate.findViewById(e.g.tip_container);
        this.hEh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12945"));
                if (!ao.isEmpty(Hr)) {
                    d.this.hQH = false;
                    d.this.hQD.UR();
                    ay.Es().c(d.this.hQC.getPageContext(), new String[]{Hr});
                }
            }
        });
        this.cig = (TextView) inflate.findViewById(e.g.tip_text);
        String Hs = yVar.Hs();
        if (ao.isEmpty(Hs)) {
            Hs = this.hQC.getString(e.j.video_splash_tip_default);
        }
        this.cig.setText(Hs);
        bNt();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNs() {
        if (this.hOG != null) {
            this.hOG.setBackgroundResource(0);
        }
    }

    private void bNt() {
        if (this.hQF != null && this.hQF.bNp()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.hQF.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.hOG != null) {
                    this.hOG.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hOG != null) {
                    this.hOG.setBackgroundColor(this.hQC.getResources().getColor(e.d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.hQH = true;
        if (this.hOG != null) {
            this.hOG.resume();
        }
    }

    public void onPause() {
        if (this.hOG != null) {
            this.hQG = this.hOG.getCurrentPosition();
            this.hOG.stopPlayback();
            if (this.hQH) {
                bNt();
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hQI);
    }

    public void a(a aVar) {
        this.hQD = aVar;
    }
}

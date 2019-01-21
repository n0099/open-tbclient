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
    private TextView cih;
    private TextView fnE;
    private View hEi;
    private ScaleVideoView hOH;
    private LogoActivity hQD;
    private a hQE;
    private int hQH;
    private View mRootView;
    private boolean hQI = true;
    private Runnable hQJ = new Runnable() { // from class: com.baidu.tieba.v.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hQE != null) {
                d.this.hQE.onError();
            }
        }
    };
    private com.baidu.tieba.v.a hQF = new com.baidu.tieba.v.a();
    private c hQG = new c();

    /* loaded from: classes.dex */
    public interface a {
        void UR();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.hQH = 0;
        this.hQD = logoActivity;
        this.hQH = 0;
    }

    public boolean bNm() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.hQF == null || this.hQG == null) {
            return false;
        }
        return this.hQF.bNm() && this.hQG.bNp();
    }

    public void bNr() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.hQG != null) {
                this.hQG.bNq();
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
        e.jG().postDelayed(this.hQJ, 1000L);
        load();
    }

    private void load() {
        if (this.hQG != null && !ao.isEmpty(this.hQG.getVideoPath())) {
            this.hOH.setVideoPath(this.hQG.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.hQF != null) {
            this.hQF.dr(System.currentTimeMillis());
        }
        if (this.hQH >= 0) {
            this.hOH.seekTo(this.hQH);
        }
        this.hOH.start();
    }

    private View o(double d) {
        View inflate = LayoutInflater.from(this.hQD).inflate(e.h.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aQ(this.hQD) * d)));
        this.hOH = (ScaleVideoView) inflate.findViewById(e.g.video);
        this.hOH.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.v.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hQJ);
                if (d.this.hQE != null) {
                    d.this.hQI = false;
                    d.this.hQE.onError();
                    return true;
                }
                return true;
            }
        });
        this.hOH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.v.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hQJ);
                if (d.this.hQE != null) {
                    d.this.hQI = false;
                    d.this.hQE.UR();
                }
            }
        });
        this.hOH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.v.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hQJ);
                d.this.hOH.setMediaPlayer(mediaPlayer);
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
        this.fnE = (TextView) inflate.findViewById(e.g.skip);
        this.fnE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hQJ);
                if (d.this.hQE != null) {
                    d.this.hQI = false;
                    d.this.hQE.UR();
                }
                TiebaStatic.log(new am("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        y yVar = new y();
        yVar.parseJson(string);
        final String Hr = yVar.Hr();
        this.hEi = inflate.findViewById(e.g.tip_container);
        this.hEi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12945"));
                if (!ao.isEmpty(Hr)) {
                    d.this.hQI = false;
                    d.this.hQE.UR();
                    ay.Es().c(d.this.hQD.getPageContext(), new String[]{Hr});
                }
            }
        });
        this.cih = (TextView) inflate.findViewById(e.g.tip_text);
        String Hs = yVar.Hs();
        if (ao.isEmpty(Hs)) {
            Hs = this.hQD.getString(e.j.video_splash_tip_default);
        }
        this.cih.setText(Hs);
        bNt();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNs() {
        if (this.hOH != null) {
            this.hOH.setBackgroundResource(0);
        }
    }

    private void bNt() {
        if (this.hQG != null && this.hQG.bNp()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.hQG.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.hOH != null) {
                    this.hOH.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hOH != null) {
                    this.hOH.setBackgroundColor(this.hQD.getResources().getColor(e.d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.hQI = true;
        if (this.hOH != null) {
            this.hOH.resume();
        }
    }

    public void onPause() {
        if (this.hOH != null) {
            this.hQH = this.hOH.getCurrentPosition();
            this.hOH.stopPlayback();
            if (this.hQI) {
                bNt();
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hQJ);
    }

    public void a(a aVar) {
        this.hQE = aVar;
    }
}

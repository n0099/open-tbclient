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
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class d {
    private TextView cdh;
    private TextView fbG;
    private ScaleVideoView hBs;
    private LogoActivity hDp;
    private a hDq;
    private int hDt;
    private View hqU;
    private View mRootView;
    private boolean hDu = true;
    private Runnable hDv = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hDq != null) {
                d.this.hDq.onError();
            }
        }
    };
    private com.baidu.tieba.u.a hDr = new com.baidu.tieba.u.a();
    private c hDs = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Te();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.hDt = 0;
        this.hDp = logoActivity;
        this.hDt = 0;
    }

    public boolean bKl() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.hDr == null || this.hDs == null) {
            return false;
        }
        return this.hDr.bKl() && this.hDs.bKo();
    }

    public void bKq() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.hDs != null) {
                this.hDs.bKp();
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
        e.jI().postDelayed(this.hDv, 1000L);
        load();
    }

    private void load() {
        if (this.hDs != null && !ao.isEmpty(this.hDs.getVideoPath())) {
            this.hBs.setVideoPath(this.hDs.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.hDr != null) {
            this.hDr.dk(System.currentTimeMillis());
        }
        if (this.hDt >= 0) {
            this.hBs.seekTo(this.hDt);
        }
        this.hBs.start();
    }

    private View o(double d) {
        View inflate = LayoutInflater.from(this.hDp).inflate(e.h.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aQ(this.hDp) * d)));
        this.hBs = (ScaleVideoView) inflate.findViewById(e.g.video);
        this.hBs.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                com.baidu.adp.lib.g.e.jI().removeCallbacks(d.this.hDv);
                if (d.this.hDq != null) {
                    d.this.hDu = false;
                    d.this.hDq.onError();
                    return true;
                }
                return true;
            }
        });
        this.hBs.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                com.baidu.adp.lib.g.e.jI().removeCallbacks(d.this.hDv);
                if (d.this.hDq != null) {
                    d.this.hDu = false;
                    d.this.hDq.Te();
                }
            }
        });
        this.hBs.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                com.baidu.adp.lib.g.e.jI().removeCallbacks(d.this.hDv);
                d.this.hBs.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.u.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.bKr();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.fbG = (TextView) inflate.findViewById(e.g.skip);
        this.fbG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.e.jI().removeCallbacks(d.this.hDv);
                if (d.this.hDq != null) {
                    d.this.hDu = false;
                    d.this.hDq.Te();
                }
                TiebaStatic.log(new am("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        w wVar = new w();
        wVar.parseJson(string);
        final String FM = wVar.FM();
        this.hqU = inflate.findViewById(e.g.tip_container);
        this.hqU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12945"));
                if (!ao.isEmpty(FM)) {
                    d.this.hDu = false;
                    d.this.hDq.Te();
                    ay.CU().c(d.this.hDp.getPageContext(), new String[]{FM});
                }
            }
        });
        this.cdh = (TextView) inflate.findViewById(e.g.tip_text);
        String FN = wVar.FN();
        if (ao.isEmpty(FN)) {
            FN = this.hDp.getString(e.j.video_splash_tip_default);
        }
        this.cdh.setText(FN);
        bKs();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKr() {
        if (this.hBs != null) {
            this.hBs.setBackgroundResource(0);
        }
    }

    private void bKs() {
        if (this.hDs != null && this.hDs.bKo()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.hDs.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.hBs != null) {
                    this.hBs.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hBs != null) {
                    this.hBs.setBackgroundColor(this.hDp.getResources().getColor(e.d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.hDu = true;
        if (this.hBs != null) {
            this.hBs.resume();
        }
    }

    public void onPause() {
        if (this.hBs != null) {
            this.hDt = this.hBs.getCurrentPosition();
            this.hBs.stopPlayback();
            if (this.hDu) {
                bKs();
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.hDv);
    }

    public void a(a aVar) {
        this.hDq = aVar;
    }
}

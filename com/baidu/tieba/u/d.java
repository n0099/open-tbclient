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
    private TextView fbF;
    private ScaleVideoView hBr;
    private LogoActivity hDo;
    private a hDp;
    private int hDs;
    private View hqT;
    private View mRootView;
    private boolean hDt = true;
    private Runnable hDu = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hDp != null) {
                d.this.hDp.onError();
            }
        }
    };
    private com.baidu.tieba.u.a hDq = new com.baidu.tieba.u.a();
    private c hDr = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Te();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.hDs = 0;
        this.hDo = logoActivity;
        this.hDs = 0;
    }

    public boolean bKl() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.hDq == null || this.hDr == null) {
            return false;
        }
        return this.hDq.bKl() && this.hDr.bKo();
    }

    public void bKq() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.hDr != null) {
                this.hDr.bKp();
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
        e.jI().postDelayed(this.hDu, 1000L);
        load();
    }

    private void load() {
        if (this.hDr != null && !ao.isEmpty(this.hDr.getVideoPath())) {
            this.hBr.setVideoPath(this.hDr.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.hDq != null) {
            this.hDq.dk(System.currentTimeMillis());
        }
        if (this.hDs >= 0) {
            this.hBr.seekTo(this.hDs);
        }
        this.hBr.start();
    }

    private View o(double d) {
        View inflate = LayoutInflater.from(this.hDo).inflate(e.h.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aQ(this.hDo) * d)));
        this.hBr = (ScaleVideoView) inflate.findViewById(e.g.video);
        this.hBr.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                com.baidu.adp.lib.g.e.jI().removeCallbacks(d.this.hDu);
                if (d.this.hDp != null) {
                    d.this.hDt = false;
                    d.this.hDp.onError();
                    return true;
                }
                return true;
            }
        });
        this.hBr.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                com.baidu.adp.lib.g.e.jI().removeCallbacks(d.this.hDu);
                if (d.this.hDp != null) {
                    d.this.hDt = false;
                    d.this.hDp.Te();
                }
            }
        });
        this.hBr.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                com.baidu.adp.lib.g.e.jI().removeCallbacks(d.this.hDu);
                d.this.hBr.setMediaPlayer(mediaPlayer);
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
        this.fbF = (TextView) inflate.findViewById(e.g.skip);
        this.fbF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.e.jI().removeCallbacks(d.this.hDu);
                if (d.this.hDp != null) {
                    d.this.hDt = false;
                    d.this.hDp.Te();
                }
                TiebaStatic.log(new am("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        w wVar = new w();
        wVar.parseJson(string);
        final String FM = wVar.FM();
        this.hqT = inflate.findViewById(e.g.tip_container);
        this.hqT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12945"));
                if (!ao.isEmpty(FM)) {
                    d.this.hDt = false;
                    d.this.hDp.Te();
                    ay.CU().c(d.this.hDo.getPageContext(), new String[]{FM});
                }
            }
        });
        this.cdh = (TextView) inflate.findViewById(e.g.tip_text);
        String FN = wVar.FN();
        if (ao.isEmpty(FN)) {
            FN = this.hDo.getString(e.j.video_splash_tip_default);
        }
        this.cdh.setText(FN);
        bKs();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKr() {
        if (this.hBr != null) {
            this.hBr.setBackgroundResource(0);
        }
    }

    private void bKs() {
        if (this.hDr != null && this.hDr.bKo()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.hDr.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.hBr != null) {
                    this.hBr.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hBr != null) {
                    this.hBr.setBackgroundColor(this.hDo.getResources().getColor(e.d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.hDt = true;
        if (this.hBr != null) {
            this.hBr.resume();
        }
    }

    public void onPause() {
        if (this.hBr != null) {
            this.hDs = this.hBr.getCurrentPosition();
            this.hBr.stopPlayback();
            if (this.hDt) {
                bKs();
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.hDu);
    }

    public void a(a aVar) {
        this.hDp = aVar;
    }
}

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
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class d {
    private TextView chu;
    private TextView fmJ;
    private View hDa;
    private ScaleVideoView hNz;
    private LogoActivity hPv;
    private a hPw;
    private int hPz;
    private View mRootView;
    private boolean hPA = true;
    private Runnable hPB = new Runnable() { // from class: com.baidu.tieba.v.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hPw != null) {
                d.this.hPw.onError();
            }
        }
    };
    private com.baidu.tieba.v.a hPx = new com.baidu.tieba.v.a();
    private c hPy = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Uv();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.hPz = 0;
        this.hPv = logoActivity;
        this.hPz = 0;
    }

    public boolean bME() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.hPx == null || this.hPy == null) {
            return false;
        }
        return this.hPx.bME() && this.hPy.bMH();
    }

    public void bMJ() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.hPy != null) {
                this.hPy.bMI();
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
        e.jG().postDelayed(this.hPB, 1000L);
        load();
    }

    private void load() {
        if (this.hPy != null && !ao.isEmpty(this.hPy.getVideoPath())) {
            this.hNz.setVideoPath(this.hPy.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.hPx != null) {
            this.hPx.dr(System.currentTimeMillis());
        }
        if (this.hPz >= 0) {
            this.hNz.seekTo(this.hPz);
        }
        this.hNz.start();
    }

    private View o(double d) {
        View inflate = LayoutInflater.from(this.hPv).inflate(e.h.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aQ(this.hPv) * d)));
        this.hNz = (ScaleVideoView) inflate.findViewById(e.g.video);
        this.hNz.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.v.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hPB);
                if (d.this.hPw != null) {
                    d.this.hPA = false;
                    d.this.hPw.onError();
                    return true;
                }
                return true;
            }
        });
        this.hNz.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.v.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hPB);
                if (d.this.hPw != null) {
                    d.this.hPA = false;
                    d.this.hPw.Uv();
                }
            }
        });
        this.hNz.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.v.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hPB);
                d.this.hNz.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.v.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.bMK();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.fmJ = (TextView) inflate.findViewById(e.g.skip);
        this.fmJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.hPB);
                if (d.this.hPw != null) {
                    d.this.hPA = false;
                    d.this.hPw.Uv();
                }
                TiebaStatic.log(new am("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        x xVar = new x();
        xVar.parseJson(string);
        final String Hd = xVar.Hd();
        this.hDa = inflate.findViewById(e.g.tip_container);
        this.hDa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12945"));
                if (!ao.isEmpty(Hd)) {
                    d.this.hPA = false;
                    d.this.hPw.Uv();
                    ay.Ef().c(d.this.hPv.getPageContext(), new String[]{Hd});
                }
            }
        });
        this.chu = (TextView) inflate.findViewById(e.g.tip_text);
        String He = xVar.He();
        if (ao.isEmpty(He)) {
            He = this.hPv.getString(e.j.video_splash_tip_default);
        }
        this.chu.setText(He);
        bML();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMK() {
        if (this.hNz != null) {
            this.hNz.setBackgroundResource(0);
        }
    }

    private void bML() {
        if (this.hPy != null && this.hPy.bMH()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.hPy.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.hNz != null) {
                    this.hNz.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hNz != null) {
                    this.hNz.setBackgroundColor(this.hPv.getResources().getColor(e.d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.hPA = true;
        if (this.hNz != null) {
            this.hNz.resume();
        }
    }

    public void onPause() {
        if (this.hNz != null) {
            this.hPz = this.hNz.getCurrentPosition();
            this.hNz.stopPlayback();
            if (this.hPA) {
                bML();
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hPB);
    }

    public void a(a aVar) {
        this.hPw = aVar;
    }
}

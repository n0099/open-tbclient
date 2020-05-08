package com.baidu.tieba.w;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private TextView fBz;
    private TextView iGx;
    private View lhb;
    private ScaleVideoView lrm;
    private LogoActivity ltt;
    private a ltu;
    private int ltx;
    private View mRootView;
    private boolean lty = true;
    private Runnable ltz = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ltu != null) {
                d.this.ltu.onError();
            }
        }
    };
    private com.baidu.tieba.w.a ltv = new com.baidu.tieba.w.a();
    private c ltw = new c();

    /* loaded from: classes.dex */
    public interface a {
        void LJ();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.ltx = 0;
        this.ltt = logoActivity;
        this.ltx = 0;
    }

    public boolean des() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aNT().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.ltv == null || this.ltw == null) {
            return false;
        }
        return this.ltv.des() && this.ltw.deu();
    }

    public void dew() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aNT().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.ltw != null) {
                this.ltw.dev();
            }
            com.baidu.tbadk.core.sharedPref.b.aNT().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View x(double d) {
        if (this.mRootView == null) {
            this.mRootView = y(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new an("c12944"));
        e.lb().postDelayed(this.ltz, 1000L);
        load();
    }

    private void load() {
        if (this.ltw != null && !aq.isEmpty(this.ltw.getVideoPath())) {
            this.lrm.setVideoPath(this.ltw.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.ltv != null) {
            this.ltv.fv(System.currentTimeMillis());
        }
        if (this.ltx >= 0) {
            this.lrm.seekTo(this.ltx);
        }
        this.lrm.start();
    }

    private View y(double d) {
        View inflate = LayoutInflater.from(this.ltt).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.ltt) * d)));
        this.lrm = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.lrm.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.lb().removeCallbacks(d.this.ltz);
                if (d.this.ltu != null) {
                    d.this.lty = false;
                    d.this.ltu.onError();
                    return true;
                }
                return true;
            }
        });
        this.lrm.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.lb().removeCallbacks(d.this.ltz);
                if (d.this.ltu != null) {
                    d.this.lty = false;
                    d.this.ltu.LJ();
                }
            }
        });
        this.lrm.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.lb().removeCallbacks(d.this.ltz);
                d.this.lrm.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dex();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.iGx = (TextView) inflate.findViewById(R.id.skip);
        this.iGx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.lb().removeCallbacks(d.this.ltz);
                if (d.this.ltu != null) {
                    d.this.lty = false;
                    d.this.ltu.LJ();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ab abVar = new ab();
        abVar.parseJson(string);
        final String aSk = abVar.aSk();
        this.lhb = inflate.findViewById(R.id.tip_container);
        this.lhb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!aq.isEmpty(aSk)) {
                    d.this.lty = false;
                    d.this.ltu.LJ();
                    ba.aOV().b(d.this.ltt.getPageContext(), new String[]{aSk});
                }
            }
        });
        this.fBz = (TextView) inflate.findViewById(R.id.tip_text);
        String aSl = abVar.aSl();
        if (aq.isEmpty(aSl)) {
            aSl = this.ltt.getString(R.string.video_splash_tip_default);
        }
        this.fBz.setText(aSl);
        dey();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dex() {
        if (this.lrm != null) {
            this.lrm.setBackgroundResource(0);
        }
    }

    private void dey() {
        if (this.ltw != null && this.ltw.deu()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.ltw.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.lrm != null) {
                    this.lrm.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.lrm != null) {
                    this.lrm.setBackgroundColor(this.ltt.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.lty = true;
        if (this.lrm != null) {
            this.lrm.resume();
        }
    }

    public void onPause() {
        if (this.lrm != null) {
            this.ltx = this.lrm.getCurrentPosition();
            this.lrm.stopPlayback();
            if (this.lty) {
                dey();
            }
        }
    }

    public void onDestroy() {
        e.lb().removeCallbacks(this.ltz);
    }

    public void a(a aVar) {
        this.ltu = aVar;
    }
}

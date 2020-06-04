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
import com.baidu.tbadk.coreExtra.data.ac;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private TextView fPN;
    private TextView iWi;
    private View lAV;
    private ScaleVideoView lKZ;
    private LogoActivity lNe;
    private a lNf;
    private int lNi;
    private View mRootView;
    private boolean lNj = true;
    private Runnable lNk = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.lNf != null) {
                d.this.lNf.onError();
            }
        }
    };
    private com.baidu.tieba.w.a lNg = new com.baidu.tieba.w.a();
    private c lNh = new c();

    /* loaded from: classes.dex */
    public interface a {
        void NW();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.lNi = 0;
        this.lNe = logoActivity;
        this.lNi = 0;
    }

    public boolean dlX() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.lNg == null || this.lNh == null) {
            return false;
        }
        return this.lNg.dlX() && this.lNh.dlZ();
    }

    public void dmb() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.lNh != null) {
                this.lNh.dma();
            }
            com.baidu.tbadk.core.sharedPref.b.aTX().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View y(double d) {
        if (this.mRootView == null) {
            this.mRootView = z(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new an("c12944"));
        e.ld().postDelayed(this.lNk, 1000L);
        load();
    }

    private void load() {
        if (this.lNh != null && !aq.isEmpty(this.lNh.getVideoPath())) {
            this.lKZ.setVideoPath(this.lNh.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.lNg != null) {
            this.lNg.fv(System.currentTimeMillis());
        }
        if (this.lNi >= 0) {
            this.lKZ.seekTo(this.lNi);
        }
        this.lKZ.start();
    }

    private View z(double d) {
        View inflate = LayoutInflater.from(this.lNe).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.lNe) * d)));
        this.lKZ = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.lKZ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.ld().removeCallbacks(d.this.lNk);
                if (d.this.lNf != null) {
                    d.this.lNj = false;
                    d.this.lNf.onError();
                    return true;
                }
                return true;
            }
        });
        this.lKZ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.ld().removeCallbacks(d.this.lNk);
                if (d.this.lNf != null) {
                    d.this.lNj = false;
                    d.this.lNf.NW();
                }
            }
        });
        this.lKZ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.ld().removeCallbacks(d.this.lNk);
                d.this.lKZ.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dmc();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.iWi = (TextView) inflate.findViewById(R.id.skip);
        this.iWi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.ld().removeCallbacks(d.this.lNk);
                if (d.this.lNf != null) {
                    d.this.lNj = false;
                    d.this.lNf.NW();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ac acVar = new ac();
        acVar.parseJson(string);
        final String aYs = acVar.aYs();
        this.lAV = inflate.findViewById(R.id.tip_container);
        this.lAV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!aq.isEmpty(aYs)) {
                    d.this.lNj = false;
                    d.this.lNf.NW();
                    ba.aVa().b(d.this.lNe.getPageContext(), new String[]{aYs});
                }
            }
        });
        this.fPN = (TextView) inflate.findViewById(R.id.tip_text);
        String aYt = acVar.aYt();
        if (aq.isEmpty(aYt)) {
            aYt = this.lNe.getString(R.string.video_splash_tip_default);
        }
        this.fPN.setText(aYt);
        dmd();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmc() {
        if (this.lKZ != null) {
            this.lKZ.setBackgroundResource(0);
        }
    }

    private void dmd() {
        if (this.lNh != null && this.lNh.dlZ()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.lNh.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.lKZ != null) {
                    this.lKZ.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.lKZ != null) {
                    this.lKZ.setBackgroundColor(this.lNe.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.lNj = true;
        if (this.lKZ != null) {
            this.lKZ.resume();
        }
    }

    public void onPause() {
        if (this.lKZ != null) {
            this.lNi = this.lKZ.getCurrentPosition();
            this.lKZ.stopPlayback();
            if (this.lNj) {
                dmd();
            }
        }
    }

    public void onDestroy() {
        e.ld().removeCallbacks(this.lNk);
    }

    public void a(a aVar) {
        this.lNf = aVar;
    }
}

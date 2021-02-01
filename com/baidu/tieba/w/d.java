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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.data.ai;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private TextView hxD;
    private TextView kYh;
    private View mRootView;
    private View nKr;
    private ScaleVideoView nTL;
    private LogoActivity nVZ;
    private a nWa;
    private int nWd;
    private boolean nWe = true;
    private Runnable nWf = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nWa != null) {
                d.this.nWa.onError();
            }
        }
    };
    private com.baidu.tieba.w.a nWb = new com.baidu.tieba.w.a();
    private c nWc = new c();

    /* loaded from: classes.dex */
    public interface a {
        void bKg();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.nWd = 0;
        this.nVZ = logoActivity;
        this.nWd = 0;
    }

    public boolean dVI() {
        if (!(com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.nWb == null || this.nWc == null) {
            return false;
        }
        return this.nWb.dVI() && this.nWc.dVK();
    }

    public void dVM() {
        if (!(com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.nWc != null) {
                this.nWc.dVL();
            }
            com.baidu.tbadk.core.sharedPref.b.brQ().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View D(double d) {
        if (this.mRootView == null) {
            this.mRootView = E(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new ar("c12944"));
        e.mA().postDelayed(this.nWf, 1000L);
        load();
    }

    private void load() {
        if (this.nWc != null && !au.isEmpty(this.nWc.getVideoPath())) {
            this.nTL.setVideoPath(this.nWc.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.nWb != null) {
            this.nWb.hK(System.currentTimeMillis());
        }
        if (this.nWd >= 0) {
            this.nTL.seekTo(this.nWd);
        }
        this.nTL.start();
    }

    private View E(double d) {
        View inflate = LayoutInflater.from(this.nVZ).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.nVZ) * d)));
        this.nTL = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.nTL.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.mA().removeCallbacks(d.this.nWf);
                if (d.this.nWa != null) {
                    d.this.nWe = false;
                    d.this.nWa.onError();
                    return true;
                }
                return true;
            }
        });
        this.nTL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.mA().removeCallbacks(d.this.nWf);
                if (d.this.nWa != null) {
                    d.this.nWe = false;
                    d.this.nWa.bKg();
                }
            }
        });
        this.nTL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.mA().removeCallbacks(d.this.nWf);
                d.this.nTL.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dVN();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.kYh = (TextView) inflate.findViewById(R.id.skip);
        this.kYh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.mA().removeCallbacks(d.this.nWf);
                if (d.this.nWa != null) {
                    d.this.nWe = false;
                    d.this.nWa.bKg();
                }
                TiebaStatic.log(new ar("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ai aiVar = new ai();
        aiVar.parseJson(string);
        final String bwK = aiVar.bwK();
        this.nKr = inflate.findViewById(R.id.tip_container);
        this.nKr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12945"));
                if (!au.isEmpty(bwK)) {
                    d.this.nWe = false;
                    d.this.nWa.bKg();
                    bf.bsV().b(d.this.nVZ.getPageContext(), new String[]{bwK});
                }
            }
        });
        this.hxD = (TextView) inflate.findViewById(R.id.tip_text);
        String bwL = aiVar.bwL();
        if (au.isEmpty(bwL)) {
            bwL = this.nVZ.getString(R.string.video_splash_tip_default);
        }
        this.hxD.setText(bwL);
        dVO();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVN() {
        if (this.nTL != null) {
            this.nTL.setBackgroundResource(0);
        }
    }

    private void dVO() {
        if (this.nWc != null && this.nWc.dVK()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.nWc.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.nTL != null) {
                    this.nTL.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nTL != null) {
                    this.nTL.setBackgroundColor(this.nVZ.getResources().getColor(R.color.CAM_X0101));
                }
            }
        }
    }

    public void onResume() {
        this.nWe = true;
        if (this.nTL != null) {
            this.nTL.resume();
        }
    }

    public void onPause() {
        if (this.nTL != null) {
            this.nWd = this.nTL.getCurrentPosition();
            this.nTL.stopPlayback();
            if (this.nWe) {
                dVO();
            }
        }
    }

    public void onDestroy() {
        e.mA().removeCallbacks(this.nWf);
    }

    public void a(a aVar) {
        this.nWa = aVar;
    }
}

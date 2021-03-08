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
    private TextView hzA;
    private TextView lay;
    private View mRootView;
    private View nMW;
    private ScaleVideoView nWp;
    private LogoActivity nYD;
    private a nYE;
    private int nYH;
    private boolean nYI = true;
    private Runnable nYJ = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nYE != null) {
                d.this.nYE.onError();
            }
        }
    };
    private com.baidu.tieba.w.a nYF = new com.baidu.tieba.w.a();
    private c nYG = new c();

    /* loaded from: classes.dex */
    public interface a {
        void bKp();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.nYH = 0;
        this.nYD = logoActivity;
        this.nYH = 0;
    }

    public boolean dVY() {
        if (!(com.baidu.tbadk.core.sharedPref.b.brR().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.nYF == null || this.nYG == null) {
            return false;
        }
        return this.nYF.dVY() && this.nYG.dWa();
    }

    public void dWc() {
        if (!(com.baidu.tbadk.core.sharedPref.b.brR().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.nYG != null) {
                this.nYG.dWb();
            }
            com.baidu.tbadk.core.sharedPref.b.brR().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
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
        e.mA().postDelayed(this.nYJ, 1000L);
        load();
    }

    private void load() {
        if (this.nYG != null && !au.isEmpty(this.nYG.getVideoPath())) {
            this.nWp.setVideoPath(this.nYG.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.nYF != null) {
            this.nYF.hK(System.currentTimeMillis());
        }
        if (this.nYH >= 0) {
            this.nWp.seekTo(this.nYH);
        }
        this.nWp.start();
    }

    private View E(double d) {
        View inflate = LayoutInflater.from(this.nYD).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.nYD) * d)));
        this.nWp = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.nWp.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.mA().removeCallbacks(d.this.nYJ);
                if (d.this.nYE != null) {
                    d.this.nYI = false;
                    d.this.nYE.onError();
                    return true;
                }
                return true;
            }
        });
        this.nWp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.mA().removeCallbacks(d.this.nYJ);
                if (d.this.nYE != null) {
                    d.this.nYI = false;
                    d.this.nYE.bKp();
                }
            }
        });
        this.nWp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.mA().removeCallbacks(d.this.nYJ);
                d.this.nWp.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dWd();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.lay = (TextView) inflate.findViewById(R.id.skip);
        this.lay.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.mA().removeCallbacks(d.this.nYJ);
                if (d.this.nYE != null) {
                    d.this.nYI = false;
                    d.this.nYE.bKp();
                }
                TiebaStatic.log(new ar("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.brR().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ai aiVar = new ai();
        aiVar.parseJson(string);
        final String bwN = aiVar.bwN();
        this.nMW = inflate.findViewById(R.id.tip_container);
        this.nMW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12945"));
                if (!au.isEmpty(bwN)) {
                    d.this.nYI = false;
                    d.this.nYE.bKp();
                    bf.bsY().b(d.this.nYD.getPageContext(), new String[]{bwN});
                }
            }
        });
        this.hzA = (TextView) inflate.findViewById(R.id.tip_text);
        String bwO = aiVar.bwO();
        if (au.isEmpty(bwO)) {
            bwO = this.nYD.getString(R.string.video_splash_tip_default);
        }
        this.hzA.setText(bwO);
        dWe();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWd() {
        if (this.nWp != null) {
            this.nWp.setBackgroundResource(0);
        }
    }

    private void dWe() {
        if (this.nYG != null && this.nYG.dWa()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.nYG.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.nWp != null) {
                    this.nWp.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nWp != null) {
                    this.nWp.setBackgroundColor(this.nYD.getResources().getColor(R.color.CAM_X0101));
                }
            }
        }
    }

    public void onResume() {
        this.nYI = true;
        if (this.nWp != null) {
            this.nWp.resume();
        }
    }

    public void onPause() {
        if (this.nWp != null) {
            this.nYH = this.nWp.getCurrentPosition();
            this.nWp.stopPlayback();
            if (this.nYI) {
                dWe();
            }
        }
    }

    public void onDestroy() {
        e.mA().removeCallbacks(this.nYJ);
    }

    public void a(a aVar) {
        this.nYE = aVar;
    }
}

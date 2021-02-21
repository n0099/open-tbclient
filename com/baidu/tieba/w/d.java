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
    private TextView hxR;
    private TextView kYv;
    private View mRootView;
    private View nKR;
    private ScaleVideoView nUl;
    private a nWA;
    private int nWD;
    private LogoActivity nWz;
    private boolean nWE = true;
    private Runnable nWF = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nWA != null) {
                d.this.nWA.onError();
            }
        }
    };
    private com.baidu.tieba.w.a nWB = new com.baidu.tieba.w.a();
    private c nWC = new c();

    /* loaded from: classes.dex */
    public interface a {
        void bKl();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.nWD = 0;
        this.nWz = logoActivity;
        this.nWD = 0;
    }

    public boolean dVQ() {
        if (!(com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.nWB == null || this.nWC == null) {
            return false;
        }
        return this.nWB.dVQ() && this.nWC.dVS();
    }

    public void dVU() {
        if (!(com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.nWC != null) {
                this.nWC.dVT();
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
        e.mA().postDelayed(this.nWF, 1000L);
        load();
    }

    private void load() {
        if (this.nWC != null && !au.isEmpty(this.nWC.getVideoPath())) {
            this.nUl.setVideoPath(this.nWC.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.nWB != null) {
            this.nWB.hK(System.currentTimeMillis());
        }
        if (this.nWD >= 0) {
            this.nUl.seekTo(this.nWD);
        }
        this.nUl.start();
    }

    private View E(double d) {
        View inflate = LayoutInflater.from(this.nWz).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.nWz) * d)));
        this.nUl = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.nUl.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.mA().removeCallbacks(d.this.nWF);
                if (d.this.nWA != null) {
                    d.this.nWE = false;
                    d.this.nWA.onError();
                    return true;
                }
                return true;
            }
        });
        this.nUl.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.mA().removeCallbacks(d.this.nWF);
                if (d.this.nWA != null) {
                    d.this.nWE = false;
                    d.this.nWA.bKl();
                }
            }
        });
        this.nUl.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.mA().removeCallbacks(d.this.nWF);
                d.this.nUl.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dVV();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.kYv = (TextView) inflate.findViewById(R.id.skip);
        this.kYv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.mA().removeCallbacks(d.this.nWF);
                if (d.this.nWA != null) {
                    d.this.nWE = false;
                    d.this.nWA.bKl();
                }
                TiebaStatic.log(new ar("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ai aiVar = new ai();
        aiVar.parseJson(string);
        final String bwK = aiVar.bwK();
        this.nKR = inflate.findViewById(R.id.tip_container);
        this.nKR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12945"));
                if (!au.isEmpty(bwK)) {
                    d.this.nWE = false;
                    d.this.nWA.bKl();
                    bf.bsV().b(d.this.nWz.getPageContext(), new String[]{bwK});
                }
            }
        });
        this.hxR = (TextView) inflate.findViewById(R.id.tip_text);
        String bwL = aiVar.bwL();
        if (au.isEmpty(bwL)) {
            bwL = this.nWz.getString(R.string.video_splash_tip_default);
        }
        this.hxR.setText(bwL);
        dVW();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVV() {
        if (this.nUl != null) {
            this.nUl.setBackgroundResource(0);
        }
    }

    private void dVW() {
        if (this.nWC != null && this.nWC.dVS()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.nWC.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.nUl != null) {
                    this.nUl.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nUl != null) {
                    this.nUl.setBackgroundColor(this.nWz.getResources().getColor(R.color.CAM_X0101));
                }
            }
        }
    }

    public void onResume() {
        this.nWE = true;
        if (this.nUl != null) {
            this.nUl.resume();
        }
    }

    public void onPause() {
        if (this.nUl != null) {
            this.nWD = this.nUl.getCurrentPosition();
            this.nUl.stopPlayback();
            if (this.nWE) {
                dVW();
            }
        }
    }

    public void onDestroy() {
        e.mA().removeCallbacks(this.nWF);
    }

    public void a(a aVar) {
        this.nWA = aVar;
    }
}

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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.data.ai;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private TextView gKT;
    private TextView kje;
    private View mRootView;
    private View mTx;
    private ScaleVideoView ndH;
    private LogoActivity nfM;
    private a nfN;
    private int nfQ;
    private boolean nfR = true;
    private Runnable nfS = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nfN != null) {
                d.this.nfN.onError();
            }
        }
    };
    private com.baidu.tieba.w.a nfO = new com.baidu.tieba.w.a();
    private c nfP = new c();

    /* loaded from: classes.dex */
    public interface a {
        void XT();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.nfQ = 0;
        this.nfM = logoActivity;
        this.nfQ = 0;
    }

    public boolean dMG() {
        if (!(com.baidu.tbadk.core.sharedPref.b.blO().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.nfO == null || this.nfP == null) {
            return false;
        }
        return this.nfO.dMG() && this.nfP.dMI();
    }

    public void dMK() {
        if (!(com.baidu.tbadk.core.sharedPref.b.blO().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.nfP != null) {
                this.nfP.dMJ();
            }
            com.baidu.tbadk.core.sharedPref.b.blO().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View I(double d) {
        if (this.mRootView == null) {
            this.mRootView = J(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new aq("c12944"));
        e.mY().postDelayed(this.nfS, 1000L);
        load();
    }

    private void load() {
        if (this.nfP != null && !at.isEmpty(this.nfP.getVideoPath())) {
            this.ndH.setVideoPath(this.nfP.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.nfO != null) {
            this.nfO.gG(System.currentTimeMillis());
        }
        if (this.nfQ >= 0) {
            this.ndH.seekTo(this.nfQ);
        }
        this.ndH.start();
    }

    private View J(double d) {
        View inflate = LayoutInflater.from(this.nfM).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.nfM) * d)));
        this.ndH = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.ndH.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.mY().removeCallbacks(d.this.nfS);
                if (d.this.nfN != null) {
                    d.this.nfR = false;
                    d.this.nfN.onError();
                    return true;
                }
                return true;
            }
        });
        this.ndH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.mY().removeCallbacks(d.this.nfS);
                if (d.this.nfN != null) {
                    d.this.nfR = false;
                    d.this.nfN.XT();
                }
            }
        });
        this.ndH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.mY().removeCallbacks(d.this.nfS);
                d.this.ndH.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dML();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.kje = (TextView) inflate.findViewById(R.id.skip);
        this.kje.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.mY().removeCallbacks(d.this.nfS);
                if (d.this.nfN != null) {
                    d.this.nfR = false;
                    d.this.nfN.XT();
                }
                TiebaStatic.log(new aq("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.blO().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ai aiVar = new ai();
        aiVar.parseJson(string);
        final String bqI = aiVar.bqI();
        this.mTx = inflate.findViewById(R.id.tip_container);
        this.mTx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12945"));
                if (!at.isEmpty(bqI)) {
                    d.this.nfR = false;
                    d.this.nfN.XT();
                    be.bmY().b(d.this.nfM.getPageContext(), new String[]{bqI});
                }
            }
        });
        this.gKT = (TextView) inflate.findViewById(R.id.tip_text);
        String bqJ = aiVar.bqJ();
        if (at.isEmpty(bqJ)) {
            bqJ = this.nfM.getString(R.string.video_splash_tip_default);
        }
        this.gKT.setText(bqJ);
        dMM();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dML() {
        if (this.ndH != null) {
            this.ndH.setBackgroundResource(0);
        }
    }

    private void dMM() {
        if (this.nfP != null && this.nfP.dMI()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.nfP.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.ndH != null) {
                    this.ndH.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.ndH != null) {
                    this.ndH.setBackgroundColor(this.nfM.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.nfR = true;
        if (this.ndH != null) {
            this.ndH.resume();
        }
    }

    public void onPause() {
        if (this.ndH != null) {
            this.nfQ = this.ndH.getCurrentPosition();
            this.ndH.stopPlayback();
            if (this.nfR) {
                dMM();
            }
        }
    }

    public void onDestroy() {
        e.mY().removeCallbacks(this.nfS);
    }

    public void a(a aVar) {
        this.nfN = aVar;
    }
}

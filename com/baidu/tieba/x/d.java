package com.baidu.tieba.x;

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
    private TextView hmc;
    private TextView kPd;
    private View mRootView;
    private View nBe;
    private ScaleVideoView nLm;
    private LogoActivity nNq;
    private a nNr;
    private int nNu;
    private boolean nNv = true;
    private Runnable nNw = new Runnable() { // from class: com.baidu.tieba.x.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nNr != null) {
                d.this.nNr.onError();
            }
        }
    };
    private com.baidu.tieba.x.a nNs = new com.baidu.tieba.x.a();
    private c nNt = new c();

    /* loaded from: classes.dex */
    public interface a {
        void aeL();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.nNu = 0;
        this.nNq = logoActivity;
        this.nNu = 0;
    }

    public boolean dXJ() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.nNs == null || this.nNt == null) {
            return false;
        }
        return this.nNs.dXJ() && this.nNt.dXL();
    }

    public void dXN() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.nNt != null) {
                this.nNt.dXM();
            }
            com.baidu.tbadk.core.sharedPref.b.bsO().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View K(double d) {
        if (this.mRootView == null) {
            this.mRootView = L(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new ar("c12944"));
        e.mY().postDelayed(this.nNw, 1000L);
        load();
    }

    private void load() {
        if (this.nNt != null && !au.isEmpty(this.nNt.getVideoPath())) {
            this.nLm.setVideoPath(this.nNt.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.nNs != null) {
            this.nNs.hL(System.currentTimeMillis());
        }
        if (this.nNu >= 0) {
            this.nLm.seekTo(this.nNu);
        }
        this.nLm.start();
    }

    private View L(double d) {
        View inflate = LayoutInflater.from(this.nNq).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.nNq) * d)));
        this.nLm = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.nLm.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.x.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.mY().removeCallbacks(d.this.nNw);
                if (d.this.nNr != null) {
                    d.this.nNv = false;
                    d.this.nNr.onError();
                    return true;
                }
                return true;
            }
        });
        this.nLm.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.x.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.mY().removeCallbacks(d.this.nNw);
                if (d.this.nNr != null) {
                    d.this.nNv = false;
                    d.this.nNr.aeL();
                }
            }
        });
        this.nLm.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.x.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.mY().removeCallbacks(d.this.nNw);
                d.this.nLm.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.x.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dXO();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.kPd = (TextView) inflate.findViewById(R.id.skip);
        this.kPd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.x.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.mY().removeCallbacks(d.this.nNw);
                if (d.this.nNr != null) {
                    d.this.nNv = false;
                    d.this.nNr.aeL();
                }
                TiebaStatic.log(new ar("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ai aiVar = new ai();
        aiVar.parseJson(string);
        final String bxR = aiVar.bxR();
        this.nBe = inflate.findViewById(R.id.tip_container);
        this.nBe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.x.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12945"));
                if (!au.isEmpty(bxR)) {
                    d.this.nNv = false;
                    d.this.nNr.aeL();
                    bf.bua().b(d.this.nNq.getPageContext(), new String[]{bxR});
                }
            }
        });
        this.hmc = (TextView) inflate.findViewById(R.id.tip_text);
        String bxS = aiVar.bxS();
        if (au.isEmpty(bxS)) {
            bxS = this.nNq.getString(R.string.video_splash_tip_default);
        }
        this.hmc.setText(bxS);
        dXP();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXO() {
        if (this.nLm != null) {
            this.nLm.setBackgroundResource(0);
        }
    }

    private void dXP() {
        if (this.nNt != null && this.nNt.dXL()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.nNt.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.nLm != null) {
                    this.nLm.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nLm != null) {
                    this.nLm.setBackgroundColor(this.nNq.getResources().getColor(R.color.CAM_X0101));
                }
            }
        }
    }

    public void onResume() {
        this.nNv = true;
        if (this.nLm != null) {
            this.nLm.resume();
        }
    }

    public void onPause() {
        if (this.nLm != null) {
            this.nNu = this.nLm.getCurrentPosition();
            this.nLm.stopPlayback();
            if (this.nNv) {
                dXP();
            }
        }
    }

    public void onDestroy() {
        e.mY().removeCallbacks(this.nNw);
    }

    public void a(a aVar) {
        this.nNr = aVar;
    }
}

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
    private TextView hme;
    private TextView kPf;
    private View mRootView;
    private View nBg;
    private ScaleVideoView nLo;
    private LogoActivity nNs;
    private a nNt;
    private int nNw;
    private boolean nNx = true;
    private Runnable nNy = new Runnable() { // from class: com.baidu.tieba.x.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nNt != null) {
                d.this.nNt.onError();
            }
        }
    };
    private com.baidu.tieba.x.a nNu = new com.baidu.tieba.x.a();
    private c nNv = new c();

    /* loaded from: classes.dex */
    public interface a {
        void aeL();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.nNw = 0;
        this.nNs = logoActivity;
        this.nNw = 0;
    }

    public boolean dXK() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.nNu == null || this.nNv == null) {
            return false;
        }
        return this.nNu.dXK() && this.nNv.dXM();
    }

    public void dXO() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.nNv != null) {
                this.nNv.dXN();
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
        e.mY().postDelayed(this.nNy, 1000L);
        load();
    }

    private void load() {
        if (this.nNv != null && !au.isEmpty(this.nNv.getVideoPath())) {
            this.nLo.setVideoPath(this.nNv.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.nNu != null) {
            this.nNu.hL(System.currentTimeMillis());
        }
        if (this.nNw >= 0) {
            this.nLo.seekTo(this.nNw);
        }
        this.nLo.start();
    }

    private View L(double d) {
        View inflate = LayoutInflater.from(this.nNs).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.nNs) * d)));
        this.nLo = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.nLo.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.x.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.mY().removeCallbacks(d.this.nNy);
                if (d.this.nNt != null) {
                    d.this.nNx = false;
                    d.this.nNt.onError();
                    return true;
                }
                return true;
            }
        });
        this.nLo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.x.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.mY().removeCallbacks(d.this.nNy);
                if (d.this.nNt != null) {
                    d.this.nNx = false;
                    d.this.nNt.aeL();
                }
            }
        });
        this.nLo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.x.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.mY().removeCallbacks(d.this.nNy);
                d.this.nLo.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.x.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dXP();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.kPf = (TextView) inflate.findViewById(R.id.skip);
        this.kPf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.x.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.mY().removeCallbacks(d.this.nNy);
                if (d.this.nNt != null) {
                    d.this.nNx = false;
                    d.this.nNt.aeL();
                }
                TiebaStatic.log(new ar("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ai aiVar = new ai();
        aiVar.parseJson(string);
        final String bxR = aiVar.bxR();
        this.nBg = inflate.findViewById(R.id.tip_container);
        this.nBg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.x.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12945"));
                if (!au.isEmpty(bxR)) {
                    d.this.nNx = false;
                    d.this.nNt.aeL();
                    bf.bua().b(d.this.nNs.getPageContext(), new String[]{bxR});
                }
            }
        });
        this.hme = (TextView) inflate.findViewById(R.id.tip_text);
        String bxS = aiVar.bxS();
        if (au.isEmpty(bxS)) {
            bxS = this.nNs.getString(R.string.video_splash_tip_default);
        }
        this.hme.setText(bxS);
        dXQ();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXP() {
        if (this.nLo != null) {
            this.nLo.setBackgroundResource(0);
        }
    }

    private void dXQ() {
        if (this.nNv != null && this.nNv.dXM()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.nNv.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.nLo != null) {
                    this.nLo.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nLo != null) {
                    this.nLo.setBackgroundColor(this.nNs.getResources().getColor(R.color.CAM_X0101));
                }
            }
        }
    }

    public void onResume() {
        this.nNx = true;
        if (this.nLo != null) {
            this.nLo.resume();
        }
    }

    public void onPause() {
        if (this.nLo != null) {
            this.nNw = this.nLo.getCurrentPosition();
            this.nLo.stopPlayback();
            if (this.nNx) {
                dXQ();
            }
        }
    }

    public void onDestroy() {
        e.mY().removeCallbacks(this.nNy);
    }

    public void a(a aVar) {
        this.nNt = aVar;
    }
}

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
    private TextView hxZ;
    private TextView kUK;
    private View mRootView;
    private View nFm;
    private ScaleVideoView nOJ;
    private LogoActivity nQN;
    private a nQO;
    private int nQR;
    private boolean nQS = true;
    private Runnable nQT = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nQO != null) {
                d.this.nQO.onError();
            }
        }
    };
    private com.baidu.tieba.w.a nQP = new com.baidu.tieba.w.a();
    private c nQQ = new c();

    /* loaded from: classes.dex */
    public interface a {
        void agH();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.nQR = 0;
        this.nQN = logoActivity;
        this.nQR = 0;
    }

    public boolean dXn() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bvq().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.nQP == null || this.nQQ == null) {
            return false;
        }
        return this.nQP.dXn() && this.nQQ.dXp();
    }

    public void dXr() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bvq().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.nQQ != null) {
                this.nQQ.dXq();
            }
            com.baidu.tbadk.core.sharedPref.b.bvq().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View J(double d) {
        if (this.mRootView == null) {
            this.mRootView = K(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new aq("c12944"));
        e.mB().postDelayed(this.nQT, 1000L);
        load();
    }

    private void load() {
        if (this.nQQ != null && !at.isEmpty(this.nQQ.getVideoPath())) {
            this.nOJ.setVideoPath(this.nQQ.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.nQP != null) {
            this.nQP.hF(System.currentTimeMillis());
        }
        if (this.nQR >= 0) {
            this.nOJ.seekTo(this.nQR);
        }
        this.nOJ.start();
    }

    private View K(double d) {
        View inflate = LayoutInflater.from(this.nQN).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.nQN) * d)));
        this.nOJ = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.nOJ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.mB().removeCallbacks(d.this.nQT);
                if (d.this.nQO != null) {
                    d.this.nQS = false;
                    d.this.nQO.onError();
                    return true;
                }
                return true;
            }
        });
        this.nOJ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.mB().removeCallbacks(d.this.nQT);
                if (d.this.nQO != null) {
                    d.this.nQS = false;
                    d.this.nQO.agH();
                }
            }
        });
        this.nOJ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.mB().removeCallbacks(d.this.nQT);
                d.this.nOJ.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dXs();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.kUK = (TextView) inflate.findViewById(R.id.skip);
        this.kUK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.mB().removeCallbacks(d.this.nQT);
                if (d.this.nQO != null) {
                    d.this.nQS = false;
                    d.this.nQO.agH();
                }
                TiebaStatic.log(new aq("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.bvq().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ai aiVar = new ai();
        aiVar.parseJson(string);
        final String bAl = aiVar.bAl();
        this.nFm = inflate.findViewById(R.id.tip_container);
        this.nFm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12945"));
                if (!at.isEmpty(bAl)) {
                    d.this.nQS = false;
                    d.this.nQO.agH();
                    be.bwu().b(d.this.nQN.getPageContext(), new String[]{bAl});
                }
            }
        });
        this.hxZ = (TextView) inflate.findViewById(R.id.tip_text);
        String bAm = aiVar.bAm();
        if (at.isEmpty(bAm)) {
            bAm = this.nQN.getString(R.string.video_splash_tip_default);
        }
        this.hxZ.setText(bAm);
        dXt();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXs() {
        if (this.nOJ != null) {
            this.nOJ.setBackgroundResource(0);
        }
    }

    private void dXt() {
        if (this.nQQ != null && this.nQQ.dXp()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.nQQ.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.nOJ != null) {
                    this.nOJ.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nOJ != null) {
                    this.nOJ.setBackgroundColor(this.nQN.getResources().getColor(R.color.CAM_X0101));
                }
            }
        }
    }

    public void onResume() {
        this.nQS = true;
        if (this.nOJ != null) {
            this.nOJ.resume();
        }
    }

    public void onPause() {
        if (this.nOJ != null) {
            this.nQR = this.nOJ.getCurrentPosition();
            this.nOJ.stopPlayback();
            if (this.nQS) {
                dXt();
            }
        }
    }

    public void onDestroy() {
        e.mB().removeCallbacks(this.nQT);
    }

    public void a(a aVar) {
        this.nQO = aVar;
    }
}

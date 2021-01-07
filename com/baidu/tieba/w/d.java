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
    private View nFl;
    private ScaleVideoView nOI;
    private LogoActivity nQM;
    private a nQN;
    private int nQQ;
    private boolean nQR = true;
    private Runnable nQS = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nQN != null) {
                d.this.nQN.onError();
            }
        }
    };
    private com.baidu.tieba.w.a nQO = new com.baidu.tieba.w.a();
    private c nQP = new c();

    /* loaded from: classes.dex */
    public interface a {
        void agI();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.nQQ = 0;
        this.nQM = logoActivity;
        this.nQQ = 0;
    }

    public boolean dXo() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bvr().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.nQO == null || this.nQP == null) {
            return false;
        }
        return this.nQO.dXo() && this.nQP.dXq();
    }

    public void dXs() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bvr().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.nQP != null) {
                this.nQP.dXr();
            }
            com.baidu.tbadk.core.sharedPref.b.bvr().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
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
        e.mB().postDelayed(this.nQS, 1000L);
        load();
    }

    private void load() {
        if (this.nQP != null && !at.isEmpty(this.nQP.getVideoPath())) {
            this.nOI.setVideoPath(this.nQP.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.nQO != null) {
            this.nQO.hF(System.currentTimeMillis());
        }
        if (this.nQQ >= 0) {
            this.nOI.seekTo(this.nQQ);
        }
        this.nOI.start();
    }

    private View K(double d) {
        View inflate = LayoutInflater.from(this.nQM).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.nQM) * d)));
        this.nOI = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.nOI.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.mB().removeCallbacks(d.this.nQS);
                if (d.this.nQN != null) {
                    d.this.nQR = false;
                    d.this.nQN.onError();
                    return true;
                }
                return true;
            }
        });
        this.nOI.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.mB().removeCallbacks(d.this.nQS);
                if (d.this.nQN != null) {
                    d.this.nQR = false;
                    d.this.nQN.agI();
                }
            }
        });
        this.nOI.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.mB().removeCallbacks(d.this.nQS);
                d.this.nOI.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dXt();
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
                e.mB().removeCallbacks(d.this.nQS);
                if (d.this.nQN != null) {
                    d.this.nQR = false;
                    d.this.nQN.agI();
                }
                TiebaStatic.log(new aq("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.bvr().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ai aiVar = new ai();
        aiVar.parseJson(string);
        final String bAm = aiVar.bAm();
        this.nFl = inflate.findViewById(R.id.tip_container);
        this.nFl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12945"));
                if (!at.isEmpty(bAm)) {
                    d.this.nQR = false;
                    d.this.nQN.agI();
                    be.bwv().b(d.this.nQM.getPageContext(), new String[]{bAm});
                }
            }
        });
        this.hxZ = (TextView) inflate.findViewById(R.id.tip_text);
        String bAn = aiVar.bAn();
        if (at.isEmpty(bAn)) {
            bAn = this.nQM.getString(R.string.video_splash_tip_default);
        }
        this.hxZ.setText(bAn);
        dXu();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXt() {
        if (this.nOI != null) {
            this.nOI.setBackgroundResource(0);
        }
    }

    private void dXu() {
        if (this.nQP != null && this.nQP.dXq()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.nQP.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.nOI != null) {
                    this.nOI.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nOI != null) {
                    this.nOI.setBackgroundColor(this.nQM.getResources().getColor(R.color.CAM_X0101));
                }
            }
        }
    }

    public void onResume() {
        this.nQR = true;
        if (this.nOI != null) {
            this.nOI.resume();
        }
    }

    public void onPause() {
        if (this.nOI != null) {
            this.nQQ = this.nOI.getCurrentPosition();
            this.nOI.stopPlayback();
            if (this.nQR) {
                dXu();
            }
        }
    }

    public void onDestroy() {
        e.mB().removeCallbacks(this.nQS);
    }

    public void a(a aVar) {
        this.nQN = aVar;
    }
}

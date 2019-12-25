package com.baidu.tieba.v;

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
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private TextView eRb;
    private TextView hPk;
    private ScaleVideoView kAj;
    private LogoActivity kCK;
    private a kCL;
    private int kCO;
    private View kqn;
    private View mRootView;
    private boolean kCP = true;
    private Runnable kCQ = new Runnable() { // from class: com.baidu.tieba.v.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.kCL != null) {
                d.this.kCL.onError();
            }
        }
    };
    private com.baidu.tieba.v.a kCM = new com.baidu.tieba.v.a();
    private c kCN = new c();

    /* loaded from: classes.dex */
    public interface a {
        void aTw();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.kCO = 0;
        this.kCK = logoActivity;
        this.kCO = 0;
    }

    public boolean cQL() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aCY().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.kCM == null || this.kCN == null) {
            return false;
        }
        return this.kCM.cQL() && this.kCN.cQN();
    }

    public void cQO() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aCY().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.kCN != null) {
                this.kCN.deleteVideo();
            }
            com.baidu.tbadk.core.sharedPref.b.aCY().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View r(double d) {
        if (this.mRootView == null) {
            this.mRootView = s(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new an("c12944"));
        e.gy().postDelayed(this.kCQ, 1000L);
        load();
    }

    private void load() {
        if (this.kCN != null && !aq.isEmpty(this.kCN.getVideoPath())) {
            this.kAj.setVideoPath(this.kCN.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.kCM != null) {
            this.kCM.eF(System.currentTimeMillis());
        }
        if (this.kCO >= 0) {
            this.kAj.seekTo(this.kCO);
        }
        this.kAj.start();
    }

    private View s(double d) {
        View inflate = LayoutInflater.from(this.kCK).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.kCK) * d)));
        this.kAj = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.kAj.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.v.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.gy().removeCallbacks(d.this.kCQ);
                if (d.this.kCL != null) {
                    d.this.kCP = false;
                    d.this.kCL.onError();
                    return true;
                }
                return true;
            }
        });
        this.kAj.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.v.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.gy().removeCallbacks(d.this.kCQ);
                if (d.this.kCL != null) {
                    d.this.kCP = false;
                    d.this.kCL.aTw();
                }
            }
        });
        this.kAj.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.v.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.gy().removeCallbacks(d.this.kCQ);
                d.this.kAj.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.v.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.cQP();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.hPk = (TextView) inflate.findViewById(R.id.skip);
        this.hPk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.gy().removeCallbacks(d.this.kCQ);
                if (d.this.kCL != null) {
                    d.this.kCP = false;
                    d.this.kCL.aTw();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        z zVar = new z();
        zVar.parseJson(string);
        final String aGW = zVar.aGW();
        this.kqn = inflate.findViewById(R.id.tip_container);
        this.kqn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!aq.isEmpty(aGW)) {
                    d.this.kCP = false;
                    d.this.kCL.aTw();
                    ba.aEa().b(d.this.kCK.getPageContext(), new String[]{aGW});
                }
            }
        });
        this.eRb = (TextView) inflate.findViewById(R.id.tip_text);
        String aGX = zVar.aGX();
        if (aq.isEmpty(aGX)) {
            aGX = this.kCK.getString(R.string.video_splash_tip_default);
        }
        this.eRb.setText(aGX);
        cQQ();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQP() {
        if (this.kAj != null) {
            this.kAj.setBackgroundResource(0);
        }
    }

    private void cQQ() {
        if (this.kCN != null && this.kCN.cQN()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.kCN.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.kAj != null) {
                    this.kAj.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.kAj != null) {
                    this.kAj.setBackgroundColor(this.kCK.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.kCP = true;
        if (this.kAj != null) {
            this.kAj.resume();
        }
    }

    public void onPause() {
        if (this.kAj != null) {
            this.kCO = this.kAj.getCurrentPosition();
            this.kAj.stopPlayback();
            if (this.kCP) {
                cQQ();
            }
        }
    }

    public void onDestroy() {
        e.gy().removeCallbacks(this.kCQ);
    }

    public void a(a aVar) {
        this.kCL = aVar;
    }
}

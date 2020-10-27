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
    private TextView gWI;
    private TextView kvB;
    private View mRootView;
    private View nfY;
    private ScaleVideoView nqj;
    private LogoActivity nsn;
    private a nso;
    private int nsr;
    private boolean nss = true;
    private Runnable nst = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nso != null) {
                d.this.nso.onError();
            }
        }
    };
    private com.baidu.tieba.w.a nsp = new com.baidu.tieba.w.a();
    private c nsq = new c();

    /* loaded from: classes.dex */
    public interface a {
        void ZN();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.nsr = 0;
        this.nsn = logoActivity;
        this.nsr = 0;
    }

    public boolean dPO() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bnH().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.nsp == null || this.nsq == null) {
            return false;
        }
        return this.nsp.dPO() && this.nsq.dPQ();
    }

    public void dPS() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bnH().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.nsq != null) {
                this.nsq.dPR();
            }
            com.baidu.tbadk.core.sharedPref.b.bnH().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
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
        e.mY().postDelayed(this.nst, 1000L);
        load();
    }

    private void load() {
        if (this.nsq != null && !at.isEmpty(this.nsq.getVideoPath())) {
            this.nqj.setVideoPath(this.nsq.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.nsp != null) {
            this.nsp.gH(System.currentTimeMillis());
        }
        if (this.nsr >= 0) {
            this.nqj.seekTo(this.nsr);
        }
        this.nqj.start();
    }

    private View K(double d) {
        View inflate = LayoutInflater.from(this.nsn).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.nsn) * d)));
        this.nqj = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.nqj.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.mY().removeCallbacks(d.this.nst);
                if (d.this.nso != null) {
                    d.this.nss = false;
                    d.this.nso.onError();
                    return true;
                }
                return true;
            }
        });
        this.nqj.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.mY().removeCallbacks(d.this.nst);
                if (d.this.nso != null) {
                    d.this.nss = false;
                    d.this.nso.ZN();
                }
            }
        });
        this.nqj.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.mY().removeCallbacks(d.this.nst);
                d.this.nqj.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dPT();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.kvB = (TextView) inflate.findViewById(R.id.skip);
        this.kvB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.mY().removeCallbacks(d.this.nst);
                if (d.this.nso != null) {
                    d.this.nss = false;
                    d.this.nso.ZN();
                }
                TiebaStatic.log(new aq("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.bnH().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ai aiVar = new ai();
        aiVar.parseJson(string);
        final String bsB = aiVar.bsB();
        this.nfY = inflate.findViewById(R.id.tip_container);
        this.nfY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12945"));
                if (!at.isEmpty(bsB)) {
                    d.this.nss = false;
                    d.this.nso.ZN();
                    be.boR().b(d.this.nsn.getPageContext(), new String[]{bsB});
                }
            }
        });
        this.gWI = (TextView) inflate.findViewById(R.id.tip_text);
        String bsC = aiVar.bsC();
        if (at.isEmpty(bsC)) {
            bsC = this.nsn.getString(R.string.video_splash_tip_default);
        }
        this.gWI.setText(bsC);
        dPU();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPT() {
        if (this.nqj != null) {
            this.nqj.setBackgroundResource(0);
        }
    }

    private void dPU() {
        if (this.nsq != null && this.nsq.dPQ()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.nsq.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.nqj != null) {
                    this.nqj.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nqj != null) {
                    this.nqj.setBackgroundColor(this.nsn.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.nss = true;
        if (this.nqj != null) {
            this.nqj.resume();
        }
    }

    public void onPause() {
        if (this.nqj != null) {
            this.nsr = this.nqj.getCurrentPosition();
            this.nqj.stopPlayback();
            if (this.nss) {
                dPU();
            }
        }
    }

    public void onDestroy() {
        e.mY().removeCallbacks(this.nst);
    }

    public void a(a aVar) {
        this.nso = aVar;
    }
}

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
    private TextView htt;
    private TextView kQf;
    private View mRootView;
    private View nAG;
    private ScaleVideoView nKd;
    private LogoActivity nMh;
    private a nMi;
    private int nMl;
    private boolean nMm = true;
    private Runnable nMn = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nMi != null) {
                d.this.nMi.onError();
            }
        }
    };
    private com.baidu.tieba.w.a nMj = new com.baidu.tieba.w.a();
    private c nMk = new c();

    /* loaded from: classes.dex */
    public interface a {
        void acO();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.nMl = 0;
        this.nMh = logoActivity;
        this.nMl = 0;
    }

    public boolean dTw() {
        if (!(com.baidu.tbadk.core.sharedPref.b.brx().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.nMj == null || this.nMk == null) {
            return false;
        }
        return this.nMj.dTw() && this.nMk.dTy();
    }

    public void dTA() {
        if (!(com.baidu.tbadk.core.sharedPref.b.brx().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.nMk != null) {
                this.nMk.dTz();
            }
            com.baidu.tbadk.core.sharedPref.b.brx().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View D(double d) {
        if (this.mRootView == null) {
            this.mRootView = E(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new aq("c12944"));
        e.mB().postDelayed(this.nMn, 1000L);
        load();
    }

    private void load() {
        if (this.nMk != null && !at.isEmpty(this.nMk.getVideoPath())) {
            this.nKd.setVideoPath(this.nMk.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.nMj != null) {
            this.nMj.hF(System.currentTimeMillis());
        }
        if (this.nMl >= 0) {
            this.nKd.seekTo(this.nMl);
        }
        this.nKd.start();
    }

    private View E(double d) {
        View inflate = LayoutInflater.from(this.nMh).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.nMh) * d)));
        this.nKd = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.nKd.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.mB().removeCallbacks(d.this.nMn);
                if (d.this.nMi != null) {
                    d.this.nMm = false;
                    d.this.nMi.onError();
                    return true;
                }
                return true;
            }
        });
        this.nKd.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.mB().removeCallbacks(d.this.nMn);
                if (d.this.nMi != null) {
                    d.this.nMm = false;
                    d.this.nMi.acO();
                }
            }
        });
        this.nKd.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.mB().removeCallbacks(d.this.nMn);
                d.this.nKd.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dTB();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.kQf = (TextView) inflate.findViewById(R.id.skip);
        this.kQf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.mB().removeCallbacks(d.this.nMn);
                if (d.this.nMi != null) {
                    d.this.nMm = false;
                    d.this.nMi.acO();
                }
                TiebaStatic.log(new aq("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.brx().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ai aiVar = new ai();
        aiVar.parseJson(string);
        final String bws = aiVar.bws();
        this.nAG = inflate.findViewById(R.id.tip_container);
        this.nAG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12945"));
                if (!at.isEmpty(bws)) {
                    d.this.nMm = false;
                    d.this.nMi.acO();
                    be.bsB().b(d.this.nMh.getPageContext(), new String[]{bws});
                }
            }
        });
        this.htt = (TextView) inflate.findViewById(R.id.tip_text);
        String bwt = aiVar.bwt();
        if (at.isEmpty(bwt)) {
            bwt = this.nMh.getString(R.string.video_splash_tip_default);
        }
        this.htt.setText(bwt);
        dTC();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTB() {
        if (this.nKd != null) {
            this.nKd.setBackgroundResource(0);
        }
    }

    private void dTC() {
        if (this.nMk != null && this.nMk.dTy()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.nMk.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.nKd != null) {
                    this.nKd.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nKd != null) {
                    this.nKd.setBackgroundColor(this.nMh.getResources().getColor(R.color.CAM_X0101));
                }
            }
        }
    }

    public void onResume() {
        this.nMm = true;
        if (this.nKd != null) {
            this.nKd.resume();
        }
    }

    public void onPause() {
        if (this.nKd != null) {
            this.nMl = this.nKd.getCurrentPosition();
            this.nKd.stopPlayback();
            if (this.nMm) {
                dTC();
            }
        }
    }

    public void onDestroy() {
        e.mB().removeCallbacks(this.nMn);
    }

    public void a(a aVar) {
        this.nMi = aVar;
    }
}

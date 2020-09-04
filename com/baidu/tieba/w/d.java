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
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private TextView gte;
    private TextView jLC;
    private ScaleVideoView mEq;
    private int mGA;
    private LogoActivity mGw;
    private a mGx;
    private View mRootView;
    private View mtZ;
    private boolean mGB = true;
    private Runnable mGC = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mGx != null) {
                d.this.mGx.onError();
            }
        }
    };
    private com.baidu.tieba.w.a mGy = new com.baidu.tieba.w.a();
    private c mGz = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Vn();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.mGA = 0;
        this.mGw = logoActivity;
        this.mGA = 0;
    }

    public boolean dFa() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.mGy == null || this.mGz == null) {
            return false;
        }
        return this.mGy.dFa() && this.mGz.dFc();
    }

    public void dFe() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.mGz != null) {
                this.mGz.dFd();
            }
            com.baidu.tbadk.core.sharedPref.b.bik().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View F(double d) {
        if (this.mRootView == null) {
            this.mRootView = G(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new aq("c12944"));
        e.mS().postDelayed(this.mGC, 1000L);
        load();
    }

    private void load() {
        if (this.mGz != null && !at.isEmpty(this.mGz.getVideoPath())) {
            this.mEq.setVideoPath(this.mGz.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.mGy != null) {
            this.mGy.ga(System.currentTimeMillis());
        }
        if (this.mGA >= 0) {
            this.mEq.seekTo(this.mGA);
        }
        this.mEq.start();
    }

    private View G(double d) {
        View inflate = LayoutInflater.from(this.mGw).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.mGw) * d)));
        this.mEq = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.mEq.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.mS().removeCallbacks(d.this.mGC);
                if (d.this.mGx != null) {
                    d.this.mGB = false;
                    d.this.mGx.onError();
                    return true;
                }
                return true;
            }
        });
        this.mEq.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.mS().removeCallbacks(d.this.mGC);
                if (d.this.mGx != null) {
                    d.this.mGB = false;
                    d.this.mGx.Vn();
                }
            }
        });
        this.mEq.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.mS().removeCallbacks(d.this.mGC);
                d.this.mEq.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dFf();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.jLC = (TextView) inflate.findViewById(R.id.skip);
        this.jLC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.mS().removeCallbacks(d.this.mGC);
                if (d.this.mGx != null) {
                    d.this.mGB = false;
                    d.this.mGx.Vn();
                }
                TiebaStatic.log(new aq("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.bik().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ah ahVar = new ah();
        ahVar.parseJson(string);
        final String bne = ahVar.bne();
        this.mtZ = inflate.findViewById(R.id.tip_container);
        this.mtZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12945"));
                if (!at.isEmpty(bne)) {
                    d.this.mGB = false;
                    d.this.mGx.Vn();
                    be.bju().b(d.this.mGw.getPageContext(), new String[]{bne});
                }
            }
        });
        this.gte = (TextView) inflate.findViewById(R.id.tip_text);
        String bnf = ahVar.bnf();
        if (at.isEmpty(bnf)) {
            bnf = this.mGw.getString(R.string.video_splash_tip_default);
        }
        this.gte.setText(bnf);
        dFg();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFf() {
        if (this.mEq != null) {
            this.mEq.setBackgroundResource(0);
        }
    }

    private void dFg() {
        if (this.mGz != null && this.mGz.dFc()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.mGz.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.mEq != null) {
                    this.mEq.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mEq != null) {
                    this.mEq.setBackgroundColor(this.mGw.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.mGB = true;
        if (this.mEq != null) {
            this.mEq.resume();
        }
    }

    public void onPause() {
        if (this.mEq != null) {
            this.mGA = this.mEq.getCurrentPosition();
            this.mEq.stopPlayback();
            if (this.mGB) {
                dFg();
            }
        }
    }

    public void onDestroy() {
        e.mS().removeCallbacks(this.mGC);
    }

    public void a(a aVar) {
        this.mGx = aVar;
    }
}

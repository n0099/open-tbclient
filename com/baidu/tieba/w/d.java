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
    private TextView hcM;
    private TextView kBw;
    private View mRootView;
    private View nlU;
    private ScaleVideoView nwe;
    private LogoActivity nyi;
    private a nyj;
    private int nym;
    private boolean nyn = true;
    private Runnable nyo = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nyj != null) {
                d.this.nyj.onError();
            }
        }
    };
    private com.baidu.tieba.w.a nyk = new com.baidu.tieba.w.a();
    private c nyl = new c();

    /* loaded from: classes.dex */
    public interface a {
        void acm();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.nym = 0;
        this.nyi = logoActivity;
        this.nym = 0;
    }

    public boolean dSq() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.nyk == null || this.nyl == null) {
            return false;
        }
        return this.nyk.dSq() && this.nyl.dSs();
    }

    public void dSu() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.nyl != null) {
                this.nyl.dSt();
            }
            com.baidu.tbadk.core.sharedPref.b.bqh().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
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
        e.mY().postDelayed(this.nyo, 1000L);
        load();
    }

    private void load() {
        if (this.nyl != null && !at.isEmpty(this.nyl.getVideoPath())) {
            this.nwe.setVideoPath(this.nyl.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.nyk != null) {
            this.nyk.hd(System.currentTimeMillis());
        }
        if (this.nym >= 0) {
            this.nwe.seekTo(this.nym);
        }
        this.nwe.start();
    }

    private View K(double d) {
        View inflate = LayoutInflater.from(this.nyi).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.nyi) * d)));
        this.nwe = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.nwe.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.mY().removeCallbacks(d.this.nyo);
                if (d.this.nyj != null) {
                    d.this.nyn = false;
                    d.this.nyj.onError();
                    return true;
                }
                return true;
            }
        });
        this.nwe.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.mY().removeCallbacks(d.this.nyo);
                if (d.this.nyj != null) {
                    d.this.nyn = false;
                    d.this.nyj.acm();
                }
            }
        });
        this.nwe.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.mY().removeCallbacks(d.this.nyo);
                d.this.nwe.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dSv();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.kBw = (TextView) inflate.findViewById(R.id.skip);
        this.kBw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.mY().removeCallbacks(d.this.nyo);
                if (d.this.nyj != null) {
                    d.this.nyn = false;
                    d.this.nyj.acm();
                }
                TiebaStatic.log(new aq("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.bqh().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ai aiVar = new ai();
        aiVar.parseJson(string);
        final String bvb = aiVar.bvb();
        this.nlU = inflate.findViewById(R.id.tip_container);
        this.nlU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12945"));
                if (!at.isEmpty(bvb)) {
                    d.this.nyn = false;
                    d.this.nyj.acm();
                    be.brr().b(d.this.nyi.getPageContext(), new String[]{bvb});
                }
            }
        });
        this.hcM = (TextView) inflate.findViewById(R.id.tip_text);
        String bvc = aiVar.bvc();
        if (at.isEmpty(bvc)) {
            bvc = this.nyi.getString(R.string.video_splash_tip_default);
        }
        this.hcM.setText(bvc);
        dSw();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSv() {
        if (this.nwe != null) {
            this.nwe.setBackgroundResource(0);
        }
    }

    private void dSw() {
        if (this.nyl != null && this.nyl.dSs()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.nyl.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.nwe != null) {
                    this.nwe.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nwe != null) {
                    this.nwe.setBackgroundColor(this.nyi.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.nyn = true;
        if (this.nwe != null) {
            this.nwe.resume();
        }
    }

    public void onPause() {
        if (this.nwe != null) {
            this.nym = this.nwe.getCurrentPosition();
            this.nwe.stopPlayback();
            if (this.nyn) {
                dSw();
            }
        }
    }

    public void onDestroy() {
        e.mY().removeCallbacks(this.nyo);
    }

    public void a(a aVar) {
        this.nyj = aVar;
    }
}

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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private TextView eXh;
    private TextView hWA;
    private ScaleVideoView kGG;
    private LogoActivity kJh;
    private a kJi;
    private int kJl;
    private View kwK;
    private View mRootView;
    private boolean kJm = true;
    private Runnable kJn = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.kJi != null) {
                d.this.kJi.onError();
            }
        }
    };
    private com.baidu.tieba.w.a kJj = new com.baidu.tieba.w.a();
    private c kJk = new c();

    /* loaded from: classes.dex */
    public interface a {
        void aWn();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.kJl = 0;
        this.kJh = logoActivity;
        this.kJl = 0;
    }

    public boolean cTI() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aFH().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.kJj == null || this.kJk == null) {
            return false;
        }
        return this.kJj.cTI() && this.kJk.cTK();
    }

    public void cTL() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aFH().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.kJk != null) {
                this.kJk.deleteVideo();
            }
            com.baidu.tbadk.core.sharedPref.b.aFH().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
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
        e.gx().postDelayed(this.kJn, 1000L);
        load();
    }

    private void load() {
        if (this.kJk != null && !aq.isEmpty(this.kJk.getVideoPath())) {
            this.kGG.setVideoPath(this.kJk.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.kJj != null) {
            this.kJj.eJ(System.currentTimeMillis());
        }
        if (this.kJl >= 0) {
            this.kGG.seekTo(this.kJl);
        }
        this.kGG.start();
    }

    private View s(double d) {
        View inflate = LayoutInflater.from(this.kJh).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.kJh) * d)));
        this.kGG = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.kGG.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.gx().removeCallbacks(d.this.kJn);
                if (d.this.kJi != null) {
                    d.this.kJm = false;
                    d.this.kJi.onError();
                    return true;
                }
                return true;
            }
        });
        this.kGG.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.gx().removeCallbacks(d.this.kJn);
                if (d.this.kJi != null) {
                    d.this.kJm = false;
                    d.this.kJi.aWn();
                }
            }
        });
        this.kGG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.gx().removeCallbacks(d.this.kJn);
                d.this.kGG.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.cTM();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.hWA = (TextView) inflate.findViewById(R.id.skip);
        this.hWA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.gx().removeCallbacks(d.this.kJn);
                if (d.this.kJi != null) {
                    d.this.kJm = false;
                    d.this.kJi.aWn();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.aFH().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ab abVar = new ab();
        abVar.parseJson(string);
        final String aJQ = abVar.aJQ();
        this.kwK = inflate.findViewById(R.id.tip_container);
        this.kwK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!aq.isEmpty(aJQ)) {
                    d.this.kJm = false;
                    d.this.kJi.aWn();
                    ba.aGK().b(d.this.kJh.getPageContext(), new String[]{aJQ});
                }
            }
        });
        this.eXh = (TextView) inflate.findViewById(R.id.tip_text);
        String aJR = abVar.aJR();
        if (aq.isEmpty(aJR)) {
            aJR = this.kJh.getString(R.string.video_splash_tip_default);
        }
        this.eXh.setText(aJR);
        cTN();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTM() {
        if (this.kGG != null) {
            this.kGG.setBackgroundResource(0);
        }
    }

    private void cTN() {
        if (this.kJk != null && this.kJk.cTK()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.kJk.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.kGG != null) {
                    this.kGG.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.kGG != null) {
                    this.kGG.setBackgroundColor(this.kJh.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.kJm = true;
        if (this.kGG != null) {
            this.kGG.resume();
        }
    }

    public void onPause() {
        if (this.kGG != null) {
            this.kJl = this.kGG.getCurrentPosition();
            this.kGG.stopPlayback();
            if (this.kJm) {
                cTN();
            }
        }
    }

    public void onDestroy() {
        e.gx().removeCallbacks(this.kJn);
    }

    public void a(a aVar) {
        this.kJi = aVar;
    }
}

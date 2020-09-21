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
    private TextView gwA;
    private TextView jUe;
    private View mDK;
    private ScaleVideoView mOb;
    private LogoActivity mQh;
    private a mQi;
    private int mQl;
    private View mRootView;
    private boolean mQm = true;
    private Runnable mQn = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mQi != null) {
                d.this.mQi.onError();
            }
        }
    };
    private com.baidu.tieba.w.a mQj = new com.baidu.tieba.w.a();
    private c mQk = new c();

    /* loaded from: classes.dex */
    public interface a {
        void VW();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.mQl = 0;
        this.mQh = logoActivity;
        this.mQl = 0;
    }

    public boolean dIU() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bjf().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.mQj == null || this.mQk == null) {
            return false;
        }
        return this.mQj.dIU() && this.mQk.dIW();
    }

    public void dIY() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bjf().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.mQk != null) {
                this.mQk.dIX();
            }
            com.baidu.tbadk.core.sharedPref.b.bjf().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
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
        e.mX().postDelayed(this.mQn, 1000L);
        load();
    }

    private void load() {
        if (this.mQk != null && !at.isEmpty(this.mQk.getVideoPath())) {
            this.mOb.setVideoPath(this.mQk.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.mQj != null) {
            this.mQj.go(System.currentTimeMillis());
        }
        if (this.mQl >= 0) {
            this.mOb.seekTo(this.mQl);
        }
        this.mOb.start();
    }

    private View G(double d) {
        View inflate = LayoutInflater.from(this.mQh).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.mQh) * d)));
        this.mOb = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.mOb.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.mX().removeCallbacks(d.this.mQn);
                if (d.this.mQi != null) {
                    d.this.mQm = false;
                    d.this.mQi.onError();
                    return true;
                }
                return true;
            }
        });
        this.mOb.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.mX().removeCallbacks(d.this.mQn);
                if (d.this.mQi != null) {
                    d.this.mQm = false;
                    d.this.mQi.VW();
                }
            }
        });
        this.mOb.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.mX().removeCallbacks(d.this.mQn);
                d.this.mOb.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dIZ();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.jUe = (TextView) inflate.findViewById(R.id.skip);
        this.jUe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.mX().removeCallbacks(d.this.mQn);
                if (d.this.mQi != null) {
                    d.this.mQm = false;
                    d.this.mQi.VW();
                }
                TiebaStatic.log(new aq("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.bjf().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ai aiVar = new ai();
        aiVar.parseJson(string);
        final String bnY = aiVar.bnY();
        this.mDK = inflate.findViewById(R.id.tip_container);
        this.mDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12945"));
                if (!at.isEmpty(bnY)) {
                    d.this.mQm = false;
                    d.this.mQi.VW();
                    be.bkp().b(d.this.mQh.getPageContext(), new String[]{bnY});
                }
            }
        });
        this.gwA = (TextView) inflate.findViewById(R.id.tip_text);
        String bnZ = aiVar.bnZ();
        if (at.isEmpty(bnZ)) {
            bnZ = this.mQh.getString(R.string.video_splash_tip_default);
        }
        this.gwA.setText(bnZ);
        dJa();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIZ() {
        if (this.mOb != null) {
            this.mOb.setBackgroundResource(0);
        }
    }

    private void dJa() {
        if (this.mQk != null && this.mQk.dIW()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.mQk.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.mOb != null) {
                    this.mOb.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mOb != null) {
                    this.mOb.setBackgroundColor(this.mQh.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.mQm = true;
        if (this.mOb != null) {
            this.mOb.resume();
        }
    }

    public void onPause() {
        if (this.mOb != null) {
            this.mQl = this.mOb.getCurrentPosition();
            this.mOb.stopPlayback();
            if (this.mQm) {
                dJa();
            }
        }
    }

    public void onDestroy() {
        e.mX().removeCallbacks(this.mQn);
    }

    public void a(a aVar) {
        this.mQi = aVar;
    }
}

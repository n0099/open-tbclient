package com.baidu.tieba.u;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
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
    private TextView ebX;
    private TextView hbT;
    private ScaleVideoView jHr;
    private LogoActivity jJs;
    private a jJt;
    private int jJw;
    private View jxb;
    private View mRootView;
    private boolean jJx = true;
    private Runnable jJy = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jJt != null) {
                d.this.jJt.onError();
            }
        }
    };
    private com.baidu.tieba.u.a jJu = new com.baidu.tieba.u.a();
    private c jJv = new c();

    /* loaded from: classes.dex */
    public interface a {
        void aBJ();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.jJw = 0;
        this.jJs = logoActivity;
        this.jJw = 0;
    }

    public boolean cwG() {
        if (!(com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.jJu == null || this.jJv == null) {
            return false;
        }
        return this.jJu.cwG() && this.jJv.cwJ();
    }

    public void cwL() {
        if (!(com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.jJv != null) {
                this.jJv.cwK();
            }
            com.baidu.tbadk.core.sharedPref.b.alR().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View o(double d) {
        if (this.mRootView == null) {
            this.mRootView = p(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new an("c12944"));
        e.fZ().postDelayed(this.jJy, 1000L);
        load();
    }

    private void load() {
        if (this.jJv != null && !aq.isEmpty(this.jJv.getVideoPath())) {
            this.jHr.setVideoPath(this.jJv.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.jJu != null) {
            this.jJu.eb(System.currentTimeMillis());
        }
        if (this.jJw >= 0) {
            this.jHr.seekTo(this.jJw);
        }
        this.jHr.start();
    }

    private View p(double d) {
        View inflate = LayoutInflater.from(this.jJs).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.jJs) * d)));
        this.jHr = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.jHr.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.fZ().removeCallbacks(d.this.jJy);
                if (d.this.jJt != null) {
                    d.this.jJx = false;
                    d.this.jJt.onError();
                    return true;
                }
                return true;
            }
        });
        this.jHr.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.fZ().removeCallbacks(d.this.jJy);
                if (d.this.jJt != null) {
                    d.this.jJx = false;
                    d.this.jJt.aBJ();
                }
            }
        });
        this.jHr.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.fZ().removeCallbacks(d.this.jJy);
                d.this.jHr.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.u.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.cwM();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.hbT = (TextView) inflate.findViewById(R.id.skip);
        this.hbT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.fZ().removeCallbacks(d.this.jJy);
                if (d.this.jJt != null) {
                    d.this.jJx = false;
                    d.this.jJt.aBJ();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.alR().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        z zVar = new z();
        zVar.parseJson(string);
        final String apA = zVar.apA();
        this.jxb = inflate.findViewById(R.id.tip_container);
        this.jxb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!aq.isEmpty(apA)) {
                    d.this.jJx = false;
                    d.this.jJt.aBJ();
                    ba.amQ().b(d.this.jJs.getPageContext(), new String[]{apA});
                }
            }
        });
        this.ebX = (TextView) inflate.findViewById(R.id.tip_text);
        String apB = zVar.apB();
        if (aq.isEmpty(apB)) {
            apB = this.jJs.getString(R.string.video_splash_tip_default);
        }
        this.ebX.setText(apB);
        cwN();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwM() {
        if (this.jHr != null) {
            this.jHr.setBackgroundResource(0);
        }
    }

    private void cwN() {
        if (this.jJv != null && this.jJv.cwJ()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.jJv.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.jHr != null) {
                    this.jHr.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jHr != null) {
                    this.jHr.setBackgroundColor(this.jJs.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.jJx = true;
        if (this.jHr != null) {
            this.jHr.resume();
        }
    }

    public void onPause() {
        if (this.jHr != null) {
            this.jJw = this.jHr.getCurrentPosition();
            this.jHr.stopPlayback();
            if (this.jJx) {
                cwN();
            }
        }
    }

    public void onDestroy() {
        e.fZ().removeCallbacks(this.jJy);
    }

    public void a(a aVar) {
        this.jJt = aVar;
    }
}

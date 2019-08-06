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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private TextView dLA;
    private TextView hbW;
    private ScaleVideoView jFf;
    private LogoActivity jHf;
    private a jHg;
    private int jHj;
    private View juN;
    private View mRootView;
    private boolean jHk = true;
    private Runnable jHl = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jHg != null) {
                d.this.jHg.onError();
            }
        }
    };
    private com.baidu.tieba.u.a jHh = new com.baidu.tieba.u.a();
    private c jHi = new c();

    /* loaded from: classes.dex */
    public interface a {
        void aBk();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.jHj = 0;
        this.jHf = logoActivity;
        this.jHj = 0;
    }

    public boolean cyd() {
        if (!(com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_video_splash_switch", 0) == 1) || this.jHh == null || this.jHi == null) {
            return false;
        }
        return this.jHh.cyd() && this.jHi.cyg();
    }

    public void cyi() {
        if (!(com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.jHi != null) {
                this.jHi.cyh();
            }
            com.baidu.tbadk.core.sharedPref.b.ahQ().putLong("key_video_splash_last_show_time", 0L);
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
        e.iK().postDelayed(this.jHl, 1000L);
        load();
    }

    private void load() {
        if (this.jHi != null && !aq.isEmpty(this.jHi.getVideoPath())) {
            this.jFf.setVideoPath(this.jHi.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.jHh != null) {
            this.jHh.eE(System.currentTimeMillis());
        }
        if (this.jHj >= 0) {
            this.jFf.seekTo(this.jHj);
        }
        this.jFf.start();
    }

    private View p(double d) {
        View inflate = LayoutInflater.from(this.jHf).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.ah(this.jHf) * d)));
        this.jFf = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.jFf.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.iK().removeCallbacks(d.this.jHl);
                if (d.this.jHg != null) {
                    d.this.jHk = false;
                    d.this.jHg.onError();
                    return true;
                }
                return true;
            }
        });
        this.jFf.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.iK().removeCallbacks(d.this.jHl);
                if (d.this.jHg != null) {
                    d.this.jHk = false;
                    d.this.jHg.aBk();
                }
            }
        });
        this.jFf.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.iK().removeCallbacks(d.this.jHl);
                d.this.jFf.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.u.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.cyj();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.hbW = (TextView) inflate.findViewById(R.id.skip);
        this.hbW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.iK().removeCallbacks(d.this.jHl);
                if (d.this.jHg != null) {
                    d.this.jHk = false;
                    d.this.jHg.aBk();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("key_video_splash_config", "");
        y yVar = new y();
        yVar.parseJson(string);
        final String amN = yVar.amN();
        this.juN = inflate.findViewById(R.id.tip_container);
        this.juN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!aq.isEmpty(amN)) {
                    d.this.jHk = false;
                    d.this.jHg.aBk();
                    bb.ajE().c(d.this.jHf.getPageContext(), new String[]{amN});
                }
            }
        });
        this.dLA = (TextView) inflate.findViewById(R.id.tip_text);
        String amO = yVar.amO();
        if (aq.isEmpty(amO)) {
            amO = this.jHf.getString(R.string.video_splash_tip_default);
        }
        this.dLA.setText(amO);
        cyk();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyj() {
        if (this.jFf != null) {
            this.jFf.setBackgroundResource(0);
        }
    }

    private void cyk() {
        if (this.jHi != null && this.jHi.cyg()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.jHi.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.jFf != null) {
                    this.jFf.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jFf != null) {
                    this.jFf.setBackgroundColor(this.jHf.getResources().getColor(R.color.cp_btn_a));
                }
            }
        }
    }

    public void onResume() {
        this.jHk = true;
        if (this.jFf != null) {
            this.jFf.resume();
        }
    }

    public void onPause() {
        if (this.jFf != null) {
            this.jHj = this.jFf.getCurrentPosition();
            this.jFf.stopPlayback();
            if (this.jHk) {
                cyk();
            }
        }
    }

    public void onDestroy() {
        e.iK().removeCallbacks(this.jHl);
    }

    public void a(a aVar) {
        this.jHg = aVar;
    }
}

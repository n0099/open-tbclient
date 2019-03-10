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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    private TextView dxi;
    private TextView gDK;
    private View iUQ;
    private ScaleVideoView jfk;
    private LogoActivity jhk;
    private a jhl;
    private int jho;
    private View mRootView;
    private boolean jhp = true;
    private Runnable jhq = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jhl != null) {
                d.this.jhl.onError();
            }
        }
    };
    private com.baidu.tieba.u.a jhm = new com.baidu.tieba.u.a();
    private c jhn = new c();

    /* loaded from: classes.dex */
    public interface a {
        void auQ();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.jho = 0;
        this.jhk = logoActivity;
        this.jho = 0;
    }

    public boolean cmN() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.jhm == null || this.jhn == null) {
            return false;
        }
        return this.jhm.cmN() && this.jhn.cmQ();
    }

    public void cmS() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.jhn != null) {
                this.jhn.cmR();
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", 0L);
        }
    }

    public View o(double d) {
        if (this.mRootView == null) {
            this.mRootView = p(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new am("c12944"));
        e.jH().postDelayed(this.jhq, 1000L);
        load();
    }

    private void load() {
        if (this.jhn != null && !ap.isEmpty(this.jhn.getVideoPath())) {
            this.jfk.setVideoPath(this.jhn.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.jhm != null) {
            this.jhm.dX(System.currentTimeMillis());
        }
        if (this.jho >= 0) {
            this.jfk.seekTo(this.jho);
        }
        this.jfk.start();
    }

    private View p(double d) {
        View inflate = LayoutInflater.from(this.jhk).inflate(d.h.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aQ(this.jhk) * d)));
        this.jfk = (ScaleVideoView) inflate.findViewById(d.g.video);
        this.jfk.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.jH().removeCallbacks(d.this.jhq);
                if (d.this.jhl != null) {
                    d.this.jhp = false;
                    d.this.jhl.onError();
                    return true;
                }
                return true;
            }
        });
        this.jfk.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.jH().removeCallbacks(d.this.jhq);
                if (d.this.jhl != null) {
                    d.this.jhp = false;
                    d.this.jhl.auQ();
                }
            }
        });
        this.jfk.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.jH().removeCallbacks(d.this.jhq);
                d.this.jfk.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.u.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.cmT();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.gDK = (TextView) inflate.findViewById(d.g.skip);
        this.gDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.jH().removeCallbacks(d.this.jhq);
                if (d.this.jhl != null) {
                    d.this.jhp = false;
                    d.this.jhl.auQ();
                }
                TiebaStatic.log(new am("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        y yVar = new y();
        yVar.parseJson(string);
        final String agK = yVar.agK();
        this.iUQ = inflate.findViewById(d.g.tip_container);
        this.iUQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12945"));
                if (!ap.isEmpty(agK)) {
                    d.this.jhp = false;
                    d.this.jhl.auQ();
                    ba.adD().c(d.this.jhk.getPageContext(), new String[]{agK});
                }
            }
        });
        this.dxi = (TextView) inflate.findViewById(d.g.tip_text);
        String agL = yVar.agL();
        if (ap.isEmpty(agL)) {
            agL = this.jhk.getString(d.j.video_splash_tip_default);
        }
        this.dxi.setText(agL);
        cmU();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmT() {
        if (this.jfk != null) {
            this.jfk.setBackgroundResource(0);
        }
    }

    private void cmU() {
        if (this.jhn != null && this.jhn.cmQ()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.jhn.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.jfk != null) {
                    this.jfk.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jfk != null) {
                    this.jfk.setBackgroundColor(this.jhk.getResources().getColor(d.C0236d.cp_btn_a));
                }
            }
        }
    }

    public void onResume() {
        this.jhp = true;
        if (this.jfk != null) {
            this.jfk.resume();
        }
    }

    public void onPause() {
        if (this.jfk != null) {
            this.jho = this.jfk.getCurrentPosition();
            this.jfk.stopPlayback();
            if (this.jhp) {
                cmU();
            }
        }
    }

    public void onDestroy() {
        e.jH().removeCallbacks(this.jhq);
    }

    public void a(a aVar) {
        this.jhl = aVar;
    }
}

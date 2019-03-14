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
    private TextView dxe;
    private TextView gDJ;
    private View iUI;
    private ScaleVideoView jfc;
    private LogoActivity jhc;
    private a jhd;
    private int jhg;
    private View mRootView;
    private boolean jhh = true;
    private Runnable jhi = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jhd != null) {
                d.this.jhd.onError();
            }
        }
    };
    private com.baidu.tieba.u.a jhe = new com.baidu.tieba.u.a();
    private c jhf = new c();

    /* loaded from: classes.dex */
    public interface a {
        void auP();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.jhg = 0;
        this.jhc = logoActivity;
        this.jhg = 0;
    }

    public boolean cmQ() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.jhe == null || this.jhf == null) {
            return false;
        }
        return this.jhe.cmQ() && this.jhf.cmT();
    }

    public void cmV() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.jhf != null) {
                this.jhf.cmU();
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
        e.jH().postDelayed(this.jhi, 1000L);
        load();
    }

    private void load() {
        if (this.jhf != null && !ap.isEmpty(this.jhf.getVideoPath())) {
            this.jfc.setVideoPath(this.jhf.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.jhe != null) {
            this.jhe.dX(System.currentTimeMillis());
        }
        if (this.jhg >= 0) {
            this.jfc.seekTo(this.jhg);
        }
        this.jfc.start();
    }

    private View p(double d) {
        View inflate = LayoutInflater.from(this.jhc).inflate(d.h.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aQ(this.jhc) * d)));
        this.jfc = (ScaleVideoView) inflate.findViewById(d.g.video);
        this.jfc.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.jH().removeCallbacks(d.this.jhi);
                if (d.this.jhd != null) {
                    d.this.jhh = false;
                    d.this.jhd.onError();
                    return true;
                }
                return true;
            }
        });
        this.jfc.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.jH().removeCallbacks(d.this.jhi);
                if (d.this.jhd != null) {
                    d.this.jhh = false;
                    d.this.jhd.auP();
                }
            }
        });
        this.jfc.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.jH().removeCallbacks(d.this.jhi);
                d.this.jfc.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.u.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.cmW();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.gDJ = (TextView) inflate.findViewById(d.g.skip);
        this.gDJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.jH().removeCallbacks(d.this.jhi);
                if (d.this.jhd != null) {
                    d.this.jhh = false;
                    d.this.jhd.auP();
                }
                TiebaStatic.log(new am("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        y yVar = new y();
        yVar.parseJson(string);
        final String agK = yVar.agK();
        this.iUI = inflate.findViewById(d.g.tip_container);
        this.iUI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12945"));
                if (!ap.isEmpty(agK)) {
                    d.this.jhh = false;
                    d.this.jhd.auP();
                    ba.adD().c(d.this.jhc.getPageContext(), new String[]{agK});
                }
            }
        });
        this.dxe = (TextView) inflate.findViewById(d.g.tip_text);
        String agL = yVar.agL();
        if (ap.isEmpty(agL)) {
            agL = this.jhc.getString(d.j.video_splash_tip_default);
        }
        this.dxe.setText(agL);
        cmX();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmW() {
        if (this.jfc != null) {
            this.jfc.setBackgroundResource(0);
        }
    }

    private void cmX() {
        if (this.jhf != null && this.jhf.cmT()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.jhf.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.jfc != null) {
                    this.jfc.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jfc != null) {
                    this.jfc.setBackgroundColor(this.jhc.getResources().getColor(d.C0277d.cp_btn_a));
                }
            }
        }
    }

    public void onResume() {
        this.jhh = true;
        if (this.jfc != null) {
            this.jfc.resume();
        }
    }

    public void onPause() {
        if (this.jfc != null) {
            this.jhg = this.jfc.getCurrentPosition();
            this.jfc.stopPlayback();
            if (this.jhh) {
                cmX();
            }
        }
    }

    public void onDestroy() {
        e.jH().removeCallbacks(this.jhi);
    }

    public void a(a aVar) {
        this.jhd = aVar;
    }
}

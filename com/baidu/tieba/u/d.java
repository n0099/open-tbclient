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
    private TextView dxk;
    private TextView gDy;
    private View iUx;
    private ScaleVideoView jeR;
    private LogoActivity jgR;
    private a jgS;
    private int jgV;
    private View mRootView;
    private boolean jgW = true;
    private Runnable jgX = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jgS != null) {
                d.this.jgS.onError();
            }
        }
    };
    private com.baidu.tieba.u.a jgT = new com.baidu.tieba.u.a();
    private c jgU = new c();

    /* loaded from: classes.dex */
    public interface a {
        void auM();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.jgV = 0;
        this.jgR = logoActivity;
        this.jgV = 0;
    }

    public boolean cmO() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.jgT == null || this.jgU == null) {
            return false;
        }
        return this.jgT.cmO() && this.jgU.cmR();
    }

    public void cmT() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.jgU != null) {
                this.jgU.cmS();
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
        e.jH().postDelayed(this.jgX, 1000L);
        load();
    }

    private void load() {
        if (this.jgU != null && !ap.isEmpty(this.jgU.getVideoPath())) {
            this.jeR.setVideoPath(this.jgU.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.jgT != null) {
            this.jgT.dY(System.currentTimeMillis());
        }
        if (this.jgV >= 0) {
            this.jeR.seekTo(this.jgV);
        }
        this.jeR.start();
    }

    private View p(double d) {
        View inflate = LayoutInflater.from(this.jgR).inflate(d.h.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aQ(this.jgR) * d)));
        this.jeR = (ScaleVideoView) inflate.findViewById(d.g.video);
        this.jeR.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.jH().removeCallbacks(d.this.jgX);
                if (d.this.jgS != null) {
                    d.this.jgW = false;
                    d.this.jgS.onError();
                    return true;
                }
                return true;
            }
        });
        this.jeR.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.jH().removeCallbacks(d.this.jgX);
                if (d.this.jgS != null) {
                    d.this.jgW = false;
                    d.this.jgS.auM();
                }
            }
        });
        this.jeR.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.jH().removeCallbacks(d.this.jgX);
                d.this.jeR.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.u.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.cmU();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.gDy = (TextView) inflate.findViewById(d.g.skip);
        this.gDy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.jH().removeCallbacks(d.this.jgX);
                if (d.this.jgS != null) {
                    d.this.jgW = false;
                    d.this.jgS.auM();
                }
                TiebaStatic.log(new am("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        y yVar = new y();
        yVar.parseJson(string);
        final String agH = yVar.agH();
        this.iUx = inflate.findViewById(d.g.tip_container);
        this.iUx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12945"));
                if (!ap.isEmpty(agH)) {
                    d.this.jgW = false;
                    d.this.jgS.auM();
                    ba.adA().c(d.this.jgR.getPageContext(), new String[]{agH});
                }
            }
        });
        this.dxk = (TextView) inflate.findViewById(d.g.tip_text);
        String agI = yVar.agI();
        if (ap.isEmpty(agI)) {
            agI = this.jgR.getString(d.j.video_splash_tip_default);
        }
        this.dxk.setText(agI);
        cmV();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmU() {
        if (this.jeR != null) {
            this.jeR.setBackgroundResource(0);
        }
    }

    private void cmV() {
        if (this.jgU != null && this.jgU.cmR()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.jgU.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.jeR != null) {
                    this.jeR.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jeR != null) {
                    this.jeR.setBackgroundColor(this.jgR.getResources().getColor(d.C0277d.cp_btn_a));
                }
            }
        }
    }

    public void onResume() {
        this.jgW = true;
        if (this.jeR != null) {
            this.jeR.resume();
        }
    }

    public void onPause() {
        if (this.jeR != null) {
            this.jgV = this.jeR.getCurrentPosition();
            this.jeR.stopPlayback();
            if (this.jgW) {
                cmV();
            }
        }
    }

    public void onDestroy() {
        e.jH().removeCallbacks(this.jgX);
    }

    public void a(a aVar) {
        this.jgS = aVar;
    }
}

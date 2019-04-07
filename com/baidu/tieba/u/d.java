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
    private TextView dxj;
    private TextView gDx;
    private View iUw;
    private ScaleVideoView jeQ;
    private LogoActivity jgQ;
    private a jgR;
    private int jgU;
    private View mRootView;
    private boolean jgV = true;
    private Runnable jgW = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jgR != null) {
                d.this.jgR.onError();
            }
        }
    };
    private com.baidu.tieba.u.a jgS = new com.baidu.tieba.u.a();
    private c jgT = new c();

    /* loaded from: classes.dex */
    public interface a {
        void auM();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.jgU = 0;
        this.jgQ = logoActivity;
        this.jgU = 0;
    }

    public boolean cmO() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.jgS == null || this.jgT == null) {
            return false;
        }
        return this.jgS.cmO() && this.jgT.cmR();
    }

    public void cmT() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.jgT != null) {
                this.jgT.cmS();
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
        e.jH().postDelayed(this.jgW, 1000L);
        load();
    }

    private void load() {
        if (this.jgT != null && !ap.isEmpty(this.jgT.getVideoPath())) {
            this.jeQ.setVideoPath(this.jgT.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.jgS != null) {
            this.jgS.dY(System.currentTimeMillis());
        }
        if (this.jgU >= 0) {
            this.jeQ.seekTo(this.jgU);
        }
        this.jeQ.start();
    }

    private View p(double d) {
        View inflate = LayoutInflater.from(this.jgQ).inflate(d.h.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aQ(this.jgQ) * d)));
        this.jeQ = (ScaleVideoView) inflate.findViewById(d.g.video);
        this.jeQ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.jH().removeCallbacks(d.this.jgW);
                if (d.this.jgR != null) {
                    d.this.jgV = false;
                    d.this.jgR.onError();
                    return true;
                }
                return true;
            }
        });
        this.jeQ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.jH().removeCallbacks(d.this.jgW);
                if (d.this.jgR != null) {
                    d.this.jgV = false;
                    d.this.jgR.auM();
                }
            }
        });
        this.jeQ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.jH().removeCallbacks(d.this.jgW);
                d.this.jeQ.setMediaPlayer(mediaPlayer);
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
        this.gDx = (TextView) inflate.findViewById(d.g.skip);
        this.gDx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.jH().removeCallbacks(d.this.jgW);
                if (d.this.jgR != null) {
                    d.this.jgV = false;
                    d.this.jgR.auM();
                }
                TiebaStatic.log(new am("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        y yVar = new y();
        yVar.parseJson(string);
        final String agH = yVar.agH();
        this.iUw = inflate.findViewById(d.g.tip_container);
        this.iUw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12945"));
                if (!ap.isEmpty(agH)) {
                    d.this.jgV = false;
                    d.this.jgR.auM();
                    ba.adA().c(d.this.jgQ.getPageContext(), new String[]{agH});
                }
            }
        });
        this.dxj = (TextView) inflate.findViewById(d.g.tip_text);
        String agI = yVar.agI();
        if (ap.isEmpty(agI)) {
            agI = this.jgQ.getString(d.j.video_splash_tip_default);
        }
        this.dxj.setText(agI);
        cmV();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmU() {
        if (this.jeQ != null) {
            this.jeQ.setBackgroundResource(0);
        }
    }

    private void cmV() {
        if (this.jgT != null && this.jgT.cmR()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.jgT.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.jeQ != null) {
                    this.jeQ.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jeQ != null) {
                    this.jeQ.setBackgroundColor(this.jgQ.getResources().getColor(d.C0277d.cp_btn_a));
                }
            }
        }
    }

    public void onResume() {
        this.jgV = true;
        if (this.jeQ != null) {
            this.jeQ.resume();
        }
    }

    public void onPause() {
        if (this.jeQ != null) {
            this.jgU = this.jeQ.getCurrentPosition();
            this.jeQ.stopPlayback();
            if (this.jgV) {
                cmV();
            }
        }
    }

    public void onDestroy() {
        e.jH().removeCallbacks(this.jgW);
    }

    public void a(a aVar) {
        this.jgR = aVar;
    }
}

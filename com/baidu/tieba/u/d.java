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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class d {
    private TextView bUH;
    private TextView eTX;
    private View hjD;
    private ScaleVideoView huf;
    private LogoActivity hwc;
    private a hwd;
    private int hwg;
    private View mRootView;
    private boolean hwh = true;
    private Runnable hwi = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hwd != null) {
                d.this.hwd.onError();
            }
        }
    };
    private com.baidu.tieba.u.a hwe = new com.baidu.tieba.u.a();
    private c hwf = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Ri();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.hwg = 0;
        this.hwc = logoActivity;
        this.hwg = 0;
    }

    public boolean bGZ() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.hwe == null || this.hwf == null) {
            return false;
        }
        return this.hwe.bGZ() && this.hwf.bHc();
    }

    public void bHe() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.hwf != null) {
                this.hwf.bHd();
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", 0L);
        }
    }

    public View n(double d) {
        if (this.mRootView == null) {
            this.mRootView = o(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new am("c12944"));
        e.jt().postDelayed(this.hwi, 1000L);
        load();
    }

    private void load() {
        if (this.hwf != null && !ao.isEmpty(this.hwf.getVideoPath())) {
            this.huf.setVideoPath(this.hwf.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.hwe != null) {
            this.hwe.dd(System.currentTimeMillis());
        }
        if (this.hwg >= 0) {
            this.huf.seekTo(this.hwg);
        }
        this.huf.start();
    }

    private View o(double d) {
        View inflate = LayoutInflater.from(this.hwc).inflate(e.h.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aQ(this.hwc) * d)));
        this.huf = (ScaleVideoView) inflate.findViewById(e.g.video);
        this.huf.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                com.baidu.adp.lib.g.e.jt().removeCallbacks(d.this.hwi);
                if (d.this.hwd != null) {
                    d.this.hwh = false;
                    d.this.hwd.onError();
                    return true;
                }
                return true;
            }
        });
        this.huf.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                com.baidu.adp.lib.g.e.jt().removeCallbacks(d.this.hwi);
                if (d.this.hwd != null) {
                    d.this.hwh = false;
                    d.this.hwd.Ri();
                }
            }
        });
        this.huf.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                com.baidu.adp.lib.g.e.jt().removeCallbacks(d.this.hwi);
                d.this.huf.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.u.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.bHf();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.eTX = (TextView) inflate.findViewById(e.g.skip);
        this.eTX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.e.jt().removeCallbacks(d.this.hwi);
                if (d.this.hwd != null) {
                    d.this.hwh = false;
                    d.this.hwd.Ri();
                }
                TiebaStatic.log(new am("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        w wVar = new w();
        wVar.parseJson(string);
        final String DL = wVar.DL();
        this.hjD = inflate.findViewById(e.g.tip_container);
        this.hjD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12945"));
                if (!ao.isEmpty(DL)) {
                    d.this.hwh = false;
                    d.this.hwd.Ri();
                    ay.AN().c(d.this.hwc.getPageContext(), new String[]{DL});
                }
            }
        });
        this.bUH = (TextView) inflate.findViewById(e.g.tip_text);
        String DM = wVar.DM();
        if (ao.isEmpty(DM)) {
            DM = this.hwc.getString(e.j.video_splash_tip_default);
        }
        this.bUH.setText(DM);
        bHg();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHf() {
        if (this.huf != null) {
            this.huf.setBackgroundResource(0);
        }
    }

    private void bHg() {
        if (this.hwf != null && this.hwf.bHc()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.hwf.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.huf != null) {
                    this.huf.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.huf != null) {
                    this.huf.setBackgroundColor(this.hwc.getResources().getColor(e.d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.hwh = true;
        if (this.huf != null) {
            this.huf.resume();
        }
    }

    public void onPause() {
        if (this.huf != null) {
            this.hwg = this.huf.getCurrentPosition();
            this.huf.stopPlayback();
            if (this.hwh) {
                bHg();
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.hwi);
    }

    public void a(a aVar) {
        this.hwd = aVar;
    }
}

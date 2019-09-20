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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private TextView dNl;
    private TextView hdQ;
    private ScaleVideoView jHB;
    private LogoActivity jJA;
    private a jJB;
    private int jJE;
    private View jxj;
    private View mRootView;
    private boolean jJF = true;
    private Runnable jJG = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jJB != null) {
                d.this.jJB.onError();
            }
        }
    };
    private com.baidu.tieba.u.a jJC = new com.baidu.tieba.u.a();
    private c jJD = new c();

    /* loaded from: classes.dex */
    public interface a {
        void aBy();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.jJE = 0;
        this.jJA = logoActivity;
        this.jJE = 0;
    }

    public boolean cyR() {
        if (!(com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_video_splash_switch", 0) == 1) || this.jJC == null || this.jJD == null) {
            return false;
        }
        return this.jJC.cyR() && this.jJD.cyU();
    }

    public void cyW() {
        if (!(com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.jJD != null) {
                this.jJD.cyV();
            }
            com.baidu.tbadk.core.sharedPref.b.ahU().putLong("key_video_splash_last_show_time", 0L);
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
        e.iK().postDelayed(this.jJG, 1000L);
        load();
    }

    private void load() {
        if (this.jJD != null && !aq.isEmpty(this.jJD.getVideoPath())) {
            this.jHB.setVideoPath(this.jJD.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.jJC != null) {
            this.jJC.eH(System.currentTimeMillis());
        }
        if (this.jJE >= 0) {
            this.jHB.seekTo(this.jJE);
        }
        this.jHB.start();
    }

    private View p(double d) {
        View inflate = LayoutInflater.from(this.jJA).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.ah(this.jJA) * d)));
        this.jHB = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.jHB.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.iK().removeCallbacks(d.this.jJG);
                if (d.this.jJB != null) {
                    d.this.jJF = false;
                    d.this.jJB.onError();
                    return true;
                }
                return true;
            }
        });
        this.jHB.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.iK().removeCallbacks(d.this.jJG);
                if (d.this.jJB != null) {
                    d.this.jJF = false;
                    d.this.jJB.aBy();
                }
            }
        });
        this.jHB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.iK().removeCallbacks(d.this.jJG);
                d.this.jHB.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.u.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.cyX();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.hdQ = (TextView) inflate.findViewById(R.id.skip);
        this.hdQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.iK().removeCallbacks(d.this.jJG);
                if (d.this.jJB != null) {
                    d.this.jJF = false;
                    d.this.jJB.aBy();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_video_splash_config", "");
        z zVar = new z();
        zVar.parseJson(string);
        final String amZ = zVar.amZ();
        this.jxj = inflate.findViewById(R.id.tip_container);
        this.jxj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!aq.isEmpty(amZ)) {
                    d.this.jJF = false;
                    d.this.jJB.aBy();
                    ba.ajK().c(d.this.jJA.getPageContext(), new String[]{amZ});
                }
            }
        });
        this.dNl = (TextView) inflate.findViewById(R.id.tip_text);
        String ana = zVar.ana();
        if (aq.isEmpty(ana)) {
            ana = this.jJA.getString(R.string.video_splash_tip_default);
        }
        this.dNl.setText(ana);
        cyY();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyX() {
        if (this.jHB != null) {
            this.jHB.setBackgroundResource(0);
        }
    }

    private void cyY() {
        if (this.jJD != null && this.jJD.cyU()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.jJD.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.jHB != null) {
                    this.jHB.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jHB != null) {
                    this.jHB.setBackgroundColor(this.jJA.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.jJF = true;
        if (this.jHB != null) {
            this.jHB.resume();
        }
    }

    public void onPause() {
        if (this.jHB != null) {
            this.jJE = this.jHB.getCurrentPosition();
            this.jHB.stopPlayback();
            if (this.jJF) {
                cyY();
            }
        }
    }

    public void onDestroy() {
        e.iK().removeCallbacks(this.jJG);
    }

    public void a(a aVar) {
        this.jJB = aVar;
    }
}

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
    private TextView eWJ;
    private TextView hVa;
    private ScaleVideoView kEZ;
    private LogoActivity kHA;
    private a kHB;
    private int kHE;
    private View kvg;
    private View mRootView;
    private boolean kHF = true;
    private Runnable kHG = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.kHB != null) {
                d.this.kHB.onError();
            }
        }
    };
    private com.baidu.tieba.w.a kHC = new com.baidu.tieba.w.a();
    private c kHD = new c();

    /* loaded from: classes.dex */
    public interface a {
        void aWj();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.kHE = 0;
        this.kHA = logoActivity;
        this.kHE = 0;
    }

    public boolean cTo() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.kHC == null || this.kHD == null) {
            return false;
        }
        return this.kHC.cTo() && this.kHD.cTq();
    }

    public void cTr() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.kHD != null) {
                this.kHD.deleteVideo();
            }
            com.baidu.tbadk.core.sharedPref.b.aFD().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
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
        e.gx().postDelayed(this.kHG, 1000L);
        load();
    }

    private void load() {
        if (this.kHD != null && !aq.isEmpty(this.kHD.getVideoPath())) {
            this.kEZ.setVideoPath(this.kHD.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.kHC != null) {
            this.kHC.eI(System.currentTimeMillis());
        }
        if (this.kHE >= 0) {
            this.kEZ.seekTo(this.kHE);
        }
        this.kEZ.start();
    }

    private View s(double d) {
        View inflate = LayoutInflater.from(this.kHA).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.kHA) * d)));
        this.kEZ = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.kEZ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.gx().removeCallbacks(d.this.kHG);
                if (d.this.kHB != null) {
                    d.this.kHF = false;
                    d.this.kHB.onError();
                    return true;
                }
                return true;
            }
        });
        this.kEZ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.gx().removeCallbacks(d.this.kHG);
                if (d.this.kHB != null) {
                    d.this.kHF = false;
                    d.this.kHB.aWj();
                }
            }
        });
        this.kEZ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.gx().removeCallbacks(d.this.kHG);
                d.this.kEZ.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.cTs();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.hVa = (TextView) inflate.findViewById(R.id.skip);
        this.hVa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.gx().removeCallbacks(d.this.kHG);
                if (d.this.kHB != null) {
                    d.this.kHF = false;
                    d.this.kHB.aWj();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ab abVar = new ab();
        abVar.parseJson(string);
        final String aJM = abVar.aJM();
        this.kvg = inflate.findViewById(R.id.tip_container);
        this.kvg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!aq.isEmpty(aJM)) {
                    d.this.kHF = false;
                    d.this.kHB.aWj();
                    ba.aGG().b(d.this.kHA.getPageContext(), new String[]{aJM});
                }
            }
        });
        this.eWJ = (TextView) inflate.findViewById(R.id.tip_text);
        String aJN = abVar.aJN();
        if (aq.isEmpty(aJN)) {
            aJN = this.kHA.getString(R.string.video_splash_tip_default);
        }
        this.eWJ.setText(aJN);
        cTt();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTs() {
        if (this.kEZ != null) {
            this.kEZ.setBackgroundResource(0);
        }
    }

    private void cTt() {
        if (this.kHD != null && this.kHD.cTq()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.kHD.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.kEZ != null) {
                    this.kEZ.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.kEZ != null) {
                    this.kEZ.setBackgroundColor(this.kHA.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.kHF = true;
        if (this.kEZ != null) {
            this.kEZ.resume();
        }
    }

    public void onPause() {
        if (this.kEZ != null) {
            this.kHE = this.kEZ.getCurrentPosition();
            this.kEZ.stopPlayback();
            if (this.kHF) {
                cTt();
            }
        }
    }

    public void onDestroy() {
        e.gx().removeCallbacks(this.kHG);
    }

    public void a(a aVar) {
        this.kHB = aVar;
    }
}

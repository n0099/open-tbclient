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
    private TextView fPC;
    private TextView iVv;
    private ScaleVideoView lJR;
    private LogoActivity lLW;
    private a lLX;
    private int lMa;
    private View lzM;
    private View mRootView;
    private boolean lMb = true;
    private Runnable lMc = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.lLX != null) {
                d.this.lLX.onError();
            }
        }
    };
    private com.baidu.tieba.w.a lLY = new com.baidu.tieba.w.a();
    private c lLZ = new c();

    /* loaded from: classes.dex */
    public interface a {
        void NW();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.lMa = 0;
        this.lLW = logoActivity;
        this.lMa = 0;
    }

    public boolean dlI() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.lLY == null || this.lLZ == null) {
            return false;
        }
        return this.lLY.dlI() && this.lLZ.dlK();
    }

    public void dlM() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.lLZ != null) {
                this.lLZ.dlL();
            }
            com.baidu.tbadk.core.sharedPref.b.aTX().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View y(double d) {
        if (this.mRootView == null) {
            this.mRootView = z(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new an("c12944"));
        e.ld().postDelayed(this.lMc, 1000L);
        load();
    }

    private void load() {
        if (this.lLZ != null && !aq.isEmpty(this.lLZ.getVideoPath())) {
            this.lJR.setVideoPath(this.lLZ.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.lLY != null) {
            this.lLY.fv(System.currentTimeMillis());
        }
        if (this.lMa >= 0) {
            this.lJR.seekTo(this.lMa);
        }
        this.lJR.start();
    }

    private View z(double d) {
        View inflate = LayoutInflater.from(this.lLW).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.lLW) * d)));
        this.lJR = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.lJR.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.ld().removeCallbacks(d.this.lMc);
                if (d.this.lLX != null) {
                    d.this.lMb = false;
                    d.this.lLX.onError();
                    return true;
                }
                return true;
            }
        });
        this.lJR.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.ld().removeCallbacks(d.this.lMc);
                if (d.this.lLX != null) {
                    d.this.lMb = false;
                    d.this.lLX.NW();
                }
            }
        });
        this.lJR.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.ld().removeCallbacks(d.this.lMc);
                d.this.lJR.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dlN();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.iVv = (TextView) inflate.findViewById(R.id.skip);
        this.iVv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.ld().removeCallbacks(d.this.lMc);
                if (d.this.lLX != null) {
                    d.this.lMb = false;
                    d.this.lLX.NW();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ab abVar = new ab();
        abVar.parseJson(string);
        final String aYr = abVar.aYr();
        this.lzM = inflate.findViewById(R.id.tip_container);
        this.lzM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!aq.isEmpty(aYr)) {
                    d.this.lMb = false;
                    d.this.lLX.NW();
                    ba.aUZ().b(d.this.lLW.getPageContext(), new String[]{aYr});
                }
            }
        });
        this.fPC = (TextView) inflate.findViewById(R.id.tip_text);
        String aYs = abVar.aYs();
        if (aq.isEmpty(aYs)) {
            aYs = this.lLW.getString(R.string.video_splash_tip_default);
        }
        this.fPC.setText(aYs);
        dlO();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlN() {
        if (this.lJR != null) {
            this.lJR.setBackgroundResource(0);
        }
    }

    private void dlO() {
        if (this.lLZ != null && this.lLZ.dlK()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.lLZ.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.lJR != null) {
                    this.lJR.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.lJR != null) {
                    this.lJR.setBackgroundColor(this.lLW.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.lMb = true;
        if (this.lJR != null) {
            this.lJR.resume();
        }
    }

    public void onPause() {
        if (this.lJR != null) {
            this.lMa = this.lJR.getCurrentPosition();
            this.lJR.stopPlayback();
            if (this.lMb) {
                dlO();
            }
        }
    }

    public void onDestroy() {
        e.ld().removeCallbacks(this.lMc);
    }

    public void a(a aVar) {
        this.lLX = aVar;
    }
}

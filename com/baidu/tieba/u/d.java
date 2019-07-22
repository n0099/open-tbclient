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
    private TextView dLt;
    private TextView hbe;
    private ScaleVideoView jDY;
    private LogoActivity jFY;
    private a jFZ;
    private int jGc;
    private View jtG;
    private View mRootView;
    private boolean jGd = true;
    private Runnable jGe = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jFZ != null) {
                d.this.jFZ.onError();
            }
        }
    };
    private com.baidu.tieba.u.a jGa = new com.baidu.tieba.u.a();
    private c jGb = new c();

    /* loaded from: classes.dex */
    public interface a {
        void aBi();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.jGc = 0;
        this.jFY = logoActivity;
        this.jGc = 0;
    }

    public boolean cxH() {
        if (!(com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_video_splash_switch", 0) == 1) || this.jGa == null || this.jGb == null) {
            return false;
        }
        return this.jGa.cxH() && this.jGb.cxK();
    }

    public void cxM() {
        if (!(com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.jGb != null) {
                this.jGb.cxL();
            }
            com.baidu.tbadk.core.sharedPref.b.ahO().putLong("key_video_splash_last_show_time", 0L);
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
        e.iK().postDelayed(this.jGe, 1000L);
        load();
    }

    private void load() {
        if (this.jGb != null && !aq.isEmpty(this.jGb.getVideoPath())) {
            this.jDY.setVideoPath(this.jGb.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.jGa != null) {
            this.jGa.eE(System.currentTimeMillis());
        }
        if (this.jGc >= 0) {
            this.jDY.seekTo(this.jGc);
        }
        this.jDY.start();
    }

    private View p(double d) {
        View inflate = LayoutInflater.from(this.jFY).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.ah(this.jFY) * d)));
        this.jDY = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.jDY.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.iK().removeCallbacks(d.this.jGe);
                if (d.this.jFZ != null) {
                    d.this.jGd = false;
                    d.this.jFZ.onError();
                    return true;
                }
                return true;
            }
        });
        this.jDY.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.iK().removeCallbacks(d.this.jGe);
                if (d.this.jFZ != null) {
                    d.this.jGd = false;
                    d.this.jFZ.aBi();
                }
            }
        });
        this.jDY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.iK().removeCallbacks(d.this.jGe);
                d.this.jDY.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.u.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.cxN();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.hbe = (TextView) inflate.findViewById(R.id.skip);
        this.hbe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.iK().removeCallbacks(d.this.jGe);
                if (d.this.jFZ != null) {
                    d.this.jGd = false;
                    d.this.jFZ.aBi();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.ahO().getString("key_video_splash_config", "");
        y yVar = new y();
        yVar.parseJson(string);
        final String amL = yVar.amL();
        this.jtG = inflate.findViewById(R.id.tip_container);
        this.jtG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!aq.isEmpty(amL)) {
                    d.this.jGd = false;
                    d.this.jFZ.aBi();
                    bb.ajC().c(d.this.jFY.getPageContext(), new String[]{amL});
                }
            }
        });
        this.dLt = (TextView) inflate.findViewById(R.id.tip_text);
        String amM = yVar.amM();
        if (aq.isEmpty(amM)) {
            amM = this.jFY.getString(R.string.video_splash_tip_default);
        }
        this.dLt.setText(amM);
        cxO();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxN() {
        if (this.jDY != null) {
            this.jDY.setBackgroundResource(0);
        }
    }

    private void cxO() {
        if (this.jGb != null && this.jGb.cxK()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.jGb.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.jDY != null) {
                    this.jDY.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jDY != null) {
                    this.jDY.setBackgroundColor(this.jFY.getResources().getColor(R.color.cp_btn_a));
                }
            }
        }
    }

    public void onResume() {
        this.jGd = true;
        if (this.jDY != null) {
            this.jDY.resume();
        }
    }

    public void onPause() {
        if (this.jDY != null) {
            this.jGc = this.jDY.getCurrentPosition();
            this.jDY.stopPlayback();
            if (this.jGd) {
                cxO();
            }
        }
    }

    public void onDestroy() {
        e.iK().removeCallbacks(this.jGe);
    }

    public void a(a aVar) {
        this.jFZ = aVar;
    }
}

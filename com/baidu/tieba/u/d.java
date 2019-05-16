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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private TextView dHK;
    private TextView gUO;
    private View jnu;
    private ScaleVideoView jxL;
    private LogoActivity jzL;
    private a jzM;
    private int jzP;
    private View mRootView;
    private boolean jzQ = true;
    private Runnable jzR = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jzM != null) {
                d.this.jzM.onError();
            }
        }
    };
    private com.baidu.tieba.u.a jzN = new com.baidu.tieba.u.a();
    private c jzO = new c();

    /* loaded from: classes.dex */
    public interface a {
        void azR();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.jzP = 0;
        this.jzL = logoActivity;
        this.jzP = 0;
    }

    public boolean cuR() {
        if (!(com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_video_splash_switch", 0) == 1) || this.jzN == null || this.jzO == null) {
            return false;
        }
        return this.jzN.cuR() && this.jzO.cuU();
    }

    public void cuW() {
        if (!(com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.jzO != null) {
                this.jzO.cuV();
            }
            com.baidu.tbadk.core.sharedPref.b.agM().putLong("key_video_splash_last_show_time", 0L);
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
        e.iB().postDelayed(this.jzR, 1000L);
        load();
    }

    private void load() {
        if (this.jzO != null && !ap.isEmpty(this.jzO.getVideoPath())) {
            this.jxL.setVideoPath(this.jzO.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.jzN != null) {
            this.jzN.ew(System.currentTimeMillis());
        }
        if (this.jzP >= 0) {
            this.jxL.seekTo(this.jzP);
        }
        this.jxL.start();
    }

    private View p(double d) {
        View inflate = LayoutInflater.from(this.jzL).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.ah(this.jzL) * d)));
        this.jxL = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.jxL.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.iB().removeCallbacks(d.this.jzR);
                if (d.this.jzM != null) {
                    d.this.jzQ = false;
                    d.this.jzM.onError();
                    return true;
                }
                return true;
            }
        });
        this.jxL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.iB().removeCallbacks(d.this.jzR);
                if (d.this.jzM != null) {
                    d.this.jzQ = false;
                    d.this.jzM.azR();
                }
            }
        });
        this.jxL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.iB().removeCallbacks(d.this.jzR);
                d.this.jxL.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.u.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.cuX();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.gUO = (TextView) inflate.findViewById(R.id.skip);
        this.gUO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.iB().removeCallbacks(d.this.jzR);
                if (d.this.jzM != null) {
                    d.this.jzQ = false;
                    d.this.jzM.azR();
                }
                TiebaStatic.log(new am("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("key_video_splash_config", "");
        y yVar = new y();
        yVar.parseJson(string);
        final String alG = yVar.alG();
        this.jnu = inflate.findViewById(R.id.tip_container);
        this.jnu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12945"));
                if (!ap.isEmpty(alG)) {
                    d.this.jzQ = false;
                    d.this.jzM.azR();
                    ba.aiz().c(d.this.jzL.getPageContext(), new String[]{alG});
                }
            }
        });
        this.dHK = (TextView) inflate.findViewById(R.id.tip_text);
        String alH = yVar.alH();
        if (ap.isEmpty(alH)) {
            alH = this.jzL.getString(R.string.video_splash_tip_default);
        }
        this.dHK.setText(alH);
        cuY();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuX() {
        if (this.jxL != null) {
            this.jxL.setBackgroundResource(0);
        }
    }

    private void cuY() {
        if (this.jzO != null && this.jzO.cuU()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.jzO.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.jxL != null) {
                    this.jxL.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jxL != null) {
                    this.jxL.setBackgroundColor(this.jzL.getResources().getColor(R.color.cp_btn_a));
                }
            }
        }
    }

    public void onResume() {
        this.jzQ = true;
        if (this.jxL != null) {
            this.jxL.resume();
        }
    }

    public void onPause() {
        if (this.jxL != null) {
            this.jzP = this.jxL.getCurrentPosition();
            this.jxL.stopPlayback();
            if (this.jzQ) {
                cuY();
            }
        }
    }

    public void onDestroy() {
        e.iB().removeCallbacks(this.jzR);
    }

    public void a(a aVar) {
        this.jzM = aVar;
    }
}

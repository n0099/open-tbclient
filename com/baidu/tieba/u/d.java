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
    private TextView dHL;
    private TextView gUT;
    private View jnz;
    private ScaleVideoView jxP;
    private LogoActivity jzP;
    private a jzQ;
    private int jzT;
    private View mRootView;
    private boolean jzU = true;
    private Runnable jzV = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jzQ != null) {
                d.this.jzQ.onError();
            }
        }
    };
    private com.baidu.tieba.u.a jzR = new com.baidu.tieba.u.a();
    private c jzS = new c();

    /* loaded from: classes.dex */
    public interface a {
        void azU();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.jzT = 0;
        this.jzP = logoActivity;
        this.jzT = 0;
    }

    public boolean cuS() {
        if (!(com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_video_splash_switch", 0) == 1) || this.jzR == null || this.jzS == null) {
            return false;
        }
        return this.jzR.cuS() && this.jzS.cuV();
    }

    public void cuX() {
        if (!(com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.jzS != null) {
                this.jzS.cuW();
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
        e.iB().postDelayed(this.jzV, 1000L);
        load();
    }

    private void load() {
        if (this.jzS != null && !ap.isEmpty(this.jzS.getVideoPath())) {
            this.jxP.setVideoPath(this.jzS.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.jzR != null) {
            this.jzR.ew(System.currentTimeMillis());
        }
        if (this.jzT >= 0) {
            this.jxP.seekTo(this.jzT);
        }
        this.jxP.start();
    }

    private View p(double d) {
        View inflate = LayoutInflater.from(this.jzP).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.ah(this.jzP) * d)));
        this.jxP = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.jxP.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.iB().removeCallbacks(d.this.jzV);
                if (d.this.jzQ != null) {
                    d.this.jzU = false;
                    d.this.jzQ.onError();
                    return true;
                }
                return true;
            }
        });
        this.jxP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.iB().removeCallbacks(d.this.jzV);
                if (d.this.jzQ != null) {
                    d.this.jzU = false;
                    d.this.jzQ.azU();
                }
            }
        });
        this.jxP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.iB().removeCallbacks(d.this.jzV);
                d.this.jxP.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.u.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.cuY();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.gUT = (TextView) inflate.findViewById(R.id.skip);
        this.gUT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.iB().removeCallbacks(d.this.jzV);
                if (d.this.jzQ != null) {
                    d.this.jzU = false;
                    d.this.jzQ.azU();
                }
                TiebaStatic.log(new am("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("key_video_splash_config", "");
        y yVar = new y();
        yVar.parseJson(string);
        final String alG = yVar.alG();
        this.jnz = inflate.findViewById(R.id.tip_container);
        this.jnz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12945"));
                if (!ap.isEmpty(alG)) {
                    d.this.jzU = false;
                    d.this.jzQ.azU();
                    ba.aiz().c(d.this.jzP.getPageContext(), new String[]{alG});
                }
            }
        });
        this.dHL = (TextView) inflate.findViewById(R.id.tip_text);
        String alH = yVar.alH();
        if (ap.isEmpty(alH)) {
            alH = this.jzP.getString(R.string.video_splash_tip_default);
        }
        this.dHL.setText(alH);
        cuZ();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuY() {
        if (this.jxP != null) {
            this.jxP.setBackgroundResource(0);
        }
    }

    private void cuZ() {
        if (this.jzS != null && this.jzS.cuV()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.jzS.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.jxP != null) {
                    this.jxP.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jxP != null) {
                    this.jxP.setBackgroundColor(this.jzP.getResources().getColor(R.color.cp_btn_a));
                }
            }
        }
    }

    public void onResume() {
        this.jzU = true;
        if (this.jxP != null) {
            this.jxP.resume();
        }
    }

    public void onPause() {
        if (this.jxP != null) {
            this.jzT = this.jxP.getCurrentPosition();
            this.jxP.stopPlayback();
            if (this.jzU) {
                cuZ();
            }
        }
    }

    public void onDestroy() {
        e.iB().removeCallbacks(this.jzV);
    }

    public void a(a aVar) {
        this.jzQ = aVar;
    }
}

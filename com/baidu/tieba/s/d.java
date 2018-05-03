package com.baidu.tieba.s;

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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    private TextView bCQ;
    private TextView esy;
    private View gJN;
    private ScaleVideoView gUp;
    private LogoActivity gWq;
    private a gWr;
    private int gWu;
    private View mRootView;
    private boolean gWv = true;
    private Runnable gWw = new Runnable() { // from class: com.baidu.tieba.s.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.gWr != null) {
                d.this.gWr.onError();
            }
        }
    };
    private com.baidu.tieba.s.a gWs = new com.baidu.tieba.s.a();
    private c gWt = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Lt();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.gWu = 0;
        this.gWq = logoActivity;
        this.gWu = 0;
    }

    public boolean bzS() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.gWs == null || this.gWt == null) {
            return false;
        }
        return this.gWs.bzS() && this.gWt.bzV();
    }

    public void bzX() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.gWt != null) {
                this.gWt.bzW();
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", 0L);
        }
    }

    public View p(double d) {
        if (this.mRootView == null) {
            this.mRootView = q(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new al("c12944"));
        e.fw().postDelayed(this.gWw, 1000L);
        load();
    }

    private void load() {
        if (this.gWt != null && !an.isEmpty(this.gWt.getVideoPath())) {
            this.gUp.setVideoPath(this.gWt.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.gWs != null) {
            this.gWs.cZ(System.currentTimeMillis());
        }
        if (this.gWu >= 0) {
            this.gUp.seekTo(this.gWu);
        }
        this.gUp.start();
    }

    private View q(double d) {
        View inflate = LayoutInflater.from(this.gWq).inflate(d.i.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.ah(this.gWq) * d)));
        this.gUp = (ScaleVideoView) inflate.findViewById(d.g.video);
        this.gUp.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.s.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.fw().removeCallbacks(d.this.gWw);
                if (d.this.gWr != null) {
                    d.this.gWv = false;
                    d.this.gWr.onError();
                    return true;
                }
                return true;
            }
        });
        this.gUp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.s.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.fw().removeCallbacks(d.this.gWw);
                if (d.this.gWr != null) {
                    d.this.gWv = false;
                    d.this.gWr.Lt();
                }
            }
        });
        this.gUp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.s.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.fw().removeCallbacks(d.this.gWw);
                d.this.gUp.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.s.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.bzY();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.esy = (TextView) inflate.findViewById(d.g.skip);
        this.esy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.s.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.fw().removeCallbacks(d.this.gWw);
                if (d.this.gWr != null) {
                    d.this.gWv = false;
                    d.this.gWr.Lt();
                }
                TiebaStatic.log(new al("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        u uVar = new u();
        uVar.parseJson(string);
        final String yR = uVar.yR();
        this.gJN = inflate.findViewById(d.g.tip_container);
        this.gJN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.s.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new al("c12945"));
                if (!an.isEmpty(yR)) {
                    d.this.gWv = false;
                    d.this.gWr.Lt();
                    ax.wg().c(d.this.gWq.getPageContext(), new String[]{yR});
                }
            }
        });
        this.bCQ = (TextView) inflate.findViewById(d.g.tip_text);
        String yS = uVar.yS();
        if (an.isEmpty(yS)) {
            yS = this.gWq.getString(d.k.video_splash_tip_default);
        }
        this.bCQ.setText(yS);
        bzZ();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzY() {
        if (this.gUp != null) {
            this.gUp.setBackgroundResource(0);
        }
    }

    private void bzZ() {
        if (this.gWt != null && this.gWt.bzV()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.gWt.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.gUp != null) {
                    this.gUp.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gUp != null) {
                    this.gUp.setBackgroundColor(this.gWq.getResources().getColor(d.C0126d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.gWv = true;
        if (this.gUp != null) {
            this.gUp.resume();
        }
    }

    public void onPause() {
        if (this.gUp != null) {
            this.gWu = this.gUp.getCurrentPosition();
            this.gUp.stopPlayback();
            if (this.gWv) {
                bzZ();
            }
        }
    }

    public void onDestroy() {
        e.fw().removeCallbacks(this.gWw);
    }

    public void a(a aVar) {
        this.gWr = aVar;
    }
}

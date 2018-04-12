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
    private TextView bCS;
    private TextView esB;
    private View gJQ;
    private ScaleVideoView gUs;
    private LogoActivity gWt;
    private a gWu;
    private int gWx;
    private View mRootView;
    private boolean gWy = true;
    private Runnable gWz = new Runnable() { // from class: com.baidu.tieba.s.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.gWu != null) {
                d.this.gWu.onError();
            }
        }
    };
    private com.baidu.tieba.s.a gWv = new com.baidu.tieba.s.a();
    private c gWw = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Lt();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.gWx = 0;
        this.gWt = logoActivity;
        this.gWx = 0;
    }

    public boolean bzS() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.gWv == null || this.gWw == null) {
            return false;
        }
        return this.gWv.bzS() && this.gWw.bzV();
    }

    public void bzX() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.gWw != null) {
                this.gWw.bzW();
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
        e.fw().postDelayed(this.gWz, 1000L);
        load();
    }

    private void load() {
        if (this.gWw != null && !an.isEmpty(this.gWw.getVideoPath())) {
            this.gUs.setVideoPath(this.gWw.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.gWv != null) {
            this.gWv.cZ(System.currentTimeMillis());
        }
        if (this.gWx >= 0) {
            this.gUs.seekTo(this.gWx);
        }
        this.gUs.start();
    }

    private View q(double d) {
        View inflate = LayoutInflater.from(this.gWt).inflate(d.i.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.ah(this.gWt) * d)));
        this.gUs = (ScaleVideoView) inflate.findViewById(d.g.video);
        this.gUs.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.s.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.fw().removeCallbacks(d.this.gWz);
                if (d.this.gWu != null) {
                    d.this.gWy = false;
                    d.this.gWu.onError();
                    return true;
                }
                return true;
            }
        });
        this.gUs.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.s.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.fw().removeCallbacks(d.this.gWz);
                if (d.this.gWu != null) {
                    d.this.gWy = false;
                    d.this.gWu.Lt();
                }
            }
        });
        this.gUs.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.s.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.fw().removeCallbacks(d.this.gWz);
                d.this.gUs.setMediaPlayer(mediaPlayer);
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
        this.esB = (TextView) inflate.findViewById(d.g.skip);
        this.esB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.s.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.fw().removeCallbacks(d.this.gWz);
                if (d.this.gWu != null) {
                    d.this.gWy = false;
                    d.this.gWu.Lt();
                }
                TiebaStatic.log(new al("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        u uVar = new u();
        uVar.parseJson(string);
        final String yR = uVar.yR();
        this.gJQ = inflate.findViewById(d.g.tip_container);
        this.gJQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.s.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new al("c12945"));
                if (!an.isEmpty(yR)) {
                    d.this.gWy = false;
                    d.this.gWu.Lt();
                    ax.wg().c(d.this.gWt.getPageContext(), new String[]{yR});
                }
            }
        });
        this.bCS = (TextView) inflate.findViewById(d.g.tip_text);
        String yS = uVar.yS();
        if (an.isEmpty(yS)) {
            yS = this.gWt.getString(d.k.video_splash_tip_default);
        }
        this.bCS.setText(yS);
        bzZ();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzY() {
        if (this.gUs != null) {
            this.gUs.setBackgroundResource(0);
        }
    }

    private void bzZ() {
        if (this.gWw != null && this.gWw.bzV()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.gWw.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.gUs != null) {
                    this.gUs.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.gUs != null) {
                    this.gUs.setBackgroundColor(this.gWt.getResources().getColor(d.C0126d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.gWy = true;
        if (this.gUs != null) {
            this.gUs.resume();
        }
    }

    public void onPause() {
        if (this.gUs != null) {
            this.gWx = this.gUs.getCurrentPosition();
            this.gUs.stopPlayback();
            if (this.gWy) {
                bzZ();
            }
        }
    }

    public void onDestroy() {
        e.fw().removeCallbacks(this.gWz);
    }

    public void a(a aVar) {
        this.gWu = aVar;
    }
}

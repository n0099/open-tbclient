package com.baidu.tieba.v;

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
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    private TextView bLP;
    private TextView eEX;
    private View gWs;
    private ScaleVideoView hgU;
    private LogoActivity hiW;
    private a hiX;
    private int hja;
    private View mRootView;
    private boolean hjb = true;
    private Runnable hjc = new Runnable() { // from class: com.baidu.tieba.v.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hiX != null) {
                d.this.hiX.onError();
            }
        }
    };
    private com.baidu.tieba.v.a hiY = new com.baidu.tieba.v.a();
    private c hiZ = new c();

    /* loaded from: classes.dex */
    public interface a {
        void OQ();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.hja = 0;
        this.hiW = logoActivity;
        this.hja = 0;
    }

    public boolean bEV() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.hiY == null || this.hiZ == null) {
            return false;
        }
        return this.hiY.bEV() && this.hiZ.bEY();
    }

    public void bFa() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.hiZ != null) {
                this.hiZ.bEZ();
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", 0L);
        }
    }

    public View q(double d) {
        if (this.mRootView == null) {
            this.mRootView = r(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new am("c12944"));
        e.im().postDelayed(this.hjc, 1000L);
        load();
    }

    private void load() {
        if (this.hiZ != null && !ao.isEmpty(this.hiZ.getVideoPath())) {
            this.hgU.setVideoPath(this.hiZ.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.hiY != null) {
            this.hiY.dg(System.currentTimeMillis());
        }
        if (this.hja >= 0) {
            this.hgU.seekTo(this.hja);
        }
        this.hgU.start();
    }

    private View r(double d) {
        View inflate = LayoutInflater.from(this.hiW).inflate(d.i.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aj(this.hiW) * d)));
        this.hgU = (ScaleVideoView) inflate.findViewById(d.g.video);
        this.hgU.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.v.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.im().removeCallbacks(d.this.hjc);
                if (d.this.hiX != null) {
                    d.this.hjb = false;
                    d.this.hiX.onError();
                    return true;
                }
                return true;
            }
        });
        this.hgU.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.v.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.im().removeCallbacks(d.this.hjc);
                if (d.this.hiX != null) {
                    d.this.hjb = false;
                    d.this.hiX.OQ();
                }
            }
        });
        this.hgU.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.v.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.im().removeCallbacks(d.this.hjc);
                d.this.hgU.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.v.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.bFb();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.eEX = (TextView) inflate.findViewById(d.g.skip);
        this.eEX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.im().removeCallbacks(d.this.hjc);
                if (d.this.hiX != null) {
                    d.this.hjb = false;
                    d.this.hiX.OQ();
                }
                TiebaStatic.log(new am("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        u uVar = new u();
        uVar.parseJson(string);
        final String Cq = uVar.Cq();
        this.gWs = inflate.findViewById(d.g.tip_container);
        this.gWs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12945"));
                if (!ao.isEmpty(Cq)) {
                    d.this.hjb = false;
                    d.this.hiX.OQ();
                    ay.zG().c(d.this.hiW.getPageContext(), new String[]{Cq});
                }
            }
        });
        this.bLP = (TextView) inflate.findViewById(d.g.tip_text);
        String Cr = uVar.Cr();
        if (ao.isEmpty(Cr)) {
            Cr = this.hiW.getString(d.k.video_splash_tip_default);
        }
        this.bLP.setText(Cr);
        bFc();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFb() {
        if (this.hgU != null) {
            this.hgU.setBackgroundResource(0);
        }
    }

    private void bFc() {
        if (this.hiZ != null && this.hiZ.bEY()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.hiZ.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.hgU != null) {
                    this.hgU.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hgU != null) {
                    this.hgU.setBackgroundColor(this.hiW.getResources().getColor(d.C0141d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.hjb = true;
        if (this.hgU != null) {
            this.hgU.resume();
        }
    }

    public void onPause() {
        if (this.hgU != null) {
            this.hja = this.hgU.getCurrentPosition();
            this.hgU.stopPlayback();
            if (this.hjb) {
                bFc();
            }
        }
    }

    public void onDestroy() {
        e.im().removeCallbacks(this.hjc);
    }

    public void a(a aVar) {
        this.hiX = aVar;
    }
}

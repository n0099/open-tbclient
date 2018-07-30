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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    private TextView bOT;
    private TextView eMH;
    private View hbK;
    private ScaleVideoView hmp;
    private LogoActivity hoj;
    private a hok;
    private int hon;
    private View mRootView;
    private boolean hoo = true;
    private Runnable hop = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hok != null) {
                d.this.hok.onError();
            }
        }
    };
    private com.baidu.tieba.u.a hol = new com.baidu.tieba.u.a();
    private c hom = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Pp();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.hon = 0;
        this.hoj = logoActivity;
        this.hon = 0;
    }

    public boolean bEg() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.hol == null || this.hom == null) {
            return false;
        }
        return this.hol.bEg() && this.hom.bEj();
    }

    public void bEl() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.hom != null) {
                this.hom.bEk();
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", 0L);
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
        e.in().postDelayed(this.hop, 1000L);
        load();
    }

    private void load() {
        if (this.hom != null && !ap.isEmpty(this.hom.getVideoPath())) {
            this.hmp.setVideoPath(this.hom.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.hol != null) {
            this.hol.db(System.currentTimeMillis());
        }
        if (this.hon >= 0) {
            this.hmp.seekTo(this.hon);
        }
        this.hmp.start();
    }

    private View p(double d) {
        View inflate = LayoutInflater.from(this.hoj).inflate(d.h.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aj(this.hoj) * d)));
        this.hmp = (ScaleVideoView) inflate.findViewById(d.g.video);
        this.hmp.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.in().removeCallbacks(d.this.hop);
                if (d.this.hok != null) {
                    d.this.hoo = false;
                    d.this.hok.onError();
                    return true;
                }
                return true;
            }
        });
        this.hmp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.in().removeCallbacks(d.this.hop);
                if (d.this.hok != null) {
                    d.this.hoo = false;
                    d.this.hok.Pp();
                }
            }
        });
        this.hmp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.in().removeCallbacks(d.this.hop);
                d.this.hmp.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.u.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.bEm();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.eMH = (TextView) inflate.findViewById(d.g.skip);
        this.eMH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.in().removeCallbacks(d.this.hop);
                if (d.this.hok != null) {
                    d.this.hoo = false;
                    d.this.hok.Pp();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        u uVar = new u();
        uVar.parseJson(string);
        final String CA = uVar.CA();
        this.hbK = inflate.findViewById(d.g.tip_container);
        this.hbK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!ap.isEmpty(CA)) {
                    d.this.hoo = false;
                    d.this.hok.Pp();
                    ay.zK().c(d.this.hoj.getPageContext(), new String[]{CA});
                }
            }
        });
        this.bOT = (TextView) inflate.findViewById(d.g.tip_text);
        String CB = uVar.CB();
        if (ap.isEmpty(CB)) {
            CB = this.hoj.getString(d.j.video_splash_tip_default);
        }
        this.bOT.setText(CB);
        bEn();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEm() {
        if (this.hmp != null) {
            this.hmp.setBackgroundResource(0);
        }
    }

    private void bEn() {
        if (this.hom != null && this.hom.bEj()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.hom.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.hmp != null) {
                    this.hmp.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hmp != null) {
                    this.hmp.setBackgroundColor(this.hoj.getResources().getColor(d.C0140d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.hoo = true;
        if (this.hmp != null) {
            this.hmp.resume();
        }
    }

    public void onPause() {
        if (this.hmp != null) {
            this.hon = this.hmp.getCurrentPosition();
            this.hmp.stopPlayback();
            if (this.hoo) {
                bEn();
            }
        }
    }

    public void onDestroy() {
        e.in().removeCallbacks(this.hop);
    }

    public void a(a aVar) {
        this.hok = aVar;
    }
}

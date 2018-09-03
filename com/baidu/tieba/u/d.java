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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class d {
    private TextView bOS;
    private TextView eMC;
    private View hbL;
    private ScaleVideoView hmq;
    private LogoActivity hok;
    private a hol;
    private int hoo;
    private View mRootView;
    private boolean hop = true;
    private Runnable hoq = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.hol != null) {
                d.this.hol.onError();
            }
        }
    };
    private com.baidu.tieba.u.a hom = new com.baidu.tieba.u.a();
    private c hon = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Pv();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.hoo = 0;
        this.hok = logoActivity;
        this.hoo = 0;
    }

    public boolean bEi() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1) || this.hom == null || this.hon == null) {
            return false;
        }
        return this.hom.bEi() && this.hon.bEl();
    }

    public void bEn() {
        if (!(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_splash_switch", 0) == 1)) {
            if (this.hon != null) {
                this.hon.bEm();
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_video_splash_last_show_time", 0L);
        }
    }

    public View n(double d) {
        if (this.mRootView == null) {
            this.mRootView = o(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new an("c12944"));
        e.in().postDelayed(this.hoq, 1000L);
        load();
    }

    private void load() {
        if (this.hon != null && !ap.isEmpty(this.hon.getVideoPath())) {
            this.hmq.setVideoPath(this.hon.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.hom != null) {
            this.hom.db(System.currentTimeMillis());
        }
        if (this.hoo >= 0) {
            this.hmq.seekTo(this.hoo);
        }
        this.hmq.start();
    }

    private View o(double d) {
        View inflate = LayoutInflater.from(this.hok).inflate(f.h.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.aj(this.hok) * d)));
        this.hmq = (ScaleVideoView) inflate.findViewById(f.g.video);
        this.hmq.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.in().removeCallbacks(d.this.hoq);
                if (d.this.hol != null) {
                    d.this.hop = false;
                    d.this.hol.onError();
                    return true;
                }
                return true;
            }
        });
        this.hmq.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.in().removeCallbacks(d.this.hoq);
                if (d.this.hol != null) {
                    d.this.hop = false;
                    d.this.hol.Pv();
                }
            }
        });
        this.hmq.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.in().removeCallbacks(d.this.hoq);
                d.this.hmq.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.u.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.bEo();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.eMC = (TextView) inflate.findViewById(f.g.skip);
        this.eMC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.in().removeCallbacks(d.this.hoq);
                if (d.this.hol != null) {
                    d.this.hop = false;
                    d.this.hol.Pv();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_video_splash_config", "");
        v vVar = new v();
        vVar.parseJson(string);
        final String Cy = vVar.Cy();
        this.hbL = inflate.findViewById(f.g.tip_container);
        this.hbL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!ap.isEmpty(Cy)) {
                    d.this.hop = false;
                    d.this.hol.Pv();
                    az.zI().c(d.this.hok.getPageContext(), new String[]{Cy});
                }
            }
        });
        this.bOS = (TextView) inflate.findViewById(f.g.tip_text);
        String Cz = vVar.Cz();
        if (ap.isEmpty(Cz)) {
            Cz = this.hok.getString(f.j.video_splash_tip_default);
        }
        this.bOS.setText(Cz);
        bEp();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEo() {
        if (this.hmq != null) {
            this.hmq.setBackgroundResource(0);
        }
    }

    private void bEp() {
        if (this.hon != null && this.hon.bEl()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.hon.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.hmq != null) {
                    this.hmq.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.hmq != null) {
                    this.hmq.setBackgroundColor(this.hok.getResources().getColor(f.d.cp_cont_i));
                }
            }
        }
    }

    public void onResume() {
        this.hop = true;
        if (this.hmq != null) {
            this.hmq.resume();
        }
    }

    public void onPause() {
        if (this.hmq != null) {
            this.hoo = this.hmq.getCurrentPosition();
            this.hmq.stopPlayback();
            if (this.hop) {
                bEp();
            }
        }
    }

    public void onDestroy() {
        e.in().removeCallbacks(this.hoq);
    }

    public void a(a aVar) {
        this.hol = aVar;
    }
}

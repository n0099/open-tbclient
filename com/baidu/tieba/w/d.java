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
    private TextView fBu;
    private TextView iGr;
    private View lgX;
    private ScaleVideoView lri;
    private LogoActivity lto;
    private a ltp;
    private int ltt;
    private View mRootView;
    private boolean ltu = true;
    private Runnable ltv = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ltp != null) {
                d.this.ltp.onError();
            }
        }
    };
    private com.baidu.tieba.w.a ltq = new com.baidu.tieba.w.a();
    private c lts = new c();

    /* loaded from: classes.dex */
    public interface a {
        void LK();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.ltt = 0;
        this.lto = logoActivity;
        this.ltt = 0;
    }

    public boolean dev() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aNV().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.ltq == null || this.lts == null) {
            return false;
        }
        return this.ltq.dev() && this.lts.dex();
    }

    public void dez() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aNV().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.lts != null) {
                this.lts.dey();
            }
            com.baidu.tbadk.core.sharedPref.b.aNV().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View x(double d) {
        if (this.mRootView == null) {
            this.mRootView = y(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new an("c12944"));
        e.lb().postDelayed(this.ltv, 1000L);
        load();
    }

    private void load() {
        if (this.lts != null && !aq.isEmpty(this.lts.getVideoPath())) {
            this.lri.setVideoPath(this.lts.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.ltq != null) {
            this.ltq.fv(System.currentTimeMillis());
        }
        if (this.ltt >= 0) {
            this.lri.seekTo(this.ltt);
        }
        this.lri.start();
    }

    private View y(double d) {
        View inflate = LayoutInflater.from(this.lto).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.lto) * d)));
        this.lri = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.lri.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.lb().removeCallbacks(d.this.ltv);
                if (d.this.ltp != null) {
                    d.this.ltu = false;
                    d.this.ltp.onError();
                    return true;
                }
                return true;
            }
        });
        this.lri.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.lb().removeCallbacks(d.this.ltv);
                if (d.this.ltp != null) {
                    d.this.ltu = false;
                    d.this.ltp.LK();
                }
            }
        });
        this.lri.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.lb().removeCallbacks(d.this.ltv);
                d.this.lri.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.deA();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.iGr = (TextView) inflate.findViewById(R.id.skip);
        this.iGr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.lb().removeCallbacks(d.this.ltv);
                if (d.this.ltp != null) {
                    d.this.ltu = false;
                    d.this.ltp.LK();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ab abVar = new ab();
        abVar.parseJson(string);
        final String aSn = abVar.aSn();
        this.lgX = inflate.findViewById(R.id.tip_container);
        this.lgX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!aq.isEmpty(aSn)) {
                    d.this.ltu = false;
                    d.this.ltp.LK();
                    ba.aOY().b(d.this.lto.getPageContext(), new String[]{aSn});
                }
            }
        });
        this.fBu = (TextView) inflate.findViewById(R.id.tip_text);
        String aSo = abVar.aSo();
        if (aq.isEmpty(aSo)) {
            aSo = this.lto.getString(R.string.video_splash_tip_default);
        }
        this.fBu.setText(aSo);
        deB();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deA() {
        if (this.lri != null) {
            this.lri.setBackgroundResource(0);
        }
    }

    private void deB() {
        if (this.lts != null && this.lts.dex()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.lts.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.lri != null) {
                    this.lri.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.lri != null) {
                    this.lri.setBackgroundColor(this.lto.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.ltu = true;
        if (this.lri != null) {
            this.lri.resume();
        }
    }

    public void onPause() {
        if (this.lri != null) {
            this.ltt = this.lri.getCurrentPosition();
            this.lri.stopPlayback();
            if (this.ltu) {
                deB();
            }
        }
    }

    public void onDestroy() {
        e.lb().removeCallbacks(this.ltv);
    }

    public void a(a aVar) {
        this.ltp = aVar;
    }
}

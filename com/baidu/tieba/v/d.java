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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private TextView eSE;
    private TextView hSO;
    private ScaleVideoView kDQ;
    private LogoActivity kGr;
    private a kGs;
    private int kGv;
    private View ktV;
    private View mRootView;
    private boolean kGw = true;
    private Runnable kGx = new Runnable() { // from class: com.baidu.tieba.v.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.kGs != null) {
                d.this.kGs.onError();
            }
        }
    };
    private com.baidu.tieba.v.a kGt = new com.baidu.tieba.v.a();
    private c kGu = new c();

    /* loaded from: classes.dex */
    public interface a {
        void aTQ();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.kGv = 0;
        this.kGr = logoActivity;
        this.kGv = 0;
    }

    public boolean cRQ() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aDr().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.kGt == null || this.kGu == null) {
            return false;
        }
        return this.kGt.cRQ() && this.kGu.cRS();
    }

    public void cRT() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aDr().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.kGu != null) {
                this.kGu.deleteVideo();
            }
            com.baidu.tbadk.core.sharedPref.b.aDr().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View r(double d) {
        if (this.mRootView == null) {
            this.mRootView = s(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new an("c12944"));
        e.gx().postDelayed(this.kGx, 1000L);
        load();
    }

    private void load() {
        if (this.kGu != null && !aq.isEmpty(this.kGu.getVideoPath())) {
            this.kDQ.setVideoPath(this.kGu.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.kGt != null) {
            this.kGt.eK(System.currentTimeMillis());
        }
        if (this.kGv >= 0) {
            this.kDQ.seekTo(this.kGv);
        }
        this.kDQ.start();
    }

    private View s(double d) {
        View inflate = LayoutInflater.from(this.kGr).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.kGr) * d)));
        this.kDQ = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.kDQ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.v.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.gx().removeCallbacks(d.this.kGx);
                if (d.this.kGs != null) {
                    d.this.kGw = false;
                    d.this.kGs.onError();
                    return true;
                }
                return true;
            }
        });
        this.kDQ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.v.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.gx().removeCallbacks(d.this.kGx);
                if (d.this.kGs != null) {
                    d.this.kGw = false;
                    d.this.kGs.aTQ();
                }
            }
        });
        this.kDQ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.v.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.gx().removeCallbacks(d.this.kGx);
                d.this.kDQ.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.v.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.cRU();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.hSO = (TextView) inflate.findViewById(R.id.skip);
        this.hSO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.gx().removeCallbacks(d.this.kGx);
                if (d.this.kGs != null) {
                    d.this.kGw = false;
                    d.this.kGs.aTQ();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        aa aaVar = new aa();
        aaVar.parseJson(string);
        final String aHq = aaVar.aHq();
        this.ktV = inflate.findViewById(R.id.tip_container);
        this.ktV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!aq.isEmpty(aHq)) {
                    d.this.kGw = false;
                    d.this.kGs.aTQ();
                    ba.aEt().b(d.this.kGr.getPageContext(), new String[]{aHq});
                }
            }
        });
        this.eSE = (TextView) inflate.findViewById(R.id.tip_text);
        String aHr = aaVar.aHr();
        if (aq.isEmpty(aHr)) {
            aHr = this.kGr.getString(R.string.video_splash_tip_default);
        }
        this.eSE.setText(aHr);
        cRV();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRU() {
        if (this.kDQ != null) {
            this.kDQ.setBackgroundResource(0);
        }
    }

    private void cRV() {
        if (this.kGu != null && this.kGu.cRS()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.kGu.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.kDQ != null) {
                    this.kDQ.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.kDQ != null) {
                    this.kDQ.setBackgroundColor(this.kGr.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.kGw = true;
        if (this.kDQ != null) {
            this.kDQ.resume();
        }
    }

    public void onPause() {
        if (this.kDQ != null) {
            this.kGv = this.kDQ.getCurrentPosition();
            this.kDQ.stopPlayback();
            if (this.kGw) {
                cRV();
            }
        }
    }

    public void onDestroy() {
        e.gx().removeCallbacks(this.kGx);
    }

    public void a(a aVar) {
        this.kGs = aVar;
    }
}

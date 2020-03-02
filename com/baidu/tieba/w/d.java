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
    private TextView eWw;
    private TextView hUO;
    private ScaleVideoView kEN;
    private LogoActivity kHo;
    private a kHp;
    private int kHs;
    private View kuU;
    private View mRootView;
    private boolean kHt = true;
    private Runnable kHu = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.kHp != null) {
                d.this.kHp.onError();
            }
        }
    };
    private com.baidu.tieba.w.a kHq = new com.baidu.tieba.w.a();
    private c kHr = new c();

    /* loaded from: classes.dex */
    public interface a {
        void aWi();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.kHs = 0;
        this.kHo = logoActivity;
        this.kHs = 0;
    }

    public boolean cTn() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.kHq == null || this.kHr == null) {
            return false;
        }
        return this.kHq.cTn() && this.kHr.cTp();
    }

    public void cTq() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.kHr != null) {
                this.kHr.deleteVideo();
            }
            com.baidu.tbadk.core.sharedPref.b.aFD().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
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
        e.gx().postDelayed(this.kHu, 1000L);
        load();
    }

    private void load() {
        if (this.kHr != null && !aq.isEmpty(this.kHr.getVideoPath())) {
            this.kEN.setVideoPath(this.kHr.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.kHq != null) {
            this.kHq.eI(System.currentTimeMillis());
        }
        if (this.kHs >= 0) {
            this.kEN.seekTo(this.kHs);
        }
        this.kEN.start();
    }

    private View s(double d) {
        View inflate = LayoutInflater.from(this.kHo).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.kHo) * d)));
        this.kEN = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.kEN.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.gx().removeCallbacks(d.this.kHu);
                if (d.this.kHp != null) {
                    d.this.kHt = false;
                    d.this.kHp.onError();
                    return true;
                }
                return true;
            }
        });
        this.kEN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.gx().removeCallbacks(d.this.kHu);
                if (d.this.kHp != null) {
                    d.this.kHt = false;
                    d.this.kHp.aWi();
                }
            }
        });
        this.kEN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.gx().removeCallbacks(d.this.kHu);
                d.this.kEN.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.cTr();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.hUO = (TextView) inflate.findViewById(R.id.skip);
        this.hUO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.gx().removeCallbacks(d.this.kHu);
                if (d.this.kHp != null) {
                    d.this.kHt = false;
                    d.this.kHp.aWi();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ab abVar = new ab();
        abVar.parseJson(string);
        final String aJL = abVar.aJL();
        this.kuU = inflate.findViewById(R.id.tip_container);
        this.kuU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!aq.isEmpty(aJL)) {
                    d.this.kHt = false;
                    d.this.kHp.aWi();
                    ba.aGG().b(d.this.kHo.getPageContext(), new String[]{aJL});
                }
            }
        });
        this.eWw = (TextView) inflate.findViewById(R.id.tip_text);
        String aJM = abVar.aJM();
        if (aq.isEmpty(aJM)) {
            aJM = this.kHo.getString(R.string.video_splash_tip_default);
        }
        this.eWw.setText(aJM);
        cTs();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTr() {
        if (this.kEN != null) {
            this.kEN.setBackgroundResource(0);
        }
    }

    private void cTs() {
        if (this.kHr != null && this.kHr.cTp()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.kHr.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.kEN != null) {
                    this.kEN.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.kEN != null) {
                    this.kEN.setBackgroundColor(this.kHo.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.kHt = true;
        if (this.kEN != null) {
            this.kEN.resume();
        }
    }

    public void onPause() {
        if (this.kEN != null) {
            this.kHs = this.kEN.getCurrentPosition();
            this.kEN.stopPlayback();
            if (this.kHt) {
                cTs();
            }
        }
    }

    public void onDestroy() {
        e.gx().removeCallbacks(this.kHu);
    }

    public void a(a aVar) {
        this.kHp = aVar;
    }
}

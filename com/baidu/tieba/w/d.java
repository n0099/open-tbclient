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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.coreExtra.data.ae;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private TextView ggR;
    private TextView jwb;
    private View mRootView;
    private View mbW;
    private ScaleVideoView mml;
    private LogoActivity moq;
    private a mor;
    private int mou;
    private boolean mov = true;
    private Runnable mow = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mor != null) {
                d.this.mor.onError();
            }
        }
    };
    private com.baidu.tieba.w.a mos = new com.baidu.tieba.w.a();
    private c mot = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Pr();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.mou = 0;
        this.moq = logoActivity;
        this.mou = 0;
    }

    public boolean dtw() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.mos == null || this.mot == null) {
            return false;
        }
        return this.mos.dtw() && this.mot.dty();
    }

    public void dtA() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.mot != null) {
                this.mot.dtz();
            }
            com.baidu.tbadk.core.sharedPref.b.aZP().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View z(double d) {
        if (this.mRootView == null) {
            this.mRootView = A(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new ap("c12944"));
        e.lt().postDelayed(this.mow, 1000L);
        load();
    }

    private void load() {
        if (this.mot != null && !as.isEmpty(this.mot.getVideoPath())) {
            this.mml.setVideoPath(this.mot.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.mos != null) {
            this.mos.fM(System.currentTimeMillis());
        }
        if (this.mou >= 0) {
            this.mml.seekTo(this.mou);
        }
        this.mml.start();
    }

    private View A(double d) {
        View inflate = LayoutInflater.from(this.moq).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.moq) * d)));
        this.mml = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.mml.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.lt().removeCallbacks(d.this.mow);
                if (d.this.mor != null) {
                    d.this.mov = false;
                    d.this.mor.onError();
                    return true;
                }
                return true;
            }
        });
        this.mml.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.lt().removeCallbacks(d.this.mow);
                if (d.this.mor != null) {
                    d.this.mov = false;
                    d.this.mor.Pr();
                }
            }
        });
        this.mml.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.lt().removeCallbacks(d.this.mow);
                d.this.mml.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dtB();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.jwb = (TextView) inflate.findViewById(R.id.skip);
        this.jwb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.lt().removeCallbacks(d.this.mow);
                if (d.this.mor != null) {
                    d.this.mov = false;
                    d.this.mor.Pr();
                }
                TiebaStatic.log(new ap("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ae aeVar = new ae();
        aeVar.parseJson(string);
        final String beu = aeVar.beu();
        this.mbW = inflate.findViewById(R.id.tip_container);
        this.mbW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ap("c12945"));
                if (!as.isEmpty(beu)) {
                    d.this.mov = false;
                    d.this.mor.Pr();
                    bd.baV().b(d.this.moq.getPageContext(), new String[]{beu});
                }
            }
        });
        this.ggR = (TextView) inflate.findViewById(R.id.tip_text);
        String bev = aeVar.bev();
        if (as.isEmpty(bev)) {
            bev = this.moq.getString(R.string.video_splash_tip_default);
        }
        this.ggR.setText(bev);
        dtC();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtB() {
        if (this.mml != null) {
            this.mml.setBackgroundResource(0);
        }
    }

    private void dtC() {
        if (this.mot != null && this.mot.dty()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.mot.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.mml != null) {
                    this.mml.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mml != null) {
                    this.mml.setBackgroundColor(this.moq.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.mov = true;
        if (this.mml != null) {
            this.mml.resume();
        }
    }

    public void onPause() {
        if (this.mml != null) {
            this.mou = this.mml.getCurrentPosition();
            this.mml.stopPlayback();
            if (this.mov) {
                dtC();
            }
        }
    }

    public void onDestroy() {
        e.lt().removeCallbacks(this.mow);
    }

    public void a(a aVar) {
        this.mor = aVar;
    }
}

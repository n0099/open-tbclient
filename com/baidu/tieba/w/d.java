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
    private TextView jvZ;
    private View mRootView;
    private View mbU;
    private ScaleVideoView mmj;
    private LogoActivity moo;
    private a mop;
    private int mos;
    private boolean mot = true;
    private Runnable mou = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mop != null) {
                d.this.mop.onError();
            }
        }
    };
    private com.baidu.tieba.w.a moq = new com.baidu.tieba.w.a();
    private c mor = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Pr();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.mos = 0;
        this.moo = logoActivity;
        this.mos = 0;
    }

    public boolean dtv() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.moq == null || this.mor == null) {
            return false;
        }
        return this.moq.dtv() && this.mor.dtx();
    }

    public void dtz() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.mor != null) {
                this.mor.dty();
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
        e.lt().postDelayed(this.mou, 1000L);
        load();
    }

    private void load() {
        if (this.mor != null && !as.isEmpty(this.mor.getVideoPath())) {
            this.mmj.setVideoPath(this.mor.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.moq != null) {
            this.moq.fM(System.currentTimeMillis());
        }
        if (this.mos >= 0) {
            this.mmj.seekTo(this.mos);
        }
        this.mmj.start();
    }

    private View A(double d) {
        View inflate = LayoutInflater.from(this.moo).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.moo) * d)));
        this.mmj = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.mmj.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.lt().removeCallbacks(d.this.mou);
                if (d.this.mop != null) {
                    d.this.mot = false;
                    d.this.mop.onError();
                    return true;
                }
                return true;
            }
        });
        this.mmj.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.lt().removeCallbacks(d.this.mou);
                if (d.this.mop != null) {
                    d.this.mot = false;
                    d.this.mop.Pr();
                }
            }
        });
        this.mmj.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.lt().removeCallbacks(d.this.mou);
                d.this.mmj.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dtA();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.jvZ = (TextView) inflate.findViewById(R.id.skip);
        this.jvZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.lt().removeCallbacks(d.this.mou);
                if (d.this.mop != null) {
                    d.this.mot = false;
                    d.this.mop.Pr();
                }
                TiebaStatic.log(new ap("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ae aeVar = new ae();
        aeVar.parseJson(string);
        final String beu = aeVar.beu();
        this.mbU = inflate.findViewById(R.id.tip_container);
        this.mbU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ap("c12945"));
                if (!as.isEmpty(beu)) {
                    d.this.mot = false;
                    d.this.mop.Pr();
                    bd.baV().b(d.this.moo.getPageContext(), new String[]{beu});
                }
            }
        });
        this.ggR = (TextView) inflate.findViewById(R.id.tip_text);
        String bev = aeVar.bev();
        if (as.isEmpty(bev)) {
            bev = this.moo.getString(R.string.video_splash_tip_default);
        }
        this.ggR.setText(bev);
        dtB();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtA() {
        if (this.mmj != null) {
            this.mmj.setBackgroundResource(0);
        }
    }

    private void dtB() {
        if (this.mor != null && this.mor.dtx()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.mor.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.mmj != null) {
                    this.mmj.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mmj != null) {
                    this.mmj.setBackgroundColor(this.moo.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.mot = true;
        if (this.mmj != null) {
            this.mmj.resume();
        }
    }

    public void onPause() {
        if (this.mmj != null) {
            this.mos = this.mmj.getCurrentPosition();
            this.mmj.stopPlayback();
            if (this.mot) {
                dtB();
            }
        }
    }

    public void onDestroy() {
        e.lt().removeCallbacks(this.mou);
    }

    public void a(a aVar) {
        this.mop = aVar;
    }
}

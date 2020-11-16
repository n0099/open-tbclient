package com.baidu.tieba.x;

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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.data.ai;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private TextView hct;
    private TextView kBL;
    private View mRootView;
    private View nnb;
    private ScaleVideoView nxl;
    private LogoActivity nzp;
    private a nzq;
    private int nzt;
    private boolean nzu = true;
    private Runnable nzv = new Runnable() { // from class: com.baidu.tieba.x.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.nzq != null) {
                d.this.nzq.onError();
            }
        }
    };
    private com.baidu.tieba.x.a nzr = new com.baidu.tieba.x.a();
    private c nzs = new c();

    /* loaded from: classes.dex */
    public interface a {
        void abD();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.nzt = 0;
        this.nzp = logoActivity;
        this.nzt = 0;
    }

    public boolean dSp() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bpu().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.nzr == null || this.nzs == null) {
            return false;
        }
        return this.nzr.dSp() && this.nzs.dSr();
    }

    public void dSt() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bpu().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.nzs != null) {
                this.nzs.dSs();
            }
            com.baidu.tbadk.core.sharedPref.b.bpu().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View J(double d) {
        if (this.mRootView == null) {
            this.mRootView = K(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new ar("c12944"));
        e.mY().postDelayed(this.nzv, 1000L);
        load();
    }

    private void load() {
        if (this.nzs != null && !au.isEmpty(this.nzs.getVideoPath())) {
            this.nxl.setVideoPath(this.nzs.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.nzr != null) {
            this.nzr.hg(System.currentTimeMillis());
        }
        if (this.nzt >= 0) {
            this.nxl.seekTo(this.nzt);
        }
        this.nxl.start();
    }

    private View K(double d) {
        View inflate = LayoutInflater.from(this.nzp).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.nzp) * d)));
        this.nxl = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.nxl.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.x.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.mY().removeCallbacks(d.this.nzv);
                if (d.this.nzq != null) {
                    d.this.nzu = false;
                    d.this.nzq.onError();
                    return true;
                }
                return true;
            }
        });
        this.nxl.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.x.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.mY().removeCallbacks(d.this.nzv);
                if (d.this.nzq != null) {
                    d.this.nzu = false;
                    d.this.nzq.abD();
                }
            }
        });
        this.nxl.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.x.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.mY().removeCallbacks(d.this.nzv);
                d.this.nxl.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.x.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dSu();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.kBL = (TextView) inflate.findViewById(R.id.skip);
        this.kBL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.x.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.mY().removeCallbacks(d.this.nzv);
                if (d.this.nzq != null) {
                    d.this.nzu = false;
                    d.this.nzq.abD();
                }
                TiebaStatic.log(new ar("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ai aiVar = new ai();
        aiVar.parseJson(string);
        final String bur = aiVar.bur();
        this.nnb = inflate.findViewById(R.id.tip_container);
        this.nnb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.x.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12945"));
                if (!au.isEmpty(bur)) {
                    d.this.nzu = false;
                    d.this.nzq.abD();
                    bf.bqF().b(d.this.nzp.getPageContext(), new String[]{bur});
                }
            }
        });
        this.hct = (TextView) inflate.findViewById(R.id.tip_text);
        String bus = aiVar.bus();
        if (au.isEmpty(bus)) {
            bus = this.nzp.getString(R.string.video_splash_tip_default);
        }
        this.hct.setText(bus);
        dSv();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSu() {
        if (this.nxl != null) {
            this.nxl.setBackgroundResource(0);
        }
    }

    private void dSv() {
        if (this.nzs != null && this.nzs.dSr()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.nzs.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.nxl != null) {
                    this.nxl.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.nxl != null) {
                    this.nxl.setBackgroundColor(this.nzp.getResources().getColor(R.color.CAM_X0101));
                }
            }
        }
    }

    public void onResume() {
        this.nzu = true;
        if (this.nxl != null) {
            this.nxl.resume();
        }
    }

    public void onPause() {
        if (this.nxl != null) {
            this.nzt = this.nxl.getCurrentPosition();
            this.nxl.stopPlayback();
            if (this.nzu) {
                dSv();
            }
        }
    }

    public void onDestroy() {
        e.mY().removeCallbacks(this.nzv);
    }

    public void a(a aVar) {
        this.nzq = aVar;
    }
}

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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private TextView gta;
    private TextView jLw;
    private ScaleVideoView mDY;
    private LogoActivity mGd;
    private a mGe;
    private int mGh;
    private View mRootView;
    private View mtH;
    private boolean mGi = true;
    private Runnable mGj = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mGe != null) {
                d.this.mGe.onError();
            }
        }
    };
    private com.baidu.tieba.w.a mGf = new com.baidu.tieba.w.a();
    private c mGg = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Vn();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.mGh = 0;
        this.mGd = logoActivity;
        this.mGh = 0;
    }

    public boolean dER() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.mGf == null || this.mGg == null) {
            return false;
        }
        return this.mGf.dER() && this.mGg.dET();
    }

    public void dEV() {
        if (!(com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.mGg != null) {
                this.mGg.dEU();
            }
            com.baidu.tbadk.core.sharedPref.b.bik().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View F(double d) {
        if (this.mRootView == null) {
            this.mRootView = G(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new aq("c12944"));
        e.mS().postDelayed(this.mGj, 1000L);
        load();
    }

    private void load() {
        if (this.mGg != null && !at.isEmpty(this.mGg.getVideoPath())) {
            this.mDY.setVideoPath(this.mGg.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.mGf != null) {
            this.mGf.fY(System.currentTimeMillis());
        }
        if (this.mGh >= 0) {
            this.mDY.seekTo(this.mGh);
        }
        this.mDY.start();
    }

    private View G(double d) {
        View inflate = LayoutInflater.from(this.mGd).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.mGd) * d)));
        this.mDY = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.mDY.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.mS().removeCallbacks(d.this.mGj);
                if (d.this.mGe != null) {
                    d.this.mGi = false;
                    d.this.mGe.onError();
                    return true;
                }
                return true;
            }
        });
        this.mDY.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.mS().removeCallbacks(d.this.mGj);
                if (d.this.mGe != null) {
                    d.this.mGi = false;
                    d.this.mGe.Vn();
                }
            }
        });
        this.mDY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.mS().removeCallbacks(d.this.mGj);
                d.this.mDY.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dEW();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.jLw = (TextView) inflate.findViewById(R.id.skip);
        this.jLw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.mS().removeCallbacks(d.this.mGj);
                if (d.this.mGe != null) {
                    d.this.mGi = false;
                    d.this.mGe.Vn();
                }
                TiebaStatic.log(new aq("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.bik().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ah ahVar = new ah();
        ahVar.parseJson(string);
        final String bne = ahVar.bne();
        this.mtH = inflate.findViewById(R.id.tip_container);
        this.mtH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12945"));
                if (!at.isEmpty(bne)) {
                    d.this.mGi = false;
                    d.this.mGe.Vn();
                    be.bju().b(d.this.mGd.getPageContext(), new String[]{bne});
                }
            }
        });
        this.gta = (TextView) inflate.findViewById(R.id.tip_text);
        String bnf = ahVar.bnf();
        if (at.isEmpty(bnf)) {
            bnf = this.mGd.getString(R.string.video_splash_tip_default);
        }
        this.gta.setText(bnf);
        dEX();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEW() {
        if (this.mDY != null) {
            this.mDY.setBackgroundResource(0);
        }
    }

    private void dEX() {
        if (this.mGg != null && this.mGg.dET()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.mGg.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.mDY != null) {
                    this.mDY.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.mDY != null) {
                    this.mDY.setBackgroundColor(this.mGd.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.mGi = true;
        if (this.mDY != null) {
            this.mDY.resume();
        }
    }

    public void onPause() {
        if (this.mDY != null) {
            this.mGh = this.mDY.getCurrentPosition();
            this.mDY.stopPlayback();
            if (this.mGi) {
                dEX();
            }
        }
    }

    public void onDestroy() {
        e.mS().removeCallbacks(this.mGj);
    }

    public void a(a aVar) {
        this.mGe = aVar;
    }
}

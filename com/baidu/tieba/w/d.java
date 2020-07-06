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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.data.ae;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private TextView gbJ;
    private TextView jnv;
    private View lUE;
    private View mRootView;
    private ScaleVideoView meT;
    private LogoActivity mgY;
    private a mgZ;
    private int mhc;
    private boolean mhd = true;
    private Runnable mhe = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mgZ != null) {
                d.this.mgZ.onError();
            }
        }
    };
    private com.baidu.tieba.w.a mha = new com.baidu.tieba.w.a();
    private c mhb = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Pc();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.mhc = 0;
        this.mgY = logoActivity;
        this.mhc = 0;
    }

    public boolean dqm() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.mha == null || this.mhb == null) {
            return false;
        }
        return this.mha.dqm() && this.mhb.dqo();
    }

    public void dqq() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.mhb != null) {
                this.mhb.dqp();
            }
            com.baidu.tbadk.core.sharedPref.b.aVP().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View z(double d) {
        if (this.mRootView == null) {
            this.mRootView = A(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new ao("c12944"));
        e.lt().postDelayed(this.mhe, 1000L);
        load();
    }

    private void load() {
        if (this.mhb != null && !ar.isEmpty(this.mhb.getVideoPath())) {
            this.meT.setVideoPath(this.mhb.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.mha != null) {
            this.mha.fz(System.currentTimeMillis());
        }
        if (this.mhc >= 0) {
            this.meT.seekTo(this.mhc);
        }
        this.meT.start();
    }

    private View A(double d) {
        View inflate = LayoutInflater.from(this.mgY).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.mgY) * d)));
        this.meT = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.meT.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.lt().removeCallbacks(d.this.mhe);
                if (d.this.mgZ != null) {
                    d.this.mhd = false;
                    d.this.mgZ.onError();
                    return true;
                }
                return true;
            }
        });
        this.meT.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.lt().removeCallbacks(d.this.mhe);
                if (d.this.mgZ != null) {
                    d.this.mhd = false;
                    d.this.mgZ.Pc();
                }
            }
        });
        this.meT.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.lt().removeCallbacks(d.this.mhe);
                d.this.meT.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dqr();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.jnv = (TextView) inflate.findViewById(R.id.skip);
        this.jnv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.lt().removeCallbacks(d.this.mhe);
                if (d.this.mgZ != null) {
                    d.this.mhd = false;
                    d.this.mgZ.Pc();
                }
                TiebaStatic.log(new ao("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ae aeVar = new ae();
        aeVar.parseJson(string);
        final String bax = aeVar.bax();
        this.lUE = inflate.findViewById(R.id.tip_container);
        this.lUE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ao("c12945"));
                if (!ar.isEmpty(bax)) {
                    d.this.mhd = false;
                    d.this.mgZ.Pc();
                    bc.aWU().b(d.this.mgY.getPageContext(), new String[]{bax});
                }
            }
        });
        this.gbJ = (TextView) inflate.findViewById(R.id.tip_text);
        String bay = aeVar.bay();
        if (ar.isEmpty(bay)) {
            bay = this.mgY.getString(R.string.video_splash_tip_default);
        }
        this.gbJ.setText(bay);
        dqs();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqr() {
        if (this.meT != null) {
            this.meT.setBackgroundResource(0);
        }
    }

    private void dqs() {
        if (this.mhb != null && this.mhb.dqo()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.mhb.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.meT != null) {
                    this.meT.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.meT != null) {
                    this.meT.setBackgroundColor(this.mgY.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.mhd = true;
        if (this.meT != null) {
            this.meT.resume();
        }
    }

    public void onPause() {
        if (this.meT != null) {
            this.mhc = this.meT.getCurrentPosition();
            this.meT.stopPlayback();
            if (this.mhd) {
                dqs();
            }
        }
    }

    public void onDestroy() {
        e.lt().removeCallbacks(this.mhe);
    }

    public void a(a aVar) {
        this.mgZ = aVar;
    }
}

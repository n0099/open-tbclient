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
    private View lUB;
    private View mRootView;
    private ScaleVideoView meQ;
    private LogoActivity mgV;
    private a mgW;
    private int mgZ;
    private boolean mha = true;
    private Runnable mhb = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mgW != null) {
                d.this.mgW.onError();
            }
        }
    };
    private com.baidu.tieba.w.a mgX = new com.baidu.tieba.w.a();
    private c mgY = new c();

    /* loaded from: classes.dex */
    public interface a {
        void Pc();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.mgZ = 0;
        this.mgV = logoActivity;
        this.mgZ = 0;
    }

    public boolean dqi() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.mgX == null || this.mgY == null) {
            return false;
        }
        return this.mgX.dqi() && this.mgY.dqk();
    }

    public void dqm() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.mgY != null) {
                this.mgY.dql();
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
        e.lt().postDelayed(this.mhb, 1000L);
        load();
    }

    private void load() {
        if (this.mgY != null && !ar.isEmpty(this.mgY.getVideoPath())) {
            this.meQ.setVideoPath(this.mgY.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.mgX != null) {
            this.mgX.fz(System.currentTimeMillis());
        }
        if (this.mgZ >= 0) {
            this.meQ.seekTo(this.mgZ);
        }
        this.meQ.start();
    }

    private View A(double d) {
        View inflate = LayoutInflater.from(this.mgV).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.mgV) * d)));
        this.meQ = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.meQ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.lt().removeCallbacks(d.this.mhb);
                if (d.this.mgW != null) {
                    d.this.mha = false;
                    d.this.mgW.onError();
                    return true;
                }
                return true;
            }
        });
        this.meQ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.lt().removeCallbacks(d.this.mhb);
                if (d.this.mgW != null) {
                    d.this.mha = false;
                    d.this.mgW.Pc();
                }
            }
        });
        this.meQ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.lt().removeCallbacks(d.this.mhb);
                d.this.meQ.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.dqn();
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
                e.lt().removeCallbacks(d.this.mhb);
                if (d.this.mgW != null) {
                    d.this.mha = false;
                    d.this.mgW.Pc();
                }
                TiebaStatic.log(new ao("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ae aeVar = new ae();
        aeVar.parseJson(string);
        final String bax = aeVar.bax();
        this.lUB = inflate.findViewById(R.id.tip_container);
        this.lUB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ao("c12945"));
                if (!ar.isEmpty(bax)) {
                    d.this.mha = false;
                    d.this.mgW.Pc();
                    bc.aWU().b(d.this.mgV.getPageContext(), new String[]{bax});
                }
            }
        });
        this.gbJ = (TextView) inflate.findViewById(R.id.tip_text);
        String bay = aeVar.bay();
        if (ar.isEmpty(bay)) {
            bay = this.mgV.getString(R.string.video_splash_tip_default);
        }
        this.gbJ.setText(bay);
        dqo();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqn() {
        if (this.meQ != null) {
            this.meQ.setBackgroundResource(0);
        }
    }

    private void dqo() {
        if (this.mgY != null && this.mgY.dqk()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.mgY.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.meQ != null) {
                    this.meQ.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.meQ != null) {
                    this.meQ.setBackgroundColor(this.mgV.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.mha = true;
        if (this.meQ != null) {
            this.meQ.resume();
        }
    }

    public void onPause() {
        if (this.meQ != null) {
            this.mgZ = this.meQ.getCurrentPosition();
            this.meQ.stopPlayback();
            if (this.mha) {
                dqo();
            }
        }
    }

    public void onDestroy() {
        e.lt().removeCallbacks(this.mhb);
    }

    public void a(a aVar) {
        this.mgW = aVar;
    }
}

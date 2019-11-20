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
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d {
    private TextView ebg;
    private TextView hbc;
    private ScaleVideoView jGA;
    private LogoActivity jIB;
    private a jIC;
    private int jIF;
    private View jwk;
    private View mRootView;
    private boolean jIG = true;
    private Runnable jIH = new Runnable() { // from class: com.baidu.tieba.u.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.jIC != null) {
                d.this.jIC.onError();
            }
        }
    };
    private com.baidu.tieba.u.a jID = new com.baidu.tieba.u.a();
    private c jIE = new c();

    /* loaded from: classes.dex */
    public interface a {
        void aBH();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.jIF = 0;
        this.jIB = logoActivity;
        this.jIF = 0;
    }

    public boolean cwE() {
        if (!(com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.jID == null || this.jIE == null) {
            return false;
        }
        return this.jID.cwE() && this.jIE.cwH();
    }

    public void cwJ() {
        if (!(com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.jIE != null) {
                this.jIE.cwI();
            }
            com.baidu.tbadk.core.sharedPref.b.alP().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
        }
    }

    public View o(double d) {
        if (this.mRootView == null) {
            this.mRootView = p(d);
        }
        return this.mRootView;
    }

    public void start() {
        TiebaStatic.log(new an("c12944"));
        e.fZ().postDelayed(this.jIH, 1000L);
        load();
    }

    private void load() {
        if (this.jIE != null && !aq.isEmpty(this.jIE.getVideoPath())) {
            this.jGA.setVideoPath(this.jIE.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.jID != null) {
            this.jID.ea(System.currentTimeMillis());
        }
        if (this.jIF >= 0) {
            this.jGA.seekTo(this.jIF);
        }
        this.jGA.start();
    }

    private View p(double d) {
        View inflate = LayoutInflater.from(this.jIB).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.jIB) * d)));
        this.jGA = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.jGA.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.u.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.fZ().removeCallbacks(d.this.jIH);
                if (d.this.jIC != null) {
                    d.this.jIG = false;
                    d.this.jIC.onError();
                    return true;
                }
                return true;
            }
        });
        this.jGA.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.u.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.fZ().removeCallbacks(d.this.jIH);
                if (d.this.jIC != null) {
                    d.this.jIG = false;
                    d.this.jIC.aBH();
                }
            }
        });
        this.jGA.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.u.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.fZ().removeCallbacks(d.this.jIH);
                d.this.jGA.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.u.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.cwK();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.hbc = (TextView) inflate.findViewById(R.id.skip);
        this.hbc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.fZ().removeCallbacks(d.this.jIH);
                if (d.this.jIC != null) {
                    d.this.jIG = false;
                    d.this.jIC.aBH();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        z zVar = new z();
        zVar.parseJson(string);
        final String apy = zVar.apy();
        this.jwk = inflate.findViewById(R.id.tip_container);
        this.jwk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!aq.isEmpty(apy)) {
                    d.this.jIG = false;
                    d.this.jIC.aBH();
                    ba.amO().b(d.this.jIB.getPageContext(), new String[]{apy});
                }
            }
        });
        this.ebg = (TextView) inflate.findViewById(R.id.tip_text);
        String apz = zVar.apz();
        if (aq.isEmpty(apz)) {
            apz = this.jIB.getString(R.string.video_splash_tip_default);
        }
        this.ebg.setText(apz);
        cwL();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwK() {
        if (this.jGA != null) {
            this.jGA.setBackgroundResource(0);
        }
    }

    private void cwL() {
        if (this.jIE != null && this.jIE.cwH()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.jIE.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.jGA != null) {
                    this.jGA.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.jGA != null) {
                    this.jGA.setBackgroundColor(this.jIB.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.jIG = true;
        if (this.jGA != null) {
            this.jGA.resume();
        }
    }

    public void onPause() {
        if (this.jGA != null) {
            this.jIF = this.jGA.getCurrentPosition();
            this.jGA.stopPlayback();
            if (this.jIG) {
                cwL();
            }
        }
    }

    public void onDestroy() {
        e.fZ().removeCallbacks(this.jIH);
    }

    public void a(a aVar) {
        this.jIC = aVar;
    }
}

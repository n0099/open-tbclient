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
    private TextView eWv;
    private TextView hUM;
    private ScaleVideoView kEL;
    private LogoActivity kHm;
    private a kHn;
    private int kHq;
    private View kuS;
    private View mRootView;
    private boolean kHr = true;
    private Runnable kHs = new Runnable() { // from class: com.baidu.tieba.w.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.kHn != null) {
                d.this.kHn.onError();
            }
        }
    };
    private com.baidu.tieba.w.a kHo = new com.baidu.tieba.w.a();
    private c kHp = new c();

    /* loaded from: classes.dex */
    public interface a {
        void aWg();

        void onError();
    }

    public d(LogoActivity logoActivity) {
        this.kHq = 0;
        this.kHm = logoActivity;
        this.kHq = 0;
    }

    public boolean cTl() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aFB().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1) || this.kHo == null || this.kHp == null) {
            return false;
        }
        return this.kHo.cTl() && this.kHp.cTn();
    }

    public void cTo() {
        if (!(com.baidu.tbadk.core.sharedPref.b.aFB().getInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, 0) == 1)) {
            if (this.kHp != null) {
                this.kHp.deleteVideo();
            }
            com.baidu.tbadk.core.sharedPref.b.aFB().putLong(SharedPrefConfig.KEY_VIDEO_SPLASH_LAST_SHOW_TIME, 0L);
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
        e.gx().postDelayed(this.kHs, 1000L);
        load();
    }

    private void load() {
        if (this.kHp != null && !aq.isEmpty(this.kHp.getVideoPath())) {
            this.kEL.setVideoPath(this.kHp.getVideoPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        if (this.kHo != null) {
            this.kHo.eI(System.currentTimeMillis());
        }
        if (this.kHq >= 0) {
            this.kEL.seekTo(this.kHq);
        }
        this.kEL.start();
    }

    private View s(double d) {
        View inflate = LayoutInflater.from(this.kHm).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.getEquipmentHeight(this.kHm) * d)));
        this.kEL = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.kEL.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.w.d.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                e.gx().removeCallbacks(d.this.kHs);
                if (d.this.kHn != null) {
                    d.this.kHr = false;
                    d.this.kHn.onError();
                    return true;
                }
                return true;
            }
        });
        this.kEL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.w.d.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                e.gx().removeCallbacks(d.this.kHs);
                if (d.this.kHn != null) {
                    d.this.kHr = false;
                    d.this.kHn.aWg();
                }
            }
        });
        this.kEL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.w.d.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.gx().removeCallbacks(d.this.kHs);
                d.this.kEL.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.w.d.4.1
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                        if (i == 3) {
                            d.this.cTp();
                            return false;
                        }
                        return false;
                    }
                });
                d.this.play();
            }
        });
        this.hUM = (TextView) inflate.findViewById(R.id.skip);
        this.hUM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.gx().removeCallbacks(d.this.kHs);
                if (d.this.kHn != null) {
                    d.this.kHr = false;
                    d.this.kHn.aWg();
                }
                TiebaStatic.log(new an("c12946"));
            }
        });
        String string = com.baidu.tbadk.core.sharedPref.b.aFB().getString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, "");
        ab abVar = new ab();
        abVar.parseJson(string);
        final String aJJ = abVar.aJJ();
        this.kuS = inflate.findViewById(R.id.tip_container);
        this.kuS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w.d.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.LogoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12945"));
                if (!aq.isEmpty(aJJ)) {
                    d.this.kHr = false;
                    d.this.kHn.aWg();
                    ba.aGE().b(d.this.kHm.getPageContext(), new String[]{aJJ});
                }
            }
        });
        this.eWv = (TextView) inflate.findViewById(R.id.tip_text);
        String aJK = abVar.aJK();
        if (aq.isEmpty(aJK)) {
            aJK = this.kHm.getString(R.string.video_splash_tip_default);
        }
        this.eWv.setText(aJK);
        cTq();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTp() {
        if (this.kEL != null) {
            this.kEL.setBackgroundResource(0);
        }
    }

    private void cTq() {
        if (this.kHp != null && this.kHp.cTn()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.kHp.getVideoPath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.kEL != null) {
                    this.kEL.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.kEL != null) {
                    this.kEL.setBackgroundColor(this.kHm.getResources().getColor(R.color.cp_cont_a));
                }
            }
        }
    }

    public void onResume() {
        this.kHr = true;
        if (this.kEL != null) {
            this.kEL.resume();
        }
    }

    public void onPause() {
        if (this.kEL != null) {
            this.kHq = this.kEL.getCurrentPosition();
            this.kEL.stopPlayback();
            if (this.kHr) {
                cTq();
            }
        }
    }

    public void onDestroy() {
        e.gx().removeCallbacks(this.kHs);
    }

    public void a(a aVar) {
        this.kHn = aVar;
    }
}

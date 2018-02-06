package com.baidu.tieba.video.player.a;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    private VideoView huB;
    private ProgressBar huC;
    private TextView huD;
    private a huE;
    private Handler huF = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.player.a.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 201:
                    b.this.bCP();
                    return;
                case 202:
                    b.this.ala();
                    return;
                default:
                    return;
            }
        }
    };
    private MediaPlayer.OnPreparedListener huG = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.player.a.b.2
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            b.this.huB.start();
            b.this.huF.removeMessages(202);
            b.this.huF.sendEmptyMessageDelayed(202, 100L);
        }
    };
    private MediaPlayer.OnCompletionListener bTx = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.player.a.b.3
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null) {
                mediaPlayer.setDisplay(null);
                mediaPlayer.reset();
                mediaPlayer.setDisplay(b.this.huB.getHolder());
            }
            b.this.huF.removeMessages(201);
            b.this.bCR();
            if (b.this.huE != null) {
                b.this.huE.bCM();
            }
        }
    };
    private MediaPlayer.OnErrorListener bTy = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.player.a.b.4
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.this.huE != null) {
                b.this.huE.bCL();
                return true;
            }
            return true;
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bCK();

        void bCL();

        void bCM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCP() {
        boolean z;
        try {
            z = this.huB.isPlaying();
        } catch (IllegalStateException e) {
            BdLog.e(e);
            z = false;
        }
        if (z) {
            bCQ();
        }
        this.huF.removeMessages(201);
        this.huF.sendEmptyMessageDelayed(201, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ala() {
        if (this.huB.getCurrentPosition() > 0) {
            if (this.huE != null) {
                this.huE.bCK();
            }
            bCQ();
            this.huF.removeMessages(202);
            this.huF.removeMessages(201);
            this.huF.sendEmptyMessageDelayed(201, 100L);
            return;
        }
        this.huF.removeMessages(202);
        this.huF.sendEmptyMessageDelayed(202, 100L);
    }

    private void bCQ() {
        int currentPosition = this.huB.getCurrentPosition();
        if (currentPosition > 0) {
            int duration = this.huB.getDuration();
            this.huD.setText(TbadkCoreApplication.getInst().getString(d.j.video_play_times, new Object[]{Integer.valueOf(((duration - currentPosition) / 1000) + 1)}));
            this.huC.setProgress((int) ((currentPosition * 100.0f) / duration));
            return;
        }
        bCR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCR() {
        this.huD.setText("");
        this.huC.setProgress(0);
    }

    public b(View view) {
        if (view != null) {
            this.huB = (VideoView) view.findViewById(d.g.video_player_video_view);
            this.huC = (ProgressBar) view.findViewById(d.g.video_player_progress);
            this.huD = (TextView) view.findViewById(d.g.video_player_time);
            this.huB.setOnPreparedListener(this.huG);
            this.huB.setOnCompletionListener(this.bTx);
            this.huB.setOnErrorListener(this.bTy);
            this.huB.setClickable(false);
        }
    }

    public void a(a aVar) {
        this.huE = aVar;
    }

    public void startPlay(String str) {
        if (this.huB != null) {
            this.huB.setVideoURI(Uri.parse(str));
        }
    }

    public void release() {
        this.huB.stopPlayback();
        this.huF.removeMessages(201);
        this.huF.removeMessages(202);
    }
}

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
    private VideoView huM;
    private ProgressBar huN;
    private TextView huO;
    private a huP;
    private Handler huQ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.player.a.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 201:
                    b.this.bCT();
                    return;
                case 202:
                    b.this.ala();
                    return;
                default:
                    return;
            }
        }
    };
    private MediaPlayer.OnPreparedListener huR = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.player.a.b.2
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            b.this.huM.start();
            b.this.huQ.removeMessages(202);
            b.this.huQ.sendEmptyMessageDelayed(202, 100L);
        }
    };
    private MediaPlayer.OnCompletionListener bTo = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.player.a.b.3
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null) {
                mediaPlayer.setDisplay(null);
                mediaPlayer.reset();
                mediaPlayer.setDisplay(b.this.huM.getHolder());
            }
            b.this.huQ.removeMessages(201);
            b.this.bCV();
            if (b.this.huP != null) {
                b.this.huP.bCQ();
            }
        }
    };
    private MediaPlayer.OnErrorListener bTp = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.player.a.b.4
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.this.huP != null) {
                b.this.huP.bCP();
                return true;
            }
            return true;
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bCO();

        void bCP();

        void bCQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCT() {
        boolean z;
        try {
            z = this.huM.isPlaying();
        } catch (IllegalStateException e) {
            BdLog.e(e);
            z = false;
        }
        if (z) {
            bCU();
        }
        this.huQ.removeMessages(201);
        this.huQ.sendEmptyMessageDelayed(201, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ala() {
        if (this.huM.getCurrentPosition() > 0) {
            if (this.huP != null) {
                this.huP.bCO();
            }
            bCU();
            this.huQ.removeMessages(202);
            this.huQ.removeMessages(201);
            this.huQ.sendEmptyMessageDelayed(201, 100L);
            return;
        }
        this.huQ.removeMessages(202);
        this.huQ.sendEmptyMessageDelayed(202, 100L);
    }

    private void bCU() {
        int currentPosition = this.huM.getCurrentPosition();
        if (currentPosition > 0) {
            int duration = this.huM.getDuration();
            this.huO.setText(TbadkCoreApplication.getInst().getString(d.j.video_play_times, new Object[]{Integer.valueOf(((duration - currentPosition) / 1000) + 1)}));
            this.huN.setProgress((int) ((currentPosition * 100.0f) / duration));
            return;
        }
        bCV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCV() {
        this.huO.setText("");
        this.huN.setProgress(0);
    }

    public b(View view) {
        if (view != null) {
            this.huM = (VideoView) view.findViewById(d.g.video_player_video_view);
            this.huN = (ProgressBar) view.findViewById(d.g.video_player_progress);
            this.huO = (TextView) view.findViewById(d.g.video_player_time);
            this.huM.setOnPreparedListener(this.huR);
            this.huM.setOnCompletionListener(this.bTo);
            this.huM.setOnErrorListener(this.bTp);
            this.huM.setClickable(false);
        }
    }

    public void a(a aVar) {
        this.huP = aVar;
    }

    public void startPlay(String str) {
        if (this.huM != null) {
            this.huM.setVideoURI(Uri.parse(str));
        }
    }

    public void release() {
        this.huM.stopPlayback();
        this.huQ.removeMessages(201);
        this.huQ.removeMessages(202);
    }
}

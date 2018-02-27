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
    private VideoView huo;
    private ProgressBar hup;
    private TextView huq;
    private a hur;
    private Handler hus = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.player.a.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 201:
                    b.this.bCO();
                    return;
                case 202:
                    b.this.akZ();
                    return;
                default:
                    return;
            }
        }
    };
    private MediaPlayer.OnPreparedListener hut = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.player.a.b.2
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            b.this.huo.start();
            b.this.hus.removeMessages(202);
            b.this.hus.sendEmptyMessageDelayed(202, 100L);
        }
    };
    private MediaPlayer.OnCompletionListener bTl = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.player.a.b.3
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null) {
                mediaPlayer.setDisplay(null);
                mediaPlayer.reset();
                mediaPlayer.setDisplay(b.this.huo.getHolder());
            }
            b.this.hus.removeMessages(201);
            b.this.bCQ();
            if (b.this.hur != null) {
                b.this.hur.bCL();
            }
        }
    };
    private MediaPlayer.OnErrorListener bTm = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.video.player.a.b.4
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (b.this.hur != null) {
                b.this.hur.bCK();
                return true;
            }
            return true;
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bCJ();

        void bCK();

        void bCL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCO() {
        boolean z;
        try {
            z = this.huo.isPlaying();
        } catch (IllegalStateException e) {
            BdLog.e(e);
            z = false;
        }
        if (z) {
            bCP();
        }
        this.hus.removeMessages(201);
        this.hus.sendEmptyMessageDelayed(201, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akZ() {
        if (this.huo.getCurrentPosition() > 0) {
            if (this.hur != null) {
                this.hur.bCJ();
            }
            bCP();
            this.hus.removeMessages(202);
            this.hus.removeMessages(201);
            this.hus.sendEmptyMessageDelayed(201, 100L);
            return;
        }
        this.hus.removeMessages(202);
        this.hus.sendEmptyMessageDelayed(202, 100L);
    }

    private void bCP() {
        int currentPosition = this.huo.getCurrentPosition();
        if (currentPosition > 0) {
            int duration = this.huo.getDuration();
            this.huq.setText(TbadkCoreApplication.getInst().getString(d.j.video_play_times, new Object[]{Integer.valueOf(((duration - currentPosition) / 1000) + 1)}));
            this.hup.setProgress((int) ((currentPosition * 100.0f) / duration));
            return;
        }
        bCQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCQ() {
        this.huq.setText("");
        this.hup.setProgress(0);
    }

    public b(View view) {
        if (view != null) {
            this.huo = (VideoView) view.findViewById(d.g.video_player_video_view);
            this.hup = (ProgressBar) view.findViewById(d.g.video_player_progress);
            this.huq = (TextView) view.findViewById(d.g.video_player_time);
            this.huo.setOnPreparedListener(this.hut);
            this.huo.setOnCompletionListener(this.bTl);
            this.huo.setOnErrorListener(this.bTm);
            this.huo.setClickable(false);
        }
    }

    public void a(a aVar) {
        this.hur = aVar;
    }

    public void startPlay(String str) {
        if (this.huo != null) {
            this.huo.setVideoURI(Uri.parse(str));
        }
    }

    public void release() {
        this.huo.stopPlayback();
        this.hus.removeMessages(201);
        this.hus.removeMessages(202);
    }
}

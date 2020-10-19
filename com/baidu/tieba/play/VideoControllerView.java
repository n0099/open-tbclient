package com.baidu.tieba.play;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class VideoControllerView extends RelativeLayout {
    private int eau;
    private MediaController.MediaPlayerControl fEA;
    protected TextView fEB;
    protected TextView fEC;
    protected SeekBar fED;
    private SeekBar.OnSeekBarChangeListener fEG;
    private SeekBar.OnSeekBarChangeListener fEH;
    private int fEz;
    private b kqq;
    private a kqr;
    private Context mContext;
    private boolean mDragging;
    protected int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes.dex */
    public interface a {
        void bFp();
    }

    /* loaded from: classes.dex */
    public interface b {
        void sU(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.fEz = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eau = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fEA != null && VideoControllerView.this.fEA.isPlaying()) {
                            int bFo = VideoControllerView.this.bFo();
                            if (VideoControllerView.this.kqq != null) {
                                VideoControllerView.this.kqq.sU(bFo);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fEz - (bFo % VideoControllerView.this.fEz));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fEH = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fEG != null) {
                    VideoControllerView.this.fEG.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eau = (int) ((VideoControllerView.this.fEA.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fEB != null) {
                        VideoControllerView.this.fEB.setText(at.stringForVideoTime(VideoControllerView.this.eau));
                    }
                    if (VideoControllerView.this.kqr != null) {
                        VideoControllerView.this.kqr.bFp();
                    }
                    if (VideoControllerView.this.fEG != null) {
                        VideoControllerView.this.fEG.onProgressChanged(seekBar, VideoControllerView.this.eau, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.fEA.seekTo(VideoControllerView.this.eau);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fEG != null) {
                    VideoControllerView.this.fEG.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fEz = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eau = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fEA != null && VideoControllerView.this.fEA.isPlaying()) {
                            int bFo = VideoControllerView.this.bFo();
                            if (VideoControllerView.this.kqq != null) {
                                VideoControllerView.this.kqq.sU(bFo);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fEz - (bFo % VideoControllerView.this.fEz));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fEH = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fEG != null) {
                    VideoControllerView.this.fEG.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eau = (int) ((VideoControllerView.this.fEA.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fEB != null) {
                        VideoControllerView.this.fEB.setText(at.stringForVideoTime(VideoControllerView.this.eau));
                    }
                    if (VideoControllerView.this.kqr != null) {
                        VideoControllerView.this.kqr.bFp();
                    }
                    if (VideoControllerView.this.fEG != null) {
                        VideoControllerView.this.fEG.onProgressChanged(seekBar, VideoControllerView.this.eau, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.fEA.seekTo(VideoControllerView.this.eau);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fEG != null) {
                    VideoControllerView.this.fEG.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fEz = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eau = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fEA != null && VideoControllerView.this.fEA.isPlaying()) {
                            int bFo = VideoControllerView.this.bFo();
                            if (VideoControllerView.this.kqq != null) {
                                VideoControllerView.this.kqq.sU(bFo);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fEz - (bFo % VideoControllerView.this.fEz));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fEH = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fEG != null) {
                    VideoControllerView.this.fEG.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eau = (int) ((VideoControllerView.this.fEA.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.fEB != null) {
                        VideoControllerView.this.fEB.setText(at.stringForVideoTime(VideoControllerView.this.eau));
                    }
                    if (VideoControllerView.this.kqr != null) {
                        VideoControllerView.this.kqr.bFp();
                    }
                    if (VideoControllerView.this.fEG != null) {
                        VideoControllerView.this.fEG.onProgressChanged(seekBar, VideoControllerView.this.eau, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.fEA.seekTo(VideoControllerView.this.eau);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fEG != null) {
                    VideoControllerView.this.fEG.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View eH = eH(context);
        addView(eH, -1, -2);
        this.fEB = (TextView) eH.findViewById(R.id.textview_cur_time);
        this.fEC = (TextView) eH.findViewById(R.id.textview_duration);
        this.fED = (SeekBar) eH.findViewById(R.id.pb_video_controller_seekBar);
        this.fED.setOnSeekBarChangeListener(this.fEH);
    }

    protected View eH(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fEA = mediaPlayerControl;
    }

    public void by(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fED.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.fEB != null) {
            this.fEB.setText(at.stringForVideoTime(i));
        }
        if (this.fEC != null) {
            this.fEC.setText(at.stringForVideoTime(this.mDuration));
        }
    }

    public void GP(int i) {
        this.mDuration = i;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.fEC != null) {
            this.fEC.setText(at.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.fEA != null) {
            this.fEz = ((this.fEA.getDuration() / 200) / 50) * 50;
            if (this.fEz < 50) {
                this.fEz = 50;
            } else if (this.fEz > 500) {
                this.fEz = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fEz - (this.fEA.getCurrentPosition() % this.fEz));
        }
    }

    public void aLG() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fED.setProgress(0);
        if (this.fEB != null) {
            this.fEB.setText(at.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int bFo() {
        int currentPosition;
        if (this.fEA == null || this.mDragging) {
            return 0;
        }
        int duration = this.fEA.getDuration();
        if (this.fEA instanceof TbCyberVideoView) {
            currentPosition = ((TbCyberVideoView) this.fEA).getCurrentPositionSync();
        } else {
            currentPosition = this.fEA.getCurrentPosition();
        }
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.fEC != null) {
                this.fEC.setText(at.stringForVideoTime(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.fED != null) {
            if (duration > 0) {
                this.fED.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.fEA.getBufferPercentage();
        }
        if (this.fEB != null) {
            this.fEB.setText(at.stringForVideoTime(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    public void setCurrentDuration(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (!z) {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
            }
        } else {
            this.fEA.seekTo(i);
            if (this.fEB != null) {
                this.fEB.setText(at.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.fEA.isPlaying()) {
            this.fED.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String GQ(int i) {
        if (i < 0) {
            i = 0;
        }
        return at.stringForVideoTime(i);
    }

    public int getSeekPosition() {
        return this.eau;
    }

    public int getCurProgress() {
        if (this.fED != null) {
            return this.fED.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.kqq = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.kqr = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.fEG = onSeekBarChangeListener;
    }
}

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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean cGd;
    private int cWb;
    private MediaController.MediaPlayerControl cWc;
    private TextView cWd;
    private TextView cWe;
    private SeekBar cWf;
    private SeekBar.OnSeekBarChangeListener cWi;
    private int cWj;
    private SeekBar.OnSeekBarChangeListener cWk;
    private b hbU;
    private a hbV;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes.dex */
    public interface a {
        void aBR();
    }

    /* loaded from: classes.dex */
    public interface b {
        void mn(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.cWb = 50;
        this.cGd = false;
        this.mShowing = true;
        this.cWj = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cGd && VideoControllerView.this.mShowing && VideoControllerView.this.cWc != null && VideoControllerView.this.cWc.isPlaying()) {
                            int aBQ = VideoControllerView.this.aBQ();
                            if (VideoControllerView.this.hbU != null) {
                                VideoControllerView.this.hbU.mn(aBQ);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cWb - (aBQ % VideoControllerView.this.cWb));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cWk = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cGd = true;
                if (VideoControllerView.this.cWi != null) {
                    VideoControllerView.this.cWi.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cWj = (int) ((VideoControllerView.this.cWc.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cWd != null) {
                        VideoControllerView.this.cWd.setText(ap.im(VideoControllerView.this.cWj));
                    }
                    if (VideoControllerView.this.hbV != null) {
                        VideoControllerView.this.hbV.aBR();
                    }
                    if (VideoControllerView.this.cWi != null) {
                        VideoControllerView.this.cWi.onProgressChanged(seekBar, VideoControllerView.this.cWj, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.cWc.seekTo(VideoControllerView.this.cWj);
                VideoControllerView.this.cGd = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cWi != null) {
                    VideoControllerView.this.cWi.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cWb = 50;
        this.cGd = false;
        this.mShowing = true;
        this.cWj = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cGd && VideoControllerView.this.mShowing && VideoControllerView.this.cWc != null && VideoControllerView.this.cWc.isPlaying()) {
                            int aBQ = VideoControllerView.this.aBQ();
                            if (VideoControllerView.this.hbU != null) {
                                VideoControllerView.this.hbU.mn(aBQ);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cWb - (aBQ % VideoControllerView.this.cWb));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cWk = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cGd = true;
                if (VideoControllerView.this.cWi != null) {
                    VideoControllerView.this.cWi.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cWj = (int) ((VideoControllerView.this.cWc.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cWd != null) {
                        VideoControllerView.this.cWd.setText(ap.im(VideoControllerView.this.cWj));
                    }
                    if (VideoControllerView.this.hbV != null) {
                        VideoControllerView.this.hbV.aBR();
                    }
                    if (VideoControllerView.this.cWi != null) {
                        VideoControllerView.this.cWi.onProgressChanged(seekBar, VideoControllerView.this.cWj, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.cWc.seekTo(VideoControllerView.this.cWj);
                VideoControllerView.this.cGd = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cWi != null) {
                    VideoControllerView.this.cWi.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cWb = 50;
        this.cGd = false;
        this.mShowing = true;
        this.cWj = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cGd && VideoControllerView.this.mShowing && VideoControllerView.this.cWc != null && VideoControllerView.this.cWc.isPlaying()) {
                            int aBQ = VideoControllerView.this.aBQ();
                            if (VideoControllerView.this.hbU != null) {
                                VideoControllerView.this.hbU.mn(aBQ);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cWb - (aBQ % VideoControllerView.this.cWb));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cWk = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cGd = true;
                if (VideoControllerView.this.cWi != null) {
                    VideoControllerView.this.cWi.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.cWj = (int) ((VideoControllerView.this.cWc.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.cWd != null) {
                        VideoControllerView.this.cWd.setText(ap.im(VideoControllerView.this.cWj));
                    }
                    if (VideoControllerView.this.hbV != null) {
                        VideoControllerView.this.hbV.aBR();
                    }
                    if (VideoControllerView.this.cWi != null) {
                        VideoControllerView.this.cWi.onProgressChanged(seekBar, VideoControllerView.this.cWj, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.cWc.seekTo(VideoControllerView.this.cWj);
                VideoControllerView.this.cGd = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cWi != null) {
                    VideoControllerView.this.cWi.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View cX = cX(context);
        addView(cX, -1, -2);
        this.cWd = (TextView) cX.findViewById(R.id.textview_cur_time);
        this.cWe = (TextView) cX.findViewById(R.id.textview_duration);
        this.cWf = (SeekBar) cX.findViewById(R.id.pb_video_controller_seekBar);
        this.cWf.setOnSeekBarChangeListener(this.cWk);
    }

    protected View cX(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cWc = mediaPlayerControl;
    }

    public void ax(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cWf.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.cWd != null) {
            this.cWd.setText(ap.im(i));
        }
        if (this.cWe != null) {
            this.cWe.setText(ap.im(this.mDuration));
        }
    }

    public void yt(int i) {
        this.mDuration = i;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.cWe != null) {
            this.cWe.setText(ap.im(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.cWc != null) {
            this.cWb = ((this.cWc.getDuration() / 200) / 50) * 50;
            if (this.cWb < 50) {
                this.cWb = 50;
            } else if (this.cWb > 500) {
                this.cWb = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cWb - (this.cWc.getCurrentPosition() % this.cWb));
        }
    }

    public void aBP() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cWf.setProgress(0);
        if (this.cWd != null) {
            this.cWd.setText(ap.im(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aBQ() {
        if (this.cWc == null || this.cGd) {
            return 0;
        }
        int currentPosition = this.cWc.getCurrentPosition();
        int duration = this.cWc.getDuration();
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.cWe != null) {
                this.cWe.setText(ap.im(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.cWf != null) {
            if (duration > 0) {
                this.cWf.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cWc.getBufferPercentage();
        }
        if (this.cWd != null) {
            this.cWd.setText(ap.im(currentPosition));
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
            this.cWc.seekTo(i);
            if (this.cWd != null) {
                this.cWd.setText(ap.im(i));
            }
            showProgress();
        }
        if (!this.cWc.isPlaying()) {
            this.cWf.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String yu(int i) {
        if (i < 0) {
            i = 0;
        }
        return ap.im(i);
    }

    public int getSeekPosition() {
        return this.cWj;
    }

    public int getCurProgress() {
        if (this.cWf != null) {
            return this.cWf.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.hbU = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.hbV = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.cWi = onSeekBarChangeListener;
    }
}

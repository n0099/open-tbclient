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
    private boolean cGc;
    private int cWa;
    private MediaController.MediaPlayerControl cWb;
    private TextView cWc;
    private TextView cWd;
    private SeekBar cWe;
    private SeekBar.OnSeekBarChangeListener cWh;
    private int cWi;
    private SeekBar.OnSeekBarChangeListener cWj;
    private b hbT;
    private a hbU;
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
        this.cWa = 50;
        this.cGc = false;
        this.mShowing = true;
        this.cWi = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cGc && VideoControllerView.this.mShowing && VideoControllerView.this.cWb != null && VideoControllerView.this.cWb.isPlaying()) {
                            int aBQ = VideoControllerView.this.aBQ();
                            if (VideoControllerView.this.hbT != null) {
                                VideoControllerView.this.hbT.mn(aBQ);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cWa - (aBQ % VideoControllerView.this.cWa));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cWj = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cGc = true;
                if (VideoControllerView.this.cWh != null) {
                    VideoControllerView.this.cWh.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cWi = (int) ((VideoControllerView.this.cWb.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cWc != null) {
                        VideoControllerView.this.cWc.setText(ap.im(VideoControllerView.this.cWi));
                    }
                    if (VideoControllerView.this.hbU != null) {
                        VideoControllerView.this.hbU.aBR();
                    }
                    if (VideoControllerView.this.cWh != null) {
                        VideoControllerView.this.cWh.onProgressChanged(seekBar, VideoControllerView.this.cWi, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.cWb.seekTo(VideoControllerView.this.cWi);
                VideoControllerView.this.cGc = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cWh != null) {
                    VideoControllerView.this.cWh.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cWa = 50;
        this.cGc = false;
        this.mShowing = true;
        this.cWi = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cGc && VideoControllerView.this.mShowing && VideoControllerView.this.cWb != null && VideoControllerView.this.cWb.isPlaying()) {
                            int aBQ = VideoControllerView.this.aBQ();
                            if (VideoControllerView.this.hbT != null) {
                                VideoControllerView.this.hbT.mn(aBQ);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cWa - (aBQ % VideoControllerView.this.cWa));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cWj = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cGc = true;
                if (VideoControllerView.this.cWh != null) {
                    VideoControllerView.this.cWh.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cWi = (int) ((VideoControllerView.this.cWb.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cWc != null) {
                        VideoControllerView.this.cWc.setText(ap.im(VideoControllerView.this.cWi));
                    }
                    if (VideoControllerView.this.hbU != null) {
                        VideoControllerView.this.hbU.aBR();
                    }
                    if (VideoControllerView.this.cWh != null) {
                        VideoControllerView.this.cWh.onProgressChanged(seekBar, VideoControllerView.this.cWi, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.cWb.seekTo(VideoControllerView.this.cWi);
                VideoControllerView.this.cGc = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cWh != null) {
                    VideoControllerView.this.cWh.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cWa = 50;
        this.cGc = false;
        this.mShowing = true;
        this.cWi = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cGc && VideoControllerView.this.mShowing && VideoControllerView.this.cWb != null && VideoControllerView.this.cWb.isPlaying()) {
                            int aBQ = VideoControllerView.this.aBQ();
                            if (VideoControllerView.this.hbT != null) {
                                VideoControllerView.this.hbT.mn(aBQ);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cWa - (aBQ % VideoControllerView.this.cWa));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cWj = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cGc = true;
                if (VideoControllerView.this.cWh != null) {
                    VideoControllerView.this.cWh.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.cWi = (int) ((VideoControllerView.this.cWb.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.cWc != null) {
                        VideoControllerView.this.cWc.setText(ap.im(VideoControllerView.this.cWi));
                    }
                    if (VideoControllerView.this.hbU != null) {
                        VideoControllerView.this.hbU.aBR();
                    }
                    if (VideoControllerView.this.cWh != null) {
                        VideoControllerView.this.cWh.onProgressChanged(seekBar, VideoControllerView.this.cWi, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.cWb.seekTo(VideoControllerView.this.cWi);
                VideoControllerView.this.cGc = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cWh != null) {
                    VideoControllerView.this.cWh.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View cX = cX(context);
        addView(cX, -1, -2);
        this.cWc = (TextView) cX.findViewById(R.id.textview_cur_time);
        this.cWd = (TextView) cX.findViewById(R.id.textview_duration);
        this.cWe = (SeekBar) cX.findViewById(R.id.pb_video_controller_seekBar);
        this.cWe.setOnSeekBarChangeListener(this.cWj);
    }

    protected View cX(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cWb = mediaPlayerControl;
    }

    public void ax(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cWe.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.cWc != null) {
            this.cWc.setText(ap.im(i));
        }
        if (this.cWd != null) {
            this.cWd.setText(ap.im(this.mDuration));
        }
    }

    public void yt(int i) {
        this.mDuration = i;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.cWd != null) {
            this.cWd.setText(ap.im(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.cWb != null) {
            this.cWa = ((this.cWb.getDuration() / 200) / 50) * 50;
            if (this.cWa < 50) {
                this.cWa = 50;
            } else if (this.cWa > 500) {
                this.cWa = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cWa - (this.cWb.getCurrentPosition() % this.cWa));
        }
    }

    public void aBP() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cWe.setProgress(0);
        if (this.cWc != null) {
            this.cWc.setText(ap.im(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aBQ() {
        if (this.cWb == null || this.cGc) {
            return 0;
        }
        int currentPosition = this.cWb.getCurrentPosition();
        int duration = this.cWb.getDuration();
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.cWd != null) {
                this.cWd.setText(ap.im(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.cWe != null) {
            if (duration > 0) {
                this.cWe.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cWb.getBufferPercentage();
        }
        if (this.cWc != null) {
            this.cWc.setText(ap.im(currentPosition));
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
            this.cWb.seekTo(i);
            if (this.cWc != null) {
                this.cWc.setText(ap.im(i));
            }
            showProgress();
        }
        if (!this.cWb.isPlaying()) {
            this.cWe.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String yu(int i) {
        if (i < 0) {
            i = 0;
        }
        return ap.im(i);
    }

    public int getSeekPosition() {
        return this.cWi;
    }

    public int getCurProgress() {
        if (this.cWe != null) {
            return this.cWe.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.hbT = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.hbU = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.cWh = onSeekBarChangeListener;
    }
}

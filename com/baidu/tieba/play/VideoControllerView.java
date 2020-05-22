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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VideoControllerView extends RelativeLayout {
    private int dsA;
    private int eON;
    private MediaController.MediaPlayerControl eOO;
    protected TextView eOP;
    protected TextView eOQ;
    protected SeekBar eOR;
    private SeekBar.OnSeekBarChangeListener eOU;
    private SeekBar.OnSeekBarChangeListener eOV;
    private b jcy;
    private a jcz;
    private Context mContext;
    private boolean mDragging;
    protected int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes.dex */
    public interface a {
        void bmO();
    }

    /* loaded from: classes.dex */
    public interface b {
        void pe(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.eON = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dsA = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eOO != null && VideoControllerView.this.eOO.isPlaying()) {
                            int bmN = VideoControllerView.this.bmN();
                            if (VideoControllerView.this.jcy != null) {
                                VideoControllerView.this.jcy.pe(bmN);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eON - (bmN % VideoControllerView.this.eON));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eOV = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eOU != null) {
                    VideoControllerView.this.eOU.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dsA = (int) ((VideoControllerView.this.eOO.getDuration() * i) / 10000);
                    if (VideoControllerView.this.eOP != null) {
                        VideoControllerView.this.eOP.setText(aq.stringForVideoTime(VideoControllerView.this.dsA));
                    }
                    if (VideoControllerView.this.jcz != null) {
                        VideoControllerView.this.jcz.bmO();
                    }
                    if (VideoControllerView.this.eOU != null) {
                        VideoControllerView.this.eOU.onProgressChanged(seekBar, VideoControllerView.this.dsA, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.eOO.seekTo(VideoControllerView.this.dsA);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eOU != null) {
                    VideoControllerView.this.eOU.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eON = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dsA = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eOO != null && VideoControllerView.this.eOO.isPlaying()) {
                            int bmN = VideoControllerView.this.bmN();
                            if (VideoControllerView.this.jcy != null) {
                                VideoControllerView.this.jcy.pe(bmN);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eON - (bmN % VideoControllerView.this.eON));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eOV = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eOU != null) {
                    VideoControllerView.this.eOU.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dsA = (int) ((VideoControllerView.this.eOO.getDuration() * i) / 10000);
                    if (VideoControllerView.this.eOP != null) {
                        VideoControllerView.this.eOP.setText(aq.stringForVideoTime(VideoControllerView.this.dsA));
                    }
                    if (VideoControllerView.this.jcz != null) {
                        VideoControllerView.this.jcz.bmO();
                    }
                    if (VideoControllerView.this.eOU != null) {
                        VideoControllerView.this.eOU.onProgressChanged(seekBar, VideoControllerView.this.dsA, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.eOO.seekTo(VideoControllerView.this.dsA);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eOU != null) {
                    VideoControllerView.this.eOU.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eON = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dsA = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eOO != null && VideoControllerView.this.eOO.isPlaying()) {
                            int bmN = VideoControllerView.this.bmN();
                            if (VideoControllerView.this.jcy != null) {
                                VideoControllerView.this.jcy.pe(bmN);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eON - (bmN % VideoControllerView.this.eON));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eOV = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eOU != null) {
                    VideoControllerView.this.eOU.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.dsA = (int) ((VideoControllerView.this.eOO.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.eOP != null) {
                        VideoControllerView.this.eOP.setText(aq.stringForVideoTime(VideoControllerView.this.dsA));
                    }
                    if (VideoControllerView.this.jcz != null) {
                        VideoControllerView.this.jcz.bmO();
                    }
                    if (VideoControllerView.this.eOU != null) {
                        VideoControllerView.this.eOU.onProgressChanged(seekBar, VideoControllerView.this.dsA, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.eOO.seekTo(VideoControllerView.this.dsA);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eOU != null) {
                    VideoControllerView.this.eOU.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ei = ei(context);
        addView(ei, -1, -2);
        this.eOP = (TextView) ei.findViewById(R.id.textview_cur_time);
        this.eOQ = (TextView) ei.findViewById(R.id.textview_duration);
        this.eOR = (SeekBar) ei.findViewById(R.id.pb_video_controller_seekBar);
        this.eOR.setOnSeekBarChangeListener(this.eOV);
    }

    protected View ei(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eOO = mediaPlayerControl;
    }

    public void bj(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eOR.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.eOP != null) {
            this.eOP.setText(aq.stringForVideoTime(i));
        }
        if (this.eOQ != null) {
            this.eOQ.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void BL(int i) {
        this.mDuration = i;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.eOQ != null) {
            this.eOQ.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.eOO != null) {
            this.eON = ((this.eOO.getDuration() / 200) / 50) * 50;
            if (this.eON < 50) {
                this.eON = 50;
            } else if (this.eON > 500) {
                this.eON = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eON - (this.eOO.getCurrentPosition() % this.eON));
        }
    }

    public void awd() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eOR.setProgress(0);
        if (this.eOP != null) {
            this.eOP.setText(aq.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int bmN() {
        int currentPosition;
        if (this.eOO == null || this.mDragging) {
            return 0;
        }
        int duration = this.eOO.getDuration();
        if (this.eOO instanceof com.baidu.tieba.play.a.a) {
            currentPosition = ((com.baidu.tieba.play.a.a) this.eOO).getCurrentPositionSync();
        } else {
            currentPosition = this.eOO.getCurrentPosition();
        }
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.eOQ != null) {
                this.eOQ.setText(aq.stringForVideoTime(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.eOR != null) {
            if (duration > 0) {
                this.eOR.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.eOO.getBufferPercentage();
        }
        if (this.eOP != null) {
            this.eOP.setText(aq.stringForVideoTime(currentPosition));
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
            this.eOO.seekTo(i);
            if (this.eOP != null) {
                this.eOP.setText(aq.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.eOO.isPlaying()) {
            this.eOR.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String BM(int i) {
        if (i < 0) {
            i = 0;
        }
        return aq.stringForVideoTime(i);
    }

    public int getSeekPosition() {
        return this.dsA;
    }

    public int getCurProgress() {
        if (this.eOR != null) {
            return this.eOR.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.jcy = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.jcz = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.eOU = onSeekBarChangeListener;
    }
}

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
    private SeekBar.OnSeekBarChangeListener eaC;
    private int eaD;
    private SeekBar.OnSeekBarChangeListener eaE;
    private int eav;
    private MediaController.MediaPlayerControl eaw;
    protected TextView eax;
    protected TextView eay;
    protected SeekBar eaz;
    private b idC;
    private a idD;
    private Context mContext;
    private boolean mDragging;
    protected int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes.dex */
    public interface a {
        void aYB();
    }

    /* loaded from: classes.dex */
    public interface b {
        void ok(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.eav = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eaD = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eaw != null && VideoControllerView.this.eaw.isPlaying()) {
                            int aYA = VideoControllerView.this.aYA();
                            if (VideoControllerView.this.idC != null) {
                                VideoControllerView.this.idC.ok(aYA);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eav - (aYA % VideoControllerView.this.eav));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eaE = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eaC != null) {
                    VideoControllerView.this.eaC.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eaD = (int) ((VideoControllerView.this.eaw.getDuration() * i) / 10000);
                    if (VideoControllerView.this.eax != null) {
                        VideoControllerView.this.eax.setText(aq.stringForVideoTime(VideoControllerView.this.eaD));
                    }
                    if (VideoControllerView.this.idD != null) {
                        VideoControllerView.this.idD.aYB();
                    }
                    if (VideoControllerView.this.eaC != null) {
                        VideoControllerView.this.eaC.onProgressChanged(seekBar, VideoControllerView.this.eaD, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.eaw.seekTo(VideoControllerView.this.eaD);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eaC != null) {
                    VideoControllerView.this.eaC.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eav = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eaD = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eaw != null && VideoControllerView.this.eaw.isPlaying()) {
                            int aYA = VideoControllerView.this.aYA();
                            if (VideoControllerView.this.idC != null) {
                                VideoControllerView.this.idC.ok(aYA);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eav - (aYA % VideoControllerView.this.eav));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eaE = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eaC != null) {
                    VideoControllerView.this.eaC.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eaD = (int) ((VideoControllerView.this.eaw.getDuration() * i) / 10000);
                    if (VideoControllerView.this.eax != null) {
                        VideoControllerView.this.eax.setText(aq.stringForVideoTime(VideoControllerView.this.eaD));
                    }
                    if (VideoControllerView.this.idD != null) {
                        VideoControllerView.this.idD.aYB();
                    }
                    if (VideoControllerView.this.eaC != null) {
                        VideoControllerView.this.eaC.onProgressChanged(seekBar, VideoControllerView.this.eaD, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.eaw.seekTo(VideoControllerView.this.eaD);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eaC != null) {
                    VideoControllerView.this.eaC.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eav = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eaD = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eaw != null && VideoControllerView.this.eaw.isPlaying()) {
                            int aYA = VideoControllerView.this.aYA();
                            if (VideoControllerView.this.idC != null) {
                                VideoControllerView.this.idC.ok(aYA);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eav - (aYA % VideoControllerView.this.eav));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eaE = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eaC != null) {
                    VideoControllerView.this.eaC.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eaD = (int) ((VideoControllerView.this.eaw.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.eax != null) {
                        VideoControllerView.this.eax.setText(aq.stringForVideoTime(VideoControllerView.this.eaD));
                    }
                    if (VideoControllerView.this.idD != null) {
                        VideoControllerView.this.idD.aYB();
                    }
                    if (VideoControllerView.this.eaC != null) {
                        VideoControllerView.this.eaC.onProgressChanged(seekBar, VideoControllerView.this.eaD, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.eaw.seekTo(VideoControllerView.this.eaD);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eaC != null) {
                    VideoControllerView.this.eaC.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View er = er(context);
        addView(er, -1, -2);
        this.eax = (TextView) er.findViewById(R.id.textview_cur_time);
        this.eay = (TextView) er.findViewById(R.id.textview_duration);
        this.eaz = (SeekBar) er.findViewById(R.id.pb_video_controller_seekBar);
        this.eaz.setOnSeekBarChangeListener(this.eaE);
    }

    protected View er(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eaw = mediaPlayerControl;
    }

    public void ba(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eaz.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.eax != null) {
            this.eax.setText(aq.stringForVideoTime(i));
        }
        if (this.eay != null) {
            this.eay.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void AB(int i) {
        this.mDuration = i;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.eay != null) {
            this.eay.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.eaw != null) {
            this.eav = ((this.eaw.getDuration() / 200) / 50) * 50;
            if (this.eav < 50) {
                this.eav = 50;
            } else if (this.eav > 500) {
                this.eav = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eav - (this.eaw.getCurrentPosition() % this.eav));
        }
    }

    public void akm() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eaz.setProgress(0);
        if (this.eax != null) {
            this.eax.setText(aq.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aYA() {
        int currentPosition;
        if (this.eaw == null || this.mDragging) {
            return 0;
        }
        int duration = this.eaw.getDuration();
        if (this.eaw instanceof com.baidu.tieba.play.a.a) {
            currentPosition = ((com.baidu.tieba.play.a.a) this.eaw).getCurrentPositionSync();
        } else {
            currentPosition = this.eaw.getCurrentPosition();
        }
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.eay != null) {
                this.eay.setText(aq.stringForVideoTime(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.eaz != null) {
            if (duration > 0) {
                this.eaz.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.eaw.getBufferPercentage();
        }
        if (this.eax != null) {
            this.eax.setText(aq.stringForVideoTime(currentPosition));
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
            this.eaw.seekTo(i);
            if (this.eax != null) {
                this.eax.setText(aq.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.eaw.isPlaying()) {
            this.eaz.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String AC(int i) {
        if (i < 0) {
            i = 0;
        }
        return aq.stringForVideoTime(i);
    }

    public int getSeekPosition() {
        return this.eaD;
    }

    public int getCurProgress() {
        if (this.eaz != null) {
            return this.eaz.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.idC = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.idD = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.eaC = onSeekBarChangeListener;
    }
}

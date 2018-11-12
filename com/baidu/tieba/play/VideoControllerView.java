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
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean bjc;
    private SeekBar.OnSeekBarChangeListener byA;
    private int byB;
    private SeekBar.OnSeekBarChangeListener byC;
    private int byt;
    private MediaController.MediaPlayerControl byu;
    private TextView byv;
    private TextView byw;
    private SeekBar byx;
    private b fkc;
    private a fkd;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes.dex */
    public interface a {
        void Vg();
    }

    /* loaded from: classes.dex */
    public interface b {
        void hu(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.byt = 50;
        this.bjc = false;
        this.mShowing = true;
        this.byB = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bjc && VideoControllerView.this.mShowing && VideoControllerView.this.byu != null && VideoControllerView.this.byu.isPlaying()) {
                            int Vf = VideoControllerView.this.Vf();
                            if (VideoControllerView.this.fkc != null) {
                                VideoControllerView.this.fkc.hu(Vf);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.byt - (Vf % VideoControllerView.this.byt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.byC = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0200e.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_pressed));
                VideoControllerView.this.bjc = true;
                if (VideoControllerView.this.byA != null) {
                    VideoControllerView.this.byA.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.byB = (int) ((VideoControllerView.this.byu.getDuration() * i) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.byv != null) {
                        VideoControllerView.this.byv.setText(ao.dH(VideoControllerView.this.byB));
                    }
                    if (VideoControllerView.this.fkd != null) {
                        VideoControllerView.this.fkd.Vg();
                    }
                    if (VideoControllerView.this.byA != null) {
                        VideoControllerView.this.byA.onProgressChanged(seekBar, VideoControllerView.this.byB, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0200e.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_normal));
                VideoControllerView.this.byu.seekTo(VideoControllerView.this.byB);
                VideoControllerView.this.bjc = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.byA != null) {
                    VideoControllerView.this.byA.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.byt = 50;
        this.bjc = false;
        this.mShowing = true;
        this.byB = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bjc && VideoControllerView.this.mShowing && VideoControllerView.this.byu != null && VideoControllerView.this.byu.isPlaying()) {
                            int Vf = VideoControllerView.this.Vf();
                            if (VideoControllerView.this.fkc != null) {
                                VideoControllerView.this.fkc.hu(Vf);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.byt - (Vf % VideoControllerView.this.byt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.byC = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0200e.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_pressed));
                VideoControllerView.this.bjc = true;
                if (VideoControllerView.this.byA != null) {
                    VideoControllerView.this.byA.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.byB = (int) ((VideoControllerView.this.byu.getDuration() * i) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.byv != null) {
                        VideoControllerView.this.byv.setText(ao.dH(VideoControllerView.this.byB));
                    }
                    if (VideoControllerView.this.fkd != null) {
                        VideoControllerView.this.fkd.Vg();
                    }
                    if (VideoControllerView.this.byA != null) {
                        VideoControllerView.this.byA.onProgressChanged(seekBar, VideoControllerView.this.byB, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0200e.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_normal));
                VideoControllerView.this.byu.seekTo(VideoControllerView.this.byB);
                VideoControllerView.this.bjc = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.byA != null) {
                    VideoControllerView.this.byA.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.byt = 50;
        this.bjc = false;
        this.mShowing = true;
        this.byB = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bjc && VideoControllerView.this.mShowing && VideoControllerView.this.byu != null && VideoControllerView.this.byu.isPlaying()) {
                            int Vf = VideoControllerView.this.Vf();
                            if (VideoControllerView.this.fkc != null) {
                                VideoControllerView.this.fkc.hu(Vf);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.byt - (Vf % VideoControllerView.this.byt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.byC = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0200e.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_pressed));
                VideoControllerView.this.bjc = true;
                if (VideoControllerView.this.byA != null) {
                    VideoControllerView.this.byA.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.byB = (int) ((VideoControllerView.this.byu.getDuration() * i2) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.byv != null) {
                        VideoControllerView.this.byv.setText(ao.dH(VideoControllerView.this.byB));
                    }
                    if (VideoControllerView.this.fkd != null) {
                        VideoControllerView.this.fkd.Vg();
                    }
                    if (VideoControllerView.this.byA != null) {
                        VideoControllerView.this.byA.onProgressChanged(seekBar, VideoControllerView.this.byB, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0200e.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_normal));
                VideoControllerView.this.byu.seekTo(VideoControllerView.this.byB);
                VideoControllerView.this.bjc = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.byA != null) {
                    VideoControllerView.this.byA.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bX = bX(context);
        addView(bX, -1, -2);
        this.byv = (TextView) bX.findViewById(e.g.textview_cur_time);
        this.byw = (TextView) bX.findViewById(e.g.textview_duration);
        this.byx = (SeekBar) bX.findViewById(e.g.pb_video_controller_seekBar);
        this.byx.setOnSeekBarChangeListener(this.byC);
    }

    protected View bX(Context context) {
        return LayoutInflater.from(context).inflate(e.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.byu = mediaPlayerControl;
    }

    public void Y(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.byx.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.byv != null) {
            this.byv.setText(ao.dH(i));
        }
        if (this.byw != null) {
            this.byw.setText(ao.dH(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.byu != null) {
            this.byt = ((this.byu.getDuration() / 200) / 50) * 50;
            if (this.byt < 50) {
                this.byt = 50;
            } else if (this.byt > 500) {
                this.byt = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.byt - (this.byu.getCurrentPosition() % this.byt));
        }
    }

    public void Ve() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.byx.setProgress(0);
        if (this.byv != null) {
            this.byv.setText(ao.dH(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Vf() {
        if (this.byu == null || this.bjc) {
            return 0;
        }
        int currentPosition = this.byu.getCurrentPosition();
        int duration = this.byu.getDuration();
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.byw != null) {
                this.byw.setText(ao.dH(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.byx != null) {
            if (duration > 0) {
                this.byx.setProgress((int) ((ErrDef.Feature.WEIGHT * currentPosition) / duration));
            }
            this.byu.getBufferPercentage();
        }
        if (this.byv != null) {
            this.byv.setText(ao.dH(currentPosition));
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
            this.byu.seekTo(i);
            if (this.byv != null) {
                this.byv.setText(ao.dH(i));
            }
            showProgress();
        }
        if (!this.byu.isPlaying()) {
            this.byx.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String sV(int i) {
        if (i < 0) {
            i = 0;
        }
        return ao.dH(i);
    }

    public int getSeekPosition() {
        return this.byB;
    }

    public int getCurProgress() {
        if (this.byx != null) {
            return this.byx.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.fkc = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.fkd = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.byA = onSeekBarChangeListener;
    }
}

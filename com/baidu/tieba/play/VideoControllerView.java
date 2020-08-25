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
/* loaded from: classes2.dex */
public class VideoControllerView extends RelativeLayout {
    private int dMm;
    private int fpd;
    private MediaController.MediaPlayerControl fpe;
    protected TextView fpf;
    protected TextView fpg;
    protected SeekBar fph;
    private SeekBar.OnSeekBarChangeListener fpk;
    private SeekBar.OnSeekBarChangeListener fpl;
    private b jSt;
    private a jSu;
    private Context mContext;
    private boolean mDragging;
    protected int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes2.dex */
    public interface a {
        void bBq();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void se(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.fpd = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dMm = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fpe != null && VideoControllerView.this.fpe.isPlaying()) {
                            int bBp = VideoControllerView.this.bBp();
                            if (VideoControllerView.this.jSt != null) {
                                VideoControllerView.this.jSt.se(bBp);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fpd - (bBp % VideoControllerView.this.fpd));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fpl = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fpk != null) {
                    VideoControllerView.this.fpk.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dMm = (int) ((VideoControllerView.this.fpe.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fpf != null) {
                        VideoControllerView.this.fpf.setText(at.stringForVideoTime(VideoControllerView.this.dMm));
                    }
                    if (VideoControllerView.this.jSu != null) {
                        VideoControllerView.this.jSu.bBq();
                    }
                    if (VideoControllerView.this.fpk != null) {
                        VideoControllerView.this.fpk.onProgressChanged(seekBar, VideoControllerView.this.dMm, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.fpe.seekTo(VideoControllerView.this.dMm);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fpk != null) {
                    VideoControllerView.this.fpk.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fpd = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dMm = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fpe != null && VideoControllerView.this.fpe.isPlaying()) {
                            int bBp = VideoControllerView.this.bBp();
                            if (VideoControllerView.this.jSt != null) {
                                VideoControllerView.this.jSt.se(bBp);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fpd - (bBp % VideoControllerView.this.fpd));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fpl = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fpk != null) {
                    VideoControllerView.this.fpk.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dMm = (int) ((VideoControllerView.this.fpe.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fpf != null) {
                        VideoControllerView.this.fpf.setText(at.stringForVideoTime(VideoControllerView.this.dMm));
                    }
                    if (VideoControllerView.this.jSu != null) {
                        VideoControllerView.this.jSu.bBq();
                    }
                    if (VideoControllerView.this.fpk != null) {
                        VideoControllerView.this.fpk.onProgressChanged(seekBar, VideoControllerView.this.dMm, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.fpe.seekTo(VideoControllerView.this.dMm);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fpk != null) {
                    VideoControllerView.this.fpk.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fpd = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dMm = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fpe != null && VideoControllerView.this.fpe.isPlaying()) {
                            int bBp = VideoControllerView.this.bBp();
                            if (VideoControllerView.this.jSt != null) {
                                VideoControllerView.this.jSt.se(bBp);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fpd - (bBp % VideoControllerView.this.fpd));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fpl = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fpk != null) {
                    VideoControllerView.this.fpk.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.dMm = (int) ((VideoControllerView.this.fpe.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.fpf != null) {
                        VideoControllerView.this.fpf.setText(at.stringForVideoTime(VideoControllerView.this.dMm));
                    }
                    if (VideoControllerView.this.jSu != null) {
                        VideoControllerView.this.jSu.bBq();
                    }
                    if (VideoControllerView.this.fpk != null) {
                        VideoControllerView.this.fpk.onProgressChanged(seekBar, VideoControllerView.this.dMm, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.fpe.seekTo(VideoControllerView.this.dMm);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fpk != null) {
                    VideoControllerView.this.fpk.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View eu = eu(context);
        addView(eu, -1, -2);
        this.fpf = (TextView) eu.findViewById(R.id.textview_cur_time);
        this.fpg = (TextView) eu.findViewById(R.id.textview_duration);
        this.fph = (SeekBar) eu.findViewById(R.id.pb_video_controller_seekBar);
        this.fph.setOnSeekBarChangeListener(this.fpl);
    }

    protected View eu(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fpe = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fph.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.fpf != null) {
            this.fpf.setText(at.stringForVideoTime(i));
        }
        if (this.fpg != null) {
            this.fpg.setText(at.stringForVideoTime(this.mDuration));
        }
    }

    public void FI(int i) {
        this.mDuration = i;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.fpg != null) {
            this.fpg.setText(at.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.fpe != null) {
            this.fpd = ((this.fpe.getDuration() / 200) / 50) * 50;
            if (this.fpd < 50) {
                this.fpd = 50;
            } else if (this.fpd > 500) {
                this.fpd = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fpd - (this.fpe.getCurrentPosition() % this.fpd));
        }
    }

    public void aIm() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fph.setProgress(0);
        if (this.fpf != null) {
            this.fpf.setText(at.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int bBp() {
        int currentPosition;
        if (this.fpe == null || this.mDragging) {
            return 0;
        }
        int duration = this.fpe.getDuration();
        if (this.fpe instanceof TbCyberVideoView) {
            currentPosition = ((TbCyberVideoView) this.fpe).getCurrentPositionSync();
        } else {
            currentPosition = this.fpe.getCurrentPosition();
        }
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.fpg != null) {
                this.fpg.setText(at.stringForVideoTime(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.fph != null) {
            if (duration > 0) {
                this.fph.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.fpe.getBufferPercentage();
        }
        if (this.fpf != null) {
            this.fpf.setText(at.stringForVideoTime(currentPosition));
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
            this.fpe.seekTo(i);
            if (this.fpf != null) {
                this.fpf.setText(at.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.fpe.isPlaying()) {
            this.fph.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String FJ(int i) {
        if (i < 0) {
            i = 0;
        }
        return at.stringForVideoTime(i);
    }

    public int getSeekPosition() {
        return this.dMm;
    }

    public int getCurProgress() {
        if (this.fph != null) {
            return this.fph.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.jSt = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.jSu = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.fpk = onSeekBarChangeListener;
    }
}

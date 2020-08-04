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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class VideoControllerView extends RelativeLayout {
    private int dDc;
    private int fdL;
    private MediaController.MediaPlayerControl fdM;
    protected TextView fdN;
    protected TextView fdO;
    protected SeekBar fdP;
    private SeekBar.OnSeekBarChangeListener fdS;
    private SeekBar.OnSeekBarChangeListener fdT;
    private b jDa;
    private a jDb;
    private Context mContext;
    private boolean mDragging;
    protected int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes.dex */
    public interface a {
        void bst();
    }

    /* loaded from: classes.dex */
    public interface b {
        void pS(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.fdL = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dDc = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fdM != null && VideoControllerView.this.fdM.isPlaying()) {
                            int bss = VideoControllerView.this.bss();
                            if (VideoControllerView.this.jDa != null) {
                                VideoControllerView.this.jDa.pS(bss);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fdL - (bss % VideoControllerView.this.fdL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fdT = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fdS != null) {
                    VideoControllerView.this.fdS.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dDc = (int) ((VideoControllerView.this.fdM.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fdN != null) {
                        VideoControllerView.this.fdN.setText(as.stringForVideoTime(VideoControllerView.this.dDc));
                    }
                    if (VideoControllerView.this.jDb != null) {
                        VideoControllerView.this.jDb.bst();
                    }
                    if (VideoControllerView.this.fdS != null) {
                        VideoControllerView.this.fdS.onProgressChanged(seekBar, VideoControllerView.this.dDc, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.fdM.seekTo(VideoControllerView.this.dDc);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fdS != null) {
                    VideoControllerView.this.fdS.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdL = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dDc = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fdM != null && VideoControllerView.this.fdM.isPlaying()) {
                            int bss = VideoControllerView.this.bss();
                            if (VideoControllerView.this.jDa != null) {
                                VideoControllerView.this.jDa.pS(bss);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fdL - (bss % VideoControllerView.this.fdL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fdT = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fdS != null) {
                    VideoControllerView.this.fdS.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dDc = (int) ((VideoControllerView.this.fdM.getDuration() * i) / 10000);
                    if (VideoControllerView.this.fdN != null) {
                        VideoControllerView.this.fdN.setText(as.stringForVideoTime(VideoControllerView.this.dDc));
                    }
                    if (VideoControllerView.this.jDb != null) {
                        VideoControllerView.this.jDb.bst();
                    }
                    if (VideoControllerView.this.fdS != null) {
                        VideoControllerView.this.fdS.onProgressChanged(seekBar, VideoControllerView.this.dDc, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.fdM.seekTo(VideoControllerView.this.dDc);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fdS != null) {
                    VideoControllerView.this.fdS.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fdL = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dDc = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.fdM != null && VideoControllerView.this.fdM.isPlaying()) {
                            int bss = VideoControllerView.this.bss();
                            if (VideoControllerView.this.jDa != null) {
                                VideoControllerView.this.jDa.pS(bss);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.fdL - (bss % VideoControllerView.this.fdL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fdT = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.fdS != null) {
                    VideoControllerView.this.fdS.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.dDc = (int) ((VideoControllerView.this.fdM.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.fdN != null) {
                        VideoControllerView.this.fdN.setText(as.stringForVideoTime(VideoControllerView.this.dDc));
                    }
                    if (VideoControllerView.this.jDb != null) {
                        VideoControllerView.this.jDb.bst();
                    }
                    if (VideoControllerView.this.fdS != null) {
                        VideoControllerView.this.fdS.onProgressChanged(seekBar, VideoControllerView.this.dDc, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.fdM.seekTo(VideoControllerView.this.dDc);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.fdS != null) {
                    VideoControllerView.this.fdS.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View em = em(context);
        addView(em, -1, -2);
        this.fdN = (TextView) em.findViewById(R.id.textview_cur_time);
        this.fdO = (TextView) em.findViewById(R.id.textview_duration);
        this.fdP = (SeekBar) em.findViewById(R.id.pb_video_controller_seekBar);
        this.fdP.setOnSeekBarChangeListener(this.fdT);
    }

    protected View em(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fdM = mediaPlayerControl;
    }

    public void bq(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fdP.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.fdN != null) {
            this.fdN.setText(as.stringForVideoTime(i));
        }
        if (this.fdO != null) {
            this.fdO.setText(as.stringForVideoTime(this.mDuration));
        }
    }

    public void Dn(int i) {
        this.mDuration = i;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.fdO != null) {
            this.fdO.setText(as.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.fdM != null) {
            this.fdL = ((this.fdM.getDuration() / 200) / 50) * 50;
            if (this.fdL < 50) {
                this.fdL = 50;
            } else if (this.fdL > 500) {
                this.fdL = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fdL - (this.fdM.getCurrentPosition() % this.fdL));
        }
    }

    public void azZ() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.fdP.setProgress(0);
        if (this.fdN != null) {
            this.fdN.setText(as.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int bss() {
        int currentPosition;
        if (this.fdM == null || this.mDragging) {
            return 0;
        }
        int duration = this.fdM.getDuration();
        if (this.fdM instanceof TbCyberVideoView) {
            currentPosition = ((TbCyberVideoView) this.fdM).getCurrentPositionSync();
        } else {
            currentPosition = this.fdM.getCurrentPosition();
        }
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.fdO != null) {
                this.fdO.setText(as.stringForVideoTime(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.fdP != null) {
            if (duration > 0) {
                this.fdP.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.fdM.getBufferPercentage();
        }
        if (this.fdN != null) {
            this.fdN.setText(as.stringForVideoTime(currentPosition));
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
            this.fdM.seekTo(i);
            if (this.fdN != null) {
                this.fdN.setText(as.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.fdM.isPlaying()) {
            this.fdP.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String Do(int i) {
        if (i < 0) {
            i = 0;
        }
        return as.stringForVideoTime(i);
    }

    public int getSeekPosition() {
        return this.dDc;
    }

    public int getCurProgress() {
        if (this.fdP != null) {
            return this.fdP.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.jDa = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.jDb = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.fdS = onSeekBarChangeListener;
    }
}

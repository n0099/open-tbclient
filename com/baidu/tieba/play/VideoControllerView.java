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
    private int dVN;
    private MediaController.MediaPlayerControl dVO;
    protected TextView dVP;
    protected TextView dVQ;
    protected SeekBar dVR;
    private SeekBar.OnSeekBarChangeListener dVU;
    private int dVV;
    private SeekBar.OnSeekBarChangeListener dVW;
    private b hZM;
    private a hZN;
    private Context mContext;
    private boolean mDragging;
    protected int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes.dex */
    public interface a {
        void aWf();
    }

    /* loaded from: classes.dex */
    public interface b {
        void nR(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.dVN = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dVV = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.dVO != null && VideoControllerView.this.dVO.isPlaying()) {
                            int aWe = VideoControllerView.this.aWe();
                            if (VideoControllerView.this.hZM != null) {
                                VideoControllerView.this.hZM.nR(aWe);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dVN - (aWe % VideoControllerView.this.dVN));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVW = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dVU != null) {
                    VideoControllerView.this.dVU.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dVV = (int) ((VideoControllerView.this.dVO.getDuration() * i) / 10000);
                    if (VideoControllerView.this.dVP != null) {
                        VideoControllerView.this.dVP.setText(aq.stringForVideoTime(VideoControllerView.this.dVV));
                    }
                    if (VideoControllerView.this.hZN != null) {
                        VideoControllerView.this.hZN.aWf();
                    }
                    if (VideoControllerView.this.dVU != null) {
                        VideoControllerView.this.dVU.onProgressChanged(seekBar, VideoControllerView.this.dVV, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.dVO.seekTo(VideoControllerView.this.dVV);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dVU != null) {
                    VideoControllerView.this.dVU.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dVN = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dVV = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.dVO != null && VideoControllerView.this.dVO.isPlaying()) {
                            int aWe = VideoControllerView.this.aWe();
                            if (VideoControllerView.this.hZM != null) {
                                VideoControllerView.this.hZM.nR(aWe);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dVN - (aWe % VideoControllerView.this.dVN));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVW = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dVU != null) {
                    VideoControllerView.this.dVU.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dVV = (int) ((VideoControllerView.this.dVO.getDuration() * i) / 10000);
                    if (VideoControllerView.this.dVP != null) {
                        VideoControllerView.this.dVP.setText(aq.stringForVideoTime(VideoControllerView.this.dVV));
                    }
                    if (VideoControllerView.this.hZN != null) {
                        VideoControllerView.this.hZN.aWf();
                    }
                    if (VideoControllerView.this.dVU != null) {
                        VideoControllerView.this.dVU.onProgressChanged(seekBar, VideoControllerView.this.dVV, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.dVO.seekTo(VideoControllerView.this.dVV);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dVU != null) {
                    VideoControllerView.this.dVU.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dVN = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dVV = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.dVO != null && VideoControllerView.this.dVO.isPlaying()) {
                            int aWe = VideoControllerView.this.aWe();
                            if (VideoControllerView.this.hZM != null) {
                                VideoControllerView.this.hZM.nR(aWe);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dVN - (aWe % VideoControllerView.this.dVN));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVW = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dVU != null) {
                    VideoControllerView.this.dVU.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.dVV = (int) ((VideoControllerView.this.dVO.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.dVP != null) {
                        VideoControllerView.this.dVP.setText(aq.stringForVideoTime(VideoControllerView.this.dVV));
                    }
                    if (VideoControllerView.this.hZN != null) {
                        VideoControllerView.this.hZN.aWf();
                    }
                    if (VideoControllerView.this.dVU != null) {
                        VideoControllerView.this.dVU.onProgressChanged(seekBar, VideoControllerView.this.dVV, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.dVO.seekTo(VideoControllerView.this.dVV);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dVU != null) {
                    VideoControllerView.this.dVU.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ep = ep(context);
        addView(ep, -1, -2);
        this.dVP = (TextView) ep.findViewById(R.id.textview_cur_time);
        this.dVQ = (TextView) ep.findViewById(R.id.textview_duration);
        this.dVR = (SeekBar) ep.findViewById(R.id.pb_video_controller_seekBar);
        this.dVR.setOnSeekBarChangeListener(this.dVW);
    }

    protected View ep(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dVO = mediaPlayerControl;
    }

    public void aZ(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.dVR.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.dVP != null) {
            this.dVP.setText(aq.stringForVideoTime(i));
        }
        if (this.dVQ != null) {
            this.dVQ.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void Aj(int i) {
        this.mDuration = i;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.dVQ != null) {
            this.dVQ.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.dVO != null) {
            this.dVN = ((this.dVO.getDuration() / 200) / 50) * 50;
            if (this.dVN < 50) {
                this.dVN = 50;
            } else if (this.dVN > 500) {
                this.dVN = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dVN - (this.dVO.getCurrentPosition() % this.dVN));
        }
    }

    public void ahT() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.dVR.setProgress(0);
        if (this.dVP != null) {
            this.dVP.setText(aq.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aWe() {
        int currentPosition;
        if (this.dVO == null || this.mDragging) {
            return 0;
        }
        int duration = this.dVO.getDuration();
        if (this.dVO instanceof com.baidu.tieba.play.a.a) {
            currentPosition = ((com.baidu.tieba.play.a.a) this.dVO).getCurrentPositionSync();
        } else {
            currentPosition = this.dVO.getCurrentPosition();
        }
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.dVQ != null) {
                this.dVQ.setText(aq.stringForVideoTime(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.dVR != null) {
            if (duration > 0) {
                this.dVR.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.dVO.getBufferPercentage();
        }
        if (this.dVP != null) {
            this.dVP.setText(aq.stringForVideoTime(currentPosition));
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
            this.dVO.seekTo(i);
            if (this.dVP != null) {
                this.dVP.setText(aq.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.dVO.isPlaying()) {
            this.dVR.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String Ak(int i) {
        if (i < 0) {
            i = 0;
        }
        return aq.stringForVideoTime(i);
    }

    public int getSeekPosition() {
        return this.dVV;
    }

    public int getCurProgress() {
        if (this.dVR != null) {
            return this.dVR.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.hZM = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.hZN = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.dVU = onSeekBarChangeListener;
    }
}

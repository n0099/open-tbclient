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
    private boolean bdx;
    private int eDK;
    private int gjU;
    private MediaController.MediaPlayerControl gjV;
    protected TextView gjW;
    protected TextView gjX;
    protected SeekBar gjY;
    private SeekBar.OnSeekBarChangeListener gkb;
    private SeekBar.OnSeekBarChangeListener gkc;
    private b lbU;
    private a lbV;
    private Context mContext;
    private boolean mDragging;
    protected int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void bPb();
    }

    /* loaded from: classes.dex */
    public interface b {
        void uC(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.gjU = 50;
        this.mDragging = false;
        this.bdx = true;
        this.eDK = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bdx && VideoControllerView.this.gjV != null && VideoControllerView.this.gjV.isPlaying()) {
                            int bPa = VideoControllerView.this.bPa();
                            if (VideoControllerView.this.lbU != null) {
                                VideoControllerView.this.lbU.uC(bPa);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gjU - (bPa % VideoControllerView.this.gjU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gkc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gkb != null) {
                    VideoControllerView.this.gkb.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eDK = (int) ((VideoControllerView.this.gjV.getDuration() * i) / 10000);
                    if (VideoControllerView.this.gjW != null) {
                        VideoControllerView.this.gjW.setText(at.stringForVideoTime(VideoControllerView.this.eDK));
                    }
                    if (VideoControllerView.this.lbV != null) {
                        VideoControllerView.this.lbV.bPb();
                    }
                    if (VideoControllerView.this.gkb != null) {
                        VideoControllerView.this.gkb.onProgressChanged(seekBar, VideoControllerView.this.eDK, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.gjV.seekTo(VideoControllerView.this.eDK);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gkb != null) {
                    VideoControllerView.this.gkb.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gjU = 50;
        this.mDragging = false;
        this.bdx = true;
        this.eDK = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bdx && VideoControllerView.this.gjV != null && VideoControllerView.this.gjV.isPlaying()) {
                            int bPa = VideoControllerView.this.bPa();
                            if (VideoControllerView.this.lbU != null) {
                                VideoControllerView.this.lbU.uC(bPa);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gjU - (bPa % VideoControllerView.this.gjU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gkc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gkb != null) {
                    VideoControllerView.this.gkb.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eDK = (int) ((VideoControllerView.this.gjV.getDuration() * i) / 10000);
                    if (VideoControllerView.this.gjW != null) {
                        VideoControllerView.this.gjW.setText(at.stringForVideoTime(VideoControllerView.this.eDK));
                    }
                    if (VideoControllerView.this.lbV != null) {
                        VideoControllerView.this.lbV.bPb();
                    }
                    if (VideoControllerView.this.gkb != null) {
                        VideoControllerView.this.gkb.onProgressChanged(seekBar, VideoControllerView.this.eDK, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.gjV.seekTo(VideoControllerView.this.eDK);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gkb != null) {
                    VideoControllerView.this.gkb.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gjU = 50;
        this.mDragging = false;
        this.bdx = true;
        this.eDK = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bdx && VideoControllerView.this.gjV != null && VideoControllerView.this.gjV.isPlaying()) {
                            int bPa = VideoControllerView.this.bPa();
                            if (VideoControllerView.this.lbU != null) {
                                VideoControllerView.this.lbU.uC(bPa);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gjU - (bPa % VideoControllerView.this.gjU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gkc = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gkb != null) {
                    VideoControllerView.this.gkb.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eDK = (int) ((VideoControllerView.this.gjV.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.gjW != null) {
                        VideoControllerView.this.gjW.setText(at.stringForVideoTime(VideoControllerView.this.eDK));
                    }
                    if (VideoControllerView.this.lbV != null) {
                        VideoControllerView.this.lbV.bPb();
                    }
                    if (VideoControllerView.this.gkb != null) {
                        VideoControllerView.this.gkb.onProgressChanged(seekBar, VideoControllerView.this.eDK, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.gjV.seekTo(VideoControllerView.this.eDK);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gkb != null) {
                    VideoControllerView.this.gkb.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View fH = fH(context);
        addView(fH, -1, -2);
        this.gjW = (TextView) fH.findViewById(R.id.textview_cur_time);
        this.gjX = (TextView) fH.findViewById(R.id.textview_duration);
        this.gjY = (SeekBar) fH.findViewById(R.id.pb_video_controller_seekBar);
        this.gjY.setOnSeekBarChangeListener(this.gkc);
    }

    protected View fH(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gjV = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.mDuration = i2;
        this.bdx = false;
        this.mHandler.removeMessages(1);
        this.gjY.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.gjW != null) {
            this.gjW.setText(at.stringForVideoTime(i));
        }
        if (this.gjX != null) {
            this.gjX.setText(at.stringForVideoTime(this.mDuration));
        }
    }

    public void IE(int i) {
        this.mDuration = i;
        this.bdx = false;
        this.mHandler.removeMessages(1);
        if (this.gjX != null) {
            this.gjX.setText(at.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.gjV != null) {
            this.gjU = ((this.gjV.getDuration() / 200) / 50) * 50;
            if (this.gjU < 50) {
                this.gjU = 50;
            } else if (this.gjU > 500) {
                this.gjU = 500;
            }
            this.bdx = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gjU - (this.gjV.getCurrentPosition() % this.gjU));
        }
    }

    public void aUR() {
        this.bdx = false;
        this.mHandler.removeMessages(1);
        this.gjY.setProgress(0);
        if (this.gjW != null) {
            this.gjW.setText(at.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int bPa() {
        int currentPosition;
        if (this.gjV == null || this.mDragging) {
            return 0;
        }
        int duration = this.gjV.getDuration();
        if (this.gjV instanceof TbCyberVideoView) {
            currentPosition = ((TbCyberVideoView) this.gjV).getCurrentPositionSync();
        } else {
            currentPosition = this.gjV.getCurrentPosition();
        }
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.gjX != null) {
                this.gjX.setText(at.stringForVideoTime(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.gjY != null) {
            if (duration > 0) {
                this.gjY.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.gjV.getBufferPercentage();
        }
        if (this.gjW != null) {
            this.gjW.setText(at.stringForVideoTime(currentPosition));
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
            this.gjV.seekTo(i);
            if (this.gjW != null) {
                this.gjW.setText(at.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.gjV.isPlaying()) {
            this.gjY.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String IF(int i) {
        if (i < 0) {
            i = 0;
        }
        return at.stringForVideoTime(i);
    }

    public int getSeekPosition() {
        return this.eDK;
    }

    public int getCurProgress() {
        if (this.gjY != null) {
            return this.gjY.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.lbU = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.lbV = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gkb = onSeekBarChangeListener;
    }
}

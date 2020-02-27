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
    private int dZR;
    private MediaController.MediaPlayerControl dZS;
    protected TextView dZT;
    protected TextView dZU;
    protected SeekBar dZV;
    private SeekBar.OnSeekBarChangeListener dZY;
    private int dZZ;
    private SeekBar.OnSeekBarChangeListener eaa;
    private b ibK;
    private a ibL;
    private Context mContext;
    private boolean mDragging;
    protected int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes.dex */
    public interface a {
        void aYu();
    }

    /* loaded from: classes.dex */
    public interface b {
        void oi(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.dZR = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dZZ = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.dZS != null && VideoControllerView.this.dZS.isPlaying()) {
                            int aYt = VideoControllerView.this.aYt();
                            if (VideoControllerView.this.ibK != null) {
                                VideoControllerView.this.ibK.oi(aYt);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dZR - (aYt % VideoControllerView.this.dZR));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eaa = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dZY != null) {
                    VideoControllerView.this.dZY.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dZZ = (int) ((VideoControllerView.this.dZS.getDuration() * i) / 10000);
                    if (VideoControllerView.this.dZT != null) {
                        VideoControllerView.this.dZT.setText(aq.stringForVideoTime(VideoControllerView.this.dZZ));
                    }
                    if (VideoControllerView.this.ibL != null) {
                        VideoControllerView.this.ibL.aYu();
                    }
                    if (VideoControllerView.this.dZY != null) {
                        VideoControllerView.this.dZY.onProgressChanged(seekBar, VideoControllerView.this.dZZ, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.dZS.seekTo(VideoControllerView.this.dZZ);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dZY != null) {
                    VideoControllerView.this.dZY.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dZR = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dZZ = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.dZS != null && VideoControllerView.this.dZS.isPlaying()) {
                            int aYt = VideoControllerView.this.aYt();
                            if (VideoControllerView.this.ibK != null) {
                                VideoControllerView.this.ibK.oi(aYt);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dZR - (aYt % VideoControllerView.this.dZR));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eaa = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dZY != null) {
                    VideoControllerView.this.dZY.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dZZ = (int) ((VideoControllerView.this.dZS.getDuration() * i) / 10000);
                    if (VideoControllerView.this.dZT != null) {
                        VideoControllerView.this.dZT.setText(aq.stringForVideoTime(VideoControllerView.this.dZZ));
                    }
                    if (VideoControllerView.this.ibL != null) {
                        VideoControllerView.this.ibL.aYu();
                    }
                    if (VideoControllerView.this.dZY != null) {
                        VideoControllerView.this.dZY.onProgressChanged(seekBar, VideoControllerView.this.dZZ, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.dZS.seekTo(VideoControllerView.this.dZZ);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dZY != null) {
                    VideoControllerView.this.dZY.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dZR = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.dZZ = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.dZS != null && VideoControllerView.this.dZS.isPlaying()) {
                            int aYt = VideoControllerView.this.aYt();
                            if (VideoControllerView.this.ibK != null) {
                                VideoControllerView.this.ibK.oi(aYt);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dZR - (aYt % VideoControllerView.this.dZR));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eaa = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dZY != null) {
                    VideoControllerView.this.dZY.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.dZZ = (int) ((VideoControllerView.this.dZS.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.dZT != null) {
                        VideoControllerView.this.dZT.setText(aq.stringForVideoTime(VideoControllerView.this.dZZ));
                    }
                    if (VideoControllerView.this.ibL != null) {
                        VideoControllerView.this.ibL.aYu();
                    }
                    if (VideoControllerView.this.dZY != null) {
                        VideoControllerView.this.dZY.onProgressChanged(seekBar, VideoControllerView.this.dZZ, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.dZS.seekTo(VideoControllerView.this.dZZ);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dZY != null) {
                    VideoControllerView.this.dZY.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View es = es(context);
        addView(es, -1, -2);
        this.dZT = (TextView) es.findViewById(R.id.textview_cur_time);
        this.dZU = (TextView) es.findViewById(R.id.textview_duration);
        this.dZV = (SeekBar) es.findViewById(R.id.pb_video_controller_seekBar);
        this.dZV.setOnSeekBarChangeListener(this.eaa);
    }

    protected View es(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dZS = mediaPlayerControl;
    }

    public void aZ(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.dZV.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.dZT != null) {
            this.dZT.setText(aq.stringForVideoTime(i));
        }
        if (this.dZU != null) {
            this.dZU.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void At(int i) {
        this.mDuration = i;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.dZU != null) {
            this.dZU.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.dZS != null) {
            this.dZR = ((this.dZS.getDuration() / 200) / 50) * 50;
            if (this.dZR < 50) {
                this.dZR = 50;
            } else if (this.dZR > 500) {
                this.dZR = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dZR - (this.dZS.getCurrentPosition() % this.dZR));
        }
    }

    public void akh() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.dZV.setProgress(0);
        if (this.dZT != null) {
            this.dZT.setText(aq.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aYt() {
        int currentPosition;
        if (this.dZS == null || this.mDragging) {
            return 0;
        }
        int duration = this.dZS.getDuration();
        if (this.dZS instanceof com.baidu.tieba.play.a.a) {
            currentPosition = ((com.baidu.tieba.play.a.a) this.dZS).getCurrentPositionSync();
        } else {
            currentPosition = this.dZS.getCurrentPosition();
        }
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.dZU != null) {
                this.dZU.setText(aq.stringForVideoTime(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.dZV != null) {
            if (duration > 0) {
                this.dZV.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.dZS.getBufferPercentage();
        }
        if (this.dZT != null) {
            this.dZT.setText(aq.stringForVideoTime(currentPosition));
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
            this.dZS.seekTo(i);
            if (this.dZT != null) {
                this.dZT.setText(aq.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.dZS.isPlaying()) {
            this.dZV.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String Au(int i) {
        if (i < 0) {
            i = 0;
        }
        return aq.stringForVideoTime(i);
    }

    public int getSeekPosition() {
        return this.dZZ;
    }

    public int getCurProgress() {
        if (this.dZV != null) {
            return this.dZV.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.ibK = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.ibL = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.dZY = onSeekBarChangeListener;
    }
}

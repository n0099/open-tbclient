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
    private boolean ahQ;
    private int dVE;
    private MediaController.MediaPlayerControl dVF;
    protected TextView dVG;
    protected TextView dVH;
    protected SeekBar dVI;
    private SeekBar.OnSeekBarChangeListener dVL;
    private int dVM;
    private SeekBar.OnSeekBarChangeListener dVN;
    private b hWi;
    private a hWj;
    private Context mContext;
    private boolean mDragging;
    protected int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void aVM();
    }

    /* loaded from: classes.dex */
    public interface b {
        void nR(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.dVE = 50;
        this.mDragging = false;
        this.ahQ = true;
        this.dVM = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.ahQ && VideoControllerView.this.dVF != null && VideoControllerView.this.dVF.isPlaying()) {
                            int aVL = VideoControllerView.this.aVL();
                            if (VideoControllerView.this.hWi != null) {
                                VideoControllerView.this.hWi.nR(aVL);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dVE - (aVL % VideoControllerView.this.dVE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVN = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dVL != null) {
                    VideoControllerView.this.dVL.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dVM = (int) ((VideoControllerView.this.dVF.getDuration() * i) / 10000);
                    if (VideoControllerView.this.dVG != null) {
                        VideoControllerView.this.dVG.setText(aq.stringForVideoTime(VideoControllerView.this.dVM));
                    }
                    if (VideoControllerView.this.hWj != null) {
                        VideoControllerView.this.hWj.aVM();
                    }
                    if (VideoControllerView.this.dVL != null) {
                        VideoControllerView.this.dVL.onProgressChanged(seekBar, VideoControllerView.this.dVM, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.dVF.seekTo(VideoControllerView.this.dVM);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dVL != null) {
                    VideoControllerView.this.dVL.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dVE = 50;
        this.mDragging = false;
        this.ahQ = true;
        this.dVM = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.ahQ && VideoControllerView.this.dVF != null && VideoControllerView.this.dVF.isPlaying()) {
                            int aVL = VideoControllerView.this.aVL();
                            if (VideoControllerView.this.hWi != null) {
                                VideoControllerView.this.hWi.nR(aVL);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dVE - (aVL % VideoControllerView.this.dVE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVN = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dVL != null) {
                    VideoControllerView.this.dVL.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dVM = (int) ((VideoControllerView.this.dVF.getDuration() * i) / 10000);
                    if (VideoControllerView.this.dVG != null) {
                        VideoControllerView.this.dVG.setText(aq.stringForVideoTime(VideoControllerView.this.dVM));
                    }
                    if (VideoControllerView.this.hWj != null) {
                        VideoControllerView.this.hWj.aVM();
                    }
                    if (VideoControllerView.this.dVL != null) {
                        VideoControllerView.this.dVL.onProgressChanged(seekBar, VideoControllerView.this.dVM, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.dVF.seekTo(VideoControllerView.this.dVM);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dVL != null) {
                    VideoControllerView.this.dVL.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dVE = 50;
        this.mDragging = false;
        this.ahQ = true;
        this.dVM = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.ahQ && VideoControllerView.this.dVF != null && VideoControllerView.this.dVF.isPlaying()) {
                            int aVL = VideoControllerView.this.aVL();
                            if (VideoControllerView.this.hWi != null) {
                                VideoControllerView.this.hWi.nR(aVL);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dVE - (aVL % VideoControllerView.this.dVE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVN = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.dVL != null) {
                    VideoControllerView.this.dVL.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.dVM = (int) ((VideoControllerView.this.dVF.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.dVG != null) {
                        VideoControllerView.this.dVG.setText(aq.stringForVideoTime(VideoControllerView.this.dVM));
                    }
                    if (VideoControllerView.this.hWj != null) {
                        VideoControllerView.this.hWj.aVM();
                    }
                    if (VideoControllerView.this.dVL != null) {
                        VideoControllerView.this.dVL.onProgressChanged(seekBar, VideoControllerView.this.dVM, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.dVF.seekTo(VideoControllerView.this.dVM);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dVL != null) {
                    VideoControllerView.this.dVL.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ep = ep(context);
        addView(ep, -1, -2);
        this.dVG = (TextView) ep.findViewById(R.id.textview_cur_time);
        this.dVH = (TextView) ep.findViewById(R.id.textview_duration);
        this.dVI = (SeekBar) ep.findViewById(R.id.pb_video_controller_seekBar);
        this.dVI.setOnSeekBarChangeListener(this.dVN);
    }

    protected View ep(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dVF = mediaPlayerControl;
    }

    public void aV(int i, int i2) {
        this.mDuration = i2;
        this.ahQ = false;
        this.mHandler.removeMessages(1);
        this.dVI.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.dVG != null) {
            this.dVG.setText(aq.stringForVideoTime(i));
        }
        if (this.dVH != null) {
            this.dVH.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void Ae(int i) {
        this.mDuration = i;
        this.ahQ = false;
        this.mHandler.removeMessages(1);
        if (this.dVH != null) {
            this.dVH.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.dVF != null) {
            this.dVE = ((this.dVF.getDuration() / 200) / 50) * 50;
            if (this.dVE < 50) {
                this.dVE = 50;
            } else if (this.dVE > 500) {
                this.dVE = 500;
            }
            this.ahQ = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dVE - (this.dVF.getCurrentPosition() % this.dVE));
        }
    }

    public void ahA() {
        this.ahQ = false;
        this.mHandler.removeMessages(1);
        this.dVI.setProgress(0);
        if (this.dVG != null) {
            this.dVG.setText(aq.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aVL() {
        int currentPosition;
        if (this.dVF == null || this.mDragging) {
            return 0;
        }
        int duration = this.dVF.getDuration();
        if (this.dVF instanceof com.baidu.tieba.play.a.a) {
            currentPosition = ((com.baidu.tieba.play.a.a) this.dVF).getCurrentPositionSync();
        } else {
            currentPosition = this.dVF.getCurrentPosition();
        }
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.dVH != null) {
                this.dVH.setText(aq.stringForVideoTime(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.dVI != null) {
            if (duration > 0) {
                this.dVI.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.dVF.getBufferPercentage();
        }
        if (this.dVG != null) {
            this.dVG.setText(aq.stringForVideoTime(currentPosition));
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
            this.dVF.seekTo(i);
            if (this.dVG != null) {
                this.dVG.setText(aq.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.dVF.isPlaying()) {
            this.dVI.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String Af(int i) {
        if (i < 0) {
            i = 0;
        }
        return aq.stringForVideoTime(i);
    }

    public int getSeekPosition() {
        return this.dVM;
    }

    public int getCurProgress() {
        if (this.dVI != null) {
            return this.dVI.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.hWi = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.hWj = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.dVL = onSeekBarChangeListener;
    }
}

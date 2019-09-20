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
    private boolean cIv;
    private int cZk;
    private MediaController.MediaPlayerControl cZl;
    private TextView cZm;
    private TextView cZn;
    private SeekBar cZo;
    private SeekBar.OnSeekBarChangeListener cZr;
    private int cZs;
    private SeekBar.OnSeekBarChangeListener cZt;
    private b hkT;
    private a hkU;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes.dex */
    public interface a {
        void aDM();
    }

    /* loaded from: classes.dex */
    public interface b {
        void mz(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.cZk = 50;
        this.cIv = false;
        this.mShowing = true;
        this.cZs = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cIv && VideoControllerView.this.mShowing && VideoControllerView.this.cZl != null && VideoControllerView.this.cZl.isPlaying()) {
                            int aDL = VideoControllerView.this.aDL();
                            if (VideoControllerView.this.hkT != null) {
                                VideoControllerView.this.hkT.mz(aDL);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cZk - (aDL % VideoControllerView.this.cZk));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cZt = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cIv = true;
                if (VideoControllerView.this.cZr != null) {
                    VideoControllerView.this.cZr.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cZs = (int) ((VideoControllerView.this.cZl.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cZm != null) {
                        VideoControllerView.this.cZm.setText(aq.it(VideoControllerView.this.cZs));
                    }
                    if (VideoControllerView.this.hkU != null) {
                        VideoControllerView.this.hkU.aDM();
                    }
                    if (VideoControllerView.this.cZr != null) {
                        VideoControllerView.this.cZr.onProgressChanged(seekBar, VideoControllerView.this.cZs, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.cZl.seekTo(VideoControllerView.this.cZs);
                VideoControllerView.this.cIv = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cZr != null) {
                    VideoControllerView.this.cZr.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cZk = 50;
        this.cIv = false;
        this.mShowing = true;
        this.cZs = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cIv && VideoControllerView.this.mShowing && VideoControllerView.this.cZl != null && VideoControllerView.this.cZl.isPlaying()) {
                            int aDL = VideoControllerView.this.aDL();
                            if (VideoControllerView.this.hkT != null) {
                                VideoControllerView.this.hkT.mz(aDL);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cZk - (aDL % VideoControllerView.this.cZk));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cZt = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cIv = true;
                if (VideoControllerView.this.cZr != null) {
                    VideoControllerView.this.cZr.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cZs = (int) ((VideoControllerView.this.cZl.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cZm != null) {
                        VideoControllerView.this.cZm.setText(aq.it(VideoControllerView.this.cZs));
                    }
                    if (VideoControllerView.this.hkU != null) {
                        VideoControllerView.this.hkU.aDM();
                    }
                    if (VideoControllerView.this.cZr != null) {
                        VideoControllerView.this.cZr.onProgressChanged(seekBar, VideoControllerView.this.cZs, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.cZl.seekTo(VideoControllerView.this.cZs);
                VideoControllerView.this.cIv = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cZr != null) {
                    VideoControllerView.this.cZr.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cZk = 50;
        this.cIv = false;
        this.mShowing = true;
        this.cZs = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cIv && VideoControllerView.this.mShowing && VideoControllerView.this.cZl != null && VideoControllerView.this.cZl.isPlaying()) {
                            int aDL = VideoControllerView.this.aDL();
                            if (VideoControllerView.this.hkT != null) {
                                VideoControllerView.this.hkT.mz(aDL);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cZk - (aDL % VideoControllerView.this.cZk));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cZt = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cIv = true;
                if (VideoControllerView.this.cZr != null) {
                    VideoControllerView.this.cZr.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.cZs = (int) ((VideoControllerView.this.cZl.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.cZm != null) {
                        VideoControllerView.this.cZm.setText(aq.it(VideoControllerView.this.cZs));
                    }
                    if (VideoControllerView.this.hkU != null) {
                        VideoControllerView.this.hkU.aDM();
                    }
                    if (VideoControllerView.this.cZr != null) {
                        VideoControllerView.this.cZr.onProgressChanged(seekBar, VideoControllerView.this.cZs, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.cZl.seekTo(VideoControllerView.this.cZs);
                VideoControllerView.this.cIv = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cZr != null) {
                    VideoControllerView.this.cZr.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View cY = cY(context);
        addView(cY, -1, -2);
        this.cZm = (TextView) cY.findViewById(R.id.textview_cur_time);
        this.cZn = (TextView) cY.findViewById(R.id.textview_duration);
        this.cZo = (SeekBar) cY.findViewById(R.id.pb_video_controller_seekBar);
        this.cZo.setOnSeekBarChangeListener(this.cZt);
    }

    protected View cY(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cZl = mediaPlayerControl;
    }

    public void aC(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cZo.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.cZm != null) {
            this.cZm.setText(aq.it(i));
        }
        if (this.cZn != null) {
            this.cZn.setText(aq.it(this.mDuration));
        }
    }

    public void zd(int i) {
        this.mDuration = i;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.cZn != null) {
            this.cZn.setText(aq.it(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.cZl != null) {
            this.cZk = ((this.cZl.getDuration() / 200) / 50) * 50;
            if (this.cZk < 50) {
                this.cZk = 50;
            } else if (this.cZk > 500) {
                this.cZk = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cZk - (this.cZl.getCurrentPosition() % this.cZk));
        }
    }

    public void aDK() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cZo.setProgress(0);
        if (this.cZm != null) {
            this.cZm.setText(aq.it(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aDL() {
        int currentPosition;
        if (this.cZl == null || this.cIv) {
            return 0;
        }
        int duration = this.cZl.getDuration();
        if (this.cZl instanceof com.baidu.tieba.play.a.a) {
            currentPosition = ((com.baidu.tieba.play.a.a) this.cZl).getCurrentPositionSync();
        } else {
            currentPosition = this.cZl.getCurrentPosition();
        }
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.cZn != null) {
                this.cZn.setText(aq.it(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.cZo != null) {
            if (duration > 0) {
                this.cZo.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cZl.getBufferPercentage();
        }
        if (this.cZm != null) {
            this.cZm.setText(aq.it(currentPosition));
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
            this.cZl.seekTo(i);
            if (this.cZm != null) {
                this.cZm.setText(aq.it(i));
            }
            showProgress();
        }
        if (!this.cZl.isPlaying()) {
            this.cZo.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String ze(int i) {
        if (i < 0) {
            i = 0;
        }
        return aq.it(i);
    }

    public int getSeekPosition() {
        return this.cZs;
    }

    public int getCurProgress() {
        if (this.cZo != null) {
            return this.cZo.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.hkT = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.hkU = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.cZr = onSeekBarChangeListener;
    }
}

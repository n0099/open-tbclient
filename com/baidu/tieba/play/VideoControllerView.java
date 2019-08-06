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
    private boolean cHE;
    private int cXE;
    private MediaController.MediaPlayerControl cXF;
    private TextView cXG;
    private TextView cXH;
    private SeekBar cXI;
    private SeekBar.OnSeekBarChangeListener cXL;
    private int cXM;
    private SeekBar.OnSeekBarChangeListener cXN;
    private b hiZ;
    private a hja;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes.dex */
    public interface a {
        void aDi();
    }

    /* loaded from: classes.dex */
    public interface b {
        void mv(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.cXE = 50;
        this.cHE = false;
        this.mShowing = true;
        this.cXM = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cHE && VideoControllerView.this.mShowing && VideoControllerView.this.cXF != null && VideoControllerView.this.cXF.isPlaying()) {
                            int aDh = VideoControllerView.this.aDh();
                            if (VideoControllerView.this.hiZ != null) {
                                VideoControllerView.this.hiZ.mv(aDh);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cXE - (aDh % VideoControllerView.this.cXE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cXN = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cHE = true;
                if (VideoControllerView.this.cXL != null) {
                    VideoControllerView.this.cXL.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cXM = (int) ((VideoControllerView.this.cXF.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cXG != null) {
                        VideoControllerView.this.cXG.setText(aq.is(VideoControllerView.this.cXM));
                    }
                    if (VideoControllerView.this.hja != null) {
                        VideoControllerView.this.hja.aDi();
                    }
                    if (VideoControllerView.this.cXL != null) {
                        VideoControllerView.this.cXL.onProgressChanged(seekBar, VideoControllerView.this.cXM, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.cXF.seekTo(VideoControllerView.this.cXM);
                VideoControllerView.this.cHE = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cXL != null) {
                    VideoControllerView.this.cXL.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cXE = 50;
        this.cHE = false;
        this.mShowing = true;
        this.cXM = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cHE && VideoControllerView.this.mShowing && VideoControllerView.this.cXF != null && VideoControllerView.this.cXF.isPlaying()) {
                            int aDh = VideoControllerView.this.aDh();
                            if (VideoControllerView.this.hiZ != null) {
                                VideoControllerView.this.hiZ.mv(aDh);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cXE - (aDh % VideoControllerView.this.cXE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cXN = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cHE = true;
                if (VideoControllerView.this.cXL != null) {
                    VideoControllerView.this.cXL.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cXM = (int) ((VideoControllerView.this.cXF.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cXG != null) {
                        VideoControllerView.this.cXG.setText(aq.is(VideoControllerView.this.cXM));
                    }
                    if (VideoControllerView.this.hja != null) {
                        VideoControllerView.this.hja.aDi();
                    }
                    if (VideoControllerView.this.cXL != null) {
                        VideoControllerView.this.cXL.onProgressChanged(seekBar, VideoControllerView.this.cXM, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.cXF.seekTo(VideoControllerView.this.cXM);
                VideoControllerView.this.cHE = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cXL != null) {
                    VideoControllerView.this.cXL.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cXE = 50;
        this.cHE = false;
        this.mShowing = true;
        this.cXM = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cHE && VideoControllerView.this.mShowing && VideoControllerView.this.cXF != null && VideoControllerView.this.cXF.isPlaying()) {
                            int aDh = VideoControllerView.this.aDh();
                            if (VideoControllerView.this.hiZ != null) {
                                VideoControllerView.this.hiZ.mv(aDh);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cXE - (aDh % VideoControllerView.this.cXE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cXN = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cHE = true;
                if (VideoControllerView.this.cXL != null) {
                    VideoControllerView.this.cXL.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.cXM = (int) ((VideoControllerView.this.cXF.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.cXG != null) {
                        VideoControllerView.this.cXG.setText(aq.is(VideoControllerView.this.cXM));
                    }
                    if (VideoControllerView.this.hja != null) {
                        VideoControllerView.this.hja.aDi();
                    }
                    if (VideoControllerView.this.cXL != null) {
                        VideoControllerView.this.cXL.onProgressChanged(seekBar, VideoControllerView.this.cXM, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.cXF.seekTo(VideoControllerView.this.cXM);
                VideoControllerView.this.cHE = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cXL != null) {
                    VideoControllerView.this.cXL.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View cY = cY(context);
        addView(cY, -1, -2);
        this.cXG = (TextView) cY.findViewById(R.id.textview_cur_time);
        this.cXH = (TextView) cY.findViewById(R.id.textview_duration);
        this.cXI = (SeekBar) cY.findViewById(R.id.pb_video_controller_seekBar);
        this.cXI.setOnSeekBarChangeListener(this.cXN);
    }

    protected View cY(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cXF = mediaPlayerControl;
    }

    public void aC(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cXI.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.cXG != null) {
            this.cXG.setText(aq.is(i));
        }
        if (this.cXH != null) {
            this.cXH.setText(aq.is(this.mDuration));
        }
    }

    public void za(int i) {
        this.mDuration = i;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.cXH != null) {
            this.cXH.setText(aq.is(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.cXF != null) {
            this.cXE = ((this.cXF.getDuration() / 200) / 50) * 50;
            if (this.cXE < 50) {
                this.cXE = 50;
            } else if (this.cXE > 500) {
                this.cXE = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cXE - (this.cXF.getCurrentPosition() % this.cXE));
        }
    }

    public void aDg() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cXI.setProgress(0);
        if (this.cXG != null) {
            this.cXG.setText(aq.is(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aDh() {
        if (this.cXF == null || this.cHE) {
            return 0;
        }
        int currentPosition = this.cXF.getCurrentPosition();
        int duration = this.cXF.getDuration();
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.cXH != null) {
                this.cXH.setText(aq.is(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.cXI != null) {
            if (duration > 0) {
                this.cXI.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cXF.getBufferPercentage();
        }
        if (this.cXG != null) {
            this.cXG.setText(aq.is(currentPosition));
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
            this.cXF.seekTo(i);
            if (this.cXG != null) {
                this.cXG.setText(aq.is(i));
            }
            showProgress();
        }
        if (!this.cXF.isPlaying()) {
            this.cXI.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String zb(int i) {
        if (i < 0) {
            i = 0;
        }
        return aq.is(i);
    }

    public int getSeekPosition() {
        return this.cXM;
    }

    public int getCurProgress() {
        if (this.cXI != null) {
            return this.cXI.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.hiZ = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.hja = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.cXL = onSeekBarChangeListener;
    }
}

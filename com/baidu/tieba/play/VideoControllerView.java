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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class VideoControllerView extends RelativeLayout {
    private int cNN;
    private MediaController.MediaPlayerControl cNO;
    private TextView cNP;
    private TextView cNQ;
    private SeekBar cNR;
    private SeekBar.OnSeekBarChangeListener cNU;
    private int cNV;
    private SeekBar.OnSeekBarChangeListener cNW;
    private boolean cxS;
    private b gKv;
    private a gKw;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes.dex */
    public interface a {
        void awI();
    }

    /* loaded from: classes.dex */
    public interface b {
        void ly(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.cNN = 50;
        this.cxS = false;
        this.mShowing = true;
        this.cNV = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cxS && VideoControllerView.this.mShowing && VideoControllerView.this.cNO != null && VideoControllerView.this.cNO.isPlaying()) {
                            int awH = VideoControllerView.this.awH();
                            if (VideoControllerView.this.gKv != null) {
                                VideoControllerView.this.gKv.ly(awH);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cNN - (awH % VideoControllerView.this.cNN));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cNW = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(d.f.video_seekbar_thumb_pressed));
                VideoControllerView.this.cxS = true;
                if (VideoControllerView.this.cNU != null) {
                    VideoControllerView.this.cNU.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cNV = (int) ((VideoControllerView.this.cNO.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cNP != null) {
                        VideoControllerView.this.cNP.setText(ap.hy(VideoControllerView.this.cNV));
                    }
                    if (VideoControllerView.this.gKw != null) {
                        VideoControllerView.this.gKw.awI();
                    }
                    if (VideoControllerView.this.cNU != null) {
                        VideoControllerView.this.cNU.onProgressChanged(seekBar, VideoControllerView.this.cNV, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(d.f.video_seekbar_thumb_normal));
                VideoControllerView.this.cNO.seekTo(VideoControllerView.this.cNV);
                VideoControllerView.this.cxS = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cNU != null) {
                    VideoControllerView.this.cNU.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cNN = 50;
        this.cxS = false;
        this.mShowing = true;
        this.cNV = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cxS && VideoControllerView.this.mShowing && VideoControllerView.this.cNO != null && VideoControllerView.this.cNO.isPlaying()) {
                            int awH = VideoControllerView.this.awH();
                            if (VideoControllerView.this.gKv != null) {
                                VideoControllerView.this.gKv.ly(awH);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cNN - (awH % VideoControllerView.this.cNN));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cNW = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(d.f.video_seekbar_thumb_pressed));
                VideoControllerView.this.cxS = true;
                if (VideoControllerView.this.cNU != null) {
                    VideoControllerView.this.cNU.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.cNV = (int) ((VideoControllerView.this.cNO.getDuration() * i) / 10000);
                    if (VideoControllerView.this.cNP != null) {
                        VideoControllerView.this.cNP.setText(ap.hy(VideoControllerView.this.cNV));
                    }
                    if (VideoControllerView.this.gKw != null) {
                        VideoControllerView.this.gKw.awI();
                    }
                    if (VideoControllerView.this.cNU != null) {
                        VideoControllerView.this.cNU.onProgressChanged(seekBar, VideoControllerView.this.cNV, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(d.f.video_seekbar_thumb_normal));
                VideoControllerView.this.cNO.seekTo(VideoControllerView.this.cNV);
                VideoControllerView.this.cxS = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cNU != null) {
                    VideoControllerView.this.cNU.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cNN = 50;
        this.cxS = false;
        this.mShowing = true;
        this.cNV = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cxS && VideoControllerView.this.mShowing && VideoControllerView.this.cNO != null && VideoControllerView.this.cNO.isPlaying()) {
                            int awH = VideoControllerView.this.awH();
                            if (VideoControllerView.this.gKv != null) {
                                VideoControllerView.this.gKv.ly(awH);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.cNN - (awH % VideoControllerView.this.cNN));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cNW = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(d.f.video_seekbar_thumb_pressed));
                VideoControllerView.this.cxS = true;
                if (VideoControllerView.this.cNU != null) {
                    VideoControllerView.this.cNU.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.cNV = (int) ((VideoControllerView.this.cNO.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.cNP != null) {
                        VideoControllerView.this.cNP.setText(ap.hy(VideoControllerView.this.cNV));
                    }
                    if (VideoControllerView.this.gKw != null) {
                        VideoControllerView.this.gKw.awI();
                    }
                    if (VideoControllerView.this.cNU != null) {
                        VideoControllerView.this.cNU.onProgressChanged(seekBar, VideoControllerView.this.cNV, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(d.f.video_seekbar_thumb_normal));
                VideoControllerView.this.cNO.seekTo(VideoControllerView.this.cNV);
                VideoControllerView.this.cxS = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.cNU != null) {
                    VideoControllerView.this.cNU.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View dr = dr(context);
        addView(dr, -1, -2);
        this.cNP = (TextView) dr.findViewById(d.g.textview_cur_time);
        this.cNQ = (TextView) dr.findViewById(d.g.textview_duration);
        this.cNR = (SeekBar) dr.findViewById(d.g.pb_video_controller_seekBar);
        this.cNR.setOnSeekBarChangeListener(this.cNW);
    }

    protected View dr(Context context) {
        return LayoutInflater.from(context).inflate(d.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cNO = mediaPlayerControl;
    }

    public void ax(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cNR.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.cNP != null) {
            this.cNP.setText(ap.hy(i));
        }
        if (this.cNQ != null) {
            this.cNQ.setText(ap.hy(this.mDuration));
        }
    }

    public void xm(int i) {
        this.mDuration = i;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.cNQ != null) {
            this.cNQ.setText(ap.hy(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.cNO != null) {
            this.cNN = ((this.cNO.getDuration() / 200) / 50) * 50;
            if (this.cNN < 50) {
                this.cNN = 50;
            } else if (this.cNN > 500) {
                this.cNN = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.cNN - (this.cNO.getCurrentPosition() % this.cNN));
        }
    }

    public void awG() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.cNR.setProgress(0);
        if (this.cNP != null) {
            this.cNP.setText(ap.hy(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int awH() {
        if (this.cNO == null || this.cxS) {
            return 0;
        }
        int currentPosition = this.cNO.getCurrentPosition();
        int duration = this.cNO.getDuration();
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.cNQ != null) {
                this.cNQ.setText(ap.hy(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.cNR != null) {
            if (duration > 0) {
                this.cNR.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.cNO.getBufferPercentage();
        }
        if (this.cNP != null) {
            this.cNP.setText(ap.hy(currentPosition));
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
            this.cNO.seekTo(i);
            if (this.cNP != null) {
                this.cNP.setText(ap.hy(i));
            }
            showProgress();
        }
        if (!this.cNO.isPlaying()) {
            this.cNR.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String xn(int i) {
        if (i < 0) {
            i = 0;
        }
        return ap.hy(i);
    }

    public int getSeekPosition() {
        return this.cNV;
    }

    public int getCurProgress() {
        if (this.cNR != null) {
            return this.cNR.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.gKv = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.gKw = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.cNU = onSeekBarChangeListener;
    }
}

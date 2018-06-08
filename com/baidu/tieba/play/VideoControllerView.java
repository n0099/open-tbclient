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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean aZD;
    private int blG;
    private MediaController.MediaPlayerControl blH;
    private TextView blI;
    private TextView blJ;
    private boolean blK;
    private SeekBar blL;
    private SeekBar.OnSeekBarChangeListener blO;
    private int blP;
    private SeekBar.OnSeekBarChangeListener blQ;
    private b eLX;
    private a eLY;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void QE();
    }

    /* loaded from: classes.dex */
    public interface b {
        void gu(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.blG = 50;
        this.aZD = false;
        this.blK = true;
        this.blP = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.aZD && VideoControllerView.this.blK && VideoControllerView.this.blH != null && VideoControllerView.this.blH.isPlaying()) {
                            int QD = VideoControllerView.this.QD();
                            if (VideoControllerView.this.eLX != null) {
                                VideoControllerView.this.eLX.gu(QD);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.blG - (QD % VideoControllerView.this.blG));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.blQ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.aZD = true;
                if (VideoControllerView.this.blO != null) {
                    VideoControllerView.this.blO.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.blP = (int) ((VideoControllerView.this.blH.getDuration() * i) / 10000);
                    if (VideoControllerView.this.blI != null) {
                        VideoControllerView.this.blI.setText(ao.cX(VideoControllerView.this.blP));
                    }
                    if (VideoControllerView.this.eLY != null) {
                        VideoControllerView.this.eLY.QE();
                    }
                    if (VideoControllerView.this.blO != null) {
                        VideoControllerView.this.blO.onProgressChanged(seekBar, VideoControllerView.this.blP, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.blH.seekTo(VideoControllerView.this.blP);
                VideoControllerView.this.aZD = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.blO != null) {
                    VideoControllerView.this.blO.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.blG = 50;
        this.aZD = false;
        this.blK = true;
        this.blP = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.aZD && VideoControllerView.this.blK && VideoControllerView.this.blH != null && VideoControllerView.this.blH.isPlaying()) {
                            int QD = VideoControllerView.this.QD();
                            if (VideoControllerView.this.eLX != null) {
                                VideoControllerView.this.eLX.gu(QD);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.blG - (QD % VideoControllerView.this.blG));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.blQ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.aZD = true;
                if (VideoControllerView.this.blO != null) {
                    VideoControllerView.this.blO.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.blP = (int) ((VideoControllerView.this.blH.getDuration() * i) / 10000);
                    if (VideoControllerView.this.blI != null) {
                        VideoControllerView.this.blI.setText(ao.cX(VideoControllerView.this.blP));
                    }
                    if (VideoControllerView.this.eLY != null) {
                        VideoControllerView.this.eLY.QE();
                    }
                    if (VideoControllerView.this.blO != null) {
                        VideoControllerView.this.blO.onProgressChanged(seekBar, VideoControllerView.this.blP, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.blH.seekTo(VideoControllerView.this.blP);
                VideoControllerView.this.aZD = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.blO != null) {
                    VideoControllerView.this.blO.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.blG = 50;
        this.aZD = false;
        this.blK = true;
        this.blP = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.aZD && VideoControllerView.this.blK && VideoControllerView.this.blH != null && VideoControllerView.this.blH.isPlaying()) {
                            int QD = VideoControllerView.this.QD();
                            if (VideoControllerView.this.eLX != null) {
                                VideoControllerView.this.eLX.gu(QD);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.blG - (QD % VideoControllerView.this.blG));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.blQ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.aZD = true;
                if (VideoControllerView.this.blO != null) {
                    VideoControllerView.this.blO.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.blP = (int) ((VideoControllerView.this.blH.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.blI != null) {
                        VideoControllerView.this.blI.setText(ao.cX(VideoControllerView.this.blP));
                    }
                    if (VideoControllerView.this.eLY != null) {
                        VideoControllerView.this.eLY.QE();
                    }
                    if (VideoControllerView.this.blO != null) {
                        VideoControllerView.this.blO.onProgressChanged(seekBar, VideoControllerView.this.blP, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.blH.seekTo(VideoControllerView.this.blP);
                VideoControllerView.this.aZD = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.blO != null) {
                    VideoControllerView.this.blO.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bl = bl(context);
        addView(bl, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.blI = (TextView) bl.findViewById(d.g.textview_cur_time);
        this.blJ = (TextView) bl.findViewById(d.g.textview_duration);
        this.blL = (SeekBar) bl.findViewById(d.g.pb_video_controller_seekBar);
        this.blL.setOnSeekBarChangeListener(this.blQ);
    }

    protected View bl(Context context) {
        return LayoutInflater.from(context).inflate(d.i.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.blH = mediaPlayerControl;
    }

    public void R(int i, int i2) {
        this.mDuration = i2;
        this.blK = false;
        this.mHandler.removeMessages(1);
        this.blL.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.blI != null) {
            this.blI.setText(ao.cX(i));
        }
        if (this.blJ != null) {
            this.blJ.setText(ao.cX(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.blH != null) {
            this.blG = ((this.blH.getDuration() / 200) / 50) * 50;
            if (this.blG < 50) {
                this.blG = 50;
            } else if (this.blG > 500) {
                this.blG = 500;
            }
            this.blK = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.blG - (this.blH.getCurrentPosition() % this.blG));
        }
    }

    public void QC() {
        this.blK = false;
        this.mHandler.removeMessages(1);
        this.blL.setProgress(0);
        if (this.blI != null) {
            this.blI.setText(ao.cX(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int QD() {
        if (this.blH == null || this.aZD) {
            return 0;
        }
        int currentPosition = this.blH.getCurrentPosition();
        int duration = this.blH.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.blL != null) {
            if (duration > 0) {
                this.blL.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.blH.getBufferPercentage();
        }
        if (this.blI != null) {
            this.blI.setText(ao.cX(currentPosition));
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
            this.blH.seekTo(i);
            if (this.blI != null) {
                this.blI.setText(ao.cX(i));
            }
            showProgress();
        }
        if (!this.blH.isPlaying()) {
            this.blL.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String rC(int i) {
        if (i < 0) {
            i = 0;
        }
        return ao.cX(i);
    }

    public int getSeekPosition() {
        return this.blP;
    }

    public int getCurProgress() {
        if (this.blL != null) {
            return this.blL.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.eLX = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.eLY = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.blO = onSeekBarChangeListener;
    }
}

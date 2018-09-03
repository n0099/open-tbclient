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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean baF;
    private int bnO;
    private MediaController.MediaPlayerControl bnP;
    private TextView bnQ;
    private TextView bnR;
    private SeekBar bnS;
    private SeekBar.OnSeekBarChangeListener bnV;
    private int bnW;
    private SeekBar.OnSeekBarChangeListener bnX;
    private b eTE;
    private a eTF;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes.dex */
    public interface a {
        void Rn();
    }

    /* loaded from: classes.dex */
    public interface b {
        void gz(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.bnO = 50;
        this.baF = false;
        this.mShowing = true;
        this.bnW = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.baF && VideoControllerView.this.mShowing && VideoControllerView.this.bnP != null && VideoControllerView.this.bnP.isPlaying()) {
                            int Rm = VideoControllerView.this.Rm();
                            if (VideoControllerView.this.eTE != null) {
                                VideoControllerView.this.eTE.gz(Rm);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bnO - (Rm % VideoControllerView.this.bnO));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bnX = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.baF = true;
                if (VideoControllerView.this.bnV != null) {
                    VideoControllerView.this.bnV.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bnW = (int) ((VideoControllerView.this.bnP.getDuration() * i) / 10000);
                    if (VideoControllerView.this.bnQ != null) {
                        VideoControllerView.this.bnQ.setText(ap.da(VideoControllerView.this.bnW));
                    }
                    if (VideoControllerView.this.eTF != null) {
                        VideoControllerView.this.eTF.Rn();
                    }
                    if (VideoControllerView.this.bnV != null) {
                        VideoControllerView.this.bnV.onProgressChanged(seekBar, VideoControllerView.this.bnW, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bnP.seekTo(VideoControllerView.this.bnW);
                VideoControllerView.this.baF = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bnV != null) {
                    VideoControllerView.this.bnV.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bnO = 50;
        this.baF = false;
        this.mShowing = true;
        this.bnW = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.baF && VideoControllerView.this.mShowing && VideoControllerView.this.bnP != null && VideoControllerView.this.bnP.isPlaying()) {
                            int Rm = VideoControllerView.this.Rm();
                            if (VideoControllerView.this.eTE != null) {
                                VideoControllerView.this.eTE.gz(Rm);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bnO - (Rm % VideoControllerView.this.bnO));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bnX = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.baF = true;
                if (VideoControllerView.this.bnV != null) {
                    VideoControllerView.this.bnV.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bnW = (int) ((VideoControllerView.this.bnP.getDuration() * i) / 10000);
                    if (VideoControllerView.this.bnQ != null) {
                        VideoControllerView.this.bnQ.setText(ap.da(VideoControllerView.this.bnW));
                    }
                    if (VideoControllerView.this.eTF != null) {
                        VideoControllerView.this.eTF.Rn();
                    }
                    if (VideoControllerView.this.bnV != null) {
                        VideoControllerView.this.bnV.onProgressChanged(seekBar, VideoControllerView.this.bnW, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bnP.seekTo(VideoControllerView.this.bnW);
                VideoControllerView.this.baF = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bnV != null) {
                    VideoControllerView.this.bnV.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bnO = 50;
        this.baF = false;
        this.mShowing = true;
        this.bnW = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.baF && VideoControllerView.this.mShowing && VideoControllerView.this.bnP != null && VideoControllerView.this.bnP.isPlaying()) {
                            int Rm = VideoControllerView.this.Rm();
                            if (VideoControllerView.this.eTE != null) {
                                VideoControllerView.this.eTE.gz(Rm);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bnO - (Rm % VideoControllerView.this.bnO));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bnX = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.baF = true;
                if (VideoControllerView.this.bnV != null) {
                    VideoControllerView.this.bnV.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.bnW = (int) ((VideoControllerView.this.bnP.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.bnQ != null) {
                        VideoControllerView.this.bnQ.setText(ap.da(VideoControllerView.this.bnW));
                    }
                    if (VideoControllerView.this.eTF != null) {
                        VideoControllerView.this.eTF.Rn();
                    }
                    if (VideoControllerView.this.bnV != null) {
                        VideoControllerView.this.bnV.onProgressChanged(seekBar, VideoControllerView.this.bnW, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bnP.seekTo(VideoControllerView.this.bnW);
                VideoControllerView.this.baF = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bnV != null) {
                    VideoControllerView.this.bnV.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bl = bl(context);
        addView(bl, -1, (int) context.getResources().getDimension(f.e.ds80));
        this.bnQ = (TextView) bl.findViewById(f.g.textview_cur_time);
        this.bnR = (TextView) bl.findViewById(f.g.textview_duration);
        this.bnS = (SeekBar) bl.findViewById(f.g.pb_video_controller_seekBar);
        this.bnS.setOnSeekBarChangeListener(this.bnX);
    }

    protected View bl(Context context) {
        return LayoutInflater.from(context).inflate(f.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bnP = mediaPlayerControl;
    }

    public void T(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.bnS.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bnQ != null) {
            this.bnQ.setText(ap.da(i));
        }
        if (this.bnR != null) {
            this.bnR.setText(ap.da(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bnP != null) {
            this.bnO = ((this.bnP.getDuration() / 200) / 50) * 50;
            if (this.bnO < 50) {
                this.bnO = 50;
            } else if (this.bnO > 500) {
                this.bnO = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bnO - (this.bnP.getCurrentPosition() % this.bnO));
        }
    }

    public void Rl() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.bnS.setProgress(0);
        if (this.bnQ != null) {
            this.bnQ.setText(ap.da(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Rm() {
        if (this.bnP == null || this.baF) {
            return 0;
        }
        int currentPosition = this.bnP.getCurrentPosition();
        int duration = this.bnP.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bnS != null) {
            if (duration > 0) {
                this.bnS.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bnP.getBufferPercentage();
        }
        if (this.bnQ != null) {
            this.bnQ.setText(ap.da(currentPosition));
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
            this.bnP.seekTo(i);
            if (this.bnQ != null) {
                this.bnQ.setText(ap.da(i));
            }
            showProgress();
        }
        if (!this.bnP.isPlaying()) {
            this.bnS.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String rI(int i) {
        if (i < 0) {
            i = 0;
        }
        return ap.da(i);
    }

    public int getSeekPosition() {
        return this.bnW;
    }

    public int getCurProgress() {
        if (this.bnS != null) {
            return this.bnS.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.eTE = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.eTF = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bnV = onSeekBarChangeListener;
    }
}

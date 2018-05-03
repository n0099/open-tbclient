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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean aRI;
    private SeekBar bdA;
    private SeekBar.OnSeekBarChangeListener bdD;
    private int bdE;
    private SeekBar.OnSeekBarChangeListener bdF;
    private int bdv;
    private MediaController.MediaPlayerControl bdw;
    private TextView bdx;
    private TextView bdy;
    private boolean bdz;
    private b ezv;
    private a ezw;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void Ng();
    }

    /* loaded from: classes.dex */
    public interface b {
        void gs(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.bdv = 50;
        this.aRI = false;
        this.bdz = true;
        this.bdE = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.aRI && VideoControllerView.this.bdz && VideoControllerView.this.bdw != null && VideoControllerView.this.bdw.isPlaying()) {
                            int Nf = VideoControllerView.this.Nf();
                            if (VideoControllerView.this.ezv != null) {
                                VideoControllerView.this.ezv.gs(Nf);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bdv - (Nf % VideoControllerView.this.bdv));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bdF = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.aRI = true;
                if (VideoControllerView.this.bdD != null) {
                    VideoControllerView.this.bdD.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bdE = (int) ((VideoControllerView.this.bdw.getDuration() * i) / 10000);
                    if (VideoControllerView.this.bdx != null) {
                        VideoControllerView.this.bdx.setText(an.cU(VideoControllerView.this.bdE));
                    }
                    if (VideoControllerView.this.ezw != null) {
                        VideoControllerView.this.ezw.Ng();
                    }
                    if (VideoControllerView.this.bdD != null) {
                        VideoControllerView.this.bdD.onProgressChanged(seekBar, VideoControllerView.this.bdE, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bdw.seekTo(VideoControllerView.this.bdE);
                VideoControllerView.this.aRI = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bdD != null) {
                    VideoControllerView.this.bdD.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdv = 50;
        this.aRI = false;
        this.bdz = true;
        this.bdE = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.aRI && VideoControllerView.this.bdz && VideoControllerView.this.bdw != null && VideoControllerView.this.bdw.isPlaying()) {
                            int Nf = VideoControllerView.this.Nf();
                            if (VideoControllerView.this.ezv != null) {
                                VideoControllerView.this.ezv.gs(Nf);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bdv - (Nf % VideoControllerView.this.bdv));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bdF = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.aRI = true;
                if (VideoControllerView.this.bdD != null) {
                    VideoControllerView.this.bdD.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bdE = (int) ((VideoControllerView.this.bdw.getDuration() * i) / 10000);
                    if (VideoControllerView.this.bdx != null) {
                        VideoControllerView.this.bdx.setText(an.cU(VideoControllerView.this.bdE));
                    }
                    if (VideoControllerView.this.ezw != null) {
                        VideoControllerView.this.ezw.Ng();
                    }
                    if (VideoControllerView.this.bdD != null) {
                        VideoControllerView.this.bdD.onProgressChanged(seekBar, VideoControllerView.this.bdE, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bdw.seekTo(VideoControllerView.this.bdE);
                VideoControllerView.this.aRI = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bdD != null) {
                    VideoControllerView.this.bdD.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdv = 50;
        this.aRI = false;
        this.bdz = true;
        this.bdE = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.aRI && VideoControllerView.this.bdz && VideoControllerView.this.bdw != null && VideoControllerView.this.bdw.isPlaying()) {
                            int Nf = VideoControllerView.this.Nf();
                            if (VideoControllerView.this.ezv != null) {
                                VideoControllerView.this.ezv.gs(Nf);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bdv - (Nf % VideoControllerView.this.bdv));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bdF = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.aRI = true;
                if (VideoControllerView.this.bdD != null) {
                    VideoControllerView.this.bdD.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.bdE = (int) ((VideoControllerView.this.bdw.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.bdx != null) {
                        VideoControllerView.this.bdx.setText(an.cU(VideoControllerView.this.bdE));
                    }
                    if (VideoControllerView.this.ezw != null) {
                        VideoControllerView.this.ezw.Ng();
                    }
                    if (VideoControllerView.this.bdD != null) {
                        VideoControllerView.this.bdD.onProgressChanged(seekBar, VideoControllerView.this.bdE, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControllerView.this.bdw.seekTo(VideoControllerView.this.bdE);
                VideoControllerView.this.aRI = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bdD != null) {
                    VideoControllerView.this.bdD.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bb = bb(context);
        addView(bb, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.bdx = (TextView) bb.findViewById(d.g.textview_cur_time);
        this.bdy = (TextView) bb.findViewById(d.g.textview_duration);
        this.bdA = (SeekBar) bb.findViewById(d.g.pb_video_controller_seekBar);
        this.bdA.setOnSeekBarChangeListener(this.bdF);
    }

    protected View bb(Context context) {
        return LayoutInflater.from(context).inflate(d.i.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bdw = mediaPlayerControl;
    }

    public void Q(int i, int i2) {
        this.mDuration = i2;
        this.bdz = false;
        this.mHandler.removeMessages(1);
        this.bdA.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bdx != null) {
            this.bdx.setText(an.cU(i));
        }
        if (this.bdy != null) {
            this.bdy.setText(an.cU(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bdw != null) {
            this.bdv = ((this.bdw.getDuration() / 200) / 50) * 50;
            if (this.bdv < 50) {
                this.bdv = 50;
            } else if (this.bdv > 500) {
                this.bdv = 500;
            }
            this.bdz = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bdv - (this.bdw.getCurrentPosition() % this.bdv));
        }
    }

    public void Ne() {
        this.bdz = false;
        this.mHandler.removeMessages(1);
        this.bdA.setProgress(0);
        if (this.bdx != null) {
            this.bdx.setText(an.cU(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Nf() {
        if (this.bdw == null || this.aRI) {
            return 0;
        }
        int currentPosition = this.bdw.getCurrentPosition();
        int duration = this.bdw.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bdA != null) {
            if (duration > 0) {
                this.bdA.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bdw.getBufferPercentage();
        }
        if (this.bdx != null) {
            this.bdx.setText(an.cU(currentPosition));
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
            this.bdw.seekTo(i);
            if (this.bdx != null) {
                this.bdx.setText(an.cU(i));
            }
            showProgress();
        }
        if (!this.bdw.isPlaying()) {
            this.bdA.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String rr(int i) {
        if (i < 0) {
            i = 0;
        }
        return an.cU(i);
    }

    public int getSeekPosition() {
        return this.bdE;
    }

    public int getCurProgress() {
        if (this.bdA != null) {
            return this.bdA.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.ezv = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.ezw = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bdD = onSeekBarChangeListener;
    }
}

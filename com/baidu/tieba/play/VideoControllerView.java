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
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class VideoControllerView extends RelativeLayout {
    private int bCH;
    private MediaController.MediaPlayerControl bCI;
    private TextView bCJ;
    private TextView bCK;
    private SeekBar bCL;
    private SeekBar.OnSeekBarChangeListener bCO;
    private int bCP;
    private SeekBar.OnSeekBarChangeListener bCQ;
    private boolean bns;
    private b fuH;
    private a fuI;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes.dex */
    public interface a {
        void WL();
    }

    /* loaded from: classes.dex */
    public interface b {
        void hJ(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.bCH = 50;
        this.bns = false;
        this.mShowing = true;
        this.bCP = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bns && VideoControllerView.this.mShowing && VideoControllerView.this.bCI != null && VideoControllerView.this.bCI.isPlaying()) {
                            int WK = VideoControllerView.this.WK();
                            if (VideoControllerView.this.fuH != null) {
                                VideoControllerView.this.fuH.hJ(WK);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bCH - (WK % VideoControllerView.this.bCH));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bCQ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0210e.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_pressed));
                VideoControllerView.this.bns = true;
                if (VideoControllerView.this.bCO != null) {
                    VideoControllerView.this.bCO.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bCP = (int) ((VideoControllerView.this.bCI.getDuration() * i) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.bCJ != null) {
                        VideoControllerView.this.bCJ.setText(ao.dV(VideoControllerView.this.bCP));
                    }
                    if (VideoControllerView.this.fuI != null) {
                        VideoControllerView.this.fuI.WL();
                    }
                    if (VideoControllerView.this.bCO != null) {
                        VideoControllerView.this.bCO.onProgressChanged(seekBar, VideoControllerView.this.bCP, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0210e.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_normal));
                VideoControllerView.this.bCI.seekTo(VideoControllerView.this.bCP);
                VideoControllerView.this.bns = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bCO != null) {
                    VideoControllerView.this.bCO.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bCH = 50;
        this.bns = false;
        this.mShowing = true;
        this.bCP = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bns && VideoControllerView.this.mShowing && VideoControllerView.this.bCI != null && VideoControllerView.this.bCI.isPlaying()) {
                            int WK = VideoControllerView.this.WK();
                            if (VideoControllerView.this.fuH != null) {
                                VideoControllerView.this.fuH.hJ(WK);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bCH - (WK % VideoControllerView.this.bCH));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bCQ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0210e.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_pressed));
                VideoControllerView.this.bns = true;
                if (VideoControllerView.this.bCO != null) {
                    VideoControllerView.this.bCO.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bCP = (int) ((VideoControllerView.this.bCI.getDuration() * i) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.bCJ != null) {
                        VideoControllerView.this.bCJ.setText(ao.dV(VideoControllerView.this.bCP));
                    }
                    if (VideoControllerView.this.fuI != null) {
                        VideoControllerView.this.fuI.WL();
                    }
                    if (VideoControllerView.this.bCO != null) {
                        VideoControllerView.this.bCO.onProgressChanged(seekBar, VideoControllerView.this.bCP, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0210e.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_normal));
                VideoControllerView.this.bCI.seekTo(VideoControllerView.this.bCP);
                VideoControllerView.this.bns = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bCO != null) {
                    VideoControllerView.this.bCO.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bCH = 50;
        this.bns = false;
        this.mShowing = true;
        this.bCP = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bns && VideoControllerView.this.mShowing && VideoControllerView.this.bCI != null && VideoControllerView.this.bCI.isPlaying()) {
                            int WK = VideoControllerView.this.WK();
                            if (VideoControllerView.this.fuH != null) {
                                VideoControllerView.this.fuH.hJ(WK);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bCH - (WK % VideoControllerView.this.bCH));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bCQ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0210e.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_pressed));
                VideoControllerView.this.bns = true;
                if (VideoControllerView.this.bCO != null) {
                    VideoControllerView.this.bCO.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.bCP = (int) ((VideoControllerView.this.bCI.getDuration() * i2) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.bCJ != null) {
                        VideoControllerView.this.bCJ.setText(ao.dV(VideoControllerView.this.bCP));
                    }
                    if (VideoControllerView.this.fuI != null) {
                        VideoControllerView.this.fuI.WL();
                    }
                    if (VideoControllerView.this.bCO != null) {
                        VideoControllerView.this.bCO.onProgressChanged(seekBar, VideoControllerView.this.bCP, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0210e.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_normal));
                VideoControllerView.this.bCI.seekTo(VideoControllerView.this.bCP);
                VideoControllerView.this.bns = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bCO != null) {
                    VideoControllerView.this.bCO.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ca = ca(context);
        addView(ca, -1, -2);
        this.bCJ = (TextView) ca.findViewById(e.g.textview_cur_time);
        this.bCK = (TextView) ca.findViewById(e.g.textview_duration);
        this.bCL = (SeekBar) ca.findViewById(e.g.pb_video_controller_seekBar);
        this.bCL.setOnSeekBarChangeListener(this.bCQ);
    }

    protected View ca(Context context) {
        return LayoutInflater.from(context).inflate(e.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bCI = mediaPlayerControl;
    }

    public void Z(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.bCL.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bCJ != null) {
            this.bCJ.setText(ao.dV(i));
        }
        if (this.bCK != null) {
            this.bCK.setText(ao.dV(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bCI != null) {
            this.bCH = ((this.bCI.getDuration() / 200) / 50) * 50;
            if (this.bCH < 50) {
                this.bCH = 50;
            } else if (this.bCH > 500) {
                this.bCH = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bCH - (this.bCI.getCurrentPosition() % this.bCH));
        }
    }

    public void WJ() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.bCL.setProgress(0);
        if (this.bCJ != null) {
            this.bCJ.setText(ao.dV(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int WK() {
        if (this.bCI == null || this.bns) {
            return 0;
        }
        int currentPosition = this.bCI.getCurrentPosition();
        int duration = this.bCI.getDuration();
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.bCK != null) {
                this.bCK.setText(ao.dV(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bCL != null) {
            if (duration > 0) {
                this.bCL.setProgress((int) ((ErrDef.Feature.WEIGHT * currentPosition) / duration));
            }
            this.bCI.getBufferPercentage();
        }
        if (this.bCJ != null) {
            this.bCJ.setText(ao.dV(currentPosition));
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
            this.bCI.seekTo(i);
            if (this.bCJ != null) {
                this.bCJ.setText(ao.dV(i));
            }
            showProgress();
        }
        if (!this.bCI.isPlaying()) {
            this.bCL.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String tG(int i) {
        if (i < 0) {
            i = 0;
        }
        return ao.dV(i);
    }

    public int getSeekPosition() {
        return this.bCP;
    }

    public int getCurProgress() {
        if (this.bCL != null) {
            return this.bCL.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.fuH = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.fuI = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bCO = onSeekBarChangeListener;
    }
}

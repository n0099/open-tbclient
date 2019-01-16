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
    private int bCG;
    private MediaController.MediaPlayerControl bCH;
    private TextView bCI;
    private TextView bCJ;
    private SeekBar bCK;
    private SeekBar.OnSeekBarChangeListener bCN;
    private int bCO;
    private SeekBar.OnSeekBarChangeListener bCP;
    private boolean bnr;
    private b fuG;
    private a fuH;
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
        this.bCG = 50;
        this.bnr = false;
        this.mShowing = true;
        this.bCO = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bnr && VideoControllerView.this.mShowing && VideoControllerView.this.bCH != null && VideoControllerView.this.bCH.isPlaying()) {
                            int WK = VideoControllerView.this.WK();
                            if (VideoControllerView.this.fuG != null) {
                                VideoControllerView.this.fuG.hJ(WK);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bCG - (WK % VideoControllerView.this.bCG));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bCP = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0210e.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_pressed));
                VideoControllerView.this.bnr = true;
                if (VideoControllerView.this.bCN != null) {
                    VideoControllerView.this.bCN.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bCO = (int) ((VideoControllerView.this.bCH.getDuration() * i) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.bCI != null) {
                        VideoControllerView.this.bCI.setText(ao.dV(VideoControllerView.this.bCO));
                    }
                    if (VideoControllerView.this.fuH != null) {
                        VideoControllerView.this.fuH.WL();
                    }
                    if (VideoControllerView.this.bCN != null) {
                        VideoControllerView.this.bCN.onProgressChanged(seekBar, VideoControllerView.this.bCO, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0210e.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_normal));
                VideoControllerView.this.bCH.seekTo(VideoControllerView.this.bCO);
                VideoControllerView.this.bnr = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bCN != null) {
                    VideoControllerView.this.bCN.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bCG = 50;
        this.bnr = false;
        this.mShowing = true;
        this.bCO = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bnr && VideoControllerView.this.mShowing && VideoControllerView.this.bCH != null && VideoControllerView.this.bCH.isPlaying()) {
                            int WK = VideoControllerView.this.WK();
                            if (VideoControllerView.this.fuG != null) {
                                VideoControllerView.this.fuG.hJ(WK);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bCG - (WK % VideoControllerView.this.bCG));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bCP = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0210e.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_pressed));
                VideoControllerView.this.bnr = true;
                if (VideoControllerView.this.bCN != null) {
                    VideoControllerView.this.bCN.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bCO = (int) ((VideoControllerView.this.bCH.getDuration() * i) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.bCI != null) {
                        VideoControllerView.this.bCI.setText(ao.dV(VideoControllerView.this.bCO));
                    }
                    if (VideoControllerView.this.fuH != null) {
                        VideoControllerView.this.fuH.WL();
                    }
                    if (VideoControllerView.this.bCN != null) {
                        VideoControllerView.this.bCN.onProgressChanged(seekBar, VideoControllerView.this.bCO, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0210e.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_normal));
                VideoControllerView.this.bCH.seekTo(VideoControllerView.this.bCO);
                VideoControllerView.this.bnr = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bCN != null) {
                    VideoControllerView.this.bCN.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bCG = 50;
        this.bnr = false;
        this.mShowing = true;
        this.bCO = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bnr && VideoControllerView.this.mShowing && VideoControllerView.this.bCH != null && VideoControllerView.this.bCH.isPlaying()) {
                            int WK = VideoControllerView.this.WK();
                            if (VideoControllerView.this.fuG != null) {
                                VideoControllerView.this.fuG.hJ(WK);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bCG - (WK % VideoControllerView.this.bCG));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bCP = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0210e.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_pressed));
                VideoControllerView.this.bnr = true;
                if (VideoControllerView.this.bCN != null) {
                    VideoControllerView.this.bCN.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.bCO = (int) ((VideoControllerView.this.bCH.getDuration() * i2) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.bCI != null) {
                        VideoControllerView.this.bCI.setText(ao.dV(VideoControllerView.this.bCO));
                    }
                    if (VideoControllerView.this.fuH != null) {
                        VideoControllerView.this.fuH.WL();
                    }
                    if (VideoControllerView.this.bCN != null) {
                        VideoControllerView.this.bCN.onProgressChanged(seekBar, VideoControllerView.this.bCO, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0210e.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_normal));
                VideoControllerView.this.bCH.seekTo(VideoControllerView.this.bCO);
                VideoControllerView.this.bnr = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bCN != null) {
                    VideoControllerView.this.bCN.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ca = ca(context);
        addView(ca, -1, -2);
        this.bCI = (TextView) ca.findViewById(e.g.textview_cur_time);
        this.bCJ = (TextView) ca.findViewById(e.g.textview_duration);
        this.bCK = (SeekBar) ca.findViewById(e.g.pb_video_controller_seekBar);
        this.bCK.setOnSeekBarChangeListener(this.bCP);
    }

    protected View ca(Context context) {
        return LayoutInflater.from(context).inflate(e.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bCH = mediaPlayerControl;
    }

    public void Z(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.bCK.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bCI != null) {
            this.bCI.setText(ao.dV(i));
        }
        if (this.bCJ != null) {
            this.bCJ.setText(ao.dV(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bCH != null) {
            this.bCG = ((this.bCH.getDuration() / 200) / 50) * 50;
            if (this.bCG < 50) {
                this.bCG = 50;
            } else if (this.bCG > 500) {
                this.bCG = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bCG - (this.bCH.getCurrentPosition() % this.bCG));
        }
    }

    public void WJ() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.bCK.setProgress(0);
        if (this.bCI != null) {
            this.bCI.setText(ao.dV(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int WK() {
        if (this.bCH == null || this.bnr) {
            return 0;
        }
        int currentPosition = this.bCH.getCurrentPosition();
        int duration = this.bCH.getDuration();
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.bCJ != null) {
                this.bCJ.setText(ao.dV(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bCK != null) {
            if (duration > 0) {
                this.bCK.setProgress((int) ((ErrDef.Feature.WEIGHT * currentPosition) / duration));
            }
            this.bCH.getBufferPercentage();
        }
        if (this.bCI != null) {
            this.bCI.setText(ao.dV(currentPosition));
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
            this.bCH.seekTo(i);
            if (this.bCI != null) {
                this.bCI.setText(ao.dV(i));
            }
            showProgress();
        }
        if (!this.bCH.isPlaying()) {
            this.bCK.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String tG(int i) {
        if (i < 0) {
            i = 0;
        }
        return ao.dV(i);
    }

    public int getSeekPosition() {
        return this.bCO;
    }

    public int getCurProgress() {
        if (this.bCK != null) {
            return this.bCK.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.fuG = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.fuH = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bCN = onSeekBarChangeListener;
    }
}

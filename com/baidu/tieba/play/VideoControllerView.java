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
    private boolean bir;
    private int bxI;
    private MediaController.MediaPlayerControl bxJ;
    private TextView bxK;
    private TextView bxL;
    private SeekBar bxM;
    private SeekBar.OnSeekBarChangeListener bxP;
    private int bxQ;
    private SeekBar.OnSeekBarChangeListener bxR;
    private b fiI;
    private a fiJ;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes.dex */
    public interface a {
        void UX();
    }

    /* loaded from: classes.dex */
    public interface b {
        void hh(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.bxI = 50;
        this.bir = false;
        this.mShowing = true;
        this.bxQ = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bir && VideoControllerView.this.mShowing && VideoControllerView.this.bxJ != null && VideoControllerView.this.bxJ.isPlaying()) {
                            int UW = VideoControllerView.this.UW();
                            if (VideoControllerView.this.fiI != null) {
                                VideoControllerView.this.fiI.hh(UW);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bxI - (UW % VideoControllerView.this.bxI));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bxR = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0175e.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_pressed));
                VideoControllerView.this.bir = true;
                if (VideoControllerView.this.bxP != null) {
                    VideoControllerView.this.bxP.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bxQ = (int) ((VideoControllerView.this.bxJ.getDuration() * i) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.bxK != null) {
                        VideoControllerView.this.bxK.setText(ao.dt(VideoControllerView.this.bxQ));
                    }
                    if (VideoControllerView.this.fiJ != null) {
                        VideoControllerView.this.fiJ.UX();
                    }
                    if (VideoControllerView.this.bxP != null) {
                        VideoControllerView.this.bxP.onProgressChanged(seekBar, VideoControllerView.this.bxQ, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0175e.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_normal));
                VideoControllerView.this.bxJ.seekTo(VideoControllerView.this.bxQ);
                VideoControllerView.this.bir = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bxP != null) {
                    VideoControllerView.this.bxP.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bxI = 50;
        this.bir = false;
        this.mShowing = true;
        this.bxQ = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bir && VideoControllerView.this.mShowing && VideoControllerView.this.bxJ != null && VideoControllerView.this.bxJ.isPlaying()) {
                            int UW = VideoControllerView.this.UW();
                            if (VideoControllerView.this.fiI != null) {
                                VideoControllerView.this.fiI.hh(UW);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bxI - (UW % VideoControllerView.this.bxI));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bxR = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0175e.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_pressed));
                VideoControllerView.this.bir = true;
                if (VideoControllerView.this.bxP != null) {
                    VideoControllerView.this.bxP.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.bxQ = (int) ((VideoControllerView.this.bxJ.getDuration() * i) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.bxK != null) {
                        VideoControllerView.this.bxK.setText(ao.dt(VideoControllerView.this.bxQ));
                    }
                    if (VideoControllerView.this.fiJ != null) {
                        VideoControllerView.this.fiJ.UX();
                    }
                    if (VideoControllerView.this.bxP != null) {
                        VideoControllerView.this.bxP.onProgressChanged(seekBar, VideoControllerView.this.bxQ, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0175e.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_normal));
                VideoControllerView.this.bxJ.seekTo(VideoControllerView.this.bxQ);
                VideoControllerView.this.bir = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bxP != null) {
                    VideoControllerView.this.bxP.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bxI = 50;
        this.bir = false;
        this.mShowing = true;
        this.bxQ = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.bir && VideoControllerView.this.mShowing && VideoControllerView.this.bxJ != null && VideoControllerView.this.bxJ.isPlaying()) {
                            int UW = VideoControllerView.this.UW();
                            if (VideoControllerView.this.fiI != null) {
                                VideoControllerView.this.fiI.hh(UW);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.bxI - (UW % VideoControllerView.this.bxI));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bxR = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0175e.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_pressed));
                VideoControllerView.this.bir = true;
                if (VideoControllerView.this.bxP != null) {
                    VideoControllerView.this.bxP.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.bxQ = (int) ((VideoControllerView.this.bxJ.getDuration() * i2) / ErrDef.Feature.WEIGHT);
                    if (VideoControllerView.this.bxK != null) {
                        VideoControllerView.this.bxK.setText(ao.dt(VideoControllerView.this.bxQ));
                    }
                    if (VideoControllerView.this.fiJ != null) {
                        VideoControllerView.this.fiJ.UX();
                    }
                    if (VideoControllerView.this.bxP != null) {
                        VideoControllerView.this.bxP.onProgressChanged(seekBar, VideoControllerView.this.bxQ, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0175e.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(e.f.video_seekbar_thumb_normal));
                VideoControllerView.this.bxJ.seekTo(VideoControllerView.this.bxQ);
                VideoControllerView.this.bir = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.bxP != null) {
                    VideoControllerView.this.bxP.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ca = ca(context);
        addView(ca, -1, -2);
        this.bxK = (TextView) ca.findViewById(e.g.textview_cur_time);
        this.bxL = (TextView) ca.findViewById(e.g.textview_duration);
        this.bxM = (SeekBar) ca.findViewById(e.g.pb_video_controller_seekBar);
        this.bxM.setOnSeekBarChangeListener(this.bxR);
    }

    protected View ca(Context context) {
        return LayoutInflater.from(context).inflate(e.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bxJ = mediaPlayerControl;
    }

    public void X(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.bxM.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bxK != null) {
            this.bxK.setText(ao.dt(i));
        }
        if (this.bxL != null) {
            this.bxL.setText(ao.dt(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bxJ != null) {
            this.bxI = ((this.bxJ.getDuration() / 200) / 50) * 50;
            if (this.bxI < 50) {
                this.bxI = 50;
            } else if (this.bxI > 500) {
                this.bxI = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bxI - (this.bxJ.getCurrentPosition() % this.bxI));
        }
    }

    public void UV() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.bxM.setProgress(0);
        if (this.bxK != null) {
            this.bxK.setText(ao.dt(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int UW() {
        if (this.bxJ == null || this.bir) {
            return 0;
        }
        int currentPosition = this.bxJ.getCurrentPosition();
        int duration = this.bxJ.getDuration();
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.bxL != null) {
                this.bxL.setText(ao.dt(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bxM != null) {
            if (duration > 0) {
                this.bxM.setProgress((int) ((ErrDef.Feature.WEIGHT * currentPosition) / duration));
            }
            this.bxJ.getBufferPercentage();
        }
        if (this.bxK != null) {
            this.bxK.setText(ao.dt(currentPosition));
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
            this.bxJ.seekTo(i);
            if (this.bxK != null) {
                this.bxK.setText(ao.dt(i));
            }
            showProgress();
        }
        if (!this.bxJ.isPlaying()) {
            this.bxM.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String sC(int i) {
        if (i < 0) {
            i = 0;
        }
        return ao.dt(i);
    }

    public int getSeekPosition() {
        return this.bxQ;
    }

    public int getCurProgress() {
        if (this.bxM != null) {
            return this.bxM.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.fiI = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.fiJ = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bxP = onSeekBarChangeListener;
    }
}

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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean bbP;
    private int eud;
    private int gaB;
    private MediaController.MediaPlayerControl gaC;
    protected TextView gaD;
    protected TextView gaE;
    protected SeekBar gaF;
    private SeekBar.OnSeekBarChangeListener gaI;
    private SeekBar.OnSeekBarChangeListener gaJ;
    private b kWo;
    private a kWp;
    private Context mContext;
    private boolean mDragging;
    protected int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void bMI();
    }

    /* loaded from: classes.dex */
    public interface b {
        void ur(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.gaB = 50;
        this.mDragging = false;
        this.bbP = true;
        this.eud = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bbP && VideoControllerView.this.gaC != null && VideoControllerView.this.gaC.isPlaying()) {
                            int bMH = VideoControllerView.this.bMH();
                            if (VideoControllerView.this.kWo != null) {
                                VideoControllerView.this.kWo.ur(bMH);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gaB - (bMH % VideoControllerView.this.gaB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gaJ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gaI != null) {
                    VideoControllerView.this.gaI.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eud = (int) ((VideoControllerView.this.gaC.getDuration() * i) / 10000);
                    if (VideoControllerView.this.gaD != null) {
                        VideoControllerView.this.gaD.setText(au.stringForVideoTime(VideoControllerView.this.eud));
                    }
                    if (VideoControllerView.this.kWp != null) {
                        VideoControllerView.this.kWp.bMI();
                    }
                    if (VideoControllerView.this.gaI != null) {
                        VideoControllerView.this.gaI.onProgressChanged(seekBar, VideoControllerView.this.eud, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.gaC.seekTo(VideoControllerView.this.eud);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gaI != null) {
                    VideoControllerView.this.gaI.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaB = 50;
        this.mDragging = false;
        this.bbP = true;
        this.eud = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bbP && VideoControllerView.this.gaC != null && VideoControllerView.this.gaC.isPlaying()) {
                            int bMH = VideoControllerView.this.bMH();
                            if (VideoControllerView.this.kWo != null) {
                                VideoControllerView.this.kWo.ur(bMH);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gaB - (bMH % VideoControllerView.this.gaB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gaJ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gaI != null) {
                    VideoControllerView.this.gaI.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eud = (int) ((VideoControllerView.this.gaC.getDuration() * i) / 10000);
                    if (VideoControllerView.this.gaD != null) {
                        VideoControllerView.this.gaD.setText(au.stringForVideoTime(VideoControllerView.this.eud));
                    }
                    if (VideoControllerView.this.kWp != null) {
                        VideoControllerView.this.kWp.bMI();
                    }
                    if (VideoControllerView.this.gaI != null) {
                        VideoControllerView.this.gaI.onProgressChanged(seekBar, VideoControllerView.this.eud, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.gaC.seekTo(VideoControllerView.this.eud);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gaI != null) {
                    VideoControllerView.this.gaI.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gaB = 50;
        this.mDragging = false;
        this.bbP = true;
        this.eud = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bbP && VideoControllerView.this.gaC != null && VideoControllerView.this.gaC.isPlaying()) {
                            int bMH = VideoControllerView.this.bMH();
                            if (VideoControllerView.this.kWo != null) {
                                VideoControllerView.this.kWo.ur(bMH);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gaB - (bMH % VideoControllerView.this.gaB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gaJ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gaI != null) {
                    VideoControllerView.this.gaI.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eud = (int) ((VideoControllerView.this.gaC.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.gaD != null) {
                        VideoControllerView.this.gaD.setText(au.stringForVideoTime(VideoControllerView.this.eud));
                    }
                    if (VideoControllerView.this.kWp != null) {
                        VideoControllerView.this.kWp.bMI();
                    }
                    if (VideoControllerView.this.gaI != null) {
                        VideoControllerView.this.gaI.onProgressChanged(seekBar, VideoControllerView.this.eud, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.gaC.seekTo(VideoControllerView.this.eud);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gaI != null) {
                    VideoControllerView.this.gaI.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View fn = fn(context);
        addView(fn, -1, -2);
        this.gaD = (TextView) fn.findViewById(R.id.textview_cur_time);
        this.gaE = (TextView) fn.findViewById(R.id.textview_duration);
        this.gaF = (SeekBar) fn.findViewById(R.id.pb_video_controller_seekBar);
        this.gaF.setOnSeekBarChangeListener(this.gaJ);
    }

    protected View fn(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gaC = mediaPlayerControl;
    }

    public void bB(int i, int i2) {
        this.mDuration = i2;
        this.bbP = false;
        this.mHandler.removeMessages(1);
        this.gaF.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.gaD != null) {
            this.gaD.setText(au.stringForVideoTime(i));
        }
        if (this.gaE != null) {
            this.gaE.setText(au.stringForVideoTime(this.mDuration));
        }
    }

    public void IK(int i) {
        this.mDuration = i;
        this.bbP = false;
        this.mHandler.removeMessages(1);
        if (this.gaE != null) {
            this.gaE.setText(au.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.gaC != null) {
            this.gaB = ((this.gaC.getDuration() / 200) / 50) * 50;
            if (this.gaB < 50) {
                this.gaB = 50;
            } else if (this.gaB > 500) {
                this.gaB = 500;
            }
            this.bbP = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gaB - (this.gaC.getCurrentPosition() % this.gaB));
        }
    }

    public void aSx() {
        this.bbP = false;
        this.mHandler.removeMessages(1);
        this.gaF.setProgress(0);
        if (this.gaD != null) {
            this.gaD.setText(au.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int bMH() {
        int currentPosition;
        if (this.gaC == null || this.mDragging) {
            return 0;
        }
        int duration = this.gaC.getDuration();
        if (this.gaC instanceof TbCyberVideoView) {
            currentPosition = ((TbCyberVideoView) this.gaC).getCurrentPositionSync();
        } else {
            currentPosition = this.gaC.getCurrentPosition();
        }
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.gaE != null) {
                this.gaE.setText(au.stringForVideoTime(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.gaF != null) {
            if (duration > 0) {
                this.gaF.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.gaC.getBufferPercentage();
        }
        if (this.gaD != null) {
            this.gaD.setText(au.stringForVideoTime(currentPosition));
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
            this.gaC.seekTo(i);
            if (this.gaD != null) {
                this.gaD.setText(au.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.gaC.isPlaying()) {
            this.gaF.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String IL(int i) {
        if (i < 0) {
            i = 0;
        }
        return au.stringForVideoTime(i);
    }

    public int getSeekPosition() {
        return this.eud;
    }

    public int getCurProgress() {
        if (this.gaF != null) {
            return this.gaF.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.kWo = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.kWp = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gaI = onSeekBarChangeListener;
    }
}

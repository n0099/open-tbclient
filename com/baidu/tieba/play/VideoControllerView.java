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
    private int eAi;
    private MediaController.MediaPlayerControl eAj;
    protected TextView eAk;
    protected TextView eAl;
    protected SeekBar eAm;
    private SeekBar.OnSeekBarChangeListener eAp;
    private int eAq;
    private SeekBar.OnSeekBarChangeListener eAr;
    private b iNt;
    private a iNu;
    private Context mContext;
    private boolean mDragging;
    protected int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes.dex */
    public interface a {
        void bgF();
    }

    /* loaded from: classes.dex */
    public interface b {
        void ox(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.eAi = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eAq = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eAj != null && VideoControllerView.this.eAj.isPlaying()) {
                            int bgE = VideoControllerView.this.bgE();
                            if (VideoControllerView.this.iNt != null) {
                                VideoControllerView.this.iNt.ox(bgE);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eAi - (bgE % VideoControllerView.this.eAi));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eAr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eAp != null) {
                    VideoControllerView.this.eAp.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eAq = (int) ((VideoControllerView.this.eAj.getDuration() * i) / 10000);
                    if (VideoControllerView.this.eAk != null) {
                        VideoControllerView.this.eAk.setText(aq.stringForVideoTime(VideoControllerView.this.eAq));
                    }
                    if (VideoControllerView.this.iNu != null) {
                        VideoControllerView.this.iNu.bgF();
                    }
                    if (VideoControllerView.this.eAp != null) {
                        VideoControllerView.this.eAp.onProgressChanged(seekBar, VideoControllerView.this.eAq, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.eAj.seekTo(VideoControllerView.this.eAq);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eAp != null) {
                    VideoControllerView.this.eAp.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eAi = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eAq = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eAj != null && VideoControllerView.this.eAj.isPlaying()) {
                            int bgE = VideoControllerView.this.bgE();
                            if (VideoControllerView.this.iNt != null) {
                                VideoControllerView.this.iNt.ox(bgE);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eAi - (bgE % VideoControllerView.this.eAi));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eAr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eAp != null) {
                    VideoControllerView.this.eAp.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eAq = (int) ((VideoControllerView.this.eAj.getDuration() * i) / 10000);
                    if (VideoControllerView.this.eAk != null) {
                        VideoControllerView.this.eAk.setText(aq.stringForVideoTime(VideoControllerView.this.eAq));
                    }
                    if (VideoControllerView.this.iNu != null) {
                        VideoControllerView.this.iNu.bgF();
                    }
                    if (VideoControllerView.this.eAp != null) {
                        VideoControllerView.this.eAp.onProgressChanged(seekBar, VideoControllerView.this.eAq, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.eAj.seekTo(VideoControllerView.this.eAq);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eAp != null) {
                    VideoControllerView.this.eAp.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eAi = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eAq = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eAj != null && VideoControllerView.this.eAj.isPlaying()) {
                            int bgE = VideoControllerView.this.bgE();
                            if (VideoControllerView.this.iNt != null) {
                                VideoControllerView.this.iNt.ox(bgE);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eAi - (bgE % VideoControllerView.this.eAi));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eAr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eAp != null) {
                    VideoControllerView.this.eAp.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eAq = (int) ((VideoControllerView.this.eAj.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.eAk != null) {
                        VideoControllerView.this.eAk.setText(aq.stringForVideoTime(VideoControllerView.this.eAq));
                    }
                    if (VideoControllerView.this.iNu != null) {
                        VideoControllerView.this.iNu.bgF();
                    }
                    if (VideoControllerView.this.eAp != null) {
                        VideoControllerView.this.eAp.onProgressChanged(seekBar, VideoControllerView.this.eAq, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.eAj.seekTo(VideoControllerView.this.eAq);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eAp != null) {
                    VideoControllerView.this.eAp.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ed = ed(context);
        addView(ed, -1, -2);
        this.eAk = (TextView) ed.findViewById(R.id.textview_cur_time);
        this.eAl = (TextView) ed.findViewById(R.id.textview_duration);
        this.eAm = (SeekBar) ed.findViewById(R.id.pb_video_controller_seekBar);
        this.eAm.setOnSeekBarChangeListener(this.eAr);
    }

    protected View ed(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eAj = mediaPlayerControl;
    }

    public void be(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eAm.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.eAk != null) {
            this.eAk.setText(aq.stringForVideoTime(i));
        }
        if (this.eAl != null) {
            this.eAl.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void Bb(int i) {
        this.mDuration = i;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.eAl != null) {
            this.eAl.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.eAj != null) {
            this.eAi = ((this.eAj.getDuration() / 200) / 50) * 50;
            if (this.eAi < 50) {
                this.eAi = 50;
            } else if (this.eAi > 500) {
                this.eAi = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eAi - (this.eAj.getCurrentPosition() % this.eAi));
        }
    }

    public void asx() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eAm.setProgress(0);
        if (this.eAk != null) {
            this.eAk.setText(aq.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int bgE() {
        int currentPosition;
        if (this.eAj == null || this.mDragging) {
            return 0;
        }
        int duration = this.eAj.getDuration();
        if (this.eAj instanceof com.baidu.tieba.play.a.a) {
            currentPosition = ((com.baidu.tieba.play.a.a) this.eAj).getCurrentPositionSync();
        } else {
            currentPosition = this.eAj.getCurrentPosition();
        }
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.eAl != null) {
                this.eAl.setText(aq.stringForVideoTime(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.eAm != null) {
            if (duration > 0) {
                this.eAm.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.eAj.getBufferPercentage();
        }
        if (this.eAk != null) {
            this.eAk.setText(aq.stringForVideoTime(currentPosition));
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
            this.eAj.seekTo(i);
            if (this.eAk != null) {
                this.eAk.setText(aq.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.eAj.isPlaying()) {
            this.eAm.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String Bc(int i) {
        if (i < 0) {
            i = 0;
        }
        return aq.stringForVideoTime(i);
    }

    public int getSeekPosition() {
        return this.eAq;
    }

    public int getCurProgress() {
        if (this.eAm != null) {
            return this.eAm.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.iNt = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.iNu = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.eAp = onSeekBarChangeListener;
    }
}

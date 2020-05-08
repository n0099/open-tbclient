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
    private int eAn;
    private MediaController.MediaPlayerControl eAo;
    protected TextView eAp;
    protected TextView eAq;
    protected SeekBar eAr;
    private SeekBar.OnSeekBarChangeListener eAu;
    private int eAv;
    private SeekBar.OnSeekBarChangeListener eAw;
    private b iNx;
    private a iNy;
    private Context mContext;
    private boolean mDragging;
    protected int mDuration;
    private Handler mHandler;
    private boolean mShowing;

    /* loaded from: classes.dex */
    public interface a {
        void bgD();
    }

    /* loaded from: classes.dex */
    public interface b {
        void ox(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.eAn = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eAv = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eAo != null && VideoControllerView.this.eAo.isPlaying()) {
                            int bgC = VideoControllerView.this.bgC();
                            if (VideoControllerView.this.iNx != null) {
                                VideoControllerView.this.iNx.ox(bgC);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eAn - (bgC % VideoControllerView.this.eAn));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eAw = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eAu != null) {
                    VideoControllerView.this.eAu.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eAv = (int) ((VideoControllerView.this.eAo.getDuration() * i) / 10000);
                    if (VideoControllerView.this.eAp != null) {
                        VideoControllerView.this.eAp.setText(aq.stringForVideoTime(VideoControllerView.this.eAv));
                    }
                    if (VideoControllerView.this.iNy != null) {
                        VideoControllerView.this.iNy.bgD();
                    }
                    if (VideoControllerView.this.eAu != null) {
                        VideoControllerView.this.eAu.onProgressChanged(seekBar, VideoControllerView.this.eAv, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.eAo.seekTo(VideoControllerView.this.eAv);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eAu != null) {
                    VideoControllerView.this.eAu.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eAn = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eAv = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eAo != null && VideoControllerView.this.eAo.isPlaying()) {
                            int bgC = VideoControllerView.this.bgC();
                            if (VideoControllerView.this.iNx != null) {
                                VideoControllerView.this.iNx.ox(bgC);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eAn - (bgC % VideoControllerView.this.eAn));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eAw = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eAu != null) {
                    VideoControllerView.this.eAu.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eAv = (int) ((VideoControllerView.this.eAo.getDuration() * i) / 10000);
                    if (VideoControllerView.this.eAp != null) {
                        VideoControllerView.this.eAp.setText(aq.stringForVideoTime(VideoControllerView.this.eAv));
                    }
                    if (VideoControllerView.this.iNy != null) {
                        VideoControllerView.this.iNy.bgD();
                    }
                    if (VideoControllerView.this.eAu != null) {
                        VideoControllerView.this.eAu.onProgressChanged(seekBar, VideoControllerView.this.eAv, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.eAo.seekTo(VideoControllerView.this.eAv);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eAu != null) {
                    VideoControllerView.this.eAu.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eAn = 50;
        this.mDragging = false;
        this.mShowing = true;
        this.eAv = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.mShowing && VideoControllerView.this.eAo != null && VideoControllerView.this.eAo.isPlaying()) {
                            int bgC = VideoControllerView.this.bgC();
                            if (VideoControllerView.this.iNx != null) {
                                VideoControllerView.this.iNx.ox(bgC);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.eAn - (bgC % VideoControllerView.this.eAn));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eAw = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.eAu != null) {
                    VideoControllerView.this.eAu.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eAv = (int) ((VideoControllerView.this.eAo.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.eAp != null) {
                        VideoControllerView.this.eAp.setText(aq.stringForVideoTime(VideoControllerView.this.eAv));
                    }
                    if (VideoControllerView.this.iNy != null) {
                        VideoControllerView.this.iNy.bgD();
                    }
                    if (VideoControllerView.this.eAu != null) {
                        VideoControllerView.this.eAu.onProgressChanged(seekBar, VideoControllerView.this.eAv, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.eAo.seekTo(VideoControllerView.this.eAv);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.eAu != null) {
                    VideoControllerView.this.eAu.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View dR = dR(context);
        addView(dR, -1, -2);
        this.eAp = (TextView) dR.findViewById(R.id.textview_cur_time);
        this.eAq = (TextView) dR.findViewById(R.id.textview_duration);
        this.eAr = (SeekBar) dR.findViewById(R.id.pb_video_controller_seekBar);
        this.eAr.setOnSeekBarChangeListener(this.eAw);
    }

    protected View dR(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eAo = mediaPlayerControl;
    }

    public void be(int i, int i2) {
        this.mDuration = i2;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eAr.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.eAp != null) {
            this.eAp.setText(aq.stringForVideoTime(i));
        }
        if (this.eAq != null) {
            this.eAq.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void Bb(int i) {
        this.mDuration = i;
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        if (this.eAq != null) {
            this.eAq.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.eAo != null) {
            this.eAn = ((this.eAo.getDuration() / 200) / 50) * 50;
            if (this.eAn < 50) {
                this.eAn = 50;
            } else if (this.eAn > 500) {
                this.eAn = 500;
            }
            this.mShowing = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eAn - (this.eAo.getCurrentPosition() % this.eAn));
        }
    }

    public void asw() {
        this.mShowing = false;
        this.mHandler.removeMessages(1);
        this.eAr.setProgress(0);
        if (this.eAp != null) {
            this.eAp.setText(aq.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int bgC() {
        int currentPosition;
        if (this.eAo == null || this.mDragging) {
            return 0;
        }
        int duration = this.eAo.getDuration();
        if (this.eAo instanceof com.baidu.tieba.play.a.a) {
            currentPosition = ((com.baidu.tieba.play.a.a) this.eAo).getCurrentPositionSync();
        } else {
            currentPosition = this.eAo.getCurrentPosition();
        }
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.eAq != null) {
                this.eAq.setText(aq.stringForVideoTime(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.eAr != null) {
            if (duration > 0) {
                this.eAr.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.eAo.getBufferPercentage();
        }
        if (this.eAp != null) {
            this.eAp.setText(aq.stringForVideoTime(currentPosition));
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
            this.eAo.seekTo(i);
            if (this.eAp != null) {
                this.eAp.setText(aq.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.eAo.isPlaying()) {
            this.eAr.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String Bc(int i) {
        if (i < 0) {
            i = 0;
        }
        return aq.stringForVideoTime(i);
    }

    public int getSeekPosition() {
        return this.eAv;
    }

    public int getCurProgress() {
        if (this.eAr != null) {
            return this.eAr.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.iNx = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.iNy = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.eAu = onSeekBarChangeListener;
    }
}

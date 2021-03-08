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
    private boolean bdq;
    private int eCG;
    private SeekBar.OnSeekBarChangeListener gjA;
    private SeekBar.OnSeekBarChangeListener gjB;
    private int gjt;
    private MediaController.MediaPlayerControl gju;
    protected TextView gjv;
    protected TextView gjw;
    protected SeekBar gjx;
    private b lhI;
    private a lhJ;
    private Context mContext;
    private boolean mDragging;
    protected int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void bLP();
    }

    /* loaded from: classes.dex */
    public interface b {
        void td(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.gjt = 50;
        this.mDragging = false;
        this.bdq = true;
        this.eCG = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bdq && VideoControllerView.this.gju != null && VideoControllerView.this.gju.isPlaying()) {
                            int bLO = VideoControllerView.this.bLO();
                            if (VideoControllerView.this.lhI != null) {
                                VideoControllerView.this.lhI.td(bLO);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gjt - (bLO % VideoControllerView.this.gjt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gjB = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gjA != null) {
                    VideoControllerView.this.gjA.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eCG = (int) ((VideoControllerView.this.gju.getDuration() * i) / 10000);
                    if (VideoControllerView.this.gjv != null) {
                        VideoControllerView.this.gjv.setText(au.stringForVideoTime(VideoControllerView.this.eCG));
                    }
                    if (VideoControllerView.this.lhJ != null) {
                        VideoControllerView.this.lhJ.bLP();
                    }
                    if (VideoControllerView.this.gjA != null) {
                        VideoControllerView.this.gjA.onProgressChanged(seekBar, VideoControllerView.this.eCG, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.gju.seekTo(VideoControllerView.this.eCG);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gjA != null) {
                    VideoControllerView.this.gjA.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gjt = 50;
        this.mDragging = false;
        this.bdq = true;
        this.eCG = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bdq && VideoControllerView.this.gju != null && VideoControllerView.this.gju.isPlaying()) {
                            int bLO = VideoControllerView.this.bLO();
                            if (VideoControllerView.this.lhI != null) {
                                VideoControllerView.this.lhI.td(bLO);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gjt - (bLO % VideoControllerView.this.gjt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gjB = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gjA != null) {
                    VideoControllerView.this.gjA.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eCG = (int) ((VideoControllerView.this.gju.getDuration() * i) / 10000);
                    if (VideoControllerView.this.gjv != null) {
                        VideoControllerView.this.gjv.setText(au.stringForVideoTime(VideoControllerView.this.eCG));
                    }
                    if (VideoControllerView.this.lhJ != null) {
                        VideoControllerView.this.lhJ.bLP();
                    }
                    if (VideoControllerView.this.gjA != null) {
                        VideoControllerView.this.gjA.onProgressChanged(seekBar, VideoControllerView.this.eCG, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.gju.seekTo(VideoControllerView.this.eCG);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gjA != null) {
                    VideoControllerView.this.gjA.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gjt = 50;
        this.mDragging = false;
        this.bdq = true;
        this.eCG = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.bdq && VideoControllerView.this.gju != null && VideoControllerView.this.gju.isPlaying()) {
                            int bLO = VideoControllerView.this.bLO();
                            if (VideoControllerView.this.lhI != null) {
                                VideoControllerView.this.lhI.td(bLO);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gjt - (bLO % VideoControllerView.this.gjt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gjB = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gjA != null) {
                    VideoControllerView.this.gjA.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eCG = (int) ((VideoControllerView.this.gju.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.gjv != null) {
                        VideoControllerView.this.gjv.setText(au.stringForVideoTime(VideoControllerView.this.eCG));
                    }
                    if (VideoControllerView.this.lhJ != null) {
                        VideoControllerView.this.lhJ.bLP();
                    }
                    if (VideoControllerView.this.gjA != null) {
                        VideoControllerView.this.gjA.onProgressChanged(seekBar, VideoControllerView.this.eCG, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.gju.seekTo(VideoControllerView.this.eCG);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gjA != null) {
                    VideoControllerView.this.gjA.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View fD = fD(context);
        addView(fD, -1, -2);
        this.gjv = (TextView) fD.findViewById(R.id.textview_cur_time);
        this.gjw = (TextView) fD.findViewById(R.id.textview_duration);
        this.gjx = (SeekBar) fD.findViewById(R.id.pb_video_controller_seekBar);
        this.gjx.setOnSeekBarChangeListener(this.gjB);
    }

    protected View fD(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gju = mediaPlayerControl;
    }

    public void bx(int i, int i2) {
        this.mDuration = i2;
        this.bdq = false;
        this.mHandler.removeMessages(1);
        this.gjx.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.gjv != null) {
            this.gjv.setText(au.stringForVideoTime(i));
        }
        if (this.gjw != null) {
            this.gjw.setText(au.stringForVideoTime(this.mDuration));
        }
    }

    public void Hs(int i) {
        this.mDuration = i;
        this.bdq = false;
        this.mHandler.removeMessages(1);
        if (this.gjw != null) {
            this.gjw.setText(au.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.gju != null) {
            this.gjt = ((this.gju.getDuration() / 200) / 50) * 50;
            if (this.gjt < 50) {
                this.gjt = 50;
            } else if (this.gjt > 500) {
                this.gjt = 500;
            }
            this.bdq = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gjt - (this.gju.getCurrentPosition() % this.gjt));
        }
    }

    public void aRr() {
        this.bdq = false;
        this.mHandler.removeMessages(1);
        this.gjx.setProgress(0);
        if (this.gjv != null) {
            this.gjv.setText(au.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int bLO() {
        int currentPosition;
        if (this.gju == null || this.mDragging) {
            return 0;
        }
        int duration = this.gju.getDuration();
        if (this.gju instanceof TbCyberVideoView) {
            currentPosition = ((TbCyberVideoView) this.gju).getCurrentPositionSync();
        } else {
            currentPosition = this.gju.getCurrentPosition();
        }
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.gjw != null) {
                this.gjw.setText(au.stringForVideoTime(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.gjx != null) {
            if (duration > 0) {
                this.gjx.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.gju.getBufferPercentage();
        }
        if (this.gjv != null) {
            this.gjv.setText(au.stringForVideoTime(currentPosition));
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
            this.gju.seekTo(i);
            if (this.gjv != null) {
                this.gjv.setText(au.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.gju.isPlaying()) {
            this.gjx.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String Ht(int i) {
        if (i < 0) {
            i = 0;
        }
        return au.stringForVideoTime(i);
    }

    public int getSeekPosition() {
        return this.eCG;
    }

    public int getCurProgress() {
        if (this.gjx != null) {
            return this.gjx.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.lhI = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.lhJ = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gjA = onSeekBarChangeListener;
    }
}

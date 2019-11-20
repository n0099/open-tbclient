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
    private boolean ZT;
    private boolean cRK;
    private int dhR;
    private MediaController.MediaPlayerControl dhS;
    private TextView dhT;
    private TextView dhU;
    private SeekBar dhV;
    private SeekBar.OnSeekBarChangeListener dhY;
    private int dhZ;
    private SeekBar.OnSeekBarChangeListener dia;
    private b hih;
    private a hii;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void aDT();
    }

    /* loaded from: classes.dex */
    public interface b {
        void lD(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.dhR = 50;
        this.cRK = false;
        this.ZT = true;
        this.dhZ = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cRK && VideoControllerView.this.ZT && VideoControllerView.this.dhS != null && VideoControllerView.this.dhS.isPlaying()) {
                            int aDS = VideoControllerView.this.aDS();
                            if (VideoControllerView.this.hih != null) {
                                VideoControllerView.this.hih.lD(aDS);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dhR - (aDS % VideoControllerView.this.dhR));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dia = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cRK = true;
                if (VideoControllerView.this.dhY != null) {
                    VideoControllerView.this.dhY.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dhZ = (int) ((VideoControllerView.this.dhS.getDuration() * i) / 10000);
                    if (VideoControllerView.this.dhT != null) {
                        VideoControllerView.this.dhT.setText(aq.stringForVideoTime(VideoControllerView.this.dhZ));
                    }
                    if (VideoControllerView.this.hii != null) {
                        VideoControllerView.this.hii.aDT();
                    }
                    if (VideoControllerView.this.dhY != null) {
                        VideoControllerView.this.dhY.onProgressChanged(seekBar, VideoControllerView.this.dhZ, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.dhS.seekTo(VideoControllerView.this.dhZ);
                VideoControllerView.this.cRK = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dhY != null) {
                    VideoControllerView.this.dhY.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dhR = 50;
        this.cRK = false;
        this.ZT = true;
        this.dhZ = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cRK && VideoControllerView.this.ZT && VideoControllerView.this.dhS != null && VideoControllerView.this.dhS.isPlaying()) {
                            int aDS = VideoControllerView.this.aDS();
                            if (VideoControllerView.this.hih != null) {
                                VideoControllerView.this.hih.lD(aDS);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dhR - (aDS % VideoControllerView.this.dhR));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dia = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cRK = true;
                if (VideoControllerView.this.dhY != null) {
                    VideoControllerView.this.dhY.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.dhZ = (int) ((VideoControllerView.this.dhS.getDuration() * i) / 10000);
                    if (VideoControllerView.this.dhT != null) {
                        VideoControllerView.this.dhT.setText(aq.stringForVideoTime(VideoControllerView.this.dhZ));
                    }
                    if (VideoControllerView.this.hii != null) {
                        VideoControllerView.this.hii.aDT();
                    }
                    if (VideoControllerView.this.dhY != null) {
                        VideoControllerView.this.dhY.onProgressChanged(seekBar, VideoControllerView.this.dhZ, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.dhS.seekTo(VideoControllerView.this.dhZ);
                VideoControllerView.this.cRK = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dhY != null) {
                    VideoControllerView.this.dhY.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dhR = 50;
        this.cRK = false;
        this.ZT = true;
        this.dhZ = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cRK && VideoControllerView.this.ZT && VideoControllerView.this.dhS != null && VideoControllerView.this.dhS.isPlaying()) {
                            int aDS = VideoControllerView.this.aDS();
                            if (VideoControllerView.this.hih != null) {
                                VideoControllerView.this.hih.lD(aDS);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.dhR - (aDS % VideoControllerView.this.dhR));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.dia = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cRK = true;
                if (VideoControllerView.this.dhY != null) {
                    VideoControllerView.this.dhY.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.dhZ = (int) ((VideoControllerView.this.dhS.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.dhT != null) {
                        VideoControllerView.this.dhT.setText(aq.stringForVideoTime(VideoControllerView.this.dhZ));
                    }
                    if (VideoControllerView.this.hii != null) {
                        VideoControllerView.this.hii.aDT();
                    }
                    if (VideoControllerView.this.dhY != null) {
                        VideoControllerView.this.dhY.onProgressChanged(seekBar, VideoControllerView.this.dhZ, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.dhS.seekTo(VideoControllerView.this.dhZ);
                VideoControllerView.this.cRK = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.dhY != null) {
                    VideoControllerView.this.dhY.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View cK = cK(context);
        addView(cK, -1, -2);
        this.dhT = (TextView) cK.findViewById(R.id.textview_cur_time);
        this.dhU = (TextView) cK.findViewById(R.id.textview_duration);
        this.dhV = (SeekBar) cK.findViewById(R.id.pb_video_controller_seekBar);
        this.dhV.setOnSeekBarChangeListener(this.dia);
    }

    protected View cK(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dhS = mediaPlayerControl;
    }

    public void aB(int i, int i2) {
        this.mDuration = i2;
        this.ZT = false;
        this.mHandler.removeMessages(1);
        this.dhV.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.dhT != null) {
            this.dhT.setText(aq.stringForVideoTime(i));
        }
        if (this.dhU != null) {
            this.dhU.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void xH(int i) {
        this.mDuration = i;
        this.ZT = false;
        this.mHandler.removeMessages(1);
        if (this.dhU != null) {
            this.dhU.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.dhS != null) {
            this.dhR = ((this.dhS.getDuration() / 200) / 50) * 50;
            if (this.dhR < 50) {
                this.dhR = 50;
            } else if (this.dhR > 500) {
                this.dhR = 500;
            }
            this.ZT = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dhR - (this.dhS.getCurrentPosition() % this.dhR));
        }
    }

    public void aDR() {
        this.ZT = false;
        this.mHandler.removeMessages(1);
        this.dhV.setProgress(0);
        if (this.dhT != null) {
            this.dhT.setText(aq.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aDS() {
        int currentPosition;
        if (this.dhS == null || this.cRK) {
            return 0;
        }
        int duration = this.dhS.getDuration();
        if (this.dhS instanceof com.baidu.tieba.play.a.a) {
            currentPosition = ((com.baidu.tieba.play.a.a) this.dhS).getCurrentPositionSync();
        } else {
            currentPosition = this.dhS.getCurrentPosition();
        }
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.dhU != null) {
                this.dhU.setText(aq.stringForVideoTime(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.dhV != null) {
            if (duration > 0) {
                this.dhV.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.dhS.getBufferPercentage();
        }
        if (this.dhT != null) {
            this.dhT.setText(aq.stringForVideoTime(currentPosition));
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
            this.dhS.seekTo(i);
            if (this.dhT != null) {
                this.dhT.setText(aq.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.dhS.isPlaying()) {
            this.dhV.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String xI(int i) {
        if (i < 0) {
            i = 0;
        }
        return aq.stringForVideoTime(i);
    }

    public int getSeekPosition() {
        return this.dhZ;
    }

    public int getCurProgress() {
        if (this.dhV != null) {
            return this.dhV.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.hih = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.hii = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.dhY = onSeekBarChangeListener;
    }
}

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
    private boolean aal;
    private boolean cSB;
    private int diJ;
    private MediaController.MediaPlayerControl diK;
    private TextView diL;
    private TextView diM;
    private SeekBar diN;
    private SeekBar.OnSeekBarChangeListener diQ;
    private int diR;
    private SeekBar.OnSeekBarChangeListener diS;
    private b hiY;
    private a hiZ;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void aDV();
    }

    /* loaded from: classes.dex */
    public interface b {
        void lE(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.diJ = 50;
        this.cSB = false;
        this.aal = true;
        this.diR = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cSB && VideoControllerView.this.aal && VideoControllerView.this.diK != null && VideoControllerView.this.diK.isPlaying()) {
                            int aDU = VideoControllerView.this.aDU();
                            if (VideoControllerView.this.hiY != null) {
                                VideoControllerView.this.hiY.lE(aDU);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.diJ - (aDU % VideoControllerView.this.diJ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.diS = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cSB = true;
                if (VideoControllerView.this.diQ != null) {
                    VideoControllerView.this.diQ.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.diR = (int) ((VideoControllerView.this.diK.getDuration() * i) / 10000);
                    if (VideoControllerView.this.diL != null) {
                        VideoControllerView.this.diL.setText(aq.stringForVideoTime(VideoControllerView.this.diR));
                    }
                    if (VideoControllerView.this.hiZ != null) {
                        VideoControllerView.this.hiZ.aDV();
                    }
                    if (VideoControllerView.this.diQ != null) {
                        VideoControllerView.this.diQ.onProgressChanged(seekBar, VideoControllerView.this.diR, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.diK.seekTo(VideoControllerView.this.diR);
                VideoControllerView.this.cSB = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.diQ != null) {
                    VideoControllerView.this.diQ.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.diJ = 50;
        this.cSB = false;
        this.aal = true;
        this.diR = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cSB && VideoControllerView.this.aal && VideoControllerView.this.diK != null && VideoControllerView.this.diK.isPlaying()) {
                            int aDU = VideoControllerView.this.aDU();
                            if (VideoControllerView.this.hiY != null) {
                                VideoControllerView.this.hiY.lE(aDU);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.diJ - (aDU % VideoControllerView.this.diJ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.diS = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cSB = true;
                if (VideoControllerView.this.diQ != null) {
                    VideoControllerView.this.diQ.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.diR = (int) ((VideoControllerView.this.diK.getDuration() * i) / 10000);
                    if (VideoControllerView.this.diL != null) {
                        VideoControllerView.this.diL.setText(aq.stringForVideoTime(VideoControllerView.this.diR));
                    }
                    if (VideoControllerView.this.hiZ != null) {
                        VideoControllerView.this.hiZ.aDV();
                    }
                    if (VideoControllerView.this.diQ != null) {
                        VideoControllerView.this.diQ.onProgressChanged(seekBar, VideoControllerView.this.diR, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.diK.seekTo(VideoControllerView.this.diR);
                VideoControllerView.this.cSB = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.diQ != null) {
                    VideoControllerView.this.diQ.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.diJ = 50;
        this.cSB = false;
        this.aal = true;
        this.diR = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.cSB && VideoControllerView.this.aal && VideoControllerView.this.diK != null && VideoControllerView.this.diK.isPlaying()) {
                            int aDU = VideoControllerView.this.aDU();
                            if (VideoControllerView.this.hiY != null) {
                                VideoControllerView.this.hiY.lE(aDU);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.diJ - (aDU % VideoControllerView.this.diJ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.diS = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.cSB = true;
                if (VideoControllerView.this.diQ != null) {
                    VideoControllerView.this.diQ.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.diR = (int) ((VideoControllerView.this.diK.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.diL != null) {
                        VideoControllerView.this.diL.setText(aq.stringForVideoTime(VideoControllerView.this.diR));
                    }
                    if (VideoControllerView.this.hiZ != null) {
                        VideoControllerView.this.hiZ.aDV();
                    }
                    if (VideoControllerView.this.diQ != null) {
                        VideoControllerView.this.diQ.onProgressChanged(seekBar, VideoControllerView.this.diR, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.diK.seekTo(VideoControllerView.this.diR);
                VideoControllerView.this.cSB = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.diQ != null) {
                    VideoControllerView.this.diQ.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View cK = cK(context);
        addView(cK, -1, -2);
        this.diL = (TextView) cK.findViewById(R.id.textview_cur_time);
        this.diM = (TextView) cK.findViewById(R.id.textview_duration);
        this.diN = (SeekBar) cK.findViewById(R.id.pb_video_controller_seekBar);
        this.diN.setOnSeekBarChangeListener(this.diS);
    }

    protected View cK(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.diK = mediaPlayerControl;
    }

    public void aD(int i, int i2) {
        this.mDuration = i2;
        this.aal = false;
        this.mHandler.removeMessages(1);
        this.diN.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.diL != null) {
            this.diL.setText(aq.stringForVideoTime(i));
        }
        if (this.diM != null) {
            this.diM.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void xI(int i) {
        this.mDuration = i;
        this.aal = false;
        this.mHandler.removeMessages(1);
        if (this.diM != null) {
            this.diM.setText(aq.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.diK != null) {
            this.diJ = ((this.diK.getDuration() / 200) / 50) * 50;
            if (this.diJ < 50) {
                this.diJ = 50;
            } else if (this.diJ > 500) {
                this.diJ = 500;
            }
            this.aal = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.diJ - (this.diK.getCurrentPosition() % this.diJ));
        }
    }

    public void aDT() {
        this.aal = false;
        this.mHandler.removeMessages(1);
        this.diN.setProgress(0);
        if (this.diL != null) {
            this.diL.setText(aq.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aDU() {
        int currentPosition;
        if (this.diK == null || this.cSB) {
            return 0;
        }
        int duration = this.diK.getDuration();
        if (this.diK instanceof com.baidu.tieba.play.a.a) {
            currentPosition = ((com.baidu.tieba.play.a.a) this.diK).getCurrentPositionSync();
        } else {
            currentPosition = this.diK.getCurrentPosition();
        }
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.diM != null) {
                this.diM.setText(aq.stringForVideoTime(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.diN != null) {
            if (duration > 0) {
                this.diN.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.diK.getBufferPercentage();
        }
        if (this.diL != null) {
            this.diL.setText(aq.stringForVideoTime(currentPosition));
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
            this.diK.seekTo(i);
            if (this.diL != null) {
                this.diL.setText(aq.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.diK.isPlaying()) {
            this.diN.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String xJ(int i) {
        if (i < 0) {
            i = 0;
        }
        return aq.stringForVideoTime(i);
    }

    public int getSeekPosition() {
        return this.diR;
    }

    public int getCurProgress() {
        if (this.diN != null) {
            return this.diN.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.hiY = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.hiZ = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.diQ = onSeekBarChangeListener;
    }
}

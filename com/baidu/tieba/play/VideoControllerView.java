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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class VideoControllerView extends RelativeLayout {
    private boolean aYJ;
    private int eyY;
    private int gfm;
    private MediaController.MediaPlayerControl gfn;
    protected TextView gfo;
    protected TextView gfp;
    protected SeekBar gfq;
    private SeekBar.OnSeekBarChangeListener gft;
    private SeekBar.OnSeekBarChangeListener gfu;
    private b kXo;
    private a kXp;
    private Context mContext;
    private boolean mDragging;
    protected int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void bLk();
    }

    /* loaded from: classes.dex */
    public interface b {
        void sW(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.gfm = 50;
        this.mDragging = false;
        this.aYJ = true;
        this.eyY = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.aYJ && VideoControllerView.this.gfn != null && VideoControllerView.this.gfn.isPlaying()) {
                            int bLj = VideoControllerView.this.bLj();
                            if (VideoControllerView.this.kXo != null) {
                                VideoControllerView.this.kXo.sW(bLj);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gfm - (bLj % VideoControllerView.this.gfm));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gfu = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gft != null) {
                    VideoControllerView.this.gft.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eyY = (int) ((VideoControllerView.this.gfn.getDuration() * i) / 10000);
                    if (VideoControllerView.this.gfo != null) {
                        VideoControllerView.this.gfo.setText(at.stringForVideoTime(VideoControllerView.this.eyY));
                    }
                    if (VideoControllerView.this.kXp != null) {
                        VideoControllerView.this.kXp.bLk();
                    }
                    if (VideoControllerView.this.gft != null) {
                        VideoControllerView.this.gft.onProgressChanged(seekBar, VideoControllerView.this.eyY, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.gfn.seekTo(VideoControllerView.this.eyY);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gft != null) {
                    VideoControllerView.this.gft.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gfm = 50;
        this.mDragging = false;
        this.aYJ = true;
        this.eyY = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.aYJ && VideoControllerView.this.gfn != null && VideoControllerView.this.gfn.isPlaying()) {
                            int bLj = VideoControllerView.this.bLj();
                            if (VideoControllerView.this.kXo != null) {
                                VideoControllerView.this.kXo.sW(bLj);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gfm - (bLj % VideoControllerView.this.gfm));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gfu = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gft != null) {
                    VideoControllerView.this.gft.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    VideoControllerView.this.eyY = (int) ((VideoControllerView.this.gfn.getDuration() * i) / 10000);
                    if (VideoControllerView.this.gfo != null) {
                        VideoControllerView.this.gfo.setText(at.stringForVideoTime(VideoControllerView.this.eyY));
                    }
                    if (VideoControllerView.this.kXp != null) {
                        VideoControllerView.this.kXp.bLk();
                    }
                    if (VideoControllerView.this.gft != null) {
                        VideoControllerView.this.gft.onProgressChanged(seekBar, VideoControllerView.this.eyY, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.gfn.seekTo(VideoControllerView.this.eyY);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gft != null) {
                    VideoControllerView.this.gft.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gfm = 50;
        this.mDragging = false;
        this.aYJ = true;
        this.eyY = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.VideoControllerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!VideoControllerView.this.mDragging && VideoControllerView.this.aYJ && VideoControllerView.this.gfn != null && VideoControllerView.this.gfn.isPlaying()) {
                            int bLj = VideoControllerView.this.bLj();
                            if (VideoControllerView.this.kXo != null) {
                                VideoControllerView.this.kXo.sW(bLj);
                            }
                            sendMessageDelayed(obtainMessage(1), VideoControllerView.this.gfm - (bLj % VideoControllerView.this.gfm));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gfu = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.VideoControllerView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                VideoControllerView.this.mDragging = true;
                if (VideoControllerView.this.gft != null) {
                    VideoControllerView.this.gft.onStartTrackingTouch(seekBar);
                }
                VideoControllerView.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    VideoControllerView.this.eyY = (int) ((VideoControllerView.this.gfn.getDuration() * i2) / 10000);
                    if (VideoControllerView.this.gfo != null) {
                        VideoControllerView.this.gfo.setText(at.stringForVideoTime(VideoControllerView.this.eyY));
                    }
                    if (VideoControllerView.this.kXp != null) {
                        VideoControllerView.this.kXp.bLk();
                    }
                    if (VideoControllerView.this.gft != null) {
                        VideoControllerView.this.gft.onProgressChanged(seekBar, VideoControllerView.this.eyY, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                VideoControllerView.this.gfn.seekTo(VideoControllerView.this.eyY);
                VideoControllerView.this.mDragging = false;
                VideoControllerView.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (VideoControllerView.this.gft != null) {
                    VideoControllerView.this.gft.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View fF = fF(context);
        addView(fF, -1, -2);
        this.gfo = (TextView) fF.findViewById(R.id.textview_cur_time);
        this.gfp = (TextView) fF.findViewById(R.id.textview_duration);
        this.gfq = (SeekBar) fF.findViewById(R.id.pb_video_controller_seekBar);
        this.gfq.setOnSeekBarChangeListener(this.gfu);
    }

    protected View fF(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gfn = mediaPlayerControl;
    }

    public void bz(int i, int i2) {
        this.mDuration = i2;
        this.aYJ = false;
        this.mHandler.removeMessages(1);
        this.gfq.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.gfo != null) {
            this.gfo.setText(at.stringForVideoTime(i));
        }
        if (this.gfp != null) {
            this.gfp.setText(at.stringForVideoTime(this.mDuration));
        }
    }

    public void GX(int i) {
        this.mDuration = i;
        this.aYJ = false;
        this.mHandler.removeMessages(1);
        if (this.gfp != null) {
            this.gfp.setText(at.stringForVideoTime(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.gfn != null) {
            this.gfm = ((this.gfn.getDuration() / 200) / 50) * 50;
            if (this.gfm < 50) {
                this.gfm = 50;
            } else if (this.gfm > 500) {
                this.gfm = 500;
            }
            this.aYJ = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gfm - (this.gfn.getCurrentPosition() % this.gfm));
        }
    }

    public void aQY() {
        this.aYJ = false;
        this.mHandler.removeMessages(1);
        this.gfq.setProgress(0);
        if (this.gfo != null) {
            this.gfo.setText(at.stringForVideoTime(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int bLj() {
        int currentPosition;
        if (this.gfn == null || this.mDragging) {
            return 0;
        }
        int duration = this.gfn.getDuration();
        if (this.gfn instanceof TbCyberVideoView) {
            currentPosition = ((TbCyberVideoView) this.gfn).getCurrentPositionSync();
        } else {
            currentPosition = this.gfn.getCurrentPosition();
        }
        if (this.mDuration <= 0 && duration != this.mDuration) {
            this.mDuration = duration;
            if (this.gfp != null) {
                this.gfp.setText(at.stringForVideoTime(this.mDuration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.gfq != null) {
            if (duration > 0) {
                this.gfq.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.gfn.getBufferPercentage();
        }
        if (this.gfo != null) {
            this.gfo.setText(at.stringForVideoTime(currentPosition));
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
            this.gfn.seekTo(i);
            if (this.gfo != null) {
                this.gfo.setText(at.stringForVideoTime(i));
            }
            showProgress();
        }
        if (!this.gfn.isPlaying()) {
            this.gfq.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String GY(int i) {
        if (i < 0) {
            i = 0;
        }
        return at.stringForVideoTime(i);
    }

    public int getSeekPosition() {
        return this.eyY;
    }

    public int getCurProgress() {
        if (this.gfq != null) {
            return this.gfq.getProgress();
        }
        return 0;
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.kXo = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.kXp = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gft = onSeekBarChangeListener;
    }
}

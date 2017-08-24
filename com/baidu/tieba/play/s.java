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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class s extends RelativeLayout {
    private TextView aYA;
    private boolean aYB;
    private boolean aYC;
    private SeekBar aYD;
    private SeekBar.OnSeekBarChangeListener aYG;
    private int aYH;
    private SeekBar.OnSeekBarChangeListener aYI;
    private int aYx;
    private MediaController.MediaPlayerControl aYy;
    private TextView aYz;
    private b dTY;
    private a dTZ;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void Lf();
    }

    /* loaded from: classes.dex */
    public interface b {
        void fQ(int i);
    }

    public s(Context context) {
        super(context);
        this.aYx = 50;
        this.aYB = false;
        this.aYC = true;
        this.aYH = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aYB && s.this.aYC && s.this.aYy != null && s.this.aYy.isPlaying()) {
                            int Le = s.this.Le();
                            if (s.this.dTY != null) {
                                s.this.dTY.fQ(Le);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aYx - (Le % s.this.aYx));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aYI = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aYB = true;
                if (s.this.aYG != null) {
                    s.this.aYG.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    s.this.aYH = (int) ((s.this.aYy.getDuration() * i) / 10000);
                    if (s.this.aYz != null) {
                        s.this.aYz.setText(al.cZ(s.this.aYH));
                    }
                    if (s.this.dTZ != null) {
                        s.this.dTZ.Lf();
                    }
                    if (s.this.aYG != null) {
                        s.this.aYG.onProgressChanged(seekBar, s.this.aYH, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aYy.seekTo(s.this.aYH);
                s.this.aYB = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aYG != null) {
                    s.this.aYG.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aYx = 50;
        this.aYB = false;
        this.aYC = true;
        this.aYH = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aYB && s.this.aYC && s.this.aYy != null && s.this.aYy.isPlaying()) {
                            int Le = s.this.Le();
                            if (s.this.dTY != null) {
                                s.this.dTY.fQ(Le);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aYx - (Le % s.this.aYx));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aYI = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aYB = true;
                if (s.this.aYG != null) {
                    s.this.aYG.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    s.this.aYH = (int) ((s.this.aYy.getDuration() * i) / 10000);
                    if (s.this.aYz != null) {
                        s.this.aYz.setText(al.cZ(s.this.aYH));
                    }
                    if (s.this.dTZ != null) {
                        s.this.dTZ.Lf();
                    }
                    if (s.this.aYG != null) {
                        s.this.aYG.onProgressChanged(seekBar, s.this.aYH, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aYy.seekTo(s.this.aYH);
                s.this.aYB = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aYG != null) {
                    s.this.aYG.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public s(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aYx = 50;
        this.aYB = false;
        this.aYC = true;
        this.aYH = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aYB && s.this.aYC && s.this.aYy != null && s.this.aYy.isPlaying()) {
                            int Le = s.this.Le();
                            if (s.this.dTY != null) {
                                s.this.dTY.fQ(Le);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aYx - (Le % s.this.aYx));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aYI = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aYB = true;
                if (s.this.aYG != null) {
                    s.this.aYG.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    s.this.aYH = (int) ((s.this.aYy.getDuration() * i2) / 10000);
                    if (s.this.aYz != null) {
                        s.this.aYz.setText(al.cZ(s.this.aYH));
                    }
                    if (s.this.dTZ != null) {
                        s.this.dTZ.Lf();
                    }
                    if (s.this.aYG != null) {
                        s.this.aYG.onProgressChanged(seekBar, s.this.aYH, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aYy.seekTo(s.this.aYH);
                s.this.aYB = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aYG != null) {
                    s.this.aYG.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bb = bb(context);
        addView(bb, -1, (int) context.getResources().getDimension(d.f.ds80));
        this.aYz = (TextView) bb.findViewById(d.h.textview_cur_time);
        this.aYA = (TextView) bb.findViewById(d.h.textview_duration);
        this.aYD = (SeekBar) bb.findViewById(d.h.pb_video_controller_seekBar);
        this.aYD.setOnSeekBarChangeListener(this.aYI);
    }

    protected View bb(Context context) {
        return LayoutInflater.from(context).inflate(d.j.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aYy = mediaPlayerControl;
    }

    public void U(int i, int i2) {
        this.mDuration = i2;
        this.aYC = false;
        this.mHandler.removeMessages(1);
        this.aYD.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.aYz != null) {
            this.aYz.setText(al.cZ(i));
        }
        if (this.aYA != null) {
            this.aYA.setText(al.cZ(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.aYy != null) {
            this.aYx = ((this.aYy.getDuration() / 200) / 50) * 50;
            if (this.aYx < 50) {
                this.aYx = 50;
            } else if (this.aYx > 500) {
                this.aYx = 500;
            }
            this.aYC = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.aYx - (this.aYy.getCurrentPosition() % this.aYx));
        }
    }

    public void Ld() {
        this.aYC = false;
        this.mHandler.removeMessages(1);
        this.aYD.setProgress(0);
        if (this.aYz != null) {
            this.aYz.setText(al.cZ(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Le() {
        if (this.aYy == null || this.aYB) {
            return 0;
        }
        int currentPosition = this.aYy.getCurrentPosition();
        int duration = this.aYy.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.aYD != null) {
            if (duration > 0) {
                this.aYD.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aYy.getBufferPercentage();
        }
        if (this.aYz != null) {
            this.aYz.setText(al.cZ(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    public void D(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (!z) {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
            }
        } else {
            this.aYy.seekTo(i);
            if (this.aYz != null) {
                this.aYz.setText(al.cZ(i));
            }
            showProgress();
        }
        if (!this.aYy.isPlaying()) {
            this.aYD.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String rM(int i) {
        if (i < 0) {
            i = 0;
        }
        return al.cZ(i);
    }

    public int getSeekPosition() {
        return this.aYH;
    }

    public int getCurProgress() {
        if (this.aYD != null) {
            return this.aYD.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.dTY = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.dTZ = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.aYG = onSeekBarChangeListener;
    }
}

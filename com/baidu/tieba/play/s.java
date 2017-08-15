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
    private boolean aYA;
    private boolean aYB;
    private SeekBar aYC;
    private SeekBar.OnSeekBarChangeListener aYF;
    private int aYG;
    private SeekBar.OnSeekBarChangeListener aYH;
    private int aYw;
    private MediaController.MediaPlayerControl aYx;
    private TextView aYy;
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
        this.aYw = 50;
        this.aYA = false;
        this.aYB = true;
        this.aYG = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aYA && s.this.aYB && s.this.aYx != null && s.this.aYx.isPlaying()) {
                            int Le = s.this.Le();
                            if (s.this.dTY != null) {
                                s.this.dTY.fQ(Le);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aYw - (Le % s.this.aYw));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aYH = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aYA = true;
                if (s.this.aYF != null) {
                    s.this.aYF.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    s.this.aYG = (int) ((s.this.aYx.getDuration() * i) / 10000);
                    if (s.this.aYy != null) {
                        s.this.aYy.setText(al.cZ(s.this.aYG));
                    }
                    if (s.this.dTZ != null) {
                        s.this.dTZ.Lf();
                    }
                    if (s.this.aYF != null) {
                        s.this.aYF.onProgressChanged(seekBar, s.this.aYG, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aYx.seekTo(s.this.aYG);
                s.this.aYA = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aYF != null) {
                    s.this.aYF.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aYw = 50;
        this.aYA = false;
        this.aYB = true;
        this.aYG = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aYA && s.this.aYB && s.this.aYx != null && s.this.aYx.isPlaying()) {
                            int Le = s.this.Le();
                            if (s.this.dTY != null) {
                                s.this.dTY.fQ(Le);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aYw - (Le % s.this.aYw));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aYH = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aYA = true;
                if (s.this.aYF != null) {
                    s.this.aYF.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    s.this.aYG = (int) ((s.this.aYx.getDuration() * i) / 10000);
                    if (s.this.aYy != null) {
                        s.this.aYy.setText(al.cZ(s.this.aYG));
                    }
                    if (s.this.dTZ != null) {
                        s.this.dTZ.Lf();
                    }
                    if (s.this.aYF != null) {
                        s.this.aYF.onProgressChanged(seekBar, s.this.aYG, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aYx.seekTo(s.this.aYG);
                s.this.aYA = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aYF != null) {
                    s.this.aYF.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public s(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aYw = 50;
        this.aYA = false;
        this.aYB = true;
        this.aYG = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aYA && s.this.aYB && s.this.aYx != null && s.this.aYx.isPlaying()) {
                            int Le = s.this.Le();
                            if (s.this.dTY != null) {
                                s.this.dTY.fQ(Le);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aYw - (Le % s.this.aYw));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aYH = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aYA = true;
                if (s.this.aYF != null) {
                    s.this.aYF.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    s.this.aYG = (int) ((s.this.aYx.getDuration() * i2) / 10000);
                    if (s.this.aYy != null) {
                        s.this.aYy.setText(al.cZ(s.this.aYG));
                    }
                    if (s.this.dTZ != null) {
                        s.this.dTZ.Lf();
                    }
                    if (s.this.aYF != null) {
                        s.this.aYF.onProgressChanged(seekBar, s.this.aYG, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aYx.seekTo(s.this.aYG);
                s.this.aYA = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aYF != null) {
                    s.this.aYF.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bb = bb(context);
        addView(bb, -1, (int) context.getResources().getDimension(d.f.ds80));
        this.aYy = (TextView) bb.findViewById(d.h.textview_cur_time);
        this.aYz = (TextView) bb.findViewById(d.h.textview_duration);
        this.aYC = (SeekBar) bb.findViewById(d.h.pb_video_controller_seekBar);
        this.aYC.setOnSeekBarChangeListener(this.aYH);
    }

    protected View bb(Context context) {
        return LayoutInflater.from(context).inflate(d.j.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aYx = mediaPlayerControl;
    }

    public void U(int i, int i2) {
        this.mDuration = i2;
        this.aYB = false;
        this.mHandler.removeMessages(1);
        this.aYC.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.aYy != null) {
            this.aYy.setText(al.cZ(i));
        }
        if (this.aYz != null) {
            this.aYz.setText(al.cZ(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.aYx != null) {
            this.aYw = ((this.aYx.getDuration() / 200) / 50) * 50;
            if (this.aYw < 50) {
                this.aYw = 50;
            } else if (this.aYw > 500) {
                this.aYw = 500;
            }
            this.aYB = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.aYw - (this.aYx.getCurrentPosition() % this.aYw));
        }
    }

    public void Ld() {
        this.aYB = false;
        this.mHandler.removeMessages(1);
        this.aYC.setProgress(0);
        if (this.aYy != null) {
            this.aYy.setText(al.cZ(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Le() {
        if (this.aYx == null || this.aYA) {
            return 0;
        }
        int currentPosition = this.aYx.getCurrentPosition();
        int duration = this.aYx.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.aYC != null) {
            if (duration > 0) {
                this.aYC.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aYx.getBufferPercentage();
        }
        if (this.aYy != null) {
            this.aYy.setText(al.cZ(currentPosition));
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
            this.aYx.seekTo(i);
            if (this.aYy != null) {
                this.aYy.setText(al.cZ(i));
            }
            showProgress();
        }
        if (!this.aYx.isPlaying()) {
            this.aYC.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String rM(int i) {
        if (i < 0) {
            i = 0;
        }
        return al.cZ(i);
    }

    public int getSeekPosition() {
        return this.aYG;
    }

    public int getCurProgress() {
        if (this.aYC != null) {
            return this.aYC.getProgress();
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
        this.aYF = onSeekBarChangeListener;
    }
}

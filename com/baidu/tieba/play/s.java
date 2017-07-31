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
    private SeekBar aYB;
    private SeekBar.OnSeekBarChangeListener aYE;
    private int aYF;
    private SeekBar.OnSeekBarChangeListener aYG;
    private int aYv;
    private MediaController.MediaPlayerControl aYw;
    private TextView aYx;
    private TextView aYy;
    private boolean aYz;
    private b dSc;
    private a dSd;
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
        this.aYv = 50;
        this.aYz = false;
        this.aYA = true;
        this.aYF = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aYz && s.this.aYA && s.this.aYw != null && s.this.aYw.isPlaying()) {
                            int Le = s.this.Le();
                            if (s.this.dSc != null) {
                                s.this.dSc.fQ(Le);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aYv - (Le % s.this.aYv));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aYG = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aYz = true;
                if (s.this.aYE != null) {
                    s.this.aYE.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    s.this.aYF = (int) ((s.this.aYw.getDuration() * i) / 10000);
                    if (s.this.aYx != null) {
                        s.this.aYx.setText(al.cZ(s.this.aYF));
                    }
                    if (s.this.dSd != null) {
                        s.this.dSd.Lf();
                    }
                    if (s.this.aYE != null) {
                        s.this.aYE.onProgressChanged(seekBar, s.this.aYF, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aYw.seekTo(s.this.aYF);
                s.this.aYz = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aYE != null) {
                    s.this.aYE.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aYv = 50;
        this.aYz = false;
        this.aYA = true;
        this.aYF = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aYz && s.this.aYA && s.this.aYw != null && s.this.aYw.isPlaying()) {
                            int Le = s.this.Le();
                            if (s.this.dSc != null) {
                                s.this.dSc.fQ(Le);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aYv - (Le % s.this.aYv));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aYG = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aYz = true;
                if (s.this.aYE != null) {
                    s.this.aYE.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    s.this.aYF = (int) ((s.this.aYw.getDuration() * i) / 10000);
                    if (s.this.aYx != null) {
                        s.this.aYx.setText(al.cZ(s.this.aYF));
                    }
                    if (s.this.dSd != null) {
                        s.this.dSd.Lf();
                    }
                    if (s.this.aYE != null) {
                        s.this.aYE.onProgressChanged(seekBar, s.this.aYF, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aYw.seekTo(s.this.aYF);
                s.this.aYz = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aYE != null) {
                    s.this.aYE.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public s(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aYv = 50;
        this.aYz = false;
        this.aYA = true;
        this.aYF = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aYz && s.this.aYA && s.this.aYw != null && s.this.aYw.isPlaying()) {
                            int Le = s.this.Le();
                            if (s.this.dSc != null) {
                                s.this.dSc.fQ(Le);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aYv - (Le % s.this.aYv));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aYG = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aYz = true;
                if (s.this.aYE != null) {
                    s.this.aYE.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    s.this.aYF = (int) ((s.this.aYw.getDuration() * i2) / 10000);
                    if (s.this.aYx != null) {
                        s.this.aYx.setText(al.cZ(s.this.aYF));
                    }
                    if (s.this.dSd != null) {
                        s.this.dSd.Lf();
                    }
                    if (s.this.aYE != null) {
                        s.this.aYE.onProgressChanged(seekBar, s.this.aYF, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aYw.seekTo(s.this.aYF);
                s.this.aYz = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aYE != null) {
                    s.this.aYE.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bb = bb(context);
        addView(bb, -1, (int) context.getResources().getDimension(d.f.ds80));
        this.aYx = (TextView) bb.findViewById(d.h.textview_cur_time);
        this.aYy = (TextView) bb.findViewById(d.h.textview_duration);
        this.aYB = (SeekBar) bb.findViewById(d.h.pb_video_controller_seekBar);
        this.aYB.setOnSeekBarChangeListener(this.aYG);
    }

    protected View bb(Context context) {
        return LayoutInflater.from(context).inflate(d.j.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aYw = mediaPlayerControl;
    }

    public void U(int i, int i2) {
        this.mDuration = i2;
        this.aYA = false;
        this.mHandler.removeMessages(1);
        this.aYB.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.aYx != null) {
            this.aYx.setText(al.cZ(i));
        }
        if (this.aYy != null) {
            this.aYy.setText(al.cZ(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.aYw != null) {
            this.aYv = ((this.aYw.getDuration() / 200) / 50) * 50;
            if (this.aYv < 50) {
                this.aYv = 50;
            } else if (this.aYv > 500) {
                this.aYv = 500;
            }
            this.aYA = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.aYv - (this.aYw.getCurrentPosition() % this.aYv));
        }
    }

    public void Ld() {
        this.aYA = false;
        this.mHandler.removeMessages(1);
        this.aYB.setProgress(0);
        if (this.aYx != null) {
            this.aYx.setText(al.cZ(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Le() {
        if (this.aYw == null || this.aYz) {
            return 0;
        }
        int currentPosition = this.aYw.getCurrentPosition();
        int duration = this.aYw.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.aYB != null) {
            if (duration > 0) {
                this.aYB.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aYw.getBufferPercentage();
        }
        if (this.aYx != null) {
            this.aYx.setText(al.cZ(currentPosition));
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
            this.aYw.seekTo(i);
            if (this.aYx != null) {
                this.aYx.setText(al.cZ(i));
            }
            showProgress();
        }
        if (!this.aYw.isPlaying()) {
            this.aYB.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String rC(int i) {
        if (i < 0) {
            i = 0;
        }
        return al.cZ(i);
    }

    public int getSeekPosition() {
        return this.aYF;
    }

    public int getCurProgress() {
        if (this.aYB != null) {
            return this.aYB.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.dSc = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.dSd = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.aYE = onSeekBarChangeListener;
    }
}

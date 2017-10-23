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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class t extends RelativeLayout {
    private int HV;
    private int aZF;
    private MediaController.MediaPlayerControl aZG;
    private TextView aZH;
    private TextView aZI;
    private boolean aZJ;
    private boolean aZK;
    private SeekBar aZL;
    private SeekBar.OnSeekBarChangeListener aZO;
    private int aZP;
    private SeekBar.OnSeekBarChangeListener aZQ;
    private b dXy;
    private a dXz;
    private Context mContext;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void Lz();
    }

    /* loaded from: classes.dex */
    public interface b {
        void ge(int i);
    }

    public t(Context context) {
        super(context);
        this.aZF = 50;
        this.aZJ = false;
        this.aZK = true;
        this.aZP = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.t.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!t.this.aZJ && t.this.aZK && t.this.aZG != null && t.this.aZG.isPlaying()) {
                            int Ly = t.this.Ly();
                            if (t.this.dXy != null) {
                                t.this.dXy.ge(Ly);
                            }
                            sendMessageDelayed(obtainMessage(1), t.this.aZF - (Ly % t.this.aZF));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aZQ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.t.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                t.this.aZJ = true;
                if (t.this.aZO != null) {
                    t.this.aZO.onStartTrackingTouch(seekBar);
                }
                t.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    t.this.aZP = (int) ((t.this.aZG.getDuration() * i) / 10000);
                    if (t.this.aZH != null) {
                        t.this.aZH.setText(am.cX(t.this.aZP));
                    }
                    if (t.this.dXz != null) {
                        t.this.dXz.Lz();
                    }
                    if (t.this.aZO != null) {
                        t.this.aZO.onProgressChanged(seekBar, t.this.aZP, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                t.this.aZG.seekTo(t.this.aZP);
                t.this.aZJ = false;
                t.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (t.this.aZO != null) {
                    t.this.aZO.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public t(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZF = 50;
        this.aZJ = false;
        this.aZK = true;
        this.aZP = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.t.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!t.this.aZJ && t.this.aZK && t.this.aZG != null && t.this.aZG.isPlaying()) {
                            int Ly = t.this.Ly();
                            if (t.this.dXy != null) {
                                t.this.dXy.ge(Ly);
                            }
                            sendMessageDelayed(obtainMessage(1), t.this.aZF - (Ly % t.this.aZF));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aZQ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.t.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                t.this.aZJ = true;
                if (t.this.aZO != null) {
                    t.this.aZO.onStartTrackingTouch(seekBar);
                }
                t.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    t.this.aZP = (int) ((t.this.aZG.getDuration() * i) / 10000);
                    if (t.this.aZH != null) {
                        t.this.aZH.setText(am.cX(t.this.aZP));
                    }
                    if (t.this.dXz != null) {
                        t.this.dXz.Lz();
                    }
                    if (t.this.aZO != null) {
                        t.this.aZO.onProgressChanged(seekBar, t.this.aZP, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                t.this.aZG.seekTo(t.this.aZP);
                t.this.aZJ = false;
                t.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (t.this.aZO != null) {
                    t.this.aZO.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public t(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aZF = 50;
        this.aZJ = false;
        this.aZK = true;
        this.aZP = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.t.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!t.this.aZJ && t.this.aZK && t.this.aZG != null && t.this.aZG.isPlaying()) {
                            int Ly = t.this.Ly();
                            if (t.this.dXy != null) {
                                t.this.dXy.ge(Ly);
                            }
                            sendMessageDelayed(obtainMessage(1), t.this.aZF - (Ly % t.this.aZF));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aZQ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.t.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                t.this.aZJ = true;
                if (t.this.aZO != null) {
                    t.this.aZO.onStartTrackingTouch(seekBar);
                }
                t.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    t.this.aZP = (int) ((t.this.aZG.getDuration() * i2) / 10000);
                    if (t.this.aZH != null) {
                        t.this.aZH.setText(am.cX(t.this.aZP));
                    }
                    if (t.this.dXz != null) {
                        t.this.dXz.Lz();
                    }
                    if (t.this.aZO != null) {
                        t.this.aZO.onProgressChanged(seekBar, t.this.aZP, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                t.this.aZG.seekTo(t.this.aZP);
                t.this.aZJ = false;
                t.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (t.this.aZO != null) {
                    t.this.aZO.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bg = bg(context);
        addView(bg, -1, (int) context.getResources().getDimension(d.f.ds80));
        this.aZH = (TextView) bg.findViewById(d.h.textview_cur_time);
        this.aZI = (TextView) bg.findViewById(d.h.textview_duration);
        this.aZL = (SeekBar) bg.findViewById(d.h.pb_video_controller_seekBar);
        this.aZL.setOnSeekBarChangeListener(this.aZQ);
    }

    protected View bg(Context context) {
        return LayoutInflater.from(context).inflate(d.j.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aZG = mediaPlayerControl;
    }

    public void W(int i, int i2) {
        this.HV = i2;
        this.aZK = false;
        this.mHandler.removeMessages(1);
        this.aZL.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.aZH != null) {
            this.aZH.setText(am.cX(i));
        }
        if (this.aZI != null) {
            this.aZI.setText(am.cX(this.HV));
        }
    }

    public void showProgress() {
        if (this.aZG != null) {
            this.aZF = ((this.aZG.getDuration() / 200) / 50) * 50;
            if (this.aZF < 50) {
                this.aZF = 50;
            } else if (this.aZF > 500) {
                this.aZF = 500;
            }
            this.aZK = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.aZF - (this.aZG.getCurrentPosition() % this.aZF));
        }
    }

    public void Lx() {
        this.aZK = false;
        this.mHandler.removeMessages(1);
        this.aZL.setProgress(0);
        if (this.aZH != null) {
            this.aZH.setText(am.cX(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ly() {
        if (this.aZG == null || this.aZJ) {
            return 0;
        }
        int currentPosition = this.aZG.getCurrentPosition();
        int duration = this.aZG.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.aZL != null) {
            if (duration > 0) {
                this.aZL.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aZG.getBufferPercentage();
        }
        if (this.aZH != null) {
            this.aZH.setText(am.cX(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    public void z(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (!z) {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
            }
        } else {
            this.aZG.seekTo(i);
            if (this.aZH != null) {
                this.aZH.setText(am.cX(i));
            }
            showProgress();
        }
        if (!this.aZG.isPlaying()) {
            this.aZL.setProgress((int) (((i * 1.0f) / this.HV) * 10000.0f));
        }
    }

    public String rN(int i) {
        if (i < 0) {
            i = 0;
        }
        return am.cX(i);
    }

    public int getSeekPosition() {
        return this.aZP;
    }

    public int getCurProgress() {
        if (this.aZL != null) {
            return this.aZL.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.dXy = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.dXz = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.aZO = onSeekBarChangeListener;
    }
}

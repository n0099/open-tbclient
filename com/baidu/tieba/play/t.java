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
    private int HU;
    private int aZT;
    private MediaController.MediaPlayerControl aZU;
    private TextView aZV;
    private TextView aZW;
    private boolean aZX;
    private boolean aZY;
    private SeekBar aZZ;
    private SeekBar.OnSeekBarChangeListener bac;
    private int bad;
    private SeekBar.OnSeekBarChangeListener bae;
    private b dXM;
    private a dXN;
    private Context mContext;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void LF();
    }

    /* loaded from: classes.dex */
    public interface b {
        void gf(int i);
    }

    public t(Context context) {
        super(context);
        this.aZT = 50;
        this.aZX = false;
        this.aZY = true;
        this.bad = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.t.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!t.this.aZX && t.this.aZY && t.this.aZU != null && t.this.aZU.isPlaying()) {
                            int LE = t.this.LE();
                            if (t.this.dXM != null) {
                                t.this.dXM.gf(LE);
                            }
                            sendMessageDelayed(obtainMessage(1), t.this.aZT - (LE % t.this.aZT));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bae = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.t.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                t.this.aZX = true;
                if (t.this.bac != null) {
                    t.this.bac.onStartTrackingTouch(seekBar);
                }
                t.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    t.this.bad = (int) ((t.this.aZU.getDuration() * i) / 10000);
                    if (t.this.aZV != null) {
                        t.this.aZV.setText(am.cY(t.this.bad));
                    }
                    if (t.this.dXN != null) {
                        t.this.dXN.LF();
                    }
                    if (t.this.bac != null) {
                        t.this.bac.onProgressChanged(seekBar, t.this.bad, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                t.this.aZU.seekTo(t.this.bad);
                t.this.aZX = false;
                t.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (t.this.bac != null) {
                    t.this.bac.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public t(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZT = 50;
        this.aZX = false;
        this.aZY = true;
        this.bad = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.t.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!t.this.aZX && t.this.aZY && t.this.aZU != null && t.this.aZU.isPlaying()) {
                            int LE = t.this.LE();
                            if (t.this.dXM != null) {
                                t.this.dXM.gf(LE);
                            }
                            sendMessageDelayed(obtainMessage(1), t.this.aZT - (LE % t.this.aZT));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bae = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.t.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                t.this.aZX = true;
                if (t.this.bac != null) {
                    t.this.bac.onStartTrackingTouch(seekBar);
                }
                t.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    t.this.bad = (int) ((t.this.aZU.getDuration() * i) / 10000);
                    if (t.this.aZV != null) {
                        t.this.aZV.setText(am.cY(t.this.bad));
                    }
                    if (t.this.dXN != null) {
                        t.this.dXN.LF();
                    }
                    if (t.this.bac != null) {
                        t.this.bac.onProgressChanged(seekBar, t.this.bad, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                t.this.aZU.seekTo(t.this.bad);
                t.this.aZX = false;
                t.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (t.this.bac != null) {
                    t.this.bac.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public t(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aZT = 50;
        this.aZX = false;
        this.aZY = true;
        this.bad = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.t.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!t.this.aZX && t.this.aZY && t.this.aZU != null && t.this.aZU.isPlaying()) {
                            int LE = t.this.LE();
                            if (t.this.dXM != null) {
                                t.this.dXM.gf(LE);
                            }
                            sendMessageDelayed(obtainMessage(1), t.this.aZT - (LE % t.this.aZT));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bae = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.t.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                t.this.aZX = true;
                if (t.this.bac != null) {
                    t.this.bac.onStartTrackingTouch(seekBar);
                }
                t.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    t.this.bad = (int) ((t.this.aZU.getDuration() * i2) / 10000);
                    if (t.this.aZV != null) {
                        t.this.aZV.setText(am.cY(t.this.bad));
                    }
                    if (t.this.dXN != null) {
                        t.this.dXN.LF();
                    }
                    if (t.this.bac != null) {
                        t.this.bac.onProgressChanged(seekBar, t.this.bad, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                t.this.aZU.seekTo(t.this.bad);
                t.this.aZX = false;
                t.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (t.this.bac != null) {
                    t.this.bac.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bh = bh(context);
        addView(bh, -1, (int) context.getResources().getDimension(d.f.ds80));
        this.aZV = (TextView) bh.findViewById(d.h.textview_cur_time);
        this.aZW = (TextView) bh.findViewById(d.h.textview_duration);
        this.aZZ = (SeekBar) bh.findViewById(d.h.pb_video_controller_seekBar);
        this.aZZ.setOnSeekBarChangeListener(this.bae);
    }

    protected View bh(Context context) {
        return LayoutInflater.from(context).inflate(d.j.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aZU = mediaPlayerControl;
    }

    public void W(int i, int i2) {
        this.HU = i2;
        this.aZY = false;
        this.mHandler.removeMessages(1);
        this.aZZ.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.aZV != null) {
            this.aZV.setText(am.cY(i));
        }
        if (this.aZW != null) {
            this.aZW.setText(am.cY(this.HU));
        }
    }

    public void showProgress() {
        if (this.aZU != null) {
            this.aZT = ((this.aZU.getDuration() / 200) / 50) * 50;
            if (this.aZT < 50) {
                this.aZT = 50;
            } else if (this.aZT > 500) {
                this.aZT = 500;
            }
            this.aZY = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.aZT - (this.aZU.getCurrentPosition() % this.aZT));
        }
    }

    public void LD() {
        this.aZY = false;
        this.mHandler.removeMessages(1);
        this.aZZ.setProgress(0);
        if (this.aZV != null) {
            this.aZV.setText(am.cY(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int LE() {
        if (this.aZU == null || this.aZX) {
            return 0;
        }
        int currentPosition = this.aZU.getCurrentPosition();
        int duration = this.aZU.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.aZZ != null) {
            if (duration > 0) {
                this.aZZ.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aZU.getBufferPercentage();
        }
        if (this.aZV != null) {
            this.aZV.setText(am.cY(currentPosition));
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
            this.aZU.seekTo(i);
            if (this.aZV != null) {
                this.aZV.setText(am.cY(i));
            }
            showProgress();
        }
        if (!this.aZU.isPlaying()) {
            this.aZZ.setProgress((int) (((i * 1.0f) / this.HU) * 10000.0f));
        }
    }

    public String rO(int i) {
        if (i < 0) {
            i = 0;
        }
        return am.cY(i);
    }

    public int getSeekPosition() {
        return this.bad;
    }

    public int getCurProgress() {
        if (this.aZZ != null) {
            return this.aZZ.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.dXM = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.dXN = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bac = onSeekBarChangeListener;
    }
}

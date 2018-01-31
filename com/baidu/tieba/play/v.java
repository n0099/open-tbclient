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
public class v extends RelativeLayout {
    private boolean bFo;
    private boolean bRA;
    private SeekBar bRB;
    private SeekBar.OnSeekBarChangeListener bRE;
    private int bRF;
    private SeekBar.OnSeekBarChangeListener bRG;
    private int bRw;
    private MediaController.MediaPlayerControl bRx;
    private TextView bRy;
    private TextView bRz;
    private b fap;
    private a faq;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void TN();
    }

    /* loaded from: classes.dex */
    public interface b {
        void js(int i);
    }

    public v(Context context) {
        super(context);
        this.bRw = 50;
        this.bFo = false;
        this.bRA = true;
        this.bRF = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bFo && v.this.bRA && v.this.bRx != null && v.this.bRx.isPlaying()) {
                            int TM = v.this.TM();
                            if (v.this.fap != null) {
                                v.this.fap.js(TM);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bRw - (TM % v.this.bRw));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bRG = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bFo = true;
                if (v.this.bRE != null) {
                    v.this.bRE.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    v.this.bRF = (int) ((v.this.bRx.getDuration() * i) / 10000);
                    if (v.this.bRy != null) {
                        v.this.bRy.setText(am.fV(v.this.bRF));
                    }
                    if (v.this.faq != null) {
                        v.this.faq.TN();
                    }
                    if (v.this.bRE != null) {
                        v.this.bRE.onProgressChanged(seekBar, v.this.bRF, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bRx.seekTo(v.this.bRF);
                v.this.bFo = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bRE != null) {
                    v.this.bRE.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public v(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bRw = 50;
        this.bFo = false;
        this.bRA = true;
        this.bRF = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bFo && v.this.bRA && v.this.bRx != null && v.this.bRx.isPlaying()) {
                            int TM = v.this.TM();
                            if (v.this.fap != null) {
                                v.this.fap.js(TM);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bRw - (TM % v.this.bRw));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bRG = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bFo = true;
                if (v.this.bRE != null) {
                    v.this.bRE.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    v.this.bRF = (int) ((v.this.bRx.getDuration() * i) / 10000);
                    if (v.this.bRy != null) {
                        v.this.bRy.setText(am.fV(v.this.bRF));
                    }
                    if (v.this.faq != null) {
                        v.this.faq.TN();
                    }
                    if (v.this.bRE != null) {
                        v.this.bRE.onProgressChanged(seekBar, v.this.bRF, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bRx.seekTo(v.this.bRF);
                v.this.bFo = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bRE != null) {
                    v.this.bRE.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bRw = 50;
        this.bFo = false;
        this.bRA = true;
        this.bRF = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bFo && v.this.bRA && v.this.bRx != null && v.this.bRx.isPlaying()) {
                            int TM = v.this.TM();
                            if (v.this.fap != null) {
                                v.this.fap.js(TM);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bRw - (TM % v.this.bRw));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bRG = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bFo = true;
                if (v.this.bRE != null) {
                    v.this.bRE.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    v.this.bRF = (int) ((v.this.bRx.getDuration() * i2) / 10000);
                    if (v.this.bRy != null) {
                        v.this.bRy.setText(am.fV(v.this.bRF));
                    }
                    if (v.this.faq != null) {
                        v.this.faq.TN();
                    }
                    if (v.this.bRE != null) {
                        v.this.bRE.onProgressChanged(seekBar, v.this.bRF, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bRx.seekTo(v.this.bRF);
                v.this.bFo = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bRE != null) {
                    v.this.bRE.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View br = br(context);
        addView(br, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.bRy = (TextView) br.findViewById(d.g.textview_cur_time);
        this.bRz = (TextView) br.findViewById(d.g.textview_duration);
        this.bRB = (SeekBar) br.findViewById(d.g.pb_video_controller_seekBar);
        this.bRB.setOnSeekBarChangeListener(this.bRG);
    }

    protected View br(Context context) {
        return LayoutInflater.from(context).inflate(d.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bRx = mediaPlayerControl;
    }

    public void aU(int i, int i2) {
        this.mDuration = i2;
        this.bRA = false;
        this.mHandler.removeMessages(1);
        this.bRB.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bRy != null) {
            this.bRy.setText(am.fV(i));
        }
        if (this.bRz != null) {
            this.bRz.setText(am.fV(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bRx != null) {
            this.bRw = ((this.bRx.getDuration() / 200) / 50) * 50;
            if (this.bRw < 50) {
                this.bRw = 50;
            } else if (this.bRw > 500) {
                this.bRw = 500;
            }
            this.bRA = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bRw - (this.bRx.getCurrentPosition() % this.bRw));
        }
    }

    public void TL() {
        this.bRA = false;
        this.mHandler.removeMessages(1);
        this.bRB.setProgress(0);
        if (this.bRy != null) {
            this.bRy.setText(am.fV(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int TM() {
        if (this.bRx == null || this.bFo) {
            return 0;
        }
        int currentPosition = this.bRx.getCurrentPosition();
        int duration = this.bRx.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bRB != null) {
            if (duration > 0) {
                this.bRB.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bRx.getBufferPercentage();
        }
        if (this.bRy != null) {
            this.bRy.setText(am.fV(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    public void L(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (!z) {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
            }
        } else {
            this.bRx.seekTo(i);
            if (this.bRy != null) {
                this.bRy.setText(am.fV(i));
            }
            showProgress();
        }
        if (!this.bRx.isPlaying()) {
            this.bRB.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String tV(int i) {
        if (i < 0) {
            i = 0;
        }
        return am.fV(i);
    }

    public int getSeekPosition() {
        return this.bRF;
    }

    public int getCurProgress() {
        if (this.bRB != null) {
            return this.bRB.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.fap = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.faq = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bRE = onSeekBarChangeListener;
    }
}

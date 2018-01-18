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
    private boolean bFg;
    private int bRo;
    private MediaController.MediaPlayerControl bRp;
    private TextView bRq;
    private TextView bRr;
    private boolean bRs;
    private SeekBar bRt;
    private SeekBar.OnSeekBarChangeListener bRw;
    private int bRx;
    private SeekBar.OnSeekBarChangeListener bRy;
    private b eZU;
    private a eZV;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void TL();
    }

    /* loaded from: classes.dex */
    public interface b {
        void js(int i);
    }

    public v(Context context) {
        super(context);
        this.bRo = 50;
        this.bFg = false;
        this.bRs = true;
        this.bRx = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bFg && v.this.bRs && v.this.bRp != null && v.this.bRp.isPlaying()) {
                            int TK = v.this.TK();
                            if (v.this.eZU != null) {
                                v.this.eZU.js(TK);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bRo - (TK % v.this.bRo));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bRy = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bFg = true;
                if (v.this.bRw != null) {
                    v.this.bRw.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    v.this.bRx = (int) ((v.this.bRp.getDuration() * i) / 10000);
                    if (v.this.bRq != null) {
                        v.this.bRq.setText(am.fV(v.this.bRx));
                    }
                    if (v.this.eZV != null) {
                        v.this.eZV.TL();
                    }
                    if (v.this.bRw != null) {
                        v.this.bRw.onProgressChanged(seekBar, v.this.bRx, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bRp.seekTo(v.this.bRx);
                v.this.bFg = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bRw != null) {
                    v.this.bRw.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public v(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bRo = 50;
        this.bFg = false;
        this.bRs = true;
        this.bRx = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bFg && v.this.bRs && v.this.bRp != null && v.this.bRp.isPlaying()) {
                            int TK = v.this.TK();
                            if (v.this.eZU != null) {
                                v.this.eZU.js(TK);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bRo - (TK % v.this.bRo));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bRy = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bFg = true;
                if (v.this.bRw != null) {
                    v.this.bRw.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    v.this.bRx = (int) ((v.this.bRp.getDuration() * i) / 10000);
                    if (v.this.bRq != null) {
                        v.this.bRq.setText(am.fV(v.this.bRx));
                    }
                    if (v.this.eZV != null) {
                        v.this.eZV.TL();
                    }
                    if (v.this.bRw != null) {
                        v.this.bRw.onProgressChanged(seekBar, v.this.bRx, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bRp.seekTo(v.this.bRx);
                v.this.bFg = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bRw != null) {
                    v.this.bRw.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bRo = 50;
        this.bFg = false;
        this.bRs = true;
        this.bRx = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bFg && v.this.bRs && v.this.bRp != null && v.this.bRp.isPlaying()) {
                            int TK = v.this.TK();
                            if (v.this.eZU != null) {
                                v.this.eZU.js(TK);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bRo - (TK % v.this.bRo));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bRy = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bFg = true;
                if (v.this.bRw != null) {
                    v.this.bRw.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    v.this.bRx = (int) ((v.this.bRp.getDuration() * i2) / 10000);
                    if (v.this.bRq != null) {
                        v.this.bRq.setText(am.fV(v.this.bRx));
                    }
                    if (v.this.eZV != null) {
                        v.this.eZV.TL();
                    }
                    if (v.this.bRw != null) {
                        v.this.bRw.onProgressChanged(seekBar, v.this.bRx, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bRp.seekTo(v.this.bRx);
                v.this.bFg = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bRw != null) {
                    v.this.bRw.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bu = bu(context);
        addView(bu, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.bRq = (TextView) bu.findViewById(d.g.textview_cur_time);
        this.bRr = (TextView) bu.findViewById(d.g.textview_duration);
        this.bRt = (SeekBar) bu.findViewById(d.g.pb_video_controller_seekBar);
        this.bRt.setOnSeekBarChangeListener(this.bRy);
    }

    protected View bu(Context context) {
        return LayoutInflater.from(context).inflate(d.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bRp = mediaPlayerControl;
    }

    public void aU(int i, int i2) {
        this.mDuration = i2;
        this.bRs = false;
        this.mHandler.removeMessages(1);
        this.bRt.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bRq != null) {
            this.bRq.setText(am.fV(i));
        }
        if (this.bRr != null) {
            this.bRr.setText(am.fV(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bRp != null) {
            this.bRo = ((this.bRp.getDuration() / 200) / 50) * 50;
            if (this.bRo < 50) {
                this.bRo = 50;
            } else if (this.bRo > 500) {
                this.bRo = 500;
            }
            this.bRs = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bRo - (this.bRp.getCurrentPosition() % this.bRo));
        }
    }

    public void TJ() {
        this.bRs = false;
        this.mHandler.removeMessages(1);
        this.bRt.setProgress(0);
        if (this.bRq != null) {
            this.bRq.setText(am.fV(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int TK() {
        if (this.bRp == null || this.bFg) {
            return 0;
        }
        int currentPosition = this.bRp.getCurrentPosition();
        int duration = this.bRp.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bRt != null) {
            if (duration > 0) {
                this.bRt.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bRp.getBufferPercentage();
        }
        if (this.bRq != null) {
            this.bRq.setText(am.fV(currentPosition));
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
            this.bRp.seekTo(i);
            if (this.bRq != null) {
                this.bRq.setText(am.fV(i));
            }
            showProgress();
        }
        if (!this.bRp.isPlaying()) {
            this.bRt.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String tV(int i) {
        if (i < 0) {
            i = 0;
        }
        return am.fV(i);
    }

    public int getSeekPosition() {
        return this.bRx;
    }

    public int getCurProgress() {
        if (this.bRt != null) {
            return this.bRt.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.eZU = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.eZV = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bRw = onSeekBarChangeListener;
    }
}

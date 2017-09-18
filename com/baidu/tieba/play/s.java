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
public class s extends RelativeLayout {
    private int HD;
    private int aYg;
    private MediaController.MediaPlayerControl aYh;
    private TextView aYi;
    private TextView aYj;
    private boolean aYk;
    private boolean aYl;
    private SeekBar aYm;
    private SeekBar.OnSeekBarChangeListener aYp;
    private int aYq;
    private SeekBar.OnSeekBarChangeListener aYr;
    private b ebD;
    private a ebE;
    private Context mContext;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void Lo();
    }

    /* loaded from: classes.dex */
    public interface b {
        void fR(int i);
    }

    public s(Context context) {
        super(context);
        this.aYg = 50;
        this.aYk = false;
        this.aYl = true;
        this.aYq = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aYk && s.this.aYl && s.this.aYh != null && s.this.aYh.isPlaying()) {
                            int Ln = s.this.Ln();
                            if (s.this.ebD != null) {
                                s.this.ebD.fR(Ln);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aYg - (Ln % s.this.aYg));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aYr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aYk = true;
                if (s.this.aYp != null) {
                    s.this.aYp.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    s.this.aYq = (int) ((s.this.aYh.getDuration() * i) / 10000);
                    if (s.this.aYi != null) {
                        s.this.aYi.setText(am.da(s.this.aYq));
                    }
                    if (s.this.ebE != null) {
                        s.this.ebE.Lo();
                    }
                    if (s.this.aYp != null) {
                        s.this.aYp.onProgressChanged(seekBar, s.this.aYq, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aYh.seekTo(s.this.aYq);
                s.this.aYk = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aYp != null) {
                    s.this.aYp.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aYg = 50;
        this.aYk = false;
        this.aYl = true;
        this.aYq = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aYk && s.this.aYl && s.this.aYh != null && s.this.aYh.isPlaying()) {
                            int Ln = s.this.Ln();
                            if (s.this.ebD != null) {
                                s.this.ebD.fR(Ln);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aYg - (Ln % s.this.aYg));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aYr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aYk = true;
                if (s.this.aYp != null) {
                    s.this.aYp.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    s.this.aYq = (int) ((s.this.aYh.getDuration() * i) / 10000);
                    if (s.this.aYi != null) {
                        s.this.aYi.setText(am.da(s.this.aYq));
                    }
                    if (s.this.ebE != null) {
                        s.this.ebE.Lo();
                    }
                    if (s.this.aYp != null) {
                        s.this.aYp.onProgressChanged(seekBar, s.this.aYq, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aYh.seekTo(s.this.aYq);
                s.this.aYk = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aYp != null) {
                    s.this.aYp.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public s(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aYg = 50;
        this.aYk = false;
        this.aYl = true;
        this.aYq = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aYk && s.this.aYl && s.this.aYh != null && s.this.aYh.isPlaying()) {
                            int Ln = s.this.Ln();
                            if (s.this.ebD != null) {
                                s.this.ebD.fR(Ln);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aYg - (Ln % s.this.aYg));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aYr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aYk = true;
                if (s.this.aYp != null) {
                    s.this.aYp.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    s.this.aYq = (int) ((s.this.aYh.getDuration() * i2) / 10000);
                    if (s.this.aYi != null) {
                        s.this.aYi.setText(am.da(s.this.aYq));
                    }
                    if (s.this.ebE != null) {
                        s.this.ebE.Lo();
                    }
                    if (s.this.aYp != null) {
                        s.this.aYp.onProgressChanged(seekBar, s.this.aYq, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aYh.seekTo(s.this.aYq);
                s.this.aYk = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aYp != null) {
                    s.this.aYp.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bh = bh(context);
        addView(bh, -1, (int) context.getResources().getDimension(d.f.ds80));
        this.aYi = (TextView) bh.findViewById(d.h.textview_cur_time);
        this.aYj = (TextView) bh.findViewById(d.h.textview_duration);
        this.aYm = (SeekBar) bh.findViewById(d.h.pb_video_controller_seekBar);
        this.aYm.setOnSeekBarChangeListener(this.aYr);
    }

    protected View bh(Context context) {
        return LayoutInflater.from(context).inflate(d.j.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aYh = mediaPlayerControl;
    }

    public void S(int i, int i2) {
        this.HD = i2;
        this.aYl = false;
        this.mHandler.removeMessages(1);
        this.aYm.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.aYi != null) {
            this.aYi.setText(am.da(i));
        }
        if (this.aYj != null) {
            this.aYj.setText(am.da(this.HD));
        }
    }

    public void showProgress() {
        if (this.aYh != null) {
            this.aYg = ((this.aYh.getDuration() / 200) / 50) * 50;
            if (this.aYg < 50) {
                this.aYg = 50;
            } else if (this.aYg > 500) {
                this.aYg = 500;
            }
            this.aYl = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.aYg - (this.aYh.getCurrentPosition() % this.aYg));
        }
    }

    public void Lm() {
        this.aYl = false;
        this.mHandler.removeMessages(1);
        this.aYm.setProgress(0);
        if (this.aYi != null) {
            this.aYi.setText(am.da(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ln() {
        if (this.aYh == null || this.aYk) {
            return 0;
        }
        int currentPosition = this.aYh.getCurrentPosition();
        int duration = this.aYh.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.aYm != null) {
            if (duration > 0) {
                this.aYm.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aYh.getBufferPercentage();
        }
        if (this.aYi != null) {
            this.aYi.setText(am.da(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    public void A(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (!z) {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
            }
        } else {
            this.aYh.seekTo(i);
            if (this.aYi != null) {
                this.aYi.setText(am.da(i));
            }
            showProgress();
        }
        if (!this.aYh.isPlaying()) {
            this.aYm.setProgress((int) (((i * 1.0f) / this.HD) * 10000.0f));
        }
    }

    public String rO(int i) {
        if (i < 0) {
            i = 0;
        }
        return am.da(i);
    }

    public int getSeekPosition() {
        return this.aYq;
    }

    public int getCurProgress() {
        if (this.aYm != null) {
            return this.aYm.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.ebD = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.ebE = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.aYp = onSeekBarChangeListener;
    }
}

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
    private int aYj;
    private MediaController.MediaPlayerControl aYk;
    private TextView aYl;
    private TextView aYm;
    private boolean aYn;
    private boolean aYo;
    private SeekBar aYp;
    private SeekBar.OnSeekBarChangeListener aYs;
    private int aYt;
    private SeekBar.OnSeekBarChangeListener aYu;
    private b eaJ;
    private a eaK;
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
        this.aYj = 50;
        this.aYn = false;
        this.aYo = true;
        this.aYt = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aYn && s.this.aYo && s.this.aYk != null && s.this.aYk.isPlaying()) {
                            int Ln = s.this.Ln();
                            if (s.this.eaJ != null) {
                                s.this.eaJ.fR(Ln);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aYj - (Ln % s.this.aYj));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aYu = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aYn = true;
                if (s.this.aYs != null) {
                    s.this.aYs.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    s.this.aYt = (int) ((s.this.aYk.getDuration() * i) / 10000);
                    if (s.this.aYl != null) {
                        s.this.aYl.setText(am.da(s.this.aYt));
                    }
                    if (s.this.eaK != null) {
                        s.this.eaK.Lo();
                    }
                    if (s.this.aYs != null) {
                        s.this.aYs.onProgressChanged(seekBar, s.this.aYt, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aYk.seekTo(s.this.aYt);
                s.this.aYn = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aYs != null) {
                    s.this.aYs.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aYj = 50;
        this.aYn = false;
        this.aYo = true;
        this.aYt = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aYn && s.this.aYo && s.this.aYk != null && s.this.aYk.isPlaying()) {
                            int Ln = s.this.Ln();
                            if (s.this.eaJ != null) {
                                s.this.eaJ.fR(Ln);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aYj - (Ln % s.this.aYj));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aYu = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aYn = true;
                if (s.this.aYs != null) {
                    s.this.aYs.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    s.this.aYt = (int) ((s.this.aYk.getDuration() * i) / 10000);
                    if (s.this.aYl != null) {
                        s.this.aYl.setText(am.da(s.this.aYt));
                    }
                    if (s.this.eaK != null) {
                        s.this.eaK.Lo();
                    }
                    if (s.this.aYs != null) {
                        s.this.aYs.onProgressChanged(seekBar, s.this.aYt, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aYk.seekTo(s.this.aYt);
                s.this.aYn = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aYs != null) {
                    s.this.aYs.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public s(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aYj = 50;
        this.aYn = false;
        this.aYo = true;
        this.aYt = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aYn && s.this.aYo && s.this.aYk != null && s.this.aYk.isPlaying()) {
                            int Ln = s.this.Ln();
                            if (s.this.eaJ != null) {
                                s.this.eaJ.fR(Ln);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aYj - (Ln % s.this.aYj));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aYu = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aYn = true;
                if (s.this.aYs != null) {
                    s.this.aYs.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    s.this.aYt = (int) ((s.this.aYk.getDuration() * i2) / 10000);
                    if (s.this.aYl != null) {
                        s.this.aYl.setText(am.da(s.this.aYt));
                    }
                    if (s.this.eaK != null) {
                        s.this.eaK.Lo();
                    }
                    if (s.this.aYs != null) {
                        s.this.aYs.onProgressChanged(seekBar, s.this.aYt, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aYk.seekTo(s.this.aYt);
                s.this.aYn = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aYs != null) {
                    s.this.aYs.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bg = bg(context);
        addView(bg, -1, (int) context.getResources().getDimension(d.f.ds80));
        this.aYl = (TextView) bg.findViewById(d.h.textview_cur_time);
        this.aYm = (TextView) bg.findViewById(d.h.textview_duration);
        this.aYp = (SeekBar) bg.findViewById(d.h.pb_video_controller_seekBar);
        this.aYp.setOnSeekBarChangeListener(this.aYu);
    }

    protected View bg(Context context) {
        return LayoutInflater.from(context).inflate(d.j.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aYk = mediaPlayerControl;
    }

    public void S(int i, int i2) {
        this.HD = i2;
        this.aYo = false;
        this.mHandler.removeMessages(1);
        this.aYp.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.aYl != null) {
            this.aYl.setText(am.da(i));
        }
        if (this.aYm != null) {
            this.aYm.setText(am.da(this.HD));
        }
    }

    public void showProgress() {
        if (this.aYk != null) {
            this.aYj = ((this.aYk.getDuration() / 200) / 50) * 50;
            if (this.aYj < 50) {
                this.aYj = 50;
            } else if (this.aYj > 500) {
                this.aYj = 500;
            }
            this.aYo = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.aYj - (this.aYk.getCurrentPosition() % this.aYj));
        }
    }

    public void Lm() {
        this.aYo = false;
        this.mHandler.removeMessages(1);
        this.aYp.setProgress(0);
        if (this.aYl != null) {
            this.aYl.setText(am.da(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ln() {
        if (this.aYk == null || this.aYn) {
            return 0;
        }
        int currentPosition = this.aYk.getCurrentPosition();
        int duration = this.aYk.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.aYp != null) {
            if (duration > 0) {
                this.aYp.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aYk.getBufferPercentage();
        }
        if (this.aYl != null) {
            this.aYl.setText(am.da(currentPosition));
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
            this.aYk.seekTo(i);
            if (this.aYl != null) {
                this.aYl.setText(am.da(i));
            }
            showProgress();
        }
        if (!this.aYk.isPlaying()) {
            this.aYp.setProgress((int) (((i * 1.0f) / this.HD) * 10000.0f));
        }
    }

    public String rM(int i) {
        if (i < 0) {
            i = 0;
        }
        return am.da(i);
    }

    public int getSeekPosition() {
        return this.aYt;
    }

    public int getCurProgress() {
        if (this.aYp != null) {
            return this.aYp.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.eaJ = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.eaK = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.aYs = onSeekBarChangeListener;
    }
}

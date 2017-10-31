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
    private int aZW;
    private MediaController.MediaPlayerControl aZX;
    private TextView aZY;
    private TextView aZZ;
    private boolean baa;
    private boolean bab;
    private SeekBar bac;
    private SeekBar.OnSeekBarChangeListener baf;
    private int bag;
    private SeekBar.OnSeekBarChangeListener bah;
    private b efj;
    private a efk;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void LI();
    }

    /* loaded from: classes.dex */
    public interface b {
        void gn(int i);
    }

    public t(Context context) {
        super(context);
        this.aZW = 50;
        this.baa = false;
        this.bab = true;
        this.bag = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.t.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!t.this.baa && t.this.bab && t.this.aZX != null && t.this.aZX.isPlaying()) {
                            int LH = t.this.LH();
                            if (t.this.efj != null) {
                                t.this.efj.gn(LH);
                            }
                            sendMessageDelayed(obtainMessage(1), t.this.aZW - (LH % t.this.aZW));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bah = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.t.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                t.this.baa = true;
                if (t.this.baf != null) {
                    t.this.baf.onStartTrackingTouch(seekBar);
                }
                t.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    t.this.bag = (int) ((t.this.aZX.getDuration() * i) / 10000);
                    if (t.this.aZY != null) {
                        t.this.aZY.setText(am.cY(t.this.bag));
                    }
                    if (t.this.efk != null) {
                        t.this.efk.LI();
                    }
                    if (t.this.baf != null) {
                        t.this.baf.onProgressChanged(seekBar, t.this.bag, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                t.this.aZX.seekTo(t.this.bag);
                t.this.baa = false;
                t.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (t.this.baf != null) {
                    t.this.baf.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public t(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZW = 50;
        this.baa = false;
        this.bab = true;
        this.bag = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.t.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!t.this.baa && t.this.bab && t.this.aZX != null && t.this.aZX.isPlaying()) {
                            int LH = t.this.LH();
                            if (t.this.efj != null) {
                                t.this.efj.gn(LH);
                            }
                            sendMessageDelayed(obtainMessage(1), t.this.aZW - (LH % t.this.aZW));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bah = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.t.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                t.this.baa = true;
                if (t.this.baf != null) {
                    t.this.baf.onStartTrackingTouch(seekBar);
                }
                t.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    t.this.bag = (int) ((t.this.aZX.getDuration() * i) / 10000);
                    if (t.this.aZY != null) {
                        t.this.aZY.setText(am.cY(t.this.bag));
                    }
                    if (t.this.efk != null) {
                        t.this.efk.LI();
                    }
                    if (t.this.baf != null) {
                        t.this.baf.onProgressChanged(seekBar, t.this.bag, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                t.this.aZX.seekTo(t.this.bag);
                t.this.baa = false;
                t.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (t.this.baf != null) {
                    t.this.baf.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public t(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aZW = 50;
        this.baa = false;
        this.bab = true;
        this.bag = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.t.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!t.this.baa && t.this.bab && t.this.aZX != null && t.this.aZX.isPlaying()) {
                            int LH = t.this.LH();
                            if (t.this.efj != null) {
                                t.this.efj.gn(LH);
                            }
                            sendMessageDelayed(obtainMessage(1), t.this.aZW - (LH % t.this.aZW));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bah = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.t.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                t.this.baa = true;
                if (t.this.baf != null) {
                    t.this.baf.onStartTrackingTouch(seekBar);
                }
                t.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    t.this.bag = (int) ((t.this.aZX.getDuration() * i2) / 10000);
                    if (t.this.aZY != null) {
                        t.this.aZY.setText(am.cY(t.this.bag));
                    }
                    if (t.this.efk != null) {
                        t.this.efk.LI();
                    }
                    if (t.this.baf != null) {
                        t.this.baf.onProgressChanged(seekBar, t.this.bag, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                t.this.aZX.seekTo(t.this.bag);
                t.this.baa = false;
                t.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (t.this.baf != null) {
                    t.this.baf.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bg = bg(context);
        addView(bg, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.aZY = (TextView) bg.findViewById(d.g.textview_cur_time);
        this.aZZ = (TextView) bg.findViewById(d.g.textview_duration);
        this.bac = (SeekBar) bg.findViewById(d.g.pb_video_controller_seekBar);
        this.bac.setOnSeekBarChangeListener(this.bah);
    }

    protected View bg(Context context) {
        return LayoutInflater.from(context).inflate(d.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aZX = mediaPlayerControl;
    }

    public void V(int i, int i2) {
        this.mDuration = i2;
        this.bab = false;
        this.mHandler.removeMessages(1);
        this.bac.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.aZY != null) {
            this.aZY.setText(am.cY(i));
        }
        if (this.aZZ != null) {
            this.aZZ.setText(am.cY(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.aZX != null) {
            this.aZW = ((this.aZX.getDuration() / 200) / 50) * 50;
            if (this.aZW < 50) {
                this.aZW = 50;
            } else if (this.aZW > 500) {
                this.aZW = 500;
            }
            this.bab = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.aZW - (this.aZX.getCurrentPosition() % this.aZW));
        }
    }

    public void LG() {
        this.bab = false;
        this.mHandler.removeMessages(1);
        this.bac.setProgress(0);
        if (this.aZY != null) {
            this.aZY.setText(am.cY(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int LH() {
        if (this.aZX == null || this.baa) {
            return 0;
        }
        int currentPosition = this.aZX.getCurrentPosition();
        int duration = this.aZX.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bac != null) {
            if (duration > 0) {
                this.bac.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aZX.getBufferPercentage();
        }
        if (this.aZY != null) {
            this.aZY.setText(am.cY(currentPosition));
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
            this.aZX.seekTo(i);
            if (this.aZY != null) {
                this.aZY.setText(am.cY(i));
            }
            showProgress();
        }
        if (!this.aZX.isPlaying()) {
            this.bac.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String sd(int i) {
        if (i < 0) {
            i = 0;
        }
        return am.cY(i);
    }

    public int getSeekPosition() {
        return this.bag;
    }

    public int getCurProgress() {
        if (this.bac != null) {
            return this.bac.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.efj = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.efk = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.baf = onSeekBarChangeListener;
    }
}

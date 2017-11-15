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
    private int baf;
    private MediaController.MediaPlayerControl bag;
    private TextView bah;
    private TextView bai;
    private boolean baj;
    private boolean bak;
    private SeekBar bal;
    private SeekBar.OnSeekBarChangeListener bao;
    private int bap;
    private SeekBar.OnSeekBarChangeListener baq;
    private b efn;
    private a efo;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void LT();
    }

    /* loaded from: classes.dex */
    public interface b {
        void gm(int i);
    }

    public t(Context context) {
        super(context);
        this.baf = 50;
        this.baj = false;
        this.bak = true;
        this.bap = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.t.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!t.this.baj && t.this.bak && t.this.bag != null && t.this.bag.isPlaying()) {
                            int LS = t.this.LS();
                            if (t.this.efn != null) {
                                t.this.efn.gm(LS);
                            }
                            sendMessageDelayed(obtainMessage(1), t.this.baf - (LS % t.this.baf));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.baq = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.t.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                t.this.baj = true;
                if (t.this.bao != null) {
                    t.this.bao.onStartTrackingTouch(seekBar);
                }
                t.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    t.this.bap = (int) ((t.this.bag.getDuration() * i) / 10000);
                    if (t.this.bah != null) {
                        t.this.bah.setText(am.cX(t.this.bap));
                    }
                    if (t.this.efo != null) {
                        t.this.efo.LT();
                    }
                    if (t.this.bao != null) {
                        t.this.bao.onProgressChanged(seekBar, t.this.bap, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                t.this.bag.seekTo(t.this.bap);
                t.this.baj = false;
                t.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (t.this.bao != null) {
                    t.this.bao.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public t(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baf = 50;
        this.baj = false;
        this.bak = true;
        this.bap = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.t.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!t.this.baj && t.this.bak && t.this.bag != null && t.this.bag.isPlaying()) {
                            int LS = t.this.LS();
                            if (t.this.efn != null) {
                                t.this.efn.gm(LS);
                            }
                            sendMessageDelayed(obtainMessage(1), t.this.baf - (LS % t.this.baf));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.baq = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.t.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                t.this.baj = true;
                if (t.this.bao != null) {
                    t.this.bao.onStartTrackingTouch(seekBar);
                }
                t.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    t.this.bap = (int) ((t.this.bag.getDuration() * i) / 10000);
                    if (t.this.bah != null) {
                        t.this.bah.setText(am.cX(t.this.bap));
                    }
                    if (t.this.efo != null) {
                        t.this.efo.LT();
                    }
                    if (t.this.bao != null) {
                        t.this.bao.onProgressChanged(seekBar, t.this.bap, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                t.this.bag.seekTo(t.this.bap);
                t.this.baj = false;
                t.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (t.this.bao != null) {
                    t.this.bao.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public t(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baf = 50;
        this.baj = false;
        this.bak = true;
        this.bap = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.t.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!t.this.baj && t.this.bak && t.this.bag != null && t.this.bag.isPlaying()) {
                            int LS = t.this.LS();
                            if (t.this.efn != null) {
                                t.this.efn.gm(LS);
                            }
                            sendMessageDelayed(obtainMessage(1), t.this.baf - (LS % t.this.baf));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.baq = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.t.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                t.this.baj = true;
                if (t.this.bao != null) {
                    t.this.bao.onStartTrackingTouch(seekBar);
                }
                t.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    t.this.bap = (int) ((t.this.bag.getDuration() * i2) / 10000);
                    if (t.this.bah != null) {
                        t.this.bah.setText(am.cX(t.this.bap));
                    }
                    if (t.this.efo != null) {
                        t.this.efo.LT();
                    }
                    if (t.this.bao != null) {
                        t.this.bao.onProgressChanged(seekBar, t.this.bap, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                t.this.bag.seekTo(t.this.bap);
                t.this.baj = false;
                t.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (t.this.bao != null) {
                    t.this.bao.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bg = bg(context);
        addView(bg, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.bah = (TextView) bg.findViewById(d.g.textview_cur_time);
        this.bai = (TextView) bg.findViewById(d.g.textview_duration);
        this.bal = (SeekBar) bg.findViewById(d.g.pb_video_controller_seekBar);
        this.bal.setOnSeekBarChangeListener(this.baq);
    }

    protected View bg(Context context) {
        return LayoutInflater.from(context).inflate(d.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bag = mediaPlayerControl;
    }

    public void V(int i, int i2) {
        this.mDuration = i2;
        this.bak = false;
        this.mHandler.removeMessages(1);
        this.bal.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bah != null) {
            this.bah.setText(am.cX(i));
        }
        if (this.bai != null) {
            this.bai.setText(am.cX(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bag != null) {
            this.baf = ((this.bag.getDuration() / 200) / 50) * 50;
            if (this.baf < 50) {
                this.baf = 50;
            } else if (this.baf > 500) {
                this.baf = 500;
            }
            this.bak = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.baf - (this.bag.getCurrentPosition() % this.baf));
        }
    }

    public void LR() {
        this.bak = false;
        this.mHandler.removeMessages(1);
        this.bal.setProgress(0);
        if (this.bah != null) {
            this.bah.setText(am.cX(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int LS() {
        if (this.bag == null || this.baj) {
            return 0;
        }
        int currentPosition = this.bag.getCurrentPosition();
        int duration = this.bag.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bal != null) {
            if (duration > 0) {
                this.bal.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bag.getBufferPercentage();
        }
        if (this.bah != null) {
            this.bah.setText(am.cX(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    public void B(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (!z) {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
            }
        } else {
            this.bag.seekTo(i);
            if (this.bah != null) {
                this.bah.setText(am.cX(i));
            }
            showProgress();
        }
        if (!this.bag.isPlaying()) {
            this.bal.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String se(int i) {
        if (i < 0) {
            i = 0;
        }
        return am.cX(i);
    }

    public int getSeekPosition() {
        return this.bap;
    }

    public int getCurProgress() {
        if (this.bal != null) {
            return this.bal.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.efn = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.efo = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bao = onSeekBarChangeListener;
    }
}

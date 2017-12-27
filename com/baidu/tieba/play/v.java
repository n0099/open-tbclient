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
    private boolean bEY;
    private int bRh;
    private MediaController.MediaPlayerControl bRi;
    private TextView bRj;
    private TextView bRk;
    private boolean bRl;
    private SeekBar bRm;
    private SeekBar.OnSeekBarChangeListener bRp;
    private int bRq;
    private SeekBar.OnSeekBarChangeListener bRr;
    private b eYt;
    private a eYu;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void TX();
    }

    /* loaded from: classes.dex */
    public interface b {
        void jw(int i);
    }

    public v(Context context) {
        super(context);
        this.bRh = 50;
        this.bEY = false;
        this.bRl = true;
        this.bRq = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bEY && v.this.bRl && v.this.bRi != null && v.this.bRi.isPlaying()) {
                            int TW = v.this.TW();
                            if (v.this.eYt != null) {
                                v.this.eYt.jw(TW);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bRh - (TW % v.this.bRh));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bRr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bEY = true;
                if (v.this.bRp != null) {
                    v.this.bRp.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    v.this.bRq = (int) ((v.this.bRi.getDuration() * i) / 10000);
                    if (v.this.bRj != null) {
                        v.this.bRj.setText(am.fX(v.this.bRq));
                    }
                    if (v.this.eYu != null) {
                        v.this.eYu.TX();
                    }
                    if (v.this.bRp != null) {
                        v.this.bRp.onProgressChanged(seekBar, v.this.bRq, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bRi.seekTo(v.this.bRq);
                v.this.bEY = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bRp != null) {
                    v.this.bRp.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public v(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bRh = 50;
        this.bEY = false;
        this.bRl = true;
        this.bRq = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bEY && v.this.bRl && v.this.bRi != null && v.this.bRi.isPlaying()) {
                            int TW = v.this.TW();
                            if (v.this.eYt != null) {
                                v.this.eYt.jw(TW);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bRh - (TW % v.this.bRh));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bRr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bEY = true;
                if (v.this.bRp != null) {
                    v.this.bRp.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    v.this.bRq = (int) ((v.this.bRi.getDuration() * i) / 10000);
                    if (v.this.bRj != null) {
                        v.this.bRj.setText(am.fX(v.this.bRq));
                    }
                    if (v.this.eYu != null) {
                        v.this.eYu.TX();
                    }
                    if (v.this.bRp != null) {
                        v.this.bRp.onProgressChanged(seekBar, v.this.bRq, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bRi.seekTo(v.this.bRq);
                v.this.bEY = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bRp != null) {
                    v.this.bRp.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bRh = 50;
        this.bEY = false;
        this.bRl = true;
        this.bRq = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bEY && v.this.bRl && v.this.bRi != null && v.this.bRi.isPlaying()) {
                            int TW = v.this.TW();
                            if (v.this.eYt != null) {
                                v.this.eYt.jw(TW);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bRh - (TW % v.this.bRh));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bRr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bEY = true;
                if (v.this.bRp != null) {
                    v.this.bRp.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    v.this.bRq = (int) ((v.this.bRi.getDuration() * i2) / 10000);
                    if (v.this.bRj != null) {
                        v.this.bRj.setText(am.fX(v.this.bRq));
                    }
                    if (v.this.eYu != null) {
                        v.this.eYu.TX();
                    }
                    if (v.this.bRp != null) {
                        v.this.bRp.onProgressChanged(seekBar, v.this.bRq, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bRi.seekTo(v.this.bRq);
                v.this.bEY = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bRp != null) {
                    v.this.bRp.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bu = bu(context);
        addView(bu, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.bRj = (TextView) bu.findViewById(d.g.textview_cur_time);
        this.bRk = (TextView) bu.findViewById(d.g.textview_duration);
        this.bRm = (SeekBar) bu.findViewById(d.g.pb_video_controller_seekBar);
        this.bRm.setOnSeekBarChangeListener(this.bRr);
    }

    protected View bu(Context context) {
        return LayoutInflater.from(context).inflate(d.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bRi = mediaPlayerControl;
    }

    public void aU(int i, int i2) {
        this.mDuration = i2;
        this.bRl = false;
        this.mHandler.removeMessages(1);
        this.bRm.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bRj != null) {
            this.bRj.setText(am.fX(i));
        }
        if (this.bRk != null) {
            this.bRk.setText(am.fX(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bRi != null) {
            this.bRh = ((this.bRi.getDuration() / 200) / 50) * 50;
            if (this.bRh < 50) {
                this.bRh = 50;
            } else if (this.bRh > 500) {
                this.bRh = 500;
            }
            this.bRl = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bRh - (this.bRi.getCurrentPosition() % this.bRh));
        }
    }

    public void TV() {
        this.bRl = false;
        this.mHandler.removeMessages(1);
        this.bRm.setProgress(0);
        if (this.bRj != null) {
            this.bRj.setText(am.fX(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int TW() {
        if (this.bRi == null || this.bEY) {
            return 0;
        }
        int currentPosition = this.bRi.getCurrentPosition();
        int duration = this.bRi.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bRm != null) {
            if (duration > 0) {
                this.bRm.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bRi.getBufferPercentage();
        }
        if (this.bRj != null) {
            this.bRj.setText(am.fX(currentPosition));
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
            this.bRi.seekTo(i);
            if (this.bRj != null) {
                this.bRj.setText(am.fX(i));
            }
            showProgress();
        }
        if (!this.bRi.isPlaying()) {
            this.bRm.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String vu(int i) {
        if (i < 0) {
            i = 0;
        }
        return am.fX(i);
    }

    public int getSeekPosition() {
        return this.bRq;
    }

    public int getCurProgress() {
        if (this.bRm != null) {
            return this.bRm.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.eYt = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.eYu = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bRp = onSeekBarChangeListener;
    }
}

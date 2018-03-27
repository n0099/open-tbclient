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
    private boolean bHi;
    private SeekBar.OnSeekBarChangeListener bTA;
    private int bTB;
    private SeekBar.OnSeekBarChangeListener bTC;
    private int bTs;
    private MediaController.MediaPlayerControl bTt;
    private TextView bTu;
    private TextView bTv;
    private boolean bTw;
    private SeekBar bTx;
    private b feK;
    private a feL;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void UF();
    }

    /* loaded from: classes.dex */
    public interface b {
        void jo(int i);
    }

    public v(Context context) {
        super(context);
        this.bTs = 50;
        this.bHi = false;
        this.bTw = true;
        this.bTB = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bHi && v.this.bTw && v.this.bTt != null && v.this.bTt.isPlaying()) {
                            int UE = v.this.UE();
                            if (v.this.feK != null) {
                                v.this.feK.jo(UE);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bTs - (UE % v.this.bTs));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTC = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bHi = true;
                if (v.this.bTA != null) {
                    v.this.bTA.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    v.this.bTB = (int) ((v.this.bTt.getDuration() * i) / 10000);
                    if (v.this.bTu != null) {
                        v.this.bTu.setText(am.fV(v.this.bTB));
                    }
                    if (v.this.feL != null) {
                        v.this.feL.UF();
                    }
                    if (v.this.bTA != null) {
                        v.this.bTA.onProgressChanged(seekBar, v.this.bTB, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bTt.seekTo(v.this.bTB);
                v.this.bHi = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bTA != null) {
                    v.this.bTA.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public v(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTs = 50;
        this.bHi = false;
        this.bTw = true;
        this.bTB = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bHi && v.this.bTw && v.this.bTt != null && v.this.bTt.isPlaying()) {
                            int UE = v.this.UE();
                            if (v.this.feK != null) {
                                v.this.feK.jo(UE);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bTs - (UE % v.this.bTs));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTC = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bHi = true;
                if (v.this.bTA != null) {
                    v.this.bTA.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    v.this.bTB = (int) ((v.this.bTt.getDuration() * i) / 10000);
                    if (v.this.bTu != null) {
                        v.this.bTu.setText(am.fV(v.this.bTB));
                    }
                    if (v.this.feL != null) {
                        v.this.feL.UF();
                    }
                    if (v.this.bTA != null) {
                        v.this.bTA.onProgressChanged(seekBar, v.this.bTB, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bTt.seekTo(v.this.bTB);
                v.this.bHi = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bTA != null) {
                    v.this.bTA.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bTs = 50;
        this.bHi = false;
        this.bTw = true;
        this.bTB = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bHi && v.this.bTw && v.this.bTt != null && v.this.bTt.isPlaying()) {
                            int UE = v.this.UE();
                            if (v.this.feK != null) {
                                v.this.feK.jo(UE);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bTs - (UE % v.this.bTs));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTC = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bHi = true;
                if (v.this.bTA != null) {
                    v.this.bTA.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    v.this.bTB = (int) ((v.this.bTt.getDuration() * i2) / 10000);
                    if (v.this.bTu != null) {
                        v.this.bTu.setText(am.fV(v.this.bTB));
                    }
                    if (v.this.feL != null) {
                        v.this.feL.UF();
                    }
                    if (v.this.bTA != null) {
                        v.this.bTA.onProgressChanged(seekBar, v.this.bTB, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bTt.seekTo(v.this.bTB);
                v.this.bHi = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bTA != null) {
                    v.this.bTA.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bq = bq(context);
        addView(bq, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.bTu = (TextView) bq.findViewById(d.g.textview_cur_time);
        this.bTv = (TextView) bq.findViewById(d.g.textview_duration);
        this.bTx = (SeekBar) bq.findViewById(d.g.pb_video_controller_seekBar);
        this.bTx.setOnSeekBarChangeListener(this.bTC);
    }

    protected View bq(Context context) {
        return LayoutInflater.from(context).inflate(d.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bTt = mediaPlayerControl;
    }

    public void aU(int i, int i2) {
        this.mDuration = i2;
        this.bTw = false;
        this.mHandler.removeMessages(1);
        this.bTx.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bTu != null) {
            this.bTu.setText(am.fV(i));
        }
        if (this.bTv != null) {
            this.bTv.setText(am.fV(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bTt != null) {
            this.bTs = ((this.bTt.getDuration() / 200) / 50) * 50;
            if (this.bTs < 50) {
                this.bTs = 50;
            } else if (this.bTs > 500) {
                this.bTs = 500;
            }
            this.bTw = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bTs - (this.bTt.getCurrentPosition() % this.bTs));
        }
    }

    public void UD() {
        this.bTw = false;
        this.mHandler.removeMessages(1);
        this.bTx.setProgress(0);
        if (this.bTu != null) {
            this.bTu.setText(am.fV(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int UE() {
        if (this.bTt == null || this.bHi) {
            return 0;
        }
        int currentPosition = this.bTt.getCurrentPosition();
        int duration = this.bTt.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bTx != null) {
            if (duration > 0) {
                this.bTx.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bTt.getBufferPercentage();
        }
        if (this.bTu != null) {
            this.bTu.setText(am.fV(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    public void R(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (!z) {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
            }
        } else {
            this.bTt.seekTo(i);
            if (this.bTu != null) {
                this.bTu.setText(am.fV(i));
            }
            showProgress();
        }
        if (!this.bTt.isPlaying()) {
            this.bTx.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String tU(int i) {
        if (i < 0) {
            i = 0;
        }
        return am.fV(i);
    }

    public int getSeekPosition() {
        return this.bTB;
    }

    public int getCurProgress() {
        if (this.bTx != null) {
            return this.bTx.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.feK = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.feL = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bTA = onSeekBarChangeListener;
    }
}

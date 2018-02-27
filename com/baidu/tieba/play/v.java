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
    private boolean bHf;
    private int bTp;
    private MediaController.MediaPlayerControl bTq;
    private TextView bTr;
    private TextView bTs;
    private boolean bTt;
    private SeekBar bTu;
    private SeekBar.OnSeekBarChangeListener bTx;
    private int bTy;
    private SeekBar.OnSeekBarChangeListener bTz;
    private b few;
    private a fex;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void UE();
    }

    /* loaded from: classes.dex */
    public interface b {
        void jo(int i);
    }

    public v(Context context) {
        super(context);
        this.bTp = 50;
        this.bHf = false;
        this.bTt = true;
        this.bTy = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bHf && v.this.bTt && v.this.bTq != null && v.this.bTq.isPlaying()) {
                            int UD = v.this.UD();
                            if (v.this.few != null) {
                                v.this.few.jo(UD);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bTp - (UD % v.this.bTp));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTz = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bHf = true;
                if (v.this.bTx != null) {
                    v.this.bTx.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    v.this.bTy = (int) ((v.this.bTq.getDuration() * i) / 10000);
                    if (v.this.bTr != null) {
                        v.this.bTr.setText(am.fV(v.this.bTy));
                    }
                    if (v.this.fex != null) {
                        v.this.fex.UE();
                    }
                    if (v.this.bTx != null) {
                        v.this.bTx.onProgressChanged(seekBar, v.this.bTy, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bTq.seekTo(v.this.bTy);
                v.this.bHf = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bTx != null) {
                    v.this.bTx.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public v(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTp = 50;
        this.bHf = false;
        this.bTt = true;
        this.bTy = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bHf && v.this.bTt && v.this.bTq != null && v.this.bTq.isPlaying()) {
                            int UD = v.this.UD();
                            if (v.this.few != null) {
                                v.this.few.jo(UD);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bTp - (UD % v.this.bTp));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTz = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bHf = true;
                if (v.this.bTx != null) {
                    v.this.bTx.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    v.this.bTy = (int) ((v.this.bTq.getDuration() * i) / 10000);
                    if (v.this.bTr != null) {
                        v.this.bTr.setText(am.fV(v.this.bTy));
                    }
                    if (v.this.fex != null) {
                        v.this.fex.UE();
                    }
                    if (v.this.bTx != null) {
                        v.this.bTx.onProgressChanged(seekBar, v.this.bTy, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bTq.seekTo(v.this.bTy);
                v.this.bHf = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bTx != null) {
                    v.this.bTx.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bTp = 50;
        this.bHf = false;
        this.bTt = true;
        this.bTy = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bHf && v.this.bTt && v.this.bTq != null && v.this.bTq.isPlaying()) {
                            int UD = v.this.UD();
                            if (v.this.few != null) {
                                v.this.few.jo(UD);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bTp - (UD % v.this.bTp));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTz = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bHf = true;
                if (v.this.bTx != null) {
                    v.this.bTx.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    v.this.bTy = (int) ((v.this.bTq.getDuration() * i2) / 10000);
                    if (v.this.bTr != null) {
                        v.this.bTr.setText(am.fV(v.this.bTy));
                    }
                    if (v.this.fex != null) {
                        v.this.fex.UE();
                    }
                    if (v.this.bTx != null) {
                        v.this.bTx.onProgressChanged(seekBar, v.this.bTy, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bTq.seekTo(v.this.bTy);
                v.this.bHf = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bTx != null) {
                    v.this.bTx.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bq = bq(context);
        addView(bq, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.bTr = (TextView) bq.findViewById(d.g.textview_cur_time);
        this.bTs = (TextView) bq.findViewById(d.g.textview_duration);
        this.bTu = (SeekBar) bq.findViewById(d.g.pb_video_controller_seekBar);
        this.bTu.setOnSeekBarChangeListener(this.bTz);
    }

    protected View bq(Context context) {
        return LayoutInflater.from(context).inflate(d.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bTq = mediaPlayerControl;
    }

    public void aU(int i, int i2) {
        this.mDuration = i2;
        this.bTt = false;
        this.mHandler.removeMessages(1);
        this.bTu.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bTr != null) {
            this.bTr.setText(am.fV(i));
        }
        if (this.bTs != null) {
            this.bTs.setText(am.fV(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bTq != null) {
            this.bTp = ((this.bTq.getDuration() / 200) / 50) * 50;
            if (this.bTp < 50) {
                this.bTp = 50;
            } else if (this.bTp > 500) {
                this.bTp = 500;
            }
            this.bTt = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bTp - (this.bTq.getCurrentPosition() % this.bTp));
        }
    }

    public void UC() {
        this.bTt = false;
        this.mHandler.removeMessages(1);
        this.bTu.setProgress(0);
        if (this.bTr != null) {
            this.bTr.setText(am.fV(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int UD() {
        if (this.bTq == null || this.bHf) {
            return 0;
        }
        int currentPosition = this.bTq.getCurrentPosition();
        int duration = this.bTq.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bTu != null) {
            if (duration > 0) {
                this.bTu.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bTq.getBufferPercentage();
        }
        if (this.bTr != null) {
            this.bTr.setText(am.fV(currentPosition));
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
            this.bTq.seekTo(i);
            if (this.bTr != null) {
                this.bTr.setText(am.fV(i));
            }
            showProgress();
        }
        if (!this.bTq.isPlaying()) {
            this.bTu.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String tU(int i) {
        if (i < 0) {
            i = 0;
        }
        return am.fV(i);
    }

    public int getSeekPosition() {
        return this.bTy;
    }

    public int getCurProgress() {
        if (this.bTu != null) {
            return this.bTu.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.few = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.fex = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bTx = onSeekBarChangeListener;
    }
}

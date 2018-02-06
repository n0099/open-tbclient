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
    private boolean bHs;
    private int bTB;
    private MediaController.MediaPlayerControl bTC;
    private TextView bTD;
    private TextView bTE;
    private boolean bTF;
    private SeekBar bTG;
    private SeekBar.OnSeekBarChangeListener bTJ;
    private int bTK;
    private SeekBar.OnSeekBarChangeListener bTL;
    private b feI;
    private a feJ;
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
        this.bTB = 50;
        this.bHs = false;
        this.bTF = true;
        this.bTK = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bHs && v.this.bTF && v.this.bTC != null && v.this.bTC.isPlaying()) {
                            int UE = v.this.UE();
                            if (v.this.feI != null) {
                                v.this.feI.jo(UE);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bTB - (UE % v.this.bTB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTL = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bHs = true;
                if (v.this.bTJ != null) {
                    v.this.bTJ.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    v.this.bTK = (int) ((v.this.bTC.getDuration() * i) / 10000);
                    if (v.this.bTD != null) {
                        v.this.bTD.setText(am.fV(v.this.bTK));
                    }
                    if (v.this.feJ != null) {
                        v.this.feJ.UF();
                    }
                    if (v.this.bTJ != null) {
                        v.this.bTJ.onProgressChanged(seekBar, v.this.bTK, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bTC.seekTo(v.this.bTK);
                v.this.bHs = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bTJ != null) {
                    v.this.bTJ.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public v(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTB = 50;
        this.bHs = false;
        this.bTF = true;
        this.bTK = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bHs && v.this.bTF && v.this.bTC != null && v.this.bTC.isPlaying()) {
                            int UE = v.this.UE();
                            if (v.this.feI != null) {
                                v.this.feI.jo(UE);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bTB - (UE % v.this.bTB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTL = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bHs = true;
                if (v.this.bTJ != null) {
                    v.this.bTJ.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    v.this.bTK = (int) ((v.this.bTC.getDuration() * i) / 10000);
                    if (v.this.bTD != null) {
                        v.this.bTD.setText(am.fV(v.this.bTK));
                    }
                    if (v.this.feJ != null) {
                        v.this.feJ.UF();
                    }
                    if (v.this.bTJ != null) {
                        v.this.bTJ.onProgressChanged(seekBar, v.this.bTK, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bTC.seekTo(v.this.bTK);
                v.this.bHs = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bTJ != null) {
                    v.this.bTJ.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bTB = 50;
        this.bHs = false;
        this.bTF = true;
        this.bTK = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.v.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!v.this.bHs && v.this.bTF && v.this.bTC != null && v.this.bTC.isPlaying()) {
                            int UE = v.this.UE();
                            if (v.this.feI != null) {
                                v.this.feI.jo(UE);
                            }
                            sendMessageDelayed(obtainMessage(1), v.this.bTB - (UE % v.this.bTB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bTL = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.v.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                v.this.bHs = true;
                if (v.this.bTJ != null) {
                    v.this.bTJ.onStartTrackingTouch(seekBar);
                }
                v.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    v.this.bTK = (int) ((v.this.bTC.getDuration() * i2) / 10000);
                    if (v.this.bTD != null) {
                        v.this.bTD.setText(am.fV(v.this.bTK));
                    }
                    if (v.this.feJ != null) {
                        v.this.feJ.UF();
                    }
                    if (v.this.bTJ != null) {
                        v.this.bTJ.onProgressChanged(seekBar, v.this.bTK, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                v.this.bTC.seekTo(v.this.bTK);
                v.this.bHs = false;
                v.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (v.this.bTJ != null) {
                    v.this.bTJ.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bq = bq(context);
        addView(bq, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.bTD = (TextView) bq.findViewById(d.g.textview_cur_time);
        this.bTE = (TextView) bq.findViewById(d.g.textview_duration);
        this.bTG = (SeekBar) bq.findViewById(d.g.pb_video_controller_seekBar);
        this.bTG.setOnSeekBarChangeListener(this.bTL);
    }

    protected View bq(Context context) {
        return LayoutInflater.from(context).inflate(d.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bTC = mediaPlayerControl;
    }

    public void aU(int i, int i2) {
        this.mDuration = i2;
        this.bTF = false;
        this.mHandler.removeMessages(1);
        this.bTG.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bTD != null) {
            this.bTD.setText(am.fV(i));
        }
        if (this.bTE != null) {
            this.bTE.setText(am.fV(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bTC != null) {
            this.bTB = ((this.bTC.getDuration() / 200) / 50) * 50;
            if (this.bTB < 50) {
                this.bTB = 50;
            } else if (this.bTB > 500) {
                this.bTB = 500;
            }
            this.bTF = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bTB - (this.bTC.getCurrentPosition() % this.bTB));
        }
    }

    public void UD() {
        this.bTF = false;
        this.mHandler.removeMessages(1);
        this.bTG.setProgress(0);
        if (this.bTD != null) {
            this.bTD.setText(am.fV(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int UE() {
        if (this.bTC == null || this.bHs) {
            return 0;
        }
        int currentPosition = this.bTC.getCurrentPosition();
        int duration = this.bTC.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bTG != null) {
            if (duration > 0) {
                this.bTG.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bTC.getBufferPercentage();
        }
        if (this.bTD != null) {
            this.bTD.setText(am.fV(currentPosition));
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
            this.bTC.seekTo(i);
            if (this.bTD != null) {
                this.bTD.setText(am.fV(i));
            }
            showProgress();
        }
        if (!this.bTC.isPlaying()) {
            this.bTG.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String tT(int i) {
        if (i < 0) {
            i = 0;
        }
        return am.fV(i);
    }

    public int getSeekPosition() {
        return this.bTK;
    }

    public int getCurProgress() {
        if (this.bTG != null) {
            return this.bTG.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.feI = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.feJ = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bTJ = onSeekBarChangeListener;
    }
}

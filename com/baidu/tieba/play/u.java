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
public class u extends RelativeLayout {
    private boolean aRi;
    private int bdA;
    private SeekBar.OnSeekBarChangeListener bdB;
    private int bdr;
    private MediaController.MediaPlayerControl bds;
    private TextView bdt;
    private TextView bdu;
    private boolean bdv;
    private SeekBar bdw;
    private SeekBar.OnSeekBarChangeListener bdz;
    private b emj;
    private a emk;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void My();
    }

    /* loaded from: classes.dex */
    public interface b {
        void gx(int i);
    }

    public u(Context context) {
        super(context);
        this.bdr = 50;
        this.aRi = false;
        this.bdv = true;
        this.bdA = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.u.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!u.this.aRi && u.this.bdv && u.this.bds != null && u.this.bds.isPlaying()) {
                            int Mx = u.this.Mx();
                            if (u.this.emj != null) {
                                u.this.emj.gx(Mx);
                            }
                            sendMessageDelayed(obtainMessage(1), u.this.bdr - (Mx % u.this.bdr));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bdB = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.u.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                u.this.aRi = true;
                if (u.this.bdz != null) {
                    u.this.bdz.onStartTrackingTouch(seekBar);
                }
                u.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    u.this.bdA = (int) ((u.this.bds.getDuration() * i) / 10000);
                    if (u.this.bdt != null) {
                        u.this.bdt.setText(am.cY(u.this.bdA));
                    }
                    if (u.this.emk != null) {
                        u.this.emk.My();
                    }
                    if (u.this.bdz != null) {
                        u.this.bdz.onProgressChanged(seekBar, u.this.bdA, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                u.this.bds.seekTo(u.this.bdA);
                u.this.aRi = false;
                u.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (u.this.bdz != null) {
                    u.this.bdz.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public u(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdr = 50;
        this.aRi = false;
        this.bdv = true;
        this.bdA = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.u.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!u.this.aRi && u.this.bdv && u.this.bds != null && u.this.bds.isPlaying()) {
                            int Mx = u.this.Mx();
                            if (u.this.emj != null) {
                                u.this.emj.gx(Mx);
                            }
                            sendMessageDelayed(obtainMessage(1), u.this.bdr - (Mx % u.this.bdr));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bdB = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.u.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                u.this.aRi = true;
                if (u.this.bdz != null) {
                    u.this.bdz.onStartTrackingTouch(seekBar);
                }
                u.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    u.this.bdA = (int) ((u.this.bds.getDuration() * i) / 10000);
                    if (u.this.bdt != null) {
                        u.this.bdt.setText(am.cY(u.this.bdA));
                    }
                    if (u.this.emk != null) {
                        u.this.emk.My();
                    }
                    if (u.this.bdz != null) {
                        u.this.bdz.onProgressChanged(seekBar, u.this.bdA, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                u.this.bds.seekTo(u.this.bdA);
                u.this.aRi = false;
                u.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (u.this.bdz != null) {
                    u.this.bdz.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdr = 50;
        this.aRi = false;
        this.bdv = true;
        this.bdA = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.u.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!u.this.aRi && u.this.bdv && u.this.bds != null && u.this.bds.isPlaying()) {
                            int Mx = u.this.Mx();
                            if (u.this.emj != null) {
                                u.this.emj.gx(Mx);
                            }
                            sendMessageDelayed(obtainMessage(1), u.this.bdr - (Mx % u.this.bdr));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bdB = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.u.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                u.this.aRi = true;
                if (u.this.bdz != null) {
                    u.this.bdz.onStartTrackingTouch(seekBar);
                }
                u.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    u.this.bdA = (int) ((u.this.bds.getDuration() * i2) / 10000);
                    if (u.this.bdt != null) {
                        u.this.bdt.setText(am.cY(u.this.bdA));
                    }
                    if (u.this.emk != null) {
                        u.this.emk.My();
                    }
                    if (u.this.bdz != null) {
                        u.this.bdz.onProgressChanged(seekBar, u.this.bdA, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                u.this.bds.seekTo(u.this.bdA);
                u.this.aRi = false;
                u.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (u.this.bdz != null) {
                    u.this.bdz.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bi = bi(context);
        addView(bi, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.bdt = (TextView) bi.findViewById(d.g.textview_cur_time);
        this.bdu = (TextView) bi.findViewById(d.g.textview_duration);
        this.bdw = (SeekBar) bi.findViewById(d.g.pb_video_controller_seekBar);
        this.bdw.setOnSeekBarChangeListener(this.bdB);
    }

    protected View bi(Context context) {
        return LayoutInflater.from(context).inflate(d.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bds = mediaPlayerControl;
    }

    public void V(int i, int i2) {
        this.mDuration = i2;
        this.bdv = false;
        this.mHandler.removeMessages(1);
        this.bdw.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bdt != null) {
            this.bdt.setText(am.cY(i));
        }
        if (this.bdu != null) {
            this.bdu.setText(am.cY(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bds != null) {
            this.bdr = ((this.bds.getDuration() / 200) / 50) * 50;
            if (this.bdr < 50) {
                this.bdr = 50;
            } else if (this.bdr > 500) {
                this.bdr = 500;
            }
            this.bdv = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bdr - (this.bds.getCurrentPosition() % this.bdr));
        }
    }

    public void Mw() {
        this.bdv = false;
        this.mHandler.removeMessages(1);
        this.bdw.setProgress(0);
        if (this.bdt != null) {
            this.bdt.setText(am.cY(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Mx() {
        if (this.bds == null || this.aRi) {
            return 0;
        }
        int currentPosition = this.bds.getCurrentPosition();
        int duration = this.bds.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bdw != null) {
            if (duration > 0) {
                this.bdw.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bds.getBufferPercentage();
        }
        if (this.bdt != null) {
            this.bdt.setText(am.cY(currentPosition));
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
            this.bds.seekTo(i);
            if (this.bdt != null) {
                this.bdt.setText(am.cY(i));
            }
            showProgress();
        }
        if (!this.bds.isPlaying()) {
            this.bdw.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String sA(int i) {
        if (i < 0) {
            i = 0;
        }
        return am.cY(i);
    }

    public int getSeekPosition() {
        return this.bdA;
    }

    public int getCurProgress() {
        if (this.bdw != null) {
            return this.bdw.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.emj = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.emk = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bdz = onSeekBarChangeListener;
    }
}

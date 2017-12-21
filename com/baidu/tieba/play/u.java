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
    private boolean aRl;
    private SeekBar bdA;
    private SeekBar.OnSeekBarChangeListener bdD;
    private int bdE;
    private SeekBar.OnSeekBarChangeListener bdF;
    private int bdv;
    private MediaController.MediaPlayerControl bdw;
    private TextView bdx;
    private TextView bdy;
    private boolean bdz;
    private b emn;
    private a emo;
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
        this.bdv = 50;
        this.aRl = false;
        this.bdz = true;
        this.bdE = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.u.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!u.this.aRl && u.this.bdz && u.this.bdw != null && u.this.bdw.isPlaying()) {
                            int Mx = u.this.Mx();
                            if (u.this.emn != null) {
                                u.this.emn.gx(Mx);
                            }
                            sendMessageDelayed(obtainMessage(1), u.this.bdv - (Mx % u.this.bdv));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bdF = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.u.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                u.this.aRl = true;
                if (u.this.bdD != null) {
                    u.this.bdD.onStartTrackingTouch(seekBar);
                }
                u.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    u.this.bdE = (int) ((u.this.bdw.getDuration() * i) / 10000);
                    if (u.this.bdx != null) {
                        u.this.bdx.setText(am.cY(u.this.bdE));
                    }
                    if (u.this.emo != null) {
                        u.this.emo.My();
                    }
                    if (u.this.bdD != null) {
                        u.this.bdD.onProgressChanged(seekBar, u.this.bdE, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                u.this.bdw.seekTo(u.this.bdE);
                u.this.aRl = false;
                u.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (u.this.bdD != null) {
                    u.this.bdD.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public u(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdv = 50;
        this.aRl = false;
        this.bdz = true;
        this.bdE = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.u.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!u.this.aRl && u.this.bdz && u.this.bdw != null && u.this.bdw.isPlaying()) {
                            int Mx = u.this.Mx();
                            if (u.this.emn != null) {
                                u.this.emn.gx(Mx);
                            }
                            sendMessageDelayed(obtainMessage(1), u.this.bdv - (Mx % u.this.bdv));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bdF = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.u.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                u.this.aRl = true;
                if (u.this.bdD != null) {
                    u.this.bdD.onStartTrackingTouch(seekBar);
                }
                u.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    u.this.bdE = (int) ((u.this.bdw.getDuration() * i) / 10000);
                    if (u.this.bdx != null) {
                        u.this.bdx.setText(am.cY(u.this.bdE));
                    }
                    if (u.this.emo != null) {
                        u.this.emo.My();
                    }
                    if (u.this.bdD != null) {
                        u.this.bdD.onProgressChanged(seekBar, u.this.bdE, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                u.this.bdw.seekTo(u.this.bdE);
                u.this.aRl = false;
                u.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (u.this.bdD != null) {
                    u.this.bdD.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdv = 50;
        this.aRl = false;
        this.bdz = true;
        this.bdE = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.u.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!u.this.aRl && u.this.bdz && u.this.bdw != null && u.this.bdw.isPlaying()) {
                            int Mx = u.this.Mx();
                            if (u.this.emn != null) {
                                u.this.emn.gx(Mx);
                            }
                            sendMessageDelayed(obtainMessage(1), u.this.bdv - (Mx % u.this.bdv));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bdF = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.u.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                u.this.aRl = true;
                if (u.this.bdD != null) {
                    u.this.bdD.onStartTrackingTouch(seekBar);
                }
                u.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    u.this.bdE = (int) ((u.this.bdw.getDuration() * i2) / 10000);
                    if (u.this.bdx != null) {
                        u.this.bdx.setText(am.cY(u.this.bdE));
                    }
                    if (u.this.emo != null) {
                        u.this.emo.My();
                    }
                    if (u.this.bdD != null) {
                        u.this.bdD.onProgressChanged(seekBar, u.this.bdE, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                u.this.bdw.seekTo(u.this.bdE);
                u.this.aRl = false;
                u.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (u.this.bdD != null) {
                    u.this.bdD.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bi = bi(context);
        addView(bi, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.bdx = (TextView) bi.findViewById(d.g.textview_cur_time);
        this.bdy = (TextView) bi.findViewById(d.g.textview_duration);
        this.bdA = (SeekBar) bi.findViewById(d.g.pb_video_controller_seekBar);
        this.bdA.setOnSeekBarChangeListener(this.bdF);
    }

    protected View bi(Context context) {
        return LayoutInflater.from(context).inflate(d.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bdw = mediaPlayerControl;
    }

    public void V(int i, int i2) {
        this.mDuration = i2;
        this.bdz = false;
        this.mHandler.removeMessages(1);
        this.bdA.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bdx != null) {
            this.bdx.setText(am.cY(i));
        }
        if (this.bdy != null) {
            this.bdy.setText(am.cY(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bdw != null) {
            this.bdv = ((this.bdw.getDuration() / 200) / 50) * 50;
            if (this.bdv < 50) {
                this.bdv = 50;
            } else if (this.bdv > 500) {
                this.bdv = 500;
            }
            this.bdz = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bdv - (this.bdw.getCurrentPosition() % this.bdv));
        }
    }

    public void Mw() {
        this.bdz = false;
        this.mHandler.removeMessages(1);
        this.bdA.setProgress(0);
        if (this.bdx != null) {
            this.bdx.setText(am.cY(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Mx() {
        if (this.bdw == null || this.aRl) {
            return 0;
        }
        int currentPosition = this.bdw.getCurrentPosition();
        int duration = this.bdw.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bdA != null) {
            if (duration > 0) {
                this.bdA.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bdw.getBufferPercentage();
        }
        if (this.bdx != null) {
            this.bdx.setText(am.cY(currentPosition));
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
            this.bdw.seekTo(i);
            if (this.bdx != null) {
                this.bdx.setText(am.cY(i));
            }
            showProgress();
        }
        if (!this.bdw.isPlaying()) {
            this.bdA.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String sA(int i) {
        if (i < 0) {
            i = 0;
        }
        return am.cY(i);
    }

    public int getSeekPosition() {
        return this.bdE;
    }

    public int getCurProgress() {
        if (this.bdA != null) {
            return this.bdA.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.emn = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.emo = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bdD = onSeekBarChangeListener;
    }
}

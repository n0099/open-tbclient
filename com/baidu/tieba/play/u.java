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
    private boolean aRf;
    private SeekBar.OnSeekBarChangeListener bdA;
    private int bdq;
    private MediaController.MediaPlayerControl bdr;
    private TextView bds;
    private TextView bdt;
    private boolean bdu;
    private SeekBar bdv;
    private SeekBar.OnSeekBarChangeListener bdy;
    private int bdz;
    private b ele;
    private a elf;
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
        this.bdq = 50;
        this.aRf = false;
        this.bdu = true;
        this.bdz = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.u.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!u.this.aRf && u.this.bdu && u.this.bdr != null && u.this.bdr.isPlaying()) {
                            int Mx = u.this.Mx();
                            if (u.this.ele != null) {
                                u.this.ele.gx(Mx);
                            }
                            sendMessageDelayed(obtainMessage(1), u.this.bdq - (Mx % u.this.bdq));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bdA = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.u.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                u.this.aRf = true;
                if (u.this.bdy != null) {
                    u.this.bdy.onStartTrackingTouch(seekBar);
                }
                u.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    u.this.bdz = (int) ((u.this.bdr.getDuration() * i) / 10000);
                    if (u.this.bds != null) {
                        u.this.bds.setText(am.cY(u.this.bdz));
                    }
                    if (u.this.elf != null) {
                        u.this.elf.My();
                    }
                    if (u.this.bdy != null) {
                        u.this.bdy.onProgressChanged(seekBar, u.this.bdz, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                u.this.bdr.seekTo(u.this.bdz);
                u.this.aRf = false;
                u.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (u.this.bdy != null) {
                    u.this.bdy.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public u(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdq = 50;
        this.aRf = false;
        this.bdu = true;
        this.bdz = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.u.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!u.this.aRf && u.this.bdu && u.this.bdr != null && u.this.bdr.isPlaying()) {
                            int Mx = u.this.Mx();
                            if (u.this.ele != null) {
                                u.this.ele.gx(Mx);
                            }
                            sendMessageDelayed(obtainMessage(1), u.this.bdq - (Mx % u.this.bdq));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bdA = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.u.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                u.this.aRf = true;
                if (u.this.bdy != null) {
                    u.this.bdy.onStartTrackingTouch(seekBar);
                }
                u.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    u.this.bdz = (int) ((u.this.bdr.getDuration() * i) / 10000);
                    if (u.this.bds != null) {
                        u.this.bds.setText(am.cY(u.this.bdz));
                    }
                    if (u.this.elf != null) {
                        u.this.elf.My();
                    }
                    if (u.this.bdy != null) {
                        u.this.bdy.onProgressChanged(seekBar, u.this.bdz, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                u.this.bdr.seekTo(u.this.bdz);
                u.this.aRf = false;
                u.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (u.this.bdy != null) {
                    u.this.bdy.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdq = 50;
        this.aRf = false;
        this.bdu = true;
        this.bdz = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.u.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!u.this.aRf && u.this.bdu && u.this.bdr != null && u.this.bdr.isPlaying()) {
                            int Mx = u.this.Mx();
                            if (u.this.ele != null) {
                                u.this.ele.gx(Mx);
                            }
                            sendMessageDelayed(obtainMessage(1), u.this.bdq - (Mx % u.this.bdq));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bdA = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.u.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                u.this.aRf = true;
                if (u.this.bdy != null) {
                    u.this.bdy.onStartTrackingTouch(seekBar);
                }
                u.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    u.this.bdz = (int) ((u.this.bdr.getDuration() * i2) / 10000);
                    if (u.this.bds != null) {
                        u.this.bds.setText(am.cY(u.this.bdz));
                    }
                    if (u.this.elf != null) {
                        u.this.elf.My();
                    }
                    if (u.this.bdy != null) {
                        u.this.bdy.onProgressChanged(seekBar, u.this.bdz, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                u.this.bdr.seekTo(u.this.bdz);
                u.this.aRf = false;
                u.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (u.this.bdy != null) {
                    u.this.bdy.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View bl = bl(context);
        addView(bl, -1, (int) context.getResources().getDimension(d.e.ds80));
        this.bds = (TextView) bl.findViewById(d.g.textview_cur_time);
        this.bdt = (TextView) bl.findViewById(d.g.textview_duration);
        this.bdv = (SeekBar) bl.findViewById(d.g.pb_video_controller_seekBar);
        this.bdv.setOnSeekBarChangeListener(this.bdA);
    }

    protected View bl(Context context) {
        return LayoutInflater.from(context).inflate(d.h.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bdr = mediaPlayerControl;
    }

    public void U(int i, int i2) {
        this.mDuration = i2;
        this.bdu = false;
        this.mHandler.removeMessages(1);
        this.bdv.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.bds != null) {
            this.bds.setText(am.cY(i));
        }
        if (this.bdt != null) {
            this.bdt.setText(am.cY(this.mDuration));
        }
    }

    public void showProgress() {
        if (this.bdr != null) {
            this.bdq = ((this.bdr.getDuration() / 200) / 50) * 50;
            if (this.bdq < 50) {
                this.bdq = 50;
            } else if (this.bdq > 500) {
                this.bdq = 500;
            }
            this.bdu = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bdq - (this.bdr.getCurrentPosition() % this.bdq));
        }
    }

    public void Mw() {
        this.bdu = false;
        this.mHandler.removeMessages(1);
        this.bdv.setProgress(0);
        if (this.bds != null) {
            this.bds.setText(am.cY(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Mx() {
        if (this.bdr == null || this.aRf) {
            return 0;
        }
        int currentPosition = this.bdr.getCurrentPosition();
        int duration = this.bdr.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.bdv != null) {
            if (duration > 0) {
                this.bdv.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.bdr.getBufferPercentage();
        }
        if (this.bds != null) {
            this.bds.setText(am.cY(currentPosition));
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
            this.bdr.seekTo(i);
            if (this.bds != null) {
                this.bds.setText(am.cY(i));
            }
            showProgress();
        }
        if (!this.bdr.isPlaying()) {
            this.bdv.setProgress((int) (((i * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public String st(int i) {
        if (i < 0) {
            i = 0;
        }
        return am.cY(i);
    }

    public int getSeekPosition() {
        return this.bdz;
    }

    public int getCurProgress() {
        if (this.bdv != null) {
            return this.bdv.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.ele = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.elf = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.bdy = onSeekBarChangeListener;
    }
}

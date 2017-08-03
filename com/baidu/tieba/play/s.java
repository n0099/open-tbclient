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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class s extends RelativeLayout {
    private int Ii;
    private int aXk;
    private MediaController.MediaPlayerControl aXl;
    private TextView aXm;
    private TextView aXn;
    private boolean aXo;
    private boolean aXp;
    private SeekBar aXq;
    private SeekBar.OnSeekBarChangeListener aXt;
    private int aXu;
    private SeekBar.OnSeekBarChangeListener aXv;
    private b dQL;
    private a dQM;
    private Context mContext;
    private Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void La();
    }

    /* loaded from: classes.dex */
    public interface b {
        void fO(int i);
    }

    public s(Context context) {
        super(context);
        this.aXk = 50;
        this.aXo = false;
        this.aXp = true;
        this.aXu = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aXo && s.this.aXp && s.this.aXl != null && s.this.aXl.isPlaying()) {
                            int KZ = s.this.KZ();
                            if (s.this.dQL != null) {
                                s.this.dQL.fO(KZ);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aXk - (KZ % s.this.aXk));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aXv = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aXo = true;
                if (s.this.aXt != null) {
                    s.this.aXt.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    s.this.aXu = (int) ((s.this.aXl.getDuration() * i) / 10000);
                    if (s.this.aXm != null) {
                        s.this.aXm.setText(al.cX(s.this.aXu));
                    }
                    if (s.this.dQM != null) {
                        s.this.dQM.La();
                    }
                    if (s.this.aXt != null) {
                        s.this.aXt.onProgressChanged(seekBar, s.this.aXu, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aXl.seekTo(s.this.aXu);
                s.this.aXo = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aXt != null) {
                    s.this.aXt.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXk = 50;
        this.aXo = false;
        this.aXp = true;
        this.aXu = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aXo && s.this.aXp && s.this.aXl != null && s.this.aXl.isPlaying()) {
                            int KZ = s.this.KZ();
                            if (s.this.dQL != null) {
                                s.this.dQL.fO(KZ);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aXk - (KZ % s.this.aXk));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aXv = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aXo = true;
                if (s.this.aXt != null) {
                    s.this.aXt.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    s.this.aXu = (int) ((s.this.aXl.getDuration() * i) / 10000);
                    if (s.this.aXm != null) {
                        s.this.aXm.setText(al.cX(s.this.aXu));
                    }
                    if (s.this.dQM != null) {
                        s.this.dQM.La();
                    }
                    if (s.this.aXt != null) {
                        s.this.aXt.onProgressChanged(seekBar, s.this.aXu, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aXl.seekTo(s.this.aXu);
                s.this.aXo = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aXt != null) {
                    s.this.aXt.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public s(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXk = 50;
        this.aXo = false;
        this.aXp = true;
        this.aXu = 0;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!s.this.aXo && s.this.aXp && s.this.aXl != null && s.this.aXl.isPlaying()) {
                            int KZ = s.this.KZ();
                            if (s.this.dQL != null) {
                                s.this.dQL.fO(KZ);
                            }
                            sendMessageDelayed(obtainMessage(1), s.this.aXk - (KZ % s.this.aXk));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aXv = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.s.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                s.this.aXo = true;
                if (s.this.aXt != null) {
                    s.this.aXt.onStartTrackingTouch(seekBar);
                }
                s.this.mHandler.removeMessages(1);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    s.this.aXu = (int) ((s.this.aXl.getDuration() * i2) / 10000);
                    if (s.this.aXm != null) {
                        s.this.aXm.setText(al.cX(s.this.aXu));
                    }
                    if (s.this.dQM != null) {
                        s.this.dQM.La();
                    }
                    if (s.this.aXt != null) {
                        s.this.aXt.onProgressChanged(seekBar, s.this.aXu, z);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                s.this.aXl.seekTo(s.this.aXu);
                s.this.aXo = false;
                s.this.mHandler.sendEmptyMessageDelayed(1, 500L);
                if (s.this.aXt != null) {
                    s.this.aXt.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View ba = ba(context);
        addView(ba, -1, (int) context.getResources().getDimension(d.f.ds80));
        this.aXm = (TextView) ba.findViewById(d.h.textview_cur_time);
        this.aXn = (TextView) ba.findViewById(d.h.textview_duration);
        this.aXq = (SeekBar) ba.findViewById(d.h.pb_video_controller_seekBar);
        this.aXq.setOnSeekBarChangeListener(this.aXv);
    }

    protected View ba(Context context) {
        return LayoutInflater.from(context).inflate(d.j.video_controller, (ViewGroup) null);
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aXl = mediaPlayerControl;
    }

    public void T(int i, int i2) {
        this.Ii = i2;
        this.aXp = false;
        this.mHandler.removeMessages(1);
        this.aXq.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        if (this.aXm != null) {
            this.aXm.setText(al.cX(i));
        }
        if (this.aXn != null) {
            this.aXn.setText(al.cX(this.Ii));
        }
    }

    public void showProgress() {
        if (this.aXl != null) {
            this.aXk = ((this.aXl.getDuration() / 200) / 50) * 50;
            if (this.aXk < 50) {
                this.aXk = 50;
            } else if (this.aXk > 500) {
                this.aXk = 500;
            }
            this.aXp = true;
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.aXk - (this.aXl.getCurrentPosition() % this.aXk));
        }
    }

    public void KY() {
        this.aXp = false;
        this.mHandler.removeMessages(1);
        this.aXq.setProgress(0);
        if (this.aXm != null) {
            this.aXm.setText(al.cX(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int KZ() {
        if (this.aXl == null || this.aXo) {
            return 0;
        }
        int currentPosition = this.aXl.getCurrentPosition();
        int duration = this.aXl.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        if (this.aXq != null) {
            if (duration > 0) {
                this.aXq.setProgress((int) ((10000 * currentPosition) / duration));
            }
            this.aXl.getBufferPercentage();
        }
        if (this.aXm != null) {
            this.aXm.setText(al.cX(currentPosition));
            return currentPosition;
        }
        return currentPosition;
    }

    public void C(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (!z) {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
            }
        } else {
            this.aXl.seekTo(i);
            if (this.aXm != null) {
                this.aXm.setText(al.cX(i));
            }
            showProgress();
        }
        if (!this.aXl.isPlaying()) {
            this.aXq.setProgress((int) (((i * 1.0f) / this.Ii) * 10000.0f));
        }
    }

    public String rC(int i) {
        if (i < 0) {
            i = 0;
        }
        return al.cX(i);
    }

    public int getSeekPosition() {
        return this.aXu;
    }

    public int getCurProgress() {
        if (this.aXq != null) {
            return this.aXq.getProgress();
        }
        return 0;
    }

    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnProgressUpdatedListener(b bVar) {
        this.dQL = bVar;
    }

    public void setOnDragingListener(a aVar) {
        this.dQM = aVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.aXt = onSeekBarChangeListener;
    }
}

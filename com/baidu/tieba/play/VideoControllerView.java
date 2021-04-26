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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes4.dex */
public class VideoControllerView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f20724e;

    /* renamed from: f  reason: collision with root package name */
    public int f20725f;

    /* renamed from: g  reason: collision with root package name */
    public MediaController.MediaPlayerControl f20726g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20727h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f20728i;
    public boolean j;
    public boolean k;
    public SeekBar l;
    public d m;
    public c n;
    public SeekBar.OnSeekBarChangeListener o;
    public int p;
    public int q;
    public Handler r;
    public SeekBar.OnSeekBarChangeListener s;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1 && !VideoControllerView.this.j && VideoControllerView.this.k && VideoControllerView.this.f20726g != null && VideoControllerView.this.f20726g.isPlaying()) {
                int r = VideoControllerView.this.r();
                if (VideoControllerView.this.m != null) {
                    VideoControllerView.this.m.a(r);
                }
                sendMessageDelayed(obtainMessage(1), VideoControllerView.this.f20725f - (r % VideoControllerView.this.f20725f));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z) {
                VideoControllerView.this.q = (int) ((VideoControllerView.this.f20726g.getDuration() * i2) / 10000);
                VideoControllerView videoControllerView = VideoControllerView.this;
                TextView textView = videoControllerView.f20727h;
                if (textView != null) {
                    textView.setText(StringHelper.stringForVideoTime(videoControllerView.q));
                }
                if (VideoControllerView.this.n != null) {
                    VideoControllerView.this.n.a();
                }
                if (VideoControllerView.this.o != null) {
                    VideoControllerView.this.o.onProgressChanged(seekBar, VideoControllerView.this.q, z);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
            VideoControllerView.this.j = true;
            if (VideoControllerView.this.o != null) {
                VideoControllerView.this.o.onStartTrackingTouch(seekBar);
            }
            VideoControllerView.this.r.removeMessages(1);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
            VideoControllerView.this.f20726g.seekTo(VideoControllerView.this.q);
            VideoControllerView.this.j = false;
            VideoControllerView.this.r.sendEmptyMessageDelayed(1, 500L);
            if (VideoControllerView.this.o != null) {
                VideoControllerView.this.o.onStopTrackingTouch(seekBar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(int i2);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.f20725f = 50;
        this.j = false;
        this.k = true;
        this.q = 0;
        this.r = new a(Looper.getMainLooper());
        this.s = new b();
        n(context);
    }

    public int getCurProgress() {
        SeekBar seekBar = this.l;
        if (seekBar != null) {
            return seekBar.getProgress();
        }
        return 0;
    }

    public int getSeekPosition() {
        return this.q;
    }

    public View l(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
    }

    public String m(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        return StringHelper.stringForVideoTime(i2);
    }

    public final void n(Context context) {
        this.f20724e = context;
        View l = l(context);
        addView(l, -1, -2);
        this.f20727h = (TextView) l.findViewById(R.id.textview_cur_time);
        this.f20728i = (TextView) l.findViewById(R.id.textview_duration);
        SeekBar seekBar = (SeekBar) l.findViewById(R.id.pb_video_controller_seekBar);
        this.l = seekBar;
        seekBar.setOnSeekBarChangeListener(this.s);
    }

    public void o(int i2, int i3) {
        this.p = i3;
        this.k = false;
        this.r.removeMessages(1);
        this.l.setProgress((int) (((i2 * 1.0f) / i3) * 10000.0f));
        TextView textView = this.f20727h;
        if (textView != null) {
            textView.setText(StringHelper.stringForVideoTime(i2));
        }
        TextView textView2 = this.f20728i;
        if (textView2 != null) {
            textView2.setText(StringHelper.stringForVideoTime(this.p));
        }
    }

    public void p(int i2) {
        this.p = i2;
        this.k = false;
        this.r.removeMessages(1);
        TextView textView = this.f20728i;
        if (textView != null) {
            textView.setText(StringHelper.stringForVideoTime(this.p));
        }
    }

    public void q() {
        this.k = false;
        this.r.removeMessages(1);
        this.l.setProgress(0);
        TextView textView = this.f20727h;
        if (textView != null) {
            textView.setText(StringHelper.stringForVideoTime(0));
        }
    }

    public int r() {
        int currentPosition;
        MediaController.MediaPlayerControl mediaPlayerControl = this.f20726g;
        if (mediaPlayerControl == null || this.j) {
            return 0;
        }
        int duration = mediaPlayerControl.getDuration();
        MediaController.MediaPlayerControl mediaPlayerControl2 = this.f20726g;
        if (mediaPlayerControl2 instanceof TbCyberVideoView) {
            currentPosition = ((TbCyberVideoView) mediaPlayerControl2).getCurrentPositionSync();
        } else {
            currentPosition = mediaPlayerControl2.getCurrentPosition();
        }
        int i2 = this.p;
        if (i2 <= 0 && duration != i2) {
            this.p = duration;
            TextView textView = this.f20728i;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(duration));
            }
        }
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        SeekBar seekBar = this.l;
        if (seekBar != null) {
            if (duration > 0) {
                seekBar.setProgress((int) ((currentPosition * 10000) / duration));
            }
            this.f20726g.getBufferPercentage();
        }
        TextView textView2 = this.f20727h;
        if (textView2 != null) {
            textView2.setText(StringHelper.stringForVideoTime(currentPosition));
        }
        return currentPosition;
    }

    public void s() {
        MediaController.MediaPlayerControl mediaPlayerControl = this.f20726g;
        if (mediaPlayerControl == null) {
            return;
        }
        int duration = ((mediaPlayerControl.getDuration() / 200) / 50) * 50;
        this.f20725f = duration;
        if (duration < 50) {
            this.f20725f = 50;
        } else if (duration > 500) {
            this.f20725f = 500;
        }
        this.k = true;
        this.r.removeMessages(1);
        Handler handler = this.r;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f20725f - (this.f20726g.getCurrentPosition() % this.f20725f));
    }

    public void setCurrentDuration(int i2, boolean z) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (!z) {
            Handler handler = this.r;
            if (handler != null) {
                handler.removeMessages(1);
            }
        } else {
            this.f20726g.seekTo(i2);
            TextView textView = this.f20727h;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(i2));
            }
            s();
        }
        if (this.f20726g.isPlaying()) {
            return;
        }
        this.l.setProgress((int) (((i2 * 1.0f) / this.p) * 10000.0f));
    }

    public void setOnDragingListener(c cVar) {
        this.n = cVar;
    }

    public void setOnProgressUpdatedListener(d dVar) {
        this.m = dVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.o = onSeekBarChangeListener;
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.f20726g = mediaPlayerControl;
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20725f = 50;
        this.j = false;
        this.k = true;
        this.q = 0;
        this.r = new a(Looper.getMainLooper());
        this.s = new b();
        n(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20725f = 50;
        this.j = false;
        this.k = true;
        this.q = 0;
        this.r = new a(Looper.getMainLooper());
        this.s = new b();
        n(context);
    }
}

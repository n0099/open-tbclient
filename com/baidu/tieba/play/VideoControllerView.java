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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class VideoControllerView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f20406e;

    /* renamed from: f  reason: collision with root package name */
    public int f20407f;

    /* renamed from: g  reason: collision with root package name */
    public MediaController.MediaPlayerControl f20408g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20409h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f20410i;
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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoControllerView f20411a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoControllerView videoControllerView, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerView, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20411a = videoControllerView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && !this.f20411a.j && this.f20411a.k && this.f20411a.f20408g != null && this.f20411a.f20408g.isPlaying()) {
                int r = this.f20411a.r();
                if (this.f20411a.m != null) {
                    this.f20411a.m.a(r);
                }
                sendMessageDelayed(obtainMessage(1), this.f20411a.f20407f - (r % this.f20411a.f20407f));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoControllerView f20412e;

        public b(VideoControllerView videoControllerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20412e = videoControllerView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                this.f20412e.q = (int) ((this.f20412e.f20408g.getDuration() * i2) / 10000);
                VideoControllerView videoControllerView = this.f20412e;
                TextView textView = videoControllerView.f20409h;
                if (textView != null) {
                    textView.setText(StringHelper.stringForVideoTime(videoControllerView.q));
                }
                if (this.f20412e.n != null) {
                    this.f20412e.n.a();
                }
                if (this.f20412e.o != null) {
                    this.f20412e.o.onProgressChanged(seekBar, this.f20412e.q, z);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
                this.f20412e.j = true;
                if (this.f20412e.o != null) {
                    this.f20412e.o.onStartTrackingTouch(seekBar);
                }
                this.f20412e.r.removeMessages(1);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
                this.f20412e.f20408g.seekTo(this.f20412e.q);
                this.f20412e.j = false;
                this.f20412e.r.sendEmptyMessageDelayed(1, 500L);
                if (this.f20412e.o != null) {
                    this.f20412e.o.onStopTrackingTouch(seekBar);
                }
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoControllerView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20407f = 50;
        this.j = false;
        this.k = true;
        this.q = 0;
        this.r = new a(this, Looper.getMainLooper());
        this.s = new b(this);
        n(context);
    }

    public int getCurProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SeekBar seekBar = this.l;
            if (seekBar != null) {
                return seekBar.getProgress();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getSeekPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.q : invokeV.intValue;
    }

    public View l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null) : (View) invokeL.objValue;
    }

    public String m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            return StringHelper.stringForVideoTime(i2);
        }
        return (String) invokeI.objValue;
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.f20406e = context;
            View l = l(context);
            addView(l, -1, -2);
            this.f20409h = (TextView) l.findViewById(R.id.textview_cur_time);
            this.f20410i = (TextView) l.findViewById(R.id.textview_duration);
            SeekBar seekBar = (SeekBar) l.findViewById(R.id.pb_video_controller_seekBar);
            this.l = seekBar;
            seekBar.setOnSeekBarChangeListener(this.s);
        }
    }

    public void o(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            this.p = i3;
            this.k = false;
            this.r.removeMessages(1);
            this.l.setProgress((int) (((i2 * 1.0f) / i3) * 10000.0f));
            TextView textView = this.f20409h;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(i2));
            }
            TextView textView2 = this.f20410i;
            if (textView2 != null) {
                textView2.setText(StringHelper.stringForVideoTime(this.p));
            }
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.p = i2;
            this.k = false;
            this.r.removeMessages(1);
            TextView textView = this.f20410i;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(this.p));
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k = false;
            this.r.removeMessages(1);
            this.l.setProgress(0);
            TextView textView = this.f20409h;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(0));
            }
        }
    }

    public int r() {
        InterceptResult invokeV;
        int currentPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            MediaController.MediaPlayerControl mediaPlayerControl = this.f20408g;
            if (mediaPlayerControl == null || this.j) {
                return 0;
            }
            int duration = mediaPlayerControl.getDuration();
            MediaController.MediaPlayerControl mediaPlayerControl2 = this.f20408g;
            if (mediaPlayerControl2 instanceof TbCyberVideoView) {
                currentPosition = ((TbCyberVideoView) mediaPlayerControl2).getCurrentPositionSync();
            } else {
                currentPosition = mediaPlayerControl2.getCurrentPosition();
            }
            int i2 = this.p;
            if (i2 <= 0 && duration != i2) {
                this.p = duration;
                TextView textView = this.f20410i;
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
                this.f20408g.getBufferPercentage();
            }
            TextView textView2 = this.f20409h;
            if (textView2 != null) {
                textView2.setText(StringHelper.stringForVideoTime(currentPosition));
            }
            return currentPosition;
        }
        return invokeV.intValue;
    }

    public void s() {
        MediaController.MediaPlayerControl mediaPlayerControl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (mediaPlayerControl = this.f20408g) == null) {
            return;
        }
        int duration = ((mediaPlayerControl.getDuration() / 200) / 50) * 50;
        this.f20407f = duration;
        if (duration < 50) {
            this.f20407f = 50;
        } else if (duration > 500) {
            this.f20407f = 500;
        }
        this.k = true;
        this.r.removeMessages(1);
        Handler handler = this.r;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f20407f - (this.f20408g.getCurrentPosition() % this.f20407f));
    }

    public void setCurrentDuration(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            if (!z) {
                Handler handler = this.r;
                if (handler != null) {
                    handler.removeMessages(1);
                }
            } else {
                this.f20408g.seekTo(i2);
                TextView textView = this.f20409h;
                if (textView != null) {
                    textView.setText(StringHelper.stringForVideoTime(i2));
                }
                s();
            }
            if (this.f20408g.isPlaying()) {
                return;
            }
            this.l.setProgress((int) (((i2 * 1.0f) / this.p) * 10000.0f));
        }
    }

    public void setOnDragingListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.n = cVar;
        }
    }

    public void setOnProgressUpdatedListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            this.m = dVar;
        }
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onSeekBarChangeListener) == null) {
            this.o = onSeekBarChangeListener;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, mediaPlayerControl) == null) {
            this.f20408g = mediaPlayerControl;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20407f = 50;
        this.j = false;
        this.k = true;
        this.q = 0;
        this.r = new a(this, Looper.getMainLooper());
        this.s = new b(this);
        n(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoControllerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f20407f = 50;
        this.j = false;
        this.k = true;
        this.q = 0;
        this.r = new a(this, Looper.getMainLooper());
        this.s = new b(this);
        n(context);
    }
}

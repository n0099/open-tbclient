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
import com.baidu.tieba.ck8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class VideoControllerView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public MediaController.MediaPlayerControl b;
    public TextView c;
    public TextView d;
    public boolean e;
    public boolean f;
    public SeekBar g;
    public d h;
    public c i;
    public SeekBar.OnSeekBarChangeListener j;
    public int k;
    public int l;
    public Handler m;
    public SeekBar.OnSeekBarChangeListener n;

    /* loaded from: classes5.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(int i);
    }

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoControllerView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoControllerView videoControllerView, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerView, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoControllerView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && !this.a.e && this.a.f && this.a.b != null && this.a.b.isPlaying()) {
                int o = this.a.o();
                if (this.a.h != null) {
                    this.a.h.a(o);
                }
                sendMessageDelayed(obtainMessage(1), this.a.a - (o % this.a.a));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoControllerView a;

        public b(VideoControllerView videoControllerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoControllerView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                this.a.l(seekBar);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                this.a.m(seekBar);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                this.a.k(seekBar, i, z);
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 50;
        this.e = false;
        this.f = true;
        this.l = 0;
        this.m = new a(this, Looper.getMainLooper());
        this.n = new b(this);
        h(context);
    }

    public void m(SeekBar seekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, seekBar) == null) {
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
            this.b.seekTo(this.l);
            this.e = false;
            this.m.sendEmptyMessageDelayed(1, 500L);
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.j;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onStopTrackingTouch(seekBar);
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 50;
        this.e = false;
        this.f = true;
        this.l = 0;
        this.m = new a(this, Looper.getMainLooper());
        this.n = new b(this);
        h(context);
    }

    public void setCurrentDuration(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i < 0) {
                i = 0;
            }
            if (!z) {
                Handler handler = this.m;
                if (handler != null) {
                    handler.removeMessages(1);
                }
            } else {
                this.b.seekTo(i);
                TextView textView = this.c;
                if (textView != null) {
                    textView.setText(StringHelper.stringForVideoTime(i));
                }
                p();
            }
            if (!this.b.isPlaying()) {
                this.g.setProgress((int) (((i * 1.0f) / this.k) * 10000.0f));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 50;
        this.e = false;
        this.f = true;
        this.l = 0;
        this.m = new a(this, Looper.getMainLooper());
        this.n = new b(this);
        h(context);
    }

    public View f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            return LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null);
        }
        return (View) invokeL.objValue;
    }

    public String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < 0) {
                i = 0;
            }
            return StringHelper.stringForVideoTime(i);
        }
        return (String) invokeI.objValue;
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.k = i;
            this.f = false;
            this.m.removeMessages(1);
            TextView textView = this.d;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(this.k));
            }
        }
    }

    public void setOnDragingListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.i = cVar;
        }
    }

    public void setOnProgressUpdatedListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dVar) == null) {
            this.h = dVar;
        }
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onSeekBarChangeListener) == null) {
            this.j = onSeekBarChangeListener;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, mediaPlayerControl) == null) {
            this.b = mediaPlayerControl;
        }
    }

    public int getCurProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SeekBar seekBar = this.g;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f = false;
            this.m.removeMessages(1);
            this.g.setProgress(0);
            TextView textView = this.c;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(0));
            }
        }
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            View f = f(context);
            addView(f, -1, -2);
            this.c = (TextView) f.findViewById(R.id.textview_cur_time);
            this.d = (TextView) f.findViewById(R.id.textview_duration);
            SeekBar seekBar = (SeekBar) f.findViewById(R.id.pb_video_controller_seekBar);
            this.g = seekBar;
            seekBar.setOnSeekBarChangeListener(this.n);
        }
    }

    public void l(SeekBar seekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, seekBar) == null) {
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
            this.e = true;
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.j;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onStartTrackingTouch(seekBar);
            }
            this.m.removeMessages(1);
        }
    }

    public void i(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            this.k = i2;
            this.f = false;
            this.m.removeMessages(1);
            this.g.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
            TextView textView = this.c;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(i));
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                textView2.setText(StringHelper.stringForVideoTime(this.k));
            }
        }
    }

    public void k(SeekBar seekBar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048583, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || !z) {
            return;
        }
        int duration = (int) ((this.b.getDuration() * i) / 10000);
        this.l = duration;
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(StringHelper.stringForVideoTime(duration));
        }
        c cVar = this.i;
        if (cVar != null) {
            cVar.a();
        }
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.j;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onProgressChanged(seekBar, this.l, z);
        }
    }

    public int o() {
        InterceptResult invokeV;
        int currentPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            MediaController.MediaPlayerControl mediaPlayerControl = this.b;
            if (mediaPlayerControl != null && !this.e) {
                int duration = mediaPlayerControl.getDuration();
                MediaController.MediaPlayerControl mediaPlayerControl2 = this.b;
                if (mediaPlayerControl2 instanceof ck8) {
                    currentPosition = ((ck8) mediaPlayerControl2).getCurrentPositionSync();
                } else {
                    currentPosition = mediaPlayerControl2.getCurrentPosition();
                }
                int i = this.k;
                if (i <= 0 && duration != i) {
                    this.k = duration;
                    TextView textView = this.d;
                    if (textView != null) {
                        textView.setText(StringHelper.stringForVideoTime(duration));
                    }
                }
                if (currentPosition > duration) {
                    currentPosition = duration;
                }
                SeekBar seekBar = this.g;
                if (seekBar != null && duration > 0) {
                    seekBar.setProgress((int) ((currentPosition * 10000) / duration));
                }
                TextView textView2 = this.c;
                if (textView2 != null) {
                    textView2.setText(StringHelper.stringForVideoTime(currentPosition));
                }
                return currentPosition;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void p() {
        MediaController.MediaPlayerControl mediaPlayerControl;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (mediaPlayerControl = this.b) == null) {
            return;
        }
        int duration = ((mediaPlayerControl.getDuration() / 200) / 50) * 50;
        this.a = duration;
        if (duration < 50) {
            this.a = 50;
        } else if (duration > 500) {
            this.a = 500;
        }
        this.f = true;
        this.m.removeMessages(1);
        Handler handler = this.m;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.a - (this.b.getCurrentPosition() % this.a));
    }
}

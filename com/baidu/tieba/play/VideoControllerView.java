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
import c.a.t0.z2.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class VideoControllerView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long PROGRESS_MAX = 10000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f47320e;

    /* renamed from: f  reason: collision with root package name */
    public MediaController.MediaPlayerControl f47321f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47322g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47323h;

    /* renamed from: i  reason: collision with root package name */
    public d f47324i;

    /* renamed from: j  reason: collision with root package name */
    public c f47325j;
    public SeekBar.OnSeekBarChangeListener k;
    public int l;
    public Handler m;
    public int mDuration;
    public SeekBar mProgress;
    public TextView mTextViewCurTime;
    public TextView mTextViewDuration;
    public SeekBar.OnSeekBarChangeListener n;

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && !this.a.f47322g && this.a.f47323h && this.a.f47321f != null && this.a.f47321f.isPlaying()) {
                int progress = this.a.setProgress();
                if (this.a.f47324i != null) {
                    this.a.f47324i.a(progress);
                }
                sendMessageDelayed(obtainMessage(1), this.a.f47320e - (progress % this.a.f47320e));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoControllerView f47326e;

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
            this.f47326e = videoControllerView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                this.f47326e.performOnProgressChanged(seekBar, i2, z);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                this.f47326e.performOnStartTrackingTouch(seekBar);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                this.f47326e.performOnStopTrackingTouch(seekBar);
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes12.dex */
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
        this.f47320e = 50;
        this.f47322g = false;
        this.f47323h = true;
        this.l = 0;
        this.m = new a(this, Looper.getMainLooper());
        this.n = new b(this);
        f(context);
    }

    public void destroy() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (handler = this.m) == null) {
            return;
        }
        handler.removeMessages(1);
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            View layout = getLayout(context);
            addView(layout, -1, -2);
            this.mTextViewCurTime = (TextView) layout.findViewById(R.id.textview_cur_time);
            this.mTextViewDuration = (TextView) layout.findViewById(R.id.textview_duration);
            SeekBar seekBar = (SeekBar) layout.findViewById(R.id.pb_video_controller_seekBar);
            this.mProgress = seekBar;
            seekBar.setOnSeekBarChangeListener(this.n);
        }
    }

    public int getCurProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SeekBar seekBar = this.mProgress;
            if (seekBar != null) {
                return seekBar.getProgress();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public View getLayout(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? LayoutInflater.from(context).inflate(R.layout.video_controller, (ViewGroup) null) : (View) invokeL.objValue;
    }

    public String getProgressTime(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            return StringHelper.stringForVideoTime(i2);
        }
        return (String) invokeI.objValue;
    }

    public int getSeekPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : invokeV.intValue;
    }

    public void initCurTimeAndDuration(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            this.mDuration = i3;
            this.f47323h = false;
            this.m.removeMessages(1);
            this.mProgress.setProgress((int) (((i2 * 1.0f) / i3) * 10000.0f));
            TextView textView = this.mTextViewCurTime;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(i2));
            }
            TextView textView2 = this.mTextViewDuration;
            if (textView2 != null) {
                textView2.setText(StringHelper.stringForVideoTime(this.mDuration));
            }
        }
    }

    public void initDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mDuration = i2;
            this.f47323h = false;
            this.m.removeMessages(1);
            TextView textView = this.mTextViewDuration;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(this.mDuration));
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            SkinManager.setViewTextColor(this.mTextViewCurTime, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.mTextViewDuration, R.color.CAM_X0101, 1);
            this.mProgress.setProgressDrawable(SkinManager.getSkinDrawable(null, R.drawable.video_seekbar));
            this.mProgress.setThumb(SkinManager.getSkinDrawable(null, R.drawable.video_seekbar_thumb));
            this.mProgress.setThumbOffset(0);
        }
    }

    public void performOnProgressChanged(SeekBar seekBar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
            int duration = (int) ((this.f47321f.getDuration() * i2) / 10000);
            this.l = duration;
            TextView textView = this.mTextViewCurTime;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(duration));
            }
            c cVar = this.f47325j;
            if (cVar != null) {
                cVar.a();
            }
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.k;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onProgressChanged(seekBar, this.l, z);
            }
        }
    }

    public void performOnStartTrackingTouch(SeekBar seekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, seekBar) == null) {
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
            this.f47322g = true;
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.k;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onStartTrackingTouch(seekBar);
            }
            this.m.removeMessages(1);
        }
    }

    public void performOnStopTrackingTouch(SeekBar seekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, seekBar) == null) {
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
            this.f47321f.seekTo(this.l);
            this.f47322g = false;
            this.m.sendEmptyMessageDelayed(1, 500L);
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.k;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onStopTrackingTouch(seekBar);
            }
        }
    }

    public void resetProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f47323h = false;
            this.m.removeMessages(1);
            this.mProgress.setProgress(0);
            TextView textView = this.mTextViewCurTime;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(0));
            }
        }
    }

    public void setCurrentDuration(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            if (!z) {
                Handler handler = this.m;
                if (handler != null) {
                    handler.removeMessages(1);
                }
            } else {
                this.f47321f.seekTo(i2);
                TextView textView = this.mTextViewCurTime;
                if (textView != null) {
                    textView.setText(StringHelper.stringForVideoTime(i2));
                }
                showProgress();
            }
            if (this.f47321f.isPlaying()) {
                return;
            }
            this.mProgress.setProgress((int) (((i2 * 1.0f) / this.mDuration) * 10000.0f));
        }
    }

    public void setOnDragingListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.f47325j = cVar;
        }
    }

    public void setOnProgressUpdatedListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dVar) == null) {
            this.f47324i = dVar;
        }
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onSeekBarChangeListener) == null) {
            this.k = onSeekBarChangeListener;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, mediaPlayerControl) == null) {
            this.f47321f = mediaPlayerControl;
        }
    }

    public int setProgress() {
        InterceptResult invokeV;
        int currentPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            MediaController.MediaPlayerControl mediaPlayerControl = this.f47321f;
            if (mediaPlayerControl == null || this.f47322g) {
                return 0;
            }
            int duration = mediaPlayerControl.getDuration();
            MediaController.MediaPlayerControl mediaPlayerControl2 = this.f47321f;
            if (mediaPlayerControl2 instanceof g) {
                currentPosition = ((g) mediaPlayerControl2).getCurrentPositionSync();
            } else {
                currentPosition = mediaPlayerControl2.getCurrentPosition();
            }
            int i2 = this.mDuration;
            if (i2 <= 0 && duration != i2) {
                this.mDuration = duration;
                TextView textView = this.mTextViewDuration;
                if (textView != null) {
                    textView.setText(StringHelper.stringForVideoTime(duration));
                }
            }
            if (currentPosition > duration) {
                currentPosition = duration;
            }
            SeekBar seekBar = this.mProgress;
            if (seekBar != null && duration > 0) {
                seekBar.setProgress((int) ((currentPosition * 10000) / duration));
            }
            TextView textView2 = this.mTextViewCurTime;
            if (textView2 != null) {
                textView2.setText(StringHelper.stringForVideoTime(currentPosition));
            }
            return currentPosition;
        }
        return invokeV.intValue;
    }

    public void showProgress() {
        MediaController.MediaPlayerControl mediaPlayerControl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (mediaPlayerControl = this.f47321f) == null) {
            return;
        }
        int duration = ((mediaPlayerControl.getDuration() / 200) / 50) * 50;
        this.f47320e = duration;
        if (duration < 50) {
            this.f47320e = 50;
        } else if (duration > 500) {
            this.f47320e = 500;
        }
        this.f47323h = true;
        this.m.removeMessages(1);
        Handler handler = this.m;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f47320e - (this.f47321f.getCurrentPosition() % this.f47320e));
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
        this.f47320e = 50;
        this.f47322g = false;
        this.f47323h = true;
        this.l = 0;
        this.m = new a(this, Looper.getMainLooper());
        this.n = new b(this);
        f(context);
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
        this.f47320e = 50;
        this.f47322g = false;
        this.f47323h = true;
        this.l = 0;
        this.m = new a(this, Looper.getMainLooper());
        this.n = new b(this);
        f(context);
    }
}

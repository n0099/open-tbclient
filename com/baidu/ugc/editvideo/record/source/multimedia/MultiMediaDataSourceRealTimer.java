package com.baidu.ugc.editvideo.record.source.multimedia;

import android.animation.Animator;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.mx9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class MultiMediaDataSourceRealTimer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer";
    public static final AtomicInteger nextSerialNumber;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable animatorCancelRunnable;
    public Runnable animatorEndRunnable;
    public Runnable animatorStartRunnable;
    public volatile boolean isStart;
    public volatile Animator.AnimatorListener mAnimatorAdapter;
    public long mBeginTime;
    public long mCurrentPlayTime;
    public long mDuration;
    public int mFrameRate;
    public Handler mJobHandler;
    public Timer mTimer;
    public TimerTask mTimerTask;
    public volatile AnimatorUpdateListener mUpdateListener;
    public Runnable resetRunnable;
    public Runnable startRunnable;
    public Runnable stopRunnable;

    /* loaded from: classes7.dex */
    public interface AnimatorUpdateListener {
        void onAnimationUpdate(long j);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1230285608, "Lcom/baidu/ugc/editvideo/record/source/multimedia/MultiMediaDataSourceRealTimer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1230285608, "Lcom/baidu/ugc/editvideo/record/source/multimedia/MultiMediaDataSourceRealTimer;");
                return;
            }
        }
        nextSerialNumber = new AtomicInteger(0);
    }

    public MultiMediaDataSourceRealTimer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFrameRate = 30;
        this.animatorStartRunnable = new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MultiMediaDataSourceRealTimer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mAnimatorAdapter == null) {
                    return;
                }
                this.this$0.mAnimatorAdapter.onAnimationStart(null);
            }
        };
        this.animatorCancelRunnable = new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MultiMediaDataSourceRealTimer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.innerStop();
                }
            }
        };
        this.animatorEndRunnable = new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MultiMediaDataSourceRealTimer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mAnimatorAdapter == null) {
                    return;
                }
                this.this$0.mAnimatorAdapter.onAnimationEnd(null);
            }
        };
        this.stopRunnable = new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MultiMediaDataSourceRealTimer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.innerStop();
                }
            }
        };
        this.resetRunnable = new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MultiMediaDataSourceRealTimer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.innerReset();
                }
            }
        };
        this.startRunnable = new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MultiMediaDataSourceRealTimer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.innerStart();
                }
            }
        };
        this.mJobHandler = new Handler(this, MultiMediaDataSourceTimerManager.getInstance().getTimerLooper()) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MultiMediaDataSourceRealTimer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    super.handleMessage(message);
                    if (message.what == 0) {
                        Object obj = message.obj;
                        if (this.this$0.mUpdateListener == null || !(obj instanceof Long)) {
                            return;
                        }
                        this.this$0.mUpdateListener.onAnimationUpdate(((Long) obj).longValue());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerReset() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65552, this) == null) && this.isStart) {
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer = null;
            }
            TimerTask timerTask = this.mTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
                this.mTimerTask = null;
            }
            this.mAnimatorAdapter = null;
            this.mUpdateListener = null;
            this.isStart = false;
            this.mCurrentPlayTime = 0L;
            this.mBeginTime = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerStart() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || this.isStart) {
            return;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer(TAG + "-" + serialNumber());
        }
        this.mTimerTask = new TimerTask(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MultiMediaDataSourceRealTimer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.this$0.mBeginTime == 0) {
                        String str = MultiMediaDataSourceRealTimer.TAG;
                        mx9.a(str, "TimerTask thread : " + Thread.currentThread().getName());
                        this.this$0.mBeginTime = currentTimeMillis;
                    }
                    long j = currentTimeMillis + this.this$0.mCurrentPlayTime;
                    if (j == this.this$0.mBeginTime + this.this$0.mCurrentPlayTime) {
                        this.this$0.mJobHandler.post(this.this$0.animatorStartRunnable);
                    }
                    if (j - this.this$0.mBeginTime < this.this$0.mDuration) {
                        Message obtain = Message.obtain();
                        obtain.what = 0;
                        obtain.obj = Long.valueOf(j - this.this$0.mBeginTime);
                        this.this$0.mJobHandler.sendMessage(obtain);
                        return;
                    }
                    Message obtain2 = Message.obtain();
                    obtain2.what = 0;
                    obtain2.obj = Long.valueOf(this.this$0.mDuration);
                    this.this$0.mJobHandler.sendMessage(obtain2);
                    this.this$0.mJobHandler.post(this.this$0.animatorEndRunnable);
                    this.this$0.mJobHandler.post(this.this$0.animatorCancelRunnable);
                }
            }
        };
        this.mBeginTime = 0L;
        this.mTimer.purge();
        this.mTimer.schedule(this.mTimerTask, 0L, 1000.0f / this.mFrameRate);
        this.isStart = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerStop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && this.isStart) {
            TimerTask timerTask = this.mTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
            }
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.purge();
            }
            this.isStart = false;
        }
    }

    public static int serialNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? nextSerialNumber.getAndIncrement() : invokeV.intValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.mTimer == null || this.mTimerTask == null || !this.isStart) ? false : true : invokeV.booleanValue;
    }

    public void lockTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mJobHandler.post(this.resetRunnable);
        }
    }

    public void setAnimatorListenerAdapter(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, animatorListener) == null) {
            this.mAnimatorAdapter = animatorListener;
        }
    }

    public void setCurrentPlayTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.mCurrentPlayTime = j;
        }
    }

    public void setDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.mDuration = j;
        }
    }

    public void setFrameRate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.mFrameRate = i;
        }
    }

    public void setUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, animatorUpdateListener) == null) {
            this.mUpdateListener = animatorUpdateListener;
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mJobHandler.post(this.startRunnable);
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mJobHandler.post(this.stopRunnable);
        }
    }

    public void unLockTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }
}

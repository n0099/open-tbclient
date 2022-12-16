package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.media.video.view.MediaGestureMode;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class rl4 extends GestureDetector.SimpleOnGestureListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final GestureDetector b;
    public sl4 c;
    public MediaGestureMode d;
    public int e;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-457197838, "Lcom/baidu/tieba/rl4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-457197838, "Lcom/baidu/tieba/rl4$a;");
                    return;
                }
            }
            int[] iArr = new int[MediaGestureMode.values().length];
            a = iArr;
            try {
                iArr[MediaGestureMode.VOLUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MediaGestureMode.BRIGHTNESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MediaGestureMode.FAST_FORWARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948125455, "Lcom/baidu/tieba/rl4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948125455, "Lcom/baidu/tieba/rl4;");
                return;
            }
        }
        f = ok1.a;
    }

    public rl4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = MediaGestureMode.INTI;
        this.a = context;
        this.b = new GestureDetector(context, this);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (f) {
                Log.d("MediaGestureDetector", "onDoubleTap:" + motionEvent);
            }
            sl4 sl4Var = this.c;
            if (sl4Var != null) {
                return sl4Var.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (f) {
                Log.d("MediaGestureDetector", "onDown:" + motionEvent);
            }
            this.d = MediaGestureMode.INTI;
            sl4 sl4Var = this.c;
            if (sl4Var != null) {
                return sl4Var.onDown(motionEvent);
            }
            return super.onDown(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            if (f) {
                Log.d("MediaGestureDetector", "onSingleTapUp:" + motionEvent);
            }
            sl4 sl4Var = this.c;
            if (sl4Var != null) {
                return sl4Var.a(motionEvent);
            }
            return super.onSingleTapUp(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        sl4 sl4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 1 && (sl4Var = this.c) != null) {
                sl4Var.b(motionEvent, this.d);
            }
            return this.b.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.e = i;
        }
    }

    public void d(sl4 sl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sl4Var) == null) {
            this.c = sl4Var;
        }
    }

    public final MediaGestureMode b(MediaGestureMode mediaGestureMode, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{mediaGestureMode, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (mediaGestureMode == MediaGestureMode.INTI) {
                if (Math.abs(f3) - Math.abs(f4) > 3.0f) {
                    mediaGestureMode = MediaGestureMode.FAST_FORWARD;
                    if (f) {
                        Log.d("MediaGestureDetector", "horizontal slide");
                    }
                } else if (f2 <= this.e / 2) {
                    mediaGestureMode = MediaGestureMode.BRIGHTNESS;
                    if (f) {
                        Log.d("MediaGestureDetector", "brightness slide");
                    }
                } else {
                    mediaGestureMode = MediaGestureMode.VOLUME;
                    if (f) {
                        Log.d("MediaGestureDetector", "volume slide");
                    }
                }
            }
            return mediaGestureMode;
        }
        return (MediaGestureMode) invokeCommon.objValue;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f) {
                Log.d("MediaGestureDetector", "onScroll:" + motionEvent + " e2:" + motionEvent2 + " distanceX:" + f2 + " distanceY:" + f3);
            }
            if (this.c == null) {
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            MediaGestureMode b = b(this.d, motionEvent.getX(), f2, f3);
            this.d = b;
            int i = a.a[b.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return this.c.d(motionEvent, motionEvent2, f2, f3);
                }
                return this.c.e(motionEvent, motionEvent2, f2, f3);
            }
            return this.c.c(motionEvent, motionEvent2, f2, f3);
        }
        return invokeCommon.booleanValue;
    }
}

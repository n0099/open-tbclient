package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.info.XDeviceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.http.client.methods.HttpDelete;
/* loaded from: classes7.dex */
public class ProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f57339e;

    /* renamed from: f  reason: collision with root package name */
    public int f57340f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f57341g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f57342h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f57343i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f57344j;
    public Paint k;
    public float l;
    public float m;
    public LinkedList<Integer> n;
    public float o;
    public volatile State p;
    public boolean q;
    public float r;
    public float s;
    public float t;
    public long u;
    public long v;
    public long w;
    public long x;
    public long y;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final State DELETE;
        public static final State PAUSE;
        public static final State ROLLBACK;
        public static final State START;
        public transient /* synthetic */ FieldHolder $fh;
        public int mIntValue;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1802369376, "Lcom/baidu/tieba/video/record/ProgressView$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1802369376, "Lcom/baidu/tieba/video/record/ProgressView$State;");
                    return;
                }
            }
            START = new State("START", 0, 1);
            PAUSE = new State(XDeviceInfo.ABILITY_PAUSE, 1, 2);
            ROLLBACK = new State("ROLLBACK", 2, 3);
            State state = new State(HttpDelete.METHOD_NAME, 3, 4);
            DELETE = state;
            $VALUES = new State[]{START, PAUSE, ROLLBACK, state};
        }

        public State(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mIntValue = i3;
        }

        public static State mapIntToValue(int i2) {
            InterceptResult invokeI;
            State[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                for (State state : values()) {
                    if (i2 == state.getIntValue()) {
                        return state;
                    }
                }
                return PAUSE;
            }
            return (State) invokeI.objValue;
        }

        public static State valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (State) Enum.valueOf(State.class, str) : (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (State[]) $VALUES.clone() : (State[]) invokeV.objValue;
        }

        public int getIntValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIntValue : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressView(Context context) {
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
        this.n = new LinkedList<>();
        this.o = 0.0f;
        this.p = State.PAUSE;
        this.q = true;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = 0.0f;
        this.v = 0L;
        this.w = 0L;
        this.x = 0L;
        this.y = 0L;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f57341g = new Paint();
            this.f57342h = new Paint();
            this.f57343i = new Paint();
            this.k = new Paint();
            this.f57344j = new Paint();
            setBackgroundColor(Color.parseColor("#FFFFFF"));
            this.f57341g.setStyle(Paint.Style.FILL);
            this.f57341g.setColor(Color.parseColor("#33aaff"));
            this.f57342h.setStyle(Paint.Style.FILL);
            this.f57342h.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
            this.f57343i.setStyle(Paint.Style.FILL);
            this.f57343i.setColor(Color.parseColor("#FFFFFF"));
            this.k.setStyle(Paint.Style.FILL);
            this.k.setColor(Color.parseColor("#e53917"));
            this.f57344j.setStyle(Paint.Style.FILL);
            this.f57344j.setColor(Color.parseColor("#33aaff"));
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float f2 = displayMetrics.widthPixels / 15000.0f;
            this.o = f2;
            this.t = f2;
        }
    }

    public State getCurrentState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p : (State) invokeV.objValue;
    }

    public int getLastProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LinkedList<Integer> linkedList = this.n;
            if (linkedList == null || linkedList.isEmpty()) {
                return 0;
            }
            return this.n.getLast().intValue();
        }
        return invokeV.intValue;
    }

    public LinkedList<Integer> getTimeList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : (LinkedList) invokeV.objValue;
    }

    public boolean isProgressListEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n.isEmpty() : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.u == 0) {
                this.u = System.currentTimeMillis();
            }
            if (this.y == 0) {
                this.y = getHeight();
            }
            long j2 = this.y;
            this.l = (float) j2;
            this.m = (float) ((j2 * 1) / 3);
            long currentTimeMillis = System.currentTimeMillis();
            this.r = 0.0f;
            if (!this.n.isEmpty()) {
                Iterator<Integer> it = this.n.iterator();
                long j3 = 0;
                while (it.hasNext()) {
                    this.w = j3;
                    long intValue = it.next().intValue();
                    this.x = intValue;
                    float f2 = this.r;
                    float f3 = (((float) (intValue - j3)) * this.o) + f2;
                    this.r = f3;
                    float f4 = f3 - this.m;
                    if (f4 < 1.0f) {
                        f4 = 1.0f;
                    }
                    float f5 = f4;
                    canvas.drawRect(f2, 0.0f, f5, (float) (this.y - 1), this.f57341g);
                    canvas.drawRect(f5, 0.0f, this.r, (float) (this.y - 1), this.f57343i);
                    j3 = intValue;
                }
                if (this.n.getLast().intValue() <= 3000.0f) {
                    float f6 = this.o;
                    canvas.drawRect(f6 * 3000.0f, 0.0f, (f6 * 3000.0f) + this.l, (float) (this.y - 1), this.f57342h);
                }
            } else {
                float f7 = this.o;
                canvas.drawRect(f7 * 3000.0f, 0.0f, (f7 * 3000.0f) + this.l, (float) (this.y - 1), this.f57342h);
            }
            if (this.p == State.ROLLBACK) {
                float f8 = this.r;
                canvas.drawRect(f8 - (((float) (this.x - this.w)) * this.o), 0.0f, f8, (float) this.y, this.k);
            }
            if (this.p == State.START) {
                float f9 = this.s + (this.t * ((float) (currentTimeMillis - this.u)));
                this.s = f9;
                float f10 = this.r + f9;
                if (f10 <= getMeasuredWidth()) {
                    float f11 = this.r;
                    canvas.drawRect(f11, 0.0f, f11 + this.s, (float) (this.y - 1), this.f57341g);
                } else {
                    canvas.drawRect(this.r, 0.0f, getMeasuredWidth(), (float) (this.y - 1), this.f57341g);
                }
                float f12 = f10 - 5.0f;
                long j4 = this.y;
                canvas.drawRect(f12, 0.0f, f12 + ((float) j4), (float) (j4 - 1), this.f57344j);
                if (this.f57339e != null) {
                    int measuredWidth = (int) ((f10 / getMeasuredWidth()) * 100.0f);
                    i2 = measuredWidth <= 100 ? measuredWidth : 100;
                    if (i2 != this.f57340f) {
                        this.f57340f = i2;
                        this.f57339e.a(i2);
                    }
                }
            } else {
                if (this.f57339e != null) {
                    int measuredWidth2 = (int) ((this.r / getMeasuredWidth()) * 100.0f);
                    i2 = measuredWidth2 <= 100 ? measuredWidth2 : 100;
                    if (i2 != this.f57340f) {
                        this.f57340f = i2;
                        this.f57339e.a(i2);
                    }
                }
                long j5 = this.v;
                if (j5 == 0 || currentTimeMillis - j5 >= 800) {
                    this.q = !this.q;
                    this.v = System.currentTimeMillis();
                }
                if (this.q) {
                    float f13 = this.r;
                    long j6 = this.y;
                    canvas.drawRect(f13 - 5.0f, 0.0f, (f13 - 5.0f) + ((float) j6), (float) (j6 - 1), this.f57344j);
                }
            }
            this.u = System.currentTimeMillis();
            invalidate();
        }
    }

    public void putProgressList(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.n.add(Integer.valueOf(i2));
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.n.clear();
            this.p = State.PAUSE;
            this.n.clear();
            this.r = 0.0f;
            this.u = 0L;
            this.w = 0L;
            this.x = 0L;
            this.f57340f = 0;
            this.v = 0L;
        }
    }

    public void setCurrentState(State state) {
        LinkedList<Integer> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, state) == null) {
            this.p = state;
            if (state != State.START) {
                this.s = this.t;
            }
            if (state != State.DELETE || (linkedList = this.n) == null || linkedList.isEmpty()) {
                return;
            }
            this.n.removeLast();
        }
    }

    public void setListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.f57339e = aVar;
        }
    }

    public void setPaintHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.y = i2;
        }
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, linkedList) == null) || linkedList == null || linkedList.size() <= 0) {
            return;
        }
        this.n = linkedList;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressView(Context context, AttributeSet attributeSet) {
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
        this.n = new LinkedList<>();
        this.o = 0.0f;
        this.p = State.PAUSE;
        this.q = true;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = 0.0f;
        this.v = 0L;
        this.w = 0L;
        this.x = 0L;
        this.y = 0L;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressView(Context context, AttributeSet attributeSet, int i2) {
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
        this.n = new LinkedList<>();
        this.o = 0.0f;
        this.p = State.PAUSE;
        this.q = true;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = 0.0f;
        this.v = 0L;
        this.w = 0L;
        this.x = 0L;
        this.y = 0L;
        a(context);
    }
}

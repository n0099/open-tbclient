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
/* loaded from: classes6.dex */
public class ProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public int f36482b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f36483c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f36484d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f36485e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f36486f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f36487g;

    /* renamed from: h  reason: collision with root package name */
    public float f36488h;
    public float i;
    public LinkedList<Integer> j;
    public float k;
    public volatile State l;
    public boolean m;
    public float n;
    public float o;
    public float p;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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
            PAUSE = new State("PAUSE", 1, 2);
            ROLLBACK = new State("ROLLBACK", 2, 3);
            State state = new State(HttpDelete.METHOD_NAME, 3, 4);
            DELETE = state;
            $VALUES = new State[]{START, PAUSE, ROLLBACK, state};
        }

        public State(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mIntValue = i2;
        }

        public static State mapIntToValue(int i) {
            InterceptResult invokeI;
            State[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                for (State state : values()) {
                    if (i == state.getIntValue()) {
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

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new LinkedList<>();
        this.k = 0.0f;
        this.l = State.PAUSE;
        this.m = true;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.r = 0L;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f36483c = new Paint();
            this.f36484d = new Paint();
            this.f36485e = new Paint();
            this.f36487g = new Paint();
            this.f36486f = new Paint();
            setBackgroundColor(Color.parseColor("#FFFFFF"));
            this.f36483c.setStyle(Paint.Style.FILL);
            this.f36483c.setColor(Color.parseColor("#33aaff"));
            this.f36484d.setStyle(Paint.Style.FILL);
            this.f36484d.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
            this.f36485e.setStyle(Paint.Style.FILL);
            this.f36485e.setColor(Color.parseColor("#FFFFFF"));
            this.f36487g.setStyle(Paint.Style.FILL);
            this.f36487g.setColor(Color.parseColor("#e53917"));
            this.f36486f.setStyle(Paint.Style.FILL);
            this.f36486f.setColor(Color.parseColor("#33aaff"));
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float f2 = displayMetrics.widthPixels / 15000.0f;
            this.k = f2;
            this.p = f2;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j.isEmpty() : invokeV.booleanValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.j.add(Integer.valueOf(i));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j.clear();
            this.l = State.PAUSE;
            this.j.clear();
            this.n = 0.0f;
            this.q = 0L;
            this.s = 0L;
            this.t = 0L;
            this.f36482b = 0;
            this.r = 0L;
        }
    }

    public State getCurrentState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : (State) invokeV.objValue;
    }

    public int getLastProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinkedList<Integer> linkedList = this.j;
            if (linkedList == null || linkedList.isEmpty()) {
                return 0;
            }
            return this.j.getLast().intValue();
        }
        return invokeV.intValue;
    }

    public LinkedList<Integer> getTimeList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : (LinkedList) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.q == 0) {
                this.q = System.currentTimeMillis();
            }
            if (this.u == 0) {
                this.u = getHeight();
            }
            long j = this.u;
            this.f36488h = (float) j;
            this.i = (float) ((j * 1) / 3);
            long currentTimeMillis = System.currentTimeMillis();
            this.n = 0.0f;
            if (!this.j.isEmpty()) {
                Iterator<Integer> it = this.j.iterator();
                long j2 = 0;
                while (it.hasNext()) {
                    this.s = j2;
                    long intValue = it.next().intValue();
                    this.t = intValue;
                    float f2 = this.n;
                    float f3 = (((float) (intValue - j2)) * this.k) + f2;
                    this.n = f3;
                    float f4 = f3 - this.i;
                    if (f4 < 1.0f) {
                        f4 = 1.0f;
                    }
                    float f5 = f4;
                    canvas.drawRect(f2, 0.0f, f5, (float) (this.u - 1), this.f36483c);
                    canvas.drawRect(f5, 0.0f, this.n, (float) (this.u - 1), this.f36485e);
                    j2 = intValue;
                }
                if (this.j.getLast().intValue() <= 3000.0f) {
                    float f6 = this.k;
                    canvas.drawRect(f6 * 3000.0f, 0.0f, (f6 * 3000.0f) + this.f36488h, (float) (this.u - 1), this.f36484d);
                }
            } else {
                float f7 = this.k;
                canvas.drawRect(f7 * 3000.0f, 0.0f, (f7 * 3000.0f) + this.f36488h, (float) (this.u - 1), this.f36484d);
            }
            if (this.l == State.ROLLBACK) {
                float f8 = this.n;
                canvas.drawRect(f8 - (((float) (this.t - this.s)) * this.k), 0.0f, f8, (float) this.u, this.f36487g);
            }
            if (this.l == State.START) {
                float f9 = this.o + (this.p * ((float) (currentTimeMillis - this.q)));
                this.o = f9;
                float f10 = this.n + f9;
                if (f10 <= getMeasuredWidth()) {
                    float f11 = this.n;
                    canvas.drawRect(f11, 0.0f, f11 + this.o, (float) (this.u - 1), this.f36483c);
                } else {
                    canvas.drawRect(this.n, 0.0f, getMeasuredWidth(), (float) (this.u - 1), this.f36483c);
                }
                float f12 = f10 - 5.0f;
                long j3 = this.u;
                canvas.drawRect(f12, 0.0f, f12 + ((float) j3), (float) (j3 - 1), this.f36486f);
                if (this.a != null) {
                    int measuredWidth = (int) ((f10 / getMeasuredWidth()) * 100.0f);
                    i = measuredWidth <= 100 ? measuredWidth : 100;
                    if (i != this.f36482b) {
                        this.f36482b = i;
                        this.a.a(i);
                    }
                }
            } else {
                if (this.a != null) {
                    int measuredWidth2 = (int) ((this.n / getMeasuredWidth()) * 100.0f);
                    i = measuredWidth2 <= 100 ? measuredWidth2 : 100;
                    if (i != this.f36482b) {
                        this.f36482b = i;
                        this.a.a(i);
                    }
                }
                long j4 = this.r;
                if (j4 == 0 || currentTimeMillis - j4 >= 800) {
                    this.m = !this.m;
                    this.r = System.currentTimeMillis();
                }
                if (this.m) {
                    float f13 = this.n;
                    long j5 = this.u;
                    canvas.drawRect(f13 - 5.0f, 0.0f, (f13 - 5.0f) + ((float) j5), (float) (j5 - 1), this.f36486f);
                }
            }
            this.q = System.currentTimeMillis();
            invalidate();
        }
    }

    public void setCurrentState(State state) {
        LinkedList<Integer> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, state) == null) {
            this.l = state;
            if (state != State.START) {
                this.o = this.p;
            }
            if (state != State.DELETE || (linkedList = this.j) == null || linkedList.isEmpty()) {
                return;
            }
            this.j.removeLast();
        }
    }

    public void setListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.a = aVar;
        }
    }

    public void setPaintHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.u = i;
        }
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, linkedList) == null) || linkedList == null || linkedList.size() <= 0) {
            return;
        }
        this.j = linkedList;
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
        this.j = new LinkedList<>();
        this.k = 0.0f;
        this.l = State.PAUSE;
        this.m = true;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.r = 0L;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressView(Context context, AttributeSet attributeSet, int i) {
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
        this.j = new LinkedList<>();
        this.k = 0.0f;
        this.l = State.PAUSE;
        this.m = true;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.r = 0L;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        a(context);
    }
}

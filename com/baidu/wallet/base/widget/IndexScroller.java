package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes13.dex */
public class IndexScroller {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int p = 0;
    public static final int q = 1;
    public static final int r = 2;
    public static final int s = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f50693b;

    /* renamed from: c  reason: collision with root package name */
    public float f50694c;

    /* renamed from: d  reason: collision with root package name */
    public float f50695d;

    /* renamed from: e  reason: collision with root package name */
    public float f50696e;

    /* renamed from: f  reason: collision with root package name */
    public float f50697f;

    /* renamed from: g  reason: collision with root package name */
    public int f50698g;

    /* renamed from: h  reason: collision with root package name */
    public int f50699h;

    /* renamed from: i  reason: collision with root package name */
    public int f50700i;

    /* renamed from: j  reason: collision with root package name */
    public int f50701j;
    public boolean k;
    public ListView l;
    public SectionIndexer m;
    public String[] n;
    public RectF o;
    public final a t;

    /* loaded from: classes13.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<IndexScroller> a;

        public a(IndexScroller indexScroller) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {indexScroller};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(indexScroller);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                IndexScroller indexScroller = this.a.get();
                if (indexScroller == null) {
                    return;
                }
                int i2 = indexScroller.f50698g;
                if (i2 == 1) {
                    indexScroller.f50697f = (float) (indexScroller.f50697f + ((1.0f - indexScroller.f50697f) * 0.2d));
                    if (indexScroller.f50697f > 0.9d) {
                        indexScroller.f50697f = 1.0f;
                        indexScroller.a(2);
                    }
                    indexScroller.l.invalidate();
                    indexScroller.a(10L);
                } else if (i2 == 2) {
                    indexScroller.a(3);
                } else if (i2 != 3) {
                } else {
                    indexScroller.f50697f = (float) (indexScroller.f50697f - (indexScroller.f50697f * 0.2d));
                    if (indexScroller.f50697f < 0.1d) {
                        indexScroller.f50697f = 0.0f;
                        indexScroller.a(0);
                    }
                    indexScroller.l.invalidate();
                    indexScroller.a(10L);
                }
            }
        }
    }

    public IndexScroller(Context context, ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, listView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50698g = 0;
        this.f50701j = -1;
        this.k = false;
        this.l = null;
        this.m = null;
        this.n = null;
        this.t = new a(this);
        this.f50695d = context.getResources().getDisplayMetrics().density;
        this.f50696e = context.getResources().getDisplayMetrics().scaledDensity;
        this.l = listView;
        setAdapter(listView.getAdapter());
        float f2 = this.f50695d;
        this.a = 20.0f * f2;
        this.f50693b = 10.0f * f2;
        this.f50694c = f2 * 5.0f;
    }

    public boolean contains(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            RectF rectF = this.o;
            if (f2 >= rectF.left) {
                float f4 = rectF.top;
                if (f3 >= f4 && f3 <= f4 + rectF.height()) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void draw(Canvas canvas) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) || (strArr = this.n) == null || strArr.length <= 0) {
            return;
        }
        int i2 = 0;
        if (this.f50701j >= 0) {
            Paint paint = new Paint();
            paint.setColor(-16777216);
            paint.setAlpha(96);
            paint.setAntiAlias(true);
            paint.setShadowLayer(3.0f, 0.0f, 0.0f, Color.argb(64, 0, 0, 0));
            Paint paint2 = new Paint();
            paint2.setColor(-1);
            paint2.setAntiAlias(true);
            paint2.setTextSize(this.f50696e * 50.0f);
            float measureText = paint2.measureText(this.n[this.f50701j]);
            float descent = ((this.f50694c * 2.0f) + paint2.descent()) - paint2.ascent();
            int i3 = this.f50699h;
            int i4 = this.f50700i;
            RectF rectF = new RectF((i3 - descent) / 2.0f, (i4 - descent) / 2.0f, ((i3 - descent) / 2.0f) + descent, ((i4 - descent) / 2.0f) + descent);
            float f2 = this.f50695d;
            canvas.drawRoundRect(rectF, f2 * 5.0f, f2 * 5.0f, paint);
            canvas.drawText(this.n[this.f50701j], (rectF.left + ((descent - measureText) / 2.0f)) - 1.0f, ((rectF.top + this.f50694c) - paint2.ascent()) + 1.0f, paint2);
        }
        Paint paint3 = new Paint();
        paint3.setColor(-16099908);
        paint3.setAntiAlias(true);
        paint3.setTextSize(this.f50696e * 14.0f);
        float height = (this.o.height() - (this.f50693b * 2.0f)) / this.n.length;
        float descent2 = (height - (paint3.descent() - paint3.ascent())) / 2.0f;
        while (true) {
            String[] strArr2 = this.n;
            if (i2 >= strArr2.length) {
                return;
            }
            String str = this.n[i2];
            RectF rectF2 = this.o;
            canvas.drawText(str, rectF2.left + ((this.a - paint3.measureText(strArr2[i2])) / 2.0f), (((rectF2.top + this.f50693b) + (i2 * height)) + descent2) - paint3.ascent(), paint3);
            i2++;
        }
    }

    public void hide() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f50698g == 2) {
            a(3);
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
            this.f50699h = i2;
            this.f50700i = i3;
            float f2 = i2;
            float f3 = this.f50693b;
            this.o = new RectF((f2 - f3) - this.a, f3, f2 - f3, i3 - f3);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2 && this.k) {
                        if (contains(motionEvent.getX(), motionEvent.getY())) {
                            int a2 = a(motionEvent.getY());
                            this.f50701j = a2;
                            this.l.setSelection(this.m.getPositionForSection(a2));
                        }
                        return true;
                    }
                } else {
                    if (this.k) {
                        this.k = false;
                        this.f50701j = -1;
                    }
                    if (this.f50698g == 2) {
                        a(3);
                    }
                }
            } else if (contains(motionEvent.getX(), motionEvent.getY())) {
                a(2);
                this.k = true;
                int a3 = a(motionEvent.getY());
                this.f50701j = a3;
                this.l.setSelection(this.m.getPositionForSection(a3));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setAdapter(Adapter adapter) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, adapter) == null) && (adapter instanceof SectionIndexer)) {
            SectionIndexer sectionIndexer = (SectionIndexer) adapter;
            this.m = sectionIndexer;
            this.n = (String[]) sectionIndexer.getSections();
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i2 = this.f50698g;
            if (i2 == 0) {
                a(1);
            } else if (i2 == 3) {
                a(3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) || i2 < 0 || i2 > 3) {
            return;
        }
        this.f50698g = i2;
        if (i2 == 0) {
            this.t.removeMessages(0);
        } else if (i2 == 1) {
            this.f50697f = 0.0f;
            a(0L);
        } else if (i2 == 2) {
            this.t.removeMessages(0);
        } else if (i2 != 3) {
        } else {
            this.f50697f = 1.0f;
            a(3000L);
        }
    }

    private int a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65538, this, f2)) == null) {
            String[] strArr = this.n;
            if (strArr == null || strArr.length == 0) {
                return 0;
            }
            RectF rectF = this.o;
            float f3 = rectF.top;
            if (f2 < this.f50693b + f3) {
                return 0;
            }
            float height = f3 + rectF.height();
            float f4 = this.f50693b;
            if (f2 >= height - f4) {
                return this.n.length - 1;
            }
            RectF rectF2 = this.o;
            return (int) (((f2 - rectF2.top) - f4) / ((rectF2.height() - (this.f50693b * 2.0f)) / this.n.length));
        }
        return invokeF.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65541, this, j2) == null) {
            this.t.removeMessages(0);
            this.t.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + j2);
        }
    }
}

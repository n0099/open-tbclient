package com.baidu.wallet.qrcodescanner.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ProgressView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f63488a;

    /* renamed from: b  reason: collision with root package name */
    public View f63489b;

    /* renamed from: c  reason: collision with root package name */
    public a f63490c;

    /* renamed from: d  reason: collision with root package name */
    public b f63491d;

    /* loaded from: classes8.dex */
    public class a extends View {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f63493a;

        /* renamed from: b  reason: collision with root package name */
        public int f63494b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ProgressView f63495c;

        /* renamed from: d  reason: collision with root package name */
        public Paint f63496d;

        /* renamed from: e  reason: collision with root package name */
        public Rect f63497e;

        /* renamed from: f  reason: collision with root package name */
        public Path f63498f;

        /* renamed from: g  reason: collision with root package name */
        public int f63499g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ProgressView progressView, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {progressView, context};
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
            this.f63495c = progressView;
            this.f63496d = new Paint();
            this.f63497e = new Rect();
            this.f63498f = new Path();
            this.f63499g = 0;
            this.f63493a = 1;
            this.f63494b = 0;
            this.f63499g = DisplayUtils.dip2px(getContext(), 1.0f);
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f63493a = i2;
            }
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f63494b = i2;
            }
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
                float height = (getHeight() - (DisplayUtils.dip2px(getContext(), 6.0f) * 2)) - (((getHeight() - (DisplayUtils.dip2px(getContext(), 6.0f) * 2)) * this.f63494b) / this.f63493a);
                int i2 = (int) height;
                this.f63497e.set((getWidth() - this.f63499g) / 2, DisplayUtils.dip2px(getContext(), 6.0f), (getWidth() + this.f63499g) / 2, i2);
                Path path = this.f63498f;
                Rect rect = this.f63497e;
                path.addRect(new RectF(rect.left, rect.top, rect.right, rect.bottom), Path.Direction.CW);
                this.f63496d.setColor(-1);
                this.f63496d.setAlpha(33);
                canvas.drawRect(this.f63497e, this.f63496d);
                this.f63497e.set((getWidth() - this.f63499g) / 2, i2 + DisplayUtils.dip2px(getContext(), 6.0f), (getWidth() + this.f63499g) / 2, getHeight() - (DisplayUtils.dip2px(getContext(), 6.0f) * 2));
                Path path2 = this.f63498f;
                Rect rect2 = this.f63497e;
                path2.addRect(new RectF(rect2.left, rect2.top, rect2.right, rect2.bottom), Path.Direction.CW);
                this.f63496d.setColor(-1);
                this.f63496d.setAlpha(127);
                canvas.drawRect(this.f63497e, this.f63496d);
                this.f63496d.setAlpha(255);
                canvas.drawCircle(getWidth() / 2, height + DisplayUtils.dip2px(getContext(), 6.0f), DisplayUtils.dip2px(getContext(), 6.0f), this.f63496d);
                super.draw(canvas);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a();

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
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            b bVar = this.f63491d;
            if (bVar != null) {
                bVar.a();
            }
            if (view == this.f63488a) {
                a aVar = this.f63490c;
                int i2 = aVar.f63494b + 2;
                int i3 = aVar.f63493a;
                if (i2 > i3) {
                    i2 = i3;
                }
                this.f63490c.b(i2);
                this.f63490c.invalidate();
                b bVar2 = this.f63491d;
                if (bVar2 != null) {
                    bVar2.a(this.f63490c.f63494b);
                }
            }
            if (view == this.f63489b) {
                int i4 = this.f63490c.f63494b - 2;
                if (i4 < 0) {
                    i4 = 0;
                }
                this.f63490c.b(i4);
                this.f63490c.invalidate();
                b bVar3 = this.f63491d;
                if (bVar3 != null) {
                    bVar3.a(this.f63490c.f63494b);
                }
            }
        }
    }

    public void setMaxPregress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f63490c.a(i2);
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f63490c.b(i2);
            this.f63490c.invalidate();
        }
    }

    public void setProgressStatusChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f63491d = bVar;
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            View view = new View(getContext());
            this.f63488a = view;
            view.setBackgroundResource(ResUtils.drawable(getContext(), "wallet_qrscanner_progress_add"));
            this.f63488a.setOnClickListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 12.0f), DisplayUtils.dip2px(getContext(), 12.0f));
            layoutParams.addRule(10);
            layoutParams.addRule(14, -1);
            layoutParams.topMargin = DisplayUtils.dip2px(getContext(), 6.0f);
            addView(this.f63488a, layoutParams);
            View view2 = new View(getContext());
            this.f63489b = view2;
            view2.setBackgroundResource(ResUtils.drawable(getContext(), "wallet_qrscanner_progress_cut"));
            this.f63489b.setOnClickListener(this);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 12.0f), DisplayUtils.dip2px(getContext(), 12.0f));
            layoutParams2.addRule(12);
            layoutParams2.addRule(14, -1);
            layoutParams2.bottomMargin = DisplayUtils.dip2px(getContext(), 6.0f);
            addView(this.f63489b, layoutParams2);
            this.f63490c = new a(this, getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 12.0f), DisplayUtils.dip2px(getContext(), 192.0f));
            layoutParams3.addRule(13, -1);
            addView(this.f63490c, layoutParams3);
            this.f63490c.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.qrcodescanner.widget.ProgressView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ProgressView f63492a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f63492a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view3, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view3, motionEvent)) == null) {
                        if (this.f63492a.f63491d != null) {
                            this.f63492a.f63491d.a();
                        }
                        if (motionEvent.getAction() == 0) {
                            int height = this.f63492a.f63490c.getHeight();
                            int[] iArr = new int[2];
                            this.f63492a.f63490c.getLocationOnScreen(iArr);
                            int i2 = iArr[1];
                            if (motionEvent.getRawY() >= i2) {
                                float f2 = i2 + height;
                                if (motionEvent.getRawY() <= f2) {
                                    int rawY = (int) (((f2 - motionEvent.getRawY()) / height) * this.f63492a.f63490c.f63493a);
                                    this.f63492a.f63490c.b(rawY);
                                    this.f63492a.f63490c.invalidate();
                                    if (this.f63492a.f63491d != null) {
                                        this.f63492a.f63491d.a(rawY);
                                    }
                                }
                            }
                            return true;
                        } else if (motionEvent.getAction() == 2) {
                            int height2 = this.f63492a.f63490c.getHeight();
                            int[] iArr2 = new int[2];
                            this.f63492a.f63490c.getLocationOnScreen(iArr2);
                            int i3 = iArr2[1];
                            if (motionEvent.getRawY() >= i3) {
                                float f3 = i3 + height2;
                                if (motionEvent.getRawY() <= f3) {
                                    int rawY2 = (int) (((f3 - motionEvent.getRawY()) / height2) * this.f63492a.f63490c.f63493a);
                                    this.f63492a.f63490c.b(rawY2);
                                    this.f63492a.f63490c.invalidate();
                                    if (this.f63492a.f63491d != null) {
                                        this.f63492a.f63491d.a(rawY2);
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        } else {
                            return false;
                        }
                    }
                    return invokeLL.booleanValue;
                }
            });
        }
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
        a();
    }
}

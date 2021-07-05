package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class DragContainer extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Scroller f21097e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f21098f;

    /* renamed from: g  reason: collision with root package name */
    public View f21099g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f21100h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragContainer(Context context) {
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
        this.f21098f = new Rect();
        f(context);
    }

    public void c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f21099g = view;
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                this.f21100h = Bitmap.createBitmap(drawingCache);
            }
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            view.getDrawingRect(this.f21098f);
            offsetDescendantRectToMyCoords(view, this.f21098f);
            int height = getHeight();
            Scroller scroller = this.f21097e;
            int i2 = this.f21098f.top;
            scroller.startScroll(i2, 0, height - i2, 0, 800);
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.f21099g != null) {
                if (this.f21097e.computeScrollOffset() && this.f21100h != null) {
                    canvas.save();
                    canvas.drawBitmap(this.f21100h, this.f21098f.left, this.f21097e.getCurrX(), (Paint) null);
                    canvas.restore();
                    postInvalidateDelayed(16L);
                    return;
                }
                Bitmap bitmap = this.f21100h;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                this.f21100h = null;
                this.f21099g = null;
            }
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f21097e = new Scroller(context);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            this.f21097e.forceFinished(true);
            Bitmap bitmap = this.f21100h;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f21100h = null;
            this.f21099g = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragContainer(Context context, AttributeSet attributeSet) {
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
        this.f21098f = new Rect();
        f(context);
    }
}

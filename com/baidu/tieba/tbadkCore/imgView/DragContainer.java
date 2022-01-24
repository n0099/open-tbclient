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
/* loaded from: classes13.dex */
public class DragContainer extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Scroller f48162e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f48163f;

    /* renamed from: g  reason: collision with root package name */
    public View f48164g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f48165h;

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
        this.f48163f = new Rect();
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f48162e = new Scroller(context);
        }
    }

    public void delete(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f48164g = view;
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                this.f48165h = Bitmap.createBitmap(drawingCache);
            }
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            view.getDrawingRect(this.f48163f);
            offsetDescendantRectToMyCoords(view, this.f48163f);
            int height = getHeight();
            Scroller scroller = this.f48162e;
            int i2 = this.f48163f.top;
            scroller.startScroll(i2, 0, height - i2, 0, 800);
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.f48164g != null) {
                if (this.f48162e.computeScrollOffset() && this.f48165h != null) {
                    canvas.save();
                    canvas.drawBitmap(this.f48165h, this.f48163f.left, this.f48162e.getCurrX(), (Paint) null);
                    canvas.restore();
                    postInvalidateDelayed(16L);
                    return;
                }
                Bitmap bitmap = this.f48165h;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                this.f48165h = null;
                this.f48164g = null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            this.f48162e.forceFinished(true);
            Bitmap bitmap = this.f48165h;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f48165h = null;
            this.f48164g = null;
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
        this.f48163f = new Rect();
        a(context);
    }
}

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
/* loaded from: classes4.dex */
public class DragContainer extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Scroller a;
    public Rect b;
    public View c;
    public Bitmap d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragContainer(Context context) {
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
        this.b = new Rect();
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = new Scroller(context);
        }
    }

    public void delete(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            this.c = view2;
            view2.setDrawingCacheEnabled(true);
            view2.buildDrawingCache();
            Bitmap drawingCache = view2.getDrawingCache();
            if (drawingCache != null) {
                this.d = Bitmap.createBitmap(drawingCache);
            }
            view2.destroyDrawingCache();
            view2.setDrawingCacheEnabled(false);
            view2.getDrawingRect(this.b);
            offsetDescendantRectToMyCoords(view2, this.b);
            int height = getHeight();
            Scroller scroller = this.a;
            int i = this.b.top;
            scroller.startScroll(i, 0, height - i, 0, 800);
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.c != null) {
                if (this.a.computeScrollOffset() && this.d != null) {
                    canvas.save();
                    canvas.drawBitmap(this.d, this.b.left, this.a.getCurrX(), (Paint) null);
                    canvas.restore();
                    postInvalidateDelayed(16L);
                    return;
                }
                Bitmap bitmap = this.d;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                this.d = null;
                this.c = null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            this.a.forceFinished(true);
            Bitmap bitmap = this.d;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.d = null;
            this.c = null;
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
        this.b = new Rect();
        b(context);
    }
}

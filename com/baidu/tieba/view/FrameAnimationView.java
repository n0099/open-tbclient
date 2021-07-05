package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.l.d;
import d.a.c.e.m.e;
import d.a.c.e.p.k;
import java.util.List;
/* loaded from: classes5.dex */
public class FrameAnimationView extends TbImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect A0;
    public List<String> B0;
    public int C0;
    public boolean D0;
    public BdUniqueId E0;
    public Runnable F0;
    public int x0;
    public Bitmap y0;
    public Rect z0;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrameAnimationView f22013e;

        public a(FrameAnimationView frameAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frameAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22013e = frameAnimationView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.a().removeCallbacks(this.f22013e.F0);
                if (this.f22013e.B0 != null) {
                    this.f22013e.W();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameAnimationView(Context context) {
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
        this.x0 = 0;
        this.z0 = new Rect();
        this.A0 = new Rect();
        this.F0 = new a(this);
    }

    private Bitmap getFrameBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            List<String> list = this.B0;
            if (list == null) {
                return null;
            }
            if (this.x0 >= list.size()) {
                this.x0 = 0;
            }
            String frameUrl = getFrameUrl();
            this.x0++;
            if (!k.isEmpty(frameUrl)) {
                d.a.c.k.d.a aVar = (d.a.c.k.d.a) d.h().n(frameUrl, 10, new Object[0]);
                if (aVar != null) {
                    return aVar.p();
                }
                d.h().m(frameUrl, 10, null, this.E0);
            }
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    private String getFrameUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            List<String> list = this.B0;
            if (list == null) {
                return null;
            }
            return list.get(this.x0);
        }
        return (String) invokeV.objValue;
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.B0 == null) {
            return;
        }
        Bitmap frameBitmap = getFrameBitmap();
        if (frameBitmap != null && !frameBitmap.isRecycled()) {
            this.y0 = frameBitmap;
            this.z0.set(0, 0, frameBitmap.getWidth(), this.y0.getHeight());
        }
        invalidate();
        e.a().postDelayed(this.F0, this.C0);
    }

    public final boolean X(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            List<String> list2 = this.B0;
            if (list2 == null || list == null || list2.size() != list.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.B0.size(); i2++) {
                if (!this.B0.get(i2).equals(list.get(i2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.B0 == null) {
            return;
        }
        W();
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e.a().removeCallbacks(this.F0);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            if (this.D0) {
                return;
            }
            Y();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            Z();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.D0 || (bitmap = this.y0) == null || bitmap.isRecycled()) {
                return;
            }
            this.A0.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.y0, this.z0, this.A0, (Paint) null);
        }
    }

    public void setData(List<String> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, i2) == null) || list == null) {
            return;
        }
        this.D0 = false;
        this.C0 = i2;
        if (X(list)) {
            return;
        }
        e.a().removeCallbacks(this.F0);
        this.B0 = list;
        this.x0 = 0;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            this.E0 = bdUniqueId;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameAnimationView(Context context, AttributeSet attributeSet) {
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
        this.x0 = 0;
        this.z0 = new Rect();
        this.A0 = new Rect();
        this.F0 = new a(this);
    }

    public void setData(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || k.isEmpty(str)) {
            return;
        }
        this.D0 = true;
        M(str, 10, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameAnimationView(Context context, AttributeSet attributeSet, int i2) {
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
        this.x0 = 0;
        this.z0 = new Rect();
        this.A0 = new Rect();
        this.F0 = new a(this);
    }
}

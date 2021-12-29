package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import c.a.s0.e1.m;
import c.a.t0.o4.e0.n.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes13.dex */
public class StickerLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f51901e;

    /* renamed from: f  reason: collision with root package name */
    public List<StickerView> f51902f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout.LayoutParams f51903g;

    /* renamed from: h  reason: collision with root package name */
    public int f51904h;

    /* loaded from: classes13.dex */
    public class a implements c.a.t0.o4.e0.n.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StickerView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f51905b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ StickerLayout f51906c;

        public a(StickerLayout stickerLayout, StickerView stickerView, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {stickerLayout, stickerView, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51906c = stickerLayout;
            this.a = stickerView;
            this.f51905b = cVar;
        }

        @Override // c.a.t0.o4.e0.n.b.a
        public void a(StickerView stickerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, stickerView) == null) {
            }
        }

        @Override // c.a.t0.o4.e0.n.b.a
        public void b(StickerView stickerView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stickerView, z) == null) {
                stickerView.setEdit(z);
                if (z) {
                    stickerView.bringToFront();
                }
            }
        }

        @Override // c.a.t0.o4.e0.n.b.a
        public void c(StickerView stickerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, stickerView) == null) {
            }
        }

        @Override // c.a.t0.o4.e0.n.b.a
        public void onDelete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f51906c.removeView(this.a);
                this.f51906c.f51902f.remove(this.a);
                this.f51906c.redraw();
                c cVar = this.f51905b;
                if (cVar != null) {
                    cVar.a();
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StickerLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public StickerView addSticker(Bitmap bitmap, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bitmap, cVar)) == null) {
            StickerView stickerView = new StickerView(this.f51901e);
            stickerView.setImageBitmap(bitmap);
            stickerView.setLayoutParams(this.f51903g);
            stickerView.setmOnStickerActionListener(new a(this, stickerView, cVar));
            addView(stickerView);
            this.f51902f.add(stickerView);
            redraw();
            if (cVar != null) {
                cVar.d();
            }
            return stickerView;
        }
        return (StickerView) invokeLL.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f51901e = context;
            this.f51902f = new ArrayList();
            this.f51903g = new FrameLayout.LayoutParams(-1, -1);
        }
    }

    public Bitmap generateCombinedBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.f51902f)) {
                return null;
            }
            redraw();
            return m.c(this);
        }
        return (Bitmap) invokeV.objValue;
    }

    public List<StickerView> getStickerViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f51902f : (List) invokeV.objValue;
    }

    public void redraw() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f51902f.size() <= 0) {
            return;
        }
        for (StickerView stickerView : this.f51902f) {
            if (stickerView != null) {
                stickerView.setRemoveRes(this.f51904h);
                stickerView.setEdit(false);
            }
        }
    }

    public void removeAllSticker(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            Iterator<StickerView> it = this.f51902f.iterator();
            while (it.hasNext()) {
                StickerView next = it.next();
                if (next != null) {
                    removeView(next);
                    it.remove();
                    redraw();
                    if (cVar != null) {
                        cVar.a();
                    }
                }
            }
        }
    }

    public void setRemoveRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f51904h = i2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StickerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerLayout(Context context, AttributeSet attributeSet, int i2) {
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
        b(context);
    }
}

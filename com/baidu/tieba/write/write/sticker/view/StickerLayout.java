package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.z0.h;
import d.a.p0.a4.u.n.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class StickerLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f22910e;

    /* renamed from: f  reason: collision with root package name */
    public List<StickerView> f22911f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout.LayoutParams f22912g;

    /* renamed from: h  reason: collision with root package name */
    public int f22913h;

    /* loaded from: classes4.dex */
    public class a implements d.a.p0.a4.u.n.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StickerView f22914a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f22915b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ StickerLayout f22916c;

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
            this.f22916c = stickerLayout;
            this.f22914a = stickerView;
            this.f22915b = cVar;
        }

        @Override // d.a.p0.a4.u.n.b.a
        public void a(StickerView stickerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, stickerView) == null) {
            }
        }

        @Override // d.a.p0.a4.u.n.b.a
        public void b(StickerView stickerView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stickerView, z) == null) {
                stickerView.setEdit(z);
                if (z) {
                    stickerView.bringToFront();
                }
            }
        }

        @Override // d.a.p0.a4.u.n.b.a
        public void c(StickerView stickerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, stickerView) == null) {
            }
        }

        @Override // d.a.p0.a4.u.n.b.a
        public void onDelete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f22916c.removeView(this.f22914a);
                this.f22916c.f22911f.remove(this.f22914a);
                this.f22916c.e();
                c cVar = this.f22915b;
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

    public StickerView b(Bitmap bitmap, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bitmap, cVar)) == null) {
            StickerView stickerView = new StickerView(this.f22910e);
            stickerView.setImageBitmap(bitmap);
            stickerView.setLayoutParams(this.f22912g);
            stickerView.setmOnStickerActionListener(new a(this, stickerView, cVar));
            addView(stickerView);
            this.f22911f.add(stickerView);
            e();
            if (cVar != null) {
                cVar.d();
            }
            return stickerView;
        }
        return (StickerView) invokeLL.objValue;
    }

    public Bitmap c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (ListUtils.isEmpty(this.f22911f)) {
                return null;
            }
            e();
            return h.c(this);
        }
        return (Bitmap) invokeV.objValue;
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f22910e = context;
            this.f22911f = new ArrayList();
            this.f22912g = new FrameLayout.LayoutParams(-1, -1);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f22911f.size() <= 0) {
            return;
        }
        for (StickerView stickerView : this.f22911f) {
            if (stickerView != null) {
                stickerView.setRemoveRes(this.f22913h);
                stickerView.setEdit(false);
            }
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            Iterator<StickerView> it = this.f22911f.iterator();
            while (it.hasNext()) {
                StickerView next = it.next();
                if (next != null) {
                    removeView(next);
                    it.remove();
                    e();
                    if (cVar != null) {
                        cVar.a();
                    }
                }
            }
        }
    }

    public List<StickerView> getStickerViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22911f : (List) invokeV.objValue;
    }

    public void setRemoveRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f22913h = i2;
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
        d(context);
    }
}

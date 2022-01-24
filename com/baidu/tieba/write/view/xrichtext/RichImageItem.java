package com.baidu.tieba.write.view.xrichtext;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.t0.p4.g;
import c.a.t0.p4.h;
import c.a.t0.p4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes13.dex */
public class RichImageItem extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f49762e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f49763f;

    /* renamed from: g  reason: collision with root package name */
    public f f49764g;

    /* renamed from: h  reason: collision with root package name */
    public ImageFileInfo f49765h;

    /* renamed from: i  reason: collision with root package name */
    public int f49766i;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RichImageItem f49767e;

        public a(RichImageItem richImageItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richImageItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49767e = richImageItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ImageFileInfo imageFileInfo = this.f49767e.f49765h;
                if (imageFileInfo.isFromMoreForum) {
                    return;
                }
                boolean z = false;
                if (imageFileInfo != null && (imageFileInfo.getImageType() == 1 || new File(imageFileInfo.getFilePath()).exists())) {
                    z = true;
                }
                if (z) {
                    if (this.f49767e.f49764g != null) {
                        this.f49767e.f49764g.b(imageFileInfo, this.f49767e);
                        return;
                    }
                    return;
                }
                n.J(this.f49767e.getContext(), j.editor_mutiiamge_image_error);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RichImageItem f49768e;

        public b(RichImageItem richImageItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richImageItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49768e = richImageItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f49768e.f49764g == null) {
                return;
            }
            this.f49768e.f49764g.a(this.f49768e.f49765h, this.f49768e);
        }
    }

    /* loaded from: classes13.dex */
    public class c implements c.a.s0.c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RichImageItem f49769e;

        public c(RichImageItem richImageItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richImageItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49769e = richImageItem;
        }

        @Override // c.a.s0.c0.b
        public void imageLoaded(c.a.d.n.d.a aVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || aVar == null) {
                return;
            }
            this.f49769e.h(aVar);
            this.f49769e.f49762e.invalidate();
        }
    }

    /* loaded from: classes13.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.d.n.d.a f49770e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RichImageItem f49771f;

        public d(RichImageItem richImageItem, c.a.d.n.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richImageItem, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49771f = richImageItem;
            this.f49770e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49771f.h(this.f49770e);
                this.f49771f.f49762e.invalidate();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class e extends c.a.d.f.l.c<c.a.d.n.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RichImageItem a;

        public e(RichImageItem richImageItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richImageItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = richImageItem;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.n.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || aVar == null) {
                return;
            }
            this.a.h(aVar);
            this.a.f49762e.invalidate();
        }
    }

    /* loaded from: classes13.dex */
    public interface f {
        void a(ImageFileInfo imageFileInfo, View view);

        void b(ImageFileInfo imageFileInfo, View view);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RichImageItem(Context context) {
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

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            FrameLayout.inflate(getContext(), h.rich_text_editor_image_item, this);
            TbImageView tbImageView = (TbImageView) findViewById(g.iv);
            this.f49762e = tbImageView;
            tbImageView.setTagTextSize(n.f(getContext(), c.a.t0.p4.e.T_X10));
            this.f49762e.setDrawBorder(true);
            this.f49762e.setDrawCorner(true);
            this.f49762e.setAutoChangeStyle(true);
            this.f49762e.setConrers(15);
            this.f49762e.setRadiusById(j.J_X05);
            View findViewById = findViewById(g.delete_info);
            this.f49763f = (ImageView) findViewById(g.delete);
            this.f49762e.setVisibility(0);
            findViewById.setVisibility(0);
            this.f49762e.setGifIconSupport(true);
            this.f49762e.setLongIconSupport(true);
            this.f49762e.setTagStr(getContext().getString(j.edit));
            setOnClickListener(new a(this));
            findViewById.setOnClickListener(new b(this));
            onSkinChange();
            this.f49766i = n.k(getContext()) - (UtilHelper.getDimenPixelSize(c.a.t0.p4.e.M_W_X007) * 2);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f49762e.setIsLongPic(this.f49765h.isLong());
            int i2 = this.f49766i;
            ImageOperation g2 = c.a.s0.d0.i.d.g(i2, i2 * 2);
            this.f49765h.clearPageActions();
            this.f49765h.addPageAction(g2);
            if (this.f49765h.getImageType() == 0) {
                this.f49762e.setTag(this.f49765h.toCachedKey(true));
                c.a.d.n.d.a d2 = new c.a.s0.d0.b().d(this.f49765h, new c(this), true);
                if (d2 != null && d2.r() > 0 && d2.m() > 0) {
                    post(new d(this, d2));
                }
                this.f49762e.setTagStr(getContext().getString(j.edit));
            } else if (this.f49765h.getImageType() == 1) {
                String filePath = this.f49765h.getFilePath();
                if (!m.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                    this.f49762e.setTag(c.a.d.f.l.d.h().g(filePath, 20));
                    c.a.d.f.l.d.h().k(filePath, 20, new e(this), 0, 0, null, null, filePath, Boolean.FALSE, null);
                }
                this.f49762e.setTagStr("");
            }
        }
    }

    public final void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            float width = getWidth() != 0 ? getWidth() : this.f49766i;
            float f2 = i3 > i2 * 2 ? width * 2.0f : (width / i2) * i3;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f49762e.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = f2 > 0.0f ? (int) f2 : -2;
            this.f49762e.setLayoutParams(layoutParams);
        }
    }

    public ImageFileInfo getImageFileInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f49765h : (ImageFileInfo) invokeV.objValue;
    }

    public final void h(c.a.d.n.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null || aVar.r() <= 0 || aVar.m() <= 0) {
            return;
        }
        g(aVar.r(), aVar.m());
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (i4 == 0 || i2 == 0 || i2 == i4) {
                return;
            }
            g(i4, i5);
        }
    }

    public void onSkinChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f49763f.setImageDrawable(WebPManager.getMaskDrawable(c.a.t0.p4.f.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.f49762e.setTagColor(getContext().getResources().getColor(c.a.t0.p4.d.CAM_X0101));
            } else {
                this.f49762e.setTagColor(getContext().getResources().getColor(c.a.t0.p4.d.CAM_X0101));
            }
        }
    }

    public void setImageFileInfo(@NonNull ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, imageFileInfo) == null) {
            this.f49765h = imageFileInfo;
            f();
        }
    }

    public void setItemOperateListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.f49764g = fVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RichImageItem(Context context, AttributeSet attributeSet) {
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
    public RichImageItem(Context context, AttributeSet attributeSet, int i2) {
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
        e();
    }
}

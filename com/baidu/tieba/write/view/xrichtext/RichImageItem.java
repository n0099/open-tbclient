package com.baidu.tieba.write.view.xrichtext;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.an5;
import com.baidu.tieba.ei;
import com.baidu.tieba.kn5;
import com.baidu.tieba.xm5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes8.dex */
public class RichImageItem extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public ImageView b;
    public f c;
    public ImageFileInfo d;
    public int e;

    /* loaded from: classes8.dex */
    public interface f {
        void a(ImageFileInfo imageFileInfo, View view2);

        void b(ImageFileInfo imageFileInfo, View view2);
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RichImageItem a;

        public a(RichImageItem richImageItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richImageItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = richImageItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            ImageFileInfo imageFileInfo = this.a.d;
            if (imageFileInfo.isFromMoreForum) {
                return;
            }
            boolean z = false;
            if (imageFileInfo != null && (imageFileInfo.getImageType() == 1 || new File(imageFileInfo.getFilePath()).exists())) {
                z = true;
            }
            if (!z) {
                BdUtilHelper.showLongToast(this.a.getContext(), (int) R.string.editor_mutiiamge_image_error);
            } else if (this.a.c != null) {
                this.a.c.b(imageFileInfo, this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RichImageItem a;

        public b(RichImageItem richImageItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richImageItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = richImageItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.c != null) {
                this.a.c.a(this.a.d, this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements xm5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RichImageItem a;

        public c(RichImageItem richImageItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richImageItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = richImageItem;
        }

        @Override // com.baidu.tieba.xm5
        public void a(BdImage bdImage, String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLZ(1048576, this, bdImage, str, z) != null) || bdImage == null) {
                return;
            }
            this.a.i(bdImage);
            this.a.a.invalidate();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdImage a;
        public final /* synthetic */ RichImageItem b;

        public d(RichImageItem richImageItem, BdImage bdImage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richImageItem, bdImage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = richImageItem;
            this.a = bdImage;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.i(this.a);
            this.b.a.invalidate();
        }
    }

    /* loaded from: classes8.dex */
    public class e extends BdResourceCallback<BdImage> {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = richImageItem;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLI(1048576, this, bdImage, str, i) != null) || bdImage == null) {
                return;
            }
            this.a.i(bdImage);
            this.a.a.invalidate();
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichImageItem(Context context, AttributeSet attributeSet, int i) {
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
        e();
    }

    public final void i(BdImage bdImage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bdImage) == null) && bdImage != null && bdImage.getWidth() > 0 && bdImage.getHeight() > 0) {
            h(bdImage.getWidth(), bdImage.getHeight());
        }
    }

    public void setImageFileInfo(@NonNull ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, imageFileInfo) == null) {
            this.d = imageFileInfo;
            g();
        }
    }

    public void setItemOperateListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.c = fVar;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            FrameLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0887, this);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091203);
            this.a = tbImageView;
            tbImageView.setTagTextSize(BdUtilHelper.getDimens(getContext(), R.dimen.T_X10));
            this.a.setDrawBorder(true);
            this.a.setDrawCorner(true);
            this.a.setAutoChangeStyle(true);
            this.a.setConrers(15);
            this.a.setRadiusById(R.string.J_X05);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f090875);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f09086e);
            this.a.setVisibility(0);
            findViewById.setVisibility(0);
            this.a.setGifIconSupport(true);
            this.a.setLongIconSupport(true);
            this.a.setTagStr(getContext().getString(R.string.obfuscated_res_0x7f0f0618));
            setOnClickListener(new a(this));
            findViewById.setOnClickListener(new b(this));
            f();
            this.e = BdUtilHelper.getEquipmentWidth(getContext()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
            this.a.setTagColor(getContext().getResources().getColor(R.color.CAM_X0101));
        }
    }

    public ImageFileInfo getImageFileInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (ImageFileInfo) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.setIsLongPic(this.d.isLong());
            int i = this.e;
            ImageOperation g = kn5.g(i, i * 2);
            this.d.clearPageActions();
            this.d.addPageAction(g);
            if (this.d.getImageType() == 0) {
                this.a.setTag(this.d.toCachedKey(true));
                BdImage d2 = new an5().d(this.d, new c(this), true);
                if (d2 != null && d2.getWidth() > 0 && d2.getHeight() > 0) {
                    post(new d(this, d2));
                }
                this.a.setTagStr(getContext().getString(R.string.obfuscated_res_0x7f0f0618));
            } else if (this.d.getImageType() == 1) {
                String filePath = this.d.getFilePath();
                if (!ei.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                    this.a.setTag(BdResourceLoader.getInstance().genCacheKey(filePath, 20));
                    BdResourceLoader.getInstance().loadResource(filePath, 20, new e(this), 0, 0, null, null, filePath, Boolean.FALSE, null);
                }
                this.a.setTagStr("");
            }
        }
    }

    public final void h(int i, int i2) {
        int i3;
        float f2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            if (getWidth() != 0) {
                i3 = getWidth();
            } else {
                i3 = this.e;
            }
            float f3 = i3;
            if (i2 > i * 2) {
                f2 = f3 * 2.0f;
            } else {
                f2 = (f3 / i) * i2;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
            layoutParams.width = -1;
            if (f2 > 0.0f) {
                i4 = (int) f2;
            } else {
                i4 = -2;
            }
            layoutParams.height = i4;
            this.a.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (i3 != 0 && i != 0 && i != i3) {
                h(i3, i4);
            }
        }
    }
}

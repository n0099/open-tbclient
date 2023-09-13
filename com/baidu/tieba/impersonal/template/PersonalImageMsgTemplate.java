package com.baidu.tieba.impersonal.template;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
import com.baidu.tieba.az8;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.impersonal.template.PersonalImageMsgTemplate;
import com.baidu.tieba.l19;
import com.baidu.tieba.uy8;
import com.baidu.tieba.x09;
import com.baidu.tieba.zd8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u001a\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u001a\u0010\"\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u0004H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/baidu/tieba/impersonal/template/PersonalImageMsgTemplate;", "Lcom/baidu/tieba/impersonal/template/BasePersonalMsgTemplate;", "Lcom/baidu/tieba/impersonal/data/ImageMsgContent;", "Lcom/baidu/tieba/im/chat/view/ChatImageWithTailView;", "Lcom/baidu/tieba/impersonal/components/uistate/PersonalImageMsgUiState;", "name", "", "(Ljava/lang/String;)V", "containerPaddingH", "", "containerPaddingLeft", "containerPaddingRight", "imgHelper", "Lcom/baidu/tieba/impersonal/util/ImageHelper;", "getImgHelper", "()Lcom/baidu/tieba/impersonal/util/ImageHelper;", "imgHelper$delegate", "Lkotlin/Lazy;", "mData", "mImageView", "mImgUrl", "bindChild", "", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "data", "configContainer", "container", "Landroid/view/ViewGroup;", "createChild", "parent", "fillImageView", "image", "imageMsg", "processClickAction", "processLongClickAction", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PersonalImageMsgTemplate extends x09<az8, ChatImageWithTailView, uy8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy b;
    public String c;
    public final int d;
    public final int e;
    public final int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalImageMsgTemplate(String name) {
        super(name);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {name};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(name, "name");
        this.b = LazyKt__LazyJVMKt.lazy(PersonalImageMsgTemplate$imgHelper$2.INSTANCE);
        this.d = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        this.e = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        this.f = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
    }

    public static final void l(PersonalImageMsgTemplate this$0, uy8 data, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, this$0, data, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            this$0.q(data);
        }
    }

    public static final boolean m(PersonalImageMsgTemplate this$0, ChatImageWithTailView chatImageWithTailView, uy8 data, View view2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, this$0, chatImageWithTailView, data, view2)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            this$0.r(chatImageWithTailView, data);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(ChatImageWithTailView chatImageWithTailView, az8 az8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, chatImageWithTailView, az8Var) == null) {
            if (az8Var != null) {
                str = az8Var.c();
            } else {
                str = null;
            }
            if (str != null) {
                String a = zd8.a(az8Var.b());
                Intrinsics.checkNotNullExpressionValue(a, "getFixedSize(imageMsg.thumbSize)");
                az8Var.f(zd8.d(chatImageWithTailView, str, a, R.drawable.icon_pic_im_image_default));
            }
        }
    }

    @Override // com.baidu.tieba.x09
    public void f(ViewGroup container) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, container) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            SkinManager.setBackgroundResource(container, R.color.transparent);
            int i = this.d;
            int i2 = this.f;
            container.setPadding(i, i2, this.e, i2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x09
    /* renamed from: k */
    public void d(final ChatImageWithTailView chatImageWithTailView, final uy8 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, chatImageWithTailView, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (chatImageWithTailView != null) {
                chatImageWithTailView.setBackgroundColor(SkinManager.getColor(R.color.transparent));
            }
            if (chatImageWithTailView != null) {
                chatImageWithTailView.getImage().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v09
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            PersonalImageMsgTemplate.l(PersonalImageMsgTemplate.this, data, view2);
                        }
                    }
                });
                chatImageWithTailView.getImage().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.r09
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view2) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view2)) == null) ? PersonalImageMsgTemplate.m(PersonalImageMsgTemplate.this, chatImageWithTailView, data, view2) : invokeL.booleanValue;
                    }
                });
            }
            if (chatImageWithTailView != null) {
                o(chatImageWithTailView, data.c().f());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x09
    /* renamed from: n */
    public ChatImageWithTailView g(ViewGroup parent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, parent)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ChatImageWithTailView chatImageWithTailView = new ChatImageWithTailView(parent.getContext());
            chatImageWithTailView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            chatImageWithTailView.e(false);
            chatImageWithTailView.getImage().setId(R.id.obfuscated_res_0x7f091c7b);
            GifView image = chatImageWithTailView.getImage();
            image.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            image.setBorderWidth(UtilHelper.getDimenPixelSize(R.dimen.obfuscated_res_0x7f0708c5));
            image.setRadiusById(R.string.J_X18);
            image.setDrawBorder(true);
            return chatImageWithTailView;
        }
        return (ChatImageWithTailView) invokeL.objValue;
    }

    public final void q(uy8 uy8Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, uy8Var) == null) {
            az8 f = uy8Var.c().f();
            boolean z2 = false;
            if (f != null) {
                String a = f.a();
                this.c = a;
                if (a != null && a.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    this.c = f.c();
                }
            }
            String str = this.c;
            if (!((str == null || str.length() == 0) ? true : true)) {
                l19 p = p();
                String str2 = this.c;
                Intrinsics.checkNotNull(str2);
                p.i(str2);
            }
        }
    }

    public final l19 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (l19) this.b.getValue();
        }
        return (l19) invokeV.objValue;
    }

    public final void r(ChatImageWithTailView chatImageWithTailView, uy8 uy8Var) {
        byte[] bArr;
        Context context;
        GifView image;
        BdImage bdImage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatImageWithTailView, uy8Var) == null) {
            String str = null;
            if (chatImageWithTailView != null && (image = chatImageWithTailView.getImage()) != null && (bdImage = image.getBdImage()) != null) {
                bArr = bdImage.getImageByte();
            } else {
                bArr = null;
            }
            az8 f = uy8Var.c().f();
            if (f != null) {
                str = f.c();
            }
            if (chatImageWithTailView != null && (context = chatImageWithTailView.getContext()) != null) {
                p().k(context, str, bArr);
            }
        }
    }
}

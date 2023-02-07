package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.fn6;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.TextGenImageAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.BaseImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.LocalCacheData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.nr7;
import com.baidu.tieba.oj7;
import com.baidu.tieba.p15;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TextGenImageView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TextView b;
    public ChatImageWithTailView c;

    /* loaded from: classes5.dex */
    public class a implements fn6.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextGenImageMsg a;
        public final /* synthetic */ TextGenImageView b;

        public a(TextGenImageView textGenImageView, TextGenImageMsg textGenImageMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textGenImageView, textGenImageMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = textGenImageView;
            this.a = textGenImageMsg;
        }

        @Override // com.baidu.tieba.fn6.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                nr7.a(spannableStringBuilder);
                this.a.setCacheText(spannableStringBuilder);
                this.b.b.setText(this.a.getCacheTextWithProgress());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextGenImageView(Context context) {
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
        this.a = context;
        setOrientation(1);
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextGenImageView(Context context, @Nullable AttributeSet attributeSet) {
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
    }

    public final void d(ChatImageWithTailView chatImageWithTailView, BaseImageMsg<?> baseImageMsg) {
        String thumbUrl;
        String thumbSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, chatImageWithTailView, baseImageMsg) == null) {
            if (baseImageMsg.getCacheData() != null) {
                thumbUrl = baseImageMsg.getCacheData().localPath;
                thumbSize = baseImageMsg.getCacheData().imgSize;
            } else {
                thumbUrl = baseImageMsg.getThumbUrl();
                thumbSize = baseImageMsg.getThumbSize();
            }
            baseImageMsg.setThumbSize(oj7.c(chatImageWithTailView, thumbUrl, thumbSize, R.drawable.icon_pic_placeholder));
        }
    }

    public void setImageWithTailView(ChatImageWithTailView chatImageWithTailView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, chatImageWithTailView) == null) {
            this.c = chatImageWithTailView;
        }
    }

    public void b(@NonNull TextGenImageAdapter.Holder holder, @NonNull TextGenImageMsg textGenImageMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, holder, textGenImageMsg) == null) {
            nr7.b(textGenImageMsg.getAtUserInfoList());
            CharSequence cacheTextWithProgress = textGenImageMsg.getCacheTextWithProgress();
            if (cacheTextWithProgress != null) {
                this.b.setText(cacheTextWithProgress);
            } else {
                fn6.d(getContext(), textGenImageMsg.getText(), UtilHelper.getDimenPixelSize(R.dimen.T_X03), new a(this, textGenImageMsg));
            }
            this.b.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            c(textGenImageMsg);
            d(this.c, textGenImageMsg);
        }
    }

    public final void c(BaseImageMsg<?> baseImageMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseImageMsg) == null) && !StringUtils.isNull(baseImageMsg.getThumbUrl()) && !baseImageMsg.getThumbUrl().startsWith("http")) {
            if (baseImageMsg.getCacheData() == null) {
                LocalCacheData localCacheData = new LocalCacheData();
                localCacheData.imgSize = baseImageMsg.getThumbSize();
                localCacheData.localPath = baseImageMsg.getThumbUrl();
                baseImageMsg.setCacheData(localCacheData);
                return;
            }
            baseImageMsg.getCacheData().imgSize = baseImageMsg.getThumbSize();
            baseImageMsg.getCacheData().localPath = baseImageMsg.getThumbUrl();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = new TextView(this.a);
            this.b.setLayoutParams(new LinearLayout.LayoutParams(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds608), -2));
            this.b.setId(R.id.obfuscated_res_0x7f090dbb);
            this.b.setLineSpacing(1.0f, 1.2f);
            p15.d(this.b).z(R.dimen.T_X05);
            addView(this.b);
            this.c = new ChatImageWithTailView(this.a);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, 0);
            this.c.setLayoutParams(layoutParams);
            this.c.e(false);
            this.c.setErrorResId(R.drawable.icon_pic_placeholder);
            this.c.setErrorBgResId(R.drawable.transparent_bg);
            this.c.getImage().setId(R.id.obfuscated_res_0x7f090d9c);
            addView(this.c);
        }
    }

    public ChatImageWithTailView getImageWithTailView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (ChatImageWithTailView) invokeV.objValue;
    }
}

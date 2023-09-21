package com.baidu.tieba.im.under.common.uiliststyle.group.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.lib.socket.msg.TbSingleTextImageMsg;
import com.baidu.tieba.im.under.common.uiliststyle.group.adapter.SingleTextImageAdapter;
import com.baidu.tieba.m47;
import com.baidu.tieba.no8;
import com.baidu.tieba.uh8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TextGenImageView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TextView b;
    public ChatImageWithTailView c;

    /* loaded from: classes6.dex */
    public class a implements m47.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbSingleTextImageMsg a;
        public final /* synthetic */ TextGenImageView b;

        public a(TextGenImageView textGenImageView, TbSingleTextImageMsg tbSingleTextImageMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textGenImageView, tbSingleTextImageMsg};
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
            this.a = tbSingleTextImageMsg;
        }

        @Override // com.baidu.tieba.m47.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                no8.a(spannableStringBuilder);
                this.a.setCacheText(spannableStringBuilder);
                this.b.b.setText(this.a.getCacheText());
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextGenImageView(Context context) {
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
        this.a = context;
        setOrientation(1);
        d();
    }

    public void setImageWithTailView(ChatImageWithTailView chatImageWithTailView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, chatImageWithTailView) == null) {
            this.c = chatImageWithTailView;
        }
    }

    public void b(@NonNull SingleTextImageAdapter.Holder holder, @NonNull TbSingleTextImageMsg tbSingleTextImageMsg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, holder, tbSingleTextImageMsg, i) == null) {
            no8.b(tbSingleTextImageMsg.getAtUserInfoList());
            CharSequence cacheText = tbSingleTextImageMsg.getCacheText();
            if (cacheText != null) {
                this.b.setText(cacheText);
            } else {
                m47.e(getContext(), tbSingleTextImageMsg.getText(), UtilHelper.getDimenPixelSize(R.dimen.T_X03), new a(this, tbSingleTextImageMsg));
            }
            c(this.c, tbSingleTextImageMsg);
        }
    }

    public final void c(ChatImageWithTailView chatImageWithTailView, TbSingleTextImageMsg tbSingleTextImageMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatImageWithTailView, tbSingleTextImageMsg) == null) {
            String thumbUrl = tbSingleTextImageMsg.getThumbUrl();
            String thumbSize = tbSingleTextImageMsg.getThumbSize();
            if (!StringUtils.isNull(thumbSize) && !StringUtils.isNull(thumbUrl)) {
                tbSingleTextImageMsg.setThumbSize(uh8.d(chatImageWithTailView, thumbUrl, thumbSize, R.drawable.icon_pic_placeholder));
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = new TextView(this.a);
            this.b.setLayoutParams(new LinearLayout.LayoutParams(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds608), -2));
            this.b.setId(R.id.obfuscated_res_0x7f090eb3);
            this.b.setLineSpacing(1.0f, 1.2f);
            EMManager.from(this.b).setTextSize(R.dimen.T_X05);
            addView(this.b);
            this.c = new ChatImageWithTailView(this.a);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, 0);
            this.c.setLayoutParams(layoutParams);
            this.c.e(false);
            this.c.setErrorResId(R.drawable.icon_pic_placeholder);
            this.c.setErrorBgResId(R.drawable.transparent_bg);
            this.c.getImage().setId(R.id.obfuscated_res_0x7f090e92);
            addView(this.c);
        }
    }

    public ChatImageWithTailView getImageWithTailView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (ChatImageWithTailView) invokeV.objValue;
    }

    @NonNull
    public TextView getTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (TextView) invokeV.objValue;
    }
}

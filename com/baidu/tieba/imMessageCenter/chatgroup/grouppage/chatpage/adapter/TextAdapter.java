package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.xa7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class TextAdapter extends BaseChatAdapter<TextMsg, Holder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class Holder extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TbRichTextView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Holder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (TbRichTextView) view2;
        }

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void b(@Nullable View.OnLongClickListener onLongClickListener) {
            TbRichTextView tbRichTextView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, onLongClickListener) == null) && (tbRichTextView = this.a) != null) {
                tbRichTextView.setOnLongClickListener(onLongClickListener);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextAdapter(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: L */
    public Holder A(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            return new Holder(K(viewGroup.getContext()));
        }
        return (Holder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: M */
    public Holder B(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            return new Holder(K(viewGroup.getContext()));
        }
        return (Holder) invokeL.objValue;
    }

    public final TbRichTextView K(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            TbRichTextView tbRichTextView = new TbRichTextView(context);
            tbRichTextView.setId(R.id.obfuscated_res_0x7f090d6e);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            layoutParams.gravity = 17;
            tbRichTextView.setLayoutParams(layoutParams);
            tbRichTextView.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            tbRichTextView.getLayoutStrategy().o(1.2f);
            tbRichTextView.getLayoutStrategy().i(UtilHelper.getDimenPixelSize(R.dimen.tbds8), 0);
            tbRichTextView.setTextCenter(true);
            tbRichTextView.setTextSize(UtilHelper.getDimenPixelSize(R.dimen.T_X05));
            tbRichTextView.setFaceSize(UtilHelper.getDimenPixelSize(R.dimen.T_X03));
            return tbRichTextView;
        }
        return (TbRichTextView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    /* renamed from: N */
    public void F(int i, @NonNull ViewGroup viewGroup, @NonNull TextMsg textMsg, @NonNull Holder holder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), viewGroup, textMsg, holder, list, Integer.valueOf(i2)}) == null) {
            TbRichTextView tbRichTextView = (TbRichTextView) holder.getView();
            tbRichTextView.setText(new TbRichText(xa7.c(textMsg.getText(), 0)));
            if (textMsg.isLeft()) {
                tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            } else {
                tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0610));
            }
        }
    }
}

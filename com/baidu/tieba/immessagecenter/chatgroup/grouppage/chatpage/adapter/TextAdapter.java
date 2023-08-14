package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.n17;
import com.baidu.tieba.tm8;
import com.baidu.tieba.yi8;
import com.baidu.tieba.yj8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class TextAdapter extends BaseChatAdapter<TextMsg, Holder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static class Holder extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TextView a;

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
            this.a = (TextView) view2;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void c(@Nullable View.OnLongClickListener onLongClickListener) {
            TextView textView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, onLongClickListener) == null) && (textView = this.a) != null) {
                textView.setOnLongClickListener(onLongClickListener);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements n17.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextMsg a;
        public final /* synthetic */ TextView b;

        public a(TextAdapter textAdapter, TextMsg textMsg, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textAdapter, textMsg, textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = textMsg;
            this.b = textView;
        }

        @Override // com.baidu.tieba.n17.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                tm8.a(spannableStringBuilder);
                this.a.setCacheText(spannableStringBuilder);
                this.b.setText(spannableStringBuilder);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements yi8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ TextMsg c;
        public final /* synthetic */ int d;
        public final /* synthetic */ TextAdapter e;

        public b(TextAdapter textAdapter, ViewGroup viewGroup, TextView textView, TextMsg textMsg, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textAdapter, viewGroup, textView, textMsg, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = textAdapter;
            this.a = viewGroup;
            this.b = textView;
            this.c = textMsg;
            this.d = i;
        }

        @Override // com.baidu.tieba.yi8
        public void a(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
                this.a.setBackground(drawable);
                yj8.o(false, this.b, this.c, this.d);
            }
        }

        @Override // com.baidu.tieba.yi8
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.e.i0(this.a, this.c);
                yj8.o(true, this.b, this.c, this.d);
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

    public final void d0(@NonNull ViewGroup viewGroup, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, viewGroup, textView) == null) {
            View findViewById = viewGroup.findViewById(R.id.obfuscated_res_0x7f090ea8);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 0) {
                    textView.getLayoutParams().width = -1;
                } else {
                    textView.getLayoutParams().width = -2;
                }
            } else {
                textView.getLayoutParams().width = -2;
            }
            textView.requestLayout();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: f0 */
    public Holder O(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            return new Holder(c0(viewGroup.getContext()));
        }
        return (Holder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: g0 */
    public Holder Q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            return new Holder(c0(viewGroup.getContext()));
        }
        return (Holder) invokeL.objValue;
    }

    public final TextView c0(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            TextView textView = new TextView(context);
            textView.setId(R.id.obfuscated_res_0x7f090eb1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            layoutParams.gravity = 17;
            textView.setLayoutParams(layoutParams);
            textView.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            textView.setLineSpacing(1.0f, 1.2f);
            EMManager.from(textView).setTextSize(R.dimen.T_X05);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    public final void e0(@NonNull TextView textView, @NonNull TextMsg textMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, textView, textMsg) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            if (textMsg.getReMsgInfo() != null) {
                layoutParams.gravity = 16;
            } else {
                layoutParams.gravity = 17;
            }
        }
    }

    public final void i0(@NonNull ViewGroup viewGroup, @NonNull TextMsg textMsg) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, viewGroup, textMsg) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (textMsg.isLeft()) {
                i = R.drawable.selector_msg_text_bubble_other;
            } else {
                i = R.drawable.selector_msg_text_bubble_me;
            }
            viewGroup.setBackground(SkinManager.getDrawable(skinType, i));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    /* renamed from: h0 */
    public void V(int i, @NonNull ViewGroup viewGroup, @NonNull TextMsg textMsg, @NonNull Holder holder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), viewGroup, textMsg, holder, list, Integer.valueOf(i2)}) == null) {
            TextView textView = (TextView) holder.getView();
            tm8.b(textMsg.getAtUserInfoList());
            if (textMsg.getCacheText() != null) {
                textView.setText(textMsg.getCacheText());
            } else {
                n17.e(getContext(), textMsg.getText(), UtilHelper.getDimenPixelSize(R.dimen.T_X03), new a(this, textMsg, textView));
            }
            yj8.t(this.mType, textMsg, viewGroup, new b(this, viewGroup, textView, textMsg, i2));
            e0(textView, textMsg);
            d0(viewGroup, textView);
        }
    }
}

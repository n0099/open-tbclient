package com.baidu.tieba.im.under.common.uiliststyle.group.adapter;

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
import com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter;
import com.baidu.tieba.im.base.core.uilist.BaseViewHolder;
import com.baidu.tieba.im.lib.socket.msg.TbTextMsg;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.TextItem;
import com.baidu.tieba.oi8;
import com.baidu.tieba.pi8;
import com.baidu.tieba.vy6;
import com.baidu.tieba.xi8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class TextAdapter extends BaseStyleNormalAdapter<TextItem, Holder, BaseNormalAdapter.NonExtraHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.im.under.common.uiliststyle.group.adapter.BaseStyleNormalAdapter
    public boolean f0() {
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

        @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
        public void b(@Nullable View.OnLongClickListener onLongClickListener) {
            TextView textView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, onLongClickListener) == null) && (textView = this.a) != null) {
                textView.setOnLongClickListener(onLongClickListener);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements vy6.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextItem a;
        public final /* synthetic */ int b;
        public final /* synthetic */ TextView c;

        public a(TextAdapter textAdapter, TextItem textItem, int i, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textAdapter, textItem, Integer.valueOf(i), textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = textItem;
            this.b = i;
            this.c = textView;
        }

        @Override // com.baidu.tieba.vy6.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                xi8.a(spannableStringBuilder, oi8.u(this.a, this.b));
                this.a.setCacheText(spannableStringBuilder);
                this.c.setText(spannableStringBuilder);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements pi8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ TextItem c;
        public final /* synthetic */ int d;
        public final /* synthetic */ TextAdapter e;

        public b(TextAdapter textAdapter, ViewGroup viewGroup, TextView textView, TextItem textItem, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textAdapter, viewGroup, textView, textItem, Integer.valueOf(i)};
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
            this.c = textItem;
            this.d = i;
        }

        @Override // com.baidu.tieba.pi8
        public void a(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
                this.a.setBackground(drawable);
                oi8.o(false, this.b, this.c, this.d);
            }
        }

        @Override // com.baidu.tieba.pi8
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.e.n0(this.a, this.c);
                oi8.o(true, this.b, this.c, this.d);
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

    public final void i0(@NonNull ViewGroup viewGroup, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, viewGroup, textView) == null) {
            View findViewById = viewGroup.findViewById(R.id.obfuscated_res_0x7f090ec6);
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
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    @NonNull
    /* renamed from: k0 */
    public Holder N(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            return new Holder(h0(viewGroup.getContext()));
        }
        return (Holder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    @NonNull
    /* renamed from: l0 */
    public Holder P(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            return new Holder(h0(viewGroup.getContext()));
        }
        return (Holder) invokeL.objValue;
    }

    public final TextView h0(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            TextView textView = new TextView(context);
            textView.setId(R.id.obfuscated_res_0x7f090ece);
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

    public final void j0(@NonNull TextView textView, @NonNull TbTextMsg tbTextMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, textView, tbTextMsg) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            if (tbTextMsg.getReMsgInfo() != null) {
                layoutParams.gravity = 16;
            } else {
                layoutParams.gravity = 17;
            }
        }
    }

    public final void n0(@NonNull ViewGroup viewGroup, @NonNull TextItem textItem) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, viewGroup, textItem) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (textItem.isLeft()) {
                i = R.drawable.selector_msg_text_bubble_other;
            } else {
                i = R.drawable.selector_msg_text_bubble_me;
            }
            viewGroup.setBackground(SkinManager.getDrawable(skinType, i));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    /* renamed from: m0 */
    public void U(int i, @NonNull ViewGroup viewGroup, @NonNull TextItem textItem, @NonNull Holder holder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), viewGroup, textItem, holder, list, Integer.valueOf(i2)}) == null) {
            TextView textView = (TextView) holder.getView();
            TbTextMsg tbMsg = textItem.getTbMsg();
            xi8.b(tbMsg.getAtUserInfoList());
            textView.setText(textItem.getTbMsg().getText());
            if (textItem.getCacheText() != null) {
                textView.setText(textItem.getCacheText());
            } else {
                vy6.e(C(), tbMsg.getText(), UtilHelper.getDimenPixelSize(R.dimen.T_X03), new a(this, textItem, i2, textView));
            }
            oi8.t(this.mType, textItem, viewGroup, new b(this, viewGroup, textView, textItem, i2));
            j0(textView, tbMsg);
            i0(viewGroup, textView);
        }
    }
}

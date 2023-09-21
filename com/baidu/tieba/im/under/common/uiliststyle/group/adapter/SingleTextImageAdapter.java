package com.baidu.tieba.im.under.common.uiliststyle.group.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.eo8;
import com.baidu.tieba.fo8;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter;
import com.baidu.tieba.im.base.core.uilist.BaseViewHolder;
import com.baidu.tieba.im.lib.socket.msg.TbBaseImageMsg;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbSingleTextImageMsg;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.SingleTextImageItem;
import com.baidu.tieba.im.under.common.uiliststyle.group.view.TextGenImageView;
import com.baidu.tieba.th8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Objects;
/* loaded from: classes6.dex */
public class SingleTextImageAdapter extends BaseStyleNormalAdapter<SingleTextImageItem, Holder, BaseNormalAdapter.NonExtraHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String m;

    @Override // com.baidu.tieba.im.under.common.uiliststyle.group.adapter.BaseStyleNormalAdapter
    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static class Holder extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public final TextGenImageView b;

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
            this.b = (TextGenImageView) view2;
        }

        @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
        public void b(@Nullable View.OnLongClickListener onLongClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLongClickListener) == null) {
                View view2 = this.a;
                if (view2 != null) {
                    view2.setOnLongClickListener(onLongClickListener);
                }
                TextGenImageView textGenImageView = this.b;
                if (textGenImageView != null && textGenImageView.getImageWithTailView() != null && this.b.getImageWithTailView().getImage() != null) {
                    this.b.getImageWithTailView().getImage().setOnLongClickListener(onLongClickListener);
                }
            }
        }

        @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
        public void a(@Nullable View.OnClickListener onClickListener) {
            TextGenImageView textGenImageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) && (textGenImageView = this.b) != null) {
                textGenImageView.getImageWithTailView().getImage().setOnClickListener(onClickListener);
            }
        }

        public void f(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
                this.a = view2;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SingleTextImageItem a;
        public final /* synthetic */ String b;

        public a(SingleTextImageAdapter singleTextImageAdapter, SingleTextImageItem singleTextImageItem, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleTextImageAdapter, singleTextImageItem, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = singleTextImageItem;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f090e92) {
                SingleTextImageAdapter.i0(view2.getContext(), (TbBaseImageMsg) this.a.getTbMsg(), this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements fo8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ TextGenImageView b;
        public final /* synthetic */ BaseItem c;
        public final /* synthetic */ int d;

        public b(ViewGroup viewGroup, TextGenImageView textGenImageView, BaseItem baseItem, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewGroup, textGenImageView, baseItem, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.b = textGenImageView;
            this.c = baseItem;
            this.d = i;
        }

        @Override // com.baidu.tieba.fo8
        public void a(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
                this.a.setBackground(drawable);
                eo8.o(false, this.b.getTextView(), this.c, this.d);
            }
        }

        @Override // com.baidu.tieba.fo8
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SingleTextImageAdapter.m0(this.a, (TbSingleTextImageMsg) this.c.getTbMsg());
                eo8.o(true, this.b.getTextView(), this.c, this.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleTextImageAdapter(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
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

    public static void m0(@NonNull ViewGroup viewGroup, @NonNull TbSingleTextImageMsg tbSingleTextImageMsg) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, viewGroup, tbSingleTextImageMsg) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!tbSingleTextImageMsg.isMaster()) {
                i = R.drawable.selector_msg_text_bubble_other;
            } else {
                i = R.drawable.selector_msg_text_bubble_me;
            }
            viewGroup.setBackground(SkinManager.getDrawable(skinType, i));
        }
    }

    public static TextGenImageView g0(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            TextGenImageView textGenImageView = new TextGenImageView(context);
            textGenImageView.setId(R.id.obfuscated_res_0x7f090eb4);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            layoutParams.gravity = 17;
            textGenImageView.setLayoutParams(layoutParams);
            textGenImageView.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            return textGenImageView;
        }
        return (TextGenImageView) invokeL.objValue;
    }

    public static void h0(int i, @NonNull ViewGroup viewGroup, @NonNull BaseItem<? extends TbSingleTextImageMsg> baseItem, @NonNull Holder holder, @NonNull List<Object> list, int i2, @NonNull BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), viewGroup, baseItem, holder, list, Integer.valueOf(i2), bdUniqueId}) == null) {
            TextGenImageView textGenImageView = holder.b;
            textGenImageView.b(holder, baseItem.getTbMsg(), i2);
            eo8.t(bdUniqueId, baseItem, viewGroup, new b(viewGroup, textGenImageView, baseItem, i2));
        }
    }

    public static void i0(@NonNull Context context, @NonNull TbBaseImageMsg tbBaseImageMsg, @NonNull String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, tbBaseImageMsg, str) == null) {
            long sessionId = tbBaseImageMsg.getSessionId();
            long a2 = ((TbBaseMsg.c) Objects.requireNonNull(tbBaseImageMsg.getForumExt())).a();
            String bigSrc = tbBaseImageMsg.getBigSrc();
            if (StringUtils.isNull(bigSrc)) {
                str2 = tbBaseImageMsg.getThumbUrl();
            } else {
                str2 = bigSrc;
            }
            if (StringUtils.isNull(str2)) {
                return;
            }
            new th8(context, str2, a2, str, sessionId, false).execute(new String[0]);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.m = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    @NonNull
    /* renamed from: j0 */
    public Holder M(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            Holder holder = new Holder(g0(viewGroup.getContext()));
            holder.f(viewGroup);
            return holder;
        }
        return (Holder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    @NonNull
    /* renamed from: k0 */
    public Holder O(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            Holder holder = new Holder(g0(viewGroup.getContext()));
            holder.f(viewGroup);
            return holder;
        }
        return (Holder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    /* renamed from: l0 */
    public void T(int i, @NonNull ViewGroup viewGroup, @NonNull SingleTextImageItem singleTextImageItem, @NonNull Holder holder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), viewGroup, singleTextImageItem, holder, list, Integer.valueOf(i2)}) == null) {
            h0(i, viewGroup, singleTextImageItem, holder, list, i2, this.mType);
            holder.a(new a(this, singleTextImageItem, this.m));
        }
    }
}

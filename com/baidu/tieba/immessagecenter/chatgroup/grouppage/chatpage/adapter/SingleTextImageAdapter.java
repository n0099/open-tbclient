package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter;

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
import com.baidu.tieba.el8;
import com.baidu.tieba.em8;
import com.baidu.tieba.hc8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.SingleTextImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.view.TextGenImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class SingleTextImageAdapter<T extends SingleTextImageMsg> extends BaseChatAdapter<T, Holder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String l;
    public hc8 m;

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void e0(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
        }
    }

    public void f0(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
        }
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void c(@Nullable View.OnLongClickListener onLongClickListener) {
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void b(@Nullable View.OnClickListener onClickListener) {
            TextGenImageView textGenImageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) && (textGenImageView = this.b) != null) {
                textGenImageView.getImageWithTailView().getImage().setOnClickListener(onClickListener);
            }
        }

        public void g(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
                this.a = view2;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements el8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ TextGenImageView b;
        public final /* synthetic */ SingleTextImageMsg c;
        public final /* synthetic */ int d;
        public final /* synthetic */ SingleTextImageAdapter e;

        public a(SingleTextImageAdapter singleTextImageAdapter, ViewGroup viewGroup, TextGenImageView textGenImageView, SingleTextImageMsg singleTextImageMsg, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleTextImageAdapter, viewGroup, textGenImageView, singleTextImageMsg, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = singleTextImageAdapter;
            this.a = viewGroup;
            this.b = textGenImageView;
            this.c = singleTextImageMsg;
            this.d = i;
        }

        @Override // com.baidu.tieba.el8
        public void a(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
                this.a.setBackground(drawable);
                em8.o(false, this.b.getTextView(), this.c, this.d);
            }
        }

        @Override // com.baidu.tieba.el8
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.e.g0(this.a, this.c);
                em8.o(true, this.b.getTextView(), this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SingleTextImageMsg a;
        public final /* synthetic */ SingleTextImageAdapter b;

        public b(SingleTextImageAdapter singleTextImageAdapter, SingleTextImageMsg singleTextImageMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleTextImageAdapter, singleTextImageMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = singleTextImageAdapter;
            this.a = singleTextImageMsg;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f090e7b) {
                this.b.a0(view2.getContext(), this.a);
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
        this.m = null;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.l = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: b0 */
    public Holder M(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            Holder holder = new Holder(Z(viewGroup.getContext()));
            holder.g(viewGroup);
            return holder;
        }
        return (Holder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    @NonNull
    /* renamed from: c0 */
    public Holder O(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            Holder holder = new Holder(Z(viewGroup.getContext()));
            holder.g(viewGroup);
            return holder;
        }
        return (Holder) invokeL.objValue;
    }

    public final TextGenImageView Z(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            TextGenImageView textGenImageView = new TextGenImageView(context);
            textGenImageView.setId(R.id.obfuscated_res_0x7f090ea0);
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

    public void a0(@NonNull Context context, @NonNull SingleTextImageMsg singleTextImageMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, singleTextImageMsg) == null) {
            CommonMsgField commonMsgField = singleTextImageMsg.getCommonMsgField();
            long roomId = commonMsgField.getRoomId();
            long forumId = commonMsgField.getForumId();
            String bigSrc = singleTextImageMsg.getBigSrc();
            if (StringUtils.isNull(bigSrc)) {
                bigSrc = singleTextImageMsg.getThumbUrl();
            }
            String str = bigSrc;
            if (StringUtils.isNull(str)) {
                return;
            }
            hc8 hc8Var = new hc8(this.mContext, str, forumId, this.l, roomId, false);
            this.m = hc8Var;
            hc8Var.execute(new String[0]);
            e0(roomId, forumId, this.l);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    /* renamed from: d0 */
    public void T(int i, @NonNull ViewGroup viewGroup, @NonNull T t, @NonNull Holder holder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), viewGroup, t, holder, list, Integer.valueOf(i2)}) == null) {
            TextGenImageView textGenImageView = holder.b;
            textGenImageView.b(holder, t, i2);
            em8.t(this.mType, t, viewGroup, new a(this, viewGroup, textGenImageView, t, i2));
            CommonMsgField commonMsgField = t.getCommonMsgField();
            f0(commonMsgField.getRoomId(), commonMsgField.getForumId(), this.l);
            holder.b(new b(this, t));
        }
    }

    public final void g0(@NonNull ViewGroup viewGroup, @NonNull BaseMsg baseMsg) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, viewGroup, baseMsg) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (baseMsg.isLeft()) {
                i = R.drawable.selector_msg_text_bubble_other;
            } else {
                i = R.drawable.selector_msg_text_bubble_me;
            }
            viewGroup.setBackground(SkinManager.getDrawable(skinType, i));
        }
    }
}

package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.feed.widget.AutoDegradeTagView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.view.ReplyContentView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.EmojiReplyView;
import com.baidu.tieba.lo8;
import com.baidu.tieba.qo8;
import com.baidu.tieba.qx5;
import com.baidu.tieba.zo8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class BaseChatAdapter<ChildItemData extends BaseMsg, ChildViewHolder extends BaseViewHolder> extends lo8<ChildItemData, Holder<ChildViewHolder>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public MsgSendHelper<? extends BaseChatAdapter, ChildItemData> k;

    public final boolean L(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i != 0 : invokeI.booleanValue;
    }

    public void M(@NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, frameLayout) == null) {
        }
    }

    @NonNull
    public abstract ChildViewHolder N(@NonNull ViewGroup viewGroup);

    public void O(@NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, frameLayout) == null) {
        }
    }

    @NonNull
    public abstract ChildViewHolder P(@NonNull ViewGroup viewGroup);

    public void T(int i, @NonNull ChildItemData childitemdata, @NonNull FrameLayout frameLayout, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), childitemdata, frameLayout, list, Integer.valueOf(i2)}) == null) {
        }
    }

    public abstract void U(int i, @NonNull ViewGroup viewGroup, @NonNull ChildItemData childitemdata, @NonNull ChildViewHolder childviewholder, @NonNull List<Object> list, int i2);

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static class Holder<ChildViewHolder extends BaseViewHolder> extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SelfHolder a;
        public SelfHolder b;
        public ChildViewHolder c;
        public ChildViewHolder d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Holder(@NonNull View view2, @NonNull SelfHolder selfHolder, @NonNull SelfHolder selfHolder2, @NonNull ChildViewHolder childviewholder, @NonNull ChildViewHolder childviewholder2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, selfHolder, selfHolder2, childviewholder, childviewholder2};
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
            c(this);
            this.a = selfHolder;
            this.b = selfHolder2;
            selfHolder.c(this);
            selfHolder2.c(this);
            this.c = childviewholder;
            this.d = childviewholder2;
            childviewholder.c(this);
            childviewholder2.c(this);
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void a(@Nullable View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
                this.a.a(onClickListener);
                this.b.a(onClickListener);
                this.c.a(onClickListener);
                this.d.a(onClickListener);
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void b(@Nullable View.OnLongClickListener onLongClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLongClickListener) == null) {
                super.b(onLongClickListener);
                this.a.b(onLongClickListener);
                this.b.b(onLongClickListener);
                this.c.b(onLongClickListener);
                this.d.b(onLongClickListener);
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void d(@NonNull qo8 qo8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qo8Var) == null) {
                super.d(qo8Var);
                this.a.d(qo8Var);
                this.b.d(qo8Var);
                this.c.d(qo8Var);
                this.d.d(qo8Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class SelfHolder extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;
        public TextView b;
        public TextView c;
        public ImageView d;
        public ImageView e;
        public ProgressBar f;
        public RelativeLayout g;
        public TbImage h;
        public TbImage i;
        public LinearLayout j;
        public FrameLayout k;
        public FrameLayout l;
        public EmojiReplyView m;
        public ViewGroup n;
        public TbImageView o;
        public TextView p;
        @Nullable
        public ReplyContentView q;
        public AutoDegradeTagView r;
        public TextView s;
        public LinearLayout t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelfHolder(@NonNull View view2, boolean z) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Boolean.valueOf(z)};
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
            this.a = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09031c);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091982);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092883);
            this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092891);
            this.e = (ImageView) view2.findViewById(R.id.btn_msgitem_resend);
            this.f = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f091dad);
            this.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090518);
            this.h = (TbImage) view2.findViewById(R.id.obfuscated_res_0x7f090517);
            this.i = (TbImage) view2.findViewById(R.id.obfuscated_res_0x7f090516);
            this.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0907aa);
            this.k = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090abd);
            this.l = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090024);
            this.m = (EmojiReplyView) view2.findViewById(R.id.obfuscated_res_0x7f0909a2);
            this.n = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0908d9);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0908d8);
            this.o = tbImageView;
            tbImageView.setPlaceHolder(0);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0908d7);
            this.s = (TextView) view2.findViewById(R.id.kaogao_icon);
            this.t = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e1a);
            AutoDegradeTagView autoDegradeTagView = (AutoDegradeTagView) view2.findViewById(R.id.obfuscated_res_0x7f092889);
            this.r = autoDegradeTagView;
            if (autoDegradeTagView.getLayoutParams() != null) {
                this.r.getLayoutParams().height = BdUtilHelper.getDimens(view2.getContext(), R.dimen.tbds44);
            }
            this.r.setTagConfig(BdUtilHelper.getDimens(view2.getContext(), R.dimen.T_X08), BdUtilHelper.getDimens(view2.getContext(), R.dimen.tbds35), BdUtilHelper.getDimens(view2.getContext(), R.dimen.M_W_X002), R.color.CAM_X0105);
            if (z && view2.getContext() != null) {
                ReplyContentView f = zo8.f(view2.getContext());
                this.q = f;
                this.j.addView(f);
            }
            Context context = view2.getContext();
            if (context != null) {
                this.l.addView(zo8.d(context));
            }
            zo8.e(this.m);
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void a(@Nullable View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) && onClickListener != null) {
                this.a.setOnClickListener(onClickListener);
                this.e.setOnClickListener(onClickListener);
                ReplyContentView replyContentView = this.q;
                if (replyContentView != null) {
                    replyContentView.setOnClickListener(onClickListener);
                }
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void b(@Nullable View.OnLongClickListener onLongClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLongClickListener) == null) {
                super.b(onLongClickListener);
                if (onLongClickListener != null) {
                    this.j.setOnLongClickListener(onLongClickListener);
                }
                ReplyContentView replyContentView = this.q;
                if (replyContentView != null) {
                    replyContentView.setOnLongClickListener(onLongClickListener);
                }
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void d(@NonNull qo8 qo8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qo8Var) == null) {
                super.d(qo8Var);
                qo8.d(this.e, qo8Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseChatAdapter(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
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

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter<ChildItemData extends com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg, ChildViewHolder extends com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.pm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        X(i, view2, viewGroup, (BaseMsg) obj, (Holder) viewHolder);
        return view2;
    }

    public <T extends BaseChatAdapter> void J(@NonNull MsgSendHelper<T, ChildItemData> msgSendHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, msgSendHelper) == null) {
            this.k = msgSendHelper;
            msgSendHelper.f(this);
            this.i.c(msgSendHelper);
        }
    }

    public final SelfHolder Q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            return new SelfHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0468, viewGroup, false), a0());
        }
        return (SelfHolder) invokeL.objValue;
    }

    public final SelfHolder R(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            return new SelfHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0469, viewGroup, false), a0());
        }
        return (SelfHolder) invokeL.objValue;
    }

    public final void K(Holder<ChildViewHolder> holder, ChildItemData childitemdata, int i) {
        SelfHolder selfHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, holder, childitemdata, i) == null) && i == 1) {
            Context context = this.mContext;
            if (childitemdata.isLeft()) {
                selfHolder = holder.a;
            } else {
                selfHolder = holder.b;
            }
            zo8.m(context, childitemdata, selfHolder, B(), A());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: S */
    public final Holder<ChildViewHolder> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            SelfHolder Q = Q(viewGroup);
            SelfHolder R = R(viewGroup);
            ChildViewHolder N = N(Q.j);
            ChildViewHolder P = P(R.j);
            boolean z2 = true;
            if (N.itemView.getParent() == null) {
                z = true;
            } else {
                z = false;
            }
            qx5.e(z, "子类视图不需要手动添加到父布局中");
            if (P.itemView.getParent() != null) {
                z2 = false;
            }
            qx5.e(z2, "子类视图不需要手动添加到父布局中");
            Q.j.addView(N.itemView);
            R.j.addView(P.itemView);
            M(Q.k);
            O(R.k);
            frameLayout.addView(Q.itemView);
            frameLayout.addView(R.itemView);
            Holder<ChildViewHolder> holder = new Holder<>(frameLayout, Q, R, N, P);
            H(holder);
            return holder;
        }
        return (Holder) invokeL.objValue;
    }

    public final void W(int i, @NonNull ViewGroup viewGroup, @NonNull ChildItemData childitemdata, @NonNull SelfHolder selfHolder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), viewGroup, childitemdata, selfHolder, list, Integer.valueOf(i2)}) == null) {
            zo8.j(childitemdata, selfHolder);
            zo8.i(childitemdata, selfHolder);
            zo8.n(childitemdata, selfHolder);
            zo8.k(this.mContext, childitemdata, selfHolder, B(), A());
            zo8.m(this.mContext, childitemdata, selfHolder, B(), A());
            zo8.l(this.mContext, childitemdata, selfHolder, D(), B());
        }
    }

    public final View X(int i, View view2, ViewGroup viewGroup, ChildItemData childitemdata, Holder<ChildViewHolder> holder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), view2, viewGroup, childitemdata, holder})) == null) {
            onFillViewHolder(i, viewGroup, holder, childitemdata, Collections.EMPTY_LIST);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lo8, com.baidu.tieba.pm
    /* renamed from: Y */
    public void onFillViewHolder(int i, ViewGroup viewGroup, Holder<ChildViewHolder> holder, ChildItemData childitemdata, @NonNull List<Object> list) {
        SelfHolder selfHolder;
        SelfHolder selfHolder2;
        ChildViewHolder childviewholder;
        SelfHolder selfHolder3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), viewGroup, holder, childitemdata, list}) == null) {
            int Z = Z(list);
            if (L(Z)) {
                K(holder, childitemdata, Z);
                return;
            }
            super.onFillViewHolder(i, viewGroup, holder, childitemdata, list);
            boolean isLeft = childitemdata.isLeft();
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (isLeft) {
                holder.a.itemView.setVisibility(0);
                holder.b.itemView.setVisibility(8);
            } else {
                holder.a.itemView.setVisibility(8);
                holder.b.itemView.setVisibility(0);
            }
            ViewGroup viewGroup2 = (ViewGroup) holder.itemView;
            if (isLeft) {
                selfHolder = holder.a;
            } else {
                selfHolder = holder.b;
            }
            W(i, viewGroup2, childitemdata, selfHolder, list, skinType);
            if (isLeft) {
                selfHolder2 = holder.a;
            } else {
                selfHolder2 = holder.b;
            }
            LinearLayout linearLayout = selfHolder2.j;
            if (isLeft) {
                childviewholder = holder.c;
            } else {
                childviewholder = holder.d;
            }
            U(i, linearLayout, childitemdata, childviewholder, list, skinType);
            if (isLeft) {
                selfHolder3 = holder.a;
            } else {
                selfHolder3 = holder.b;
            }
            T(i, childitemdata, selfHolder3.k, list, skinType);
            qx5.c(this.k, "必须绑定消费发送帮助器");
            if (childitemdata.getItemStatus() == 0) {
                this.k.n(childitemdata, i);
            }
            zo8.h(D(), childitemdata, holder.itemView);
        }
    }

    public final int Z(@NonNull List<Object> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, list)) == null) {
            int i = 0;
            if (list.isEmpty()) {
                return 0;
            }
            for (Object obj : list) {
                if (obj instanceof Integer) {
                    i = ((Integer) obj).intValue();
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.lo8
    @NonNull
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }
}

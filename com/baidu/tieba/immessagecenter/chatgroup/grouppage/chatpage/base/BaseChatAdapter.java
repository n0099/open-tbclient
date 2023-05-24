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
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.b98;
import com.baidu.tieba.c98;
import com.baidu.tieba.feed.widget.AutoDegradeTagView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.view.ReplyContentView;
import com.baidu.tieba.l98;
import com.baidu.tieba.ri;
import com.baidu.tieba.w88;
import com.baidu.tieba.xs5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class BaseChatAdapter<ChildItemData extends BaseMsg, ChildViewHolder extends BaseViewHolder> extends w88<ChildItemData, Holder<ChildViewHolder>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public b98<? extends BaseChatAdapter, ChildItemData> i;

    public void I(@NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frameLayout) == null) {
        }
    }

    @NonNull
    public abstract ChildViewHolder J(@NonNull ViewGroup viewGroup);

    public void K(@NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, frameLayout) == null) {
        }
    }

    @NonNull
    public abstract ChildViewHolder M(@NonNull ViewGroup viewGroup);

    public void Q(int i, @NonNull ChildItemData childitemdata, @NonNull FrameLayout frameLayout, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), childitemdata, frameLayout, list, Integer.valueOf(i2)}) == null) {
        }
    }

    public abstract void R(int i, @NonNull ViewGroup viewGroup, @NonNull ChildItemData childitemdata, @NonNull ChildViewHolder childviewholder, @NonNull List<Object> list, int i2);

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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
        public void d(@NonNull c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c98Var) == null) {
                super.d(c98Var);
                this.a.d(c98Var);
                this.b.d(c98Var);
                this.c.d(c98Var);
                this.d.d(c98Var);
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
        public ViewGroup m;
        public TbImageView n;
        public TextView o;
        @Nullable
        public ReplyContentView p;
        public AutoDegradeTagView q;
        public TextView r;
        public LinearLayout s;

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
            this.a = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090317);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918a3);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092723);
            this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092730);
            this.e = (ImageView) view2.findViewById(R.id.btn_msgitem_resend);
            this.f = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f091c9b);
            this.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0904f8);
            this.h = (TbImage) view2.findViewById(R.id.obfuscated_res_0x7f0904f7);
            this.i = (TbImage) view2.findViewById(R.id.obfuscated_res_0x7f0904f6);
            this.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090792);
            this.k = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a87);
            this.l = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090024);
            this.m = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0908b8);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0908b7);
            this.n = tbImageView;
            tbImageView.setPlaceHolder(0);
            this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0908b6);
            this.r = (TextView) view2.findViewById(R.id.kaogao_icon);
            this.s = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090dd8);
            AutoDegradeTagView autoDegradeTagView = (AutoDegradeTagView) view2.findViewById(R.id.obfuscated_res_0x7f092728);
            this.q = autoDegradeTagView;
            if (autoDegradeTagView.getLayoutParams() != null) {
                this.q.getLayoutParams().height = ri.g(view2.getContext(), R.dimen.tbds44);
            }
            this.q.setTagConfig(ri.g(view2.getContext(), R.dimen.T_X08), ri.g(view2.getContext(), R.dimen.tbds35), ri.g(view2.getContext(), R.dimen.M_W_X002), R.color.CAM_X0105);
            if (z && view2.getContext() != null) {
                ReplyContentView e = l98.e(view2.getContext());
                this.p = e;
                this.j.addView(e);
            }
            if (view2.getContext() != null) {
                this.l.addView(l98.d(view2.getContext()));
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void a(@Nullable View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) && onClickListener != null) {
                this.a.setOnClickListener(onClickListener);
                this.e.setOnClickListener(onClickListener);
                ReplyContentView replyContentView = this.p;
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
                ReplyContentView replyContentView = this.p;
                if (replyContentView != null) {
                    replyContentView.setOnLongClickListener(onLongClickListener);
                }
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void d(@NonNull c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c98Var) == null) {
                super.d(c98Var);
                c98.d(this.e, c98Var);
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
    @Override // com.baidu.tieba.en
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        T(i, view2, viewGroup, (BaseMsg) obj, (Holder) viewHolder);
        return view2;
    }

    public <T extends BaseChatAdapter> void H(@NonNull b98<T, ChildItemData> b98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b98Var) == null) {
            this.i = b98Var;
            b98Var.f(this);
            this.g.c(b98Var);
        }
    }

    public final SelfHolder N(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            return new SelfHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d043f, viewGroup, false), V());
        }
        return (SelfHolder) invokeL.objValue;
    }

    public final SelfHolder O(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            return new SelfHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0440, viewGroup, false), V());
        }
        return (SelfHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.en
    /* renamed from: P */
    public final Holder<ChildViewHolder> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            SelfHolder N = N(viewGroup);
            SelfHolder O = O(viewGroup);
            ChildViewHolder J = J(N.j);
            ChildViewHolder M = M(O.j);
            boolean z2 = true;
            if (J.itemView.getParent() == null) {
                z = true;
            } else {
                z = false;
            }
            xs5.e(z, "子类视图不需要手动添加到父布局中");
            if (M.itemView.getParent() != null) {
                z2 = false;
            }
            xs5.e(z2, "子类视图不需要手动添加到父布局中");
            N.j.addView(J.itemView);
            O.j.addView(M.itemView);
            I(N.k);
            K(O.k);
            frameLayout.addView(N.itemView);
            frameLayout.addView(O.itemView);
            Holder<ChildViewHolder> holder = new Holder<>(frameLayout, N, O, J, M);
            G(holder);
            return holder;
        }
        return (Holder) invokeL.objValue;
    }

    public final void S(int i, @NonNull ViewGroup viewGroup, @NonNull ChildItemData childitemdata, @NonNull SelfHolder selfHolder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), viewGroup, childitemdata, selfHolder, list, Integer.valueOf(i2)}) == null) {
            l98.i(childitemdata, selfHolder);
            l98.h(childitemdata, selfHolder);
            l98.l(childitemdata, selfHolder);
            l98.j(this.mContext, childitemdata, selfHolder, A());
            l98.k(this.mContext, childitemdata, selfHolder, C(), A());
        }
    }

    public final View T(int i, View view2, ViewGroup viewGroup, ChildItemData childitemdata, Holder<ChildViewHolder> holder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), view2, viewGroup, childitemdata, holder})) == null) {
            onFillViewHolder(i, viewGroup, holder, childitemdata, Collections.EMPTY_LIST);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w88, com.baidu.tieba.en
    /* renamed from: U */
    public void onFillViewHolder(int i, ViewGroup viewGroup, Holder<ChildViewHolder> holder, ChildItemData childitemdata, @NonNull List<Object> list) {
        SelfHolder selfHolder;
        SelfHolder selfHolder2;
        ChildViewHolder childviewholder;
        SelfHolder selfHolder3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), viewGroup, holder, childitemdata, list}) == null) {
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
            S(i, viewGroup2, childitemdata, selfHolder, list, skinType);
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
            R(i, linearLayout, childitemdata, childviewholder, list, skinType);
            if (isLeft) {
                selfHolder3 = holder.a;
            } else {
                selfHolder3 = holder.b;
            }
            Q(i, childitemdata, selfHolder3.k, list, skinType);
            xs5.c(this.i, "必须绑定消费发送帮助器");
            if (childitemdata.getItemStatus() == 0) {
                this.i.m(childitemdata, i);
            }
            l98.g(C(), childitemdata, holder.itemView);
        }
    }

    @Override // com.baidu.tieba.w88
    @NonNull
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }
}

package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.cl7;
import com.baidu.tieba.fl7;
import com.baidu.tieba.gl7;
import com.baidu.tieba.hl7;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.view.ReplyContentView;
import com.baidu.tieba.sk5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class BaseChatAdapter<ChildItemData extends BaseMsg, ChildViewHolder extends BaseViewHolder> extends cl7<ChildItemData, Holder<ChildViewHolder>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public fl7<? extends BaseChatAdapter, ChildItemData> f;

    public void A(@NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) {
        }
    }

    @NonNull
    public abstract ChildViewHolder B(@NonNull ViewGroup viewGroup);

    public void C(@NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frameLayout) == null) {
        }
    }

    @NonNull
    public abstract ChildViewHolder D(@NonNull ViewGroup viewGroup);

    public void H(int i, @NonNull ChildItemData childitemdata, @NonNull FrameLayout frameLayout, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), childitemdata, frameLayout, list, Integer.valueOf(i2)}) == null) {
        }
    }

    public abstract void J(int i, @NonNull ViewGroup viewGroup, @NonNull ChildItemData childitemdata, @NonNull ChildViewHolder childviewholder, @NonNull List<Object> list, int i2);

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
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

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void a(@Nullable View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
                this.a.a(onClickListener);
                this.b.a(onClickListener);
                this.c.a(onClickListener);
                this.d.a(onClickListener);
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
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

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void d(@NonNull gl7 gl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gl7Var) == null) {
                super.d(gl7Var);
                this.a.d(gl7Var);
                this.b.d(gl7Var);
                this.c.d(gl7Var);
                this.d.d(gl7Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class SelfHolder extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;
        public TextView b;
        public TextView c;
        public ImageView d;
        public ImageView e;
        public ProgressBar f;
        public LinearLayout g;
        public FrameLayout h;
        @Nullable
        public ReplyContentView i;

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
            this.a = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090311);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09176d);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092598);
            this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0925a4);
            this.e = (ImageView) view2.findViewById(R.id.btn_msgitem_resend);
            this.f = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f091b80);
            this.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906fb);
            this.h = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0909a0);
            if (z && view2.getContext() != null) {
                ReplyContentView d = hl7.d(view2.getContext());
                this.i = d;
                this.g.addView(d);
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void a(@Nullable View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) && onClickListener != null) {
                this.a.setOnClickListener(onClickListener);
                this.e.setOnClickListener(onClickListener);
                ReplyContentView replyContentView = this.i;
                if (replyContentView != null) {
                    replyContentView.setOnClickListener(onClickListener);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void b(@Nullable View.OnLongClickListener onLongClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLongClickListener) == null) {
                super.b(onLongClickListener);
                if (onLongClickListener != null) {
                    this.g.setOnLongClickListener(onLongClickListener);
                }
                ReplyContentView replyContentView = this.i;
                if (replyContentView != null) {
                    replyContentView.setOnLongClickListener(onLongClickListener);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void d(@NonNull gl7 gl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gl7Var) == null) {
                super.d(gl7Var);
                gl7.d(this.e, gl7Var);
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

    public final SelfHolder E(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            return new SelfHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d03ff, viewGroup, false), N());
        }
        return (SelfHolder) invokeL.objValue;
    }

    public final SelfHolder F(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            return new SelfHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0400, viewGroup, false), N());
        }
        return (SelfHolder) invokeL.objValue;
    }

    public <T extends BaseChatAdapter> void z(@NonNull fl7<T, ChildItemData> fl7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, fl7Var) == null) {
            this.f = fl7Var;
            fl7Var.f(this);
            this.e.c(fl7Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: G */
    public final Holder<ChildViewHolder> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            SelfHolder E = E(viewGroup);
            SelfHolder F = F(viewGroup);
            ChildViewHolder B = B(E.g);
            ChildViewHolder D = D(F.g);
            boolean z2 = true;
            if (B.itemView.getParent() == null) {
                z = true;
            } else {
                z = false;
            }
            sk5.e(z, "子类视图不需要手动添加到父布局中");
            if (D.itemView.getParent() != null) {
                z2 = false;
            }
            sk5.e(z2, "子类视图不需要手动添加到父布局中");
            E.g.addView(B.itemView);
            F.g.addView(D.itemView);
            A(E.h);
            C(F.h);
            frameLayout.addView(E.itemView);
            frameLayout.addView(F.itemView);
            Holder<ChildViewHolder> holder = new Holder<>(frameLayout, E, F, B, D);
            y(holder);
            return holder;
        }
        return (Holder) invokeL.objValue;
    }

    public final void K(int i, @NonNull ViewGroup viewGroup, @NonNull ChildItemData childitemdata, @NonNull SelfHolder selfHolder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), viewGroup, childitemdata, selfHolder, list, Integer.valueOf(i2)}) == null) {
            hl7.g(childitemdata, selfHolder);
            hl7.f(childitemdata, selfHolder);
            hl7.h(childitemdata, selfHolder);
        }
    }

    public final View L(int i, View view2, ViewGroup viewGroup, ChildItemData childitemdata, Holder<ChildViewHolder> holder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), view2, viewGroup, childitemdata, holder})) == null) {
            onFillViewHolder(i, viewGroup, holder, childitemdata, Collections.EMPTY_LIST);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: M */
    public void onFillViewHolder(int i, ViewGroup viewGroup, Holder<ChildViewHolder> holder, ChildItemData childitemdata, @NonNull List<Object> list) {
        SelfHolder selfHolder;
        SelfHolder selfHolder2;
        ChildViewHolder childviewholder;
        SelfHolder selfHolder3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), viewGroup, holder, childitemdata, list}) == null) {
            super.onFillViewHolder(i, viewGroup, (ViewGroup) holder, (Holder<ChildViewHolder>) childitemdata, list);
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
            K(i, viewGroup2, childitemdata, selfHolder, list, skinType);
            if (isLeft) {
                selfHolder2 = holder.a;
            } else {
                selfHolder2 = holder.b;
            }
            LinearLayout linearLayout = selfHolder2.g;
            if (isLeft) {
                childviewholder = holder.c;
            } else {
                childviewholder = holder.d;
            }
            J(i, linearLayout, childitemdata, childviewholder, list, skinType);
            if (isLeft) {
                selfHolder3 = holder.a;
            } else {
                selfHolder3 = holder.b;
            }
            H(i, childitemdata, selfHolder3.h, list, skinType);
            sk5.c(this.f, "必须绑定消费发送帮助器");
            if (childitemdata.getItemStatus() == 0) {
                this.f.m(childitemdata, i);
            }
        }
    }

    @Override // com.baidu.tieba.cl7
    @NonNull
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter<ChildItemData extends com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg, ChildViewHolder extends com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.ln
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        L(i, view2, viewGroup, (BaseMsg) obj, (Holder) viewHolder);
        return view2;
    }
}

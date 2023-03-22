package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.view.ReplyContentView;
import com.baidu.tieba.iv7;
import com.baidu.tieba.mv7;
import com.baidu.tieba.nv7;
import com.baidu.tieba.ov7;
import com.baidu.tieba.pp5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class BaseChatAdapter<ChildItemData extends BaseMsg, ChildViewHolder extends BaseViewHolder> extends iv7<ChildItemData, Holder<ChildViewHolder>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public mv7<? extends BaseChatAdapter, ChildItemData> g;

    public void E(@NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frameLayout) == null) {
        }
    }

    @NonNull
    public abstract ChildViewHolder F(@NonNull ViewGroup viewGroup);

    public void G(@NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, frameLayout) == null) {
        }
    }

    @NonNull
    public abstract ChildViewHolder H(@NonNull ViewGroup viewGroup);

    public void M(int i, @NonNull ChildItemData childitemdata, @NonNull FrameLayout frameLayout, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), childitemdata, frameLayout, list, Integer.valueOf(i2)}) == null) {
        }
    }

    public abstract void N(int i, @NonNull ViewGroup viewGroup, @NonNull ChildItemData childitemdata, @NonNull ChildViewHolder childviewholder, @NonNull List<Object> list, int i2);

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
        public void d(@NonNull nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nv7Var) == null) {
                super.d(nv7Var);
                this.a.d(nv7Var);
                this.b.d(nv7Var);
                this.c.d(nv7Var);
                this.d.d(nv7Var);
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
        public FrameLayout i;
        public ViewGroup j;
        public TbImageView k;
        public TextView l;
        @Nullable
        public ReplyContentView m;

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
            this.a = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090316);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091846);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926a7);
            this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0926b3);
            this.e = (ImageView) view2.findViewById(R.id.btn_msgitem_resend);
            this.f = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f091c48);
            this.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09076e);
            this.h = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a55);
            this.i = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090024);
            this.j = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f090896);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090895);
            this.k = tbImageView;
            tbImageView.setPlaceHolder(0);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090894);
            if (z && view2.getContext() != null) {
                ReplyContentView e = ov7.e(view2.getContext());
                this.m = e;
                this.g.addView(e);
            }
            if (view2.getContext() != null) {
                this.i.addView(ov7.d(view2.getContext()));
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void a(@Nullable View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) && onClickListener != null) {
                this.a.setOnClickListener(onClickListener);
                this.e.setOnClickListener(onClickListener);
                ReplyContentView replyContentView = this.m;
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
                    this.g.setOnLongClickListener(onLongClickListener);
                }
                ReplyContentView replyContentView = this.m;
                if (replyContentView != null) {
                    replyContentView.setOnLongClickListener(onLongClickListener);
                }
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void d(@NonNull nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nv7Var) == null) {
                super.d(nv7Var);
                nv7.d(this.e, nv7Var);
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

    public <T extends BaseChatAdapter> void D(@NonNull mv7<T, ChildItemData> mv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mv7Var) == null) {
            this.g = mv7Var;
            mv7Var.f(this);
            this.f.c(mv7Var);
        }
    }

    public final SelfHolder I(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            return new SelfHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d041c, viewGroup, false), R());
        }
        return (SelfHolder) invokeL.objValue;
    }

    public final SelfHolder J(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            return new SelfHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d041d, viewGroup, false), R());
        }
        return (SelfHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: L */
    public final Holder<ChildViewHolder> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            SelfHolder I = I(viewGroup);
            SelfHolder J = J(viewGroup);
            ChildViewHolder F = F(I.g);
            ChildViewHolder H = H(J.g);
            boolean z2 = true;
            if (F.itemView.getParent() == null) {
                z = true;
            } else {
                z = false;
            }
            pp5.e(z, "子类视图不需要手动添加到父布局中");
            if (H.itemView.getParent() != null) {
                z2 = false;
            }
            pp5.e(z2, "子类视图不需要手动添加到父布局中");
            I.g.addView(F.itemView);
            J.g.addView(H.itemView);
            E(I.h);
            G(J.h);
            frameLayout.addView(I.itemView);
            frameLayout.addView(J.itemView);
            Holder<ChildViewHolder> holder = new Holder<>(frameLayout, I, J, F, H);
            C(holder);
            return holder;
        }
        return (Holder) invokeL.objValue;
    }

    public final void O(int i, @NonNull ViewGroup viewGroup, @NonNull ChildItemData childitemdata, @NonNull SelfHolder selfHolder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), viewGroup, childitemdata, selfHolder, list, Integer.valueOf(i2)}) == null) {
            ov7.h(childitemdata, selfHolder);
            ov7.g(childitemdata, selfHolder);
            ov7.j(childitemdata, selfHolder);
            ov7.i(this.mContext, childitemdata, selfHolder, y());
        }
    }

    public final View P(int i, View view2, ViewGroup viewGroup, ChildItemData childitemdata, Holder<ChildViewHolder> holder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), view2, viewGroup, childitemdata, holder})) == null) {
            onFillViewHolder(i, viewGroup, holder, childitemdata, Collections.EMPTY_LIST);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: Q */
    public void onFillViewHolder(int i, ViewGroup viewGroup, Holder<ChildViewHolder> holder, ChildItemData childitemdata, @NonNull List<Object> list) {
        SelfHolder selfHolder;
        SelfHolder selfHolder2;
        ChildViewHolder childviewholder;
        SelfHolder selfHolder3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), viewGroup, holder, childitemdata, list}) == null) {
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
            O(i, viewGroup2, childitemdata, selfHolder, list, skinType);
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
            N(i, linearLayout, childitemdata, childviewholder, list, skinType);
            if (isLeft) {
                selfHolder3 = holder.a;
            } else {
                selfHolder3 = holder.b;
            }
            M(i, childitemdata, selfHolder3.h, list, skinType);
            pp5.c(this.g, "必须绑定消费发送帮助器");
            if (childitemdata.getItemStatus() == 0) {
                this.g.m(childitemdata, i);
            }
        }
    }

    @Override // com.baidu.tieba.iv7
    @NonNull
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter<ChildItemData extends com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg, ChildViewHolder extends com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.tm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        P(i, view2, viewGroup, (BaseMsg) obj, (Holder) viewHolder);
        return view2;
    }
}

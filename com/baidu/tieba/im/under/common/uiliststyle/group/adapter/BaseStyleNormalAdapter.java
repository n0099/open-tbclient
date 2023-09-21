package com.baidu.tieba.im.under.common.uiliststyle.group.adapter;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.bg8;
import com.baidu.tieba.eo8;
import com.baidu.tieba.feed.widget.AutoDegradeTagView;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter;
import com.baidu.tieba.im.base.core.uilist.BaseViewHolder;
import com.baidu.tieba.im.base.core.uilist.ReplyContentView;
import com.baidu.tieba.im.lib.socket.msg.TbNormalMsg;
import com.baidu.tieba.im.under.common.uiliststyle.group.emjio.view.EmojiReplyView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class BaseStyleNormalAdapter<ChildItemData extends BaseItem<? extends TbNormalMsg>, ChildViewHolder extends BaseViewHolder, ChildExtraHolder extends BaseViewHolder> extends BaseNormalAdapter<ChildItemData, ChildViewHolder, ChildExtraHolder, SelfHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public final boolean Y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? i != 0 : invokeI.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static class SelfHolder extends BaseNormalAdapter.SelfHolder {
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
            this.a = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090315);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09196e);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09284f);
            this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09285d);
            this.e = (ImageView) view2.findViewById(R.id.btn_msgitem_resend);
            this.f = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f091d7b);
            this.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090511);
            this.h = (TbImage) view2.findViewById(R.id.obfuscated_res_0x7f090510);
            this.i = (TbImage) view2.findViewById(R.id.obfuscated_res_0x7f09050f);
            this.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0907a0);
            this.k = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090ab5);
            this.l = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090024);
            this.m = (EmojiReplyView) view2.findViewById(R.id.obfuscated_res_0x7f09099a);
            this.n = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0908cf);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0908ce);
            this.o = tbImageView;
            tbImageView.setPlaceHolder(0);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0908cd);
            this.s = (TextView) view2.findViewById(R.id.kaogao_icon);
            this.t = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e14);
            AutoDegradeTagView autoDegradeTagView = (AutoDegradeTagView) view2.findViewById(R.id.obfuscated_res_0x7f092855);
            this.r = autoDegradeTagView;
            if (autoDegradeTagView.getLayoutParams() != null) {
                this.r.getLayoutParams().height = BdUtilHelper.getDimens(view2.getContext(), R.dimen.tbds44);
            }
            this.r.setTagConfig(BdUtilHelper.getDimens(view2.getContext(), R.dimen.T_X08), BdUtilHelper.getDimens(view2.getContext(), R.dimen.tbds35), BdUtilHelper.getDimens(view2.getContext(), R.dimen.M_W_X002), R.color.CAM_X0105);
            if (z && view2.getContext() != null) {
                ReplyContentView f = eo8.f(view2.getContext());
                this.q = f;
                this.j.addView(f);
            }
            Context context = view2.getContext();
            if (context != null) {
                this.l.addView(eo8.d(context));
            }
            eo8.e(this.m);
        }

        @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
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

        @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
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

        @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
        public void d(@NonNull bg8 bg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bg8Var) == null) {
                super.d(bg8Var);
                bg8.d(this.e, bg8Var);
            }
        }

        @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter.SelfHolder
        @NonNull
        public ViewGroup e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.j;
            }
            return (ViewGroup) invokeV.objValue;
        }

        @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter.SelfHolder
        @Nullable
        public ViewGroup f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.k;
            }
            return (ViewGroup) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseStyleNormalAdapter(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
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
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    /* renamed from: Z */
    public SelfHolder P(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            return new SelfHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0469, viewGroup, false), e0());
        }
        return (SelfHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    /* renamed from: b0 */
    public SelfHolder Q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            return new SelfHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d046b, viewGroup, false), e0());
        }
        return (SelfHolder) invokeL.objValue;
    }

    public final void X(SelfHolder selfHolder, ChildItemData childitemdata, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, selfHolder, childitemdata, i) == null) {
            if (i == 1) {
                eo8.m(this.mContext, childitemdata, selfHolder, B(), A());
            } else if (i == 2) {
                eo8.l(this.mContext, childitemdata, selfHolder, E(), B(), C());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter
    /* renamed from: c0 */
    public void U(int i, @NonNull ViewGroup viewGroup, @NonNull ChildItemData childitemdata, @NonNull SelfHolder selfHolder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), viewGroup, childitemdata, selfHolder, list, Integer.valueOf(i2)}) == null) {
            eo8.v(selfHolder);
            int d0 = d0(list);
            if (Y(d0)) {
                X(selfHolder, childitemdata, d0);
                return;
            }
            eo8.j(childitemdata, selfHolder);
            eo8.i(childitemdata, selfHolder);
            eo8.n(childitemdata, selfHolder);
            eo8.k(this.mContext, childitemdata, selfHolder, B(), A());
            eo8.m(this.mContext, childitemdata, selfHolder, B(), A());
            eo8.h(E(), childitemdata, viewGroup);
        }
    }

    public final int d0(@NonNull List<Object> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list)) == null) {
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
}

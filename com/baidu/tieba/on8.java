package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.botpanel.BotItemViewHolderFactory;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.RelativeMemeDetail;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.TagAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class on8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;
    public final HeadImageView b;
    public final TextView c;
    public final RecyclerView d;
    public final mn8 e;
    public long f;
    public long g;
    public Boolean h;
    public final CustomMessageListener i;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ on8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(on8 on8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = on8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements pn8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pn8 a;
        public final /* synthetic */ on8 b;

        public b(on8 on8Var, pn8 pn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on8Var, pn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = on8Var;
            this.a = pn8Var;
        }

        @Override // com.baidu.tieba.pn8
        public void a(AbilityItem abilityItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, abilityItem) == null) {
                if (!"pic_gen_commit".equals(abilityItem.getType())) {
                    this.b.j();
                    zb8.b(2, this.b.f, this.b.g);
                } else {
                    zb8.b(3, this.b.f, this.b.g);
                }
                if (this.a != null && this.b.h.booleanValue()) {
                    this.a.a(abilityItem);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelativeMemeDetail a;
        public final /* synthetic */ on8 b;

        public c(on8 on8Var, RelativeMemeDetail relativeMemeDetail) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on8Var, relativeMemeDetail};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = on8Var;
            this.a = relativeMemeDetail;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.b.a.setVisibility(0);
                this.b.c.setText(this.a.getTitle());
                this.b.b.N(this.a.getPortrait(), 12, false);
                this.b.k();
                this.b.e.h(this.a.getAbilityItems());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ on8 a;

        public d(on8 on8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = on8Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationCancel(animator);
                this.a.a.setVisibility(8);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.a.setVisibility(8);
            }
        }
    }

    public on8(View view2, pn8 pn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, pn8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = Boolean.TRUE;
        this.i = new a(this, 2001304);
        this.a = view2;
        HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090431);
        this.b = headImageView;
        headImageView.setIsRound(true);
        this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09043b);
        RecyclerView recyclerView = (RecyclerView) this.a.findViewById(R.id.obfuscated_res_0x7f090433);
        this.d = recyclerView;
        recyclerView.addItemDecoration(new BotItemViewHolderFactory.BotThinkItemDecoration());
        this.d.setLayoutManager(new LinearLayoutManager(view2.getContext(), 0, false));
        this.e = new mn8();
        this.d.setAdapter(new TagAdapter(new BotItemViewHolderFactory(new b(this, pn8Var)), this.e, view2.getContext()));
        MessageManager.getInstance().registerListener(this.i);
    }

    public void n(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bool) == null) {
            this.h = bool;
        }
    }

    public void o(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.g = j;
        }
    }

    public void p(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.f = j;
        }
    }

    public void q(RelativeMemeDetail relativeMemeDetail) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, relativeMemeDetail) == null) && relativeMemeDetail != null) {
            m(relativeMemeDetail);
            zb8.b(1, this.f, this.g);
        }
    }

    @NonNull
    public mn8 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (mn8) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            xo8.b(this.a, new d(this), 60L);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d85 d2 = d85.d(this.a);
            d2.o(R.string.J_X13);
            d2.f(R.color.CAM_X0207);
            d85.d(this.c).x(R.color.CAM_X0107);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }

    public final void m(RelativeMemeDetail relativeMemeDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, relativeMemeDetail) == null) {
            if (this.a.getVisibility() != 0) {
                xo8.c(this.a, new c(this, relativeMemeDetail));
                return;
            }
            this.c.setText(relativeMemeDetail.getTitle());
            this.b.N(relativeMemeDetail.getPortrait(), 12, false);
            this.e.h(relativeMemeDetail.getAbilityItems());
        }
    }
}

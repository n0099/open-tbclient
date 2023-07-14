package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter.InterceptRecyclerView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.data.SkillSugListData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.data.SkillSugRequest;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class xm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
    public final View a;
    public final View b;
    public final kp8 c;
    public final RecyclerView d;
    public final kp8 e;
    public final InterceptRecyclerView f;
    public final View g;
    public final TextView h;
    public final m i;
    public k j;
    public l k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    @Nullable
    public bo8 r;
    @Nullable
    public FastRequest s;
    @Nullable
    public TbPageContext<BaseFragmentActivity> t;
    @Nullable
    public SkillSugRequest u;
    @Nullable
    public ml8 v;
    @Nullable
    public BaseMsg w;
    @NonNull
    public List<AbilityItem> x;
    public final CustomMessageListener y;
    @NonNull
    public final FastRequest.b<SkillSugListData> z;

    /* loaded from: classes8.dex */
    public interface k {
        void a();
    }

    /* loaded from: classes8.dex */
    public interface l {
        void a(boolean z);
    }

    /* loaded from: classes8.dex */
    public interface m {
        void a(boolean z);
    }

    /* loaded from: classes8.dex */
    public class i extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;
        public final /* synthetic */ l b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ xm8 d;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d.j != null) {
                    this.a.d.j.a();
                }
            }
        }

        public i(xm8 xm8Var, k kVar, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xm8Var, kVar, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xm8Var;
            this.a = kVar;
            this.b = lVar;
            this.c = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.d.j = this.a;
                this.d.k = this.b;
                this.d.a.setVisibility(0);
                this.d.g.setVisibility(0);
                this.d.J(this.c);
                this.d.h.setVisibility(0);
                this.d.h.setOnClickListener(new a(this));
                this.d.R();
                zg.a().postDelayed(this.d.A, 1000L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AnimatorListenerAdapter a;
        public final /* synthetic */ xm8 b;

        public a(xm8 xm8Var, AnimatorListenerAdapter animatorListenerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xm8Var, animatorListenerAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xm8Var;
            this.a = animatorListenerAdapter;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.b.d.setVisibility(0);
                AnimatorListenerAdapter animatorListenerAdapter = this.a;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationCancel(animator);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.b.d.setVisibility(0);
                AnimatorListenerAdapter animatorListenerAdapter = this.a;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationEnd(animator);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xm8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(xm8 xm8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xm8Var, Integer.valueOf(i)};
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
            this.a = xm8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.R();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends FastRequest.b<SkillSugListData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xm8 b;

        public c(xm8 xm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xm8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable SkillSugListData skillSugListData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, skillSugListData) == null) {
                super.b(i, str, skillSugListData);
                this.b.x.clear();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull SkillSugListData skillSugListData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, skillSugListData) == null) {
                super.e(skillSugListData);
                this.b.x.clear();
                if (skillSugListData.getSugList() != null && !skillSugListData.getSugList().isEmpty()) {
                    this.b.x.addAll(skillSugListData.getSugList());
                    this.b.e.d(this.b.x);
                    this.b.g.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements mp8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xm8 a;

        public d(xm8 xm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xm8Var;
        }

        @Override // com.baidu.tieba.mp8
        public boolean a(int i, boolean z, Object obj) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), obj})) == null) {
                if (this.a.l != i || !this.a.m) {
                    if (obj instanceof List) {
                        if (this.a.l != i && this.a.l >= 0) {
                            lp8 a = this.a.e.a(this.a.l);
                            if (a instanceof po8) {
                                ((po8) a).n(false);
                                this.a.e.e(this.a.l);
                            }
                        }
                        this.a.l = i;
                        List list = (List) obj;
                        if (list.size() <= 1) {
                            if (list.size() <= 1 && this.a.m) {
                                this.a.E();
                                this.a.m = false;
                            }
                        } else {
                            this.a.I(list);
                            this.a.c.d(list);
                            if (!this.a.m) {
                                this.a.c0();
                                this.a.m = true;
                            }
                        }
                        if (!this.a.z() && list.size() <= 1) {
                            return false;
                        }
                        return true;
                    } else if (obj instanceof AbilityItem) {
                        AbilityItem abilityItem = (AbilityItem) obj;
                        if (this.a.v != null) {
                            this.a.v.d(abilityItem, this.a.w, Boolean.TRUE);
                        }
                    }
                } else {
                    this.a.m = false;
                    if ((obj instanceof List) && ((List) obj).size() <= 1) {
                        return false;
                    }
                    this.a.e.e(this.a.l);
                    this.a.E();
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements mp8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xm8 a;

        public e(xm8 xm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xm8Var;
        }

        @Override // com.baidu.tieba.mp8
        public boolean a(int i, boolean z, Object obj) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), obj})) == null) {
                if (!(obj instanceof BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO)) {
                    return true;
                }
                this.a.m = false;
                po8 po8Var = (po8) this.a.e.a(this.a.l);
                if (po8Var != null) {
                    po8Var.m((BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO) obj);
                    po8Var.n(false);
                    this.a.e.e(this.a.l);
                }
                this.a.E();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xm8 a;

        public f(xm8 xm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xm8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xo8.c(this.a.d, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xm8 a;

        public g(xm8 xm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xm8Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.a.S(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.a.S(true);
        }
    }

    /* loaded from: classes8.dex */
    public class h extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ xm8 c;

        public h(xm8 xm8Var, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xm8Var, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xm8Var;
            this.a = z;
            this.b = z2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                View view2 = this.c.g;
                if (this.a) {
                    i = 0;
                } else {
                    i = 8;
                }
                view2.setVisibility(i);
                this.c.J(this.b);
                this.c.R();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xm8 a;

        public j(xm8 xm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xm8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.k != null) {
                this.a.k.a(this.a.q);
            }
        }
    }

    public xm8(@NonNull View view2, @Nullable m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.s = null;
        this.x = new ArrayList();
        this.y = new b(this, 2001304);
        this.z = new c(this);
        this.A = new j(this);
        this.b = view2;
        this.a = view2.findViewById(R.id.obfuscated_res_0x7f090e7d);
        this.i = mVar;
        this.d = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091120);
        this.f = (InterceptRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f09111e);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09111f);
        this.g = view2.findViewById(R.id.obfuscated_res_0x7f09111d);
        this.c = io8.a(view2.getContext(), this.d, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004));
        this.e = io8.b(view2.getContext(), this.f, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004));
        H();
        K();
        MessageManager.getInstance().registerListener(this.y);
    }

    public void F(AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, animatorListenerAdapter) == null) {
            this.q = false;
            xo8.a(this.a, new a(this, animatorListenerAdapter));
        }
    }

    public final void S(boolean z) {
        m mVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && (mVar = this.i) != null) {
            mVar.a(z);
        }
    }

    public void W(ml8 ml8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, ml8Var) == null) {
            this.v = ml8Var;
        }
    }

    public void X(TbPageContext<BaseFragmentActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, tbPageContext) == null) {
            this.t = tbPageContext;
        }
    }

    public void Y(BaseMsg baseMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, baseMsg) == null) {
            this.w = baseMsg;
        }
    }

    public void Z(@Nullable SkillSugRequest skillSugRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, skillSugRequest) == null) {
            this.u = skillSugRequest;
            if (skillSugRequest != null) {
                V(skillSugRequest);
            }
        }
    }

    public void a0(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, lVar) == null) {
            this.k = lVar;
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f.getChildCount() > 0) {
            this.f.removeAllViews();
            this.e.d(null);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || !this.m) {
            return;
        }
        this.m = false;
        this.e.e(this.l);
        po8 po8Var = (po8) this.e.a(this.l);
        if (po8Var != null) {
            po8Var.n(false);
        }
        E();
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.p = true;
            xo8.a(this.d, new g(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.g(new d(this));
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.c.g(new e(this));
        }
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.q;
        }
        return invokeV.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.y);
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            S(false);
            zg.a().postDelayed(new f(this), 300L);
        }
    }

    @Nullable
    public List<String> B() {
        InterceptResult invokeV;
        po8 po8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if ((this.e.a(this.l) instanceof po8) && (po8Var = (po8) this.e.a(this.l)) != null && po8Var.d() != null && po8Var.d().getItemType() == 2) {
                return fp8.b(po8Var.c());
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            d85 d2 = d85.d(this.d);
            d2.o(R.string.J_X13);
            d2.f(R.color.CAM_X0207);
            d85.d(this.g).f(R.color.CAM_X0207);
            d85.d(this.f).f(R.color.CAM_X0207);
            if (this.h.getVisibility() == 0) {
                d85 d3 = d85.d(this.h);
                d3.x(R.color.CAM_X0101);
                d3.C(R.dimen.T_X08);
                d3.o(R.string.J_X01);
                d3.D(R.string.F_X01);
                d3.f(R.color.CAM_X0302);
            }
        }
    }

    public List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> C() {
        InterceptResult invokeV;
        po8 po8Var;
        BotsDTO.BotListDTO.SkillDTO.ItemsDTO d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<lp8> b2 = this.e.b();
            if (b2 != null && this.o) {
                ArrayList arrayList = new ArrayList();
                for (lp8 lp8Var : b2) {
                    if ((lp8Var instanceof po8) && (d2 = (po8Var = (po8) lp8Var).d()) != null) {
                        BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO = new BotsDTO.BotListDTO.SkillDTO.ItemsDTO();
                        itemsDTO.setName(d2.getName());
                        itemsDTO.setValue(d2.getValue());
                        itemsDTO.setItemType(d2.getItemType());
                        BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO g2 = po8Var.g();
                        if (g2 != null) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(g2);
                            itemsDTO.setOpts(arrayList2);
                        }
                        arrayList.add(itemsDTO);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public void G(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, bo8 bo8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, list, bo8Var, z) == null) {
            boolean z2 = true;
            this.o = !ListUtils.isEmpty(list);
            this.r = bo8Var;
            if (ListUtils.isEmpty(list)) {
                E();
                return;
            }
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> opts = list.get(0).getOpts();
            I(opts);
            U(list, z, (opts == null || opts.size() <= 1) ? false : false);
            this.e.c(list);
            this.c.c(opts);
        }
    }

    public final void U(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048596, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        boolean z3 = false;
        if (z) {
            this.e.h(0);
            this.l = 0;
        } else {
            this.e.h(-1);
            this.l = -1;
        }
        this.n = z2;
        if (z && z2) {
            z3 = true;
        }
        this.m = z3;
    }

    public final void I(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO optsDTO : list) {
            if (optsDTO.getDefaultX() == 1) {
                return;
            }
        }
        list.get(0).setDefaultX(1);
    }

    public final void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (this.n && z) {
                if (this.p) {
                    xo8.d(this.d, null, 0L);
                } else {
                    this.d.setVisibility(0);
                }
                S(false);
                return;
            }
            this.d.setVisibility(8);
            S(true);
        }
    }

    public void N(List<AtSelectData> list) {
        po8 po8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            for (int i2 = 0; i2 < this.e.b().size(); i2++) {
                if ((this.e.a(i2) instanceof po8) && (po8Var = (po8) this.e.a(i2)) != null && po8Var.d() != null && po8Var.d().getItemType() == 2) {
                    po8Var.o(list);
                    this.e.e(i2);
                }
            }
        }
    }

    public void O(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, list, z) == null) {
            boolean z2 = true;
            this.o = !ListUtils.isEmpty(list);
            if (ListUtils.isEmpty(list)) {
                E();
                A();
                return;
            }
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> opts = list.get(0).getOpts();
            U(list, z, (opts == null || opts.size() <= 1) ? false : false);
            I(opts);
            this.e.d(list);
            this.c.d(opts);
        }
    }

    public void P(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) && (this.e.a(this.l) instanceof qo8)) {
            qo8 qo8Var = (qo8) this.e.a(this.l);
            qo8Var.s(str, str2);
            qo8Var.r(true);
            this.e.e(this.l);
        }
    }

    public void b0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.q = true;
            this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.h.setVisibility(8);
            xo8.c(this.a, new h(this, z2, z));
        }
    }

    public void T(Context context, bo8 bo8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048595, this, context, bo8Var, z) == null) {
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(context, 12004, true);
            atListActivityConfig.setIsForGroupChat(true);
            atListActivityConfig.setCallAtListSource(AtListActivityConfig.GROUP_BOT_SKILL);
            if (!ListUtils.isEmpty(B()) && ListUtils.getCount(B()) > 0) {
                atListActivityConfig.setSelectedAtUid(TextUtils.join(",", B()));
            }
            if (bo8Var.a() > 0) {
                atListActivityConfig.setFromFid(String.valueOf(bo8Var.a()));
            }
            atListActivityConfig.setChatroomId(bo8Var.c());
            atListActivityConfig.setUserRole(bo8Var.d());
            atListActivityConfig.setForumName(bo8Var.b());
            atListActivityConfig.setIsShowBotInfo(false);
            atListActivityConfig.setCallAtListOptional(z);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
        }
    }

    public final void V(@NonNull SkillSugRequest skillSugRequest) {
        TbPageContext<BaseFragmentActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, skillSugRequest) == null) {
            if (this.s == null && (tbPageContext = this.t) != null) {
                this.s = new FastRequest(tbPageContext, CmdConfigHttp.CMD_POST_SKILL_SUG, TbConfig.URL_GET_SKILL_SUG_LIST);
            }
            FastRequest fastRequest = this.s;
            if (fastRequest != null) {
                fastRequest.b0(HttpMessageTask.HTTP_METHOD.POST);
                fastRequest.W("skill_id", Long.valueOf(skillSugRequest.getSkillId()));
                fastRequest.W("robot_uk", skillSugRequest.getBotUk());
                fastRequest.W("forum_id", Long.valueOf(skillSugRequest.getForumId()));
                fastRequest.W("chatroom_id", Long.valueOf(skillSugRequest.getChatroomId()));
                fastRequest.Y(this.z);
                fastRequest.X();
            }
        }
    }

    public void d0(k kVar, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048605, this, kVar, lVar, z) == null) {
            this.q = true;
            this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            xo8.c(this.a, new i(this, kVar, lVar, z));
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            int i2 = this.l;
            if (i2 >= 0) {
                lp8 a2 = this.e.a(i2);
                if (a2 instanceof po8) {
                    po8 po8Var = (po8) a2;
                    if (po8Var.i() == 2 && this.r != null) {
                        T(this.b.getContext(), this.r, po8Var.k());
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}

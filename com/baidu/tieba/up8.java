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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
public class up8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
    public final View a;
    public final View b;
    public final gs8 c;
    public final RecyclerView d;
    public final gs8 e;
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
    public yq8 r;
    @Nullable
    public FastRequest s;
    @Nullable
    public TbPageContext<BaseFragmentActivity> t;
    @Nullable
    public SkillSugRequest u;
    @Nullable
    public io8 v;
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
        public final /* synthetic */ up8 d;

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

        public i(up8 up8Var, k kVar, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up8Var, kVar, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = up8Var;
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
                SafeHandler.getInst().postDelayed(this.d.A, 1000L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AnimatorListenerAdapter a;
        public final /* synthetic */ up8 b;

        public a(up8 up8Var, AnimatorListenerAdapter animatorListenerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up8Var, animatorListenerAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = up8Var;
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
        public final /* synthetic */ up8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(up8 up8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up8Var, Integer.valueOf(i)};
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
            this.a = up8Var;
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
        public final /* synthetic */ up8 b;

        public c(up8 up8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = up8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void b(int i, @NonNull String str, @Nullable SkillSugListData skillSugListData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, skillSugListData) == null) {
                super.b(i, str, skillSugListData);
                this.b.x.clear();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: h */
        public void f(@NonNull SkillSugListData skillSugListData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, skillSugListData) == null) {
                super.f(skillSugListData);
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
    public class d implements is8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ up8 a;

        public d(up8 up8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = up8Var;
        }

        @Override // com.baidu.tieba.is8
        public boolean a(int i, boolean z, Object obj) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), obj})) == null) {
                if (this.a.l != i || !this.a.m) {
                    if (obj instanceof List) {
                        if (this.a.l != i && this.a.l >= 0) {
                            hs8 a = this.a.e.a(this.a.l);
                            if (a instanceof lr8) {
                                ((lr8) a).n(false);
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
    public class e implements is8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ up8 a;

        public e(up8 up8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = up8Var;
        }

        @Override // com.baidu.tieba.is8
        public boolean a(int i, boolean z, Object obj) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), obj})) == null) {
                if (!(obj instanceof BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO)) {
                    return true;
                }
                this.a.m = false;
                lr8 lr8Var = (lr8) this.a.e.a(this.a.l);
                if (lr8Var != null) {
                    lr8Var.m((BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO) obj);
                    lr8Var.n(false);
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
        public final /* synthetic */ up8 a;

        public f(up8 up8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = up8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tr8.c(this.a.d, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ up8 a;

        public g(up8 up8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = up8Var;
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
        public final /* synthetic */ up8 c;

        public h(up8 up8Var, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up8Var, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = up8Var;
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
        public final /* synthetic */ up8 a;

        public j(up8 up8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {up8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = up8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.k != null) {
                this.a.k.a(this.a.q);
            }
        }
    }

    public up8(@NonNull View view2, @Nullable m mVar) {
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
        this.l = -1;
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
        this.a = view2.findViewById(R.id.obfuscated_res_0x7f090e9b);
        this.i = mVar;
        this.d = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091149);
        this.f = (InterceptRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091147);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091148);
        this.g = view2.findViewById(R.id.obfuscated_res_0x7f091146);
        this.c = er8.a(view2.getContext(), this.d, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004));
        this.e = er8.b(view2.getContext(), this.f, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004));
        H();
        K();
        MessageManager.getInstance().registerListener(this.y);
    }

    public void F(AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, animatorListenerAdapter) == null) {
            this.q = false;
            tr8.a(this.a, new a(this, animatorListenerAdapter));
        }
    }

    public final void S(boolean z) {
        m mVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && (mVar = this.i) != null) {
            mVar.a(z);
        }
    }

    public void W(io8 io8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, io8Var) == null) {
            this.v = io8Var;
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
        lr8 lr8Var = (lr8) this.e.a(this.l);
        if (lr8Var != null) {
            lr8Var.n(false);
        }
        E();
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.p = true;
            tr8.a(this.d, new g(this));
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
            SafeHandler.getInst().postDelayed(new f(this), 300L);
        }
    }

    @Nullable
    public List<String> B() {
        InterceptResult invokeV;
        lr8 lr8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if ((this.e.a(this.l) instanceof lr8) && (lr8Var = (lr8) this.e.a(this.l)) != null && lr8Var.d() != null && lr8Var.d().getItemType() == 2) {
                return bs8.b(lr8Var.c());
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            EMManager.from(this.d).setCorner(R.string.J_X13).setBackGroundColor(R.color.CAM_X0207);
            EMManager.from(this.g).setBackGroundColor(R.color.CAM_X0207);
            EMManager.from(this.f).setBackGroundColor(R.color.CAM_X0207);
            if (this.h.getVisibility() == 0) {
                EMManager.from(this.h).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X08).setCorner(R.string.J_X01).setTextStyle(R.string.F_X01).setBackGroundColor(R.color.CAM_X0302);
            }
        }
    }

    public List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> C() {
        InterceptResult invokeV;
        lr8 lr8Var;
        BotsDTO.BotListDTO.SkillDTO.ItemsDTO d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<hs8> b2 = this.e.b();
            if (b2 != null && this.o) {
                ArrayList arrayList = new ArrayList();
                for (hs8 hs8Var : b2) {
                    if ((hs8Var instanceof lr8) && (d2 = (lr8Var = (lr8) hs8Var).d()) != null) {
                        BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO = new BotsDTO.BotListDTO.SkillDTO.ItemsDTO();
                        itemsDTO.setName(d2.getName());
                        itemsDTO.setValue(d2.getValue());
                        itemsDTO.setItemType(d2.getItemType());
                        BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO g2 = lr8Var.g();
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

    public void G(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, yq8 yq8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, list, yq8Var, z) == null) {
            boolean z2 = true;
            this.o = !ListUtils.isEmpty(list);
            this.r = yq8Var;
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
                    tr8.d(this.d, null, 0L);
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
        lr8 lr8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            for (int i2 = 0; i2 < this.e.b().size(); i2++) {
                if ((this.e.a(i2) instanceof lr8) && (lr8Var = (lr8) this.e.a(i2)) != null && lr8Var.d() != null && lr8Var.d().getItemType() == 2) {
                    lr8Var.o(list);
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
        if ((interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) && (this.e.a(this.l) instanceof mr8)) {
            mr8 mr8Var = (mr8) this.e.a(this.l);
            mr8Var.s(str, str2);
            mr8Var.r(true);
            this.e.e(this.l);
        }
    }

    public void b0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.q = true;
            this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.h.setVisibility(8);
            tr8.c(this.a, new h(this, z2, z));
        }
    }

    public void T(Context context, yq8 yq8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048595, this, context, yq8Var, z) == null) {
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(context, 12004, true);
            atListActivityConfig.setIsForGroupChat(true);
            atListActivityConfig.setCallAtListSource(AtListActivityConfig.GROUP_BOT_SKILL);
            if (!ListUtils.isEmpty(B()) && ListUtils.getCount(B()) > 0) {
                atListActivityConfig.setSelectedAtUid(TextUtils.join(",", B()));
            }
            if (yq8Var.a() > 0) {
                atListActivityConfig.setFromFid(String.valueOf(yq8Var.a()));
            }
            atListActivityConfig.setChatroomId(yq8Var.c());
            atListActivityConfig.setUserRole(yq8Var.d());
            atListActivityConfig.setForumName(yq8Var.b());
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
                fastRequest.S(HttpMessageTask.HTTP_METHOD.POST);
                fastRequest.N("skill_id", Long.valueOf(skillSugRequest.getSkillId()));
                fastRequest.N("robot_uk", skillSugRequest.getBotUk());
                fastRequest.N("forum_id", Long.valueOf(skillSugRequest.getForumId()));
                fastRequest.N("chatroom_id", Long.valueOf(skillSugRequest.getChatroomId()));
                fastRequest.P(this.z);
                fastRequest.O();
            }
        }
    }

    public void d0(k kVar, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048605, this, kVar, lVar, z) == null) {
            this.q = true;
            this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            tr8.c(this.a, new i(this, kVar, lVar, z));
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            int i2 = this.l;
            if (i2 >= 0) {
                hs8 a2 = this.e.a(i2);
                if (a2 instanceof lr8) {
                    lr8 lr8Var = (lr8) a2;
                    if (lr8Var.i() == 2 && this.r != null) {
                        T(this.b.getContext(), this.r, lr8Var.k());
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

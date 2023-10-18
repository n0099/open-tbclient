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
import com.baidu.adp.lib.util.BdLog;
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
import com.baidu.tieba.im.base.core.inputtool.robotfloor.adapter.InterceptRecyclerView;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.data.SkillSugListData;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.data.SkillSugRequest;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class j78 {
    public static /* synthetic */ Interceptable $ic;
    public static u98 B;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
    public final View a;
    public final View b;
    public final t98 c;
    public final RecyclerView d;
    public final t98 e;
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
    public w78 r;
    @Nullable
    public FastRequest s;
    @Nullable
    public TbPageContext<BaseFragmentActivity> t;
    @Nullable
    public SkillSugRequest u;
    @Nullable
    public ea8 v;
    @Nullable
    public BaseItem<? extends TbBaseMsg> w;
    @NonNull
    public List<AbilityItem> x;
    public final CustomMessageListener y;
    @NonNull
    public final FastRequest.b<SkillSugListData> z;

    /* loaded from: classes6.dex */
    public interface k {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface l {
        void a(boolean z);
    }

    /* loaded from: classes6.dex */
    public interface m {
        void a(boolean z);
    }

    /* loaded from: classes6.dex */
    public class i extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;
        public final /* synthetic */ l b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ j78 d;

        /* loaded from: classes6.dex */
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

        public i(j78 j78Var, k kVar, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j78Var, kVar, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = j78Var;
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
                this.d.K(this.c);
                this.d.h.setVisibility(0);
                this.d.h.setOnClickListener(new a(this));
                this.d.S();
                SafeHandler.getInst().postDelayed(this.d.A, 1000L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AnimatorListenerAdapter a;
        public final /* synthetic */ j78 b;

        public a(j78 j78Var, AnimatorListenerAdapter animatorListenerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j78Var, animatorListenerAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j78Var;
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

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j78 j78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j78Var, Integer.valueOf(i)};
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
            this.a = j78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.S();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends FastRequest.b<SkillSugListData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j78 d;

        public c(j78 j78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = j78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void f(int i, @NonNull String str, @Nullable SkillSugListData skillSugListData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, skillSugListData) == null) {
                super.f(i, str, skillSugListData);
                this.d.x.clear();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(@NonNull SkillSugListData skillSugListData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, skillSugListData) == null) {
                super.i(skillSugListData);
                this.d.x.clear();
                if (skillSugListData.getSugList() != null && !skillSugListData.getSugList().isEmpty()) {
                    this.d.x.addAll(skillSugListData.getSugList());
                    this.d.e.d(this.d.x);
                    this.d.g.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements w98 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j78 a;

        public d(j78 j78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j78Var;
        }

        @Override // com.baidu.tieba.w98
        public boolean a(int i, boolean z, Object obj) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), obj})) == null) {
                if (this.a.l != i || !this.a.m) {
                    if (obj instanceof List) {
                        if (this.a.l != i && this.a.l >= 0) {
                            v98 a = this.a.e.a(this.a.l);
                            if (a instanceof aa8) {
                                ((aa8) a).n(false);
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
                            this.a.J(list);
                            this.a.c.d(list);
                            if (!this.a.m) {
                                this.a.d0();
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

    /* loaded from: classes6.dex */
    public class e implements w98 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j78 a;

        public e(j78 j78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j78Var;
        }

        @Override // com.baidu.tieba.w98
        public boolean a(int i, boolean z, Object obj) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), obj})) == null) {
                if (!(obj instanceof BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO)) {
                    return true;
                }
                this.a.m = false;
                aa8 aa8Var = (aa8) this.a.e.a(this.a.l);
                if (aa8Var != null) {
                    aa8Var.m((BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO) obj);
                    aa8Var.n(false);
                    this.a.e.e(this.a.l);
                }
                this.a.E();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j78 a;

        public f(j78 j78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j78Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c98.c(this.a.d, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j78 a;

        public g(j78 j78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j78Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.a.T(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.a.T(true);
        }
    }

    /* loaded from: classes6.dex */
    public class h extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ j78 c;

        public h(j78 j78Var, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j78Var, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j78Var;
            this.a = z;
            this.b = z2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            View view2 = this.c.g;
            if (this.a) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
            this.c.K(this.b);
            this.c.S();
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j78 a;

        public j(j78 j78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j78Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.k != null) {
                this.a.k.a(this.a.q);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947836318, "Lcom/baidu/tieba/j78;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947836318, "Lcom/baidu/tieba/j78;");
                return;
            }
        }
        try {
            B = (u98) Class.forName("com.baidu.tieba.wh8").newInstance();
        } catch (Exception e2) {
            e2.printStackTrace();
            BdLog.i(e2.getMessage());
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            int i2 = this.l;
            if (i2 >= 0) {
                v98 a2 = this.e.a(i2);
                if (a2 instanceof aa8) {
                    aa8 aa8Var = (aa8) a2;
                    if (aa8Var.i() == 2 && this.r != null) {
                        U(this.b.getContext(), this.r, aa8Var.k());
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

    public j78(@NonNull View view2, @Nullable m mVar, @Nullable BotsDTO.BotListDTO.SkillDTO skillDTO, @Nullable BotsDTO.BotListDTO.UserDTO userDTO) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, mVar, skillDTO, userDTO};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
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
        this.a = view2.findViewById(R.id.obfuscated_res_0x7f090eae);
        this.i = mVar;
        this.d = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091153);
        this.f = (InterceptRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091151);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091152);
        this.g = view2.findViewById(R.id.obfuscated_res_0x7f091150);
        this.c = B.b(view2.getContext(), this.d, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004));
        this.e = B.a(view2.getContext(), this.f, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), skillDTO, userDTO);
        I();
        L();
        MessageManager.getInstance().registerListener(this.y);
    }

    public void F(AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, animatorListenerAdapter) == null) {
            this.q = false;
            c98.a(this.a, new a(this, animatorListenerAdapter));
        }
    }

    public void H(da8 da8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, da8Var) == null) {
            this.e.f(this.v, da8Var);
        }
    }

    public final void T(boolean z) {
        m mVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && (mVar = this.i) != null) {
            mVar.a(z);
        }
    }

    public void X(ea8 ea8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, ea8Var) == null) {
            this.v = ea8Var;
        }
    }

    public void Y(TbPageContext<BaseFragmentActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, tbPageContext) == null) {
            this.t = tbPageContext;
        }
    }

    public void Z(BaseItem<? extends TbBaseMsg> baseItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, baseItem) == null) {
            this.w = baseItem;
        }
    }

    public void a0(@Nullable SkillSugRequest skillSugRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, skillSugRequest) == null) {
            this.u = skillSugRequest;
            if (skillSugRequest != null) {
                W(skillSugRequest);
            }
        }
    }

    public void b0(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, lVar) == null) {
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
        aa8 aa8Var = (aa8) this.e.a(this.l);
        if (aa8Var != null) {
            aa8Var.n(false);
        }
        E();
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.p = true;
            c98.a(this.d, new g(this));
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.e.g(new d(this));
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.c.g(new e(this));
        }
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.q;
        }
        return invokeV.booleanValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.y);
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            T(false);
            SafeHandler.getInst().postDelayed(new f(this), 300L);
        }
    }

    @Nullable
    public List<String> B() {
        InterceptResult invokeV;
        aa8 aa8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if ((this.e.a(this.l) instanceof aa8) && (aa8Var = (aa8) this.e.a(this.l)) != null && aa8Var.d() != null && aa8Var.d().getItemType() == 2) {
                return f98.b(aa8Var.c());
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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
        aa8 aa8Var;
        BotsDTO.BotListDTO.SkillDTO.ItemsDTO d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<v98> b2 = this.e.b();
            if (b2 != null && this.o) {
                ArrayList arrayList = new ArrayList();
                for (v98 v98Var : b2) {
                    if ((v98Var instanceof aa8) && (d2 = (aa8Var = (aa8) v98Var).d()) != null) {
                        BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO = new BotsDTO.BotListDTO.SkillDTO.ItemsDTO();
                        itemsDTO.setName(d2.getName());
                        itemsDTO.setValue(d2.getValue());
                        itemsDTO.setItemType(d2.getItemType());
                        BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO g2 = aa8Var.g();
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

    public void G(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, w78 w78Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, list, w78Var, z) == null) {
            boolean z2 = true;
            this.o = !ListUtils.isEmpty(list);
            this.r = w78Var;
            if (ListUtils.isEmpty(list)) {
                E();
                return;
            }
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> opts = list.get(0).getOpts();
            J(opts);
            V(list, z, (opts == null || opts.size() <= 1) ? false : false);
            this.e.c(list);
            this.c.c(opts);
        }
    }

    public final void V(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048597, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || ListUtils.isEmpty(list)) {
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

    public final void J(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO optsDTO : list) {
            if (optsDTO.getDefaultX() == 1) {
                return;
            }
        }
        list.get(0).setDefaultX(1);
    }

    public final void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (this.n && z) {
                if (this.p) {
                    c98.d(this.d, null, 0L);
                } else {
                    this.d.setVisibility(0);
                }
                T(false);
                return;
            }
            this.d.setVisibility(8);
            T(true);
        }
    }

    public void O(List<AtSelectData> list) {
        aa8 aa8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            for (int i2 = 0; i2 < this.e.b().size(); i2++) {
                if ((this.e.a(i2) instanceof aa8) && (aa8Var = (aa8) this.e.a(i2)) != null && aa8Var.d() != null && aa8Var.d().getItemType() == 2) {
                    aa8Var.o(list);
                    this.e.e(i2);
                }
            }
        }
    }

    public void P(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, list, z) == null) {
            boolean z2 = true;
            this.o = !ListUtils.isEmpty(list);
            if (ListUtils.isEmpty(list)) {
                E();
                A();
                return;
            }
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> opts = list.get(0).getOpts();
            V(list, z, (opts == null || opts.size() <= 1) ? false : false);
            J(opts);
            this.e.d(list);
            this.c.d(opts);
        }
    }

    public void Q(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) && (this.e.a(this.l) instanceof ba8)) {
            ba8 ba8Var = (ba8) this.e.a(this.l);
            ba8Var.s(str, str2);
            ba8Var.r(true);
            this.e.e(this.l);
        }
    }

    public void c0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.q = true;
            this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.h.setVisibility(8);
            c98.c(this.a, new h(this, z2, z));
        }
    }

    public void U(Context context, w78 w78Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048596, this, context, w78Var, z) == null) {
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(context, 12004, true);
            atListActivityConfig.setIsForGroupChat(true);
            atListActivityConfig.setCallAtListSource(AtListActivityConfig.GROUP_BOT_SKILL);
            if (!ListUtils.isEmpty(B()) && ListUtils.getCount(B()) > 0) {
                atListActivityConfig.setSelectedAtUid(TextUtils.join(",", B()));
            }
            if (w78Var.a() > 0) {
                atListActivityConfig.setFromFid(String.valueOf(w78Var.a()));
            }
            atListActivityConfig.setChatroomId(w78Var.c());
            atListActivityConfig.setUserRole(w78Var.d());
            atListActivityConfig.setForumName(w78Var.b());
            atListActivityConfig.setIsShowBotInfo(false);
            atListActivityConfig.setCallAtListOptional(z);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
        }
    }

    public final void W(@NonNull SkillSugRequest skillSugRequest) {
        TbPageContext<BaseFragmentActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, skillSugRequest) == null) {
            if (this.s == null && (tbPageContext = this.t) != null) {
                this.s = new FastRequest(tbPageContext, CmdConfigHttp.CMD_POST_SKILL_SUG, TbConfig.URL_GET_SKILL_SUG_LIST);
            }
            FastRequest fastRequest = this.s;
            if (fastRequest != null) {
                fastRequest.T(HttpMessageTask.HTTP_METHOD.POST);
                fastRequest.O("skill_id", Long.valueOf(skillSugRequest.getSkillId()));
                fastRequest.O("robot_uk", skillSugRequest.getBotUk());
                fastRequest.O("forum_id", Long.valueOf(skillSugRequest.getForumId()));
                fastRequest.O("chatroom_id", Long.valueOf(skillSugRequest.getChatroomId()));
                fastRequest.Q(this.z);
                fastRequest.P();
            }
        }
    }

    public void e0(k kVar, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048606, this, kVar, lVar, z) == null) {
            this.q = true;
            this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            c98.c(this.a, new i(this, kVar, lVar, z));
        }
    }
}

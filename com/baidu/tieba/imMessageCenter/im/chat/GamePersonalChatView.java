package com.baidu.tieba.imMessageCenter.im.chat;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.RoundRelativeLayout;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.imMessageCenter.im.view.GameContactsView;
import com.baidu.tieba.imMessageCenter.im.view.GamePersonalChatTitleView;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.de5;
import com.repackage.f67;
import com.repackage.he5;
import com.repackage.j15;
import com.repackage.jd5;
import com.repackage.k15;
import com.repackage.k57;
import com.repackage.ng;
import com.repackage.pi;
import com.repackage.u97;
import com.repackage.ur4;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class GamePersonalChatView extends PersonalChatView {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public transient /* synthetic */ FieldHolder $fh;
    public final GamePersonalChatActivity o;
    public GameContactsView p;
    public GamePersonalChatTitleView q;
    public Fragment r;
    public final Map<String, Object> s;
    public View t;
    public int u;
    public String v;
    public String w;
    public String x;
    public k57 y;
    public k15 z;

    /* loaded from: classes3.dex */
    public class a implements jd5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserData a;
        public final /* synthetic */ GamePersonalChatView b;

        public a(GamePersonalChatView gamePersonalChatView, UserData userData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePersonalChatView, userData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gamePersonalChatView;
            this.a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(Void r5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, r5) == null) || this.b.o == null) {
                return;
            }
            this.b.o.s2(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePersonalChatView a;

        public b(GamePersonalChatView gamePersonalChatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePersonalChatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePersonalChatView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                ViewGroup.LayoutParams layoutParams = this.a.originListContainer.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.a.originListContainer.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePersonalChatView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(GamePersonalChatView gamePersonalChatView) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePersonalChatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((d) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePersonalChatView;
        }

        @Override // com.baidu.tieba.imMessageCenter.im.chat.GamePersonalChatView.m, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.originListContainer.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePersonalChatView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(GamePersonalChatView gamePersonalChatView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePersonalChatView, Integer.valueOf(i)};
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
            this.a = gamePersonalChatView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921708 && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                this.a.g0(hashMap);
                this.a.p0(hashMap);
                Integer num = (Integer) hashMap.get("imShowType");
                if (num == null) {
                    return;
                }
                int intValue = num.intValue();
                if (intValue == 0) {
                    this.a.n0();
                } else if (intValue == 1) {
                    List<k57> h = k57.h(hashMap);
                    if (h.isEmpty()) {
                        this.a.n0();
                    } else {
                        this.a.l0(h);
                    }
                } else if (intValue == 2) {
                    this.a.h0();
                } else if (intValue != 3) {
                } else {
                    this.a.q0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePersonalChatView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(GamePersonalChatView gamePersonalChatView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePersonalChatView, Integer.valueOf(i)};
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
            this.a = gamePersonalChatView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016004) {
                this.a.o0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements GameContactsView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePersonalChatView a;

        public f(GamePersonalChatView gamePersonalChatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePersonalChatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePersonalChatView;
        }

        @Override // com.baidu.tieba.imMessageCenter.im.view.GameContactsView.a
        public void a(View view2, k57 k57Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, view2, k57Var, i) == null) {
                this.a.y = k57Var;
                if (i != 3) {
                    this.a.q.h(k57Var);
                    this.a.o.K = false;
                    this.a.r0(k57Var);
                    u97.h(this.a.x, this.a.w, k57Var.d(), k57Var.b(), k57Var.e());
                }
                if (i != 1) {
                    u97.e(this.a.x, this.a.w, k57Var.d(), k57Var.b(), k57Var.e());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements GamePersonalChatTitleView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePersonalChatView a;

        public g(GamePersonalChatView gamePersonalChatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePersonalChatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePersonalChatView;
        }

        @Override // com.baidu.tieba.imMessageCenter.im.view.GamePersonalChatTitleView.b
        public void a(@NonNull k57 k57Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k57Var) == null) {
                u97.a(this.a.x, this.a.w, k57Var.d(), k57Var.b(), k57Var.e());
                if (k57Var.e()) {
                    if (this.a.o.C0() == null || TextUtils.isEmpty(this.a.v)) {
                        return;
                    }
                    this.a.o.C0().sendTextMessage(this.a.v);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921713, k57Var));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePersonalChatView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(GamePersonalChatView gamePersonalChatView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePersonalChatView, Integer.valueOf(i)};
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
            this.a = gamePersonalChatView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object obj;
            k57 g;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921712 || !(customResponsedMessage.getData() instanceof HashMap) || (obj = ((HashMap) customResponsedMessage.getData()).get("imUser")) == null || (g = k57.g(obj)) == null) {
                return;
            }
            if (this.a.p.b(g)) {
                this.a.q.h(g);
                this.a.o.K = false;
                this.a.r0(g);
                this.a.o.A2(this.a.v);
            } else if (TextUtils.isEmpty(this.a.v)) {
            } else {
                this.a.o.C0().sendTextMessage(this.a.v);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePersonalChatView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(GamePersonalChatView gamePersonalChatView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePersonalChatView, Integer.valueOf(i)};
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
            this.a = gamePersonalChatView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || this.a.originListContainer == null || this.a.originListContainer.getVisibility() != 0) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            ViewGroup.LayoutParams layoutParams = this.a.originListContainer.getLayoutParams();
            int i2 = pi.i(CyberPlayerManager.getApplicationContext());
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                i = TbadkCoreApplication.getInst().getKeyboardHeight();
            } else {
                i = (i2 / 2) - 250;
            }
            if (booleanValue) {
                layoutParams.height += i;
            } else {
                layoutParams.height -= i;
            }
            this.a.originListContainer.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements k15 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePersonalChatView a;

        public j(GamePersonalChatView gamePersonalChatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePersonalChatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePersonalChatView;
        }

        @Override // com.repackage.k15
        public void C(j15 j15Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, j15Var) == null) || j15Var == null || this.a.y == null) {
                return;
            }
            int i = j15Var.a;
            if (i == 14) {
                u97.d(this.a.x, this.a.w, this.a.y.b(), this.a.y.e());
                return;
            }
            if (i == 63) {
                Object obj = j15Var.c;
                if (obj instanceof Boolean) {
                    u97.f(this.a.x, this.a.w, this.a.y.b(), this.a.y.e(), ((Boolean) obj).booleanValue() ? 1 : 2);
                }
            } else if (i != 62) {
                if (i == 64) {
                    u97.b(this.a.x, this.a.w, this.a.y.b(), this.a.y.e());
                }
            } else {
                Object obj2 = j15Var.c;
                if (obj2 instanceof Boolean) {
                    u97.c(this.a.x, this.a.w, this.a.y.b(), this.a.y.e(), ((Boolean) obj2).booleanValue() ? 1 : 2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamePersonalChatView a;

        public k(GamePersonalChatView gamePersonalChatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePersonalChatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamePersonalChatView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                ViewGroup.LayoutParams layoutParams = this.a.originListContainer.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.a.originListContainer.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends de5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedList a;

        public l(GamePersonalChatView gamePersonalChatView, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePersonalChatView, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.de5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f67.v().a(this.a) : (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class m implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public /* synthetic */ m(d dVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1489912667, "Lcom/baidu/tieba/imMessageCenter/im/chat/GamePersonalChatView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1489912667, "Lcom/baidu/tieba/imMessageCenter/im/chat/GamePersonalChatView;");
                return;
            }
        }
        A = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070756);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GamePersonalChatView(GamePersonalChatActivity gamePersonalChatActivity, boolean z, Map<String, Object> map) {
        super(gamePersonalChatActivity, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gamePersonalChatActivity, Boolean.valueOf(z), map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((MsglistActivity) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = A;
        this.o = gamePersonalChatActivity;
        this.s = map;
        if (map != null) {
            this.x = String.valueOf(map.get("game_id"));
            this.w = String.valueOf(map.get("game_name"));
        }
        GamePersonalChatActivity gamePersonalChatActivity2 = this.o;
        if (gamePersonalChatActivity2 instanceof BaseFragmentActivity) {
            gamePersonalChatActivity2.setSwipeBackEnabled(false);
        }
        i0();
        k0();
        j0();
    }

    public final void g0(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && (hashMap.get("imTopMargin") instanceof Integer)) {
            Integer num = (Integer) hashMap.get("imTopMargin");
            int i2 = pi.i(TbadkCoreApplication.getInst());
            if (num == null || num.intValue() <= 0 || num.intValue() >= i2) {
                return;
            }
            this.u = i2 - num.intValue();
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.originListContainer.getVisibility() == 0) {
            ValueAnimator ofInt = ValueAnimator.ofInt(this.u, 0);
            ofInt.addUpdateListener(new b(this));
            ofInt.addListener(new c(this));
            ofInt.setDuration(500L);
            ofInt.start();
            GamePersonalChatActivity gamePersonalChatActivity = this.o;
            pi.x(gamePersonalChatActivity, gamePersonalChatActivity.getCurrentFocus());
            this.mTool.A(new j15(5, -1, null));
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null) {
                navigationBar.setVisibility(8);
            }
            GamePersonalChatTitleView gamePersonalChatTitleView = (GamePersonalChatTitleView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f090c27);
            this.q = gamePersonalChatTitleView;
            gamePersonalChatTitleView.setVisibility(0);
            GameContactsView gameContactsView = (GameContactsView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f090c13);
            this.p = gameContactsView;
            gameContactsView.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mListMain.getLayoutParams();
            layoutParams.addRule(1, R.id.obfuscated_res_0x7f090c13);
            this.mListMain.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.viewHeader.getLayoutParams();
            layoutParams2.addRule(3, R.id.obfuscated_res_0x7f090c27);
            layoutParams2.addRule(1, R.id.obfuscated_res_0x7f090c13);
            this.viewHeader.setLayoutParams(layoutParams2);
            this.mNetworkView.b();
            this.originListContainer.setAllCornerRound(RoundRelativeLayout.e);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.originListContainer.getLayoutParams();
            layoutParams3.height = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070756);
            layoutParams3.addRule(12);
            this.originListContainer.setLayoutParams(layoutParams3);
            View findViewById = this.mRootView.findViewById(R.id.obfuscated_res_0x7f0921ce);
            this.t = findViewById;
            findViewById.setVisibility(8);
            this.originListContainer.setVisibility(8);
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FragmentManager supportFragmentManager = ((AbsMsglistView) this).mContext.getSupportFragmentManager();
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Fragment findFragmentById = supportFragmentManager.findFragmentById(R.id.obfuscated_res_0x7f0909c3);
            if (findFragmentById == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921707, Fragment.class, new FlutterOpenData(((AbsMsglistView) this).mContext, null, this.s));
                if (runTask != null) {
                    this.r = (Fragment) runTask.getData();
                }
            } else {
                beginTransaction.remove(findFragmentById);
                supportFragmentManager.popBackStack();
                beginTransaction.commit();
                beginTransaction = supportFragmentManager.beginTransaction();
            }
            Fragment fragment = this.r;
            if (fragment != null) {
                beginTransaction.add(R.id.obfuscated_res_0x7f0909c3, fragment);
            }
            beginTransaction.commit();
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ((AbsMsglistView) this).mContext.registerListener(new d(this, 2921708));
            ((AbsMsglistView) this).mContext.registerListener(new e(this, 2016004));
            this.p.setOnContactsItemViewClick(new f(this));
            this.q.setOnTitleBtnClick(new g(this));
            ((AbsMsglistView) this).mContext.registerListener(new h(this, 2921712));
            ((AbsMsglistView) this).mContext.registerListener(new i(this, 2010046));
            if (this.z != null || this.mTool == null) {
                return;
            }
            j jVar = new j(this);
            this.z = jVar;
            this.mTool.setActionListener(14, jVar);
            this.mTool.setActionListener(63, this.z);
            this.mTool.setActionListener(64, this.z);
            this.mTool.setActionListener(62, this.z);
        }
    }

    public final void l0(@NonNull List<k57> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.p.a(list);
            q0();
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.p.c();
            h0();
        }
    }

    public final void o0(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage)) {
            this.p.e(((MemoryChangedMessage) customResponsedMessage).getData());
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView, com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.onChangeSkinType(i2);
            ur4.d(this.p).f(R.color.CAM_X0204);
            this.q.g();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p0(HashMap hashMap) {
        HashMap hashMap2;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, hashMap) == null) && (hashMap.get("imGameCard") instanceof HashMap) && (hashMap2 = (HashMap) hashMap.get("imGameCard")) != null) {
            String str4 = "";
            if (hashMap2.get("game_info") instanceof HashMap) {
                Object obj = hashMap2.get("game_info");
                if (obj instanceof HashMap) {
                    HashMap hashMap3 = (HashMap) obj;
                    str4 = (String) hashMap3.get("game_name");
                    str = (String) hashMap3.get("game_id");
                    str2 = (String) hashMap2.get("god_level");
                    str3 = (String) hashMap2.get("order_area");
                    StringBuilder sb = new StringBuilder();
                    if (!TextUtils.isEmpty(str4)) {
                        sb.append(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f078d), str4));
                    }
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f078b), str));
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        sb.append(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f078c), str2));
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        sb.append(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0789), str3));
                    }
                    sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f078a));
                    this.v = sb.toString();
                }
            }
            str = "";
            str2 = (String) hashMap2.get("god_level");
            str3 = (String) hashMap2.get("order_area");
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(str4)) {
            }
            if (!TextUtils.isEmpty(str)) {
            }
            if (!TextUtils.isEmpty(str2)) {
            }
            if (!TextUtils.isEmpty(str3)) {
            }
            sb2.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f078a));
            this.v = sb2.toString();
        }
    }

    public final void q0() {
        com.baidu.tieba.view.RoundRelativeLayout roundRelativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (roundRelativeLayout = this.originListContainer) == null || roundRelativeLayout.getVisibility() == 0) {
            return;
        }
        this.originListContainer.setVisibility(0);
        ValueAnimator ofInt = ValueAnimator.ofInt(this.u);
        ofInt.setInterpolator(new OvershootInterpolator(1.0f));
        ofInt.addUpdateListener(new k(this));
        ofInt.setDuration(500L);
        ofInt.start();
    }

    public final void r0(@NonNull k57 k57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, k57Var) == null) {
            UserData userData = new UserData();
            userData.setPortrait(k57Var.a());
            userData.setName_show(k57Var.c());
            userData.setUserId(k57Var.d());
            userData.setUserIdLong(ng.g(k57Var.d(), 0L));
            LinkedList linkedList = new LinkedList();
            linkedList.add(String.valueOf(userData.getUserId()));
            he5.c(new l(this, linkedList), new a(this, userData));
        }
    }
}

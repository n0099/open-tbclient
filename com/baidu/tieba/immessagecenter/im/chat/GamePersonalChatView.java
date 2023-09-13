package com.baidu.tieba.immessagecenter.im.chat;

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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.by5;
import com.baidu.tieba.cx5;
import com.baidu.tieba.dt8;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GameMatchUser;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.si5;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.ti5;
import com.baidu.tieba.vf8;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.view.gameim.GameContactsView;
import com.baidu.tieba.view.gameim.GamePersonalChatTitleView;
import com.baidu.tieba.xx5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class GamePersonalChatView extends PersonalChatView {
    public static /* synthetic */ Interceptable $ic;
    public static final int H;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public int B;
    public String C;
    public String D;
    public String E;
    public GameMatchUser F;
    public ti5 G;
    public final GamePersonalChatActivity u;
    public boolean v;
    public GameContactsView w;
    public GamePersonalChatTitleView x;
    public Fragment y;
    public final Map<String, Object> z;

    /* loaded from: classes6.dex */
    public class a implements cx5<Void> {
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
        @Override // com.baidu.tieba.cx5
        /* renamed from: a */
        public void onReturnDataInUI(Void r5) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, r5) == null) && this.b.u != null) {
                this.b.u.o3(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

        @Override // com.baidu.tieba.immessagecenter.im.chat.GamePersonalChatView.m, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.originListContainer.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.A0(hashMap);
                this.a.J0(hashMap);
                Integer num = (Integer) hashMap.get("imShowType");
                if (num == null) {
                    return;
                }
                int intValue = num.intValue();
                if (intValue != 0) {
                    if (intValue != 1) {
                        if (intValue != 2) {
                            if (intValue != 3) {
                                return;
                            }
                            this.a.K0();
                            return;
                        }
                        this.a.B0();
                        return;
                    }
                    List<GameMatchUser> parserFlutterList = GameMatchUser.parserFlutterList(hashMap);
                    if (!parserFlutterList.isEmpty()) {
                        this.a.G0(parserFlutterList);
                        return;
                    } else {
                        this.a.H0();
                        return;
                    }
                }
                this.a.H0();
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016004) {
                return;
            }
            this.a.I0(customResponsedMessage);
        }
    }

    /* loaded from: classes6.dex */
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

        @Override // com.baidu.tieba.view.gameim.GameContactsView.a
        public void a(View view2, GameMatchUser gameMatchUser, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLI(1048576, this, view2, gameMatchUser, i) != null) || gameMatchUser == null) {
                return;
            }
            this.a.F = gameMatchUser;
            if (i != 3) {
                this.a.x.h(gameMatchUser);
                this.a.u.K = false;
                this.a.L0(gameMatchUser);
                dt8.h(this.a.E, this.a.D, gameMatchUser.getUserId(), gameMatchUser.getPos(), gameMatchUser.isFree());
            }
            if (i != 1) {
                dt8.e(this.a.E, this.a.D, gameMatchUser.getUserId(), gameMatchUser.getPos(), gameMatchUser.isFree());
            }
        }
    }

    /* loaded from: classes6.dex */
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

        @Override // com.baidu.tieba.view.gameim.GamePersonalChatTitleView.b
        public void a(@NonNull GameMatchUser gameMatchUser) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gameMatchUser) == null) {
                dt8.a(this.a.E, this.a.D, gameMatchUser.getUserId(), gameMatchUser.getPos(), gameMatchUser.isFree());
                if (gameMatchUser.isFree()) {
                    if (this.a.u.E1() != null && !TextUtils.isEmpty(this.a.C)) {
                        this.a.u.E1().sendTextMessage(this.a.C);
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921713, gameMatchUser));
            }
        }
    }

    /* loaded from: classes6.dex */
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
            GameMatchUser parserFlutterData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921712 || !(customResponsedMessage.getData() instanceof HashMap) || (obj = ((HashMap) customResponsedMessage.getData()).get("imUser")) == null || (parserFlutterData = GameMatchUser.parserFlutterData(obj)) == null) {
                return;
            }
            if (this.a.w.b(parserFlutterData)) {
                this.a.x.h(parserFlutterData);
                this.a.u.K = false;
                this.a.L0(parserFlutterData);
                this.a.u.w3(this.a.C);
            } else if (!TextUtils.isEmpty(this.a.C)) {
                this.a.u.E1().sendTextMessage(this.a.C);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && this.a.originListContainer != null && this.a.originListContainer.getVisibility() == 0) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                ViewGroup.LayoutParams layoutParams = this.a.originListContainer.getLayoutParams();
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(CyberPlayerManager.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                } else {
                    i = (equipmentHeight / 2) - 250;
                }
                if (booleanValue) {
                    layoutParams.height += i;
                } else {
                    layoutParams.height -= i;
                }
                this.a.originListContainer.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements ti5 {
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

        @Override // com.baidu.tieba.ti5
        public void G(si5 si5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, si5Var) == null) && si5Var != null && this.a.F != null) {
                int i = si5Var.a;
                if (i == 14) {
                    dt8.d(this.a.E, this.a.D, this.a.F.getPos(), this.a.F.isFree());
                    return;
                }
                int i2 = 1;
                if (i == 63) {
                    Object obj = si5Var.c;
                    if (obj instanceof Boolean) {
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        String str = this.a.E;
                        String str2 = this.a.D;
                        int pos = this.a.F.getPos();
                        boolean isFree = this.a.F.isFree();
                        if (!booleanValue) {
                            i2 = 2;
                        }
                        dt8.f(str, str2, pos, isFree, i2);
                    }
                } else if (i == 62) {
                    Object obj2 = si5Var.c;
                    if (obj2 instanceof Boolean) {
                        boolean booleanValue2 = ((Boolean) obj2).booleanValue();
                        String str3 = this.a.E;
                        String str4 = this.a.D;
                        int pos2 = this.a.F.getPos();
                        boolean isFree2 = this.a.F.isFree();
                        if (!booleanValue2) {
                            i2 = 2;
                        }
                        dt8.c(str3, str4, pos2, isFree2, i2);
                    }
                } else if (i == 64) {
                    dt8.b(this.a.E, this.a.D, this.a.F.getPos(), this.a.F.isFree());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class l extends xx5<Void> {
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
        @Override // com.baidu.tieba.xx5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return vf8.w().a(this.a);
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public /* synthetic */ m(d dVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1998379173, "Lcom/baidu/tieba/immessagecenter/im/chat/GamePersonalChatView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1998379173, "Lcom/baidu/tieba/immessagecenter/im/chat/GamePersonalChatView;");
                return;
            }
        }
        H = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0708db);
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.w.c();
            B0();
        }
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
        this.v = false;
        this.B = H;
        this.u = gamePersonalChatActivity;
        this.z = map;
        if (map != null) {
            this.E = String.valueOf(map.get("game_id"));
            this.D = String.valueOf(map.get("game_name"));
        }
        GamePersonalChatActivity gamePersonalChatActivity2 = this.u;
        if (gamePersonalChatActivity2 instanceof BaseFragmentActivity) {
            gamePersonalChatActivity2.setSwipeBackEnabled(false);
        }
        this.v = DeviceInfoUtil.isHarmonyOs200();
        D0();
        F0();
        E0();
    }

    public final void G0(@NonNull List<GameMatchUser> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.w.a(list);
            K0();
        }
    }

    public final void I0(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof MemoryChangedMessage)) {
            return;
        }
        this.w.e(((MemoryChangedMessage) customResponsedMessage).getData());
    }

    @Override // com.baidu.tieba.immessagecenter.im.chat.PersonalChatView, com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.onChangeSkinType(i2);
            EMManager.from(this.w).setBackGroundColor(R.color.CAM_X0204);
            this.x.g();
        }
    }

    public final void A0(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && (hashMap.get("imTopMargin") instanceof Integer)) {
            Integer num = (Integer) hashMap.get("imTopMargin");
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
            if (num != null && num.intValue() > 0 && num.intValue() < equipmentHeight) {
                this.B = equipmentHeight - num.intValue();
            }
        }
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.originListContainer.getVisibility() != 0) {
            return;
        }
        if (this.v) {
            this.originListContainer.setVisibility(8);
        } else {
            ValueAnimator ofInt = ValueAnimator.ofInt(this.B, 0);
            ofInt.addUpdateListener(new b(this));
            ofInt.addListener(new c(this));
            ofInt.setDuration(500L);
            ofInt.start();
        }
        GamePersonalChatActivity gamePersonalChatActivity = this.u;
        BdUtilHelper.hideSoftKeyPad(gamePersonalChatActivity, gamePersonalChatActivity.getCurrentFocus());
        this.mTool.D(new si5(5, -1, null));
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FragmentManager supportFragmentManager = ((AbsMsglistView) this).mContext.getSupportFragmentManager();
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Fragment findFragmentById = supportFragmentManager.findFragmentById(R.id.flutter_page_container);
            if (findFragmentById == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921707, Fragment.class, new FlutterOpenData(((AbsMsglistView) this).mContext, null, this.z));
                if (runTask != null) {
                    this.y = (Fragment) runTask.getData();
                }
            } else {
                beginTransaction.remove(findFragmentById);
                supportFragmentManager.popBackStack();
                beginTransaction.commit();
                beginTransaction = supportFragmentManager.beginTransaction();
            }
            Fragment fragment = this.y;
            if (fragment != null) {
                beginTransaction.add(R.id.flutter_page_container, fragment);
            }
            beginTransaction.commit();
        }
    }

    public final void K0() {
        RoundRelativeLayout roundRelativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (roundRelativeLayout = this.originListContainer) != null && roundRelativeLayout.getVisibility() != 0) {
            this.originListContainer.setVisibility(0);
            if (!this.v) {
                ValueAnimator ofInt = ValueAnimator.ofInt(this.B);
                ofInt.setInterpolator(new OvershootInterpolator(1.0f));
                ofInt.addUpdateListener(new k(this));
                ofInt.setDuration(500L);
                ofInt.start();
            }
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null) {
                navigationBar.setVisibility(8);
            }
            GamePersonalChatTitleView gamePersonalChatTitleView = (GamePersonalChatTitleView) this.mRootView.findViewById(R.id.game_title_container);
            this.x = gamePersonalChatTitleView;
            gamePersonalChatTitleView.setVisibility(0);
            GameContactsView gameContactsView = (GameContactsView) this.mRootView.findViewById(R.id.game_contacts_view);
            this.w = gameContactsView;
            gameContactsView.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mListMain.getLayoutParams();
            layoutParams.addRule(1, R.id.game_contacts_view);
            this.mListMain.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.viewHeader.getLayoutParams();
            layoutParams2.addRule(3, R.id.game_title_container);
            layoutParams2.addRule(1, R.id.game_contacts_view);
            this.viewHeader.setLayoutParams(layoutParams2);
            this.mNetworkView.hideCheckDetail();
            RoundRelativeLayout roundRelativeLayout = this.originListContainer;
            float f2 = com.baidu.tbadk.core.dialog.RoundRelativeLayout.e;
            roundRelativeLayout.setRoundLayoutRadius(new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f});
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.originListContainer.getLayoutParams();
            layoutParams3.height = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0708db);
            layoutParams3.addRule(12);
            this.originListContainer.setLayoutParams(layoutParams3);
            View findViewById = this.mRootView.findViewById(R.id.transpant_view);
            this.A = findViewById;
            findViewById.setVisibility(8);
            this.originListContainer.setVisibility(8);
        }
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ((AbsMsglistView) this).mContext.registerListener(new d(this, 2921708));
            ((AbsMsglistView) this).mContext.registerListener(new e(this, 2016004));
            this.w.setOnContactsItemViewClick(new f(this));
            this.x.setOnTitleBtnClick(new g(this));
            ((AbsMsglistView) this).mContext.registerListener(new h(this, 2921712));
            ((AbsMsglistView) this).mContext.registerListener(new i(this, 2010046));
            if (this.G == null && this.mTool != null) {
                j jVar = new j(this);
                this.G = jVar;
                this.mTool.setActionListener(14, jVar);
                this.mTool.setActionListener(63, this.G);
                this.mTool.setActionListener(64, this.G);
                this.mTool.setActionListener(62, this.G);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void J0(HashMap hashMap) {
        HashMap hashMap2;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hashMap) != null) || !(hashMap.get("imGameCard") instanceof HashMap) || (hashMap2 = (HashMap) hashMap.get("imGameCard")) == null) {
            return;
        }
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
                    sb.append(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08c5), str4));
                }
                if (!TextUtils.isEmpty(str)) {
                    sb.append(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08c3), str));
                }
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08c4), str2));
                }
                if (!TextUtils.isEmpty(str3)) {
                    sb.append(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08c1), str3));
                }
                sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08c2));
                this.C = sb.toString();
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
        sb2.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08c2));
        this.C = sb2.toString();
    }

    public final void L0(@NonNull GameMatchUser gameMatchUser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gameMatchUser) == null) {
            UserData userData = new UserData();
            userData.setPortrait(gameMatchUser.getAvatar());
            userData.setName_show(gameMatchUser.getShowName());
            userData.setUserId(gameMatchUser.getUserId());
            userData.setUserIdLong(JavaTypesHelper.toLong(gameMatchUser.getUserId(), 0L));
            LinkedList linkedList = new LinkedList();
            linkedList.add(String.valueOf(userData.getUserId()));
            by5.c(new l(this, linkedList), new a(this, userData));
        }
    }
}

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
import com.baidu.tieba.co8;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GameMatchUser;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.kw5;
import com.baidu.tieba.lh5;
import com.baidu.tieba.mh5;
import com.baidu.tieba.ow5;
import com.baidu.tieba.pv5;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.view.gameim.GameContactsView;
import com.baidu.tieba.view.gameim.GamePersonalChatTitleView;
import com.baidu.tieba.zb8;
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
    public static final int E;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public GameMatchUser C;
    public mh5 D;
    public final GamePersonalChatActivity r;
    public boolean s;
    public GameContactsView t;
    public GamePersonalChatTitleView u;
    public Fragment v;
    public final Map<String, Object> w;
    public View x;
    public int y;
    public String z;

    /* loaded from: classes6.dex */
    public class a implements pv5<Void> {
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
        @Override // com.baidu.tieba.pv5
        /* renamed from: a */
        public void onReturnDataInUI(Void r5) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, r5) == null) && this.b.r != null) {
                this.b.r.i3(this.a);
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
                            this.a.L0();
                            return;
                        }
                        this.a.B0();
                        return;
                    }
                    List<GameMatchUser> parserFlutterList = GameMatchUser.parserFlutterList(hashMap);
                    if (!parserFlutterList.isEmpty()) {
                        this.a.F0(parserFlutterList);
                        return;
                    } else {
                        this.a.G0();
                        return;
                    }
                }
                this.a.G0();
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
            this.a.H0(customResponsedMessage);
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
            this.a.C = gameMatchUser;
            if (i != 3) {
                this.a.u.h(gameMatchUser);
                this.a.r.K = false;
                this.a.M0(gameMatchUser);
                co8.h(this.a.B, this.a.A, gameMatchUser.getUserId(), gameMatchUser.getPos(), gameMatchUser.isFree());
            }
            if (i != 1) {
                co8.e(this.a.B, this.a.A, gameMatchUser.getUserId(), gameMatchUser.getPos(), gameMatchUser.isFree());
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
                co8.a(this.a.B, this.a.A, gameMatchUser.getUserId(), gameMatchUser.getPos(), gameMatchUser.isFree());
                if (gameMatchUser.isFree()) {
                    if (this.a.r.D1() != null && !TextUtils.isEmpty(this.a.z)) {
                        this.a.r.D1().sendTextMessage(this.a.z);
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
            if (this.a.t.b(parserFlutterData)) {
                this.a.u.h(parserFlutterData);
                this.a.r.K = false;
                this.a.M0(parserFlutterData);
                this.a.r.q3(this.a.z);
            } else if (!TextUtils.isEmpty(this.a.z)) {
                this.a.r.D1().sendTextMessage(this.a.z);
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
    public class j implements mh5 {
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

        @Override // com.baidu.tieba.mh5
        public void B(lh5 lh5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, lh5Var) == null) && lh5Var != null && this.a.C != null) {
                int i = lh5Var.a;
                if (i == 14) {
                    co8.d(this.a.B, this.a.A, this.a.C.getPos(), this.a.C.isFree());
                    return;
                }
                int i2 = 1;
                if (i == 63) {
                    Object obj = lh5Var.c;
                    if (obj instanceof Boolean) {
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        String str = this.a.B;
                        String str2 = this.a.A;
                        int pos = this.a.C.getPos();
                        boolean isFree = this.a.C.isFree();
                        if (!booleanValue) {
                            i2 = 2;
                        }
                        co8.f(str, str2, pos, isFree, i2);
                    }
                } else if (i == 62) {
                    Object obj2 = lh5Var.c;
                    if (obj2 instanceof Boolean) {
                        boolean booleanValue2 = ((Boolean) obj2).booleanValue();
                        String str3 = this.a.B;
                        String str4 = this.a.A;
                        int pos2 = this.a.C.getPos();
                        boolean isFree2 = this.a.C.isFree();
                        if (!booleanValue2) {
                            i2 = 2;
                        }
                        co8.c(str3, str4, pos2, isFree2, i2);
                    }
                } else if (i == 64) {
                    co8.b(this.a.B, this.a.A, this.a.C.getPos(), this.a.C.isFree());
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
    public class l extends kw5<Void> {
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
        @Override // com.baidu.tieba.kw5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return zb8.w().a(this.a);
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
        E = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0708d5);
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.t.c();
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
        this.s = false;
        this.y = E;
        this.r = gamePersonalChatActivity;
        this.w = map;
        if (map != null) {
            this.B = String.valueOf(map.get("game_id"));
            this.A = String.valueOf(map.get("game_name"));
        }
        GamePersonalChatActivity gamePersonalChatActivity2 = this.r;
        if (gamePersonalChatActivity2 instanceof BaseFragmentActivity) {
            gamePersonalChatActivity2.setSwipeBackEnabled(false);
        }
        this.s = DeviceInfoUtil.isHarmonyOs200();
        C0();
        E0();
        D0();
    }

    public final void F0(@NonNull List<GameMatchUser> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.t.a(list);
            L0();
        }
    }

    public final void H0(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof MemoryChangedMessage)) {
            return;
        }
        this.t.e(((MemoryChangedMessage) customResponsedMessage).getData());
    }

    @Override // com.baidu.tieba.immessagecenter.im.chat.PersonalChatView, com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.onChangeSkinType(i2);
            EMManager.from(this.t).setBackGroundColor(R.color.CAM_X0204);
            this.u.g();
        }
    }

    public final void A0(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && (hashMap.get("imTopMargin") instanceof Integer)) {
            Integer num = (Integer) hashMap.get("imTopMargin");
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
            if (num != null && num.intValue() > 0 && num.intValue() < equipmentHeight) {
                this.y = equipmentHeight - num.intValue();
            }
        }
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.originListContainer.getVisibility() != 0) {
            return;
        }
        if (this.s) {
            this.originListContainer.setVisibility(8);
        } else {
            ValueAnimator ofInt = ValueAnimator.ofInt(this.y, 0);
            ofInt.addUpdateListener(new b(this));
            ofInt.addListener(new c(this));
            ofInt.setDuration(500L);
            ofInt.start();
        }
        GamePersonalChatActivity gamePersonalChatActivity = this.r;
        BdUtilHelper.hideSoftKeyPad(gamePersonalChatActivity, gamePersonalChatActivity.getCurrentFocus());
        this.mTool.D(new lh5(5, -1, null));
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FragmentManager supportFragmentManager = ((AbsMsglistView) this).mContext.getSupportFragmentManager();
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Fragment findFragmentById = supportFragmentManager.findFragmentById(R.id.flutter_page_container);
            if (findFragmentById == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921707, Fragment.class, new FlutterOpenData(((AbsMsglistView) this).mContext, null, this.w));
                if (runTask != null) {
                    this.v = (Fragment) runTask.getData();
                }
            } else {
                beginTransaction.remove(findFragmentById);
                supportFragmentManager.popBackStack();
                beginTransaction.commit();
                beginTransaction = supportFragmentManager.beginTransaction();
            }
            Fragment fragment = this.v;
            if (fragment != null) {
                beginTransaction.add(R.id.flutter_page_container, fragment);
            }
            beginTransaction.commit();
        }
    }

    public final void L0() {
        RoundRelativeLayout roundRelativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (roundRelativeLayout = this.originListContainer) != null && roundRelativeLayout.getVisibility() != 0) {
            this.originListContainer.setVisibility(0);
            if (!this.s) {
                ValueAnimator ofInt = ValueAnimator.ofInt(this.y);
                ofInt.setInterpolator(new OvershootInterpolator(1.0f));
                ofInt.addUpdateListener(new k(this));
                ofInt.setDuration(500L);
                ofInt.start();
            }
        }
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null) {
                navigationBar.setVisibility(8);
            }
            GamePersonalChatTitleView gamePersonalChatTitleView = (GamePersonalChatTitleView) this.mRootView.findViewById(R.id.game_title_container);
            this.u = gamePersonalChatTitleView;
            gamePersonalChatTitleView.setVisibility(0);
            GameContactsView gameContactsView = (GameContactsView) this.mRootView.findViewById(R.id.game_contacts_view);
            this.t = gameContactsView;
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
            layoutParams3.height = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0708d5);
            layoutParams3.addRule(12);
            this.originListContainer.setLayoutParams(layoutParams3);
            View findViewById = this.mRootView.findViewById(R.id.transpant_view);
            this.x = findViewById;
            findViewById.setVisibility(8);
            this.originListContainer.setVisibility(8);
        }
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ((AbsMsglistView) this).mContext.registerListener(new d(this, 2921708));
            ((AbsMsglistView) this).mContext.registerListener(new e(this, 2016004));
            this.t.setOnContactsItemViewClick(new f(this));
            this.u.setOnTitleBtnClick(new g(this));
            ((AbsMsglistView) this).mContext.registerListener(new h(this, 2921712));
            ((AbsMsglistView) this).mContext.registerListener(new i(this, 2010046));
            if (this.D == null && this.mTool != null) {
                j jVar = new j(this);
                this.D = jVar;
                this.mTool.setActionListener(14, jVar);
                this.mTool.setActionListener(63, this.D);
                this.mTool.setActionListener(64, this.D);
                this.mTool.setActionListener(62, this.D);
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
                    sb.append(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08ba), str4));
                }
                if (!TextUtils.isEmpty(str)) {
                    sb.append(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08b8), str));
                }
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08b9), str2));
                }
                if (!TextUtils.isEmpty(str3)) {
                    sb.append(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08b6), str3));
                }
                sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08b7));
                this.z = sb.toString();
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
        sb2.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08b7));
        this.z = sb2.toString();
    }

    public final void M0(@NonNull GameMatchUser gameMatchUser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gameMatchUser) == null) {
            UserData userData = new UserData();
            userData.setPortrait(gameMatchUser.getAvatar());
            userData.setName_show(gameMatchUser.getShowName());
            userData.setUserId(gameMatchUser.getUserId());
            userData.setUserIdLong(JavaTypesHelper.toLong(gameMatchUser.getUserId(), 0L));
            LinkedList linkedList = new LinkedList();
            linkedList.add(String.valueOf(userData.getUserId()));
            ow5.c(new l(this, linkedList), new a(this, userData));
        }
    }
}

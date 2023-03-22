package com.baidu.tieba.immessagecenter.chatgroup.floatentrance;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.data.ChatRoomEntranceData;
import com.baidu.tbadk.data.ChatRoomInfoData;
import com.baidu.tbadk.switchs.UnReadRedPotMessage;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.dh5;
import com.baidu.tieba.dp7;
import com.baidu.tieba.eh5;
import com.baidu.tieba.gg;
import com.baidu.tieba.gh5;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.jg;
import com.baidu.tieba.ju7;
import com.baidu.tieba.ka5;
import com.baidu.tieba.ku7;
import com.baidu.tieba.kx7;
import com.baidu.tieba.lt7;
import com.baidu.tieba.lu7;
import com.baidu.tieba.m35;
import com.baidu.tieba.n15;
import com.baidu.tieba.ou7;
import com.baidu.tieba.qu7;
import com.baidu.tieba.ru7;
import com.baidu.tieba.sj9;
import com.baidu.tieba.su7;
import com.baidu.tieba.tu7;
import com.baidu.tieba.uu7;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class ChatFloatEntranceFragment extends BaseFragment implements dh5.b, ju7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static long S = 5000;
    public static final int T;
    public static final int U;
    public static final int V;
    public static int W;
    public static int X;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public lt7 A;
    public boolean B;
    public long C;
    public boolean D;
    public boolean E;
    public boolean F;
    public final CustomMessageListener G;
    public final CustomMessageListener H;
    @NonNull
    public lt7.b I;
    public final CustomMessageListener J;
    public final CustomMessageListener K;
    public final CustomMessageListener L;
    public List<Map<String, Long>> M;
    public final Runnable N;
    public final qu7 O;
    public final ru7 P;
    public final su7.c Q;
    public Runnable R;
    public q a;
    public boolean b;
    public su7 c;
    public int d;
    public boolean e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public PollingModel k;
    public String l;
    public long m;
    public String n;
    public boolean o;
    @NonNull
    public final List<Long> p;
    public int q;
    public long r;
    public String s;
    public List<ChatRoomInfoData> t;
    public Map<Long, Integer> u;
    public int v;
    @Nullable
    public ou7 w;
    public lu7 x;
    public ku7 y;
    public gh5 z;

    @Override // com.baidu.tieba.dh5.b
    public Fragment d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this : (Fragment) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        /* loaded from: classes4.dex */
        public class a implements PollingModel.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            public a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nVar;
            }

            @Override // com.baidu.tbadk.core.leveiconlivepolling.PollingModel.c
            public void a(ChatRoomEntranceData chatRoomEntranceData) {
                ChatRoomInfoData chatRoomInfoData;
                long j;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, chatRoomEntranceData) == null) && chatRoomEntranceData != null && !ListUtils.isEmpty(chatRoomEntranceData.getChatRoomInfoList()) && (chatRoomInfoData = chatRoomEntranceData.getChatRoomInfoList().get(0)) != null) {
                    ChatFloatEntranceFragment chatFloatEntranceFragment = this.a.a;
                    if (chatRoomInfoData.getChatroomInfoBasicData() != null) {
                        j = chatRoomInfoData.getChatroomInfoBasicData().getForumId();
                    } else {
                        j = 0;
                    }
                    chatFloatEntranceFragment.m = j;
                    if (this.a.a.m > 0 && !this.a.a.E) {
                        jg.a().removeCallbacks(this.a.a.N);
                        jg.a().post(this.a.a.N);
                    }
                }
            }
        }

        public n(ChatFloatEntranceFragment chatFloatEntranceFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatFloatEntranceFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.k != null) {
                this.a.l = String.valueOf(System.currentTimeMillis());
                long N2 = this.a.N2();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!TextUtils.isEmpty(currentAccount) && !this.a.E && this.a.m > 0) {
                    this.a.k.x0(PollingModel.CHATROOM_FRS, this.a.n, 0L, this.a.l, kx7.a(new dp7().e(currentAccount, String.valueOf(this.a.m))));
                    this.a.E = true;
                } else if (ListUtils.isEmpty(this.a.p)) {
                    if (!this.a.E && !TextUtils.isEmpty(currentAccount)) {
                        this.a.k.H0(new a(this));
                    }
                    this.a.k.x0(PollingModel.CHATROOM_FRS, this.a.n, 0L, this.a.l, null);
                } else if (!TextUtils.isEmpty(currentAccount) && this.a.m > 0) {
                    this.a.k.x0(PollingModel.CHATROOM_FRS, null, N2, this.a.l, kx7.a(new dp7().e(currentAccount, String.valueOf(this.a.m))));
                } else {
                    this.a.k.x0(PollingModel.CHATROOM_FRS, null, N2, this.a.l, null);
                }
                jg.a().postDelayed(this.a.N, ChatFloatEntranceFragment.S);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements su7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        public a(ChatFloatEntranceFragment chatFloatEntranceFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatFloatEntranceFragment;
        }

        @Override // com.baidu.tieba.su7.c
        public void a(@NonNull View view2, @NonNull ChatRoomInfoData chatRoomInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, chatRoomInfoData) == null) {
                this.a.r = chatRoomInfoData.getRoomId();
                if (chatRoomInfoData.getChatroomInfoBasicData() != null) {
                    int btnType = chatRoomInfoData.getChatroomInfoBasicData().getBtnType();
                    this.a.v = gg.e(chatRoomInfoData.getChatroomInfoBasicData().getUnreadNum(), 0);
                    ChatFloatEntranceFragment chatFloatEntranceFragment = this.a;
                    chatFloatEntranceFragment.s2(btnType, chatFloatEntranceFragment.v);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        public b(ChatFloatEntranceFragment chatFloatEntranceFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatFloatEntranceFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.w2();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        public c(ChatFloatEntranceFragment chatFloatEntranceFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatFloatEntranceFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ChatFloatEntranceFragment chatFloatEntranceFragment = this.a;
                chatFloatEntranceFragment.i = chatFloatEntranceFragment.a.c.getWidth();
                ChatFloatEntranceFragment chatFloatEntranceFragment2 = this.a;
                chatFloatEntranceFragment2.j = chatFloatEntranceFragment2.a.c.getHeight();
                ViewGroup.LayoutParams layoutParams = this.a.a.c.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    this.a.g = marginLayoutParams.leftMargin;
                    this.a.h = marginLayoutParams.rightMargin;
                }
                this.a.a.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements su7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        public d(ChatFloatEntranceFragment chatFloatEntranceFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatFloatEntranceFragment;
        }

        @Override // com.baidu.tieba.su7.b
        public void a(View view2, ChatRoomInfoData chatRoomInfoData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, view2, chatRoomInfoData) != null) || chatRoomInfoData == null) {
                return;
            }
            ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity());
            this.a.r = chatRoomInfoData.getRoomId();
            this.a.s = chatRoomInfoData.getJumpUrl();
            this.a.D2();
            if (this.a.A != null) {
                this.a.A.o(true);
            }
            if (this.a.w != null && this.a.A2()) {
                this.a.w.B(this.a.v2());
            }
            tu7.b("c15073", this.a.m, this.a.n, String.valueOf(this.a.r), 1, "1");
            tu7.b(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK, this.a.m, this.a.n, String.valueOf(this.a.r), 1, null);
            this.a.w2();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        public e(ChatFloatEntranceFragment chatFloatEntranceFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatFloatEntranceFragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.e = false;
                this.a.d = 1;
                lu7 lu7Var = this.a.x;
                if (lu7Var != null) {
                    lu7Var.d();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                this.a.e = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        public f(ChatFloatEntranceFragment chatFloatEntranceFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatFloatEntranceFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && (valueAnimator.getAnimatedValue() instanceof Integer) && ((Integer) valueAnimator.getAnimatedValue()).intValue() <= ChatFloatEntranceFragment.V && this.a.a.f.getVisibility() == 0) {
                this.a.a.f.setVisibility(4);
                if (this.a.a.k.getVisibility() != 0) {
                    sj9.a(this.a.a.c, 10L, this.a.a.k, 10L);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        public g(ChatFloatEntranceFragment chatFloatEntranceFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatFloatEntranceFragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.e = false;
                this.a.d = 2;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                this.a.e = true;
                this.a.a.f.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ChatFloatEntranceFragment chatFloatEntranceFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment, Integer.valueOf(i)};
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
            this.a = chatFloatEntranceFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !customResponsedMessage.hasError()) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ChatFloatEntranceFragment chatFloatEntranceFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment, Integer.valueOf(i)};
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
            this.a = chatFloatEntranceFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && !customResponsedMessage.hasError() && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if ("forum_follow".equals(str) || "forum_sign".equals(str)) {
                    this.a.c();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements lt7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        public j(ChatFloatEntranceFragment chatFloatEntranceFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatFloatEntranceFragment;
        }

        @Override // com.baidu.tieba.lt7.b
        public void a(List list, int i) {
            ChatFloatEntranceFragment chatFloatEntranceFragment;
            lu7 lu7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) && (lu7Var = (chatFloatEntranceFragment = this.a).x) != null) {
                lu7Var.g(chatFloatEntranceFragment.p, this.a.m, list, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ChatFloatEntranceFragment chatFloatEntranceFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment, Integer.valueOf(i)};
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
            this.a = chatFloatEntranceFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !customResponsedMessage.hasError()) {
                this.a.onUserChanged(TbadkCoreApplication.isLogin());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(ChatFloatEntranceFragment chatFloatEntranceFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment, Integer.valueOf(i)};
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
            this.a = chatFloatEntranceFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ka5 ka5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !customResponsedMessage.hasError()) {
                if ((customResponsedMessage.getData() instanceof ka5) && (ka5Var = (ka5) customResponsedMessage.getData()) != null && ka5Var.a()) {
                    this.a.r = ka5Var.b();
                }
                if (TbadkCoreApplication.isLogin() && this.a.r > 0 && !this.a.A2()) {
                    if (this.a.z != null) {
                        this.a.z.a(this.a.getPageContext(), Collections.unmodifiableList(this.a.p), this.a.m, this.a.n, this.a.r, this.a.o, this.a.D);
                    }
                    this.a.r = -1L;
                }
                this.a.F = false;
                if (this.a.w == null || this.a.w.A(this.a.v2())) {
                    return;
                }
                this.a.K2(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(ChatFloatEntranceFragment chatFloatEntranceFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment, Integer.valueOf(i)};
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
            this.a = chatFloatEntranceFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !customResponsedMessage.hasError() && this.a.A2() && this.a.w != null) {
                this.a.w.l();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements qu7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        public o(ChatFloatEntranceFragment chatFloatEntranceFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatFloatEntranceFragment;
        }

        @Override // com.baidu.tieba.qu7
        public void a(@NonNull ChatRoomInfo chatRoomInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, chatRoomInfo) != null) || chatRoomInfo.getNewMessage() == null || this.a.F) {
                return;
            }
            this.a.F2(0, chatRoomInfo);
        }
    }

    /* loaded from: classes4.dex */
    public class p implements ru7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        @Override // com.baidu.tieba.ru7
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            }
        }

        public p(ChatFloatEntranceFragment chatFloatEntranceFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatFloatEntranceFragment;
        }

        @Override // com.baidu.tieba.ru7
        public void b(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) || this.a.w == null || !this.a.w.A(j)) {
                return;
            }
            this.a.K2(false);
        }
    }

    /* loaded from: classes4.dex */
    public static class q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public BaseAdapterViewFlipper b;
        public CardViewLayout c;
        public LinearLayout d;
        public TbImageView e;
        public RelativeLayout f;
        public View g;
        public RelativeLayout h;
        public TextView i;
        public View j;
        public RelativeLayout k;
        public RoundRelativeLayout l;
        public TbImageView m;
        public ImageView n;
        public TbImageView o;
        public ImageView p;
        public FrameLayout q;
        public ImageView r;
        public FrameLayout s;
        public TextView t;
        public TextView u;
        public ConstraintLayout v;
        public ImageView w;

        public q() {
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

        public static q a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                q qVar = new q();
                qVar.a = view2;
                qVar.c = (CardViewLayout) view2.findViewById(R.id.obfuscated_res_0x7f09068d);
                qVar.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09068e);
                qVar.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090695);
                qVar.g = view2.findViewById(R.id.obfuscated_res_0x7f091441);
                qVar.b = (BaseAdapterViewFlipper) view2.findViewById(R.id.obfuscated_res_0x7f09068f);
                qVar.h = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09068a);
                qVar.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09068b);
                qVar.f = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090698);
                qVar.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090683);
                qVar.l = (RoundRelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090686);
                qVar.m = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ae4);
                qVar.n = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090684);
                qVar.j = view2.findViewById(R.id.obfuscated_res_0x7f092043);
                qVar.o = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090682);
                qVar.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902df);
                qVar.q = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0902e0);
                qVar.r = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0923ae);
                qVar.s = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0923af);
                qVar.v = (ConstraintLayout) view2.findViewById(R.id.obfuscated_res_0x7f090691);
                qVar.w = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090690);
                qVar.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090693);
                qVar.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090692);
                return qVar;
            }
            return (q) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1258487739, "Lcom/baidu/tieba/immessagecenter/chatgroup/floatentrance/ChatFloatEntranceFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1258487739, "Lcom/baidu/tieba/immessagecenter/chatgroup/floatentrance/ChatFloatEntranceFragment;");
                return;
            }
        }
        T = UtilHelper.getDimenPixelSize(R.dimen.tbds130);
        U = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        V = UtilHelper.getDimenPixelSize(R.dimen.tbds170);
        W = 0;
        X = 1;
    }

    public final void D2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && TbadkCoreApplication.isLogin() && getContext() != null && this.r > 0) {
            this.F = true;
            eh5.a().b(getContext(), this.r);
        }
    }

    public final void E2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && TbadkCoreApplication.isLogin() && getContext() != null && this.f) {
            this.f = false;
            gh5 gh5Var = this.z;
            if (gh5Var != null) {
                gh5Var.a(getPageContext(), Collections.unmodifiableList(this.p), this.m, this.n, -1L, this.o, this.D);
            }
        }
    }

    public final void H2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SkinManager.setBackgroundResource(this.a.d, R.drawable.obfuscated_res_0x7f080264);
            SkinManager.setBackgroundResource(this.a.l, R.drawable.obfuscated_res_0x7f080263);
            SkinManager.setImageResource(this.a.e, R.drawable.icon_chat_group_expend);
            s2(3, this.v);
        }
    }

    public final long N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (ListUtils.isEmpty(this.p)) {
                return 0L;
            }
            if (this.q > ListUtils.getCount(this.p) - 1) {
                this.q = 0;
            }
            long longValue = this.p.get(this.q).longValue();
            this.q++;
            return longValue;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.dh5.b
    public void S0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && !z2() && this.b) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921788));
            this.a.v.setVisibility(0);
            jg.a().postDelayed(this.R, 5000L);
            m35.m().w("key_chat_group_guide_show", true);
        }
    }

    public final long v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (!ListUtils.isEmpty(this.p) && ListUtils.getCount(this.p) > 0 && this.p.get(0) != null) {
                return this.p.get(0).longValue();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.ju7
    public void y1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && this.A != null && this.m > 0 && System.currentTimeMillis() - this.C > 5000) {
            this.A.y(this.p, TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.m));
            this.C = System.currentTimeMillis();
        }
    }

    public ChatFloatEntranceFragment(String str, gh5 gh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, gh5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = true;
        this.d = 0;
        this.e = false;
        this.f = false;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        new GradientDrawable();
        this.p = new ArrayList();
        this.q = 1;
        this.r = -1L;
        this.u = new HashMap();
        this.B = false;
        this.E = false;
        this.F = false;
        this.G = new h(this, 2921769);
        this.H = new i(this, 2921768);
        this.I = new j(this);
        this.J = new k(this, 2921410);
        this.K = new l(this, 2921771);
        this.L = new m(this, 2003023);
        this.M = null;
        this.N = new n(this);
        this.O = new o(this);
        this.P = new p(this);
        this.Q = new a(this);
        this.R = new b(this);
        this.n = str;
        this.z = gh5Var;
    }

    public void J2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048585, this, z) != null) || this.a.b.isFlipping()) {
            return;
        }
        this.a.b.setAutoStart(z);
        this.a.b.startFlipping();
    }

    public final void K2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                jg.a().removeCallbacks(this.N);
                jg.a().post(this.N);
                return;
            }
            jg.a().removeCallbacks(this.N);
        }
    }

    @Override // com.baidu.tieba.dh5.b
    public void O0(MotionEvent motionEvent) {
        ku7 ku7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, motionEvent) == null) && (ku7Var = this.y) != null) {
            ku7Var.b(motionEvent);
        }
    }

    @Override // com.baidu.tieba.dh5.b
    public void l1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.b = z;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            super.onUserChanged(z);
            D2();
            E2();
        }
    }

    @Override // com.baidu.tieba.dh5.b
    public boolean r1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            return String.valueOf(this.l).equals(str);
        }
        return invokeL.booleanValue;
    }

    public boolean A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!ListUtils.isEmpty(this.p) && this.p.size() <= 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.c.getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
        }
    }

    public final void C2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.d(new d(this));
        }
    }

    @Override // com.baidu.tieba.dh5.b
    public void N0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !this.e && this.d != 2) {
            this.d = 2;
            t2();
            lu7 lu7Var = this.x;
            if (lu7Var != null) {
                lu7Var.e();
            }
        }
    }

    @Override // com.baidu.tieba.dh5.b
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && !this.e && this.d != 1) {
            this.d = 1;
            r2();
            G2();
            w2();
        }
    }

    @Override // com.baidu.tieba.dh5.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            onDestroyView();
            this.z = null;
        }
    }

    @Override // com.baidu.tieba.dh5.b
    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.d == 1 || this.a.c.getVisibility() != 0) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.dh5.b
    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return !ListUtils.isEmpty(this.t);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.dh5.b
    public void o1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            w2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onPause();
            ou7 ou7Var = this.w;
            if (ou7Var != null) {
                ou7Var.m();
            }
            lu7 lu7Var = this.x;
            if (lu7Var != null) {
                lu7Var.h();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onResume();
            lu7 lu7Var = this.x;
            if (lu7Var != null) {
                lu7Var.i(this.p);
            }
        }
    }

    @Override // com.baidu.tieba.ju7
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ju7
    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.m;
        }
        return invokeV.longValue;
    }

    public final void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921789));
            this.a.v.setVisibility(8);
        }
    }

    public final void x2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            long loopChatroomFrequency = TbSingleton.getInstance().getLoopChatroomFrequency() * 1000;
            S = loopChatroomFrequency;
            if (loopChatroomFrequency <= 0) {
                S = 5000L;
            }
        }
    }

    public final boolean z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return m35.m().i("key_chat_group_guide_show", false);
        }
        return invokeV.booleanValue;
    }

    public final void F2(int i2, @NonNull ChatRoomInfo chatRoomInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048581, this, i2, chatRoomInfo) != null) || this.a.b.getChildCount() - 1 != i2) {
            return;
        }
        this.v = chatRoomInfo.getUnreadNum();
        this.r = chatRoomInfo.getRoomId();
        su7 su7Var = this.c;
        if (su7Var != null) {
            Object item = su7Var.getItem(i2);
            if (item instanceof ChatRoomInfoData) {
                uu7.d(chatRoomInfo, (ChatRoomInfoData) item);
                this.c.notifyDataSetChanged();
            }
        }
    }

    public void G2() {
        Date date;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Date date2 = new Date(System.currentTimeMillis());
            if (TbSingleton.getInstance().getHasShowRedPot() != null && TbSingleton.getInstance().getHasShowRedPot().get(Long.valueOf(this.m)) != null) {
                date = TbSingleton.getInstance().getHasShowRedPot().get(Long.valueOf(this.m));
            } else {
                date = new Date(0L);
            }
            if (TbSingleton.getInstance().getHasClickRedPot() != null && TbSingleton.getInstance().getHasClickRedPot().get(Long.valueOf(this.m)) != null) {
                i2 = TbSingleton.getInstance().getHasClickRedPot().get(Long.valueOf(this.m)).intValue();
            } else {
                i2 = 0;
            }
            if (UnReadRedPotMessage.getIsOn()) {
                if (TimeHelper.getDayDifference(date2, date) >= 1) {
                    u2();
                    M2(W);
                } else if (i2 == X) {
                    u2();
                    M2(W);
                }
            }
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds170);
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.a.b, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, dimenPixelSize, 0.0f), PropertyValuesHolder.ofFloat(View.ALPHA, 0.0f, 1.0f)).setDuration(800L);
            duration.setInterpolator(new AccelerateDecelerateInterpolator());
            this.a.b.setInAnimation(duration);
            ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(this.a.b, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 0.0f, -dimenPixelSize), PropertyValuesHolder.ofFloat(View.ALPHA, 1.0f, 0.0f)).setDuration(800L);
            duration2.setInterpolator(new AccelerateDecelerateInterpolator());
            this.a.b.setOutAnimation(duration2);
        }
    }

    public final void y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.a.f.setOnClickListener(this);
            this.a.h.setOnClickListener(this);
            this.a.d.setOnClickListener(this);
            this.a.c.setRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            n15.d(this.a.c).o(R.string.J_X06);
            this.a.g.setAlpha(0.08f);
            this.c = new su7(getPageContext());
            this.a.b.setFlipInterval(5500);
            this.a.b.startFlipping();
            this.a.b.setAnimateFirstView(false);
            q2();
            C2();
            this.a.t.setText(R.string.chat_group_guide_title);
            this.a.u.setText(R.string.chat_group_guide_content);
            this.c.e(this.Q);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            B2();
        }
    }

    public final void I2(int i2, boolean z, int i3) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) && getPageContext() != null && (layoutParams = (LinearLayout.LayoutParams) this.a.h.getLayoutParams()) != null) {
            if (z && i3 > 0) {
                this.a.i.setVisibility(0);
                String format = String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0d26), Integer.valueOf(i3));
                String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0d27);
                TextView textView = this.a.i;
                if (i3 >= 99) {
                    format = string;
                }
                textView.setText(format);
                layoutParams.width = -2;
            } else {
                this.a.i.setVisibility(8);
                layoutParams.width = i2;
            }
            this.a.h.setLayoutParams(layoutParams);
        }
    }

    public final void L2(@NonNull ChatRoomEntranceData chatRoomEntranceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, chatRoomEntranceData) == null) {
            if (!A2()) {
                J2(true);
                return;
            }
            if (A2()) {
                this.a.b.stopFlipping();
            }
            if (this.w != null && A2() && !this.w.y()) {
                this.w.z(chatRoomEntranceData.getChatRoomInfoList(), v2(), this.P);
            }
        }
    }

    public void M2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (this.u == null) {
                this.u = new HashMap();
            } else {
                this.u = TbSingleton.getInstance().getHasClickRedPot();
            }
            this.u.put(Long.valueOf(this.m), Integer.valueOf(i2));
            TbSingleton.getInstance().setHasClickRedPot(this.u);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048600, this, i2) != null) || i2 == this.mSkinType) {
            return;
        }
        this.mSkinType = i2;
        lu7 lu7Var = this.x;
        if (lu7Var != null) {
            lu7Var.f(i2);
        }
        this.a.c.setCardBackgroundColor(SkinManager.getColor(R.color.CAM_X0207));
        SkinManager.setImageResource(this.a.w, R.drawable.chat_group_mask_guide);
        H2();
        n15.d(this.a.g).f(R.color.CAM_X0334);
        SkinManager.setBackgroundColor(this.a.j, R.color.transparent);
        if (this.mSkinType == 0) {
            this.a.c.setElevation(UtilHelper.getDimenPixelSize(R.dimen.tbds21));
        }
        n15 d2 = n15.d(this.a.t);
        d2.B(R.string.F_X02);
        d2.w(R.color.CAM_X0105);
        d2.A(R.dimen.T_X08);
        n15 d3 = n15.d(this.a.u);
        d3.B(R.string.F_X01);
        d3.w(R.color.CAM_X0107);
        d3.A(R.dimen.T_X09);
        n15 d4 = n15.d(this.a.i);
        d4.w(R.color.CAM_X0101);
        d4.B(R.string.F_X01);
        d4.A(R.dimen.T_X08);
    }

    @Override // com.baidu.tieba.dh5.b
    public void u(ChatRoomEntranceData chatRoomEntranceData) {
        lt7 lt7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, chatRoomEntranceData) == null) && chatRoomEntranceData != null && !ListUtils.isEmpty(chatRoomEntranceData.getChatRoomInfoList())) {
            if (!ListUtils.isEmpty(chatRoomEntranceData.getHotRoomList())) {
                this.p.clear();
                this.p.addAll(chatRoomEntranceData.getHotRoomList());
                L2(chatRoomEntranceData);
            }
            if (!this.B && (lt7Var = this.A) != null && this.m > 0) {
                lt7Var.y(this.p, TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.m));
                this.B = true;
            }
            List<ChatRoomInfoData> chatRoomInfoList = chatRoomEntranceData.getChatRoomInfoList();
            this.t = chatRoomInfoList;
            this.c.c(chatRoomInfoList);
            if (this.a.b.getAdapter() == null) {
                this.a.b.setAdapter(this.c);
            }
            if (this.w != null && A2() && !this.w.A(v2())) {
                ChatRoomInfoData chatRoomInfoData = chatRoomEntranceData.getChatRoomInfoList().get(0);
                int btnType = chatRoomInfoData.getChatroomInfoBasicData().getBtnType();
                int e2 = gg.e(chatRoomInfoData.getChatroomInfoBasicData().getUnreadNum(), 0);
                this.v = e2;
                s2(btnType, e2);
                this.c.notifyDataSetChanged();
                this.w.l();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() != R.id.obfuscated_res_0x7f090698 && view2.getId() != R.id.obfuscated_res_0x7f090686) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09068a) {
                    D2();
                    return;
                }
                return;
            }
            if (TbadkCoreApplication.isLogin()) {
                gh5 gh5Var = this.z;
                if (gh5Var != null) {
                    gh5Var.a(getPageContext(), Collections.unmodifiableList(this.p), this.m, this.n, -1L, this.o, this.D);
                }
            } else {
                this.f = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) TbadkCoreApplication.getInst(), true)));
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f090698 && view2.getId() != R.id.obfuscated_res_0x7f09068a) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            tu7.b("c15073", this.m, this.n, null, i2, "2");
            w2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            super.onCreate(bundle);
            x2();
            if (this.k == null) {
                this.k = new PollingModel(getPageContext(), getUniqueId());
            }
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                this.w = new ou7(getPageContext().getPageActivity(), this.O);
            }
            jg.a().removeCallbacks(this.N);
            jg.a().post(this.N);
            registerListener(this.J);
            registerListener(this.H);
            registerListener(this.G);
            registerListener(this.K);
            registerListener(this.L);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048603, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02ef, viewGroup, false);
            this.a = q.a(inflate);
            y2();
            lu7 lu7Var = new lu7(this.a, this);
            this.x = lu7Var;
            this.y = new ku7(this, lu7Var);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onDestroyView();
            jg.a().removeCallbacks(this.N);
            jg.a().removeCallbacks(this.R);
            MessageManager.getInstance().unRegisterListener(this.J);
            MessageManager.getInstance().unRegisterListener(this.H);
            MessageManager.getInstance().unRegisterListener(this.G);
            MessageManager.getInstance().unRegisterListener(this.K);
            MessageManager.getInstance().unRegisterListener(this.L);
            MessageManager.getInstance().unRegisterListener(su7.e);
            this.c.e(null);
            lt7 lt7Var = this.A;
            if (lt7Var != null) {
                lt7Var.k();
            }
            ou7 ou7Var = this.w;
            if (ou7Var != null) {
                ou7Var.k();
            }
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048610, this) != null) || this.e) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.a.c, "width", this.i, T);
        animatorSet.playTogether(ofInt, ObjectAnimator.ofInt(this.a.c, "height", this.j, T), ObjectAnimator.ofInt(this.a.c, "marginRight", this.h, U));
        animatorSet.addListener(new e(this));
        ofInt.addUpdateListener(new f(this));
        animatorSet.setDuration(600L).start();
    }

    public final void t2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048612, this) != null) || this.e) {
            return;
        }
        q qVar = this.a;
        sj9.a(qVar.k, 10L, qVar.c, 10L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofInt(this.a.c, "width", T, this.i), ObjectAnimator.ofInt(this.a.c, "height", T, this.j), ObjectAnimator.ofInt(this.a.c, "marginRight", U, this.h));
        animatorSet.addListener(new g(this));
        animatorSet.setDuration(600L).start();
    }

    public void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (this.M == null) {
                this.M = new ArrayList();
            }
            this.M.clear();
            for (int i2 = 0; i2 < this.p.size(); i2++) {
                Long l2 = this.p.get(i2);
                HashMap hashMap = new HashMap();
                hashMap.put("room_id", l2);
                GroupChatRoomPojo c2 = dp7.f().c(TbadkCoreApplication.getCurrentAccount(), l2.longValue());
                if (c2 != null) {
                    hashMap.put("msg_id", Long.valueOf(c2.getLatestMsgId()));
                } else {
                    hashMap.put("msg_id", 0L);
                }
                this.M.add(hashMap);
            }
            if (ListUtils.isEmpty(this.M)) {
                return;
            }
            TbSingleton.getInstance().setLoopMsgRoomMsgId(DataExt.toJson(this.M));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921764, Boolean.TRUE));
        }
    }

    public final void s2(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048611, this, i2, i3) == null) {
            if (i2 == 1) {
                I2(UtilHelper.getDimenPixelSize(R.dimen.tbds172), false, 0);
                SkinManager.setBackgroundResource(this.a.h, R.drawable.obfuscated_res_0x7f080701);
            } else if (i3 > 0) {
                I2(UtilHelper.getDimenPixelSize(R.dimen.tbds172), true, i3);
                SkinManager.setBackgroundResource(this.a.h, R.drawable.obfuscated_res_0x7f080705);
            } else {
                I2(UtilHelper.getDimenPixelSize(R.dimen.tbds198), false, 0);
                SkinManager.setBackgroundResource(this.a.h, R.drawable.obfuscated_res_0x7f0806fd);
            }
        }
    }

    @Override // com.baidu.tieba.dh5.b
    public void z1(long j2, String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Long.valueOf(j2), str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.o = z;
            this.D = z2;
            if (StringUtils.isNull(this.n)) {
                this.n = str;
            }
            if (this.m == 0 && j2 > 0 && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && !this.E) {
                jg.a().removeCallbacks(this.N);
                jg.a().post(this.N);
            }
            this.m = j2;
            this.A = new lt7(getContext(), this.I, false);
        }
    }
}

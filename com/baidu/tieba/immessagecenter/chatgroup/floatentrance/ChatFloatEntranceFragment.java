package com.baidu.tieba.immessagecenter.chatgroup.floatentrance;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
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
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a65;
import com.baidu.tieba.ala;
import com.baidu.tieba.ap8;
import com.baidu.tieba.ay5;
import com.baidu.tieba.az5;
import com.baidu.tieba.bq5;
import com.baidu.tieba.cq5;
import com.baidu.tieba.d85;
import com.baidu.tieba.da5;
import com.baidu.tieba.eq5;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.jj8;
import com.baidu.tieba.ok8;
import com.baidu.tieba.pk8;
import com.baidu.tieba.sk8;
import com.baidu.tieba.tk8;
import com.baidu.tieba.uk8;
import com.baidu.tieba.vd8;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.vk8;
import com.baidu.tieba.wg;
import com.baidu.tieba.wi8;
import com.baidu.tieba.wk8;
import com.baidu.tieba.wy5;
import com.baidu.tieba.xk8;
import com.baidu.tieba.y55;
import com.baidu.tieba.yh5;
import com.baidu.tieba.yi;
import com.baidu.tieba.zg;
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
/* loaded from: classes6.dex */
public class ChatFloatEntranceFragment extends BaseFragment implements bq5.b, ok8 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: T  reason: collision with root package name */
    public static final String f1124T;
    public static long U;
    public static final int V;
    public static final int W;
    public static final int X;
    public static int Y;
    public static int Z;
    public transient /* synthetic */ FieldHolder $fh;
    public pk8 A;
    public eq5 B;
    @Nullable
    public wi8 C;
    public boolean D;
    public long E;
    public boolean F;
    public String G;
    public boolean H;
    public final CustomMessageListener I;
    public final CustomMessageListener J;
    @NonNull
    public final wi8.c K;
    public final CustomMessageListener L;
    public final CustomMessageListener M;
    public List<Map<String, Long>> N;
    public final Runnable O;
    public final tk8 P;
    public final uk8 Q;
    public final vk8.d R;
    public Runnable S;
    public u a;
    public boolean b;
    public vk8 c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public int k;
    public PollingModel l;
    public String m;
    public long n;
    public String o;
    public boolean p;
    @NonNull
    public final List<Long> q;
    public int r;
    public int s;
    public long t;
    public long u;
    public String v;
    public List<ChatRoomInfoData> w;
    public Map<Long, Integer> x;
    public int y;
    @Nullable
    public sk8 z;

    @Override // com.baidu.tieba.bq5.b
    public void U0(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, motionEvent) == null) {
        }
    }

    @Override // com.baidu.tieba.bq5.b
    public Fragment h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this : (Fragment) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        /* loaded from: classes6.dex */
        public class a implements PollingModel.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q a;

            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = qVar;
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
                    chatFloatEntranceFragment.n = j;
                    if (this.a.a.n > 0 && !this.a.a.F) {
                        zg.a().removeCallbacks(this.a.a.O);
                        zg.a().post(this.a.a.O);
                    }
                }
            }
        }

        public q(ChatFloatEntranceFragment chatFloatEntranceFragment) {
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                this.a.m = String.valueOf(System.currentTimeMillis());
                long e3 = this.a.e3();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!ListUtils.isEmpty(this.a.q) || this.a.r <= 0) {
                    if (ListUtils.isEmpty(this.a.q) && !this.a.F) {
                        this.a.l.M0(new a(this));
                        ChatFloatEntranceFragment chatFloatEntranceFragment = this.a;
                        chatFloatEntranceFragment.F2(currentAccount, Boolean.valueOf(chatFloatEntranceFragment.F), 0L);
                        this.a.F = true;
                        return;
                    }
                    ChatFloatEntranceFragment chatFloatEntranceFragment2 = this.a;
                    chatFloatEntranceFragment2.F2(currentAccount, Boolean.valueOf(chatFloatEntranceFragment2.F), e3);
                    return;
                }
                this.a.Z2(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                ChatFloatEntranceFragment chatFloatEntranceFragment = this.a;
                chatFloatEntranceFragment.a3(chatFloatEntranceFragment.o);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements vk8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnLongClickListener a;
        public final /* synthetic */ ChatFloatEntranceFragment b;

        public b(ChatFloatEntranceFragment chatFloatEntranceFragment, View.OnLongClickListener onLongClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment, onLongClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = chatFloatEntranceFragment;
            this.a = onLongClickListener;
        }

        @Override // com.baidu.tieba.vk8.e
        public boolean a(View view2, ChatRoomInfoData chatRoomInfoData) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, chatRoomInfoData)) == null) {
                return this.a.onLongClick(view2);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a65.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ da5 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ y55 d;
        public final /* synthetic */ ChatFloatEntranceFragment e;

        public c(ChatFloatEntranceFragment chatFloatEntranceFragment, da5 da5Var, String str, boolean z, y55 y55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment, da5Var, str, Boolean.valueOf(z), y55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = chatFloatEntranceFragment;
            this.a = da5Var;
            this.b = str;
            this.c = z;
            this.d = y55Var;
        }

        @Override // com.baidu.tieba.a65.f
        public void L0(a65 a65Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIL(1048576, this, a65Var, i, view2) != null) || !(view2 instanceof TextView)) {
                return;
            }
            this.a.A(this.b, !this.c);
            this.e.b3(R.string.obfuscated_res_0x7f0f0a4a, true);
            wk8.c(this.e.n, this.c);
            this.d.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.I2();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ViewTreeObserver.OnGlobalLayoutListener {
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

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ChatFloatEntranceFragment chatFloatEntranceFragment = this.a;
                chatFloatEntranceFragment.j = yi.m(chatFloatEntranceFragment.getContext(), UtilHelper.isFoldScreen()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
                ChatFloatEntranceFragment chatFloatEntranceFragment2 = this.a;
                chatFloatEntranceFragment2.k = chatFloatEntranceFragment2.a.c.getHeight();
                ViewGroup.LayoutParams layoutParams = this.a.a.c.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    this.a.h = marginLayoutParams.leftMargin;
                    this.a.i = marginLayoutParams.rightMargin;
                }
                this.a.a.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements vk8.c {
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

        @Override // com.baidu.tieba.vk8.c
        public void a(View view2, ChatRoomInfoData chatRoomInfoData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, view2, chatRoomInfoData) != null) || chatRoomInfoData == null) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.a.z2(25075);
            }
            this.a.t = chatRoomInfoData.getRoomId();
            this.a.v = chatRoomInfoData.getJumpUrl();
            this.a.C2();
        }
    }

    /* loaded from: classes6.dex */
    public class g extends wy5<List<GroupChatRoomPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ChatFloatEntranceFragment b;

        public g(ChatFloatEntranceFragment chatFloatEntranceFragment, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = chatFloatEntranceFragment;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wy5
        public List<GroupChatRoomPojo> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return vd8.j().i(this.a, String.valueOf(this.b.o));
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ay5<List<GroupChatRoomPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Boolean a;
        public final /* synthetic */ long b;
        public final /* synthetic */ ChatFloatEntranceFragment c;

        public h(ChatFloatEntranceFragment chatFloatEntranceFragment, Boolean bool, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment, bool, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = chatFloatEntranceFragment;
            this.a = bool;
            this.b = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ay5
        /* renamed from: a */
        public void onReturnDataInUI(List<GroupChatRoomPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.c.G = ap8.d(list);
                if (!this.a.booleanValue()) {
                    this.c.l.B0(PollingModel.CHATROOM_FRS, this.c.o, this.b, this.c.m, this.c.G);
                } else {
                    this.c.l.B0(PollingModel.CHATROOM_FRS, null, this.b, this.c.m, this.c.G);
                }
                zg.a().postDelayed(this.c.O, ChatFloatEntranceFragment.U);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        public i(ChatFloatEntranceFragment chatFloatEntranceFragment) {
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
                pk8 pk8Var = this.a.A;
                if (pk8Var != null) {
                    pk8Var.b();
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

    /* loaded from: classes6.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {
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

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && (valueAnimator.getAnimatedValue() instanceof Integer) && ((Integer) valueAnimator.getAnimatedValue()).intValue() <= ChatFloatEntranceFragment.X && this.a.a.f.getVisibility() == 0) {
                this.a.a.f.setVisibility(4);
                if (this.a.a.k.getVisibility() != 0) {
                    ala.a(this.a.a.c, 10L, this.a.a.k, 10L);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        public l(ChatFloatEntranceFragment chatFloatEntranceFragment) {
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

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && !customResponsedMessage.hasError() && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if ("forum_follow".equals(str) || "forum_sign".equals(str)) {
                    this.a.d();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements wi8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

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

        @Override // com.baidu.tieba.wi8.c
        public void a(List list, int i) {
            ChatFloatEntranceFragment chatFloatEntranceFragment;
            pk8 pk8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) && (pk8Var = (chatFloatEntranceFragment = this.a).A) != null) {
                pk8Var.f(chatFloatEntranceFragment.q, this.a.n, list, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(ChatFloatEntranceFragment chatFloatEntranceFragment, int i) {
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
            yh5 yh5Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.hasError() || !this.a.isResumed()) {
                return;
            }
            if ((customResponsedMessage.getData() instanceof yh5) && (yh5Var = (yh5) customResponsedMessage.getData()) != null && yh5Var.a()) {
                this.a.u = yh5Var.b();
            }
            if (TbadkCoreApplication.isLogin() && this.a.u > 0 && !this.a.N2()) {
                if (this.a.B != null) {
                    this.a.B.a(this.a.getPageContext(), Collections.unmodifiableList(this.a.q), this.a.n, this.a.o, this.a.u, this.a.p, this.a.getActivity().getSupportFragmentManager(), jj8.b, "dialog");
                }
                this.a.u = -1L;
            }
            this.a.H = false;
            if (this.a.z == null || this.a.z.F(this.a.H2())) {
                return;
            }
            this.a.Z2(true);
        }
    }

    /* loaded from: classes6.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ChatFloatEntranceFragment chatFloatEntranceFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !customResponsedMessage.hasError() && this.a.O2() && this.a.z != null) {
                this.a.z.p();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements tk8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        public r(ChatFloatEntranceFragment chatFloatEntranceFragment) {
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

        @Override // com.baidu.tieba.tk8
        public void a(@NonNull ChatRoomInfo chatRoomInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, chatRoomInfo) != null) || chatRoomInfo.getNewMessage() == null || this.a.H) {
                return;
            }
            this.a.T2(0, chatRoomInfo);
        }
    }

    /* loaded from: classes6.dex */
    public class s implements uk8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        @Override // com.baidu.tieba.uk8
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            }
        }

        public s(ChatFloatEntranceFragment chatFloatEntranceFragment) {
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

        @Override // com.baidu.tieba.uk8
        public void b(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) || this.a.z == null || !this.a.z.F(j)) {
                return;
            }
            this.a.Z2(false);
        }
    }

    /* loaded from: classes6.dex */
    public class t implements vk8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        public t(ChatFloatEntranceFragment chatFloatEntranceFragment) {
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

        @Override // com.baidu.tieba.vk8.d
        public void a(@NonNull View view2, @NonNull ChatRoomInfoData chatRoomInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, chatRoomInfoData) == null) {
                this.a.t = chatRoomInfoData.getRoomId();
                if (chatRoomInfoData.getChatroomInfoBasicData() != null) {
                    int btnType = chatRoomInfoData.getChatroomInfoBasicData().getBtnType();
                    this.a.y = wg.e(chatRoomInfoData.getChatroomInfoBasicData().getUnreadNum(), 0);
                    ChatFloatEntranceFragment chatFloatEntranceFragment = this.a;
                    chatFloatEntranceFragment.D2(btnType, chatFloatEntranceFragment.y);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class u {
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

        public u() {
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

        public static u a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                u uVar = new u();
                uVar.a = view2;
                uVar.c = (CardViewLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906bb);
                uVar.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906bc);
                uVar.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906c3);
                uVar.g = view2.findViewById(R.id.obfuscated_res_0x7f0914d0);
                uVar.b = (BaseAdapterViewFlipper) view2.findViewById(R.id.obfuscated_res_0x7f0906bd);
                uVar.h = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906b8);
                uVar.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906b9);
                uVar.f = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906c6);
                uVar.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906b1);
                uVar.l = (RoundRelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906b4);
                uVar.m = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b3e);
                uVar.n = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906b2);
                uVar.j = view2.findViewById(R.id.obfuscated_res_0x7f092170);
                uVar.o = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906b0);
                uVar.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902e0);
                uVar.q = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0902e1);
                uVar.r = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0924f1);
                uVar.s = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0924f2);
                uVar.v = (ConstraintLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906bf);
                uVar.w = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906be);
                uVar.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906c1);
                uVar.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906c0);
                return uVar;
            }
            return (u) invokeL.objValue;
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
        f1124T = da5.t(PollingModel.SP_KEY_GROUP_CHAT_DISTURB_SETTING);
        U = 5000L;
        V = UtilHelper.getDimenPixelSize(R.dimen.tbds130);
        W = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        X = UtilHelper.getDimenPixelSize(R.dimen.tbds170);
        Y = 0;
        Z = 1;
    }

    @Override // com.baidu.tieba.ok8
    public void B1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.C != null && this.n > 0 && System.currentTimeMillis() - this.E > 5000) {
            if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST) instanceof TbHttpMessageTask) {
                ((TbHttpMessageTask) MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST)).setIsNeedDialog(false);
            }
            this.C.F(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.n));
            this.E = System.currentTimeMillis();
        }
    }

    public final void C2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            R2();
            wi8 wi8Var = this.C;
            if (wi8Var != null) {
                wi8Var.u(true);
            }
            if (this.z != null && O2()) {
                this.z.G(H2());
            }
            wk8.b("c15073", this.n, this.o, String.valueOf(this.t), 1, "1");
            wk8.b(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK, this.n, this.o, String.valueOf(this.t), 1, null);
            I2();
        }
    }

    @Override // com.baidu.tieba.bq5.b
    public boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (M2() || !this.b) {
                return false;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921788));
            this.a.v.setVisibility(0);
            zg.a().postDelayed(this.S, 5000L);
            da5.p().A("key_chat_group_guide_show", true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public ChatFloatEntranceFragment(String str, eq5 eq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, eq5Var};
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
        this.g = true;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        new GradientDrawable();
        this.q = new ArrayList();
        this.r = 0;
        this.s = 1;
        this.t = -1L;
        this.u = -1L;
        this.x = new HashMap();
        this.D = false;
        this.F = false;
        this.H = false;
        this.I = new k(this, 2921769);
        this.J = new m(this, 2921768);
        this.K = new n(this);
        this.L = new o(this, 2921771);
        this.M = new p(this, 2003023);
        this.N = null;
        this.O = new q(this);
        this.P = new r(this);
        this.Q = new s(this);
        this.R = new t(this);
        this.S = new d(this);
        this.o = str;
        this.B = eq5Var;
    }

    @Override // com.baidu.tieba.bq5.b
    public void G0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.g = z;
        }
    }

    public void Y2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048608, this, z) != null) || this.a.b.isFlipping()) {
            return;
        }
        this.a.b.setAutoStart(z);
        this.a.b.startFlipping();
    }

    public final void Z2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            if (z) {
                zg.a().removeCallbacks(this.O);
                zg.a().post(this.O);
                return;
            }
            zg.a().removeCallbacks(this.O);
        }
    }

    @Override // com.baidu.tieba.bq5.b
    public void p1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.b = z;
        }
    }

    @Override // com.baidu.tieba.bq5.b
    public boolean v1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, str)) == null) {
            return String.valueOf(this.m).equals(str);
        }
        return invokeL.booleanValue;
    }

    public final void z2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getContext(), true, i2)));
        }
    }

    public final void F2(String str, Boolean bool, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, bool, Long.valueOf(j2)}) == null) {
            az5.c(new g(this, str), new h(this, bool, j2));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048620, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 != 25075) {
                    if (i2 == 25076) {
                        S2();
                        return;
                    }
                    return;
                }
                C2();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048625, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d031c, viewGroup, false);
            this.a = u.a(inflate);
            K2();
            this.A = new pk8(this.a, this);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    public final void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921789));
            this.a.v.setVisibility(8);
        }
    }

    public final void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            long loopChatroomFrequency = TbSingleton.getInstance().getLoopChatroomFrequency() * 1000;
            U = loopChatroomFrequency;
            if (loopChatroomFrequency <= 0) {
                U = 5000L;
            }
        }
    }

    public final boolean L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (TbadkCoreApplication.isLogin() && this.t > 0 && !N2()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return da5.p().l("key_chat_group_guide_show", false);
        }
        return invokeV.booleanValue;
    }

    public final boolean N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.r <= 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean O2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (!ListUtils.isEmpty(this.q) && this.q.size() <= 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.a.c.getViewTreeObserver().addOnGlobalLayoutListener(new e(this));
        }
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.c.e(new f(this));
        }
    }

    @Override // com.baidu.tieba.bq5.b
    public void S0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && !this.e && this.d != 2) {
            this.d = 2;
            E2();
            pk8 pk8Var = this.A;
            if (pk8Var != null) {
                pk8Var.c();
            }
        }
    }

    @Override // com.baidu.tieba.bq5.b
    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (ListUtils.isEmpty(this.q) && this.r > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bq5.b
    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && !this.e && this.d != 1) {
            this.d = 1;
            B2();
            V2();
            I2();
        }
    }

    @Override // com.baidu.tieba.bq5.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            onDestroyView();
            this.B = null;
        }
    }

    @Override // com.baidu.tieba.bq5.b
    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.d == 1 || this.a.c.getVisibility() != 0) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ok8
    public Context getViewContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return getContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onPause();
            sk8 sk8Var = this.z;
            if (sk8Var != null) {
                sk8Var.q();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onResume();
            pk8 pk8Var = this.A;
            if (pk8Var != null) {
                pk8Var.g(this.q);
            }
        }
    }

    @Override // com.baidu.tieba.bq5.b
    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return !ListUtils.isEmpty(this.w);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bq5.b
    public void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            I2();
        }
    }

    @Override // com.baidu.tieba.ok8
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ok8
    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.n;
        }
        return invokeV.longValue;
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds170);
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.a.b, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, dimenPixelSize, 0.0f), PropertyValuesHolder.ofFloat(View.ALPHA, 0.0f, 1.0f)).setDuration(800L);
            duration.setInterpolator(new AccelerateDecelerateInterpolator());
            this.a.b.setInAnimation(duration);
            ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(this.a.b, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 0.0f, -dimenPixelSize), PropertyValuesHolder.ofFloat(View.ALPHA, 1.0f, 0.0f)).setDuration(800L);
            duration2.setInterpolator(new AccelerateDecelerateInterpolator());
            this.a.b.setOutAnimation(duration2);
        }
    }

    public void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.N == null) {
                this.N = new ArrayList();
            }
            this.N.clear();
            for (int i2 = 0; i2 < this.q.size(); i2++) {
                Long l2 = this.q.get(i2);
                HashMap hashMap = new HashMap();
                hashMap.put("room_id", l2);
                GroupChatRoomPojo f2 = vd8.j().f(TbadkCoreApplication.getCurrentAccount(), l2.longValue());
                if (f2 != null) {
                    hashMap.put("msg_id", Long.valueOf(f2.getLatestMsgId()));
                    hashMap.put("time", Long.valueOf(f2.getLastExitChatRoomTime()));
                } else {
                    hashMap.put("msg_id", 0L);
                    hashMap.put("time", 1L);
                }
                this.N.add(hashMap);
            }
            if (ListUtils.isEmpty(this.N)) {
                return;
            }
            TbSingleton.getInstance().setLoopMsgRoomMsgId(DataExt.toJson(this.N));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921764, Boolean.TRUE));
        }
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.a.f.setOnClickListener(this);
            this.a.h.setOnClickListener(this);
            this.a.d.setOnClickListener(this);
            a aVar = new a(this);
            this.a.f.setOnLongClickListener(aVar);
            this.a.h.setOnLongClickListener(aVar);
            this.a.l.setOnLongClickListener(aVar);
            this.a.c.setRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            d85.d(this.a.c).o(R.string.J_X06);
            this.a.g.setAlpha(0.08f);
            vk8 vk8Var = new vk8(getPageContext());
            this.c = vk8Var;
            vk8Var.g(new b(this, aVar));
            this.a.b.setFlipInterval(5500);
            this.a.b.startFlipping();
            this.a.b.setAnimateFirstView(false);
            A2();
            Q2();
            this.a.t.setText(R.string.chat_group_guide_title);
            this.a.u.setText(R.string.chat_group_guide_content);
            this.c.f(this.R);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            P2();
        }
    }

    public void V2() {
        Date date;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            Date date2 = new Date(System.currentTimeMillis());
            if (TbSingleton.getInstance().getHasShowRedPot() != null && TbSingleton.getInstance().getHasShowRedPot().get(Long.valueOf(this.n)) != null) {
                date = TbSingleton.getInstance().getHasShowRedPot().get(Long.valueOf(this.n));
            } else {
                date = new Date(0L);
            }
            if (TbSingleton.getInstance().getHasClickRedPot() != null && TbSingleton.getInstance().getHasClickRedPot().get(Long.valueOf(this.n)) != null) {
                i2 = TbSingleton.getInstance().getHasClickRedPot().get(Long.valueOf(this.n)).intValue();
            } else {
                i2 = 0;
            }
            if (UnReadRedPotMessage.getIsOn()) {
                if (TimeHelper.getDayDifference(date2, date) >= 1) {
                    G2();
                    d3(Y);
                } else if (i2 == Z) {
                    G2();
                    d3(Y);
                }
            }
        }
    }

    public final void B2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.e) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.a.c, "width", this.j, V);
        animatorSet.playTogether(ofInt, ObjectAnimator.ofInt(this.a.c, "height", this.k, V), ObjectAnimator.ofInt(this.a.c, "marginRight", this.i, W));
        animatorSet.addListener(new i(this));
        ofInt.addUpdateListener(new j(this));
        animatorSet.setDuration(600L).start();
    }

    public final void E2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.e) {
            return;
        }
        u uVar = this.a;
        ala.a(uVar.k, 10L, uVar.c, 10L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofInt(this.a.c, "width", V, this.j), ObjectAnimator.ofInt(this.a.c, "height", V, this.k), ObjectAnimator.ofInt(this.a.c, "marginRight", W, this.i));
        animatorSet.addListener(new l(this));
        animatorSet.setDuration(600L).start();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onDestroyView();
            zg.a().removeCallbacks(this.O);
            zg.a().removeCallbacks(this.S);
            MessageManager.getInstance().unRegisterListener(this.J);
            MessageManager.getInstance().unRegisterListener(this.I);
            MessageManager.getInstance().unRegisterListener(this.L);
            MessageManager.getInstance().unRegisterListener(this.M);
            MessageManager.getInstance().unRegisterListener(vk8.f);
            this.c.f(null);
            wi8 wi8Var = this.C;
            if (wi8Var != null) {
                wi8Var.o();
            }
            sk8 sk8Var = this.z;
            if (sk8Var != null) {
                sk8Var.o();
            }
        }
    }

    @Override // com.baidu.tieba.bq5.b
    public void C1(long j2, String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.p = z;
            if (StringUtils.isNull(this.o)) {
                this.o = str;
            }
            if (this.n == 0 && j2 > 0 && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && !this.F) {
                zg.a().removeCallbacks(this.O);
                zg.a().post(this.O);
            }
            this.n = j2;
            this.C = new wi8(getContext(), this.K, false);
        }
    }

    public final void D2(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            if (i2 == 1) {
                X2(UtilHelper.getDimenPixelSize(R.dimen.tbds172), false, 0);
                SkinManager.setBackgroundResource(this.a.h, R.drawable.icon_chat_group_experience);
            } else if (i3 > 0) {
                X2(UtilHelper.getDimenPixelSize(R.dimen.tbds172), true, i3);
                SkinManager.setBackgroundResource(this.a.h, R.drawable.icon_chat_group_new_msg);
            } else {
                X2(UtilHelper.getDimenPixelSize(R.dimen.tbds198), false, 0);
                SkinManager.setBackgroundResource(this.a.h, R.drawable.icon_chat_group_enter_see_more);
            }
        }
    }

    @Override // com.baidu.tieba.bq5.b
    public void G(ChatRoomEntranceData chatRoomEntranceData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatRoomEntranceData) == null) && chatRoomEntranceData != null) {
            if (!ListUtils.isEmpty(chatRoomEntranceData.getChatRoomInfoList()) || chatRoomEntranceData.getHotListOriginNum() > 0) {
                if (this.g) {
                    this.r = chatRoomEntranceData.getHotListOriginNum();
                }
                if (ListUtils.isEmpty(chatRoomEntranceData.getChatRoomInfoList()) && chatRoomEntranceData.getHotListOriginNum() > 0) {
                    U2();
                    return;
                }
                if (!ListUtils.isEmpty(chatRoomEntranceData.getHotRoomList())) {
                    this.q.clear();
                    this.q.addAll(chatRoomEntranceData.getHotRoomList());
                    c3(chatRoomEntranceData);
                }
                if (!this.D && this.C != null && this.n > 0) {
                    if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST) instanceof TbHttpMessageTask) {
                        ((TbHttpMessageTask) MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST)).setIsNeedDialog(false);
                    }
                    this.C.F(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.n));
                    this.D = true;
                }
                List<ChatRoomInfoData> chatRoomInfoList = chatRoomEntranceData.getChatRoomInfoList();
                this.w = chatRoomInfoList;
                this.c.d(chatRoomInfoList);
                if (this.a.b.getAdapter() == null) {
                    this.a.b.setAdapter(this.c);
                }
                if (this.z != null && O2() && !this.z.F(H2())) {
                    ChatRoomInfoData chatRoomInfoData = chatRoomEntranceData.getChatRoomInfoList().get(0);
                    int btnType = chatRoomInfoData.getChatroomInfoBasicData().getBtnType();
                    int e2 = wg.e(chatRoomInfoData.getChatroomInfoBasicData().getUnreadNum(), 0);
                    this.y = e2;
                    D2(btnType, e2);
                    this.c.notifyDataSetChanged();
                    this.z.p();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f0906b4) {
                if (TbadkCoreApplication.isLogin()) {
                    eq5 eq5Var = this.B;
                    if (eq5Var != null) {
                        eq5Var.a(getPageContext(), Collections.unmodifiableList(this.q), this.n, this.o, this.t, this.p, getActivity().getSupportFragmentManager(), jj8.a, "dialog");
                    }
                } else {
                    this.f = true;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) TbadkCoreApplication.getInst(), true)));
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f0906c6 && view2.getId() != R.id.obfuscated_res_0x7f0906b8) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                wk8.b("c15073", this.n, this.o, null, i2, "2");
                I2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0906b8) {
                ViewHelper.checkUpIsLogin(getPageContext().getPageActivity());
                R2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0906c6) {
                if (!TbadkCoreApplication.isLogin()) {
                    z2(25076);
                    return;
                }
                eq5 eq5Var2 = this.B;
                if (eq5Var2 != null) {
                    eq5Var2.a(getPageContext(), Collections.unmodifiableList(this.q), this.n, this.o, -1L, this.p, getActivity().getSupportFragmentManager(), jj8.a, "dialog");
                }
            }
        }
    }

    public final long H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!ListUtils.isEmpty(this.q) && ListUtils.getCount(this.q) > 0 && this.q.get(0) != null) {
                return this.q.get(0).longValue();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final void R2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && TbadkCoreApplication.isLogin() && getContext() != null && this.t > 0) {
            this.H = true;
            cq5.a().d(getContext(), 1, this.t, L2());
        }
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && getContext() != null && this.f) {
            this.f = false;
            eq5 eq5Var = this.B;
            if (eq5Var != null) {
                eq5Var.a(getPageContext(), Collections.unmodifiableList(this.q), this.n, this.o, this.t, this.p, getActivity().getSupportFragmentManager(), jj8.a, "dialog");
            }
        }
    }

    public void U2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && !this.e && this.d != 1) {
            this.d = 1;
            u uVar = this.a;
            ala.a(uVar.c, 10L, uVar.k, 10L);
            pk8 pk8Var = this.A;
            if (pk8Var != null) {
                pk8Var.b();
            }
            V2();
            I2();
        }
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            SkinManager.setBackgroundResource(this.a.d, R.drawable.bg_chat_group_expend_gradual);
            SkinManager.setBackgroundResource(this.a.l, R.drawable.bg_chat_group_collapse_gradual);
            SkinManager.setImageResource(this.a.e, R.drawable.icon_entrance_left_expend);
            D2(3, this.y);
        }
    }

    public final long e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (ListUtils.isEmpty(this.q)) {
                return 0L;
            }
            if (this.s > ListUtils.getCount(this.q) - 1) {
                this.s = 0;
            }
            long longValue = this.q.get(this.s).longValue();
            this.s++;
            return longValue;
        }
        return invokeV.longValue;
    }

    public final void T2(int i2, @NonNull ChatRoomInfo chatRoomInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048601, this, i2, chatRoomInfo) != null) || this.a.b.getChildCount() - 1 != i2) {
            return;
        }
        this.y = chatRoomInfo.getUnreadNum();
        this.t = chatRoomInfo.getRoomId();
        vk8 vk8Var = this.c;
        if (vk8Var != null) {
            Object item = vk8Var.getItem(i2);
            if (item instanceof ChatRoomInfoData) {
                xk8.d(chatRoomInfo, (ChatRoomInfoData) item);
                this.c.notifyDataSetChanged();
            }
        }
    }

    public void b3(@StringRes int i2, boolean z) {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) != null) || (activity = getActivity()) == null) {
            return;
        }
        BdTopToast bdTopToast = new BdTopToast(activity);
        bdTopToast.g(activity.getString(i2));
        bdTopToast.h(z);
        bdTopToast.i((ViewGroup) activity.findViewById(16908290));
    }

    public final void X2(int i2, boolean z, int i3) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) && getPageContext() != null && (layoutParams = (LinearLayout.LayoutParams) this.a.h.getLayoutParams()) != null) {
            if (z && i3 > 0) {
                this.a.i.setVisibility(0);
                String format = String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0e27), Integer.valueOf(i3));
                String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0e28);
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

    public final void a3(String str) {
        TbPageContext<BaseFragmentActivity> pageContext;
        int i2;
        String str2;
        TbSingleton.GroupChatDisturbText.TitleText canNotDisturb;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, str) != null) || (pageContext = getPageContext()) == null) {
            return;
        }
        da5 p2 = da5.p();
        String str3 = f1124T + str;
        boolean l2 = p2.l(str3, true);
        if (l2) {
            i2 = R.string.obfuscated_res_0x7f0f0a48;
        } else {
            i2 = R.string.obfuscated_res_0x7f0f0a49;
        }
        String string = pageContext.getString(i2);
        if (l2) {
            str2 = pageContext.getString(R.string.obfuscated_res_0x7f0f0a47);
        } else {
            str2 = null;
        }
        TbSingleton.GroupChatDisturbText groupChatDisturbText = TbSingleton.getInstance().getGroupChatDisturbText();
        if (groupChatDisturbText != null) {
            if (l2) {
                canNotDisturb = groupChatDisturbText.getCanDisturb();
            } else {
                canNotDisturb = groupChatDisturbText.getCanNotDisturb();
            }
            if (!TextUtils.isEmpty(canNotDisturb.getMainTitle())) {
                string = canNotDisturb.getMainTitle();
            }
            if (!TextUtils.isEmpty(canNotDisturb.getSubTitle())) {
                str2 = canNotDisturb.getSubTitle();
            }
        }
        y55 y55Var = new y55(pageContext);
        y55Var.j(false);
        y55Var.i(str2, new String[]{string}, new c(this, p2, str3, l2, y55Var));
        y55Var.l();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, bundle) == null) {
            super.onCreate(bundle);
            J2();
            if (this.l == null) {
                this.l = new PollingModel(getPageContext(), getUniqueId());
            }
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                this.z = new sk8(getPageContext().getPageActivity(), this.P);
            }
            zg.a().removeCallbacks(this.O);
            zg.a().post(this.O);
            registerListener(this.J);
            registerListener(this.I);
            registerListener(this.L);
            registerListener(this.M);
        }
    }

    public final void c3(@NonNull ChatRoomEntranceData chatRoomEntranceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, chatRoomEntranceData) == null) {
            if (!O2()) {
                Y2(true);
                return;
            }
            if (O2()) {
                this.a.b.stopFlipping();
            }
            if (this.z != null && O2() && !this.z.D()) {
                this.z.E(chatRoomEntranceData.getChatRoomInfoList(), H2(), this.Q);
            }
        }
    }

    public void d3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            if (this.x == null) {
                this.x = new HashMap();
            } else {
                this.x = TbSingleton.getInstance().getHasClickRedPot();
            }
            this.x.put(Long.valueOf(this.n), Integer.valueOf(i2));
            TbSingleton.getInstance().setHasClickRedPot(this.x);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            int m2 = yi.m(getContext(), UtilHelper.isFoldScreen()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
            this.j = m2;
            if (m2 != this.a.c.getWidth()) {
                this.a.c.setWidth(this.j);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048621, this, i2) != null) || i2 == this.mSkinType) {
            return;
        }
        this.mSkinType = i2;
        pk8 pk8Var = this.A;
        if (pk8Var != null) {
            pk8Var.e(i2);
        }
        this.a.c.setCardBackgroundColor(SkinManager.getColor(R.color.CAM_X0207));
        SkinManager.setImageResource(this.a.w, R.drawable.chat_group_mask_guide);
        W2();
        d85.d(this.a.g).f(R.color.CAM_X0334);
        SkinManager.setBackgroundColor(this.a.j, R.color.transparent);
        if (this.mSkinType == 0) {
            this.a.c.setElevation(UtilHelper.getDimenPixelSize(R.dimen.tbds21));
        }
        d85 d2 = d85.d(this.a.t);
        d2.D(R.string.F_X02);
        d2.x(R.color.CAM_X0105);
        d2.C(R.dimen.T_X08);
        d85 d3 = d85.d(this.a.u);
        d3.D(R.string.F_X01);
        d3.x(R.color.CAM_X0107);
        d3.C(R.dimen.T_X09);
        d85 d4 = d85.d(this.a.i);
        d4.x(R.color.CAM_X0101);
        d4.D(R.string.F_X01);
        d4.C(R.dimen.T_X08);
    }
}

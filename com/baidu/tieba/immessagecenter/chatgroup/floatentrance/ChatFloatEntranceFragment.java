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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tieba.a55;
import com.baidu.tieba.ap5;
import com.baidu.tieba.bl8;
import com.baidu.tieba.bx5;
import com.baidu.tieba.c55;
import com.baidu.tieba.fx5;
import com.baidu.tieba.gm8;
import com.baidu.tieba.gw5;
import com.baidu.tieba.hm8;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.je8;
import com.baidu.tieba.km8;
import com.baidu.tieba.lm8;
import com.baidu.tieba.mm8;
import com.baidu.tieba.nm8;
import com.baidu.tieba.ok8;
import com.baidu.tieba.om8;
import com.baidu.tieba.pm8;
import com.baidu.tieba.poa;
import com.baidu.tieba.qm8;
import com.baidu.tieba.rg5;
import com.baidu.tieba.uq8;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.xo5;
import com.baidu.tieba.yo5;
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
public class ChatFloatEntranceFragment extends BaseFragment implements xo5.b, gm8 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: T  reason: collision with root package name */
    public static final String f1133T;
    public static long U;
    public static final int V;
    public static final int W;
    public static final int X;
    public static int Y;
    public static int Z;
    public transient /* synthetic */ FieldHolder $fh;
    public hm8 A;
    public ap5 B;
    @Nullable
    public ok8 C;
    public boolean D;
    public long E;
    public boolean F;
    public String G;
    public boolean H;
    public final CustomMessageListener I;
    public final CustomMessageListener J;
    @NonNull
    public final ok8.c K;
    public final CustomMessageListener L;
    public final CustomMessageListener M;
    public List<Map<String, Long>> N;
    @Nullable
    public Runnable O;
    public final lm8 P;
    public final mm8 Q;
    public final nm8.d R;
    public Runnable S;
    public u a;
    public boolean b;
    public nm8 c;
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
    public km8 z;

    @Override // com.baidu.tieba.xo5.b
    public void d1(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, motionEvent) == null) {
        }
    }

    @Override // com.baidu.tieba.xo5.b
    public Fragment i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this : (Fragment) invokeV.objValue;
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
                        qm8.a(this.a.a.O);
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
                long p3 = this.a.p3();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (ListUtils.isEmpty(this.a.q) && this.a.r > 0) {
                    qm8.c(false, this.a.O);
                } else if (ListUtils.isEmpty(this.a.q) && !this.a.F) {
                    this.a.l.setChatRoomEntranceCallback(new a(this));
                    ChatFloatEntranceFragment chatFloatEntranceFragment = this.a;
                    chatFloatEntranceFragment.R2(currentAccount, Boolean.valueOf(chatFloatEntranceFragment.F), 0L);
                    this.a.F = true;
                } else {
                    ChatFloatEntranceFragment chatFloatEntranceFragment2 = this.a;
                    chatFloatEntranceFragment2.R2(currentAccount, Boolean.valueOf(chatFloatEntranceFragment2.F), p3);
                }
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
                chatFloatEntranceFragment.l3(chatFloatEntranceFragment.o);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements nm8.e {
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

        @Override // com.baidu.tieba.nm8.e
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
    public class c implements c55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SharedPrefHelper a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ a55 d;
        public final /* synthetic */ ChatFloatEntranceFragment e;

        public c(ChatFloatEntranceFragment chatFloatEntranceFragment, SharedPrefHelper sharedPrefHelper, String str, boolean z, a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment, sharedPrefHelper, str, Boolean.valueOf(z), a55Var};
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
            this.a = sharedPrefHelper;
            this.b = str;
            this.c = z;
            this.d = a55Var;
        }

        @Override // com.baidu.tieba.c55.f
        public void J0(c55 c55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIL(1048576, this, c55Var, i, view2) != null) || !(view2 instanceof TextView)) {
                return;
            }
            this.a.putBoolean(this.b, !this.c);
            this.e.m3(R.string.obfuscated_res_0x7f0f0a53, true);
            om8.d(this.e.n, this.c);
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
            this.a.U2();
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
                chatFloatEntranceFragment.j = BdUtilHelper.getEquipmentWidth(chatFloatEntranceFragment.getContext(), UtilHelper.isFoldScreen()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
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
    public class f implements nm8.c {
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

        @Override // com.baidu.tieba.nm8.c
        public void a(View view2, ChatRoomInfoData chatRoomInfoData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, view2, chatRoomInfoData) != null) || chatRoomInfoData == null) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.a.L2(25075);
            }
            this.a.t = chatRoomInfoData.getRoomId();
            this.a.v = chatRoomInfoData.getJumpUrl();
            this.a.O2();
        }
    }

    /* loaded from: classes6.dex */
    public class g extends bx5<List<GroupChatRoomPojo>> {
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
        @Override // com.baidu.tieba.bx5
        public List<GroupChatRoomPojo> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return je8.j().i(this.a, String.valueOf(this.b.o));
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements gw5<List<GroupChatRoomPojo>> {
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
        @Override // com.baidu.tieba.gw5
        /* renamed from: a */
        public void onReturnDataInUI(List<GroupChatRoomPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.c.G = uq8.d(list);
                if (!this.a.booleanValue()) {
                    this.c.l.getChatEntranceData(PollingModel.CHATROOM_FRS, this.c.o, this.b, this.c.m, this.c.G);
                } else {
                    this.c.l.getChatEntranceData(PollingModel.CHATROOM_FRS, null, this.b, this.c.m, this.c.G);
                }
                if (this.c.O != null) {
                    qm8.b(this.c.O, ChatFloatEntranceFragment.U);
                }
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
                hm8 hm8Var = this.a.A;
                if (hm8Var != null) {
                    hm8Var.b();
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
                    poa.a(this.a.a.c, 10L, this.a.a.k, 10L);
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
                this.a.g();
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
                    this.a.g();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements ok8.c {
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

        @Override // com.baidu.tieba.ok8.c
        public void a(List list, int i) {
            ChatFloatEntranceFragment chatFloatEntranceFragment;
            hm8 hm8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) && (hm8Var = (chatFloatEntranceFragment = this.a).A) != null) {
                hm8Var.f(chatFloatEntranceFragment.q, this.a.n, list, i);
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
            rg5 rg5Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.hasError() || !this.a.isResumed()) {
                return;
            }
            if ((customResponsedMessage.getData() instanceof rg5) && (rg5Var = (rg5) customResponsedMessage.getData()) != null && rg5Var.a()) {
                this.a.u = rg5Var.b();
            }
            if (TbadkCoreApplication.isLogin() && this.a.u > 0 && !this.a.Z2()) {
                if (this.a.B != null) {
                    this.a.B.a(this.a.getPageContext(), Collections.unmodifiableList(this.a.q), this.a.n, this.a.o, this.a.u, this.a.p, this.a.getActivity().getSupportFragmentManager(), bl8.b, "frs");
                }
                this.a.u = -1L;
            }
            this.a.H = false;
            if (this.a.z != null && !this.a.z.F(this.a.T2())) {
                qm8.c(true, this.a.O);
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !customResponsedMessage.hasError() && this.a.a3() && this.a.z != null) {
                this.a.z.p();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements lm8 {
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

        @Override // com.baidu.tieba.lm8
        public void a(@NonNull ChatRoomInfo chatRoomInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, chatRoomInfo) != null) || chatRoomInfo.getNewMessage() == null || this.a.H) {
                return;
            }
            this.a.f3(0, chatRoomInfo);
        }
    }

    /* loaded from: classes6.dex */
    public class s implements mm8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        @Override // com.baidu.tieba.mm8
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

        @Override // com.baidu.tieba.mm8
        public void b(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.a.z != null && this.a.z.F(j)) {
                qm8.c(false, this.a.O);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements nm8.d {
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

        @Override // com.baidu.tieba.nm8.d
        public void a(@NonNull View view2, @NonNull ChatRoomInfoData chatRoomInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, chatRoomInfoData) == null) {
                this.a.t = chatRoomInfoData.getRoomId();
                if (chatRoomInfoData.getChatroomInfoBasicData() != null) {
                    int btnType = chatRoomInfoData.getChatroomInfoBasicData().getBtnType();
                    this.a.y = JavaTypesHelper.toInt(chatRoomInfoData.getChatroomInfoBasicData().getUnreadNum(), 0);
                    ChatFloatEntranceFragment chatFloatEntranceFragment = this.a;
                    chatFloatEntranceFragment.P2(btnType, chatFloatEntranceFragment.y);
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
                uVar.c = (CardViewLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906cb);
                uVar.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906cc);
                uVar.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906d3);
                uVar.g = view2.findViewById(R.id.obfuscated_res_0x7f0914fa);
                uVar.b = (BaseAdapterViewFlipper) view2.findViewById(R.id.obfuscated_res_0x7f0906cd);
                uVar.h = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906c8);
                uVar.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906c9);
                uVar.f = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906d6);
                uVar.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906c1);
                uVar.l = (RoundRelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906c4);
                uVar.m = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b5b);
                uVar.n = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906c2);
                uVar.j = view2.findViewById(R.id.obfuscated_res_0x7f0921b4);
                uVar.o = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906c0);
                uVar.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902e3);
                uVar.q = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0902e4);
                uVar.r = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09253e);
                uVar.s = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09253f);
                uVar.v = (ConstraintLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906cf);
                uVar.w = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906ce);
                uVar.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906d1);
                uVar.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906d0);
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
        f1133T = SharedPrefHelper.getSharedPrefKeyWithAccount(PollingModel.SP_KEY_GROUP_CHAT_DISTURB_SETTING);
        U = 5000L;
        V = UtilHelper.getDimenPixelSize(R.dimen.tbds130);
        W = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        X = UtilHelper.getDimenPixelSize(R.dimen.tbds170);
        Y = 0;
        Z = 1;
    }

    @Override // com.baidu.tieba.gm8
    public void O1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.C != null && this.n > 0 && System.currentTimeMillis() - this.E > 5000) {
            if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST) instanceof TbHttpMessageTask) {
                ((TbHttpMessageTask) MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST)).setIsNeedDialog(false);
            }
            this.C.F(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.n), "frs");
            this.E = System.currentTimeMillis();
        }
    }

    public final void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d3();
            ok8 ok8Var = this.C;
            if (ok8Var != null) {
                ok8Var.u(true);
            }
            if (this.z != null && a3()) {
                this.z.G(T2());
            }
            om8.b("c15073", this.n, this.o, String.valueOf(this.t), 1, 1);
            om8.b(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK, this.n, this.o, String.valueOf(this.t), 1, 1);
            U2();
        }
    }

    @Override // com.baidu.tieba.xo5.b
    public boolean h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (Y2() || !this.b) {
                return false;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921788));
            this.a.v.setVisibility(0);
            SafeHandler.getInst().postDelayed(this.S, 5000L);
            SharedPrefHelper.getInstance().putBoolean("key_chat_group_guide_show", true);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onDestroyView();
            qm8.d(this.O);
            SafeHandler.getInst().removeCallbacks(this.S);
            MessageManager.getInstance().unRegisterListener(this.J);
            MessageManager.getInstance().unRegisterListener(this.I);
            MessageManager.getInstance().unRegisterListener(this.L);
            MessageManager.getInstance().unRegisterListener(this.M);
            MessageManager.getInstance().unRegisterListener(nm8.f);
            this.c.f(null);
            ok8 ok8Var = this.C;
            if (ok8Var != null) {
                ok8Var.o();
            }
            km8 km8Var = this.z;
            if (km8Var != null) {
                km8Var.o();
            }
            this.O = null;
        }
    }

    public ChatFloatEntranceFragment(String str, ap5 ap5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, ap5Var};
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
        this.B = ap5Var;
    }

    @Override // com.baidu.tieba.xo5.b
    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            U2();
        }
    }

    public final void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921789));
            this.a.v.setVisibility(8);
        }
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            long loopChatroomFrequency = TbSingleton.getInstance().getLoopChatroomFrequency() * 1000;
            U = loopChatroomFrequency;
            if (loopChatroomFrequency <= 0) {
                U = 5000L;
            }
        }
    }

    public final boolean X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (TbadkCoreApplication.isLogin() && this.t > 0 && !Z2()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return SharedPrefHelper.getInstance().getBoolean("key_chat_group_guide_show", false);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xo5.b
    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (ListUtils.isEmpty(this.q) && this.r > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.r <= 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (!ListUtils.isEmpty(this.q) && this.q.size() <= 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xo5.b
    public void b1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && !this.e && this.d != 2) {
            this.d = 2;
            Q2();
            hm8 hm8Var = this.A;
            if (hm8Var != null) {
                hm8Var.c();
            }
        }
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.a.c.getViewTreeObserver().addOnGlobalLayoutListener(new e(this));
        }
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.c.e(new f(this));
        }
    }

    @Override // com.baidu.tieba.xo5.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            onDestroyView();
            this.B = null;
        }
    }

    @Override // com.baidu.tieba.xo5.b
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && !this.e && this.d != 1) {
            this.d = 1;
            N2();
            h3();
            U2();
        }
    }

    @Override // com.baidu.tieba.xo5.b
    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (this.d == 1 || this.a.c.getVisibility() != 0) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.gm8
    public Context getViewContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return getContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            super.onPause();
            km8 km8Var = this.z;
            if (km8Var != null) {
                km8Var.q();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.onResume();
            hm8 hm8Var = this.A;
            if (hm8Var != null) {
                hm8Var.g(this.q);
            }
        }
    }

    @Override // com.baidu.tieba.gm8
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gm8
    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.n;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.xo5.b
    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return !ListUtils.isEmpty(this.w);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xo5.b
    public void C1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.b = z;
        }
    }

    @Override // com.baidu.tieba.xo5.b
    public boolean I1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return String.valueOf(this.m).equals(str);
        }
        return invokeL.booleanValue;
    }

    public final void L2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getContext(), true, i2)));
        }
    }

    @Override // com.baidu.tieba.xo5.b
    public void P0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.g = z;
        }
    }

    public void k3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048617, this, z) != null) || this.a.b.isFlipping()) {
            return;
        }
        this.a.b.setAutoStart(z);
        this.a.b.startFlipping();
    }

    public final void R2(String str, Boolean bool, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, bool, Long.valueOf(j2)}) == null) {
            fx5.c(new g(this, str), new h(this, bool, j2));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048622, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 != 25075) {
                    if (i2 == 25076) {
                        e3();
                        return;
                    }
                    return;
                }
                O2();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048627, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0323, viewGroup, false);
            this.a = u.a(inflate);
            W2();
            this.A = new hm8(this.a, this);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.xo5.b
    public void J(ChatRoomEntranceData chatRoomEntranceData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, chatRoomEntranceData) == null) && chatRoomEntranceData != null) {
            if (!ListUtils.isEmpty(chatRoomEntranceData.getChatRoomInfoList()) || chatRoomEntranceData.getHotListOriginNum() > 0) {
                if (this.g) {
                    this.r = chatRoomEntranceData.getHotListOriginNum();
                }
                if (ListUtils.isEmpty(chatRoomEntranceData.getChatRoomInfoList()) && chatRoomEntranceData.getHotListOriginNum() > 0) {
                    g3();
                    return;
                }
                if (!ListUtils.isEmpty(chatRoomEntranceData.getHotRoomList())) {
                    this.q.clear();
                    this.q.addAll(chatRoomEntranceData.getHotRoomList());
                    n3(chatRoomEntranceData);
                }
                if (!this.D && this.C != null && this.n > 0) {
                    if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST) instanceof TbHttpMessageTask) {
                        ((TbHttpMessageTask) MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST)).setIsNeedDialog(false);
                    }
                    this.C.F(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.n), "frs");
                    this.D = true;
                }
                List<ChatRoomInfoData> chatRoomInfoList = chatRoomEntranceData.getChatRoomInfoList();
                this.w = chatRoomInfoList;
                this.c.d(chatRoomInfoList);
                if (this.a.b.getAdapter() == null) {
                    this.a.b.setAdapter(this.c);
                }
                if (this.z != null && a3() && !this.z.F(T2())) {
                    ChatRoomInfoData chatRoomInfoData = chatRoomEntranceData.getChatRoomInfoList().get(0);
                    int btnType = chatRoomInfoData.getChatroomInfoBasicData().getBtnType();
                    int i2 = JavaTypesHelper.toInt(chatRoomInfoData.getChatroomInfoBasicData().getUnreadNum(), 0);
                    this.y = i2;
                    P2(btnType, i2);
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
        if (interceptable == null || interceptable.invokeL(1048624, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f0906c4) {
                if (TbadkCoreApplication.isLogin()) {
                    ap5 ap5Var = this.B;
                    if (ap5Var != null) {
                        ap5Var.a(getPageContext(), Collections.unmodifiableList(this.q), this.n, this.o, this.t, this.p, getActivity().getSupportFragmentManager(), bl8.a, "frs");
                    }
                } else {
                    this.f = true;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) TbadkCoreApplication.getInst(), true)));
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f0906d6 && view2.getId() != R.id.obfuscated_res_0x7f0906c8) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                om8.b("c15073", this.n, this.o, null, i2, 2);
                U2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0906c8) {
                ViewHelper.checkUpIsLogin(getPageContext().getPageActivity());
                d3();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0906d6) {
                if (!TbadkCoreApplication.isLogin()) {
                    L2(25076);
                    return;
                }
                ap5 ap5Var2 = this.B;
                if (ap5Var2 != null) {
                    ap5Var2.a(getPageContext(), Collections.unmodifiableList(this.q), this.n, this.o, -1L, this.p, getActivity().getSupportFragmentManager(), bl8.a, "frs");
                }
            }
        }
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds170);
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.a.b, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, dimenPixelSize, 0.0f), PropertyValuesHolder.ofFloat(View.ALPHA, 0.0f, 1.0f)).setDuration(800L);
            duration.setInterpolator(new AccelerateDecelerateInterpolator());
            this.a.b.setInAnimation(duration);
            ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(this.a.b, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 0.0f, -dimenPixelSize), PropertyValuesHolder.ofFloat(View.ALPHA, 1.0f, 0.0f)).setDuration(800L);
            duration2.setInterpolator(new AccelerateDecelerateInterpolator());
            this.a.b.setOutAnimation(duration2);
        }
    }

    public void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.N == null) {
                this.N = new ArrayList();
            }
            this.N.clear();
            for (int i2 = 0; i2 < this.q.size(); i2++) {
                Long l2 = this.q.get(i2);
                HashMap hashMap = new HashMap();
                hashMap.put("room_id", l2);
                GroupChatRoomPojo f2 = je8.j().f(TbadkCoreApplication.getCurrentAccount(), l2.longValue());
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

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.a.f.setOnClickListener(this);
            this.a.h.setOnClickListener(this);
            this.a.d.setOnClickListener(this);
            a aVar = new a(this);
            this.a.f.setOnLongClickListener(aVar);
            this.a.h.setOnLongClickListener(aVar);
            this.a.l.setOnLongClickListener(aVar);
            this.a.c.setRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            EMManager.from(this.a.c).setCorner(R.string.J_X06);
            this.a.g.setAlpha(0.08f);
            nm8 nm8Var = new nm8(getPageContext());
            this.c = nm8Var;
            nm8Var.g(new b(this, aVar));
            this.a.b.setFlipInterval(5500);
            this.a.b.startFlipping();
            this.a.b.setAnimateFirstView(false);
            M2();
            c3();
            this.a.t.setText(R.string.chat_group_guide_title);
            this.a.u.setText(R.string.chat_group_guide_content);
            this.c.f(this.R);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            b3();
        }
    }

    public void h3() {
        Date date;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
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
                    S2();
                    o3(Y);
                } else if (i2 == Z) {
                    S2();
                    o3(Y);
                }
            }
        }
    }

    public final void N2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.e) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.a.c, "width", this.j, V);
        animatorSet.playTogether(ofInt, ObjectAnimator.ofInt(this.a.c, "height", this.k, V), ObjectAnimator.ofInt(this.a.c, "marginRight", this.i, W));
        animatorSet.addListener(new i(this));
        ofInt.addUpdateListener(new j(this));
        animatorSet.setDuration(600L).start();
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || this.e) {
            return;
        }
        u uVar = this.a;
        poa.a(uVar.k, 10L, uVar.c, 10L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofInt(this.a.c, "width", V, this.j), ObjectAnimator.ofInt(this.a.c, "height", V, this.k), ObjectAnimator.ofInt(this.a.c, "marginRight", W, this.i));
        animatorSet.addListener(new l(this));
        animatorSet.setDuration(600L).start();
    }

    @Override // com.baidu.tieba.xo5.b
    public void P1(long j2, String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j2), str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.p = z;
            if (StringUtils.isNull(this.o)) {
                this.o = str;
            }
            if (this.n == 0 && j2 > 0 && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && !this.F) {
                qm8.a(this.O);
            }
            this.n = j2;
            this.C = new ok8(getContext(), this.K, false);
        }
    }

    public final void P2(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            if (i2 == 1) {
                j3(UtilHelper.getDimenPixelSize(R.dimen.tbds172), false, 0);
                SkinManager.setBackgroundResource(this.a.h, R.drawable.icon_chat_group_experience);
            } else if (i3 > 0) {
                j3(UtilHelper.getDimenPixelSize(R.dimen.tbds172), true, i3);
                SkinManager.setBackgroundResource(this.a.h, R.drawable.icon_chat_group_new_msg);
            } else {
                j3(UtilHelper.getDimenPixelSize(R.dimen.tbds198), false, 0);
                SkinManager.setBackgroundResource(this.a.h, R.drawable.icon_chat_group_enter_see_more);
            }
        }
    }

    public void m3(@StringRes int i2, boolean z) {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048619, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) != null) || (activity = getActivity()) == null) {
            return;
        }
        new BdTopToast(activity).setContent(activity.getString(i2)).setIcon(z).show((ViewGroup) activity.findViewById(16908290));
    }

    public final long T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (!ListUtils.isEmpty(this.q) && ListUtils.getCount(this.q) > 0 && this.q.get(0) != null) {
                return this.q.get(0).longValue();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && TbadkCoreApplication.isLogin() && getContext() != null && this.t > 0) {
            this.H = true;
            yo5.a().e(getContext(), 1, this.t, X2());
        }
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && getContext() != null && this.f) {
            this.f = false;
            ap5 ap5Var = this.B;
            if (ap5Var != null) {
                ap5Var.a(getPageContext(), Collections.unmodifiableList(this.q), this.n, this.o, this.t, this.p, getActivity().getSupportFragmentManager(), bl8.a, "frs");
            }
        }
    }

    public void g3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && !this.e && this.d != 1) {
            this.d = 1;
            u uVar = this.a;
            poa.a(uVar.c, 10L, uVar.k, 10L);
            hm8 hm8Var = this.A;
            if (hm8Var != null) {
                hm8Var.b();
            }
            h3();
            U2();
        }
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            SkinManager.setBackgroundResource(this.a.d, R.drawable.bg_chat_group_expend_gradual);
            SkinManager.setBackgroundResource(this.a.l, R.drawable.bg_chat_group_collapse_gradual);
            SkinManager.setImageResource(this.a.e, R.drawable.icon_entrance_left_expend);
            P2(3, this.y);
        }
    }

    public final long p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
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

    public final void f3(int i2, @NonNull ChatRoomInfo chatRoomInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048607, this, i2, chatRoomInfo) != null) || this.a.b.getChildCount() - 1 != i2) {
            return;
        }
        this.y = chatRoomInfo.getUnreadNum();
        this.t = chatRoomInfo.getRoomId();
        nm8 nm8Var = this.c;
        if (nm8Var != null) {
            Object item = nm8Var.getItem(i2);
            if (item instanceof ChatRoomInfoData) {
                pm8.d(chatRoomInfo, (ChatRoomInfoData) item);
                this.c.notifyDataSetChanged();
            }
        }
    }

    public final void j3(int i2, boolean z, int i3) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) && getPageContext() != null && (layoutParams = (LinearLayout.LayoutParams) this.a.h.getLayoutParams()) != null) {
            if (z && i3 > 0) {
                this.a.i.setVisibility(0);
                String format = String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0e31), Integer.valueOf(i3));
                String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0e32);
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

    public final void l3(String str) {
        TbPageContext<BaseFragmentActivity> pageContext;
        int i2;
        String str2;
        TbSingleton.GroupChatDisturbText.TitleText canNotDisturb;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048618, this, str) != null) || (pageContext = getPageContext()) == null) {
            return;
        }
        SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
        String str3 = f1133T + str;
        boolean z = sharedPrefHelper.getBoolean(str3, true);
        if (z) {
            i2 = R.string.obfuscated_res_0x7f0f0a51;
        } else {
            i2 = R.string.obfuscated_res_0x7f0f0a52;
        }
        String string = pageContext.getString(i2);
        if (z) {
            str2 = pageContext.getString(R.string.obfuscated_res_0x7f0f0a50);
        } else {
            str2 = null;
        }
        TbSingleton.GroupChatDisturbText groupChatDisturbText = TbSingleton.getInstance().getGroupChatDisturbText();
        if (groupChatDisturbText != null) {
            if (z) {
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
        a55 a55Var = new a55(pageContext);
        a55Var.j(false);
        a55Var.i(str2, new String[]{string}, new c(this, sharedPrefHelper, str3, z, a55Var));
        a55Var.l();
    }

    public final void n3(@NonNull ChatRoomEntranceData chatRoomEntranceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, chatRoomEntranceData) == null) {
            if (!a3()) {
                k3(true);
                return;
            }
            if (a3()) {
                this.a.b.stopFlipping();
            }
            if (this.z != null && a3() && !this.z.D()) {
                this.z.E(chatRoomEntranceData.getChatRoomInfoList(), T2(), this.Q);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, bundle) == null) {
            super.onCreate(bundle);
            V2();
            if (this.l == null) {
                this.l = new PollingModel(getPageContext(), getUniqueId());
            }
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                this.z = new km8(getPageContext().getPageActivity(), this.P);
            }
            qm8.a(this.O);
            registerListener(this.J);
            registerListener(this.I);
            registerListener(this.L);
            registerListener(this.M);
        }
    }

    public void o3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048625, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(getContext(), UtilHelper.isFoldScreen()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
            this.j = equipmentWidth;
            if (equipmentWidth != this.a.c.getWidth()) {
                this.a.c.setWidth(this.j);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048623, this, i2) != null) || i2 == this.mSkinType) {
            return;
        }
        this.mSkinType = i2;
        hm8 hm8Var = this.A;
        if (hm8Var != null) {
            hm8Var.e(i2);
        }
        this.a.c.setCardBackgroundColor(SkinManager.getColor(R.color.CAM_X0207));
        SkinManager.setImageResource(this.a.w, R.drawable.chat_group_mask_guide);
        i3();
        EMManager.from(this.a.g).setBackGroundColor(R.color.CAM_X0334);
        SkinManager.setBackgroundColor(this.a.j, R.color.transparent);
        if (this.mSkinType == 0) {
            this.a.c.setElevation(UtilHelper.getDimenPixelSize(R.dimen.tbds21));
        }
        EMManager.from(this.a.t).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X08);
        EMManager.from(this.a.u).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0107).setTextSize(R.dimen.T_X09);
        EMManager.from(this.a.i).setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08);
    }
}

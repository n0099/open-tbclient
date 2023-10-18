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
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ak5;
import com.baidu.tieba.an8;
import com.baidu.tieba.bk5;
import com.baidu.tieba.bn8;
import com.baidu.tieba.dk5;
import com.baidu.tieba.fl8;
import com.baidu.tieba.gs5;
import com.baidu.tieba.im.base.core.slice.SliceFragment;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.io8;
import com.baidu.tieba.ks5;
import com.baidu.tieba.lr5;
import com.baidu.tieba.mna;
import com.baidu.tieba.nl8;
import com.baidu.tieba.pz4;
import com.baidu.tieba.qd8;
import com.baidu.tieba.rm8;
import com.baidu.tieba.rz4;
import com.baidu.tieba.sm8;
import com.baidu.tieba.ub5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.vm8;
import com.baidu.tieba.wm8;
import com.baidu.tieba.xm8;
import com.baidu.tieba.ym8;
import com.baidu.tieba.zm8;
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
public class ChatFloatEntranceFragment extends SliceFragment implements ak5.b, rm8 {
    public static /* synthetic */ Interceptable $ic;
    public static final String Y;
    public static long Z;
    public static final int a0;
    public static final int b0;
    public static final int c0;
    public static int d0;
    public static int e0;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ChatRoomInfoData> A;
    public Map<Long, Integer> B;
    public int C;
    @Nullable
    public vm8 D;
    public sm8 E;
    public dk5 F;
    @Nullable
    public fl8 G;
    public boolean H;
    public long I;
    public boolean J;
    public String K;
    public boolean L;
    public boolean M;
    public final CustomMessageListener N;
    public final CustomMessageListener O;
    @NonNull
    public final fl8.c P;
    public final CustomMessageListener Q;
    public final CustomMessageListener R;
    public List<Map<String, Long>> S;
    @Nullable

    /* renamed from: T  reason: collision with root package name */
    public Runnable f1124T;
    public final wm8 U;
    public final xm8 V;
    public final ym8.d W;
    public Runnable X;
    public u e;
    public boolean f;
    public ym8 g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o;
    public PollingModel p;
    public String q;
    public long r;
    public String s;
    public boolean t;
    @NonNull
    public final List<Long> u;
    public int v;
    public int w;
    public long x;
    public long y;
    public String z;

    @Override // com.baidu.tieba.ak5.b
    public Fragment j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this : (Fragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak5.b
    public void k1(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, motionEvent) == null) {
        }
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
                    chatFloatEntranceFragment.r = j;
                    if (this.a.a.r > 0 && !this.a.a.J) {
                        bn8.a(this.a.a.f1124T);
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.p != null) {
                this.a.q = String.valueOf(System.currentTimeMillis());
                long C3 = this.a.C3();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (ListUtils.isEmpty(this.a.u) && this.a.v > 0) {
                    bn8.c(false, this.a.f1124T);
                } else if (ListUtils.isEmpty(this.a.u) && !this.a.J) {
                    this.a.p.setChatRoomEntranceCallback(new a(this));
                    ChatFloatEntranceFragment chatFloatEntranceFragment = this.a;
                    chatFloatEntranceFragment.e3(currentAccount, chatFloatEntranceFragment.J, 0L);
                    this.a.J = true;
                } else {
                    ChatFloatEntranceFragment chatFloatEntranceFragment2 = this.a;
                    chatFloatEntranceFragment2.e3(currentAccount, chatFloatEntranceFragment2.J, C3);
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
                chatFloatEntranceFragment.y3(chatFloatEntranceFragment.s);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ym8.e {
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

        @Override // com.baidu.tieba.ym8.e
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
    public class c implements rz4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SharedPrefHelper a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ pz4 d;
        public final /* synthetic */ ChatFloatEntranceFragment e;

        public c(ChatFloatEntranceFragment chatFloatEntranceFragment, SharedPrefHelper sharedPrefHelper, String str, boolean z, pz4 pz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment, sharedPrefHelper, str, Boolean.valueOf(z), pz4Var};
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
            this.d = pz4Var;
        }

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIL(1048576, this, rz4Var, i, view2) != null) || !(view2 instanceof TextView)) {
                return;
            }
            this.a.putBoolean(this.b, !this.c);
            this.e.z3(R.string.obfuscated_res_0x7f0f0a65, true);
            zm8.d(this.e.r, this.c);
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
            this.a.h3();
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
                chatFloatEntranceFragment.n = BdUtilHelper.getEquipmentWidth(chatFloatEntranceFragment.getContext(), UtilHelper.isFoldScreen()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
                ChatFloatEntranceFragment chatFloatEntranceFragment2 = this.a;
                chatFloatEntranceFragment2.o = chatFloatEntranceFragment2.e.c.getHeight();
                ViewGroup.LayoutParams layoutParams = this.a.e.c.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    this.a.l = marginLayoutParams.leftMargin;
                    this.a.m = marginLayoutParams.rightMargin;
                }
                this.a.e.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ym8.c {
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

        @Override // com.baidu.tieba.ym8.c
        public void a(View view2, ChatRoomInfoData chatRoomInfoData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, view2, chatRoomInfoData) != null) || chatRoomInfoData == null) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.a.X2(25075);
            }
            this.a.x = chatRoomInfoData.getRoomId();
            this.a.z = chatRoomInfoData.getJumpUrl();
            this.a.a3();
        }
    }

    /* loaded from: classes6.dex */
    public class g extends gs5<List<GroupChatRoomPojo>> {
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
        @Override // com.baidu.tieba.gs5
        public List<GroupChatRoomPojo> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return qd8.j().i(this.a, String.valueOf(this.b.s));
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements lr5<List<GroupChatRoomPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ long b;
        public final /* synthetic */ ChatFloatEntranceFragment c;

        public h(ChatFloatEntranceFragment chatFloatEntranceFragment, boolean z, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment, Boolean.valueOf(z), Long.valueOf(j)};
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
            this.a = z;
            this.b = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lr5
        /* renamed from: a */
        public void onReturnDataInUI(List<GroupChatRoomPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.c.K = io8.e(list);
                if (!this.a) {
                    this.c.p.getChatEntranceData(PollingModel.CHATROOM_FRS, this.c.s, this.b, this.c.q, this.c.K);
                } else {
                    this.c.p.getChatEntranceData(PollingModel.CHATROOM_FRS, null, this.b, this.c.q, this.c.K);
                }
                if (this.c.f1124T != null && this.c.M) {
                    bn8.b(this.c.f1124T, ChatFloatEntranceFragment.Z);
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
                this.a.i = false;
                this.a.h = 1;
                sm8 sm8Var = this.a.E;
                if (sm8Var != null) {
                    sm8Var.b();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                this.a.i = true;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && (valueAnimator.getAnimatedValue() instanceof Integer) && ((Integer) valueAnimator.getAnimatedValue()).intValue() <= ChatFloatEntranceFragment.c0 && this.a.e.f.getVisibility() == 0) {
                this.a.e.f.setVisibility(4);
                if (this.a.e.k.getVisibility() != 0) {
                    mna.a(this.a.e.c, 10L, this.a.e.k, 10L);
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
                this.a.i = false;
                this.a.h = 2;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                this.a.i = true;
                this.a.e.f.setVisibility(0);
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
    public class n implements fl8.c {
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

        @Override // com.baidu.tieba.fl8.c
        public void a(List list, int i) {
            ChatFloatEntranceFragment chatFloatEntranceFragment;
            sm8 sm8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) && (sm8Var = (chatFloatEntranceFragment = this.a).E) != null) {
                sm8Var.f(chatFloatEntranceFragment.u, this.a.r, list, i);
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
            ub5 ub5Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.hasError() || !this.a.isResumed()) {
                return;
            }
            if ((customResponsedMessage.getData() instanceof ub5) && (ub5Var = (ub5) customResponsedMessage.getData()) != null && ub5Var.a()) {
                this.a.y = ub5Var.b();
            }
            if (TbadkCoreApplication.isLogin() && this.a.y > 0 && !this.a.m3()) {
                if (this.a.F != null) {
                    this.a.F.a(this.a.getPageContext(), Collections.unmodifiableList(this.a.u), this.a.r, this.a.s, this.a.y, this.a.t, this.a.getActivity().getSupportFragmentManager(), nl8.b, "frs");
                }
                this.a.y = -1L;
            }
            this.a.L = false;
            if (this.a.D != null && !this.a.D.E(this.a.g3())) {
                bn8.c(true, this.a.f1124T);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !customResponsedMessage.hasError() && this.a.n3() && this.a.D != null) {
                this.a.D.p();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements wm8 {
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

        @Override // com.baidu.tieba.wm8
        public void a(@NonNull ChatRoomInfo chatRoomInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, chatRoomInfo) != null) || chatRoomInfo.getNewMessage() == null || this.a.L) {
                return;
            }
            this.a.s3(0, chatRoomInfo);
        }
    }

    /* loaded from: classes6.dex */
    public class s implements xm8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        @Override // com.baidu.tieba.xm8
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

        @Override // com.baidu.tieba.xm8
        public void b(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.a.D != null && this.a.D.E(j)) {
                bn8.c(false, this.a.f1124T);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements ym8.d {
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

        @Override // com.baidu.tieba.ym8.d
        public void a(@NonNull View view2, @NonNull ChatRoomInfoData chatRoomInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, chatRoomInfoData) == null) {
                this.a.x = chatRoomInfoData.getRoomId();
                if (chatRoomInfoData.getChatroomInfoBasicData() != null) {
                    int btnType = chatRoomInfoData.getChatroomInfoBasicData().getBtnType();
                    this.a.C = JavaTypesHelper.toInt(chatRoomInfoData.getChatroomInfoBasicData().getUnreadNum(), 0);
                    ChatFloatEntranceFragment chatFloatEntranceFragment = this.a;
                    chatFloatEntranceFragment.b3(btnType, chatFloatEntranceFragment.C);
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
                uVar.c = (CardViewLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906d3);
                uVar.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906d4);
                uVar.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906db);
                uVar.g = view2.findViewById(R.id.obfuscated_res_0x7f091508);
                uVar.b = (BaseAdapterViewFlipper) view2.findViewById(R.id.obfuscated_res_0x7f0906d5);
                uVar.h = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906d0);
                uVar.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906d1);
                uVar.f = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906de);
                uVar.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906c9);
                uVar.l = (RoundRelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906cc);
                uVar.m = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b63);
                uVar.n = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906ca);
                uVar.j = view2.findViewById(R.id.obfuscated_res_0x7f0921c7);
                uVar.o = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906c8);
                uVar.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902e5);
                uVar.q = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0902e6);
                uVar.r = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092555);
                uVar.s = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092556);
                uVar.v = (ConstraintLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906d7);
                uVar.w = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906d6);
                uVar.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906d9);
                uVar.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906d8);
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
        Y = SharedPrefHelper.getSharedPrefKeyWithAccount(PollingModel.SP_KEY_GROUP_CHAT_DISTURB_SETTING);
        Z = 5000L;
        a0 = UtilHelper.getDimenPixelSize(R.dimen.tbds130);
        b0 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        c0 = UtilHelper.getDimenPixelSize(R.dimen.tbds170);
        d0 = 0;
        e0 = 1;
    }

    @Override // com.baidu.tieba.rm8
    public void U1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.G != null && this.r > 0 && System.currentTimeMillis() - this.I > 5000) {
            if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST) instanceof TbHttpMessageTask) {
                ((TbHttpMessageTask) MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST)).setIsNeedDialog(false);
            }
            this.G.E(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.r), "frs");
            this.I = System.currentTimeMillis();
        }
    }

    public final void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            q3();
            fl8 fl8Var = this.G;
            if (fl8Var != null) {
                fl8Var.t(true);
            }
            if (this.D != null && n3()) {
                this.D.F(g3());
            }
            zm8.b("c15073", this.r, this.s, String.valueOf(this.x), 1, 1);
            zm8.b(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK, this.r, this.s, String.valueOf(this.x), 1, 1);
            h3();
        }
    }

    @Override // com.baidu.tieba.ak5.b
    public boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (l3() || !this.f) {
                return false;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921788));
            this.e.v.setVisibility(0);
            SafeHandler.getInst().postDelayed(this.X, 5000L);
            SharedPrefHelper.getInstance().putBoolean("key_chat_group_guide_show", true);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onDestroyView();
            bn8.d(this.f1124T);
            SafeHandler.getInst().removeCallbacks(this.X);
            MessageManager.getInstance().unRegisterListener(this.O);
            MessageManager.getInstance().unRegisterListener(this.N);
            MessageManager.getInstance().unRegisterListener(this.Q);
            MessageManager.getInstance().unRegisterListener(this.R);
            MessageManager.getInstance().unRegisterListener(ym8.f);
            this.g.f(null);
            fl8 fl8Var = this.G;
            if (fl8Var != null) {
                fl8Var.o();
            }
            vm8 vm8Var = this.D;
            if (vm8Var != null) {
                vm8Var.o();
            }
            this.f1124T = null;
        }
    }

    public ChatFloatEntranceFragment(String str, dk5 dk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, dk5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = true;
        this.h = 0;
        this.i = false;
        this.j = false;
        this.k = true;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.u = new ArrayList();
        this.v = 0;
        this.w = 1;
        this.x = -1L;
        this.y = -1L;
        this.B = new HashMap();
        this.H = false;
        this.J = false;
        this.L = false;
        this.M = true;
        this.N = new k(this, 2921769);
        this.O = new m(this, 2921768);
        this.P = new n(this);
        this.Q = new o(this, 2921771);
        this.R = new p(this, 2003023);
        this.S = null;
        this.f1124T = new q(this);
        this.U = new r(this);
        this.V = new s(this);
        this.W = new t(this);
        this.X = new d(this);
        this.s = str;
        this.F = dk5Var;
    }

    @Override // com.baidu.tieba.ak5.b
    public void G1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f = z;
        }
    }

    @Override // com.baidu.tieba.ak5.b
    public boolean O1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return String.valueOf(this.q).equals(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ak5.b
    public void V0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.k = z;
        }
    }

    public final void X2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getContext(), true, i2)));
        }
    }

    public void x3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048633, this, z) != null) || this.e.b.isFlipping()) {
            return;
        }
        this.e.b.setAutoStart(z);
        this.e.b.startFlipping();
    }

    @Override // com.baidu.tieba.ak5.b
    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return !ListUtils.isEmpty(this.A);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ak5.b
    public void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h3();
        }
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.f1124T != null && ListUtils.isEmpty(this.u)) {
            this.M = false;
            bn8.c(false, this.f1124T);
        }
    }

    @Override // com.baidu.tieba.ak5.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            onDestroyView();
            this.F = null;
        }
    }

    @Override // com.baidu.tieba.ak5.b
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && !this.i && this.h != 1) {
            this.h = 1;
            Z2();
            u3();
            h3();
        }
    }

    @Override // com.baidu.tieba.ak5.b
    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.h == 1 || this.e.c.getVisibility() != 0) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rm8
    public Context getViewContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return getContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ak5.b
    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (ListUtils.isEmpty(this.u) && this.v > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921789));
            this.e.v.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ak5.b
    public void i1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && !this.i && this.h != 2) {
            this.h = 2;
            d3();
            sm8 sm8Var = this.E;
            if (sm8Var != null) {
                sm8Var.c();
            }
        }
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            long loopChatroomFrequency = TbSingleton.getInstance().getLoopChatroomFrequency() * 1000;
            Z = loopChatroomFrequency;
            if (loopChatroomFrequency <= 0) {
                Z = 5000L;
            }
        }
    }

    public final boolean k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (TbadkCoreApplication.isLogin() && this.x > 0 && !m3()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return SharedPrefHelper.getInstance().getBoolean("key_chat_group_guide_show", false);
        }
        return invokeV.booleanValue;
    }

    public final boolean m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (this.v <= 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (!ListUtils.isEmpty(this.u) && this.u.size() <= 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.e.c.getViewTreeObserver().addOnGlobalLayoutListener(new e(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            super.onPause();
            vm8 vm8Var = this.D;
            if (vm8Var != null) {
                vm8Var.q();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onResume();
            sm8 sm8Var = this.E;
            if (sm8Var != null) {
                sm8Var.g(this.u);
            }
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.g.e(new f(this));
        }
    }

    @Override // com.baidu.tieba.rm8
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rm8
    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.r;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048614, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 != 25075) {
                    if (i2 == 25076) {
                        r3();
                        return;
                    }
                    return;
                }
                a3();
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048619, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0328, viewGroup, false);
            this.e = u.a(inflate);
            j3();
            this.E = new sm8(this.e, this);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    public final void A3(@NonNull ChatRoomEntranceData chatRoomEntranceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, chatRoomEntranceData) == null) {
            if (!n3()) {
                x3(true);
                return;
            }
            if (n3()) {
                this.e.b.stopFlipping();
            }
            if (this.D != null && n3() && !this.D.C()) {
                this.D.D(chatRoomEntranceData.getChatRoomInfoList(), g3(), this.V);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
            super.onCreate(bundle);
            i3();
            if (this.p == null) {
                this.p = new PollingModel(getPageContext(), getUniqueId());
            }
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                this.D = new vm8(getPageContext().getPageActivity(), this.U);
            }
            bn8.a(this.f1124T);
            registerListener(this.O);
            registerListener(this.N);
            registerListener(this.Q);
            registerListener(this.R);
        }
    }

    public void B3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (this.B == null) {
                this.B = new HashMap();
            } else {
                this.B = TbSingleton.getInstance().getHasClickRedPot();
            }
            this.B.put(Long.valueOf(this.r), Integer.valueOf(i2));
            TbSingleton.getInstance().setHasClickRedPot(this.B);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(getContext(), UtilHelper.isFoldScreen()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
            this.n = equipmentWidth;
            if (equipmentWidth != this.e.c.getWidth()) {
                this.e.c.setWidth(this.n);
            }
        }
    }

    public final long C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.u)) {
                return 0L;
            }
            if (this.w > ListUtils.getCount(this.u) - 1) {
                this.w = 0;
            }
            long longValue = this.u.get(this.w).longValue();
            this.w++;
            return longValue;
        }
        return invokeV.longValue;
    }

    public final long g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (!ListUtils.isEmpty(this.u) && ListUtils.getCount(this.u) > 0 && this.u.get(0) != null) {
                return this.u.get(0).longValue();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && TbadkCoreApplication.isLogin() && getContext() != null && this.x > 0) {
            this.L = true;
            bk5.a().f(getContext(), 1, this.x, k3());
        }
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && getContext() != null && this.j) {
            this.j = false;
            dk5 dk5Var = this.F;
            if (dk5Var != null) {
                dk5Var.a(getPageContext(), Collections.unmodifiableList(this.u), this.r, this.s, this.x, this.t, getActivity().getSupportFragmentManager(), nl8.a, "frs");
            }
        }
    }

    public void t3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && !this.i && this.h != 1) {
            this.h = 1;
            u uVar = this.e;
            mna.a(uVar.c, 10L, uVar.k, 10L);
            sm8 sm8Var = this.E;
            if (sm8Var != null) {
                sm8Var.b();
            }
            u3();
            h3();
        }
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            SkinManager.setBackgroundResource(this.e.d, R.drawable.bg_chat_group_expend_gradual);
            SkinManager.setBackgroundResource(this.e.l, R.drawable.bg_chat_group_collapse_gradual);
            SkinManager.setImageResource(this.e.e, R.drawable.icon_entrance_left_expend);
            b3(3, this.C);
        }
    }

    @Override // com.baidu.tieba.ak5.b
    public void T(ChatRoomEntranceData chatRoomEntranceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, chatRoomEntranceData) == null) {
            if (chatRoomEntranceData != null && (!ListUtils.isEmpty(chatRoomEntranceData.getChatRoomInfoList()) || chatRoomEntranceData.getHotListOriginNum() > 0)) {
                if (this.k) {
                    this.v = chatRoomEntranceData.getHotListOriginNum();
                }
                if (ListUtils.isEmpty(chatRoomEntranceData.getChatRoomInfoList()) && chatRoomEntranceData.getHotListOriginNum() > 0) {
                    t3();
                    return;
                }
                if (!ListUtils.isEmpty(chatRoomEntranceData.getHotRoomList())) {
                    this.u.clear();
                    this.u.addAll(chatRoomEntranceData.getHotRoomList());
                    A3(chatRoomEntranceData);
                }
                if (!this.H && this.G != null && this.r > 0) {
                    if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST) instanceof TbHttpMessageTask) {
                        ((TbHttpMessageTask) MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST)).setIsNeedDialog(false);
                    }
                    this.G.E(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.r), "frs");
                    this.H = true;
                }
                List<ChatRoomInfoData> chatRoomInfoList = chatRoomEntranceData.getChatRoomInfoList();
                this.A = chatRoomInfoList;
                this.g.d(chatRoomInfoList);
                if (this.e.b.getAdapter() == null) {
                    this.e.b.setAdapter(this.g);
                }
                if (this.D != null && n3() && !this.D.E(g3())) {
                    ChatRoomInfoData chatRoomInfoData = chatRoomEntranceData.getChatRoomInfoList().get(0);
                    int btnType = chatRoomInfoData.getChatroomInfoBasicData().getBtnType();
                    int i2 = JavaTypesHelper.toInt(chatRoomInfoData.getChatroomInfoBasicData().getUnreadNum(), 0);
                    this.C = i2;
                    b3(btnType, i2);
                    this.g.notifyDataSetChanged();
                    this.D.p();
                    return;
                }
                return;
            }
            c3();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f0906cc) {
                if (TbadkCoreApplication.isLogin()) {
                    dk5 dk5Var = this.F;
                    if (dk5Var != null) {
                        dk5Var.a(getPageContext(), Collections.unmodifiableList(this.u), this.r, this.s, this.x, this.t, getActivity().getSupportFragmentManager(), nl8.a, "frs");
                    }
                } else {
                    this.j = true;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) TbadkCoreApplication.getInst(), true)));
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f0906de && view2.getId() != R.id.obfuscated_res_0x7f0906d0) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                zm8.b("c15073", this.r, this.s, String.valueOf(this.x), i2, 2);
                h3();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0906d0) {
                ViewHelper.checkUpIsLogin(getPageContext().getPageActivity());
                q3();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0906de) {
                if (!TbadkCoreApplication.isLogin()) {
                    X2(25076);
                    return;
                }
                dk5 dk5Var2 = this.F;
                if (dk5Var2 != null) {
                    dk5Var2.a(getPageContext(), Collections.unmodifiableList(this.u), this.r, this.s, this.x, this.t, getActivity().getSupportFragmentManager(), nl8.a, "frs");
                }
            }
        }
    }

    @Override // com.baidu.tieba.ak5.b
    public void X1(long j2, String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j2), str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.t = z;
            if (StringUtils.isNull(this.s)) {
                this.s = str;
            }
            if (this.r == 0 && j2 > 0 && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && !this.J) {
                bn8.a(this.f1124T);
            }
            this.r = j2;
            this.G = new fl8(getContext(), this.P, false);
        }
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds170);
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.e.b, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, dimenPixelSize, 0.0f), PropertyValuesHolder.ofFloat(View.ALPHA, 0.0f, 1.0f)).setDuration(800L);
            duration.setInterpolator(new AccelerateDecelerateInterpolator());
            this.e.b.setInAnimation(duration);
            ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(this.e.b, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 0.0f, -dimenPixelSize), PropertyValuesHolder.ofFloat(View.ALPHA, 1.0f, 0.0f)).setDuration(800L);
            duration2.setInterpolator(new AccelerateDecelerateInterpolator());
            this.e.b.setOutAnimation(duration2);
        }
    }

    public void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.S == null) {
                this.S = new ArrayList();
            }
            this.S.clear();
            for (int i2 = 0; i2 < this.u.size(); i2++) {
                Long l2 = this.u.get(i2);
                HashMap hashMap = new HashMap();
                hashMap.put("room_id", l2);
                GroupChatRoomPojo f2 = qd8.j().f(TbadkCoreApplication.getCurrentAccount(), l2.longValue());
                if (f2 != null) {
                    hashMap.put("msg_id", Long.valueOf(f2.getLatestMsgId()));
                    hashMap.put("time", Long.valueOf(f2.getLastExitChatRoomTime()));
                } else {
                    hashMap.put("msg_id", 0L);
                    hashMap.put("time", 1L);
                }
                this.S.add(hashMap);
            }
            if (ListUtils.isEmpty(this.S)) {
                return;
            }
            TbSingleton.getInstance().setLoopMsgRoomMsgId(DataExt.toJson(this.S));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921764, Boolean.TRUE));
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.e.f.setOnClickListener(this);
            this.e.h.setOnClickListener(this);
            this.e.d.setOnClickListener(this);
            a aVar = new a(this);
            this.e.f.setOnLongClickListener(aVar);
            this.e.h.setOnLongClickListener(aVar);
            this.e.l.setOnLongClickListener(aVar);
            this.e.c.setRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            EMManager.from(this.e.c).setCorner(R.string.J_X06);
            this.e.g.setAlpha(0.08f);
            ym8 ym8Var = new ym8(getPageContext());
            this.g = ym8Var;
            ym8Var.g(new b(this, aVar));
            this.e.b.setFlipInterval(5500);
            this.e.b.startFlipping();
            this.e.b.setAnimateFirstView(false);
            Y2();
            p3();
            this.e.t.setText(R.string.chat_group_guide_title);
            this.e.u.setText(R.string.chat_group_guide_content);
            this.g.f(this.W);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            o3();
        }
    }

    public void u3() {
        Date date;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            Date date2 = new Date(System.currentTimeMillis());
            if (TbSingleton.getInstance().getHasShowRedPot() != null && TbSingleton.getInstance().getHasShowRedPot().get(Long.valueOf(this.r)) != null) {
                date = TbSingleton.getInstance().getHasShowRedPot().get(Long.valueOf(this.r));
            } else {
                date = new Date(0L);
            }
            if (TbSingleton.getInstance().getHasClickRedPot() != null && TbSingleton.getInstance().getHasClickRedPot().get(Long.valueOf(this.r)) != null) {
                i2 = TbSingleton.getInstance().getHasClickRedPot().get(Long.valueOf(this.r)).intValue();
            } else {
                i2 = 0;
            }
            if (TimeHelper.getDayDifference(date2, date) >= 1) {
                f3();
                B3(d0);
            } else if (i2 == e0) {
                f3();
                B3(d0);
            }
        }
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || this.i) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.e.c, "width", this.n, a0);
        animatorSet.playTogether(ofInt, ObjectAnimator.ofInt(this.e.c, "height", this.o, a0), ObjectAnimator.ofInt(this.e.c, "marginRight", this.m, b0));
        animatorSet.addListener(new i(this));
        ofInt.addUpdateListener(new j(this));
        animatorSet.setDuration(600L).start();
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || this.i) {
            return;
        }
        u uVar = this.e;
        mna.a(uVar.k, 10L, uVar.c, 10L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofInt(this.e.c, "width", a0, this.n), ObjectAnimator.ofInt(this.e.c, "height", a0, this.o), ObjectAnimator.ofInt(this.e.c, "marginRight", b0, this.m));
        animatorSet.addListener(new l(this));
        animatorSet.setDuration(600L).start();
    }

    public final void b3(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
            if (i2 == 1) {
                w3(UtilHelper.getDimenPixelSize(R.dimen.tbds172), false, 0);
                SkinManager.setBackgroundResource(this.e.h, R.drawable.icon_chat_group_experience);
            } else if (i3 > 0) {
                w3(UtilHelper.getDimenPixelSize(R.dimen.tbds172), true, i3);
                SkinManager.setBackgroundResource(this.e.h, R.drawable.icon_chat_group_new_msg);
            } else {
                w3(UtilHelper.getDimenPixelSize(R.dimen.tbds198), false, 0);
                SkinManager.setBackgroundResource(this.e.h, R.drawable.icon_chat_group_enter_see_more);
            }
        }
    }

    public void z3(@StringRes int i2, boolean z) {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048635, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) != null) || (activity = getActivity()) == null) {
            return;
        }
        new BdTopToast(activity).setContent(activity.getString(i2)).setIcon(z).show((ViewGroup) activity.findViewById(16908290));
    }

    public final void e3(String str, boolean z, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{str, Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
            ks5.c(new g(this, str), new h(this, z, j2));
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (i2 == this.mSkinType) {
                return;
            }
            this.mSkinType = i2;
            sm8 sm8Var = this.E;
            if (sm8Var != null) {
                sm8Var.e(i2);
            }
            this.e.c.setCardBackgroundColor(SkinManager.getColor(R.color.CAM_X0207));
            SkinManager.setImageResource(this.e.w, R.drawable.chat_group_mask_guide);
            v3();
            EMManager.from(this.e.g).setBackGroundColor(R.color.CAM_X0334);
            SkinManager.setBackgroundColor(this.e.j, R.color.transparent);
            if (this.mSkinType == 0) {
                this.e.c.setElevation(UtilHelper.getDimenPixelSize(R.dimen.tbds21));
            }
            EMManager.from(this.e.t).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X08);
            EMManager.from(this.e.u).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0107).setTextSize(R.dimen.T_X09);
            EMManager.from(this.e.i).setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08);
        }
    }

    public final void s3(int i2, @NonNull ChatRoomInfo chatRoomInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048626, this, i2, chatRoomInfo) != null) || this.e.b.getChildCount() - 1 != i2) {
            return;
        }
        this.C = chatRoomInfo.getUnreadNum();
        this.x = chatRoomInfo.getRoomId();
        ym8 ym8Var = this.g;
        if (ym8Var != null) {
            Object item = ym8Var.getItem(i2);
            if (item instanceof ChatRoomInfoData) {
                an8.d(chatRoomInfo, (ChatRoomInfoData) item);
                this.g.notifyDataSetChanged();
            }
        }
    }

    public final void w3(int i2, boolean z, int i3) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) && getPageContext() != null && (layoutParams = (LinearLayout.LayoutParams) this.e.h.getLayoutParams()) != null) {
            if (z && i3 > 0) {
                this.e.i.setVisibility(0);
                String format = String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0e57), Integer.valueOf(i3));
                String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0e58);
                TextView textView = this.e.i;
                if (i3 >= 99) {
                    format = string;
                }
                textView.setText(format);
                layoutParams.width = -2;
            } else {
                this.e.i.setVisibility(8);
                layoutParams.width = i2;
            }
            this.e.h.setLayoutParams(layoutParams);
        }
    }

    public final void y3(String str) {
        TbPageContext<BaseFragmentActivity> pageContext;
        int i2;
        String str2;
        TbSingleton.GroupChatDisturbText.TitleText canNotDisturb;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048634, this, str) != null) || (pageContext = getPageContext()) == null) {
            return;
        }
        SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
        String str3 = Y + str;
        boolean z = sharedPrefHelper.getBoolean(str3, true);
        if (z) {
            i2 = R.string.obfuscated_res_0x7f0f0a62;
        } else {
            i2 = R.string.obfuscated_res_0x7f0f0a63;
        }
        String string = pageContext.getString(i2);
        if (z) {
            str2 = pageContext.getString(R.string.obfuscated_res_0x7f0f0a61);
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
        pz4 pz4Var = new pz4(pageContext);
        pz4Var.j(false);
        pz4Var.i(str2, new String[]{string}, new c(this, sharedPrefHelper, str3, z, pz4Var));
        pz4Var.l();
    }
}

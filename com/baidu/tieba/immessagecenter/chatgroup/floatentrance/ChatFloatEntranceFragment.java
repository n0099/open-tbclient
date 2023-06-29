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
import com.baidu.tieba.a98;
import com.baidu.tieba.ae8;
import com.baidu.tieba.ap5;
import com.baidu.tieba.bh5;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.jca;
import com.baidu.tieba.kj8;
import com.baidu.tieba.ne8;
import com.baidu.tieba.p55;
import com.baidu.tieba.pf8;
import com.baidu.tieba.qf8;
import com.baidu.tieba.r55;
import com.baidu.tieba.r95;
import com.baidu.tieba.s75;
import com.baidu.tieba.tf8;
import com.baidu.tieba.uf8;
import com.baidu.tieba.vf8;
import com.baidu.tieba.vg;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.wf8;
import com.baidu.tieba.xf8;
import com.baidu.tieba.xi;
import com.baidu.tieba.xo5;
import com.baidu.tieba.yf8;
import com.baidu.tieba.yg;
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
public class ChatFloatEntranceFragment extends BaseFragment implements xo5.b, pf8 {
    public static /* synthetic */ Interceptable $ic;
    public static final String R;
    public static long S;

    /* renamed from: T  reason: collision with root package name */
    public static final int f1121T;
    public static final int U;
    public static final int V;
    public static int W;
    public static int X;
    public transient /* synthetic */ FieldHolder $fh;
    public ap5 A;
    @Nullable
    public ae8 B;
    public boolean C;
    public long D;
    public boolean E;
    public boolean F;
    public final CustomMessageListener G;
    public final CustomMessageListener H;
    @NonNull
    public ae8.c I;
    public final CustomMessageListener J;
    public final CustomMessageListener K;
    public List<Map<String, Long>> L;
    public final Runnable M;
    public final uf8 N;
    public final vf8 O;
    public final wf8.d P;
    public Runnable Q;
    public s a;
    public boolean b;
    public wf8 c;
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
    public String u;
    public List<ChatRoomInfoData> v;
    public Map<Long, Integer> w;
    public int x;
    @Nullable
    public tf8 y;
    public qf8 z;

    @Override // com.baidu.tieba.xo5.b
    public void U0(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, motionEvent) == null) {
        }
    }

    @Override // com.baidu.tieba.xo5.b
    public Fragment e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this : (Fragment) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        /* loaded from: classes6.dex */
        public class a implements PollingModel.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

            public a(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oVar;
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
                    if (this.a.a.n > 0 && !this.a.a.E) {
                        yg.a().removeCallbacks(this.a.a.M);
                        yg.a().post(this.a.a.M);
                    }
                }
            }
        }

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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                this.a.m = String.valueOf(System.currentTimeMillis());
                long Y2 = this.a.Y2();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!ListUtils.isEmpty(this.a.q) || this.a.r <= 0) {
                    if (!TextUtils.isEmpty(currentAccount) && !this.a.E && this.a.n > 0) {
                        this.a.l.A0(PollingModel.CHATROOM_FRS, this.a.o, 0L, this.a.m, kj8.a(new a98().e(currentAccount, String.valueOf(this.a.n))));
                        this.a.E = true;
                    } else if (ListUtils.isEmpty(this.a.q)) {
                        if (!this.a.E && !TextUtils.isEmpty(currentAccount)) {
                            this.a.l.L0(new a(this));
                        }
                        this.a.l.A0(PollingModel.CHATROOM_FRS, this.a.o, 0L, this.a.m, null);
                    } else if (!TextUtils.isEmpty(currentAccount) && this.a.n > 0) {
                        this.a.l.A0(PollingModel.CHATROOM_FRS, null, Y2, this.a.m, kj8.a(new a98().e(currentAccount, String.valueOf(this.a.n))));
                    } else {
                        this.a.l.A0(PollingModel.CHATROOM_FRS, null, Y2, this.a.m, null);
                    }
                    yg.a().postDelayed(this.a.M, ChatFloatEntranceFragment.S);
                    return;
                }
                this.a.T2(false);
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
                chatFloatEntranceFragment.U2(chatFloatEntranceFragment.o);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements wf8.e {
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

        @Override // com.baidu.tieba.wf8.e
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
    public class c implements r55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r95 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ p55 d;
        public final /* synthetic */ ChatFloatEntranceFragment e;

        public c(ChatFloatEntranceFragment chatFloatEntranceFragment, r95 r95Var, String str, boolean z, p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment, r95Var, str, Boolean.valueOf(z), p55Var};
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
            this.a = r95Var;
            this.b = str;
            this.c = z;
            this.d = p55Var;
        }

        @Override // com.baidu.tieba.r55.f
        public void M0(r55 r55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIL(1048576, this, r55Var, i, view2) != null) || !(view2 instanceof TextView)) {
                return;
            }
            this.a.A(this.b, !this.c);
            this.e.V2(R.string.obfuscated_res_0x7f0f0a3f, true);
            xf8.c(this.e.n, this.c);
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
            this.a.D2();
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
                chatFloatEntranceFragment.j = xi.m(chatFloatEntranceFragment.getContext(), UtilHelper.isFoldScreen()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
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
    public class f implements wf8.c {
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

        @Override // com.baidu.tieba.wf8.c
        public void a(View view2, ChatRoomInfoData chatRoomInfoData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, view2, chatRoomInfoData) != null) || chatRoomInfoData == null) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.a.v2(25075);
            }
            this.a.t = chatRoomInfoData.getRoomId();
            this.a.u = chatRoomInfoData.getJumpUrl();
            this.a.y2();
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.d = 1;
                qf8 qf8Var = this.a.z;
                if (qf8Var != null) {
                    qf8Var.b();
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
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        public h(ChatFloatEntranceFragment chatFloatEntranceFragment) {
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
                    jca.a(this.a.a.c, 10L, this.a.a.k, 10L);
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
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(ChatFloatEntranceFragment chatFloatEntranceFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && !customResponsedMessage.hasError() && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if ("forum_follow".equals(str) || "forum_sign".equals(str)) {
                    this.a.d();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements ae8.c {
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

        @Override // com.baidu.tieba.ae8.c
        public void a(List list, int i) {
            ChatFloatEntranceFragment chatFloatEntranceFragment;
            qf8 qf8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) && (qf8Var = (chatFloatEntranceFragment = this.a).z) != null) {
                qf8Var.f(chatFloatEntranceFragment.q, this.a.n, list, i);
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
            bh5 bh5Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.hasError() || !this.a.isResumed()) {
                return;
            }
            if ((customResponsedMessage.getData() instanceof bh5) && (bh5Var = (bh5) customResponsedMessage.getData()) != null && bh5Var.a()) {
                this.a.t = bh5Var.b();
            }
            if (TbadkCoreApplication.isLogin() && this.a.t > 0 && !this.a.H2()) {
                if (this.a.A != null) {
                    this.a.A.a(this.a.getPageContext(), Collections.unmodifiableList(this.a.q), this.a.n, this.a.o, this.a.t, this.a.p, this.a.getActivity().getSupportFragmentManager(), ne8.b, "dialog");
                }
                this.a.t = -1L;
            }
            this.a.F = false;
            if (this.a.y == null || this.a.y.E(this.a.C2())) {
                return;
            }
            this.a.T2(true);
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(ChatFloatEntranceFragment chatFloatEntranceFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !customResponsedMessage.hasError() && this.a.I2() && this.a.y != null) {
                this.a.y.p();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements uf8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

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

        @Override // com.baidu.tieba.uf8
        public void a(@NonNull ChatRoomInfo chatRoomInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, chatRoomInfo) != null) || chatRoomInfo.getNewMessage() == null || this.a.F) {
                return;
            }
            this.a.N2(0, chatRoomInfo);
        }
    }

    /* loaded from: classes6.dex */
    public class q implements vf8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        @Override // com.baidu.tieba.vf8
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
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

        @Override // com.baidu.tieba.vf8
        public void b(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) || this.a.y == null || !this.a.y.E(j)) {
                return;
            }
            this.a.T2(false);
        }
    }

    /* loaded from: classes6.dex */
    public class r implements wf8.d {
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

        @Override // com.baidu.tieba.wf8.d
        public void a(@NonNull View view2, @NonNull ChatRoomInfoData chatRoomInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, chatRoomInfoData) == null) {
                this.a.t = chatRoomInfoData.getRoomId();
                if (chatRoomInfoData.getChatroomInfoBasicData() != null) {
                    int btnType = chatRoomInfoData.getChatroomInfoBasicData().getBtnType();
                    this.a.x = vg.e(chatRoomInfoData.getChatroomInfoBasicData().getUnreadNum(), 0);
                    ChatFloatEntranceFragment chatFloatEntranceFragment = this.a;
                    chatFloatEntranceFragment.z2(btnType, chatFloatEntranceFragment.x);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class s {
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

        public s() {
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

        public static s a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                s sVar = new s();
                sVar.a = view2;
                sVar.c = (CardViewLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906b9);
                sVar.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906ba);
                sVar.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906c1);
                sVar.g = view2.findViewById(R.id.obfuscated_res_0x7f0914bc);
                sVar.b = (BaseAdapterViewFlipper) view2.findViewById(R.id.obfuscated_res_0x7f0906bb);
                sVar.h = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906b6);
                sVar.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906b7);
                sVar.f = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906c4);
                sVar.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906af);
                sVar.l = (RoundRelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906b2);
                sVar.m = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b34);
                sVar.n = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906b0);
                sVar.j = view2.findViewById(R.id.obfuscated_res_0x7f09213c);
                sVar.o = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906ae);
                sVar.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902e0);
                sVar.q = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0902e1);
                sVar.r = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0924bd);
                sVar.s = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0924be);
                sVar.v = (ConstraintLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906bd);
                sVar.w = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906bc);
                sVar.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906bf);
                sVar.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906be);
                return sVar;
            }
            return (s) invokeL.objValue;
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
        R = r95.t(PollingModel.SP_KEY_GROUP_CHAT_DISTURB_SETTING);
        S = 5000L;
        f1121T = UtilHelper.getDimenPixelSize(R.dimen.tbds130);
        U = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        V = UtilHelper.getDimenPixelSize(R.dimen.tbds170);
        W = 0;
        X = 1;
    }

    @Override // com.baidu.tieba.pf8
    public void B1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.B != null && this.n > 0 && System.currentTimeMillis() - this.D > 5000) {
            if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST) instanceof TbHttpMessageTask) {
                ((TbHttpMessageTask) MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST)).setIsNeedDialog(false);
            }
            this.B.E(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.n));
            this.D = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.xo5.b
    public boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (G2() || !this.b) {
                return false;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921788));
            this.a.v.setVisibility(0);
            yg.a().postDelayed(this.Q, 5000L);
            r95.p().A("key_chat_group_guide_show", true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            L2();
            ae8 ae8Var = this.B;
            if (ae8Var != null) {
                ae8Var.t(true);
            }
            if (this.y != null && I2()) {
                this.y.F(C2());
            }
            xf8.b("c15073", this.n, this.o, String.valueOf(this.t), 1, "1");
            xf8.b(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK, this.n, this.o, String.valueOf(this.t), 1, null);
            D2();
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
        this.w = new HashMap();
        this.C = false;
        this.E = false;
        this.F = false;
        this.G = new j(this, 2921769);
        this.H = new k(this, 2921768);
        this.I = new l(this);
        this.J = new m(this, 2921771);
        this.K = new n(this, 2003023);
        this.L = null;
        this.M = new o(this);
        this.N = new p(this);
        this.O = new q(this);
        this.P = new r(this);
        this.Q = new d(this);
        this.o = str;
        this.A = ap5Var;
    }

    @Override // com.baidu.tieba.xo5.b
    public void G0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.g = z;
        }
    }

    public void S2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048600, this, z) != null) || this.a.b.isFlipping()) {
            return;
        }
        this.a.b.setAutoStart(z);
        this.a.b.startFlipping();
    }

    public final void T2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            if (z) {
                yg.a().removeCallbacks(this.M);
                yg.a().post(this.M);
                return;
            }
            yg.a().removeCallbacks(this.M);
        }
    }

    @Override // com.baidu.tieba.xo5.b
    public void p1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.b = z;
        }
    }

    @Override // com.baidu.tieba.xo5.b
    public boolean v1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, str)) == null) {
            return String.valueOf(this.m).equals(str);
        }
        return invokeL.booleanValue;
    }

    public final void v2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getContext(), true, i2)));
        }
    }

    public final void D2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921789));
            this.a.v.setVisibility(8);
        }
    }

    public final void E2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            long loopChatroomFrequency = TbSingleton.getInstance().getLoopChatroomFrequency() * 1000;
            S = loopChatroomFrequency;
            if (loopChatroomFrequency <= 0) {
                S = 5000L;
            }
        }
    }

    public final boolean G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return r95.p().l("key_chat_group_guide_show", false);
        }
        return invokeV.booleanValue;
    }

    public final boolean H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.r <= 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!ListUtils.isEmpty(this.q) && this.q.size() <= 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.c.getViewTreeObserver().addOnGlobalLayoutListener(new e(this));
        }
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.c.e(new f(this));
        }
    }

    @Override // com.baidu.tieba.xo5.b
    public boolean R() {
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

    @Override // com.baidu.tieba.xo5.b
    public void S0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && !this.e && this.d != 2) {
            this.d = 2;
            A2();
            qf8 qf8Var = this.z;
            if (qf8Var != null) {
                qf8Var.c();
            }
        }
    }

    @Override // com.baidu.tieba.xo5.b
    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && !this.e && this.d != 1) {
            this.d = 1;
            x2();
            P2();
            D2();
        }
    }

    @Override // com.baidu.tieba.xo5.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            onDestroyView();
            this.A = null;
        }
    }

    @Override // com.baidu.tieba.xo5.b
    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (this.d == 1 || this.a.c.getVisibility() != 0) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pf8
    public Context getViewContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return getContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            super.onPause();
            tf8 tf8Var = this.y;
            if (tf8Var != null) {
                tf8Var.q();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onResume();
            qf8 qf8Var = this.z;
            if (qf8Var != null) {
                qf8Var.g(this.q);
            }
        }
    }

    @Override // com.baidu.tieba.xo5.b
    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return !ListUtils.isEmpty(this.v);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xo5.b
    public void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            D2();
        }
    }

    @Override // com.baidu.tieba.pf8
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pf8
    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.n;
        }
        return invokeV.longValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048614, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 != 25075) {
                    if (i2 == 25076) {
                        M2();
                        return;
                    }
                    return;
                }
                y2();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048619, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0313, viewGroup, false);
            this.a = s.a(inflate);
            F2();
            this.z = new qf8(this.a, this);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.e) {
            return;
        }
        s sVar = this.a;
        jca.a(sVar.k, 10L, sVar.c, 10L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofInt(this.a.c, "width", f1121T, this.j), ObjectAnimator.ofInt(this.a.c, "height", f1121T, this.k), ObjectAnimator.ofInt(this.a.c, "marginRight", U, this.i));
        animatorSet.addListener(new i(this));
        animatorSet.setDuration(600L).start();
    }

    public void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.L == null) {
                this.L = new ArrayList();
            }
            this.L.clear();
            for (int i2 = 0; i2 < this.q.size(); i2++) {
                Long l2 = this.q.get(i2);
                HashMap hashMap = new HashMap();
                hashMap.put("room_id", l2);
                GroupChatRoomPojo c2 = a98.f().c(TbadkCoreApplication.getCurrentAccount(), l2.longValue());
                if (c2 != null) {
                    hashMap.put("msg_id", Long.valueOf(c2.getLatestMsgId()));
                } else {
                    hashMap.put("msg_id", 0L);
                }
                this.L.add(hashMap);
            }
            if (ListUtils.isEmpty(this.L)) {
                return;
            }
            TbSingleton.getInstance().setLoopMsgRoomMsgId(DataExt.toJson(this.L));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921764, Boolean.TRUE));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onDestroyView();
            yg.a().removeCallbacks(this.M);
            yg.a().removeCallbacks(this.Q);
            MessageManager.getInstance().unRegisterListener(this.H);
            MessageManager.getInstance().unRegisterListener(this.G);
            MessageManager.getInstance().unRegisterListener(this.J);
            MessageManager.getInstance().unRegisterListener(this.K);
            MessageManager.getInstance().unRegisterListener(wf8.f);
            this.c.f(null);
            ae8 ae8Var = this.B;
            if (ae8Var != null) {
                ae8Var.o();
            }
            tf8 tf8Var = this.y;
            if (tf8Var != null) {
                tf8Var.o();
            }
        }
    }

    public final void x2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048631, this) != null) || this.e) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.a.c, "width", this.j, f1121T);
        animatorSet.playTogether(ofInt, ObjectAnimator.ofInt(this.a.c, "height", this.k, f1121T), ObjectAnimator.ofInt(this.a.c, "marginRight", this.i, U));
        animatorSet.addListener(new g(this));
        ofInt.addUpdateListener(new h(this));
        animatorSet.setDuration(600L).start();
    }

    @Override // com.baidu.tieba.xo5.b
    public void C1(long j2, String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.p = z;
            if (StringUtils.isNull(this.o)) {
                this.o = str;
            }
            if (this.n == 0 && j2 > 0 && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && !this.E) {
                yg.a().removeCallbacks(this.M);
                yg.a().post(this.M);
            }
            this.n = j2;
            this.B = new ae8(getContext(), this.I, false);
        }
    }

    public final long C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!ListUtils.isEmpty(this.q) && ListUtils.getCount(this.q) > 0 && this.q.get(0) != null) {
                return this.q.get(0).longValue();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final void L2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && TbadkCoreApplication.isLogin() && getContext() != null && this.t > 0) {
            this.F = true;
            yo5.a().c(getContext(), 1, this.t);
        }
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && getContext() != null && this.f) {
            this.f = false;
            ap5 ap5Var = this.A;
            if (ap5Var != null) {
                ap5Var.a(getPageContext(), Collections.unmodifiableList(this.q), this.n, this.o, this.t, this.p, getActivity().getSupportFragmentManager(), ne8.a, "dialog");
            }
        }
    }

    public void O2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && !this.e && this.d != 1) {
            this.d = 1;
            s sVar = this.a;
            jca.a(sVar.c, 10L, sVar.k, 10L);
            qf8 qf8Var = this.z;
            if (qf8Var != null) {
                qf8Var.b();
            }
            P2();
            D2();
        }
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            SkinManager.setBackgroundResource(this.a.d, R.drawable.bg_chat_group_expend_gradual);
            SkinManager.setBackgroundResource(this.a.l, R.drawable.bg_chat_group_collapse_gradual);
            SkinManager.setImageResource(this.a.e, R.drawable.icon_entrance_left_expend);
            z2(3, this.x);
        }
    }

    public final long Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
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

    @Override // com.baidu.tieba.xo5.b
    public void F(ChatRoomEntranceData chatRoomEntranceData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, chatRoomEntranceData) == null) && chatRoomEntranceData != null) {
            if (!ListUtils.isEmpty(chatRoomEntranceData.getChatRoomInfoList()) || chatRoomEntranceData.getHotListOriginNum() > 0) {
                if (this.g) {
                    this.r = chatRoomEntranceData.getHotListOriginNum();
                }
                if (ListUtils.isEmpty(chatRoomEntranceData.getChatRoomInfoList()) && chatRoomEntranceData.getHotListOriginNum() > 0) {
                    O2();
                    return;
                }
                if (!ListUtils.isEmpty(chatRoomEntranceData.getHotRoomList())) {
                    this.q.clear();
                    this.q.addAll(chatRoomEntranceData.getHotRoomList());
                    W2(chatRoomEntranceData);
                }
                if (!this.C && this.B != null && this.n > 0) {
                    if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST) instanceof TbHttpMessageTask) {
                        ((TbHttpMessageTask) MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST)).setIsNeedDialog(false);
                    }
                    this.B.E(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.n));
                    this.C = true;
                }
                List<ChatRoomInfoData> chatRoomInfoList = chatRoomEntranceData.getChatRoomInfoList();
                this.v = chatRoomInfoList;
                this.c.d(chatRoomInfoList);
                if (this.a.b.getAdapter() == null) {
                    this.a.b.setAdapter(this.c);
                }
                if (this.y != null && I2() && !this.y.E(C2())) {
                    ChatRoomInfoData chatRoomInfoData = chatRoomEntranceData.getChatRoomInfoList().get(0);
                    int btnType = chatRoomInfoData.getChatroomInfoBasicData().getBtnType();
                    int e2 = vg.e(chatRoomInfoData.getChatroomInfoBasicData().getUnreadNum(), 0);
                    this.x = e2;
                    z2(btnType, e2);
                    this.c.notifyDataSetChanged();
                    this.y.p();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f0906b2) {
                if (TbadkCoreApplication.isLogin()) {
                    ap5 ap5Var = this.A;
                    if (ap5Var != null) {
                        ap5Var.a(getPageContext(), Collections.unmodifiableList(this.q), this.n, this.o, this.t, this.p, getActivity().getSupportFragmentManager(), ne8.a, "dialog");
                    }
                } else {
                    this.f = true;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) TbadkCoreApplication.getInst(), true)));
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f0906c4 && view2.getId() != R.id.obfuscated_res_0x7f0906b6) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                xf8.b("c15073", this.n, this.o, null, i2, "2");
                D2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0906b6) {
                ViewHelper.checkUpIsLogin(getPageContext().getPageActivity());
                L2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0906c4) {
                if (!TbadkCoreApplication.isLogin()) {
                    v2(25076);
                    return;
                }
                ap5 ap5Var2 = this.A;
                if (ap5Var2 != null) {
                    ap5Var2.a(getPageContext(), Collections.unmodifiableList(this.q), this.n, this.o, -1L, this.p, getActivity().getSupportFragmentManager(), ne8.a, "dialog");
                }
            }
        }
    }

    public final void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.f.setOnClickListener(this);
            this.a.h.setOnClickListener(this);
            this.a.d.setOnClickListener(this);
            a aVar = new a(this);
            this.a.f.setOnLongClickListener(aVar);
            this.a.h.setOnLongClickListener(aVar);
            this.a.l.setOnLongClickListener(aVar);
            this.a.c.setRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            s75.d(this.a.c).o(R.string.J_X06);
            this.a.g.setAlpha(0.08f);
            wf8 wf8Var = new wf8(getPageContext());
            this.c = wf8Var;
            wf8Var.g(new b(this, aVar));
            this.a.b.setFlipInterval(5500);
            this.a.b.startFlipping();
            this.a.b.setAnimateFirstView(false);
            w2();
            K2();
            this.a.t.setText(R.string.chat_group_guide_title);
            this.a.u.setText(R.string.chat_group_guide_content);
            this.c.f(this.P);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            J2();
        }
    }

    public void P2() {
        Date date;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
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
                    B2();
                    X2(W);
                } else if (i2 == X) {
                    B2();
                    X2(W);
                }
            }
        }
    }

    public final void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds170);
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.a.b, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, dimenPixelSize, 0.0f), PropertyValuesHolder.ofFloat(View.ALPHA, 0.0f, 1.0f)).setDuration(800L);
            duration.setInterpolator(new AccelerateDecelerateInterpolator());
            this.a.b.setInAnimation(duration);
            ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(this.a.b, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 0.0f, -dimenPixelSize), PropertyValuesHolder.ofFloat(View.ALPHA, 1.0f, 0.0f)).setDuration(800L);
            duration2.setInterpolator(new AccelerateDecelerateInterpolator());
            this.a.b.setOutAnimation(duration2);
        }
    }

    public final void N2(int i2, @NonNull ChatRoomInfo chatRoomInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048593, this, i2, chatRoomInfo) != null) || this.a.b.getChildCount() - 1 != i2) {
            return;
        }
        this.x = chatRoomInfo.getUnreadNum();
        this.t = chatRoomInfo.getRoomId();
        wf8 wf8Var = this.c;
        if (wf8Var != null) {
            Object item = wf8Var.getItem(i2);
            if (item instanceof ChatRoomInfoData) {
                yf8.d(chatRoomInfo, (ChatRoomInfoData) item);
                this.c.notifyDataSetChanged();
            }
        }
    }

    public void V2(@StringRes int i2, boolean z) {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) != null) || (activity = getActivity()) == null) {
            return;
        }
        BdTopToast bdTopToast = new BdTopToast(activity);
        bdTopToast.g(activity.getString(i2));
        bdTopToast.h(z);
        bdTopToast.i((ViewGroup) activity.findViewById(16908290));
    }

    public final void R2(int i2, boolean z, int i3) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) && getPageContext() != null && (layoutParams = (LinearLayout.LayoutParams) this.a.h.getLayoutParams()) != null) {
            if (z && i3 > 0) {
                this.a.i.setVisibility(0);
                String format = String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0e17), Integer.valueOf(i3));
                String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0e18);
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

    public final void U2(String str) {
        TbPageContext<BaseFragmentActivity> pageContext;
        int i2;
        String str2;
        TbSingleton.GroupChatDisturbText.TitleText canNotDisturb;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048603, this, str) != null) || (pageContext = getPageContext()) == null) {
            return;
        }
        r95 p2 = r95.p();
        String str3 = R + str;
        boolean l2 = p2.l(str3, true);
        if (l2) {
            i2 = R.string.obfuscated_res_0x7f0f0a3d;
        } else {
            i2 = R.string.obfuscated_res_0x7f0f0a3e;
        }
        String string = pageContext.getString(i2);
        if (l2) {
            str2 = pageContext.getString(R.string.obfuscated_res_0x7f0f0a3c);
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
        p55 p55Var = new p55(pageContext);
        p55Var.j(false);
        p55Var.i(str2, new String[]{string}, new c(this, p2, str3, l2, p55Var));
        p55Var.l();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
            super.onCreate(bundle);
            E2();
            if (this.l == null) {
                this.l = new PollingModel(getPageContext(), getUniqueId());
            }
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                this.y = new tf8(getPageContext().getPageActivity(), this.N);
            }
            yg.a().removeCallbacks(this.M);
            yg.a().post(this.M);
            registerListener(this.H);
            registerListener(this.G);
            registerListener(this.J);
            registerListener(this.K);
        }
    }

    public final void W2(@NonNull ChatRoomEntranceData chatRoomEntranceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, chatRoomEntranceData) == null) {
            if (!I2()) {
                S2(true);
                return;
            }
            if (I2()) {
                this.a.b.stopFlipping();
            }
            if (this.y != null && I2() && !this.y.C()) {
                this.y.D(chatRoomEntranceData.getChatRoomInfoList(), C2(), this.O);
            }
        }
    }

    public void X2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            if (this.w == null) {
                this.w = new HashMap();
            } else {
                this.w = TbSingleton.getInstance().getHasClickRedPot();
            }
            this.w.put(Long.valueOf(this.n), Integer.valueOf(i2));
            TbSingleton.getInstance().setHasClickRedPot(this.w);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            int m2 = xi.m(getContext(), UtilHelper.isFoldScreen()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
            this.j = m2;
            if (m2 != this.a.c.getWidth()) {
                this.a.c.setWidth(this.j);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048615, this, i2) != null) || i2 == this.mSkinType) {
            return;
        }
        this.mSkinType = i2;
        qf8 qf8Var = this.z;
        if (qf8Var != null) {
            qf8Var.e(i2);
        }
        this.a.c.setCardBackgroundColor(SkinManager.getColor(R.color.CAM_X0207));
        SkinManager.setImageResource(this.a.w, R.drawable.chat_group_mask_guide);
        Q2();
        s75.d(this.a.g).f(R.color.CAM_X0334);
        SkinManager.setBackgroundColor(this.a.j, R.color.transparent);
        if (this.mSkinType == 0) {
            this.a.c.setElevation(UtilHelper.getDimenPixelSize(R.dimen.tbds21));
        }
        s75 d2 = s75.d(this.a.t);
        d2.D(R.string.F_X02);
        d2.x(R.color.CAM_X0105);
        d2.C(R.dimen.T_X08);
        s75 d3 = s75.d(this.a.u);
        d3.D(R.string.F_X01);
        d3.x(R.color.CAM_X0107);
        d3.C(R.dimen.T_X09);
        s75 d4 = s75.d(this.a.i);
        d4.x(R.color.CAM_X0101);
        d4.D(R.string.F_X01);
        d4.C(R.dimen.T_X08);
    }

    public final void z2(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048633, this, i2, i3) == null) {
            if (i2 == 1) {
                R2(UtilHelper.getDimenPixelSize(R.dimen.tbds172), false, 0);
                SkinManager.setBackgroundResource(this.a.h, R.drawable.icon_chat_group_experience);
            } else if (i3 > 0) {
                R2(UtilHelper.getDimenPixelSize(R.dimen.tbds172), true, i3);
                SkinManager.setBackgroundResource(this.a.h, R.drawable.icon_chat_group_new_msg);
            } else {
                R2(UtilHelper.getDimenPixelSize(R.dimen.tbds198), false, 0);
                SkinManager.setBackgroundResource(this.a.h, R.drawable.icon_chat_group_enter_see_more);
            }
        }
    }
}

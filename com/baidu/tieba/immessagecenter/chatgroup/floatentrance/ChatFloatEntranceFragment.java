package com.baidu.tieba.immessagecenter.chatgroup.floatentrance;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
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
import com.baidu.tieba.e88;
import com.baidu.tieba.g6a;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.jh8;
import com.baidu.tieba.l55;
import com.baidu.tieba.n55;
import com.baidu.tieba.n95;
import com.baidu.tieba.o75;
import com.baidu.tieba.od8;
import com.baidu.tieba.oo5;
import com.baidu.tieba.pd8;
import com.baidu.tieba.po5;
import com.baidu.tieba.qc8;
import com.baidu.tieba.ro5;
import com.baidu.tieba.sd8;
import com.baidu.tieba.td8;
import com.baidu.tieba.tg;
import com.baidu.tieba.tg5;
import com.baidu.tieba.ud8;
import com.baidu.tieba.vd8;
import com.baidu.tieba.vi;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.wd8;
import com.baidu.tieba.wg;
import com.baidu.tieba.xd8;
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
public class ChatFloatEntranceFragment extends BaseFragment implements oo5.b, od8 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: T  reason: collision with root package name */
    public static final String f1126T;
    public static long U;
    public static final int V;
    public static final int W;
    public static final int X;
    public static int Y;
    public static int Z;
    public transient /* synthetic */ FieldHolder $fh;
    public ro5 A;
    @Nullable
    public qc8 B;
    public boolean C;
    public long D;
    public boolean E;
    public boolean F;
    public boolean G;
    public final CustomMessageListener H;
    public final CustomMessageListener I;
    @NonNull
    public qc8.c J;
    public final CustomMessageListener K;
    public final CustomMessageListener L;
    public final CustomMessageListener M;
    public List<Map<String, Long>> N;
    public final Runnable O;
    public final td8 P;
    public final ud8 Q;
    public final vd8.d R;
    public Runnable S;
    public t a;
    public boolean b;
    public vd8 c;
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
    public sd8 y;
    public pd8 z;

    @Override // com.baidu.tieba.oo5.b
    public void U0(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, motionEvent) == null) {
        }
    }

    @Override // com.baidu.tieba.oo5.b
    public Fragment e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this : (Fragment) invokeV.objValue;
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
                        wg.a().removeCallbacks(this.a.a.O);
                        wg.a().post(this.a.a.O);
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
                long X2 = this.a.X2();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!ListUtils.isEmpty(this.a.q) || this.a.r <= 0) {
                    if (!TextUtils.isEmpty(currentAccount) && !this.a.F && this.a.n > 0) {
                        this.a.l.A0(PollingModel.CHATROOM_FRS, this.a.o, 0L, this.a.m, jh8.a(new e88().e(currentAccount, String.valueOf(this.a.n))));
                        this.a.F = true;
                    } else if (ListUtils.isEmpty(this.a.q)) {
                        if (!this.a.F && !TextUtils.isEmpty(currentAccount)) {
                            this.a.l.L0(new a(this));
                        }
                        this.a.l.A0(PollingModel.CHATROOM_FRS, this.a.o, 0L, this.a.m, null);
                    } else if (!TextUtils.isEmpty(currentAccount) && this.a.n > 0) {
                        this.a.l.A0(PollingModel.CHATROOM_FRS, null, X2, this.a.m, jh8.a(new e88().e(currentAccount, String.valueOf(this.a.n))));
                    } else {
                        this.a.l.A0(PollingModel.CHATROOM_FRS, null, X2, this.a.m, null);
                    }
                    wg.a().postDelayed(this.a.O, ChatFloatEntranceFragment.U);
                    return;
                }
                this.a.S2(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements vd8.d {
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

        @Override // com.baidu.tieba.vd8.d
        public void a(@NonNull View view2, @NonNull ChatRoomInfoData chatRoomInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, chatRoomInfoData) == null) {
                this.a.t = chatRoomInfoData.getRoomId();
                if (chatRoomInfoData.getChatroomInfoBasicData() != null) {
                    int btnType = chatRoomInfoData.getChatroomInfoBasicData().getBtnType();
                    this.a.x = tg.e(chatRoomInfoData.getChatroomInfoBasicData().getUnreadNum(), 0);
                    ChatFloatEntranceFragment chatFloatEntranceFragment = this.a;
                    chatFloatEntranceFragment.y2(btnType, chatFloatEntranceFragment.x);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                ChatFloatEntranceFragment chatFloatEntranceFragment = this.a;
                chatFloatEntranceFragment.T2(chatFloatEntranceFragment.o);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements vd8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnLongClickListener a;
        public final /* synthetic */ ChatFloatEntranceFragment b;

        public c(ChatFloatEntranceFragment chatFloatEntranceFragment, View.OnLongClickListener onLongClickListener) {
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

        @Override // com.baidu.tieba.vd8.e
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
    public class d implements n55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n95 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ l55 d;
        public final /* synthetic */ ChatFloatEntranceFragment e;

        public d(ChatFloatEntranceFragment chatFloatEntranceFragment, n95 n95Var, String str, boolean z, l55 l55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment, n95Var, str, Boolean.valueOf(z), l55Var};
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
            this.a = n95Var;
            this.b = str;
            this.c = z;
            this.d = l55Var;
        }

        @Override // com.baidu.tieba.n55.f
        public void M0(n55 n55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIL(1048576, this, n55Var, i, view2) != null) || !(view2 instanceof TextView)) {
                return;
            }
            this.a.w(this.b, !this.c);
            this.e.U2(R.string.obfuscated_res_0x7f0f0a38, true);
            wd8.c(this.e.n, this.c);
            this.d.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.C2();
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ViewTreeObserver.OnGlobalLayoutListener {
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

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ChatFloatEntranceFragment chatFloatEntranceFragment = this.a;
                chatFloatEntranceFragment.j = vi.m(chatFloatEntranceFragment.getContext(), UtilHelper.isFoldScreen()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
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
    public class g implements vd8.c {
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

        @Override // com.baidu.tieba.vd8.c
        public void a(View view2, ChatRoomInfoData chatRoomInfoData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, view2, chatRoomInfoData) != null) || chatRoomInfoData == null) {
                return;
            }
            ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity());
            this.a.t = chatRoomInfoData.getRoomId();
            this.a.u = chatRoomInfoData.getJumpUrl();
            this.a.K2();
            if (this.a.B != null) {
                this.a.B.n(true);
            }
            if (this.a.y != null && this.a.H2()) {
                this.a.y.z(this.a.B2());
            }
            wd8.b("c15073", this.a.n, this.a.o, String.valueOf(this.a.t), 1, "1");
            wd8.b(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK, this.a.n, this.a.o, String.valueOf(this.a.t), 1, null);
            this.a.C2();
        }
    }

    /* loaded from: classes6.dex */
    public class h extends AnimatorListenerAdapter {
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

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.e = false;
                this.a.d = 1;
                pd8 pd8Var = this.a.z;
                if (pd8Var != null) {
                    pd8Var.b();
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
    public class i implements ValueAnimator.AnimatorUpdateListener {
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

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && (valueAnimator.getAnimatedValue() instanceof Integer) && ((Integer) valueAnimator.getAnimatedValue()).intValue() <= ChatFloatEntranceFragment.X && this.a.a.f.getVisibility() == 0) {
                this.a.a.f.setVisibility(4);
                if (this.a.a.k.getVisibility() != 0) {
                    g6a.a(this.a.a.c, 10L, this.a.a.k, 10L);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends AnimatorListenerAdapter {
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
    public class m implements qc8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        public m(ChatFloatEntranceFragment chatFloatEntranceFragment) {
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

        @Override // com.baidu.tieba.qc8.c
        public void a(List list, int i) {
            ChatFloatEntranceFragment chatFloatEntranceFragment;
            pd8 pd8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) && (pd8Var = (chatFloatEntranceFragment = this.a).z) != null) {
                pd8Var.f(chatFloatEntranceFragment.q, this.a.n, list, i);
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !customResponsedMessage.hasError()) {
                this.a.onUserChanged(TbadkCoreApplication.isLogin());
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
            tg5 tg5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !customResponsedMessage.hasError()) {
                if ((customResponsedMessage.getData() instanceof tg5) && (tg5Var = (tg5) customResponsedMessage.getData()) != null && tg5Var.a()) {
                    this.a.t = tg5Var.b();
                }
                if (TbadkCoreApplication.isLogin() && this.a.t > 0 && !this.a.G2()) {
                    if (this.a.A != null) {
                        this.a.A.a(this.a.getPageContext(), Collections.unmodifiableList(this.a.q), this.a.n, this.a.o, this.a.t, this.a.p, this.a.E);
                    }
                    this.a.t = -1L;
                }
                this.a.G = false;
                if (this.a.y == null || this.a.y.y(this.a.B2())) {
                    return;
                }
                this.a.S2(true);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !customResponsedMessage.hasError() && this.a.H2() && this.a.y != null) {
                this.a.y.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements td8 {
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

        @Override // com.baidu.tieba.td8
        public void a(@NonNull ChatRoomInfo chatRoomInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, chatRoomInfo) != null) || chatRoomInfo.getNewMessage() == null || this.a.G) {
                return;
            }
            this.a.M2(0, chatRoomInfo);
        }
    }

    /* loaded from: classes6.dex */
    public class s implements ud8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        @Override // com.baidu.tieba.ud8
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

        @Override // com.baidu.tieba.ud8
        public void b(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) || this.a.y == null || !this.a.y.y(j)) {
                return;
            }
            this.a.S2(false);
        }
    }

    /* loaded from: classes6.dex */
    public static class t {
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

        public t() {
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

        public static t a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                t tVar = new t();
                tVar.a = view2;
                tVar.c = (CardViewLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906b5);
                tVar.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906b6);
                tVar.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906bd);
                tVar.g = view2.findViewById(R.id.obfuscated_res_0x7f0914a6);
                tVar.b = (BaseAdapterViewFlipper) view2.findViewById(R.id.obfuscated_res_0x7f0906b7);
                tVar.h = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906b2);
                tVar.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906b3);
                tVar.f = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906c0);
                tVar.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906ab);
                tVar.l = (RoundRelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906ae);
                tVar.m = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b2c);
                tVar.n = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906ac);
                tVar.j = view2.findViewById(R.id.obfuscated_res_0x7f0920d2);
                tVar.o = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906aa);
                tVar.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902e3);
                tVar.q = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0902e4);
                tVar.r = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092452);
                tVar.s = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092453);
                tVar.v = (ConstraintLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906b9);
                tVar.w = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906b8);
                tVar.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906bb);
                tVar.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906ba);
                return tVar;
            }
            return (t) invokeL.objValue;
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
        f1126T = n95.q(PollingModel.SP_KEY_GROUP_CHAT_DISTURB_SETTING);
        U = 5000L;
        V = UtilHelper.getDimenPixelSize(R.dimen.tbds130);
        W = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        X = UtilHelper.getDimenPixelSize(R.dimen.tbds170);
        Y = 0;
        Z = 1;
    }

    @Override // com.baidu.tieba.oo5.b
    public boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (F2() || !this.b) {
                return false;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921788));
            this.a.v.setVisibility(0);
            wg.a().postDelayed(this.S, 5000L);
            n95.m().w("key_chat_group_guide_show", true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public ChatFloatEntranceFragment(String str, ro5 ro5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, ro5Var};
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
        this.F = false;
        this.G = false;
        this.H = new k(this, 2921769);
        this.I = new l(this, 2921768);
        this.J = new m(this);
        this.K = new n(this, 2921410);
        this.L = new o(this, 2921771);
        this.M = new p(this, 2003023);
        this.N = null;
        this.O = new q(this);
        this.P = new r(this);
        this.Q = new s(this);
        this.R = new a(this);
        this.S = new e(this);
        this.o = str;
        this.A = ro5Var;
    }

    @Override // com.baidu.tieba.oo5.b
    public void G0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.g = z;
        }
    }

    public void R2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048598, this, z) != null) || this.a.b.isFlipping()) {
            return;
        }
        this.a.b.setAutoStart(z);
        this.a.b.startFlipping();
    }

    public final void S2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            if (z) {
                wg.a().removeCallbacks(this.O);
                wg.a().post(this.O);
                return;
            }
            wg.a().removeCallbacks(this.O);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            super.onUserChanged(z);
            K2();
            L2();
        }
    }

    @Override // com.baidu.tieba.oo5.b
    public void p1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.b = z;
        }
    }

    @Override // com.baidu.tieba.oo5.b
    public boolean v1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, str)) == null) {
            return String.valueOf(this.m).equals(str);
        }
        return invokeL.booleanValue;
    }

    public final void C2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921789));
            this.a.v.setVisibility(8);
        }
    }

    public final void D2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long loopChatroomFrequency = TbSingleton.getInstance().getLoopChatroomFrequency() * 1000;
            U = loopChatroomFrequency;
            if (loopChatroomFrequency <= 0) {
                U = 5000L;
            }
        }
    }

    public final boolean F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return n95.m().i("key_chat_group_guide_show", false);
        }
        return invokeV.booleanValue;
    }

    public final boolean G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.r <= 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!ListUtils.isEmpty(this.q) && this.q.size() <= 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.c.getViewTreeObserver().addOnGlobalLayoutListener(new f(this));
        }
    }

    public final void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.c.e(new g(this));
        }
    }

    @Override // com.baidu.tieba.oo5.b
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

    @Override // com.baidu.tieba.oo5.b
    public void S0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && !this.e && this.d != 2) {
            this.d = 2;
            z2();
            pd8 pd8Var = this.z;
            if (pd8Var != null) {
                pd8Var.c();
            }
        }
    }

    @Override // com.baidu.tieba.oo5.b
    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && !this.e && this.d != 1) {
            this.d = 1;
            x2();
            O2();
            C2();
        }
    }

    @Override // com.baidu.tieba.oo5.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            onDestroyView();
            this.A = null;
        }
    }

    @Override // com.baidu.tieba.oo5.b
    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (this.d == 1 || this.a.c.getVisibility() != 0) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.od8
    public Context getViewContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return getContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onPause();
            sd8 sd8Var = this.y;
            if (sd8Var != null) {
                sd8Var.l();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onResume();
            pd8 pd8Var = this.z;
            if (pd8Var != null) {
                pd8Var.g(this.q);
            }
        }
    }

    @Override // com.baidu.tieba.oo5.b
    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return !ListUtils.isEmpty(this.v);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.oo5.b
    public void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            C2();
        }
    }

    @Override // com.baidu.tieba.od8
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.od8
    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.n;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048617, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0312, viewGroup, false);
            this.a = t.a(inflate);
            E2();
            this.z = new pd8(this.a, this);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    public void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.N == null) {
                this.N = new ArrayList();
            }
            this.N.clear();
            for (int i2 = 0; i2 < this.q.size(); i2++) {
                Long l2 = this.q.get(i2);
                HashMap hashMap = new HashMap();
                hashMap.put("room_id", l2);
                GroupChatRoomPojo c2 = e88.f().c(TbadkCoreApplication.getCurrentAccount(), l2.longValue());
                if (c2 != null) {
                    hashMap.put("msg_id", Long.valueOf(c2.getLatestMsgId()));
                } else {
                    hashMap.put("msg_id", 0L);
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onDestroyView();
            wg.a().removeCallbacks(this.O);
            wg.a().removeCallbacks(this.S);
            MessageManager.getInstance().unRegisterListener(this.K);
            MessageManager.getInstance().unRegisterListener(this.I);
            MessageManager.getInstance().unRegisterListener(this.H);
            MessageManager.getInstance().unRegisterListener(this.L);
            MessageManager.getInstance().unRegisterListener(this.M);
            MessageManager.getInstance().unRegisterListener(vd8.f);
            this.c.f(null);
            qc8 qc8Var = this.B;
            if (qc8Var != null) {
                qc8Var.j();
            }
            sd8 sd8Var = this.y;
            if (sd8Var != null) {
                sd8Var.j();
            }
        }
    }

    public final void x2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048629, this) != null) || this.e) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.a.c, "width", this.j, V);
        animatorSet.playTogether(ofInt, ObjectAnimator.ofInt(this.a.c, "height", this.k, V), ObjectAnimator.ofInt(this.a.c, "marginRight", this.i, W));
        animatorSet.addListener(new h(this));
        ofInt.addUpdateListener(new i(this));
        animatorSet.setDuration(600L).start();
    }

    public final void z2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048631, this) != null) || this.e) {
            return;
        }
        t tVar = this.a;
        g6a.a(tVar.k, 10L, tVar.c, 10L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofInt(this.a.c, "width", V, this.j), ObjectAnimator.ofInt(this.a.c, "height", V, this.k), ObjectAnimator.ofInt(this.a.c, "marginRight", W, this.i));
        animatorSet.addListener(new j(this));
        animatorSet.setDuration(600L).start();
    }

    @Override // com.baidu.tieba.od8
    public void B1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.B != null && this.n > 0 && System.currentTimeMillis() - this.D > 5000) {
            this.B.x(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.n));
            this.D = System.currentTimeMillis();
        }
    }

    public final long B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!ListUtils.isEmpty(this.q) && ListUtils.getCount(this.q) > 0 && this.q.get(0) != null) {
                return this.q.get(0).longValue();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && TbadkCoreApplication.isLogin() && getContext() != null && this.t > 0) {
            this.G = true;
            po5.a().b(getContext(), this.t);
        }
    }

    public final void L2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && getContext() != null && this.f) {
            this.f = false;
            ro5 ro5Var = this.A;
            if (ro5Var != null) {
                ro5Var.a(getPageContext(), Collections.unmodifiableList(this.q), this.n, this.o, -1L, this.p, this.E);
            }
        }
    }

    public void N2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && !this.e && this.d != 1) {
            this.d = 1;
            t tVar = this.a;
            g6a.a(tVar.c, 10L, tVar.k, 10L);
            pd8 pd8Var = this.z;
            if (pd8Var != null) {
                pd8Var.b();
            }
            O2();
            C2();
        }
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            SkinManager.setBackgroundResource(this.a.d, R.drawable.bg_chat_group_expend_gradual);
            SkinManager.setBackgroundResource(this.a.l, R.drawable.bg_chat_group_collapse_gradual);
            SkinManager.setImageResource(this.a.e, R.drawable.icon_entrance_left_expend);
            y2(3, this.x);
        }
    }

    public final long X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
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

    @Override // com.baidu.tieba.oo5.b
    public void C1(long j2, String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.p = z;
            this.E = z2;
            if (StringUtils.isNull(this.o)) {
                this.o = str;
            }
            if (this.n == 0 && j2 > 0 && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && !this.F) {
                wg.a().removeCallbacks(this.O);
                wg.a().post(this.O);
            }
            this.n = j2;
            this.B = new qc8(getContext(), this.J, false);
        }
    }

    public final void E2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.f.setOnClickListener(this);
            this.a.h.setOnClickListener(this);
            this.a.d.setOnClickListener(this);
            b bVar = new b(this);
            this.a.f.setOnLongClickListener(bVar);
            this.a.h.setOnLongClickListener(bVar);
            this.a.l.setOnLongClickListener(bVar);
            this.a.c.setRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            o75.d(this.a.c).o(R.string.J_X06);
            this.a.g.setAlpha(0.08f);
            vd8 vd8Var = new vd8(getPageContext());
            this.c = vd8Var;
            vd8Var.g(new c(this, bVar));
            this.a.b.setFlipInterval(5500);
            this.a.b.startFlipping();
            this.a.b.setAnimateFirstView(false);
            w2();
            J2();
            this.a.t.setText(R.string.chat_group_guide_title);
            this.a.u.setText(R.string.chat_group_guide_content);
            this.c.f(this.R);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            I2();
        }
    }

    public void O2() {
        Date date;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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
                    A2();
                    W2(Y);
                } else if (i2 == Z) {
                    A2();
                    W2(Y);
                }
            }
        }
    }

    public final void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds170);
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.a.b, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, dimenPixelSize, 0.0f), PropertyValuesHolder.ofFloat(View.ALPHA, 0.0f, 1.0f)).setDuration(800L);
            duration.setInterpolator(new AccelerateDecelerateInterpolator());
            this.a.b.setInAnimation(duration);
            ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(this.a.b, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 0.0f, -dimenPixelSize), PropertyValuesHolder.ofFloat(View.ALPHA, 1.0f, 0.0f)).setDuration(800L);
            duration2.setInterpolator(new AccelerateDecelerateInterpolator());
            this.a.b.setOutAnimation(duration2);
        }
    }

    @Override // com.baidu.tieba.oo5.b
    public void F(ChatRoomEntranceData chatRoomEntranceData) {
        qc8 qc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, chatRoomEntranceData) == null) && chatRoomEntranceData != null) {
            if (!ListUtils.isEmpty(chatRoomEntranceData.getChatRoomInfoList()) || chatRoomEntranceData.getHotListOriginNum() > 0) {
                if (this.g) {
                    this.r = chatRoomEntranceData.getHotListOriginNum();
                }
                if (ListUtils.isEmpty(chatRoomEntranceData.getChatRoomInfoList()) && chatRoomEntranceData.getHotListOriginNum() > 0) {
                    N2();
                    return;
                }
                if (!ListUtils.isEmpty(chatRoomEntranceData.getHotRoomList())) {
                    this.q.clear();
                    this.q.addAll(chatRoomEntranceData.getHotRoomList());
                    V2(chatRoomEntranceData);
                }
                if (!this.C && (qc8Var = this.B) != null && this.n > 0) {
                    qc8Var.x(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.n));
                    this.C = true;
                }
                List<ChatRoomInfoData> chatRoomInfoList = chatRoomEntranceData.getChatRoomInfoList();
                this.v = chatRoomInfoList;
                this.c.d(chatRoomInfoList);
                if (this.a.b.getAdapter() == null) {
                    this.a.b.setAdapter(this.c);
                }
                if (this.y != null && H2() && !this.y.y(B2())) {
                    ChatRoomInfoData chatRoomInfoData = chatRoomEntranceData.getChatRoomInfoList().get(0);
                    int btnType = chatRoomInfoData.getChatroomInfoBasicData().getBtnType();
                    int e2 = tg.e(chatRoomInfoData.getChatroomInfoBasicData().getUnreadNum(), 0);
                    this.x = e2;
                    y2(btnType, e2);
                    this.c.notifyDataSetChanged();
                    this.y.k();
                }
            }
        }
    }

    public final void M2(int i2, @NonNull ChatRoomInfo chatRoomInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048592, this, i2, chatRoomInfo) != null) || this.a.b.getChildCount() - 1 != i2) {
            return;
        }
        this.x = chatRoomInfo.getUnreadNum();
        this.t = chatRoomInfo.getRoomId();
        vd8 vd8Var = this.c;
        if (vd8Var != null) {
            Object item = vd8Var.getItem(i2);
            if (item instanceof ChatRoomInfoData) {
                xd8.d(chatRoomInfo, (ChatRoomInfoData) item);
                this.c.notifyDataSetChanged();
            }
        }
    }

    public void U2(@StringRes int i2, boolean z) {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) != null) || (activity = getActivity()) == null) {
            return;
        }
        BdTopToast bdTopToast = new BdTopToast(activity);
        bdTopToast.g(activity.getString(i2));
        bdTopToast.h(z);
        bdTopToast.i((ViewGroup) activity.findViewById(16908290));
    }

    public final void Q2(int i2, boolean z, int i3) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) && getPageContext() != null && (layoutParams = (LinearLayout.LayoutParams) this.a.h.getLayoutParams()) != null) {
            if (z && i3 > 0) {
                this.a.i.setVisibility(0);
                String format = String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0df7), Integer.valueOf(i3));
                String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0df8);
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

    public final void T2(String str) {
        TbPageContext<BaseFragmentActivity> pageContext;
        int i2;
        String str2;
        TbSingleton.GroupChatDisturbText.TitleText canNotDisturb;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048601, this, str) != null) || (pageContext = getPageContext()) == null) {
            return;
        }
        n95 m2 = n95.m();
        String str3 = f1126T + str;
        boolean i3 = m2.i(str3, true);
        if (i3) {
            i2 = R.string.obfuscated_res_0x7f0f0a36;
        } else {
            i2 = R.string.obfuscated_res_0x7f0f0a37;
        }
        String string = pageContext.getString(i2);
        if (i3) {
            str2 = pageContext.getString(R.string.obfuscated_res_0x7f0f0a35);
        } else {
            str2 = null;
        }
        TbSingleton.GroupChatDisturbText groupChatDisturbText = TbSingleton.getInstance().getGroupChatDisturbText();
        if (groupChatDisturbText != null) {
            if (i3) {
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
        l55 l55Var = new l55(pageContext);
        l55Var.j(false);
        l55Var.i(str2, new String[]{string}, new d(this, m2, str3, i3, l55Var));
        l55Var.l();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bundle) == null) {
            super.onCreate(bundle);
            D2();
            if (this.l == null) {
                this.l = new PollingModel(getPageContext(), getUniqueId());
            }
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                this.y = new sd8(getPageContext().getPageActivity(), this.P);
            }
            wg.a().removeCallbacks(this.O);
            wg.a().post(this.O);
            registerListener(this.K);
            registerListener(this.I);
            registerListener(this.H);
            registerListener(this.L);
            registerListener(this.M);
        }
    }

    public final void V2(@NonNull ChatRoomEntranceData chatRoomEntranceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, chatRoomEntranceData) == null) {
            if (!H2()) {
                R2(true);
                return;
            }
            if (H2()) {
                this.a.b.stopFlipping();
            }
            if (this.y != null && H2() && !this.y.w()) {
                this.y.x(chatRoomEntranceData.getChatRoomInfoList(), B2(), this.Q);
            }
        }
    }

    public void W2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048615, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            int m2 = vi.m(getContext(), UtilHelper.isFoldScreen()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
            this.j = m2;
            if (m2 != this.a.c.getWidth()) {
                this.a.c.setWidth(this.j);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048613, this, i2) != null) || i2 == this.mSkinType) {
            return;
        }
        this.mSkinType = i2;
        pd8 pd8Var = this.z;
        if (pd8Var != null) {
            pd8Var.e(i2);
        }
        this.a.c.setCardBackgroundColor(SkinManager.getColor(R.color.CAM_X0207));
        SkinManager.setImageResource(this.a.w, R.drawable.chat_group_mask_guide);
        P2();
        o75.d(this.a.g).f(R.color.CAM_X0334);
        SkinManager.setBackgroundColor(this.a.j, R.color.transparent);
        if (this.mSkinType == 0) {
            this.a.c.setElevation(UtilHelper.getDimenPixelSize(R.dimen.tbds21));
        }
        o75 d2 = o75.d(this.a.t);
        d2.C(R.string.F_X02);
        d2.w(R.color.CAM_X0105);
        d2.B(R.dimen.T_X08);
        o75 d3 = o75.d(this.a.u);
        d3.C(R.string.F_X01);
        d3.w(R.color.CAM_X0107);
        d3.B(R.dimen.T_X09);
        o75 d4 = o75.d(this.a.i);
        d4.w(R.color.CAM_X0101);
        d4.C(R.string.F_X01);
        d4.B(R.dimen.T_X08);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        ro5 ro5Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f0906ae) {
                if (TbadkCoreApplication.isLogin()) {
                    ro5 ro5Var2 = this.A;
                    if (ro5Var2 != null) {
                        ro5Var2.a(getPageContext(), Collections.unmodifiableList(this.q), this.n, this.o, -1L, this.p, this.E);
                    }
                } else {
                    this.f = true;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) TbadkCoreApplication.getInst(), true)));
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f0906c0 && view2.getId() != R.id.obfuscated_res_0x7f0906b2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                wd8.b("c15073", this.n, this.o, null, i2, "2");
                C2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0906b2) {
                ViewHelper.checkUpIsLogin(getPageContext().getPageActivity());
                K2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0906c0 && (ro5Var = this.A) != null) {
                ro5Var.a(getPageContext(), Collections.unmodifiableList(this.q), this.n, this.o, -1L, this.p, this.E);
            }
        }
    }

    public final void y2(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048630, this, i2, i3) == null) {
            if (i2 == 1) {
                Q2(UtilHelper.getDimenPixelSize(R.dimen.tbds172), false, 0);
                SkinManager.setBackgroundResource(this.a.h, R.drawable.icon_chat_group_experience);
            } else if (i3 > 0) {
                Q2(UtilHelper.getDimenPixelSize(R.dimen.tbds172), true, i3);
                SkinManager.setBackgroundResource(this.a.h, R.drawable.icon_chat_group_new_msg);
            } else {
                Q2(UtilHelper.getDimenPixelSize(R.dimen.tbds198), false, 0);
                SkinManager.setBackgroundResource(this.a.h, R.drawable.icon_chat_group_enter_see_more);
            }
        }
    }
}

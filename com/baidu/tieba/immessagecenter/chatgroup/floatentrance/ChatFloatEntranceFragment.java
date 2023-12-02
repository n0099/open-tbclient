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
import com.baidu.tieba.au8;
import com.baidu.tieba.d29;
import com.baidu.tieba.dm5;
import com.baidu.tieba.em5;
import com.baidu.tieba.gm5;
import com.baidu.tieba.h39;
import com.baidu.tieba.i39;
import com.baidu.tieba.i5b;
import com.baidu.tieba.im.base.core.slice.SliceFragment;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.l39;
import com.baidu.tieba.m39;
import com.baidu.tieba.n05;
import com.baidu.tieba.n39;
import com.baidu.tieba.nu5;
import com.baidu.tieba.o39;
import com.baidu.tieba.p05;
import com.baidu.tieba.p39;
import com.baidu.tieba.q39;
import com.baidu.tieba.r39;
import com.baidu.tieba.ru5;
import com.baidu.tieba.s19;
import com.baidu.tieba.st5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.y49;
import com.baidu.tieba.yc5;
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
public class ChatFloatEntranceFragment extends SliceFragment implements dm5.b, h39 {
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
    public l39 D;
    public i39 E;
    public gm5 F;
    @Nullable
    public s19 G;
    public boolean H;
    public long I;
    public boolean J;
    public String K;
    public boolean L;
    public boolean M;
    public final CustomMessageListener N;
    public final CustomMessageListener O;
    @NonNull
    public final s19.c P;
    public final CustomMessageListener Q;
    public final CustomMessageListener R;
    public List<Map<String, Long>> S;
    @Nullable

    /* renamed from: T  reason: collision with root package name */
    public Runnable f1115T;
    public final m39 U;
    public final n39 V;
    public final o39.d W;
    public Runnable X;
    public u e;
    public boolean f;
    public o39 g;
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

    @Override // com.baidu.tieba.dm5.b
    public void G1(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, motionEvent) == null) {
        }
    }

    @Override // com.baidu.tieba.dm5.b
    public Fragment n() {
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
                    chatFloatEntranceFragment.r = j;
                    if (this.a.a.r > 0 && !this.a.a.J) {
                        r39.a(this.a.a.f1115T);
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
                long g4 = this.a.g4();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (ListUtils.isEmpty(this.a.u) && this.a.v > 0) {
                    r39.c(false, this.a.f1115T);
                } else if (ListUtils.isEmpty(this.a.u) && !this.a.J) {
                    this.a.p.setChatRoomEntranceCallback(new a(this));
                    ChatFloatEntranceFragment chatFloatEntranceFragment = this.a;
                    chatFloatEntranceFragment.I3(currentAccount, chatFloatEntranceFragment.J, 0L);
                    this.a.J = true;
                } else {
                    ChatFloatEntranceFragment chatFloatEntranceFragment2 = this.a;
                    chatFloatEntranceFragment2.I3(currentAccount, chatFloatEntranceFragment2.J, g4);
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
                chatFloatEntranceFragment.c4(chatFloatEntranceFragment.s);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements o39.e {
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

        @Override // com.baidu.tieba.o39.e
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
    public class c implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SharedPrefHelper a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ n05 d;
        public final /* synthetic */ ChatFloatEntranceFragment e;

        public c(ChatFloatEntranceFragment chatFloatEntranceFragment, SharedPrefHelper sharedPrefHelper, String str, boolean z, n05 n05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatFloatEntranceFragment, sharedPrefHelper, str, Boolean.valueOf(z), n05Var};
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
            this.d = n05Var;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIL(1048576, this, p05Var, i, view2) != null) || !(view2 instanceof TextView)) {
                return;
            }
            this.a.putBoolean(this.b, !this.c);
            this.e.d4(R.string.obfuscated_res_0x7f0f0a83, true);
            p39.d(this.e.r, this.c);
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
            this.a.L3();
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
    public class f implements o39.c {
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

        @Override // com.baidu.tieba.o39.c
        public void a(View view2, ChatRoomInfoData chatRoomInfoData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, view2, chatRoomInfoData) != null) || chatRoomInfoData == null) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.a.B3(25075);
            }
            this.a.x = chatRoomInfoData.getRoomId();
            this.a.z = chatRoomInfoData.getJumpUrl();
            this.a.E3();
        }
    }

    /* loaded from: classes6.dex */
    public class g extends nu5<List<GroupChatRoomPojo>> {
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
        @Override // com.baidu.tieba.nu5
        public List<GroupChatRoomPojo> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return au8.j().i(this.a, String.valueOf(this.b.s));
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements st5<List<GroupChatRoomPojo>> {
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
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(List<GroupChatRoomPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.c.K = y49.a(list);
                if (!this.a) {
                    this.c.p.getChatEntranceData(PollingModel.CHATROOM_FRS, this.c.s, this.b, this.c.q, this.c.K);
                } else {
                    this.c.p.getChatEntranceData(PollingModel.CHATROOM_FRS, null, this.b, this.c.q, this.c.K);
                }
                if (this.c.f1115T != null && this.c.M) {
                    r39.b(this.c.f1115T, ChatFloatEntranceFragment.Z);
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
                i39 i39Var = this.a.E;
                if (i39Var != null) {
                    i39Var.b();
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
                    i5b.a(this.a.e.c, 10L, this.a.e.k, 10L);
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
                this.a.j();
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
                    this.a.j();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements s19.c {
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

        @Override // com.baidu.tieba.s19.c
        public void a(List list, int i) {
            ChatFloatEntranceFragment chatFloatEntranceFragment;
            i39 i39Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) && (i39Var = (chatFloatEntranceFragment = this.a).E) != null) {
                i39Var.f(chatFloatEntranceFragment.u, this.a.r, list, i);
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
            yc5 yc5Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.hasError() || !this.a.isResumed()) {
                return;
            }
            if ((customResponsedMessage.getData() instanceof yc5) && (yc5Var = (yc5) customResponsedMessage.getData()) != null && yc5Var.a()) {
                this.a.y = yc5Var.b();
            }
            if (TbadkCoreApplication.isLogin() && this.a.y > 0 && !this.a.Q3()) {
                if (this.a.F != null) {
                    this.a.F.a(this.a.getPageContext(), Collections.unmodifiableList(this.a.u), this.a.r, this.a.s, this.a.y, this.a.t, this.a.getActivity().getSupportFragmentManager(), d29.b, "frs");
                }
                this.a.y = -1L;
            }
            this.a.L = false;
            if (this.a.D != null && !this.a.D.F(this.a.K3())) {
                r39.c(true, this.a.f1115T);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !customResponsedMessage.hasError() && this.a.R3() && this.a.D != null) {
                this.a.D.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements m39 {
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

        @Override // com.baidu.tieba.m39
        public void a(@NonNull ChatRoomInfo chatRoomInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, chatRoomInfo) != null) || chatRoomInfo.getNewMessage() == null || this.a.L) {
                return;
            }
            this.a.W3(0, chatRoomInfo);
        }
    }

    /* loaded from: classes6.dex */
    public class s implements n39 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        @Override // com.baidu.tieba.n39
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

        @Override // com.baidu.tieba.n39
        public void b(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.a.D != null && this.a.D.F(j)) {
                r39.c(false, this.a.f1115T);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements o39.d {
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

        @Override // com.baidu.tieba.o39.d
        public void a(@NonNull View view2, @NonNull ChatRoomInfoData chatRoomInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, chatRoomInfoData) == null) {
                this.a.x = chatRoomInfoData.getRoomId();
                if (chatRoomInfoData.getChatroomInfoBasicData() != null) {
                    int btnType = chatRoomInfoData.getChatroomInfoBasicData().getBtnType();
                    this.a.C = JavaTypesHelper.toInt(chatRoomInfoData.getChatroomInfoBasicData().getUnreadNum(), 0);
                    ChatFloatEntranceFragment chatFloatEntranceFragment = this.a;
                    chatFloatEntranceFragment.F3(btnType, chatFloatEntranceFragment.C);
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
                uVar.c = (CardViewLayout) view2.findViewById(R.id.obfuscated_res_0x7f09070e);
                uVar.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09070f);
                uVar.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090716);
                uVar.g = view2.findViewById(R.id.obfuscated_res_0x7f0915b9);
                uVar.b = (BaseAdapterViewFlipper) view2.findViewById(R.id.obfuscated_res_0x7f090710);
                uVar.h = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09070b);
                uVar.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09070c);
                uVar.f = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090719);
                uVar.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090704);
                uVar.l = (RoundRelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090707);
                uVar.m = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ba5);
                uVar.n = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090705);
                uVar.j = view2.findViewById(R.id.obfuscated_res_0x7f09228c);
                uVar.o = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090703);
                uVar.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09030d);
                uVar.q = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09030e);
                uVar.r = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092633);
                uVar.s = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092634);
                uVar.v = (ConstraintLayout) view2.findViewById(R.id.obfuscated_res_0x7f090712);
                uVar.w = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090711);
                uVar.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090714);
                uVar.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090713);
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

    public final void E3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            U3();
            s19 s19Var = this.G;
            if (s19Var != null) {
                s19Var.u(true);
            }
            if (this.D != null && R3()) {
                this.D.G(K3());
            }
            p39.b("c15073", this.r, this.s, String.valueOf(this.x), 1, 1);
            p39.b(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK, this.r, this.s, String.valueOf(this.x), 1, 1);
            L3();
        }
    }

    @Override // com.baidu.tieba.dm5.b
    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (P3() || !this.f || getState() != 2) {
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
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onDestroyView();
            r39.d(this.f1115T);
            SafeHandler.getInst().removeCallbacks(this.X);
            MessageManager.getInstance().unRegisterListener(this.O);
            MessageManager.getInstance().unRegisterListener(this.N);
            MessageManager.getInstance().unRegisterListener(this.Q);
            MessageManager.getInstance().unRegisterListener(this.R);
            MessageManager.getInstance().unRegisterListener(o39.f);
            this.g.f(null);
            s19 s19Var = this.G;
            if (s19Var != null) {
                s19Var.p();
            }
            l39 l39Var = this.D;
            if (l39Var != null) {
                l39Var.p();
            }
            this.f1115T = null;
        }
    }

    @Override // com.baidu.tieba.h39
    public void y2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && this.G != null && this.r > 0 && System.currentTimeMillis() - this.I > 5000) {
            if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST) instanceof TbHttpMessageTask) {
                ((TbHttpMessageTask) MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST)).setIsNeedDialog(false);
            }
            this.G.F(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.r), "frs");
            this.I = System.currentTimeMillis();
        }
    }

    public ChatFloatEntranceFragment(String str, gm5 gm5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, gm5Var};
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
        this.f1115T = new q(this);
        this.U = new r(this);
        this.V = new s(this);
        this.W = new t(this);
        this.X = new d(this);
        this.s = str;
        this.F = gm5Var;
    }

    public final void B3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getContext(), true, i2)));
        }
    }

    public void b4(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048607, this, z) != null) || this.e.b.isFlipping()) {
            return;
        }
        this.e.b.setAutoStart(z);
        this.e.b.startFlipping();
    }

    @Override // com.baidu.tieba.dm5.b
    public void h2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.f = z;
        }
    }

    @Override // com.baidu.tieba.dm5.b
    public void l1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.k = z;
        }
    }

    @Override // com.baidu.tieba.dm5.b
    public boolean r2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, str)) == null) {
            return String.valueOf(this.q).equals(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048621, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 != 25075) {
                    if (i2 == 25076) {
                        V3();
                        return;
                    }
                    return;
                }
                E3();
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048626, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d033f, viewGroup, false);
            this.e = u.a(inflate);
            N3();
            this.E = new i39(this.e, this);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.dm5.b
    public void E1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !this.i && this.h != 2) {
            this.h = 2;
            H3();
            i39 i39Var = this.E;
            if (i39Var != null) {
                i39Var.c();
            }
        }
    }

    public final void G3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f1115T != null && ListUtils.isEmpty(this.u)) {
            this.M = false;
            r39.c(false, this.f1115T);
        }
    }

    public final void L3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921789));
            this.e.v.setVisibility(8);
        }
    }

    public final void M3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            long loopChatroomFrequency = TbSingleton.getInstance().getLoopChatroomFrequency() * 1000;
            Z = loopChatroomFrequency;
            if (loopChatroomFrequency <= 0) {
                Z = 5000L;
            }
        }
    }

    public final boolean O3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (TbadkCoreApplication.isLogin() && this.x > 0 && !Q3()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean P3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return SharedPrefHelper.getInstance().getBoolean("key_chat_group_guide_show", false);
        }
        return invokeV.booleanValue;
    }

    public final boolean Q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.v <= 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean R3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (!ListUtils.isEmpty(this.u) && this.u.size() <= 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void S3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.e.c.getViewTreeObserver().addOnGlobalLayoutListener(new e(this));
        }
    }

    public final void T3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.g.e(new f(this));
        }
    }

    @Override // com.baidu.tieba.dm5.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            onDestroyView();
            this.F = null;
        }
    }

    @Override // com.baidu.tieba.dm5.b
    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.h == 1 || this.e.c.getVisibility() != 0) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.h39
    public Context getViewContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return getContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dm5.b
    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && !this.i && this.h != 1) {
            this.h = 1;
            D3();
            Y3();
            L3();
        }
    }

    @Override // com.baidu.tieba.dm5.b
    public void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            L3();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onPause();
            l39 l39Var = this.D;
            if (l39Var != null) {
                l39Var.r();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            super.onResume();
            i39 i39Var = this.E;
            if (i39Var != null) {
                i39Var.g(this.u);
            }
        }
    }

    @Override // com.baidu.tieba.dm5.b
    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (ListUtils.isEmpty(this.u) && this.v > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.dm5.b
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return !ListUtils.isEmpty(this.A);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h39
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h39
    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.r;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.dm5.b
    public void B2(long j2, String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.t = z;
            if (StringUtils.isNull(this.s)) {
                this.s = str;
            }
            if (this.r == 0 && j2 > 0 && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && !this.J) {
                r39.a(this.f1115T);
            }
            this.r = j2;
            this.G = new s19(getContext(), this.P, false);
        }
    }

    public final void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds170);
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.e.b, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, dimenPixelSize, 0.0f), PropertyValuesHolder.ofFloat(View.ALPHA, 0.0f, 1.0f)).setDuration(800L);
            duration.setInterpolator(new AccelerateDecelerateInterpolator());
            this.e.b.setInAnimation(duration);
            ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(this.e.b, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 0.0f, -dimenPixelSize), PropertyValuesHolder.ofFloat(View.ALPHA, 1.0f, 0.0f)).setDuration(800L);
            duration2.setInterpolator(new AccelerateDecelerateInterpolator());
            this.e.b.setOutAnimation(duration2);
        }
    }

    public void J3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.S == null) {
                this.S = new ArrayList();
            }
            this.S.clear();
            for (int i2 = 0; i2 < this.u.size(); i2++) {
                Long l2 = this.u.get(i2);
                HashMap hashMap = new HashMap();
                hashMap.put("room_id", l2);
                GroupChatRoomPojo f2 = au8.j().f(TbadkCoreApplication.getCurrentAccount(), l2.longValue());
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

    public final void N3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
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
            o39 o39Var = new o39(getPageContext());
            this.g = o39Var;
            o39Var.g(new b(this, aVar));
            this.e.b.setFlipInterval(5500);
            this.e.b.startFlipping();
            this.e.b.setAnimateFirstView(false);
            C3();
            T3();
            this.e.t.setText(R.string.chat_group_guide_title);
            this.e.u.setText(R.string.chat_group_guide_content);
            this.g.f(this.W);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            S3();
        }
    }

    public void Y3() {
        Date date;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
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
                J3();
                f4(d0);
            } else if (i2 == e0) {
                J3();
                f4(d0);
            }
        }
    }

    public final void D3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.i) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.e.c, "width", this.n, a0);
        animatorSet.playTogether(ofInt, ObjectAnimator.ofInt(this.e.c, "height", this.o, a0), ObjectAnimator.ofInt(this.e.c, "marginRight", this.m, b0));
        animatorSet.addListener(new i(this));
        ofInt.addUpdateListener(new j(this));
        animatorSet.setDuration(600L).start();
    }

    public final void H3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || this.i) {
            return;
        }
        u uVar = this.e;
        i5b.a(uVar.k, 10L, uVar.c, 10L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofInt(this.e.c, "width", a0, this.n), ObjectAnimator.ofInt(this.e.c, "height", a0, this.o), ObjectAnimator.ofInt(this.e.c, "marginRight", b0, this.m));
        animatorSet.addListener(new l(this));
        animatorSet.setDuration(600L).start();
    }

    public final void F3(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            if (i2 == 1) {
                a4(UtilHelper.getDimenPixelSize(R.dimen.tbds172), false, 0);
                SkinManager.setBackgroundResource(this.e.h, R.drawable.icon_chat_group_experience);
            } else if (i3 > 0) {
                a4(UtilHelper.getDimenPixelSize(R.dimen.tbds172), true, i3);
                SkinManager.setBackgroundResource(this.e.h, R.drawable.icon_chat_group_new_msg);
            } else {
                a4(UtilHelper.getDimenPixelSize(R.dimen.tbds198), false, 0);
                SkinManager.setBackgroundResource(this.e.h, R.drawable.icon_chat_group_enter_see_more);
            }
        }
    }

    public void d4(@StringRes int i2, boolean z) {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) != null) || (activity = getActivity()) == null) {
            return;
        }
        new BdTopToast(activity).setContent(activity.getString(i2)).setIcon(z).show((ViewGroup) activity.findViewById(16908290));
    }

    public final void I3(String str, boolean z, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
            ru5.c(new g(this, str), new h(this, z, j2));
        }
    }

    public final long K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!ListUtils.isEmpty(this.u) && ListUtils.getCount(this.u) > 0 && this.u.get(0) != null) {
                return this.u.get(0).longValue();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final void U3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && TbadkCoreApplication.isLogin() && getContext() != null && this.x > 0) {
            this.L = true;
            em5.a().f(getContext(), 1, this.x, O3());
        }
    }

    public final void V3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && getContext() != null && this.j) {
            this.j = false;
            gm5 gm5Var = this.F;
            if (gm5Var != null) {
                gm5Var.a(getPageContext(), Collections.unmodifiableList(this.u), this.r, this.s, this.x, this.t, getActivity().getSupportFragmentManager(), d29.a, "frs");
            }
        }
    }

    public void X3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && !this.i && this.h != 1) {
            this.h = 1;
            u uVar = this.e;
            i5b.a(uVar.c, 10L, uVar.k, 10L);
            i39 i39Var = this.E;
            if (i39Var != null) {
                i39Var.b();
            }
            Y3();
            L3();
        }
    }

    public final void Z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            SkinManager.setBackgroundResource(this.e.d, R.drawable.bg_chat_group_expend_gradual);
            SkinManager.setBackgroundResource(this.e.l, R.drawable.bg_chat_group_collapse_gradual);
            SkinManager.setImageResource(this.e.e, R.drawable.icon_entrance_left_expend);
            F3(3, this.C);
        }
    }

    public final long g4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
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

    public final void W3(int i2, @NonNull ChatRoomInfo chatRoomInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048601, this, i2, chatRoomInfo) != null) || this.e.b.getChildCount() - 1 != i2) {
            return;
        }
        this.C = chatRoomInfo.getUnreadNum();
        this.x = chatRoomInfo.getRoomId();
        o39 o39Var = this.g;
        if (o39Var != null) {
            Object item = o39Var.getItem(i2);
            if (item instanceof ChatRoomInfoData) {
                q39.d(chatRoomInfo, (ChatRoomInfoData) item);
                this.g.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tieba.dm5.b
    public void a0(ChatRoomEntranceData chatRoomEntranceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, chatRoomEntranceData) == null) {
            if (chatRoomEntranceData != null && (!ListUtils.isEmpty(chatRoomEntranceData.getChatRoomInfoList()) || chatRoomEntranceData.getHotListOriginNum() > 0)) {
                if (this.k) {
                    this.v = chatRoomEntranceData.getHotListOriginNum();
                }
                if (ListUtils.isEmpty(chatRoomEntranceData.getChatRoomInfoList()) && chatRoomEntranceData.getHotListOriginNum() > 0) {
                    X3();
                    return;
                }
                if (!ListUtils.isEmpty(chatRoomEntranceData.getHotRoomList())) {
                    this.u.clear();
                    this.u.addAll(chatRoomEntranceData.getHotRoomList());
                    e4(chatRoomEntranceData);
                }
                if (!this.H && this.G != null && this.r > 0) {
                    if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST) instanceof TbHttpMessageTask) {
                        ((TbHttpMessageTask) MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST)).setIsNeedDialog(false);
                    }
                    this.G.F(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.r), "frs");
                    this.H = true;
                }
                List<ChatRoomInfoData> chatRoomInfoList = chatRoomEntranceData.getChatRoomInfoList();
                this.A = chatRoomInfoList;
                this.g.d(chatRoomInfoList);
                if (this.e.b.getAdapter() == null) {
                    this.e.b.setAdapter(this.g);
                }
                if (this.D != null && R3() && !this.D.F(K3())) {
                    ChatRoomInfoData chatRoomInfoData = chatRoomEntranceData.getChatRoomInfoList().get(0);
                    int btnType = chatRoomInfoData.getChatroomInfoBasicData().getBtnType();
                    int i2 = JavaTypesHelper.toInt(chatRoomInfoData.getChatroomInfoBasicData().getUnreadNum(), 0);
                    this.C = i2;
                    F3(btnType, i2);
                    this.g.notifyDataSetChanged();
                    this.D.q();
                    return;
                }
                return;
            }
            G3();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f090707) {
                if (TbadkCoreApplication.isLogin()) {
                    gm5 gm5Var = this.F;
                    if (gm5Var != null) {
                        gm5Var.a(getPageContext(), Collections.unmodifiableList(this.u), this.r, this.s, this.x, this.t, getActivity().getSupportFragmentManager(), d29.a, "frs");
                    }
                } else {
                    this.j = true;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) TbadkCoreApplication.getInst(), true)));
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f090719 && view2.getId() != R.id.obfuscated_res_0x7f09070b) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                p39.b("c15073", this.r, this.s, String.valueOf(this.x), i2, 2);
                L3();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09070b) {
                ViewHelper.checkUpIsLogin(getPageContext().getPageActivity());
                U3();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090719) {
                if (!TbadkCoreApplication.isLogin()) {
                    B3(25076);
                    return;
                }
                gm5 gm5Var2 = this.F;
                if (gm5Var2 != null) {
                    gm5Var2.a(getPageContext(), Collections.unmodifiableList(this.u), this.r, this.s, this.x, this.t, getActivity().getSupportFragmentManager(), d29.a, "frs");
                }
            }
        }
    }

    public final void a4(int i2, boolean z, int i3) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) && getPageContext() != null && (layoutParams = (LinearLayout.LayoutParams) this.e.h.getLayoutParams()) != null) {
            if (z && i3 > 0) {
                this.e.i.setVisibility(0);
                String format = String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0e78), Integer.valueOf(i3));
                String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0e79);
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

    public final void c4(String str) {
        TbPageContext<BaseFragmentActivity> pageContext;
        int i2;
        String str2;
        TbSingleton.GroupChatDisturbText.TitleText canNotDisturb;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, str) != null) || (pageContext = getPageContext()) == null) {
            return;
        }
        SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
        String str3 = Y + str;
        boolean z = sharedPrefHelper.getBoolean(str3, true);
        if (z) {
            i2 = R.string.obfuscated_res_0x7f0f0a7f;
        } else {
            i2 = R.string.obfuscated_res_0x7f0f0a80;
        }
        String string = pageContext.getString(i2);
        if (z) {
            str2 = pageContext.getString(R.string.obfuscated_res_0x7f0f0a7e);
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
        n05 n05Var = new n05(pageContext);
        n05Var.j(false);
        n05Var.i(str2, new String[]{string}, new c(this, sharedPrefHelper, str3, z, n05Var));
        n05Var.l();
    }

    public final void e4(@NonNull ChatRoomEntranceData chatRoomEntranceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, chatRoomEntranceData) == null) {
            if (!R3()) {
                b4(true);
                return;
            }
            if (R3()) {
                this.e.b.stopFlipping();
            }
            if (this.D != null && R3() && !this.D.D()) {
                this.D.E(chatRoomEntranceData.getChatRoomInfoList(), K3(), this.V);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bundle) == null) {
            super.onCreate(bundle);
            M3();
            if (this.p == null) {
                this.p = new PollingModel(getPageContext(), getUniqueId());
            }
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                this.D = new l39(getPageContext().getPageActivity(), this.U);
            }
            r39.a(this.f1115T);
            registerListener(this.O);
            registerListener(this.N);
            registerListener(this.Q);
            registerListener(this.R);
        }
    }

    public void f4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048624, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(getContext(), UtilHelper.isFoldScreen()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
            this.n = equipmentWidth;
            if (equipmentWidth != this.e.c.getWidth()) {
                this.e.c.setWidth(this.n);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (i2 == this.mSkinType) {
                return;
            }
            this.mSkinType = i2;
            i39 i39Var = this.E;
            if (i39Var != null) {
                i39Var.e(i2);
            }
            this.e.c.setCardBackgroundColor(SkinManager.getColor(R.color.CAM_X0207));
            SkinManager.setImageResource(this.e.w, R.drawable.chat_group_mask_guide);
            Z3();
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
}

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
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
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
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tbadk.data.ChatEntranceGuideConfig;
import com.baidu.tbadk.data.ChatRoomEntranceData;
import com.baidu.tbadk.data.ChatRoomInfoData;
import com.baidu.tbadk.switchs.UnReadRedPotMessage;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.al7;
import com.baidu.tieba.dq7;
import com.baidu.tieba.fq7;
import com.baidu.tieba.gh;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatGroupInfo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.ip7;
import com.baidu.tieba.or7;
import com.baidu.tieba.p15;
import com.baidu.tieba.p35;
import com.baidu.tieba.t99;
import com.baidu.tieba.tg5;
import com.baidu.tieba.ug5;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.wg5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class ChatFloatEntranceFragment extends BaseFragment implements tg5.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static long P = 5000;
    public static final int Q;
    public static final int R;
    public static final int S;
    public static int T;
    public static int U;
    public static int V;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    @Nullable
    public ChatEntranceGuideConfig.GuideConfig G;
    @Nullable
    public ChatEntranceGuideConfig.GuideConfig H;
    public final CustomMessageListener I;
    @NonNull
    public ip7.b J;
    public final CustomMessageListener K;
    public final CustomMessageListener L;
    public List<Map<String, Long>> M;
    public final Runnable N;
    public Runnable O;
    public m a;
    public boolean b;
    public fq7 c;
    public int d;
    public boolean e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public final GradientDrawable k;
    public PollingModel l;
    public String m;
    public long n;
    public String o;
    public boolean p;
    public List<Long> q;
    public int r;
    public long s;
    public String t;
    public List<ChatRoomInfoData> u;
    public Map<Long, Date> v;
    public Map<Long, Integer> w;
    public final CustomMessageListener x;
    public wg5 y;
    @Nullable
    public ip7 z;

    @Override // com.baidu.tieba.tg5.b
    public Fragment d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this : (Fragment) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        /* loaded from: classes4.dex */
        public class a implements PollingModel.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
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
                        gh.a().removeCallbacks(this.a.a.N);
                        gh.a().post(this.a.a.N);
                    }
                }
            }
        }

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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                this.a.m = String.valueOf(System.currentTimeMillis());
                long H2 = this.a.H2();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!TextUtils.isEmpty(currentAccount) && !this.a.E && this.a.n > 0) {
                    this.a.l.m0(PollingModel.CHATROOM_FRS, this.a.o, 0L, this.a.m, or7.a(new al7().e(currentAccount, String.valueOf(this.a.n))));
                    this.a.E = true;
                } else if (ListUtils.isEmpty(this.a.q)) {
                    if (!this.a.E && !TextUtils.isEmpty(currentAccount)) {
                        this.a.l.w0(new a(this));
                    }
                    this.a.l.m0(PollingModel.CHATROOM_FRS, this.a.o, 0L, this.a.m, null);
                } else if (!TextUtils.isEmpty(currentAccount) && this.a.n > 0) {
                    this.a.l.m0(PollingModel.CHATROOM_FRS, null, H2, this.a.m, or7.a(new al7().e(currentAccount, String.valueOf(this.a.n))));
                } else {
                    this.a.l.m0(PollingModel.CHATROOM_FRS, null, H2, this.a.m, null);
                }
                gh.a().postDelayed(this.a.N, ChatFloatEntranceFragment.P);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
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

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                this.a.e = true;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.e = false;
                this.a.d = 1;
                this.a.F2(true);
                if (this.a.a.b.isFlipping()) {
                    this.a.a.b.stopFlipping();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
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

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && (valueAnimator.getAnimatedValue() instanceof Integer) && ((Integer) valueAnimator.getAnimatedValue()).intValue() <= ChatFloatEntranceFragment.S && this.a.a.g.getVisibility() == 0) {
                this.a.a.g.setVisibility(4);
                if (this.a.a.m.getVisibility() != 0) {
                    t99.a(this.a.a.c, 10L, this.a.a.m, 10L);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends AnimatorListenerAdapter {
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
                this.a.F2(true);
                this.a.a.b.startFlipping();
                this.a.a.g.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ChatFloatEntranceFragment chatFloatEntranceFragment, int i) {
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.a.a.q.getVisibility() == 8) {
                    this.a.a.r.setVisibility(0);
                    Date date = new Date(System.currentTimeMillis());
                    ChatFloatEntranceFragment chatFloatEntranceFragment = this.a;
                    if (chatFloatEntranceFragment.v == null) {
                        chatFloatEntranceFragment.v = new HashMap();
                    } else {
                        chatFloatEntranceFragment.v = TbSingleton.getInstance().getHasShowRedPot();
                    }
                    ChatFloatEntranceFragment chatFloatEntranceFragment2 = this.a;
                    chatFloatEntranceFragment2.v.put(Long.valueOf(chatFloatEntranceFragment2.n), date);
                    TbSingleton.getInstance().setHasShowRedPot(this.a.v);
                    this.a.G2(ChatFloatEntranceFragment.U);
                    return;
                }
                this.a.a.r.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ChatFloatEntranceFragment chatFloatEntranceFragment, int i) {
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
    public class f implements ip7.b {
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

        @Override // com.baidu.tieba.ip7.b
        public void a(List list, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) && !ListUtils.isEmpty(list)) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (list.get(i2) instanceof ChatGroupInfo) {
                        List<ChatRoomInfo> roomInfoList = ((ChatGroupInfo) list.get(i2)).getRoomInfoList();
                        if (!ListUtils.isEmpty(roomInfoList)) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= roomInfoList.size()) {
                                    break;
                                }
                                ChatRoomInfo chatRoomInfo = roomInfoList.get(i3);
                                if (chatRoomInfo.getAtInfo() == null || chatRoomInfo.getAtInfo().getCountAll() <= 0) {
                                    i3++;
                                } else {
                                    this.a.A = true;
                                    break;
                                }
                            }
                        }
                        if (this.a.A) {
                            break;
                        }
                    }
                }
                if (this.a.A && !this.a.B) {
                    this.a.a.q.setVisibility(0);
                    this.a.a.r.setVisibility(8);
                    this.a.A = false;
                    return;
                }
                this.a.a.q.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ChatFloatEntranceFragment chatFloatEntranceFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !customResponsedMessage.hasError() && TbadkCoreApplication.isLogin() && this.a.s > 0) {
                if (this.a.y != null) {
                    this.a.y.a(this.a.getPageContext(), Collections.unmodifiableList(this.a.q), this.a.n, this.a.o, this.a.s, this.a.p, this.a.D);
                    p35 m = p35.m();
                    m.w("key_chat_group_entrance_click_daily" + this.a.n, true);
                    this.a.I2();
                }
                this.a.s = -1L;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.p2();
        }
    }

    /* loaded from: classes4.dex */
    public class k implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatFloatEntranceFragment a;

        public k(ChatFloatEntranceFragment chatFloatEntranceFragment) {
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
    public class l implements fq7.b {
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

        @Override // com.baidu.tieba.fq7.b
        public void a(View view2, ChatRoomInfoData chatRoomInfoData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, view2, chatRoomInfoData) != null) || chatRoomInfoData == null) {
                return;
            }
            ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity());
            this.a.s = chatRoomInfoData.getRoomId();
            this.a.t = chatRoomInfoData.getJumpUrl();
            this.a.y2();
            if (this.a.z != null) {
                this.a.z.m(true);
            }
            dq7.b("c15073", this.a.n, this.a.o, String.valueOf(this.a.s), 1, "1");
            dq7.b(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK, this.a.n, this.a.o, String.valueOf(this.a.s), 1, null);
            this.a.p2();
        }
    }

    /* loaded from: classes4.dex */
    public static class m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public BaseAdapterViewFlipper b;
        public CardViewLayout c;
        public TbImageView d;
        public LinearLayout e;
        public TbImageView f;
        public RelativeLayout g;
        public LinearLayout h;
        public View i;
        public View j;
        public TbImageView k;
        public View l;
        public RelativeLayout m;
        public RoundTbImageView n;
        public RoundRelativeLayout o;
        public TbImageView p;
        public TextView q;
        public ImageView r;
        public TextView s;
        public TextView t;
        public ConstraintLayout u;
        public ImageView v;

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

        public static m a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                m mVar = new m();
                mVar.a = view2;
                mVar.c = (CardViewLayout) view2.findViewById(R.id.obfuscated_res_0x7f090632);
                mVar.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090633);
                mVar.f = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09063a);
                mVar.i = view2.findViewById(R.id.obfuscated_res_0x7f0913ce);
                mVar.b = (BaseAdapterViewFlipper) view2.findViewById(R.id.obfuscated_res_0x7f090634);
                mVar.j = view2.findViewById(R.id.obfuscated_res_0x7f091d64);
                mVar.k = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090640);
                mVar.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09063d);
                mVar.h = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090642);
                mVar.m = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09062a);
                mVar.o = (RoundRelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09062d);
                mVar.p = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090a81);
                mVar.l = view2.findViewById(R.id.obfuscated_res_0x7f091fb5);
                mVar.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0902d8);
                mVar.r = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cdb);
                mVar.u = (ConstraintLayout) view2.findViewById(R.id.obfuscated_res_0x7f090636);
                mVar.v = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090635);
                mVar.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090638);
                mVar.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090637);
                mVar.d = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09062c);
                mVar.n = (RoundTbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090629);
                return mVar;
            }
            return (m) invokeL.objValue;
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
        Q = UtilHelper.getDimenPixelSize(R.dimen.tbds130);
        R = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        S = UtilHelper.getDimenPixelSize(R.dimen.tbds170);
        T = 0;
        U = 1;
        V = 2;
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            p35.m().z("key_chat_group_entrance_hot_num", 0);
            p35 m2 = p35.m();
            m2.w("key_chat_group_entrance_click_daily" + this.n, false);
        }
    }

    public final void C2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setImageResource(this.a.n, R.drawable.obfuscated_res_0x7f080258);
            SkinManager.setImageResource(this.a.d, R.drawable.obfuscated_res_0x7f080259);
            SkinManager.setImageResource(this.a.f, R.drawable.icon_chat_group_expend);
            SkinManager.setImageResource(this.a.k, R.drawable.icon_chat_group_more);
            SkinManager.setImageResource(this.a.p, R.drawable.icon_chat_group_collapse);
        }
    }

    public final long H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (ListUtils.isEmpty(this.q)) {
                return 0L;
            }
            if (this.r > ListUtils.getCount(this.q) - 1) {
                this.r = 0;
            }
            long longValue = this.q.get(this.r).longValue();
            this.r++;
            return longValue;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.tg5.b
    public void R0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !s2() && this.b) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921788));
            this.a.u.setVisibility(0);
            gh.a().postDelayed(this.O, 5000L);
            p35.m().w("key_chat_group_guide_show", true);
        }
    }

    public final void z2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && TbadkCoreApplication.isLogin() && getContext() != null && this.f) {
            this.f = false;
            wg5 wg5Var = this.y;
            if (wg5Var != null) {
                wg5Var.a(getPageContext(), Collections.unmodifiableList(this.q), this.n, this.o, -1L, this.p, this.D);
            }
        }
    }

    public ChatFloatEntranceFragment(String str, wg5 wg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, wg5Var};
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
        this.k = new GradientDrawable();
        this.q = new ArrayList();
        this.r = 1;
        this.s = -1L;
        this.v = new HashMap();
        this.w = new HashMap();
        this.x = new d(this, 2921783);
        this.A = false;
        this.B = false;
        this.C = false;
        this.E = false;
        this.I = new e(this, 2921768);
        this.J = new f(this);
        this.K = new g(this, 2921410);
        this.L = new h(this, 2921771);
        this.M = null;
        this.N = new i(this);
        this.O = new j(this);
        this.o = str;
        this.y = wg5Var;
    }

    public final void E2(@NonNull ChatEntranceGuideConfig.GuideConfig guideConfig, @NonNull ChatEntranceGuideConfig.GuideConfig guideConfig2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, guideConfig, guideConfig2) == null) {
            w2(this.a.d, SkinManager.getResourceId(R.drawable.obfuscated_res_0x7f080259), guideConfig.getExpendBackGroundDay(), guideConfig.getExpendBackGroundNight(), guideConfig2.getExpendBackGroundDay(), guideConfig2.getExpendBackGroundNight());
            w2(this.a.f, SkinManager.getResourceId(R.drawable.icon_chat_group_expend), guideConfig.getExpendIconDay(), guideConfig.getExpendIconNight(), guideConfig2.getExpendIconDay(), guideConfig2.getExpendIconNight());
            w2(this.a.k, SkinManager.getResourceId(R.drawable.icon_chat_group_more), guideConfig.getExpendArrowDay(), guideConfig.getExpendArrowNight(), guideConfig2.getExpendArrowDay(), guideConfig2.getExpendArrowNight());
            w2(this.a.n, SkinManager.getResourceId(R.drawable.obfuscated_res_0x7f080258), guideConfig.getCollapseBackGroundDay(), guideConfig.getCollapseBackGroundNight(), guideConfig2.getCollapseBackGroundDay(), guideConfig2.getCollapseBackGroundNight());
            w2(this.a.p, SkinManager.getResourceId(R.drawable.icon_chat_group_collapse), guideConfig.getCollapseIconDay(), guideConfig.getCollapseIconNight(), guideConfig2.getCollapseIconDay(), guideConfig2.getCollapseIconNight());
        }
    }

    public final void F2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                gh.a().removeCallbacks(this.N);
                gh.a().post(this.N);
                return;
            }
            gh.a().removeCallbacks(this.N);
        }
    }

    @Override // com.baidu.tieba.tg5.b
    public void k1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.b = z;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            super.onUserChanged(z);
            y2();
            z2();
        }
    }

    @Override // com.baidu.tieba.tg5.b
    public boolean q1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            return String.valueOf(this.m).equals(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.tg5.b
    public void N0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && !this.e && this.d != 2) {
            this.d = 2;
            n2();
        }
    }

    @Override // com.baidu.tieba.tg5.b
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.e && this.d != 1) {
            this.d = 1;
            m2();
            B2();
            p2();
        }
    }

    @Override // com.baidu.tieba.tg5.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            onDestroyView();
            this.y = null;
        }
    }

    @Override // com.baidu.tieba.tg5.b
    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.d == 1 || this.a.c.getVisibility() != 0) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tg5.b
    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return !ListUtils.isEmpty(this.u);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tg5.b
    public void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            p2();
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921789));
            this.a.u.setVisibility(8);
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            long loopChatroomFrequency = TbSingleton.getInstance().getLoopChatroomFrequency() * 1000;
            P = loopChatroomFrequency;
            if (loopChatroomFrequency <= 0) {
                P = 5000L;
            }
        }
    }

    public final boolean s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return p35.m().i("key_chat_group_guide_show", false);
        }
        return invokeV.booleanValue;
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.a.c.getViewTreeObserver().addOnGlobalLayoutListener(new k(this));
        }
    }

    public final void x2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.c.d(new l(this));
        }
    }

    public final void y2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && TbadkCoreApplication.isLogin() && getContext() != null && this.s > 0) {
            ug5.a().b(getContext(), this.s);
        }
    }

    public void B2() {
        Date date;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
                    o2();
                    G2(T);
                } else if (i2 == U) {
                    o2();
                    G2(T);
                }
            }
        }
    }

    public final void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds170);
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.a.b, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, dimenPixelSize, 0.0f), PropertyValuesHolder.ofFloat(View.ALPHA, 0.0f, 1.0f)).setDuration(800L);
            duration.setInterpolator(new AccelerateDecelerateInterpolator());
            this.a.b.setInAnimation(duration);
            ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(this.a.b, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 0.0f, -dimenPixelSize), PropertyValuesHolder.ofFloat(View.ALPHA, 1.0f, 0.0f)).setDuration(800L);
            duration2.setInterpolator(new AccelerateDecelerateInterpolator());
            this.a.b.setOutAnimation(duration2);
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.a.g.setOnClickListener(this);
            this.a.h.setOnClickListener(this);
            this.a.e.setOnClickListener(this);
            this.a.c.setRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds83));
            this.k.setColor(SkinManager.getColor(R.color.CAM_X0207));
            this.k.setShape(1);
            this.k.setUseLevel(false);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds130);
            this.k.setSize(dimenPixelSize, dimenPixelSize);
            this.a.i.setAlpha(0.08f);
            this.a.j.setAlpha(0.08f);
            this.c = new fq7(getPageContext());
            this.a.b.setFlipInterval(5500);
            this.a.b.startFlipping();
            this.a.b.setAnimateFirstView(false);
            l2();
            x2();
            this.a.o.setOnClickListener(this);
            this.a.q.setVisibility(8);
            this.a.s.setText(R.string.chat_group_guide_title);
            this.a.t.setText(R.string.chat_group_guide_content);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            u2();
        }
    }

    public final void D2(@NonNull ChatEntranceGuideConfig.GuideConfig guideConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, guideConfig) == null) {
            v2(this.a.d, SkinManager.getResourceId(R.drawable.obfuscated_res_0x7f080259), guideConfig.getExpendBackGroundDay(), guideConfig.getExpendBackGroundNight());
            v2(this.a.f, SkinManager.getResourceId(R.drawable.icon_chat_group_expend), guideConfig.getExpendIconDay(), guideConfig.getExpendIconNight());
            v2(this.a.k, SkinManager.getResourceId(R.drawable.icon_chat_group_more), guideConfig.getExpendArrowDay(), guideConfig.getExpendArrowNight());
            v2(this.a.n, SkinManager.getResourceId(R.drawable.obfuscated_res_0x7f080258), guideConfig.getCollapseBackGroundDay(), guideConfig.getCollapseBackGroundNight());
            v2(this.a.p, SkinManager.getResourceId(R.drawable.icon_chat_group_collapse), guideConfig.getCollapseIconDay(), guideConfig.getCollapseIconNight());
        }
    }

    public void G2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (this.w == null) {
                this.w = new HashMap();
            } else {
                this.w = TbSingleton.getInstance().getHasClickRedPot();
            }
            this.w.put(Long.valueOf(this.n), Integer.valueOf(i2));
            TbSingleton.getInstance().setHasClickRedPot(this.w);
        }
    }

    public final void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.G == null && this.H == null) {
                C2();
            } else if (this.G != null && t2()) {
                ChatEntranceGuideConfig.GuideConfig guideConfig = this.H;
                if (guideConfig != null) {
                    E2(this.G, guideConfig);
                } else {
                    D2(this.G);
                }
                p35.m().z("key_chat_group_entrance_hot_num", this.F);
            } else {
                ChatEntranceGuideConfig.GuideConfig guideConfig2 = this.H;
                if (guideConfig2 != null) {
                    D2(guideConfig2);
                } else {
                    C2();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDestroyView();
            gh.a().removeCallbacks(this.N);
            gh.a().removeCallbacks(this.O);
            MessageManager.getInstance().unRegisterListener(this.K);
            MessageManager.getInstance().unRegisterListener(this.I);
            MessageManager.getInstance().unRegisterListener(this.L);
            MessageManager.getInstance().unRegisterListener(this.x);
            MessageManager.getInstance().unRegisterListener(fq7.d);
            ip7 ip7Var = this.z;
            if (ip7Var != null) {
                ip7Var.j();
            }
        }
    }

    public boolean t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (!StringHelper.isTaday(p35.m().o("key_chat_group_entrance_hot_time", System.currentTimeMillis()))) {
                A2();
                return true;
            }
            long n = p35.m().n("key_chat_group_entrance_hot_num", 0);
            boolean i2 = p35.m().i("key_chat_group_entrance_click_daily" + this.n, false);
            if (this.F >= n && !i2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || this.e) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.a.c, "width", this.i, Q);
        animatorSet.playTogether(ofInt, ObjectAnimator.ofInt(this.a.c, "height", this.j, Q), ObjectAnimator.ofInt(this.a.c, "marginRight", this.h, R));
        animatorSet.addListener(new a(this));
        ofInt.addUpdateListener(new b(this));
        animatorSet.setDuration(600L).start();
    }

    public final void n2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || this.e) {
            return;
        }
        m mVar = this.a;
        t99.a(mVar.m, 10L, mVar.c, 10L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofInt(this.a.c, "width", Q, this.i), ObjectAnimator.ofInt(this.a.c, "height", Q, this.j), ObjectAnimator.ofInt(this.a.c, "marginRight", R, this.h));
        animatorSet.addListener(new c(this));
        animatorSet.setDuration(600L).start();
    }

    public void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.M == null) {
                this.M = new ArrayList();
            }
            this.M.clear();
            for (int i2 = 0; i2 < this.q.size(); i2++) {
                Long l2 = this.q.get(i2);
                HashMap hashMap = new HashMap();
                hashMap.put("room_id", l2);
                GroupChatRoomPojo c2 = al7.f().c(TbadkCoreApplication.getCurrentAccount(), l2.longValue());
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048598, this, i2) != null) || i2 == this.mSkinType) {
            return;
        }
        this.mSkinType = i2;
        this.k.setColor(SkinManager.getColor(R.color.CAM_X0207));
        this.a.c.setCardBackgroundColor(SkinManager.getColor(R.color.CAM_X0207));
        this.a.m.setBackground(this.k);
        SkinManager.setImageResource(this.a.v, R.drawable.chat_group_mask_guide);
        this.a.n.setRadius(R.dimen.tbds134);
        this.a.n.setSkinType(this.mSkinType);
        I2();
        p15.d(this.a.i).f(R.color.CAM_X0334);
        p15.d(this.a.j).f(R.color.CAM_X0334);
        SkinManager.setBackgroundColor(this.a.l, R.color.transparent);
        if (this.mSkinType == 0) {
            this.a.c.setElevation(UtilHelper.getDimenPixelSize(R.dimen.tbds21));
            this.a.m.setElevation(UtilHelper.getDimenPixelSize(R.dimen.tbds16));
        }
        p15 d2 = p15.d(this.a.q);
        d2.A(R.string.F_X02);
        d2.v(R.color.CAM_X0101);
        d2.z(R.dimen.T_X09);
        p15 d3 = p15.d(this.a.s);
        d3.A(R.string.F_X02);
        d3.v(R.color.CAM_X0105);
        d3.z(R.dimen.T_X08);
        p15 d4 = p15.d(this.a.t);
        d4.A(R.string.F_X01);
        d4.v(R.color.CAM_X0107);
        d4.z(R.dimen.T_X09);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f09063d || view2.getId() == R.id.obfuscated_res_0x7f090642 || view2.getId() == R.id.obfuscated_res_0x7f09062d) {
                if (TbadkCoreApplication.isLogin()) {
                    wg5 wg5Var = this.y;
                    if (wg5Var != null) {
                        wg5Var.a(getPageContext(), Collections.unmodifiableList(this.q), this.n, this.o, -1L, this.p, this.D);
                    }
                } else {
                    this.f = true;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) TbadkCoreApplication.getInst(), true)));
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f09063d && view2.getId() != R.id.obfuscated_res_0x7f090642) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                dq7.b("c15073", this.n, this.o, null, i2, "2");
                p35 m2 = p35.m();
                m2.w("key_chat_group_entrance_click_daily" + this.n, true);
                I2();
                p2();
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09062d) {
                G2(V);
                this.a.r.setVisibility(8);
                this.a.q.setVisibility(8);
                this.B = true;
                this.v.put(Long.valueOf(this.n), new Date(System.currentTimeMillis()));
                TbSingleton.getInstance().setHasShowRedPot(this.v);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onCreate(bundle);
            q2();
            if (this.l == null) {
                this.l = new PollingModel(getPageContext(), getUniqueId());
            }
            gh.a().removeCallbacks(this.N);
            gh.a().post(this.N);
            registerListener(this.K);
            registerListener(this.I);
            registerListener(this.L);
            registerListener(this.x);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02d8, viewGroup, false);
            this.a = m.a(inflate);
            r2();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    public final void v2(TbImageView tbImageView, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048611, this, tbImageView, i2, str, str2) == null) {
            w2(tbImageView, i2, null, null, str, str2);
        }
    }

    public final void w2(TbImageView tbImageView, int i2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{tbImageView, Integer.valueOf(i2), str, str2, str3, str4}) == null) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                if (this.mSkinType != 0) {
                    str = str2;
                }
                p35.m().A("key_chat_group_entrance_hot_time", System.currentTimeMillis());
            } else if (!StringUtils.isNull(str3) && !StringUtils.isNull(str4)) {
                if (this.mSkinType != 0) {
                    str3 = str4;
                }
                str = str3;
            } else {
                str = null;
            }
            Glide.with(this).load(str).apply((BaseRequestOptions<?>) new RequestOptions().error(i2).placeholder(i2)).into(tbImageView);
        }
    }

    @Override // com.baidu.tieba.tg5.b
    public void x1(long j2, String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Long.valueOf(j2), str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.p = z;
            this.D = z2;
            if (StringUtils.isNull(this.o)) {
                this.o = str;
            }
            if (this.n == 0 && j2 > 0 && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && !this.E) {
                gh.a().removeCallbacks(this.N);
                gh.a().post(this.N);
            }
            this.n = j2;
            this.z = new ip7(getContext(), this.J, false);
        }
    }

    @Override // com.baidu.tieba.tg5.b
    public void z(ChatRoomEntranceData chatRoomEntranceData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, chatRoomEntranceData) == null) && chatRoomEntranceData != null && !ListUtils.isEmpty(chatRoomEntranceData.getChatRoomInfoList())) {
            if (!ListUtils.isEmpty(chatRoomEntranceData.getHotRoomList())) {
                this.q.clear();
                this.q.addAll(chatRoomEntranceData.getHotRoomList());
            }
            if (!this.C && this.z != null && this.n > 0) {
                this.a.q.setVisibility(8);
                this.z.v(this.q, TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.n));
                this.C = true;
            }
            List<ChatRoomInfoData> chatRoomInfoList = chatRoomEntranceData.getChatRoomInfoList();
            this.u = chatRoomInfoList;
            this.c.c(chatRoomInfoList);
            if (chatRoomEntranceData.getGuideConfig() != null) {
                this.F = chatRoomEntranceData.getGuideConfig().getHotNum();
                this.G = chatRoomEntranceData.getGuideConfig().getHotConfig();
                this.H = chatRoomEntranceData.getGuideConfig().getManualConfig();
                I2();
            }
            if (this.a.b.getAdapter() == null) {
                this.a.b.setAdapter(this.c);
            }
        }
    }
}

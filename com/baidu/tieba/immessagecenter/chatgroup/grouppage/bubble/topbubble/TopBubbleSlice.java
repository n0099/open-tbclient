package com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.a55;
import com.baidu.tieba.br8;
import com.baidu.tieba.c55;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.adapter.ExcellentAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.nab;
import com.baidu.tieba.vm8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class TopBubbleSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener A;
    @NonNull
    public final TbPageContext<BaseFragmentActivity> j;
    public GroupChatFragment k;
    public final ChatPage l;
    @NonNull
    public final List<TopBubbleData> m;
    public List<TopBubbleData> n;
    public j o;
    public String p;
    public TBAlertBuilder q;
    public k r;
    public String s;
    @Nullable
    public TopBubbleData t;
    public PopupWindow u;
    public boolean v;
    public boolean w;
    @Nullable
    public ExcellentAdapter x;
    public boolean y;
    public final CustomMessageListener z;

    /* loaded from: classes6.dex */
    public class g implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopBubbleSlice a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.y = false;
                if (this.a.a.t != null) {
                    this.a.a.o.b.c(this.a.a.t, this.a.a.v, this.a.a.G0());
                }
                this.a.a.Q0(true);
            }
        }

        public g(TopBubbleSlice topBubbleSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topBubbleSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topBubbleSlice;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SafeHandler.getInst().postDelayed(new a(this), 100L);
                this.a.Q0(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopBubbleSlice a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TopBubbleSlice topBubbleSlice, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topBubbleSlice, Integer.valueOf(i)};
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
            this.a = topBubbleSlice;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof TopBubbleData)) {
                TopBubbleData topBubbleData = (TopBubbleData) customResponsedMessage.getData();
                if (!topBubbleData.isNotice()) {
                    if (!this.a.B0(topBubbleData.getVersionKey())) {
                        return;
                    }
                    if (!topBubbleData.isSetExcellent()) {
                        this.a.O0(topBubbleData);
                        return;
                    }
                }
                if (this.a.t == null) {
                    this.a.m.add(0, topBubbleData);
                    this.a.t = topBubbleData;
                    TopBubbleSlice topBubbleSlice = this.a;
                    topBubbleSlice.v = topBubbleSlice.t.isNotice();
                    this.a.V0();
                } else if (this.a.t.isNotice()) {
                    if (!topBubbleData.isNotice()) {
                        this.a.m.add(1, topBubbleData);
                        this.a.w = true;
                        this.a.V0();
                        this.a.E0();
                        return;
                    }
                    this.a.t = topBubbleData;
                    this.a.V0();
                } else {
                    this.a.m.add(0, topBubbleData);
                    this.a.D0();
                    this.a.E0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopBubbleSlice a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TopBubbleSlice topBubbleSlice, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topBubbleSlice, Integer.valueOf(i)};
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
            this.a = topBubbleSlice;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.t != null && this.a.t.isNotice()) {
                boolean z = true;
                vm8.b(this.a.t.getVersionKey(), true);
                this.a.m.remove(this.a.t);
                if (this.a.m.size() > 0) {
                    TopBubbleSlice topBubbleSlice = this.a;
                    topBubbleSlice.t = (TopBubbleData) topBubbleSlice.m.get(0);
                    TopBubbleSlice topBubbleSlice2 = this.a;
                    topBubbleSlice2.v = topBubbleSlice2.t.isNotice();
                    TopBubbleSlice topBubbleSlice3 = this.a;
                    topBubbleSlice3.w = (topBubbleSlice3.m.size() <= 1 || !this.a.J0()) ? false : false;
                    if (this.a.y) {
                        if (!this.a.w) {
                            this.a.u.dismiss();
                            this.a.V0();
                            return;
                        }
                        this.a.V0();
                        this.a.E0();
                        return;
                    }
                    this.a.V0();
                    return;
                }
                this.a.P0();
                this.a.k.K2().setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopBubbleSlice a;

        public c(TopBubbleSlice topBubbleSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topBubbleSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topBubbleSlice;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TopBubbleData topBubbleData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!this.a.y) {
                    if (this.a.w && this.a.J0()) {
                        if (this.a.t != null) {
                            this.a.o.b.c(this.a.t, this.a.v, true);
                        }
                        if (!this.a.m.isEmpty() && (topBubbleData = (TopBubbleData) this.a.m.get(0)) != null) {
                            if (topBubbleData.isNotice() && this.a.m.size() > 1) {
                                topBubbleData = (TopBubbleData) this.a.m.get(1);
                            }
                            if (!this.a.B0(topBubbleData.getVersionKey())) {
                                return;
                            }
                            this.a.S0();
                            return;
                        }
                        return;
                    }
                    this.a.K0();
                    return;
                }
                this.a.K0();
                this.a.u.dismiss();
                this.a.y = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopBubbleSlice a;

        public d(TopBubbleSlice topBubbleSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topBubbleSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topBubbleSlice;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            TopBubbleData topBubbleData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (!this.a.m.isEmpty() && (topBubbleData = (TopBubbleData) this.a.m.get(0)) != null && (!topBubbleData.isNotice() || this.a.w)) {
                    this.a.R0();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ExcellentAdapter.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopBubbleSlice a;

        public e(TopBubbleSlice topBubbleSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topBubbleSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topBubbleSlice;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.adapter.ExcellentAdapter.c
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) {
                return;
            }
            this.a.R0();
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.adapter.ExcellentAdapter.c
        public void a(int i) {
            TopBubbleData topBubbleData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || (topBubbleData = this.a.n.get(i)) == null) {
                return;
            }
            vm8.b(topBubbleData.getVersionKey(), true);
            this.a.l.i1(topBubbleData);
            this.a.l.b1(topBubbleData.getMsgId(), topBubbleData.getMsgKey());
            this.a.u.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopBubbleSlice a;

        public f(TopBubbleSlice topBubbleSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topBubbleSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topBubbleSlice;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.Q0(true);
            this.a.u.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class h implements c55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a55 a;
        public final /* synthetic */ TopBubbleSlice b;

        public h(TopBubbleSlice topBubbleSlice, a55 a55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topBubbleSlice, a55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = topBubbleSlice;
            this.a = a55Var;
        }

        @Override // com.baidu.tieba.c55.f
        public void J0(c55 c55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, c55Var, i, view2) == null) {
                if (i != 0) {
                    if (i != 1) {
                        return;
                    }
                    this.b.T0();
                    this.a.dismiss();
                } else if (!StringUtils.isNull(this.b.p) && !StringUtils.isNull(this.b.s)) {
                    UrlManager.getInstance().dealOneLink(this.b.j, new String[]{TopBubbleSlice.L0(nab.a(nab.a(TbConfig.URL_EXCELLENT_ROOM, "roomId", this.b.s), "forumId", this.b.p))});
                    this.a.dismiss();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopBubbleSlice a;

        public i(TopBubbleSlice topBubbleSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topBubbleSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topBubbleSlice;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.I0();
            br8.a(this.a.j.getPageActivity());
        }
    }

    /* loaded from: classes6.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TopBubbleView b;
        public ConstraintLayout c;
        public ImageView d;
        public ImageView e;

        public j() {
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

        public static j a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                j jVar = new j();
                jVar.a = view2;
                jVar.b = (TopBubbleView) view2.findViewById(R.id.obfuscated_res_0x7f0919ad);
                jVar.c = (ConstraintLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906bc);
                jVar.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09231b);
                jVar.e = (ImageView) view2.findViewById(R.id.bg_view);
                return jVar;
            }
            return (j) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public RelativeLayout b;
        public RecyclerView c;
        public LinearLayout d;
        public LinearLayout e;
        public ImageView f;

        public k() {
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

        @NonNull
        public static k a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                k kVar = new k();
                kVar.a = view2;
                kVar.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d09);
                RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090a91);
                kVar.c = recyclerView;
                recyclerView.setLayoutManager(new LinearLayoutManager(view2.getContext()));
                kVar.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a92);
                kVar.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a93);
                kVar.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a41);
                kVar.b();
                return kVar;
            }
            return (k) invokeL.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundResource(this.b, R.drawable.pic_mask_chat_notice_bg);
                SkinManager.setImageResource(this.f, R.drawable.obfuscated_res_0x7f080618);
                EMManager.from(this.c).setBorderWidth(R.dimen.L_X02).setCorner(R.string.J_X05);
                EMManager.from(this.d).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0207);
            }
        }
    }

    public TopBubbleSlice(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, GroupChatFragment groupChatFragment, ChatPage chatPage) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, groupChatFragment, chatPage};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new LinkedList();
        this.n = null;
        this.t = null;
        this.v = false;
        this.w = false;
        this.y = false;
        this.z = new a(this, 2921796);
        this.A = new b(this, 2921795);
        this.j = tbPageContext;
        this.k = groupChatFragment;
        this.l = chatPage;
    }

    public static String L0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String str2 = "?";
            try {
                Uri parse = Uri.parse(str);
                String fragment = parse.getFragment();
                String query = parse.getQuery();
                if (fragment != null) {
                    if (fragment.contains("?")) {
                        str2 = "&";
                    }
                    if (!TextUtils.isEmpty(query)) {
                        return str.substring(0, str.indexOf("#")) + "&time=" + System.currentTimeMillis() + "#" + fragment + str2;
                    }
                    return str.substring(0, str.indexOf("#")) + "?time=" + System.currentTimeMillis() + "#" + fragment + str2;
                }
                return str;
            } catch (Exception e2) {
                BdLog.d("parseRouterUrl Exception " + e2);
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void V(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, view2, bundle) == null) {
            super.V(view2, bundle);
            if (view2 != null) {
                this.o = j.a(view2);
            }
            MessageManager.getInstance().registerListener(this.A);
            MessageManager.getInstance().registerListener(this.z);
            U0();
        }
    }

    public final void Q0(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            ImageView imageView = this.o.d;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.x == null) {
            ExcellentAdapter excellentAdapter = new ExcellentAdapter(this.j);
            this.x = excellentAdapter;
            excellentAdapter.o(new e(this));
        }
    }

    public List C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.m;
        }
        return (List) invokeV.objValue;
    }

    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.v = false;
            this.w = false;
            this.y = false;
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.o.b.setOnClickListener(new c(this));
            this.o.b.setOnLongClickListener(new d(this));
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.A);
            MessageManager.getInstance().unRegisterListener(this.z);
        }
    }

    public final boolean B0(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (StringUtils.isNull(str) || (split = str.split(":")) == null || split.length != 3) {
                return true;
            }
            long j2 = JavaTypesHelper.toLong(split[2].trim(), 0L);
            if (j2 > SharedPrefHelper.getInstance().getLong(SharedPrefHelper.getSharedPrefKeyWithAccount("excellent_" + this.s), 0L)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void F0(@NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, chatRoomDetail) != null) || ListUtils.isEmpty(chatRoomDetail.getChatBubbleData())) {
            return;
        }
        if (chatRoomDetail.getBasicInfo() != null) {
            this.p = String.valueOf(chatRoomDetail.getBasicInfo().getForumId());
            this.s = String.valueOf(chatRoomDetail.getBasicInfo().getId());
        }
        this.m.clear();
        this.m.addAll(chatRoomDetail.getChatBubbleData());
        D0();
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!ListUtils.isEmpty(this.m)) {
                boolean z = false;
                TopBubbleData topBubbleData = this.m.get(0);
                this.t = topBubbleData;
                if (topBubbleData != null) {
                    boolean isNotice = topBubbleData.isNotice();
                    this.v = isNotice;
                    if (isNotice && vm8.a(this.t.getVersionKey())) {
                        this.m.remove(this.t);
                        if (this.m.size() > 0) {
                            this.v = false;
                            this.t = this.m.get(0);
                        } else {
                            this.t = null;
                            return;
                        }
                    }
                    if (this.m.size() > 1 && J0()) {
                        z = true;
                    }
                    this.w = z;
                    V0();
                    return;
                }
                return;
            }
            P0();
            this.k.K2().setVisibility(8);
        }
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.n == null) {
                this.n = new ArrayList();
            }
            this.n.clear();
            if (this.m.size() > 1) {
                if (this.v) {
                    if (this.m.size() >= 6) {
                        this.n.addAll(this.m.subList(1, 6));
                    } else {
                        List<TopBubbleData> list = this.n;
                        List<TopBubbleData> list2 = this.m;
                        list.addAll(list2.subList(1, list2.size()));
                    }
                } else if (this.m.size() >= 5) {
                    this.n.addAll(this.m.subList(1, 5));
                } else {
                    List<TopBubbleData> list3 = this.n;
                    List<TopBubbleData> list4 = this.m;
                    list3.addAll(list4.subList(1, list4.size()));
                }
            }
            ExcellentAdapter excellentAdapter = this.x;
            if (excellentAdapter != null) {
                excellentAdapter.setData(this.n);
            }
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            TopBubbleData topBubbleData = this.t;
            if (topBubbleData != null && topBubbleData.isNotice()) {
                this.k.s2();
                UrlManager.getInstance().dealOneLink(this.j, new String[]{this.t.getJumpTo()});
                TiebaStatic.log(new StatisticItem("c15201"));
                return;
            }
            this.o.b.setExcellentRead();
            TopBubbleData topBubbleData2 = this.t;
            if (topBubbleData2 != null) {
                if (!vm8.a(topBubbleData2.getVersionKey())) {
                    vm8.b(this.t.getVersionKey(), true);
                }
                this.l.b1(this.t.getMsgId(), this.t.getMsgKey());
            }
        }
    }

    public final void N0() {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            TopBubbleData topBubbleData = this.m.get(0);
            if (topBubbleData.isNotice()) {
                topBubbleData = this.m.get(1);
            }
            if (topBubbleData != null && !topBubbleData.isNotice()) {
                String versionKey = topBubbleData.getVersionKey();
                if (!StringUtils.isNull(versionKey) && (split = versionKey.split(":")) != null && split.length == 3) {
                    SharedPrefHelper.getInstance().putLong(SharedPrefHelper.getSharedPrefKeyWithAccount("excellent_" + this.s), JavaTypesHelper.toLong(split[2].trim(), 0L));
                }
            }
        }
    }

    public final void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.j.getPageActivity());
            this.q = tBAlertBuilder;
            tBAlertBuilder.setTitle(R.string.obfuscated_res_0x7f0f09c1);
            this.q.setDescStr(this.j.getString(R.string.obfuscated_res_0x7f0f09c5));
            this.q.setDescLightStyle(true);
            this.q.setOperateBtn(new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f09c3, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f09c4, TBAlertConfig.OperateBtnStyle.MAIN, new i(this)));
            this.q.setAutoClose();
            this.q.setCancelable(false);
            this.q.show();
        }
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TopBubbleData topBubbleData = this.t;
            if (topBubbleData != null) {
                boolean z = true;
                if (topBubbleData.isNotice()) {
                    this.o.b.c(this.t, this.v, G0());
                    Q0((this.y || !this.w) ? false : false);
                    this.k.K2().setVisibility(0);
                    return;
                } else if (B0(this.t.getVersionKey())) {
                    this.o.b.c(this.t, this.v, G0());
                    Q0((this.y || !this.w) ? false : false);
                    this.k.K2().setVisibility(0);
                    return;
                } else {
                    this.k.K2().setVisibility(8);
                    return;
                }
            }
            this.k.K2().setVisibility(8);
        }
    }

    public final boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.m.isEmpty() && ((this.m.size() == 1 || !J0()) && this.m.get(0).isNotice())) {
                return true;
            }
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public final boolean J0() {
        InterceptResult invokeV;
        TopBubbleData topBubbleData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.m.isEmpty() || (topBubbleData = this.m.get(0)) == null) {
                return false;
            }
            if (topBubbleData.isNotice() && this.m.size() > 1) {
                topBubbleData = this.m.get(1);
            }
            return B0(topBubbleData.getVersionKey());
        }
        return invokeV.booleanValue;
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            String[] strArr = {this.j.getString(R.string.obfuscated_res_0x7f0f0421), this.j.getString(R.string.obfuscated_res_0x7f0f09c1)};
            a55 a55Var = new a55(this.j);
            a55Var.i(null, strArr, new h(this, a55Var));
            a55Var.l();
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            N0();
            if (this.y) {
                this.u.dismiss();
            }
            if (this.m.size() > 0) {
                if (this.m.get(0).isNotice()) {
                    PopupWindow popupWindow = this.u;
                    if (popupWindow != null) {
                        popupWindow.dismiss();
                    }
                    this.o.b.c(this.t, this.v, G0());
                    Q0(false);
                    return;
                }
                this.k.K2().setVisibility(8);
                return;
            }
            this.k.K2().setVisibility(8);
        }
    }

    public final void O0(TopBubbleData topBubbleData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, topBubbleData) == null) {
            long msgId = topBubbleData.getMsgId();
            Iterator<TopBubbleData> it = this.m.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TopBubbleData next = it.next();
                if (!next.isNotice() && next.getMsgId() == msgId) {
                    it.remove();
                    break;
                }
            }
            boolean z = false;
            if (this.m.size() > 0) {
                this.t = this.m.get(0);
            } else {
                this.t = null;
            }
            if (this.m.size() > 1 && J0()) {
                z = true;
            }
            this.w = z;
            V0();
            E0();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public View P(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d099f, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            A0();
            if (this.r == null) {
                k a2 = k.a(LayoutInflater.from(this.j.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0124, (ViewGroup) null));
                this.r = a2;
                a2.e.setOnClickListener(new f(this));
                this.r.c.setAdapter(this.x);
            }
            E0();
            if (this.u == null) {
                PopupWindow popupWindow = new PopupWindow();
                this.u = popupWindow;
                popupWindow.setContentView(this.r.a);
                this.u.setWidth(-1);
                this.u.setHeight(-2);
                this.u.setFocusable(false);
                this.u.setOutsideTouchable(true);
                this.u.setOnDismissListener(new g(this));
                this.u.setAnimationStyle(R.style.obfuscated_res_0x7f1003fb);
            }
            this.o.b.measure(0, 0);
            int measuredWidth = this.o.b.getMeasuredWidth();
            int measuredHeight = this.o.b.getMeasuredHeight();
            int[] iArr = new int[2];
            this.o.b.getLocationOnScreen(iArr);
            this.u.showAtLocation(this.o.b, 0, (iArr[0] + (measuredWidth / 2)) - (this.u.getWidth() / 2), iArr[1] + measuredHeight);
            this.y = true;
            Q0(false);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    @SuppressLint({"NotifyDataSetChanged"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            super.onChangeSkinType(i2);
            TopBubbleView topBubbleView = this.o.b;
            if (topBubbleView != null) {
                topBubbleView.b();
            }
            TBAlertBuilder tBAlertBuilder = this.q;
            if (tBAlertBuilder != null) {
                tBAlertBuilder.onChangeSkinType();
            }
            k kVar = this.r;
            if (kVar != null) {
                kVar.b();
            }
            ExcellentAdapter excellentAdapter = this.x;
            if (excellentAdapter != null) {
                excellentAdapter.notifyDataSetChanged();
            }
            SkinManager.setImageResource(this.o.e, R.drawable.pic_mask_chat_notice_bg);
            SkinManager.setImageResource(this.o.d, R.drawable.top_bubble_excellent_bg);
        }
    }
}

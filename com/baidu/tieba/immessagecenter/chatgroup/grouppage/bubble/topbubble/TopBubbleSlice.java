package com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ds8;
import com.baidu.tieba.g55;
import com.baidu.tieba.i55;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.adapter.PinnedOverlayAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble.TopBubbleView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.vcb;
import com.baidu.tieba.xn8;
import com.baidu.tieba.yn8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class TopBubbleSlice extends Slice implements xn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbPageContext<BaseFragmentActivity> j;
    public GroupChatFragment k;
    public final ChatPage l;
    public f m;
    public String n;
    public TBAlertBuilder o;
    public g p;
    public final String q;
    public PopupWindow r;
    @Nullable
    public PinnedOverlayAdapter s;
    @NonNull
    public final PinnedModel t;
    public boolean u;
    public boolean v;
    public final TopBubbleView.b w;
    public final View.OnClickListener x;
    public final PopupWindow.OnDismissListener y;

    /* loaded from: classes6.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopBubbleSlice a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.u = false;
                this.a.a.t.s(true);
                this.a.a.t0(true);
            }
        }

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

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SafeHandler.getInst().postDelayed(new a(this), 100L);
                this.a.t0(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements TopBubbleView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopBubbleSlice a;

        public a(TopBubbleSlice topBubbleSlice) {
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

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble.TopBubbleView.b
        public void a(View view2) {
            TopBubbleData topBubbleData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null || (topBubbleData = (TopBubbleData) view2.getTag(R.id.obfuscated_res_0x7f0906d6)) == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f0919c7) {
                this.a.u0();
            } else if (topBubbleData.isExcellent() || this.a.t.p()) {
                this.a.u0();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble.TopBubbleView.b
        public void b(View view2) {
            TopBubbleData topBubbleData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) != null) || view2 == null || (topBubbleData = (TopBubbleData) view2.getTag(R.id.obfuscated_res_0x7f0906d6)) == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f0919c7) {
                this.a.o0(topBubbleData);
                this.a.r.dismiss();
                this.a.t.s(true);
            } else if (this.a.u) {
                this.a.o0(topBubbleData);
                this.a.r.dismiss();
                this.a.u = false;
                this.a.t.s(true);
            } else if (!this.a.v) {
                this.a.o0(topBubbleData);
                this.a.t.s(false);
            } else {
                this.a.t.s(false);
                this.a.w0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopBubbleSlice a;

        public b(TopBubbleSlice topBubbleSlice) {
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
            this.a.t0(true);
            this.a.r.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements i55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g55 a;
        public final /* synthetic */ TopBubbleSlice b;

        public d(TopBubbleSlice topBubbleSlice, g55 g55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topBubbleSlice, g55Var};
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
            this.a = g55Var;
        }

        @Override // com.baidu.tieba.i55.f
        public void G0(i55 i55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, i55Var, i, view2) == null) {
                if (i != 0) {
                    if (i == 1) {
                        this.b.v0();
                        this.a.dismiss();
                    }
                } else if (!StringUtils.isNull(this.b.n) && !StringUtils.isNull(this.b.q)) {
                    UrlManager.getInstance().dealOneLink(this.b.j, new String[]{yn8.d(vcb.a(vcb.a(TbConfig.URL_EXCELLENT_ROOM, "roomId", this.b.q), "forumId", this.b.n))});
                    this.a.dismiss();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.t.n();
                ds8.b(this.a.j.getPageActivity());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TopBubbleView b;
        public ImageView c;

        public f() {
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

        public static f a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                f fVar = new f();
                fVar.a = view2;
                fVar.b = (TopBubbleView) view2.findViewById(R.id.obfuscated_res_0x7f0919c7);
                fVar.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09235b);
                return fVar;
            }
            return (f) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public RelativeLayout b;
        public RecyclerView c;
        public LinearLayout d;
        public LinearLayout e;
        public ImageView f;

        public g() {
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
        public static g a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                g gVar = new g();
                gVar.a = view2;
                gVar.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d29);
                RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090a89);
                gVar.c = recyclerView;
                recyclerView.setLayoutManager(new LinearLayoutManager(view2.getContext()));
                gVar.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a8a);
                gVar.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a8b);
                gVar.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a5b);
                gVar.b();
                return gVar;
            }
            return (g) invokeL.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundResource(this.b, R.drawable.pic_mask_chat_notice_bg);
                SkinManager.setImageResource(this.f, R.drawable.obfuscated_res_0x7f080625);
                EMManager.from(this.c).setBorderWidth(R.dimen.L_X02).setCorner(R.string.J_X05);
                EMManager.from(this.d).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0207);
            }
        }
    }

    public TopBubbleSlice(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, GroupChatFragment groupChatFragment, ChatPage chatPage, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, groupChatFragment, chatPage, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = false;
        this.v = false;
        this.w = new a(this);
        this.x = new b(this);
        this.y = new c(this);
        this.j = tbPageContext;
        this.k = groupChatFragment;
        this.l = chatPage;
        String valueOf = String.valueOf(j);
        this.q = valueOf;
        this.t = new PinnedModel(this, valueOf);
    }

    public void q0(@NonNull List<TopBubbleData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.t.o(list);
        }
    }

    public void s0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.n = String.valueOf(j);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void X(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bundle) == null) {
            super.X(view2, bundle);
            if (view2 != null) {
                this.m = f.a(view2);
            }
            this.m.b.setEventCallback(this.w);
            p0();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public View R(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d09b4, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.xn8
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k.M2().setVisibility(8);
            r0();
        }
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.t.f();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            this.t.t();
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.u = false;
        }
    }

    public final void o0(@NonNull TopBubbleData topBubbleData) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, topBubbleData) == null) {
            String pinnedType = topBubbleData.getPinnedType();
            int hashCode = pinnedType.hashCode();
            if (hashCode != -1655966961) {
                if (hashCode != -1420194824) {
                    if (hashCode == -1039690024 && pinnedType.equals("notice")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                } else {
                    if (pinnedType.equals(TopBubbleData.EXCELLENT)) {
                        c2 = 2;
                    }
                    c2 = 65535;
                }
            } else {
                if (pinnedType.equals("activity")) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 == 2) {
                        yn8.f(topBubbleData.getVersionKey(), true);
                        this.l.d1(topBubbleData.getMsgId(), topBubbleData.getMsgKey());
                        return;
                    }
                    return;
                }
                this.k.u2();
                UrlManager.getInstance().dealOneLink(this.j, new String[]{topBubbleData.getJumpTo()});
                TiebaStatic.log(new StatisticItem("c15201"));
                return;
            }
            UrlManager.getInstance().dealOneLink(this.j, new String[]{topBubbleData.getJumpTo()});
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    @SuppressLint({"NotifyDataSetChanged"})
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            TopBubbleView topBubbleView = this.m.b;
            if (topBubbleView != null) {
                topBubbleView.d();
            }
            this.t.q();
            TBAlertBuilder tBAlertBuilder = this.o;
            if (tBAlertBuilder != null) {
                tBAlertBuilder.onChangeSkinType();
            }
            g gVar = this.p;
            if (gVar != null) {
                gVar.b();
            }
            PinnedOverlayAdapter pinnedOverlayAdapter = this.s;
            if (pinnedOverlayAdapter != null) {
                pinnedOverlayAdapter.notifyDataSetChanged();
            }
            SkinManager.setBackgroundResource(this.m.a, R.drawable.pic_mask_chat_notice_bg);
            SkinManager.setImageResource(this.m.c, R.drawable.top_bubble_excellent_bg);
        }
    }

    @Override // com.baidu.tieba.xn8
    public void p(@NonNull List<TopBubbleData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.k.M2().setVisibility(0);
            TopBubbleData topBubbleData = list.get(0);
            this.m.b.setTag(R.id.obfuscated_res_0x7f0906d6, topBubbleData);
            this.m.b.c(topBubbleData);
            int size = list.size();
            if (size > 1) {
                this.v = true;
                if (!this.u) {
                    t0(true);
                }
                PinnedOverlayAdapter pinnedOverlayAdapter = this.s;
                if (pinnedOverlayAdapter != null) {
                    pinnedOverlayAdapter.setData(list.subList(1, size));
                    return;
                }
                return;
            }
            this.v = false;
            t0(false);
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            PinnedOverlayAdapter pinnedOverlayAdapter = new PinnedOverlayAdapter();
            this.s = pinnedOverlayAdapter;
            pinnedOverlayAdapter.n(this.w);
            g a2 = g.a(LayoutInflater.from(this.j.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0129, (ViewGroup) null));
            this.p = a2;
            a2.e.setOnClickListener(this.x);
            this.p.c.setAdapter(this.s);
            PopupWindow popupWindow = new PopupWindow();
            this.r = popupWindow;
            popupWindow.setContentView(this.p.a);
            this.r.setWidth(-1);
            this.r.setHeight(-2);
            this.r.setFocusable(false);
            this.r.setOutsideTouchable(true);
            this.r.setOnDismissListener(this.y);
            this.r.setAnimationStyle(R.style.obfuscated_res_0x7f100404);
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.j.getPageActivity());
            this.o = tBAlertBuilder;
            tBAlertBuilder.setTitle(R.string.obfuscated_res_0x7f0f09c7);
            this.o.setDescStr(this.j.getString(R.string.obfuscated_res_0x7f0f09cb));
            this.o.setDescLightStyle(true);
            this.o.setOperateBtn(new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f09c9, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f09ca, TBAlertConfig.OperateBtnStyle.MAIN, new e(this)));
            this.o.setAutoClose();
            this.o.setCancelable(false);
            this.o.show();
        }
    }

    public final void t0(boolean z) {
        int i;
        int dimenPixelSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            ImageView imageView = this.m.c;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
            if (z) {
                dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds156);
            } else {
                dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds136);
            }
            ViewGroup.LayoutParams layoutParams = this.m.a.getLayoutParams();
            layoutParams.height = dimenPixelSize;
            this.m.a.setLayoutParams(layoutParams);
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            String[] strArr = {this.j.getString(R.string.obfuscated_res_0x7f0f0423), this.j.getString(R.string.obfuscated_res_0x7f0f09c7)};
            g55 g55Var = new g55(this.j);
            g55Var.i(null, strArr, new d(this, g55Var));
            g55Var.l();
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.m.b.measure(0, 0);
            int measuredWidth = this.m.b.getMeasuredWidth();
            int measuredHeight = this.m.b.getMeasuredHeight();
            int[] iArr = new int[2];
            this.m.b.getLocationOnScreen(iArr);
            int i = iArr[1] + measuredHeight;
            this.r.showAtLocation(this.m.b, 0, (iArr[0] + (measuredWidth / 2)) - (this.r.getWidth() / 2), i);
            this.u = true;
            t0(false);
        }
    }
}

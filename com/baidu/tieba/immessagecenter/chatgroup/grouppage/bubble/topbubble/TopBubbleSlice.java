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
import com.baidu.tieba.e59;
import com.baidu.tieba.frb;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.im.lib.socket.msg.data.TopBubbleData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.adapter.PinnedOverlayAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble.TopBubbleView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.n05;
import com.baidu.tieba.p05;
import com.baidu.tieba.u39;
import com.baidu.tieba.v39;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class TopBubbleSlice extends Slice implements u39 {
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
                this.a.a.w0(true);
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
                this.a.w0(false);
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null || (topBubbleData = (TopBubbleData) view2.getTag(R.id.obfuscated_res_0x7f090725)) == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f091a9a) {
                this.a.x0();
            } else if (topBubbleData.isExcellent() || this.a.t.p()) {
                this.a.x0();
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble.TopBubbleView.b
        public void b(View view2) {
            TopBubbleData topBubbleData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) != null) || view2 == null || (topBubbleData = (TopBubbleData) view2.getTag(R.id.obfuscated_res_0x7f090725)) == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f091a9a) {
                this.a.r0(topBubbleData);
                this.a.r.dismiss();
                this.a.t.s(true);
            } else if (this.a.u) {
                this.a.r0(topBubbleData);
                this.a.r.dismiss();
                this.a.u = false;
                this.a.t.s(true);
            } else if (!this.a.v) {
                this.a.r0(topBubbleData);
                this.a.t.s(false);
            } else {
                this.a.t.s(false);
                this.a.z0();
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
            this.a.w0(true);
            this.a.r.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n05 a;
        public final /* synthetic */ TopBubbleSlice b;

        public d(TopBubbleSlice topBubbleSlice, n05 n05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topBubbleSlice, n05Var};
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
            this.a = n05Var;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                if (i != 0) {
                    if (i == 1) {
                        this.b.y0();
                        this.a.dismiss();
                    }
                } else if (!StringUtils.isNull(this.b.n) && !StringUtils.isNull(this.b.q)) {
                    UrlManager.getInstance().dealOneLink(this.b.j, new String[]{v39.d(frb.a(frb.a(TbConfig.URL_EXCELLENT_ROOM, "roomId", this.b.q), "forumId", this.b.n))});
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
                e59.b(this.a.j.getPageActivity());
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
                fVar.b = (TopBubbleView) view2.findViewById(R.id.obfuscated_res_0x7f091a9a);
                fVar.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09240b);
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
                gVar.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091dde);
                RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090add);
                gVar.c = recyclerView;
                recyclerView.setLayoutManager(new LinearLayoutManager(view2.getContext()));
                gVar.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090ade);
                gVar.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090adf);
                gVar.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b2e);
                gVar.b();
                return gVar;
            }
            return (g) invokeL.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundResource(this.b, R.drawable.pic_mask_chat_notice_bg);
                SkinManager.setImageResource(this.f, R.drawable.obfuscated_res_0x7f080630);
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

    public void t0(@NonNull List<TopBubbleData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.t.o(list);
        }
    }

    public void v0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.n = String.valueOf(j);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void a0(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bundle) == null) {
            super.a0(view2, bundle);
            if (view2 != null) {
                this.m = f.a(view2);
            }
            this.m.b.setEventCallback(this.w);
            s0();
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public View U(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d09d6, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.u39
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k.x3().setVisibility(8);
            u0();
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            this.t.t();
        }
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.t.f();
        }
        return invokeV.booleanValue;
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.u = false;
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    @SuppressLint({"NotifyDataSetChanged"})
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
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

    @Override // com.baidu.tieba.u39
    public void r(@NonNull List<TopBubbleData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.k.x3().setVisibility(0);
            TopBubbleData topBubbleData = list.get(0);
            this.m.b.setTag(R.id.obfuscated_res_0x7f090725, topBubbleData);
            this.m.b.c(topBubbleData);
            int size = list.size();
            if (size > 1) {
                this.v = true;
                if (!this.u) {
                    w0(true);
                }
                PinnedOverlayAdapter pinnedOverlayAdapter = this.s;
                if (pinnedOverlayAdapter != null) {
                    pinnedOverlayAdapter.setData(list.subList(1, size));
                    return;
                }
                return;
            }
            this.v = false;
            w0(false);
        }
    }

    public final void r0(@NonNull TopBubbleData topBubbleData) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, topBubbleData) == null) {
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
                        v39.f(topBubbleData.getVersionKey(), true);
                        this.l.i1(topBubbleData.getMsgId(), topBubbleData.getMsgKey());
                        return;
                    }
                    return;
                }
                this.k.h3();
                UrlManager.getInstance().dealOneLink(this.j, new String[]{topBubbleData.getJumpTo()});
                TiebaStatic.log(new StatisticItem("c15201"));
                return;
            }
            UrlManager.getInstance().dealOneLink(this.j, new String[]{topBubbleData.getJumpTo()});
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            PinnedOverlayAdapter pinnedOverlayAdapter = new PinnedOverlayAdapter();
            this.s = pinnedOverlayAdapter;
            pinnedOverlayAdapter.o(this.w);
            g a2 = g.a(LayoutInflater.from(this.j.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d012a, (ViewGroup) null));
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
            this.r.setAnimationStyle(R.style.obfuscated_res_0x7f100401);
        }
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.j.getPageActivity());
            this.o = tBAlertBuilder;
            tBAlertBuilder.setTitle(R.string.obfuscated_res_0x7f0f09ec);
            this.o.setDescStr(this.j.getString(R.string.obfuscated_res_0x7f0f09f0));
            this.o.setDescLightStyle(true);
            this.o.setOperateBtn(new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f09ee, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f09ef, TBAlertConfig.OperateBtnStyle.MAIN, new e(this)));
            this.o.setAutoClose();
            this.o.setCancelable(false);
            this.o.show();
        }
    }

    public final void w0(boolean z) {
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

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            String[] strArr = {this.j.getString(R.string.obfuscated_res_0x7f0f042e), this.j.getString(R.string.obfuscated_res_0x7f0f09ec)};
            n05 n05Var = new n05(this.j);
            n05Var.i(null, strArr, new d(this, n05Var));
            n05Var.l();
        }
    }

    public final void z0() {
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
            w0(false);
        }
    }
}

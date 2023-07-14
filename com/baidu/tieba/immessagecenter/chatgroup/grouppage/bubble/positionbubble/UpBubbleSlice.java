package com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.positionbubble;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.RecyclerViewTypeAdapter;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.al8;
import com.baidu.tieba.bl8;
import com.baidu.tieba.d85;
import com.baidu.tieba.immessagecenter.chatgroup.data.AtInfoMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.yn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes6.dex */
public class UpBubbleSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GroupChatFragment j;
    public d k;
    public GroupChatRepo l;
    public GroupChatRepo.v<TreeSet<ChatMsg>> m;
    @NonNull
    public final bl8 n;
    public String o;
    public boolean p;
    public long q;
    public String r;
    public final ChatPage s;

    /* loaded from: classes6.dex */
    public class a implements al8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UpBubbleSlice a;

        public a(UpBubbleSlice upBubbleSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {upBubbleSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = upBubbleSlice;
        }

        @Override // com.baidu.tieba.al8
        public void a(BdTypeRecyclerView bdTypeRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) {
                int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
                List<yn> data = ((RecyclerViewTypeAdapter) bdTypeRecyclerView.getWrappedAdapter()).getData();
                if ((ListUtils.getItem(data, firstVisiblePosition) instanceof BaseMsg) && ((BaseMsg) ListUtils.getItem(data, firstVisiblePosition)).getCommonMsgField().getMsgId() == this.a.q) {
                    this.a.o0();
                }
            }
        }

        @Override // com.baidu.tieba.al8
        public void b(BdTypeRecyclerView bdTypeRecyclerView, GroupChatRepo groupChatRepo, GroupChatRepo.v<TreeSet<ChatMsg>> vVar) {
            RecyclerViewTypeAdapter recyclerViewTypeAdapter;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView, groupChatRepo, vVar) == null) {
                this.a.l = groupChatRepo;
                this.a.m = vVar;
                int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
                if (this.a.p && (recyclerViewTypeAdapter = (RecyclerViewTypeAdapter) bdTypeRecyclerView.getWrappedAdapter()) != null) {
                    List<yn> data = recyclerViewTypeAdapter.getData();
                    if (data.size() > 0 && firstVisiblePosition != -1) {
                        yn ynVar = data.get(firstVisiblePosition);
                        if ((ynVar instanceof BaseMsg) && ((BaseMsg) ynVar).getCommonMsgField().getMsgId() > this.a.q) {
                            this.a.k0();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UpBubbleSlice a;

        public b(UpBubbleSlice upBubbleSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {upBubbleSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = upBubbleSlice;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l.Z(this.a.q, this.a.r, this.a.m);
                this.a.o0();
                this.a.s.K0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UpBubbleSlice a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        public c(UpBubbleSlice upBubbleSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {upBubbleSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = upBubbleSlice;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.i0();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                this.a.k.d.setClickable(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TextView b;
        public ImageView c;
        public LinearLayout d;

        public d() {
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

        public static d a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                d dVar = new d();
                dVar.a = view2;
                dVar.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0927c9);
                dVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090502);
                dVar.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09050d);
                return dVar;
            }
            return (d) invokeL.objValue;
        }
    }

    public UpBubbleSlice(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, GroupChatFragment groupChatFragment, ChatPage chatPage) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, groupChatFragment, chatPage};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = Long.MAX_VALUE;
        this.j = groupChatFragment;
        this.s = chatPage;
        this.n = new bl8();
    }

    public void l0(ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, chatRoomDetail) == null) {
            this.n.c(chatRoomDetail);
            j0();
        }
    }

    public final void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            FrameLayout z2 = this.j.z2();
            if (z) {
                z2.setVisibility(0);
            } else {
                z2.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void U(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bundle) == null) {
            super.U(view2, bundle);
            if (view2 != null) {
                this.k = d.a(view2);
            }
            n0();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public View N(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d09ae, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.p = this.n.b();
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.k.d.getVisibility() == 0) {
                this.k.d.setVisibility(8);
            }
            m0(false);
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k.d.setVisibility(0);
            m0(true);
            this.k.b.setText(this.o);
            this.k.d.setOnClickListener(new b(this));
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.s.i1(new a(this));
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.p = false;
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 1000.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(1000L);
            this.k.d.startAnimation(translateAnimation);
            translateAnimation.setAnimationListener(new c(this));
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Map<String, AtInfoMsg> a2 = this.n.a();
            AtInfoMsg atInfoMsg = null;
            if (!a2.isEmpty()) {
                for (String str : a2.keySet()) {
                    this.o = str;
                    atInfoMsg = a2.get(str);
                }
            }
            if (atInfoMsg != null) {
                this.q = atInfoMsg.getMsgId();
                this.r = atInfoMsg.getMsgKey();
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
            this.k.c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.up_positioning_bubble_icon, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            d85 d2 = d85.d(this.k.d);
            d2.o(R.string.deprecated_J_X20);
            d2.f(R.color.CAM_X0207);
            d85 d3 = d85.d(this.k.b);
            d3.D(R.string.F_X01);
            d3.x(R.color.CAM_X0105);
            d3.C(R.dimen.T_X07);
        }
    }
}

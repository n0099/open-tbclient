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
import com.baidu.tieba.immessagecenter.chatgroup.data.AtInfo;
import com.baidu.tieba.immessagecenter.chatgroup.data.AtInfoMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.j88;
import com.baidu.tieba.p45;
import com.baidu.tieba.rn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
/* loaded from: classes6.dex */
public class UpBubbleSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GroupChatFragment j;
    public d k;
    public GroupChatRepo l;
    public GroupChatRepo.s<TreeSet<ChatMsg>> m;
    @Nullable
    public ChatRoomDetail n;
    public boolean o;
    public long p;
    public String q;
    public ChatPage r;

    /* loaded from: classes6.dex */
    public class a implements j88 {
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

        @Override // com.baidu.tieba.j88
        public void a(BdTypeRecyclerView bdTypeRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) {
                int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
                List<rn> data = ((RecyclerViewTypeAdapter) bdTypeRecyclerView.getWrappedAdapter()).getData();
                if ((ListUtils.getItem(data, firstVisiblePosition) instanceof BaseMsg) && ((BaseMsg) ListUtils.getItem(data, firstVisiblePosition)).getCommonMsgField().getMsgId() == this.a.p) {
                    this.a.o0();
                }
            }
        }

        @Override // com.baidu.tieba.j88
        public void b(BdTypeRecyclerView bdTypeRecyclerView, GroupChatRepo groupChatRepo, GroupChatRepo.s<TreeSet<ChatMsg>> sVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView, groupChatRepo, sVar) == null) {
                this.a.l = groupChatRepo;
                this.a.m = sVar;
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
                if (this.a.o) {
                    ArrayList arrayList = new ArrayList();
                    List<rn> data = ((RecyclerViewTypeAdapter) bdTypeRecyclerView.getWrappedAdapter()).getData();
                    if (data.size() > 0 && firstVisiblePosition != -1 && lastVisiblePosition != -1) {
                        while (firstVisiblePosition <= lastVisiblePosition) {
                            rn rnVar = data.get(firstVisiblePosition);
                            if (rnVar instanceof TextMsg) {
                                long msgId = ((TextMsg) rnVar).getCommonMsgField().getMsgId();
                                if (this.a.n != null && this.a.n.getAtInfo() != null) {
                                    if (this.a.n.getAtInfo().getAllMsgList() != null) {
                                        for (AtInfoMsg atInfoMsg : this.a.n.getAtInfo().getAllMsgList()) {
                                            if (atInfoMsg != null && msgId == atInfoMsg.getMsgId()) {
                                                arrayList.add(atInfoMsg);
                                            }
                                        }
                                    }
                                    if (this.a.n.getAtInfo().getSingleMsgList() != null) {
                                        for (AtInfoMsg atInfoMsg2 : this.a.n.getAtInfo().getSingleMsgList()) {
                                            if (atInfoMsg2 != null && msgId == atInfoMsg2.getMsgId()) {
                                                arrayList.add(atInfoMsg2);
                                            }
                                        }
                                    }
                                }
                            }
                            firstVisiblePosition++;
                        }
                        if (arrayList.isEmpty()) {
                            this.a.j0();
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
                this.a.l.T(this.a.p, this.a.q, this.a.m);
                this.a.o0();
                this.a.r.I0();
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
                dVar.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0926ee);
                dVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0904fb);
                dVar.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090506);
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
        this.j = groupChatFragment;
        this.r = chatPage;
    }

    public void l0(ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, chatRoomDetail) == null) {
            this.n = chatRoomDetail;
        }
    }

    public final void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            FrameLayout u2 = this.j.u2();
            if (z) {
                u2.setVisibility(0);
            } else {
                u2.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void T(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bundle) == null) {
            super.T(view2, bundle);
            if (view2 != null) {
                this.k = d.a(view2);
            }
            n0();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public View M(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0966, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    public void h0() {
        ChatRoomDetail chatRoomDetail;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (chatRoomDetail = this.n) != null) {
            boolean z = false;
            if (chatRoomDetail.getAtInfo() == null) {
                this.o = false;
            } else {
                this.o = (this.n.getAtInfo().getAllMsgCount() > 0 || this.n.getAtInfo().getSingleMsgCount() > 0) ? true : true;
            }
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

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.r.d1(new a(this));
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.o = false;
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 1000.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(1000L);
            this.k.d.startAnimation(translateAnimation);
            translateAnimation.setAnimationListener(new c(this));
        }
    }

    public final void j0() {
        AtInfoMsg atInfoMsg;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.n.getAtInfo() == null) {
            return;
        }
        this.k.d.setVisibility(0);
        m0(true);
        if (!k0()) {
            this.k.b.setText(R.string.obfuscated_res_0x7f0f03f9);
        } else {
            this.k.b.setText(R.string.obfuscated_res_0x7f0f03f8);
        }
        if (!k0()) {
            atInfoMsg = this.n.getAtInfo().getSingleMsgList().get(0);
        } else {
            atInfoMsg = this.n.getAtInfo().getAllMsgList().get(0);
        }
        if (atInfoMsg != null) {
            this.p = atInfoMsg.getMsgId();
            this.q = atInfoMsg.getMsgKey();
        }
        this.k.d.setOnClickListener(new b(this));
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.n;
            if (chatRoomDetail != null && chatRoomDetail.getAtInfo() != null) {
                AtInfo atInfo = this.n.getAtInfo();
                List<AtInfoMsg> singleMsgList = atInfo.getSingleMsgList();
                List<AtInfoMsg> allMsgList = atInfo.getAllMsgList();
                if (ListUtils.isEmpty(singleMsgList) && !ListUtils.isEmpty(allMsgList)) {
                    return true;
                }
                if (!ListUtils.isEmpty(singleMsgList) && !ListUtils.isEmpty(allMsgList) && singleMsgList.get(0).getMsgId() > allMsgList.get(0).getMsgId()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
            this.k.c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.up_positioning_bubble_icon, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            p45 d2 = p45.d(this.k.d);
            d2.o(R.string.deprecated_J_X20);
            d2.f(R.color.CAM_X0207);
            p45 d3 = p45.d(this.k.b);
            d3.C(R.string.F_X01);
            d3.w(R.color.CAM_X0105);
            d3.B(R.dimen.T_X07);
        }
    }
}

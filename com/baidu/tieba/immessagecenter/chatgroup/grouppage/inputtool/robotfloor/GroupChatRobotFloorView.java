package com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.d78;
import com.baidu.tieba.ga8;
import com.baidu.tieba.ha8;
import com.baidu.tieba.ia8;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.ChatRoomRecycleAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter.RobotItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter.RobotSkillRecentlyItem;
import com.baidu.tieba.oa8;
import com.baidu.tieba.p45;
import com.baidu.tieba.pa8;
import com.baidu.tieba.q11;
import com.baidu.tieba.ri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class GroupChatRobotFloorView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<BaseFragmentActivity> b;
    public LinearLayout c;
    public RelativeLayout d;
    public View e;
    public LinearLayout f;
    public RoundTbImageView g;
    public TextView h;
    public RecyclerView i;
    public TabLayout j;
    public long k;
    public long l;
    public ChatRoomRecycleAdapter m;
    public ha8 n;
    public f o;
    public LinearLayoutManager p;
    public TabLayout.OnTabSelectedListener q;
    public final HashMap<String, TabLayout.Tab> r;
    public pa8 s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;

    /* loaded from: classes6.dex */
    public interface f {
        void a(String str, int i, int i2);
    }

    /* loaded from: classes6.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRobotFloorView a;

        public a(GroupChatRobotFloorView groupChatRobotFloorView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRobotFloorView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatRobotFloorView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i != 0) {
                    return;
                }
                this.a.u = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (this.a.t) {
                    this.a.t = false;
                    this.a.q();
                }
                int findFirstVisibleItemPosition = this.a.p.findFirstVisibleItemPosition();
                if (findFirstVisibleItemPosition == this.a.x || this.a.n == null) {
                    return;
                }
                this.a.x = findFirstVisibleItemPosition;
                d78 k = this.a.n.k(findFirstVisibleItemPosition);
                if (k == null) {
                    return;
                }
                if (this.a.n.o() > 0) {
                    this.a.f.setVisibility(0);
                    this.a.g.N(String.valueOf((int) R.drawable.obfuscated_res_0x7f08132c), 24, false);
                    this.a.h.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0929));
                } else if (k instanceof RobotItem) {
                    RobotItem robotItem = (RobotItem) k;
                    if (findFirstVisibleItemPosition == 0) {
                        robotItem.setShowHeadView(false);
                    } else {
                        robotItem.setShowHeadView(true);
                    }
                    this.a.m.notifyDataSetChanged();
                }
                if (k instanceof RobotItem) {
                    RobotItem robotItem2 = (RobotItem) k;
                    this.a.f.setVisibility(0);
                    if (!TextUtils.isEmpty(robotItem2.getRobortAvatar())) {
                        this.a.g.N(robotItem2.getRobortAvatar(), 12, false);
                    } else {
                        this.a.g.N(String.valueOf((int) R.drawable.obfuscated_res_0x7f081118), 24, false);
                    }
                    if (!TextUtils.isEmpty(robotItem2.getRoboatName())) {
                        this.a.h.setText(robotItem2.getRoboatName());
                    }
                    this.a.H(robotItem2.getRobotUk());
                } else if (!(k instanceof RobotSkillRecentlyItem)) {
                } else {
                    this.a.H("999999");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TabLayout.OnTabSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRobotFloorView a;

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tab) == null) {
            }
        }

        public b(GroupChatRobotFloorView groupChatRobotFloorView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRobotFloorView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatRobotFloorView;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tab) != null) {
                return;
            }
            this.a.I(tab, true);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) != null) {
                return;
            }
            this.a.I(tab, false);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRobotFloorView a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public c(GroupChatRobotFloorView groupChatRobotFloorView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRobotFloorView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatRobotFloorView;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ga8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRobotFloorView a;

        public d(GroupChatRobotFloorView groupChatRobotFloorView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRobotFloorView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatRobotFloorView;
        }

        @Override // com.baidu.tieba.ga8
        public void a(String str, int i) {
            GroupChatRobotFloorView groupChatRobotFloorView;
            f fVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) && (fVar = (groupChatRobotFloorView = this.a).o) != null) {
                fVar.a(str, i, groupChatRobotFloorView.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ga8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRobotFloorView a;

        public e(GroupChatRobotFloorView groupChatRobotFloorView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRobotFloorView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatRobotFloorView;
        }

        @Override // com.baidu.tieba.ga8
        public void a(String str, int i) {
            GroupChatRobotFloorView groupChatRobotFloorView;
            f fVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) && (fVar = (groupChatRobotFloorView = this.a).o) != null) {
                fVar.a(str, i, groupChatRobotFloorView.a);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupChatRobotFloorView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void H(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && this.j != null && !q11.c(this.r) && this.r.containsKey(str)) {
            if (this.v) {
                this.v = false;
                return;
            }
            this.u = true;
            this.j.selectTab(this.r.get(str));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupChatRobotFloorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupChatRobotFloorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.o = null;
        this.q = null;
        this.r = new HashMap<>();
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = -1;
    }

    public final void J(int i, @Nullable String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048585, this, i, str, str2) == null) {
            String str3 = "999999";
            if (!"999999".equals(str)) {
                if (TextUtils.isEmpty(str)) {
                    str3 = "";
                } else {
                    str3 = BIMManager.getBdUidFromBdUK(str);
                }
            }
            StatisticItem param = new StatisticItem("c15242").param("obj_type", i).param("obj_id", str3);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            TiebaStatic.log(param.param("obj_name", str2).param("fid", this.l).param("room_id", this.k).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void setData(List<Object> list, boolean z) {
        ha8 ha8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048595, this, list, z) == null) && !ListUtils.isEmpty(list) && (ha8Var = this.n) != null) {
            ha8Var.p(list, z);
            t(this.n.n());
        }
    }

    public void setRoomDetailInfo(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.k = j;
            this.l = j2;
            ha8 ha8Var = this.n;
            if (ha8Var != null) {
                ha8Var.v(j, j2);
            }
        }
    }

    public boolean z(List<Object> list, boolean z) {
        InterceptResult invokeLZ;
        ha8 ha8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048606, this, list, z)) == null) {
            if (!ListUtils.isEmpty(list) && (ha8Var = this.n) != null) {
                ha8Var.q(list, z);
                return !ListUtils.isEmpty(this.n.n());
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void setCallFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.a = i;
        }
    }

    public void setOnItemClickListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void setPageContext(TbPageContext<BaseFragmentActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, tbPageContext) == null) {
            this.b = tbPageContext;
            this.s = new pa8();
            v();
            u();
        }
    }

    public void setTabLayoutVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            if (z) {
                this.j.setVisibility(0);
                J(1, null, null);
                return;
            }
            this.j.setVisibility(8);
        }
    }

    private int getSkillCountTabOffSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.n.o() > 0) {
                return this.n.o() - 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void D() {
        ha8 ha8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (ha8Var = this.n) != null) {
            ha8Var.t();
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.j != null && !q11.c(this.r)) {
            this.j.removeTabAt(0);
            this.r.remove("999999");
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.u = false;
            this.v = false;
        }
    }

    public RecyclerView getRecycleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.i;
        }
        return (RecyclerView) invokeV.objValue;
    }

    public int getRobotFloorHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ha8 ha8Var = this.n;
            if (ha8Var != null) {
                return ha8Var.j();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public ha8 getRobotItemDataAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.n;
        }
        return (ha8) invokeV.objValue;
    }

    public int getSkillRecentlyCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ha8 ha8Var = this.n;
            if (ha8Var == null) {
                return 0;
            }
            return ha8Var.o();
        }
        return invokeV.intValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.w = false;
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.i.addOnScrollListener(new a(this));
            this.q = new b(this);
            this.d.setOnClickListener(new c(this));
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            ha8 ha8Var = this.n;
            if (ha8Var != null && ha8Var.o() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        TabLayout tabLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (q11.c(this.r) || (tabLayout = this.j) == null || tabLayout.getTabAt(0) != this.r.get("999999")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            p45 d2 = p45.d(this.c);
            d2.o(R.string.deprecated_J_X18);
            d2.f(R.color.CAM_X0207);
            p45 d3 = p45.d(this.e);
            d3.o(R.string.J_X03);
            d3.f(R.color.CAM_X0210);
            p45 d4 = p45.d(this.h);
            d4.w(R.color.CAM_X0107);
            d4.B(R.dimen.T_X08);
            C();
            pa8 pa8Var = this.s;
            if (pa8Var != null && !"999999".equals(pa8Var.b())) {
                B();
            }
            ChatRoomRecycleAdapter chatRoomRecycleAdapter = this.m;
            if (chatRoomRecycleAdapter != null) {
                chatRoomRecycleAdapter.notifyDataSetChanged();
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !q11.c(this.r) && this.r.get("999999") != null && this.r.get("999999").getCustomView() != null && this.r.get("999999").getCustomView().getTag(R.id.obfuscated_res_0x7f090e86) != null && (this.r.get("999999").getCustomView().getTag(R.id.obfuscated_res_0x7f090e86) instanceof oa8)) {
            RoundTbImageView a2 = ((oa8) this.r.get("999999").getCustomView().getTag(R.id.obfuscated_res_0x7f090e86)).a();
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                a2.N(String.valueOf((int) R.drawable.obfuscated_res_0x7f08132d), 24, false);
            } else {
                a2.N(String.valueOf((int) R.drawable.obfuscated_res_0x7f08132e), 24, false);
            }
        }
    }

    public final void C() {
        pa8 pa8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (pa8Var = this.s) != null && pa8Var.a() != null && !TextUtils.isEmpty(this.s.b()) && !"999999".equals(this.s.b())) {
            this.s.a().setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.j != null && !q11.c(this.r) && this.j.getTabAt(0) != null) {
            TabLayout tabLayout = this.j;
            tabLayout.selectTab(tabLayout.getTabAt(0));
            I(this.j.getTabAt(0), true);
            this.w = true;
        }
    }

    public void p() {
        TabLayout tabLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (tabLayout = this.j) != null && this.r != null) {
            TabLayout.Tab customView = tabLayout.newTab().setCustomView(s(null, "999999", getResources().getString(R.string.obfuscated_res_0x7f0f11cf), true));
            this.j.addTab(customView, 0);
            this.r.put("999999", customView);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int selectedTabPosition = this.j.getSelectedTabPosition() + getSkillCountTabOffSet();
            int findFirstVisibleItemPosition = this.p.findFirstVisibleItemPosition();
            if (selectedTabPosition <= this.p.findLastVisibleItemPosition()) {
                this.i.scrollBy(0, this.i.getChildAt(selectedTabPosition - findFirstVisibleItemPosition).getTop() + this.n.m());
            }
        }
    }

    public final void I(TabLayout.Tab tab, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, tab, z) == null) && tab != null && tab.getCustomView() != null && tab.getCustomView().getTag(R.id.obfuscated_res_0x7f090e86) != null && (tab.getCustomView().getTag(R.id.obfuscated_res_0x7f090e86) instanceof oa8)) {
            oa8 oa8Var = (oa8) tab.getCustomView().getTag(R.id.obfuscated_res_0x7f090e86);
            String d2 = oa8Var.d();
            RoundTbImageView a2 = oa8Var.a();
            RoundTbImageView b2 = oa8Var.b();
            String c2 = oa8Var.c();
            if (z) {
                pa8 pa8Var = this.s;
                if (pa8Var != null) {
                    pa8Var.d(d2);
                    this.s.c(b2);
                }
                if ("999999".equals(d2)) {
                    a2.N(String.valueOf((int) R.drawable.obfuscated_res_0x7f08132c), 24, false);
                } else {
                    b2.setDrawBorder(true);
                    b2.setBorderWidth(ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
                    b2.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
                }
                y(d2, c2);
            } else if ("999999".equals(d2)) {
                B();
            } else {
                b2.setDrawBorder(true);
                b2.setBorderWidth(ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds0));
                b2.setBorderColor(SkinManager.getColor(R.color.transparent));
            }
        }
    }

    @NonNull
    public View s(@Nullable String str, @NonNull String str2, @NonNull String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03c8, (ViewGroup) null);
            RoundTbImageView roundTbImageView = (RoundTbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092261);
            RoundTbImageView roundTbImageView2 = (RoundTbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092262);
            if (z && TextUtils.isEmpty(str)) {
                B();
            } else {
                roundTbImageView.N(str, 12, false);
            }
            roundTbImageView2.N(String.valueOf((int) R.drawable.transparent_bg), 24, false);
            inflate.setTag(R.id.obfuscated_res_0x7f090e86, new oa8(str2, roundTbImageView, roundTbImageView2, str3));
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    public void t(ArrayList<RobotItem> arrayList) {
        TabLayout.OnTabSelectedListener onTabSelectedListener;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048600, this, arrayList) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        Iterator<RobotItem> it = arrayList.iterator();
        while (it.hasNext()) {
            RobotItem next = it.next();
            if (next != null && !TextUtils.isEmpty(next.getRoboatName()) && !TextUtils.isEmpty(next.getRobortAvatar()) && !TextUtils.isEmpty(next.getRobotUk())) {
                TabLayout.Tab customView = this.j.newTab().setCustomView(s(next.getRobortAvatar(), next.getRobotUk(), next.getRoboatName(), false));
                this.j.addTab(customView);
                this.r.put(next.getRobotUk(), customView);
            }
        }
        p();
        TabLayout tabLayout = this.j;
        if (tabLayout != null && (onTabSelectedListener = this.q) != null) {
            tabLayout.removeOnTabSelectedListener(onTabSelectedListener);
            this.j.addOnTabSelectedListener(this.q);
        }
    }

    public final void v() {
        TbPageContext<BaseFragmentActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048602, this) != null) || (tbPageContext = this.b) == null) {
            return;
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03c5, (ViewGroup) this, true);
        this.c = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e82);
        this.d = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e77);
        this.e = inflate.findViewById(R.id.obfuscated_res_0x7f0924f0);
        this.f = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e8b);
        this.g = (RoundTbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091e76);
        this.h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e80);
        this.i = (RecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f091e7f);
        this.j = (TabLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e89);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.b.getPageActivity());
        this.p = linearLayoutManager;
        this.i.setLayoutManager(linearLayoutManager);
        ha8 ha8Var = new ha8(this.b);
        this.n = ha8Var;
        ha8Var.u(new d(this));
        ChatRoomRecycleAdapter chatRoomRecycleAdapter = new ChatRoomRecycleAdapter(new ia8(new e(this)), this.n, this.b);
        this.m = chatRoomRecycleAdapter;
        this.i.setAdapter(chatRoomRecycleAdapter);
        A(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, str, str2) == null) && this.i != null && this.p != null && this.n != null) {
            if (this.u) {
                this.u = false;
                return;
            }
            this.v = true;
            if (this.w) {
                J(2, str, str2);
            }
            if (this.j.getSelectedTabPosition() == 0) {
                this.i.scrollToPosition(0);
                return;
            }
            int selectedTabPosition = this.j.getSelectedTabPosition() + getSkillCountTabOffSet();
            int findFirstVisibleItemPosition = this.p.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = this.p.findLastVisibleItemPosition();
            if (selectedTabPosition >= findFirstVisibleItemPosition && selectedTabPosition <= findLastVisibleItemPosition) {
                if (selectedTabPosition <= findLastVisibleItemPosition) {
                    this.i.scrollBy(0, this.i.getChildAt(selectedTabPosition - findFirstVisibleItemPosition).getTop() + this.n.m());
                    return;
                }
                return;
            }
            this.i.scrollToPosition(selectedTabPosition);
            this.t = true;
        }
    }
}

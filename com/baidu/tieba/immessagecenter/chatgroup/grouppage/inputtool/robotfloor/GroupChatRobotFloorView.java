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
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.ChatRoomRecycleAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter.RobotItem;
import com.baidu.tieba.k68;
import com.baidu.tieba.l68;
import com.baidu.tieba.m68;
import com.baidu.tieba.o38;
import com.baidu.tieba.r25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class GroupChatRobotFloorView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<BaseFragmentActivity> b;
    public RelativeLayout c;
    public RelativeLayout d;
    public View e;
    public LinearLayout f;
    public RoundTbImageView g;
    public TextView h;
    public RecyclerView i;
    public long j;
    public long k;
    public ChatRoomRecycleAdapter l;
    public l68 m;
    public e n;
    public LinearLayoutManager o;
    public int p;

    /* loaded from: classes5.dex */
    public interface e {
        void a(String str, int i, int i2);
    }

    /* loaded from: classes5.dex */
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
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                int findFirstVisibleItemPosition = this.a.o.findFirstVisibleItemPosition();
                if (findFirstVisibleItemPosition == this.a.p || this.a.m == null) {
                    return;
                }
                this.a.p = findFirstVisibleItemPosition;
                o38 l = this.a.m.l(findFirstVisibleItemPosition);
                if (l == null) {
                    return;
                }
                if (this.a.m.n() > 0) {
                    this.a.f.setVisibility(0);
                    this.a.g.N(String.valueOf((int) R.drawable.obfuscated_res_0x7f081195), 24, false);
                    this.a.h.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f08aa));
                } else if (l instanceof RobotItem) {
                    RobotItem robotItem = (RobotItem) l;
                    if (findFirstVisibleItemPosition == 0) {
                        robotItem.setShowHeadView(false);
                    } else {
                        robotItem.setShowHeadView(true);
                    }
                    this.a.l.notifyDataSetChanged();
                }
                if (l instanceof RobotItem) {
                    RobotItem robotItem2 = (RobotItem) l;
                    this.a.f.setVisibility(0);
                    if (!TextUtils.isEmpty(robotItem2.getRobortAvatar())) {
                        this.a.g.N(robotItem2.getRobortAvatar(), 12, false);
                    } else {
                        this.a.g.N(String.valueOf((int) R.drawable.obfuscated_res_0x7f080f93), 24, false);
                    }
                    if (!TextUtils.isEmpty(robotItem2.getRoboatName())) {
                        this.a.h.setText(robotItem2.getRoboatName());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRobotFloorView a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
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
    }

    /* loaded from: classes5.dex */
    public class c implements k68 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRobotFloorView a;

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

        @Override // com.baidu.tieba.k68
        public void a(String str, int i) {
            GroupChatRobotFloorView groupChatRobotFloorView;
            e eVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) && (eVar = (groupChatRobotFloorView = this.a).n) != null) {
                eVar.a(str, i, groupChatRobotFloorView.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements k68 {
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

        @Override // com.baidu.tieba.k68
        public void a(String str, int i) {
            GroupChatRobotFloorView groupChatRobotFloorView;
            e eVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) && (eVar = (groupChatRobotFloorView = this.a).n) != null) {
                eVar.a(str, i, groupChatRobotFloorView.a);
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

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            r25 d2 = r25.d(this.c);
            d2.o(R.string.J_X18);
            d2.f(R.color.CAM_X0207);
            r25 d3 = r25.d(this.e);
            d3.o(R.string.J_X03);
            d3.f(R.color.CAM_X0210);
            r25 d4 = r25.d(this.h);
            d4.w(R.color.CAM_X0107);
            d4.B(R.dimen.T_X08);
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
        new ArrayList();
        this.n = null;
        this.p = -1;
    }

    public void l(List<Object> list) {
        l68 l68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && !ListUtils.isEmpty(list) && (l68Var = this.m) != null) {
            l68Var.p(list);
        }
    }

    public void setCallFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.a = i;
        }
    }

    public void setData(List<Object> list) {
        l68 l68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, list) == null) && !ListUtils.isEmpty(list) && (l68Var = this.m) != null) {
            l68Var.o(list);
        }
    }

    public void setOnItemClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.n = eVar;
        }
    }

    public void setPageContext(TbPageContext<BaseFragmentActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbPageContext) == null) {
            this.b = tbPageContext;
            k();
            j();
        }
    }

    public void setRoomDetailInfo(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.j = j;
            this.k = j2;
            l68 l68Var = this.m;
            if (l68Var != null) {
                l68Var.u(j, j2);
            }
        }
    }

    public RecyclerView getRecycleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i;
        }
        return (RecyclerView) invokeV.objValue;
    }

    public int getRobotFloorHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            l68 l68Var = this.m;
            if (l68Var != null) {
                return l68Var.k();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public l68 getRobotItemDataAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.m;
        }
        return (l68) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.i.addOnScrollListener(new a(this));
            this.d.setOnClickListener(new b(this));
        }
    }

    public void n() {
        l68 l68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (l68Var = this.m) != null) {
            l68Var.s();
        }
    }

    public final void k() {
        TbPageContext<BaseFragmentActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (tbPageContext = this.b) == null) {
            return;
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03aa, (ViewGroup) this, true);
        this.c = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e15);
        this.d = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e0b);
        this.e = inflate.findViewById(R.id.obfuscated_res_0x7f09246c);
        this.f = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e1c);
        this.g = (RoundTbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091e0a);
        this.h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e14);
        this.i = (RecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f091e13);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.b.getPageActivity());
        this.o = linearLayoutManager;
        this.i.setLayoutManager(linearLayoutManager);
        l68 l68Var = new l68(this.b);
        this.m = l68Var;
        l68Var.t(new c(this));
        ChatRoomRecycleAdapter chatRoomRecycleAdapter = new ChatRoomRecycleAdapter(new m68(new d(this)), this.m, this.b);
        this.l = chatRoomRecycleAdapter;
        this.i.setAdapter(chatRoomRecycleAdapter);
        m(TbadkCoreApplication.getInst().getSkinType());
    }
}

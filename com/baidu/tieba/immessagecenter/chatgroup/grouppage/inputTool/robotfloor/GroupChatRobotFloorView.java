package com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool.robotfloor;

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
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ar7;
import com.baidu.tieba.br7;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.ChatRoomRecycleAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool.robotfloor.adapter.RobotItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.p15;
import com.baidu.tieba.zq7;
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
    public HeadImageView g;
    public TextView h;
    public RecyclerView i;
    public ChatRoomRecycleAdapter j;
    public ar7 k;
    public d l;
    public LinearLayoutManager m;
    public int n;

    /* loaded from: classes5.dex */
    public interface d {
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
                int findFirstVisibleItemPosition = this.a.m.findFirstVisibleItemPosition();
                if (findFirstVisibleItemPosition == this.a.n || this.a.k == null) {
                    return;
                }
                this.a.n = findFirstVisibleItemPosition;
                RobotItem k = this.a.k.k(findFirstVisibleItemPosition);
                if (k == null) {
                    return;
                }
                if (findFirstVisibleItemPosition == 0) {
                    k.setShowHeadView(false);
                } else {
                    k.setShowHeadView(true);
                }
                this.a.j.notifyDataSetChanged();
                this.a.f.setVisibility(0);
                if (!TextUtils.isEmpty(k.getRobortAvatar())) {
                    this.a.g.K(k.getRobortAvatar(), 12, false);
                }
                if (!TextUtils.isEmpty(k.getRoboatName())) {
                    this.a.h.setText(k.getRoboatName());
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
    public class c implements zq7 {
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

        @Override // com.baidu.tieba.zq7
        public void a(String str, int i) {
            GroupChatRobotFloorView groupChatRobotFloorView;
            d dVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) && (dVar = (groupChatRobotFloorView = this.a).l) != null) {
                dVar.a(str, i, groupChatRobotFloorView.a);
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

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            p15 d2 = p15.d(this.c);
            d2.n(R.string.J_X18);
            d2.f(R.color.CAM_X0207);
            p15 d3 = p15.d(this.e);
            d3.n(R.string.J_X03);
            d3.f(R.color.CAM_X0212);
            p15 d4 = p15.d(this.h);
            d4.v(R.color.CAM_X0107);
            d4.z(R.dimen.T_X08);
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
        this.l = null;
        this.n = -1;
    }

    public void setCallFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a = i;
        }
    }

    public void setData(List<BotsDTO.BotListDTO> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.k.m(list);
    }

    public void setOnItemClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.l = dVar;
        }
    }

    public void setPageContext(TbPageContext<BaseFragmentActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbPageContext) == null) {
            this.b = tbPageContext;
            k();
            j();
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
            ar7 ar7Var = this.k;
            if (ar7Var != null) {
                return ar7Var.j();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public ar7 getRobotItemDataAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.k;
        }
        return (ar7) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.i.addOnScrollListener(new a(this));
            this.d.setOnClickListener(new b(this));
        }
    }

    public final void k() {
        TbPageContext<BaseFragmentActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (tbPageContext = this.b) == null) {
            return;
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0391, (ViewGroup) this, true);
        this.c = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091d99);
        this.d = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091d92);
        this.e = inflate.findViewById(R.id.obfuscated_res_0x7f0923d3);
        this.f = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091d9f);
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091d91);
        this.g = headImageView;
        headImageView.setIsRound(true);
        this.g.setIsBigV(false);
        this.h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d98);
        this.i = (RecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f091d97);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.b.getPageActivity());
        this.m = linearLayoutManager;
        this.i.setLayoutManager(linearLayoutManager);
        ar7 ar7Var = new ar7(this.b);
        this.k = ar7Var;
        ar7Var.p(new c(this));
        ChatRoomRecycleAdapter chatRoomRecycleAdapter = new ChatRoomRecycleAdapter(new br7(null), this.k, this.b);
        this.j = chatRoomRecycleAdapter;
        this.i.setAdapter(chatRoomRecycleAdapter);
        l(TbadkCoreApplication.getInst().getSkinType());
    }
}

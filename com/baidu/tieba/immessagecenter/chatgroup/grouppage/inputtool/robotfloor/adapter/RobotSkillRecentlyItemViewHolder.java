package com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder;
import com.baidu.tieba.k68;
import com.baidu.tieba.o38;
import com.baidu.tieba.r25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class RobotSkillRecentlyItemViewHolder extends BaseItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout d;
    public HeadImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public RobotSkillRecentlyItem i;
    public final k68 j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RobotSkillRecentlyItemViewHolder a;

        public a(RobotSkillRecentlyItemViewHolder robotSkillRecentlyItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {robotSkillRecentlyItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = robotSkillRecentlyItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.j != null && this.a.i != null) {
                this.a.j.a(this.a.i.getUk(), this.a.i.getSkillId());
                this.a.m(2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotSkillRecentlyItemViewHolder(@NonNull View view2, k68 k68Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, k68Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = k68Var;
        this.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090425);
        HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09041d);
        this.e = headImageView;
        headImageView.setIsRound(true);
        this.e.setIsBigV(false);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920bc);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090420);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920bb);
        this.d.setOnClickListener(new a(this));
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void c(@Nullable RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, recyclerView) == null) {
            super.c(recyclerView);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void e(@Nullable RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recyclerView) == null) {
            super.e(recyclerView);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void d(@NonNull o38 o38Var, @NonNull TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o38Var, tbPageContext, i) == null) && (o38Var instanceof RobotSkillRecentlyItem)) {
            this.i = (RobotSkillRecentlyItem) o38Var;
            this.g.setText(tbPageContext.getString(R.string.obfuscated_res_0x7f0f08ab) + this.i.getSkillName());
            this.h.setText(this.i.getSkillDesc());
            this.f.setText(this.i.getBotName());
            if (!TextUtils.isEmpty(this.i.getAvatar())) {
                this.e.N(this.i.getAvatar(), 12, false);
            } else {
                this.e.N(String.valueOf((int) R.drawable.obfuscated_res_0x7f080f93), 24, false);
            }
            f(TbadkCoreApplication.getInst().getSkinType());
            m(1);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            r25 d = r25.d(this.g);
            d.B(R.dimen.T_X06);
            d.w(R.color.CAM_X0105);
            r25 d2 = r25.d(this.f);
            d2.B(R.dimen.T_X08);
            d2.w(R.color.CAM_X0108);
            r25 d3 = r25.d(this.h);
            d3.B(R.dimen.T_X08);
            d3.w(R.color.CAM_X0108);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.g();
        }
    }

    public final void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            TiebaStatic.log(new StatisticItem("c15243").param("obj_type", i).param("obj_id", this.i.getUk()).param("obj_name", this.i.getBotName()).param("obj_source", this.i.getSkillName()).param("fid", this.i.getmForumId()).param("room_id", this.i.getmRoomId()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }
}

package com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.bj8;
import com.baidu.tieba.d85;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder;
import com.baidu.tieba.in8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class RobotSkillRecentlyItemViewHolder extends BaseItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout e;
    public HeadImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public ImageView j;
    public RobotSkillRecentlyItem k;
    public final in8 l;

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.l != null && this.a.k != null) {
                this.a.l.a(this.a.k.getUk(), this.a.k.getSkillId());
                this.a.o(2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotSkillRecentlyItemViewHolder(@NonNull View view2, in8 in8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, in8Var};
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
        this.l = in8Var;
        this.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09043a);
        HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090431);
        this.f = headImageView;
        headImageView.setIsRound(true);
        this.f.setIsBigV(false);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092200);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090435);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921ff);
        this.j = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091f49);
        this.e.setOnClickListener(new a(this));
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void d(@Nullable RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, recyclerView) == null) {
            super.d(recyclerView);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void f(@Nullable RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recyclerView) == null) {
            super.f(recyclerView);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void e(@NonNull bj8 bj8Var, @NonNull TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bj8Var, tbPageContext, i) == null) && (bj8Var instanceof RobotSkillRecentlyItem)) {
            this.k = (RobotSkillRecentlyItem) bj8Var;
            this.h.setText(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0972) + this.k.getSkillName());
            this.i.setText(this.k.getSkillDesc());
            this.g.setText(this.k.getBotName());
            if (!TextUtils.isEmpty(this.k.getAvatar())) {
                this.f.N(this.k.getAvatar(), 12, false);
            } else {
                this.f.N(String.valueOf((int) R.drawable.obfuscated_res_0x7f08118b), 24, false);
            }
            if (this.i.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                if (this.k.isFuncJump()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                    layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
                    this.i.setLayoutParams(layoutParams);
                    this.j.setVisibility(0);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                    layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
                    this.i.setLayoutParams(layoutParams2);
                    this.j.setVisibility(8);
                }
            }
            n();
            o(1);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.h();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d85 d = d85.d(this.h);
            d.C(R.dimen.T_X06);
            d.x(R.color.CAM_X0105);
            d85 d2 = d85.d(this.g);
            d2.C(R.dimen.T_X08);
            d2.x(R.color.CAM_X0108);
            d85 d3 = d85.d(this.i);
            d3.C(R.dimen.T_X08);
            d3.x(R.color.CAM_X0108);
            WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_mount_card_link_right_arrow, R.color.CAM_X0109, null);
        }
    }

    public final void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            TiebaStatic.log(new StatisticItem("c15243").param("obj_type", i).param("obj_id", this.k.getUk()).param("obj_name", this.k.getBotName()).param("obj_source", this.k.getSkillName()).param("fid", this.k.getmForumId()).param("room_id", this.k.getmRoomId()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }
}

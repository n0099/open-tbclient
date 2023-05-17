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
import com.baidu.tieba.d78;
import com.baidu.tieba.ga8;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder;
import com.baidu.tieba.p45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class RobotSkillRecentlyItemViewHolder extends BaseItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout d;
    public HeadImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public ImageView i;
    public RobotSkillRecentlyItem j;
    public final ga8 k;

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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.k != null && this.a.j != null) {
                this.a.k.a(this.a.j.getUk(), this.a.j.getSkillId());
                this.a.n(2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotSkillRecentlyItemViewHolder(@NonNull View view2, ga8 ga8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, ga8Var};
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
        this.k = ga8Var;
        this.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090438);
        HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090430);
        this.e = headImageView;
        headImageView.setIsRound(true);
        this.e.setIsBigV(false);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092132);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090433);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092131);
        this.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091e81);
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
    public void d(@NonNull d78 d78Var, @NonNull TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d78Var, tbPageContext, i) == null) && (d78Var instanceof RobotSkillRecentlyItem)) {
            this.j = (RobotSkillRecentlyItem) d78Var;
            this.g.setText(tbPageContext.getString(R.string.obfuscated_res_0x7f0f092a) + this.j.getSkillName());
            this.h.setText(this.j.getSkillDesc());
            this.f.setText(this.j.getBotName());
            if (!TextUtils.isEmpty(this.j.getAvatar())) {
                this.e.N(this.j.getAvatar(), 12, false);
            } else {
                this.e.N(String.valueOf((int) R.drawable.obfuscated_res_0x7f081118), 24, false);
            }
            if (this.h.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                if (this.j.isFuncJump()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.h.getLayoutParams();
                    layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
                    this.h.setLayoutParams(layoutParams);
                    this.i.setVisibility(0);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.h.getLayoutParams();
                    layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
                    this.h.setLayoutParams(layoutParams2);
                    this.i.setVisibility(8);
                }
            }
            m();
            n(1);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.g();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            p45 d = p45.d(this.g);
            d.B(R.dimen.T_X06);
            d.w(R.color.CAM_X0105);
            p45 d2 = p45.d(this.f);
            d2.B(R.dimen.T_X08);
            d2.w(R.color.CAM_X0108);
            p45 d3 = p45.d(this.h);
            d3.B(R.dimen.T_X08);
            d3.w(R.color.CAM_X0108);
            WebPManager.setPureDrawable(this.i, R.drawable.icon_pure_mount_card_link_right_arrow, R.color.CAM_X0109, null);
        }
    }

    public final void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            TiebaStatic.log(new StatisticItem("c15243").param("obj_type", i).param("obj_id", this.j.getUk()).param("obj_name", this.j.getBotName()).param("obj_source", this.j.getSkillName()).param("fid", this.j.getmForumId()).param("room_id", this.j.getmRoomId()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }
}

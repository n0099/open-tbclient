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
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.fq8;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder;
import com.baidu.tieba.vl8;
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
    public final fq8 l;

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
                this.a.n(2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotSkillRecentlyItemViewHolder(@NonNull View view2, fq8 fq8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, fq8Var};
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
        this.l = fq8Var;
        this.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09044d);
        HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090442);
        this.f = headImageView;
        headImageView.setIsRound(true);
        this.f.setIsBigV(false);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092285);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090446);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092284);
        this.j = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091fcb);
        this.e.setOnClickListener(new a(this));
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
    public void d(@NonNull vl8 vl8Var, @NonNull TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vl8Var, tbPageContext, i) == null) && (vl8Var instanceof RobotSkillRecentlyItem)) {
            this.k = (RobotSkillRecentlyItem) vl8Var;
            this.h.setText(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0981) + this.k.getSkillName());
            this.i.setText(this.k.getSkillDesc());
            this.g.setText(this.k.getBotName());
            if (!TextUtils.isEmpty(this.k.getAvatar())) {
                this.f.startLoad(this.k.getAvatar(), 12, false);
            } else {
                this.f.startLoad(String.valueOf((int) R.drawable.obfuscated_res_0x7f0811c7), 24, false);
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
            EMManager.from(this.h).setTextSize(R.dimen.T_X06).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.g).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0108);
            EMManager.from(this.i).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0108);
            WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_mount_card_link_right_arrow, R.color.CAM_X0109, null);
        }
    }

    public final void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            TiebaStatic.log(new StatisticItem("c15243").param("obj_type", i).param("obj_id", this.k.getUk()).param("obj_name", this.k.getBotName()).param("obj_source", this.k.getSkillName()).param("fid", this.k.getmForumId()).param("room_id", this.k.getmRoomId()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }
}

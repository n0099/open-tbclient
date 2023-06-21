package com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder;
import com.baidu.tieba.ld8;
import com.baidu.tieba.p75;
import com.baidu.tieba.qg8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class RobotSkillItemViewHolder extends BaseItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout e;
    public RelativeLayout f;
    public TextView g;
    public TextView h;
    public ImageView i;
    public RobotSkillItem j;
    public qg8 k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RobotSkillItemViewHolder a;

        public a(RobotSkillItemViewHolder robotSkillItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {robotSkillItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = robotSkillItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.k != null && this.a.j != null) {
                this.a.k.a(this.a.j.getUk(), this.a.j.getSkillType());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotSkillItemViewHolder(@NonNull View view2, qg8 qg8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, qg8Var};
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
        this.k = qg8Var;
        this.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ebf);
        this.f = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ebd);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ec0);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ebe);
        this.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091ebc);
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
    @SuppressLint({"ResourceAsColor"})
    public void d(@NonNull ld8 ld8Var, @NonNull TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ld8Var, tbPageContext, i) == null) && (ld8Var instanceof RobotSkillItem)) {
            RobotSkillItem robotSkillItem = (RobotSkillItem) ld8Var;
            this.j = robotSkillItem;
            if (!TextUtils.isEmpty(robotSkillItem.getSkillName())) {
                TextView textView = this.g;
                textView.setText("/" + this.j.getSkillName());
            }
            if (!TextUtils.isEmpty(this.j.getSkillDesc())) {
                this.h.setText(this.j.getSkillDesc());
            }
            if (this.h.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                if (this.j.isFuncJump()) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
                    layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X015);
                    this.h.setLayoutParams(layoutParams);
                    this.i.setVisibility(0);
                } else {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
                    layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
                    this.h.setLayoutParams(layoutParams2);
                    this.i.setVisibility(8);
                }
            }
            l();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.g();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            p75 d = p75.d(this.g);
            d.C(R.dimen.T_X06);
            d.x(R.color.CAM_X0105);
            p75 d2 = p75.d(this.h);
            d2.C(R.dimen.T_X08);
            d2.x(R.color.CAM_X0109);
            WebPManager.setPureDrawable(this.i, R.drawable.icon_pure_mount_card_link_right_arrow, R.color.CAM_X0109, null);
        }
    }
}

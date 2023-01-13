package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.robotfloor.adapter;

import android.annotation.SuppressLint;
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
import com.baidu.tieba.R;
import com.baidu.tieba.cx4;
import com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.BaseItemViewHolder;
import com.baidu.tieba.kk7;
import com.baidu.tieba.ql7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class RobotSkillItemViewHolder extends BaseItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout d;
    public RelativeLayout e;
    public TextView f;
    public TextView g;
    public RobotSkillItem h;
    public ql7 i;

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.i != null && this.a.h != null) {
                this.a.i.a(this.a.h.getUk(), this.a.h.getSkillType());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotSkillItemViewHolder(@NonNull View view2, ql7 ql7Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, ql7Var};
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
        this.i = ql7Var;
        this.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d45);
        this.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d43);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091d46);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091d44);
        this.d.setOnClickListener(new a(this));
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void c(@Nullable RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, recyclerView) == null) {
            super.c(recyclerView);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void e(@Nullable RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recyclerView) == null) {
            super.e(recyclerView);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    @SuppressLint({"ResourceAsColor"})
    public void d(@NonNull kk7 kk7Var, @NonNull TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kk7Var, tbPageContext, i) == null) && (kk7Var instanceof RobotSkillItem)) {
            RobotSkillItem robotSkillItem = (RobotSkillItem) kk7Var;
            this.h = robotSkillItem;
            if (!TextUtils.isEmpty(robotSkillItem.getSkillName())) {
                TextView textView = this.f;
                textView.setText("/" + this.h.getSkillName());
            }
            if (!TextUtils.isEmpty(this.h.getSkillDesc())) {
                this.g.setText(this.h.getSkillDesc());
            }
            f(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            cx4 d = cx4.d(this.f);
            d.z(R.dimen.T_X06);
            d.v(R.color.CAM_X0105);
            cx4 d2 = cx4.d(this.g);
            d2.z(R.dimen.T_X08);
            d2.v(R.color.CAM_X0109);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.g();
        }
    }
}

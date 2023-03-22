package com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder;
import com.baidu.tieba.n15;
import com.baidu.tieba.rt7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class RobotItemViewHolder extends BaseItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout d;
    public LinearLayout e;
    public HeadImageView f;
    public TextView g;
    public RecyclerView h;
    public RobotItem i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotItemViewHolder(@NonNull View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
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
        this.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e23);
        this.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e21);
        this.f = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091e20);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e22);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091e2b);
        this.h = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(view2.getContext()));
        this.h.setFocusable(false);
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
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            n15 d = n15.d(this.g);
            d.A(R.dimen.T_X08);
            d.w(R.color.CAM_X0107);
            this.f.setIsRound(true);
            this.f.setIsBigV(false);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void d(@NonNull rt7 rt7Var, @NonNull TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rt7Var, tbPageContext, i) == null) && (rt7Var instanceof RobotItem)) {
            RobotItem robotItem = (RobotItem) rt7Var;
            this.i = robotItem;
            if (!TextUtils.isEmpty(robotItem.getRoboatName())) {
                this.g.setText(this.i.getRoboatName());
            }
            if (!TextUtils.isEmpty(this.i.getRobortAvatar())) {
                this.f.M(this.i.getRobortAvatar(), 12, false);
            } else {
                this.f.M(String.valueOf((int) R.drawable.obfuscated_res_0x7f080fa8), 24, false);
            }
            if (this.h.getAdapter() != this.i.getAdapter()) {
                if (this.h.getAdapter() != null) {
                    this.h.swapAdapter(this.i.getAdapter(), true);
                } else {
                    this.h.setAdapter(this.i.getAdapter());
                }
            }
            if (this.i.isShowHeadView()) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
            f(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.g();
        }
    }
}

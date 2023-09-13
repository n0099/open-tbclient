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
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder;
import com.baidu.tieba.vl8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class RobotItemViewHolder extends BaseItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout e;
    public LinearLayout f;
    public HeadImageView g;
    public TextView h;
    public RecyclerView i;
    public RobotItem j;

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
        this.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091fc7);
        this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091fc5);
        this.g = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091fc4);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091fc6);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091fd2);
        this.i = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(view2.getContext()));
        this.i.setFocusable(false);
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
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vl8Var, tbPageContext, i) == null) && (vl8Var instanceof RobotItem)) {
            RobotItem robotItem = (RobotItem) vl8Var;
            this.j = robotItem;
            if (!TextUtils.isEmpty(robotItem.getRoboatName())) {
                this.h.setText(this.j.getRoboatName());
            }
            if (!TextUtils.isEmpty(this.j.getRobortAvatar())) {
                this.g.startLoad(this.j.getRobortAvatar(), 12, false);
            } else {
                this.g.startLoad(String.valueOf((int) R.drawable.obfuscated_res_0x7f0811c7), 24, false);
            }
            if (this.i.getAdapter() != this.j.getAdapter()) {
                if (this.i.getAdapter() != null) {
                    this.i.swapAdapter(this.j.getAdapter(), true);
                } else {
                    this.i.setAdapter(this.j.getAdapter());
                }
            }
            if (this.j.isShowHeadView()) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            j();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.g();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            EMManager.from(this.h).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0107);
            this.g.setIsRound(true);
            this.g.setIsBigV(false);
            RecyclerView recyclerView = this.i;
            if (recyclerView != null && recyclerView.getAdapter() != null) {
                this.i.getAdapter().notifyDataSetChanged();
            }
        }
    }
}

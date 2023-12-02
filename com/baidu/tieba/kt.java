package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.InterviewLiveLayout;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class kt extends ku implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterviewLiveLayout A;
    public int B;
    public TextView C;
    public mm6<fw4> D;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kt(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.B = 3;
        D();
    }

    public final int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        }
        return invokeV.intValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
            this.f = inflate;
            this.g = (TextView) inflate.findViewById(R.id.video_seg_title);
            this.C = (TextView) this.f.findViewById(R.id.video_seg_abstract);
            this.i = (RoundCornerFrameLayout) this.f.findViewById(R.id.frame_video);
            this.A = (InterviewLiveLayout) this.f.findViewById(R.id.frame_interview_no_video);
            lea t = t();
            this.l = t;
            t.getMainView().setBackgroundResource(R.color.transparent);
            this.C.setOnClickListener(this);
            this.g.setOnClickListener(this);
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.A.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.os
    public void n(mm6<fw4> mm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mm6Var) == null) {
            this.D = mm6Var;
            this.A.setSubClickListener(mm6Var);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        mm6<fw4> mm6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            if ((view2 == this.C || view2 == this.g) && (mm6Var = this.D) != null) {
                mm6Var.a(view2, this.h);
            }
        }
    }

    @Override // com.baidu.tieba.ku, com.baidu.tieba.os
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ku
    public lea t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            mea meaVar = new mea(this.b, this.i);
            meaVar.setStageType("2003");
            return meaVar;
        }
        return (lea) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ku, com.baidu.tieba.jt
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i) == null) {
            if (this.B != i) {
                SkinManager.setBackgroundResource(this.A, R.drawable.addresslist_item_bg);
                this.A.k(this.B);
            }
            this.B = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ku, com.baidu.tieba.it
    /* renamed from: u */
    public void onBindDataToView(fw4 fw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fw4Var) == null) {
            this.h = fw4Var;
            if (fw4Var != null && fw4Var.getThreadData() != null) {
                ThreadData threadData = fw4Var.getThreadData();
                if (threadData.getThreadVideoInfo() != null) {
                    this.A.setVisibility(8);
                    this.i.setVisibility(0);
                    this.C.setVisibility(8);
                    super.onBindDataToView(fw4Var);
                    return;
                }
                this.i.setVisibility(8);
                this.C.setVisibility(0);
                ThreadCardUtils.setTitle(this.g, threadData);
                ThreadCardUtils.setAbstract(this.C, this.g, threadData, C());
                if (threadData.getTaskInfoData() != null && threadData.getTaskInfoData().j() != 0) {
                    this.A.setVisibility(8);
                    return;
                }
                this.A.setVisibility(0);
                this.A.onBindDataToView(fw4Var);
            }
        }
    }
}

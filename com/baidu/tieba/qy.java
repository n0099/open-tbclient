package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
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
public class qy extends rz implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterviewLiveLayout A;
    public int B;
    public TextView C;
    public eo6<f15> D;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qy(Context context) {
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
        F();
    }

    public final int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return vi.l(TbadkCoreApplication.getInst()) - ((vi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + vi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        }
        return invokeV.intValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
            this.f = inflate;
            this.g = (TextView) inflate.findViewById(R.id.video_seg_title);
            this.C = (TextView) this.f.findViewById(R.id.video_seg_abstract);
            this.i = (RoundCornerFrameLayout) this.f.findViewById(R.id.frame_video);
            this.A = (InterviewLiveLayout) this.f.findViewById(R.id.frame_interview_no_video);
            ej9 u = u();
            this.l = u;
            u.getMainView().setBackgroundResource(R.color.transparent);
            this.C.setOnClickListener(this);
            this.g.setOnClickListener(this);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.A.setFromCDN(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        eo6<f15> eo6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            if ((view2 == this.C || view2 == this.g) && (eo6Var = this.D) != null) {
                eo6Var.a(view2, this.h);
            }
        }
    }

    @Override // com.baidu.tieba.ux
    public void p(eo6<f15> eo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eo6Var) == null) {
            this.D = eo6Var;
            this.A.setSubClickListener(eo6Var);
        }
    }

    @Override // com.baidu.tieba.rz, com.baidu.tieba.ux
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rz
    public ej9 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            fj9 fj9Var = new fj9(this.b, this.i);
            fj9Var.setStageType("2003");
            return fj9Var;
        }
        return (ej9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rz, com.baidu.tieba.py
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            if (this.B != i) {
                SkinManager.setBackgroundResource(this.A, R.drawable.addresslist_item_bg);
                this.A.l(this.B);
            }
            this.B = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rz, com.baidu.tieba.oy
    /* renamed from: x */
    public void a(f15 f15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, f15Var) == null) {
            this.h = f15Var;
            if (f15Var != null && f15Var.getThreadData() != null) {
                ThreadData threadData = f15Var.getThreadData();
                if (threadData.getThreadVideoInfo() != null) {
                    this.A.setVisibility(8);
                    this.i.setVisibility(0);
                    this.C.setVisibility(8);
                    super.a(f15Var);
                    return;
                }
                this.i.setVisibility(8);
                this.C.setVisibility(0);
                ThreadCardUtils.setTitle(this.g, threadData);
                ThreadCardUtils.setAbstract(this.C, this.g, threadData, E());
                if (threadData.getTaskInfoData() != null && threadData.getTaskInfoData().j() != 0) {
                    this.A.setVisibility(8);
                    return;
                }
                this.A.setVisibility(0);
                this.A.a(f15Var);
            }
        }
    }
}

package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.InterviewLiveLayout;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class kx extends my {
    public static /* synthetic */ Interceptable $ic;
    public static final int D;
    public transient /* synthetic */ FieldHolder $fh;
    public InterviewLiveLayout A;
    public int B;
    public TextView C;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448309728, "Lcom/baidu/tieba/kx;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448309728, "Lcom/baidu/tieba/kx;");
                return;
            }
        }
        D = ii.l(TbadkCoreApplication.getInst()) - ((ii.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + ii.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kx(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.B = 3;
        E();
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
            this.f = inflate;
            this.g = (TextView) inflate.findViewById(R.id.video_seg_title);
            this.C = (TextView) this.f.findViewById(R.id.video_seg_abstract);
            this.i = (RoundCornerFrameLayout) this.f.findViewById(R.id.frame_video);
            this.A = (InterviewLiveLayout) this.f.findViewById(R.id.frame_interview_no_video);
            h89 u = u();
            this.l = u;
            u.getMainView().setBackgroundResource(R.color.transparent);
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.A.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.qw
    public void p(yg6<kw4> yg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yg6Var) == null) {
            this.A.setSubClickListener(yg6Var);
        }
    }

    @Override // com.baidu.tieba.my, com.baidu.tieba.qw
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.my
    public h89 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            i89 i89Var = new i89(this.b, this.i);
            i89Var.setStageType("2003");
            return i89Var;
        }
        return (h89) invokeV.objValue;
    }

    @Override // com.baidu.tieba.my, com.baidu.tieba.jx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            if (this.B != i) {
                SkinManager.setBackgroundResource(this.A, R.drawable.addresslist_item_bg);
                this.A.l(this.B);
            }
            this.B = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.my, com.baidu.tieba.ix
    /* renamed from: v */
    public void a(kw4 kw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, kw4Var) == null) {
            this.h = kw4Var;
            if (kw4Var != null && kw4Var.getThreadData() != null) {
                ThreadData threadData = kw4Var.getThreadData();
                if (threadData.getThreadVideoInfo() != null) {
                    this.A.setVisibility(8);
                    this.i.setVisibility(0);
                    this.C.setVisibility(8);
                    super.a(kw4Var);
                    return;
                }
                this.i.setVisibility(8);
                this.C.setVisibility(0);
                ThreadCardUtils.setTitle(this.g, threadData);
                ThreadCardUtils.setAbstract(this.C, this.g, threadData, D);
                if (threadData.getTaskInfoData() != null && threadData.getTaskInfoData().h() != 0) {
                    this.A.setVisibility(8);
                    return;
                }
                this.A.setVisibility(0);
                this.A.a(kw4Var);
            }
        }
    }
}

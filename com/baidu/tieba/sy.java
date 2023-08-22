package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sy extends zw<w05> {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public TextView h;
    public OriginalThreadCardView i;
    public w05 j;
    public boolean k;
    public OriginalThreadCardView.b l;

    /* loaded from: classes8.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy a;

        public a(sy syVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {syVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = syVar;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) && this.a.j != null && this.a.j.getThreadData() != null) {
                if (this.a.h() != null) {
                    this.a.h().a(this.a.i, this.a.j);
                }
                String id = this.a.j.getThreadData().getId();
                vn6.a(id);
                this.a.z(id);
                this.a.a.p(new yy.a(1));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448317447, "Lcom/baidu/tieba/sy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448317447, "Lcom/baidu/tieba/sy;");
                return;
            }
        }
        m = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sy(Context context) {
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
        this.k = false;
        this.l = new a(this);
        if (TbadkCoreApplication.getInst().getPersonalizeViewData().p != null && TbadkCoreApplication.getInst().getPersonalizeViewData().p.getParent() == null) {
            this.f = TbadkCoreApplication.getInst().getPersonalizeViewData().p;
        } else {
            this.f = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        }
        this.g = (TextView) this.f.findViewById(R.id.thread_card_title);
        this.h = (TextView) this.f.findViewById(R.id.thread_card_abstract);
        OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) this.f.findViewById(R.id.original_thread_view);
        this.i = originalThreadCardView;
        originalThreadCardView.setSubClickListener(this.l);
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.k = z;
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.i.m = i;
        }
    }

    @Override // com.baidu.tieba.zw
    public void p(jo6<w05> jo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jo6Var) == null) {
            super.p(jo6Var);
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            vn6.l(this.g, str, R.color.CAM_X0105, R.color.CAM_X0109);
            vn6.l(this.h, str, R.color.CAM_X0105, R.color.CAM_X0109);
            this.i.setReadState(vn6.k(str));
        }
    }

    @Override // com.baidu.tieba.ux
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            this.i.s();
        }
    }

    @Override // com.baidu.tieba.zw
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tx
    /* renamed from: y */
    public void onBindDataToView(w05 w05Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, w05Var) == null) && w05Var != null && w05Var.getThreadData() != null) {
            this.j = w05Var;
            ThreadCardUtils.setTitle(this.g, w05Var.getThreadData(), this.k);
            ThreadCardUtils.setAbstract(this.h, this.g, w05Var.getThreadData(), m, this.k);
            this.i.i(w05Var.getThreadData().originalThreadData);
        }
    }
}

package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ty extends ax<sr4> {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public TextView h;
    public OriginalThreadCardView i;
    public sr4 j;
    public boolean k;
    public OriginalThreadCardView.b l;

    /* loaded from: classes6.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ty a;

        public a(ty tyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tyVar;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) && this.a.j != null && this.a.j.getThreadData() != null) {
                if (this.a.h() != null) {
                    this.a.h().a(this.a.i, this.a.j);
                }
                String id = this.a.j.getThreadData().getId();
                w36.a(id);
                this.a.w(id);
                this.a.a.o(new zy.a(1));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448318408, "Lcom/baidu/tieba/ty;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448318408, "Lcom/baidu/tieba/ty;");
                return;
            }
        }
        m = yi.l(TbadkCoreApplication.getInst()) - ((yi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + yi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ty(Context context) {
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
            this.f = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01c0, (ViewGroup) null, false);
        }
        this.g = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0921de);
        this.h = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0921d0);
        OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) this.f.findViewById(R.id.obfuscated_res_0x7f0917a0);
        this.i = originalThreadCardView;
        originalThreadCardView.setSubClickListener(this.l);
    }

    @Override // com.baidu.tieba.ax
    public void p(l46<sr4> l46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, l46Var) == null) {
            super.p(l46Var);
        }
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            w36.l(this.g, str, R.color.CAM_X0105, R.color.CAM_X0109);
            w36.l(this.h, str, R.color.CAM_X0105, R.color.CAM_X0109);
            this.i.setReadState(w36.k(str));
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.k = z;
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.i.m = i;
        }
    }

    @Override // com.baidu.tieba.tx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.i.s();
        }
    }

    @Override // com.baidu.tieba.ax
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sx
    /* renamed from: v */
    public void a(sr4 sr4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, sr4Var) == null) && sr4Var != null && sr4Var.getThreadData() != null) {
            this.j = sr4Var;
            ThreadCardUtils.setTitle(this.g, sr4Var.getThreadData(), this.k);
            ThreadCardUtils.setAbstract(this.h, this.g, sr4Var.getThreadData(), m, this.k);
            this.i.i(sr4Var.getThreadData().originalThreadData);
        }
    }
}

package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class jd8 extends dd8 implements bu7, ad8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public long c;
    public boolean d;
    public BdUniqueId e;
    public fd8 f;
    public df8 g;
    public PersonPolymericModel h;
    public ed8 i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<q98> n;

    @Override // com.baidu.tieba.ad8
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jd8(BaseFragment baseFragment, fd8 fd8Var, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, fd8Var, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = true;
        this.m = 3;
        BaseFragmentActivity baseFragmentActivity = baseFragment.getBaseFragmentActivity();
        this.j = baseFragmentActivity;
        this.b = baseFragmentActivity.getPageContext();
        this.c = j;
        this.f = fd8Var;
        this.e = bdUniqueId;
        this.k = fd8Var.e;
        this.l = new PersonPostModel(this.b, bdUniqueId, null, this.a, 1);
        df8 df8Var = new df8(baseFragment, fd8Var, bdUniqueId, z, this.c);
        this.g = df8Var;
        df8Var.W(this);
        resetData();
        this.h = this.f.p();
        this.i = this.f.k();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new q98());
        this.n.add(new q98());
    }

    @Override // com.baidu.tieba.bu7
    public void a() {
        fd8 fd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (fd8Var = this.f) != null) {
            fd8Var.a();
        }
    }

    @Override // com.baidu.tieba.bu7
    public void b() {
        fd8 fd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (fd8Var = this.f) != null) {
            fd8Var.b();
        }
    }

    @Override // com.baidu.tieba.ad8
    public df8 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (df8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ad8
    public void e() {
        df8 df8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (df8Var = this.g) != null) {
            df8Var.M();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            df8 df8Var = this.g;
            if (df8Var != null) {
                df8Var.U();
            }
        }
    }

    @Override // com.baidu.tieba.bu7
    public void resetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.resetThreadPn();
            PersonPolymericModel personPolymericModel = this.h;
            if (personPolymericModel != null) {
                personPolymericModel.U();
            }
        }
    }

    public void i(q49 q49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, q49Var) == null) {
            this.g.X(q49Var);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || this.m == i) {
            return;
        }
        df8 df8Var = this.g;
        if (df8Var != null) {
            df8Var.T(i);
        }
        this.m = i;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && z && this.d) {
            a();
        }
    }

    public void m() {
        boolean isBigV;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && TbadkCoreApplication.isLogin() && !this.a && this.c == TbadkCoreApplication.getCurrentAccountId()) {
            this.a = true;
            if (TbadkCoreApplication.getCurrentAccountInfo() == null) {
                isBigV = false;
            } else {
                isBigV = TbadkCoreApplication.getCurrentAccountInfo().isBigV();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.b.getPageActivity()).createNormalConfig(xg.g(TbadkCoreApplication.getCurrentAccount(), 0L), true, isBigV)));
            this.j.finish();
        }
    }

    public void n(kd8 kd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kd8Var) == null) {
            this.g.N();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (kd8Var == null) {
                this.i.w(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0cb8), true);
                this.i.l();
                this.i.r(8);
                return;
            }
            this.i.n();
            if (kd8Var.e() != null && ((kd8Var.e().getHide_stat() == 1 && kd8Var.e().getBlock_stat() == 1) || (kd8Var.e().getHide_stat() == 1 && kd8Var.e().getBlock_stat() == 2))) {
                this.i.t(this.a);
                this.i.r(8);
                return;
            }
            this.i.r(0);
            kd8Var.b();
            z = (kd8Var.f() == null || kd8Var.f().size() < 20) ? false : false;
            if (kd8Var.j() != null) {
                kd8Var.j().getSex();
            }
            this.d = false;
            if (this.a && kd8Var.j() != null) {
                kd8Var.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                kd8Var.j().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                g95.d().i(kd8Var.j());
            }
            q98 q98Var = this.n.get(0);
            q98Var.a(kd8Var.f());
            q98Var.b(z);
            this.g.Z(kd8Var, z, h(kd8Var));
        }
    }
}

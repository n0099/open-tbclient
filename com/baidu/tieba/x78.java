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
/* loaded from: classes6.dex */
public class x78 extends r78 implements jo7, o78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public long c;
    public boolean d;
    public BdUniqueId e;
    public t78 f;
    public r98 g;
    public PersonPolymericModel h;
    public s78 i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<e48> n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x78(BaseFragment baseFragment, t78 t78Var, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, t78Var, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
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
        this.f = t78Var;
        this.e = bdUniqueId;
        this.k = t78Var.e;
        this.l = new PersonPostModel(this.b, bdUniqueId, null, this.a, PersonPostModel.FROM_PERSON_POLYMERIC);
        r98 r98Var = new r98(baseFragment, t78Var, bdUniqueId, z, this.c);
        this.g = r98Var;
        r98Var.W(this);
        resetData();
        this.h = this.f.p();
        this.i = this.f.k();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new e48());
        this.n.add(new e48());
    }

    @Override // com.baidu.tieba.jo7
    public void a() {
        t78 t78Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (t78Var = this.f) == null) {
            return;
        }
        t78Var.a();
    }

    @Override // com.baidu.tieba.jo7
    public void b() {
        t78 t78Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (t78Var = this.f) == null) {
            return;
        }
        t78Var.b();
    }

    @Override // com.baidu.tieba.o78
    public r98 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : (r98) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o78
    public void e() {
        r98 r98Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (r98Var = this.g) == null) {
            return;
        }
        r98Var.M();
    }

    @Override // com.baidu.tieba.o78
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    public void i(ny8 ny8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ny8Var) == null) {
            this.g.X(ny8Var);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || this.m == i) {
            return;
        }
        r98 r98Var = this.g;
        if (r98Var != null) {
            r98Var.T(i);
        }
        this.m = i;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            r98 r98Var = this.g;
            if (r98Var != null) {
                r98Var.U();
            }
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && z && this.d) {
            a();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && TbadkCoreApplication.isLogin() && !this.a && this.c == TbadkCoreApplication.getCurrentAccountId()) {
            this.a = true;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.b.getPageActivity()).createNormalConfig(dh.g(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.j.finish();
        }
    }

    public void n(y78 y78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, y78Var) == null) {
            this.g.N();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (y78Var == null) {
                this.i.w(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c59), true);
                this.i.l();
                this.i.r(8);
                return;
            }
            this.i.n();
            if (y78Var.e() != null && ((y78Var.e().getHide_stat() == 1 && y78Var.e().getBlock_stat() == 1) || (y78Var.e().getHide_stat() == 1 && y78Var.e().getBlock_stat() == 2))) {
                this.i.t(this.a);
                this.i.r(8);
                return;
            }
            this.i.r(0);
            y78Var.b();
            z = (y78Var.f() == null || y78Var.f().size() < 20) ? false : false;
            if (y78Var.j() != null) {
                y78Var.j().getSex();
            }
            this.d = false;
            if (this.a && y78Var.j() != null) {
                y78Var.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                y78Var.j().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                o75.d().i(y78Var.j());
            }
            e48 e48Var = this.n.get(0);
            e48Var.a(y78Var.f());
            e48Var.b(z);
            this.g.Z(y78Var, z, h(y78Var));
        }
    }

    @Override // com.baidu.tieba.jo7
    public void resetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.resetThreadPn();
            PersonPolymericModel personPolymericModel = this.h;
            if (personPolymericModel != null) {
                personPolymericModel.N();
            }
        }
    }
}

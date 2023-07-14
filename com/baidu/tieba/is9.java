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
public class is9 extends cs9 implements q89, zr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public long c;
    public boolean d;
    public BdUniqueId e;
    public es9 f;
    public cu9 g;
    public PersonPolymericModel h;
    public ds9 i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<no9> n;

    @Override // com.baidu.tieba.zr9
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public is9(BaseFragment baseFragment, es9 es9Var, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, es9Var, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
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
        this.f = es9Var;
        this.e = bdUniqueId;
        this.k = es9Var.e;
        this.l = new PersonPostModel(this.b, bdUniqueId, null, this.a, 1);
        cu9 cu9Var = new cu9(baseFragment, es9Var, bdUniqueId, z, this.c);
        this.g = cu9Var;
        cu9Var.W(this);
        resetData();
        this.h = this.f.p();
        this.i = this.f.k();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new no9());
        this.n.add(new no9());
    }

    @Override // com.baidu.tieba.q89
    public void a() {
        es9 es9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (es9Var = this.f) != null) {
            es9Var.a();
        }
    }

    @Override // com.baidu.tieba.q89
    public void b() {
        es9 es9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (es9Var = this.f) != null) {
            es9Var.b();
        }
    }

    @Override // com.baidu.tieba.zr9
    public cu9 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (cu9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zr9
    public void e() {
        cu9 cu9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (cu9Var = this.g) != null) {
            cu9Var.M();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            cu9 cu9Var = this.g;
            if (cu9Var != null) {
                cu9Var.U();
            }
        }
    }

    @Override // com.baidu.tieba.q89
    public void resetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.resetThreadPn();
            PersonPolymericModel personPolymericModel = this.h;
            if (personPolymericModel != null) {
                personPolymericModel.j0();
            }
        }
    }

    public void i(gqa gqaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gqaVar) == null) {
            this.g.X(gqaVar);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || this.m == i) {
            return;
        }
        cu9 cu9Var = this.g;
        if (cu9Var != null) {
            cu9Var.T(i);
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.b.getPageActivity()).createNormalConfig(wg.g(TbadkCoreApplication.getCurrentAccount(), 0L), true, isBigV)));
            this.j.finish();
        }
    }

    public void n(js9 js9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, js9Var) == null) {
            this.g.N();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (js9Var == null) {
                this.i.y(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e1f), true);
                this.i.l();
                this.i.r(8);
                return;
            }
            this.i.n();
            if (js9Var.e() != null && ((js9Var.e().getHide_stat() == 1 && js9Var.e().getBlock_stat() == 1) || (js9Var.e().getHide_stat() == 1 && js9Var.e().getBlock_stat() == 2))) {
                this.i.t(this.a);
                this.i.r(8);
                return;
            }
            this.i.r(0);
            js9Var.b();
            z = (js9Var.f() == null || js9Var.f().size() < 20) ? false : false;
            if (js9Var.j() != null) {
                js9Var.j().getSex();
            }
            this.d = false;
            if (this.a && js9Var.j() != null) {
                js9Var.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                js9Var.j().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                zl5.d().i(js9Var.j());
            }
            no9 no9Var = this.n.get(0);
            no9Var.a(js9Var.f());
            no9Var.b(z);
            this.g.Z(js9Var, z, h(js9Var));
        }
    }
}

package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
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
public class jt9 extends dt9 implements u79, at9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public long c;
    public boolean d;
    public BdUniqueId e;
    public ft9 f;
    public dv9 g;
    public PersonPolymericModel h;
    public et9 i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<op9> n;

    @Override // com.baidu.tieba.at9
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jt9(BaseFragment baseFragment, ft9 ft9Var, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, ft9Var, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
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
        this.f = ft9Var;
        this.e = bdUniqueId;
        this.k = ft9Var.e;
        this.l = new PersonPostModel(this.b, bdUniqueId, null, this.a, 1);
        dv9 dv9Var = new dv9(baseFragment, ft9Var, bdUniqueId, z, this.c);
        this.g = dv9Var;
        dv9Var.X(this);
        resetData();
        this.h = this.f.p();
        this.i = this.f.k();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new op9());
        this.n.add(new op9());
    }

    @Override // com.baidu.tieba.u79
    public void a() {
        ft9 ft9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ft9Var = this.f) != null) {
            ft9Var.a();
        }
    }

    @Override // com.baidu.tieba.at9
    public dv9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (dv9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u79
    public void c() {
        ft9 ft9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ft9Var = this.f) != null) {
            ft9Var.c();
        }
    }

    @Override // com.baidu.tieba.at9
    public void e() {
        dv9 dv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (dv9Var = this.g) != null) {
            dv9Var.N();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            dv9 dv9Var = this.g;
            if (dv9Var != null) {
                dv9Var.V();
            }
        }
    }

    @Override // com.baidu.tieba.u79
    public void resetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.resetThreadPn();
            PersonPolymericModel personPolymericModel = this.h;
            if (personPolymericModel != null) {
                personPolymericModel.b0();
            }
        }
    }

    public void i(csa csaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, csaVar) == null) {
            this.g.Y(csaVar);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || this.m == i) {
            return;
        }
        dv9 dv9Var = this.g;
        if (dv9Var != null) {
            dv9Var.U(i);
        }
        this.m = i;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && z && this.d) {
            c();
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.b.getPageActivity()).createNormalConfig(JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, isBigV)));
            this.j.finish();
        }
    }

    public void n(kt9 kt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kt9Var) == null) {
            this.g.O();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (kt9Var == null) {
                this.i.y(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e4f), true);
                this.i.l();
                this.i.r(8);
                return;
            }
            this.i.n();
            if (kt9Var.e() != null && ((kt9Var.e().getHide_stat() == 1 && kt9Var.e().getBlock_stat() == 1) || (kt9Var.e().getHide_stat() == 1 && kt9Var.e().getBlock_stat() == 2))) {
                this.i.t(this.a);
                this.i.r(8);
                return;
            }
            this.i.r(0);
            kt9Var.b();
            z = (kt9Var.f() == null || kt9Var.f().size() < 20) ? false : false;
            if (kt9Var.j() != null) {
                kt9Var.j().getSex();
            }
            this.d = false;
            if (this.a && kt9Var.j() != null) {
                kt9Var.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                kt9Var.j().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                kt9Var.j().setIosBImgFormat(TbadkCoreApplication.getInst().getDefaultIosBImgFormat());
                kt9Var.j().setIosBUrl(TbadkCoreApplication.getInst().getDefaultIosBUrl());
                cg5.d().i(kt9Var.j());
            }
            op9 op9Var = this.n.get(0);
            op9Var.a(kt9Var.f());
            op9Var.b(z);
            this.g.a0(kt9Var, z, h(kt9Var));
        }
    }
}

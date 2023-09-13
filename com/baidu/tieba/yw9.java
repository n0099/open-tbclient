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
/* loaded from: classes9.dex */
public class yw9 extends sw9 implements wb9, pw9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public long c;
    public boolean d;
    public BdUniqueId e;
    public uw9 f;
    public sy9 g;
    public PersonPolymericModel h;
    public tw9 i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<dt9> n;

    @Override // com.baidu.tieba.pw9
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yw9(BaseFragment baseFragment, uw9 uw9Var, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, uw9Var, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
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
        this.f = uw9Var;
        this.e = bdUniqueId;
        this.k = uw9Var.e;
        this.l = new PersonPostModel(this.b, bdUniqueId, null, this.a, 1);
        sy9 sy9Var = new sy9(baseFragment, uw9Var, bdUniqueId, z, this.c);
        this.g = sy9Var;
        sy9Var.X(this);
        resetData();
        this.h = this.f.p();
        this.i = this.f.k();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new dt9());
        this.n.add(new dt9());
    }

    @Override // com.baidu.tieba.wb9
    public void a() {
        uw9 uw9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (uw9Var = this.f) != null) {
            uw9Var.a();
        }
    }

    @Override // com.baidu.tieba.pw9
    public sy9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (sy9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wb9
    public void c() {
        uw9 uw9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (uw9Var = this.f) != null) {
            uw9Var.c();
        }
    }

    @Override // com.baidu.tieba.pw9
    public void e() {
        sy9 sy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (sy9Var = this.g) != null) {
            sy9Var.N();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            sy9 sy9Var = this.g;
            if (sy9Var != null) {
                sy9Var.V();
            }
        }
    }

    @Override // com.baidu.tieba.wb9
    public void resetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.resetThreadPn();
            PersonPolymericModel personPolymericModel = this.h;
            if (personPolymericModel != null) {
                personPolymericModel.a0();
            }
        }
    }

    public void i(sva svaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, svaVar) == null) {
            this.g.Y(svaVar);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || this.m == i) {
            return;
        }
        sy9 sy9Var = this.g;
        if (sy9Var != null) {
            sy9Var.U(i);
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

    public void n(zw9 zw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, zw9Var) == null) {
            this.g.O();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (zw9Var == null) {
                this.i.y(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e40), true);
                this.i.l();
                this.i.r(8);
                return;
            }
            this.i.n();
            if (zw9Var.e() != null && ((zw9Var.e().getHide_stat() == 1 && zw9Var.e().getBlock_stat() == 1) || (zw9Var.e().getHide_stat() == 1 && zw9Var.e().getBlock_stat() == 2))) {
                this.i.t(this.a);
                this.i.r(8);
                return;
            }
            this.i.r(0);
            zw9Var.b();
            z = (zw9Var.f() == null || zw9Var.f().size() < 20) ? false : false;
            if (zw9Var.j() != null) {
                zw9Var.j().getSex();
            }
            this.d = false;
            if (this.a && zw9Var.j() != null) {
                zw9Var.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                zw9Var.j().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                zw9Var.j().setIosBImgFormat(TbadkCoreApplication.getInst().getDefaultIosBImgFormat());
                zw9Var.j().setIosBUrl(TbadkCoreApplication.getInst().getDefaultIosBUrl());
                sl5.d().i(zw9Var.j());
            }
            dt9 dt9Var = this.n.get(0);
            dt9Var.a(zw9Var.f());
            dt9Var.b(z);
            this.g.a0(zw9Var, z, h(zw9Var));
        }
    }
}

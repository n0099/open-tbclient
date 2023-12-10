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
/* loaded from: classes7.dex */
public class qba extends kba implements vo9, hba {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public long c;
    public boolean d;
    public BdUniqueId e;
    public mba f;
    public kda g;
    public PersonPolymericModel h;
    public lba i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<v7a> n;

    @Override // com.baidu.tieba.hba
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qba(BaseFragment baseFragment, mba mbaVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, mbaVar, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
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
        this.f = mbaVar;
        this.e = bdUniqueId;
        this.k = mbaVar.e;
        this.l = new PersonPostModel(this.b, bdUniqueId, null, this.a, 1);
        kda kdaVar = new kda(baseFragment, mbaVar, bdUniqueId, z, this.c);
        this.g = kdaVar;
        kdaVar.X(this);
        resetData();
        this.h = this.f.q();
        this.i = this.f.k();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new v7a());
        this.n.add(new v7a());
    }

    @Override // com.baidu.tieba.vo9
    public void a() {
        mba mbaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (mbaVar = this.f) != null) {
            mbaVar.a();
        }
    }

    @Override // com.baidu.tieba.hba
    public kda b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (kda) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vo9
    public void c() {
        mba mbaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (mbaVar = this.f) != null) {
            mbaVar.c();
        }
    }

    @Override // com.baidu.tieba.hba
    public void e() {
        kda kdaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (kdaVar = this.g) != null) {
            kdaVar.N();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            kda kdaVar = this.g;
            if (kdaVar != null) {
                kdaVar.V();
            }
        }
    }

    @Override // com.baidu.tieba.vo9
    public void resetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.resetThreadPn();
            PersonPolymericModel personPolymericModel = this.h;
            if (personPolymericModel != null) {
                personPolymericModel.c0();
            }
        }
    }

    public void i(aab aabVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aabVar) == null) {
            this.g.Y(aabVar);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || this.m == i) {
            return;
        }
        kda kdaVar = this.g;
        if (kdaVar != null) {
            kdaVar.U(i);
        }
        this.m = i;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && z && this.d) {
            c();
        }
    }

    public void n() {
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

    public void o(rba rbaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rbaVar) == null) {
            this.g.O();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (rbaVar == null) {
                this.i.z(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e70), true);
                this.i.l();
                this.i.s(8);
                return;
            }
            this.i.o();
            if (rbaVar.e() != null && ((rbaVar.e().getHide_stat() == 1 && rbaVar.e().getBlock_stat() == 1) || (rbaVar.e().getHide_stat() == 1 && rbaVar.e().getBlock_stat() == 2))) {
                this.i.u(this.a);
                this.i.s(8);
                return;
            }
            this.i.s(0);
            rbaVar.b();
            z = (rbaVar.f() == null || rbaVar.f().size() < 20) ? false : false;
            if (rbaVar.j() != null) {
                rbaVar.j().getSex();
            }
            this.d = false;
            if (this.a && rbaVar.j() != null) {
                rbaVar.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                rbaVar.j().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                rbaVar.j().setIosBImgFormat(TbadkCoreApplication.getInst().getDefaultIosBImgFormat());
                rbaVar.j().setIosBUrl(TbadkCoreApplication.getInst().getDefaultIosBUrl());
                bi5.d().i(rbaVar.j());
            }
            v7a v7aVar = this.n.get(0);
            v7aVar.a(rbaVar.f());
            v7aVar.b(z);
            this.g.a0(rbaVar, z, h(rbaVar));
        }
    }
}

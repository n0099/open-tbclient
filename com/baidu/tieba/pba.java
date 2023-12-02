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
public class pba extends jba implements uo9, gba {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public long c;
    public boolean d;
    public BdUniqueId e;
    public lba f;
    public jda g;
    public PersonPolymericModel h;
    public kba i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<u7a> n;

    @Override // com.baidu.tieba.gba
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pba(BaseFragment baseFragment, lba lbaVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, lbaVar, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
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
        this.f = lbaVar;
        this.e = bdUniqueId;
        this.k = lbaVar.e;
        this.l = new PersonPostModel(this.b, bdUniqueId, null, this.a, 1);
        jda jdaVar = new jda(baseFragment, lbaVar, bdUniqueId, z, this.c);
        this.g = jdaVar;
        jdaVar.X(this);
        resetData();
        this.h = this.f.q();
        this.i = this.f.k();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new u7a());
        this.n.add(new u7a());
    }

    @Override // com.baidu.tieba.uo9
    public void a() {
        lba lbaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (lbaVar = this.f) != null) {
            lbaVar.a();
        }
    }

    @Override // com.baidu.tieba.gba
    public jda b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (jda) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uo9
    public void c() {
        lba lbaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (lbaVar = this.f) != null) {
            lbaVar.c();
        }
    }

    @Override // com.baidu.tieba.gba
    public void e() {
        jda jdaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (jdaVar = this.g) != null) {
            jdaVar.N();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            jda jdaVar = this.g;
            if (jdaVar != null) {
                jdaVar.V();
            }
        }
    }

    @Override // com.baidu.tieba.uo9
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

    public void i(z9b z9bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, z9bVar) == null) {
            this.g.Y(z9bVar);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || this.m == i) {
            return;
        }
        jda jdaVar = this.g;
        if (jdaVar != null) {
            jdaVar.U(i);
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

    public void o(qba qbaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, qbaVar) == null) {
            this.g.O();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (qbaVar == null) {
                this.i.z(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e70), true);
                this.i.l();
                this.i.s(8);
                return;
            }
            this.i.o();
            if (qbaVar.e() != null && ((qbaVar.e().getHide_stat() == 1 && qbaVar.e().getBlock_stat() == 1) || (qbaVar.e().getHide_stat() == 1 && qbaVar.e().getBlock_stat() == 2))) {
                this.i.u(this.a);
                this.i.s(8);
                return;
            }
            this.i.s(0);
            qbaVar.b();
            z = (qbaVar.f() == null || qbaVar.f().size() < 20) ? false : false;
            if (qbaVar.j() != null) {
                qbaVar.j().getSex();
            }
            this.d = false;
            if (this.a && qbaVar.j() != null) {
                qbaVar.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                qbaVar.j().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                qbaVar.j().setIosBImgFormat(TbadkCoreApplication.getInst().getDefaultIosBImgFormat());
                qbaVar.j().setIosBUrl(TbadkCoreApplication.getInst().getDefaultIosBUrl());
                bi5.d().i(qbaVar.j());
            }
            u7a u7aVar = this.n.get(0);
            u7aVar.a(qbaVar.f());
            u7aVar.b(z);
            this.g.a0(qbaVar, z, h(qbaVar));
        }
    }
}

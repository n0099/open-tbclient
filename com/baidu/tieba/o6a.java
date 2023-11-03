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
public class o6a extends i6a implements zk9, f6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public long c;
    public boolean d;
    public BdUniqueId e;
    public k6a f;
    public i8a g;
    public PersonPolymericModel h;
    public j6a i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<t2a> n;

    @Override // com.baidu.tieba.f6a
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o6a(BaseFragment baseFragment, k6a k6aVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, k6aVar, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
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
        this.f = k6aVar;
        this.e = bdUniqueId;
        this.k = k6aVar.e;
        this.l = new PersonPostModel(this.b, bdUniqueId, null, this.a, 1);
        i8a i8aVar = new i8a(baseFragment, k6aVar, bdUniqueId, z, this.c);
        this.g = i8aVar;
        i8aVar.X(this);
        resetData();
        this.h = this.f.q();
        this.i = this.f.l();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new t2a());
        this.n.add(new t2a());
    }

    @Override // com.baidu.tieba.zk9
    public void a() {
        k6a k6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (k6aVar = this.f) != null) {
            k6aVar.a();
        }
    }

    @Override // com.baidu.tieba.f6a
    public i8a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (i8a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zk9
    public void c() {
        k6a k6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (k6aVar = this.f) != null) {
            k6aVar.c();
        }
    }

    @Override // com.baidu.tieba.f6a
    public void e() {
        i8a i8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (i8aVar = this.g) != null) {
            i8aVar.N();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            i8a i8aVar = this.g;
            if (i8aVar != null) {
                i8aVar.V();
            }
        }
    }

    @Override // com.baidu.tieba.zk9
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

    public void i(d5b d5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, d5bVar) == null) {
            this.g.Y(d5bVar);
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || this.m == i) {
            return;
        }
        i8a i8aVar = this.g;
        if (i8aVar != null) {
            i8aVar.U(i);
        }
        this.m = i;
    }

    public void m(boolean z) {
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

    public void o(p6a p6aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, p6aVar) == null) {
            this.g.O();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (p6aVar == null) {
                this.i.z(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e61), true);
                this.i.m();
                this.i.s(8);
                return;
            }
            this.i.o();
            if (p6aVar.e() != null && ((p6aVar.e().getHide_stat() == 1 && p6aVar.e().getBlock_stat() == 1) || (p6aVar.e().getHide_stat() == 1 && p6aVar.e().getBlock_stat() == 2))) {
                this.i.u(this.a);
                this.i.s(8);
                return;
            }
            this.i.s(0);
            p6aVar.b();
            z = (p6aVar.f() == null || p6aVar.f().size() < 20) ? false : false;
            if (p6aVar.j() != null) {
                p6aVar.j().getSex();
            }
            this.d = false;
            if (this.a && p6aVar.j() != null) {
                p6aVar.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                p6aVar.j().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                p6aVar.j().setIosBImgFormat(TbadkCoreApplication.getInst().getDefaultIosBImgFormat());
                p6aVar.j().setIosBUrl(TbadkCoreApplication.getInst().getDefaultIosBUrl());
                rh5.d().i(p6aVar.j());
            }
            t2a t2aVar = this.n.get(0);
            t2aVar.a(p6aVar.f());
            t2aVar.b(z);
            this.g.a0(p6aVar, z, h(p6aVar));
        }
    }
}

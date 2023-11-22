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
public class p6a extends j6a implements al9, g6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public long c;
    public boolean d;
    public BdUniqueId e;
    public l6a f;
    public j8a g;
    public PersonPolymericModel h;
    public k6a i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<u2a> n;

    @Override // com.baidu.tieba.g6a
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p6a(BaseFragment baseFragment, l6a l6aVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, l6aVar, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
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
        this.f = l6aVar;
        this.e = bdUniqueId;
        this.k = l6aVar.e;
        this.l = new PersonPostModel(this.b, bdUniqueId, null, this.a, 1);
        j8a j8aVar = new j8a(baseFragment, l6aVar, bdUniqueId, z, this.c);
        this.g = j8aVar;
        j8aVar.X(this);
        resetData();
        this.h = this.f.q();
        this.i = this.f.l();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new u2a());
        this.n.add(new u2a());
    }

    @Override // com.baidu.tieba.al9
    public void a() {
        l6a l6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (l6aVar = this.f) != null) {
            l6aVar.a();
        }
    }

    @Override // com.baidu.tieba.g6a
    public j8a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (j8a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.al9
    public void c() {
        l6a l6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (l6aVar = this.f) != null) {
            l6aVar.c();
        }
    }

    @Override // com.baidu.tieba.g6a
    public void e() {
        j8a j8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (j8aVar = this.g) != null) {
            j8aVar.N();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            j8a j8aVar = this.g;
            if (j8aVar != null) {
                j8aVar.V();
            }
        }
    }

    @Override // com.baidu.tieba.al9
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

    public void i(e5b e5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, e5bVar) == null) {
            this.g.Y(e5bVar);
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || this.m == i) {
            return;
        }
        j8a j8aVar = this.g;
        if (j8aVar != null) {
            j8aVar.U(i);
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

    public void o(q6a q6aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, q6aVar) == null) {
            this.g.O();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (q6aVar == null) {
                this.i.z(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e61), true);
                this.i.m();
                this.i.s(8);
                return;
            }
            this.i.o();
            if (q6aVar.e() != null && ((q6aVar.e().getHide_stat() == 1 && q6aVar.e().getBlock_stat() == 1) || (q6aVar.e().getHide_stat() == 1 && q6aVar.e().getBlock_stat() == 2))) {
                this.i.u(this.a);
                this.i.s(8);
                return;
            }
            this.i.s(0);
            q6aVar.b();
            z = (q6aVar.f() == null || q6aVar.f().size() < 20) ? false : false;
            if (q6aVar.j() != null) {
                q6aVar.j().getSex();
            }
            this.d = false;
            if (this.a && q6aVar.j() != null) {
                q6aVar.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                q6aVar.j().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                q6aVar.j().setIosBImgFormat(TbadkCoreApplication.getInst().getDefaultIosBImgFormat());
                q6aVar.j().setIosBUrl(TbadkCoreApplication.getInst().getDefaultIosBUrl());
                sh5.d().i(q6aVar.j());
            }
            u2a u2aVar = this.n.get(0);
            u2aVar.a(q6aVar.f());
            u2aVar.b(z);
            this.g.a0(q6aVar, z, h(q6aVar));
        }
    }
}

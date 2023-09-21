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
/* loaded from: classes8.dex */
public class wy9 extends qy9 implements hd9, ny9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public long c;
    public boolean d;
    public BdUniqueId e;
    public sy9 f;
    public q0a g;
    public PersonPolymericModel h;
    public ry9 i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<bv9> n;

    @Override // com.baidu.tieba.ny9
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wy9(BaseFragment baseFragment, sy9 sy9Var, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, sy9Var, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
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
        this.f = sy9Var;
        this.e = bdUniqueId;
        this.k = sy9Var.e;
        this.l = new PersonPostModel(this.b, bdUniqueId, null, this.a, 1);
        q0a q0aVar = new q0a(baseFragment, sy9Var, bdUniqueId, z, this.c);
        this.g = q0aVar;
        q0aVar.X(this);
        resetData();
        this.h = this.f.p();
        this.i = this.f.k();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new bv9());
        this.n.add(new bv9());
    }

    @Override // com.baidu.tieba.hd9
    public void a() {
        sy9 sy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (sy9Var = this.f) != null) {
            sy9Var.a();
        }
    }

    @Override // com.baidu.tieba.ny9
    public q0a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (q0a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hd9
    public void c() {
        sy9 sy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (sy9Var = this.f) != null) {
            sy9Var.c();
        }
    }

    @Override // com.baidu.tieba.ny9
    public void e() {
        q0a q0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (q0aVar = this.g) != null) {
            q0aVar.N();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            q0a q0aVar = this.g;
            if (q0aVar != null) {
                q0aVar.V();
            }
        }
    }

    @Override // com.baidu.tieba.hd9
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

    public void i(kxa kxaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kxaVar) == null) {
            this.g.Y(kxaVar);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || this.m == i) {
            return;
        }
        q0a q0aVar = this.g;
        if (q0aVar != null) {
            q0aVar.U(i);
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

    public void n(xy9 xy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, xy9Var) == null) {
            this.g.O();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (xy9Var == null) {
                this.i.y(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e42), true);
                this.i.l();
                this.i.r(8);
                return;
            }
            this.i.n();
            if (xy9Var.e() != null && ((xy9Var.e().getHide_stat() == 1 && xy9Var.e().getBlock_stat() == 1) || (xy9Var.e().getHide_stat() == 1 && xy9Var.e().getBlock_stat() == 2))) {
                this.i.t(this.a);
                this.i.r(8);
                return;
            }
            this.i.r(0);
            xy9Var.b();
            z = (xy9Var.f() == null || xy9Var.f().size() < 20) ? false : false;
            if (xy9Var.j() != null) {
                xy9Var.j().getSex();
            }
            this.d = false;
            if (this.a && xy9Var.j() != null) {
                xy9Var.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                xy9Var.j().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                xy9Var.j().setIosBImgFormat(TbadkCoreApplication.getInst().getDefaultIosBImgFormat());
                xy9Var.j().setIosBUrl(TbadkCoreApplication.getInst().getDefaultIosBUrl());
                wl5.d().i(xy9Var.j());
            }
            bv9 bv9Var = this.n.get(0);
            bv9Var.a(xy9Var.f());
            bv9Var.b(z);
            this.g.a0(xy9Var, z, h(xy9Var));
        }
    }
}

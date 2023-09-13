package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.FrsTabTestHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes6.dex */
public class kn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public FrsFragment b;
    public TextView c;
    public FrsTabSortSwitchButton d;
    public String e;
    public int f;
    public FrsTabSortSwitchButton.e g;

    /* loaded from: classes6.dex */
    public class a implements FrsTabSortSwitchButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kn7 a;

        public a(kn7 kn7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kn7Var;
        }

        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                boolean z = false;
                if (!wh7.f().i() && !vh7.h().j()) {
                    if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                        this.a.b.showToast(R.string.obfuscated_res_0x7f0f0e40);
                        return false;
                    } else if (this.a.b.f1() != null && this.a.b.N1() != null) {
                        z = true;
                        if (this.a.f == i) {
                            return true;
                        }
                        this.a.b.f1().f1(this.a.d.x(this.a.f));
                        this.a.f = i;
                        if (this.a.f != 7) {
                            tx5.c();
                            yia.a();
                        } else {
                            yia.b();
                        }
                        this.a.b.f1().b1(this.a.d.x(this.a.f));
                        if (UbsABTestHelper.isFrsNewAreaTabSortTestA()) {
                            FrsTabTestHelper.storeFrsNewAreaTabSort(this.a.d.x(this.a.f));
                        }
                        this.a.b.f1().e1(true);
                        this.a.b.N1().c2();
                        this.a.b.f1().d1(true);
                        this.a.f();
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    public kn7(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = -1;
        this.g = new a(this);
        if (frsFragment != null && relativeLayout != null) {
            this.b = frsFragment;
            View inflate = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.obfuscated_res_0x7f0d03a7, relativeLayout);
            this.a = inflate;
            inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
            this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0922a2);
            FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.a.findViewById(R.id.obfuscated_res_0x7f0922a3);
            this.d = frsTabSortSwitchButton;
            frsTabSortSwitchButton.setOnSwitchChangeListener(this.g);
            this.f = this.d.getState();
            i();
        }
    }

    public void g(int i) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (frsTabSortSwitchButton = this.d) != null) {
            frsTabSortSwitchButton.u(i);
            this.f = this.d.getState();
        }
    }

    public void j(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, list) == null) && (frsTabSortSwitchButton = this.d) != null) {
            frsTabSortSwitchButton.setData(list);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.e = str;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c11437");
            statisticItem.param("obj_type", this.d.x(this.f));
            statisticItem.param("fid", this.e);
            TiebaStatic.log(statisticItem);
        }
    }

    public FrsTabSortSwitchButton h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (FrsTabSortSwitchButton) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FrsTabSortSwitchButton frsTabSortSwitchButton = this.d;
            if (frsTabSortSwitchButton != null) {
                frsTabSortSwitchButton.E();
            }
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0108);
        }
    }
}

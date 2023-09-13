package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.FrsTabTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes6.dex */
public class jn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public BaseFragment b;
    public TextView c;
    public FrsTabSortSwitchButton d;
    public int e;
    public String f;
    public FrsTabSortSwitchButton.e g;

    /* loaded from: classes6.dex */
    public class a implements FrsTabSortSwitchButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jn7 a;

        public a(jn7 jn7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jn7Var;
        }

        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        public boolean a(int i) {
            InterceptResult invokeI;
            nl7 o2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                boolean z = false;
                if (!wh7.f().i() && !vh7.h().j()) {
                    if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                        this.a.b.showToast(R.string.obfuscated_res_0x7f0f0e40);
                        return false;
                    }
                    if (this.a.b instanceof FrsNewAreaFragment) {
                        if (((FrsNewAreaFragment) this.a.b).G2() == null || ((FrsNewAreaFragment) this.a.b).C2() == null) {
                            return false;
                        }
                    } else if ((this.a.b instanceof FrsCommonTabFragment) && (o2 = ((FrsCommonTabFragment) this.a.b).o2()) != null && ((FrsCommonTabFragment) this.a.b).n2() != null) {
                        if (o2.j()) {
                            return false;
                        }
                    }
                    z = true;
                    if (this.a.e == i) {
                        return true;
                    }
                    this.a.e = i;
                    if (this.a.e != 7) {
                        tx5.c();
                        yia.a();
                    } else {
                        yia.b();
                    }
                    if (this.a.b instanceof FrsNewAreaFragment) {
                        ((FrsNewAreaFragment) this.a.b).G2().c0(this.a.d.x(this.a.e));
                        if (UbsABTestHelper.isFrsNewAreaTabSortTestA()) {
                            FrsTabTestHelper.storeFrsNewAreaTabSort(this.a.d.x(this.a.e));
                        }
                        ((FrsNewAreaFragment) this.a.b).C2().P();
                    } else {
                        ((FrsCommonTabFragment) this.a.b).v2(sw7.d(this.a.d.x(this.a.e)));
                        ((FrsCommonTabFragment) this.a.b).n2().x(true);
                    }
                    this.a.f();
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    public jn7(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = -1;
        this.g = new a(this);
        if (baseFragment != null && relativeLayout != null) {
            this.b = baseFragment;
            View inflate = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.obfuscated_res_0x7f0d03a7, relativeLayout);
            this.a = inflate;
            inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
            this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0922a2);
            FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.a.findViewById(R.id.obfuscated_res_0x7f0922a3);
            this.d = frsTabSortSwitchButton;
            frsTabSortSwitchButton.setOnSwitchChangeListener(this.g);
            this.e = this.d.getState();
            h();
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && this.d != null) {
            this.d.u(sw7.f(i));
            this.e = this.d.getState();
        }
    }

    public void i(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && (frsTabSortSwitchButton = this.d) != null) {
            frsTabSortSwitchButton.setData(list);
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f = str;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c11437");
            statisticItem.param("obj_type", this.d.x(this.e));
            statisticItem.param("fid", this.f);
            TiebaStatic.log(statisticItem);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrsTabSortSwitchButton frsTabSortSwitchButton = this.d;
            if (frsTabSortSwitchButton != null) {
                frsTabSortSwitchButton.E();
            }
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
        }
    }
}

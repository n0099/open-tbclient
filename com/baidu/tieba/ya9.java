package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.newinterest.fragment.BaseInterestSelectionFragment;
import com.baidu.tieba.newinterest.fragment.BaseInterestedForumFragment;
import com.baidu.tieba.newinterest.fragment.InterestSelectionStyleAFragment;
import com.baidu.tieba.newinterest.fragment.InterestedForumStyleAFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class ya9 implements View.OnClickListener, BaseInterestSelectionFragment.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public int b;
    public String[] c;
    public boolean d;
    public View e;
    public View f;
    public TextView g;
    public NavigationBar h;
    public BaseInterestedForumFragment i;
    public BaseInterestSelectionFragment j;

    public ya9(BaseFragmentActivity baseFragmentActivity, int i, String[] strArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, Integer.valueOf(i), strArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = baseFragmentActivity;
        this.b = i;
        this.c = strArr;
        this.d = z;
        f();
        g();
    }

    @Override // com.baidu.tieba.newinterest.fragment.BaseInterestSelectionFragment.a
    public void a(List<na9> list) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            InterestedForumStyleAFragment N1 = InterestedForumStyleAFragment.N1(this.b, this.c);
            this.i = N1;
            N1.L1(list);
            b().beginTransaction().add(R.id.content_container, this.i).addToBackStack(null).commitAllowingStateLoss();
            if (b().getFragments().size() == 1) {
                i = 1;
            } else {
                i = 2;
            }
            ua9.a(i, 1, this.b, c(list), "");
        }
    }

    public String c(List<na9> list) {
        InterceptResult invokeL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (na9 na9Var : list) {
                if (na9Var != null) {
                    if (sb.length() > 0) {
                        sb.append("|");
                    }
                    if (TextUtils.isEmpty(na9Var.a())) {
                        a = na9Var.d();
                    } else {
                        a = na9Var.a();
                    }
                    sb.append(a);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            int i = 1;
            if (view2 == this.f && this.a != null) {
                BaseInterestedForumFragment baseInterestedForumFragment = this.i;
                if (baseInterestedForumFragment != null && baseInterestedForumFragment.isVisible()) {
                    b().popBackStack();
                    ua9.c(1, this.b);
                    return;
                }
                e();
            } else if (view2 == this.g) {
                e();
                if (b().getFragments().size() != 1) {
                    i = 2;
                }
                ua9.a(i, 2, this.b, "", "");
            }
        }
    }

    public final FragmentManager b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.getSupportFragmentManager();
        }
        return (FragmentManager) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.g.setOnClickListener(this);
            this.f.setOnClickListener(this);
            BaseInterestSelectionFragment baseInterestSelectionFragment = this.j;
            if (baseInterestSelectionFragment != null) {
                baseInterestSelectionFragment.L1(this);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && b().getFragments().size() == 1) {
            ua9.c(1, this.b);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0201);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 1);
            TiebaStatic.log(statisticItem);
            if (this.d) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.a).createNormalCfg(0)));
            } else {
                this.a.finish();
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0041, (ViewGroup) null);
            this.e = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
            this.h = navigationBar;
            TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(R.string.obfuscated_res_0x7f0f13fb));
            this.g = addTextButton;
            addTextButton.setId(R.id.btn_skip);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0108);
            this.f = this.h.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            InterestSelectionStyleAFragment M1 = InterestSelectionStyleAFragment.M1(this.b, this.c);
            this.j = M1;
            b().beginTransaction().add(R.id.content_container, M1).commitAllowingStateLoss();
            TiebaStatic.log(new StatisticItem("c13681"));
        }
    }
}

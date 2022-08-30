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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class kr7 implements View.OnClickListener, BaseInterestSelectionFragment.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public int b;
    public boolean c;
    public ArrayList<Integer> d;
    public String[] e;
    public View f;
    public View g;
    public TextView h;
    public NavigationBar i;
    public BaseInterestedForumFragment j;
    public BaseInterestSelectionFragment k;

    public kr7(BaseFragmentActivity baseFragmentActivity, int i, boolean z, ArrayList<Integer> arrayList, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, Integer.valueOf(i), Boolean.valueOf(z), arrayList, strArr};
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
        this.c = z;
        this.d = arrayList;
        this.e = strArr;
        f();
        g();
    }

    @Override // com.baidu.tieba.newinterest.fragment.BaseInterestSelectionFragment.a
    public void a(List<zq7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            InterestedForumStyleAFragment x1 = InterestedForumStyleAFragment.x1(this.b, this.e);
            this.j = x1;
            x1.u1(list);
            b().beginTransaction().add(R.id.obfuscated_res_0x7f0906d3, this.j).addToBackStack(null).commitAllowingStateLoss();
            gr7.a(b().getFragments().size() == 1 ? 1 : 2, 1, this.b, c(list), "");
        }
    }

    public final FragmentManager b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getSupportFragmentManager() : (FragmentManager) invokeV.objValue;
    }

    public String c(List<zq7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (zq7 zq7Var : list) {
                if (zq7Var != null) {
                    if (sb.length() > 0) {
                        sb.append("|");
                    }
                    sb.append(TextUtils.isEmpty(zq7Var.a()) ? zq7Var.d() : zq7Var.a());
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 1);
            TiebaStatic.log(statisticItem);
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.a).createNormalCfg(0)));
        }
    }

    public final void f() {
        BaseInterestedForumFragment baseInterestedForumFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d003e, (ViewGroup) null);
            this.f = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f091626);
            this.i = navigationBar;
            TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(R.string.obfuscated_res_0x7f0f11a4));
            this.h = addTextButton;
            addTextButton.setId(R.id.obfuscated_res_0x7f09044d);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0108);
            this.g = this.i.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            boolean z = this.c;
            if (z) {
                this.j = InterestedForumStyleAFragment.w1(this.b, z, this.e);
                List<zq7> j = j();
                if (j != null) {
                    this.j.u1(j);
                }
                BaseInterestedForumFragment baseInterestedForumFragment2 = this.j;
                this.g.setVisibility(4);
                baseInterestedForumFragment = baseInterestedForumFragment2;
            } else {
                InterestSelectionStyleAFragment v1 = InterestSelectionStyleAFragment.v1(this.b, this.e);
                this.k = v1;
                baseInterestedForumFragment = v1;
            }
            b().beginTransaction().add(R.id.obfuscated_res_0x7f0906d3, baseInterestedForumFragment).commitAllowingStateLoss();
            TiebaStatic.log(new StatisticItem("c13681"));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h.setOnClickListener(this);
            this.g.setOnClickListener(this);
            BaseInterestSelectionFragment baseInterestSelectionFragment = this.k;
            if (baseInterestSelectionFragment != null) {
                baseInterestSelectionFragment.u1(this);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && b().getFragments().size() == 1) {
            gr7.c(1, this.b);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0201);
        }
    }

    public final List<zq7> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (ListUtils.isEmpty(this.d)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = this.d.iterator();
            while (it.hasNext()) {
                zq7 zq7Var = new zq7();
                zq7Var.i(it.next().intValue());
                arrayList.add(zq7Var);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            if (view2 == this.g && this.a != null) {
                BaseInterestedForumFragment baseInterestedForumFragment = this.j;
                if (baseInterestedForumFragment != null && baseInterestedForumFragment.isVisible()) {
                    b().popBackStack();
                    gr7.c(1, this.b);
                    return;
                }
                e();
            } else if (view2 == this.h) {
                e();
                gr7.a(b().getFragments().size() != 1 ? 2 : 1, 2, this.b, "", "");
            }
        }
    }
}

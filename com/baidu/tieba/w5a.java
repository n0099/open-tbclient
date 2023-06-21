package com.baidu.tieba;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class w5a extends i9<AvatarPendantActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x5a a;
    public BdListView b;
    public NoNetworkView c;
    public MemberRecommendView d;
    public NavigationBar e;
    public int f;
    public TextView g;
    public TextView h;
    public AvatarPendantActivity i;
    public View j;
    public TextView k;

    /* loaded from: classes8.dex */
    public interface a {
        void R0(DressItemData dressItemData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w5a(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {avatarPendantActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 0;
        this.i = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.obfuscated_res_0x7f0d0130);
        this.j = avatarPendantActivity.findViewById(R.id.obfuscated_res_0x7f091edb);
        this.f = wi.g(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0703b6);
        this.b = (BdListView) avatarPendantActivity.findViewById(R.id.obfuscated_res_0x7f09031c);
        this.c = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e.setTitleText(R.string.obfuscated_res_0x7f0f0301);
        MemberRecommendView memberRecommendView = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.obfuscated_res_0x7f09031e);
        this.d = memberRecommendView;
        memberRecommendView.setFromType(8);
        this.d.getButton().setOnClickListener(avatarPendantActivity);
        TextView textView = new TextView(avatarPendantActivity.getActivity());
        this.g = textView;
        textView.setHeight(wi.g(avatarPendantActivity.getActivity(), R.dimen.obfuscated_res_0x7f07019c));
        this.k = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + wi.g(avatarPendantActivity.getActivity(), R.dimen.obfuscated_res_0x7f070282));
        TextView textView2 = new TextView(avatarPendantActivity.getActivity());
        this.h = textView2;
        textView2.setHeight(wi.g(avatarPendantActivity.getActivity(), R.dimen.obfuscated_res_0x7f0703e6));
        this.k.setLayoutParams(layoutParams);
        this.b.w(this.k, 0);
        this.b.addFooterView(this.h);
        x5a x5aVar = new x5a(avatarPendantActivity);
        this.a = x5aVar;
        this.b.setAdapter((ListAdapter) x5aVar);
    }

    public TextView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.k;
        }
        return (TextView) invokeV.objValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.i.hideNetRefreshView(this.j);
            this.b.setVisibility(0);
        }
    }

    public MemberRecommendView y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (MemberRecommendView) invokeV.objValue;
    }

    public View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            lt5.a(this.i.getPageContext(), this.j);
            this.b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            this.a.notifyDataSetChanged();
            this.e.onChangeSkinType(this.i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.c.d(this.i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.d.d();
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
        }
    }

    public void C(List<u5a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.b.setVisibility(0);
                this.a.c(list);
                this.a.notifyDataSetChanged();
                return;
            }
            this.b.setVisibility(8);
        }
    }

    public void E(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.a.b(aVar);
        }
    }

    public void u(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.c.a(bVar);
        }
    }

    public final boolean D(w6a w6aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, w6aVar)) == null) {
            if (w6aVar != null && !StringUtils.isNull(w6aVar.c())) {
                this.d.setVisibility(0);
                this.d.e(w6aVar);
                return true;
            }
            this.d.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.setVisibility(8);
            String string = this.i.getPageContext().getResources().getString(R.string.no_data_text);
            this.i.setNetRefreshViewTopMargin(this.f);
            this.i.showNetRefreshView(this.j, string, false);
        }
    }

    public void G(w6a w6aVar, List<u5a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, w6aVar, list) == null) {
            if ((w6aVar != null && !StringUtils.isNull(w6aVar.c())) || (list != null && list.size() > 0)) {
                x();
                if (D(w6aVar)) {
                    this.b.removeHeaderView(this.g);
                    this.b.addHeaderView(this.g);
                } else {
                    this.b.removeHeaderView(this.g);
                }
                C(list);
                return;
            }
            F();
        }
    }
}

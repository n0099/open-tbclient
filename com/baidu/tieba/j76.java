package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity;
import com.baidu.tieba.h76;
import com.baidu.tieba.z95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class j76 extends BdBaseView<NewFriendsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewFriendsActivity a;
    public View b;
    public NavigationBar c;
    public ImageView d;
    public BdListView e;
    public h76 f;
    public aa5 g;
    public NoDataView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j76(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newFriendsActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = newFriendsActivity;
        this.b = newFriendsActivity.findViewById(R.id.obfuscated_res_0x7f09194a);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.c = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e46));
        this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.a).findViewById(R.id.new_friend_search);
        this.d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.e = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f09194b);
        h76 h76Var = new h76(this.a);
        this.f = h76Var;
        this.e.setAdapter((ListAdapter) h76Var);
        this.e.setOnItemClickListener(this.a);
        this.e.setOnItemLongClickListener(this.a);
        aa5 aa5Var = new aa5(newFriendsActivity.getPageContext());
        this.g = aa5Var;
        this.e.setPullRefresh(aa5Var);
        BdListViewHelper.d(this.a.getActivity(), this.e, BdListViewHelper.HeadType.DEFAULT);
        this.h = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.obfuscated_res_0x7f0703c0)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0e87), null);
    }

    public void C(z95.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
            this.g.a(gVar);
        }
    }

    public void D(h76.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f.f(cVar);
        }
    }

    public void F(List<cf8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f.h(list);
            this.f.notifyDataSetChanged();
        }
    }

    public void y(cf8 cf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cf8Var) == null) {
            this.f.d(cf8Var);
            this.f.notifyDataSetChanged();
        }
    }

    public void z(List<cf8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.e.setEmptyView(this.h);
            this.f.e(list);
            this.f.notifyDataSetChanged();
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.E();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e.z(0L);
        }
    }

    public h76 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (h76) invokeV.objValue;
    }

    public void t(BDLayoutMode bDLayoutMode, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, bDLayoutMode, i) == null) {
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            bDLayoutMode.setNightMode(z);
            this.c.onChangeSkinType(this.a.getPageContext(), i);
            this.g.C(i);
            bDLayoutMode.onModeChanged(this.b);
            this.h.f(this.a.getPageContext(), i);
            this.d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }
}

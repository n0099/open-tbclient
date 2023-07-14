package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity;
import com.baidu.tieba.m86;
import com.baidu.tieba.sa5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class o86 extends j9<NewFriendsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewFriendsActivity a;
    public View b;
    public NavigationBar c;
    public ImageView d;
    public BdListView e;
    public m86 f;
    public ta5 g;
    public NoDataView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o86(NewFriendsActivity newFriendsActivity) {
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
                super((l9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = newFriendsActivity;
        this.b = newFriendsActivity.findViewById(R.id.obfuscated_res_0x7f0918f8);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.c = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e25));
        this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.a).findViewById(R.id.new_friend_search);
        this.d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.e = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f0918f9);
        m86 m86Var = new m86(this.a);
        this.f = m86Var;
        this.e.setAdapter((ListAdapter) m86Var);
        this.e.setOnItemClickListener(this.a);
        this.e.setOnItemLongClickListener(this.a);
        ta5 ta5Var = new ta5(newFriendsActivity.getPageContext());
        this.g = ta5Var;
        this.e.setPullRefresh(ta5Var);
        BdListViewHelper.d(this.a.getActivity(), this.e, BdListViewHelper.HeadType.DEFAULT);
        this.h = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, yi.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f0703bc)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0e66), null);
    }

    public void B(md8 md8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, md8Var) == null) {
            this.f.d(md8Var);
            this.f.notifyDataSetChanged();
        }
    }

    public void C(List<md8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.e.setEmptyView(this.h);
            this.f.e(list);
            this.f.notifyDataSetChanged();
        }
    }

    public void D(sa5.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            this.g.f(gVar);
        }
    }

    public void E(m86.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f.f(cVar);
        }
    }

    public void G(List<md8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f.h(list);
            this.f.notifyDataSetChanged();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e.E();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.z(0L);
        }
    }

    public m86 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (m86) invokeV.objValue;
    }

    public void x(q05 q05Var, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, q05Var, i) == null) {
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            q05Var.l(z);
            this.c.onChangeSkinType(this.a.getPageContext(), i);
            this.g.H(i);
            q05Var.k(this.b);
            this.h.f(this.a.getPageContext(), i);
            this.d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }
}

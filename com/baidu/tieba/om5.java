package com.baidu.tieba;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity;
import com.baidu.tieba.ad.browser.newstyle.view.ApkDownloadBannerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class om5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public AdBaseWebViewActivity c;
    public NavigationBar d;
    public TextView e;
    public View f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public LinearLayout j;
    public TextView k;
    public NoDataView l;
    public View.OnClickListener m;
    public View n;
    public MorePopupWindow o;
    public ApkDownloadBannerView p;
    public boolean q;
    public String r;
    public pm5 s;
    public pi0 t;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om5 a;

        public a(om5 om5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.c == null || this.a.c.webViewGoBack()) {
                return;
            }
            this.a.c.finish();
        }
    }

    public om5(AdBaseWebViewActivity adBaseWebViewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adBaseWebViewActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.q = true;
        this.c = adBaseWebViewActivity;
        i();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.l == null) {
                this.l = NoDataViewFactory.a(this.c.getPageContext().getPageActivity(), this.a, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.e.d(null, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f14d8)), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f0fba), this.m)));
            }
            this.l.f(this.c.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.j.setVisibility(8);
            this.l.setVisibility(0);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void C(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareItem) == null) || shareItem == null) {
            return;
        }
        TiebaStatic.eventStat(this.c.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.w);
        statisticItem.param("obj_type", 0);
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.c.getPageContext().getPageActivity(), shareItem, true, d())));
    }

    public void b() {
        pi0 pi0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (pi0Var = this.t) == null) {
            return;
        }
        pi0Var.p.c = this.r;
        if (this.s == null) {
            this.s = new pm5(this.p, pi0Var);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ug.d(this.o, this.c.getPageContext().getPageActivity());
        }
    }

    public final SparseArray<String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SparseArray<String> sparseArray = new SparseArray<>(8);
            sparseArray.put(2, "pb_wx_timeline");
            sparseArray.put(3, "pb_wx_friend");
            sparseArray.put(4, "pb_qq_zone");
            sparseArray.put(5, "pb_tencent_weibo");
            sparseArray.put(6, "pb_sina_weibo");
            sparseArray.put(7, "pb_renren");
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.k.setVisibility(8);
        }
    }

    public void f() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (noDataView = this.l) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.j.setVisibility(0);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            UtilHelper.getStatusBarHeight();
            ri.f(this.c.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070282);
            int i = ri.r(this.c.getPageContext().getPageActivity()).heightPixels;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.c.setContentView(R.layout.obfuscated_res_0x7f0d013d);
            this.a = this.c.findViewById(R.id.obfuscated_res_0x7f091c33);
            this.d = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f092566);
            w("");
            this.j = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0925fc);
            this.p = (ApkDownloadBannerView) this.c.findViewById(R.id.obfuscated_res_0x7f0925f6);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f092566);
            this.j.setLayoutParams(layoutParams);
            this.k = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0925fe);
            View addCustomView = this.d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d0901, new a(this));
            this.f = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f09261f);
            this.g = imageView;
            imageView.setContentDescription(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f02ca));
            h();
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                this.j.addView(this.c.createWebView());
                this.k.setVisibility(8);
                if (this.q) {
                    return true;
                }
                this.d.setStatusBarVisibility(8);
                return true;
            } catch (Exception e) {
                this.k.setVisibility(0);
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void k(pi0 pi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pi0Var) == null) {
            this.t = pi0Var;
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            NavigationBar navigationBar = this.d;
            return navigationBar != null && navigationBar.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.c.getPageContext(), i);
            }
            MorePopupWindow morePopupWindow = this.o;
            if (morePopupWindow != null) {
                morePopupWindow.onChangeSkinType(this.c, i, SkinManager.getDrawable(R.drawable.bg_pull_down_right_n));
            }
            NoDataView noDataView = this.l;
            if (noDataView != null) {
                noDataView.f(this.c.getPageContext(), i);
            }
            SkinManager.setNavbarIconSrc(this.g, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
            SkinManager.setNavbarIconSrc(this.h, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
            SkinManager.setNavbarIconSrc(this.i, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
        }
    }

    public void n() {
        pm5 pm5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pm5Var = this.s) == null) {
            return;
        }
        pm5Var.v();
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            LinearLayout linearLayout = this.j;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.release();
            }
            MorePopupWindow morePopupWindow = this.o;
            if (morePopupWindow != null) {
                ug.d(morePopupWindow, this.c.getPageContext().getPageActivity());
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f092566);
            this.j.setLayoutParams(layoutParams);
            this.g.setBackgroundDrawable(null);
            this.h.setBackgroundDrawable(null);
            this.i.setBackgroundDrawable(null);
            this.d.showBottomLine(true);
            this.c.getWindow().clearFlags(1024);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.r = str;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.p.setDownloadWarningVisible(z);
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.addRule(3, 0);
            layoutParams.height = -1;
            this.j.setLayoutParams(layoutParams);
            this.d.getBackground().mutate().setAlpha(0);
            this.d.showBottomLine(false);
            SkinManager.setBackgroundResource(this.g, R.drawable.obfuscated_res_0x7f08058c);
            SkinManager.setBackgroundResource(this.h, R.drawable.obfuscated_res_0x7f08058c);
            SkinManager.setBackgroundResource(this.i, R.drawable.obfuscated_res_0x7f08058c);
            w("");
            this.c.getWindow().setFlags(1024, 1024);
        }
    }

    public void u(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (view2 = this.n) == null) {
            return;
        }
        if (z) {
            view2.setVisibility(0);
        } else {
            view2.setVisibility(8);
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            if (z) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
            this.j.getLayoutParams().height = -1;
        }
    }

    public void w(String str) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.e = this.d.setCenterTextTitle(str);
            ImageView imageView2 = this.g;
            if (imageView2 != null && imageView2.getVisibility() == 0 && (imageView = this.h) != null && imageView.getVisibility() == 0) {
                this.e.setMaxWidth(ri.f(this.c.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07024e) * 2);
            }
            SkinManager.setNavbarTitleColor(this.e, R.color.CAM_X0105, R.color.s_navbar_title_color);
        }
    }

    public void x(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void y(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || (view2 = this.b) == null) {
            return;
        }
        if (z) {
            view2.setVisibility(0);
        } else {
            view2.setVisibility(8);
        }
        this.o.refresh();
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.q = z;
        }
    }
}

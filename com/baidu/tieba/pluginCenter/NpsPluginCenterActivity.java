package com.baidu.tieba.pluginCenter;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import c.a.d.i.c;
import c.a.t0.l0.f.b;
import c.a.u0.d3.d;
import c.a.u0.d3.e;
import c.a.u0.d3.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.pass.ecommerce.common.view.ToastUtil;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class NpsPluginCenterActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbSettingTextTipView livePlugin;
    public int mFromType;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public b<Object, c.a.t0.l0.d.b, c.a.t0.l0.f.a<Object, c.a.t0.l0.d.b>> mPluginCenterAdapter;
    public View mRootView;
    public List<Object> mShowList;
    @NonNull
    public final List<TbSettingTextTipView> tipViewList;
    @NonNull
    public final List<String> whiteList;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BundleInfo f47540e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NpsPluginCenterActivity f47541f;

        public a(NpsPluginCenterActivity npsPluginCenterActivity, BundleInfo bundleInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {npsPluginCenterActivity, bundleInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47541f = npsPluginCenterActivity;
            this.f47540e = bundleInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ToastUtil.show(this.f47540e.getPackageName());
            }
        }
    }

    public NpsPluginCenterActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.tipViewList = new ArrayList();
        this.whiteList = new ArrayList();
    }

    private void initNavigationBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            if (getIntent() != null) {
                this.mFromType = getIntent().getIntExtra("key_from_type", 0);
            }
            NavigationBar navigationBar = (NavigationBar) findViewById(d.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getString(f.plugin_center));
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    private void initScrollContent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.scroll_content);
            this.whiteList.add("com.baidu.searchbox.bjhlivenps");
            this.whiteList.add("com.baidu.live.media.business");
            this.whiteList.add(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME);
            this.whiteList.add("com.baidu.searchbox.yylive.extlib");
            for (BundleInfo bundleInfo : c.e().c()) {
                if (this.whiteList.contains(bundleInfo.getPackageName())) {
                    TbSettingTextTipView makeTipView = makeTipView();
                    makeTipView.setText(bundleInfo.getName());
                    makeTipView.setTip(String.valueOf(bundleInfo.getVersionCode()));
                    this.tipViewList.add(makeTipView);
                    linearLayout.addView(makeTipView);
                    if (TbadkCoreApplication.getInst().isDebugMode()) {
                        makeTipView.setOnClickListener(new a(this, bundleInfo));
                    }
                }
            }
        }
    }

    @NonNull
    private TbSettingTextTipView makeTipView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            TbSettingTextTipView tbSettingTextTipView = new TbSettingTextTipView(this);
            tbSettingTextTipView.hideArrow();
            return tbSettingTextTipView;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.mRootView, c.a.u0.d3.a.CAM_X0204);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            getLayoutMode().j(findViewById(16908290));
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.onChangeSkinType(getPageContext(), i2);
            }
            for (TbSettingTextTipView tbSettingTextTipView : this.tipViewList) {
                tbSettingTextTipView.onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(e.nps_plugin_center_activity);
            initNavigationBar();
            initScrollContent();
        }
    }
}

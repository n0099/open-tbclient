package com.baidu.tieba.pluginCenter;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.searchbox.live.nps.LiveMediaPluginManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.FlutterPluginManager;
import com.baidu.tieba.tl;
import com.baidu.tieba.wallet.WalletPluginManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class NpsPluginCenterActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public NavigationBar b;
    public NoDataView c;
    @NonNull
    public final List<TbSettingTextTipView> d;
    @NonNull
    public final List<String> e;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BundleInfo a;
        public final /* synthetic */ NpsPluginCenterActivity b;

        public a(NpsPluginCenterActivity npsPluginCenterActivity, BundleInfo bundleInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {npsPluginCenterActivity, bundleInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = npsPluginCenterActivity;
            this.a = bundleInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.showToast(this.a.getPackageName());
            }
        }
    }

    public NpsPluginCenterActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new ArrayList();
        this.e = new ArrayList();
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091dcc);
            this.e.add(LiveMediaPluginManager.BJH_PLUGIN_PKG_NAME);
            this.e.add("com.baidu.live.media.business");
            this.e.add("com.baidu.searchbox.livenps");
            this.e.add("com.baidu.searchbox.yylive.extlib");
            this.e.add(WalletPluginManager.PLUGIN_PKG_NAME);
            this.e.add(FlutterPluginManager.PLUGIN_PKG_NAME);
            for (BundleInfo bundleInfo : tl.e().c()) {
                if (this.e.contains(bundleInfo.getPackageName())) {
                    TbSettingTextTipView B1 = B1();
                    B1.setText(bundleInfo.getName());
                    B1.setTip(String.valueOf(bundleInfo.getVersionCode()));
                    this.d.add(B1);
                    linearLayout.addView(B1);
                    if (TbadkCoreApplication.getInst().isDebugMode()) {
                        B1.setOnClickListener(new a(this, bundleInfo));
                    }
                }
            }
        }
    }

    @NonNull
    public final TbSettingTextTipView B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TbSettingTextTipView tbSettingTextTipView = new TbSettingTextTipView(this);
            tbSettingTextTipView.c();
            return tbSettingTextTipView;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0204);
            this.b.onChangeSkinType(getPageContext(), i);
            getLayoutMode().k(findViewById(16908290));
            NoDataView noDataView = this.c;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i);
            }
            for (TbSettingTextTipView tbSettingTextTipView : this.d) {
                tbSettingTextTipView.f(i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0679);
            z1();
            A1();
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (getIntent() != null) {
                getIntent().getIntExtra("key_from_type", 0);
            }
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0925c2);
            this.b = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0eb4));
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }
}

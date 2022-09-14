package com.baidu.tieba.themeCenter.background;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.dt8;
import com.baidu.tieba.is8;
import com.baidu.tieba.kc5;
import com.baidu.tieba.ks8;
import com.baidu.tieba.lx4;
import com.baidu.tieba.themeCenter.background.BackgroundListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class BackgroundListActivity extends BaseActivity<BackgroundListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BackgroundListModel b;
    public ks8 c;
    public is8 d;
    public BackgroundListModel.c e;
    public BdListView.p f;
    public final lx4.g g;

    /* loaded from: classes6.dex */
    public class a implements BackgroundListModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BackgroundListActivity a;

        public a(BackgroundListActivity backgroundListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = backgroundListActivity;
        }

        @Override // com.baidu.tieba.themeCenter.background.BackgroundListModel.c
        public void a(int i, String str, dt8 dt8Var, List<DressItemData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, dt8Var, list}) == null) {
                this.a.c.j();
                BackgroundListActivity backgroundListActivity = this.a;
                backgroundListActivity.hideLoadingView(backgroundListActivity.c.c());
                if (i == 0) {
                    this.a.c.i(dt8Var, list, this.a.b.S());
                    return;
                }
                this.a.showToast(str);
                this.a.c.h();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BackgroundListActivity a;

        public b(BackgroundListActivity backgroundListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = backgroundListActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.z();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements lx4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BackgroundListActivity a;

        public c(BackgroundListActivity backgroundListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = backgroundListActivity;
        }

        @Override // com.baidu.tieba.lx4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.b == null) {
                return;
            }
            this.a.b.loadData();
        }
    }

    public BackgroundListActivity() {
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
        this.e = new a(this);
        this.f = new b(this);
        this.g = new c(this);
    }

    public int B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d.a() : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.hc5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "b008" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public kc5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            kc5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.a = true;
            }
            return pageStayDurationItem;
        }
        return (kc5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            ks8 ks8Var = this.c;
            if (ks8Var != null) {
                ks8Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            this.a = getPageContext();
            BackgroundListModel backgroundListModel = new BackgroundListModel(this);
            this.b = backgroundListModel;
            backgroundListModel.U(this.e);
            is8 is8Var = new is8(this.a, this.b.getUniqueId());
            this.d = is8Var;
            is8Var.c(0);
            ks8 ks8Var = new ks8(this, this.d);
            this.c = ks8Var;
            ks8Var.g(this.f, this.g);
            showLoadingView(this.c.c());
            this.b.loadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            BackgroundListModel backgroundListModel = this.b;
            if (backgroundListModel != null) {
                backgroundListModel.destroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        ks8 ks8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.b == null || (ks8Var = this.c) == null) {
            return;
        }
        showLoadingView(ks8Var.c());
        this.b.loadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
                TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
                showLoadingView(this.c.c());
                this.b.loadData();
            }
        }
    }
}

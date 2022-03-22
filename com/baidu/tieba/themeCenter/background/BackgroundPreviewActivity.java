package com.baidu.tieba.themeCenter.background;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.p0.d;
import c.a.p0.f4.e.j;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tieba.themeCenter.background.BackgroundPreviewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class BackgroundPreviewActivity extends BaseActivity<BackgroundPreviewActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundPreviewModel.b mCallback;
    public int mFrom;
    public int mInUse;
    public BackgroundPreviewModel mModel;
    public int mPropId;
    public j mView;

    /* loaded from: classes6.dex */
    public class a implements BackgroundPreviewModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BackgroundPreviewActivity a;

        public a(BackgroundPreviewActivity backgroundPreviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundPreviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = backgroundPreviewActivity;
        }

        @Override // com.baidu.tieba.themeCenter.background.BackgroundPreviewModel.b
        public void a(int i, String str, DressItemData dressItemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, dressItemData) == null) {
                BackgroundPreviewActivity backgroundPreviewActivity = this.a;
                backgroundPreviewActivity.hideLoadingView(backgroundPreviewActivity.mView.f());
                if (i == 0) {
                    this.a.mView.l(dressItemData);
                    return;
                }
                this.a.showToast(str);
                this.a.mView.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BdExpandListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BackgroundPreviewActivity a;

        public b(BackgroundPreviewActivity backgroundPreviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundPreviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = backgroundPreviewActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdExpandListView.b
        public void a(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            }
        }

        @Override // com.baidu.adp.widget.ListView.BdExpandListView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.adp.widget.ListView.BdExpandListView.b
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    public BackgroundPreviewActivity() {
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
        this.mCallback = new a(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, c.a.o0.p0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "b009" : (String) invokeV.objValue;
    }

    public int getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFrom : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.a = true;
                pageStayDurationItem.i = String.valueOf(this.mPropId);
            }
            return pageStayDurationItem;
        }
        return (d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            j jVar = this.mView;
            if (jVar != null) {
                jVar.g();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
            Intent intent = getIntent();
            if (intent != null) {
                this.mPropId = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.PROPID, 0);
                this.mInUse = intent.getIntExtra(PersonalBackgroundPreviewActivityConfig.INUSE, 0);
                this.mFrom = intent.getIntExtra("from", -1);
            }
            BackgroundPreviewModel backgroundPreviewModel = new BackgroundPreviewModel(this.mPropId, this.mInUse);
            this.mModel = backgroundPreviewModel;
            backgroundPreviewModel.D(this.mCallback);
            j jVar = new j(this);
            this.mView = jVar;
            showLoadingView(jVar.f());
            this.mView.j(new b(this));
            this.mModel.loadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            BackgroundPreviewModel backgroundPreviewModel = this.mModel;
            if (backgroundPreviewModel != null) {
                backgroundPreviewModel.destroy();
            }
            j jVar = this.mView;
            if (jVar != null) {
                jVar.h();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.mModel == null || (jVar = this.mView) == null) {
            return;
        }
        showLoadingView(jVar.f());
        this.mModel.loadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            if (TbadkCoreApplication.getInst().getThemeWebviewOpen()) {
                TbadkCoreApplication.getInst().setThemeWebviewOpen(false);
                showLoadingView(this.mView.f());
                this.mModel.loadData();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            super.onUserChanged(z);
            if (z) {
                c.a.o0.z.b.d().h();
            }
        }
    }
}

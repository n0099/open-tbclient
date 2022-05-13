package com.baidu.tieba.newlist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cq7;
import com.repackage.ro;
import java.util.List;
/* loaded from: classes3.dex */
public class HotTopicListActivity extends BaseActivity<HotTopicListActivity> implements cq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String callFrom;
    public List<ro> curDataList;
    public HotTopicListModel mModel;
    public HotTopicListView mView;

    public HotTopicListActivity() {
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
        this.callFrom = "";
    }

    private void initParamsFromIntent(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.callFrom = intent.getStringExtra(IntentConfig.CALL_FROM);
            } else if (bundle != null) {
                this.callFrom = bundle.getString(IntentConfig.CALL_FROM);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.m85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a078" : (String) invokeV.objValue;
    }

    @Override // com.repackage.cq7
    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean loadData = this.mModel.loadData();
            if (!ListUtils.isEmpty(this.curDataList)) {
                if (loadData) {
                    return;
                }
                this.mView.m();
                this.mView.v();
            } else if (loadData) {
                this.mView.s();
                this.mView.n();
            } else {
                this.mView.m();
                this.mView.t(false);
            }
        }
    }

    @Override // com.repackage.cq7
    public void netCallback(int i, List<ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, list) == null) {
            this.mView.m();
            this.mView.v();
            this.mView.n();
            if (i == 0 && !ListUtils.isEmpty(list)) {
                this.mView.setData(list);
                this.mView.u();
                this.curDataList = list;
            } else if (ListUtils.isEmpty(this.curDataList)) {
                this.mView.t(false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.q();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            initParamsFromIntent(bundle);
            this.mModel = new HotTopicListModel(getPageContext(), this);
            HotTopicListView hotTopicListView = new HotTopicListView(getPageContext(), this, bundle);
            this.mView = hotTopicListView;
            setContentView(hotTopicListView);
            setIsAddSwipeBackLayout(false);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            loadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            TiebaStatic.log(new StatisticItem("c13741").param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }
}

package com.baidu.tieba.newlist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.er7;
import com.repackage.on;
import java.util.List;
/* loaded from: classes3.dex */
public class HotTopicListActivity extends BaseActivity<HotTopicListActivity> implements er7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotTopicListModel a;
    public HotTopicListView b;
    public List<on> c;

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
            }
        }
    }

    @Override // com.repackage.er7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean loadData = this.a.loadData();
            if (!ListUtils.isEmpty(this.c)) {
                if (loadData) {
                    return;
                }
                this.b.m();
                this.b.v();
            } else if (loadData) {
                this.b.s();
                this.b.n();
            } else {
                this.b.m();
                this.b.t(false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.u95
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "a078" : (String) invokeV.objValue;
    }

    @Override // com.repackage.er7
    public void j(int i, List<on> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, list) == null) {
            this.b.m();
            this.b.v();
            this.b.n();
            if (i == 0 && !ListUtils.isEmpty(list)) {
                this.b.setData(list);
                this.b.u();
                this.c = list;
            } else if (ListUtils.isEmpty(this.c)) {
                this.b.t(false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            this.b.q();
            UtilHelper.setNavigationBarBg(this, SkinManager.getColor(R.color.CAM_X0201));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            z1(bundle);
            this.a = new HotTopicListModel(getPageContext(), this);
            HotTopicListView hotTopicListView = new HotTopicListView(getPageContext(), this, bundle);
            this.b = hotTopicListView;
            setContentView(hotTopicListView);
            setIsAddSwipeBackLayout(false);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            a();
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

    public final void z1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                intent.getStringExtra(IntentConfig.CALL_FROM);
            } else if (bundle != null) {
                bundle.getString(IntentConfig.CALL_FROM);
            }
        }
    }
}

package com.baidu.tieba.write.selectForum;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class HotTopicChangeFourmActivity extends BaseActivity<HotTopicChangeFourmActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LIMIT_COUNT = 20;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.c4.o.a mAdapter;
    public List<HotTopicBussinessData> mList;
    public BdListView mListView;
    public NavigationBar mNavigationBar;
    public boolean mUseOriginList;

    /* loaded from: classes7.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicChangeFourmActivity f58797e;

        public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicChangeFourmActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58797e = hotTopicChangeFourmActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, i2);
                intent.putExtra(VideoListActivityConfig.KEY_FORUM_ID, ((HotTopicBussinessData) this.f58797e.mList.get(i2)).getForumId());
                intent.putExtra("KEY_FORUM_NAME", ((HotTopicBussinessData) this.f58797e.mList.get(i2)).getForumName());
                this.f58797e.setResult(-1, intent);
                this.f58797e.finish();
            }
        }
    }

    public HotTopicChangeFourmActivity() {
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
        this.mListView = null;
        this.mUseOriginList = false;
    }

    private void initUi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            SkinManager.setViewTextColor(this.mNavigationBar.setTitleText(TbadkCoreApplication.getInst().getString(R.string.change_fourm)), R.color.CAM_X0106);
            this.mListView = (BdListView) findViewById(R.id.hot_topic_listview);
            this.mAdapter = new c.a.r0.c4.o.a(this);
            if (!this.mUseOriginList) {
                int size = this.mList.size();
                ArrayList arrayList = null;
                for (int i2 = 0; i2 < size; i2++) {
                    HotTopicBussinessData hotTopicBussinessData = this.mList.get(i2);
                    if (hotTopicBussinessData == null || StringUtils.isNull(hotTopicBussinessData.mForumName)) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(hotTopicBussinessData);
                    }
                }
                if (arrayList != null) {
                    this.mList.removeAll(arrayList);
                }
                if (this.mList.size() > 20) {
                    this.mList = this.mList.subList(0, 19);
                }
            }
            this.mAdapter.e(this.mList);
            TextView textView = new TextView(getActivity());
            Resources resources = getResources();
            textView.setHeight(resources.getDimensionPixelSize(R.dimen.ds54));
            textView.setWidth(-1);
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ds5);
            textView.setPadding(resources.getDimensionPixelSize(R.dimen.ds24), dimensionPixelSize, 0, dimensionPixelSize);
            textView.setGravity(16);
            textView.setTextSize(0, resources.getDimensionPixelSize(R.dimen.fontsize24));
            textView.setText(resources.getString(R.string.hot_topic_header_tip));
            this.mListView.addHeaderView(textView);
            SkinManager.setBackgroundResource(textView, R.color.common_color_10238);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0108, 1);
            this.mListView.setAdapter((ListAdapter) this.mAdapter);
            this.mListView.setOnItemClickListener(new a(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.hot_topic_change_view);
            if (getIntent() != null) {
                this.mList = (ArrayList) getIntent().getSerializableExtra("hot_topic_forum_list");
                this.mUseOriginList = getIntent().getBooleanExtra(HotTopicChangeActivityConfig.KEY_USE_ORIGIN_LIST, false);
            }
            if (ListUtils.isEmpty(this.mList)) {
                finish();
            }
            initUi();
        }
    }
}

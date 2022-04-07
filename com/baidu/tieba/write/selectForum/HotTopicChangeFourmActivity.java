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
import com.repackage.vz8;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicChangeFourmActivity extends BaseActivity<HotTopicChangeFourmActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LIMIT_COUNT = 20;
    public transient /* synthetic */ FieldHolder $fh;
    public vz8 mAdapter;
    public List<HotTopicBussinessData> mList;
    public BdListView mListView;
    public NavigationBar mNavigationBar;
    public boolean mUseOriginList;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicChangeFourmActivity a;

        public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicChangeFourmActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicChangeFourmActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, i);
                intent.putExtra(VideoListActivityConfig.KEY_FORUM_ID, ((HotTopicBussinessData) this.a.mList.get(i)).getForumId());
                intent.putExtra("KEY_FORUM_NAME", ((HotTopicBussinessData) this.a.mList.get(i)).getForumName());
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    public HotTopicChangeFourmActivity() {
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
        this.mListView = null;
        this.mUseOriginList = false;
    }

    private void initUi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923ab);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            SkinManager.setViewTextColor(this.mNavigationBar.setTitleText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f038e)), (int) R.color.CAM_X0106);
            this.mListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f090de8);
            this.mAdapter = new vz8(this);
            if (!this.mUseOriginList) {
                int size = this.mList.size();
                ArrayList arrayList = null;
                for (int i = 0; i < size; i++) {
                    HotTopicBussinessData hotTopicBussinessData = this.mList.get(i);
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
            textView.setHeight(resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702dd));
            textView.setWidth(-1);
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702d4);
            textView.setPadding(resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8), dimensionPixelSize, 0, dimensionPixelSize);
            textView.setGravity(16);
            textView.setTextSize(0, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b3));
            textView.setText(resources.getString(R.string.obfuscated_res_0x7f0f086b));
            this.mListView.addHeaderView(textView);
            SkinManager.setBackgroundResource(textView, R.color.common_color_10238);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0108, 1);
            this.mListView.setAdapter((ListAdapter) this.mAdapter);
            this.mListView.setOnItemClickListener(new a(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d03ae);
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

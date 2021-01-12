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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class HotTopicChangeFourmActivity extends BaseActivity<HotTopicChangeFourmActivity> {
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private a nVJ;
    private BdListView WT = null;
    private boolean nVK = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.hot_topic_change_view);
        if (getIntent() != null) {
            this.mList = (ArrayList) getIntent().getSerializableExtra("hot_topic_forum_list");
            this.nVK = getIntent().getBooleanExtra(HotTopicChangeActivityConfig.KEY_USE_ORIGIN_LIST, false);
        }
        if (x.isEmpty(this.mList)) {
            finish();
        }
        cME();
    }

    private void cME() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ao.setViewTextColor(this.mNavigationBar.setTitleText(TbadkCoreApplication.getInst().getString(R.string.change_fourm)), R.color.CAM_X0106);
        this.WT = (BdListView) findViewById(R.id.hot_topic_listview);
        this.nVJ = new a(this);
        if (!this.nVK) {
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
        this.nVJ.setData(this.mList);
        TextView textView = new TextView(getActivity());
        Resources resources = getResources();
        textView.setHeight(resources.getDimensionPixelSize(R.dimen.ds54));
        textView.setWidth(-1);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ds5);
        textView.setPadding(resources.getDimensionPixelSize(R.dimen.ds24), dimensionPixelSize, 0, dimensionPixelSize);
        textView.setGravity(16);
        textView.setTextSize(0, resources.getDimensionPixelSize(R.dimen.fontsize24));
        textView.setText(resources.getString(R.string.hot_topic_header_tip));
        this.WT.addHeaderView(textView);
        ao.setBackgroundResource(textView, R.color.common_color_10238);
        ao.setViewTextColor(textView, R.color.CAM_X0108, 1);
        this.WT.setAdapter((ListAdapter) this.nVJ);
        this.WT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.selectForum.HotTopicChangeFourmActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                Intent intent = new Intent();
                intent.putExtra("hot_topic_change_fourm", i2);
                intent.putExtra(VideoListActivityConfig.KEY_FORUM_ID, ((HotTopicBussinessData) HotTopicChangeFourmActivity.this.mList.get(i2)).getForumId());
                intent.putExtra("KEY_FORUM_NAME", ((HotTopicBussinessData) HotTopicChangeFourmActivity.this.mList.get(i2)).getForumName());
                HotTopicChangeFourmActivity.this.setResult(-1, intent);
                HotTopicChangeFourmActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}

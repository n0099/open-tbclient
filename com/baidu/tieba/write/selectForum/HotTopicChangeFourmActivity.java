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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class HotTopicChangeFourmActivity extends BaseActivity<HotTopicChangeFourmActivity> {
    private a lAy;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private BdListView Ua = null;
    private boolean lAz = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.hot_topic_change_view);
        if (getIntent() != null) {
            this.mList = (ArrayList) getIntent().getSerializableExtra("hot_topic_forum_list");
            this.lAz = getIntent().getBooleanExtra(HotTopicChangeActivityConfig.KEY_USE_ORIGIN_LIST, false);
        }
        if (v.isEmpty(this.mList)) {
            finish();
        }
        bXK();
    }

    private void bXK() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        am.setViewTextColor(this.mNavigationBar.setTitleText(TbadkCoreApplication.getInst().getString(R.string.change_fourm)), (int) R.color.cp_cont_f);
        this.Ua = (BdListView) findViewById(R.id.hot_topic_listview);
        this.lAy = new a(this);
        if (!this.lAz) {
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
        this.lAy.setData(this.mList);
        TextView textView = new TextView(getActivity());
        Resources resources = getResources();
        textView.setHeight(resources.getDimensionPixelSize(R.dimen.ds54));
        textView.setWidth(-1);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ds5);
        textView.setPadding(resources.getDimensionPixelSize(R.dimen.ds24), dimensionPixelSize, 0, dimensionPixelSize);
        textView.setGravity(16);
        textView.setTextSize(0, resources.getDimensionPixelSize(R.dimen.fontsize24));
        textView.setText(resources.getString(R.string.hot_topic_header_tip));
        this.Ua.addHeaderView(textView);
        am.setBackgroundResource(textView, R.color.common_color_10238);
        am.setViewTextColor(textView, R.color.cp_cont_c, 1);
        this.Ua.setAdapter((ListAdapter) this.lAy);
        this.Ua.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.selectForum.HotTopicChangeFourmActivity.1
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

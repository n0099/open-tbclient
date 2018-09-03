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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class HotTopicChangeFourmActivity extends BaseActivity<HotTopicChangeFourmActivity> {
    private a hvW;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private BdListView LO = null;
    private boolean hvX = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.h.hot_topic_change_view);
        if (getIntent() != null) {
            this.mList = (ArrayList) getIntent().getSerializableExtra("hot_topic_forum_list");
            this.hvX = getIntent().getBooleanExtra(HotTopicChangeActivityConfig.KEY_USE_ORIGIN_LIST, false);
        }
        if (w.z(this.mList)) {
            finish();
        }
        aDa();
    }

    private void aDa() {
        this.mNavigationBar = (NavigationBar) findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        am.h(this.mNavigationBar.setTitleText(TbadkCoreApplication.getInst().getString(f.j.change_fourm)), f.d.cp_cont_f);
        this.LO = (BdListView) findViewById(f.g.hot_topic_listview);
        this.hvW = new a(this);
        if (!this.hvX) {
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
        this.hvW.setData(this.mList);
        TextView textView = new TextView(getActivity());
        Resources resources = getResources();
        textView.setHeight(resources.getDimensionPixelSize(f.e.ds54));
        textView.setWidth(-1);
        int dimensionPixelSize = resources.getDimensionPixelSize(f.e.ds5);
        textView.setPadding(resources.getDimensionPixelSize(f.e.ds24), dimensionPixelSize, 0, dimensionPixelSize);
        textView.setGravity(16);
        textView.setTextSize(0, resources.getDimensionPixelSize(f.e.fontsize24));
        textView.setText(resources.getString(f.j.hot_topic_header_tip));
        this.LO.addHeaderView(textView);
        am.i(textView, f.d.common_color_10238);
        am.c(textView, f.d.cp_cont_c, 1);
        this.LO.setAdapter((ListAdapter) this.hvW);
        this.LO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.selectForum.HotTopicChangeFourmActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, i2);
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

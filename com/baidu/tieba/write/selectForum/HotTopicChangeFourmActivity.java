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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class HotTopicChangeFourmActivity extends BaseActivity<HotTopicChangeFourmActivity> {
    private a huO;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private BdListView LS = null;
    private boolean huP = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.hot_topic_change_view);
        if (getIntent() != null) {
            this.mList = (ArrayList) getIntent().getSerializableExtra("hot_topic_forum_list");
            this.huP = getIntent().getBooleanExtra(HotTopicChangeActivityConfig.KEY_USE_ORIGIN_LIST, false);
        }
        if (w.A(this.mList)) {
            finish();
        }
        aCu();
    }

    private void aCu() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        am.h(this.mNavigationBar.setTitleText(TbadkCoreApplication.getInst().getString(d.k.change_fourm)), d.C0142d.cp_cont_f);
        this.LS = (BdListView) findViewById(d.g.hot_topic_listview);
        this.huO = new a(this);
        if (!this.huP) {
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
        this.huO.setData(this.mList);
        TextView textView = new TextView(getActivity());
        Resources resources = getResources();
        textView.setHeight(resources.getDimensionPixelSize(d.e.ds54));
        textView.setWidth(-1);
        int dimensionPixelSize = resources.getDimensionPixelSize(d.e.ds5);
        textView.setPadding(resources.getDimensionPixelSize(d.e.ds24), dimensionPixelSize, 0, dimensionPixelSize);
        textView.setGravity(16);
        textView.setTextSize(0, resources.getDimensionPixelSize(d.e.fontsize24));
        textView.setText(resources.getString(d.k.hot_topic_header_tip));
        this.LS.addHeaderView(textView);
        am.i(textView, d.C0142d.common_color_10238);
        am.c(textView, d.C0142d.cp_cont_c, 1);
        this.LS.setAdapter((ListAdapter) this.huO);
        this.LS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.selectForum.HotTopicChangeFourmActivity.1
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

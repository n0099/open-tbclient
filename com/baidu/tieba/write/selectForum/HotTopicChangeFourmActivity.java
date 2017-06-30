package com.baidu.tieba.write.selectForum;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HotTopicChangeFourmActivity extends BaseActivity<HotTopicChangeFourmActivity> {
    private b ghh;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private BdListView Ib = null;
    private boolean ghi = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.hot_topic_change_view);
        if (getIntent() != null) {
            this.mList = (ArrayList) getIntent().getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.ghi = getIntent().getBooleanExtra(HotTopicChangeActivityConfig.KEY_USE_ORIGIN_LIST, false);
        }
        if (z.t(this.mList)) {
            finish();
        }
        alX();
    }

    private void alX() {
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        as.i(this.mNavigationBar.setTitleText(TbadkCoreApplication.m9getInst().getString(w.l.change_fourm)), w.e.cp_cont_f);
        this.Ib = (BdListView) findViewById(w.h.hot_topic_listview);
        this.ghh = new b(this);
        if (!this.ghi) {
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
        this.ghh.setData(this.mList);
        TextView textView = new TextView(getActivity());
        Resources resources = getResources();
        textView.setHeight(resources.getDimensionPixelSize(w.f.ds54));
        textView.setWidth(-1);
        int dimensionPixelSize = resources.getDimensionPixelSize(w.f.ds5);
        textView.setPadding(resources.getDimensionPixelSize(w.f.ds24), dimensionPixelSize, 0, dimensionPixelSize);
        textView.setGravity(16);
        textView.setTextSize(0, resources.getDimensionPixelSize(w.f.fontsize24));
        textView.setText(resources.getString(w.l.hot_topic_header_tip));
        this.Ib.addHeaderView(textView);
        as.j(textView, w.e.common_color_10238);
        as.c(textView, w.e.cp_cont_c, 1);
        this.Ib.setAdapter((ListAdapter) this.ghh);
        this.Ib.setOnItemClickListener(new a(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}

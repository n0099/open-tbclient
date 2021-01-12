package com.baidu.tieba.newfaceshop.facemake;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectSingleForumActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.BazhuInfoData;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class SelectSingleForumActivity extends BaseActivity<SelectSingleForumActivity> {
    private BdListView WT;
    private View dyW;
    private View eFs;
    private TextView lus;
    private i lut;
    private View luu;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private TextView mTitleView;
    private List<BazhuInfoData.BaInfo> mDataList = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.SelectSingleForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() == SelectSingleForumActivity.this.lus.getId()) {
                    if (SelectSingleForumActivity.this.dgO() != null) {
                        Intent intent = new Intent();
                        intent.putExtra(SelectSingleForumActivityConfig.KEY_OUTPUT_FORUM, SelectSingleForumActivity.this.dgO());
                        SelectSingleForumActivity.this.setResult(-1, intent);
                        SelectSingleForumActivity.this.finish();
                    }
                } else if (view.getId() == SelectSingleForumActivity.this.eFs.getId()) {
                    SelectSingleForumActivity.this.setResult(0);
                    SelectSingleForumActivity.this.finish();
                }
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.SelectSingleForumActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BazhuInfoData.BaInfo baInfo = (BazhuInfoData.BaInfo) SelectSingleForumActivity.this.mDataList.get(i);
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
            if (!checkBox.isChecked()) {
                if (SelectSingleForumActivity.this.dgO() != null && SelectSingleForumActivity.this.dgO().isChecked) {
                    SelectSingleForumActivity.this.dgO().isChecked = false;
                }
                baInfo.isChecked = true;
                checkBox.setChecked(!checkBox.isChecked());
                SelectSingleForumActivity.this.lut.notifyDataSetChanged();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.select_single_forum_activity);
        this.mRootView = findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.eFs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.eFs.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eFs.getLayoutParams();
            layoutParams.leftMargin = l.getDimens(getActivity(), R.dimen.ds10);
            this.eFs.setLayoutParams(layoutParams);
        }
        this.mTitleView = this.mNavigationBar.setCenterTextTitle(getString(R.string.emotion_make_select_bar));
        this.eFs.setOnClickListener(this.mOnClickListener);
        this.dyW = findViewById(R.id.view_divider);
        this.lus = (TextView) findViewById(R.id.transmit_confirm);
        this.lus.setOnClickListener(this.mOnClickListener);
        this.luu = findViewById(R.id.layout_confirm);
        this.WT = (BdListView) findViewById(R.id.trasmit_grid_view);
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST");
            if (x.getCount(parcelableArrayListExtra) > 0) {
                this.mDataList.addAll(parcelableArrayListExtra);
            }
        }
        this.WT.setOnItemClickListener(this.mOnItemClickListener);
        this.lut = new i(getActivity());
        this.WT.setAdapter((ListAdapter) this.lut);
        this.lut.eM(this.mDataList);
        dgN();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void dgN() {
        this.lus.setText(R.string.select_single_forum_confirm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BazhuInfoData.BaInfo dgO() {
        for (BazhuInfoData.BaInfo baInfo : this.mDataList) {
            if (baInfo.isChecked) {
                return baInfo;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        ao.setBackgroundResource(this.lus, R.drawable.btn_all_blue);
        ao.setViewTextColor(this.lus, R.color.CAM_X0111, 1);
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ao.setBackgroundColor(this.dyW, R.color.CAM_X0204);
        this.lut.EQ(i);
        this.WT.setSelector(ao.getDrawable(R.drawable.selector_select_forum_item));
        ao.setBackgroundColor(this.luu, R.color.cp_bg_line_d_alpha95);
    }
}

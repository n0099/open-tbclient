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
/* loaded from: classes9.dex */
public class SelectSingleForumActivity extends BaseActivity<SelectSingleForumActivity> {
    private BdListView WV;
    private View dDI;
    private View eKd;
    private TextView lyY;
    private i lyZ;
    private View lza;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private TextView mTitleView;
    private List<BazhuInfoData.BaInfo> mDataList = new ArrayList();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.SelectSingleForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() == SelectSingleForumActivity.this.lyY.getId()) {
                    if (SelectSingleForumActivity.this.dkG() != null) {
                        Intent intent = new Intent();
                        intent.putExtra(SelectSingleForumActivityConfig.KEY_OUTPUT_FORUM, SelectSingleForumActivity.this.dkG());
                        SelectSingleForumActivity.this.setResult(-1, intent);
                        SelectSingleForumActivity.this.finish();
                    }
                } else if (view.getId() == SelectSingleForumActivity.this.eKd.getId()) {
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
                if (SelectSingleForumActivity.this.dkG() != null && SelectSingleForumActivity.this.dkG().isChecked) {
                    SelectSingleForumActivity.this.dkG().isChecked = false;
                }
                baInfo.isChecked = true;
                checkBox.setChecked(!checkBox.isChecked());
                SelectSingleForumActivity.this.lyZ.notifyDataSetChanged();
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
        this.eKd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.eKd.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eKd.getLayoutParams();
            layoutParams.leftMargin = l.getDimens(getActivity(), R.dimen.ds10);
            this.eKd.setLayoutParams(layoutParams);
        }
        this.mTitleView = this.mNavigationBar.setCenterTextTitle(getString(R.string.emotion_make_select_bar));
        this.eKd.setOnClickListener(this.mOnClickListener);
        this.dDI = findViewById(R.id.view_divider);
        this.lyY = (TextView) findViewById(R.id.transmit_confirm);
        this.lyY.setOnClickListener(this.mOnClickListener);
        this.lza = findViewById(R.id.layout_confirm);
        this.WV = (BdListView) findViewById(R.id.trasmit_grid_view);
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST");
            if (x.getCount(parcelableArrayListExtra) > 0) {
                this.mDataList.addAll(parcelableArrayListExtra);
            }
        }
        this.WV.setOnItemClickListener(this.mOnItemClickListener);
        this.lyZ = new i(getActivity());
        this.WV.setAdapter((ListAdapter) this.lyZ);
        this.lyZ.eM(this.mDataList);
        dkF();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void dkF() {
        this.lyY.setText(R.string.select_single_forum_confirm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BazhuInfoData.BaInfo dkG() {
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
        ao.setBackgroundResource(this.lyY, R.drawable.btn_all_blue);
        ao.setViewTextColor(this.lyY, R.color.CAM_X0111, 1);
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ao.setBackgroundColor(this.dDI, R.color.CAM_X0204);
        this.lyZ.Gw(i);
        this.WV.setSelector(ao.getDrawable(R.drawable.selector_select_forum_item));
        ao.setBackgroundColor(this.lza, R.color.cp_bg_line_d_alpha95);
    }
}

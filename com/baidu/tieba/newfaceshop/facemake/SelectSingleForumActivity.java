package com.baidu.tieba.newfaceshop.facemake;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectSingleForumActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.BazhuInfoData;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.z1.g.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectSingleForumActivity extends BaseActivity<SelectSingleForumActivity> {
    public i mAdapter;
    public View mBackView;
    public View mDivider;
    public View mLayoutConfirm;
    public BdListView mListView;
    public NavigationBar mNavigationBar;
    public View mRootView;
    public TextView mTitleView;
    public TextView mTransmitConfirmButton;
    public List<BazhuInfoData.BaInfo> mDataList = new ArrayList();
    public View.OnClickListener mOnClickListener = new a();
    public AdapterView.OnItemClickListener mOnItemClickListener = new b();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
                return;
            }
            if (view.getId() == SelectSingleForumActivity.this.mTransmitConfirmButton.getId()) {
                if (SelectSingleForumActivity.this.getSelectedData() == null) {
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(SelectSingleForumActivityConfig.KEY_OUTPUT_FORUM, SelectSingleForumActivity.this.getSelectedData());
                SelectSingleForumActivity.this.setResult(-1, intent);
                SelectSingleForumActivity.this.finish();
            } else if (view.getId() == SelectSingleForumActivity.this.mBackView.getId()) {
                SelectSingleForumActivity.this.setResult(0);
                SelectSingleForumActivity.this.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            BazhuInfoData.BaInfo baInfo = (BazhuInfoData.BaInfo) SelectSingleForumActivity.this.mDataList.get(i2);
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
            if (checkBox.isChecked()) {
                return;
            }
            if (SelectSingleForumActivity.this.getSelectedData() != null && SelectSingleForumActivity.this.getSelectedData().isChecked) {
                SelectSingleForumActivity.this.getSelectedData().isChecked = false;
            }
            baInfo.isChecked = true;
            checkBox.setChecked(!checkBox.isChecked());
            SelectSingleForumActivity.this.mAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BazhuInfoData.BaInfo getSelectedData() {
        for (BazhuInfoData.BaInfo baInfo : this.mDataList) {
            if (baInfo.isChecked) {
                return baInfo;
            }
        }
        return null;
    }

    private void setTransmitConfirmButtonText() {
        this.mTransmitConfirmButton.setText(R.string.select_single_forum_confirm);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        SkinManager.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(this.mTransmitConfirmButton, R.drawable.btn_all_blue);
        SkinManager.setViewTextColor(this.mTransmitConfirmButton, R.color.CAM_X0111, 1);
        SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
        this.mAdapter.c(i2);
        this.mListView.setSelector(SkinManager.getDrawable(R.drawable.selector_select_forum_item));
        SkinManager.setBackgroundColor(this.mLayoutConfirm, R.color.cp_bg_line_d_alpha95);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.select_single_forum_activity);
        this.mRootView = findViewById(R.id.root_view);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBackView = addSystemImageButton;
        if (addSystemImageButton.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBackView.getLayoutParams();
            layoutParams.leftMargin = l.g(getActivity(), R.dimen.ds10);
            this.mBackView.setLayoutParams(layoutParams);
        }
        this.mTitleView = this.mNavigationBar.setCenterTextTitle(getString(R.string.emotion_make_select_bar));
        this.mBackView.setOnClickListener(this.mOnClickListener);
        this.mDivider = findViewById(R.id.view_divider);
        TextView textView = (TextView) findViewById(R.id.transmit_confirm);
        this.mTransmitConfirmButton = textView;
        textView.setOnClickListener(this.mOnClickListener);
        this.mLayoutConfirm = findViewById(R.id.layout_confirm);
        this.mListView = (BdListView) findViewById(R.id.trasmit_grid_view);
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST");
            if (ListUtils.getCount(parcelableArrayListExtra) > 0) {
                this.mDataList.addAll(parcelableArrayListExtra);
            }
        }
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        i iVar = new i(getActivity());
        this.mAdapter = iVar;
        this.mListView.setAdapter((ListAdapter) iVar);
        this.mAdapter.b(this.mDataList);
        setTransmitConfirmButtonText();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}

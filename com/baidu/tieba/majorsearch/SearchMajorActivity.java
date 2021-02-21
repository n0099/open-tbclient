package com.baidu.tieba.majorsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.model.SearchMajorModel;
import java.util.List;
/* loaded from: classes8.dex */
public class SearchMajorActivity extends BaseActivity<SearchMajorActivity> implements SearchMajorModel.a {
    private SearchMajorModel lkA;
    private com.baidu.tieba.majorsearch.a.a lkz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lkz = new com.baidu.tieba.majorsearch.a.a(this);
        this.lkA = new SearchMajorModel(getPageContext(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.lkz.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lkz != null) {
            this.lkz.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void aj(List<String> list) {
        if (this.lkz != null && this.lkz.deY() != null) {
            this.lkz.eQ(list);
            hideNetRefreshView(this.lkz.deY().deT());
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void b(ErrorData errorData) {
        if (this.lkz != null && this.lkz.deY() != null) {
            this.lkz.d(errorData);
            getRefreshView().ro(R.drawable.new_pic_emotion_07);
            showNetRefreshViewNoClick(this.lkz.deY().deT(), null);
            getRefreshView().Dk(getString(R.string.search_major_no_data));
        }
    }

    public void Z(Intent intent) {
        setResult(-1, intent);
        finish();
    }
}

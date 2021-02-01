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
    private com.baidu.tieba.majorsearch.a.a lkl;
    private SearchMajorModel lkm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lkl = new com.baidu.tieba.majorsearch.a.a(this);
        this.lkm = new SearchMajorModel(getPageContext(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.lkl.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lkl != null) {
            this.lkl.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void aj(List<String> list) {
        if (this.lkl != null && this.lkl.deR() != null) {
            this.lkl.eQ(list);
            hideNetRefreshView(this.lkl.deR().deM());
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void b(ErrorData errorData) {
        if (this.lkl != null && this.lkl.deR() != null) {
            this.lkl.d(errorData);
            getRefreshView().ro(R.drawable.new_pic_emotion_07);
            showNetRefreshViewNoClick(this.lkl.deR().deM(), null);
            getRefreshView().Dm(getString(R.string.search_major_no_data));
        }
    }

    public void Z(Intent intent) {
        setResult(-1, intent);
        finish();
    }
}

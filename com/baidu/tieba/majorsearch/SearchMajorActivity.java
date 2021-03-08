package com.baidu.tieba.majorsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.model.SearchMajorModel;
import java.util.List;
/* loaded from: classes7.dex */
public class SearchMajorActivity extends BaseActivity<SearchMajorActivity> implements SearchMajorModel.a {
    private com.baidu.tieba.majorsearch.a.a lmB;
    private SearchMajorModel lmC;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lmB = new com.baidu.tieba.majorsearch.a.a(this);
        this.lmC = new SearchMajorModel(getPageContext(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.lmB.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lmB != null) {
            this.lmB.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void aj(List<String> list) {
        if (this.lmB != null && this.lmB.dfh() != null) {
            this.lmB.eQ(list);
            hideNetRefreshView(this.lmB.dfh().dfc());
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void b(ErrorData errorData) {
        if (this.lmB != null && this.lmB.dfh() != null) {
            this.lmB.d(errorData);
            getRefreshView().rp(R.drawable.new_pic_emotion_07);
            showNetRefreshViewNoClick(this.lmB.dfh().dfc(), null);
            getRefreshView().Dr(getString(R.string.search_major_no_data));
        }
    }

    public void Z(Intent intent) {
        setResult(-1, intent);
        finish();
    }
}

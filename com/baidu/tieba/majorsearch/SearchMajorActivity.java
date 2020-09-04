package com.baidu.tieba.majorsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.model.SearchMajorModel;
import java.util.List;
/* loaded from: classes18.dex */
public class SearchMajorActivity extends BaseActivity<SearchMajorActivity> implements SearchMajorModel.a {
    private com.baidu.tieba.majorsearch.b.a jXu;
    private SearchMajorModel jXv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jXu = new com.baidu.tieba.majorsearch.b.a(this);
        this.jXv = new SearchMajorModel(getPageContext(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jXu.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jXu != null) {
            this.jXu.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void bd(List<String> list) {
        if (this.jXu != null && this.jXu.cPn() != null) {
            this.jXu.ef(list);
            hideNetRefreshView(this.jXu.cPn().cPi());
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void b(ErrorData errorData) {
        if (this.jXu != null && this.jXu.cPn() != null) {
            this.jXu.d(errorData);
            getRefreshView().qu(R.drawable.new_pic_emotion_07);
            showNetRefreshViewNoClick(this.jXu.cPn().cPi(), null);
            getRefreshView().Co(getString(R.string.search_major_no_data));
        }
    }

    public void ad(Intent intent) {
        setResult(-1, intent);
        finish();
    }
}

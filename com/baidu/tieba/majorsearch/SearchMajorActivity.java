package com.baidu.tieba.majorsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.model.SearchMajorModel;
import java.util.List;
/* loaded from: classes24.dex */
public class SearchMajorActivity extends BaseActivity<SearchMajorActivity> implements SearchMajorModel.a {
    private com.baidu.tieba.majorsearch.b.a kHH;
    private SearchMajorModel kHI;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kHH = new com.baidu.tieba.majorsearch.b.a(this);
        this.kHI = new SearchMajorModel(getPageContext(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kHH.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kHH != null) {
            this.kHH.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void aa(List<String> list) {
        if (this.kHH != null && this.kHH.cZK() != null) {
            this.kHH.ez(list);
            hideNetRefreshView(this.kHH.cZK().cZF());
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void b(ErrorData errorData) {
        if (this.kHH != null && this.kHH.cZK() != null) {
            this.kHH.d(errorData);
            getRefreshView().ru(R.drawable.new_pic_emotion_07);
            showNetRefreshViewNoClick(this.kHH.cZK().cZF(), null);
            getRefreshView().DP(getString(R.string.search_major_no_data));
        }
    }

    public void aa(Intent intent) {
        setResult(-1, intent);
        finish();
    }
}

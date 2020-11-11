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
    private com.baidu.tieba.majorsearch.b.a kND;
    private SearchMajorModel kNE;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kND = new com.baidu.tieba.majorsearch.b.a(this);
        this.kNE = new SearchMajorModel(getPageContext(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kND.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kND != null) {
            this.kND.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void af(List<String> list) {
        if (this.kND != null && this.kND.dcm() != null) {
            this.kND.eH(list);
            hideNetRefreshView(this.kND.dcm().dch());
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void b(ErrorData errorData) {
        if (this.kND != null && this.kND.dcm() != null) {
            this.kND.d(errorData);
            getRefreshView().rE(R.drawable.new_pic_emotion_07);
            showNetRefreshViewNoClick(this.kND.dcm().dch(), null);
            getRefreshView().Ed(getString(R.string.search_major_no_data));
        }
    }

    public void aa(Intent intent) {
        setResult(-1, intent);
        finish();
    }
}

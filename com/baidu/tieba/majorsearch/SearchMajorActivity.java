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
    private com.baidu.tieba.majorsearch.b.a lbi;
    private SearchMajorModel lbj;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lbi = new com.baidu.tieba.majorsearch.b.a(this);
        this.lbj = new SearchMajorModel(getPageContext(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.lbi.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lbi != null) {
            this.lbi.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void ah(List<String> list) {
        if (this.lbi != null && this.lbi.dgV() != null) {
            this.lbi.eS(list);
            hideNetRefreshView(this.lbi.dgV().dgQ());
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void b(ErrorData errorData) {
        if (this.lbi != null && this.lbi.dgV() != null) {
            this.lbi.d(errorData);
            getRefreshView().sD(R.drawable.new_pic_emotion_07);
            showNetRefreshViewNoClick(this.lbi.dgV().dgQ(), null);
            getRefreshView().Ek(getString(R.string.search_major_no_data));
        }
    }

    public void aa(Intent intent) {
        setResult(-1, intent);
        finish();
    }
}

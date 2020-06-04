package com.baidu.tieba.majorsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.model.SearchMajorModel;
import java.util.List;
/* loaded from: classes11.dex */
public class SearchMajorActivity extends BaseActivity<SearchMajorActivity> implements SearchMajorModel.a {
    private com.baidu.tieba.majorsearch.b.a jii;
    private SearchMajorModel jij;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jii = new com.baidu.tieba.majorsearch.b.a(this);
        this.jij = new SearchMajorModel(getPageContext(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jii.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jii != null) {
            this.jii.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void aN(List<String> list) {
        if (this.jii != null && this.jii.cwG() != null) {
            this.jii.dC(list);
            hideNetRefreshView(this.jii.cwG().cwB());
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void b(ErrorData errorData) {
        if (this.jii != null && this.jii.cwG() != null) {
            this.jii.d(errorData);
            getRefreshView().nw(R.drawable.new_pic_emotion_07);
            showNetRefreshViewNoClick(this.jii.cwG().cwB(), null);
            getRefreshView().yx(getString(R.string.search_major_no_data));
        }
    }

    public void aa(Intent intent) {
        setResult(-1, intent);
        finish();
    }
}

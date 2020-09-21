package com.baidu.tieba.majorsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.model.SearchMajorModel;
import java.util.List;
/* loaded from: classes23.dex */
public class SearchMajorActivity extends BaseActivity<SearchMajorActivity> implements SearchMajorModel.a {
    private com.baidu.tieba.majorsearch.b.a kfX;
    private SearchMajorModel kfY;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kfX = new com.baidu.tieba.majorsearch.b.a(this);
        this.kfY = new SearchMajorModel(getPageContext(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kfX.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kfX != null) {
            this.kfX.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void bh(List<String> list) {
        if (this.kfX != null && this.kfX.cSS() != null) {
            this.kfX.en(list);
            hideNetRefreshView(this.kfX.cSS().cSN());
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void b(ErrorData errorData) {
        if (this.kfX != null && this.kfX.cSS() != null) {
            this.kfX.d(errorData);
            getRefreshView().qL(R.drawable.new_pic_emotion_07);
            showNetRefreshViewNoClick(this.kfX.cSS().cSN(), null);
            getRefreshView().CK(getString(R.string.search_major_no_data));
        }
    }

    public void ac(Intent intent) {
        setResult(-1, intent);
        finish();
    }
}

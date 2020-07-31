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
    private com.baidu.tieba.majorsearch.b.a jHU;
    private SearchMajorModel jHV;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jHU = new com.baidu.tieba.majorsearch.b.a(this);
        this.jHV = new SearchMajorModel(getPageContext(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jHU.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jHU != null) {
            this.jHU.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void bd(List<String> list) {
        if (this.jHU != null && this.jHU.cEv() != null) {
            this.jHU.dX(list);
            hideNetRefreshView(this.jHU.cEv().cEq());
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void b(ErrorData errorData) {
        if (this.jHU != null && this.jHU.cEv() != null) {
            this.jHU.d(errorData);
            getRefreshView().oj(R.drawable.new_pic_emotion_07);
            showNetRefreshViewNoClick(this.jHU.cEv().cEq(), null);
            getRefreshView().zX(getString(R.string.search_major_no_data));
        }
    }

    public void ab(Intent intent) {
        setResult(-1, intent);
        finish();
    }
}

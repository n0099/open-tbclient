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
    private com.baidu.tieba.majorsearch.a.a lch;
    private SearchMajorModel lci;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lch = new com.baidu.tieba.majorsearch.a.a(this);
        this.lci = new SearchMajorModel(getPageContext(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.lch.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lch != null) {
            this.lch.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void ai(List<String> list) {
        if (this.lch != null && this.lch.dcR() != null) {
            this.lch.eS(list);
            hideNetRefreshView(this.lch.dcR().dcM());
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void b(ErrorData errorData) {
        if (this.lch != null && this.lch.dcR() != null) {
            this.lch.d(errorData);
            getRefreshView().rj(R.drawable.new_pic_emotion_07);
            showNetRefreshViewNoClick(this.lch.dcR().dcM(), null);
            getRefreshView().CV(getString(R.string.search_major_no_data));
        }
    }

    public void Z(Intent intent) {
        setResult(-1, intent);
        finish();
    }
}

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
    private com.baidu.tieba.majorsearch.a.a lgO;
    private SearchMajorModel lgP;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lgO = new com.baidu.tieba.majorsearch.a.a(this);
        this.lgP = new SearchMajorModel(getPageContext(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.lgO.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lgO != null) {
            this.lgO.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void ai(List<String> list) {
        if (this.lgO != null && this.lgO.dgI() != null) {
            this.lgO.eS(list);
            hideNetRefreshView(this.lgO.dgI().dgD());
        }
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.a
    public void b(ErrorData errorData) {
        if (this.lgO != null && this.lgO.dgI() != null) {
            this.lgO.d(errorData);
            getRefreshView().sP(R.drawable.new_pic_emotion_07);
            showNetRefreshViewNoClick(this.lgO.dgI().dgD(), null);
            getRefreshView().Eh(getString(R.string.search_major_no_data));
        }
    }

    public void Z(Intent intent) {
        setResult(-1, intent);
        finish();
    }
}

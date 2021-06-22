package com.baidu.tieba.majorsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.model.SearchMajorModel;
import d.a.o0.q1.b.a;
import java.util.List;
/* loaded from: classes3.dex */
public class SearchMajorActivity extends BaseActivity<SearchMajorActivity> implements SearchMajorModel.b {
    public a mController;
    public SearchMajorModel mModel;

    public void finish(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        a aVar = this.mController;
        if (aVar != null) {
            aVar.i(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController = new a(this);
        this.mModel = new SearchMajorModel(getPageContext(), this);
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.b
    public void onError(ErrorData errorData) {
        a aVar = this.mController;
        if (aVar == null || aVar.g() == null) {
            return;
        }
        this.mController.m(errorData);
        getRefreshView().h(R.drawable.new_pic_emotion_07);
        showNetRefreshViewNoClick(this.mController.g().d(), null);
        getRefreshView().n(getString(R.string.search_major_no_data));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mController.j();
    }

    @Override // com.baidu.tieba.majorsearch.model.SearchMajorModel.b
    public void onSuccess(List<String> list) {
        a aVar = this.mController;
        if (aVar == null || aVar.g() == null) {
            return;
        }
        this.mController.l(list);
        hideNetRefreshView(this.mController.g().d());
    }
}

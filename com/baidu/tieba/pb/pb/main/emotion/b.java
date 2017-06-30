package com.baidu.tieba.pb.pb.main.emotion;

import android.app.Activity;
import android.widget.EditText;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.pb.pb.main.emotion.model.SearchEmotionModel;
import java.util.List;
/* loaded from: classes.dex */
class b implements SearchEmotionModel.a {
    final /* synthetic */ PbSearchEmotionActivity eET;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbSearchEmotionActivity pbSearchEmotionActivity) {
        this.eET = pbSearchEmotionActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.SearchEmotionModel.a
    public void a(com.baidu.tieba.pb.pb.main.emotion.data.a aVar) {
        int i;
        int i2;
        List list;
        l lVar;
        l lVar2;
        Activity activity;
        EditText editText;
        List list2;
        l lVar3;
        a aVar2;
        BdListView bdListView;
        l lVar4;
        List list3;
        this.eET.hideProgressBar();
        if (aVar == null || aVar.aRm() == null || aVar.aRm().isEmpty()) {
            i = this.eET.mCurrentPage;
            if (i != 0) {
                return;
            }
            this.eET.aRk();
            return;
        }
        this.eET.mCurrentPage = aVar.getPage();
        i2 = this.eET.mCurrentPage;
        if (i2 == 1) {
            list3 = this.eET.eER;
            list3.clear();
        }
        this.eET.mHasMore = aVar.alz() != 0;
        list = this.eET.eER;
        list.addAll(aVar.aRm());
        lVar = this.eET.eEN;
        if (lVar != null) {
            lVar2 = this.eET.eEN;
            lVar2.notifyDataSetChanged();
        } else {
            PbSearchEmotionActivity pbSearchEmotionActivity = this.eET;
            list2 = this.eET.eER;
            pbSearchEmotionActivity.eEN = new l(list2);
            lVar3 = this.eET.eEN;
            aVar2 = this.eET.evB;
            lVar3.a(aVar2);
            bdListView = this.eET.eEM;
            lVar4 = this.eET.eEN;
            bdListView.setAdapter((ListAdapter) lVar4);
        }
        this.eET.aRj();
        activity = this.eET.mActivity;
        editText = this.eET.dLj;
        com.baidu.adp.lib.util.k.b(activity, editText);
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.SearchEmotionModel.a
    public void onFail(int i, String str) {
        int i2;
        this.eET.hideProgressBar();
        i2 = this.eET.mCurrentPage;
        if (i2 != 1) {
            return;
        }
        this.eET.aRk();
    }
}

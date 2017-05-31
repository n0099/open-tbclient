package com.baidu.tieba.pb.pb.main.emotion;

import android.app.Activity;
import android.widget.EditText;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.pb.pb.main.emotion.model.SearchEmotionModel;
import java.util.List;
/* loaded from: classes.dex */
class b implements SearchEmotionModel.a {
    final /* synthetic */ PbSearchEmotionActivity evD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbSearchEmotionActivity pbSearchEmotionActivity) {
        this.evD = pbSearchEmotionActivity;
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
        this.evD.hideProgressBar();
        if (aVar == null || aVar.aNn() == null || aVar.aNn().isEmpty()) {
            i = this.evD.mCurrentPage;
            if (i != 0) {
                return;
            }
            this.evD.aNl();
            return;
        }
        this.evD.mCurrentPage = aVar.getPage();
        i2 = this.evD.mCurrentPage;
        if (i2 == 1) {
            list3 = this.evD.evB;
            list3.clear();
        }
        this.evD.mHasMore = aVar.ahP() != 0;
        list = this.evD.evB;
        list.addAll(aVar.aNn());
        lVar = this.evD.evx;
        if (lVar != null) {
            lVar2 = this.evD.evx;
            lVar2.notifyDataSetChanged();
        } else {
            PbSearchEmotionActivity pbSearchEmotionActivity = this.evD;
            list2 = this.evD.evB;
            pbSearchEmotionActivity.evx = new l(list2);
            lVar3 = this.evD.evx;
            aVar2 = this.evD.emx;
            lVar3.a(aVar2);
            bdListView = this.evD.evw;
            lVar4 = this.evD.evx;
            bdListView.setAdapter((ListAdapter) lVar4);
        }
        this.evD.aNk();
        activity = this.evD.mActivity;
        editText = this.evD.dCP;
        com.baidu.adp.lib.util.k.b(activity, editText);
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.SearchEmotionModel.a
    public void onFail(int i, String str) {
        int i2;
        this.evD.hideProgressBar();
        i2 = this.evD.mCurrentPage;
        if (i2 != 1) {
            return;
        }
        this.evD.aNl();
    }
}

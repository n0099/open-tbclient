package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements PbFakeFloorModel.a {
    final /* synthetic */ NewSubPbActivity eye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NewSubPbActivity newSubPbActivity) {
        this.eye = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
    public void j(PostData postData) {
        ao aoVar;
        ao aoVar2;
        aoVar = this.eye.exP;
        aoVar.l(postData);
        aoVar2 = this.eye.exP;
        aoVar2.a((BdListView.e) null);
    }
}

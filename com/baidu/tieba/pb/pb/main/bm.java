package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbFloorAgreeModel;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements PbFloorAgreeModel.a {
    final /* synthetic */ PbActivity ewh;
    private final /* synthetic */ int ewm;
    private final /* synthetic */ View val$v;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PbActivity pbActivity, int i, View view) {
        this.ewh = pbActivity;
        this.ewm = i;
        this.val$v = view;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
    public void oK(int i) {
        if (i > 0 && this.ewm == 0) {
            ((PbFloorAgreeView) this.val$v).ph(i);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
    public void oN(String str) {
        com.baidu.tieba.pb.d.a(this.ewh.getPageContext(), str);
    }
}

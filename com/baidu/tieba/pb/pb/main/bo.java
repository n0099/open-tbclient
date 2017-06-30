package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbFloorAgreeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements PbFloorAgreeModel.a {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
    public void oK(int i) {
    }

    @Override // com.baidu.tieba.pb.pb.main.PbFloorAgreeModel.a
    public void oN(String str) {
        com.baidu.tieba.pb.d.a(this.ewh.getPageContext(), str);
    }
}

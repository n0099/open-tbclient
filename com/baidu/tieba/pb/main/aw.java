package com.baidu.tieba.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.h bvD;
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.h hVar) {
        this.bvu = pbActivity;
        this.bvD = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.an(this.bvD.Na);
        com.baidu.adp.lib.util.m.showToast(view.getContext(), view.getResources().getString(com.baidu.tieba.y.copy_pb_url_success));
    }
}

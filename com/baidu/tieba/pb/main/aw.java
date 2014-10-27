package com.baidu.tieba.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ PbActivity bvg;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.h bvp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.h hVar) {
        this.bvg = pbActivity;
        this.bvp = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.an(this.bvp.MW);
        com.baidu.adp.lib.util.m.showToast(view.getContext(), view.getResources().getString(com.baidu.tieba.y.copy_pb_url_success));
    }
}

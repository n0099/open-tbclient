package com.baidu.tieba.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ PbActivity a;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.h hVar) {
        this.a = pbActivity;
        this.b = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.a(this.b.c);
        com.baidu.adp.lib.util.j.a(view.getContext(), view.getResources().getString(com.baidu.tieba.y.copy_pb_url_success));
    }
}

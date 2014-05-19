package com.baidu.tieba.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ PbActivity a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity, String str) {
        this.a = pbActivity;
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.a(this.b);
        com.baidu.adp.lib.util.h.a(view.getContext(), view.getResources().getString(com.baidu.tieba.u.copy_pb_url_success));
    }
}

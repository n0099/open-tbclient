package com.baidu.tieba.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ap implements View.OnClickListener {
    final /* synthetic */ PbActivity a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PbActivity pbActivity, String str) {
        this.a = pbActivity;
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.adp.lib.util.a.a(this.b);
        com.baidu.adp.lib.util.i.a(view.getContext(), view.getResources().getString(com.baidu.tieba.a.k.copy_pb_url_success));
    }
}

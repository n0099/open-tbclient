package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.pb.SubPbActivity;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ ai a;
    private final /* synthetic */ com.baidu.tieba.b.m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar, com.baidu.tieba.b.m mVar) {
        this.a = aiVar;
        this.b = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.a() == 2) {
            PbActivity.a(this.a.a, this.b.g(), "");
        } else if (this.b.i()) {
            SubPbActivity.a(this.a.a, this.b.g(), this.b.h(), true);
        } else {
            PbActivity.a(this.a.a, this.b.g(), this.b.h(), "");
        }
    }
}

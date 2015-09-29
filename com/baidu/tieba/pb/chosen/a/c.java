package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.d;
import tbclient.Post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b cfn;
    private final /* synthetic */ Post cfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Post post) {
        this.cfn = bVar;
        this.cfo = post;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a aVar;
        d.a aVar2;
        if (this.cfo != null && this.cfo.id != null) {
            aVar = this.cfn.ceS;
            if (aVar != null) {
                aVar2 = this.cfn.ceS;
                aVar2.jC(String.valueOf(this.cfo.id));
            }
        }
    }
}

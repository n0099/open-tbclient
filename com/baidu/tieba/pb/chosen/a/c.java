package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.d;
import tbclient.Post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b cCi;
    private final /* synthetic */ Post cCj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Post post) {
        this.cCi = bVar;
        this.cCj = post;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a aVar;
        d.a aVar2;
        if (this.cCj != null && this.cCj.id != null) {
            aVar = this.cCi.cBM;
            if (aVar != null) {
                aVar2 = this.cCi.cBM;
                aVar2.kr(String.valueOf(this.cCj.id));
            }
        }
    }
}

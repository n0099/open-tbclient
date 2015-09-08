package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.d;
import tbclient.Post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b cai;
    private final /* synthetic */ Post caj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Post post) {
        this.cai = bVar;
        this.caj = post;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a aVar;
        d.a aVar2;
        if (this.caj != null && this.caj.id != null) {
            aVar = this.cai.bZK;
            if (aVar != null) {
                aVar2 = this.cai.bZK;
                aVar2.jk(String.valueOf(this.caj.id));
            }
        }
    }
}

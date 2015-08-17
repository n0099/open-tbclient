package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.d;
import tbclient.Post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b bZo;
    private final /* synthetic */ Post bZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Post post) {
        this.bZo = bVar;
        this.bZp = post;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a aVar;
        d.a aVar2;
        if (this.bZp != null && this.bZp.id != null) {
            aVar = this.bZo.bYQ;
            if (aVar != null) {
                aVar2 = this.bZo.bYQ;
                aVar2.jc(String.valueOf(this.bZp.id));
            }
        }
    }
}

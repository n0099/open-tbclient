package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.d;
import tbclient.Post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b cfZ;
    private final /* synthetic */ Post cga;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Post post) {
        this.cfZ = bVar;
        this.cga = post;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a aVar;
        d.a aVar2;
        if (this.cga != null && this.cga.id != null) {
            aVar = this.cfZ.cfE;
            if (aVar != null) {
                aVar2 = this.cfZ.cfE;
                aVar2.jE(String.valueOf(this.cga.id));
            }
        }
    }
}

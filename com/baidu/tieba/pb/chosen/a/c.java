package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.d;
import tbclient.Post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b cIN;
    private final /* synthetic */ Post cIO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Post post) {
        this.cIN = bVar;
        this.cIO = post;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a aVar;
        d.a aVar2;
        if (this.cIO != null && this.cIO.id != null) {
            aVar = this.cIN.cIs;
            if (aVar != null) {
                aVar2 = this.cIN.cIs;
                aVar2.ku(String.valueOf(this.cIO.id));
            }
        }
    }
}

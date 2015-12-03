package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.d;
import tbclient.Post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b cyB;
    private final /* synthetic */ Post cyC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Post post) {
        this.cyB = bVar;
        this.cyC = post;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a aVar;
        d.a aVar2;
        if (this.cyC != null && this.cyC.id != null) {
            aVar = this.cyB.cyf;
            if (aVar != null) {
                aVar2 = this.cyB.cyf;
                aVar2.ku(String.valueOf(this.cyC.id));
            }
        }
    }
}

package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.d;
import tbclient.Post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b cfy;
    private final /* synthetic */ Post cfz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Post post) {
        this.cfy = bVar;
        this.cfz = post;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a aVar;
        d.a aVar2;
        if (this.cfz != null && this.cfz.id != null) {
            aVar = this.cfy.cfd;
            if (aVar != null) {
                aVar2 = this.cfy.cfd;
                aVar2.jC(String.valueOf(this.cfz.id));
            }
        }
    }
}

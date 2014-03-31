package com.baidu.tieba.person.post;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.b.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l implements c {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.a = jVar;
    }

    @Override // com.baidu.tieba.person.post.c
    public final void a(View view) {
        String[] strArr;
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        int id = view.getId();
        if (id == com.baidu.tieba.a.h.portrait) {
            activity4 = this.a.e;
            activity4.finish();
        } else if (id == com.baidu.tieba.a.h.username) {
            activity3 = this.a.e;
            activity3.finish();
        } else if ((id == com.baidu.tieba.a.h.item_header || id == com.baidu.tieba.a.h.original_post_title) && (strArr = (String[]) view.getTag()) != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
                activity = this.a.e;
                a.a(new com.baidu.adp.framework.message.a(2004001, new af(activity).a(strArr[0], strArr[1], "person_post_reply")));
                return;
            }
            com.baidu.adp.framework.c a2 = com.baidu.adp.framework.c.a();
            activity2 = this.a.e;
            a2.a(new com.baidu.adp.framework.message.a(2004001, new af(activity2).b(strArr[0], strArr[1], "person_post_reply")));
        }
    }
}

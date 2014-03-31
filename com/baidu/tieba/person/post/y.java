package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.b.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y implements View.OnClickListener {
    final /* synthetic */ ReplyLinearLayout a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ReplyLinearLayout replyLinearLayout) {
        this.a = replyLinearLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String[] strArr = (String[]) view.getTag();
        if (strArr != null) {
            Context context = this.a.getContext();
            if ("0".equals(strArr[3])) {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2004001, new af(context).a(strArr[1], strArr[2], "person_post_reply")));
            } else {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2004001, new af(context).b(strArr[1], strArr[2], "person_post_reply")));
            }
        }
    }
}

package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ ReplyLinearLayout a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(ReplyLinearLayout replyLinearLayout) {
        this.a = replyLinearLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr = (String[]) view.getTag();
        if (strArr != null) {
            Context context = this.a.getContext();
            if ("0".equals(strArr[3])) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2006001, new ar(context).a(strArr[1], strArr[2], "person_post_reply")));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2006001, new ar(context).b(strArr[1], strArr[2], "person_post_reply")));
            }
        }
    }
}

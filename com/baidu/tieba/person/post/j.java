package com.baidu.tieba.person.post;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements b {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.a = hVar;
    }

    @Override // com.baidu.tieba.person.post.b
    public void a(View view) {
        String[] strArr;
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        int id = view.getId();
        if (id == com.baidu.tieba.u.portrait) {
            activity4 = this.a.e;
            activity4.finish();
        } else if (id == com.baidu.tieba.u.username) {
            activity3 = this.a.e;
            activity3.finish();
        } else if ((id == com.baidu.tieba.u.item_header || id == com.baidu.tieba.u.original_post_title || id == com.baidu.tieba.u.item_footer) && (strArr = (String[]) view.getTag()) != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                MessageManager messageManager = MessageManager.getInstance();
                activity = this.a.e;
                messageManager.sendMessage(new CustomMessage(2004001, new bc(activity).a(strArr[0], strArr[1], "person_post_reply")));
                return;
            }
            MessageManager messageManager2 = MessageManager.getInstance();
            activity2 = this.a.e;
            messageManager2.sendMessage(new CustomMessage(2004001, new bc(activity2).b(strArr[0], strArr[1], "person_post_reply")));
        }
    }
}

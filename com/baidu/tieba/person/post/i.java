package com.baidu.tieba.person.post;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements c {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.a = gVar;
    }

    @Override // com.baidu.tieba.person.post.c
    public void a(View view) {
        String[] strArr;
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        int id = view.getId();
        if (id == com.baidu.tieba.v.portrait) {
            activity4 = this.a.e;
            activity4.finish();
        } else if (id == com.baidu.tieba.v.username) {
            activity3 = this.a.e;
            activity3.finish();
        } else if ((id == com.baidu.tieba.v.item_header || id == com.baidu.tieba.v.original_post_title || id == com.baidu.tieba.v.item_footer) && (strArr = (String[]) view.getTag()) != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                MessageManager messageManager = MessageManager.getInstance();
                activity = this.a.e;
                messageManager.sendMessage(new CustomMessage(2006001, new as(activity).a(strArr[0], strArr[1], "person_post_reply")));
                return;
            }
            MessageManager messageManager2 = MessageManager.getInstance();
            activity2 = this.a.e;
            messageManager2.sendMessage(new CustomMessage(2006001, new as(activity2).b(strArr[0], strArr[1], "person_post_reply")));
        }
    }
}

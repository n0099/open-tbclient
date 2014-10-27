package com.baidu.tieba.person.post;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements b {
    final /* synthetic */ h bDE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.bDE = hVar;
    }

    @Override // com.baidu.tieba.person.post.b
    public void X(View view) {
        String[] strArr;
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        int id = view.getId();
        if (id == com.baidu.tieba.v.portrait) {
            activity4 = this.bDE.mActivity;
            activity4.finish();
        } else if (id == com.baidu.tieba.v.username) {
            activity3 = this.bDE.mActivity;
            activity3.finish();
        } else if ((id == com.baidu.tieba.v.item_header || id == com.baidu.tieba.v.original_post_title || id == com.baidu.tieba.v.item_footer) && (strArr = (String[]) view.getTag()) != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                MessageManager messageManager = MessageManager.getInstance();
                activity = this.bDE.mActivity;
                messageManager.sendMessage(new CustomMessage(2004001, new PbActivityConfig(activity).createNormalCfg(strArr[0], strArr[1], "person_post_reply")));
                return;
            }
            MessageManager messageManager2 = MessageManager.getInstance();
            activity2 = this.bDE.mActivity;
            messageManager2.sendMessage(new CustomMessage(2004001, new PbActivityConfig(activity2).createSubPbCfg(strArr[0], strArr[1], "person_post_reply")));
        }
    }
}

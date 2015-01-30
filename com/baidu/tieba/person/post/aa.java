package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ ReplyLinearLayout bJH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ReplyLinearLayout replyLinearLayout) {
        this.bJH = replyLinearLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr = (String[]) view.getTag();
        if (strArr != null) {
            Context context = this.bJH.getContext();
            if ("0".equals(strArr[3])) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(context).createNormalCfg(strArr[1], strArr[2], "person_post_reply")));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(context).createSubPbCfg(strArr[1], strArr[2], "person_post_reply")));
            }
        }
    }
}

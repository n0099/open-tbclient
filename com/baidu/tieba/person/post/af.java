package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ ReplyLinearLayout dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ReplyLinearLayout replyLinearLayout) {
        this.dht = replyLinearLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        String[] strArr = (String[]) view.getTag();
        if (strArr != null) {
            Context context = this.dht.getContext();
            if (strArr.length < 6 || strArr[5] == null || com.baidu.adp.lib.h.b.g(strArr[5], 0) != 33) {
                z = false;
            } else if ("0".equals(strArr[3])) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(context, strArr[1]).rC()));
                z = true;
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(context).createPhotoLiveCommentActivityConfig(strArr[1], strArr[2], false)));
                z = true;
            }
            if (!z) {
                if ("0".equals(strArr[3])) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(context).createNormalCfg(strArr[1], strArr[2], "person_post_reply")));
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(context).createSubPbActivityConfig(strArr[1], strArr[2], "person_post_reply", false, null, false)));
            }
        }
    }
}

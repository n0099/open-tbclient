package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ ReplyLinearLayout eRu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ReplyLinearLayout replyLinearLayout) {
        this.eRu = replyLinearLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        String[] strArr = (String[]) view.getTag();
        au auVar = new au("c12043");
        z = this.eRu.bhl;
        TiebaStatic.log(auVar.r("obj_type", z ? 1 : 2));
        if (strArr != null) {
            Context context = this.eRu.getContext();
            if (strArr.length < 6 || strArr[5] == null || b.g(strArr[5], 0) != 33) {
                z2 = false;
            } else if ("0".equals(strArr[3])) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(context, strArr[1]).pa()));
                z2 = true;
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(context).createPhotoLiveCommentActivityConfig(strArr[1], strArr[2], false)));
                z2 = true;
            }
            if (!z2) {
                if ("0".equals(strArr[3])) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(context).createNormalCfg(strArr[1], strArr[2], "person_post_reply")));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(context).createSubPbActivityConfig(strArr[1], strArr[2], "person_post_reply", false, null, false)));
                }
            }
        }
    }
}

package com.baidu.tieba.person.post;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
import com.baidu.tieba.person.post.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0082a {
    final /* synthetic */ g cQK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.cQK = gVar;
    }

    @Override // com.baidu.tieba.person.post.a.InterfaceC0082a
    public void am(View view) {
        String[] strArr;
        boolean z;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        TbPageContext tbPageContext5;
        TbPageContext tbPageContext6;
        int id = view.getId();
        if (id == n.f.portrait) {
            tbPageContext6 = this.cQK.aUx;
            ((BaseFragmentActivity) tbPageContext6.getOrignalPage()).finish();
        } else if (id == n.f.username) {
            tbPageContext5 = this.cQK.aUx;
            ((BaseFragmentActivity) tbPageContext5.getOrignalPage()).finish();
        } else if ((id == n.f.item_header || id == n.f.original_post_title || id == n.f.item_footer) && (strArr = (String[]) view.getTag()) != null) {
            if (strArr.length < 4 || strArr[3] == null || com.baidu.adp.lib.h.b.g(strArr[3], 0) != 33) {
                z = false;
            } else if ("0".equals(strArr[2]) || strArr[1] == null) {
                tbPageContext3 = this.cQK.aUx;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(tbPageContext3.getPageActivity(), strArr[0]).rw()));
                z = true;
            } else {
                tbPageContext4 = this.cQK.aUx;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(tbPageContext4.getPageActivity()).createPhotoLiveCommentActivityConfig(strArr[0], strArr[1], false)));
                z = true;
            }
            if (!z) {
                if (!"0".equals(strArr[2]) && strArr[1] != null) {
                    tbPageContext2 = this.cQK.aUx;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(tbPageContext2.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false)));
                    return;
                }
                MessageManager messageManager = MessageManager.getInstance();
                tbPageContext = this.cQK.aUx;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_post_reply")));
            }
        }
    }
}

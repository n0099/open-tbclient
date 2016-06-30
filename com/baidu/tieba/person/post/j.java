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
import com.baidu.tieba.person.post.a;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements a.InterfaceC0074a {
    final /* synthetic */ h enp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.enp = hVar;
    }

    @Override // com.baidu.tieba.person.post.a.InterfaceC0074a
    public void bc(View view) {
        String[] strArr;
        boolean z;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        TbPageContext tbPageContext5;
        TbPageContext tbPageContext6;
        int id = view.getId();
        if (id == u.g.portrait) {
            tbPageContext6 = this.enp.bxh;
            ((BaseFragmentActivity) tbPageContext6.getOrignalPage()).finish();
        } else if (id == u.g.username) {
            tbPageContext5 = this.enp.bxh;
            ((BaseFragmentActivity) tbPageContext5.getOrignalPage()).finish();
        } else if ((id == u.g.item_header || id == u.g.original_post_title || id == u.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
            if (strArr.length < 4 || strArr[3] == null || com.baidu.adp.lib.h.b.g(strArr[3], 0) != 33) {
                z = false;
            } else if ("0".equals(strArr[2]) || strArr[1] == null) {
                tbPageContext3 = this.enp.bxh;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(tbPageContext3.getPageActivity(), strArr[0]).ol()));
                z = true;
            } else {
                tbPageContext4 = this.enp.bxh;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(tbPageContext4.getPageActivity()).createPhotoLiveCommentActivityConfig(strArr[0], strArr[1], false)));
                z = true;
            }
            if (!z) {
                if (!"0".equals(strArr[2]) && strArr[1] != null) {
                    tbPageContext2 = this.enp.bxh;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(tbPageContext2.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false)));
                    return;
                }
                MessageManager messageManager = MessageManager.getInstance();
                tbPageContext = this.enp.bxh;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_post_reply")));
            }
        }
    }
}

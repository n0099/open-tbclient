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
import com.baidu.tieba.i;
import com.baidu.tieba.person.post.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0072a {
    final /* synthetic */ g crB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.crB = gVar;
    }

    @Override // com.baidu.tieba.person.post.a.InterfaceC0072a
    public void ae(View view) {
        String[] strArr;
        boolean z;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        TbPageContext tbPageContext5;
        TbPageContext tbPageContext6;
        int id = view.getId();
        if (id == i.f.portrait) {
            tbPageContext6 = this.crB.aPm;
            ((BaseFragmentActivity) tbPageContext6.getOrignalPage()).finish();
        } else if (id == i.f.username) {
            tbPageContext5 = this.crB.aPm;
            ((BaseFragmentActivity) tbPageContext5.getOrignalPage()).finish();
        } else if ((id == i.f.item_header || id == i.f.original_post_title || id == i.f.item_footer) && (strArr = (String[]) view.getTag()) != null) {
            if (strArr.length < 4 || strArr[3] == null || com.baidu.adp.lib.g.b.g(strArr[3], 0) != 33) {
                z = false;
            } else if ("0".equals(strArr[2]) || strArr[1] == null) {
                tbPageContext3 = this.crB.aPm;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(tbPageContext3.getPageActivity(), strArr[0]).rk()));
                z = true;
            } else {
                tbPageContext4 = this.crB.aPm;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(tbPageContext4.getPageActivity()).createPhotoLiveCommentActivityConfig(strArr[0], strArr[1], false)));
                z = true;
            }
            if (!z) {
                if (!"0".equals(strArr[2]) && strArr[1] != null) {
                    tbPageContext2 = this.crB.aPm;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(tbPageContext2.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false)));
                    return;
                }
                MessageManager messageManager = MessageManager.getInstance();
                tbPageContext = this.crB.aPm;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_post_reply")));
            }
        }
    }
}

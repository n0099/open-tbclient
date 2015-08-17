package com.baidu.tieba.person.post;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
import com.baidu.tieba.person.post.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.InterfaceC0067a {
    final /* synthetic */ f ckR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.ckR = fVar;
    }

    @Override // com.baidu.tieba.person.post.a.InterfaceC0067a
    public void ac(View view) {
        String[] strArr;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        int id = view.getId();
        if (id == i.f.portrait) {
            tbPageContext4 = this.ckR.adr;
            ((BaseFragmentActivity) tbPageContext4.getOrignalPage()).finish();
        } else if (id == i.f.username) {
            tbPageContext3 = this.ckR.adr;
            ((BaseFragmentActivity) tbPageContext3.getOrignalPage()).finish();
        } else if ((id == i.f.item_header || id == i.f.original_post_title || id == i.f.item_footer) && (strArr = (String[]) view.getTag()) != null) {
            if (!"0".equals(strArr[2]) && strArr[1] != null) {
                tbPageContext2 = this.ckR.adr;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(tbPageContext2.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false)));
                return;
            }
            MessageManager messageManager = MessageManager.getInstance();
            tbPageContext = this.ckR.adr;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_post_reply")));
        }
    }
}

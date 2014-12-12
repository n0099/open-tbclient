package com.baidu.tieba.person.post;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements b {
    final /* synthetic */ g bHr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.bHr = gVar;
    }

    @Override // com.baidu.tieba.person.post.b
    public void O(View view) {
        String[] strArr;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        int id = view.getId();
        if (id == com.baidu.tieba.w.portrait) {
            tbPageContext4 = g.Me;
            ((BaseFragmentActivity) tbPageContext4.getOrignalPage()).finish();
        } else if (id == com.baidu.tieba.w.username) {
            tbPageContext3 = g.Me;
            ((BaseFragmentActivity) tbPageContext3.getOrignalPage()).finish();
        } else if ((id == com.baidu.tieba.w.item_header || id == com.baidu.tieba.w.original_post_title || id == com.baidu.tieba.w.item_footer) && (strArr = (String[]) view.getTag()) != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                MessageManager messageManager = MessageManager.getInstance();
                tbPageContext = g.Me;
                messageManager.sendMessage(new CustomMessage(2004001, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_post_reply")));
                return;
            }
            MessageManager messageManager2 = MessageManager.getInstance();
            tbPageContext2 = g.Me;
            messageManager2.sendMessage(new CustomMessage(2004001, new PbActivityConfig(tbPageContext2.getPageActivity()).createSubPbCfg(strArr[0], strArr[1], "person_post_reply")));
        }
    }
}

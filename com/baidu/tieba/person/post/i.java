package com.baidu.tieba.person.post;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.game.GameInfoData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements b {
    final /* synthetic */ g bRo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.bRo = gVar;
    }

    @Override // com.baidu.tieba.person.post.b
    public void Q(View view) {
        String[] strArr;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        int id = view.getId();
        if (id == com.baidu.tieba.v.portrait) {
            tbPageContext4 = g.XE;
            ((BaseFragmentActivity) tbPageContext4.getOrignalPage()).finish();
        } else if (id == com.baidu.tieba.v.username) {
            tbPageContext3 = g.XE;
            ((BaseFragmentActivity) tbPageContext3.getOrignalPage()).finish();
        } else if ((id == com.baidu.tieba.v.item_header || id == com.baidu.tieba.v.original_post_title || id == com.baidu.tieba.v.item_footer) && (strArr = (String[]) view.getTag()) != null) {
            if (GameInfoData.NOT_FROM_DETAIL.equals(strArr[2]) || strArr[1] == null) {
                MessageManager messageManager = MessageManager.getInstance();
                tbPageContext = g.XE;
                messageManager.sendMessage(new CustomMessage(2004001, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_post_reply")));
                return;
            }
            MessageManager messageManager2 = MessageManager.getInstance();
            tbPageContext2 = g.XE;
            messageManager2.sendMessage(new CustomMessage(2004001, new PbActivityConfig(tbPageContext2.getPageActivity()).createSubPbCfg(strArr[0], strArr[1], "person_post_reply")));
        }
    }
}

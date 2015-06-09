package com.baidu.tieba.person.post;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.game.GameInfoData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements b {
    final /* synthetic */ g bUk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.bUk = gVar;
    }

    @Override // com.baidu.tieba.person.post.b
    public void Q(View view) {
        String[] strArr;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        int id = view.getId();
        if (id == com.baidu.tieba.q.portrait) {
            tbPageContext4 = g.Yt;
            ((BaseFragmentActivity) tbPageContext4.getOrignalPage()).finish();
        } else if (id == com.baidu.tieba.q.username) {
            tbPageContext3 = g.Yt;
            ((BaseFragmentActivity) tbPageContext3.getOrignalPage()).finish();
        } else if ((id == com.baidu.tieba.q.item_header || id == com.baidu.tieba.q.original_post_title || id == com.baidu.tieba.q.item_footer) && (strArr = (String[]) view.getTag()) != null) {
            if (!GameInfoData.NOT_FROM_DETAIL.equals(strArr[2]) && strArr[1] != null) {
                tbPageContext2 = g.Yt;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(tbPageContext2.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false)));
                return;
            }
            MessageManager messageManager = MessageManager.getInstance();
            tbPageContext = g.Yt;
            messageManager.sendMessage(new CustomMessage(2004001, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_post_reply")));
        }
    }
}

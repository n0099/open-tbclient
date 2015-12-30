package com.baidu.tieba.vote;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ b dRr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i, int i2) {
        super(i, i2);
        this.dRr = bVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean checkMessageIsBelongToCurPage;
        this.dRr.dRo = false;
        checkMessageIsBelongToCurPage = this.dRr.checkMessageIsBelongToCurPage(responsedMessage);
        if (checkMessageIsBelongToCurPage) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                String errorString = responsedMessage.getErrorString();
                String string = TbadkCoreApplication.m411getInst().getString(n.j.neterror);
                if (!StringUtils.isNull(errorString)) {
                    string = errorString;
                }
                k.showToast(TbadkCoreApplication.m411getInst(), string);
            } else if (!(responsedMessage instanceof AddVoteHttpProtoResponse)) {
                if (!(responsedMessage instanceof AddVoteSocketResponse)) {
                    return;
                }
                this.dRr.aJp();
            } else {
                this.dRr.aJp();
            }
        }
    }
}

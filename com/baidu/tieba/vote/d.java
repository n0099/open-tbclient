package com.baidu.tieba.vote;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ b fBq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i, int i2) {
        super(i, i2);
        this.fBq = bVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean checkMessageIsBelongToCurPage;
        this.fBq.fBn = false;
        checkMessageIsBelongToCurPage = this.fBq.checkMessageIsBelongToCurPage(responsedMessage);
        if (checkMessageIsBelongToCurPage) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                String errorString = responsedMessage.getErrorString();
                String string = TbadkCoreApplication.m9getInst().getString(u.j.neterror);
                if (!StringUtils.isNull(errorString)) {
                    string = errorString;
                }
                k.showToast(TbadkCoreApplication.m9getInst(), string);
            } else if (!(responsedMessage instanceof AddVoteHttpProtoResponse)) {
                if (!(responsedMessage instanceof AddVoteSocketResponse)) {
                    return;
                }
                this.fBq.bjr();
            } else {
                this.fBq.bjr();
            }
        }
    }
}

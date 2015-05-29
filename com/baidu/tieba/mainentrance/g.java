package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ f bBF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i, int i2) {
        super(i, i2);
        this.bBF = fVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        h hVar;
        SquareSearchActivity squareSearchActivity;
        h hVar2;
        SquareSearchActivity squareSearchActivity2;
        h hVar3;
        h hVar4;
        List<e> list;
        h hVar5;
        List<e> list2;
        h hVar6;
        SquareSearchActivity squareSearchActivity3;
        if (!(responsedMessage instanceof HotForumSocketResponseMessage) && !(responsedMessage instanceof HotForumHttpResponseMessage)) {
            hVar6 = this.bBF.bBD;
            squareSearchActivity3 = this.bBF.bBC;
            hVar6.hX(squareSearchActivity3.getPageContext().getString(com.baidu.tieba.t.neterror));
        } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
            hVar = this.bBF.bBD;
            squareSearchActivity = this.bBF.bBC;
            hVar.hX(squareSearchActivity.getPageContext().getString(com.baidu.tieba.t.neterror));
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                hVar3 = this.bBF.bBD;
                hVar3.hX(responsedMessage.getErrorString());
                return;
            }
            hVar2 = this.bBF.bBD;
            squareSearchActivity2 = this.bBF.bBC;
            hVar2.hX(squareSearchActivity2.getPageContext().getString(com.baidu.tieba.t.neterror));
        } else {
            if (responsedMessage instanceof HotForumHttpResponseMessage) {
                this.bBF.bBE = ((HotForumHttpResponseMessage) responsedMessage).getForumInfoList();
                hVar5 = this.bBF.bBD;
                list2 = this.bBF.bBE;
                hVar5.aN(list2);
            }
            if (responsedMessage instanceof HotForumSocketResponseMessage) {
                this.bBF.bBE = ((HotForumSocketResponseMessage) responsedMessage).getForumInfoList();
                hVar4 = this.bBF.bBD;
                list = this.bBF.bBE;
                hVar4.aN(list);
            }
        }
    }
}

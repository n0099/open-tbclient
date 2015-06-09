package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ f bBG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i, int i2) {
        super(i, i2);
        this.bBG = fVar;
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
            hVar6 = this.bBG.bBE;
            squareSearchActivity3 = this.bBG.bBD;
            hVar6.hX(squareSearchActivity3.getPageContext().getString(com.baidu.tieba.t.neterror));
        } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
            hVar = this.bBG.bBE;
            squareSearchActivity = this.bBG.bBD;
            hVar.hX(squareSearchActivity.getPageContext().getString(com.baidu.tieba.t.neterror));
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                hVar3 = this.bBG.bBE;
                hVar3.hX(responsedMessage.getErrorString());
                return;
            }
            hVar2 = this.bBG.bBE;
            squareSearchActivity2 = this.bBG.bBD;
            hVar2.hX(squareSearchActivity2.getPageContext().getString(com.baidu.tieba.t.neterror));
        } else {
            if (responsedMessage instanceof HotForumHttpResponseMessage) {
                this.bBG.bBF = ((HotForumHttpResponseMessage) responsedMessage).getForumInfoList();
                hVar5 = this.bBG.bBE;
                list2 = this.bBG.bBF;
                hVar5.aN(list2);
            }
            if (responsedMessage instanceof HotForumSocketResponseMessage) {
                this.bBG.bBF = ((HotForumSocketResponseMessage) responsedMessage).getForumInfoList();
                hVar4 = this.bBG.bBE;
                list = this.bBG.bBF;
                hVar4.aN(list);
            }
        }
    }
}

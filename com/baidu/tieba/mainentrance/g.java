package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ f byR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i, int i2) {
        super(i, i2);
        this.byR = fVar;
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
            hVar6 = this.byR.byQ;
            squareSearchActivity3 = this.byR.byL;
            hVar6.ht(squareSearchActivity3.getPageContext().getString(com.baidu.tieba.y.neterror));
        } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
            hVar = this.byR.byQ;
            squareSearchActivity = this.byR.byL;
            hVar.ht(squareSearchActivity.getPageContext().getString(com.baidu.tieba.y.neterror));
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                hVar3 = this.byR.byQ;
                hVar3.ht(responsedMessage.getErrorString());
                return;
            }
            hVar2 = this.byR.byQ;
            squareSearchActivity2 = this.byR.byL;
            hVar2.ht(squareSearchActivity2.getPageContext().getString(com.baidu.tieba.y.neterror));
        } else {
            if (responsedMessage instanceof HotForumHttpResponseMessage) {
                this.byR.byM = ((HotForumHttpResponseMessage) responsedMessage).getForumInfoList();
                hVar5 = this.byR.byQ;
                list2 = this.byR.byM;
                hVar5.aN(list2);
            }
            if (responsedMessage instanceof HotForumSocketResponseMessage) {
                this.byR.byM = ((HotForumSocketResponseMessage) responsedMessage).getForumInfoList();
                hVar4 = this.byR.byQ;
                list = this.byR.byM;
                hVar4.aN(list);
            }
        }
    }
}

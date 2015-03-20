package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ f byB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i, int i2) {
        super(i, i2);
        this.byB = fVar;
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
            hVar6 = this.byB.byA;
            squareSearchActivity3 = this.byB.byv;
            hVar6.hq(squareSearchActivity3.getPageContext().getString(com.baidu.tieba.y.neterror));
        } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
            hVar = this.byB.byA;
            squareSearchActivity = this.byB.byv;
            hVar.hq(squareSearchActivity.getPageContext().getString(com.baidu.tieba.y.neterror));
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                hVar3 = this.byB.byA;
                hVar3.hq(responsedMessage.getErrorString());
                return;
            }
            hVar2 = this.byB.byA;
            squareSearchActivity2 = this.byB.byv;
            hVar2.hq(squareSearchActivity2.getPageContext().getString(com.baidu.tieba.y.neterror));
        } else {
            if (responsedMessage instanceof HotForumHttpResponseMessage) {
                this.byB.byw = ((HotForumHttpResponseMessage) responsedMessage).getForumInfoList();
                hVar5 = this.byB.byA;
                list2 = this.byB.byw;
                hVar5.aL(list2);
            }
            if (responsedMessage instanceof HotForumSocketResponseMessage) {
                this.byB.byw = ((HotForumSocketResponseMessage) responsedMessage).getForumInfoList();
                hVar4 = this.byB.byA;
                list = this.byB.byw;
                hVar4.aL(list);
            }
        }
    }
}

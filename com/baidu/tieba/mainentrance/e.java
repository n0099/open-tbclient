package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.mainentrance.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d bQv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.bQv = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        d.a aVar;
        SquareSearchActivity squareSearchActivity;
        d.a aVar2;
        SquareSearchActivity squareSearchActivity2;
        d.a aVar3;
        d.a aVar4;
        List<c> list;
        d.a aVar5;
        List<c> list2;
        d.a aVar6;
        SquareSearchActivity squareSearchActivity3;
        if (!(responsedMessage instanceof HotForumSocketResponseMessage) && !(responsedMessage instanceof HotForumHttpResponseMessage)) {
            aVar6 = this.bQv.bQt;
            squareSearchActivity3 = this.bQv.bQs;
            aVar6.iJ(squareSearchActivity3.getPageContext().getString(i.h.neterror));
        } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
            aVar = this.bQv.bQt;
            squareSearchActivity = this.bQv.bQs;
            aVar.iJ(squareSearchActivity.getPageContext().getString(i.h.neterror));
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                aVar3 = this.bQv.bQt;
                aVar3.iJ(responsedMessage.getErrorString());
                return;
            }
            aVar2 = this.bQv.bQt;
            squareSearchActivity2 = this.bQv.bQs;
            aVar2.iJ(squareSearchActivity2.getPageContext().getString(i.h.neterror));
        } else {
            if (responsedMessage instanceof HotForumHttpResponseMessage) {
                this.bQv.bQu = ((HotForumHttpResponseMessage) responsedMessage).getForumInfoList();
                aVar5 = this.bQv.bQt;
                list2 = this.bQv.bQu;
                aVar5.aQ(list2);
            }
            if (responsedMessage instanceof HotForumSocketResponseMessage) {
                this.bQv.bQu = ((HotForumSocketResponseMessage) responsedMessage).getForumInfoList();
                aVar4 = this.bQv.bQt;
                list = this.bQv.bQu;
                aVar4.aQ(list);
            }
        }
    }
}

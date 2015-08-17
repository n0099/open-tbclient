package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.mainentrance.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d bPP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.bPP = dVar;
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
            aVar6 = this.bPP.bPN;
            squareSearchActivity3 = this.bPP.bPM;
            aVar6.iA(squareSearchActivity3.getPageContext().getString(i.C0057i.neterror));
        } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
            aVar = this.bPP.bPN;
            squareSearchActivity = this.bPP.bPM;
            aVar.iA(squareSearchActivity.getPageContext().getString(i.C0057i.neterror));
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                aVar3 = this.bPP.bPN;
                aVar3.iA(responsedMessage.getErrorString());
                return;
            }
            aVar2 = this.bPP.bPN;
            squareSearchActivity2 = this.bPP.bPM;
            aVar2.iA(squareSearchActivity2.getPageContext().getString(i.C0057i.neterror));
        } else {
            if (responsedMessage instanceof HotForumHttpResponseMessage) {
                this.bPP.bPO = ((HotForumHttpResponseMessage) responsedMessage).getForumInfoList();
                aVar5 = this.bPP.bPN;
                list2 = this.bPP.bPO;
                aVar5.aQ(list2);
            }
            if (responsedMessage instanceof HotForumSocketResponseMessage) {
                this.bPP.bPO = ((HotForumSocketResponseMessage) responsedMessage).getForumInfoList();
                aVar4 = this.bPP.bPN;
                list = this.bPP.bPO;
                aVar4.aQ(list);
            }
        }
    }
}

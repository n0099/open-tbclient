package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.mainentrance.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d bTY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.bTY = dVar;
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
        List<g> list2;
        f fVar;
        d.a aVar5;
        List<c> list3;
        List<g> list4;
        f fVar2;
        d.a aVar6;
        SquareSearchActivity squareSearchActivity3;
        if (!(responsedMessage instanceof HotForumSocketResponseMessage) && !(responsedMessage instanceof HotForumHttpResponseMessage)) {
            aVar6 = this.bTY.bTW;
            squareSearchActivity3 = this.bTY.bTV;
            aVar6.iU(squareSearchActivity3.getPageContext().getString(i.h.neterror));
        } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
            aVar = this.bTY.bTW;
            squareSearchActivity = this.bTY.bTV;
            aVar.iU(squareSearchActivity.getPageContext().getString(i.h.neterror));
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                aVar3 = this.bTY.bTW;
                aVar3.iU(responsedMessage.getErrorString());
                return;
            }
            aVar2 = this.bTY.bTW;
            squareSearchActivity2 = this.bTY.bTV;
            aVar2.iU(squareSearchActivity2.getPageContext().getString(i.h.neterror));
        } else {
            if (responsedMessage instanceof HotForumHttpResponseMessage) {
                HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                this.bTY.bTX = hotForumHttpResponseMessage.getForumInfoList();
                this.bTY.mTopicInfoList = hotForumHttpResponseMessage.getTopicInfoList();
                this.bTY.mHotSearchInfo = hotForumHttpResponseMessage.getHotSearchInfo();
                aVar5 = this.bTY.bTW;
                list3 = this.bTY.bTX;
                list4 = this.bTY.mTopicInfoList;
                fVar2 = this.bTY.mHotSearchInfo;
                aVar5.a(list3, list4, fVar2);
            }
            if (responsedMessage instanceof HotForumSocketResponseMessage) {
                HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                this.bTY.bTX = hotForumSocketResponseMessage.getForumInfoList();
                this.bTY.mTopicInfoList = hotForumSocketResponseMessage.getTopicInfoList();
                this.bTY.mHotSearchInfo = hotForumSocketResponseMessage.getSearchInfo();
                aVar4 = this.bTY.bTW;
                list = this.bTY.bTX;
                list2 = this.bTY.mTopicInfoList;
                fVar = this.bTY.mHotSearchInfo;
                aVar4.a(list, list2, fVar);
            }
        }
    }
}

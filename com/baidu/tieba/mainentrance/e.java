package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.mainentrance.d;
import com.baidu.tieba.n;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d cpb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.cpb = dVar;
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
            aVar6 = this.cpb.coZ;
            squareSearchActivity3 = this.cpb.coY;
            aVar6.jG(squareSearchActivity3.getPageContext().getString(n.j.neterror));
        } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
            aVar = this.cpb.coZ;
            squareSearchActivity = this.cpb.coY;
            aVar.jG(squareSearchActivity.getPageContext().getString(n.j.neterror));
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                aVar3 = this.cpb.coZ;
                aVar3.jG(responsedMessage.getErrorString());
                return;
            }
            aVar2 = this.cpb.coZ;
            squareSearchActivity2 = this.cpb.coY;
            aVar2.jG(squareSearchActivity2.getPageContext().getString(n.j.neterror));
        } else {
            if (responsedMessage instanceof HotForumHttpResponseMessage) {
                HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                this.cpb.cpa = hotForumHttpResponseMessage.getForumInfoList();
                this.cpb.mTopicInfoList = hotForumHttpResponseMessage.getTopicInfoList();
                this.cpb.mHotSearchInfo = hotForumHttpResponseMessage.getHotSearchInfo();
                aVar5 = this.cpb.coZ;
                list3 = this.cpb.cpa;
                list4 = this.cpb.mTopicInfoList;
                fVar2 = this.cpb.mHotSearchInfo;
                aVar5.a(list3, list4, fVar2);
            }
            if (responsedMessage instanceof HotForumSocketResponseMessage) {
                HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                this.cpb.cpa = hotForumSocketResponseMessage.getForumInfoList();
                this.cpb.mTopicInfoList = hotForumSocketResponseMessage.getTopicInfoList();
                this.cpb.mHotSearchInfo = hotForumSocketResponseMessage.getSearchInfo();
                aVar4 = this.cpb.coZ;
                list = this.cpb.cpa;
                list2 = this.cpb.mTopicInfoList;
                fVar = this.cpb.mHotSearchInfo;
                aVar4.a(list, list2, fVar);
            }
        }
    }
}

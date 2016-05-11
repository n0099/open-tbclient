package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.mainentrance.d;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d cLB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.cLB = dVar;
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
        String str;
        d.a aVar5;
        List<c> list3;
        List<g> list4;
        f fVar2;
        String str2;
        d.a aVar6;
        SquareSearchActivity squareSearchActivity3;
        if (!(responsedMessage instanceof HotForumSocketResponseMessage) && !(responsedMessage instanceof HotForumHttpResponseMessage)) {
            aVar6 = this.cLB.cLz;
            squareSearchActivity3 = this.cLB.cLy;
            aVar6.kB(squareSearchActivity3.getPageContext().getString(t.j.neterror));
        } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
            aVar = this.cLB.cLz;
            squareSearchActivity = this.cLB.cLy;
            aVar.kB(squareSearchActivity.getPageContext().getString(t.j.neterror));
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                aVar3 = this.cLB.cLz;
                aVar3.kB(responsedMessage.getErrorString());
                return;
            }
            aVar2 = this.cLB.cLz;
            squareSearchActivity2 = this.cLB.cLy;
            aVar2.kB(squareSearchActivity2.getPageContext().getString(t.j.neterror));
        } else {
            if (responsedMessage instanceof HotForumHttpResponseMessage) {
                HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                this.cLB.cLA = hotForumHttpResponseMessage.getForumInfoList();
                this.cLB.mTopicInfoList = hotForumHttpResponseMessage.getTopicInfoList();
                this.cLB.mHotSearchInfo = hotForumHttpResponseMessage.getHotSearchInfo();
                this.cLB.mTopicInfoTitle = hotForumHttpResponseMessage.getTopicInfoTitle();
                aVar5 = this.cLB.cLz;
                list3 = this.cLB.cLA;
                list4 = this.cLB.mTopicInfoList;
                fVar2 = this.cLB.mHotSearchInfo;
                str2 = this.cLB.mTopicInfoTitle;
                aVar5.a(list3, list4, fVar2, str2);
            }
            if (responsedMessage instanceof HotForumSocketResponseMessage) {
                HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                this.cLB.cLA = hotForumSocketResponseMessage.getForumInfoList();
                this.cLB.mTopicInfoList = hotForumSocketResponseMessage.getTopicInfoList();
                this.cLB.mHotSearchInfo = hotForumSocketResponseMessage.getSearchInfo();
                this.cLB.mTopicInfoTitle = hotForumSocketResponseMessage.getTopicInfoTitle();
                aVar4 = this.cLB.cLz;
                list = this.cLB.cLA;
                list2 = this.cLB.mTopicInfoList;
                fVar = this.cLB.mHotSearchInfo;
                str = this.cLB.mTopicInfoTitle;
                aVar4.a(list, list2, fVar, str);
            }
        }
    }
}

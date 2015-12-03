package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.mainentrance.d;
import com.baidu.tieba.n;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d ckX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.ckX = dVar;
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
            aVar6 = this.ckX.ckV;
            squareSearchActivity3 = this.ckX.ckU;
            aVar6.jr(squareSearchActivity3.getPageContext().getString(n.i.neterror));
        } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
            aVar = this.ckX.ckV;
            squareSearchActivity = this.ckX.ckU;
            aVar.jr(squareSearchActivity.getPageContext().getString(n.i.neterror));
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                aVar3 = this.ckX.ckV;
                aVar3.jr(responsedMessage.getErrorString());
                return;
            }
            aVar2 = this.ckX.ckV;
            squareSearchActivity2 = this.ckX.ckU;
            aVar2.jr(squareSearchActivity2.getPageContext().getString(n.i.neterror));
        } else {
            if (responsedMessage instanceof HotForumHttpResponseMessage) {
                HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                this.ckX.ckW = hotForumHttpResponseMessage.getForumInfoList();
                this.ckX.mTopicInfoList = hotForumHttpResponseMessage.getTopicInfoList();
                this.ckX.mHotSearchInfo = hotForumHttpResponseMessage.getHotSearchInfo();
                aVar5 = this.ckX.ckV;
                list3 = this.ckX.ckW;
                list4 = this.ckX.mTopicInfoList;
                fVar2 = this.ckX.mHotSearchInfo;
                aVar5.a(list3, list4, fVar2);
            }
            if (responsedMessage instanceof HotForumSocketResponseMessage) {
                HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                this.ckX.ckW = hotForumSocketResponseMessage.getForumInfoList();
                this.ckX.mTopicInfoList = hotForumSocketResponseMessage.getTopicInfoList();
                this.ckX.mHotSearchInfo = hotForumSocketResponseMessage.getSearchInfo();
                aVar4 = this.ckX.ckV;
                list = this.ckX.ckW;
                list2 = this.ckX.mTopicInfoList;
                fVar = this.ckX.mHotSearchInfo;
                aVar4.a(list, list2, fVar);
            }
        }
    }
}

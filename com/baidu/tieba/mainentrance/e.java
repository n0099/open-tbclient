package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.mainentrance.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d bUj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.bUj = dVar;
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
            aVar6 = this.bUj.bUh;
            squareSearchActivity3 = this.bUj.bUg;
            aVar6.iU(squareSearchActivity3.getPageContext().getString(i.h.neterror));
        } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
            aVar = this.bUj.bUh;
            squareSearchActivity = this.bUj.bUg;
            aVar.iU(squareSearchActivity.getPageContext().getString(i.h.neterror));
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                aVar3 = this.bUj.bUh;
                aVar3.iU(responsedMessage.getErrorString());
                return;
            }
            aVar2 = this.bUj.bUh;
            squareSearchActivity2 = this.bUj.bUg;
            aVar2.iU(squareSearchActivity2.getPageContext().getString(i.h.neterror));
        } else {
            if (responsedMessage instanceof HotForumHttpResponseMessage) {
                HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                this.bUj.bUi = hotForumHttpResponseMessage.getForumInfoList();
                this.bUj.mTopicInfoList = hotForumHttpResponseMessage.getTopicInfoList();
                this.bUj.mHotSearchInfo = hotForumHttpResponseMessage.getHotSearchInfo();
                aVar5 = this.bUj.bUh;
                list3 = this.bUj.bUi;
                list4 = this.bUj.mTopicInfoList;
                fVar2 = this.bUj.mHotSearchInfo;
                aVar5.a(list3, list4, fVar2);
            }
            if (responsedMessage instanceof HotForumSocketResponseMessage) {
                HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                this.bUj.bUi = hotForumSocketResponseMessage.getForumInfoList();
                this.bUj.mTopicInfoList = hotForumSocketResponseMessage.getTopicInfoList();
                this.bUj.mHotSearchInfo = hotForumSocketResponseMessage.getSearchInfo();
                aVar4 = this.bUj.bUh;
                list = this.bUj.bUi;
                list2 = this.bUj.mTopicInfoList;
                fVar = this.bUj.mHotSearchInfo;
                aVar4.a(list, list2, fVar);
            }
        }
    }
}

package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.mainentrance.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d bUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.bUK = dVar;
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
            aVar6 = this.bUK.bUI;
            squareSearchActivity3 = this.bUK.bUH;
            aVar6.iW(squareSearchActivity3.getPageContext().getString(i.h.neterror));
        } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
            aVar = this.bUK.bUI;
            squareSearchActivity = this.bUK.bUH;
            aVar.iW(squareSearchActivity.getPageContext().getString(i.h.neterror));
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                aVar3 = this.bUK.bUI;
                aVar3.iW(responsedMessage.getErrorString());
                return;
            }
            aVar2 = this.bUK.bUI;
            squareSearchActivity2 = this.bUK.bUH;
            aVar2.iW(squareSearchActivity2.getPageContext().getString(i.h.neterror));
        } else {
            if (responsedMessage instanceof HotForumHttpResponseMessage) {
                HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                this.bUK.bUJ = hotForumHttpResponseMessage.getForumInfoList();
                this.bUK.mTopicInfoList = hotForumHttpResponseMessage.getTopicInfoList();
                this.bUK.mHotSearchInfo = hotForumHttpResponseMessage.getHotSearchInfo();
                aVar5 = this.bUK.bUI;
                list3 = this.bUK.bUJ;
                list4 = this.bUK.mTopicInfoList;
                fVar2 = this.bUK.mHotSearchInfo;
                aVar5.a(list3, list4, fVar2);
            }
            if (responsedMessage instanceof HotForumSocketResponseMessage) {
                HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                this.bUK.bUJ = hotForumSocketResponseMessage.getForumInfoList();
                this.bUK.mTopicInfoList = hotForumSocketResponseMessage.getTopicInfoList();
                this.bUK.mHotSearchInfo = hotForumSocketResponseMessage.getSearchInfo();
                aVar4 = this.bUK.bUI;
                list = this.bUK.bUJ;
                list2 = this.bUK.mTopicInfoList;
                fVar = this.bUK.mHotSearchInfo;
                aVar4.a(list, list2, fVar);
            }
        }
    }
}

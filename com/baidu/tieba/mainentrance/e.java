package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.mainentrance.d;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d cKF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.cKF = dVar;
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
            aVar6 = this.cKF.cKD;
            squareSearchActivity3 = this.cKF.cKC;
            aVar6.kx(squareSearchActivity3.getPageContext().getString(t.j.neterror));
        } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
            aVar = this.cKF.cKD;
            squareSearchActivity = this.cKF.cKC;
            aVar.kx(squareSearchActivity.getPageContext().getString(t.j.neterror));
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                aVar3 = this.cKF.cKD;
                aVar3.kx(responsedMessage.getErrorString());
                return;
            }
            aVar2 = this.cKF.cKD;
            squareSearchActivity2 = this.cKF.cKC;
            aVar2.kx(squareSearchActivity2.getPageContext().getString(t.j.neterror));
        } else {
            if (responsedMessage instanceof HotForumHttpResponseMessage) {
                HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                this.cKF.cKE = hotForumHttpResponseMessage.getForumInfoList();
                this.cKF.mTopicInfoList = hotForumHttpResponseMessage.getTopicInfoList();
                this.cKF.mHotSearchInfo = hotForumHttpResponseMessage.getHotSearchInfo();
                this.cKF.mTopicInfoTitle = hotForumHttpResponseMessage.getTopicInfoTitle();
                aVar5 = this.cKF.cKD;
                list3 = this.cKF.cKE;
                list4 = this.cKF.mTopicInfoList;
                fVar2 = this.cKF.mHotSearchInfo;
                str2 = this.cKF.mTopicInfoTitle;
                aVar5.a(list3, list4, fVar2, str2);
            }
            if (responsedMessage instanceof HotForumSocketResponseMessage) {
                HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                this.cKF.cKE = hotForumSocketResponseMessage.getForumInfoList();
                this.cKF.mTopicInfoList = hotForumSocketResponseMessage.getTopicInfoList();
                this.cKF.mHotSearchInfo = hotForumSocketResponseMessage.getSearchInfo();
                this.cKF.mTopicInfoTitle = hotForumSocketResponseMessage.getTopicInfoTitle();
                aVar4 = this.cKF.cKD;
                list = this.cKF.cKE;
                list2 = this.cKF.mTopicInfoList;
                fVar = this.cKF.mHotSearchInfo;
                str = this.cKF.mTopicInfoTitle;
                aVar4.a(list, list2, fVar, str);
            }
        }
    }
}

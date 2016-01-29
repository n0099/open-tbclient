package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.mainentrance.d;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d cvK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.cvK = dVar;
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
            aVar6 = this.cvK.cvI;
            squareSearchActivity3 = this.cvK.cvH;
            aVar6.jK(squareSearchActivity3.getPageContext().getString(t.j.neterror));
        } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
            aVar = this.cvK.cvI;
            squareSearchActivity = this.cvK.cvH;
            aVar.jK(squareSearchActivity.getPageContext().getString(t.j.neterror));
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                aVar3 = this.cvK.cvI;
                aVar3.jK(responsedMessage.getErrorString());
                return;
            }
            aVar2 = this.cvK.cvI;
            squareSearchActivity2 = this.cvK.cvH;
            aVar2.jK(squareSearchActivity2.getPageContext().getString(t.j.neterror));
        } else {
            if (responsedMessage instanceof HotForumHttpResponseMessage) {
                HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                this.cvK.cvJ = hotForumHttpResponseMessage.getForumInfoList();
                this.cvK.mTopicInfoList = hotForumHttpResponseMessage.getTopicInfoList();
                this.cvK.mHotSearchInfo = hotForumHttpResponseMessage.getHotSearchInfo();
                this.cvK.mTopicInfoTitle = hotForumHttpResponseMessage.getTopicInfoTitle();
                aVar5 = this.cvK.cvI;
                list3 = this.cvK.cvJ;
                list4 = this.cvK.mTopicInfoList;
                fVar2 = this.cvK.mHotSearchInfo;
                str2 = this.cvK.mTopicInfoTitle;
                aVar5.a(list3, list4, fVar2, str2);
            }
            if (responsedMessage instanceof HotForumSocketResponseMessage) {
                HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                this.cvK.cvJ = hotForumSocketResponseMessage.getForumInfoList();
                this.cvK.mTopicInfoList = hotForumSocketResponseMessage.getTopicInfoList();
                this.cvK.mHotSearchInfo = hotForumSocketResponseMessage.getSearchInfo();
                this.cvK.mTopicInfoTitle = hotForumSocketResponseMessage.getTopicInfoTitle();
                aVar4 = this.cvK.cvI;
                list = this.cvK.cvJ;
                list2 = this.cvK.mTopicInfoList;
                fVar = this.cvK.mHotSearchInfo;
                str = this.cvK.mTopicInfoTitle;
                aVar4.a(list, list2, fVar, str);
            }
        }
    }
}

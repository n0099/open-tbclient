package com.baidu.tieba.mygiftlist;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import tbclient.GetGiftMyList.DataRes;
/* loaded from: classes.dex */
class c extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ MyGiftListActivity bsZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(MyGiftListActivity myGiftListActivity, int i) {
        super(i);
        this.bsZ = myGiftListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        k kVar;
        k kVar2;
        j jVar;
        j jVar2;
        j jVar3;
        k kVar3;
        j jVar4;
        if (socketResponsedMessage instanceof ResponseMyGiftListMessage) {
            this.bsZ.closeLoadingDialog();
            kVar = this.bsZ.bsU;
            kVar.VJ().setVisibility(8);
            ResponseMyGiftListMessage responseMyGiftListMessage = (ResponseMyGiftListMessage) socketResponsedMessage;
            kVar2 = this.bsZ.bsU;
            kVar2.VK();
            if (responseMyGiftListMessage.hasError()) {
                if (!TextUtils.isEmpty(responseMyGiftListMessage.getErrorString())) {
                    this.bsZ.showToast(responseMyGiftListMessage.getErrorString());
                    return;
                }
                return;
            }
            DataRes giftPageInfo = responseMyGiftListMessage.getGiftPageInfo();
            if (giftPageInfo != null) {
                jVar = this.bsZ.bsT;
                jVar2 = this.bsZ.bsT;
                jVar.setPageNum(jVar2.getPageNum() + 1);
                jVar3 = this.bsZ.bsT;
                jVar3.setHasMore(giftPageInfo.page.has_more.intValue() == 1);
                kVar3 = this.bsZ.bsU;
                jVar4 = this.bsZ.bsT;
                kVar3.a(giftPageInfo, jVar4.VH());
            }
        }
    }
}

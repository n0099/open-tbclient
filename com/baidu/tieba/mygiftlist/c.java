package com.baidu.tieba.mygiftlist;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import tbclient.GetGiftMyList.DataRes;
/* loaded from: classes.dex */
class c extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ MyGiftListActivity bto;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(MyGiftListActivity myGiftListActivity, int i) {
        super(i);
        this.bto = myGiftListActivity;
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
            this.bto.closeLoadingDialog();
            kVar = this.bto.bti;
            kVar.VM().setVisibility(8);
            ResponseMyGiftListMessage responseMyGiftListMessage = (ResponseMyGiftListMessage) socketResponsedMessage;
            kVar2 = this.bto.bti;
            kVar2.VN();
            if (responseMyGiftListMessage.hasError()) {
                if (!TextUtils.isEmpty(responseMyGiftListMessage.getErrorString())) {
                    this.bto.showToast(responseMyGiftListMessage.getErrorString());
                    return;
                }
                return;
            }
            DataRes giftPageInfo = responseMyGiftListMessage.getGiftPageInfo();
            if (giftPageInfo != null) {
                jVar = this.bto.bth;
                jVar2 = this.bto.bth;
                jVar.setPageNum(jVar2.getPageNum() + 1);
                jVar3 = this.bto.bth;
                jVar3.setHasMore(giftPageInfo.page.has_more.intValue() == 1);
                kVar3 = this.bto.bti;
                jVar4 = this.bto.bth;
                kVar3.a(giftPageInfo, jVar4.VK());
            }
        }
    }
}

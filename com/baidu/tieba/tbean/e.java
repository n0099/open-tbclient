package com.baidu.tieba.tbean;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.z;
import java.util.List;
import tbclient.GetIconList.UserInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ d cbU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i) {
        super(i);
        this.cbU = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        i iVar;
        BuyTBeanActivity buyTBeanActivity;
        UserInfo userInfo;
        i iVar2;
        BuyTBeanActivity buyTBeanActivity2;
        List list;
        i iVar3;
        i iVar4;
        BuyTBeanActivity buyTBeanActivity3;
        i iVar5;
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof GetYinJiResponseMessage)) {
            iVar = this.cbU.cbT;
            buyTBeanActivity = this.cbU.cbS;
            iVar.onFailed(buyTBeanActivity.getPageContext().getString(z.neterror));
            return;
        }
        GetYinJiResponseMessage getYinJiResponseMessage = (GetYinJiResponseMessage) socketResponsedMessage;
        if (getYinJiResponseMessage.getError() != 0) {
            if (!TextUtils.isEmpty(getYinJiResponseMessage.getErrorString())) {
                iVar5 = this.cbU.cbT;
                iVar5.onFailed(getYinJiResponseMessage.getErrorString());
                return;
            }
            iVar4 = this.cbU.cbT;
            buyTBeanActivity3 = this.cbU.cbS;
            iVar4.onFailed(buyTBeanActivity3.getPageContext().getString(z.neterror));
            return;
        }
        this.cbU.userInfo = getYinJiResponseMessage.getUserInfo();
        this.cbU.iconInfoList = getYinJiResponseMessage.getIconInfoList();
        userInfo = this.cbU.userInfo;
        if (userInfo != null) {
            list = this.cbU.iconInfoList;
            if (list != null) {
                iVar3 = this.cbU.cbT;
                iVar3.onSuccess();
                return;
            }
        }
        iVar2 = this.cbU.cbT;
        buyTBeanActivity2 = this.cbU.cbS;
        iVar2.onFailed(buyTBeanActivity2.getPageContext().getString(z.no_data_tip));
    }
}

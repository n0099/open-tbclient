package com.baidu.tieba.tbean;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.GetIconList.UserInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ d cuN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i) {
        super(i);
        this.cuN = dVar;
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
            iVar = this.cuN.cuM;
            buyTBeanActivity = this.cuN.cuL;
            iVar.onFailed(buyTBeanActivity.getPageContext().getString(t.neterror));
            return;
        }
        GetYinJiResponseMessage getYinJiResponseMessage = (GetYinJiResponseMessage) socketResponsedMessage;
        if (getYinJiResponseMessage.getError() != 0) {
            if (!TextUtils.isEmpty(getYinJiResponseMessage.getErrorString())) {
                iVar5 = this.cuN.cuM;
                iVar5.onFailed(getYinJiResponseMessage.getErrorString());
                return;
            }
            iVar4 = this.cuN.cuM;
            buyTBeanActivity3 = this.cuN.cuL;
            iVar4.onFailed(buyTBeanActivity3.getPageContext().getString(t.neterror));
            return;
        }
        this.cuN.userInfo = getYinJiResponseMessage.getUserInfo();
        this.cuN.iconInfoList = getYinJiResponseMessage.getIconInfoList();
        userInfo = this.cuN.userInfo;
        if (userInfo != null) {
            list = this.cuN.iconInfoList;
            if (list != null) {
                iVar3 = this.cuN.cuM;
                iVar3.onSuccess();
                return;
            }
        }
        iVar2 = this.cuN.cuM;
        buyTBeanActivity2 = this.cuN.cuL;
        iVar2.onFailed(buyTBeanActivity2.getPageContext().getString(t.no_data_tip));
    }
}

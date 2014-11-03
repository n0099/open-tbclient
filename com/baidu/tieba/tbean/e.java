package com.baidu.tieba.tbean;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.y;
import java.util.List;
import tbclient.GetIconList.UserInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ d bNR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i) {
        super(i);
        this.bNR = dVar;
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
            iVar = this.bNR.bNQ;
            buyTBeanActivity = this.bNR.bNP;
            iVar.hw(buyTBeanActivity.getString(y.neterror));
            return;
        }
        GetYinJiResponseMessage getYinJiResponseMessage = (GetYinJiResponseMessage) socketResponsedMessage;
        if (getYinJiResponseMessage.getError() != 0) {
            if (!TextUtils.isEmpty(getYinJiResponseMessage.getErrorString())) {
                iVar5 = this.bNR.bNQ;
                iVar5.hw(getYinJiResponseMessage.getErrorString());
                return;
            }
            iVar4 = this.bNR.bNQ;
            buyTBeanActivity3 = this.bNR.bNP;
            iVar4.hw(buyTBeanActivity3.getString(y.neterror));
            return;
        }
        this.bNR.userInfo = getYinJiResponseMessage.getUserInfo();
        this.bNR.iconInfoList = getYinJiResponseMessage.getIconInfoList();
        userInfo = this.bNR.userInfo;
        if (userInfo != null) {
            list = this.bNR.iconInfoList;
            if (list != null) {
                iVar3 = this.bNR.bNQ;
                iVar3.onSuccess();
                return;
            }
        }
        iVar2 = this.bNR.bNQ;
        buyTBeanActivity2 = this.bNR.bNP;
        iVar2.hw(buyTBeanActivity2.getString(y.no_data_tip));
    }
}

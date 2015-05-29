package com.baidu.tieba.tbean;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.GetIconList.UserInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ d cuM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i) {
        super(i);
        this.cuM = dVar;
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
            iVar = this.cuM.cuL;
            buyTBeanActivity = this.cuM.cuK;
            iVar.onFailed(buyTBeanActivity.getPageContext().getString(t.neterror));
            return;
        }
        GetYinJiResponseMessage getYinJiResponseMessage = (GetYinJiResponseMessage) socketResponsedMessage;
        if (getYinJiResponseMessage.getError() != 0) {
            if (!TextUtils.isEmpty(getYinJiResponseMessage.getErrorString())) {
                iVar5 = this.cuM.cuL;
                iVar5.onFailed(getYinJiResponseMessage.getErrorString());
                return;
            }
            iVar4 = this.cuM.cuL;
            buyTBeanActivity3 = this.cuM.cuK;
            iVar4.onFailed(buyTBeanActivity3.getPageContext().getString(t.neterror));
            return;
        }
        this.cuM.userInfo = getYinJiResponseMessage.getUserInfo();
        this.cuM.iconInfoList = getYinJiResponseMessage.getIconInfoList();
        userInfo = this.cuM.userInfo;
        if (userInfo != null) {
            list = this.cuM.iconInfoList;
            if (list != null) {
                iVar3 = this.cuM.cuL;
                iVar3.onSuccess();
                return;
            }
        }
        iVar2 = this.cuM.cuL;
        buyTBeanActivity2 = this.cuM.cuK;
        iVar2.onFailed(buyTBeanActivity2.getPageContext().getString(t.no_data_tip));
    }
}

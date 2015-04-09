package com.baidu.tieba.tbean;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.y;
import java.util.List;
import tbclient.GetIconList.UserInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ d cqI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i) {
        super(i);
        this.cqI = dVar;
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
            iVar = this.cqI.cqH;
            buyTBeanActivity = this.cqI.cqG;
            iVar.onFailed(buyTBeanActivity.getPageContext().getString(y.neterror));
            return;
        }
        GetYinJiResponseMessage getYinJiResponseMessage = (GetYinJiResponseMessage) socketResponsedMessage;
        if (getYinJiResponseMessage.getError() != 0) {
            if (!TextUtils.isEmpty(getYinJiResponseMessage.getErrorString())) {
                iVar5 = this.cqI.cqH;
                iVar5.onFailed(getYinJiResponseMessage.getErrorString());
                return;
            }
            iVar4 = this.cqI.cqH;
            buyTBeanActivity3 = this.cqI.cqG;
            iVar4.onFailed(buyTBeanActivity3.getPageContext().getString(y.neterror));
            return;
        }
        this.cqI.userInfo = getYinJiResponseMessage.getUserInfo();
        this.cqI.iconInfoList = getYinJiResponseMessage.getIconInfoList();
        userInfo = this.cqI.userInfo;
        if (userInfo != null) {
            list = this.cqI.iconInfoList;
            if (list != null) {
                iVar3 = this.cqI.cqH;
                iVar3.onSuccess();
                return;
            }
        }
        iVar2 = this.cqI.cqH;
        buyTBeanActivity2 = this.cqI.cqG;
        iVar2.onFailed(buyTBeanActivity2.getPageContext().getString(y.no_data_tip));
    }
}

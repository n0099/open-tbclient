package com.baidu.tieba.tbean;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.y;
import java.util.List;
import tbclient.GetIconList.UserInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ d cqs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i) {
        super(i);
        this.cqs = dVar;
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
            iVar = this.cqs.cqr;
            buyTBeanActivity = this.cqs.cqq;
            iVar.onFailed(buyTBeanActivity.getPageContext().getString(y.neterror));
            return;
        }
        GetYinJiResponseMessage getYinJiResponseMessage = (GetYinJiResponseMessage) socketResponsedMessage;
        if (getYinJiResponseMessage.getError() != 0) {
            if (!TextUtils.isEmpty(getYinJiResponseMessage.getErrorString())) {
                iVar5 = this.cqs.cqr;
                iVar5.onFailed(getYinJiResponseMessage.getErrorString());
                return;
            }
            iVar4 = this.cqs.cqr;
            buyTBeanActivity3 = this.cqs.cqq;
            iVar4.onFailed(buyTBeanActivity3.getPageContext().getString(y.neterror));
            return;
        }
        this.cqs.userInfo = getYinJiResponseMessage.getUserInfo();
        this.cqs.iconInfoList = getYinJiResponseMessage.getIconInfoList();
        userInfo = this.cqs.userInfo;
        if (userInfo != null) {
            list = this.cqs.iconInfoList;
            if (list != null) {
                iVar3 = this.cqs.cqr;
                iVar3.onSuccess();
                return;
            }
        }
        iVar2 = this.cqs.cqr;
        buyTBeanActivity2 = this.cqs.cqq;
        iVar2.onFailed(buyTBeanActivity2.getPageContext().getString(y.no_data_tip));
    }
}

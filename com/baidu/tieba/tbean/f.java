package com.baidu.tieba.tbean;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.n;
import com.baidu.tieba.tbean.e;
import java.util.List;
import tbclient.GetIconList.UserInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ e dCv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i) {
        super(i);
        this.dCv = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        e.a aVar;
        BuyTBeanActivity buyTBeanActivity;
        UserInfo userInfo;
        e.a aVar2;
        BuyTBeanActivity buyTBeanActivity2;
        List list;
        e.a aVar3;
        e.a aVar4;
        BuyTBeanActivity buyTBeanActivity3;
        e.a aVar5;
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof GetYinJiResponseMessage)) {
            aVar = this.dCv.dCu;
            buyTBeanActivity = this.dCv.dCt;
            aVar.hh(buyTBeanActivity.getPageContext().getString(n.i.neterror));
            return;
        }
        GetYinJiResponseMessage getYinJiResponseMessage = (GetYinJiResponseMessage) socketResponsedMessage;
        if (getYinJiResponseMessage.getError() != 0) {
            if (!TextUtils.isEmpty(getYinJiResponseMessage.getErrorString())) {
                aVar5 = this.dCv.dCu;
                aVar5.hh(getYinJiResponseMessage.getErrorString());
                return;
            }
            aVar4 = this.dCv.dCu;
            buyTBeanActivity3 = this.dCv.dCt;
            aVar4.hh(buyTBeanActivity3.getPageContext().getString(n.i.neterror));
            return;
        }
        this.dCv.userInfo = getYinJiResponseMessage.getUserInfo();
        this.dCv.iconInfoList = getYinJiResponseMessage.getIconInfoList();
        userInfo = this.dCv.userInfo;
        if (userInfo != null) {
            list = this.dCv.iconInfoList;
            if (list != null) {
                aVar3 = this.dCv.dCu;
                aVar3.onSuccess();
                return;
            }
        }
        aVar2 = this.dCv.dCu;
        buyTBeanActivity2 = this.dCv.dCt;
        aVar2.hh(buyTBeanActivity2.getPageContext().getString(n.i.no_data_tip));
    }
}

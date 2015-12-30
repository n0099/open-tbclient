package com.baidu.tieba.tbean;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.n;
import com.baidu.tieba.tbean.e;
import java.util.List;
import tbclient.GetIconList.UserInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends HttpMessageListener {
    final /* synthetic */ e dJX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, int i) {
        super(i);
        this.dJX = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
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
        if (httpResponsedMessage == null || !(httpResponsedMessage instanceof GetYinJiHttpResponseMessage)) {
            aVar = this.dJX.dJW;
            buyTBeanActivity = this.dJX.dJV;
            aVar.hs(buyTBeanActivity.getPageContext().getString(n.j.neterror));
            return;
        }
        GetYinJiHttpResponseMessage getYinJiHttpResponseMessage = (GetYinJiHttpResponseMessage) httpResponsedMessage;
        if (getYinJiHttpResponseMessage.getError() != 0) {
            if (!TextUtils.isEmpty(getYinJiHttpResponseMessage.getErrorString())) {
                aVar5 = this.dJX.dJW;
                aVar5.hs(getYinJiHttpResponseMessage.getErrorString());
                return;
            }
            aVar4 = this.dJX.dJW;
            buyTBeanActivity3 = this.dJX.dJV;
            aVar4.hs(buyTBeanActivity3.getPageContext().getString(n.j.neterror));
            return;
        }
        this.dJX.userInfo = getYinJiHttpResponseMessage.getUserInfo();
        this.dJX.iconInfoList = getYinJiHttpResponseMessage.getIconInfoList();
        userInfo = this.dJX.userInfo;
        if (userInfo != null) {
            list = this.dJX.iconInfoList;
            if (list != null) {
                aVar3 = this.dJX.dJW;
                aVar3.onSuccess();
                return;
            }
        }
        aVar2 = this.dJX.dJW;
        buyTBeanActivity2 = this.dJX.dJV;
        aVar2.hs(buyTBeanActivity2.getPageContext().getString(n.j.no_data_tip));
    }
}

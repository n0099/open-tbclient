package com.baidu.tieba.tbean;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.t;
import com.baidu.tieba.tbean.e;
import java.util.List;
import tbclient.GetIconList.UserInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends HttpMessageListener {
    final /* synthetic */ e eac;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, int i) {
        super(i);
        this.eac = eVar;
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
            aVar = this.eac.eab;
            buyTBeanActivity = this.eac.eaa;
            aVar.ht(buyTBeanActivity.getPageContext().getString(t.j.neterror));
            return;
        }
        GetYinJiHttpResponseMessage getYinJiHttpResponseMessage = (GetYinJiHttpResponseMessage) httpResponsedMessage;
        if (getYinJiHttpResponseMessage.getError() != 0) {
            if (!TextUtils.isEmpty(getYinJiHttpResponseMessage.getErrorString())) {
                aVar5 = this.eac.eab;
                aVar5.ht(getYinJiHttpResponseMessage.getErrorString());
                return;
            }
            aVar4 = this.eac.eab;
            buyTBeanActivity3 = this.eac.eaa;
            aVar4.ht(buyTBeanActivity3.getPageContext().getString(t.j.neterror));
            return;
        }
        this.eac.userInfo = getYinJiHttpResponseMessage.getUserInfo();
        this.eac.iconInfoList = getYinJiHttpResponseMessage.getIconInfoList();
        userInfo = this.eac.userInfo;
        if (userInfo != null) {
            list = this.eac.iconInfoList;
            if (list != null) {
                aVar3 = this.eac.eab;
                aVar3.onSuccess();
                return;
            }
        }
        aVar2 = this.eac.eab;
        buyTBeanActivity2 = this.eac.eaa;
        aVar2.ht(buyTBeanActivity2.getPageContext().getString(t.j.no_data_tip));
    }
}

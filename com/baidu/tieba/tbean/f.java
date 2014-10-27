package com.baidu.tieba.tbean;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.y;
import java.util.List;
import tbclient.GetIconList.UserInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends HttpMessageListener {
    final /* synthetic */ d bNC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.bNC = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
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
        if (httpResponsedMessage == null || !(httpResponsedMessage instanceof GetYinJiHttpResponseMessage)) {
            iVar = this.bNC.bNB;
            buyTBeanActivity = this.bNC.bNA;
            iVar.hw(buyTBeanActivity.getString(y.neterror));
            return;
        }
        GetYinJiHttpResponseMessage getYinJiHttpResponseMessage = (GetYinJiHttpResponseMessage) httpResponsedMessage;
        if (getYinJiHttpResponseMessage.getError() != 0) {
            if (!TextUtils.isEmpty(getYinJiHttpResponseMessage.getErrorString())) {
                iVar5 = this.bNC.bNB;
                iVar5.hw(getYinJiHttpResponseMessage.getErrorString());
                return;
            }
            iVar4 = this.bNC.bNB;
            buyTBeanActivity3 = this.bNC.bNA;
            iVar4.hw(buyTBeanActivity3.getString(y.neterror));
            return;
        }
        this.bNC.userInfo = getYinJiHttpResponseMessage.getUserInfo();
        this.bNC.iconInfoList = getYinJiHttpResponseMessage.getIconInfoList();
        userInfo = this.bNC.userInfo;
        if (userInfo != null) {
            list = this.bNC.iconInfoList;
            if (list != null) {
                iVar3 = this.bNC.bNB;
                iVar3.onSuccess();
                return;
            }
        }
        iVar2 = this.bNC.bNB;
        buyTBeanActivity2 = this.bNC.bNA;
        iVar2.hw(buyTBeanActivity2.getString(y.no_data_tip));
    }
}

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
    final /* synthetic */ d cqI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.cqI = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
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
            iVar = this.cqI.cqH;
            buyTBeanActivity = this.cqI.cqG;
            iVar.onFailed(buyTBeanActivity.getPageContext().getString(y.neterror));
            return;
        }
        GetYinJiHttpResponseMessage getYinJiHttpResponseMessage = (GetYinJiHttpResponseMessage) httpResponsedMessage;
        if (getYinJiHttpResponseMessage.getError() != 0) {
            if (!TextUtils.isEmpty(getYinJiHttpResponseMessage.getErrorString())) {
                iVar5 = this.cqI.cqH;
                iVar5.onFailed(getYinJiHttpResponseMessage.getErrorString());
                return;
            }
            iVar4 = this.cqI.cqH;
            buyTBeanActivity3 = this.cqI.cqG;
            iVar4.onFailed(buyTBeanActivity3.getPageContext().getString(y.neterror));
            return;
        }
        this.cqI.userInfo = getYinJiHttpResponseMessage.getUserInfo();
        this.cqI.iconInfoList = getYinJiHttpResponseMessage.getIconInfoList();
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

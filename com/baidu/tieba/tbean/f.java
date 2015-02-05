package com.baidu.tieba.tbean;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.z;
import java.util.List;
import tbclient.GetIconList.UserInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends HttpMessageListener {
    final /* synthetic */ d cbU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.cbU = dVar;
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
            iVar = this.cbU.cbT;
            buyTBeanActivity = this.cbU.cbS;
            iVar.onFailed(buyTBeanActivity.getPageContext().getString(z.neterror));
            return;
        }
        GetYinJiHttpResponseMessage getYinJiHttpResponseMessage = (GetYinJiHttpResponseMessage) httpResponsedMessage;
        if (getYinJiHttpResponseMessage.getError() != 0) {
            if (!TextUtils.isEmpty(getYinJiHttpResponseMessage.getErrorString())) {
                iVar5 = this.cbU.cbT;
                iVar5.onFailed(getYinJiHttpResponseMessage.getErrorString());
                return;
            }
            iVar4 = this.cbU.cbT;
            buyTBeanActivity3 = this.cbU.cbS;
            iVar4.onFailed(buyTBeanActivity3.getPageContext().getString(z.neterror));
            return;
        }
        this.cbU.userInfo = getYinJiHttpResponseMessage.getUserInfo();
        this.cbU.iconInfoList = getYinJiHttpResponseMessage.getIconInfoList();
        userInfo = this.cbU.userInfo;
        if (userInfo != null) {
            list = this.cbU.iconInfoList;
            if (list != null) {
                iVar3 = this.cbU.cbT;
                iVar3.onSuccess();
                return;
            }
        }
        iVar2 = this.cbU.cbT;
        buyTBeanActivity2 = this.cbU.cbS;
        iVar2.onFailed(buyTBeanActivity2.getPageContext().getString(z.no_data_tip));
    }
}

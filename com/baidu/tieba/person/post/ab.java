package com.baidu.tieba.person.post;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.message.ResponseGetDeferThreadTimeMessage;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends HttpMessageListener {
    final /* synthetic */ x eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(x xVar, int i) {
        super(i);
        this.eob = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        q qVar;
        q qVar2;
        DealInfoData dealInfoData;
        this.eob.getBaseFragmentActivity().closeLoadingDialog();
        if ((httpResponsedMessage instanceof ResponseGetDeferThreadTimeMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
            ResponseGetDeferThreadTimeMessage responseGetDeferThreadTimeMessage = (ResponseGetDeferThreadTimeMessage) httpResponsedMessage;
            HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
            if (httpMessage.getExtra() instanceof Long) {
                long longValue = ((Long) httpMessage.getExtra()).longValue();
                if (responseGetDeferThreadTimeMessage.getError() == 0) {
                    qVar = this.eob.enX;
                    PersonPostModel.PostInfoList cq = qVar.cq(longValue);
                    if (cq != null && (dealInfoData = cq.dealInfoData) != null) {
                        dealInfoData.expireTime = responseGetDeferThreadTimeMessage.expireTime;
                    }
                    qVar2 = this.eob.enX;
                    qVar2.notifyDataSetChanged();
                    return;
                }
                String errorString = responseGetDeferThreadTimeMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = this.eob.getResources().getString(u.j.neterror);
                }
                this.eob.showToast(errorString);
            }
        }
    }
}

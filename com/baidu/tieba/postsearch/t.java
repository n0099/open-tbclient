package com.baidu.tieba.postsearch;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends HttpMessageListener {
    final /* synthetic */ s cFV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(s sVar, int i) {
        super(i);
        this.cFV = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        int km;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        PostSearchActivity postSearchActivity3;
        PostSearchActivity postSearchActivity4;
        int statusCode = httpResponsedMessage.getStatusCode();
        int error = httpResponsedMessage.getError();
        if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
            HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
            int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
            this.cFV.kn(intValue);
            km = this.cFV.km(intValue);
            boolean z = km > 1;
            PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
            if (statusCode == 200 && error == 0) {
                postSearchActivity4 = this.cFV.cFs;
                postSearchActivity4.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                this.cFV.kl(intValue);
                this.cFV.aoW();
                this.cFV.aoZ();
                return;
            }
            String errorString = postSearchHttpResponseMessage.getErrorString();
            if (TextUtils.isEmpty(errorString)) {
                postSearchActivity3 = this.cFV.cFs;
                errorString = postSearchActivity3.getResources().getString(i.h.neterror);
            }
            postSearchActivity = this.cFV.cFs;
            postSearchActivity.showToast(errorString);
            postSearchActivity2 = this.cFV.cFs;
            postSearchActivity2.a(intValue, null, z);
        }
    }
}

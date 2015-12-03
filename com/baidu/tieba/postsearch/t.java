package com.baidu.tieba.postsearch;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends HttpMessageListener {
    final /* synthetic */ s deE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(s sVar, int i) {
        super(i);
        this.deE = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        int lx;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        PostSearchActivity postSearchActivity3;
        PostSearchActivity postSearchActivity4;
        int statusCode = httpResponsedMessage.getStatusCode();
        int error = httpResponsedMessage.getError();
        if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
            HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
            int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
            this.deE.ly(intValue);
            lx = this.deE.lx(intValue);
            boolean z = lx > 1;
            PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
            if (statusCode == 200 && error == 0) {
                postSearchActivity4 = this.deE.deb;
                postSearchActivity4.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                this.deE.lw(intValue);
                this.deE.auI();
                this.deE.auL();
                return;
            }
            String errorString = postSearchHttpResponseMessage.getErrorString();
            if (TextUtils.isEmpty(errorString)) {
                postSearchActivity3 = this.deE.deb;
                errorString = postSearchActivity3.getResources().getString(n.i.neterror);
            }
            postSearchActivity = this.deE.deb;
            postSearchActivity.showToast(errorString);
            postSearchActivity2 = this.deE.deb;
            postSearchActivity2.a(intValue, null, z);
        }
    }
}

package com.baidu.tieba.postsearch;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends HttpMessageListener {
    final /* synthetic */ t dyf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(t tVar, int i) {
        super(i);
        this.dyf = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        int mX;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        PostSearchActivity postSearchActivity3;
        PostSearchActivity postSearchActivity4;
        int statusCode = httpResponsedMessage.getStatusCode();
        int error = httpResponsedMessage.getError();
        if ((httpResponsedMessage instanceof PostSearchHttpResponseMessage) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
            HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
            int intValue = httpMessage.getExtra() instanceof Integer ? ((Integer) httpMessage.getExtra()).intValue() : 0;
            this.dyf.mY(intValue);
            mX = this.dyf.mX(intValue);
            boolean z = mX > 1;
            PostSearchHttpResponseMessage postSearchHttpResponseMessage = (PostSearchHttpResponseMessage) httpResponsedMessage;
            if (statusCode == 200 && error == 0) {
                postSearchActivity4 = this.dyf.dxA;
                postSearchActivity4.a(intValue, postSearchHttpResponseMessage.getSearchData(), z);
                this.dyf.mW(intValue);
                this.dyf.aCX();
                this.dyf.aDa();
                return;
            }
            String errorString = postSearchHttpResponseMessage.getErrorString();
            if (TextUtils.isEmpty(errorString)) {
                postSearchActivity3 = this.dyf.dxA;
                errorString = postSearchActivity3.getResources().getString(t.j.neterror);
            }
            postSearchActivity = this.dyf.dxA;
            postSearchActivity.showToast(errorString);
            postSearchActivity2 = this.dyf.dxA;
            postSearchActivity2.a(intValue, null, z);
        }
    }
}

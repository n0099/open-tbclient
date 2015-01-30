package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity bIW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.bIW = personPostActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        int[] iArr;
        ImageView imageView;
        int[] iArr2;
        int[] iArr3;
        if (httpResponsedMessage.isSuccess()) {
            if (httpResponsedMessage.getError() == 0) {
                iArr = PersonPostActivity.bkw;
                com.baidu.tbadk.core.account.o.n(4, iArr[this.bIW.bkn]);
                imageView = this.bIW.bkq;
                iArr2 = PersonPostActivity.bku;
                bc.c(imageView, iArr2[this.bIW.bkn]);
                PersonPostActivity personPostActivity = this.bIW;
                TbPageContext pageContext = this.bIW.getPageContext();
                iArr3 = PersonPostActivity.bkv;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr3[this.bIW.bkn]), com.baidu.tieba.v.icon_toast_info);
                return;
            }
            this.bIW.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bIW.showToast(this.bIW.getPageContext().getString(com.baidu.tieba.z.neterror));
    }
}

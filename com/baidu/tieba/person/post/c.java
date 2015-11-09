package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity csQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.csQ = personPostActivity;
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
                iArr = PersonPostActivity.bGj;
                com.baidu.tbadk.core.a.h.w(4, iArr[this.csQ.bGb]);
                imageView = this.csQ.bGd;
                iArr2 = PersonPostActivity.bGh;
                an.c(imageView, iArr2[this.csQ.bGb]);
                PersonPostActivity personPostActivity = this.csQ;
                TbPageContext pageContext = this.csQ.getPageContext();
                iArr3 = PersonPostActivity.bGi;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr3[this.csQ.bGb]), i.e.icon_toast_info);
                return;
            }
            this.csQ.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.csQ.showToast(this.csQ.getPageContext().getString(i.h.neterror));
    }
}

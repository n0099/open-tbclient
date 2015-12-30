package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity cVf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.cVf = personPostActivity;
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
                iArr = PersonPostActivity.bZc;
                com.baidu.tbadk.core.a.h.v(4, iArr[this.cVf.bYU]);
                imageView = this.cVf.bYW;
                iArr2 = PersonPostActivity.bZa;
                as.c(imageView, iArr2[this.cVf.bYU]);
                PersonPostActivity personPostActivity = this.cVf;
                TbPageContext pageContext = this.cVf.getPageContext();
                iArr3 = PersonPostActivity.bZb;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr3[this.cVf.bYU]), n.f.icon_toast_info);
                return;
            }
            this.cVf.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.cVf.showToast(this.cVf.getPageContext().getString(n.j.neterror));
    }
}

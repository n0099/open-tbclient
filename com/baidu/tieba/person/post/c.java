package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity cru;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.cru = personPostActivity;
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
                iArr = PersonPostActivity.bFO;
                com.baidu.tbadk.core.a.h.w(4, iArr[this.cru.bFG]);
                imageView = this.cru.bFI;
                iArr2 = PersonPostActivity.bFM;
                an.c(imageView, iArr2[this.cru.bFG]);
                PersonPostActivity personPostActivity = this.cru;
                TbPageContext pageContext = this.cru.getPageContext();
                iArr3 = PersonPostActivity.bFN;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr3[this.cru.bFG]), i.e.icon_toast_info);
                return;
            }
            this.cru.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.cru.showToast(this.cru.getPageContext().getString(i.h.neterror));
    }
}

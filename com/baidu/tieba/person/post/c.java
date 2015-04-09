package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity bRx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.bRx = personPostActivity;
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
                iArr = PersonPostActivity.blA;
                com.baidu.tbadk.core.a.j.l(4, iArr[this.bRx.blr]);
                imageView = this.bRx.blu;
                iArr2 = PersonPostActivity.bly;
                ba.c(imageView, iArr2[this.bRx.blr]);
                PersonPostActivity personPostActivity = this.bRx;
                TbPageContext pageContext = this.bRx.getPageContext();
                iArr3 = PersonPostActivity.blz;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr3[this.bRx.blr]), com.baidu.tieba.u.icon_toast_info);
                return;
            }
            this.bRx.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bRx.showToast(this.bRx.getPageContext().getString(com.baidu.tieba.y.neterror));
    }
}

package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity clF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.clF = personPostActivity;
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
                iArr = PersonPostActivity.bCz;
                com.baidu.tbadk.core.a.h.w(4, iArr[this.clF.bCr]);
                imageView = this.clF.bCt;
                iArr2 = PersonPostActivity.bCx;
                al.c(imageView, iArr2[this.clF.bCr]);
                PersonPostActivity personPostActivity = this.clF;
                TbPageContext pageContext = this.clF.getPageContext();
                iArr3 = PersonPostActivity.bCy;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr3[this.clF.bCr]), i.e.icon_toast_info);
                return;
            }
            this.clF.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.clF.showToast(this.clF.getPageContext().getString(i.h.neterror));
    }
}

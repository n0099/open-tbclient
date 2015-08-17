package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class b extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity ckK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.ckK = personPostActivity;
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
                iArr = PersonPostActivity.bBS;
                com.baidu.tbadk.core.a.h.w(4, iArr[this.ckK.bBK]);
                imageView = this.ckK.bBM;
                iArr2 = PersonPostActivity.bBQ;
                al.c(imageView, iArr2[this.ckK.bBK]);
                PersonPostActivity personPostActivity = this.ckK;
                TbPageContext pageContext = this.ckK.getPageContext();
                iArr3 = PersonPostActivity.bBR;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr3[this.ckK.bBK]), i.e.icon_toast_info);
                return;
            }
            this.ckK.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.ckK.showToast(this.ckK.getPageContext().getString(i.C0057i.neterror));
    }
}

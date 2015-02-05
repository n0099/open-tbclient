package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity bIV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.bIV = personPostActivity;
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
                iArr = PersonPostActivity.bkv;
                com.baidu.tbadk.core.account.o.n(4, iArr[this.bIV.bkm]);
                imageView = this.bIV.bkp;
                iArr2 = PersonPostActivity.bkt;
                bc.c(imageView, iArr2[this.bIV.bkm]);
                PersonPostActivity personPostActivity = this.bIV;
                TbPageContext pageContext = this.bIV.getPageContext();
                iArr3 = PersonPostActivity.bku;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr3[this.bIV.bkm]), com.baidu.tieba.v.icon_toast_info);
                return;
            }
            this.bIV.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bIV.showToast(this.bIV.getPageContext().getString(com.baidu.tieba.z.neterror));
    }
}

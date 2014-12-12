package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity bHk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.bHk = personPostActivity;
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
                iArr = PersonPostActivity.biZ;
                com.baidu.tbadk.core.account.o.n(4, iArr[this.bHk.biQ]);
                imageView = this.bHk.biT;
                iArr2 = PersonPostActivity.biX;
                ax.c(imageView, iArr2[this.bHk.biQ]);
                PersonPostActivity personPostActivity = this.bHk;
                TbPageContext pageContext = this.bHk.getPageContext();
                iArr3 = PersonPostActivity.biY;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr3[this.bHk.biQ]), com.baidu.tieba.v.icon_toast_info);
                return;
            }
            this.bHk.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bHk.showToast(this.bHk.getPageContext().getString(com.baidu.tieba.z.neterror));
    }
}

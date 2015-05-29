package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity bUc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.bUc = personPostActivity;
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
                iArr = PersonPostActivity.boe;
                com.baidu.tbadk.core.a.j.l(4, iArr[this.bUc.bnW]);
                imageView = this.bUc.bnY;
                iArr2 = PersonPostActivity.boc;
                ay.c(imageView, iArr2[this.bUc.bnW]);
                PersonPostActivity personPostActivity = this.bUc;
                TbPageContext pageContext = this.bUc.getPageContext();
                iArr3 = PersonPostActivity.bod;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr3[this.bUc.bnW]), com.baidu.tieba.p.icon_toast_info);
                return;
            }
            this.bUc.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bUc.showToast(this.bUc.getPageContext().getString(com.baidu.tieba.t.neterror));
    }
}

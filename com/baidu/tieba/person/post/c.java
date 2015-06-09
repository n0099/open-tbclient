package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity bUd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.bUd = personPostActivity;
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
                iArr = PersonPostActivity.bof;
                com.baidu.tbadk.core.a.j.l(4, iArr[this.bUd.bnX]);
                imageView = this.bUd.bnZ;
                iArr2 = PersonPostActivity.bod;
                ay.c(imageView, iArr2[this.bUd.bnX]);
                PersonPostActivity personPostActivity = this.bUd;
                TbPageContext pageContext = this.bUd.getPageContext();
                iArr3 = PersonPostActivity.boe;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr3[this.bUd.bnX]), com.baidu.tieba.p.icon_toast_info);
                return;
            }
            this.bUd.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bUd.showToast(this.bUd.getPageContext().getString(com.baidu.tieba.t.neterror));
    }
}

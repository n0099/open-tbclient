package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity dgG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.dgG = personPostActivity;
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
                iArr = PersonPostActivity.cdx;
                com.baidu.tbadk.core.a.h.r(4, iArr[this.dgG.cdo]);
                imageView = this.dgG.cdr;
                iArr2 = PersonPostActivity.cdv;
                ar.c(imageView, iArr2[this.dgG.cdo]);
                PersonPostActivity personPostActivity = this.dgG;
                TbPageContext pageContext = this.dgG.getPageContext();
                iArr3 = PersonPostActivity.cdw;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr3[this.dgG.cdo]), t.f.icon_toast_info);
                return;
            }
            this.dgG.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.dgG.showToast(this.dgG.getPageContext().getString(t.j.neterror));
    }
}

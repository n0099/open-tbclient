package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity eni;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.eni = personPostActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        int[] iArr;
        ImageView imageView;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (httpResponsedMessage.isSuccess()) {
            if (httpResponsedMessage.getError() == 0) {
                iArr = PersonPostActivity.cUp;
                com.baidu.tbadk.core.a.h.n(4, iArr[this.eni.cUf]);
                imageView = this.eni.cUi;
                iArr2 = PersonPostActivity.eng;
                int i = iArr2[this.eni.cUf];
                iArr3 = PersonPostActivity.cUm;
                av.a(imageView, i, iArr3[this.eni.cUf]);
                this.eni.ene = this.eni.cUf;
                PersonPostActivity personPostActivity = this.eni;
                TbPageContext pageContext = this.eni.getPageContext();
                iArr4 = PersonPostActivity.cUo;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr4[this.eni.cUf]), u.f.icon_toast_info);
                return;
            }
            this.eni.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.eni.showToast(this.eni.getPageContext().getString(u.j.neterror));
    }
}

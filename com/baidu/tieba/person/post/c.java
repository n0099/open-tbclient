package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity dEo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.dEo = personPostActivity;
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
                iArr = PersonPostActivity.coZ;
                com.baidu.tbadk.core.a.h.n(4, iArr[this.dEo.coQ]);
                imageView = this.dEo.coT;
                iArr2 = PersonPostActivity.dEm;
                int i = iArr2[this.dEo.coQ];
                iArr3 = PersonPostActivity.coX;
                at.a(imageView, i, iArr3[this.dEo.coQ]);
                this.dEo.dEk = this.dEo.coQ;
                PersonPostActivity personPostActivity = this.dEo;
                TbPageContext pageContext = this.dEo.getPageContext();
                iArr4 = PersonPostActivity.coY;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr4[this.dEo.coQ]), t.f.icon_toast_info);
                return;
            }
            this.dEo.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.dEo.showToast(this.dEo.getPageContext().getString(t.j.neterror));
    }
}

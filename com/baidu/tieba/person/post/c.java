package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity dBf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.dBf = personPostActivity;
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
                iArr = PersonPostActivity.coc;
                com.baidu.tbadk.core.a.h.n(4, iArr[this.dBf.cnT]);
                imageView = this.dBf.cnW;
                iArr2 = PersonPostActivity.coa;
                at.c(imageView, iArr2[this.dBf.cnT]);
                PersonPostActivity personPostActivity = this.dBf;
                TbPageContext pageContext = this.dBf.getPageContext();
                iArr3 = PersonPostActivity.cob;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr3[this.dBf.cnT]), t.f.icon_toast_info);
                return;
            }
            this.dBf.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.dBf.showToast(this.dBf.getPageContext().getString(t.j.neterror));
    }
}

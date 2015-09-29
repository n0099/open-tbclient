package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity crj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.crj = personPostActivity;
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
                iArr = PersonPostActivity.bFD;
                com.baidu.tbadk.core.a.h.w(4, iArr[this.crj.bFv]);
                imageView = this.crj.bFx;
                iArr2 = PersonPostActivity.bFB;
                am.c(imageView, iArr2[this.crj.bFv]);
                PersonPostActivity personPostActivity = this.crj;
                TbPageContext pageContext = this.crj.getPageContext();
                iArr3 = PersonPostActivity.bFC;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr3[this.crj.bFv]), i.e.icon_toast_info);
                return;
            }
            this.crj.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.crj.showToast(this.crj.getPageContext().getString(i.h.neterror));
    }
}

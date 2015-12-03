package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity cQD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.cQD = personPostActivity;
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
                iArr = PersonPostActivity.bVq;
                com.baidu.tbadk.core.a.h.w(4, iArr[this.cQD.bVi]);
                imageView = this.cQD.bVk;
                iArr2 = PersonPostActivity.bVo;
                as.c(imageView, iArr2[this.cQD.bVi]);
                PersonPostActivity personPostActivity = this.cQD;
                TbPageContext pageContext = this.cQD.getPageContext();
                iArr3 = PersonPostActivity.bVp;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr3[this.cQD.bVi]), n.e.icon_toast_info);
                return;
            }
            this.cQD.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.cQD.showToast(this.cQD.getPageContext().getString(n.i.neterror));
    }
}

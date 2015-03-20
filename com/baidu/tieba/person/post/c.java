package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity bRh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.bRh = personPostActivity;
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
                iArr = PersonPostActivity.blk;
                com.baidu.tbadk.core.a.j.l(4, iArr[this.bRh.blb]);
                imageView = this.bRh.ble;
                iArr2 = PersonPostActivity.bli;
                ba.c(imageView, iArr2[this.bRh.blb]);
                PersonPostActivity personPostActivity = this.bRh;
                TbPageContext pageContext = this.bRh.getPageContext();
                iArr3 = PersonPostActivity.blj;
                personPostActivity.showToastWithIcon(pageContext.getString(iArr3[this.bRh.blb]), com.baidu.tieba.u.icon_toast_info);
                return;
            }
            this.bRh.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bRh.showToast(this.bRh.getPageContext().getString(com.baidu.tieba.y.neterror));
    }
}

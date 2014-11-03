package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity bDJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.bDJ = personPostActivity;
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
                iArr = PersonPostActivity.bfM;
                com.baidu.tbadk.core.account.o.k(4, iArr[this.bDJ.bfD]);
                imageView = this.bDJ.bfG;
                iArr2 = PersonPostActivity.bfK;
                aw.c(imageView, iArr2[this.bDJ.bfD]);
                PersonPostActivity personPostActivity = this.bDJ;
                PersonPostActivity personPostActivity2 = this.bDJ;
                iArr3 = PersonPostActivity.bfL;
                personPostActivity.showToastWithIcon(personPostActivity2.getString(iArr3[this.bDJ.bfD]), com.baidu.tieba.u.icon_toast_info);
                return;
            }
            this.bDJ.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bDJ.showToast(this.bDJ.getString(com.baidu.tieba.y.neterror));
    }
}

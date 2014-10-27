package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity bDv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.bDv = personPostActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        int[] iArr;
        ImageView imageView;
        int[] iArr2;
        int[] iArr3;
        if (httpResponsedMessage.isSuccess()) {
            if (httpResponsedMessage.getError() == 0) {
                iArr = PersonPostActivity.bfy;
                com.baidu.tbadk.core.account.o.k(4, iArr[this.bDv.bfp]);
                imageView = this.bDv.bfs;
                iArr2 = PersonPostActivity.bfw;
                aw.c(imageView, iArr2[this.bDv.bfp]);
                PersonPostActivity personPostActivity = this.bDv;
                PersonPostActivity personPostActivity2 = this.bDv;
                iArr3 = PersonPostActivity.bfx;
                personPostActivity.showToastWithIcon(personPostActivity2.getString(iArr3[this.bDv.bfp]), com.baidu.tieba.u.icon_toast_info);
                return;
            }
            this.bDv.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bDv.showToast(this.bDv.getString(com.baidu.tieba.y.neterror));
    }
}

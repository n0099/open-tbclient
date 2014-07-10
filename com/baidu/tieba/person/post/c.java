package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.util.bk;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ PersonPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPostActivity personPostActivity, int i) {
        super(i);
        this.a = personPostActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        int[] iArr;
        ImageView imageView;
        int[] iArr2;
        int[] iArr3;
        if (httpResponsedMessage.isSuccess()) {
            if (httpResponsedMessage.getError() == 0) {
                iArr = PersonPostActivity.s;
                com.baidu.tbadk.core.account.o.a(4, iArr[this.a.c]);
                imageView = this.a.n;
                iArr2 = PersonPostActivity.q;
                bk.c(imageView, iArr2[this.a.c]);
                PersonPostActivity personPostActivity = this.a;
                PersonPostActivity personPostActivity2 = this.a;
                iArr3 = PersonPostActivity.r;
                personPostActivity.a(personPostActivity2.getString(iArr3[this.a.c]), com.baidu.tieba.u.icon_toast_info);
                return;
            }
            this.a.a(httpResponsedMessage.getErrorString());
        }
    }
}

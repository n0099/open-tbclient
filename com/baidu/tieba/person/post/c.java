package com.baidu.tieba.person.post;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.util.ay;
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
                iArr = PersonPostActivity.t;
                com.baidu.tbadk.core.account.o.a(4, iArr[this.a.d]);
                imageView = this.a.o;
                iArr2 = PersonPostActivity.r;
                ay.c(imageView, iArr2[this.a.d]);
                PersonPostActivity personPostActivity = this.a;
                PersonPostActivity personPostActivity2 = this.a;
                iArr3 = PersonPostActivity.s;
                personPostActivity.a(personPostActivity2.getString(iArr3[this.a.d]), com.baidu.tieba.t.icon_toast_info);
                return;
            }
            this.a.a(httpResponsedMessage.getErrorString());
            return;
        }
        this.a.a(this.a.getString(com.baidu.tieba.x.neterror));
    }
}

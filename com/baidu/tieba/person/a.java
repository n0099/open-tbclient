package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.a = basePersonInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        int[] iArr;
        int i;
        ImageView imageView;
        int[] iArr2;
        int i2;
        int[] iArr3;
        int i3;
        if (httpResponsedMessage.isSuccess()) {
            if (httpResponsedMessage.getError() == 0) {
                int s = this.a.s();
                iArr = BasePersonInfoActivity.n;
                i = this.a.g;
                com.baidu.tbadk.core.account.o.a(s, iArr[i]);
                imageView = this.a.q;
                iArr2 = BasePersonInfoActivity.l;
                i2 = this.a.g;
                com.baidu.tbadk.core.util.ay.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.a;
                BasePersonInfoActivity basePersonInfoActivity2 = this.a;
                iArr3 = BasePersonInfoActivity.m;
                i3 = this.a.g;
                basePersonInfoActivity.a(basePersonInfoActivity2.getString(iArr3[i3]), com.baidu.tieba.t.icon_toast_info);
                return;
            }
            this.a.a(httpResponsedMessage.getErrorString());
        }
    }
}

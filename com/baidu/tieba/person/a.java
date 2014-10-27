package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity bAQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.bAQ = basePersonInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
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
                int Zw = this.bAQ.Zw();
                iArr = BasePersonInfoActivity.bfy;
                i = this.bAQ.bfp;
                com.baidu.tbadk.core.account.o.k(Zw, iArr[i]);
                imageView = this.bAQ.bfs;
                iArr2 = BasePersonInfoActivity.bfw;
                i2 = this.bAQ.bfp;
                com.baidu.tbadk.core.util.aw.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.bAQ;
                BasePersonInfoActivity basePersonInfoActivity2 = this.bAQ;
                iArr3 = BasePersonInfoActivity.bfx;
                i3 = this.bAQ.bfp;
                basePersonInfoActivity.showToastWithIcon(basePersonInfoActivity2.getString(iArr3[i3]), com.baidu.tieba.u.icon_toast_info);
                return;
            }
            this.bAQ.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bAQ.showToast(this.bAQ.getString(com.baidu.tieba.y.neterror));
    }
}

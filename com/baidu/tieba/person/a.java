package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity bBe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.bBe = basePersonInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
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
                int Zz = this.bBe.Zz();
                iArr = BasePersonInfoActivity.bfM;
                i = this.bBe.bfD;
                com.baidu.tbadk.core.account.o.k(Zz, iArr[i]);
                imageView = this.bBe.bfG;
                iArr2 = BasePersonInfoActivity.bfK;
                i2 = this.bBe.bfD;
                com.baidu.tbadk.core.util.aw.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.bBe;
                BasePersonInfoActivity basePersonInfoActivity2 = this.bBe;
                iArr3 = BasePersonInfoActivity.bfL;
                i3 = this.bBe.bfD;
                basePersonInfoActivity.showToastWithIcon(basePersonInfoActivity2.getString(iArr3[i3]), com.baidu.tieba.u.icon_toast_info);
                return;
            }
            this.bBe.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bBe.showToast(this.bBe.getString(com.baidu.tieba.y.neterror));
    }
}

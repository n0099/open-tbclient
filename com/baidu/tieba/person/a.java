package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity bGD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.bGD = basePersonInfoActivity;
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
                int aaz = this.bGD.aaz();
                iArr = BasePersonInfoActivity.bkw;
                i = this.bGD.bkn;
                com.baidu.tbadk.core.account.o.n(aaz, iArr[i]);
                imageView = this.bGD.bkq;
                iArr2 = BasePersonInfoActivity.bku;
                i2 = this.bGD.bkn;
                com.baidu.tbadk.core.util.bc.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.bGD;
                TbPageContext pageContext = this.bGD.getPageContext();
                iArr3 = BasePersonInfoActivity.bkv;
                i3 = this.bGD.bkn;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr3[i3]), com.baidu.tieba.v.icon_toast_info);
                return;
            }
            this.bGD.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bGD.showToast(this.bGD.getPageContext().getString(com.baidu.tieba.z.neterror));
    }
}

package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity bGC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.bGC = basePersonInfoActivity;
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
                int aau = this.bGC.aau();
                iArr = BasePersonInfoActivity.bkv;
                i = this.bGC.bkm;
                com.baidu.tbadk.core.account.o.n(aau, iArr[i]);
                imageView = this.bGC.bkp;
                iArr2 = BasePersonInfoActivity.bkt;
                i2 = this.bGC.bkm;
                com.baidu.tbadk.core.util.bc.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.bGC;
                TbPageContext pageContext = this.bGC.getPageContext();
                iArr3 = BasePersonInfoActivity.bku;
                i3 = this.bGC.bkm;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr3[i3]), com.baidu.tieba.v.icon_toast_info);
                return;
            }
            this.bGC.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bGC.showToast(this.bGC.getPageContext().getString(com.baidu.tieba.z.neterror));
    }
}

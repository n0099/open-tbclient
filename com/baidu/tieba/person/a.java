package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity bQS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.bQS = basePersonInfoActivity;
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
                int adW = this.bQS.adW();
                iArr = BasePersonInfoActivity.boe;
                i = this.bQS.bnW;
                com.baidu.tbadk.core.a.j.l(adW, iArr[i]);
                imageView = this.bQS.bnY;
                iArr2 = BasePersonInfoActivity.boc;
                i2 = this.bQS.bnW;
                com.baidu.tbadk.core.util.ay.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.bQS;
                TbPageContext pageContext = this.bQS.getPageContext();
                iArr3 = BasePersonInfoActivity.bod;
                i3 = this.bQS.bnW;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr3[i3]), com.baidu.tieba.p.icon_toast_info);
                return;
            }
            this.bQS.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bQS.showToast(this.bQS.getPageContext().getString(com.baidu.tieba.t.neterror));
    }
}

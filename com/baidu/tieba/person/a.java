package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity bOQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.bOQ = basePersonInfoActivity;
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
                int acW = this.bOQ.acW();
                iArr = BasePersonInfoActivity.blA;
                i = this.bOQ.blr;
                com.baidu.tbadk.core.a.j.l(acW, iArr[i]);
                imageView = this.bOQ.blu;
                iArr2 = BasePersonInfoActivity.bly;
                i2 = this.bOQ.blr;
                com.baidu.tbadk.core.util.ba.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.bOQ;
                TbPageContext pageContext = this.bOQ.getPageContext();
                iArr3 = BasePersonInfoActivity.blz;
                i3 = this.bOQ.blr;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr3[i3]), com.baidu.tieba.u.icon_toast_info);
                return;
            }
            this.bOQ.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bOQ.showToast(this.bOQ.getPageContext().getString(com.baidu.tieba.y.neterror));
    }
}

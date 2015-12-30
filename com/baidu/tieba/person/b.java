package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity cNe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.cNe = basePersonInfoActivity;
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
                int aot = this.cNe.aot();
                iArr = BasePersonInfoActivity.bZc;
                i = this.cNe.bYU;
                com.baidu.tbadk.core.a.h.v(aot, iArr[i]);
                imageView = this.cNe.bYW;
                iArr2 = BasePersonInfoActivity.bZa;
                i2 = this.cNe.bYU;
                com.baidu.tbadk.core.util.as.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.cNe;
                TbPageContext pageContext = this.cNe.getPageContext();
                iArr3 = BasePersonInfoActivity.bZb;
                i3 = this.cNe.bYU;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr3[i3]), n.f.icon_toast_info);
                return;
            }
            this.cNe.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.cNe.showToast(this.cNe.getPageContext().getString(n.j.neterror));
    }
}

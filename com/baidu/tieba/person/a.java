package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity ciq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.ciq = basePersonInfoActivity;
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
                int age = this.ciq.age();
                iArr = BasePersonInfoActivity.bCz;
                i = this.ciq.bCr;
                com.baidu.tbadk.core.a.h.w(age, iArr[i]);
                imageView = this.ciq.bCt;
                iArr2 = BasePersonInfoActivity.bCx;
                i2 = this.ciq.bCr;
                com.baidu.tbadk.core.util.al.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.ciq;
                TbPageContext pageContext = this.ciq.getPageContext();
                iArr3 = BasePersonInfoActivity.bCy;
                i3 = this.ciq.bCr;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr3[i3]), i.e.icon_toast_info);
                return;
            }
            this.ciq.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.ciq.showToast(this.ciq.getPageContext().getString(i.h.neterror));
    }
}

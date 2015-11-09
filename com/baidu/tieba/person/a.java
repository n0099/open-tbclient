package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity cpt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.cpt = basePersonInfoActivity;
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
                int aiF = this.cpt.aiF();
                iArr = BasePersonInfoActivity.bGj;
                i = this.cpt.bGb;
                com.baidu.tbadk.core.a.h.w(aiF, iArr[i]);
                imageView = this.cpt.bGd;
                iArr2 = BasePersonInfoActivity.bGh;
                i2 = this.cpt.bGb;
                com.baidu.tbadk.core.util.an.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.cpt;
                TbPageContext pageContext = this.cpt.getPageContext();
                iArr3 = BasePersonInfoActivity.bGi;
                i3 = this.cpt.bGb;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr3[i3]), i.e.icon_toast_info);
                return;
            }
            this.cpt.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.cpt.showToast(this.cpt.getPageContext().getString(i.h.neterror));
    }
}

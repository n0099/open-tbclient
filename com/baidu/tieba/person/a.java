package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity cnX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.cnX = basePersonInfoActivity;
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
                int aid = this.cnX.aid();
                iArr = BasePersonInfoActivity.bFO;
                i = this.cnX.bFG;
                com.baidu.tbadk.core.a.h.w(aid, iArr[i]);
                imageView = this.cnX.bFI;
                iArr2 = BasePersonInfoActivity.bFM;
                i2 = this.cnX.bFG;
                com.baidu.tbadk.core.util.an.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.cnX;
                TbPageContext pageContext = this.cnX.getPageContext();
                iArr3 = BasePersonInfoActivity.bFN;
                i3 = this.cnX.bFG;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr3[i3]), i.e.icon_toast_info);
                return;
            }
            this.cnX.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.cnX.showToast(this.cnX.getPageContext().getString(i.h.neterror));
    }
}

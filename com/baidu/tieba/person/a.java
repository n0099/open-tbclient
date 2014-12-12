package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity bES;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.bES = basePersonInfoActivity;
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
                int ZU = this.bES.ZU();
                iArr = BasePersonInfoActivity.biZ;
                i = this.bES.biQ;
                com.baidu.tbadk.core.account.o.n(ZU, iArr[i]);
                imageView = this.bES.biT;
                iArr2 = BasePersonInfoActivity.biX;
                i2 = this.bES.biQ;
                com.baidu.tbadk.core.util.ax.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.bES;
                TbPageContext pageContext = this.bES.getPageContext();
                iArr3 = BasePersonInfoActivity.biY;
                i3 = this.bES.biQ;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr3[i3]), com.baidu.tieba.v.icon_toast_info);
                return;
            }
            this.bES.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bES.showToast(this.bES.getPageContext().getString(com.baidu.tieba.z.neterror));
    }
}

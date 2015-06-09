package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity bQT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.bQT = basePersonInfoActivity;
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
                int adX = this.bQT.adX();
                iArr = BasePersonInfoActivity.bof;
                i = this.bQT.bnX;
                com.baidu.tbadk.core.a.j.l(adX, iArr[i]);
                imageView = this.bQT.bnZ;
                iArr2 = BasePersonInfoActivity.bod;
                i2 = this.bQT.bnX;
                com.baidu.tbadk.core.util.ay.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.bQT;
                TbPageContext pageContext = this.bQT.getPageContext();
                iArr3 = BasePersonInfoActivity.boe;
                i3 = this.bQT.bnX;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr3[i3]), com.baidu.tieba.p.icon_toast_info);
                return;
            }
            this.bQT.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bQT.showToast(this.bQT.getPageContext().getString(com.baidu.tieba.t.neterror));
    }
}

package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity chw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.chw = basePersonInfoActivity;
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
                int afO = this.chw.afO();
                iArr = BasePersonInfoActivity.bBS;
                i = this.chw.bBK;
                com.baidu.tbadk.core.a.h.w(afO, iArr[i]);
                imageView = this.chw.bBM;
                iArr2 = BasePersonInfoActivity.bBQ;
                i2 = this.chw.bBK;
                com.baidu.tbadk.core.util.al.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.chw;
                TbPageContext pageContext = this.chw.getPageContext();
                iArr3 = BasePersonInfoActivity.bBR;
                i3 = this.chw.bBK;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr3[i3]), i.e.icon_toast_info);
                return;
            }
            this.chw.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.chw.showToast(this.chw.getPageContext().getString(i.C0057i.neterror));
    }
}

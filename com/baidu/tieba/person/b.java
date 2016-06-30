package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity ecN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.ecN = basePersonInfoActivity;
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
        int[] iArr4;
        int i4;
        if (httpResponsedMessage.isSuccess()) {
            if (httpResponsedMessage.getError() == 0) {
                int aKi = this.ecN.aKi();
                iArr = BasePersonInfoActivity.cUp;
                i = this.ecN.cUf;
                com.baidu.tbadk.core.a.h.n(aKi, iArr[i]);
                imageView = this.ecN.cUi;
                iArr2 = BasePersonInfoActivity.ecK;
                i2 = this.ecN.cUf;
                int i5 = iArr2[i2];
                iArr3 = BasePersonInfoActivity.cUm;
                i3 = this.ecN.cUf;
                com.baidu.tbadk.core.util.av.a(imageView, i5, iArr3[i3]);
                BasePersonInfoActivity basePersonInfoActivity = this.ecN;
                TbPageContext pageContext = this.ecN.getPageContext();
                iArr4 = BasePersonInfoActivity.cUo;
                i4 = this.ecN.cUf;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr4[i4]), u.f.icon_toast_info);
                return;
            }
            this.ecN.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.ecN.showToast(this.ecN.getPageContext().getString(u.j.neterror));
    }
}

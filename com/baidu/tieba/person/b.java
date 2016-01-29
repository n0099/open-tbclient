package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity cWy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.cWy = basePersonInfoActivity;
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
                int atk = this.cWy.atk();
                iArr = BasePersonInfoActivity.cdx;
                i = this.cWy.cdo;
                com.baidu.tbadk.core.a.h.r(atk, iArr[i]);
                imageView = this.cWy.cdr;
                iArr2 = BasePersonInfoActivity.cdv;
                i2 = this.cWy.cdo;
                com.baidu.tbadk.core.util.ar.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.cWy;
                TbPageContext pageContext = this.cWy.getPageContext();
                iArr3 = BasePersonInfoActivity.cdw;
                i3 = this.cWy.cdo;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr3[i3]), t.f.icon_toast_info);
                return;
            }
            this.cWy.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.cWy.showToast(this.cWy.getPageContext().getString(t.j.neterror));
    }
}

package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity cnM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.cnM = basePersonInfoActivity;
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
                int aid = this.cnM.aid();
                iArr = BasePersonInfoActivity.bFD;
                i = this.cnM.bFv;
                com.baidu.tbadk.core.a.h.w(aid, iArr[i]);
                imageView = this.cnM.bFx;
                iArr2 = BasePersonInfoActivity.bFB;
                i2 = this.cnM.bFv;
                com.baidu.tbadk.core.util.am.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.cnM;
                TbPageContext pageContext = this.cnM.getPageContext();
                iArr3 = BasePersonInfoActivity.bFC;
                i3 = this.cnM.bFv;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr3[i3]), i.e.icon_toast_info);
                return;
            }
            this.cnM.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.cnM.showToast(this.cnM.getPageContext().getString(i.h.neterror));
    }
}

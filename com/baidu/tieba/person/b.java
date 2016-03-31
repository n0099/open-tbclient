package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity dra;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.dra = basePersonInfoActivity;
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
                int aAQ = this.dra.aAQ();
                iArr = BasePersonInfoActivity.coc;
                i = this.dra.cnT;
                com.baidu.tbadk.core.a.h.n(aAQ, iArr[i]);
                imageView = this.dra.cnW;
                iArr2 = BasePersonInfoActivity.coa;
                i2 = this.dra.cnT;
                com.baidu.tbadk.core.util.at.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.dra;
                TbPageContext pageContext = this.dra.getPageContext();
                iArr3 = BasePersonInfoActivity.cob;
                i3 = this.dra.cnT;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr3[i3]), t.f.icon_toast_info);
                return;
            }
            this.dra.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.dra.showToast(this.dra.getPageContext().getString(t.j.neterror));
    }
}

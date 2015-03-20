package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity bOA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.bOA = basePersonInfoActivity;
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
                int acH = this.bOA.acH();
                iArr = BasePersonInfoActivity.blk;
                i = this.bOA.blb;
                com.baidu.tbadk.core.a.j.l(acH, iArr[i]);
                imageView = this.bOA.ble;
                iArr2 = BasePersonInfoActivity.bli;
                i2 = this.bOA.blb;
                com.baidu.tbadk.core.util.ba.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.bOA;
                TbPageContext pageContext = this.bOA.getPageContext();
                iArr3 = BasePersonInfoActivity.blj;
                i3 = this.bOA.blb;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr3[i3]), com.baidu.tieba.u.icon_toast_info);
                return;
            }
            this.bOA.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.bOA.showToast(this.bOA.getPageContext().getString(com.baidu.tieba.y.neterror));
    }
}

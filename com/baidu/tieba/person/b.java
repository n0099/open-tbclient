package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity cIO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.cIO = basePersonInfoActivity;
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
                int ani = this.cIO.ani();
                iArr = BasePersonInfoActivity.bVq;
                i = this.cIO.bVi;
                com.baidu.tbadk.core.a.h.w(ani, iArr[i]);
                imageView = this.cIO.bVk;
                iArr2 = BasePersonInfoActivity.bVo;
                i2 = this.cIO.bVi;
                com.baidu.tbadk.core.util.as.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.cIO;
                TbPageContext pageContext = this.cIO.getPageContext();
                iArr3 = BasePersonInfoActivity.bVp;
                i3 = this.cIO.bVi;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr3[i3]), n.e.icon_toast_info);
                return;
            }
            this.cIO.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.cIO.showToast(this.cIO.getPageContext().getString(n.i.neterror));
    }
}

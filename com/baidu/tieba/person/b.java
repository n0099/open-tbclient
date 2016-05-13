package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ BasePersonInfoActivity duv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BasePersonInfoActivity basePersonInfoActivity, int i) {
        super(i);
        this.duv = basePersonInfoActivity;
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
                int aBq = this.duv.aBq();
                iArr = BasePersonInfoActivity.coZ;
                i = this.duv.coQ;
                com.baidu.tbadk.core.a.h.n(aBq, iArr[i]);
                imageView = this.duv.coT;
                iArr2 = BasePersonInfoActivity.coX;
                i2 = this.duv.coQ;
                com.baidu.tbadk.core.util.at.c(imageView, iArr2[i2]);
                BasePersonInfoActivity basePersonInfoActivity = this.duv;
                TbPageContext pageContext = this.duv.getPageContext();
                iArr3 = BasePersonInfoActivity.coY;
                i3 = this.duv.coQ;
                basePersonInfoActivity.showToastWithIcon(pageContext.getString(iArr3[i3]), t.f.icon_toast_info);
                return;
            }
            this.duv.showToast(httpResponsedMessage.getErrorString());
            return;
        }
        this.duv.showToast(this.duv.getPageContext().getString(t.j.neterror));
    }
}

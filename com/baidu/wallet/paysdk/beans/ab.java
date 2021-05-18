package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.ui.widget.FeedbackDialog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ab extends PayBaseBean<Object> {

    /* renamed from: a  reason: collision with root package name */
    public String f25187a;

    /* renamed from: b  reason: collision with root package name */
    public FeedbackDialog.c f25188b;

    public ab(Context context) {
        super(context);
    }

    public void a(String str, FeedbackDialog.c cVar) {
        this.f25187a = str;
        this.f25188b = cVar;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(String.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("trans_no", this.f25187a));
        arrayList.add(new RestNameValuePair("score", "" + this.f25188b.f26123a));
        FeedbackDialog.c cVar = this.f25188b;
        arrayList.add(new RestNameValuePair("tag_list", a(cVar != null ? cVar.f26124b : null)));
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_SAVE_FEEDBACK;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_SAVE_FEEDBACK;
    }

    public String a(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null && strArr.length > 0) {
            sb.append(strArr[0]);
            for (int i2 = 1; i2 < strArr.length; i2++) {
                sb.append(",");
                sb.append(strArr[i2]);
            }
            sb = new StringBuilder("[" + ((Object) sb) + "]");
        }
        return sb.toString();
    }
}

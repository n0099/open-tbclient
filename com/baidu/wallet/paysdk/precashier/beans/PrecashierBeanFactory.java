package com.baidu.wallet.paysdk.precashier.beans;

import android.content.Context;
import com.baidu.apollon.beans.ApollonBean;
import com.baidu.apollon.beans.IBeanFactory;
import com.baidu.wallet.core.beans.BeanManager;
/* loaded from: classes5.dex */
public class PrecashierBeanFactory implements IBeanFactory {
    public static final int BEAN_ID_PRECASHIER_GET_DEFAULT_PAY_TYPE = 1;
    public static final int BEAN_ID_PRECASHIER_MODIFY_PAY_TYPE = 2;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static PrecashierBeanFactory f25360a = new PrecashierBeanFactory();
    }

    public static PrecashierBeanFactory getInstance() {
        return a.f25360a;
    }

    @Override // com.baidu.apollon.beans.IBeanFactory
    public ApollonBean<?> getBean(Context context, int i2, String str) {
        Context applicationContext = context.getApplicationContext();
        if (i2 == 1) {
            return new PrecashierDefaultPayTypeBean(applicationContext);
        }
        PrecashierModifyPayTypeBean precashierModifyPayTypeBean = i2 == 2 ? new PrecashierModifyPayTypeBean(applicationContext) : null;
        if (precashierModifyPayTypeBean != null) {
            BeanManager.getInstance().addBean(str, precashierModifyPayTypeBean);
        }
        return precashierModifyPayTypeBean;
    }

    public PrecashierBeanFactory() {
    }
}

package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.apollon.beans.IBeanFactory;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.beans.BeanManager;
/* loaded from: classes5.dex */
public final class SecuityBeanFactory implements IBeanFactory {
    public static final int BEAN_ID_SECUITY_BEAN = 1;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static SecuityBeanFactory f25467a = new SecuityBeanFactory();
    }

    public static SecuityBeanFactory getInstance() {
        return a.f25467a;
    }

    public SecuityBeanFactory() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.apollon.beans.IBeanFactory
    public BaseBean<?> getBean(Context context, int i, String str) {
        SecuityCenterBean secuityCenterBean = i != 1 ? null : new SecuityCenterBean(context);
        if (secuityCenterBean != null) {
            BeanManager.getInstance().addBean(str, secuityCenterBean);
        }
        return secuityCenterBean;
    }
}

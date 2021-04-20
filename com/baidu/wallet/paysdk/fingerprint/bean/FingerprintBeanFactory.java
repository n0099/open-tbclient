package com.baidu.wallet.paysdk.fingerprint.bean;

import android.content.Context;
import com.baidu.apollon.beans.IBeanFactory;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.beans.BeanManager;
/* loaded from: classes5.dex */
public final class FingerprintBeanFactory implements IBeanFactory {
    public static final int BEAN_ID_SYS_FINGERPRINT_CLOSE = 773;
    public static final int BEAN_ID_SYS_FINGERPRINT_OPEN = 772;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static FingerprintBeanFactory f25323a = new FingerprintBeanFactory();
    }

    public static FingerprintBeanFactory getInstance() {
        return a.f25323a;
    }

    public FingerprintBeanFactory() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    @Override // com.baidu.apollon.beans.IBeanFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BaseBean<?> getBean(Context context, int i, String str) {
        BaseBean<?> bVar;
        BaseBean<?> baseBean;
        if (i == 772) {
            bVar = new b(context);
        } else if (i != 773) {
            baseBean = null;
            if (baseBean != null) {
                BeanManager.getInstance().addBean(str, baseBean);
            }
            return baseBean;
        } else {
            bVar = new com.baidu.wallet.paysdk.fingerprint.bean.a(context);
        }
        baseBean = bVar;
        if (baseBean != null) {
        }
        return baseBean;
    }
}

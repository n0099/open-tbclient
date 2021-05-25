package com.baidu.wallet.base.iddetect.beans;

import android.content.Context;
import com.baidu.apollon.beans.IBeanFactory;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.beans.BeanManager;
/* loaded from: classes5.dex */
public final class IDDetectBeanFactory implements IBeanFactory {
    public static final int BEAN_ID_ID_DETECT = 57345;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static IDDetectBeanFactory f23233a = new IDDetectBeanFactory();
    }

    public static IDDetectBeanFactory getInstance() {
        return a.f23233a;
    }

    public IDDetectBeanFactory() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.apollon.beans.IBeanFactory
    public BaseBean<?> getBean(Context context, int i2, String str) {
        com.baidu.wallet.base.iddetect.beans.a aVar = i2 != 57345 ? null : new com.baidu.wallet.base.iddetect.beans.a(context);
        if (aVar != null) {
            BeanManager.getInstance().addBean(str, aVar);
        }
        return aVar;
    }
}

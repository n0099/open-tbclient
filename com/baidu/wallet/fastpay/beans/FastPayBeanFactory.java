package com.baidu.wallet.fastpay.beans;

import android.content.Context;
import com.baidu.apollon.beans.IBeanFactory;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.beans.BeanManager;
/* loaded from: classes5.dex */
public final class FastPayBeanFactory implements IBeanFactory {
    public static final int BEAN_ID_BIND_INFO = 45316;
    public static final int BEAN_ID_CHARGE_RESULT_BANNER = 45317;
    public static final int BEAN_ID_GET_ORDER = 45314;
    public static final int BEAN_ID_PROMOTION_INFO = 45315;
    public static final int BEAN_ID_QUERY_LOCATION = 45313;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static FastPayBeanFactory f24039a = new FastPayBeanFactory();
    }

    public static FastPayBeanFactory getInstance() {
        return a.f24039a;
    }

    public FastPayBeanFactory() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.apollon.beans.IBeanFactory
    public BaseBean<?> getBean(Context context, int i, String str) {
        BaseBean<?> dVar;
        switch (i) {
            case BEAN_ID_QUERY_LOCATION /* 45313 */:
                dVar = new d(context);
                break;
            case BEAN_ID_GET_ORDER /* 45314 */:
                dVar = new b(context);
                break;
            case BEAN_ID_PROMOTION_INFO /* 45315 */:
                dVar = new c(context);
                break;
            case BEAN_ID_BIND_INFO /* 45316 */:
                dVar = new com.baidu.wallet.fastpay.beans.a(context);
                break;
            default:
                dVar = null;
                break;
        }
        if (dVar != null) {
            BeanManager.getInstance().addBean(str, dVar);
        }
        return dVar;
    }
}

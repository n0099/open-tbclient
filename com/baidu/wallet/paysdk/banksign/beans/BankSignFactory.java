package com.baidu.wallet.paysdk.banksign.beans;

import android.content.Context;
import com.baidu.apollon.beans.IBeanFactory;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.beans.BeanManager;
/* loaded from: classes5.dex */
public final class BankSignFactory implements IBeanFactory {
    public static final int BEAN_ID_BIND_CARD = 771;
    public static final int BEAN_ID_GET_JUMP_URL = 768;
    public static final int BEAN_ID_POLLING = 769;
    public static final int BEAN_ID_QUERY = 770;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static BankSignFactory f25921a = new BankSignFactory();
    }

    public static BankSignFactory getInstance() {
        return a.f25921a;
    }

    public BankSignFactory() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.apollon.beans.IBeanFactory
    public BaseBean<?> getBean(Context context, int i2, String str) {
        BaseBean<?> bVar;
        Context applicationContext = context.getApplicationContext();
        switch (i2) {
            case 768:
                bVar = new b(applicationContext);
                break;
            case BEAN_ID_POLLING /* 769 */:
                bVar = new c(applicationContext);
                break;
            case BEAN_ID_QUERY /* 770 */:
                bVar = new d(applicationContext);
                break;
            case BEAN_ID_BIND_CARD /* 771 */:
                bVar = new com.baidu.wallet.paysdk.banksign.beans.a(applicationContext);
                break;
            default:
                bVar = null;
                break;
        }
        if (bVar != null) {
            BeanManager.getInstance().addBean(str, bVar);
        }
        return bVar;
    }
}

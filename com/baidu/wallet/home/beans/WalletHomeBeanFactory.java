package com.baidu.wallet.home.beans;

import android.content.Context;
import com.baidu.apollon.beans.IBeanFactory;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.beans.BeanManager;
/* loaded from: classes5.dex */
public final class WalletHomeBeanFactory implements IBeanFactory {
    public static final int BEAN_ID_HOMETAB = 49158;
    public static final int BEAN_ID_HOME_CFG = 49157;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static WalletHomeBeanFactory f24529a = new WalletHomeBeanFactory();
    }

    public static WalletHomeBeanFactory getInstance() {
        return a.f24529a;
    }

    public WalletHomeBeanFactory() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.apollon.beans.IBeanFactory
    public BaseBean<?> getBean(Context context, int i, String str) {
        BaseBean<?> homeCfgBean;
        switch (i) {
            case BEAN_ID_HOME_CFG /* 49157 */:
                homeCfgBean = new HomeCfgBean(context);
                break;
            case BEAN_ID_HOMETAB /* 49158 */:
                homeCfgBean = new HomeTabBean(context);
                break;
            default:
                homeCfgBean = null;
                break;
        }
        if (homeCfgBean != null) {
            BeanManager.getInstance().addBean(str, homeCfgBean);
        }
        return homeCfgBean;
    }
}

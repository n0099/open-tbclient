package com.baidu.wallet.qrcodescanner.beans;

import android.content.Context;
import com.baidu.apollon.beans.IBeanFactory;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.beans.BeanManager;
/* loaded from: classes5.dex */
public final class QRCodeScannerBeanFactory implements IBeanFactory {
    public static final int QRCODE_SHORT_URL = 2561;
    public static final int QRCODE_WHITE_LIST = 2560;

    /* renamed from: a  reason: collision with root package name */
    public static QRCodeScannerBeanFactory f27257a;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static QRCodeScannerBeanFactory f27258a = new QRCodeScannerBeanFactory();
    }

    public static QRCodeScannerBeanFactory getInstance() {
        return a.f27258a;
    }

    public QRCodeScannerBeanFactory() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    @Override // com.baidu.apollon.beans.IBeanFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BaseBean<?> getBean(Context context, int i2, String str) {
        BaseBean<?> bVar;
        BaseBean<?> baseBean;
        if (i2 == 2560) {
            bVar = new b(context);
        } else if (i2 != 2561) {
            baseBean = null;
            if (baseBean != null) {
                BeanManager.getInstance().addBean(str, baseBean);
            }
            return baseBean;
        } else {
            bVar = new com.baidu.wallet.qrcodescanner.beans.a(context);
        }
        baseBean = bVar;
        if (baseBean != null) {
        }
        return baseBean;
    }
}

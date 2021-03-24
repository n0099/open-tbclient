package com.baidu.wallet.personal.beans;

import android.content.Context;
import com.baidu.apollon.beans.IBeanFactory;
import com.baidu.mapapi.UIMsg;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.beans.BeanManager;
/* loaded from: classes5.dex */
public final class b implements IBeanFactory {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static b f26553a = new b();
    }

    public b() {
    }

    public static b a() {
        return a.f26553a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.apollon.beans.IBeanFactory
    /* renamed from: a */
    public BaseBean<?> getBean(Context context, int i, String str) {
        BaseBean<?> dVar;
        switch (i) {
            case 515:
                dVar = new d(context);
                break;
            case 516:
                dVar = new c(context);
                break;
            case 517:
                dVar = new QueryHceTransRecordsBean(context);
                break;
            case UIMsg.m_AppUI.MSG_COMPASS_DISPLAY /* 518 */:
            default:
                dVar = null;
                break;
            case UIMsg.m_AppUI.MSG_SET_SENSOR_STATUS /* 519 */:
                dVar = new com.baidu.wallet.personal.beans.a(context);
                break;
        }
        if (dVar != null) {
            BeanManager.getInstance().addBean(str, dVar);
        }
        return dVar;
    }
}

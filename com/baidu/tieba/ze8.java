package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes6.dex */
public interface ze8 extends IAdBaseAsyncController {

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i);
    }

    void a(TbPageContext tbPageContext);

    void c(AdvertAppInfo advertAppInfo, boolean z);

    ae8 i(AdvertAppInfo advertAppInfo);

    void loadAd();

    void m(AdvertAppInfo advertAppInfo);
}

package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes5.dex */
public interface jb9 extends IAdBaseAsyncController {

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i);
    }

    void a(TbPageContext<BaseFragmentActivity> tbPageContext);

    void c(AdvertAppInfo advertAppInfo, boolean z);

    @Nullable
    ka9 i(AdvertAppInfo advertAppInfo);

    void loadAd();

    void m(AdvertAppInfo advertAppInfo);
}

package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public interface tha {
    ci<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    oha b();

    void c(AdvertAppInfo advertAppInfo, mg9<?> mg9Var, String str, String str2, int i, int i2);

    jha d();

    ci<?, ?> e(sha shaVar, BdUniqueId bdUniqueId);

    void f();

    List<AdvertAppInfo> g();

    ci<?, ?> h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str);

    IAdBaseAsyncController i(@NonNull IAdBaseAsyncController.Type type, @Nullable IAdBaseAsyncController.a aVar);

    qha j();

    void k(AdvertAppInfo advertAppInfo);

    void l(HashMap<String, String> hashMap, Context context);
}

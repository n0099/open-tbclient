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
public interface sha {
    ci<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    nha b();

    void c(AdvertAppInfo advertAppInfo, lg9<?> lg9Var, String str, String str2, int i, int i2);

    iha d();

    ci<?, ?> e(rha rhaVar, BdUniqueId bdUniqueId);

    void f();

    List<AdvertAppInfo> g();

    ci<?, ?> h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str);

    IAdBaseAsyncController i(@NonNull IAdBaseAsyncController.Type type, @Nullable IAdBaseAsyncController.a aVar);

    pha j();

    void k(AdvertAppInfo advertAppInfo);

    void l(HashMap<String, String> hashMap, Context context);
}

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
/* loaded from: classes7.dex */
public interface ry9 {
    ln<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    my9 b();

    void c(AdvertAppInfo advertAppInfo, p09<?> p09Var, String str, String str2, int i, int i2);

    hy9 d();

    ln<?, ?> e(qy9 qy9Var, BdUniqueId bdUniqueId);

    void f();

    List<AdvertAppInfo> g();

    ln<?, ?> h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str);

    IAdBaseAsyncController i(@NonNull IAdBaseAsyncController.Type type, @Nullable IAdBaseAsyncController.a aVar);

    oy9 j();

    void k(AdvertAppInfo advertAppInfo);

    void l(HashMap<String, String> hashMap, Context context);
}

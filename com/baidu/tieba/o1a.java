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
public interface o1a {
    om<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    j1a b();

    void c(AdvertAppInfo advertAppInfo, o29<?> o29Var, String str, String str2, int i, int i2);

    e1a d();

    om<?, ?> e(n1a n1aVar, BdUniqueId bdUniqueId);

    void f();

    List<AdvertAppInfo> g();

    om<?, ?> h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str);

    IAdBaseAsyncController i(@NonNull IAdBaseAsyncController.Type type, @Nullable IAdBaseAsyncController.a aVar);

    l1a j();

    void k(AdvertAppInfo advertAppInfo);

    void l(HashMap<String, String> hashMap, Context context);
}

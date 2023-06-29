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
/* loaded from: classes6.dex */
public interface ks9 {
    kn<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    fs9 b();

    as9 c();

    kn<?, ?> d(js9 js9Var, BdUniqueId bdUniqueId);

    void e();

    List<AdvertAppInfo> f();

    kn<?, ?> g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str);

    IAdBaseAsyncController h(@NonNull IAdBaseAsyncController.Type type, @Nullable IAdBaseAsyncController.a aVar);

    hs9 i();

    void j(AdvertAppInfo advertAppInfo);

    void k(HashMap<String, String> hashMap, Context context);
}

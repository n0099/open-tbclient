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
public interface zd8 {
    qn<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    ud8 b();

    pd8 c();

    qn<?, ?> d(yd8 yd8Var, BdUniqueId bdUniqueId);

    void e();

    List<AdvertAppInfo> f();

    qn<?, ?> g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str);

    IAdBaseAsyncController h(@NonNull IAdBaseAsyncController.Type type, @Nullable IAdBaseAsyncController.a aVar);

    wd8 i();

    void j(AdvertAppInfo advertAppInfo);

    void k(HashMap<String, String> hashMap, Context context);
}

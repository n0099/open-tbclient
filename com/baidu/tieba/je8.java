package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public interface je8 {
    rn a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    ee8 b();

    zd8 c();

    rn d(ie8 ie8Var, BdUniqueId bdUniqueId);

    void e();

    List f();

    rn g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str);

    IAdBaseAsyncController h(IAdBaseAsyncController.Type type, IAdBaseAsyncController.a aVar);

    ge8 i();

    void j(AdvertAppInfo advertAppInfo);

    void k(HashMap hashMap, Context context);
}

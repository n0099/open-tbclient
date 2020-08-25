package com.baidu.tieba.recapp;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.List;
/* loaded from: classes2.dex */
public interface o {
    com.baidu.adp.widget.ListView.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    com.baidu.adp.widget.ListView.a<?, ?> a(n nVar, BdUniqueId bdUniqueId);

    void a(AdvertAppInfo advertAppInfo, Context context);

    void a(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5);

    com.baidu.adp.widget.ListView.a<?, ?> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId);

    j dnb();

    l dnc();

    com.baidu.tieba.r.a dnd();

    g dne();

    List<AppData> dnf();

    void dng();

    void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4);
}

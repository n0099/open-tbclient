package com.baidu.tieba.recapp;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.List;
/* loaded from: classes.dex */
public interface q {
    com.baidu.adp.widget.ListView.a<?, ?> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str);

    com.baidu.adp.widget.ListView.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    com.baidu.adp.widget.ListView.a<?, ?> a(p pVar, BdUniqueId bdUniqueId);

    h a(TbPageContext<?> tbPageContext, AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2);

    void a(AdvertAppInfo advertAppInfo, Context context);

    void a(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5);

    l dEP();

    n dEQ();

    com.baidu.tieba.r.a dER();

    i dES();

    List<AppData> dET();

    void dEU();

    void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4);
}

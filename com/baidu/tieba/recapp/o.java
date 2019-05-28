package com.baidu.tieba.recapp;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.List;
/* loaded from: classes.dex */
public interface o {
    com.baidu.adp.widget.ListView.a<?, ?> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId);

    com.baidu.adp.widget.ListView.a<?, ?> a(n nVar, BdUniqueId bdUniqueId);

    void a(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5);

    com.baidu.adp.widget.ListView.a<?, ?> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId);

    j ceF();

    l ceG();

    com.baidu.tieba.p.a ceH();

    h ceI();

    List<AppData> ceJ();

    void ceK();

    void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4);
}

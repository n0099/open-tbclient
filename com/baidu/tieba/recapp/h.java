package com.baidu.tieba.recapp;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.List;
/* loaded from: classes.dex */
public interface h {
    a<?, ?> a(g gVar, BdUniqueId bdUniqueId);

    void a(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5);

    e aYe();

    com.baidu.adp.widget.ListView.a<?, ?> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId);

    com.baidu.adp.widget.ListView.a<?, ?> c(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId);

    void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4);
}

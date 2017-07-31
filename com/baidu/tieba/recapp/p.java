package com.baidu.tieba.recapp;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.List;
/* loaded from: classes.dex */
public interface p {
    a<?, ?> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId);

    a<?, ?> a(o oVar, BdUniqueId bdUniqueId);

    void a(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5);

    h bI(Context context);

    k bhB();

    m bhC();

    com.baidu.tieba.k.a bhD();

    i bhE();

    com.baidu.adp.widget.ListView.a<?, ?> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId);

    void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4);
}

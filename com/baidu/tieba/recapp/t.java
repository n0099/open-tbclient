package com.baidu.tieba.recapp;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.List;
/* loaded from: classes.dex */
public interface t {
    a<?, ?> a(s sVar, BdUniqueId bdUniqueId);

    void a(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5);

    com.baidu.adp.widget.ListView.a<?, ?> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId);

    n bI(Context context);

    p baN();

    q baO();

    com.baidu.tieba.h.a baP();

    com.baidu.adp.widget.ListView.a<?, ?> c(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId);

    void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4);
}

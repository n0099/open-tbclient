package com.baidu.tieba.lego.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.c.e;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements a {
    public static final AtomicReference<a> hiO = new AtomicReference<>(null);
    private static final a hiP = new b();

    private b() {
    }

    public static a bLD() {
        a aVar = hiO.get();
        return aVar == null ? hiP : aVar;
    }

    @Override // com.baidu.tieba.lego.d.a
    public com.baidu.tieba.lego.model.a b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        BdLog.e("Card project loaded failed.");
        return null;
    }

    @Override // com.baidu.tieba.lego.d.a
    public com.baidu.tieba.lego.c.a a(e eVar) {
        BdLog.e("Card project loaded failed.");
        return null;
    }

    @Override // com.baidu.tieba.lego.d.a
    public com.baidu.tieba.lego.card.a.a a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i) {
        BdLog.e("Card project loaded failed.");
        return null;
    }
}

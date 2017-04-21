package com.baidu.tieba.lego.g;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.d.e;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements a {
    public static final AtomicReference<a> dAN = new AtomicReference<>(null);
    private static final a dAO = new b();

    private b() {
    }

    public static a aAt() {
        a aVar = dAN.get();
        return aVar == null ? dAO : aVar;
    }

    @Override // com.baidu.tieba.lego.g.a
    public com.baidu.tieba.lego.model.a a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        BdLog.e("Card project loaded failed.");
        return null;
    }

    @Override // com.baidu.tieba.lego.g.a
    public com.baidu.tieba.lego.d.a a(e eVar) {
        BdLog.e("Card project loaded failed.");
        return null;
    }

    @Override // com.baidu.tieba.lego.g.a
    public com.baidu.tieba.lego.card.a.a a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i) {
        BdLog.e("Card project loaded failed.");
        return null;
    }
}

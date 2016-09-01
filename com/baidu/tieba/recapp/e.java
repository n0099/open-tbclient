package com.baidu.tieba.recapp;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class e implements c {
    public static final AtomicReference<c> faq = new AtomicReference<>(null);
    private static final c far = new e();

    public static c bbp() {
        c cVar = faq.get();
        return cVar == null ? far : cVar;
    }

    @Override // com.baidu.tieba.recapp.c
    public com.baidu.adp.widget.ListView.a<?, ?> a(b bVar, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.c
    public com.baidu.adp.widget.ListView.a<?, ?> c(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.c
    public com.baidu.adp.widget.ListView.a<?, ?> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }
}

package com.baidu.tieba.tbluncher;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class p extends com.baidu.adp.framework.c.a {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* bridge */ /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        Object a = customResponsedMessage.a();
        if (a instanceof Activity) {
            com.baidu.tbadk.core.d.b.a((Activity) a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i) {
        super(2001004);
    }
}

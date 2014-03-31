package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class l extends com.baidu.adp.framework.c.a {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 != null) {
            switch (customResponsedMessage2.g()) {
                case 2005009:
                    r.c();
                    r.M();
                    return;
                case 2005010:
                    r.c();
                    r.N();
                    return;
                case 2005011:
                    r.c();
                    r.O();
                    return;
                case 2005012:
                    r.c();
                    r.P();
                    return;
                case 2005013:
                    r.c();
                    r.L();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(int i) {
        super(0);
    }
}

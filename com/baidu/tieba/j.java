package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class j extends com.baidu.adp.framework.c.a {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 != null) {
            switch (customResponsedMessage2.g()) {
                case 2005009:
                    p.c();
                    p.I();
                    return;
                case 2005010:
                    p.c();
                    p.J();
                    return;
                case 2005011:
                    p.c();
                    p.K();
                    return;
                case 2005012:
                    p.c();
                    p.L();
                    return;
                case 2005013:
                    p.c();
                    p.H();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(int i) {
        super(0);
    }
}

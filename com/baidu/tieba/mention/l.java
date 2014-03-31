package com.baidu.tieba.mention;

import android.support.v4.app.Fragment;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends com.baidu.adp.framework.c.a {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(k kVar, int i) {
        super(2008002);
        this.a = kVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.d[] dVarArr;
        Object a;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        Fragment fragment = (customResponsedMessage2 == null || (a = customResponsedMessage2.a()) == null || !(a instanceof Fragment)) ? null : (Fragment) a;
        if (fragment != null) {
            this.a.a = new com.baidu.tbadk.core.d[]{(com.baidu.tbadk.core.d) fragment, new af(), new a()};
            this.a.b = new int[]{0, 1, 2};
        } else {
            this.a.a = new com.baidu.tbadk.core.d[]{new af(), new a()};
            this.a.b = new int[]{1, 2};
        }
        k kVar = this.a;
        dVarArr = this.a.a;
        kVar.c = dVarArr.length;
    }
}

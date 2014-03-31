package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
final class w extends com.baidu.adp.framework.c.a {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(SquareSearchActivity squareSearchActivity, int i) {
        super(2009001);
        this.a = squareSearchActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* bridge */ /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        Object a;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null || (a = customResponsedMessage2.a()) == null || !(a instanceof ArrayList)) {
            return;
        }
        this.a.a(false, (ArrayList<String>) a);
    }
}

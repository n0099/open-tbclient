package com.baidu.tieba.tbean;

import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements LinearLayoutDetectsSoftKeyboard.a {
    final /* synthetic */ j eav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.eav = jVar;
    }

    @Override // com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard.a
    public void eB(boolean z) {
        this.eav.eao = z;
    }
}

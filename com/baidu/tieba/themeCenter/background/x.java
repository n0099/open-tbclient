package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.widget.ListView.BdExpandImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ w dhE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.dhE = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        BdExpandImageView bdExpandImageView;
        if (aVar != null) {
            bdExpandImageView = this.dhE.dhz;
            aVar.a(bdExpandImageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void aj(String str) {
        super.aj(str);
    }
}

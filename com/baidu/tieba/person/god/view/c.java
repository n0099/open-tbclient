package com.baidu.tieba.person.god.view;

import com.baidu.adp.widget.ListView.BdExpandImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ a dxV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.dxV = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        BdExpandImageView bdExpandImageView;
        if (aVar != null) {
            bdExpandImageView = this.dxV.dxB;
            aVar.a(bdExpandImageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void ao(String str) {
        super.ao(str);
    }
}

package com.baidu.tieba.personInfo;

import com.baidu.adp.widget.ListView.BdExpandImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ bc dji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar) {
        this.dji = bcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        BdExpandImageView bdExpandImageView;
        if (aVar != null) {
            bdExpandImageView = this.dji.diK;
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
    public void am(String str) {
        super.am(str);
    }
}

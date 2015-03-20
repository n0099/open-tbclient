package com.baidu.tieba.tbadkCore.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = a.cnx;
        if (dVar != null) {
            dVar2 = a.cnx;
            dVar2.dismiss();
        }
    }
}

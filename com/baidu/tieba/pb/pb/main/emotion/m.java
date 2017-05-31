package com.baidu.tieba.pb.pb.main.emotion;

import android.text.TextUtils;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ l evI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.evI = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Set set;
        Set<String> set2;
        set = this.evI.evG;
        if (set != null) {
            set2 = this.evI.evG;
            for (String str : set2) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.imageManager.c.DH().fI(str);
                }
            }
        }
    }
}

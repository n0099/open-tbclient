package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg implements Runnable {
    final /* synthetic */ df dmk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(df dfVar) {
        this.dmk = dfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        PbActivity pbActivity;
        view = this.dmk.dmf;
        pbActivity = this.dmk.dic;
        view.setBackgroundColor(pbActivity.getResources().getColor(t.d.black_alpha30));
    }
}

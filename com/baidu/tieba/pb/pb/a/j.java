package com.baidu.tieba.pb.pb.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    private final /* synthetic */ String bHb;
    private final /* synthetic */ String cQi;
    final /* synthetic */ h eeL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, String str, String str2) {
        this.eeL = hVar;
        this.cQi = str;
        this.bHb = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eeL.nA(this.cQi);
        TiebaStatic.log(new as("c12041").aa("fid", this.bHb));
    }
}

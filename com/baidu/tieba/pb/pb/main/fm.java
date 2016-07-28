package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fm implements View.OnClickListener {
    final /* synthetic */ ew eiu;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(ew ewVar, String str) {
        this.eiu = ewVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        if (!com.baidu.adp.lib.util.k.fH()) {
            pbActivity = this.eiu.eat;
            pbActivity.showToast(u.j.neterror);
            return;
        }
        com.baidu.tbadk.core.util.bi us = com.baidu.tbadk.core.util.bi.us();
        pbActivity2 = this.eiu.eat;
        us.c(pbActivity2.getPageContext(), new String[]{this.val$url});
        pbActivity3 = this.eiu.eat;
        pbActivity3.finish();
    }
}

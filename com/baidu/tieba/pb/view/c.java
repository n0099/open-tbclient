package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b eKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.eKT = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        tbPageContext = this.eKT.ajP;
        ((PbActivity) tbPageContext.getOrignalPage()).skipToLoginActivity();
        tbPageContext2 = this.eKT.ajP;
        ((PbActivity) tbPageContext2.getOrignalPage()).iF(true);
    }
}

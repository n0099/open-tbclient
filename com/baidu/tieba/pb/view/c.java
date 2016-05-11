package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b drS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.drS = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        tbPageContext = this.drS.DV;
        ((PbActivity) tbPageContext.getOrignalPage()).skipToRegisterActivity();
        tbPageContext2 = this.drS.DV;
        ((PbActivity) tbPageContext2.getOrignalPage()).gx(true);
    }
}

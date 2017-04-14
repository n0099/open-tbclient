package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b evy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.evy = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        tbPageContext = this.evy.ajT;
        ((PbActivity) tbPageContext.getOrignalPage()).skipToRegisterActivity();
        tbPageContext2 = this.evy.ajT;
        ((PbActivity) tbPageContext2.getOrignalPage()).il(true);
    }
}

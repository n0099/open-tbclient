package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b ekb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ekb = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        tbPageContext = this.ekb.GO;
        ((PbActivity) tbPageContext.getOrignalPage()).skipToRegisterActivity();
        tbPageContext2 = this.ekb.GO;
        ((PbActivity) tbPageContext2.getOrignalPage()).ig(true);
    }
}

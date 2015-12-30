package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b cMx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cMx = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        tbPageContext = this.cMx.mPageContext;
        ((PbActivity) tbPageContext.getOrignalPage()).skipToRegisterActivity();
        tbPageContext2 = this.cMx.mPageContext;
        ((PbActivity) tbPageContext2.getOrignalPage()).eY(true);
    }
}

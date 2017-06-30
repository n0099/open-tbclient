package com.baidu.tieba.pb.pb.main.emotion.view;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.emotion.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a eFJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.eFJ = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0075a interfaceC0075a;
        a.InterfaceC0075a interfaceC0075a2;
        com.baidu.tieba.pb.pb.main.emotion.data.b bVar;
        interfaceC0075a = this.eFJ.eFz;
        if (interfaceC0075a != null) {
            interfaceC0075a2 = this.eFJ.eFz;
            bVar = this.eFJ.mData;
            interfaceC0075a2.cl(bVar.aRn());
        }
        TiebaStatic.log("c12177");
    }
}

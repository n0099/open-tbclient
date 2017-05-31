package com.baidu.tieba.pb.pb.main.emotion.view;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.emotion.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a ewn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.ewn = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.InterfaceC0072a interfaceC0072a;
        a.InterfaceC0072a interfaceC0072a2;
        com.baidu.tieba.pb.pb.main.emotion.data.b bVar;
        interfaceC0072a = this.ewn.ewl;
        if (interfaceC0072a != null) {
            interfaceC0072a2 = this.ewn.ewl;
            bVar = this.ewn.mData;
            interfaceC0072a2.bW(bVar.aNo());
        }
        TiebaStatic.log("c12177");
    }
}

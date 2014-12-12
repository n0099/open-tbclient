package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {
    private final int GU;
    final /* synthetic */ PrivilegeTabHorizonScrollView bUW;

    private ar(PrivilegeTabHorizonScrollView privilegeTabHorizonScrollView, int i) {
        this.bUW = privilegeTabHorizonScrollView;
        this.GU = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ar(PrivilegeTabHorizonScrollView privilegeTabHorizonScrollView, int i, ar arVar) {
        this(privilegeTabHorizonScrollView, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PrivilegeTabHorizonScrollView.a(this.bUW).df(this.GU);
    }
}

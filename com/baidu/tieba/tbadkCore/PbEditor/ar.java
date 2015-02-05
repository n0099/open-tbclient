package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {
    private final int Ha;
    final /* synthetic */ PrivilegeTabHorizonScrollView bWO;

    private ar(PrivilegeTabHorizonScrollView privilegeTabHorizonScrollView, int i) {
        this.bWO = privilegeTabHorizonScrollView;
        this.Ha = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ar(PrivilegeTabHorizonScrollView privilegeTabHorizonScrollView, int i, ar arVar) {
        this(privilegeTabHorizonScrollView, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PrivilegeTabHorizonScrollView.a(this.bWO).dm(this.Ha);
    }
}

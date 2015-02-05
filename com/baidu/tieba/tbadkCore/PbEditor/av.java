package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ PrivilegeTabWidgetView bWU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PrivilegeTabWidgetView privilegeTabWidgetView) {
        this.bWU = privilegeTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.w wVar;
        com.baidu.tbadk.editortool.w wVar2;
        wVar = this.bWU.Yg;
        if (wVar != null) {
            wVar2 = this.bWU.Yg;
            wVar2.handleAction(21, null);
        }
    }
}

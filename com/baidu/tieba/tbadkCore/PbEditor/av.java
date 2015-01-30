package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ PrivilegeTabWidgetView bWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PrivilegeTabWidgetView privilegeTabWidgetView) {
        this.bWV = privilegeTabWidgetView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.w wVar;
        com.baidu.tbadk.editortool.w wVar2;
        wVar = this.bWV.Yj;
        if (wVar != null) {
            wVar2 = this.bWV.Yj;
            wVar2.handleAction(21, null);
        }
    }
}

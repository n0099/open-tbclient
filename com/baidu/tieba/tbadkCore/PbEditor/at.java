package com.baidu.tieba.tbadkCore.PbEditor;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements au {
    final /* synthetic */ as bWS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.bWS = asVar;
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.au
    public void b(ao aoVar) {
        PrivilegeTabWidgetView privilegeTabWidgetView;
        PrivilegeTabWidgetView privilegeTabWidgetView2;
        ArrayList<ao> arrayList;
        ArrayList arrayList2;
        int i;
        int i2;
        ArrayList arrayList3;
        this.bWS.hideProgressBar();
        privilegeTabWidgetView = this.bWS.bWR;
        privilegeTabWidgetView.reset();
        privilegeTabWidgetView2 = this.bWS.bWR;
        arrayList = this.bWS.amP;
        privilegeTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.bWS.amP;
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3 = this.bWS.amP;
            this.bWS.c(((ao) arrayList3.get(i3)).agv());
        }
        i = this.bWS.mCurrentIndex;
        if (i < 0) {
            this.bWS.setCurrentTab(0);
            return;
        }
        as asVar = this.bWS;
        i2 = this.bWS.mCurrentIndex;
        asVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.au
    public void OF() {
        this.bWS.showProgressBar();
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.au
    public void agD() {
        this.bWS.hideProgressBar();
    }
}

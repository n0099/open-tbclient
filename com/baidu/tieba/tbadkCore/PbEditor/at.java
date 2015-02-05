package com.baidu.tieba.tbadkCore.PbEditor;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements au {
    final /* synthetic */ as bWR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.bWR = asVar;
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
        this.bWR.hideProgressBar();
        privilegeTabWidgetView = this.bWR.bWQ;
        privilegeTabWidgetView.reset();
        privilegeTabWidgetView2 = this.bWR.bWQ;
        arrayList = this.bWR.amM;
        privilegeTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.bWR.amM;
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3 = this.bWR.amM;
            this.bWR.c(((ao) arrayList3.get(i3)).agq());
        }
        i = this.bWR.mCurrentIndex;
        if (i < 0) {
            this.bWR.setCurrentTab(0);
            return;
        }
        as asVar = this.bWR;
        i2 = this.bWR.mCurrentIndex;
        asVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.au
    public void OA() {
        this.bWR.showProgressBar();
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.au
    public void agy() {
        this.bWR.hideProgressBar();
    }
}

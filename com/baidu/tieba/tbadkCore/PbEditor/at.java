package com.baidu.tieba.tbadkCore.PbEditor;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements au {
    final /* synthetic */ as bUZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.bUZ = asVar;
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
        this.bUZ.hideProgressBar();
        privilegeTabWidgetView = this.bUZ.bUY;
        privilegeTabWidgetView.reset();
        privilegeTabWidgetView2 = this.bUZ.bUY;
        arrayList = this.bUZ.mData;
        privilegeTabWidgetView2.setDatas(arrayList);
        arrayList2 = this.bUZ.mData;
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3 = this.bUZ.mData;
            this.bUZ.c(((ao) arrayList3.get(i3)).afR());
        }
        i = this.bUZ.mCurrentIndex;
        if (i < 0) {
            this.bUZ.setCurrentTab(0);
            return;
        }
        as asVar = this.bUZ;
        i2 = this.bUZ.mCurrentIndex;
        asVar.setCurrentTab(i2);
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.au
    public void Oj() {
        this.bUZ.showProgressBar();
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.au
    public void afZ() {
        this.bUZ.hideProgressBar();
    }
}

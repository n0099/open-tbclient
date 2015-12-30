package com.baidu.tieba.pb.chosen;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class a implements AbsListView.OnScrollListener {
    final /* synthetic */ PbChosenActivity cBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PbChosenActivity pbChosenActivity) {
        this.cBV = pbChosenActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.editortools.d.e eVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.tieba.pb.chosen.a.l lVar;
        if (i != 0) {
            eVar = this.cBV.bbY;
            if (eVar != null) {
                eVar2 = this.cBV.bbY;
                if (eVar2.Bj() != null) {
                    eVar3 = this.cBV.bbY;
                    eVar3.Bj().hide();
                    lVar = this.cBV.cBA;
                    lVar.setVisible(true);
                }
            }
        }
    }
}

package com.baidu.tieba.pb.chosen;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class a implements AbsListView.OnScrollListener {
    final /* synthetic */ PbChosenActivity cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PbChosenActivity pbChosenActivity) {
        this.cfl = pbChosenActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.editortools.c.d dVar;
        com.baidu.tbadk.editortools.c.d dVar2;
        com.baidu.tbadk.editortools.c.d dVar3;
        com.baidu.tieba.pb.chosen.a.m mVar;
        if (i != 0) {
            dVar = this.cfl.aSC;
            if (dVar != null) {
                dVar2 = this.cfl.aSC;
                if (dVar2.Au() != null) {
                    dVar3 = this.cfl.aSC;
                    dVar3.Au().hide();
                    mVar = this.cfl.ceS;
                    mVar.setVisible(true);
                }
            }
        }
    }
}

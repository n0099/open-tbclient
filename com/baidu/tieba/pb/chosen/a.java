package com.baidu.tieba.pb.chosen;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class a implements AbsListView.OnScrollListener {
    final /* synthetic */ PbChosenActivity bZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PbChosenActivity pbChosenActivity) {
        this.bZS = pbChosenActivity;
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
            dVar = this.bZS.aTv;
            if (dVar != null) {
                dVar2 = this.bZS.aTv;
                if (dVar2.AL() != null) {
                    dVar3 = this.bZS.aTv;
                    dVar3.AL().hide();
                    mVar = this.bZS.bZz;
                    mVar.setVisible(true);
                }
            }
        }
    }
}

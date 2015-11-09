package com.baidu.tieba.pb.chosen;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class a implements AbsListView.OnScrollListener {
    final /* synthetic */ PbChosenActivity cfM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PbChosenActivity pbChosenActivity) {
        this.cfM = pbChosenActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.editortools.c.e eVar;
        com.baidu.tbadk.editortools.c.e eVar2;
        com.baidu.tbadk.editortools.c.e eVar3;
        com.baidu.tieba.pb.chosen.a.m mVar;
        if (i != 0) {
            eVar = this.cfM.aSK;
            if (eVar != null) {
                eVar2 = this.cfM.aSK;
                if (eVar2.Az() != null) {
                    eVar3 = this.cfM.aSK;
                    eVar3.Az().hide();
                    mVar = this.cfM.cft;
                    mVar.setVisible(true);
                }
            }
        }
    }
}

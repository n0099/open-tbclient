package com.baidu.tieba.pb.chosen;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class a implements AbsListView.OnScrollListener {
    final /* synthetic */ PbChosenActivity cyo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PbChosenActivity pbChosenActivity) {
        this.cyo = pbChosenActivity;
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
            eVar = this.cyo.aXY;
            if (eVar != null) {
                eVar2 = this.cyo.aXY;
                if (eVar2.Bu() != null) {
                    eVar3 = this.cyo.aXY;
                    eVar3.Bu().hide();
                    lVar = this.cyo.cxT;
                    lVar.setVisible(true);
                }
            }
        }
    }
}

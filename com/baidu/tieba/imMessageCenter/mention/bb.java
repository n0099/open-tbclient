package com.baidu.tieba.imMessageCenter.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements AbsListView.OnScrollListener {
    final /* synthetic */ az dAk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(az azVar) {
        this.dAk = azVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.editortools.e.p pVar;
        com.baidu.tbadk.editortools.e.p pVar2;
        if (i != 0) {
            pVar = this.dAk.dAe;
            if (pVar != null) {
                pVar2 = this.dAk.dAe;
                pVar2.DS();
                if (this.dAk.dzh != null) {
                    this.dAk.dzh.aBC();
                }
            }
        }
    }
}

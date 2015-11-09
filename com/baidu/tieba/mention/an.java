package com.baidu.tieba.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements AbsListView.OnScrollListener {
    final /* synthetic */ al cbA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar) {
        this.cbA = alVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tbadk.editortools.c.p pVar;
        com.baidu.tbadk.editortools.c.p pVar2;
        if (i != 0) {
            pVar = this.cbA.cbv;
            if (pVar != null) {
                pVar2 = this.cbA.cbv;
                pVar2.BC();
            }
        }
    }
}

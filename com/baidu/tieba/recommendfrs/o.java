package com.baidu.tieba.recommendfrs;

import android.widget.AbsListView;
import com.baidu.tieba.card.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AbsListView.OnScrollListener {
    private int doC = 0;
    private boolean doD = false;
    final /* synthetic */ n doE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.doE = nVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            am.Iq().Ir();
            if (this.doD) {
                this.doE.ayh();
            }
            this.doD = false;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.doC > i) {
            this.doD = true;
        }
        this.doC = i;
    }
}

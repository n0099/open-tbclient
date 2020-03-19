package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView ekE;
    private NewSubPbActivity iWK;
    private com.baidu.tieba.pb.pb.sub.a.b iXA;
    private com.baidu.tieba.pb.pb.sub.a.d iXB;
    private s iXC;
    private List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private View.OnClickListener akE = null;
    private boolean fQn = false;
    private boolean iXD = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.iWK = newSubPbActivity;
        this.ekE = bdTypeListView;
    }

    public void wR() {
        this.iXA = new com.baidu.tieba.pb.pb.sub.a.b(this.iWK, PostData.kii);
        this.iXA.y(this.akE);
        this.iXA.a(this.iXC);
        this.iXA.setFromCDN(this.iXD);
        this.asP.add(this.iXA);
        this.iXB = new com.baidu.tieba.pb.pb.sub.a.d(this.iWK, com.baidu.tieba.pb.pb.sub.b.b.iYt);
        this.asP.add(this.iXB);
        this.asP.add(new com.baidu.tieba.pb.pb.sub.a.c(this.iWK, com.baidu.tieba.pb.pb.sub.b.a.iYs));
        this.ekE.addAdapters(this.asP);
    }

    public void b(bj bjVar, List<m> list) {
        this.iXA.setThreadData(bjVar);
        if (this.iWK.crM().coL()) {
            this.iXA.Gv(this.iWK.crM().cnT());
        }
        this.ekE.setData(list);
        this.ekE.getAdapter().notifyDataSetChanged();
    }

    public boolean acd() {
        return this.fQn;
    }

    public void setHasMoreData(boolean z) {
        this.fQn = z;
    }

    public void y(View.OnClickListener onClickListener) {
        this.akE = onClickListener;
    }

    public void setLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.iXA.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.iXA.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.iXD = z;
    }

    public void notifyDataSetChanged() {
        if (this.ekE.getAdapter() != null) {
            this.ekE.getAdapter().notifyDataSetChanged();
        }
    }
}

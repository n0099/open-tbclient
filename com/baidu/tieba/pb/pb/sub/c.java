package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    private BdTypeListView gcr;
    private NewSubPbActivity lCE;
    private com.baidu.tieba.pb.pb.sub.a.b lDu;
    private com.baidu.tieba.pb.pb.sub.a.d lDv;
    private ab lDw;
    private List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private View.OnClickListener aYF = null;
    private boolean hXS = false;
    private boolean lDx = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.lCE = newSubPbActivity;
        this.gcr = bdTypeListView;
    }

    public void Ly() {
        this.lDu = new com.baidu.tieba.pb.pb.sub.a.b(this.lCE, PostData.mQN);
        this.lDu.A(this.aYF);
        this.lDu.a(this.lDw);
        this.lDu.setFromCDN(this.lDx);
        this.bje.add(this.lDu);
        this.lDv = new com.baidu.tieba.pb.pb.sub.a.d(this.lCE, com.baidu.tieba.pb.pb.sub.b.b.lEm);
        this.bje.add(this.lDv);
        this.bje.add(new com.baidu.tieba.pb.pb.sub.a.c(this.lCE, com.baidu.tieba.pb.pb.sub.b.a.lEl));
        this.gcr.addAdapters(this.bje);
    }

    public void a(bw bwVar, List<q> list) {
        this.lDu.setThreadData(bwVar);
        if (!at.isEmpty(this.lCE.dmT().diU())) {
            this.lDu.PQ(this.lCE.dmT().diU());
        }
        this.gcr.setData(list);
        this.gcr.getAdapter().notifyDataSetChanged();
    }

    public boolean aEj() {
        return this.hXS;
    }

    public void setHasMoreData(boolean z) {
        this.hXS = z;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aYF = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.lDu.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lDu.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.lDx = z;
    }

    public void notifyDataSetChanged() {
        if (this.gcr.getAdapter() != null) {
            this.gcr.getAdapter().notifyDataSetChanged();
        }
    }
}

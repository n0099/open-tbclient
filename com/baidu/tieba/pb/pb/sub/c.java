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
/* loaded from: classes16.dex */
public class c {
    private BdTypeListView fCP;
    private com.baidu.tieba.pb.pb.sub.a.b kST;
    private com.baidu.tieba.pb.pb.sub.a.d kSU;
    private ab kSV;
    private NewSubPbActivity kSd;
    private List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private View.OnClickListener aRU = null;
    private boolean hps = false;
    private boolean kSW = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.kSd = newSubPbActivity;
        this.fCP = bdTypeListView;
    }

    public void Jv() {
        this.kST = new com.baidu.tieba.pb.pb.sub.a.b(this.kSd, PostData.meN);
        this.kST.A(this.aRU);
        this.kST.a(this.kSV);
        this.kST.setFromCDN(this.kSW);
        this.bbu.add(this.kST);
        this.kSU = new com.baidu.tieba.pb.pb.sub.a.d(this.kSd, com.baidu.tieba.pb.pb.sub.b.b.kTL);
        this.bbu.add(this.kSU);
        this.bbu.add(new com.baidu.tieba.pb.pb.sub.a.c(this.kSd, com.baidu.tieba.pb.pb.sub.b.a.kTK));
        this.fCP.addAdapters(this.bbu);
    }

    public void a(bw bwVar, List<q> list) {
        this.kST.setThreadData(bwVar);
        if (!at.isEmpty(this.kSd.dcy().cYA())) {
            this.kST.Ob(this.kSd.dcy().cYA());
        }
        this.fCP.setData(list);
        this.fCP.getAdapter().notifyDataSetChanged();
    }

    public boolean ayX() {
        return this.hps;
    }

    public void setHasMoreData(boolean z) {
        this.hps = z;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aRU = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.kST.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kST.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.kSW = z;
    }

    public void notifyDataSetChanged() {
        if (this.fCP.getAdapter() != null) {
            this.fCP.getAdapter().notifyDataSetChanged();
        }
    }
}

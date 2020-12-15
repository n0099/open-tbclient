package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    private BdTypeListView gpZ;
    private NewSubPbActivity lWO;
    private com.baidu.tieba.pb.pb.sub.a.b lXE;
    private com.baidu.tieba.pb.pb.sub.a.d lXF;
    private ab lXG;
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private View.OnClickListener bbH = null;
    private boolean ipE = false;
    private boolean lXH = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.lWO = newSubPbActivity;
        this.gpZ = bdTypeListView;
    }

    public void Nt() {
        this.lXE = new com.baidu.tieba.pb.pb.sub.a.b(this.lWO, PostData.nlJ);
        this.lXE.B(this.bbH);
        this.lXE.a(this.lXG);
        this.lXE.setFromCDN(this.lXH);
        this.bnf.add(this.lXE);
        this.lXF = new com.baidu.tieba.pb.pb.sub.a.d(this.lWO, com.baidu.tieba.pb.pb.sub.b.b.lYA);
        this.bnf.add(this.lXF);
        this.bnf.add(new com.baidu.tieba.pb.pb.sub.a.c(this.lWO, com.baidu.tieba.pb.pb.sub.b.a.lYz));
        this.gpZ.addAdapters(this.bnf);
    }

    public void a(by byVar, List<q> list) {
        this.lXE.setThreadData(byVar);
        if (!au.isEmpty(this.lWO.duo().dqj())) {
            this.lXE.QL(this.lWO.duo().dqj());
        }
        this.gpZ.setData(list);
        this.gpZ.getAdapter().notifyDataSetChanged();
    }

    public boolean aJj() {
        return this.ipE;
    }

    public void setHasMoreData(boolean z) {
        this.ipE = z;
    }

    public void B(View.OnClickListener onClickListener) {
        this.bbH = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.lXE.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lXE.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.lXH = z;
    }

    public void notifyDataSetChanged() {
        if (this.gpZ.getAdapter() != null) {
            this.gpZ.getAdapter().notifyDataSetChanged();
        }
    }
}

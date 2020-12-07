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
    private BdTypeListView gpX;
    private NewSubPbActivity lWM;
    private com.baidu.tieba.pb.pb.sub.a.b lXC;
    private com.baidu.tieba.pb.pb.sub.a.d lXD;
    private ab lXE;
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private View.OnClickListener bbH = null;
    private boolean ipC = false;
    private boolean lXF = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.lWM = newSubPbActivity;
        this.gpX = bdTypeListView;
    }

    public void Nt() {
        this.lXC = new com.baidu.tieba.pb.pb.sub.a.b(this.lWM, PostData.nlH);
        this.lXC.B(this.bbH);
        this.lXC.a(this.lXE);
        this.lXC.setFromCDN(this.lXF);
        this.bnf.add(this.lXC);
        this.lXD = new com.baidu.tieba.pb.pb.sub.a.d(this.lWM, com.baidu.tieba.pb.pb.sub.b.b.lYy);
        this.bnf.add(this.lXD);
        this.bnf.add(new com.baidu.tieba.pb.pb.sub.a.c(this.lWM, com.baidu.tieba.pb.pb.sub.b.a.lYx));
        this.gpX.addAdapters(this.bnf);
    }

    public void a(by byVar, List<q> list) {
        this.lXC.setThreadData(byVar);
        if (!au.isEmpty(this.lWM.dun().dqi())) {
            this.lXC.QL(this.lWM.dun().dqi());
        }
        this.gpX.setData(list);
        this.gpX.getAdapter().notifyDataSetChanged();
    }

    public boolean aJj() {
        return this.ipC;
    }

    public void setHasMoreData(boolean z) {
        this.ipC = z;
    }

    public void B(View.OnClickListener onClickListener) {
        this.bbH = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.lXC.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lXC.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.lXF = z;
    }

    public void notifyDataSetChanged() {
        if (this.gpX.getAdapter() != null) {
            this.gpX.getAdapter().notifyDataSetChanged();
        }
    }
}

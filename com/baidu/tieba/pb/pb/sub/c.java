package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView faQ;
    private NewSubPbActivity jYF;
    private com.baidu.tieba.pb.pb.sub.a.b jZv;
    private com.baidu.tieba.pb.pb.sub.a.d jZw;
    private x jZx;
    private List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private View.OnClickListener aIH = null;
    private boolean gJL = false;
    private boolean jZy = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.jYF = newSubPbActivity;
        this.faQ = bdTypeListView;
    }

    public void CY() {
        this.jZv = new com.baidu.tieba.pb.pb.sub.a.b(this.jYF, PostData.lkJ);
        this.jZv.y(this.aIH);
        this.jZv.a(this.jZx);
        this.jZv.setFromCDN(this.jZy);
        this.aSj.add(this.jZv);
        this.jZw = new com.baidu.tieba.pb.pb.sub.a.d(this.jYF, com.baidu.tieba.pb.pb.sub.b.b.kap);
        this.aSj.add(this.jZw);
        this.aSj.add(new com.baidu.tieba.pb.pb.sub.a.c(this.jYF, com.baidu.tieba.pb.pb.sub.b.a.kao));
        this.faQ.addAdapters(this.aSj);
    }

    public void b(bk bkVar, List<o> list) {
        this.jZv.setThreadData(bkVar);
        if (this.jYF.cJn().cGl()) {
            this.jZv.JR(this.jYF.cJn().cFs());
        }
        this.faQ.setData(list);
        this.faQ.getAdapter().notifyDataSetChanged();
    }

    public boolean anV() {
        return this.gJL;
    }

    public void setHasMoreData(boolean z) {
        this.gJL = z;
    }

    public void y(View.OnClickListener onClickListener) {
        this.aIH = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.jZv.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.jZv.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.jZy = z;
    }

    public void notifyDataSetChanged() {
        if (this.faQ.getAdapter() != null) {
            this.faQ.getAdapter().notifyDataSetChanged();
        }
    }
}

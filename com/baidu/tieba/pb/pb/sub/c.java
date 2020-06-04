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
    private BdTypeListView fbb;
    private NewSubPbActivity jZL;
    private com.baidu.tieba.pb.pb.sub.a.b kaC;
    private com.baidu.tieba.pb.pb.sub.a.d kaD;
    private x kaE;
    private List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private View.OnClickListener aIH = null;
    private boolean gJW = false;
    private boolean kaF = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.jZL = newSubPbActivity;
        this.fbb = bdTypeListView;
    }

    public void CY() {
        this.kaC = new com.baidu.tieba.pb.pb.sub.a.b(this.jZL, PostData.llS);
        this.kaC.y(this.aIH);
        this.kaC.a(this.kaE);
        this.kaC.setFromCDN(this.kaF);
        this.aSj.add(this.kaC);
        this.kaD = new com.baidu.tieba.pb.pb.sub.a.d(this.jZL, com.baidu.tieba.pb.pb.sub.b.b.kbw);
        this.aSj.add(this.kaD);
        this.aSj.add(new com.baidu.tieba.pb.pb.sub.a.c(this.jZL, com.baidu.tieba.pb.pb.sub.b.a.kbv));
        this.fbb.addAdapters(this.aSj);
    }

    public void b(bk bkVar, List<o> list) {
        this.kaC.setThreadData(bkVar);
        if (this.jZL.cJD().cGB()) {
            this.kaC.JS(this.jZL.cJD().cFI());
        }
        this.fbb.setData(list);
        this.fbb.getAdapter().notifyDataSetChanged();
    }

    public boolean anV() {
        return this.gJW;
    }

    public void setHasMoreData(boolean z) {
        this.gJW = z;
    }

    public void y(View.OnClickListener onClickListener) {
        this.aIH = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.kaC.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kaC.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.kaF = z;
    }

    public void notifyDataSetChanged() {
        if (this.fbb.getAdapter() != null) {
            this.fbb.getAdapter().notifyDataSetChanged();
        }
    }
}

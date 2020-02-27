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
    private BdTypeListView eka;
    private NewSubPbActivity iUV;
    private com.baidu.tieba.pb.pb.sub.a.b iVL;
    private com.baidu.tieba.pb.pb.sub.a.d iVM;
    private s iVN;
    private List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private View.OnClickListener akt = null;
    private boolean fPq = false;
    private boolean iVO = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.iUV = newSubPbActivity;
        this.eka = bdTypeListView;
    }

    public void wM() {
        this.iVL = new com.baidu.tieba.pb.pb.sub.a.b(this.iUV, PostData.kgr);
        this.iVL.y(this.akt);
        this.iVL.a(this.iVN);
        this.iVL.setFromCDN(this.iVO);
        this.asE.add(this.iVL);
        this.iVM = new com.baidu.tieba.pb.pb.sub.a.d(this.iUV, com.baidu.tieba.pb.pb.sub.b.b.iWE);
        this.asE.add(this.iVM);
        this.asE.add(new com.baidu.tieba.pb.pb.sub.a.c(this.iUV, com.baidu.tieba.pb.pb.sub.b.a.iWD));
        this.eka.addAdapters(this.asE);
    }

    public void b(bj bjVar, List<m> list) {
        this.iVL.setThreadData(bjVar);
        if (this.iUV.cro().con()) {
            this.iVL.Gu(this.iUV.cro().cnv());
        }
        this.eka.setData(list);
        this.eka.getAdapter().notifyDataSetChanged();
    }

    public boolean abY() {
        return this.fPq;
    }

    public void setHasMoreData(boolean z) {
        this.fPq = z;
    }

    public void y(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public void setLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.iVL.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.iVL.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.iVO = z;
    }

    public void notifyDataSetChanged() {
        if (this.eka.getAdapter() != null) {
            this.eka.getAdapter().notifyDataSetChanged();
        }
    }
}

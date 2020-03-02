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
    private BdTypeListView ekb;
    private NewSubPbActivity iUX;
    private com.baidu.tieba.pb.pb.sub.a.b iVN;
    private com.baidu.tieba.pb.pb.sub.a.d iVO;
    private s iVP;
    private List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private View.OnClickListener akt = null;
    private boolean fPs = false;
    private boolean iVQ = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.iUX = newSubPbActivity;
        this.ekb = bdTypeListView;
    }

    public void wM() {
        this.iVN = new com.baidu.tieba.pb.pb.sub.a.b(this.iUX, PostData.kgt);
        this.iVN.y(this.akt);
        this.iVN.a(this.iVP);
        this.iVN.setFromCDN(this.iVQ);
        this.asE.add(this.iVN);
        this.iVO = new com.baidu.tieba.pb.pb.sub.a.d(this.iUX, com.baidu.tieba.pb.pb.sub.b.b.iWG);
        this.asE.add(this.iVO);
        this.asE.add(new com.baidu.tieba.pb.pb.sub.a.c(this.iUX, com.baidu.tieba.pb.pb.sub.b.a.iWF));
        this.ekb.addAdapters(this.asE);
    }

    public void b(bj bjVar, List<m> list) {
        this.iVN.setThreadData(bjVar);
        if (this.iUX.crq().cop()) {
            this.iVN.Gu(this.iUX.crq().cnx());
        }
        this.ekb.setData(list);
        this.ekb.getAdapter().notifyDataSetChanged();
    }

    public boolean aca() {
        return this.fPs;
    }

    public void setHasMoreData(boolean z) {
        this.fPs = z;
    }

    public void y(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public void setLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.iVN.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.iVN.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.iVQ = z;
    }

    public void notifyDataSetChanged() {
        if (this.ekb.getAdapter() != null) {
            this.ekb.getAdapter().notifyDataSetChanged();
        }
    }
}

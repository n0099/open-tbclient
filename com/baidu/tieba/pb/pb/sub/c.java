package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private BdTypeListView gzp;
    private NewSubPbActivity mgQ;
    private com.baidu.tieba.pb.pb.sub.adapter.b mhG;
    private SubPbReplyAdapter mhH;
    private w mhI;
    private List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private View.OnClickListener bbI = null;
    private boolean iDp = false;
    private boolean mhJ = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.mgQ = newSubPbActivity;
        this.gzp = bdTypeListView;
    }

    public void Kw() {
        this.mhG = new com.baidu.tieba.pb.pb.sub.adapter.b(this.mgQ, PostData.nwY);
        this.mhG.C(this.bbI);
        this.mhG.a(this.mhI);
        this.mhG.setFromCDN(this.mhJ);
        this.bns.add(this.mhG);
        this.mhH = new SubPbReplyAdapter(this.mgQ, com.baidu.tieba.pb.pb.sub.a.b.miE);
        this.bns.add(this.mhH);
        this.bns.add(new com.baidu.tieba.pb.pb.sub.adapter.c(this.mgQ, com.baidu.tieba.pb.pb.sub.a.a.miD));
        this.gzp.addAdapters(this.bns);
    }

    public void a(cb cbVar, List<n> list) {
        this.mhG.setThreadData(cbVar);
        if (!au.isEmpty(this.mgQ.dsH().doz())) {
            this.mhG.Qb(this.mgQ.dsH().doz());
        }
        if (this.mgQ != null && this.mgQ.dsH() != null) {
            this.mhG.uT(this.mgQ.dsH().dtC());
        }
        this.gzp.setData(list);
        this.gzp.getAdapter().notifyDataSetChanged();
    }

    public boolean aHt() {
        return this.iDp;
    }

    public void setHasMoreData(boolean z) {
        this.iDp = z;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bbI = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.mhG.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.mhG.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.mhJ = z;
    }

    public void notifyDataSetChanged() {
        if (this.gzp.getAdapter() != null) {
            this.gzp.getAdapter().notifyDataSetChanged();
        }
    }
}

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
    private BdTypeListView gzb;
    private NewSubPbActivity mgB;
    private com.baidu.tieba.pb.pb.sub.adapter.b mhr;
    private SubPbReplyAdapter mhs;
    private w mht;
    private List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private View.OnClickListener bbI = null;
    private boolean iDb = false;
    private boolean mhu = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.mgB = newSubPbActivity;
        this.gzb = bdTypeListView;
    }

    public void Kw() {
        this.mhr = new com.baidu.tieba.pb.pb.sub.adapter.b(this.mgB, PostData.nwy);
        this.mhr.C(this.bbI);
        this.mhr.a(this.mht);
        this.mhr.setFromCDN(this.mhu);
        this.bns.add(this.mhr);
        this.mhs = new SubPbReplyAdapter(this.mgB, com.baidu.tieba.pb.pb.sub.a.b.mip);
        this.bns.add(this.mhs);
        this.bns.add(new com.baidu.tieba.pb.pb.sub.adapter.c(this.mgB, com.baidu.tieba.pb.pb.sub.a.a.mio));
        this.gzb.addAdapters(this.bns);
    }

    public void a(cb cbVar, List<n> list) {
        this.mhr.setThreadData(cbVar);
        if (!au.isEmpty(this.mgB.dsA().dos())) {
            this.mhr.Qa(this.mgB.dsA().dos());
        }
        if (this.mgB != null && this.mgB.dsA() != null) {
            this.mhr.uT(this.mgB.dsA().dtv());
        }
        this.gzb.setData(list);
        this.gzb.getAdapter().notifyDataSetChanged();
    }

    public boolean aHt() {
        return this.iDb;
    }

    public void setHasMoreData(boolean z) {
        this.iDb = z;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bbI = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.mhr.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.mhr.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.mhu = z;
    }

    public void notifyDataSetChanged() {
        if (this.gzb.getAdapter() != null) {
            this.gzb.getAdapter().notifyDataSetChanged();
        }
    }
}

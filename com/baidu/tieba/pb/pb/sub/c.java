package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class c {
    private BdTypeListView frv;
    private NewSubPbActivity kCx;
    private com.baidu.tieba.pb.pb.sub.a.b kDn;
    private com.baidu.tieba.pb.pb.sub.a.d kDo;
    private z kDp;
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private View.OnClickListener aMH = null;
    private boolean hcB = false;
    private boolean kDq = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.kCx = newSubPbActivity;
        this.frv = bdTypeListView;
    }

    public void DS() {
        this.kDn = new com.baidu.tieba.pb.pb.sub.a.b(this.kCx, PostData.lNd);
        this.kDn.z(this.aMH);
        this.kDn.a(this.kDp);
        this.kDn.setFromCDN(this.kDq);
        this.aWf.add(this.kDn);
        this.kDo = new com.baidu.tieba.pb.pb.sub.a.d(this.kCx, com.baidu.tieba.pb.pb.sub.b.b.kEe);
        this.aWf.add(this.kDo);
        this.aWf.add(new com.baidu.tieba.pb.pb.sub.a.c(this.kCx, com.baidu.tieba.pb.pb.sub.b.a.kEd));
        this.frv.addAdapters(this.aWf);
    }

    public void a(bv bvVar, List<q> list) {
        this.kDn.setThreadData(bvVar);
        if (this.kCx.cRI().cOD()) {
            this.kDn.Li(this.kCx.cRI().cNK());
        }
        this.frv.setData(list);
        this.frv.getAdapter().notifyDataSetChanged();
    }

    public boolean aqL() {
        return this.hcB;
    }

    public void setHasMoreData(boolean z) {
        this.hcB = z;
    }

    public void z(View.OnClickListener onClickListener) {
        this.aMH = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.kDn.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kDn.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.kDq = z;
    }

    public void notifyDataSetChanged() {
        if (this.frv.getAdapter() != null) {
            this.frv.getAdapter().notifyDataSetChanged();
        }
    }
}

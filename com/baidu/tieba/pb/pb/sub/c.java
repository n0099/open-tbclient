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
    private NewSubPbActivity kCv;
    private com.baidu.tieba.pb.pb.sub.a.b kDl;
    private com.baidu.tieba.pb.pb.sub.a.d kDm;
    private z kDn;
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private View.OnClickListener aMH = null;
    private boolean hcB = false;
    private boolean kDo = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.kCv = newSubPbActivity;
        this.frv = bdTypeListView;
    }

    public void DS() {
        this.kDl = new com.baidu.tieba.pb.pb.sub.a.b(this.kCv, PostData.lNb);
        this.kDl.z(this.aMH);
        this.kDl.a(this.kDn);
        this.kDl.setFromCDN(this.kDo);
        this.aWf.add(this.kDl);
        this.kDm = new com.baidu.tieba.pb.pb.sub.a.d(this.kCv, com.baidu.tieba.pb.pb.sub.b.b.kEc);
        this.aWf.add(this.kDm);
        this.aWf.add(new com.baidu.tieba.pb.pb.sub.a.c(this.kCv, com.baidu.tieba.pb.pb.sub.b.a.kEb));
        this.frv.addAdapters(this.aWf);
    }

    public void a(bv bvVar, List<q> list) {
        this.kDl.setThreadData(bvVar);
        if (this.kCv.cRI().cOD()) {
            this.kDl.Li(this.kCv.cRI().cNK());
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
        this.kDl.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kDl.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.kDo = z;
    }

    public void notifyDataSetChanged() {
        if (this.frv.getAdapter() != null) {
            this.frv.getAdapter().notifyDataSetChanged();
        }
    }
}

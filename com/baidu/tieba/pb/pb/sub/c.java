package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView eOe;
    private NewSubPbActivity jGS;
    private com.baidu.tieba.pb.pb.sub.a.b jHI;
    private com.baidu.tieba.pb.pb.sub.a.d jHJ;
    private v jHK;
    private List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private View.OnClickListener aDc = null;
    private boolean guU = false;
    private boolean jHL = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.jGS = newSubPbActivity;
        this.eOe = bdTypeListView;
    }

    public void BC() {
        this.jHI = new com.baidu.tieba.pb.pb.sub.a.b(this.jGS, PostData.kSo);
        this.jHI.z(this.aDc);
        this.jHI.a(this.jHK);
        this.jHI.setFromCDN(this.jHL);
        this.aMd.add(this.jHI);
        this.jHJ = new com.baidu.tieba.pb.pb.sub.a.d(this.jGS, com.baidu.tieba.pb.pb.sub.b.b.jIB);
        this.aMd.add(this.jHJ);
        this.aMd.add(new com.baidu.tieba.pb.pb.sub.a.c(this.jGS, com.baidu.tieba.pb.pb.sub.b.a.jIA));
        this.eOe.addAdapters(this.aMd);
    }

    public void b(bj bjVar, List<m> list) {
        this.jHI.setThreadData(bjVar);
        if (this.jGS.cCs().czr()) {
            this.jHI.Ic(this.jGS.cCs().cyz());
        }
        this.eOe.setData(list);
        this.eOe.getAdapter().notifyDataSetChanged();
    }

    public boolean aki() {
        return this.guU;
    }

    public void setHasMoreData(boolean z) {
        this.guU = z;
    }

    public void z(View.OnClickListener onClickListener) {
        this.aDc = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.jHI.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.jHI.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.jHL = z;
    }

    public void notifyDataSetChanged() {
        if (this.eOe.getAdapter() != null) {
            this.eOe.getAdapter().notifyDataSetChanged();
        }
    }
}

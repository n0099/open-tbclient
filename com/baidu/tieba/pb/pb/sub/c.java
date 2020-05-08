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
    private BdTypeListView eOj;
    private NewSubPbActivity jGW;
    private com.baidu.tieba.pb.pb.sub.a.b jHM;
    private com.baidu.tieba.pb.pb.sub.a.d jHN;
    private v jHO;
    private List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private View.OnClickListener aDi = null;
    private boolean gva = false;
    private boolean jHP = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.jGW = newSubPbActivity;
        this.eOj = bdTypeListView;
    }

    public void BB() {
        this.jHM = new com.baidu.tieba.pb.pb.sub.a.b(this.jGW, PostData.kSs);
        this.jHM.z(this.aDi);
        this.jHM.a(this.jHO);
        this.jHM.setFromCDN(this.jHP);
        this.aMj.add(this.jHM);
        this.jHN = new com.baidu.tieba.pb.pb.sub.a.d(this.jGW, com.baidu.tieba.pb.pb.sub.b.b.jIF);
        this.aMj.add(this.jHN);
        this.aMj.add(new com.baidu.tieba.pb.pb.sub.a.c(this.jGW, com.baidu.tieba.pb.pb.sub.b.a.jIE));
        this.eOj.addAdapters(this.aMj);
    }

    public void b(bj bjVar, List<m> list) {
        this.jHM.setThreadData(bjVar);
        if (this.jGW.cCp().czo()) {
            this.jHM.If(this.jGW.cCp().cyw());
        }
        this.eOj.setData(list);
        this.eOj.getAdapter().notifyDataSetChanged();
    }

    public boolean akh() {
        return this.gva;
    }

    public void setHasMoreData(boolean z) {
        this.gva = z;
    }

    public void z(View.OnClickListener onClickListener) {
        this.aDi = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.jHM.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.jHM.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.jHP = z;
    }

    public void notifyDataSetChanged() {
        if (this.eOj.getAdapter() != null) {
            this.eOj.getAdapter().notifyDataSetChanged();
        }
    }
}

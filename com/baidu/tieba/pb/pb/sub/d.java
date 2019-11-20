package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private BdTypeListView duK;
    private NewSubPbActivity iaL;
    private com.baidu.tieba.pb.pb.sub.a.b ibF;
    private com.baidu.tieba.pb.pb.sub.a.d ibG;
    private s ibH;
    private List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private View.OnClickListener ZF = null;
    private boolean eVf = false;
    private boolean ibI = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.iaL = newSubPbActivity;
        this.duK = bdTypeListView;
    }

    public void sY() {
        this.ibF = new com.baidu.tieba.pb.pb.sub.a.b(this.iaL, PostData.jhw);
        this.ibF.w(this.ZF);
        this.ibF.a(this.ibH);
        this.ibF.setFromCDN(this.ibI);
        this.agy.add(this.ibF);
        this.ibG = new com.baidu.tieba.pb.pb.sub.a.d(this.iaL, com.baidu.tieba.pb.pb.sub.b.b.icv);
        this.agy.add(this.ibG);
        this.agy.add(new com.baidu.tieba.pb.pb.sub.a.c(this.iaL, com.baidu.tieba.pb.pb.sub.b.a.icu));
        this.duK.addAdapters(this.agy);
    }

    public void b(bh bhVar, List<m> list) {
        this.ibF.ai(bhVar);
        if (this.iaL.bWV().bUo()) {
            this.ibF.Bl(this.iaL.bWV().bTx());
        }
        this.duK.setData(list);
        this.duK.getAdapter().notifyDataSetChanged();
    }

    public boolean Pz() {
        return this.eVf;
    }

    public void setHasMoreData(boolean z) {
        this.eVf = z;
    }

    public void w(View.OnClickListener onClickListener) {
        this.ZF = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.ibF.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.ibF.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.ibI = z;
    }

    public void notifyDataSetChanged() {
        if (this.duK.getAdapter() != null) {
            this.duK.getAdapter().notifyDataSetChanged();
        }
    }
}

package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView fml;
    private NewSubPbActivity ktD;
    private com.baidu.tieba.pb.pb.sub.a.b kut;
    private com.baidu.tieba.pb.pb.sub.a.d kuu;
    private z kuv;
    private List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private View.OnClickListener aLl = null;
    private boolean gWW = false;
    private boolean kuw = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.ktD = newSubPbActivity;
        this.fml = bdTypeListView;
    }

    public void Dz() {
        this.kut = new com.baidu.tieba.pb.pb.sub.a.b(this.ktD, PostData.lFM);
        this.kut.z(this.aLl);
        this.kut.a(this.kuv);
        this.kut.setFromCDN(this.kuw);
        this.aUP.add(this.kut);
        this.kuu = new com.baidu.tieba.pb.pb.sub.a.d(this.ktD, com.baidu.tieba.pb.pb.sub.b.b.kvj);
        this.aUP.add(this.kuu);
        this.aUP.add(new com.baidu.tieba.pb.pb.sub.a.c(this.ktD, com.baidu.tieba.pb.pb.sub.b.a.kvi));
        this.fml.addAdapters(this.aUP);
    }

    public void b(bu buVar, List<q> list) {
        this.kut.setThreadData(buVar);
        if (this.ktD.cNV().cKS()) {
            this.kut.Ku(this.ktD.cNV().cJZ());
        }
        this.fml.setData(list);
        this.fml.getAdapter().notifyDataSetChanged();
    }

    public boolean apb() {
        return this.gWW;
    }

    public void setHasMoreData(boolean z) {
        this.gWW = z;
    }

    public void z(View.OnClickListener onClickListener) {
        this.aLl = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.kut.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kut.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.kuw = z;
    }

    public void notifyDataSetChanged() {
        if (this.fml.getAdapter() != null) {
            this.fml.getAdapter().notifyDataSetChanged();
        }
    }
}

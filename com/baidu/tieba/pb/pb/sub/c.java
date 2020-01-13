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
/* loaded from: classes7.dex */
public class c {
    private BdTypeListView efW;
    private NewSubPbActivity iTB;
    private com.baidu.tieba.pb.pb.sub.a.b iUr;
    private com.baidu.tieba.pb.pb.sub.a.d iUs;
    private s iUt;
    private List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private View.OnClickListener ain = null;
    private boolean fMV = false;
    private boolean iUu = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.iTB = newSubPbActivity;
        this.efW = bdTypeListView;
    }

    public void vi() {
        this.iUr = new com.baidu.tieba.pb.pb.sub.a.b(this.iTB, PostData.kfm);
        this.iUr.x(this.ain);
        this.iUr.a(this.iUt);
        this.iUr.setFromCDN(this.iUu);
        this.apl.add(this.iUr);
        this.iUs = new com.baidu.tieba.pb.pb.sub.a.d(this.iTB, com.baidu.tieba.pb.pb.sub.b.b.iVk);
        this.apl.add(this.iUs);
        this.apl.add(new com.baidu.tieba.pb.pb.sub.a.c(this.iTB, com.baidu.tieba.pb.pb.sub.b.a.iVj));
        this.efW.addAdapters(this.apl);
    }

    public void b(bj bjVar, List<m> list) {
        this.iUr.setThreadData(bjVar);
        if (this.iTB.cpW().cmW()) {
            this.iUr.Gf(this.iTB.cpW().cmb());
        }
        this.efW.setData(list);
        this.efW.getAdapter().notifyDataSetChanged();
    }

    public boolean ZK() {
        return this.fMV;
    }

    public void setHasMoreData(boolean z) {
        this.fMV = z;
    }

    public void x(View.OnClickListener onClickListener) {
        this.ain = onClickListener;
    }

    public void setLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.iUr.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.iUr.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.iUu = z;
    }

    public void notifyDataSetChanged() {
        if (this.efW.getAdapter() != null) {
            this.efW.getAdapter().notifyDataSetChanged();
        }
    }
}

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
    private BdTypeListView eko;
    private com.baidu.tieba.pb.pb.sub.a.b iVZ;
    private NewSubPbActivity iVj;
    private com.baidu.tieba.pb.pb.sub.a.d iWa;
    private s iWb;
    private List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private View.OnClickListener aku = null;
    private boolean fPF = false;
    private boolean iWc = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.iVj = newSubPbActivity;
        this.eko = bdTypeListView;
    }

    public void wM() {
        this.iVZ = new com.baidu.tieba.pb.pb.sub.a.b(this.iVj, PostData.kgF);
        this.iVZ.y(this.aku);
        this.iVZ.a(this.iWb);
        this.iVZ.setFromCDN(this.iWc);
        this.asF.add(this.iVZ);
        this.iWa = new com.baidu.tieba.pb.pb.sub.a.d(this.iVj, com.baidu.tieba.pb.pb.sub.b.b.iWS);
        this.asF.add(this.iWa);
        this.asF.add(new com.baidu.tieba.pb.pb.sub.a.c(this.iVj, com.baidu.tieba.pb.pb.sub.b.a.iWR));
        this.eko.addAdapters(this.asF);
    }

    public void b(bj bjVar, List<m> list) {
        this.iVZ.setThreadData(bjVar);
        if (this.iVj.crr().coq()) {
            this.iVZ.Gv(this.iVj.crr().cny());
        }
        this.eko.setData(list);
        this.eko.getAdapter().notifyDataSetChanged();
    }

    public boolean aca() {
        return this.fPF;
    }

    public void setHasMoreData(boolean z) {
        this.fPF = z;
    }

    public void y(View.OnClickListener onClickListener) {
        this.aku = onClickListener;
    }

    public void setLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.iVZ.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.iVZ.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.iWc = z;
    }

    public void notifyDataSetChanged() {
        if (this.eko.getAdapter() != null) {
            this.eko.getAdapter().notifyDataSetChanged();
        }
    }
}

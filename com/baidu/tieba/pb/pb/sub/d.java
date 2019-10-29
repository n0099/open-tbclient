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
    private BdTypeListView dvB;
    private NewSubPbActivity ibC;
    private com.baidu.tieba.pb.pb.sub.a.b icw;
    private com.baidu.tieba.pb.pb.sub.a.d icx;
    private s icy;
    private List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private View.OnClickListener ZX = null;
    private boolean eVW = false;
    private boolean icz = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.ibC = newSubPbActivity;
        this.dvB = bdTypeListView;
    }

    public void sX() {
        this.icw = new com.baidu.tieba.pb.pb.sub.a.b(this.ibC, PostData.jio);
        this.icw.w(this.ZX);
        this.icw.a(this.icy);
        this.icw.setFromCDN(this.icz);
        this.agQ.add(this.icw);
        this.icx = new com.baidu.tieba.pb.pb.sub.a.d(this.ibC, com.baidu.tieba.pb.pb.sub.b.b.idn);
        this.agQ.add(this.icx);
        this.agQ.add(new com.baidu.tieba.pb.pb.sub.a.c(this.ibC, com.baidu.tieba.pb.pb.sub.b.a.idm));
        this.dvB.addAdapters(this.agQ);
    }

    public void b(bh bhVar, List<m> list) {
        this.icw.ai(bhVar);
        if (this.ibC.bWX().bUq()) {
            this.icw.Bl(this.ibC.bWX().bTz());
        }
        this.dvB.setData(list);
        this.dvB.getAdapter().notifyDataSetChanged();
    }

    public boolean Py() {
        return this.eVW;
    }

    public void setHasMoreData(boolean z) {
        this.eVW = z;
    }

    public void w(View.OnClickListener onClickListener) {
        this.ZX = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.icw.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.icw.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.icz = z;
    }

    public void notifyDataSetChanged() {
        if (this.dvB.getAdapter() != null) {
            this.dvB.getAdapter().notifyDataSetChanged();
        }
    }
}

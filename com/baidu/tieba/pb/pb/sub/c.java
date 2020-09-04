package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class c {
    private BdTypeListView fCT;
    private NewSubPbActivity kSk;
    private com.baidu.tieba.pb.pb.sub.a.b kTa;
    private com.baidu.tieba.pb.pb.sub.a.d kTb;
    private ab kTc;
    private List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private View.OnClickListener aRW = null;
    private boolean hpw = false;
    private boolean kTd = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.kSk = newSubPbActivity;
        this.fCT = bdTypeListView;
    }

    public void Jv() {
        this.kTa = new com.baidu.tieba.pb.pb.sub.a.b(this.kSk, PostData.mfc);
        this.kTa.A(this.aRW);
        this.kTa.a(this.kTc);
        this.kTa.setFromCDN(this.kTd);
        this.bbw.add(this.kTa);
        this.kTb = new com.baidu.tieba.pb.pb.sub.a.d(this.kSk, com.baidu.tieba.pb.pb.sub.b.b.kTS);
        this.bbw.add(this.kTb);
        this.bbw.add(new com.baidu.tieba.pb.pb.sub.a.c(this.kSk, com.baidu.tieba.pb.pb.sub.b.a.kTR));
        this.fCT.addAdapters(this.bbw);
    }

    public void a(bw bwVar, List<q> list) {
        this.kTa.setThreadData(bwVar);
        if (!at.isEmpty(this.kSk.dcz().cYB())) {
            this.kTa.Oc(this.kSk.dcz().cYB());
        }
        this.fCT.setData(list);
        this.fCT.getAdapter().notifyDataSetChanged();
    }

    public boolean ayX() {
        return this.hpw;
    }

    public void setHasMoreData(boolean z) {
        this.hpw = z;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aRW = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.kTa.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kTa.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.kTd = z;
    }

    public void notifyDataSetChanged() {
        if (this.fCT.getAdapter() != null) {
            this.fCT.getAdapter().notifyDataSetChanged();
        }
    }
}

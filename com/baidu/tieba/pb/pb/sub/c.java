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
/* loaded from: classes21.dex */
public class c {
    private BdTypeListView fGf;
    private NewSubPbActivity laO;
    private com.baidu.tieba.pb.pb.sub.a.b lbE;
    private com.baidu.tieba.pb.pb.sub.a.d lbF;
    private ab lbG;
    private List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private View.OnClickListener aTZ = null;
    private boolean hwA = false;
    private boolean lbH = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.laO = newSubPbActivity;
        this.fGf = bdTypeListView;
    }

    public void JZ() {
        this.lbE = new com.baidu.tieba.pb.pb.sub.a.b(this.laO, PostData.moB);
        this.lbE.A(this.aTZ);
        this.lbE.a(this.lbG);
        this.lbE.setFromCDN(this.lbH);
        this.bdV.add(this.lbE);
        this.lbF = new com.baidu.tieba.pb.pb.sub.a.d(this.laO, com.baidu.tieba.pb.pb.sub.b.b.lcw);
        this.bdV.add(this.lbF);
        this.bdV.add(new com.baidu.tieba.pb.pb.sub.a.c(this.laO, com.baidu.tieba.pb.pb.sub.b.a.lcv));
        this.fGf.addAdapters(this.bdV);
    }

    public void a(bw bwVar, List<q> list) {
        this.lbE.setThreadData(bwVar);
        if (!at.isEmpty(this.laO.dgd().dce())) {
            this.lbE.OD(this.laO.dgd().dce());
        }
        this.fGf.setData(list);
        this.fGf.getAdapter().notifyDataSetChanged();
    }

    public boolean azG() {
        return this.hwA;
    }

    public void setHasMoreData(boolean z) {
        this.hwA = z;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aTZ = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.lbE.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lbE.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.lbH = z;
    }

    public void notifyDataSetChanged() {
        if (this.fGf.getAdapter() != null) {
            this.fGf.getAdapter().notifyDataSetChanged();
        }
    }
}

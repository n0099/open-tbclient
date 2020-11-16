package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class c {
    private BdTypeListView ghN;
    private NewSubPbActivity lIS;
    private com.baidu.tieba.pb.pb.sub.a.b lJI;
    private com.baidu.tieba.pb.pb.sub.a.d lJJ;
    private ab lJK;
    private List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private View.OnClickListener aYm = null;
    private boolean ieI = false;
    private boolean lJL = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.lIS = newSubPbActivity;
        this.ghN = bdTypeListView;
    }

    public void Lp() {
        this.lJI = new com.baidu.tieba.pb.pb.sub.a.b(this.lIS, PostData.mXJ);
        this.lJI.B(this.aYm);
        this.lJI.a(this.lJK);
        this.lJI.setFromCDN(this.lJL);
        this.biN.add(this.lJI);
        this.lJJ = new com.baidu.tieba.pb.pb.sub.a.d(this.lIS, com.baidu.tieba.pb.pb.sub.b.b.lKA);
        this.biN.add(this.lJJ);
        this.biN.add(new com.baidu.tieba.pb.pb.sub.a.c(this.lIS, com.baidu.tieba.pb.pb.sub.b.a.lKz));
        this.ghN.addAdapters(this.biN);
    }

    public void a(bx bxVar, List<q> list) {
        this.lJI.setThreadData(bxVar);
        if (!au.isEmpty(this.lIS.doW().dkT())) {
            this.lJI.PD(this.lIS.doW().dkT());
        }
        this.ghN.setData(list);
        this.ghN.getAdapter().notifyDataSetChanged();
    }

    public boolean aGb() {
        return this.ieI;
    }

    public void setHasMoreData(boolean z) {
        this.ieI = z;
    }

    public void B(View.OnClickListener onClickListener) {
        this.aYm = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.lJI.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lJI.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.lJL = z;
    }

    public void notifyDataSetChanged() {
        if (this.ghN.getAdapter() != null) {
            this.ghN.getAdapter().notifyDataSetChanged();
        }
    }
}

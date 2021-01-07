package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private BdTypeListView gAY;
    private com.baidu.tieba.pb.pb.sub.adapter.b mcT;
    private SubPbReplyAdapter mcU;
    private w mcV;
    private NewSubPbActivity mcd;
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private View.OnClickListener bdp = null;
    private boolean iBY = false;
    private boolean mcW = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.mcd = newSubPbActivity;
        this.gAY = bdTypeListView;
    }

    public void MT() {
        this.mcT = new com.baidu.tieba.pb.pb.sub.adapter.b(this.mcd, PostData.nru);
        this.mcT.C(this.bdp);
        this.mcT.a(this.mcV);
        this.mcT.setFromCDN(this.mcW);
        this.boM.add(this.mcT);
        this.mcU = new SubPbReplyAdapter(this.mcd, com.baidu.tieba.pb.pb.sub.a.b.mdO);
        this.boM.add(this.mcU);
        this.boM.add(new com.baidu.tieba.pb.pb.sub.adapter.c(this.mcd, com.baidu.tieba.pb.pb.sub.a.a.mdN));
        this.gAY.addAdapters(this.boM);
    }

    public void a(bz bzVar, List<n> list) {
        this.mcT.setThreadData(bzVar);
        if (!at.isEmpty(this.mcd.due().dpW())) {
            this.mcT.Qq(this.mcd.due().dpW());
        }
        this.gAY.setData(list);
        this.gAY.getAdapter().notifyDataSetChanged();
    }

    public boolean aKU() {
        return this.iBY;
    }

    public void setHasMoreData(boolean z) {
        this.iBY = z;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bdp = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.mcT.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.mcT.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.mcW = z;
    }

    public void notifyDataSetChanged() {
        if (this.gAY.getAdapter() != null) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }
}

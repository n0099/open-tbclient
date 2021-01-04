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
    private com.baidu.tieba.pb.pb.sub.adapter.b mcU;
    private SubPbReplyAdapter mcV;
    private w mcW;
    private NewSubPbActivity mce;
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private View.OnClickListener bdp = null;
    private boolean iBY = false;
    private boolean mcX = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.mce = newSubPbActivity;
        this.gAY = bdTypeListView;
    }

    public void MT() {
        this.mcU = new com.baidu.tieba.pb.pb.sub.adapter.b(this.mce, PostData.nrv);
        this.mcU.C(this.bdp);
        this.mcU.a(this.mcW);
        this.mcU.setFromCDN(this.mcX);
        this.boM.add(this.mcU);
        this.mcV = new SubPbReplyAdapter(this.mce, com.baidu.tieba.pb.pb.sub.a.b.mdP);
        this.boM.add(this.mcV);
        this.boM.add(new com.baidu.tieba.pb.pb.sub.adapter.c(this.mce, com.baidu.tieba.pb.pb.sub.a.a.mdO));
        this.gAY.addAdapters(this.boM);
    }

    public void a(bz bzVar, List<n> list) {
        this.mcU.setThreadData(bzVar);
        if (!at.isEmpty(this.mce.dud().dpV())) {
            this.mcU.Qr(this.mce.dud().dpV());
        }
        this.gAY.setData(list);
        this.gAY.getAdapter().notifyDataSetChanged();
    }

    public boolean aKT() {
        return this.iBY;
    }

    public void setHasMoreData(boolean z) {
        this.iBY = z;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bdp = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.mcU.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.mcU.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.mcX = z;
    }

    public void notifyDataSetChanged() {
        if (this.gAY.getAdapter() != null) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }
}

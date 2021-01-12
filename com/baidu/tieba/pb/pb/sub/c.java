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
    private BdTypeListView gwr;
    private NewSubPbActivity lXw;
    private com.baidu.tieba.pb.pb.sub.adapter.b lYm;
    private SubPbReplyAdapter lYn;
    private w lYo;
    private List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private View.OnClickListener aYB = null;
    private boolean ixr = false;
    private boolean lYp = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.lXw = newSubPbActivity;
        this.gwr = bdTypeListView;
    }

    public void IY() {
        this.lYm = new com.baidu.tieba.pb.pb.sub.adapter.b(this.lXw, PostData.nmN);
        this.lYm.C(this.aYB);
        this.lYm.a(this.lYo);
        this.lYm.setFromCDN(this.lYp);
        this.bjZ.add(this.lYm);
        this.lYn = new SubPbReplyAdapter(this.lXw, com.baidu.tieba.pb.pb.sub.a.b.lZh);
        this.bjZ.add(this.lYn);
        this.bjZ.add(new com.baidu.tieba.pb.pb.sub.adapter.c(this.lXw, com.baidu.tieba.pb.pb.sub.a.a.lZg));
        this.gwr.addAdapters(this.bjZ);
    }

    public void a(bz bzVar, List<n> list) {
        this.lYm.setThreadData(bzVar);
        if (!at.isEmpty(this.lXw.dqm().dmd())) {
            this.lYm.Pi(this.lXw.dqm().dmd());
        }
        this.gwr.setData(list);
        this.gwr.getAdapter().notifyDataSetChanged();
    }

    public boolean aHa() {
        return this.ixr;
    }

    public void setHasMoreData(boolean z) {
        this.ixr = z;
    }

    public void C(View.OnClickListener onClickListener) {
        this.aYB = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.lYm.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lYm.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.lYp = z;
    }

    public void notifyDataSetChanged() {
        if (this.gwr.getAdapter() != null) {
            this.gwr.getAdapter().notifyDataSetChanged();
        }
    }
}

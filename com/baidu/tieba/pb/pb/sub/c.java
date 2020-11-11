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
/* loaded from: classes22.dex */
public class c {
    private BdTypeListView gih;
    private NewSubPbActivity lIA;
    private com.baidu.tieba.pb.pb.sub.a.b lJq;
    private com.baidu.tieba.pb.pb.sub.a.d lJr;
    private ab lJs;
    private List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private View.OnClickListener aZX = null;
    private boolean idT = false;
    private boolean lJt = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.lIA = newSubPbActivity;
        this.gih = bdTypeListView;
    }

    public void LY() {
        this.lJq = new com.baidu.tieba.pb.pb.sub.a.b(this.lIA, PostData.mWR);
        this.lJq.B(this.aZX);
        this.lJq.a(this.lJs);
        this.lJq.setFromCDN(this.lJt);
        this.bky.add(this.lJq);
        this.lJr = new com.baidu.tieba.pb.pb.sub.a.d(this.lIA, com.baidu.tieba.pb.pb.sub.b.b.lKi);
        this.bky.add(this.lJr);
        this.bky.add(new com.baidu.tieba.pb.pb.sub.a.c(this.lIA, com.baidu.tieba.pb.pb.sub.b.a.lKh));
        this.gih.addAdapters(this.bky);
    }

    public void a(bw bwVar, List<q> list) {
        this.lJq.setThreadData(bwVar);
        if (!at.isEmpty(this.lIA.dpw().dlw())) {
            this.lJq.Qh(this.lIA.dpw().dlw());
        }
        this.gih.setData(list);
        this.gih.getAdapter().notifyDataSetChanged();
    }

    public boolean aGJ() {
        return this.idT;
    }

    public void setHasMoreData(boolean z) {
        this.idT = z;
    }

    public void B(View.OnClickListener onClickListener) {
        this.aZX = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.lJq.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lJq.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.lJt = z;
    }

    public void notifyDataSetChanged() {
        if (this.gih.getAdapter() != null) {
            this.gih.getAdapter().notifyDataSetChanged();
        }
    }
}

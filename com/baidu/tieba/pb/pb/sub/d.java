package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private NewSubPbActivity fSn;
    private com.baidu.tieba.pb.pb.sub.a.b fTb;
    private com.baidu.tieba.pb.pb.sub.a.d fTc;
    private n fTd;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean cNB = false;
    private boolean fTe = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.fSn = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.fTb = new com.baidu.tieba.pb.pb.sub.a.b(this.fSn, PostData.gVA);
        this.fTb.q(this.mCommonClickListener);
        this.fTb.setOnAdapterItemClickListener(this.fTd);
        this.fTb.setFromCDN(this.fTe);
        this.mAdapters.add(this.fTb);
        this.fTc = new com.baidu.tieba.pb.pb.sub.a.d(this.fSn, com.baidu.tieba.pb.pb.sub.b.b.fTP);
        this.mAdapters.add(this.fTc);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.fSn, com.baidu.tieba.pb.pb.sub.b.a.fTO));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void a(bb bbVar, List<h> list) {
        this.fTb.aa(bbVar);
        this.mListView.setData(list);
        this.mListView.getAdapter().notifyDataSetChanged();
    }

    public boolean aiH() {
        return this.cNB;
    }

    public void setHasMoreData(boolean z) {
        this.cNB = z;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.fTb.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fTb.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.fTe = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

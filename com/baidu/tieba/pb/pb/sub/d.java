package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private NewSubPbActivity hTL;
    private com.baidu.tieba.pb.pb.sub.a.b hUE;
    private com.baidu.tieba.pb.pb.sub.a.d hUF;
    private s hUG;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean eGD = false;
    private boolean hUH = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.hTL = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.hUE = new com.baidu.tieba.pb.pb.sub.a.b(this.hTL, PostData.iYC);
        this.hUE.v(this.mCommonClickListener);
        this.hUE.setOnAdapterItemClickListener(this.hUG);
        this.hUE.setFromCDN(this.hUH);
        this.mAdapters.add(this.hUE);
        this.hUF = new com.baidu.tieba.pb.pb.sub.a.d(this.hTL, com.baidu.tieba.pb.pb.sub.b.b.hVu);
        this.mAdapters.add(this.hUF);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.hTL, com.baidu.tieba.pb.pb.sub.b.a.hVt));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void b(bg bgVar, List<m> list) {
        this.hUE.ai(bgVar);
        if (this.hTL.bWb().bTx()) {
            this.hUE.BE(this.hTL.bWb().bSH());
        }
        this.mListView.setData(list);
        this.mListView.getAdapter().notifyDataSetChanged();
    }

    public boolean JO() {
        return this.eGD;
    }

    public void setHasMoreData(boolean z) {
        this.eGD = z;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.hUE.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hUE.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.hUH = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

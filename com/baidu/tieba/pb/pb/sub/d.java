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
    private NewSubPbActivity hBH;
    private com.baidu.tieba.pb.pb.sub.a.b hCA;
    private com.baidu.tieba.pb.pb.sub.a.d hCB;
    private s hCC;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean eqU = false;
    private boolean hCD = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.hBH = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.hCA = new com.baidu.tieba.pb.pb.sub.a.b(this.hBH, PostData.iFM);
        this.hCA.t(this.mCommonClickListener);
        this.hCA.setOnAdapterItemClickListener(this.hCC);
        this.hCA.setFromCDN(this.hCD);
        this.mAdapters.add(this.hCA);
        this.hCB = new com.baidu.tieba.pb.pb.sub.a.d(this.hBH, com.baidu.tieba.pb.pb.sub.b.b.hDq);
        this.mAdapters.add(this.hCB);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.hBH, com.baidu.tieba.pb.pb.sub.b.a.hDp));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void b(bg bgVar, List<m> list) {
        this.hCA.ai(bgVar);
        if (this.hBH.bOf().bLD()) {
            this.hCA.Ao(this.hBH.bOf().bKN());
        }
        this.mListView.setData(list);
        this.mListView.getAdapter().notifyDataSetChanged();
    }

    public boolean Hy() {
        return this.eqU;
    }

    public void setHasMoreData(boolean z) {
        this.eqU = z;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.hCA.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hCA.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.hCD = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

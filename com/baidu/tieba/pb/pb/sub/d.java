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
    private NewSubPbActivity hBV;
    private com.baidu.tieba.pb.pb.sub.a.b hCO;
    private com.baidu.tieba.pb.pb.sub.a.d hCP;
    private s hCQ;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean eri = false;
    private boolean hCR = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.hBV = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.hCO = new com.baidu.tieba.pb.pb.sub.a.b(this.hBV, PostData.iGc);
        this.hCO.t(this.mCommonClickListener);
        this.hCO.setOnAdapterItemClickListener(this.hCQ);
        this.hCO.setFromCDN(this.hCR);
        this.mAdapters.add(this.hCO);
        this.hCP = new com.baidu.tieba.pb.pb.sub.a.d(this.hBV, com.baidu.tieba.pb.pb.sub.b.b.hDE);
        this.mAdapters.add(this.hCP);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.hBV, com.baidu.tieba.pb.pb.sub.b.a.hDD));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void b(bg bgVar, List<m> list) {
        this.hCO.aj(bgVar);
        if (this.hBV.bOi().bLG()) {
            this.hCO.Ap(this.hBV.bOi().bKQ());
        }
        this.mListView.setData(list);
        this.mListView.getAdapter().notifyDataSetChanged();
    }

    public boolean HA() {
        return this.eri;
    }

    public void setHasMoreData(boolean z) {
        this.eri = z;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.hCO.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hCO.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.hCR = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

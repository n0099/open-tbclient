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
    private NewSubPbActivity hTI;
    private com.baidu.tieba.pb.pb.sub.a.b hUB;
    private com.baidu.tieba.pb.pb.sub.a.d hUC;
    private s hUD;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean eGC = false;
    private boolean hUE = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.hTI = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.hUB = new com.baidu.tieba.pb.pb.sub.a.b(this.hTI, PostData.iYA);
        this.hUB.v(this.mCommonClickListener);
        this.hUB.setOnAdapterItemClickListener(this.hUD);
        this.hUB.setFromCDN(this.hUE);
        this.mAdapters.add(this.hUB);
        this.hUC = new com.baidu.tieba.pb.pb.sub.a.d(this.hTI, com.baidu.tieba.pb.pb.sub.b.b.hVr);
        this.mAdapters.add(this.hUC);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.hTI, com.baidu.tieba.pb.pb.sub.b.a.hVq));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void b(bg bgVar, List<m> list) {
        this.hUB.ai(bgVar);
        if (this.hTI.bVY().bTu()) {
            this.hUB.BE(this.hTI.bVY().bSE());
        }
        this.mListView.setData(list);
        this.mListView.getAdapter().notifyDataSetChanged();
    }

    public boolean JO() {
        return this.eGC;
    }

    public void setHasMoreData(boolean z) {
        this.eGC = z;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.hUB.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hUB.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.hUE = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

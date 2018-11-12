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
/* loaded from: classes6.dex */
public class d {
    private com.baidu.tieba.pb.pb.sub.a.b gbY;
    private com.baidu.tieba.pb.pb.sub.a.d gbZ;
    private NewSubPbActivity gbk;
    private n gca;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean cWY = false;
    private boolean gcb = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.gbk = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.gbY = new com.baidu.tieba.pb.pb.sub.a.b(this.gbk, PostData.het);
        this.gbY.s(this.mCommonClickListener);
        this.gbY.setOnAdapterItemClickListener(this.gca);
        this.gbY.setFromCDN(this.gcb);
        this.mAdapters.add(this.gbY);
        this.gbZ = new com.baidu.tieba.pb.pb.sub.a.d(this.gbk, com.baidu.tieba.pb.pb.sub.b.b.gcM);
        this.mAdapters.add(this.gbZ);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.gbk, com.baidu.tieba.pb.pb.sub.b.a.gcL));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void a(bb bbVar, List<h> list) {
        this.gbY.aa(bbVar);
        this.mListView.setData(list);
        this.mListView.getAdapter().notifyDataSetChanged();
    }

    public boolean hasMoreData() {
        return this.cWY;
    }

    public void setHasMoreData(boolean z) {
        this.cWY = z;
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.gbY.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.gbY.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.gcb = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

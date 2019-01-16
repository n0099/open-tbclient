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
    private NewSubPbActivity glW;
    private com.baidu.tieba.pb.pb.sub.a.b gmK;
    private com.baidu.tieba.pb.pb.sub.a.d gmL;
    private n gmM;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean dhm = false;
    private boolean gmN = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.glW = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.gmK = new com.baidu.tieba.pb.pb.sub.a.b(this.glW, PostData.hpD);
        this.gmK.s(this.mCommonClickListener);
        this.gmK.setOnAdapterItemClickListener(this.gmM);
        this.gmK.setFromCDN(this.gmN);
        this.mAdapters.add(this.gmK);
        this.gmL = new com.baidu.tieba.pb.pb.sub.a.d(this.glW, com.baidu.tieba.pb.pb.sub.b.b.gny);
        this.mAdapters.add(this.gmL);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.glW, com.baidu.tieba.pb.pb.sub.b.a.gnx));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void a(bb bbVar, List<h> list) {
        this.gmK.aa(bbVar);
        this.mListView.setData(list);
        this.mListView.getAdapter().notifyDataSetChanged();
    }

    public boolean hasMoreData() {
        return this.dhm;
    }

    public void setHasMoreData(boolean z) {
        this.dhm = z;
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.gmK.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.gmK.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.gmN = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

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
    private NewSubPbActivity glX;
    private com.baidu.tieba.pb.pb.sub.a.b gmL;
    private com.baidu.tieba.pb.pb.sub.a.d gmM;
    private n gmN;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean dhn = false;
    private boolean gmO = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.glX = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.gmL = new com.baidu.tieba.pb.pb.sub.a.b(this.glX, PostData.hpE);
        this.gmL.s(this.mCommonClickListener);
        this.gmL.setOnAdapterItemClickListener(this.gmN);
        this.gmL.setFromCDN(this.gmO);
        this.mAdapters.add(this.gmL);
        this.gmM = new com.baidu.tieba.pb.pb.sub.a.d(this.glX, com.baidu.tieba.pb.pb.sub.b.b.gnz);
        this.mAdapters.add(this.gmM);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.glX, com.baidu.tieba.pb.pb.sub.b.a.gny));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void a(bb bbVar, List<h> list) {
        this.gmL.aa(bbVar);
        this.mListView.setData(list);
        this.mListView.getAdapter().notifyDataSetChanged();
    }

    public boolean hasMoreData() {
        return this.dhn;
    }

    public void setHasMoreData(boolean z) {
        this.dhn = z;
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.gmL.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.gmL.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.gmO = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

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
    private com.baidu.tieba.pb.pb.sub.a.b giQ;
    private com.baidu.tieba.pb.pb.sub.a.d giR;
    private n giS;
    private NewSubPbActivity gib;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean ddJ = false;
    private boolean giT = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.gib = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.giQ = new com.baidu.tieba.pb.pb.sub.a.b(this.gib, PostData.hln);
        this.giQ.s(this.mCommonClickListener);
        this.giQ.setOnAdapterItemClickListener(this.giS);
        this.giQ.setFromCDN(this.giT);
        this.mAdapters.add(this.giQ);
        this.giR = new com.baidu.tieba.pb.pb.sub.a.d(this.gib, com.baidu.tieba.pb.pb.sub.b.b.gjE);
        this.mAdapters.add(this.giR);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.gib, com.baidu.tieba.pb.pb.sub.b.a.gjD));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void a(bb bbVar, List<h> list) {
        this.giQ.aa(bbVar);
        this.mListView.setData(list);
        this.mListView.getAdapter().notifyDataSetChanged();
    }

    public boolean hasMoreData() {
        return this.ddJ;
    }

    public void setHasMoreData(boolean z) {
        this.ddJ = z;
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.giQ.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.giQ.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.giT = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

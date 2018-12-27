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
    private NewSubPbActivity gkT;
    private com.baidu.tieba.pb.pb.sub.a.b glH;
    private com.baidu.tieba.pb.pb.sub.a.d glI;
    private n glJ;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean dgA = false;
    private boolean glK = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.gkT = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.glH = new com.baidu.tieba.pb.pb.sub.a.b(this.gkT, PostData.hoy);
        this.glH.s(this.mCommonClickListener);
        this.glH.setOnAdapterItemClickListener(this.glJ);
        this.glH.setFromCDN(this.glK);
        this.mAdapters.add(this.glH);
        this.glI = new com.baidu.tieba.pb.pb.sub.a.d(this.gkT, com.baidu.tieba.pb.pb.sub.b.b.gmv);
        this.mAdapters.add(this.glI);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.gkT, com.baidu.tieba.pb.pb.sub.b.a.gmu));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void a(bb bbVar, List<h> list) {
        this.glH.aa(bbVar);
        this.mListView.setData(list);
        this.mListView.getAdapter().notifyDataSetChanged();
    }

    public boolean hasMoreData() {
        return this.dgA;
    }

    public void setHasMoreData(boolean z) {
        this.dgA = z;
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.glH.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.glH.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.glK = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

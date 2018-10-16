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
    private NewSubPbActivity fZN;
    private com.baidu.tieba.pb.pb.sub.a.b gaB;
    private com.baidu.tieba.pb.pb.sub.a.d gaC;
    private n gaD;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean cVS = false;
    private boolean gaE = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.fZN = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.gaB = new com.baidu.tieba.pb.pb.sub.a.b(this.fZN, PostData.hcV);
        this.gaB.q(this.mCommonClickListener);
        this.gaB.setOnAdapterItemClickListener(this.gaD);
        this.gaB.setFromCDN(this.gaE);
        this.mAdapters.add(this.gaB);
        this.gaC = new com.baidu.tieba.pb.pb.sub.a.d(this.fZN, com.baidu.tieba.pb.pb.sub.b.b.gbp);
        this.mAdapters.add(this.gaC);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.fZN, com.baidu.tieba.pb.pb.sub.b.a.gbo));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void a(bb bbVar, List<h> list) {
        this.gaB.aa(bbVar);
        this.mListView.setData(list);
        this.mListView.getAdapter().notifyDataSetChanged();
    }

    public boolean hasMoreData() {
        return this.cVS;
    }

    public void setHasMoreData(boolean z) {
        this.cVS = z;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.gaB.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.gaB.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.gaE = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

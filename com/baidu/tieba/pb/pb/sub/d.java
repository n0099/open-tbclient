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
    private NewSubPbActivity fZO;
    private com.baidu.tieba.pb.pb.sub.a.b gaC;
    private com.baidu.tieba.pb.pb.sub.a.d gaD;
    private n gaE;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean cVS = false;
    private boolean gaF = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.fZO = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.gaC = new com.baidu.tieba.pb.pb.sub.a.b(this.fZO, PostData.hcW);
        this.gaC.q(this.mCommonClickListener);
        this.gaC.setOnAdapterItemClickListener(this.gaE);
        this.gaC.setFromCDN(this.gaF);
        this.mAdapters.add(this.gaC);
        this.gaD = new com.baidu.tieba.pb.pb.sub.a.d(this.fZO, com.baidu.tieba.pb.pb.sub.b.b.gbq);
        this.mAdapters.add(this.gaD);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.fZO, com.baidu.tieba.pb.pb.sub.b.a.gbp));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void a(bb bbVar, List<h> list) {
        this.gaC.aa(bbVar);
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
        this.gaC.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.gaC.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.gaF = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

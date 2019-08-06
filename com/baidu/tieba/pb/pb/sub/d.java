package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private NewSubPbActivity iaW;
    private com.baidu.tieba.pb.pb.sub.a.b ibP;
    private com.baidu.tieba.pb.pb.sub.a.d ibQ;
    private s ibR;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean eLG = false;
    private boolean ibS = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.iaW = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.ibP = new com.baidu.tieba.pb.pb.sub.a.b(this.iaW, PostData.jge);
        this.ibP.v(this.mCommonClickListener);
        this.ibP.setOnAdapterItemClickListener(this.ibR);
        this.ibP.setFromCDN(this.ibS);
        this.mAdapters.add(this.ibP);
        this.ibQ = new com.baidu.tieba.pb.pb.sub.a.d(this.iaW, com.baidu.tieba.pb.pb.sub.b.b.icF);
        this.mAdapters.add(this.ibQ);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.iaW, com.baidu.tieba.pb.pb.sub.b.a.icE));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void b(bh bhVar, List<m> list) {
        this.ibP.aj(bhVar);
        if (this.iaW.bZh().bWB()) {
            this.ibP.Ct(this.iaW.bZh().bVK());
        }
        this.mListView.setData(list);
        this.mListView.getAdapter().notifyDataSetChanged();
    }

    public boolean KB() {
        return this.eLG;
    }

    public void setHasMoreData(boolean z) {
        this.eLG = z;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.ibP.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.ibP.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.ibS = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

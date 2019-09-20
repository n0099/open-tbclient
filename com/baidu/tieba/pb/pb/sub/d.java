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
    private NewSubPbActivity icU;
    private com.baidu.tieba.pb.pb.sub.a.b idR;
    private com.baidu.tieba.pb.pb.sub.a.d idS;
    private s idT;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean eNp = false;
    private boolean idU = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.icU = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.idR = new com.baidu.tieba.pb.pb.sub.a.b(this.icU, PostData.jiA);
        this.idR.v(this.mCommonClickListener);
        this.idR.setOnAdapterItemClickListener(this.idT);
        this.idR.setFromCDN(this.idU);
        this.mAdapters.add(this.idR);
        this.idS = new com.baidu.tieba.pb.pb.sub.a.d(this.icU, com.baidu.tieba.pb.pb.sub.b.b.ieH);
        this.mAdapters.add(this.idS);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.icU, com.baidu.tieba.pb.pb.sub.b.a.ieG));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void b(bh bhVar, List<m> list) {
        this.idR.ak(bhVar);
        if (this.icU.bZV().bXo()) {
            this.idR.CS(this.icU.bZV().bWx());
        }
        this.mListView.setData(list);
        this.mListView.getAdapter().notifyDataSetChanged();
    }

    public boolean KF() {
        return this.eNp;
    }

    public void setHasMoreData(boolean z) {
        this.eNp = z;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.idR.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.idR.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.idU = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

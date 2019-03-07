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
    private com.baidu.tieba.pb.pb.sub.a.b hCT;
    private com.baidu.tieba.pb.pb.sub.a.d hCU;
    private s hCV;
    private NewSubPbActivity hCa;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean erm = false;
    private boolean hCW = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.hCa = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.hCT = new com.baidu.tieba.pb.pb.sub.a.b(this.hCa, PostData.iGj);
        this.hCT.t(this.mCommonClickListener);
        this.hCT.setOnAdapterItemClickListener(this.hCV);
        this.hCT.setFromCDN(this.hCW);
        this.mAdapters.add(this.hCT);
        this.hCU = new com.baidu.tieba.pb.pb.sub.a.d(this.hCa, com.baidu.tieba.pb.pb.sub.b.b.hDJ);
        this.mAdapters.add(this.hCU);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.hCa, com.baidu.tieba.pb.pb.sub.b.a.hDI));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void b(bg bgVar, List<m> list) {
        this.hCT.aj(bgVar);
        if (this.hCa.bOh().bLG()) {
            this.hCT.Aq(this.hCa.bOh().bKQ());
        }
        this.mListView.setData(list);
        this.mListView.getAdapter().notifyDataSetChanged();
    }

    public boolean HA() {
        return this.erm;
    }

    public void setHasMoreData(boolean z) {
        this.erm = z;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.hCT.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hCT.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.hCW = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

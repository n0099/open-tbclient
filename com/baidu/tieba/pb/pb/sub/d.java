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
    private com.baidu.tieba.pb.pb.sub.a.b hCU;
    private com.baidu.tieba.pb.pb.sub.a.d hCV;
    private s hCW;
    private NewSubPbActivity hCb;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean erm = false;
    private boolean hCX = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.hCb = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.hCU = new com.baidu.tieba.pb.pb.sub.a.b(this.hCb, PostData.iGk);
        this.hCU.t(this.mCommonClickListener);
        this.hCU.setOnAdapterItemClickListener(this.hCW);
        this.hCU.setFromCDN(this.hCX);
        this.mAdapters.add(this.hCU);
        this.hCV = new com.baidu.tieba.pb.pb.sub.a.d(this.hCb, com.baidu.tieba.pb.pb.sub.b.b.hDK);
        this.mAdapters.add(this.hCV);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.hCb, com.baidu.tieba.pb.pb.sub.b.a.hDJ));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void b(bg bgVar, List<m> list) {
        this.hCU.aj(bgVar);
        if (this.hCb.bOi().bLH()) {
            this.hCU.Ar(this.hCb.bOi().bKR());
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
        this.hCU.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hCU.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.hCX = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

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
    private NewSubPbActivity hZZ;
    private com.baidu.tieba.pb.pb.sub.a.b iaS;
    private com.baidu.tieba.pb.pb.sub.a.d iaT;
    private s iaU;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean eLz = false;
    private boolean iaV = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.hZZ = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.iaS = new com.baidu.tieba.pb.pb.sub.a.b(this.hZZ, PostData.jeX);
        this.iaS.v(this.mCommonClickListener);
        this.iaS.setOnAdapterItemClickListener(this.iaU);
        this.iaS.setFromCDN(this.iaV);
        this.mAdapters.add(this.iaS);
        this.iaT = new com.baidu.tieba.pb.pb.sub.a.d(this.hZZ, com.baidu.tieba.pb.pb.sub.b.b.ibI);
        this.mAdapters.add(this.iaT);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.hZZ, com.baidu.tieba.pb.pb.sub.b.a.ibH));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void b(bg bgVar, List<m> list) {
        this.iaS.ai(bgVar);
        if (this.hZZ.bYQ().bWl()) {
            this.iaS.Cs(this.hZZ.bYQ().bVu());
        }
        this.mListView.setData(list);
        this.mListView.getAdapter().notifyDataSetChanged();
    }

    public boolean KB() {
        return this.eLz;
    }

    public void setHasMoreData(boolean z) {
        this.eLz = z;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.iaS.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.iaS.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.iaV = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

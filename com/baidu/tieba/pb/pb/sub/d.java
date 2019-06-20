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
    private NewSubPbActivity hTM;
    private com.baidu.tieba.pb.pb.sub.a.b hUF;
    private com.baidu.tieba.pb.pb.sub.a.d hUG;
    private s hUH;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private View.OnClickListener mCommonClickListener = null;
    private boolean eGD = false;
    private boolean hUI = true;

    public d(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.hTM = newSubPbActivity;
        this.mListView = bdTypeListView;
    }

    public void initAdapters() {
        this.hUF = new com.baidu.tieba.pb.pb.sub.a.b(this.hTM, PostData.iYG);
        this.hUF.v(this.mCommonClickListener);
        this.hUF.setOnAdapterItemClickListener(this.hUH);
        this.hUF.setFromCDN(this.hUI);
        this.mAdapters.add(this.hUF);
        this.hUG = new com.baidu.tieba.pb.pb.sub.a.d(this.hTM, com.baidu.tieba.pb.pb.sub.b.b.hVv);
        this.mAdapters.add(this.hUG);
        this.mAdapters.add(new com.baidu.tieba.pb.pb.sub.a.c(this.hTM, com.baidu.tieba.pb.pb.sub.b.a.hVu));
        this.mListView.addAdapters(this.mAdapters);
    }

    public void b(bg bgVar, List<m> list) {
        this.hUF.ai(bgVar);
        if (this.hTM.bWc().bTy()) {
            this.hUF.BG(this.hTM.bWc().bSI());
        }
        this.mListView.setData(list);
        this.mListView.getAdapter().notifyDataSetChanged();
    }

    public boolean JO() {
        return this.eGD;
    }

    public void setHasMoreData(boolean z) {
        this.eGD = z;
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.hUF.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hUF.setOnImageClickListener(hVar);
    }

    public void setFromCDN(boolean z) {
        this.hUI = z;
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}

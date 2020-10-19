package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    private BdTypeListView fSo;
    private com.baidu.tieba.pb.pb.sub.a.b lqV;
    private com.baidu.tieba.pb.pb.sub.a.d lqW;
    private ab lqX;
    private NewSubPbActivity lqf;
    private List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private View.OnClickListener aXk = null;
    private boolean hLv = false;
    private boolean lqY = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.lqf = newSubPbActivity;
        this.fSo = bdTypeListView;
    }

    public void Le() {
        this.lqV = new com.baidu.tieba.pb.pb.sub.a.b(this.lqf, PostData.mEh);
        this.lqV.A(this.aXk);
        this.lqV.a(this.lqX);
        this.lqV.setFromCDN(this.lqY);
        this.bhH.add(this.lqV);
        this.lqW = new com.baidu.tieba.pb.pb.sub.a.d(this.lqf, com.baidu.tieba.pb.pb.sub.b.b.lrN);
        this.bhH.add(this.lqW);
        this.bhH.add(new com.baidu.tieba.pb.pb.sub.a.c(this.lqf, com.baidu.tieba.pb.pb.sub.b.a.lrM));
        this.fSo.addAdapters(this.bhH);
    }

    public void a(bw bwVar, List<q> list) {
        this.lqV.setThreadData(bwVar);
        if (!at.isEmpty(this.lqf.djM().dfN())) {
            this.lqV.Ps(this.lqf.djM().dfN());
        }
        this.fSo.setData(list);
        this.fSo.getAdapter().notifyDataSetChanged();
    }

    public boolean aCp() {
        return this.hLv;
    }

    public void setHasMoreData(boolean z) {
        this.hLv = z;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aXk = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.lqV.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lqV.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.lqY = z;
    }

    public void notifyDataSetChanged() {
        if (this.fSo.getAdapter() != null) {
            this.fSo.getAdapter().notifyDataSetChanged();
        }
    }
}

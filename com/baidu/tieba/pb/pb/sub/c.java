package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private BdTypeListView efM;
    private NewSubPbActivity iPX;
    private com.baidu.tieba.pb.pb.sub.a.b iQN;
    private com.baidu.tieba.pb.pb.sub.a.d iQO;
    private s iQP;
    private List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private View.OnClickListener ahD = null;
    private boolean fJM = false;
    private boolean iQQ = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.iPX = newSubPbActivity;
        this.efM = bdTypeListView;
    }

    public void uR() {
        this.iQN = new com.baidu.tieba.pb.pb.sub.a.b(this.iPX, PostData.kbJ);
        this.iQN.y(this.ahD);
        this.iQN.a(this.iQP);
        this.iQN.setFromCDN(this.iQQ);
        this.aoz.add(this.iQN);
        this.iQO = new com.baidu.tieba.pb.pb.sub.a.d(this.iPX, com.baidu.tieba.pb.pb.sub.b.b.iRH);
        this.aoz.add(this.iQO);
        this.aoz.add(new com.baidu.tieba.pb.pb.sub.a.c(this.iPX, com.baidu.tieba.pb.pb.sub.b.a.iRG));
        this.efM.addAdapters(this.aoz);
    }

    public void b(bj bjVar, List<m> list) {
        this.iQN.setThreadData(bjVar);
        if (this.iPX.coP().clO()) {
            this.iQN.FV(this.iPX.coP().ckT());
        }
        this.efM.setData(list);
        this.efM.getAdapter().notifyDataSetChanged();
    }

    public boolean Zn() {
        return this.fJM;
    }

    public void setHasMoreData(boolean z) {
        this.fJM = z;
    }

    public void y(View.OnClickListener onClickListener) {
        this.ahD = onClickListener;
    }

    public void setLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.iQN.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.iQN.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.iQQ = z;
    }

    public void notifyDataSetChanged() {
        if (this.efM.getAdapter() != null) {
            this.efM.getAdapter().notifyDataSetChanged();
        }
    }
}

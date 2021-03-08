package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private BdTypeListView gAY;
    private NewSubPbActivity miU;
    private com.baidu.tieba.pb.pb.sub.adapter.b mjK;
    private SubPbReplyAdapter mjL;
    private w mjM;
    private List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private View.OnClickListener bdi = null;
    private boolean iEY = false;
    private boolean mjN = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.miU = newSubPbActivity;
        this.gAY = bdTypeListView;
    }

    public void Kz() {
        this.mjK = new com.baidu.tieba.pb.pb.sub.adapter.b(this.miU, PostData.nzd);
        this.mjK.C(this.bdi);
        this.mjK.a(this.mjM);
        this.mjK.setFromCDN(this.mjN);
        this.boS.add(this.mjK);
        this.mjL = new SubPbReplyAdapter(this.miU, com.baidu.tieba.pb.pb.sub.a.b.mkG);
        this.boS.add(this.mjL);
        this.boS.add(new com.baidu.tieba.pb.pb.sub.adapter.c(this.miU, com.baidu.tieba.pb.pb.sub.a.a.mkF));
        this.gAY.addAdapters(this.boS);
    }

    public void a(cb cbVar, List<n> list) {
        this.mjK.setThreadData(cbVar);
        if (!au.isEmpty(this.miU.dsQ().doI())) {
            this.mjK.Qh(this.miU.dsQ().doI());
        }
        if (this.miU != null && this.miU.dsQ() != null) {
            this.mjK.uT(this.miU.dsQ().dtL());
        }
        this.gAY.setData(list);
        this.gAY.getAdapter().notifyDataSetChanged();
    }

    public boolean aHw() {
        return this.iEY;
    }

    public void setHasMoreData(boolean z) {
        this.iEY = z;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bdi = onClickListener;
    }

    public void c(View.OnLongClickListener onLongClickListener) {
        this.mjK.setOnLongClickListener(onLongClickListener);
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.mjK.setOnImageClickListener(iVar);
    }

    public void setFromCDN(boolean z) {
        this.mjN = z;
    }

    public void notifyDataSetChanged() {
        if (this.gAY.getAdapter() != null) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }
}

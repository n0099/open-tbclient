package com.baidu.tieba.pb.videopb;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.g;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private ArrayList<m> eea;
    private BdTypeRecyclerView gnE;
    private ReplyFragment iTS;
    private k izj;
    private com.baidu.tieba.pb.pb.a.d izs;
    private com.baidu.tieba.pb.data.f izv;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private String amQ = null;
    private boolean izw = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener izF = null;
    private View.OnClickListener ahD = null;
    private TbRichTextView.i dIi = null;
    private com.baidu.tieba.pb.a.c dmm = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iTS = replyFragment;
        this.gnE = bdTypeRecyclerView;
        uR();
    }

    private void uR() {
        this.izj = new k(this.iTS.ckD(), PostData.kbJ);
        this.izj.a((TbRichTextView.c) this.iTS.ckD());
        this.izs = new com.baidu.tieba.pb.pb.a.d(this.iTS.ckD(), PostData.kbO);
        this.aoz.add(this.izj);
        this.aoz.add(this.izs);
        this.gnE.addAdapters(this.aoz);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.izv = fVar;
            if (fVar != null && fVar.chK() != null && fVar.chK().azE() != null) {
                this.amQ = fVar.chK().azE().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.izv != null && this.izv.chM() != null && this.izv.chM().size() > 0) {
                this.postList.addAll(this.izv.chM());
            }
            this.izj.setData(fVar);
            this.izj.setFromCDN(this.mIsFromCDN);
            this.izj.dv(this.amQ);
            this.izj.ph(this.izw);
            this.izj.y(this.ahD);
            this.izj.P(this.izF);
            this.izj.setOnImageClickListener(this.dIi);
            this.izj.setOnLongClickListener(this.mOnLongClickListener);
            this.izj.setTbGestureDetector(this.dmm);
            this.izs.setOnClickListener(this.ahD);
            ArrayList<m> arrayList = new ArrayList<>(fVar.chM());
            Iterator<m> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                m next = it.next();
                if ((next instanceof PostData) && ((PostData) next).cIt() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.gnE != null) {
                this.eea = arrayList;
                this.gnE.setData(this.eea);
            }
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void P(View.OnClickListener onClickListener) {
        this.izF = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dIi = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dmm = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.ahD = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.gnE.getAdapter() instanceof g) {
            this.gnE.getAdapter().notifyDataSetChanged();
        }
    }

    public ArrayList<m> getDataList() {
        return this.eea;
    }
}

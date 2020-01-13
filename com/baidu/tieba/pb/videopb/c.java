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
/* loaded from: classes7.dex */
public class c {
    private ArrayList<m> eei;
    private BdTypeRecyclerView gqN;
    private k iCN;
    private com.baidu.tieba.pb.pb.a.d iCW;
    private com.baidu.tieba.pb.data.f iCZ;
    private ReplyFragment iXv;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private String anD = null;
    private boolean iDa = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener iDj = null;
    private View.OnClickListener ain = null;
    private TbRichTextView.i dIr = null;
    private com.baidu.tieba.pb.a.c dmA = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iXv = replyFragment;
        this.gqN = bdTypeRecyclerView;
        vi();
    }

    private void vi() {
        this.iCN = new k(this.iXv.clL(), PostData.kfm);
        this.iCN.a((TbRichTextView.c) this.iXv.clL());
        this.iCW = new com.baidu.tieba.pb.pb.a.d(this.iXv.clL(), PostData.kfr);
        this.apl.add(this.iCN);
        this.apl.add(this.iCW);
        this.gqN.addAdapters(this.apl);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.iCZ = fVar;
            if (fVar != null && fVar.ciS() != null && fVar.ciS().azX() != null) {
                this.anD = fVar.ciS().azX().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.iCZ != null && this.iCZ.ciU() != null && this.iCZ.ciU().size() > 0) {
                this.postList.addAll(this.iCZ.ciU());
            }
            this.iCN.setData(fVar);
            this.iCN.setFromCDN(this.mIsFromCDN);
            this.iCN.dx(this.anD);
            this.iCN.pt(this.iDa);
            this.iCN.x(this.ain);
            this.iCN.O(this.iDj);
            this.iCN.setOnImageClickListener(this.dIr);
            this.iCN.setOnLongClickListener(this.mOnLongClickListener);
            this.iCN.setTbGestureDetector(this.dmA);
            this.iCW.setOnClickListener(this.ain);
            ArrayList<m> arrayList = new ArrayList<>(fVar.ciU());
            Iterator<m> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                m next = it.next();
                if ((next instanceof PostData) && ((PostData) next).cJx() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.gqN != null) {
                this.eei = arrayList;
                this.gqN.setData(this.eei);
            }
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void O(View.OnClickListener onClickListener) {
        this.iDj = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dIr = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dmA = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.ain = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.gqN.getAdapter() instanceof g) {
            this.gqN.getAdapter().notifyDataSetChanged();
        }
    }

    public ArrayList<m> getDataList() {
        return this.eei;
    }
}

package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.d;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.pb.pb.main.l;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class PbFirstFloorCommentAndPraiseAdapter extends l<o, PbFirstFloorCommentAndPraiseViewHolder> {
    private static int aHt;
    private View.OnClickListener fgh;
    private final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> lSA;
    private c lSz;

    public PbFirstFloorCommentAndPraiseAdapter(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lSA = new LinkedList<>();
        if (bVar != null && bVar.dkd() != null) {
            aHt = bVar.dkd().dmP();
        }
        this.lSz = new c(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cD */
    public PbFirstFloorCommentAndPraiseViewHolder e(ViewGroup viewGroup) {
        PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.lSA.add(pbFirstFloorCommentAndPraiseViewHolder);
        return pbFirstFloorCommentAndPraiseViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, o oVar, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (o) pbFirstFloorCommentAndPraiseViewHolder);
        if (oVar != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
            pbFirstFloorCommentAndPraiseViewHolder.lSB.setOnClickOutListener(this.fgh);
            pbFirstFloorCommentAndPraiseViewHolder.lSB.setPostId(getPostId());
            pbFirstFloorCommentAndPraiseViewHolder.lSB.setForumId(getForumId());
            pbFirstFloorCommentAndPraiseViewHolder.b(oVar);
        }
        return view;
    }

    public void onDestroy() {
        dpx();
        if (this.lSz != null) {
            this.lSz.onDestroy();
        }
    }

    private void dpx() {
        Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.lSA.iterator();
        while (it.hasNext()) {
            PbFirstFloorCommentAndPraiseViewHolder next = it.next();
            if (next != null && next.lSB != null) {
                next.lSB.onDestroy();
            }
        }
    }

    public void Bn(String str) {
        if (this.lSA.size() > 0) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.lSA.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && next.lSB != null) {
                    next.lSB.Bn(str);
                }
            }
        } else if (dpy() != null) {
            this.lSz.e(dpy().bpr());
        }
    }

    private String getPostId() {
        bz dpy = dpy();
        return dpy != null ? dpy.bnN() : "";
    }

    private String getForumId() {
        return this.lHa.dkd() != null ? this.lHa.dkd().getForumId() : "";
    }

    private bz dpy() {
        if (this.lHa.dkd() == null || this.lHa.dkd().getPbData() == null) {
            return null;
        }
        return this.lHa.dkd().getPbData().diN();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fgh = onClickListener;
    }

    /* loaded from: classes2.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {
        public PbThreadCommentAndPraiseInfoLayout lSB;
        public View lSC;
        private int lSD;

        public PbFirstFloorCommentAndPraiseViewHolder(View view) {
            super(view);
            if (view != null) {
                this.lSB = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                d dVar = new d();
                dVar.eJO = 4;
                dVar.eJU = 7;
                dVar.eJP = this.lSD;
                dVar.eJS = PbFirstFloorCommentAndPraiseAdapter.aHt;
                this.lSB.setAgreeStatisticData(dVar);
                this.lSC = view.findViewById(R.id.bottom_divider_line);
                this.lSC.setVisibility(0);
            }
        }

        public void b(o oVar) {
            if (oVar != null && oVar.bkV() != null) {
                bz bkV = oVar.bkV();
                if (bkV.bpr() != null) {
                    bkV.bpr().postId = bkV.bnN();
                }
                this.lSB.a(bkV, oVar.getAnti());
                this.lSC.setVisibility(oVar.djI() ? 0 : 8);
                if (bkV.bmc() && bkV.bnO() != null) {
                    this.lSD = 2;
                } else {
                    this.lSD = 1;
                }
                if (oVar.lCL) {
                    getView().setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            ao.setBackgroundColor(this.lSC, R.color.CAM_X0203);
            this.lSB.onChangeSkinType();
        }
    }
}

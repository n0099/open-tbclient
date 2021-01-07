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
    private static int aMg;
    private View.OnClickListener fkS;
    private c lXd;
    private final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> lXe;

    public PbFirstFloorCommentAndPraiseAdapter(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lXe = new LinkedList<>();
        if (bVar != null && bVar.dnW() != null) {
            aMg = bVar.dnW().dqI();
        }
        this.lXd = new c(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cD */
    public PbFirstFloorCommentAndPraiseViewHolder e(ViewGroup viewGroup) {
        PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.lXe.add(pbFirstFloorCommentAndPraiseViewHolder);
        return pbFirstFloorCommentAndPraiseViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, o oVar, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (o) pbFirstFloorCommentAndPraiseViewHolder);
        if (oVar != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
            pbFirstFloorCommentAndPraiseViewHolder.lXf.setOnClickOutListener(this.fkS);
            pbFirstFloorCommentAndPraiseViewHolder.lXf.setPostId(getPostId());
            pbFirstFloorCommentAndPraiseViewHolder.lXf.setForumId(getForumId());
            pbFirstFloorCommentAndPraiseViewHolder.b(oVar);
        }
        return view;
    }

    public void onDestroy() {
        dtp();
        if (this.lXd != null) {
            this.lXd.onDestroy();
        }
    }

    private void dtp() {
        Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.lXe.iterator();
        while (it.hasNext()) {
            PbFirstFloorCommentAndPraiseViewHolder next = it.next();
            if (next != null && next.lXf != null) {
                next.lXf.onDestroy();
            }
        }
    }

    public void Cy(String str) {
        if (this.lXe.size() > 0) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.lXe.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && next.lXf != null) {
                    next.lXf.Cy(str);
                }
            }
        } else if (dtq() != null) {
            this.lXd.e(dtq().btl());
        }
    }

    private String getPostId() {
        bz dtq = dtq();
        return dtq != null ? dtq.brH() : "";
    }

    private String getForumId() {
        return this.lLE.dnW() != null ? this.lLE.dnW().getForumId() : "";
    }

    private bz dtq() {
        if (this.lLE.dnW() == null || this.lLE.dnW().getPbData() == null) {
            return null;
        }
        return this.lLE.dnW().getPbData().dmF();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fkS = onClickListener;
    }

    /* loaded from: classes2.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {
        public PbThreadCommentAndPraiseInfoLayout lXf;
        public View lXg;
        private int lXh;

        public PbFirstFloorCommentAndPraiseViewHolder(View view) {
            super(view);
            if (view != null) {
                this.lXf = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                d dVar = new d();
                dVar.eOz = 4;
                dVar.eOF = 7;
                dVar.eOA = this.lXh;
                dVar.eOD = PbFirstFloorCommentAndPraiseAdapter.aMg;
                this.lXf.setAgreeStatisticData(dVar);
                this.lXg = view.findViewById(R.id.bottom_divider_line);
                this.lXg.setVisibility(0);
            }
        }

        public void b(o oVar) {
            if (oVar != null && oVar.boP() != null) {
                bz boP = oVar.boP();
                if (boP.btl() != null) {
                    boP.btl().postId = boP.brH();
                }
                this.lXf.a(boP, oVar.getAnti());
                this.lXg.setVisibility(oVar.dnB() ? 0 : 8);
                if (boP.bpW() && boP.brI() != null) {
                    this.lXh = 2;
                } else {
                    this.lXh = 1;
                }
                if (oVar.lHq) {
                    getView().setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            ao.setBackgroundColor(this.lXg, R.color.CAM_X0203);
            this.lXf.onChangeSkinType();
        }
    }
}

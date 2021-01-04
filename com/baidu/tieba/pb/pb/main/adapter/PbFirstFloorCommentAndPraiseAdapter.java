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
    private c lXe;
    private final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> lXf;

    public PbFirstFloorCommentAndPraiseAdapter(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lXf = new LinkedList<>();
        if (bVar != null && bVar.dnV() != null) {
            aMg = bVar.dnV().dqH();
        }
        this.lXe = new c(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cD */
    public PbFirstFloorCommentAndPraiseViewHolder e(ViewGroup viewGroup) {
        PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.lXf.add(pbFirstFloorCommentAndPraiseViewHolder);
        return pbFirstFloorCommentAndPraiseViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, o oVar, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (o) pbFirstFloorCommentAndPraiseViewHolder);
        if (oVar != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
            pbFirstFloorCommentAndPraiseViewHolder.lXg.setOnClickOutListener(this.fkS);
            pbFirstFloorCommentAndPraiseViewHolder.lXg.setPostId(getPostId());
            pbFirstFloorCommentAndPraiseViewHolder.lXg.setForumId(getForumId());
            pbFirstFloorCommentAndPraiseViewHolder.b(oVar);
        }
        return view;
    }

    public void onDestroy() {
        dto();
        if (this.lXe != null) {
            this.lXe.onDestroy();
        }
    }

    private void dto() {
        Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.lXf.iterator();
        while (it.hasNext()) {
            PbFirstFloorCommentAndPraiseViewHolder next = it.next();
            if (next != null && next.lXg != null) {
                next.lXg.onDestroy();
            }
        }
    }

    public void Cz(String str) {
        if (this.lXf.size() > 0) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.lXf.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && next.lXg != null) {
                    next.lXg.Cz(str);
                }
            }
        } else if (dtp() != null) {
            this.lXe.e(dtp().btk());
        }
    }

    private String getPostId() {
        bz dtp = dtp();
        return dtp != null ? dtp.brG() : "";
    }

    private String getForumId() {
        return this.lLF.dnV() != null ? this.lLF.dnV().getForumId() : "";
    }

    private bz dtp() {
        if (this.lLF.dnV() == null || this.lLF.dnV().getPbData() == null) {
            return null;
        }
        return this.lLF.dnV().getPbData().dmE();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fkS = onClickListener;
    }

    /* loaded from: classes2.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {
        public PbThreadCommentAndPraiseInfoLayout lXg;
        public View lXh;
        private int lXi;

        public PbFirstFloorCommentAndPraiseViewHolder(View view) {
            super(view);
            if (view != null) {
                this.lXg = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                d dVar = new d();
                dVar.eOz = 4;
                dVar.eOF = 7;
                dVar.eOA = this.lXi;
                dVar.eOD = PbFirstFloorCommentAndPraiseAdapter.aMg;
                this.lXg.setAgreeStatisticData(dVar);
                this.lXh = view.findViewById(R.id.bottom_divider_line);
                this.lXh.setVisibility(0);
            }
        }

        public void b(o oVar) {
            if (oVar != null && oVar.boO() != null) {
                bz boO = oVar.boO();
                if (boO.btk() != null) {
                    boO.btk().postId = boO.brG();
                }
                this.lXg.a(boO, oVar.getAnti());
                this.lXh.setVisibility(oVar.dnA() ? 0 : 8);
                if (boO.bpV() && boO.brH() != null) {
                    this.lXi = 2;
                } else {
                    this.lXi = 1;
                }
                if (oVar.lHr) {
                    getView().setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            ao.setBackgroundColor(this.lXh, R.color.CAM_X0203);
            this.lXg.onChangeSkinType();
        }
    }
}

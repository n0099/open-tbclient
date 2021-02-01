package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.e;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.l;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class PbFirstFloorCommentAndPraiseAdapter extends l<p, PbFirstFloorCommentAndPraiseViewHolder> {
    private static int aJY;
    private View.OnClickListener fiA;
    private boolean lLA;
    private c mby;
    private final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> mbz;

    public PbFirstFloorCommentAndPraiseAdapter(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.mbz = new LinkedList<>();
        this.lLA = false;
        if (bVar != null && bVar.dmq() != null) {
            aJY = bVar.dmq().dpe();
        }
        this.mby = new c(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cD */
    public PbFirstFloorCommentAndPraiseViewHolder e(ViewGroup viewGroup) {
        PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.mbz.add(pbFirstFloorCommentAndPraiseViewHolder);
        return pbFirstFloorCommentAndPraiseViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, p pVar, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) pVar, (p) pbFirstFloorCommentAndPraiseViewHolder);
        if (pVar != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
            pbFirstFloorCommentAndPraiseViewHolder.mbA.setOnClickOutListener(this.fiA);
            pbFirstFloorCommentAndPraiseViewHolder.mbA.setPostId(getPostId());
            pbFirstFloorCommentAndPraiseViewHolder.mbA.setForumId(getForumId());
            pVar.uI(this.lLA);
            pbFirstFloorCommentAndPraiseViewHolder.b(pVar);
        }
        return view;
    }

    public void onDestroy() {
        drL();
        if (this.mby != null) {
            this.mby.onDestroy();
        }
    }

    private void drL() {
        Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.mbz.iterator();
        while (it.hasNext()) {
            PbFirstFloorCommentAndPraiseViewHolder next = it.next();
            if (next != null && next.mbA != null) {
                next.mbA.onDestroy();
            }
        }
    }

    public void BE(String str) {
        if (this.mbz.size() > 0) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.mbz.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && next.mbA != null) {
                    next.mbA.BE(str);
                }
            }
        } else if (drM() != null) {
            this.mby.e(drM().bpJ());
        }
    }

    private String getPostId() {
        cb drM = drM();
        return drM != null ? drM.bog() : "";
    }

    private String getForumId() {
        return this.lPU.dmq() != null ? this.lPU.dmq().getForumId() : "";
    }

    private cb drM() {
        if (this.lPU.dmq() == null || this.lPU.dmq().getPbData() == null) {
            return null;
        }
        return this.lPU.dmq().getPbData().dkZ();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fiA = onClickListener;
    }

    public void vS(boolean z) {
        this.lLA = z;
    }

    /* loaded from: classes2.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {
        public PbThreadCommentAndPraiseInfoLayout mbA;
        public View mbB;
        private int mbC;

        public PbFirstFloorCommentAndPraiseViewHolder(View view) {
            super(view);
            if (view != null) {
                this.mbA = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                e eVar = new e();
                eVar.eMa = 4;
                eVar.eMg = 7;
                eVar.eMb = this.mbC;
                eVar.eMe = PbFirstFloorCommentAndPraiseAdapter.aJY;
                this.mbA.setAgreeStatisticData(eVar);
                this.mbB = view.findViewById(R.id.bottom_divider_line);
                this.mbB.setVisibility(0);
            }
        }

        public void b(p pVar) {
            if (pVar != null && pVar.bln() != null) {
                cb bln = pVar.bln();
                if (bln.bpJ() != null) {
                    bln.bpJ().postId = bln.bog();
                }
                this.mbA.a(bln, pVar.getAnti());
                this.mbB.setVisibility(pVar.dlU() ? 0 : 8);
                if (bln.bmv() && bln.boh() != null) {
                    this.mbC = 2;
                } else {
                    this.mbC = 1;
                }
                if (pVar.lLz) {
                    getView().setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
                this.mbA.showOperationMaskView(pVar.dlV());
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            ap.setBackgroundColor(this.mbB, R.color.CAM_X0203);
            this.mbA.onChangeSkinType();
        }
    }
}

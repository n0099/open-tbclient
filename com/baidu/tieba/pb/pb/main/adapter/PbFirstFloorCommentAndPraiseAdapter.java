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
    private static int aLy;
    private View.OnClickListener fjZ;
    private boolean lNR;
    private c mdP;
    private final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> mdQ;

    public PbFirstFloorCommentAndPraiseAdapter(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.mdQ = new LinkedList<>();
        this.lNR = false;
        if (bVar != null && bVar.dmG() != null) {
            aLy = bVar.dmG().dpu();
        }
        this.mdP = new c(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cC */
    public PbFirstFloorCommentAndPraiseViewHolder e(ViewGroup viewGroup) {
        PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.mdQ.add(pbFirstFloorCommentAndPraiseViewHolder);
        return pbFirstFloorCommentAndPraiseViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, p pVar, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) pVar, (p) pbFirstFloorCommentAndPraiseViewHolder);
        if (pVar != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
            pbFirstFloorCommentAndPraiseViewHolder.mdR.setOnClickOutListener(this.fjZ);
            pbFirstFloorCommentAndPraiseViewHolder.mdR.setPostId(getPostId());
            pbFirstFloorCommentAndPraiseViewHolder.mdR.setForumId(getForumId());
            pVar.uI(this.lNR);
            pbFirstFloorCommentAndPraiseViewHolder.b(pVar);
        }
        return view;
    }

    public void onDestroy() {
        dsb();
        if (this.mdP != null) {
            this.mdP.onDestroy();
        }
    }

    private void dsb() {
        Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.mdQ.iterator();
        while (it.hasNext()) {
            PbFirstFloorCommentAndPraiseViewHolder next = it.next();
            if (next != null && next.mdR != null) {
                next.mdR.onDestroy();
            }
        }
    }

    public void BL(String str) {
        if (this.mdQ.size() > 0) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.mdQ.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && next.mdR != null) {
                    next.mdR.BL(str);
                }
            }
        } else if (dsc() != null) {
            this.mdP.e(dsc().bpL());
        }
    }

    private String getPostId() {
        cb dsc = dsc();
        return dsc != null ? dsc.boi() : "";
    }

    private String getForumId() {
        return this.lSl.dmG() != null ? this.lSl.dmG().getForumId() : "";
    }

    private cb dsc() {
        if (this.lSl.dmG() == null || this.lSl.dmG().getPbData() == null) {
            return null;
        }
        return this.lSl.dmG().getPbData().dlp();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fjZ = onClickListener;
    }

    public void vS(boolean z) {
        this.lNR = z;
    }

    /* loaded from: classes2.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {
        public PbThreadCommentAndPraiseInfoLayout mdR;
        public View mdS;
        private int mdT;

        public PbFirstFloorCommentAndPraiseViewHolder(View view) {
            super(view);
            if (view != null) {
                this.mdR = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                e eVar = new e();
                eVar.eNB = 4;
                eVar.eNH = 7;
                eVar.eNC = this.mdT;
                eVar.eNF = PbFirstFloorCommentAndPraiseAdapter.aLy;
                this.mdR.setAgreeStatisticData(eVar);
                this.mdS = view.findViewById(R.id.bottom_divider_line);
                this.mdS.setVisibility(0);
            }
        }

        public void b(p pVar) {
            if (pVar != null && pVar.blp() != null) {
                cb blp = pVar.blp();
                if (blp.bpL() != null) {
                    blp.bpL().postId = blp.boi();
                }
                this.mdR.a(blp, pVar.getAnti());
                this.mdS.setVisibility(pVar.dmk() ? 0 : 8);
                if (blp.bmx() && blp.boj() != null) {
                    this.mdT = 2;
                } else {
                    this.mdT = 1;
                }
                if (pVar.lNQ) {
                    getView().setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
                this.mdR.showOperationMaskView(pVar.dml());
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            ap.setBackgroundColor(this.mdS, R.color.CAM_X0203);
            this.mdR.onChangeSkinType();
        }
    }
}

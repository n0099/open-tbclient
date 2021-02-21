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
    private boolean lLP;
    private c mbN;
    private final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> mbO;

    public PbFirstFloorCommentAndPraiseAdapter(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.mbO = new LinkedList<>();
        this.lLP = false;
        if (bVar != null && bVar.dmx() != null) {
            aJY = bVar.dmx().dpl();
        }
        this.mbN = new c(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cD */
    public PbFirstFloorCommentAndPraiseViewHolder e(ViewGroup viewGroup) {
        PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.mbO.add(pbFirstFloorCommentAndPraiseViewHolder);
        return pbFirstFloorCommentAndPraiseViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, p pVar, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) pVar, (p) pbFirstFloorCommentAndPraiseViewHolder);
        if (pVar != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
            pbFirstFloorCommentAndPraiseViewHolder.mbP.setOnClickOutListener(this.fiA);
            pbFirstFloorCommentAndPraiseViewHolder.mbP.setPostId(getPostId());
            pbFirstFloorCommentAndPraiseViewHolder.mbP.setForumId(getForumId());
            pVar.uI(this.lLP);
            pbFirstFloorCommentAndPraiseViewHolder.b(pVar);
        }
        return view;
    }

    public void onDestroy() {
        drS();
        if (this.mbN != null) {
            this.mbN.onDestroy();
        }
    }

    private void drS() {
        Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.mbO.iterator();
        while (it.hasNext()) {
            PbFirstFloorCommentAndPraiseViewHolder next = it.next();
            if (next != null && next.mbP != null) {
                next.mbP.onDestroy();
            }
        }
    }

    public void BE(String str) {
        if (this.mbO.size() > 0) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.mbO.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && next.mbP != null) {
                    next.mbP.BE(str);
                }
            }
        } else if (drT() != null) {
            this.mbN.e(drT().bpJ());
        }
    }

    private String getPostId() {
        cb drT = drT();
        return drT != null ? drT.bog() : "";
    }

    private String getForumId() {
        return this.lQj.dmx() != null ? this.lQj.dmx().getForumId() : "";
    }

    private cb drT() {
        if (this.lQj.dmx() == null || this.lQj.dmx().getPbData() == null) {
            return null;
        }
        return this.lQj.dmx().getPbData().dlg();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fiA = onClickListener;
    }

    public void vS(boolean z) {
        this.lLP = z;
    }

    /* loaded from: classes2.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {
        public PbThreadCommentAndPraiseInfoLayout mbP;
        public View mbQ;
        private int mbR;

        public PbFirstFloorCommentAndPraiseViewHolder(View view) {
            super(view);
            if (view != null) {
                this.mbP = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
                e eVar = new e();
                eVar.eMa = 4;
                eVar.eMg = 7;
                eVar.eMb = this.mbR;
                eVar.eMe = PbFirstFloorCommentAndPraiseAdapter.aJY;
                this.mbP.setAgreeStatisticData(eVar);
                this.mbQ = view.findViewById(R.id.bottom_divider_line);
                this.mbQ.setVisibility(0);
            }
        }

        public void b(p pVar) {
            if (pVar != null && pVar.bln() != null) {
                cb bln = pVar.bln();
                if (bln.bpJ() != null) {
                    bln.bpJ().postId = bln.bog();
                }
                this.mbP.a(bln, pVar.getAnti());
                this.mbQ.setVisibility(pVar.dmb() ? 0 : 8);
                if (bln.bmv() && bln.boh() != null) {
                    this.mbR = 2;
                } else {
                    this.mbR = 1;
                }
                if (pVar.lLO) {
                    getView().setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getView().getContext(), R.dimen.tbds32));
                }
                this.mbP.showOperationMaskView(pVar.dmc());
            }
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            ap.setBackgroundColor(this.mbQ, R.color.CAM_X0203);
            this.mbP.onChangeSkinType();
        }
    }
}

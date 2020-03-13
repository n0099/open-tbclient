package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ai extends l<com.baidu.tieba.pb.data.j, aj> {
    private View.OnClickListener aku;
    private com.baidu.tieba.pb.data.e iEU;
    private BdUniqueId iNq;
    private BdUniqueId iNr;
    private boolean iNs;

    public ai(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.iNs = false;
        this.iNq = BdUniqueId.gen();
        this.iNr = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bK */
    public aj b(ViewGroup viewGroup) {
        aj ajVar = new aj(this.iGs.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        ajVar.CF = false;
        ajVar.Q(this.aku);
        if (getType() == com.baidu.tieba.pb.data.j.iCP) {
            ajVar.j(this.iNq);
        } else if (getType() == com.baidu.tieba.pb.data.j.iCQ) {
            ajVar.s(this.iNr);
        }
        return ajVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, aj ajVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (com.baidu.tieba.pb.data.j) ajVar);
        if (ajVar != null) {
            cpa();
            ajVar.a(jVar);
        }
        return view;
    }

    private void cpa() {
        if (this.iEU != null && this.iEU.ckv() != null && this.iEU.cku() != null && this.iEU.iBS && !this.iNs) {
            this.iNs = true;
            boolean isLike = this.iEU.cku().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").cy("page_type", PageStayDurationConstants.PageName.PB).X("obj_isad", 1).X("obj_floor", 1).X("obj_adlocate", 9).cy("obj_id", this.iEU.cku().getForumId()).X("thread_type", this.iEU.ckv().getThreadType()).cy("tid", this.iEU.ckv().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").cy("page_type", PageStayDurationConstants.PageName.PB).X("obj_isad", 1).X("obj_floor", 1).X("obj_adlocate", 10).cy("obj_id", this.iEU.cku().getForumId()).X("thread_type", this.iEU.ckv().getThreadType()).cy("tid", this.iEU.ckv().getId()));
            }
        }
    }

    public void onDestroy() {
        this.iNs = false;
        MessageManager.getInstance().unRegisterListener(this.iNq);
        MessageManager.getInstance().unRegisterListener(this.iNr);
    }

    public void y(View.OnClickListener onClickListener) {
        this.aku = onClickListener;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.iEU = eVar;
    }
}

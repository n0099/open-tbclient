package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class al extends m<com.baidu.tieba.pb.data.k, am> {
    private View.OnClickListener ain;
    private com.baidu.tieba.pb.data.f iCZ;
    private BdUniqueId iLH;
    private BdUniqueId iLI;
    private boolean iLJ;

    public al(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.iLJ = false;
        this.iLH = BdUniqueId.gen();
        this.iLI = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bL */
    public am b(ViewGroup viewGroup) {
        am amVar = new am(this.iEA.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        amVar.Cm = false;
        amVar.Q(this.ain);
        if (getType() == com.baidu.tieba.pb.data.k.iAI) {
            amVar.j(this.iLH);
        } else if (getType() == com.baidu.tieba.pb.data.k.iAJ) {
            amVar.s(this.iLI);
        }
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.k kVar, am amVar) {
        super.a(i, view, viewGroup, (ViewGroup) kVar, (com.baidu.tieba.pb.data.k) amVar);
        if (amVar != null) {
            cnG();
            amVar.a(kVar);
        }
        return view;
    }

    private void cnG() {
        if (this.iCZ != null && this.iCZ.ciS() != null && this.iCZ.ciR() != null && this.iCZ.izM && !this.iLJ) {
            this.iLJ = true;
            boolean isLike = this.iCZ.ciR().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").cp("page_type", PageStayDurationConstants.PageName.PB).Z("obj_isad", 1).Z("obj_floor", 1).Z("obj_adlocate", 9).cp("obj_id", this.iCZ.ciR().getForumId()).Z("thread_type", this.iCZ.ciS().getThreadType()).cp("tid", this.iCZ.ciS().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").cp("page_type", PageStayDurationConstants.PageName.PB).Z("obj_isad", 1).Z("obj_floor", 1).Z("obj_adlocate", 10).cp("obj_id", this.iCZ.ciR().getForumId()).Z("thread_type", this.iCZ.ciS().getThreadType()).cp("tid", this.iCZ.ciS().getId()));
            }
        }
    }

    public void onDestroy() {
        this.iLJ = false;
        MessageManager.getInstance().unRegisterListener(this.iLH);
        MessageManager.getInstance().unRegisterListener(this.iLI);
    }

    public void x(View.OnClickListener onClickListener) {
        this.ain = onClickListener;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.iCZ = fVar;
    }
}

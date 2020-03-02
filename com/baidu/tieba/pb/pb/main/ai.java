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
    private View.OnClickListener akt;
    private com.baidu.tieba.pb.data.e iEI;
    private BdUniqueId iNe;
    private BdUniqueId iNf;
    private boolean iNg;

    public ai(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.iNg = false;
        this.iNe = BdUniqueId.gen();
        this.iNf = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bK */
    public aj b(ViewGroup viewGroup) {
        aj ajVar = new aj(this.iGg.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        ajVar.CF = false;
        ajVar.Q(this.akt);
        if (getType() == com.baidu.tieba.pb.data.j.iCD) {
            ajVar.j(this.iNe);
        } else if (getType() == com.baidu.tieba.pb.data.j.iCE) {
            ajVar.s(this.iNf);
        }
        return ajVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, aj ajVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (com.baidu.tieba.pb.data.j) ajVar);
        if (ajVar != null) {
            coZ();
            ajVar.a(jVar);
        }
        return view;
    }

    private void coZ() {
        if (this.iEI != null && this.iEI.cku() != null && this.iEI.ckt() != null && this.iEI.iBG && !this.iNg) {
            this.iNg = true;
            boolean isLike = this.iEI.ckt().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").cy("page_type", PageStayDurationConstants.PageName.PB).X("obj_isad", 1).X("obj_floor", 1).X("obj_adlocate", 9).cy("obj_id", this.iEI.ckt().getForumId()).X("thread_type", this.iEI.cku().getThreadType()).cy("tid", this.iEI.cku().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").cy("page_type", PageStayDurationConstants.PageName.PB).X("obj_isad", 1).X("obj_floor", 1).X("obj_adlocate", 10).cy("obj_id", this.iEI.ckt().getForumId()).X("thread_type", this.iEI.cku().getThreadType()).cy("tid", this.iEI.cku().getId()));
            }
        }
    }

    public void onDestroy() {
        this.iNg = false;
        MessageManager.getInstance().unRegisterListener(this.iNe);
        MessageManager.getInstance().unRegisterListener(this.iNf);
    }

    public void y(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        this.iEI = eVar;
    }
}

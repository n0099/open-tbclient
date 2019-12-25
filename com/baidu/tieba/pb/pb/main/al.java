package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class al extends m<com.baidu.tieba.pb.data.k, am> {
    private View.OnClickListener ahD;
    private BdUniqueId iId;
    private BdUniqueId iIe;
    private boolean iIf;
    private com.baidu.tieba.pb.data.f izv;

    public al(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.iIf = false;
        this.iId = BdUniqueId.gen();
        this.iIe = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public am b(ViewGroup viewGroup) {
        am amVar = new am(this.iAW.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        amVar.Ch = false;
        amVar.R(this.ahD);
        if (getType() == com.baidu.tieba.pb.data.k.ixe) {
            amVar.j(this.iId);
        } else if (getType() == com.baidu.tieba.pb.data.k.ixf) {
            amVar.s(this.iIe);
        }
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.k kVar, am amVar) {
        super.a(i, view, viewGroup, (ViewGroup) kVar, (com.baidu.tieba.pb.data.k) amVar);
        if (amVar != null) {
            cmz();
            amVar.a(kVar);
        }
        return view;
    }

    private void cmz() {
        if (this.izv != null && this.izv.chK() != null && this.izv.chJ() != null && this.izv.iwi && !this.iIf) {
            this.iIf = true;
            boolean isLike = this.izv.chJ().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").cp("page_type", PageStayDurationConstants.PageName.PB).Z("obj_isad", 1).Z("obj_floor", 1).Z("obj_adlocate", 9).cp("obj_id", this.izv.chJ().getForumId()).Z("thread_type", this.izv.chK().getThreadType()).cp("tid", this.izv.chK().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_exp").cp("page_type", PageStayDurationConstants.PageName.PB).Z("obj_isad", 1).Z("obj_floor", 1).Z("obj_adlocate", 10).cp("obj_id", this.izv.chJ().getForumId()).Z("thread_type", this.izv.chK().getThreadType()).cp("tid", this.izv.chK().getId()));
            }
        }
    }

    public void onDestroy() {
        this.iIf = false;
        MessageManager.getInstance().unRegisterListener(this.iId);
        MessageManager.getInstance().unRegisterListener(this.iIe);
    }

    public void y(View.OnClickListener onClickListener) {
        this.ahD = onClickListener;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.izv = fVar;
    }
}

package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.view.SortSwitchButton;
/* loaded from: classes22.dex */
public class at extends o<com.baidu.tieba.pb.data.n, au> {
    private View.OnClickListener aZX;
    private BdUniqueId lAp;
    private BdUniqueId lAq;
    private boolean lAr;
    private com.baidu.tieba.pb.data.f lqv;
    private SortSwitchButton.a luP;

    public at(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lAr = false;
        this.lAp = BdUniqueId.gen();
        this.lAq = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cq */
    public au c(ViewGroup viewGroup) {
        au auVar = new au(this.lsm.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        if (this.lpI != null) {
            auVar.v(this.lpI.ltL);
        }
        auVar.Yj = false;
        auVar.V(this.aZX);
        auVar.setOnSwitchChangeListener(this.luP);
        if (getType() == com.baidu.tieba.pb.data.n.lol) {
            auVar.l(this.lAp);
        } else if (getType() == com.baidu.tieba.pb.data.n.lom) {
            auVar.u(this.lAq);
        }
        return auVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.n nVar, au auVar) {
        super.a(i, view, viewGroup, (ViewGroup) nVar, (com.baidu.tieba.pb.data.n) auVar);
        if (auVar != null) {
            dnb();
            nVar.los = this.lqv.lmT;
            auVar.a(nVar);
        }
        return view;
    }

    private void dnb() {
        if (this.lqv != null && this.lqv.dik() != null && this.lqv.dij() != null && this.lqv.lmW && !this.lAr) {
            this.lAr = true;
            boolean isLike = this.lqv.dij().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dR("page_type", PageStayDurationConstants.PageName.PB).al("obj_isad", 1).al("obj_floor", 1).al("obj_adlocate", 9).dR("obj_id", this.lqv.dij().getForumId()).al("thread_type", this.lqv.dik().getThreadType()).dR("tid", this.lqv.dik().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dR("page_type", PageStayDurationConstants.PageName.PB).al("obj_isad", 1).al("obj_floor", 1).al("obj_adlocate", 10).dR("obj_id", this.lqv.dij().getForumId()).al("thread_type", this.lqv.dik().getThreadType()).dR("tid", this.lqv.dik().getId()));
            }
        }
    }

    public void onDestroy() {
        this.lAr = false;
        MessageManager.getInstance().unRegisterListener(this.lAp);
        MessageManager.getInstance().unRegisterListener(this.lAq);
    }

    public void B(View.OnClickListener onClickListener) {
        this.aZX = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.luP = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lqv = fVar;
    }
}

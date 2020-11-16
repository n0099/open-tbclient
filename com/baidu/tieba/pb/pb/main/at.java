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
/* loaded from: classes21.dex */
public class at extends o<com.baidu.tieba.pb.data.n, au> {
    private View.OnClickListener aYm;
    private BdUniqueId lAH;
    private BdUniqueId lAI;
    private boolean lAJ;
    private com.baidu.tieba.pb.data.f lqK;
    private SortSwitchButton.a lvf;

    public at(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lAJ = false;
        this.lAH = BdUniqueId.gen();
        this.lAI = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cm */
    public au c(ViewGroup viewGroup) {
        au auVar = new au(this.lsC.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        if (this.lpX != null) {
            auVar.v(this.lpX.lub);
        }
        auVar.Yo = false;
        auVar.U(this.aYm);
        auVar.setOnSwitchChangeListener(this.lvf);
        if (getType() == com.baidu.tieba.pb.data.n.loE) {
            auVar.l(this.lAH);
        } else if (getType() == com.baidu.tieba.pb.data.n.loF) {
            auVar.u(this.lAI);
        }
        return auVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.n nVar, au auVar) {
        super.a(i, view, viewGroup, (ViewGroup) nVar, (com.baidu.tieba.pb.data.n) auVar);
        if (auVar != null) {
            dmA();
            nVar.loK = this.lqK.lnk;
            auVar.a(nVar);
        }
        return view;
    }

    private void dmA() {
        if (this.lqK != null && this.lqK.dhH() != null && this.lqK.dhG() != null && this.lqK.lnn && !this.lAJ) {
            this.lAJ = true;
            boolean isLike = this.lqK.dhG().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_exp").dR("page_type", PageStayDurationConstants.PageName.PB).ak("obj_isad", 1).ak("obj_floor", 1).ak("obj_adlocate", 9).dR("obj_id", this.lqK.dhG().getForumId()).ak("thread_type", this.lqK.dhH().getThreadType()).dR("tid", this.lqK.dhH().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_exp").dR("page_type", PageStayDurationConstants.PageName.PB).ak("obj_isad", 1).ak("obj_floor", 1).ak("obj_adlocate", 10).dR("obj_id", this.lqK.dhG().getForumId()).ak("thread_type", this.lqK.dhH().getThreadType()).dR("tid", this.lqK.dhH().getId()));
            }
        }
    }

    public void onDestroy() {
        this.lAJ = false;
        MessageManager.getInstance().unRegisterListener(this.lAH);
        MessageManager.getInstance().unRegisterListener(this.lAI);
    }

    public void B(View.OnClickListener onClickListener) {
        this.aYm = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.lvf = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lqK = fVar;
    }
}

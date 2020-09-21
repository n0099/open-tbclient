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
    private View.OnClickListener aTZ;
    private com.baidu.tieba.pb.data.f kIK;
    private SortSwitchButton.a kNd;
    private BdUniqueId kSC;
    private BdUniqueId kSD;
    private boolean kSE;

    public at(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.kSE = false;
        this.kSC = BdUniqueId.gen();
        this.kSD = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cl */
    public au c(ViewGroup viewGroup) {
        au auVar = new au(this.kKB.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        if (this.kHX != null) {
            auVar.v(this.kHX.kLZ);
        }
        auVar.XR = false;
        auVar.U(this.aTZ);
        auVar.setOnSwitchChangeListener(this.kNd);
        if (getType() == com.baidu.tieba.pb.data.n.kGC) {
            auVar.l(this.kSC);
        } else if (getType() == com.baidu.tieba.pb.data.n.kGD) {
            auVar.u(this.kSD);
        }
        return auVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.n nVar, au auVar) {
        super.a(i, view, viewGroup, (ViewGroup) nVar, (com.baidu.tieba.pb.data.n) auVar);
        if (auVar != null) {
            ddJ();
            nVar.kGI = this.kIK.kFn;
            auVar.a(nVar);
        }
        return view;
    }

    private void ddJ() {
        if (this.kIK != null && this.kIK.cYR() != null && this.kIK.cYQ() != null && this.kIK.kFq && !this.kSE) {
            this.kSE = true;
            boolean isLike = this.kIK.cYQ().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dF("page_type", PageStayDurationConstants.PageName.PB).ai("obj_isad", 1).ai("obj_floor", 1).ai("obj_adlocate", 9).dF("obj_id", this.kIK.cYQ().getForumId()).ai("thread_type", this.kIK.cYR().getThreadType()).dF("tid", this.kIK.cYR().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dF("page_type", PageStayDurationConstants.PageName.PB).ai("obj_isad", 1).ai("obj_floor", 1).ai("obj_adlocate", 10).dF("obj_id", this.kIK.cYQ().getForumId()).ai("thread_type", this.kIK.cYR().getThreadType()).dF("tid", this.kIK.cYR().getId()));
            }
        }
    }

    public void onDestroy() {
        this.kSE = false;
        MessageManager.getInstance().unRegisterListener(this.kSC);
        MessageManager.getInstance().unRegisterListener(this.kSD);
    }

    public void A(View.OnClickListener onClickListener) {
        this.aTZ = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.kNd = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kIK = fVar;
    }
}

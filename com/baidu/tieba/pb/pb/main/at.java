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
    private View.OnClickListener aXk;
    private com.baidu.tieba.pb.data.f kXV;
    private SortSwitchButton.a lcp;
    private BdUniqueId lhP;
    private BdUniqueId lhQ;
    private boolean lhR;

    public at(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lhR = false;
        this.lhP = BdUniqueId.gen();
        this.lhQ = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cn */
    public au c(ViewGroup viewGroup) {
        au auVar = new au(this.kZM.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        if (this.kXi != null) {
            auVar.v(this.kXi.lbl);
        }
        auVar.Yi = false;
        auVar.U(this.aXk);
        auVar.setOnSwitchChangeListener(this.lcp);
        if (getType() == com.baidu.tieba.pb.data.n.kVN) {
            auVar.l(this.lhP);
        } else if (getType() == com.baidu.tieba.pb.data.n.kVO) {
            auVar.u(this.lhQ);
        }
        return auVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.n nVar, au auVar) {
        super.a(i, view, viewGroup, (ViewGroup) nVar, (com.baidu.tieba.pb.data.n) auVar);
        if (auVar != null) {
            dhs();
            nVar.kVT = this.kXV.kUy;
            auVar.a(nVar);
        }
        return view;
    }

    private void dhs() {
        if (this.kXV != null && this.kXV.dcA() != null && this.kXV.dcz() != null && this.kXV.kUB && !this.lhR) {
            this.lhR = true;
            boolean isLike = this.kXV.dcz().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dK("page_type", PageStayDurationConstants.PageName.PB).aj("obj_isad", 1).aj("obj_floor", 1).aj("obj_adlocate", 9).dK("obj_id", this.kXV.dcz().getForumId()).aj("thread_type", this.kXV.dcA().getThreadType()).dK("tid", this.kXV.dcA().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dK("page_type", PageStayDurationConstants.PageName.PB).aj("obj_isad", 1).aj("obj_floor", 1).aj("obj_adlocate", 10).dK("obj_id", this.kXV.dcz().getForumId()).aj("thread_type", this.kXV.dcA().getThreadType()).dK("tid", this.kXV.dcA().getId()));
            }
        }
    }

    public void onDestroy() {
        this.lhR = false;
        MessageManager.getInstance().unRegisterListener(this.lhP);
        MessageManager.getInstance().unRegisterListener(this.lhQ);
    }

    public void A(View.OnClickListener onClickListener) {
        this.aXk = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.lcp = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kXV = fVar;
    }
}

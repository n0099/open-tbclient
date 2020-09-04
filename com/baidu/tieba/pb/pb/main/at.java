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
/* loaded from: classes16.dex */
public class at extends o<com.baidu.tieba.pb.data.n, au> {
    private View.OnClickListener aRW;
    private com.baidu.tieba.pb.data.f kAn;
    private SortSwitchButton.a kEE;
    private BdUniqueId kKc;
    private BdUniqueId kKd;
    private boolean kKe;

    public at(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.kKe = false;
        this.kKc = BdUniqueId.gen();
        this.kKd = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ck */
    public au b(ViewGroup viewGroup) {
        au auVar = new au(this.kCd.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        if (this.kzA != null) {
            auVar.w(this.kzA.kDB);
        }
        auVar.Xz = false;
        auVar.U(this.aRW);
        auVar.setOnSwitchChangeListener(this.kEE);
        if (getType() == com.baidu.tieba.pb.data.n.kyf) {
            auVar.m(this.kKc);
        } else if (getType() == com.baidu.tieba.pb.data.n.kyg) {
            auVar.v(this.kKd);
        }
        return auVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.n nVar, au auVar) {
        super.a(i, view, viewGroup, (ViewGroup) nVar, (com.baidu.tieba.pb.data.n) auVar);
        if (auVar != null) {
            dag();
            nVar.kyl = this.kAn.kwO;
            auVar.a(nVar);
        }
        return view;
    }

    private void dag() {
        if (this.kAn != null && this.kAn.cVm() != null && this.kAn.cVl() != null && this.kAn.kwR && !this.kKe) {
            this.kKe = true;
            boolean isLike = this.kAn.cVl().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dD("page_type", PageStayDurationConstants.PageName.PB).ai("obj_isad", 1).ai("obj_floor", 1).ai("obj_adlocate", 9).dD("obj_id", this.kAn.cVl().getForumId()).ai("thread_type", this.kAn.cVm().getThreadType()).dD("tid", this.kAn.cVm().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dD("page_type", PageStayDurationConstants.PageName.PB).ai("obj_isad", 1).ai("obj_floor", 1).ai("obj_adlocate", 10).dD("obj_id", this.kAn.cVl().getForumId()).ai("thread_type", this.kAn.cVm().getThreadType()).dD("tid", this.kAn.cVm().getId()));
            }
        }
    }

    public void onDestroy() {
        this.kKe = false;
        MessageManager.getInstance().unRegisterListener(this.kKc);
        MessageManager.getInstance().unRegisterListener(this.kKd);
    }

    public void A(View.OnClickListener onClickListener) {
        this.aRW = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.kEE = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kAn = fVar;
    }
}

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
    private View.OnClickListener aRU;
    private com.baidu.tieba.pb.data.f kAg;
    private SortSwitchButton.a kEx;
    private BdUniqueId kJV;
    private BdUniqueId kJW;
    private boolean kJX;

    public at(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.kJX = false;
        this.kJV = BdUniqueId.gen();
        this.kJW = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ck */
    public au b(ViewGroup viewGroup) {
        au auVar = new au(this.kBW.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        if (this.kzt != null) {
            auVar.w(this.kzt.kDu);
        }
        auVar.Xx = false;
        auVar.U(this.aRU);
        auVar.setOnSwitchChangeListener(this.kEx);
        if (getType() == com.baidu.tieba.pb.data.n.kxY) {
            auVar.m(this.kJV);
        } else if (getType() == com.baidu.tieba.pb.data.n.kxZ) {
            auVar.v(this.kJW);
        }
        return auVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.n nVar, au auVar) {
        super.a(i, view, viewGroup, (ViewGroup) nVar, (com.baidu.tieba.pb.data.n) auVar);
        if (auVar != null) {
            daf();
            nVar.kye = this.kAg.kwH;
            auVar.a(nVar);
        }
        return view;
    }

    private void daf() {
        if (this.kAg != null && this.kAg.cVl() != null && this.kAg.cVk() != null && this.kAg.kwK && !this.kJX) {
            this.kJX = true;
            boolean isLike = this.kAg.cVk().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dD("page_type", PageStayDurationConstants.PageName.PB).ai("obj_isad", 1).ai("obj_floor", 1).ai("obj_adlocate", 9).dD("obj_id", this.kAg.cVk().getForumId()).ai("thread_type", this.kAg.cVl().getThreadType()).dD("tid", this.kAg.cVl().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dD("page_type", PageStayDurationConstants.PageName.PB).ai("obj_isad", 1).ai("obj_floor", 1).ai("obj_adlocate", 10).dD("obj_id", this.kAg.cVk().getForumId()).ai("thread_type", this.kAg.cVl().getThreadType()).dD("tid", this.kAg.cVl().getId()));
            }
        }
    }

    public void onDestroy() {
        this.kJX = false;
        MessageManager.getInstance().unRegisterListener(this.kJV);
        MessageManager.getInstance().unRegisterListener(this.kJW);
    }

    public void A(View.OnClickListener onClickListener) {
        this.aRU = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.kEx = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kAg = fVar;
    }
}

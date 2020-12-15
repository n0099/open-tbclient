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
    private View.OnClickListener bbH;
    private com.baidu.tieba.pb.data.f lEv;
    private SortSwitchButton.a lIU;
    private BdUniqueId lOw;
    private BdUniqueId lOx;
    private boolean lOy;

    public at(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lOy = false;
        this.lOw = BdUniqueId.gen();
        this.lOx = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cp */
    public au c(ViewGroup viewGroup) {
        au auVar = new au(this.lGq.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        if (this.lDI != null) {
            auVar.v(this.lDI.lHP);
        }
        auVar.Zl = false;
        auVar.U(this.bbH);
        auVar.setOnSwitchChangeListener(this.lIU);
        if (getType() == com.baidu.tieba.pb.data.n.lCc) {
            auVar.l(this.lOw);
        } else if (getType() == com.baidu.tieba.pb.data.n.lCd) {
            auVar.u(this.lOx);
        }
        return auVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.n nVar, au auVar) {
        super.a(i, view, viewGroup, (ViewGroup) nVar, (com.baidu.tieba.pb.data.n) auVar);
        if (auVar != null) {
            drS();
            nVar.lCi = this.lEv.lAL;
            auVar.a(nVar);
        }
        return view;
    }

    private void drS() {
        if (this.lEv != null && this.lEv.dmU() != null && this.lEv.dmT() != null && this.lEv.lAO && !this.lOy) {
            this.lOy = true;
            boolean isLike = this.lEv.dmT().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_exp").dY("page_type", PageStayDurationConstants.PageName.PB).al("obj_isad", 1).al("obj_floor", 1).al("obj_adlocate", 9).dY("obj_id", this.lEv.dmT().getForumId()).al("thread_type", this.lEv.dmU().getThreadType()).dY("tid", this.lEv.dmU().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_exp").dY("page_type", PageStayDurationConstants.PageName.PB).al("obj_isad", 1).al("obj_floor", 1).al("obj_adlocate", 10).dY("obj_id", this.lEv.dmT().getForumId()).al("thread_type", this.lEv.dmU().getThreadType()).dY("tid", this.lEv.dmU().getId()));
            }
        }
    }

    public void onDestroy() {
        this.lOy = false;
        MessageManager.getInstance().unRegisterListener(this.lOw);
        MessageManager.getInstance().unRegisterListener(this.lOx);
    }

    public void B(View.OnClickListener onClickListener) {
        this.bbH = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.lIU = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lEv = fVar;
    }
}

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
    private com.baidu.tieba.pb.data.f lEt;
    private SortSwitchButton.a lIS;
    private BdUniqueId lOu;
    private BdUniqueId lOv;
    private boolean lOw;

    public at(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.lOw = false;
        this.lOu = BdUniqueId.gen();
        this.lOv = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cp */
    public au c(ViewGroup viewGroup) {
        au auVar = new au(this.lGo.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        if (this.lDG != null) {
            auVar.v(this.lDG.lHN);
        }
        auVar.Zl = false;
        auVar.U(this.bbH);
        auVar.setOnSwitchChangeListener(this.lIS);
        if (getType() == com.baidu.tieba.pb.data.n.lCa) {
            auVar.l(this.lOu);
        } else if (getType() == com.baidu.tieba.pb.data.n.lCb) {
            auVar.u(this.lOv);
        }
        return auVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.n nVar, au auVar) {
        super.a(i, view, viewGroup, (ViewGroup) nVar, (com.baidu.tieba.pb.data.n) auVar);
        if (auVar != null) {
            drR();
            nVar.lCg = this.lEt.lAJ;
            auVar.a(nVar);
        }
        return view;
    }

    private void drR() {
        if (this.lEt != null && this.lEt.dmT() != null && this.lEt.dmS() != null && this.lEt.lAM && !this.lOw) {
            this.lOw = true;
            boolean isLike = this.lEt.dmS().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_exp").dY("page_type", PageStayDurationConstants.PageName.PB).al("obj_isad", 1).al("obj_floor", 1).al("obj_adlocate", 9).dY("obj_id", this.lEt.dmS().getForumId()).al("thread_type", this.lEt.dmT().getThreadType()).dY("tid", this.lEt.dmT().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_exp").dY("page_type", PageStayDurationConstants.PageName.PB).al("obj_isad", 1).al("obj_floor", 1).al("obj_adlocate", 10).dY("obj_id", this.lEt.dmS().getForumId()).al("thread_type", this.lEt.dmT().getThreadType()).dY("tid", this.lEt.dmT().getId()));
            }
        }
    }

    public void onDestroy() {
        this.lOw = false;
        MessageManager.getInstance().unRegisterListener(this.lOu);
        MessageManager.getInstance().unRegisterListener(this.lOv);
    }

    public void B(View.OnClickListener onClickListener) {
        this.bbH = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.lIS = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lEt = fVar;
    }
}

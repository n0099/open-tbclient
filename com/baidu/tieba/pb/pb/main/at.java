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
    private View.OnClickListener aYF;
    private com.baidu.tieba.pb.data.f lku;
    private SortSwitchButton.a loS;
    private BdUniqueId lus;
    private BdUniqueId lut;
    private boolean luu;

    public at(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.luu = false;
        this.lus = BdUniqueId.gen();
        this.lut = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: co */
    public au c(ViewGroup viewGroup) {
        au auVar = new au(this.lml.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        if (this.ljH != null) {
            auVar.v(this.ljH.lnK);
        }
        auVar.Yj = false;
        auVar.U(this.aYF);
        auVar.setOnSwitchChangeListener(this.loS);
        if (getType() == com.baidu.tieba.pb.data.n.lim) {
            auVar.l(this.lus);
        } else if (getType() == com.baidu.tieba.pb.data.n.lin) {
            auVar.u(this.lut);
        }
        return auVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.n nVar, au auVar) {
        super.a(i, view, viewGroup, (ViewGroup) nVar, (com.baidu.tieba.pb.data.n) auVar);
        if (auVar != null) {
            dkz();
            nVar.lis = this.lku.lgX;
            auVar.a(nVar);
        }
        return view;
    }

    private void dkz() {
        if (this.lku != null && this.lku.dfI() != null && this.lku.dfH() != null && this.lku.lha && !this.luu) {
            this.luu = true;
            boolean isLike = this.lku.dfH().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dR("page_type", PageStayDurationConstants.PageName.PB).aj("obj_isad", 1).aj("obj_floor", 1).aj("obj_adlocate", 9).dR("obj_id", this.lku.dfH().getForumId()).aj("thread_type", this.lku.dfI().getThreadType()).dR("tid", this.lku.dfI().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_exp").dR("page_type", PageStayDurationConstants.PageName.PB).aj("obj_isad", 1).aj("obj_floor", 1).aj("obj_adlocate", 10).dR("obj_id", this.lku.dfH().getForumId()).aj("thread_type", this.lku.dfI().getThreadType()).dR("tid", this.lku.dfI().getId()));
            }
        }
    }

    public void onDestroy() {
        this.luu = false;
        MessageManager.getInstance().unRegisterListener(this.lus);
        MessageManager.getInstance().unRegisterListener(this.lut);
    }

    public void A(View.OnClickListener onClickListener) {
        this.aYF = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.loS = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lku = fVar;
    }
}

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
    private View.OnClickListener aMH;
    private com.baidu.tieba.pb.data.f kkO;
    private SortSwitchButton.a kpg;
    private BdUniqueId kuq;
    private BdUniqueId kur;
    private boolean kus;

    public at(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.kus = false;
        this.kuq = BdUniqueId.gen();
        this.kur = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: co */
    public au b(ViewGroup viewGroup) {
        au auVar = new au(this.kmE.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        if (this.kkb != null) {
            auVar.w(this.kkb.koc);
        }
        auVar.WR = false;
        auVar.T(this.aMH);
        auVar.setOnSwitchChangeListener(this.kpg);
        if (getType() == com.baidu.tieba.pb.data.n.kiG) {
            auVar.m(this.kuq);
        } else if (getType() == com.baidu.tieba.pb.data.n.kiH) {
            auVar.v(this.kur);
        }
        return auVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.n nVar, au auVar) {
        super.a(i, view, viewGroup, (ViewGroup) nVar, (com.baidu.tieba.pb.data.n) auVar);
        if (auVar != null) {
            cPp();
            nVar.kiM = this.kkO.kho;
            auVar.a(nVar);
        }
        return view;
    }

    private void cPp() {
        if (this.kkO != null && this.kkO.cKx() != null && this.kkO.cKw() != null && this.kkO.khr && !this.kus) {
            this.kus = true;
            boolean isLike = this.kkO.cKw().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("common_exp").dn("page_type", PageStayDurationConstants.PageName.PB).ah("obj_isad", 1).ah("obj_floor", 1).ah("obj_adlocate", 9).dn("obj_id", this.kkO.cKw().getForumId()).ah("thread_type", this.kkO.cKx().getThreadType()).dn("tid", this.kkO.cKx().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("common_exp").dn("page_type", PageStayDurationConstants.PageName.PB).ah("obj_isad", 1).ah("obj_floor", 1).ah("obj_adlocate", 10).dn("obj_id", this.kkO.cKw().getForumId()).ah("thread_type", this.kkO.cKx().getThreadType()).dn("tid", this.kkO.cKx().getId()));
            }
        }
    }

    public void onDestroy() {
        this.kus = false;
        MessageManager.getInstance().unRegisterListener(this.kuq);
        MessageManager.getInstance().unRegisterListener(this.kur);
    }

    public void z(View.OnClickListener onClickListener) {
        this.aMH = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.kpg = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kkO = fVar;
    }
}

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
    private com.baidu.tieba.pb.data.f kkM;
    private SortSwitchButton.a kpe;
    private BdUniqueId kuo;
    private BdUniqueId kup;
    private boolean kuq;

    public at(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.kuq = false;
        this.kuo = BdUniqueId.gen();
        this.kup = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: co */
    public au b(ViewGroup viewGroup) {
        au auVar = new au(this.kmC.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        if (this.kjZ != null) {
            auVar.w(this.kjZ.koa);
        }
        auVar.WR = false;
        auVar.T(this.aMH);
        auVar.setOnSwitchChangeListener(this.kpe);
        if (getType() == com.baidu.tieba.pb.data.n.kiE) {
            auVar.m(this.kuo);
        } else if (getType() == com.baidu.tieba.pb.data.n.kiF) {
            auVar.v(this.kup);
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
            nVar.kiK = this.kkM.khm;
            auVar.a(nVar);
        }
        return view;
    }

    private void cPp() {
        if (this.kkM != null && this.kkM.cKx() != null && this.kkM.cKw() != null && this.kkM.khp && !this.kuq) {
            this.kuq = true;
            boolean isLike = this.kkM.cKw().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("common_exp").dn("page_type", PageStayDurationConstants.PageName.PB).ah("obj_isad", 1).ah("obj_floor", 1).ah("obj_adlocate", 9).dn("obj_id", this.kkM.cKw().getForumId()).ah("thread_type", this.kkM.cKx().getThreadType()).dn("tid", this.kkM.cKx().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("common_exp").dn("page_type", PageStayDurationConstants.PageName.PB).ah("obj_isad", 1).ah("obj_floor", 1).ah("obj_adlocate", 10).dn("obj_id", this.kkM.cKw().getForumId()).ah("thread_type", this.kkM.cKx().getThreadType()).dn("tid", this.kkM.cKx().getId()));
            }
        }
    }

    public void onDestroy() {
        this.kuq = false;
        MessageManager.getInstance().unRegisterListener(this.kuo);
        MessageManager.getInstance().unRegisterListener(this.kup);
    }

    public void z(View.OnClickListener onClickListener) {
        this.aMH = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.kpe = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kkM = fVar;
    }
}

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
/* loaded from: classes2.dex */
public class ak extends l<com.baidu.tieba.pb.data.o, PbReplyTitleViewHolder> {
    private View.OnClickListener bdi;
    private com.baidu.tieba.pb.data.f lQk;
    private SortSwitchButton.a lUS;
    private BdUniqueId mat;
    private BdUniqueId mau;
    private boolean mav;

    public ak(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.mav = false;
        this.mat = BdUniqueId.gen();
        this.mau = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cA */
    public PbReplyTitleViewHolder e(ViewGroup viewGroup) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.lSl.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        if (this.lPo != null) {
            pbReplyTitleViewHolder.x(this.lPo.lTN);
        }
        pbReplyTitleViewHolder.abh = false;
        pbReplyTitleViewHolder.X(this.bdi);
        pbReplyTitleViewHolder.setOnSwitchChangeListener(this.lUS);
        if (getType() == com.baidu.tieba.pb.data.o.lNH) {
            pbReplyTitleViewHolder.l(this.mat);
        } else if (getType() == com.baidu.tieba.pb.data.o.lNI) {
            pbReplyTitleViewHolder.w(this.mau);
        }
        return pbReplyTitleViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.o oVar, PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.pb.data.o) pbReplyTitleViewHolder);
        if (pbReplyTitleViewHolder != null) {
            dqr();
            oVar.lNN = this.lQk.lMo;
            pbReplyTitleViewHolder.a(oVar);
        }
        return view;
    }

    private void dqr() {
        if (this.lQk != null && this.lQk.dlp() != null && this.lQk.dlo() != null && this.lQk.lMr && !this.mav) {
            this.mav = true;
            boolean isLike = this.lQk.dlo().getIsLike();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_exp").dR("page_type", PageStayDurationConstants.PageName.PB).aq("obj_isad", 1).aq("obj_floor", 1).aq("obj_adlocate", 9).dR("obj_id", this.lQk.dlo().getForumId()).aq("thread_type", this.lQk.dlp().getThreadType()).dR("tid", this.lQk.dlp().getId()));
            if (!isLike) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_exp").dR("page_type", PageStayDurationConstants.PageName.PB).aq("obj_isad", 1).aq("obj_floor", 1).aq("obj_adlocate", 10).dR("obj_id", this.lQk.dlo().getForumId()).aq("thread_type", this.lQk.dlp().getThreadType()).dR("tid", this.lQk.dlp().getId()));
            }
        }
    }

    public void onDestroy() {
        this.mav = false;
        MessageManager.getInstance().unRegisterListener(this.mat);
        MessageManager.getInstance().unRegisterListener(this.mau);
    }

    public void C(View.OnClickListener onClickListener) {
        this.bdi = onClickListener;
    }

    public void a(SortSwitchButton.a aVar) {
        this.lUS = aVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lQk = fVar;
    }
}
